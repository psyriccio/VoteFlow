/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psyriccio.voteflow.api;

import com.google.common.escape.Escaper;
import com.google.common.html.HtmlEscapers;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpRequestException;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpStatus;
import psyriccio.voteflow.Main;
import psyriccio.voteflow.api.jaxb.JAXBContextDescriptor;

/**
 *
 * @author psyriccio
 */
public class LawAPI {

    public final static String BASE_URI = "http://api.duma.gov.ru/api/";
    public final static Escaper HTML_ESC = HtmlEscapers.htmlEscaper();

    private final HttpClient httpClient;
    private final Map<String, String> jaxbProperties;
    private final Map<String, JAXBContextDescriptor> jaxb;

    private String[] objNames = new String[]{
        "topics",
        "classes",
        "deputies",
        "federalorgans",
        "periods",
        "stages",
        "votes"
    };

    private void initJAXB() {
        for (String name : objNames) {
            try {
                JAXBContextDescriptor descr = new JAXBContextDescriptor("psyriccio.voteflow.api.jaxb." + name + ".impl");
                if (descr != null) {
                    jaxb.put(name, descr);
                }
            } catch (Exception ex) {
                Main.log.error("Exception: {}", ex);
            }
        }
    }

    public LawAPI() {
        jaxbProperties = new HashMap<>();
        this.jaxb = new ConcurrentHashMap<>();
        httpClient = new HttpClient();
    }

    public void init() {
        initJAXB();
        httpClient.setUserAgentField(new HttpField("User-Agent", "VoteFlow//TESTING"));
        httpClient.setFollowRedirects(true);
        try {
            httpClient.start();
        } catch (Exception ex) {
            Main.log.error("Exception: {}", ex);
        }
    }

    protected String rawRequest(String url, Map<String, String> params) throws InterruptedException, ExecutionException, TimeoutException, UnsupportedEncodingException {
        Request req = httpClient.newRequest(new String(url.getBytes("UTF-8"), "UTF-8"))
                .header(HttpHeader.CONTENT_ENCODING, "UTF-8")
                .method(HttpMethod.GET)
                .header(HttpHeader.ACCEPT_ENCODING, "UTF-8");
        req = req.param("app_token", APIKeys.getAPPKey());
        if (params != null) {
            for (String key : params.keySet()) {
                req = req.param(key, params.get(key));
            }
        }
        Main.log.info("GET {}, {}, {}", req, req.getQuery(), req.getParams());
        ContentResponse resp = req.send();
        if (resp.getStatus() != HttpStatus.OK_200) {
            throw new HttpRequestException(
                    "Request ended with non-OK status: "
                    + HttpStatus.getMessage(resp.getStatus()),
                    resp.getRequest()
            );
        }
        return resp.getContentAsString();
    }

    protected String requestSpec(String request, String format, Map<String, String> params) {

        String url = BASE_URI + APIKeys.getAPIKey() + "/" + request + "." + format;// + "?app_token=" + APIKeys.getAPPKey();
//        if (params != null) {
//            for (String key : params.keySet()) {
//                String val = params.get(key);
//                url += "&" + key + "=" + val;
//            }
//        }

        try {
            Main.log.info("'" + url + "'");
            return rawRequest(url, params);
        } catch (InterruptedException | ExecutionException | TimeoutException | UnsupportedEncodingException ex) {
            Main.log.error("Exception: {}", ex);
            throw new RuntimeException(ex.getMessage());
        }

    }

    protected Map<String, String> getParams(Object obj) {
        Map<String, String> params = new HashMap<>();
        final Function<Date, String> formatDate = (Date t) -> {
            return DateFormatUtils.format(t, "yyyy-MM-dd");
        };

        if (obj == null) {
            return params;
        }
        for (Method method : obj.getClass().getMethods()) {
            if (method.getParameterCount() == 0) {
                if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
                    String name = method.getName().replaceAll("get", "").replaceAll("is", "").toLowerCase();
                    if (name.equals("class")) {
                        continue;
                    }
                    try {
                        Object objVal = method.invoke(obj);
                        if (objVal != null) {
                            String value = "";
                            if (objVal instanceof Boolean) {
                                value = ((Boolean) objVal) ? "1" : "0";
                            } else if (objVal instanceof Date) {
                                value = formatDate.apply((Date) objVal);
                            } else {
                                value = objVal.toString();
                            }
                            params.put(name, value);
                        }
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                        Main.log.error("Exception: {}", ex);
                    }
                }
            }
        }
        return params;
    }

    public void finish() {
        try {
            httpClient.stop();
        } catch (Exception ex) {
            Main.log.error("Exception: {}", ex);
        }
    }

    public Date date(String dateStr) {
        try {
            return DateFormatUtils.ISO_DATE_FORMAT.parse(dateStr);
        } catch (ParseException ex) {
            return null;
        }
    }

    public psyriccio.voteflow.api.jaxb.topics.Result getTopics() {
        return (psyriccio.voteflow.api.jaxb.topics.Result) jaxb.get("topics")
                .unmarshall(requestSpec("topics", "xml", null));
    }

    public psyriccio.voteflow.api.jaxb.classes.Result getClasses() {
        return (psyriccio.voteflow.api.jaxb.classes.Result) jaxb.get("classes")
                .unmarshall(requestSpec("classes", "xml", null));
    }

    public psyriccio.voteflow.api.jaxb.deputies.Result getDeputies(DeputiesRequest req) {
        return (psyriccio.voteflow.api.jaxb.deputies.Result) jaxb.get("deputies")
                .unmarshall(requestSpec("deputies", "xml", getParams(req)));
    }

    public psyriccio.voteflow.api.jaxb.stages.Result getStages() {
        return (psyriccio.voteflow.api.jaxb.stages.Result) jaxb.get("stages")
                .unmarshall(requestSpec("stages", "xml", null));
    }

    public psyriccio.voteflow.api.jaxb.votes.Result searchVotes(VoteSearchRequest req) {
        return (psyriccio.voteflow.api.jaxb.votes.Result) jaxb.get("votes")
                .unmarshall(requestSpec("voteSearch", "xml", getParams(req)));
    }

    public psyriccio.voteflow.api.jaxb.periods.Result getPeriods() {
        return (psyriccio.voteflow.api.jaxb.periods.Result) jaxb.get("periods")
                .unmarshall(requestSpec("periods", "xml", null));
    }

    public psyriccio.voteflow.api.jaxb.federalorgans.Result getFederalOrgans(FederalOrgansRequest req) {
        return (psyriccio.voteflow.api.jaxb.federalorgans.Result) jaxb.get("federalorgans")
                .unmarshall(requestSpec("periods", "xml", null));
    }

}
