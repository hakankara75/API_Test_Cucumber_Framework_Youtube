package stepdefinitions.put;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojo.Faker_Books_Pojo;
import pojo.Faker_Pojo;

import static baseUrl.Faker_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put_01_Pojo_Abbas {
    /*
GIVEN
https://fakerestapi.azurewebsites.net/api/v1/Books/1
{
  "id": 0,
  "title": "araştırma",
  "description": "yakın tarih",
  "pageCount": 300,
  "excerpt": "tarih",
  "publishDate": "2024-07-24T18:29:36.894Z"
}
WHEN
I send PUT request to the URL
THEN
Status code should be 200
And response body should be
{
  "id": 0,
  "title": "araştırma",
  "description": "yakın tarih",
  "pageCount": 300,
  "excerpt": "tarih",
  "publishDate": "2024-07-24T18:29:36.894Z"
}
*/

    Response response;
    Faker_Books_Pojo expectedData;

    @Given("faker books url gidilir")
    public void fakerBooksUrlGidilir() {
        //1- set the url
        spec.pathParams("a","api", "b", "v1","c","Books","d",1);

    }

    @And("books url olusturulur")
    public void booksUrlOlusturulur() {
        //2- set the expected data
        expectedData=new Faker_Books_Pojo(1,"araştırma","yakın tarih",300,"tarih","2024-07-24T18:29:36.894Z");


    }

    @And("books icin expected data olusturulur ve gonderilir")
    public void booksIcinExpectedDataOlusturulurVeGonderilir() {
        //3-send the request and get the response
        response =given(spec).body(expectedData).put("{a}/{b}/{c}/{d}");
        response.prettyPrint();
    }

    @Then("books icin response dogrulanir")
    public void booksIcinResponseDogrulanir() {
        //4- do assertion
        Faker_Books_Pojo actualData=response.as(Faker_Books_Pojo.class);

        assertEquals(200, response.statusCode());

        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getDescription(), actualData.getDescription());
        assertEquals(expectedData.getPageCount(), actualData.getPageCount());
        assertEquals(expectedData.getExcerpt(), actualData.getExcerpt());
        assertEquals(expectedData.getPublishDate(), actualData.getPublishDate());
    }
}
