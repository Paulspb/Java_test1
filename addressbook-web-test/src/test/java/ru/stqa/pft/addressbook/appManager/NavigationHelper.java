package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by khomep on 08-Jun-16.
 */
public class NavigationHelper extends HelperBase {
    // private FirefoxDriver wd; is child

    public NavigationHelper(WebDriver wd) {
        super(wd);
        //this.wd = wd;
    }

    public void returntoGroupPage()    {
        // table present only in this page, it has ID
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        // click(By.linkText("group page"));
        // wd.findElement(By.linkText("group page")).click();
        //click(By.linkText("groups"));
        click(By.linkText("group page"));
    }

    //protected void gotoGroupPage2() {
    //public void gotoGroupPage2() {
    //    wd.findElement(By.name("user")).click();
    // }
}
