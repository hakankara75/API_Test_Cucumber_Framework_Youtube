package hooks;

import io.cucumber.java.Before;



import static baseUrl.PetStore_BaseUrl.setupPetStore;



public class Hooks {

    @Before
    public void before(){
       // setup();
       //setupJson();
       //  setupHerokuapp();
       // setUpFaker();
     //  setupGorest();
        setupPetStore();


    }
}
