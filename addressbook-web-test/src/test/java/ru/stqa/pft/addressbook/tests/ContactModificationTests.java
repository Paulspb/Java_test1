package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static ru.stqa.pft.addressbook.appManager.ApplicationManager.properties;


/**
 * Created by khomep on 09-Jun-16.
 */
public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditionContact(){
        app.contact().goToContact();
        //if (! app.contact().isThereAContact()) {
        if ( app.db().contacts().size() == 0) {
            app.contact().create(new NameFirstMiddle().withId(0).
                    withFirstname(properties.getProperty("web.contactModifiedFirstName")).
                    withLastname(properties.getProperty("web.contactModifiedLastName"))
            );
              //lesson 7.6      withGroup(properties.getProperty("web.contactGroup")) );
        }
    }

    @Test
    public void testContactModification() throws IOException {
                    //List<NameFirstMiddle> before = app.contact().list();
            // all() return spisok, not mnogestvo
        Contacts before = app.db().contacts();
            // next() return sly4ainyi element, not last, not first
        NameFirstMiddle modifiedContact = before.iterator().next();
                    //int index = before.size() -1;
        NameFirstMiddle contact = new NameFirstMiddle().
            withId(modifiedContact.getId()).
                withFirstname(properties.getProperty("web.contactModifiedFirstName")).
                withLastname(properties.getProperty("web.contactModifiedLastName")).
                withEmail1(properties.getProperty("web.contactEmail1")).
                withEmail2(properties.getProperty("web.contactEmail2")).
                withEmail3(properties.getProperty("web.contactEmail3")).
                withFullAddress(properties.getProperty("web.contactAddress1")).
                withHomePhone(properties.getProperty("web.contactHomeTel")).
                withWorkPhone(properties.getProperty("web.contactWorkTel")).
                withMobilePhone(properties.getProperty("web.contactMobileTel"));

        app.contact().modify(contact);
        Contacts after = app.db().contacts();
        assertEquals(after.size(),before.size() );
        assertThat(after, equalTo(
                before.without(modifiedContact).withAdded(contact)));
        verifyContactListInUi();
                //-no needs after assertThat:before.remove(modifiedContact);
                //-no needs after assertThat:before.add(contact);
            // ne-uporjado4en - massiv
            // uporjado4en    - spisok
            // spicok -> mnogestvoб BUT HashSet contains only unique names aND remove duplicates names
                //-no needs after assertThat:assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
            //anonimous function: sort by Id - our choice
                // no need after modifiedContact
                //Comparator<? super NameFirstMiddle> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
                //before.sort(byId);
                //after.sort(byId);
                //-no needs after assertThat:assertEquals(before,after);
    }
}
