package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ExcelUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ComparePage extends Base {

    private final By tableSection = By.xpath("//h5[text()='Specifications']/following::div");

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTableSection() {
        return findElement(tableSection, Duration.ofSeconds(10));
    }

    public WebElement obtenerTabla(String nombreTabla) {
        String tableXpath = "//div[contains(text(), '" + nombreTabla + "')]/parent::div/descendant::table";
        return getTableSection().findElement(By.xpath(tableXpath));
    }

    public void guardarDatosExcel(String nombreTabla) throws IOException {
        WebElement table = obtenerTabla(nombreTabla);
        List<WebElement> totalRows = table.findElements(By.tagName("tr"));
        ExcelUtils.writeExcelTable("src/test/resources/datos.xlsx", nombreTabla, totalRows);
    }

}
