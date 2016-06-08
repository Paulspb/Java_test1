package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by khomep on 08-Jun-16.
 */
public class GroupHelper {
    private FirefoxDriver wd;

    private final NavigationHelper navigationHelper;

    public GroupHelper(FirefoxDriver wd) {
        this.wd = wd;
        navigationHelper = new NavigationHelper(wd);
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public  void gotoGroupCreation() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void deleteSelectedGroup() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[5]")).click();
    }

    public void selectOneGroupFromAllGroup() {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/span[2]/input")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/span[2]/input")).click();
        }
    }

    public void fillInGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
