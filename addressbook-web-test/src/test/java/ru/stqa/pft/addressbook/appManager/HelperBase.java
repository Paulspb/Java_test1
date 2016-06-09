package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by khomep on 09-Jun-16.
 */
public class HelperBase {
    protected FirefoxDriver wd;

    public HelperBase(FirefoxDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String tezt) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(tezt);
    }

    //Function was:
    // public static boolean isAlertPresent(FirefoxDriver wd) {
    //Method is...,  it used definition before
    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
