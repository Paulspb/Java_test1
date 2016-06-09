package ru.stqa.pft.addressbook.appManager;

import com.sun.javafx.binding.ExpressionHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by khomep on 08-Jun-16.
 */
public class GroupHelper extends HelperBase {

    private NavigationHelper navigationHelper;

    public GroupHelper(FirefoxDriver wd) {
        super(wd);
        navigationHelper = new NavigationHelper(wd);
    }

    public void submitGroupCreation()    {
        click(By.name("submit"));
    }

    public void initGroupCreation()    {
        click(By.name("new"));
    }

    public  void gotoGroupCreation() {
        click(By.linkText("groups"));
    }

    public void deleteSelectedGroup() {
        click(By.xpath("//div[@id='content']/form/input[5]"));
    }

    public void selectOneGroupFromAllGroup() {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/span[2]/input")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/span[2]/input"));
        }
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
}
