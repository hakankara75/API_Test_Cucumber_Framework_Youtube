package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static baseUrl.Reqres_BaseUrl.specification;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post_01_String_StepDef {
    /*
       Given
           1) https://reqres.in/api/users
           2) {
               "name": "Hakan Kara",
               "job": "leader"
               }
       When
           I send POST Request to the Url
       Then
           Status code is 201
           And response body should be like {
                                               "name": "Hakan Kara",
                                               "job": "leader",
                                               "id": "354",
                                               "createdAt": "2024-02-06T09:20:25.174Z"
                                             }
    */
    Response response;
    @Given("kullanici {string} sitesine gider")
    public void kullaniciSitesineGider(String arg0) {
        //1- set the ur
        specification.pathParam("a", "users");
    }

    @And("post islemi yapar")
    public void postIslemiYapar() {
        //2- set the expected data
        String payLoad= "{\n" +
                "    \"name\": \"Hakan Kara\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        //3- send the request and get the response
        response=given(specification).body(payLoad).post("{a}");
        response.prettyPrint();
    }

    @Then("response dogrulanir")
    public void responseDogrulanir() {
        assertEquals(201,response.statusCode());
        JsonPath jsonPath=response.jsonPath();
        String expectedName= "Hakan Kara";
        String actualName= jsonPath.getString("name");

        String expectedJob= "leader";
        String actualJob= jsonPath.getString("job");

        assertEquals(expectedName,actualName);
        assertEquals(expectedJob,actualJob);

    }


}
