package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features="src/test/resources",
        glue= {"stepdefinitions","hooks"},
        tags= "@assertHeader",
        dryRun= false
)
public class Runner {


}
