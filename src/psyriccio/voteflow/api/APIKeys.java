/////////////////////////////////////////////////////////////////////////////////////////////
//
// API-keys requested for VoteFlow software,
// please do not use this keys in other software/sites
// You may request another keys, for free at http://api.duma.gov.ru/key-request
//
/////////////////////////////////////////////////////////////////////////////////////////////
//
// API-ключи, запрошенные для проекта VoteFlow,
// пожалуйста, не используйте эти ключи в других проектах.
// Вы можете бесплатно запросить другие ключи по ссылке http://api.duma.gov.ru/key-request
//
/////////////////////////////////////////////////////////////////////////////////////////////
package psyriccio.voteflow.api;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 *
 * @author psyriccio
 */
public class APIKeys {

    private static final String API_KEY
            = "TWpSbFlUY3lORFV4WkdGa01ESmhOV00zTjJReE56bGxPV0V4TmpZeVlUWmlZek5rTnpSaU1BPT0";
    private static final String APP_KEY
            = "WVhCd016QTBaV1U1WkRNMlpUTmhaVEEzWkRFNU16ZGpZbVJsWXpWbE1HVXpNalZsWm1JMk5tTm1Zdz09";

    public static String getAPIKey() {
        try {
            return new String(
                    Base64.getDecoder().decode(
                            Base64.getDecoder().decode(
                                    API_KEY.getBytes("UTF-8")
                            )
                    )
            );
        } catch (UnsupportedEncodingException ex) {
            return "";
        }
    }

    public static String getAPPKey() {
        try {
            return new String(
                    Base64.getDecoder().decode(
                            Base64.getDecoder().decode(
                                    APP_KEY.getBytes("UTF-8")
                            )
                    )
            );
        } catch (UnsupportedEncodingException ex) {
            return "";
        }
    }

}
