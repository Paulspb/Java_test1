package ru.stqa.pft.addressbook.model;

public class GroupData {
    // this constraucter not acept any parms
    //private int id;
    private int id = Integer.MAX_VALUE;  // new line at the buttom
    private String name;
    private String header;
    private String footer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        return name != null ? name.equals(groupData.name) : groupData.name == null;

    }

    @Override
    public int hashCode() {
            //if hashCode not the same, then equlas() not needs. hashCode - faster
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
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

    public GroupData withId(int id) {
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
