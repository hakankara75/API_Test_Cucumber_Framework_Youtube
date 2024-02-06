package hooks;

import io.cucumber.java.Before;

import static baseUrl.Reqres_BaseUrl.setup;

public class Hooks {

    @Before
    public void before(){
        setup();
    }
}
