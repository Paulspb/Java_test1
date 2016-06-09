package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by khomep on 09-Jun-16.
 */
public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getContactHelper().fillAddNamePad();
        //app.
        //app.fillFirstNameMiddleName(new NameFirstMiddle("Alexey", "Sergeevich"));
        //app.fillLastNameNickName(new LastNameNick2("Pushkin", "Puschkin"));
        //app.fillTitle("mr.");
        //app.fillCompany("ooo Boldino");
        //app.fillAddress1("Pskovskaya obl.");
        //app.fillHomeMobileTlf("8 888 555 3214", "8 921 921 921 921");
        //app.fillFaxWorkTlf();
        //app.fillEmail(new Emails123("alexander0.puchkin@gmail.com", "apuchkin@kultura.tv", "\\9"));
    }
}
