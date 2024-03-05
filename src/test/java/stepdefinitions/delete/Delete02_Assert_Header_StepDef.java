package stepdefinitions.delete;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.Faker_Pojo;

import static baseUrl.Faker_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete02_Assert_Header_StepDef {
    /*
GIVEN
https://fakerestapi.azurewebsites.net/api/v1/Activities/2
WHEN
I send DELETE request to the URL
THEN
Status code should be 200
AND
Header should be
    api-supported-versions: 1.0
    Content-Length: 0
    Date: Fri09 Feb 2024 17:11:44 GMT
    Server: Kestrel
*/
    Faker_Pojo expectedData;

    Response response;
    @Given("fakerestapi icin url olusturulur")
    public void fakerestapiIcinUrlOlusturulur() {
        //1- set the url
        spec.pathParams("a", "api", "b","v1", "c", "Activities", "d", 4);
    }

    @And("fakerestapi icin expected data olusturulur")
    public void fakerestapiIcinExpectedDataOlusturulur() {
        //2- set the expected data
        expectedData = new Faker_Pojo();
    }

    @When("fakerestapi icin request ve response yapilir")
    public void fakerestapiIcinRequestVeResponseYapilir() {
        //3- send the request and get the response
        response =given(spec).body(expectedData).delete("{a}/{b}/{c}/{d}");
        response.prettyPrint();
    }

    @Then("fakerestapi icin response dogrulanir")
    public void fakerestapiIcinResponseDogrulanir() {
        //4- do assertion
        assertEquals(200, response.statusCode());
        String expectedVersion ="1.0";
        Integer expectedContentLength =0;
        String expectedServer ="Kestrel";

        String actualVersion=response.header("api-supported-versions");
        Integer actualContentLength = Integer.valueOf(response.header("Content-Length"));
        String actualServer =response.header("Server");

        assertEquals(expectedVersion, actualVersion);
        assertEquals(expectedContentLength, actualContentLength);
        assertEquals(expectedServer, actualServer);
    }
}
