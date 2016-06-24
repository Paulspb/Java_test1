package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Emails123;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.LastNameNick2;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by khomep on 09-Jun-16.
 */
public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getContactHelper().goToContact();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createSimpleContact(new NameFirstMiddle(
                    0,"update2", "Sergeevich","test134"),
                    true);
        }
        List<NameFirstMiddle> before = app.getContactHelper().getContactlist();
        app.getContactHelper().initContactModification( before.size() + 1 );
        NameFirstMiddle contact = new NameFirstMiddle
                (before.get(before.size()-1).getId(),"UpdateFirst1", "Last-update3",null);

        app.getContactHelper().fillFirstNameMiddleName(contact,false);
        app.getContactHelper().submitUpdate();
        app.getContactHelper().goToContact();
        List<NameFirstMiddle> after = app.getContactHelper().getContactlist();
        Assert.assertEquals(after.size(),before.size() );
        before.remove(before.size() - 1);
        before.add(contact);
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
