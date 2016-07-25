package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static ru.stqa.pft.addressbook.appManager.ApplicationManager.properties;

    public class ContactAddToGroupTest extends TestBase  {

        @BeforeMethod
        public void ensurePreconditionContact(){
            app.contact().goToContact();
            //if (! app.contact().isThereAContact()) {
            if ( app.db().contacts().size() == 0) {
                Groups groups = app.db().groups();      // mnogestvo
                app.contact().create(new NameFirstMiddle().withId(0).
                        withFirstname(properties.getProperty("web.contactModifiedFirstName")).
                        withLastname(properties.getProperty("web.contactModifiedLastName"))
                        .inGroup(groups.iterator().next()) );
            }

            if(app.db().groups().size() == 0 ) {
                app.group().groupPage();
                app.group().create(new GroupData().
                        withName(properties.getProperty("web.groupModifiedName")));
                app.contact().goToContact();
            }
        }

        @Test
        public void testContactAddToGroup() throws IOException {
            Contacts before = app.db().contacts();
            Groups   groups = app.db().groups();      // mnogestvo
            NameFirstMiddle modifiedContact = before.iterator().next();
            app.contact().addOneGroup(modifiedContact,groups.size());

            if (! app.contact().isThereContactReadyToAdd()) {
                System.out.println("*** there is no any contacts in this group : '"+ groups.iterator().next().getName()+"' ***");
                System.out.println("*** verification skipped ***");
            } else {
                Contacts after = app.db().contacts();
                assertEquals(after.size(),before.size() );
                verifyContactListInUi();
            }
        }
    }