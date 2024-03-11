package stepdefinitions.patch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilities.JsonPlaceHolder_TestData;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.JsonPlaceHolder_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch_01_Map_If_TestData_StepDef {
/*
GIVEN
    https://jsonplaceholder.typicode.com/posts/5

    {
    "title": "Tamir edilecekler listesi",
    }
WHEN
    I send PATCH request to the URL
THEN
    Status code should be 200
    And response body should be
        {
    "userId": 1,
    "id": 5,
    "title": "Tamir edilecekler listesi",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
        }
 */
Response response;
    Map<String, Object> expectedData;
    @Given("kullanici jsonplaceholder sitesine gider")
    public void kullaniciJsonplaceholderSitesineGider() {
        //1-set the url
        spec.pathParams("a", "posts", "b", 5);

    }

    @And("herokuapp sitesinde patch islemi yapar")
    public void herokuappSitesindePatchIslemiYapar() {
        //2- set the expected data  serialization
         expectedData= new JsonPlaceHolder_TestData().expectedPatchDataMap(null, null,"Tamir edilecekler listesi",null);

        //3- set the expected data and get the response
        response =given(spec).body(expectedData).patch("{a}/{b}");
        response.prettyPrint();

    }

    @Then("pattch den gelen response dogrulanir")
    public void pattchDenGelenResponseDogrulanir() {
        //response alindiktan sonra expected dataya kalan body put yapilir
        expectedData.put("userId",1);
        expectedData.put("id", 5);
        expectedData.put("body", "repudiandae veniam quaerat sunt sed\nalias aut fugiat sit autem sed est\nvoluptatem omnis possimus esse voluptatibus quis\nest aut tenetur dolor neque"
        );


        //4- do assertion  de serialization
        Map<String, Object> actualData=response.as(HashMap.class);

        assertEquals(200, response.statusCode());

        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("id"), actualData.get("id"));
        assertEquals(expectedData.get("body"), actualData.get("body"));
    }



}
