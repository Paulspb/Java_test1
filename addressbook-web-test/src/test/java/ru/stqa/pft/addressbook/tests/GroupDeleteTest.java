package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static ru.stqa.pft.addressbook.appManager.ApplicationManager.properties;

public class GroupDeleteTest extends TestBase  {
    @BeforeMethod
    public void ensurePreconditions() {
                // load web in cache 1-time
        app.group().groupPage();
        if(app.db().groups().size() == 0 ) {
            app.group().create(new GroupData().
                    withName(properties.getProperty("web.groupModifiedName")));
        }
    }

    @Test(enabled = true)
    public void groupDeleteTest1() {
            //() - it was any of line
            //(before -1 = <last line -1>
            //int groupbefore = app.group().getGroupCount();
            // in was  Set<GrooupData> before
            // load web in cache 2-time
        //Groups before = app.group().all();
        Groups before = app.db().groups();      // mnogestvo
            //take from mnovestvo iterator, then next
        GroupData deletedGroup = before.iterator().next();
            // as substitute on deletedGroup int index = before.size() -1;
                // needs to delete whole element with Id
                //it was : app.group().delete(index);, now:
        app.group().delete(deletedGroup);
        Groups after = app.db().groups();
                // int after = app.group().getGroupCount();
                //Assert.assertEquals(after,before +1);
        assertEquals(after.size(),before.size()-1);
            // by index from mnovestvo no chance to delete
            //before.remove(index);
                //before.remove(deletedGroup);

        assertThat(after, equalTo(before.without(deletedGroup)));
                //for ( int i = 0; i < after.size(); i++) {
                //    Assert.assertEquals(after.get(i),before.get(i));
                //}
            // assertEquals can do so:
                //Assert.assertEquals(after,before);

    }




}
