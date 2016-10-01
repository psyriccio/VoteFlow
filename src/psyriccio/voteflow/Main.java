package psyriccio.voteflow;

import ch.qos.logback.classic.Logger;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.LoggerFactory;
import psyriccio.voteflow.api.DeputiesRequest;
import psyriccio.voteflow.api.LawAPI;
import psyriccio.voteflow.api.VoteSearchRequest;

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
        api.getClasses().getClazz()
                .forEach(
                        (clazz)
                        -> log.info(
                                "{} - {}",
                                clazz.getId(),
                                clazz.getName()
                        )
                );
        api.getDeputies(
                DeputiesRequest.builder()
                .current(true)
                .build()
        ).getDeputy().forEach((dep) -> {
            log.info("{}, {}, {}, {}, {}",
                    dep.getId(),
                    dep.getName(),
                    dep.getPosition(),
                    dep.getFaction().stream()
                    .map((fr) -> fr.getId() + ":" + fr.getName() + "; ")
                    .reduce("", String::concat),
                    dep.isIsCurrent()
            );
        });

        api.getStages().getStage().forEach((stg) -> {
            log.info("{}, {}, {}",
                    stg.getId(),
                    stg.getName(),
                    stg.getPhase().stream()
                    .filter((ph) -> ph != null)
                    .map((ph) -> ph.getId() + ":" + ph.getName() + ":"
                            + (ph.getInstance() != null ? ph.getInstance().getName() : "") + "; ")
                    .reduce("", String::concat)
            );
        });

        api.searchVotes(
                VoteSearchRequest.builder()
                .from(api.date("2015-01-01"))
                .to(api.date("2016-10-01"))
                .build()
        ).getContent().forEach((vote) -> {
            try {
                psyriccio.voteflow.api.jaxb.votes.Vote vt = (psyriccio.voteflow.api.jaxb.votes.Vote) vote;
                log.info(
                        "{}, {}, {}, {}, {}",
                        vt.getId(),
                        vt.getSubject(),
                        vt.getResult(),
                        vt.getResultType(),
                        vt.getVoteDate()
                );
            } catch (Exception ex) {
                log.info(vote.toString());
            }
        });

        api.finish();
    }

}
