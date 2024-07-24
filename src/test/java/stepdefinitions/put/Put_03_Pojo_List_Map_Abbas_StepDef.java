package stepdefinitions.put;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojo.PetStore.PetStore_User_Pojo;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.PetStore_BaseUrl.specPetStore;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put_03_Pojo_List_Map_Abbas_StepDef {
    /*
   Given
       https://petstore.swagger.io/v2/user/hakan
   When
       User send a PUT Request like that body to the url like that body
       {
  "id": 0,
  "username": "hakan",
  "firstName": "hakan",
  "lastName": "kara",
  "email": "hakanbatirhan@gmail.com",
  "password": "123456",
  "phone": "123456",
  "userStatus": 0
}
   Then
       HTTP Status code should be 200
   And
        Response body should be
   {
  "code": 200,
  "type": "unknown",
  "message": "9223372036854767813"
}

*/

    PetStore_User_Pojo expectedData;
    Response response;

    @Given("user put icin petstore url girilir")
    public void userPutIcinPetstoreUrlGirilir() {
        //1- set the url
        specPetStore.pathParams("first", "user", "second","hakan");
    }

    @And("user put islemi icin expected data olusturulur")
    public void userPutIslemiIcinExpectedDataOlusturulur() {
        //2- set the expected data
        expectedData=new PetStore_User_Pojo(null,"hakan","hakan", "kara","hakanbatirhan@gmail.com","123456","123456",0);


    }

    @And("user put icin request ve response olusturulur")
    public void userPutIcinRequestVeResponseOlusturulur() {
        //3- send the request and get the response
        response =given(specPetStore).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

    }

    @Then("user put icin dogrulama yapilir")
    public void userPutIcinDogrulamaYapilir() {
        Integer code=200;
        String type="unknown";
        String message="9223372036854767813";
        Map<String , Object> actualData= response.as(HashMap.class);

        assertEquals(200, response.statusCode());
        assertEquals(code, actualData.get("code"));
        assertEquals(type, actualData.get("type"));
        // assertEquals(message, actualData.get("message")); //mesaj surekli degisiyor

    }


}
