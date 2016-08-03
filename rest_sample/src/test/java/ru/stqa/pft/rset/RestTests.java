package ru.stqa.pft.rset;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

//import static com.sun.javafx.runtime.async.BackgroundExecutor.getExecutor;
import static org.testng.Assert.assertEquals;

/**
 * Created by khomep on 02-Aug-16.
 */
public class RestTests extends TestBase {
    @Test
    public void testCreateIssue() throws IOException, InterruptedException {

        skipIfNotFixed(7);   // if issue : id =7 not 'resolved' , then test skip

        Set<Issue> oldIssues = getIssues();
        Issue newIssue = new Issue().withSubject("Test issue15").withDescription("New test issue15");
        int issueId = createIssue(newIssue);
        Thread.sleep(200);
        //skipIfNotFixed(issueId);  // or if new issue  not resolved , then test skipp
        Set<Issue> newIssues = getIssues();
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(newIssues,oldIssues);

    }


    private Set<Issue> getIssues2() throws IOException {
               //Request.Get("");
                //Request
                //org.apache.http.client.fluent.
        String json =
        getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues.json"))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {}.getType());


    }

    private Executor getExecutor2() {
        return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==", "");
    }

    private int createIssue(Issue newIssue) throws IOException {
        String json = getExecutor().execute(Request.Post("http://demo.bugify.com/api/issues.json")
                     .bodyForm(new BasicNameValuePair("subject", newIssue.getSubject())
                             , new BasicNameValuePair("description", newIssue.getDescription())))
                     .returnContent().asString();
         JsonElement parsed = new JsonParser().parse(json);
        return parsed.getAsJsonObject().get("issue_id").getAsInt();
    }
}
