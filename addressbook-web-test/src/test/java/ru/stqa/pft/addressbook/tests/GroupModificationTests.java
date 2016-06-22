package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by khomep on 09-Jun-16.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test123423434", "test21", "test31"));
        }
        app.getGroupHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectOneGroupFromAllGroup(before -1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillInGroupForm(new GroupData("test123423434", "updat3331", "updat3331"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().getNavigationHelper().returntoGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before );

    }
}
