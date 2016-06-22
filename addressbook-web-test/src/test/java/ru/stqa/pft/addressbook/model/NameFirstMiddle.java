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

    @Override
    public String toString() {
        return "NameFirstMiddle{" +
                "firstname='" + firstname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameFirstMiddle that = (NameFirstMiddle) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        return group != null ? group.equals(that.group) : that.group == null;

    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }

    public String getGroup() {
        // to take value of pole
        return group;

    }
}
