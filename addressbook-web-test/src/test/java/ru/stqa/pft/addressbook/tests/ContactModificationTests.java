package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by khomep on 09-Jun-16.
 */
public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditionContact(){
        app.contact().goToContact();
        //if (! app.contact().isThereAContact()) {
        if ( app.contact().list().size() == 0) {
            app.contact().create(new NameFirstMiddle().withId(0).withFirstname("update2"));
        }
    }

    @Test
    public void testContactModification() {
        List<NameFirstMiddle> before = app.contact().list();
        int index = before.size() -1;
        NameFirstMiddle contact = new NameFirstMiddle().withId(before.get(index).getId()).
        withFirstname("UpdateFirst1").withLastname("Last-update3");
        app.contact().modify(before, contact);
        List<NameFirstMiddle> after = app.contact().list();
        Assert.assertEquals(after.size(),before.size() );
        before.remove(index);
        before.add(contact);
            //System.out.println("after =" + after);
            //System.out.println("before =" +before);
            // ne-uporjado4en - massiv
            // uporjado4en    - spisok
            // spicok -> mnogestvoб BUT HashSet contains only unique names aND remove duplicates names
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
            //anonimous function: sort by Id - our choice
        Comparator<? super NameFirstMiddle> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
                Assert.assertEquals(before,after);

            //app.fillTitle("mr.");
            //app.fillCompany("ooo Boldino");
            //app.fillAddress1("Pskovskaya obl.");
            //app.fillHomeMobileTlf("8 888 555 3214", "8 921 921 921 921");
            //app.fillEmail(new Emails123("alexander0.puchkin@gmail.com", "apuchkin@kultura.tv", "\\9"));

    }



}
