package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreationTestMethod() {
            //app.group().gotoGroupPage2();
            //app.getNavigationHelper()
        app.group().groupPage();
        List<GroupData> before = app.group().list();
            //int before1 = app.group().getGroupCount();
        GroupData group = new GroupData("test134", "test21", "test31");
        app.group().create(group);
            // placed into create
            //app.group().initGroupCreation();
            //app.group().fillInGroupForm(new GroupData("test123423434", "test21", "test31"));
            //app.group().submitGroupCreation();
            //app.group().getNavigationHelper().returntoGroupPage();
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(),before.size() +1);

        // find max ID
        int max = 0;
        for (GroupData g : after)  {
            if(g.getId() > max ) {
                max = g.getId();
            }
        }
            //lambda  or function anonimous
        Comparator<? super GroupData> byId = (o1,o2) ->  Integer.compare(o1.getId(),o2.getId());
        int max2 = after.stream().max((o1,o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
            //    Comparator<? super GroupData> byId = new Comparator<GroupData>() {
            //    @Override
            //    public int compare(GroupData o1, GroupData o2) {
            //        return Integer.compare(o1.getId(),o2.getId());
            //    }
            //};
                //int max1 = after.stream().max(byId).get().getId();
        group.setId(max2);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

        Comparator<? super GroupData> byId2 = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId2);
        after.sort(byId2);
            System.out.println("before2 - " + before);
            System.out.println("after2 - " + after);
             //comp. not mnogestvo, but spisok
        Assert.assertEquals(before,after);
    }

    @Test(enabled = false)
    public void groupCreationTestMethodNull() {
            //app.group().gotoGroupPage2();
            //app.getNavigationHelper()
        app.group().groupPage();
            // list of elements from Group
        List<GroupData> before = app.group().list();
            // counter (not the list per elements) of group
            //int before = app.group().getGroupCount();
        app.group().create(new GroupData("testGroupNull",null,null));
            // placed into create
            //app.group().initGroupCreation();
            //app.group().fillInGroupForm(new GroupData("testNotNull", null,null));
            //app.group().submitGroupCreation();
            //app.group().getNavigationHelper().returntoGroupPage();
        List<GroupData> after = app.group().list();
            // int after = app.group().getGroupCount();
            //Assert.assertEquals(after,before +1);
        Assert.assertEquals(after.size(),before.size() +1);
        ///System.out.println("after222 - " + after);
    }

}
