package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.JsonPlaceHolder_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post_02_Map_StepDef {
    /*
       Given
         1)  https://jsonplaceholder.typicode.com/todos
         2)  {
               "userId": 75,
               "title": "Dag manzarali",
               "completed": false
              }
      When
       I send POST Request to the Url
      Then
          Status code is 201
      And
          response body is like {
                                  "userId": 75,
                                  "title": "Dag manzarali",
                                  "completed": false,
                                  "id": 201
                                  }
   */
    Map<String, Object> expectedData;
    Response response;
    @Given("kullanici jsonplaceholder.typicode.com\\/todos sitesine gider")
    public void kullaniciJsonplaceholderTypicodeComTodosSitesineGider() {
        //1- set the url
        spec.pathParam("a", "todos");

        //2- set the expected data
        //serialization
         expectedData=new HashMap<>();
        expectedData.put("userId", 75);
        expectedData.put("title", "Dag manzarali");
        expectedData.put("completed", false);

    }

    @And("jsonplaceholder sitesinde post islemi yapar")
    public void jsonplaceholderSitesindePostIslemiYapar() {
        //3- set the request and get the response
        response =given(spec).body(expectedData).post("{a}");
        response.prettyPrint();



    }

    @Then("jsonplaceholder sitesinden gelen response dogrulanir")
    public void jsonplaceholderSitesindenGelenResponseDogrulanir() {
        //4- do assertion
        //de serialization - json'dan java ya ceviriliyor
        Map<String, Object> actualData=response.as(HashMap.class);
        assertEquals(201, response.statusCode());

        String expectedUserId=expectedData.get("userId").toString();
        System.out.println("expectedUserId = " + expectedUserId);
        String actualUserId=actualData.get("userId").toString();
        System.out.println("actualUserId = " + actualUserId);

        String expectedTitle=expectedData.get("title").toString();
        String actualTitle=actualData.get("title").toString();

        String expectedCompleted=expectedData.get("completed").toString();
        String actualCompleted=actualData.get("completed").toString();

        assertEquals(expectedUserId, actualUserId);
        assertEquals(expectedTitle, actualTitle);
        assertEquals(expectedCompleted, actualCompleted);


    }

}
