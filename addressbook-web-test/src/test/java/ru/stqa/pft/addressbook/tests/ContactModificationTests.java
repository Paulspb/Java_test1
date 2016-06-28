package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by khomep on 09-Jun-16.
 */
public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditionContact(){
        app.contact().goToContact();
        //if (! app.contact().isThereAContact()) {
        if ( app.contact().all().size() == 0) {
            app.contact().create(new NameFirstMiddle().withId(0).
                    withFirstname("new group2 modifing").
                    withLastname("Dostoyevsky").withGroup("test134") );
        }
    }

    @Test
    public void testContactModification() {
                //List<NameFirstMiddle> before = app.contact().list();
            // all() return spisok, not mnogestvo
        Set<NameFirstMiddle> before = app.contact().all();
            // next() return sly4ainyi element, not last, not first
        NameFirstMiddle modifiedContact = before.iterator().next();
            //System.out.println("modifiedContact =" + modifiedContact);
                //int index = before.size() -1;
        NameFirstMiddle contact = new NameFirstMiddle().
            withId(modifiedContact.getId()).
            withFirstname("upd-Alexander").withLastname("Pushkin");
        app.contact().modify(contact);
                //app.contact().modify(contact);
        Set<NameFirstMiddle> after = app.contact().all();
        Assert.assertEquals(after.size(),before.size() );
            //System.out.println("2before =" +before);
        before.remove(modifiedContact);
            //System.out.println("2modifiedContact =" + modifiedContact);
            //System.out.println("2Contact =        " + contact);
        before.add(contact);
            // System.out.println("3before =" +before);
            // System.out.println("3after =" + after);
            // ne-uporjado4en - massiv
            // uporjado4en    - spisok
            // spicok -> mnogestvoб BUT HashSet contains only unique names aND remove duplicates names
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
            //anonimous function: sort by Id - our choice
                // no need after modifiedContact
                //Comparator<? super NameFirstMiddle> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
                //before.sort(byId);
                //after.sort(byId);
            //System.out.println("before assertE - " + before);
            //System.out.println("after  assertE - " + after);
        Assert.assertEquals(before,after);

                //app.fillTitle("mr.");
                //app.fillCompany("ooo Boldino");
                //app.fillAddress1("Pskovskaya obl.");
                //app.fillHomeMobileTlf("8 888 555 3214", "8 921 921 921 921");
                //app.fillEmail(new Emails123("alexander0.puchkin@gmail.com", "apuchkin@kultura.tv", "\\9"));

    }



}
