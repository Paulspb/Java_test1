package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

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
        Set<GroupData> before = app.group().all();
            //take from mnovestvo iterator, then next
        GroupData deletedGroup = before.iterator().next();
            // as substitute on deletedGroup int index = before.size() -1;
                // needs to delete whole element with Id
                //it was : app.group().delete(index);, now:
        app.group().delete(deletedGroup);
        Set<GroupData> after = app.group().all();
        // int after = app.group().getGroupCount();
        //Assert.assertEquals(after,before +1);
        Assert.assertEquals(after.size(),before.size()-1);
        // by index from mnovestvo no chance to delete
            //before.remove(index);
        before.remove(deletedGroup);
                //for ( int i = 0; i < after.size(); i++) {
                //    Assert.assertEquals(after.get(i),before.get(i));
                //}
            // assertEquals can do so:
        Assert.assertEquals(after,before);
    }




}
