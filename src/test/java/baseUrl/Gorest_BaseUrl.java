package baseUrl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Gorest_BaseUrl {

    public static RequestSpecification spec;

    public static void setupGorest(){
        spec= new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer xxxxxxxxxxxxxxxxxxxxxxxx")
                .setContentType(ContentType.JSON)
                .setBaseUri("https://gorest.co.in/").build();
    }


}
