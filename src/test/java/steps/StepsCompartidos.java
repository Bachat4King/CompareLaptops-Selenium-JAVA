package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class StepsCompartidos {

    WebDriver driver = DriverFactory.getDriver();

    @Given("ir al sitio {string}")
    public void irAlSitio(String url) {
            driver.get(url);
    }

}
