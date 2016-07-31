package ru.stqa.ptf.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.mantis.appmanager.HttpSession;
import ru.stqa.ptf.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by khomep on 30-Jul-16.
 */
public class ResetPassword extends TestBase{

    @BeforeMethod
        public void startMailServer() {
        app.mail().start();
    }



    @Test
    public void testResetPassword() throws IOException, MessagingException {
        HttpSession session = app.newSession();
        String now      = "1";
        String user     = "user"+ now;
        String password = "password";
        String passwordNew = "passwordNew";
        String email = String.format("user%s@localhost.localdomain",now);
                // make failed password
        for (int i = 1; i < 6; i++) {
            app.newSession().loginFailed(user, password);
        }
                // verify if password has failed
        assertFalse(app.newSession().loginFailed(user,password));

        app.registration().startForReset("administrator","root",user);
                //awaiting mail: 2 items for 20sec
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
                // return string
        String confirmationLink = app.registration().findConfirmationLink(mailMessages, email);

        app.registration().finishForReset(confirmationLink, passwordNew);
                // verification of results: passwordNew - true
        assertTrue(app.newSession().login(user,passwordNew));
        // verification of results: password - false
        assertFalse(app.newSession().login(user,password));

    }

    @AfterMethod(alwaysRun = true)
    public  void  stopMailServer() {
        app.mail().stop();
    }
}
