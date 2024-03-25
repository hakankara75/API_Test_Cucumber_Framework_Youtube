package stepdefinitions.patch;

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

public class Patch_03_ObjectMapperUtils_Map_StepDef {
    /*
    GIVEN
       https://reqres.in/api/users/3
    {
        "name": "Bilo",
        "job": "Banker Bilo"
    }
    WHEN
        I send PATCH request to the URL
    THEN
        Status code should be 200
        And response body should be
    {
        "name": "Bilo",
        "job": "Banker Bilo"
        "updatedAt": "2024-02-14T17:06:55.948Z"
    }
     */
    Map<String, String> expectedData;
    Response response;
    @Given("reqres api urle gidilir")
    public void reqresApiUrleGidilir() {
        //1- set url
        specification.pathParams("a","api", "b", "users" , "c", 3);

    }

    @And("reqres expecpected data olusturulur")
    public void reqresExpecpectedDataOlusturulur() {
        //2- set the expected data
        expectedData = new HashMap<>();
        expectedData.put("name","Bilo");
        expectedData.put("job","Banker Bilo");
        System.out.println("expectedData = " + expectedData);

    }

    @And("reqres request gonderilir ve response alinir")
    public void reqresRequestGonderilirVeResponseAlinir() {
        //3- send the request and get the response
       response =given(specification).body(expectedData).patch("{a}/{b}/{c}");
       response.prettyPrint();
    }

    @Then("reqres json body dogrulanir")
    public void reqresJsonBodyDogrulanir() {
        //4- do assertion
        Map<String,String> actualData=ObjectMapperUtils.convertData(response.asString(), HashMap.class);

        assertEquals(200, response.statusCode());

        assertEquals(expectedData.get("name"), actualData.get("name"));
        assertEquals(expectedData.get("job"), actualData.get("job"));
    }


}
