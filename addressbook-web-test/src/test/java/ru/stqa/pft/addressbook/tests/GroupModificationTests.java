package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by khomep on 09-Jun-16.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {
        app.getGroupHelper().gotoGroupCreation();
        app.getGroupHelper().selectOneGroupFromAllGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillInGroupForm(new GroupData("upda3334", "updat3331", "updat3331"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().getNavigationHelper().returntoGroupPage();

    }
}
