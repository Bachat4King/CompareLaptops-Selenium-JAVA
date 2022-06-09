package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CompareLaptopsPage;
import pages.ComparePage;
import utils.DriverFactory;

import java.io.IOException;

public class CompareLaptopsSteps {

    CompareLaptopsPage compareLaptopsPage = new CompareLaptopsPage(DriverFactory.getDriver());
    ComparePage comparePage = new ComparePage(DriverFactory.getDriver());

    @And("agregar laptop {string} y {string}")
    public void agregarLaptop(String laptop1, String laptop2) {
        compareLaptopsPage.agregarLaptop();
        compareLaptopsPage.buscarLaptop(laptop1);
        compareLaptopsPage.agregarLaptop();
        compareLaptopsPage.buscarLaptop(laptop2);
    }

    @Then("click button {string}")
    public void clickButton(String button) {
        compareLaptopsPage.clickButton(button);
    }

    @Then("guardar datos de tabla {string} en excel")
    public void guardarDatosDeTabla(String nombreTabla) throws IOException {
        comparePage.guardarDatosExcel(nombreTabla);
    }

}


