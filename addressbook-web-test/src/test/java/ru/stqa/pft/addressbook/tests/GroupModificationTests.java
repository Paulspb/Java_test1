package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static ru.stqa.pft.addressbook.appManager.ApplicationManager.properties;

/**
 * Created by khomep on 09-Jun-16.
 */
public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.group().groupPage();
        //app.getNavigationHelpe().groupPage();
        //if (! app.group().isThereAGroup()) {
        if ( app.group().all().size() == 0) {
            app.group().create(new GroupData().
                    withName(properties.getProperty("web.groupModifiedName")));
        }
    }

    @Test
    public void testGroupModification() {
            //int before = app.group().getGroupCount();
            //List<GroupData> before = app.group().list(); - spisok
        Groups before = app.group().all();      // mnogestvo
        GroupData modifiedGroup = before.iterator().next();
                //int index = before.size() -1;
                //GroupData group = new GroupData(before.get(index).getId(),
                //        "test-modification", "updat3331", "updat3331");
                //GroupData group = new GroupData().withId(before.get(index).getId()).
        GroupData group = new GroupData().withId(modifiedGroup.getId()).
                withName(properties.getProperty("web.groupName")).
                withHeader(properties.getProperty("web.groupHeader")).
                withFooter(properties.getProperty("web.groupFooter"));
                        //app.group().modify(modifiedGroup, group);
        app.group().modify( group);
            //int after = app.group().getGroupCount();
        Groups after = app.group().all();
        assertEquals(after.size(),before.size() );
            //Assert.assertEquals(after,before );
            // modify old spicok in two steps
                //-no needs after assertThat:before.remove(modifiedGroup);
                //-no needs after assertThat:before.add(group);
            //System.out.println("after =" + after);
            //System.out.println("before =" +before);
             // ne-uporjado4en - massiv
            // uporjado4en    - spisok
            // spicok -> mnogestvoб BUT HashSet contains only unique names aND remove duplicates names
                //-no needs after assertThat:Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
            // no needs after added modifiedGroup
            //anonimous function
                //Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
                //before.sort(byId);
                //after.sort(byId);
                    //-no needs after assertThat: Assert.assertEquals(before,after);
        assertThat(after, equalTo
                (before.without(modifiedGroup).withAdded(group)));

    }


}
