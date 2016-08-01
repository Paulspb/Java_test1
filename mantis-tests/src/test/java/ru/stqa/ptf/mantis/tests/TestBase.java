package ru.stqa.ptf.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.ptf.mantis.appmanager.ApplicationManager;
import ru.stqa.ptf.mantis.model.Issue;

import java.io.File;
import java.io.IOException;


public class TestBase {

     protected static final ApplicationManager app =
             new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));
              // new available only with constructor in AppMng !!!


    @BeforeSuite
    public void setUp() throws Exception {
        //app.init();
        //app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws IOException {
        //app.stop();
        //app.ftp().restore( "config_inc.php.bak", "config_inc.php");
    }


    public boolean isIssueOpen(int issueId) throws IOException {
             return !getIssueById(issueId).getState_name().equals("Resolved");
    }

    public Issue getIssueById(int id) throws IOException {
               Issue issue = new Issue();
               getIssues()
                       .stream().findFirst().map
                      ((i) -> issue.withId(i.getId()).withSubject(i.getSubject())
                              .withDescription(i.getDescription())
                           .withStateName(i.getState_name())
                 );
          return issue;
        }


}
