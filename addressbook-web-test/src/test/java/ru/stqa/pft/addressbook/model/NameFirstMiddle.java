package ru.stqa.pft.addressbook.model;

public class NameFirstMiddle {
    private final String firstname;
    private final String middleName;
    private String group;

    public NameFirstMiddle(String firstname, String middleName, String group) {
        this.firstname = firstname;
        this.middleName = middleName;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGroup() {
        // to take value of pole
        return group;
    }
}
