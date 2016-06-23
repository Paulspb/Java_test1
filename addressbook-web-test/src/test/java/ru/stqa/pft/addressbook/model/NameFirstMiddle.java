package ru.stqa.pft.addressbook.model;

public class NameFirstMiddle {
    private final String id;
    private final String firstname;
    private final String lastname;
    //private final String middleName;
    private final String group;

    public NameFirstMiddle(String id,String firstname, String lastname, String group) {
        this.id        = id;
        this.firstname = firstname;
        //this.middleName = middleName;
        this.lastname  = lastname;
        this.group = group;
    }

    public String getId() { return id;  }

    public String getFirstname() {        return firstname;    }
    public String getLastName() {        return lastname;    }
    //public String getMiddleName() {
    //    return middleName;
    //}

    @Override
    public String toString() {
        return "NameFirstMiddle{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameFirstMiddle that = (NameFirstMiddle) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        return group != null ? group.equals(that.group) : that.group == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }

    public String getGroup() {
        // to take value of pole
        return group;

    }
}
