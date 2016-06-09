package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by khomep on 08-Jun-16.
 */
public class ApplicationManager {
    FirefoxDriver wd;
    private ContactHelper contactHelper;
    // private final ContactHelper contactHelper = new ContactHelper();
    // private final GroupHelper groupHelper = new GroupHelper();
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;



    public void initTests() {
        // .....goes method 'setup'
        // groupHelper.wd = new FirefoxDriver();
        // contactHelper.wd = new FirefoxDriver();
        wd = new FirefoxDriver();
        // init attribute of object = WD
        // groupHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // groupHelper.wd.get("http://localhost/addressbook/group.php");
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper    = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper.loginAddressbook("admin", "secret");
        //groupHelper.getNavigationHelper().gotoGroupPage2();

    }

    public void submit() {
        wd.findElement(By.name("notes")).sendKeys(".");
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }


    public void afterTests() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
