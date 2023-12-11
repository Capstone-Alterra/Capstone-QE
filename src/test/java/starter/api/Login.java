package starter.api;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Login {
    protected static String url = "https://raihpeduli.my.id/auth/login";
    @Step("I set login endpoint")
    public String setEndpoints(){
        return url;
    }
    @Step("I send login POST HTTP request and fill body parameter")
    public void sendLogPostHTTPrequest(){
        JSONObject body = new JSONObject();
        body.put("email","izazrakha@gmail.com");
        body.put("password","izaz123");

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).post(setEndpoints());
    }
    @Step("I successfully login with status code 200")
    public void response(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I set valid login endpoint")
    public String setEndpoints2(){
        return url;
    }
    @Step("I send login POST HTTP request with empty email and password")
    public void sendLogPostHTTPrequest2(){
        JSONObject body = new JSONObject();
        body.put("email","");
        body.put("password","");

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).post(setEndpoints2());
    }
    @Step("I fail login with status code 400")
    public void response2(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I set valid login endpoint url")
    public String setEndpoints3(){
        return url;
    }
    @Step("I send login POST HTTP request with empty email")
    public void sendLogPostHTTPrequest3(){
        JSONObject body = new JSONObject();
        body.put("email","");
        body.put("password","izaz123");

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).post(setEndpoints3());
    }
    @Step("I failed login with status code 400")
    public void response3(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I set login endpoint url")
    public String setEndpoints4(){
        return url;
    }
    @Step("I send login POST HTTP request with empty password")
    public void sendLogPostHTTPrequest4(){
        JSONObject body = new JSONObject();
        body.put("email","izazrakha@gmail.com");
        body.put("password","");

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).post(setEndpoints4());
    }
    @Step("I fail to login with status code 400")
    public void response4(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I set login endpoints")
    public String setEndpoints5(){
        return url;
    }
    @Step("I send login POST HTTP request with invalid email")
    public void sendLogPostHTTPrequest5(){
        JSONObject body = new JSONObject();
        body.put("email","ijas@gmail.com");
        body.put("password","izaz123");

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).post(setEndpoints5());
    }
    @Step("I failed to login with status code 400")
    public void response5(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I set login endpoints url")
    public String setEndpoints6(){
        return url;
    }
    @Step("I send login POST HTTP request fill email with username")
    public void sendLogPostHTTPrequest6(){
        JSONObject body = new JSONObject();
        body.put("email","Izaz Rakha");
        body.put("password","izaz123");

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).post(setEndpoints6());
    }
    @Step("I cant login and get status code 400")
    public void response6(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I set login endpoints url")
    public String setEndpoints7(){
        return url;
    }
    @Step("I send login POST HTTP request with invalid parameter")
    public void sendLogPostHTTPrequest7(){
        JSONObject body = new JSONObject();
        body.put("mail","izazrakha@gmail.com");
        body.put("pwd","izaz123");

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).post(setEndpoints7());
    }
    @Step("I cant login and get status code 400")
    public void response7(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I set valid endpoints url")
    public String setEndpoints8(){
        return url;
    }
    @Step("I send login POST HTTP request with empty body")
    public void sendLogPostHTTPrequest8(){
        JSONObject body = new JSONObject();

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).post(setEndpoints8());
    }
    @Step("I can not login and get response code 400")
    public void response8(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I set login endpoint")
    public String setEndpoints9(){
        return url;
    }
    @Step("I send login POST HTTP request and fill body parameter")
    public void sendLogPostHTTPrequest9(){
        JSONObject body = new JSONObject();
        body.put("email","izazrakha@gmail.com");
        body.put("password","izaz123");

        SerenityRest.given().header("Content-Type", "application/json").body(body.toJSONString()).put(setEndpoints9());
    }
    @Step("I successfully login with status code 200")
    public void response9(){
        restAssuredThat(response -> response.statusCode(405));
    }
}
