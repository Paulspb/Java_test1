package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Emails123;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.LastNameNick2;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.List;

/**
 * Created by khomep on 09-Jun-16.
 */
public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getContactHelper().goToContact();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createSimpleContact(new NameFirstMiddle("update2", "Sergeevich","test134"),
                    true);
        }
        int contactBefore = app.getContactHelper().getContactCount();
        //List<GroupData> before = app.getContactHelper().getContactlist(); jun 20
        List<NameFirstMiddle> before = app.getContactHelper().getContactlist();
        //System.out.println("before.size() =" + before.size());
        //System.out.println("contactBefore =" + contactBefore);
        //app.getContactHelper().initContactModification( before.size() -1 );
        app.getContactHelper().initContactModification( contactBefore -1 );
        app.getContactHelper().fillFirstNameMiddleName(new NameFirstMiddle("Update1", "Serge-update",null),
                false);
        app.getContactHelper().fillLastNameNickName(new LastNameNick2("UPdate11", "update1-Puschkin"));
        app.getContactHelper().submitUpdate();
        app.getContactHelper().goToContact();
        //List<GroupData> after = app.getContactHelper().getContactlist();
        List<NameFirstMiddle> after = app.getContactHelper().getContactlist();
            // int after = app.getGroupHelper().getGroupCount();
            //Assert.assertEquals(after,before );
        Assert.assertEquals(after.size(),before.size() );

        //app.fillTitle("mr.");
        //app.fillCompany("ooo Boldino");
        //app.fillAddress1("Pskovskaya obl.");
        //app.fillHomeMobileTlf("8 888 555 3214", "8 921 921 921 921");
        //app.fillEmail(new Emails123("alexander0.puchkin@gmail.com", "apuchkin@kultura.tv", "\\9"));

    }


}
