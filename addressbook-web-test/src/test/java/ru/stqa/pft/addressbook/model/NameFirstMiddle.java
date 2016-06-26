package ru.stqa.pft.addressbook.model;

public class NameFirstMiddle {
    private int id;
    private final String firstname;
    private final String lastname;
    //private final String middleName;
    private final String group;

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

    public NameFirstMiddle(int id, String firstname, String lastname, String group) {
                //this.id        = id; error !!!
                //this.id   = 0;  // new line in begin
        //this.id   = Integer.MAX_VALUE;  // new line at the buttom
        this.id     = id;
        this.firstname = firstname;
        //this.middleName = middleName;
        this.lastname  = lastname;
        this.group = group;
    }

    public NameFirstMiddle( String firstname, String lastname, String group) {
        //this.id        = id; error !!!
        //this.id   = 0;  // new line in begin
        this.id   = Integer.MAX_VALUE;  // new line at the buttom
        //this.id     = id;
        this.firstname = firstname;
        //this.middleName = middleName;
        this.lastname  = lastname;
        this.group = group;
    }

    public int getId() { return id;  }

    public void setId(int id) { this.id = id;  }

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
