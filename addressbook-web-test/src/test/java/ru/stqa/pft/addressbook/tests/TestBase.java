package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appManager.ApplicationManager;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestBase {

    //    protected final ApplicationManager app = new ApplicationManager(BrowserType.IE);
      //  protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
     protected static final ApplicationManager app =
            new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.initTests();

    }

    @AfterSuite
    public void tearDown() {
        app.afterTests();
    }

    public void verifyGroupListInUi() {
        // system.getboolen
        if (Boolean.getBoolean("verifyUI")) {
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            //assertThat

            //dbGroups contains more element as Ui, needs to simplify DB records
            //assertThat(uiGroups, equalTo(dbGroups));
            assertThat(uiGroups, equalTo(dbGroups.stream().map((g) -> new GroupData().
                    withId(g.getId()).withName(g.getName())).
                    collect(Collectors.toSet())));
        }
    }


    public void verifyContactListInUi() {
        if (Boolean.getBoolean("verifyUI")) {
            Contacts dbContacts = app.db().contacts();
            Contacts uiContacts = app.contact().all();
            assertThat(uiContacts.stream()
                    .filter( (s) ->  s!= null && !s.equals(""))
                    .map(
                    (h) -> new NameFirstMiddle().withId(h.getId()).
                            withFirstname(h.getFirstname()).withLastname(h.getLastName()).withFullAddress(h.getFullAddress())).
                            collect(Collectors.toSet())

                    , equalTo(dbContacts.stream()
                    .filter( (s) ->  s!= null && !s.equals(""))
                    .map(
                    (g) -> new NameFirstMiddle().withId(g.getId()).
                            withFirstname(g.getFirstname()).withLastname(g.getLastName()).withFullAddress(g.getFullAddress())).
                    collect(Collectors.toSet())));
        } else {
            System.out.println("!!! step verifyContactListInUi skipped due to " +
                    "this parameter equal false : -ea -DverifyUI=false  !!! ");
        }
    }
}
