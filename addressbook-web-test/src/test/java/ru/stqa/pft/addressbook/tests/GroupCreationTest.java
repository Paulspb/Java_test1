package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreationTestMethod() {
        //app.getGroupHelper().gotoGroupPage2();
        //app.getNavigationHelper()
        app.getGroupHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillInGroupForm(new GroupData("test123423434", "test21", "test31"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().getNavigationHelper().returntoGroupPage();
    }

    @Test
    public void groupCreationTestMethodNull() {
        //app.getGroupHelper().gotoGroupPage2();
        //app.getNavigationHelper()
        app.getGroupHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillInGroupForm(new GroupData("testNotNull", null,null));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().getNavigationHelper().returntoGroupPage();
    }

}
