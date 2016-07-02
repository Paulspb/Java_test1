package ru.stqa.pft.addressbook.appManager;

import com.sun.javafx.binding.ExpressionHelperBase;
import jdk.nashorn.internal.runtime.regexp.joni.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by khomep on 08-Jun-16.
 */
public class GroupHelper extends HelperBase {

    private NavigationHelper navigationHelper;

                //public GroupHelper(FirefoxDriver wd) {
    public GroupHelper(WebDriver wd) {
            super(wd);
        navigationHelper = new NavigationHelper(wd);
    }

    public void submitGroupCreation()    {
        click(By.name("submit"));
    }

    public void initGroupCreation()    {
        click(By.name("new"));
    }

    public  void groupPage() {

        // look if "Group" tag present via analyze element into FireFox  &&
        // look if Element within h1 == Group &&
        // elememt #2= "new"
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
            }
            click(By.linkText("groups"));
        }

    public void deleteSelectedGroup() {
        click(By.xpath("//div[@id='content']/form/input[5]"));
    }

    public void selectOneGroupFromAllGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
                //click(By.name("selected[]")); it's any selecting
                // it has recorded:
                // if (!wd.findElement(By.xpath("//div[@id='content']/form/span[2]/input")).isSelected()) {
                //     click(By.xpath("//div[@id='content']/form/span[2]/input"));
        }


    public void selectGroupById(int id) {
            //html
            //<input name="selected[]" value="156" title="Select (test-modification)" type="checkbox">
            //cssSelector
        wd.findElement(By.cssSelector("input[value='"+id +"']")).click();
    }

    public void fillInGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void initGroupMark() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }
    public void submitGroupDelete() {
        click(By.name("delete"));
    }

    public void create(GroupData group) {
        initGroupCreation();
            //fillInGroupForm(new GroupData("test123423434", "test21", "test31"));
        fillInGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        getNavigationHelper().returntoGroupPage();
    }

    //public void modify(int index, GroupData group) {
    public void modify(GroupData group) {
                    //selectOneGroupFromAllGroup(index);
        selectGroupById(group.getId());
        initGroupModification();
                // one line instead of 2
                // take id from last element
        fillInGroupForm(group);
        submitGroupModification();
        groupCache = null;
        getNavigationHelper().returntoGroupPage();
    }

    public void delete(GroupData group) {
                    //selectOneGroupFromAllGroup(index);
        selectGroupById(group.getId());
        deleteSelectedGroup();
            // cache empty
        groupCache = null;
        groupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<GroupData>();
            // next takes one element of array = ArrayList
        //Matcher
            /// tag = "span" && tag = "group"
            // <span = class ="group" >, this is one element definition
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element :elements) {
            String name = element.getText();  // name of groups
            int id   = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            // no more needs GroupData group = new GroupData().withId(id).withName(name);
                    //app.group().create(new GroupData("tesNotNull",null,null));
                    // add element to group
            groups.add(new GroupData().withId(id).withName(name));
        }
        return  groups;
    }

    //public int getGroupCount() {
    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    // keep just has read group to cache
    private Groups groupCache = null;

    // type of return object List -> Set
    //public Set<GroupData> all() {
    // this return object this type = Group
    public Groups all() {
                // verify if cache is empty
                //cache needs to empty in case if it was changing
        if (groupCache != null) {
                //return new / copy of old groupCache
            return new Groups(groupCache);
        }
                    // create mnogestvo -groupdata-
                    //Groups  groups = new Groups();
            //copy of input Groups
        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element :elements) {
            String name = element.getText();  // name of groups
            int id   = Integer.parseInt(element.findElement
                    (By.tagName("input")).getAttribute("value"));
                    //groups.add(new GroupData().withId(id).withName(name));
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
                //  return  groups;
                //put object to mnogestvo
    }

}
