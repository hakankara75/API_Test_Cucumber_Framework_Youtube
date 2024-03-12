package stepdefinitions.put;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojo.PetStore.JSON.PetStore_Category_Pojo;
import pojo.PetStore.JSON.PetStore_ExpectedPojo;
import pojo.PetStore.JSON.PetStore_Tags_Pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseUrl.PetStore_BaseUrl.specPetStore;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put_03_Pojo_Lombok_List_StepDef {
      /*
   Given
       https://petstore.swagger.io/v2/pet
   When
       User send a PUT Request like that body to the url like that body
       {
  "id": 75,
  "category": {
    :"id" 1,
    "name": "köpek"
  },
  "name": "gollo",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 1,
      "name": "string"
    }
  ],
  "status": "available"
}
   Then
       HTTP Status code should be 200

*/

    PetStore_ExpectedPojo expectedData;
    Response response;
      @Given("petstore urle gidilir ve url olusturulur")
      public void petstoreUrleGidilirVeUrlOlusturulur() {
          //1- set the url
          specPetStore.pathParam("first", "pet");

      }

    @And("petstore expected data olusturulur ve gonderilir")
    public void petstoreExpectedDataOlusturulurVeGonderilir() {
          //2- set the expected data
        PetStore_Category_Pojo categoryPojo= new PetStore_Category_Pojo(1,"köpek");

        PetStore_Tags_Pojo tagsPojo=new PetStore_Tags_Pojo(1,null);
        List<PetStore_Tags_Pojo> tagsPojoList= new ArrayList<>();
        tagsPojoList.add(tagsPojo);

        expectedData= new PetStore_ExpectedPojo(75, categoryPojo, "gollo", null,
                tagsPojoList, "available");

        //3- send the request and get the response
       response= given(specPetStore).body(expectedData).put("{first}");
       response.prettyPrint();
    }

    @Then("petstore response dogrulanir")
    public void petstoreResponseDogrulanir() {
        //4- do assertion
        Map<String, Object> actualData= response.as(HashMap.class);

        assertEquals(200, response.statusCode());

        assertEquals(expectedData.getId(),actualData.get("id"));
        assertEquals(expectedData.getCategory().getId(),((Map)actualData.get("category")).get("id"));
        assertEquals(expectedData.getCategory().getName(),((Map)actualData.get("category")).get("name"));
        assertEquals(expectedData.getName(),actualData.get("name"));

        List<Map<String, Object>> actualTagsList=(List<Map<String, Object>>)actualData.get("tags");
        assertEquals(expectedData.getTags().get(0).getId(),actualTagsList.get(0).get( "id"));

        assertEquals(expectedData.getStatus(),actualData.get("status"));


    }


}
