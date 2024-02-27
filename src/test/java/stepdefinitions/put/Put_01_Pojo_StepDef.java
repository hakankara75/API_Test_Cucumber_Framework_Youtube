package stepdefinitions.put;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Faker_Pojo;

import static baseUrl.Faker_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.junit.Assert.assertEquals;

public class Put_01_Pojo_StepDef {
    /*
GIVEN
https://fakerestapi.azurewebsites.net/api/v1/Activities/1
{
"id": 1075,
"title": "marathon",
"dueDate": "2024-03-21T18:57:26.063Z",
"completed": false
}
WHEN
I send PUT request to the URL
THEN
Status code should be 200
And response body should be
   {
"id": 1075,
"title": "marathon",
"dueDate": "2024-03-21T18:57:26.063Z",
"completed": false
}
*/
    Response response;
    Faker_Pojo expectedData;
    @Given("faker url'e gidilir")
    public void fakerUrlEGidilir() {

    }

    @And("url olusturulur")
    public void urlOlusturulur() {
        //1- set the url
        spec.pathParams("a","api", "b", "v1","c","Activities","d",1075);

    }

    @And("expected data olusturulur ve gonderilir")
    public void expectedDataOlusturulurVeGonderilir() {
        //2- set the expected data
        expectedData=new Faker_Pojo(1075,"marathon","2024-03-21T18:57:26.063Z",false);

        //3-send the request and get the response
       response =given(spec).body(expectedData).put("{a}/{b}/{c}/{d}");
       response.prettyPrint();
    }

    @Then("faker response dogrulanir")
    public void fakerResponseDogrulanir() {
        Faker_Pojo actualData=response.as(Faker_Pojo.class);

        assertEquals(200, response.statusCode());

        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getDueDate(), actualData.getDueDate());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());
    }


}
