package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.Emails123;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.LastNameNick2;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khomep on 09-Jun-16.
 */
public class ContactHelper extends HelperBase {
    // no after super.wd;   private FirefoxDriver wd;

    public ContactHelper(WebDriver wd) {
        //this.wd = wd;
        super(wd);
    }

    public void goToContact() {
        // table present only in this page, it has ID
        if (isElementPresent(By.id("maintable"))) {
            return;
          }  // else
        click(By.linkText("home"));
        //click(By.id("content"));
        //wd.findElement(By.id("content")).click();
        //click(By.linkText("add new"));
        //wd.findElement(By.linkText("add new")).click();
    }
    public void goToAddNamePad() {
        //click(By.id("content"));
        //wd.findElement(By.id("content")).click();
        click(By.linkText("add new"));
        //wd.findElement(By.linkText("add new")).click();
    }
    // boolean = 1 - creation, 0 - modify
    public void fillFirstNameMiddleName(NameFirstMiddle nameFirstMiddle, boolean creation) {

        type(By.name("firstname"),nameFirstMiddle.getFirstname());
        //wd.findElement(By.name("firstname")).click();
        //wd.findElement(By.name("firstname")).clear();
        //wd.findElement(By.name("firstname")).sendKeys(nameFirstMiddle.getFirstname());
        //type(By.name("middlename"),nameFirstMiddle.getMiddleName());
        type(By.name("lastname"),nameFirstMiddle.getLastName());
        // take group from GroupName
        if (creation) {
            //if (isElementPresent(wd.findElement(By.name("new_group")).selectByVisibleText(nameFirstMiddle.getGroup()) {
            //}
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(nameFirstMiddle.getGroup());
        } else {
            // test modify, not creating
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        // take element from predefined values
        // //if (isElementPresent(By.name("new_group"))) {
            //new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(nameFirstMiddle.getGroup());
        //  }
    }

    public void fillLastNameNickName(LastNameNick2 lastNameNick2) {
        //type(By.name("lastname"),lastNameNick2.getLastname());
        //type(By.name("middlename"),lastNameNick2.getMiddleName());
        type(By.name("nickname"),lastNameNick2.getNickname());
        }

    public void fillTitle(String title) {
        type(By.name("title"),title);

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
        wd.findElement(By.name("ayear")).sendKeys("1837");
        // group choice
        //if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).isSelected()) {
        //    wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).click();
        //}
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

    public void submitDelete() {
        //click(By.xpath("//div[@id='content']/form[1]/input[22]"));
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public void initContactModification(int index) {
        //click(By.xpath("//div[@id='content']/form/span[2]/input"));
        click(By.xpath("//table[@id='maintable']/tbody/tr[" + index +"]/td[8]/a/img"));
    }
    //public void initContactModification() {
    //    //click(By.xpath("//div[@id='content']/form/span[2]/input"));
    //    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    //}

    public void submitUpdate() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }


    public void createContactName(LastNameNick2 lastNameNick2) {
    //    fillAddNamePad();
    //    //app.getContactHelper().fillFirstNameMiddleName(new NameFirstMiddle("Alexey", "Sergeevich"));
    //    //fillFirstNameMiddleName(nameFirstMiddle, true);
    //    //app.getContactHelper().fillLastNameNickName(new LastNameNick2("delete", "delete-Puschkin"));
        fillLastNameNickName(lastNameNick2);
    //     submitContact();
    }

    public void submitContact() {
        wd.findElement(By.name("notes")).sendKeys(".");
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public boolean isThereAContact() {
        //return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

        //return isElementPresent(By.name("selected[]"));
        return (isElementPresent(By.name("selected[]")) &&
                ! wd.findElement(By.tagName("strong")).getText().equals("Select all")    );
        //if (isElementPresent(By.tagName("h1"))
        //        && wd.findElement(By.tagName("h1")).getText().equals("Groups")
        //        && isElementPresent(By.name("new"))) {

        }

    public void createSimpleContact(NameFirstMiddle nameFirstMiddle, boolean b) {

        goToAddNamePad();
        fillFirstNameMiddleName(nameFirstMiddle,true);
        fillEmail(new Emails123("alexander0.puchkin@gmail.com", "apuchkin@kultura.tv", "ACPushkin@kultura.tv"));
        submitContact();
        goToContact();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    //public List<GroupData> getContactlist() {
    public List<NameFirstMiddle> getContactlist() {
        List<NameFirstMiddle> contacts    = new ArrayList<>();

        // next takes one element of array = ArrayList
        /// tag = "span" && tag = "group"
        // was <span  class ="group" >, this is one element definition
        // now <td    class ="center"
        // empty element List<WebElement> elementNotodds = wd.findElements(By.cssSelector("td.center")); // +1
        List<WebElement> elementNotodds   = wd.findElements(By.xpath("//tr[@name='entry']"));

        for (WebElement element :elementNotodds) {
            String id = element.findElement(By.tagName("input")).getAttribute("id");
            String lastName  = element.findElement(By.xpath(".//td[2]")).getText();
            String firstName = element.findElement(By.xpath(".//td[3]")).getText();
            NameFirstMiddle contact = new NameFirstMiddle(id,firstName,lastName, null);

            //System.out.println("contact=" + contact);
                    // add element to contact
            contacts.add(contact);
        }

        return contacts;
    }
}
