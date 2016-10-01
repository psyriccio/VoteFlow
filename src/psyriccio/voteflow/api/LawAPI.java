/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psyriccio.voteflow.api;

import com.google.common.escape.Escaper;
import com.google.common.html.HtmlEscapers;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpRequestException;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import psyriccio.voteflow.Main;

/**
 *
 * @author psyriccio
 */
public class LawAPI {

    public final static String BASE_URI = "http://api.duma.gov.ru/api/";
    public final static Escaper HTML_ESC = HtmlEscapers.htmlEscaper();

    private final HttpClient httpClient;
    private final Map<String, String> jaxbProperties;

    public LawAPI() {
        jaxbProperties = new HashMap<>();
        httpClient = new HttpClient();
        try {
            httpClient.start();
        } catch (Exception ex) {
            Main.log.error("Exception: {}", ex);
        }
    }

    protected String rawRequest(String url) throws InterruptedException, ExecutionException, TimeoutException {
        ContentResponse resp = httpClient.GET(url);
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

        String url = BASE_URI + APIKeys.getAPIKey() + "/" + request + "." + format + "?app_token=" + APIKeys.getAPPKey();
        if (params != null) {
            params.forEach((key, val) -> url.concat("&" + key + "=" + val));
        }

        try {
            Main.log.debug("'" + url + "'");
            return rawRequest(url);
        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
            Main.log.error("Exception: {}", ex);
            throw new RuntimeException(ex.getMessage());
        }

    }

    public void finish() {
        try {
            httpClient.stop();
        } catch (Exception ex) {
            Main.log.error("Exception: {}", ex);
        }
    }

    public psyriccio.voteflow.api.jaxb.topics.Result getTopics() {
        try {
            JAXBContext jaxb = (JAXBContext) JAXBContextFactory.createContext(
                    new Class[]{
                        psyriccio.voteflow.api.jaxb.topics.Result.class,
                        psyriccio.voteflow.api.jaxb.topics.Topic.class
                    },
                    jaxbProperties);
            Unmarshaller unmarsh = jaxb.createUnmarshaller();
            return (psyriccio.voteflow.api.jaxb.topics.Result) unmarsh.unmarshal(
                    new StringReader(
                            requestSpec("topics", "xml", null)
                    )
            );
        } catch (JAXBException ex) {
            Main.log.error("Exception: {}", ex);
        }
        return null;
    }

}
