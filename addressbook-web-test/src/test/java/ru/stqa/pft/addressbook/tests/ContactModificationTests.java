package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.LastNameNick2;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

/**
 * Created by khomep on 09-Jun-16.
 */
public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getContactHelper().goToContact();
        app.getContactHelper().initContactModification();
        //app.getContactHelper().fillFirstNameMiddleName(new NameFirstMiddle("Update1", "Serge-update","upda3334"), false);
        app.getContactHelper().fillFirstNameMiddleName(new NameFirstMiddle("Update1", "Serge-update",null), false);
        app.getContactHelper().fillLastNameNickName(new LastNameNick2("UPdate11", "update1-Puschkin"));
        app.getContactHelper().submitUpdate();
        //app.fillTitle("mr.");
        //app.fillCompany("ooo Boldino");
        //app.fillAddress1("Pskovskaya obl.");
        //app.fillHomeMobileTlf("8 888 555 3214", "8 921 921 921 921");
        //app.fillEmail(new Emails123("alexander0.puchkin@gmail.com", "apuchkin@kultura.tv", "\\9"));
    }


}
