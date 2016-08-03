package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by khomep on 08-Jun-16.
 */
public class ApplicationManager {
        //FirefoxDriver wd;
        //private final Properties properties;
        //private static Properties properties;
    public static Properties properties;
        //private Properties properties;
        //public Properties properties;
    WebDriver wd;
    private ContactHelper contactHelper;
        // private final ContactHelper contactHelper = new ContactHelper();
        // private final GroupHelper groupHelper = new GroupHelper();
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String browser;
            // lesson 7.4
    private DbHelper dbHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties    = new Properties();
    }

    public void initTests() throws IOException {
            // file config name
        String target = System.getProperty("target","local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));

            //this is constructor ??? // lesson 7.4
        dbHelper = new DbHelper();

        if ("".equals((properties.getProperty("selenium.server")))) {
            if (browser.equals(BrowserType.FIREFOX)) {
                // .....goes method 'setup'
                // groupHelper.wd = new FirefoxDriver();
                // contactHelper.wd = new FirefoxDriver();
                wd = new FirefoxDriver();
            } else if (Objects.equals(browser, BrowserType.CHROME)) {
                wd = new ChromeDriver();
            } else if (Objects.equals(browser, BrowserType.IE)) {
                wd = new InternetExplorerDriver();
            } else{
                // using remote servet
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(browser);
                capabilities.setPlatform(Platform.fromString(System.getProperty("platform","win7")));
                wd = new RemoteWebDriver(new URL
                        (properties.getProperty("selenium.server")),capabilities);
            }
        }


        wd.manage().timeouts().implicitlyWait(020, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper    = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper.loginAddressbook(properties.getProperty("web.adminLogin"),
                properties.getProperty("web.adminPassword"));
    }

    public void afterTests() {
        wd.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }
    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
    public ContactHelper contact() {
        return contactHelper;
    }
            // new constructor in Groups.java
    public DbHelper db()     { return dbHelper; }
}
