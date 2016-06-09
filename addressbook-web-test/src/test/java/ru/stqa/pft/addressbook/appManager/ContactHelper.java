package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.Emails123;
import ru.stqa.pft.addressbook.model.LastNameNick2;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

/**
 * Created by khomep on 09-Jun-16.
 */
public class ContactHelper extends HelperBase {
    // no after super.wd;   private FirefoxDriver wd;

    public ContactHelper(FirefoxDriver wd) {
        //this.wd = wd;
        super(wd);
    }

    public void fillAddNamePad() {
        click(By.id("content"));
        //wd.findElement(By.id("content")).click();
        click(By.linkText("add new"));
        //wd.findElement(By.linkText("add new")).click();
    }

    public void fillFirstNameMiddleName(NameFirstMiddle nameFirstMiddle) {

        type(By.name("firstname"),nameFirstMiddle.getFirstname());
        //wd.findElement(By.name("firstname")).click();
        //wd.findElement(By.name("firstname")).clear();
        //wd.findElement(By.name("firstname")).sendKeys(nameFirstMiddle.getFirstname());
        type(By.name("middlename"),nameFirstMiddle.getMiddleName());
        //wd.findElement(By.name("middlename")).click();
        //wd.findElement(By.name("middlename")).clear();
        //wd.findElement(By.name("middlename")).sendKeys(nameFirstMiddle.getMiddleName());
    }

    public void fillLastNameNickName(LastNameNick2 lastNameNick2) {
        type(By.name("lastname"),lastNameNick2.getLastname());
        type(By.name("nickname"),lastNameNick2.getNickname());
        }

    public void fillTitle(String title) {
        type(By.name("title"),title);
        //wd.findElement(By.name("title")).click();
        //wd.findElement(By.name("title")).clear();
        //wd.findElement(By.name("title")).sendKeys(title);
    }

    public void fillCompany(String companyName) {
        type(By.name("company"),companyName);
        // wd.findElement(By.name("company")).sendKeys(companyName);
    }

    public void fillAddress1(String address1) {
        type(By.name("address"),address1);
        // wd.findElement(By.name("address")).sendKeys(address1);
    }

    public void fillHomeMobileTlf(String hometlf, String mobiletlf) {
        type(By.name("home"),hometlf);
        //wd.findElement(By.name("home")).sendKeys(hometlf);
        type(By.name("company"),mobiletlf);
        // wd.findElement(By.name("mobile")).sendKeys(mobiletlf);
    }

    public void fillFaxWorkTlf() {
        type(By.name("work"),"8788");
        type(By.name("fax"),"32455");
        //wd.findElement(By.name("work")).click();
        //wd.findElement(By.name("work")).sendKeys("\\9");
        //wd.findElement(By.name("fax")).click();
        //wd.findElement(By.name("fax")).sendKeys("\\9");
    }

    public void fillEmail(Emails123 emails123) {
        type(By.name("email"),emails123.getEmail1());
        // wd.findElement(By.name("email")).sendKeys(emails123.getEmail1());
        type(By.name("email2"),emails123.getEmail2());
        // wd.findElement(By.name("email2")).sendKeys(emails123.getEmail2());
        type(By.name("email3"),emails123.getEmail3());
        //wd.findElement(By.name("email3")).click();
        //wd.findElement(By.name("email3")).sendKeys(emails123.getEmail3());
    }

    public void fillHomePage() {
        type(By.name("homepage"),"www.kultura.tv");
        // wd.findElement(By.name("homepage")).sendKeys("www.kultura.tv");
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
        type(By.name("byear"),"1799");
        // wd.findElement(By.name("byear")).sendKeys("1799");
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
        type(By.name("address2"),"Spb, Puchkinskij dom");
         //wd.findElement(By.name("address2")).sendKeys("Spb, Puchkinskij dom");
    }

    public void fillPhone2() {
        type(By.name("address2"),"Spb, fontanka,6");
        type(By.name("notes"),"...notes...");
        // wd.findElement(By.name("phone2")).sendKeys("Spb Fontanka,6");
        //wd.findElement(By.name("notes")).click();
        //wd.findElement(By.name("notes")).clear();
    }
}
