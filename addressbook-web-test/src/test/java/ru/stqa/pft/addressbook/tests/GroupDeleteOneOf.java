package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

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
            app.getGroupHelper().selectOneGroupFromAllGroup();
            //app.getGroupHelper().initGroupModification();
            //app.getGroupHelper().fillInGroupForm(new GroupData("dete11", "del 11", "del 11111"));
            app.getGroupHelper().submitGroupDelete();
            app.getGroupHelper().getNavigationHelper().returntoGroupPage();

     }
}
