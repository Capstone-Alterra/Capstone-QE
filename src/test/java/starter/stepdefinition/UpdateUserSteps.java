package starter.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.api.UpdateUser;

public class UpdateUserSteps {
    @Steps
    UpdateUser updateuser;

    @Given("I set update user endpoint")
    public void getEndpointsUpdateUser() {
        updateuser.setEndpointsUpdateUser();
    }

    @When("I fill valid parameter update in body")
    public void sendPostUpdateUser() {
        updateuser.fillvalidparameterupdate();
    }

    @Then("I successfully update user with status code 200")
    public void success200updatuser() {
        updateuser.responseupdateuser();
    }

    @Given("I set Update User Endpoint")
    public void getendpointsupdateuser() {
        updateuser.setendpointsupdateuser();
    }

    @When("I fill empty parameter update in body")
    public void sendPostEmptyUpdateUser() {
        updateuser.fillemptyparameterupdate();
    }

    @Then("I fail update user with status code 400")
    public void failed400updatuser() { updateuser.responseemptyupdateuser();}
}
