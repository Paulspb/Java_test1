package ru.stqa.ptf.mantis.tests;

import biz.futureware.mantis.rpc.soap.client.IssueData;
import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.ptf.mantis.appmanager.ApplicationManager;
import ru.stqa.ptf.mantis.model.Issue;
import ru.stqa.ptf.mantis.appmanager.SoapHelper;
import ru.stqa.ptf.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;


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


    public void skipIfNotFixed(int issueID) throws IOException, ServiceException,SkipException {
        if(isIssueOpen(issueID)) {
            throw new SkipException("Ignored because of issue " +issueID);
        }
    }

    public boolean isIssueOpen(int issueId) throws IOException, ServiceException {
             //return !getIssueById(issueId).getState_name().equals("Resolved");
        return !getIssueById(issueId);
    }

    public Boolean getIssueById(int id) throws IOException, ServiceException {
        MantisConnectPortType mc = getMantisConnect2();
        BigInteger idBig = BigInteger.valueOf(id);
            IssueData[] issues = mc.mc_project_get_issues("administrator", "root",
                    BigInteger.valueOf(1),BigInteger.valueOf(1),BigInteger.valueOf(12));
                    //idBig,BigInteger.valueOf(1),BigInteger.valueOf(4));
        System.out.println("issues list for Project ' 1  ' :");
        for (IssueData i: issues) {
            System.out.println(i.getId() +" "+ i.getSummary() +" in Status "+ i.getStatus().getName());
            if (i.getId().equals(idBig)) {
                if(i.getStatus().getName().equals("Resolved")) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    return  false;
        //IssueData createdIssueData = mc.mc_issue_get("administrator", "root", idBig);
        //    System.out.println("Project id: "+id +" in Status: " +
        //            createdIssueData.getStatus().getName());
        //return  createdIssueData.getStatus().getName().equals("Resolved");
    }

    private MantisConnectPortType getMantisConnect2() throws ServiceException, MalformedURLException {
        return new MantisConnectLocator().getMantisConnectPort(new URL(
                "http://localhost/mantisbt-1.3.0/api/soap/mantisconnect.php"));
    }
}
