package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PetStore_BaseUrl {
    public static RequestSpecification specPetStore;
    public static void setupPetStore(){
        specPetStore=new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/").build();
    }

}
