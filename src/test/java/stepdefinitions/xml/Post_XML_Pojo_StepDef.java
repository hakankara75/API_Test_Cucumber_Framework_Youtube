package stepdefinitions.xml;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import pojo.PetStore.XML.*;

import java.util.ArrayList;
import java.util.List;

import static baseUrl.PetStore_BaseUrl.specPetStore;
import static baseUrl.PetStore_BaseUrl_XML.specPetStore_XML;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post_XML_Pojo_StepDef {
             /*
   Given
      https://petstore.swagger.io/v2/pet

      <?xml version="1.0" encoding="UTF-8"?>
<Pet>
	<id>1</id>
	<Category>
		<id>1</id>
		<name>Gollo</name>
	</Category>
	<name>Köpek</name>
	<photoUrls>
		<photoUrl>data:image/jpeg;base64,/9j/2w3afky/IdP3UX7</photoUrl>
	</photoUrls>
	<tags>
		<Tag>
			<id>1</id>
			<name>Gollo</name>
		</Tag>
	</tags>
	<status>available</status>
</Pet>
   When
       User send a POST Request to the url
   Then
       HTTP Status code should be 200
    And
       Content Type should be application/xml
   And
       Connection should be keep-alive
    And
       category id is 1,
    And
       category name is Köpek,
   And
       id is 1,
   And
       name is Gollo,
    And
       photoUrls is gollo/dog/a.png,
    And
       status is available,
    And
       tag id is 1,
    And
       tag name is Gollo,
*/
             Pet expectedPet;
    Response response;
    @Given("petstore url girilir")
    public void petstoreUrlGirilir() {
        //1- set the url
        specPetStore_XML.pathParam("first", "pet");
    }

    @And("expected pet olusturulur")
    public void expectedPetOlusturulur() {
        //2- set the expected data
        PhotoUrls photoUrls=new PhotoUrls("C:/local/photo.png");
        Tag tag=new Tag(1,"Gollo");
        List<Tag> tagList=new ArrayList<>();
        tagList.add(tag);
        Tags tags=new Tags(tagList);
        Category category=new Category(1,"Gollo");
         expectedPet=new Pet(1, category, "Köpek",photoUrls,tags,"available");


    }

    @And("petster urle request gonderilir ve response alinir")
    public void petsterUrleRequestGonderilirVeResponseAlinir() {
        //3- send the request and get the response
        response= given(specPetStore_XML).body(expectedPet).post("{first}");
        response.prettyPrint();
    }

    @Then("petden gelen response dogrulanir")
    public void petdenGelenResponseDogrulanir() {
        //4- do assertion
        response.then()
                .statusCode(200)
                .contentType("application/xml");
        String  expectedConnection= "keep-alive";
        String  actualConnection= response.header("Connection");

          assertEquals(expectedConnection, actualConnection);

           XmlPath xmlPath =response.xmlPath();
          assertEquals(1, xmlPath.getInt("Pet.id"));
          assertEquals(1, xmlPath.getInt("Pet.category.id"));
          assertEquals("Gollo", xmlPath.getString("Pet.category.name"));
          assertEquals("Köpek", xmlPath.getString("Pet.name"));
          assertEquals("C:/local/photo.png", xmlPath.getString("Pet.photoUrls.photoUrl"));
          assertEquals(1, xmlPath.getInt("Pet.tags.tag.id"));
          assertEquals("Gollo", xmlPath.getString("Pet.tags.tag.name"));
          assertEquals("available", xmlPath.getString("Pet.status"));


    }
}
