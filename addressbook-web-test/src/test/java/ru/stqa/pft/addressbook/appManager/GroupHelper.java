package ru.stqa.pft.addressbook.appManager;

import com.sun.javafx.binding.ExpressionHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

    public  void gotoGroupPage() {

        // look if "Group" tag present via analyze element into FireFox  &&
        // look if Element within h1 == Group &&
        // elememt #2= "new"
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
        //if ( ! isElementPresent(By.tagName("h1"))
        //            || ! wd.findElement(By.tagName("h1")).getText().equals("Groups")
        //            || ! isElementPresent(By.name("new"))) {
              return;
            }  // else
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

    public void createGroup(GroupData group) {
        initGroupCreation();
        //fillInGroupForm(new GroupData("test123423434", "test21", "test31"));
        fillInGroupForm(group);
        submitGroupCreation();
        getNavigationHelper().returntoGroupPage();
    }

    public boolean isThereAGroup() {

        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        // next takes one element of array = ArrayList
        /// tag = "span" && tag = "group"
        // <span = class ="group" >, this is one element definition
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element :elements) {
            String name = element.getText();  // name of groups
            String id   = element.findElement(By.tagName("input")).getAttribute("value");
            GroupData group = new GroupData(id,name,null, null);
            //app.getGroupHelper().createGroup(new GroupData("tesNotNull",null,null));
            // add element to group
            groups.add(group);
        }
        return  groups;
    }
}
