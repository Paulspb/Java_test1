package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by khomep on 09-Jun-16.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {
        app.getGroupHelper().gotoGroupCreation();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().initGroupModificatio();
        //app.getGroupHelper().fillInGroupForm(new GroupData("test123423434", "test21", "test31"));
        // app.getGroupHelper().submitGroupCreation();
        // app.getGroupHelper().getNavigationHelper().returntoGroupPage();
    }
}
