package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class Authentication_HerokuApp {

    public static String generateToken(){
        String body="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

       Response response= given().body(body).contentType(ContentType.JSON).post("https://restful-booker.herokuapp.com/auth");
        response.prettyPrint();
       return response.jsonPath().getString("token");

    }
}
