package kim.fullred;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GreetingSteps {

    private GreetingHelper greetingHelper;
    private ObjectStore objectStore;

    public GreetingSteps() {
        this.greetingHelper = new GreetingHelper();
        this.objectStore = new ObjectStore();
    }

    @When("^user send a get request to the greeting endpoint$")
    public void sendGetRequest() {
        String response = greetingHelper.doGetRequest();
        objectStore.put("response", response);
    }

    @Then("a default greeting will be returned")
    public void aGreetingWillBeReturned() {
        String response = objectStore.get("response");
        Assert.assertTrue(response.contains("Hello, World!"));
    }

    @When("user send a get request to the greeting endpoint with name {string}")
    public void userSendAGetRequestToTheGreetingEndpointWithName(String name) {
        String response = greetingHelper.doGetRequest(name);
        objectStore.put("response", response);
        objectStore.put("name", name);
    }

    @Then("a greeting will be returned with the same name")
    public void aGreetingWillBeReturnedWithTheSameName() {
        String response = objectStore.get("response");
        String name = objectStore.get("name");
        Assert.assertTrue(response.contains(String.format("Hello, %s", name)));
    }
}
