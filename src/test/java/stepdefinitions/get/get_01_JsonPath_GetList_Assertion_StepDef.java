package stepdefinitions.get;

import baseUrl.JsonPlaceHolder_BaseUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class get_01_JsonPath_GetList_Assertion_StepDef extends JsonPlaceHolder_BaseUrl {
                /*
      Given
          https://jsonplaceholder.typicode.com/posts/3/comments
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
And
    Response format should be “application/json”
And
    “email” is “Veronica_Goodwin@timmothy.net”,
And
    “name” is "fugit labore quia mollitia quas deserunt nostrum sunt",
And
    “postId” is 3
     "id" is 11,
     And
    "body" is "ut dolorum nostrum id quia aut est\nfuga est inventore vel eligendi explicabo quis consectetur\naut occaecati repellat id natus quo est\nut blanditiis quia ut vel ut maiores ea"
   */
                Response response;
                @Given("jsonplaceholder sitesinde gidilir")
                public void jsonplaceholderSitesindeGidilir() {
                    //1- set the url
                    spec.pathParams("a", "posts", "b", "3", "c", "comments");

                }

    @And("get yapilir")
    public void getYapilir() {
                    //2- send the request and get the response
       response =given(spec).get("{a}/{b}/{c}");
        response.prettyPrint();
    }

    @Then("body assert edilir")
    public void bodyAssertEdilir() {
                    //3- do assertion
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON);
/*

    “postId” is 3
        "id" is 11,
                And
        "body" is ""
                */
        JsonPath jsonPath=response.jsonPath();
    List<String> nameList= jsonPath.getList("name");
        assertEquals("fugit labore quia mollitia quas deserunt nostrum sunt", nameList.get(0));

        List<String> emailList= jsonPath.getList("email");
        assertEquals("Veronica_Goodwin@timmothy.net", emailList.get(0));

        List<String> bodyList= jsonPath.getList("body");
        assertEquals("ut dolorum nostrum id quia aut est\nfuga est inventore vel eligendi explicabo quis consectetur\naut occaecati repellat id natus quo est\nut blanditiis quia ut vel ut maiores ea", bodyList.get(0));

        List<Integer> postIdList= jsonPath.getList("postId");
        assertEquals(3, postIdList.get(0).intValue());

        List<Integer> idList= jsonPath.getList("id");
        assertEquals(11, idList.get(0).intValue());










    //assertEquals("Veronica_Goodwin@timmothy.net", jsonPath.getString("email.get(0)"));
    }
}
