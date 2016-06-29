package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by khomep on 29-Jun-16.
 */
public class Contacts extends ForwardingSet<NameFirstMiddle> {

    private Set<NameFirstMiddle> delegateC;

    public Contacts(Contacts contacts) {
        this.delegateC = new HashSet<NameFirstMiddle>(contacts.delegateC);
    }

    public Contacts() {
        this.delegateC = new HashSet<NameFirstMiddle>();
    }

    @Override
    protected Set<NameFirstMiddle> delegate() {
        return delegateC;
    }

   public Contacts withAdded(NameFirstMiddle contact) {
       Contacts contacts = new Contacts(this);
       contacts.add(contact);
       return contacts;
    }
    public Contacts without(NameFirstMiddle contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }
}
