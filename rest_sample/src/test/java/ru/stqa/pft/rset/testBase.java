package ru.stqa.pft.rset;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by khomep on 02-Aug-16.
 */
public class TestBase extends Issue{
    public void skipIfNotFixed(int issueId) throws IOException, SkipException {
        if (isIssueOpen(issueId)) {
            System.out.println("Issue # " + issueId + "  is not fixed");
            throw new SkipException("Ignored because of issue " + issueId);
        } else {
            System.out.println("Issue is fixed");
        }
    }

    public boolean isIssueOpen(int issueId) throws IOException {
        System.out.println("Issue # " + issueId + "  is in status :"+getIssueById(issueId).getStateName());
        return !getIssueById(issueId).getStateName().equals("Resolved");
    }

    public Issue getIssueById(int id) throws IOException {
        Issue issue = new Issue();
        Set<Issue> issues = getIssues();

        for (Issue g: issues) {
            if (g.getId() == id) {
                    return issue.withId(g.getId()).withSubject(g.getSubject())
                            .withIdIssue(g.getIdIssue())
                            .withDescription(g.getDescription())
                            .withStateName(g.getStateName());
            }
        }
            return issue;
    }

    public Set<Issue> getIssues() throws IOException {
           String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues.json"))
                  .returnContent().asString();
           JsonElement parsed = new JsonParser().parse(json);
           JsonElement issues = parsed.getAsJsonObject().get("issues");
        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {}.getType());
    }

    public Executor getExecutor() {
             return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==", "");
         }
    }
