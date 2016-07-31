package ru.stqa.ptf.mantis.appmanager;


import org.apache.http.client.methods.HttpPost;
import org.openqa.selenium.By;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.ptf.mantis.model.MailMessage;

import java.util.List;


/**
 * Created by khomep on 29-Jul-16.
 */
public class RegistrationHelper extends HelperBase {
    // it done in HelpBase - private final ApplicationManager app;
            //start needs for helper
    // it done in HelpBase - private WebDriver wd;

    public RegistrationHelper(ApplicationManager app)  {
        super(app);
        //-no after super...this.app = app;
            //wd = app.wd;
            // now switch on lenivyu init
        wd = app.getDriver();
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        type(By.name("username"),username);
        type(By.name("email"),email);
        click(By.cssSelector("input[value='Signup']"));
    }


    public void startForReset(String username, String password, String user) {
        wd.get(app.getProperty("web.baseUrl") + "login_page.php");
        type(By.name("username"),username);
        type(By.name("password"),password);
        wd.findElement(By.cssSelector("input.button")).click();
        wd.findElement(By.linkText("Manage")).click();
        wd.findElement(By.linkText("Manage Users")).click();
        wd.findElement(By.linkText(user)).click();
        //wd.findElement(By.xpath("//form[@id='manage-user-reset-form']/fieldset/span/input")).click();
        click(By.cssSelector("input[value='Reset Password']"));
        //wd.findElement(By.id("logout-link")).click();
    }

    public void finish(String confirmationLink, String passowrd) {
            // confirmationLink - this is link
        wd.get(confirmationLink);
        type(By.name("password"), passowrd);
        type(By.name("password_confirm"), passowrd);
        click(By.cssSelector("input[value='Update User']"));
    }


    public void finishForReset(String confirmationLink, String passowrd) {
        // confirmationLink - this is link
        wd.findElement(By.id("logout-link")).click();
        wd.get(confirmationLink);
        type(By.name("password"), passowrd);
        type(By.name("password_confirm"), passowrd);
        click(By.cssSelector("input[value='Update User']"));
    }

    public String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        // take all msgs, filter only ==email, then
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        //now needs for extraction of link via regular expression
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return  regex.getText(mailMessage.text);
    }
}
