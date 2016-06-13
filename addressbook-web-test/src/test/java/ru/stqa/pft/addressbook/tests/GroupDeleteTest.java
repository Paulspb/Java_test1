package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeleteTest extends TestBase  {

    @Test
    public void groupDeleteTest1() {
        app.getGroupHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test123423434", "test21", "test31"));
        }
        app.getGroupHelper().selectOneGroupFromAllGroup();
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().gotoGroupPage();
    }


}
