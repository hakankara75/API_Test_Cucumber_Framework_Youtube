package hooks;

import io.cucumber.java.Before;


import static baseUrl.Faker_BaseUrl.setUpFaker;
import static baseUrl.Herokuapp_BaseUrl_Authentication.setupHerokuapp_Authentication;
import static baseUrl.Herokuapp_XML_Authentication_BaseUrl.setupHerokuapp_XML_Authentication;
import static baseUrl.Herokuapp_XML_BaseUrl.setupHerokuapp_XML;
import static baseUrl.PetStore_BaseUrl.setupPetStore;
import static baseUrl.Reqres_BaseUrl.setup;


public class Hooks {

    @Before
    public void before(){
        // setup();
       //setupJson();
       //  setupHerokuapp();
      // setUpFaker();
     //  setupGorest();
        // setupPetStore();
        //   setupHerokuapp_Authentication();
        //setupHerokuapp_XML();
        setupHerokuapp_XML_Authentication();
    }
}
