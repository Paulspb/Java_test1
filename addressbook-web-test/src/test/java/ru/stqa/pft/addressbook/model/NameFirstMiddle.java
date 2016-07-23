package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.File;

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
            //private final String middleName
            //@Column(name = "id")
    @Transient
    private String group;
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
    public String getGroup()     {   return group;    }

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
                ", email1='" + email1 + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", allEmails='" + allEmails + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                '}';
    }
}
