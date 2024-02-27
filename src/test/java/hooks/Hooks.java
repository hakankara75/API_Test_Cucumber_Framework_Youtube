package hooks;

import io.cucumber.java.Before;


import static baseUrl.Faker_BaseUrl.setUpFaker;
import static baseUrl.Gorest_BaseUrl.setupGorest;


public class Hooks {

    @Before
    public void before(){
       // setup();
       //setupJson();
       //  setupHerokuapp();
       // setUpFaker();
        setupGorest();

    }
}
