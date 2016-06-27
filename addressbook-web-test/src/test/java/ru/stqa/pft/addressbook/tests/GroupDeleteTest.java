package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeleteTest extends TestBase  {
    @BeforeMethod
    public void ensurePreconditions() {
        app.group().groupPage();
        if ( app.group().list().size() == 0) {
            //app.group().create(new GroupData("test123423434", "test21", "test31"));
            app.group().create(new GroupData().withName("delete"));
            }
    }

    @Test(enabled = true)
    public void groupDeleteTest1() {
            //() - it was any of line
            //(before -1 = <last line -1>
            //int groupbefore = app.group().getGroupCount();
        List<GroupData> before = app.group().list();
        int index = before.size() -1;
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        // int after = app.group().getGroupCount();
        //Assert.assertEquals(after,before +1);
        Assert.assertEquals(after.size(),before.size()-1);
        before.remove(index);
        //for ( int i = 0; i < after.size(); i++) {
        //    Assert.assertEquals(after.get(i),before.get(i));
        //}
        // assertEquals can do so:
        Assert.assertEquals(after,before);
    }




}
