package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeleteTest extends TestBase  {

    @Test
    public void groupDeleteTest1() {

        app.getGroupHelper().gotoGroupCreation();
        app.getGroupHelper().selectOneGroupFromAllGroup();
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().gotoGroupCreation();
    }


}