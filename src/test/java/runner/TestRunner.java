package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"steps"}, features = "src/test/resources", plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        "json:target/cucumber.json"})
public class TestRunner  {


}
