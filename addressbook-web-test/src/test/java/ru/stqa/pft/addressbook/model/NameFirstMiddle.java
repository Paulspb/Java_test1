package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contacts")
@javax.persistence.Entity
@javax.persistence.Table(name = "addressbook")
public class NameFirstMiddle {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

        // lesson 7.6
    //@Transient
    //private String group;

    @ManyToMany(fetch = FetchType.EAGER)    // link address and group table  Gadny !!
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

        // lesson 5.9
    @Column(name = "home")
    @Type(type ="text")
    private String homePhone;

    @Column(name = "mobile")
    @Type(type ="text")
    private String mobilePhone;

    @Column(name = "work")
    @Type(type ="text")
    private String workPhone;

    @Transient
    private String allPhones;
        // home12
        //@Transient
        @Column(name = "email")
        @Type(type ="text")
    private String email1;

    @Column(name = "email2")
    @Type(type ="text")
    private String email2;

    @Column(name = "email3")
    @Type(type ="text")
    private String email3;
    @Transient
    private String allEmails;
    @Column(name = "address")
    @Type(type ="text")
    private String fullAddress;

    @Column(name = "photo")
    @Type(type ="text")
    //private File   photo;
    private String   photo;


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
        // lesson 7.6
    //public NameFirstMiddle withGroup(String group) {
    //    this.group = group;
    //    return this;
    //}
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
    public NameFirstMiddle withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }
    public NameFirstMiddle withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }
    public NameFirstMiddle withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }
    public NameFirstMiddle withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }
    public NameFirstMiddle withFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
        return this;
    }
    // public NameFirstMiddle withPhoto(File photo) {
    public NameFirstMiddle withPhoto(File photo) {
        //this.photo = photo;
        this.photo = photo.getPath();
        return this;
    }

    public int    getId()        { return id;  }
    public String getFirstname() { return firstname;  }
    public String getLastName()  { return lastname;   }
        // lesson 7.6
    //public String getGroup()     {   return group;    }
        // lesson 7.6
    //public Set<GroupData> getGroup() {
    //    return group;
    //}
           /// lesson 7.6 for unification
    public Groups getGroups() {
                // mnogestvo -> object with type group
                //return group;
        return new Groups(groups);
    }

    public String getMobile()    { return mobilePhone;  }
    public String getHome()      { return homePhone;    }
    public String getWork()      { return workPhone;    }
    public String getAllPhones() { return allPhones;    }
        //home12
    public String getEmail1()       { return email1;     }
    public String getEmail2()       { return email2;     }
    public String getEmail3()       { return email3;     }
    public String getAllEmails()    { return allEmails;  }
    public String getFullAddress()  { return fullAddress;}
        //home 14
        //public File   getPhoto()        { return photo;      }  // now is String
    public File   getPhoto()        { return new File(photo);      }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameFirstMiddle that = (NameFirstMiddle) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
        if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
        if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
        if (email1 != null ? !email1.equals(that.email1) : that.email1 != null) return false;
        if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
        if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
        return fullAddress != null ? fullAddress.equals(that.fullAddress) : that.fullAddress == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
        result = 31 * result + (email1 != null ? email1.hashCode() : 0);
        result = 31 * result + (email2 != null ? email2.hashCode() : 0);
        result = 31 * result + (email3 != null ? email3.hashCode() : 0);
        result = 31 * result + (fullAddress != null ? fullAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NameFirstMiddle{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
//                ", group='" + group + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", allPhones='" + allPhones + '\'' +
                ", email1='" + email1 + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", allEmails='" + allEmails + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                '}';
    }

    public NameFirstMiddle inGroup(GroupData group) {
        groups.add(group);
        return this;
    }
}
