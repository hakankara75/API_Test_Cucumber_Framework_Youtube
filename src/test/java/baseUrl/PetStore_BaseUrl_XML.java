package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PetStore_BaseUrl_XML {
    public static RequestSpecification specPetStore_XML;
    public static void setupPetStore_XML(){
        specPetStore_XML=new RequestSpecBuilder()
                .addHeader("accept", "application/json")
                .addHeader("Content-Type", "application/xml")
                .setAccept(ContentType.XML)
                .setBaseUri("https://petstore.swagger.io/v2/").build();
    }
}
