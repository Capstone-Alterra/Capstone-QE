package starter.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.api.Login;

public class LoginSteps {
    @Steps
    Login log;

    @Given("I set login endpoint")
    public void getLogEndpoint() {
        log.setEndpoints();
    }
    @When("I send login POST HTTP request and fill body parameter")
    public void sendLogPostHTTPReq() {
        log.sendLogPostHTTPrequest();
    }
    @Then("I successfully login with status code 200")
    public void successLog200() {
        log.response();
    }

    @Given("I set valid login endpoint")
    public void setLogEndpoint() {
        log.setEndpoints2();
    }
    @When("I send login POST HTTP request with empty email and password")
    public void sendLogPostHTTPReqEmptyField() {
        log.sendLogPostHTTPrequest2();
    }
    @Then("I fail login with status code 400")
    public void failLog400() {
        log.response2();
    }

    @Given("I set valid login endpoint url")
    public void setLogEndpointUrl() {
        log.setEndpoints3();
    }
    @When("I send login POST HTTP request with empty email")
    public void sendLogPostHTTPReqEmptyEmail() {
        log.sendLogPostHTTPrequest3();
    }
    @Then("I failed login with status code 400")
    public void failedLog400() {
        log.response3();
    }

    @Given("I set login endpoint url")
    public void logEndpointUrl() {
        log.setEndpoints4();
    }
    @When("I send login POST HTTP request with empty password")
    public void sendLogPostHTTPReqEmptyPassword() {
        log.sendLogPostHTTPrequest4();
    }
    @Then("I fail to login with status code 400")
    public void failToLog400() {
        log.response4();
    }

    @Given("I set login endpoints")
    public void setLogEndpoints() {
        log.setEndpoints5();
    }
    @When("I send login POST HTTP request with invalid email")
    public void sendLogPostHTTPReqInvEmail() {
        log.sendLogPostHTTPrequest5();
    }
    @Then("I failed to login with status code 401")
    public void failedToLog400() {
        log.response5();
    }

    @Given("I set login endpoints url")
    public void setLogEndpointsUrl() {
        log.setEndpoints6();
    }
    @When("I send login POST HTTP request fill email with username")
    public void sendLogPostHTTPReqFillEmWUsername() {
        log.sendLogPostHTTPrequest6();
    }
    @Then("I cant login and get status code 400")
    public void cantLog400() {
        log.response6();
    }

    @Given("I set valid login endpoints url")
    public void setValidLogEndpointsUrl() {
        log.setEndpoints7();
    }
    @When("I send login POST HTTP request with invalid parameter")
    public void sendLogPostHTTPReqInvalidParam() {
        log.sendLogPostHTTPrequest7();
    }
    @Then("I can not login and get status code 400")
    public void canNotLog400() {
        log.response7();
    }

    @Given("I set valid endpoints url")
    public void setValidEndpointsUrl() {
        log.setEndpoints8();
    }
    @When("I send login POST HTTP request with empty body")
    public void sendLogPostHTTPReqEmptyBody() {
        log.sendLogPostHTTPrequest8();
    }
    @Then("I can not login and get response code 400")
    public void canNotLogResponse400() {
        log.response8();
    }

    @Given("I set valid endpoint url")
    public void setValidEndpointUrl() {
        log.setEndpoints9();
    }
    @When("I send login POST HTTP request with wrong method")
    public void sendLogPostHTTPReqWrongMethod() {
        log.sendLogPostHTTPrequest9();
    }
    @Then("I can not login and get response code 405")
    public void canNotLogResponse405() {
        log.response9();
    }
}
