package stepdefinitions.post;

import baseUrl.Herokuapp_BaseUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilities.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post_04_ObjectMapper_String_Map_StepDef extends Herokuapp_BaseUrl {
    /*

 Given
1) https://restful-booker.herokuapp.com/booking
2)
{
    "firstname" : "Hakan",
    "lastname" : "Kara",
    "totalprice" : 175,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2025-01-01",
        "checkout" : "2025-02-01"
    },
    "additionalneeds" : "Breakfast"
}

When
    I send POST Request to the Url
Then
    Status code is 200
    And response body should be like
        {
    "bookingid": 1991,
    "booking": {
        "firstname": "Hakan",
        "lastname": "Kara",
        "totalprice": 175,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2025-01-01",
            "checkout": "2025-02-01"
        },
        "additionalneeds": "Breakfast"
        }
            }

     */
    Map<String , Object> expectedData;
    Response response;
    @Given("heroku sitesine git")
    public void herokuSitesineGit() {
        //1- set the url
        specHeroku.pathParam("first", "booking");
        String expected="{\n" +
                "    \"firstname\" : \"Hakan\",\n" +
                "    \"lastname\" : \"Kara\",\n" +
                "    \"totalprice\" : 175,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-01-01\",\n" +
                "        \"checkout\" : \"2025-02-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        //2- set the expected data
      expectedData=ObjectMapperUtils.convertData(expected, HashMap.class);

    }

    @And("request gonder")
    public void requestGonder() {
        //3- send the request and get the response
       response =given(specHeroku).body(expectedData).post("{first}");
       response.prettyPrint();
    }


    @Then("dogrula")
    public void dogrula() {
        Map<String , Object> actualData= ObjectMapperUtils.convertData(response.asString(), HashMap.class);

        //4- do assertion
        assertEquals(200, response.statusCode());
        /*
    "bookingdates" : {
        "checkin" : "2025-01-01",
        "checkout" : "2025-02-01"
    },
    "additionalneeds" : "Breakfast"
         */
        assertEquals(expectedData.get("firstname"), ((Map)actualData.get("booking")).get("firstname"));
        assertEquals(expectedData.get("lastname"), ((Map)actualData.get("booking")).get("lastname"));
        assertEquals(expectedData.get("depositpaid"), ((Map)actualData.get("booking")).get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"), ((Map)actualData.get("booking")).get("additionalneeds"));
        assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkout"));

    }


}
