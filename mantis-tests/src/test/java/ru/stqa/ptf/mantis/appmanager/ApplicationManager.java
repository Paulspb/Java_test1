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
            //////private WebDriver driver;
    private RegistrationHelper registrationHelper;
    private FtpHelper ftp;
    private MailHelper mailHelper;
    private SoapHelper soapHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties    = new Properties();
    }


    public void init() throws IOException {
            // file config name
        String target = System.getProperty("target","local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));
    }

    public void stop() {
        if(wd !=null) {
            wd.quit();
        }
    }

    public HttpSession newSession() {
            //constructor
            // we could open session from user + developer + manager + administrator
            // 4 session are resurce consuming
        return  new HttpSession(this);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public RegistrationHelper registration() {
                //for avoid of duplication
            //return new RegistrationHelper(this);
        if (registrationHelper == null) {
            registrationHelper = new RegistrationHelper(this);
        }
        return registrationHelper;
    }

    public FtpHelper ftp() {
        if(ftp == null) {
            ftp = new FtpHelper(this);
        }
        return ftp;
    }

    public WebDriver getDriver() {
        if (wd == null) {
            if (browser.equals(BrowserType.FIREFOX)) {
                // .....goes method 'setup'
                wd = new FirefoxDriver();
            } else if (Objects.equals(browser, BrowserType.CHROME)) {
                wd = new ChromeDriver();
            } else if (Objects.equals(browser, BrowserType.IE)) {
                wd = new InternetExplorerDriver();
            }
            // init attribute of object = WD
            wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            wd.get(properties.getProperty("web.baseUrl"));

        }
        return wd;
    }
    
    public MailHelper mail() {
        if (mailHelper == null) {
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }

    //public JamesHelper james() {
    //    if (jamesHelper == null) {
    //        jamesHelper = new JamesHelper(this);
    //    }
    //    return jamesHelper;
    //}


        //init SoapHelper after declaration as in class (separated class)
    public SoapHelper soap() {
        //this is lenivyi initialization
        if (soapHelper == null) {
            soapHelper = new SoapHelper(this);
        }  // then create bew field(not new variable) called : soapHelper here
        return  soapHelper;

    }
}
