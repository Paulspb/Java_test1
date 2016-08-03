package ru.stqa.pft.rset;

/**
 * Created by khomep on 02-Aug-16.
 */
public class Issue {
    private int id;
    private String subject;
    private String description;
    private String state_name;
    private int issue_id;

    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    public Issue withIdIssue(int issue_id) {
         this.issue_id= issue_id;
        return this;
    }

    public Issue withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }

    public Issue withStateName(String state_name) {
        this.state_name = state_name;
        return this;
    }

    public int getId() {
        return id;
    }
    public int getIdIssue() {
        return issue_id;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public String getStateName() { return state_name;    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", state_name='" + state_name + '\'' +
                ", issue_id=" + issue_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (subject != null ? !subject.equals(issue.subject) : issue.subject != null) return false;
        return description != null ? description.equals(issue.description) : issue.description == null;

    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
