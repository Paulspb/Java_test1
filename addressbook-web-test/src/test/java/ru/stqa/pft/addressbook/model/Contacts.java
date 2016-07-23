package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<NameFirstMiddle> {

    private Set<NameFirstMiddle> delegateC;

    public Contacts(Contacts contacts) {
        this.delegateC = new HashSet<NameFirstMiddle>(contacts.delegateC);
    }
            //constructor1
    public Contacts() {
        this.delegateC = new HashSet<NameFirstMiddle>();
    }
            //constructor2
    public Contacts(Collection<NameFirstMiddle> contacts) {
        this.delegateC = new HashSet<NameFirstMiddle>(contacts);
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
