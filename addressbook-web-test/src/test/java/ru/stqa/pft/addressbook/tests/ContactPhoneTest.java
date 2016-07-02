package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by khomep on 02-Jul-16.
 */
public class ContactPhoneTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditionContact(){
        app.contact().goToContact();
        if ( app.contact().all().size() == 0) {
            app.contact().create(new NameFirstMiddle().withId(0).
                    withFirstname("new dummy contact2").
                    withLastname("Dostoyevsky").withGroup("test134") );
        }
    }
    @Test
    public void testContactPhones() {
        app.contact().goToContact();
        NameFirstMiddle contact = app.contact().all().iterator().next();
            System.out.println("iterator            =" + contact);
        NameFirstMiddle contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
            System.out.println("InfoFromEditForm ->  " + contactInfoFromEditForm);

        //assertEquals(contact.size(),before.size() );
        assertThat(contact, equalTo(contactInfoFromEditForm));

    }
}
