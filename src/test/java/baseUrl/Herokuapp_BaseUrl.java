package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Herokuapp_BaseUrl {
    public static RequestSpecification specHeroku;
    public static void setupHerokuapp(){
        specHeroku=new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://restful-booker.herokuapp.com/").build();
    }

}
