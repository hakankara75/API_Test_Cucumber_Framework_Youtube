package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Herokuapp_XML_BaseUrl {
    public static RequestSpecification specHerokuXML;
    public static void setupHerokuapp_XML(){
        specHerokuXML=new RequestSpecBuilder()
                .addHeader("Accept", "application/xml")
                .setBaseUri("https://restful-booker.herokuapp.com/").build();
    }

}
