package ru.stqa.ptf.mantis.model;

/**
 * Created by khomep on 01-Aug-16.
 */
public class Project {
    private int id;
    private String name;


    public Project withId(int id) {
        this.id = id;
        return this;
    }

    //public void withName(String name) {
    public Project withName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
