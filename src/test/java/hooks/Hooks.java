package hooks;

import io.cucumber.java.Before;


import static baseUrl.Herokuapp_BaseUrl_Authentication.setupHerokuapp_Authentication;
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
        setupHerokuapp_Authentication();

    }
}
