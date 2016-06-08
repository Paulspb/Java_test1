package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreationTestMethod() {

        gotoGroupCreation();
        initGroupCreation();
        fillInGroupForm(new GroupData("test134", "test21", "test31"));
        submitGroupCreation();
        returntoGroupPage();
    }

}
