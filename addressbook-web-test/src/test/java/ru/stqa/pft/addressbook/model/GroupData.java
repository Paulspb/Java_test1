package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.persister.entity.SingleTableEntityPersister;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@XStreamAlias("group")

@javax.persistence.Entity
        //mapping table group_list
@javax.persistence.Table(name = "group_list")
public class GroupData {
        // this constructer not acept any parms
    @XStreamOmitField
            // this revoke id from xml file
    @Id
    @Column(name = "group_id")

    private int id = Integer.MAX_VALUE;  // new line at the buttom
    @Column(name = "group_name")
    private String name;
    @Column(name = "group_header")
    @Type(type ="text")
    private String header;
    @Column(name = "group_footer")
    @Type(type ="text")
    private String footer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        if (name != null ? !name.equals(groupData.name) : groupData.name != null) return false;
        if (header != null ? !header.equals(groupData.header) : groupData.header != null) return false;
        return footer != null ? footer.equals(groupData.footer) : groupData.footer == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (header != null ? header.hashCode() : 0);
        result = 31 * result + (footer != null ? footer.hashCode() : 0);
        return result;
    }

    // revoke after
            //private int id;
            //private int id = Integer.MAX_VALUE;  // new line at the buttom

    //public GroupData(String name, String header, String footer) {
    //    //this.id   = 0;  // new line in begin
    //    this.id   = Integer.MAX_VALUE;  // new line at the buttom
    //    this.name = name;
    //    this.header = header;
    //    this.footer = footer;
    //}

    //public GroupData(int id,String name, String header, String footer) {
    //    this.id   = id;
    //    this.name = name;
    //    this.header = header;
    //    this.footer = footer;
    //}

    public GroupData setId(int id) {
        this.id = id;
        return this;
    }

        //public void withName(String name) {
    public GroupData withName(String name) {
        this.name = name;
        // will return object from them it calling
        return this;
    }
    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }
    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public int    getId()     { return id;     }
    public String getName()   { return name;   }
    public String getHeader() { return header; }
    public String getFooter() {
        return footer;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}
