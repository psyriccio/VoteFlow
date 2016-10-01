package psyriccio.voteflow;

import ch.qos.logback.classic.Logger;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import org.slf4j.LoggerFactory;
import psyriccio.voteflow.api.LawAPI;

public class Main {

    public static final Logger log = (Logger) LoggerFactory.getLogger("~");

    private static void dumpResult(String res, String fileName) {
        try {
            log.info("Result = {}", res);
            Files.write(res.getBytes("UTF-8"), new File(fileName));
        } catch (IOException ex) {
            log.error("Exception: {}", ex);
        }
    }

    public static void main(String[] args) {
        log.info("VoteFlow");
        log.info("Testing api");
        LawAPI api = new LawAPI();
        log.info("getTopics()");
        api.getTopics().getTopic()
                .forEach(
                        (topic)
                        -> log.info(
                                "{} - {}",
                                topic.getId().toString(),
                                topic.getName()
                        )
                );
        api.finish();
    }

}
