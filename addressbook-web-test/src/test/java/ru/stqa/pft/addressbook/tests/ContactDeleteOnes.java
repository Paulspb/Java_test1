package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static ru.stqa.pft.addressbook.appManager.ApplicationManager.properties;

/**
 * Created by khomep on 09-Jun-16.
 */
public class ContactDeleteOnes extends TestBase {
    @BeforeMethod
    public void ensurePreconditionContact(){
        app.contact().goToContact();
        if ( app.db().contacts().size() == 0) {
            app.contact().create(new NameFirstMiddle().withId(0).
                    withFirstname(properties.getProperty("web.contactModifiedFirstName")).
                    withLastname(properties.getProperty("web.contactModifiedLastName")) );
                    //lesson 7.6 withGroup(properties.getProperty("web.contactGroup")) );
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.db().contacts();
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
        Contacts after = app.db().contacts();
            //System.out.println("after.size =" +after.size());
            // int after = app.group().getGroupCount();
                //Assert.assertEquals(after,before - 1);
        assertEquals(after.size(),index);
                //before.remove(index);
            // -no needs after add eqbefulTo...ore.remove(deletedContact);
        assertThat(after, equalTo(before.without(deletedContact)));
        verifyContactListInUi();
            //System.out.println("bef.remove =" + before);
            //System.out.println("after      =" + after);
                //for ( int i = 0; i < after.size(); i++) {
                //    Assert.assertEquals(after.get(i),before.get(i));
                //}
                //-no needs after add equalTo: Assert.assertEquals(after,before);


    }


}
