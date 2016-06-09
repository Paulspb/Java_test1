package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.Emails123;
import ru.stqa.pft.addressbook.model.LastNameNick2;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.concurrent.TimeUnit;

/**
 * Created by khomep on 08-Jun-16.
 */
public class ApplicationManager  {

    FirefoxDriver wd;

    // private final GroupHelper groupHelper = new GroupHelper();
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;



    public void initTests() {
        // .....goes method 'setup'
        // groupHelper.wd = new FirefoxDriver();
        wd = new FirefoxDriver();
        // init attribute of object = WD
        // groupHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // groupHelper.wd.get("http://localhost/addressbook/group.php");
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper    = new SessionHelper(wd);
        sessionHelper.loginAddressbook("admin", "secret");
        //groupHelper.getNavigationHelper().gotoGroupPage2();

    }

    public void fillAddNamePad() {
        wd.findElement(By.id("content")).click();
        wd.findElement(By.linkText("add new")).click();
    }

    public void fillFirstNameMiddleName(NameFirstMiddle nameFirstMiddle) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(nameFirstMiddle.getFirstname());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(nameFirstMiddle.getMiddleName());
    }

    public void fillLastNameNickName(LastNameNick2 lastNameNick2) {
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(lastNameNick2.getLastname());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(lastNameNick2.getNickname());
    }

    public void fillTitle(String title) {
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(title);
    }

    public void fillCompany(String companyName) {
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(companyName);
    }

    public void fillAddress1(String address1) {
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(address1);
    }

    public void fillHomeMobileTlf(String hometlf, String mobiletlf) {
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(hometlf);
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(mobiletlf);
    }

    public void fillFaxWorkTlf() {
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).sendKeys("\\9");
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).sendKeys("\\9");
    }

    public void fillEmail(Emails123 emails123) {
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(emails123.getEmail1());
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(emails123.getEmail2());
        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("email3")).sendKeys(emails123.getEmail3());
    }

    public void fillHomePage() {
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys("www.kultura.tv");
    }

    public void fillBithday() {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[8]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[8]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).click();
        }
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys("1799");
    }

    public void fillContent() {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).click();
        }
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).sendKeys("\\9");
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).click();
        }
    }

    public void fillAddress2() {
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys("Spb, Puchkinskij dom");
    }

    public void fillPhone2() {
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys("Spb Fontanka,6");
        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
    }

    public void submit() {
        wd.findElement(By.name("notes")).sendKeys(".");
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }


    public void afterTests() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
