package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Emails123;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.LastNameNick2;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameCreationTestPuchkin extends TestBase {

    @Test
    public void nameCreationTestPushkinMethod() {
        app.contact().goToContact();
            //int before = app.group().getGroupCount();
            //int before = app.contact().getContactCount();  it's counter
            //List<GroupData> before = app.contact().list();  // it's full parms of one contact
        Set<NameFirstMiddle> before = app.contact().all();
        app.contact().goToAddNamePad();
            //NameFirstMiddle name = new NameFirstMiddle(before.size()-1,"Alexey", "Pushkin","test134");
        NameFirstMiddle name = new NameFirstMiddle().withId(before.size()-1).withFirstname("Alexey").
                withLastname("Pushkin").withGroup("test134");
        app.contact().fillFirstNameMiddleName(name, true);

            //app.contact().createContactName(new NameFirstMiddle("Alexey", "Sergeevich","test134"), true);

        app.contact().createContactName(new LastNameNick2("Push"));
        app.contact().fillTitle("mr.");
        app.contact().fillCompany("ooo Boldino");
        app.contact().fillAddress1("Pskovskaya obl.");
        app.contact().fillHomeMobileTlf("8 888 555 3214", "8 921 921 921 921");
        app.contact().fillFaxWorkTlf();
        app.contact().fillEmail(new Emails123("alexander0.puchkin@gmail.com", "apuchkin@kultura.tv", "\\9"));
        app.contact().fillHomePage();
        app.contact().fillBithday();
        app.contact().fillContent();
        app.contact().fillAddress2();
        app.contact().fillPhone2();
            //app.submit();
        app.contact().submitContact();
        app.contact().goToContact();
        //int after = app.contact().getContactCount();
        //Assert.assertEquals(after,before +1);
            //List<GroupData> after = app.contact().list();
            // it was list - spisok, Set - mnogestvo
        Set<NameFirstMiddle> after = app.contact().all();
        // int after = app.group().getGroupCount();
        //Assert.assertEquals(after,before +1);
        Assert.assertEquals(after.size(),before.size() +1);
            // find max ID - first way
            //int max = 0;
            //for (NameFirstMiddle g : after) {
            //    if(g.getId() > max ) {
            //        max = g.getId();
            //    }
            //}
                //    lyambda - second way
                //Comparator<? super GroupData> byId = (o1, o2) ->  Integer.compare(o1.getId(),o2.getId());
            //int max2 = after.stream().max((o1,o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
            //it was setId
            //name.withId(after.stream().max((o1,o2) -> Integer.
            // it's first method
            //        compare(o1.getId(),o2.getId())).get().getId());
            //it's second method'
        name.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt());
        before.add(name);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
                // comparation via anonimous func.
                // after list -> set no needs to use sort
                //Comparator<? super NameFirstMiddle> byId2 = (g1, g2) -> Integer.
                //        compare(g1.getId(),g2.getId());
                //before.sort(byId2);
                //after.sort(byId2);
           System.out.println("before assertE - " + before);
           System.out.println("after  assertE - " + after);
        Assert.assertEquals(before,after);
    }


}
