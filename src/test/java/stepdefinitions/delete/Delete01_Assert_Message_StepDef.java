package stepdefinitions.delete;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.Heroku.HerokuApp_Pojo;

import static baseUrl.Herokuapp_BaseUrl_Authentication.specHeroku_Authentication;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete01_Assert_Message_StepDef {
    /*
GIVEN
https://restful-booker.herokuapp.com/booking/4


WHEN
I send DELETE request to the URL
THEN
Status code should be 200 or 201
And
And response body should be
"Created"
*/
    HerokuApp_Pojo expectedData;
    Response response;
    @Given("urle gidilir")
    public void urleGidilir() {
        //1- set the url
        specHeroku_Authentication.pathParams("first", "booking", "second", 4);
    }

    @And("expected data olusturulur")
    public void expectedDataOlusturulur() {
        //2- set the expected data
        expectedData= new HerokuApp_Pojo();

    }

    @When("request ve response yapilir")
    public void requestVeResponseYapilir() {
        //3- send the request and get the response
        response =given(specHeroku_Authentication).body(expectedData).delete("{first}/{second}");
        response.prettyPrint();
    }

    @Then("delete response dogrulanir")
    public void deleteResponseDogrulanir() {
        //4- do assertion
        assertEquals(201,response.statusCode());

        String expectedMessage ="Created";
        String actualMessage= response.getBody().asString();

       assertEquals(expectedMessage, actualMessage);
    }

}
