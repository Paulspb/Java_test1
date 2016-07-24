package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by khomep on 03-Jul-16.
 */
public class contactHomeAddressTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditionContact() {
        app.contact().goToContact();
        if (app.contact().all().size() == 0) {
            app.contact().create(new NameFirstMiddle().withId(0).
                    withFirstname("new dummy contact2").
                    withLastname("Dostoyevsky")); //lesson 7.6 .withGroup("test134"));
        }
    }

    @Test
    public void testHomeAddress() {
        app.contact().goToContact();
        NameFirstMiddle contact = app.contact().all().iterator().next();
            System.out.println("contact.getfullAddress() = " + contact.getFullAddress());
        NameFirstMiddle homeAddressFromEditForm = app.contact().fullAddressFromEditForm(contact);
            System.out.println("homeAddressFromEditForm ->  " +
                homeAddressFromEditForm.getFullAddress().replaceAll("\\n", ""));

        assertThat(ContactPhoneTest.cleaned(contact.getFullAddress()),
                equalTo(ContactPhoneTest.cleaned(homeAddressFromEditForm.getFullAddress())));
    }
}
