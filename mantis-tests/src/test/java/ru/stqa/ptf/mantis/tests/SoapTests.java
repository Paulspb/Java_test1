package ru.stqa.ptf.mantis.tests;

import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import biz.futureware.mantis.rpc.soap.client.ProjectData;
import org.testng.annotations.Test;
import ru.stqa.ptf.mantis.model.Issue;
import ru.stqa.ptf.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by khomep on 01-Aug-16.
 */
    //public class SoapTests {
    public class SoapTests extends TestBase {


    @Test(enabled = true)
    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();  //mnogestvo
            //System.out.println(projects.length); // for massiv
        System.out.println(projects.size()); // for mnogestvo
        for (Project project: projects) {
            System.out.println(project.getName());
        }
    }

    @Test
    public void testCreateIssue()throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();  //mnogestvo
        Issue issue = new Issue().withSummary("Test summary").withDescription("Test issue description")
                .withProject(projects.iterator().next());
        Issue created = app.soap().addIssue(issue);
        assertEquals(issue.getSummary(),created.getSummary());

    }
}
