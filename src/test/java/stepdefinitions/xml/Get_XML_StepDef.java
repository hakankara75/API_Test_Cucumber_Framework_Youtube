package stepdefinitions.xml;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static baseUrl.Herokuapp_XML_BaseUrl.specHerokuXML;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get_XML_StepDef {
    /*
   Given
       https://restful-booker.herokuapp.com/booking/2?lastname=Smith
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 200
    And
       Content Type should be text/html; charset=utf-8
   And
       Status Line should be HTTP/1.1 200 OK
   And
       "firstname" is "Susan",
   And
      "lastname" is "Smith",
   And
       "totalprice" is 755,
   And
       "depositpaid" is false,
    And
       "checkin" is "2017-09-01",
    And
       "checkout" is "2020-07-15",
*/
    Response response;
    @Given("heroku baseurl gidilir")
    public void herokuBaseurlGidilir() {
        //1- set the url
            specHerokuXML.pathParams("first", "booking", "second", 2).
                queryParam("lastname", "Smith");
    }

    @And("get icin xml request gonderilip response alinir")
    public void getIcinXmlRequestGonderilipResponseAlinir() {
        //2- set the expected data
        //3- send the request and get the response
        response= given(specHerokuXML).get("{first}/{second}");
        response.prettyPrint();
    }

    @And("get icin xml response dogrulanir")
    public void getIcinXmlResponseDogrulanir() {
        //4-do assertion
        response.then()
                .statusCode(200)
                .contentType("text/html; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");

        XmlPath xmlPath= response.xmlPath();
        assertEquals("Susan", xmlPath.getString("booking.firstname"));
        assertEquals("Jackson", xmlPath.getString("booking.lastname"));
        assertEquals(650, xmlPath.getInt("booking.totalprice"));
        assertEquals(true, xmlPath.getBoolean("booking.depositpaid"));
       // assertEquals("Breakfast", xmlPath.getString("booking.additionalneeds"));
        assertEquals("2016-11-08", xmlPath.getString("booking.bookingdates.checkin"));
        assertEquals("2021-07-06", xmlPath.getString("booking.bookingdates.checkout"));

}
}