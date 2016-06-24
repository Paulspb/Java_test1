package ru.stqa.pft.addressbook.model;

public class NameFirstMiddle {
    private int id;
    private final String firstname;
    private final String lastname;
    //private final String middleName;
    private final String group;

    public NameFirstMiddle(int id,String firstname, String lastname, String group) {
        this.id        = id;
        this.firstname = firstname;
        //this.middleName = middleName;
        this.lastname  = lastname;
        this.group = group;
    }

    public int getId() { return id;  }

    public void setId(int id) { this.id = id;  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameFirstMiddle that = (NameFirstMiddle) o;

        if (id != that.id) return false;
        if (!firstname.equals(that.firstname)) return false;
        return lastname.equals(that.lastname);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        return result;
    }

    public String getFirstname() {        return firstname;    }
    public String getLastName() {        return lastname;    }
    //public String getMiddleName() {
    //    return middleName;
    //}

    @Override
    public String toString() {
        return "NameFirstMiddle{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    public String getGroup() {
        // to take value of pole
        return group;

    }
}
