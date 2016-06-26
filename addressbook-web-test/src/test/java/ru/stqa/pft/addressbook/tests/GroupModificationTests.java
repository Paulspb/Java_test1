package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by khomep on 09-Jun-16.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test123423434", "test21", "test31"));
        }
        app.getGroupHelper().gotoGroupPage();
        //int before = app.getGroupHelper().getGroupCount();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectOneGroupFromAllGroup(before.size() -1);
        app.getGroupHelper().initGroupModification();
        // one line instead of 2
        //                               take id from last element
        GroupData group = new GroupData(before.get(before.size()-1).getId(),
                "test-modification", "updat3331", "updat3331");
        app.getGroupHelper().fillInGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().getNavigationHelper().returntoGroupPage();
        //int after = app.getGroupHelper().getGroupCount();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size() );
        //Assert.assertEquals(after,before );
        // modify old spicok in two steps
        before.remove(before.size() -1);
        before.add(group);
        System.out.println("after =" + after);
        System.out.println("before =" +before);
             // ne-uporjado4en - massiv
            // uporjado4en    - spisok
            // spicok -> mnogestvoб BUT HashSet contains only unique names aND remove duplicates names
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
            //anonimous function
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}
