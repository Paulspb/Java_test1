package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by khomep on 09-Jun-16.
 */
public class GroupDeleteOneOf extends TestBase {
     @Test
        public void testGroupDeleteOneOf() {
         app.getGroupHelper().gotoGroupPage();
         if (! app.getGroupHelper().isThereAGroup()) {
             app.getGroupHelper().createGroup(new GroupData("test123423434", "test21", "test31"));
         }
                //int before = app.getGroupHelper().getGroupCount();
         List<GroupData> before = app.getGroupHelper().getGroupList();
         app.getGroupHelper().selectOneGroupFromAllGroup(before.size() -1);
                //app.getGroupHelper().initGroupModification();
                //app.getGroupHelper().fillInGroupForm(new GroupData("dete11", "del 11", "del 11111"));
         app.getGroupHelper().submitGroupDelete();
         app.getGroupHelper().getNavigationHelper().returntoGroupPage();
         List<GroupData> after = app.getGroupHelper().getGroupList();
                    // int after = app.getGroupHelper().getGroupCount();
                    //Assert.assertEquals(after,before +1);
         Assert.assertEquals(after.size(),before.size() -1);
                    // remove before comparasion
         before.remove(before.size() - 1);
         //for ( int i = 0; i < after.size(); i++) {
         //    Assert.assertEquals(after.get(i),before.get(i));
         //}
         // assertEquals can do so:
         Assert.assertEquals(after,before);

     }
}
