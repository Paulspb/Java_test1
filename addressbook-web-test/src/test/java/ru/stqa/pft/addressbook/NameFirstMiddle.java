package ru.stqa.pft.addressbook;

public class NameFirstMiddle {
    private final String firstname;
    private final String middleName;

    public NameFirstMiddle(String firstname, String middleName) {
        this.firstname = firstname;
        this.middleName = middleName;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddleName() {
        return middleName;
    }
}
