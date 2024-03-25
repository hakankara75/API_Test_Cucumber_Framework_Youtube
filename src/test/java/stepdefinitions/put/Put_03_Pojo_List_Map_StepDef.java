package stepdefinitions.put;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojo.PetStore.JSON.Category;
import pojo.PetStore.JSON.Root;
import pojo.PetStore.JSON.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseUrl.PetStore_BaseUrl.specPetStore;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put_03_Pojo_List_Map_StepDef {
    /*
   Given
       https://petstore.swagger.io/v2/pet
   When
       User send a PUT Request like that body to the url like that body
       {
  "id": 75,
  "category": {
    "id": 1,
    "name": "köpek"
  },
  "name": "gollo",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 1,
      "name": "güzel köpek"
    }
  ],
  "status": "available"
}
   Then
       HTTP Status code should be 200

*/
    Root expectedData;
    Response response;
    @Given("put icin petstore url girilir")
    public void putIcinPetstoreUrlGirilir() {
        //1- set the url
        specPetStore.pathParam("first", "pet");

    }

    @And("put icin expected data olusturulur")
    public void putIcinExpectedDataOlusturulur() {
        //2- set the expected data

        Category category=new Category(1,"köpek");
        ArrayList<String> photoUrls=new ArrayList<String>();

        String str="C:/Users/";
        photoUrls.add(str);

        Tag tag=new Tag(1,"güzel köpek");
        List<Tag> tagList=new ArrayList<>();
        tagList.add(tag);

        expectedData = new Root(75,category,"gollo",photoUrls,
                (ArrayList<Tag>) tagList, "available");


    }

    @And("put icin request ve response olusturulur")
    public void putIcinRequestVeResponseOlusturulur() {
        //3- send the request and get the response
         response =given(specPetStore).body(expectedData).put("{first}");
         response.prettyPrint();
    }

    @Then("put icin dogrulama yapilir")
    public void putIcinDogrulamaYapilir() {
        Map<String , Object> actualData= response.as(HashMap.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getId(), actualData.get("id"));
        assertEquals(expectedData.getCategory().getId(),((Map)actualData.get("category")).get("id"));
        assertEquals(expectedData.getCategory().getName(),((Map)actualData.get("category")).get("name"));
        assertEquals(expectedData.getName(), actualData.get("name"));
        assertEquals(expectedData.getPhotoUrls(), actualData.get("photoUrls"));

        List<Map<String , Object>> actualTagsList= (List<Map<String, Object>>) actualData.get("tags");
        assertEquals(expectedData.getTags().get(0).getId(), actualTagsList.get(0).get("id"));
        assertEquals(expectedData.getTags().get(0).getName(), actualTagsList.get(0).get("name"));

        assertEquals(expectedData.getStatus(), actualData.get("status"));

        //2. yol
        Root actualRoot =response.as(Root.class);
        assertEquals(expectedData.getId(), actualRoot.getId());
        assertEquals(expectedData.getCategory().getId(), actualRoot.getCategory().getId());

    }
}
