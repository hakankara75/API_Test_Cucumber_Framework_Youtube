package stepdefinitions.put;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilities.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.Reqres_BaseUrl.specification;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put_04_Map_ObjectMapperUtils_StepDef {
    /*
GIVEN
   https://reqres.in/api/users/2
{
    "name": "hakan",
    "job": "zion resident"
}
WHEN
    I send PUT request to the URL
THEN
    Status code should be 200
    And response body should be
{
     "name": "hakan",
    "job": "zion resident",
    "updatedAt": "2024-02-14T17:06:55.948Z"
}
 */
    Map<String,String > expectedData;
    Response response;
    @Given("reqres urle gidilir")
    public void reqresUrleGidilir() {
        //1- set the url
        specification.pathParams("first", "api", "second", "users", "third",2);
    }

    @And("expecpected data olusturulur")
    public void expecpectedDataOlusturulur() {
        //2- set expected data
         expectedData = new HashMap<>();
        expectedData.put("name", "hakan");
        expectedData.put("job", "zion resident");
    }

    @And("request gonderilip response alinir")
    public void requestGonderilipResponseAlinir() {
        //3- send the request and get the response
       response =given(specification).body(expectedData).put("{first}/{second}/{third}");
       response.prettyPrint();
    }

    @Then("dogrulanir")
    public void dogrulanir() {
        //4- do assertion
       Map<String, String> actualData=ObjectMapperUtils.convertData(response.asString(), HashMap.class);

       assertEquals(200, response.statusCode());
       assertEquals(expectedData.get("name"), actualData.get("name"));
       assertEquals(expectedData.get("job"), actualData.get("job"));


    }

}
