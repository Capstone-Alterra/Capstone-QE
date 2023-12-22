package starter.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.api.CreateNewUser;

public class CreateNewUserSteps {
    @Steps
    CreateNewUser createnewuser;

    @Given("I set create user endpoint")
    public void getEndpointsCreateNewUser() {
        createnewuser.setEndpointsCreateNewUser();
    }

    @When("I fill valid parameter in body")
    public void sendPostCreateNewUser() {
        createnewuser.fillvalidparameter();
    }

    @Then("I successfully create new user with status code 200")
    public void success200createnewuser() {
        createnewuser.responsecreateuser();
    }

    @Given("I set Create User Endpoint")
    public void getendpointscreatenewuser() {
        createnewuser.setendpointscreatenewuser();
    }

    @When("I fill empty parameter in body")
    public void sendfillemptyparameter() {
        createnewuser.fillemptyparameter();
    }

    @Then("I fail create new user with status code 400")
    public void failcreateuser() {
        createnewuser.responsefailcreateuser();
    }
}
