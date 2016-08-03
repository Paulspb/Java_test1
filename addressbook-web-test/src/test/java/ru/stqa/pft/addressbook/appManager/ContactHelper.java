package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.*;
//import ru.stqa.pft.addressbook.model.Emails123;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static ru.stqa.pft.addressbook.appManager.ApplicationManager.properties;

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
    //public void fillFirstNameMiddleName(NameFirstMiddle nameFirstMiddle, boolean creation) {
    public void fillFirstLastNames(NameFirstMiddle nameFirstMiddle, boolean creation) {
        ///goToAddNamePad();
        type(By.name("firstname"),nameFirstMiddle.getFirstname());
                    //wd.findElement(By.name("firstname")).click();
                    //wd.findElement(By.name("firstname")).clear();
                    //wd.findElement(By.name("firstname")).sendKeys(nameFirstMiddle.getFirstname());
                    //type(By.name("middlename"),nameFirstMiddle.getMiddleName());
        type(By.name("lastname"),nameFirstMiddle.getLastName());


            type(By.name("work"),nameFirstMiddle.getWork());
            //type(By.name("fax"),nameFirstMiddle.g`);


        //lesson 6.1, lesson 7.4
        //attach(By.name("photo"),nameFirstMiddle.getPhoto());
            // take group from GroupName
        if (creation) {
            if (nameFirstMiddle.getGroups().size() > 0 ) {
                        //lesson 7.6
                Assert.assertTrue(nameFirstMiddle.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group")))
                        .selectByVisibleText(nameFirstMiddle.getGroups().
                                iterator().next().getName());
                        //.selectByVisibleText(nameFirstMiddle.getGroup());
                //lesson 6.1, lesson 7.4
                attach(By.name("photo"),nameFirstMiddle.getPhoto());
            }
                    //if (isElementPresent(wd.findElement(By.name("new_group")).selectByVisibleText(nameFirstMiddle.getGroup()) {
                    //}

        } else {
                // test modify, not creating
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
                // take element from predefined values
                // //if (isElementPresent(By.name("new_group"))) {
                    //new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(nameFirstMiddle.getGroup());
                //  }
        ///createRestFields();
    }

    public void fillLastNameNickName(LastNameNick2 lastNameNick2) {
        type(By.name("nickname"),lastNameNick2.getNickname());
        }

    public void fillTitle(String title) {
        type(By.name("title"),title);
    }

    public void fillCompany(String companyName) {
        type(By.name("company"),companyName);
    }

    public void fillAddress1(String address1) {
        type(By.name("address"),address1);
    }

    public void fillHomeMobileTlf(String hometlf, String mobiletlf) {
        type(By.name("home"),hometlf);
        type(By.name("mobile"),mobiletlf);
    }

    public void fillFaxWorkTlf(String workTlf, String fax) {
        type(By.name("work"),workTlf);
        type(By.name("fax"),fax);
    }

//    public void fillEmail(Emails123 emails123) {
     public void fillEmail(String email1, String email2, String email3) {
        //type(By.name("email"),emails123.getEmail1());
        type(By.name("email"),email1);
        type(By.name("email2"),email2);
        type(By.name("email3"),email3);
    }


    public void fillHomePage() {
        type(By.name("homepage"),"www.kultura.tv");
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
    }

    public void fillPhone2() {
        type(By.name("address2"),"Spb, fontanka,6");
        type(By.name("notes"),"...notes...");
    }

    public void createContactName(LastNameNick2 lastNameNick2) {
    //    fillAddNamePad();
    //    //app.contact().fillFirstNameMiddleName(new NameFirstMiddle("Alexey", "Sergeevich"));
    //    //fillFirstNameMiddleName(nameFirstMiddle, true);
    //    //app.contact().fillLastNameNickName(new LastNameNick2("delete", "delete-Puschkin"));
        fillLastNameNickName(lastNameNick2);
    //     submitContact();
    }

    public void submitContact() {
        wd.findElement(By.name("notes")).sendKeys(".");
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }


    //public void create(NameFirstMiddle name, boolean b) {
    public void create(NameFirstMiddle name) {
        goToAddNamePad();
        fillFirstLastNames(name,true);
        fillAddress1(properties.getProperty("web.contactAddress1"));
        fillEmail(properties.getProperty("web.contactEmail1"),
                properties.getProperty("web.contactEmail2"),
                properties.getProperty("web.contactEmail3") );

        fillHomeMobileTlf(properties.getProperty("web.contactHomeTel"),
                properties.getProperty("web.contactMobileTel") );

        fillFaxWorkTlf(properties.getProperty("web.contactWorkTel"),
                properties.getProperty("web.contactFax"));


        //fillAddress1("Pskovskaya obl.");
        //fillEmail("alexander0.puchkin@gmail.com", "apuchkin@kultura.tv", "ACPushkin@kultura.tv");
        //fillHomeMobileTlf("8 11235 3214", "8 000 921 921 921");
        //fillFaxWorkTlf("3333","4444");
        submitContact();
        contactCache = null;
        goToContact();
    }

    //public void createRestFields() {
    //    createContactName(new LastNameNick2("Push"));
    //    fillTitle("mr.");
    //  fillCompany("ooo Boldino");
    //fillHomePage();
    //    fillBithday();
    //  fillContent();
    //fillAddress2();
    //fillPhone2();
    //}

    public NameFirstMiddle infoFromEditForm (NameFirstMiddle contact) {
        selectContactById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName  = wd.findElement(By.name("lastname")).getAttribute("value");
        String homePhone = wd.findElement(By.name("home")).getAttribute("value");
        String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
        String workPhone = wd.findElement(By.name("work")).getAttribute("value");
        goToContact();
            System.out.println("return infoForm.. -> " +
                    new NameFirstMiddle().withId(contact.getId()).
                withFirstname(firstName).
                withLastname(lastName).withHomePhone(homePhone).
                withMobilePhone(mobilePhone).withWorkPhone(workPhone));

        return new NameFirstMiddle().withId(contact.getId()).withFirstname(firstName).
            withLastname(lastName).withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone);
    }

    public NameFirstMiddle emailsFromEditForm (NameFirstMiddle contact) {
        selectContactById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName  = wd.findElement(By.name("lastname")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        goToContact();
            //System.out.println("return infoForm.. -> " +
            //        new NameFirstMiddle().withId(contact.getId()).
            //                withFirstname(firstName).
            //                withLastname(lastName).withEmail1(email1).
            //                withEmail2(email2).withEmail3(email3));

        return new NameFirstMiddle().withId(contact.getId()).withFirstname(firstName).
                withLastname(lastName).
                withEmail1(email1).
                withEmail2(email2).withEmail3(email3);
    }

    public NameFirstMiddle fullAddressFromEditForm (NameFirstMiddle contact) {
        selectContactById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName  = wd.findElement(By.name("lastname")).getAttribute("value");
        String address1 = wd.findElement(By.name("address")).getText();
        goToContact();
        //System.out.println("return HomeAddress.. -> " +
        //        new NameFirstMiddle().withId(contact.getId()).
        //                withFirstname(firstName).
        //                withLastname(lastName).withFullAddress(address1));

        return new NameFirstMiddle().withId(contact.getId()).withFirstname(firstName).
                withLastname(lastName).
                withFullAddress(address1);
    }

    //public void modify(List<NameFirstMiddle> before, NameFirstMiddle contact) {
    public void modify( NameFirstMiddle contact) {
                //initContactModification( before.size() + 1 );
        selectContactById(contact.getId());
        fillFirstLastNames(contact,false);
        submitUpdate();
        contactCache = null;
                //submitUpdateId(contact.getId());
        goToContact();
    }

    public boolean isThereContactInGroup() {
        boolean inGroup;
        if (isElementPresent(By.name("selected[]"))) {
            inGroup = true;
        } else {
            inGroup = false;
        }
        submitRemoveFrom();
        goToContact();
        selectWholeGroups();
        return (inGroup);

        //return (isElementPresent(By.name("selected[]")) &&
          //      ! wd.findElement(By.tagName("strong")).getText().equals("Select all")    );

        //return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

        //if (isElementPresent(By.tagName("h1"))
        //        && wd.findElement(By.tagName("h1")).getText().equals("Groups")
        //        && isElementPresent(By.name("new"))) {

    }

    public void  addOneGroup( NameFirstMiddle contact,Groups groups) {
        String newGroup  = "xxx";
        newGroup = selectOneGroup(contact,groups,"add");
        if (newGroup == "xxx") {
            System.out.println("!!! all groups is already added to contact : 'first name' =" + contact.getFirstname());
        } else {
            selectOneGroupForAdding(contact.getId(),newGroup);
            contactCache = null;
        }
    }


    public void  selectOneGroupForAdding(int id, String newGroup) {
        if (isElementPresent(By.xpath("//select[@name='to_group']"))) {
            new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(newGroup);
                    //reset 'group'-select  to 'all'
            new Select(wd.findElement(By.name("group"))).selectByVisibleText("[all]");
        }

        if (isElementPresent(By.name("selected[]"))) {
            wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
        }

    }
    //if (isElementPresent(By.xpath("//div[@class='right']/select//option["+r+"]"))) {
    //wd.findElement(By.xpath("//div[@class='right']/select//option["+r+"]")).click();

    public void submitAddInGroup() {
        wd.findElement(By.name("add")).click();
    }

    public boolean isThereContactReadyToAdd() {
        boolean inGroup;
        if (isElementPresent(By.name("selected[]"))) {
            inGroup = true;
        } else {
            inGroup = false;
        }
        submitAddInGroup();
        goToContact();
        return (inGroup);
    }

    private String  selectOneGroup(NameFirstMiddle contact,Groups groups, String movement) {
        List<GroupData> groupsTemp    = new ArrayList<>();
        String newGroup  = "xxx";
        int choice = 2;
            // movement = 'add' or 'remove'
            // fill-in temporary groups  marked '11'
        for (GroupData oneGroup: groups) {
            groupsTemp.add(new GroupData().withName(oneGroup.getName()).withId(11));
        }

        // fill-in temporary group element with marker '0' in case if element exist in contact
        for (GroupData oneGroupInContact: contact.getGroups()) {
            for (GroupData oneGroup: groupsTemp ) {
                if ( oneGroup.getId() != 0
                        && !oneGroup.getName().equals(oneGroupInContact.getName())) {
                    //notAddGroup2 = oneGroup;
                    continue;
                    //notAddGroup.add(new GroupData());
                } else{
                    if (groupsTemp.size() > 0 ) {
                        // marking this group as present in contact
                        oneGroup.withId(0);
                    }
                }
            }
        }

            // read first group not marked as '0' for add (still not used in contact)
            // read first group not marked as '11' for remove (still not used in contact)
        if (movement == "add")    {choice = 0; }
        if (movement == "remove") {choice = 11; }

        for (GroupData oneGroup: groupsTemp) {
            if ( oneGroup.getId() != choice ) {
                System.out.println("*** new group for adding :  " + oneGroup.getName());
                newGroup = oneGroup.getName();
                break;
            }
        }

        return newGroup;
    }


    public void  deleteFromGroup( NameFirstMiddle contact,Groups groups) {

        String oldGroup = "yyy";
        oldGroup = selectOneGroup(contact,groups,"remove");

        if (oldGroup == "yyy") {
                System.out.println("!!! all groups is already removed from contact : 'first name' =" + contact.getFirstname());
        } else {
            selectOneGroupForDeletion(contact.getId(),oldGroup);
            contactCache = null;
        }
    }

    public void  selectOneGroupForDeletion(int id,String oldGroup) {

        if (isElementPresent(By.xpath("//select[@name='group']"))) {
                //reset 'group'-select  to 'all'
            new Select(wd.findElement(By.name("group"))).selectByVisibleText(oldGroup);
        } else {
            System.out.println("!!! no suitable group for selection found out on selection visibility fields!!!!!");
        }

        if (isElementPresent(By.name("selected[]"))) {
            wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
        }
    }
    //or 1
    //WebElement checkbox = wd.findElement(By.cssSelector((String.
    //        format("input[value='%s']", index))));

    /// it was option =khomep 20
    //if (!wd.findElement(By.xpath("//form[@id='right']/select//option[3]")).isSelected()) {
    //if (isElementPresent(By.name("//form[@id='right']/select//option[3]"))) {


    public void selectWholeGroups() {
        if (isElementPresent(By.xpath("//select[@name='group']"))) {
            new Select(wd.findElement(By.name("group"))).selectByVisibleText("[all]");
        }
    }


    public void submitRemoveFrom() {
        wd.findElement(By.name("remove")).click();
    }

    public void removeOneGroup(NameFirstMiddle nameFirstMiddle, boolean creation) {
        ///goToAddNamePad();
        type(By.name("firstname"),nameFirstMiddle.getFirstname());
        type(By.name("lastname"),nameFirstMiddle.getLastName());
        type(By.name("work"),nameFirstMiddle.getWork());



        //lesson 6.1, lesson 7.4
        //attach(By.name("photo"),nameFirstMiddle.getPhoto());
        // take group from GroupName
        if (creation) {
            if (nameFirstMiddle.getGroups().size() > 0 ) {
                //lesson 7.6
                Assert.assertTrue(nameFirstMiddle.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group")))
                        .selectByVisibleText(nameFirstMiddle.getGroups().
                                iterator().next().getName());
                //.selectByVisibleText(nameFirstMiddle.getGroup());
                //lesson 6.1, lesson 7.4
                attach(By.name("photo"),nameFirstMiddle.getPhoto());
            }
            //if (isElementPresent(wd.findElement(By.name("new_group")).selectByVisibleText(nameFirstMiddle.getGroup()) {
            //}

        } else {
            // test modify, not creating
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        // take element from predefined values
        // //if (isElementPresent(By.name("new_group"))) {
        //new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(nameFirstMiddle.getGroup());
        //  }
        ///createRestFields();
    }


    public void selectContactById(int id) {
            // click at left
        wd.findElement(By.cssSelector("input[value='"+id +"']")).click();
            // click on Edit
        wd.findElement(By.cssSelector("a[href='edit.php?id="+id+"']")).click();
            //or 1
        //WebElement checkbox = wd.findElement(By.cssSelector((String.
        //        format("input[value='%s']", index))));
            //then 1
        //WebElement row = checkbox.findElement(By.xpath("./../.."));
        //List<WebElement> cells = row.findElements(By.tagName("td")));
        //cells.get(7).findElement(By.tagName("a")).click();
            //or 2
        //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a",id))).click();
            //or 3
        //wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a",id))).click();

    }

    public void submitUpdate() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    //public void submitUpdateId(int id) {
        //-no id - wd.findElement(By.xpath(".//td[8]")).click();
        /// it was before wd.findElement(By.cssSelector("a[href='edit.php?id="+id+"']")).click();
        ///fillCompany("updated-2");
        //wd.findElement(By.name("Update")).click();
        //-no-click(By.name("Update"));
    //    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    //}



    public void initContactModification(int index) {
        //click(By.xpath("//div[@id='content']/form/span[2]/input"));
        click(By.xpath("//table[@id='maintable']/tbody/tr[" + index +"]/td[8]/a/img"));
        //or
        //WebElement checkbox = wd.findElement(By.cssSelector((String.
        //        format("input[value='%s']", index))));
        //then
        //WebElement row = checkbox.findElement(By.xpath("./../.."));
        //<WebListElement> cells = row.findElements(By.tagName("td")));
        //cells.get(7).findElement(By.tagName("a")).click();
        //or
        //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a",index))).click();
        //wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a",index))).click();


    }


    public void delete(NameFirstMiddle contact) {
                //initContactModification(before.size() + 1);  +1 !!!!!
        selectContactById(contact.getId());
        submitDelete();
        contactCache = null;
        goToContact();
    }
    public void submitDelete() {
                //click(By.xpath("//div[@id='content']/form[1]/input[22]"));
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }
    public void submitDeleteId() {
            // works !!!! no needs, clicked on edit into selectContactById(contact.getId());
        ///wd.findElement(By.cssSelector("a[href='edit.php?id="+id+"']")).click();
        //!!!!!!!!!!!!!!!!!!!  work
        //wd.findElement(By.xpath("//tr[@name='entry']//td[8]")).click();
        //-no-wd.findElement(By.cssSelector("//a[href='edit.php?id="+id+"']")).click();
        //-no- wd.findElement(By.xpath("a[href='edit.php?id="+id+"']")).click();

        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<NameFirstMiddle> list() {
        List<NameFirstMiddle> contacts    = new ArrayList<>();
            // next takes one element of array = ArrayList
            /// tag = "span" && tag = "group"
            // was <span  class ="group" >, this is one element definition
            // now <td    class ="center"
            // empty element List<WebElement> elementNotodds = wd.findElements(By.cssSelector("td.center")); // +1
        List<WebElement> elements   = wd.findElements(By.xpath("//tr[@name='entry']"));

        for (WebElement element :elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String lastName  = element.findElement(By.xpath(".//td[2]")).getText();
            String firstName = element.findElement(By.xpath(".//td[3]")).getText();
                    //NameFirstMiddle contact = new NameFirstMiddle().withId(id).
                    //withFirstname(firstName).withLastname(lastName);

                //System.out.println("contact=" + contact);
                    // add element to contact
            contacts.add(new NameFirstMiddle().withId(id).
                    withFirstname(firstName).withLastname(lastName));
        }
        return contacts;
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache  != null) {
            return new Contacts(contactCache);
        }

        contactCache  = new Contacts();
        List<WebElement> elements   = wd.findElements(By.xpath("//tr[@name='entry']"));

        for (WebElement element :elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String lastName   = element.findElement(By.xpath(".//td[2]")).getText();
            String firstName  = element.findElement(By.xpath(".//td[3]")).getText();
            String allPhone   = element.findElement(By.xpath(".//td[6]")).getText();
            String allEmails  = element.findElement(By.xpath(".//td[5]")).getText();
            String fullAddress = element.findElement(By.xpath(".//td[4]")).getText();
                //System.out.println("allEmails "+id+"---"+allEmails);
                                                        // regular vyragenie via .split()
                //String[] phones =element.findElement(By.xpath(".//td[6]")).getText().split("\n");
                //System.out.println("phones ---"+phones[0] + "-"+phones[2]);
            contactCache.add(new NameFirstMiddle().withId(id).
                    withFirstname(firstName).withLastname(lastName).
                    withAllPhones(allPhone).withAllEmails(allEmails).withFullAddress(fullAddress));
            //withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
        }
        return contactCache;
    }

    public void viewContactById(int id) {
        // click at left
        wd.findElement(By.cssSelector("input[value='"+id +"']")).click();
        // click on Man
        wd.findElement(By.cssSelector("a[href='view.php?id="+id+"']")).click();

    }

    public NameFirstMiddle readContactFromEditForm (NameFirstMiddle contact) {
        selectContactById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName  = wd.findElement(By.name("lastname")).getAttribute("value");
        String address1 = wd.findElement(By.name("address")).getText();
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String homePhone = wd.findElement(By.name("home")).getAttribute("value");
        String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
        String workPhone = wd.findElement(By.name("work")).getAttribute("value");
        goToContact();

        return new NameFirstMiddle().withId(contact.getId()).withFirstname(firstName).
                withLastname(lastName).
                withFullAddress(address1).withAllPhones("").
                withEmail1(email1).withEmail2(email2).withEmail3(email3).withAllEmails("").
                withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone);

    }

    public NameFirstMiddle viewMan( NameFirstMiddle contact) {
        //"abc".replaceAll("ab*c", "");
        viewContactById(contact.getId());
        String firstName = wd.findElement(By.xpath("//div[@id='content']/b[1]")).getText();
        String viewForm  = wd.findElement(By.xpath("//div[@id='content']")).getText().replaceAll("\\n","");
        String email1    = wd.findElement(By.xpath("//div[@id='content']/a[1]")).getText();
        String email2    = wd.findElement(By.xpath("//div[@id='content']/a[2]")).getText();
        String email3    = wd.findElement(By.xpath("//div[@id='content']/a[4]")).getText();
        String splitViewForm[] = viewForm.split(email3);
        String splitFullAddressEditForm[] = contact.getFullAddress().split("\\n");
        String splitTlfs[]                = splitViewForm[0].split("H:");
        String splitFullAddressViewForm[] = splitTlfs[0].split(splitFullAddressEditForm[0]);
        String splitHome[]                = splitTlfs[1].split("M:");
            //System.out.println("contact.splitHome[0] = " + splitHome[0]);
                //System.out.println("contact.splitHome[1] = " + splitHome[1]);
        String splitMobile[]              = splitHome[1].split("W:");
            //System.out.println("contact.splitwork[0] = " + splitMobile[0]);// mobile
                //System.out.println("contact.splitWork[1] = " + splitMobile[1]);
        String splitWork[]                = splitMobile[1].split("F:");
            //System.out.println("contact.splitMobile[0] = " + splitWork[0]); //work
                //System.out.println("contact.splitMobile[1] = " + splitWork[1]);
        String splitFax[]                 = splitWork[1].split(email1);
            //System.out.println("contact.splitFax[0] = " + splitFax[0]);
                //System.out.println("contact.splitFax[1] = " + splitFax[1]);
        //for (String tmp : viewForm.split("<\\s*br\\s*(/?)\\s*>|\\n")) {
        //    //System.out.println("xxx____" + tmp + "____xxx__");

        //}



        return new NameFirstMiddle().withId(contact.getId()).withFirstname(firstName).withLastname("").
                withAllPhones(splitHome[0]+splitWork[0]+splitMobile[0]).
                withMobilePhone("").withWorkPhone("").withHomePhone("").
                withEmail1(email1).withEmail2(email2).withEmail3(email3).withAllEmails("").
                withFullAddress(splitFullAddressEditForm[0]+splitFullAddressViewForm[1]);

    }

}
