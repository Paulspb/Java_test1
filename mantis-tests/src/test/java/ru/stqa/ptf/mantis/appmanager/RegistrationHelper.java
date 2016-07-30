package ru.stqa.ptf.mantis.appmanager;


import org.apache.http.client.methods.HttpPost;
import org.openqa.selenium.By;


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
        //HttpPost post = new HttpPost(app.getProperty("web.baseUrl") + "/sign_up.php");
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        type(By.name("username"),username);
            //wd.findElement(By.name("username")).sendKeys(username);
        type(By.name("email"),email);
        type(By.name("email"),email);
        click(By.cssSelector("input[value='Signup']"));


    }

    public void finish(String confirmationLink, String passowrd) {
            // confirmationLink - this is link
        wd.get(confirmationLink);
        type(By.name("password"), passowrd);
        type(By.name("password_confirm"), passowrd);
        click(By.cssSelector("input[value='Update User']"));
    }
}
