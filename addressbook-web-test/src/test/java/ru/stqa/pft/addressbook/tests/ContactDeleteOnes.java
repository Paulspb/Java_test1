package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.LastNameNick2;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

/**
 * Created by khomep on 09-Jun-16.
 */
public class ContactDeleteOnes extends TestBase {
    @Test
    public void testContactModification() {
        app.getContactHelper().goToContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillFirstNameMiddleName(new NameFirstMiddle("delete", "Serge-delete", "delete3"), false);
        app.getContactHelper().fillLastNameNickName(new LastNameNick2("delete", "delete-Puschkin"));
        app.getContactHelper().submitDelete();
     }
}
