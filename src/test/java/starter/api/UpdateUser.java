package starter.api;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UpdateUser {
    protected static String url = "https://raihpeduli.my.id";

    public static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE3MDIyODQyOTksInJvbGVfaWQiOiIyIiwidXNlcl9pZCI6IjM1In0.xt1-xQ4NBUYQxyXWEPyTFsZB78GcCYLdfl4Ejl1J3jA";

    @Step("I set update user endpoint")
    public String setEndpointsUpdateUser() {
        return (url + "/users/1");
    }

    @Step("I fill valid parameter update in body")
    public void fillvalidparameterupdate() {
        JSONObject body = new JSONObject();
        body.put("fullname","defhita cantik");
        body.put("address","Purwokerto");
        body.put("phone_number","08976554399");
        body.put("gender","female");
        body.put("email","depita@ittelkom-pwt.ac.id");
        body.put("profil_picture","www.drive.com/depp");

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).post(setEndpointsUpdateUser());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("I successfully update user with status code 200")
    public void responseupdateuser() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I set Update User Endpoint")
    public String setendpointsupdateuser() {
        return (url + "/users/1");
    }

    @Step("I fill empty parameter update in body")
    public void fillemptyparameterupdate() {
        JSONObject body = new JSONObject();
        body.put("fullname","defhita cantik");
        body.put("address","Purwokerto");
        body.put("phone_number","08976554399");
        body.put("gender","female");
        body.put("email","depita@ittelkom-pwt.ac.id");
        body.put("profil_picture","www.drive.com/depp");

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).post(setendpointsupdateuser());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("I fail update user with status code 405")
    public void responseemptyupdateuser() {
        restAssuredThat(response -> response.statusCode(405));
    }

}
