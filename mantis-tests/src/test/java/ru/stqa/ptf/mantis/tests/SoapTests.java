package ru.stqa.ptf.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

/**
 * Created by khomep on 01-Aug-16.
 */
public class SoapTests extends TestBase {
    @Test
    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();  //mnogestvo
        //System.out.println(projects.length); // for massiv
        System.out.println(projects.size()); // for mnogestvo
        for (Project project: projects) {
            System.out.println(project.getName());
        }

    }
}
