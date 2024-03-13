package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PetStore_BaseUrl_XML_Post_Jsoup {
    public static RequestSpecification specPetStore_XML_Post_Jsoup;
    public static void setupPetStore_XML_Post_Jsoup(){
        specPetStore_XML_Post_Jsoup=new RequestSpecBuilder()
                .addHeader("accept", "application/xml")
                .addHeader("Content-Type", "application/json")
                .setBaseUri("https://petstore.swagger.io/v2/").build();
    }
}
