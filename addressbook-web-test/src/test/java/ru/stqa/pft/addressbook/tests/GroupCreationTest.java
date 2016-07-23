package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static ru.stqa.pft.addressbook.appManager.ApplicationManager.properties;

public class GroupCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]>validGroups() throws IOException {
                //functional programming, next no need:
                //List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(new File(properties.getProperty("web.groupFile"))))
                ) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml +=line;
                        //-no needs for xml-
                    // String[] split = line.split(";");
                    //in case if 3 INPUT lines, then add 3 GroupData() lines
                    //-no needs for xml-
                    //list.add(new Object[]{ new GroupData().
                    //withName(split[0]).withHeader(split[1]).withFooter(split[2])});
                line = reader.readLine();
            }
            XStream xstream = new XStream();
                //- needs only for convert-
            xstream.processAnnotations(GroupData.class);
                // read data from xml and keep data to var at the  same type
            List<GroupData> groups  = (List<GroupData>)  xstream.fromXML(xml);
                //functional programming
                    // collect potok -> spisok
                    //default Stream<E> stream() {
                        //List<Object[]> list = new ArrayList<Object[]>();
            return groups.stream().
                    map( (g) -> new Object[] {g} ).collect(Collectors.toList()).iterator();  //   .collect(Collectors.toList()).

        }
                //list.add(new Object[]{"test1","header1","footer1"});
                //list.add(new Object[]{"test2","header2","footer2"});
                //list.add(new Object[]{"test3","header3","footer3"});
            //-no- afrter add functional progr.

    }
            //  do link between @dataprovider & the Test
    @Test(dataProvider = "validGroups")
    //public void groupCreationTestMethod(String name, String header, String footer) {
    public void groupCreationTestMethod(GroupData group) {

                //String [] names = new String[] {"test641","test642","test643"};
                //for (String name :names ) {
                    //GroupData group = new GroupData().withName(name).
                        //    withHeader(header).withFooter(footer);
        app.group().groupPage();
        Groups before = app.db().groups();      // mnogestvo  les-7.4
        app.group().create(group);
            //xeching - method where assert light values does before hard assert
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.db().groups();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(
                    group.setId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        //}
    }


    @Test(enabled = true )
    //@Test(dataProvider = "validGroups")
            //public void groupCreationTestLesson(GroupData group) {
    public void groupCreationTestLesson() {
            //app.group().gotoGroupPage2();
            //app.getNavigationHelper()
        app.group().groupPage();
            //List<GroupData> before = app.group().list();
        //-after added withAdded Set<GroupData> before = app.group().all();
        Groups before = app.db().groups();      // mnogestvo  les-7.4
            //int before1 = app.group().getGroupCount();
            // no needs as take from generator !!!
        //GroupData group = new GroupData("test134", "test21", "test31");
        GroupData group = new GroupData().
                withName(properties.getProperty("web.groupName")).
                withHeader(properties.getProperty("web.groupHeader")).
                withFooter(properties.getProperty("web.groupFooter"));

        app.group().create(group);
            //xeching - method where assert light values does before hard assert
        assertThat(app.group().count(),equalTo(before.size()+1));
            // placed into create
            //app.group().initGroupCreation();
            //app.group().fillInGroupForm(new GroupData("test123423434", "test21", "test31"));
            //app.group().submitGroupCreation();
            //app.group().getNavigationHelper().returntoGroupPage();
        //List<GroupData> after = app.group().list();
            //-no need Set<GroupData> after = app.group().all();
        Groups after = app.db().groups();
            //-old statement- Assert.assertEquals(after.size(),before.size() +1);
            //-old too-assertEquals(after.size(),equalTo(before.size() +1));
        assertThat(after.size(),equalTo(before.size() +1));
        assertThat(after, equalTo(before.withAdded(
                        group.setId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));

                    // find max ID
                    //int max = 0;
                    //for (GroupData g : after)  {
                    //    if(g.getId() > max ) {
                    //        max = g.getId();
                    //    }
                    //}
            //lambda  or function anonimous
        //Comparator<? super GroupData> byId = (o1,o2) ->  Integer.compare(o1.getId(),o2.getId());
        //int max2 = after.stream().max((o1,o2) -> Integer.
        //        compare(o1.getId(),o2.getId())).get().getId();
            //    Comparator<? super GroupData> byId = new Comparator<GroupData>() {
            //    @Override
            //    public int compare(GroupData o1, GroupData o2) {
            //        return Integer.compare(o1.getId(),o2.getId());
            //    }
            //};
                //int max1 = after.stream().max(byId).get().getId();
            //group.setId(max2);
            //group.withId(max2);
            // convert potok Group to potok of ID:
            //pass to anonim.function: g - parameter. g.getId() - result, then calcul. the max
            // then convert Hash to usual INT
                //-moved to assetThat: group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt());
            //before.add(group);
            // old Assert: related with old ADD(GROUP);
            //assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
            //after list -> set
            // no needs to use sort
            //Comparator<? super GroupData> byId2 = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
            //before.sort(byId2);
            //after.sort(byId2);
        //    System.out.println("before2 - " + before);
        //    System.out.println("after2 - " + after);
             //comp. not mnogestvo, but spisok
                //Assert.assertEquals(before,after); now:
                //assertThat(after, equalTo(before));

                //added -import- only for static function instead of
                //import org.hamcrest.CoreMatchers;
                    // also convert via alt+ enter
                //MatcherAssert.assertThat(after, equalTo(before));
                //-do updates- assertThat(after, equalTo(before));
        //assertThat(after, equalTo(before.withAdded(
        //        group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));

    }

    @Test(enabled = false)
    public void groupCreationTestBadMethod() {
        app.group().groupPage();
        Groups before = app.group().all();  // ' is bad data
        GroupData group = new GroupData().withName("test134'").
                withHeader("test21").withFooter("test31");
        app.group().create(group);
                // why needs to load all group if needs for size() only ?
                // count() take size() faster
                //xeching - method where assert light values does before hard assert
        assertThat(app.group().count(),equalTo(before.size()));
        Groups after = app.group().all();
        //assertThat(after.size(),equalTo(before.size() +1));
        assertThat(after.size(),equalTo(before.size()));
            //System.out.println("before2 - " + before);
            //System.out.println("after2 - " + after);
        // no group added due to failed syntax '
        assertThat(after, equalTo(before));

        //assertThat(after, equalTo(before.withAdded(
        //        group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));

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
        app.group().create(new GroupData().withName("test134"));
            //        ("testGroupNull",null,null));
            // placed into create
            //app.group().initGroupCreation();
            //app.group().fillInGroupForm(new GroupData("testNotNull", null,null));
            //app.group().submitGroupCreation();
            //app.group().getNavigationHelper().returntoGroupPage();
        List<GroupData> after = app.group().list();
            // int after = app.group().getGroupCount();
            //Assert.assertEquals(after,before +1);
        assertEquals(after.size(),before.size() +1);
        ///System.out.println("after222 - " + after);
    }

}
