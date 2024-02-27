package stepdefinitions.put;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojo.Gorest_Pojo;

import static baseUrl.Gorest_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;

public class Put_02_Pojo_Authorization {

    Response response;
    Gorest_Pojo expectedData;
    @Given("gorest urle gidilir ve url olusturulur")
    public void gorestUrleGidilirVeUrlOlusturulur() {

        //1- set the url
        spec.pathParams("a", "public", "b", "v2","c", "users","d", 2139082);
    }

    @And("gorest expected data olusturulur ve gonderilir")
    public void gorestExpectedDataOlusturulurVeGonderilir() {
        //2- set the expected data
         expectedData = new Gorest_Pojo("hakan","hakan@hakan.test","male","active");

        //3- send the request and get the response
         response= given(spec).body(expectedData).put("{a}/{b}/{c}/{d}");
        response.prettyPrint();
    }

    @Then("gorest response dogrulanir")
    public void gorestResponseDogrulanir() {
        // 4- do assertion
        Gorest_Pojo actualData=response.as(Gorest_Pojo.class);

        assertEquals(200, response.statusCode());

        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getEmail(),actualData.getEmail());
        assertEquals(expectedData.getGender(),actualData.getGender());
        assertEquals(expectedData.getStatus(),actualData.getStatus());

        response.then()
                .assertThat()
                .body("id", notNullValue())
                .body("id", equalTo(2139082));

    }


}
