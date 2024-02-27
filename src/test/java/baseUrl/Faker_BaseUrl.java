package baseUrl;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Faker_BaseUrl {
    public static RequestSpecification spec;

   public static void setUpFaker() {
        spec=new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://fakerestapi.azurewebsites.net/").build();

    }
}
