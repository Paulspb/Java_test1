package ru.stqa.ptf.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.ptf.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;


import static org.testng.Assert.assertTrue;

/**
 * Created by khomep on 29-Jul-16.
 */
public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException {
        long now = System.currentTimeMillis();
        String user = "user"+ now;
        String password = "password";
        String email = String.format("user%s@localhost.localdomain",now);
        app.registration().start(user, email);
                //awaiting mail: 2 items for 10sec
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
                // return string
        String confirmationLink = findConfirmationLink(mailMessages, email);

        app.registration().finish(confirmationLink, password);
                // verification of results
        assertTrue(app.newSession().login(user,password));

    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
            // take all msgs, filter only ==email, then
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
                //now needs for extraction of link via regular expression
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return  regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public  void  stopMailServer() {
        app.mail().stop();
    }
}
