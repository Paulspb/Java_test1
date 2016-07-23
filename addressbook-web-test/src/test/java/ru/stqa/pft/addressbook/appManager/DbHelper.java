package ru.stqa.pft.addressbook.appManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.List;

public class DbHelper {
    private final SessionFactory sessionFactory;
    //private final SessionFactory sessionFactory;
    //private final SessionFactory2 sessionFactory2;

    //private final SessionHelper sessionHelper;
    //this is constructor !!

    public DbHelper() {
        // A SessionFactory is set up once for an application!

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().
                buildSessionFactory();
    }

    //public void testHbConnectionContact() {
    @Test(enabled = true)
    public Groups groups() {
        //lesson 7.3
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GroupData> result = session.createQuery(
                "from GroupData " ).list();                 //"from GroupData where deprecated = '0000-00-00'" ).list();
        session.getTransaction().commit();
        session.close();
                // no constructor for result, so do new one
        return  new Groups(result);
    }

    @Test(enabled = true)
    public Contacts contacts()  {
        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        List<NameFirstMiddle> resultContact = session2.createQuery(
                "from NameFirstMiddle where deprecated = '0000-00-00' " ).list();
        session2.getTransaction().commit();
        session2.close();
        return  new Contacts(resultContact);
    }
}
