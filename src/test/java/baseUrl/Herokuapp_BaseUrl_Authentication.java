package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.Authentication_HerokuApp.generateToken;

public class Herokuapp_BaseUrl_Authentication {
    public static RequestSpecification specHeroku_Authentication;
    public static void setupHerokuapp_Authentication(){
        specHeroku_Authentication=new RequestSpecBuilder()
                .addHeader("Cookie","token="+generateToken())
                .setContentType(ContentType.JSON)
                .setBaseUri("https://restful-booker.herokuapp.com/").build();
    }

}
