package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class CompareLaptopsPage extends Base {

    private final By searchLaptops = By.xpath("//span[contains(text(), 'Select')]");
    private final By searchLaptopsInput = By.xpath("//span[contains(text(), 'Select')]/descendant::input");
    private final By laptopsDropdown = By.xpath("//span[contains(text(), 'Select')]//mark");

    public CompareLaptopsPage(WebDriver driver) {
        super(driver);
    }

    public void agregarLaptop() {
        click(searchLaptops);
    }

    public void buscarLaptop(String nombreLaptop) {
        type(nombreLaptop, searchLaptopsInput);
        List<WebElement> laptops = obtenerDropdownElements();
        for (WebElement laptop : laptops) {
            if (laptop.getText().equals(nombreLaptop)) {
                laptop.click();
                break;
            }
        }
    }

    public List<WebElement> obtenerDropdownElements() {
        return findElements(laptopsDropdown, Duration.ofSeconds(10));
    }


}
