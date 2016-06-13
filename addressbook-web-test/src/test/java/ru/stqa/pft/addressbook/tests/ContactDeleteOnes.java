package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Emails123;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.LastNameNick2;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

/**
 * Created by khomep on 09-Jun-16.
 */
public class ContactDeleteOnes extends TestBase {
    @Test
    public void testContactModification() {

        app.getContactHelper().goToContact();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createSimpleContact(new NameFirstMiddle("update2", "Sergeevich","test134"), true);
            }
        app.getContactHelper().initContactModification(2);
        app.getContactHelper().submitDelete();
     }
}
