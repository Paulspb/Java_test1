import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.Emails123;
import ru.stqa.pft.addressbook.LastNameNick2;
import ru.stqa.pft.addressbook.NameFirstMiddle;

public class NameCreationTestPuchkin {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        loginPushkin("admin", "secret");
    }

    private void loginPushkin(String username, String userpass) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(userpass);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    @Test
    public void nameCreationTestPushkinMethod() {
        fillAddNamePad();
        fillFirstNameMiddleName(new NameFirstMiddle("Alexander", "sergeevich"));
        fillLastNameNickName(new LastNameNick2("Puchkin", "puchkin"));
        fillTitle("mr.");
        fillCompany("ooo Boldino");
        fillAddress1("Pskovskaya obl.");
        fillHomeMobileTlf("8 888 555 3214", "8 921 921 921 921");
        fillFaxWorkTlf();
        fillEmail(new Emails123("alexander0.puchkin@gmail.com", "apuchkin@kultura.tv", "\\9"));
        fillHomePage();
        fillBithday();
        fillContent();
        fillAddress2();
        fillPhone2();
        submit();
    }

    private void fillAddNamePad() {
        wd.findElement(By.id("content")).click();
        wd.findElement(By.linkText("add new")).click();
    }

    private void fillFirstNameMiddleName(NameFirstMiddle nameFirstMiddle) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(nameFirstMiddle.getFirstname());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(nameFirstMiddle.getMiddleName());
    }

    private void fillLastNameNickName(LastNameNick2 lastNameNick2) {
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(lastNameNick2.getLastname());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(lastNameNick2.getNickname());
    }

    private void fillTitle(String title) {
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(title);
    }

    private void fillCompany(String companyName) {
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(companyName);
    }

    private void fillAddress1(String address1) {
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(address1);
    }

    private void fillHomeMobileTlf(String hometlf, String mobiletlf) {
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(hometlf);
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(mobiletlf);
    }

    private void fillFaxWorkTlf() {
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).sendKeys("\\9");
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).sendKeys("\\9");
    }

    private void fillEmail(Emails123 emails123) {
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(emails123.getEmail1());
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(emails123.getEmail2());
        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("email3")).sendKeys(emails123.getEmail3());
    }

    private void fillHomePage() {
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys("www.kultura.tv");
    }

    private void fillBithday() {
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

    private void fillContent() {
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

    private void fillAddress2() {
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys("Spb, Puchkinskij dom");
    }

    private void fillPhone2() {
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys("Spb Fontanka,6");
        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
    }

    private void submit() {
        wd.findElement(By.name("notes")).sendKeys(".");
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
