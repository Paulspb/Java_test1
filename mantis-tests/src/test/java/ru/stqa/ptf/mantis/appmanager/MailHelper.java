package ru.stqa.ptf.mantis.appmanager;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;
import ru.stqa.ptf.mantis.model.MailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


/**
 * Created by khomep on 29-Jul-16.
 */
public class MailHelper {
    private ApplicationManager app;
    private final Wiser wiser;

    public MailHelper(ApplicationManager app) {
        this.app = app;
                // this is post mail
        wiser = new Wiser();
    }

    public List<MailMessage> waitForMail(int count, long timeout)throws MessagingException, IOException {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() < start + timeout) {
            if (wiser.getMessages().size() >= count) {
                        //transfer real object to internal model object
                return wiser.getMessages().stream().map((m) -> toModelMail(m)).
                        collect(Collectors.toList());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        throw new Error("No mail :(");
    }

    public static MailMessage toModelMail(WiserMessage m) {
        try {
            MimeMessage mm = m.getMimeMessage();
                    // first mail to administrator about new user registred
                    //second mail to user where is link for continius for registration
                    // then getContent going to MailServer == Mail Message
            return  new MailMessage(mm.getAllRecipients()[0].toString(), (String) mm.getContent());
        } catch (MessagingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void start() {wiser.start();}

    public void stop() {wiser.stop();}
}
