package stepdefinitions.xml;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import pojo.Heroku.Heroku_Patch_XML_Pojo;

import java.lang.annotation.Documented;

import static baseUrl.Herokuapp_XML_Authentication_BaseUrl.specHerokuXML_Authorization;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.junit.Assert.assertEquals;

public class Patch_Pojo_JSoup_StepDef {
    /*
GIVEN
    https://restful-booker.herokuapp.com/booking/5

   <booking>
    <firstname>Maho</firstname>
    <lastname>Ağa</lastname>
  </booking>
WHEN
    I send PATCH request to the URL
THEN
    Status code should be 200
    And response body should be
    <booking>
    <firstname>Maho</firstname>
    <lastname>Ağa</lastname>
    <totalprice>111</totalprice>
    <depositpaid>true</depositpaid>
    <bookingdates>
      <checkin>2018-01-01</checkin>
      <checkout>2019-01-01</checkout>
    </bookingdates>
    <additionalneeds>Breakfast</additionalneeds>
</booking>
 */
    Heroku_Patch_XML_Pojo expected;
    Response response;
    @Given("patch icin herokuapp urle gidilir")
    public void patchIcinHerokuappUrleGidilir() {
        //1-set the url
        specHerokuXML_Authorization.pathParams("first", "booking", "second", 1);
    }

    @And("patch icin expected data olusturulur")
    public void patchIcinExpectedDataOlusturulur() {
        //2- set the expected data
        expected= new Heroku_Patch_XML_Pojo("Maho", "Ağa");
    }

    @And("patch icin request gonderilir response alinir")
    public void patchIcinRequestGonderilirResponseAlinir() {
        //3- send the request and get the response
        String xmlData = "<booking><firstname>Maho</firstname><lastname>Ağa</lastname></booking>";
        response= given(specHerokuXML_Authorization).body(xmlData).patch("{first}/{second}");
        response.prettyPrint();
    }

    @Then("patch icin dogrulama yapilir")
    public void patchIcinDogrulamaYapilir() {
        //4- do assertion
       String responseBody= response.getBody().asString();
        Document document= Jsoup.parse(responseBody);

        String expectedFirstName= document.select("booking > firstname").text();
        String expectedLastName= document.select("booking > lastname").text();

        assertEquals("Maho",expectedFirstName);
        assertEquals("Ağa",expectedLastName);
    }
}
