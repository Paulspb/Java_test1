package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by khomep on 09-Jun-16.
 */
public class SessionHelper extends HelperBase {

    //private FirefoxDriver wd;  took from base class

    public SessionHelper(WebDriver wd) {
        // this.wd = wd;
        super(wd);
    }
    public void loginAddressbook(String username, String pass) {
        // method , not function due to 'wd' - variable of object by GroupCreationTest type
        // groupHelper.getNavigationHelper().gotoGroupPage2(); no needs, took directly
        type(By.name("user"), username);
        type(By.name("pass"), pass);
        //  wd.findElement(By.name("pass")).click();
        //  wd.findElement(By.name("pass")).clear();
        //  wd.findElement(By.name("pass")).sendKeys(pass);

        click(By.xpath("//form[@id='LoginForm']/input[3]"));
        //wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();

    }
}
