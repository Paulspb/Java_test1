package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by khomep on 09-Jun-16.
 */
public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.group().groupPage();
        //app.getNavigationHelpe().groupPage();
        //if (! app.group().isThereAGroup()) {
        if ( app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("delete"));
        }
    }

    @Test
    public void testGroupModification() {
            //int before = app.group().getGroupCount();
            //List<GroupData> before = app.group().list(); - spisok
        Set<GroupData> before = app.group().all();      // mnogestvo
        GroupData modifiedGroup = before.iterator().next();
        //int index = before.size() -1;
                //GroupData group = new GroupData(before.get(index).getId(),
                //        "test-modification", "updat3331", "updat3331");
        //GroupData group = new GroupData().withId(before.get(index).getId()).
        GroupData group = new GroupData().withId(modifiedGroup.getId()).
                withName("test134").withHeader("updat3331").withFooter("updat3331");

        //app.group().modify(modifiedGroup, group);
        app.group().modify( group);
            //int after = app.group().getGroupCount();
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(),before.size() );
        //Assert.assertEquals(after,before );
        // modify old spicok in two steps
        before.remove(modifiedGroup);
        before.add(group);
        System.out.println("after =" + after);
        System.out.println("before =" +before);
             // ne-uporjado4en - massiv
            // uporjado4en    - spisok
            // spicok -> mnogestvoб BUT HashSet contains only unique names aND remove duplicates names
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
        // no needs after added modifiedGroup
            //anonimous function
        //Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        //before.sort(byId);
        //after.sort(byId);
        Assert.assertEquals(before,after);
    }


}
