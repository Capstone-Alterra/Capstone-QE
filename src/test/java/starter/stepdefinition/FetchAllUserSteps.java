package starter.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.api.FetchAllUser;

public class FetchAllUserSteps {
    @Steps
    FetchAllUser fetchAllUser;

    @Given("I set fetch all endpoint")
    public void getEndpoint() {
        fetchAllUser.setEndpoints();
    }

    @When("I request get fetch all")
    public void sendPostHTTPReq() {
        fetchAllUser.requestFetchAllUser();
    }

    @Then("I successfully fetch all with status code 200")
    public void success200() {
        fetchAllUser.responseAdmin();
    }

    @Given("I set invalid fetch all endpoint")
    public void getInvalidEndpoint() {
        fetchAllUser.setInvalidEndpoints();
    }

    @When("I request fetch all")
    public void sendGetHTTPReq() {
        fetchAllUser.requestfetchalluser();
    }

    @Then("I failed fetch all with status code 404")
    public void failed404() {
        fetchAllUser.responseFailed();
    }

    @Given("I set valid fetch all endpoint")
    public void geendpoint() {
        fetchAllUser.setendpoints();
    }

    @When("I request fetch all with PUT method")
    public void sendHTTPReq() {
        fetchAllUser.RequestFetchAlluser();
    }

    @Then("I failed fetch all with status code 401")
    public void failed401() {
        fetchAllUser.Responsefail();
    }
}
