package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilities.Herokuapp_TestData;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.Herokuapp_BaseUrl.specHeroku;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post_03_TestData_Map_StepDef {

    /*
    Given
      1) https://restful-booker.herokuapp.com/booking
      2)  {
    "firstname" : "hakan",
    "lastname" : "kara",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
    When
        I send POST Request to the Url
    Then
       Status code is 200
    And
       response body is like
                                {
                            "bookingid": 1258,
                            "booking": {
                                "firstname": "hakan",
                                "lastname": "kara",
                                "totalprice": 275,
                                "depositpaid": true,
                                "bookingdates": {
                                    "checkin": "2024-01-01",
                                    "checkout": "2024-02-01"
                                },
                                "additionalneeds": "Breakfast"
                            }
                        }
     */
    Map<String, Object> expectedData;
    Response response;
    Map<String, String > bookingDatesMap;
    @Given("kullanici herokuapp sitesine gider")
    public void kullaniciHerokuappSitesineGider() {
        //1- set the url
        specHeroku.pathParam("first", "booking");

        //2- set the expected data
        //serialization
        Herokuapp_TestData obje=new Herokuapp_TestData();
        bookingDatesMap= obje.bookingdatesMapMethod("2024-01-01","2024-02-01" );
        expectedData= obje.outherMapMethod("hakan", "kara",275,
                true,bookingDatesMap, "Breakfast");
        System.out.println("expectedData = " + expectedData);
    }

    @And("herokuapp sitesinde post islemi yapar")
    public void herokuappSitesindePostIslemiYapar() {
        //3- Send the request and get the response
        response =given(specHeroku).body(expectedData).post("{first}");
        System.out.println("response = " + response);
    }

    @Then("herokuapp sitesinden gelen response dogrulanir")
    public void herokuappSitesindenGelenResponseDogrulanir() {
        //4- Do assertion
        // de serialization
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());

        assertEquals(expectedData.get("firstname"), ((Map)actualData.get("booking")).get("firstname"));
        assertEquals(expectedData.get("lastname"), ((Map)actualData.get("booking")).get("lastname"));
        assertEquals(expectedData.get("totalprice"), ((Map)actualData.get("booking")).get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), ((Map)actualData.get("booking")).get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"), ((Map)actualData.get("booking")).get("additionalneeds"));
        assertEquals(bookingDatesMap.get("checkin"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(bookingDatesMap.get("checkout"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkout"));

        assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"), ((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkout"));
        /*
        {

            "bookingid": 1258,
                "booking": {
                     "firstname": "hakan",
                    "lastname": "kara",
                    "totalprice": 275,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2024-01-01",
                        "checkout": "2024-02-01"
            },
                    "additionalneeds": "Breakfast"
        }
        } */
    }







}
