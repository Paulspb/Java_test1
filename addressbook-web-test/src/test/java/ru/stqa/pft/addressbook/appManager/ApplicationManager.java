package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by khomep on 08-Jun-16.
 */
public class ApplicationManager {
    //FirefoxDriver wd;
    WebDriver wd;
    private ContactHelper contactHelper;
    // private final ContactHelper contactHelper = new ContactHelper();
    // private final GroupHelper groupHelper = new GroupHelper();
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void initTests() {
        // when this.browser = browser;, then next line no needs
        //String browser = BrowserType.FIREFOX;
        if (browser == BrowserType.FIREFOX) {
            // .....goes method 'setup'
            // groupHelper.wd = new FirefoxDriver();
            // contactHelper.wd = new FirefoxDriver();
            wd = new FirefoxDriver();
        } else if (Objects.equals(browser, BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (Objects.equals(browser, BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }
        // init attribute of object = WD
        // groupHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // groupHelper.wd.get("http://localhost/addressbook/group.php");
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper    = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper.loginAddressbook("admin", "secret");
        //groupHelper.getNavigationHelper().gotoGroupPage2();

    }

    public void afterTests() {
        wd.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }
    public NavigationHelper getNavigationHelpe() {
        return navigationHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }
}
