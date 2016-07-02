package ru.stqa.pft.addressbook.model;

public class NameFirstMiddle {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
            //private final String middleName;
    private String group;
        // lesson 5.9
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String allPhones;


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
    public NameFirstMiddle withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }
    public NameFirstMiddle withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }
    public NameFirstMiddle withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }
    public NameFirstMiddle withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }


    public int    getId()        { return id;  }
    public String getFirstname() { return firstname;   }
    public String getLastName()  { return lastname;    }
    public String getMobile()    { return mobilePhone;    }
    public String getHome()      { return homePhone;    }
    public String getWork()      { return workPhone;    }
    public String getAllPhones() {
        return allPhones;
    }


    public String getGroup() {        // to take value of pole
            return group;    }

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

    @Override
    public String toString() {
        return "NameFirstMiddle{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", group='" + group + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", allPhones='" + allPhones + '\'' +
                '}';
    }
}
