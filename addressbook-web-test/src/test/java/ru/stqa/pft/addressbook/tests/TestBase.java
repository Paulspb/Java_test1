package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appManager.ApplicationManager;

/**
 * Created by khomep on 08-Jun-16.
 */
public class TestBase {

    //    protected final ApplicationManager app = new ApplicationManager(BrowserType.IE);
    //    protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
     protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() throws Exception {
        app.initTests();

    }

    @AfterSuite
    public void tearDown() {
        app.afterTests();
    }

}
