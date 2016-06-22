package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeleteTest extends TestBase  {

    @Test
    public void groupDeleteTest1() {
        app.getGroupHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test123423434", "test21", "test31"));
        }
        //() - it was any of line
        //(before -1 = <last line -1>
        //int groupbefore = app.getGroupHelper().getGroupCount();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectOneGroupFromAllGroup(before.size() -1);
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().gotoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        // int after = app.getGroupHelper().getGroupCount();
        //Assert.assertEquals(after,before +1);
        Assert.assertEquals(after.size(),before.size() -1);
        before.remove(before.size() - 1);
        //for ( int i = 0; i < after.size(); i++) {
        //    Assert.assertEquals(after.get(i),before.get(i));
        //}
        // assertEquals can do so:
        Assert.assertEquals(after,before);
    }


}
