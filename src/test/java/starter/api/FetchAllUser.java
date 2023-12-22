package starter.api;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import io.restassured.path.json.JsonPath;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class FetchAllUser {
    protected static String url = "https://raihpeduli.my.id/users";

    @Step("I set fetch all endpoint")
    public String setEndpoints() {
        return (url + "/?page=1&page_size=10&name=admin");
    }

    @Step("I request get fetch all")
    public void requestFetchAllUser() {
        String accessTokenAdmin = performAuthentication();

        // Debugging: Print request headers
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessTokenAdmin)
                .log().headers()  // Print request headers
                .get(setEndpoints());
    }

    @Step("I successfully fetch all with status code 200")
    public void responseAdmin() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I set invalid fetch all endpoint")
    public String setInvalidEndpoints() {
        return (url + "xxxyyy");
    }

    @Step("I request fetch all")
    public void requestfetchalluser() {
        String accessTokenAdmin = performAuthentication();

        // Debugging: Print request headers
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessTokenAdmin)
                .log().headers()  // Print request headers
                .get(setInvalidEndpoints());
    }

    @Step("I failed fetch all with status code 404")
    public void responseFailed() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("I set valid fetch all endpoint")
    public String setendpoints() {
        return (url + "/?page=1&page_size=10&name=admin");
    }

    @Step("I request fetch all with PUT method")
    public void RequestFetchAlluser() {
        String accessTokenAdmin = performAuth();

        // Debugging: Print request headers
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessTokenAdmin)
                .log().headers()  // Print request headers
                .get(setendpoints());
    }

    @Step("I failed fetch all with status code 401")
    public void Responsefail() {
        restAssuredThat(response -> response.statusCode(401));
    }

    private String performAuthentication() {
        JSONObject body = new JSONObject();
        body.put("email", "admin@raihpeduli.my.id");
        body.put("password", "user12345");

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).post("https://raihpeduli.my.id/auth/login");

        String responseBody = SerenityRest.lastResponse().asString();
        JsonPath jsonPath = new JsonPath(responseBody);

        // Debugging: Print access token
        System.out.println("Access Token: " + jsonPath.getString("data.access_token"));

        return jsonPath.getString("data.access_token");
    }

    private String performAuth() {
        JSONObject body = new JSONObject();
        body.put("email", "admin@raihpeduli.my.id");
        body.put("password", "user12345");

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).put("https://raihpeduli.my.id/auth/login");

        String responseBody = SerenityRest.lastResponse().asString();
        JsonPath jsonPath = new JsonPath(responseBody);

        // Debugging: Print access token
        System.out.println("Access Token: " + jsonPath.getString("data.access_token"));

        return jsonPath.getString("data.access_token");
    }
}