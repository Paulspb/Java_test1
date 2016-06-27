package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.List;

/**
 * Created by khomep on 09-Jun-16.
 */
public class ContactDeleteOnes extends TestBase {
    @BeforeMethod
    public void ensurePreconditionContact(){
        app.contact().goToContact();
        if ( app.contact().list().size() == 0) {
            app.contact().create(new NameFirstMiddle().withId(0).withFirstname("update2"));
        }
    }

    @Test
    public void testContactDeletion() {
        List<NameFirstMiddle> before = app.contact().list();
        int index = before.size() -1;
            //System.out.println("after =" + after);
            //System.out.println("before =" +before);
        app.contact().delete(before);
        List<NameFirstMiddle> after = app.contact().list();
            //System.out.println("after.size =" +after.size());
            // int after = app.group().getGroupCount();
            //Assert.assertEquals(after,before - 1);
        Assert.assertEquals(after.size(),index);
        before.remove(index);
            //for ( int i = 0; i < after.size(); i++) {
            //    Assert.assertEquals(after.get(i),before.get(i));
            //}
        Assert.assertEquals(after,before);


    }


}
