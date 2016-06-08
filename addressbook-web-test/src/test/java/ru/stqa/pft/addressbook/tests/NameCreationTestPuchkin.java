package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Emails123;
import ru.stqa.pft.addressbook.model.LastNameNick2;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

public class NameCreationTestPuchkin extends TestBase {

    @Test
    public void nameCreationTestPushkinMethod() {
        app.fillAddNamePad();
        app.fillFirstNameMiddleName(new NameFirstMiddle("Alexey", "Sergeevich"));
        app.fillLastNameNickName(new LastNameNick2("Pushkin", "Puschkin"));
        app.fillTitle("mr.");
        app.fillCompany("ooo Boldino");
        app.fillAddress1("Pskovskaya obl.");
        app.fillHomeMobileTlf("8 888 555 3214", "8 921 921 921 921");
        app.fillFaxWorkTlf();
        app.fillEmail(new Emails123("alexander0.puchkin@gmail.com", "apuchkin@kultura.tv", "\\9"));
        app.fillHomePage();
        app.fillBithday();
        app.fillContent();
        app.fillAddress2();
        app.fillPhone2();
        app.submit();
    }


}
