package psyriccio.voteflow;

import ch.qos.logback.classic.Logger;
import com.alee.laf.WebLookAndFeel;
import com.google.common.io.Files;
import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import org.slf4j.LoggerFactory;
import psyriccio.voteflow.api.DeputiesRequest;
import psyriccio.voteflow.api.LawAPI;
import psyriccio.voteflow.api.VoteSearchRequest;
import psyriccio.voteflow.ui.MainForm;

public class Main {

    static {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Main.class.getResourceAsStream("/fonts/FiraCode-Regular.ttf")));
        } catch (IOException|FontFormatException e) {
        }
    }

    public final static Font firaCodeFont = new Font("Fira Code", Font.PLAIN, 8);

    public static final Logger log = (Logger) LoggerFactory.getLogger("~");
    public static final LawAPI API = new LawAPI();

    private static void dumpResult(String res, String fileName) {
        try {
            log.info("Result = {}", res);
            Files.write(res.getBytes("UTF-8"), new File(fileName));
        } catch (IOException ex) {
            log.error("Exception: {}", ex);
        }
    }

    public static void doSimpleDevTest(LawAPI api) {
        log.info("getTopics()");
        api.getTopics().getTopics()
                .forEach(
                        (topic)
                        -> log.info(
                                "{} - {}",
                                topic.getId().toString(),
                                topic.getName()
                        )
                );
        api.getClasses().getClazzs()
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
        ).getDeputies().forEach((dep) -> {
            log.info("{}, {}, {}, {}, {}",
                    dep.getId(),
                    dep.getName(),
                    dep.getPosition(),
                    dep.getFactions().stream()
                    .map((fr) -> fr.getId() + ":" + fr.getName() + "; ")
                    .reduce("", String::concat),
                    dep.isIsCurrent()
            );
        });

        api.getStages().getStages().forEach((stg) -> {
            log.info("{}, {}, {}",
                    stg.getId(),
                    stg.getName(),
                    stg.getPhases().stream()
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

        api.getPeriods().getPeriods().forEach((per) -> {
            log.info(
                    "{}, {}, {}, {}",
                    per.getId(),
                    per.getName(),
                    per.getStartDate(),
                    per.getEndDate(),
                    per.getSessions().stream()
                    .map((ses) -> ses.getId() + ":"
                            + ses.getName() + ":"
                            + ses.getStartDate() + ":"
                            + ses.getEndDate() + "; ")
                    .reduce("", String::concat));

        });

        //dumpResult(api.getFederalOrgans(new FederalOrgansRequest()), "federal-organs.xml");
    }

    public static void main(String[] args) {
        log.info("VoteFlow");
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new GTKLookAndFeel());
            } catch (UnsupportedLookAndFeelException ex) {
            }
            //WebLookAndFeel.install(true);
            MainForm mainForm = new MainForm();
            mainForm.setFont(Main.firaCodeFont);
            mainForm.setVisible(true);
        });

    }

}
