package stepdefinitions.xml;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.PetStore_BaseUrl_XML_Post_Jsoup.specPetStore_XML_Post_Jsoup;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post_02_XML_Map_Jsoup_StepDef {
    /*
Given
https://petstore.swagger.io/v2/user

        {
     "id": 224234,
     "username": "Hakan",
     "firstName": "Hakan",
     "lastName": "Kara",
     "email": "hakan@gmail.com",
     "password": "123456",
     "phone": "123456",
     "userStatus": 1
           }
When
User send a POST Request to the url
Then
HTTP Status code should be 200
And
Content Type should be application/xml
And
Connection should be keep-alive
And
response body is like

<apiResponse>
    <message>9223372036854775807</message>
     <type>unknown</type>
</apiResponse>
*/
    Map<String, Object> expectedData;
    Response response;
    @Given("petstore urle gidilir")
    public void petstoreUrleGidilir() {
        //1- set the url
        specPetStore_XML_Post_Jsoup.pathParam("first", "user");
    }

    @And("xml icin expected data olusturulur")
    public void xmlIcinExpectedDataOlusturulur() {
        //2- set the expected data
        expectedData = new HashMap<>();
        expectedData.put("id", 224234);
        expectedData.put("username", "Hakan");
        expectedData.put( "firstName", "Hakan");
        expectedData.put("lastName", "Kara");
        expectedData.put("email", "hakan@gmail.com");
        expectedData.put("password", "123456");
        expectedData.put("phone", "123456");
        expectedData.put("userStatus", 1);

    }

    @And("xml icin request gonderilir ve response alinir")
    public void xmlIcinRequestGonderilirVeResponseAlinir() {
        response= given(specPetStore_XML_Post_Jsoup).body(expectedData).post("{first}");
        response.prettyPrint();
    }

    @Then("xml body dogrulanir")
    public void xmlBodyDogrulanir() {

        String responseBody=response.getBody().asString();
        Document document= Jsoup.parse(responseBody);

        String expectedMessage="224234";
        String expectedType="unknown";

        String actualMessage=document.select("apiResponse > message").text();
        String actualType=document.select("apiResponse > type").text();

        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedType, actualType);

        assertEquals(200,response.getStatusCode());
        assertEquals("application/xml",response.contentType());
        assertEquals("keep-alive",response.getHeaders().get("Connection").getValue());


    }
}
