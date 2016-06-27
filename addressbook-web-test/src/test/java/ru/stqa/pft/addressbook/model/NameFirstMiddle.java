package ru.stqa.pft.addressbook.model;

public class NameFirstMiddle {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    //private final String middleName;
    private String group;

     //public void withId(int id) {
    public NameFirstMiddle withId(int id) {
        this.id = id;
        return this;
    }

    public NameFirstMiddle withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }
    public NameFirstMiddle withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
    public NameFirstMiddle withGroup(String group) {
        this.group = group;
        return this;
    }


    public int    getId()        { return id;  }
    public String getFirstname() { return firstname;   }
    public String getLastName()  { return lastname;    }
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameFirstMiddle that = (NameFirstMiddle) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}
