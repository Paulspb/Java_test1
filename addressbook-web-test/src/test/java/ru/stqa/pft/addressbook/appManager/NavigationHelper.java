package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by khomep on 08-Jun-16.
 */
public class NavigationHelper {
    // !!!!!!! need???FirefoxDriver wd;
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void returntoGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    //protected void gotoGroupPage2() {
    public void gotoGroupPage2() {
        wd.findElement(By.name("user")).click();
    }
}
