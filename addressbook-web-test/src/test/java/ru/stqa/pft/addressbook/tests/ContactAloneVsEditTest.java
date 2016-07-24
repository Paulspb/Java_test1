package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.stqa.pft.addressbook.appManager.ApplicationManager.properties;

/**
 * Created by khomep on 05-Jul-16.
 */
public class ContactAloneVsEditTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditionContact(){
        app.contact().goToContact();
        if ( app.contact().all().size() == 0) {
            app.contact().create(new NameFirstMiddle().withId(0).
                    //withFirstname(properties.getProperty("web.contactModifiedFirstName")).
                    //withLastname(properties.getProperty("web.contactModifiedLastName")).
                    //withGroup(properties.getProperty("web.contactGroup")) );


                    withFirstname("new dummy contact2").
                    withLastname("Dostoyevsky") ); //lesson 7.6.withGroup("test134") );
        }
    }

    @Test
    public void testContactAloneVsEdit() {
        app.contact().goToContact();
        NameFirstMiddle contact = app.contact().all().iterator().next();
        NameFirstMiddle viewEditFormContact = app.contact().readContactFromEditForm(contact);
        NameFirstMiddle viewManFormContact = app.contact().viewMan(contact);
        assertThat(mergeManView(viewEditFormContact),
                equalTo(mergeManView(viewManFormContact)));
    }

    private String mergeManView(NameFirstMiddle contact) {
        return Arrays.asList(contact.getFirstname(),contact.getLastName(),
                contact.getAllPhones(),contact.getHome(),contact.getWork(),contact.getMobile(),
                contact.getFullAddress(),
                contact.getEmail1(),contact.getEmail2(),contact.getEmail3()).
                stream().filter( (s) ->  s!= null && !s.equals("")).
                map(ContactPhoneTest::cleaned).
                collect(Collectors.joining(""));
        //stream().filter( (s) ->  !s.equals("") && !s.equals("null")  ).
    }



}
