package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Emails123;
import ru.stqa.pft.addressbook.model.LastNameNick2;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

public class NameCreationTestPuchkin extends TestBase {

    @Test
    public void nameCreationTestPushkinMethod() {
        app.getContactHelper().goToContact();
        app.getContactHelper().fillAddNamePad();
        app.getContactHelper().fillFirstNameMiddleName(new NameFirstMiddle("Alexey", "Sergeevich"));
        app.getContactHelper().fillLastNameNickName(new LastNameNick2("Pushkin", "Puschkin"));
        app.getContactHelper().fillTitle("mr.");
        app.getContactHelper().fillCompany("ooo Boldino");
        app.getContactHelper().fillAddress1("Pskovskaya obl.");
        app.getContactHelper().fillHomeMobileTlf("8 888 555 3214", "8 921 921 921 921");
        app.getContactHelper().fillFaxWorkTlf();
        app.getContactHelper().fillEmail(new Emails123("alexander0.puchkin@gmail.com", "apuchkin@kultura.tv", "\\9"));
        app.getContactHelper().fillHomePage();
        app.getContactHelper().fillBithday();
        app.getContactHelper().fillContent();
        app.getContactHelper().fillAddress2();
        app.getContactHelper().fillPhone2();
        app.submit();
    }


}
