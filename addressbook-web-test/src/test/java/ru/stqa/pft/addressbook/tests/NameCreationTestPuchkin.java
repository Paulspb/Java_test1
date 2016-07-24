package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.io.IOException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static ru.stqa.pft.addressbook.appManager.ApplicationManager.properties;

public class NameCreationTestPuchkin extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
                //list.add(new Object[]{new NameFirstMiddle().withPhoto(photo).
                //        withFirstname("Alex641").withLastname("Pushkin641").withGroup("test134") });
                    List<Object[]> list = new ArrayList<Object[]>();
        //File photo = new File("src/test/resources/kira2back.jpg");
        File photo = new File(properties.getProperty("web.contactPhoto"));
        try (BufferedReader reader = new BufferedReader(
                new FileReader(new File(properties.getProperty("web.contactData"))))
            ) {
                String xml = "";
            String line = reader.readLine();
            while (line != null) {
                    xml +=line;
                String[] split = line.split(";");
                list.add(new Object[]{ new NameFirstMiddle().
                        withFirstname(split[0]).withLastname(split[1]).withGroup(split[2]).withHomePhone(split[3]).withWorkPhone(split[4]).withMobilePhone(split[5]). withEmail1(split[6]).withEmail2(split[7]).withEmail3(split[8]).withFullAddress(split[9]).
                        withPhoto(photo)});
                line = reader.readLine();
            }
            return list.iterator();
        }
    }


    @Test (enabled = true, dataProvider = "validContacts")
    public void nameCreationTestWithGenerator(NameFirstMiddle name) {
        app.contact().goToContact();
        Contacts before = app.db().contacts();
        app.contact().create(name);
        assertThat(app.contact().count(),equalTo(before.size()+1));
            //Contacts after = app.contact().all();
        Contacts after = app.db().contacts();
        assertThat(after.size(),equalTo(before.size() +1));
        assertThat(after, equalTo(before.withAdded(
                    name.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
        verifyContactListInUi();
    }


    @Test(enabled = false)
    public void nameCreationTestPushkinMethod() {
        app.contact().goToContact();
                    //int before = app.group().getGroupCount();
                    //int before = app.contact().getContactCount();  it's counter
                    //List<GroupData> before = app.contact().list();  // it's full parms of one contact
            //  -no need Set<NameFirstMiddle> before = app.contact().all();
        Contacts before = app.contact().all();
        NameFirstMiddle name = new NameFirstMiddle().withId(before.size()-1).withFirstname("Alexey").
                withLastname("Pushkin").withGroup("test134");
                    //app.contact().fillFirstLastNames(name, true);
        app.contact().create(name);
                    //app.contact().createContactName(new NameFirstMiddle("Alexey", "Sergeevich","test134"), true);
            //xeching - method where assert light values does before hard assert
        assertThat(app.contact().count(),equalTo(before.size()+1));
                    //int after = app.contact().getContactCount();
                    //Assert.assertEquals(after,before +1);
                    //List<GroupData> after = app.contact().list();
                    // it was list - spisok, Set - mnogestvo
                    //-noneed- Set<NameFirstMiddle> after = app.contact().all();
        Contacts after = app.contact().all();
                    // int after = app.group().getGroupCount();
                    //Assert.assertEquals(after,before +1);
                //-old statement too assertEquals(after.size(),before.size() +1);
        assertThat(after.size(),equalTo(before.size() +1));
        assertThat(after, equalTo(before.withAdded(
                name.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
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
        //it's second method for sorting of mnogestvo
        //name.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt());
        //before.add(name);
        //assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        // comparation via anonimous func.
        // after list -> set no needs to use sort
        //Comparator<? super NameFirstMiddle> byId2 = (g1, g2) -> Integer.
        //        compare(g1.getId(),g2.getId());
        //before.sort(byId2);
        //after.sort(byId2);
        //System.out.println("before assertE - " + before);
        //System.out.println("after  assertE - " + after);
        //Assert.assertEquals(before,after);
        //assertEquals(before,after);
        //assertThat(after, equalTo(before.withAdded(
        //        name.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));

    }

    @Test(enabled = false)
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/ATT2.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
        System.out.println(photo.isDirectory());
        System.out.println(photo.isFile());
        System.out.println(photo.canWrite());
    }

}
