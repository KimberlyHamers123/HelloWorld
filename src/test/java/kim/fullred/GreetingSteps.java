package kim.fullred;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GreetingSteps {


    @When("^user send a get request to the greeting endpoint$")
    public void sendGetRequest() throws IOException {
        URL url = new URL("http://localhost:8083/greeting");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        ObjectStore.getInstance().put("response", response.toString());
    }

    @Then("a default greeting will be returned")
    public void aGreetingWillBeReturned() {
        String response = ObjectStore.getInstance().get("response");
        Assert.assertTrue(response.contains("Hello, World!"));
    }
}
