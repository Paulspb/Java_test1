package ru.stqa.pft.addressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.List;


public class HbConnectionTest {
    private SessionFactory sessionFactory;


    @BeforeClass
    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().
                    buildSessionFactory();
        }
        catch (Exception e) {
            //Sout :
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    @Test
    public void testHbConnectionContact() {
            //lesson 7.3
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery(
                "from NameFirstMiddle where deprecated = '0000-00-00'" ).list();
        for (NameFirstMiddle contact : (List<NameFirstMiddle>) result ) {
            System.out.println( "     contacts===========> " + contact );
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test (enabled = false)
    public void testHbConnection() {
                //Example 6. Obtaining a list of entities
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        List result = session.createQuery( "from group_list" ).list();
        List result = session.createQuery( "from GroupData" ).list();
        for ( GroupData group : (List<GroupData>) result ) {
            //for ( GroupData group :  result ) {
            System.out.println( "group (" + group );
        }
        session.getTransaction().commit();
        session.close();
    }


}
