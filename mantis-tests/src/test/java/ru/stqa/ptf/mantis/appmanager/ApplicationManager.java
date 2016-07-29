package ru.stqa.ptf.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by khomep on 08-Jun-16.
 */
public class ApplicationManager {
    public static Properties properties;
    WebDriver wd;

    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties    = new Properties();
    }


    public void init() throws IOException {
            // file config name
        String target = System.getProperty("target","local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));


        if (browser.equals(BrowserType.FIREFOX)) {
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
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                //wd.get("http://localhost/addressbook/group.php");
        wd.get(properties.getProperty("web.baseUrl"));

    }

    public void stop() {wd.quit(); }

    public HttpSession newSession() {
            //constructor
            // we could open session from user + developer + manager + administrator
            // 4 session are resurce consuming
        return  new HttpSession(this);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
