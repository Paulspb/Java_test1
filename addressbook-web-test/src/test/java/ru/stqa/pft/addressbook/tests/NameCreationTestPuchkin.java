package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Emails123;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.LastNameNick2;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;

import java.util.HashSet;
import java.util.List;

public class NameCreationTestPuchkin extends TestBase {

    @Test
    public void nameCreationTestPushkinMethod() {
        app.getContactHelper().goToContact();
        //int before = app.getGroupHelper().getGroupCount();
        //int before = app.getContactHelper().getContactCount();  it's counter
        //List<GroupData> before = app.getContactHelper().getContactlist();  // it's full parms of one contact
        List<NameFirstMiddle> before = app.getContactHelper().getContactlist();
        app.getContactHelper().goToAddNamePad();
        NameFirstMiddle name = new NameFirstMiddle(0,"Alexey", "Pushkin","test134");
        app.getContactHelper().fillFirstNameMiddleName(name, true);

        //app.getContactHelper().createContactName(new NameFirstMiddle("Alexey", "Sergeevich","test134"), true);

        //app.getContactHelper().createContactName(new LastNameNick2("Sergeevich","Push"));
        app.getContactHelper().createContactName(new LastNameNick2("Push"));
        app.getContactHelper().fillTitle("mr.");
        app.getContactHelper().fillCompany("ooo Boldino");
        app.getContactHelper().fillAddress1("Pskovskaya obl.");
        app.getContactHelper().fillHomeMobileTlf("8 888 555 3214", "8 921 921 921 921");
        app.getContactHelper().fillFaxWorkTlf();
        app.getContactHelper().fillEmail(new Emails123("alexander0.puchkin@gmail.com", "apuchkin@kultura.tv", "\\9"));
        app.getContactHelper().fillHomePage();
        app.getContactHelper().fillBithday();
        app.getContactHelper().fillContent();
        app.getContactHelper().fillAddress2();
        app.getContactHelper().fillPhone2();
        //app.submit();
        app.getContactHelper().submitContact();
        app.getContactHelper().goToContact();
        //int after = app.getContactHelper().getContactCount();
        //Assert.assertEquals(after,before +1);
        //List<GroupData> after = app.getContactHelper().getContactlist();
        List<NameFirstMiddle> after = app.getContactHelper().getContactlist();
        // int after = app.getGroupHelper().getGroupCount();
        //Assert.assertEquals(after,before +1);
        Assert.assertEquals(after.size(),before.size() +1);
        // find max ID
        int max = 0;
        for (NameFirstMiddle g : after)
            if(g.getId() > max ) {
                max = g.getId();
            }
        name.setId(max);
        //System.out.println("before - " + before);
        //System.out.println("after - " + after);
        before.add(name);
        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }


}
