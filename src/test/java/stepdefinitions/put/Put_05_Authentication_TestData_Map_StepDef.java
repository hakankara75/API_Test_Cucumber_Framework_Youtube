package stepdefinitions.put;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Herokuapp_TestData;
import utilities.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.Herokuapp_BaseUrl_Authentication.specHeroku_Authentication;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication_HerokuApp.generateToken;

public class Put_05_Authentication_TestData_Map_StepDef {
     /*
    Given
      1) https://restful-booker.herokuapp.com/booking/1
      2)  {
    "firstname" : "hakan",
    "lastname" : "kara",
    "totalprice" : 1111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2024-01-01",
        "checkout" : "2024-02-01"
    },
    "additionalneeds" : "Dinner but everything little little into the middle"
}
    When
        I send PUT Request to the Url
    Then
       Status code is 200
    And
       response body is like
                                {
    "firstname": "hakan",
    "lastname": "kara",
    "totalprice": 1111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2024-01-01",
        "checkout": "2024-02-01"
    },
    "additionalneeds": "Dinner but everything little little into the middle"
}

                        }
     */
     Map<String ,Object > expectedData;
    Map<String ,String > bookingdatesMap;
    Response response;
    @Given("heroku icin url olusturulur")
    public void herokuIcinUrlOlusturulur() {
        //1- set the url
        specHeroku_Authentication.pathParams("first","booking", "second",1);
    }

    @And("heroku icin expected olusturulur")
    public void herokuIcinExpectedOlusturulur() {
        //2- set the expected data
        Herokuapp_TestData obj=new Herokuapp_TestData();

        bookingdatesMap=obj.bookingdatesMapMethod("2024-01-01","2024-02-01");

       expectedData=obj.outherMapMethod("hakan","kara",1111,true,
                bookingdatesMap,"Dinner but everything little little into the middle");
    }

    @And("request gonderilir response alinir")
    public void requestGonderilirResponseAlinir() {
       response =given(specHeroku_Authentication).body(expectedData).put("{first}/{second}");
       response.prettyPrint();
    }

    @Then("heroku icin response dogrulanir")
    public void herokuIcinResponseDogrulanir() {
        //4- do assertion
        Map<String ,Object > actualData =ObjectMapperUtils.convertData(response.asString(), HashMap.class);

        assertEquals(200, response.statusCode());

        assertEquals(expectedData.get("firstname"), actualData.get("firstname") );
        assertEquals(expectedData.get("lastname"), actualData.get("lastname") );
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice") );
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid") );
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds") );
        assertEquals(bookingdatesMap.get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin") );
        assertEquals(bookingdatesMap.get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout") );

        //2.yol
        assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin") );
        assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout") );

    }


}
