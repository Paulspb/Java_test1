package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appManager.ApplicationManager;

/**
 * Created by khomep on 08-Jun-16.
 */
public class TestBase {

    //    protected final ApplicationManager app = new ApplicationManager(BrowserType.IE);
    //    protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
     protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeMethod
    public void setUp() throws Exception {
        app.initTests();

    }

    @AfterMethod
    public void tearDown() {
        app.afterTests();
    }

}
