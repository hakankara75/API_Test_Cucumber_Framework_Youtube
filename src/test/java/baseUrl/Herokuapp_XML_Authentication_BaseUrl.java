package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Herokuapp_XML_Authentication_BaseUrl {
    public static RequestSpecification specHerokuXML_Authorization;
    public static void setupHerokuapp_XML_Authentication(){
        specHerokuXML_Authorization=new RequestSpecBuilder()
                .addHeader("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=") //post islemine kullanma
                .addHeader("Accept", "application/xml")
                .addHeader("Content-Type","text/xml") // request içeriğinin tipini belirler.
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();
    }

}
