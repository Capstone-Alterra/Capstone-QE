package starter.api;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateNewUser {
    protected static String url = "https://raihpeduli.my.id";

    public static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE3MDIyODQyOTksInJvbGVfaWQiOiIyIiwidXNlcl9pZCI6IjM1In0.xt1-xQ4NBUYQxyXWEPyTFsZB78GcCYLdfl4Ejl1J3jA";

    @Step("I set create user endpoint")
    public String setEndpointsCreateNewUser() {
        return (url + "/users");
    }

    @Step("I fill valid parameter in body")
    public void fillvalidparameter() {
        JSONObject body = new JSONObject();
        body.put("fullname","Anggara anggara");
        body.put("address","Purwokerto");
        body.put("phone_number","08976554399");
        body.put("gender","male");
        body.put("email","ijasss@ittelkom-pwt.ac.id");
        body.put("password","anggara123");

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).post(setEndpointsCreateNewUser());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("I successfully fetch all with status code 200")
    public void responsecreateuser() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I set Create User Endpoint")
    public String setendpointscreatenewuser() {
        return (url + "/users");
    }

    @Step("I fill empty parameter in body")
    public void fillemptyparameter() {
        JSONObject body = new JSONObject();
        body.put("","");
        body.put("","");
        body.put("","");
        body.put("","");
        body.put("","");
        body.put("","");

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).post(setendpointscreatenewuser());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("I fail create new user with status code 400")
    public void responsefailcreateuser() {
        restAssuredThat(response -> response.statusCode(400));
    }
}
