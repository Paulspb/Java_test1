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
public class ContactEmailsTest extends TestBase {
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
    public void testEmails() {
        app.contact().goToContact();
        NameFirstMiddle contact = app.contact().all().iterator().next();
            //System.out.println("iterator            =" + contact);
            System.out.println("contact.getAllEmails() = " + contact.getAllEmails());
        NameFirstMiddle emailsInfoFromEditForm = app.contact().emailsFromEditForm(contact);
            System.out.println("emailsInfoFromEditForm ->  " + emailsInfoFromEditForm);

        assertThat(contact.getAllEmails(),
                equalTo(mergeEmails(emailsInfoFromEditForm)));

    }

    private String mergeEmails(NameFirstMiddle contact) {
                // before java 8
                //String result = "";
                //if (contact.getHome() != null) {
                //    result = result + contact.getHome();
                //}
            // create collection/spisok in java 8
            // move collection/spisok to potok -> stream() ., then remove NULL = filter()
            // convert to spisok via collect()  & \n - razdelitel
            // map() convert via fuction: cleaned()

        return Arrays.asList(contact.getEmail1(),contact.getEmail2(),contact.getEmail3()).
                stream().filter((s) -> ! s.equals("")).
                map(ContactPhoneTest::cleaned).
                collect(Collectors.joining("\n"));
    }


}
