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
public class ContactDeleteOnes extends TestBase {
    @Test
    public void testContactModification() {
        app.getContactHelper().goToContact();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createSimpleContact(new NameFirstMiddle(0,"update2", "Sergeevich","test134"), true);
            }
        List<NameFirstMiddle> before = app.getContactHelper().getContactlist();
        //System.out.println("contactBefore =" + contactBefore);
        //System.out.println("before.size =" +before.size());
        app.getContactHelper().initContactModification(before.size() + 1);
        app.getContactHelper().submitDelete();
        app.getContactHelper().goToContact();
        List<NameFirstMiddle> after = app.getContactHelper().getContactlist();
        //System.out.println("after.size =" +after.size());
        // int after = app.getGroupHelper().getGroupCount();
        //Assert.assertEquals(after,before - 1);
        Assert.assertEquals(after.size(),before.size() - 1);
        before.remove(before.size() - 1);
        //for ( int i = 0; i < after.size(); i++) {
        //    Assert.assertEquals(after.get(i),before.get(i));
        //}
        Assert.assertEquals(after,before);


    }
}
