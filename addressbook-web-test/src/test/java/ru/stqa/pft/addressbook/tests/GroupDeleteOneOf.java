package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by khomep on 09-Jun-16.
 */
public class GroupDeleteOneOf extends TestBase {
     @Test(enabled = false)
        public void testGroupDeleteOneOf() {
         app.group().groupPage();
         if (! app.group().isThereAGroup()) {
             app.group().create(new GroupData("test123423434", "test21", "test31"));
         }
                //int before = app.group().getGroupCount();
         List<GroupData> before = app.group().list();
         app.group().selectOneGroupFromAllGroup(before.size() -1);
         app.group().submitGroupDelete();
         app.group().getNavigationHelper().returntoGroupPage();
         List<GroupData> after = app.group().list();
                    // int after = app.group().getGroupCount();
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
