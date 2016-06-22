package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreationTestMethod() {
        //app.getGroupHelper().gotoGroupPage2();
        //app.getNavigationHelper()
        app.getGroupHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupData("test134", "test21", "test31"));
        // placed into createGroup
        //app.getGroupHelper().initGroupCreation();
        //app.getGroupHelper().fillInGroupForm(new GroupData("test123423434", "test21", "test31"));
        //app.getGroupHelper().submitGroupCreation();
        //app.getGroupHelper().getNavigationHelper().returntoGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before +1);
    }

    @Test
    public void groupCreationTestMethodNull() {
        //app.getGroupHelper().gotoGroupPage2();
        //app.getNavigationHelper()
        app.getGroupHelper().gotoGroupPage();
        // list of elements from Group
        List<GroupData> before = app.getGroupHelper().getGroupList();
        // counter (not the list per elements) of group
        //int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupData("testGroupNull",null,null));
        // placed into createGroup
        //app.getGroupHelper().initGroupCreation();
        //app.getGroupHelper().fillInGroupForm(new GroupData("testNotNull", null,null));
        //app.getGroupHelper().submitGroupCreation();
        //app.getGroupHelper().getNavigationHelper().returntoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        // int after = app.getGroupHelper().getGroupCount();
        //Assert.assertEquals(after,before +1);
        Assert.assertEquals(after.size(),before.size() +1);
    }

}
