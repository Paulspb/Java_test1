package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// this runs shablon -decorator-
public class Groups extends ForwardingSet<GroupData> {

    private Set<GroupData> delegate;

    public Groups(Groups groups) {
        // build new mnogestvo
        this.delegate = new HashSet<GroupData>(groups.delegate());
    }

    public Groups() {
        this.delegate = new HashSet<GroupData>();
    }

            // lesson 7.4
    public Groups(Collection<GroupData> groups) {
                //build new HasSet == mnogestvo with type GroupData from Collection
        this.delegate = new HashSet<GroupData>(groups);
    }

    @Override
    protected Set<GroupData> delegate() {
        return delegate;
    }

    // our owm methods
    public Groups withAdded(GroupData group) {
        // old object will be the same, but withAdded retirns a new object
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    // our owm methods
    public Groups without(GroupData group) {
        // old object will be the same, but withAdded retirns a new object
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
