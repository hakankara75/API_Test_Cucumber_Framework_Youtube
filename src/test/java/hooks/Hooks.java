package hooks;

import io.cucumber.java.Before;


import static baseUrl.Herokuapp_BaseUrl.setupHerokuapp;
import static baseUrl.JsonPlaceHolder_BaseUrl.setupJson;
import static baseUrl.Reqres_BaseUrl.setup;

public class Hooks {

    @Before
    public void before(){
       // setup();
       //  setupJson();
        setupHerokuapp();

    }
}
