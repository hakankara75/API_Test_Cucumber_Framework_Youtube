package baseUrl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Gorest_BaseUrl {

    public static RequestSpecification spec;

    public static void setupGorest(){
        spec= new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer 32938ff512b9a4a7fb0140d14f0ec0e1dea3e68db30bb738b8a48a5d3dbbc8aa")
                .setContentType(ContentType.JSON)
                .setBaseUri("https://gorest.co.in/").build();
    }


}
