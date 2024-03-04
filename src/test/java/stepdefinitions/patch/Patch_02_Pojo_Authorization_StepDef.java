package stepdefinitions.patch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.Heroku.BookingDates_Pojo;
import pojo.Heroku.HerokuApp_Pojo;

import java.util.Optional;

import static baseUrl.Herokuapp_BaseUrl_Authentication.specHeroku_Authentication;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.junit.Assert.assertEquals;

public class Patch_02_Pojo_Authorization_StepDef {
    /*
GIVEN
    https://restful-booker.herokuapp.com/booking/1

   {
        "firstname" : "Maho",
        "lastname" : "Ağa"
    }
WHEN
    I send PATCH request to the URL
THEN
    Status code should be 200
    And response body should be
    {
        "firstname" : "Maho",
        "lastname" : "Maho",
        "totalprice" : 111,
        "depositpaid" : true,
        "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
                         },
         "additionalneeds" : "Breakfast"
    }
 */


    HerokuApp_Pojo expectedData;
    Response response;
    @Given("heroku url olusturulur")
    public void herokuUrlOlusturulur() {
        //1- set the url
        specHeroku_Authentication.pathParams("a", "booking", "b", 1);
    }

    @And("expected data olusur")
    public void expectedDataOlusur() {
        //2- set the expected data
        BookingDates_Pojo bookingDatesPojo=new BookingDates_Pojo(null,null);
         expectedData=new HerokuApp_Pojo("Maho","Ağa",null,null,bookingDatesPojo,null);
    }

    @When("request gonderilir ve response alinir")
    public void requestGonderilirVeResponseAlinir() {
        //3- send the request and get the response
       response =given(specHeroku_Authentication).body(expectedData).patch("{a}/{b}");
        response.prettyPrint();
    }

    @Then("body dogrulanir")
    public void bodyDogrulanir() {
        //4- do assertion
        HerokuApp_Pojo actualData= response.as(HerokuApp_Pojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());

    }



}
