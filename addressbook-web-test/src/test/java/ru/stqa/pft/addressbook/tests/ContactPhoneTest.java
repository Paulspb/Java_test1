package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.Arrays;
import java.util.stream.Collectors;

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
            System.out.println("contact.getAllPhones() = " +contact.getAllPhones());
        NameFirstMiddle contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
            System.out.println("InfoFromEditForm ->  " + contactInfoFromEditForm);

                //assertEquals(contact.size(),before.size() );
        assertThat(contact.getAllPhones(),
                equalTo(mergePhones(contactInfoFromEditForm)));
                //assertThat(contact.getHome(), equalTo(cleaned(contactInfoFromEditForm.getHome())));
                //assertThat(contact.getMobile(), equalTo(cleaned(contactInfoFromEditForm.getMobile())));
                //assertThat(contact.getWork(), equalTo(cleaned(contactInfoFromEditForm.getWork())));
                //assertThat(contact, equalTo(contactInfoFromEditForm));

    }

    private String mergePhones(NameFirstMiddle contact) {
            // before java 8
            //String result = "";
            //if (contact.getHome() != null) {
            //    result = result + contact.getHome();
            //}
        // create collection/spisok in java 8
        // move collection/spisok to potok -> stream() ., then remove NULL = filter()
        // convert to spisok via collect()  & \n - razdelitel
        // map() convert via fuction: cleaned()
        return Arrays.asList(contact.getHome(),contact.getMobile(),contact.getWork()).
                stream().filter((s) -> ! s.equals("")).
                map(ContactPhoneTest::cleaned).
                collect(Collectors.joining("\n"));
    }
            //static means Global
    public static String cleaned (String phones){
        // revoke 'blank' & () & -
        // \\s  'blank'                           [a-z] [-az]
        return phones.replaceAll("\\s","").replaceAll("[-()]","");
    }
}
