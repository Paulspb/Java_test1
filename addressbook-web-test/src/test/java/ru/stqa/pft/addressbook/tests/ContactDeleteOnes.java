package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.Set;

/**
 * Created by khomep on 09-Jun-16.
 */
public class ContactDeleteOnes extends TestBase {
    @BeforeMethod
    public void ensurePreconditionContact(){
        app.contact().goToContact();
        if ( app.contact().all().size() == 0) {
            app.contact().create(new NameFirstMiddle().withId(0).
                    withFirstname("new group2").
                    withLastname("Dostoyevsky").withGroup("test134") );
        }
    }

    @Test
    public void testContactDeletion() {
        Set<NameFirstMiddle> before = app.contact().all();
        int index = before.size() -1;
                    //int index2 = before.size() +0;
            // next return sly4ainyi element, not last, not first
        NameFirstMiddle deletedContact = before.iterator().next();
            //System.out.println("before =" +before);
            //System.out.println("before( next ) =" +
        before.iterator().next();
            //System.out.println("before =" +before.iterator().next());
                //app.contact().delete(before);
                //app.contact().delete(index2);
        app.contact().delete(deletedContact);
        Set<NameFirstMiddle> after = app.contact().all();
            //System.out.println("after.size =" +after.size());
            // int after = app.group().getGroupCount();
            //Assert.assertEquals(after,before - 1);
        Assert.assertEquals(after.size(),index);
            //before.remove(index);
        before.remove(deletedContact);
            //System.out.println("bef.remove =" + before);
            //System.out.println("after      =" + after);
                //for ( int i = 0; i < after.size(); i++) {
                //    Assert.assertEquals(after.get(i),before.get(i));
                //}
        Assert.assertEquals(after,before);


    }


}
