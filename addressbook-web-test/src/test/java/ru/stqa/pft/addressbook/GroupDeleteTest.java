package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

import org.openqa.selenium.*;


public class GroupDeleteTest extends TestBase  {


    @Test
    public void groupDeleteTest1() {

        gotoGroupCreation();
        selectOneGroupFromAllGroup();
        deleteSelectedGroup();
        gotoGroupCreation();
    }


}
