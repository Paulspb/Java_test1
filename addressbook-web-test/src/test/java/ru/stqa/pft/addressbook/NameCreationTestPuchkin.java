package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class NameCreationTestPuchkin extends TestBase {

    @Test
    public void nameCreationTestPushkinMethod() {
        fillAddNamePad();
        fillFirstNameMiddleName(new NameFirstMiddle("Alexandre", "Sergeevich"));
        fillLastNameNickName(new LastNameNick2("Pushkin", "Puschkin"));
        fillTitle("mr.");
        fillCompany("ooo Boldino");
        fillAddress1("Pskovskaya obl.");
        fillHomeMobileTlf("8 888 555 3214", "8 921 921 921 921");
        fillFaxWorkTlf();
        fillEmail(new Emails123("alexander0.puchkin@gmail.com", "apuchkin@kultura.tv", "\\9"));
        fillHomePage();
        fillBithday();
        fillContent();
        fillAddress2();
        fillPhone2();
        submit();
    }


}
