package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features="src/test/resources",
        glue= {"stepdefinitions","hooks"},
        tags= "@postTestData",//Çalışacak scenarioları belirtir.
        dryRun= false
)
public class Runner {


}
