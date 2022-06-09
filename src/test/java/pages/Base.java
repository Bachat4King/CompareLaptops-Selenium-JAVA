package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Base {

    private final WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By locator, Duration timeout) {
        return new WebDriverWait(this.driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> findElements(By locator, Duration timeout) {
        return new WebDriverWait(this.driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void type(String inputText, By locator) {
        findElement(locator, Duration.ofSeconds(10)).sendKeys(inputText);
    }

    public void click(By locator) {
        findElement(locator, Duration.ofSeconds(10)).click();
    }

    public void clickButton(String button) {
        click(By.xpath("//button[contains(text(), '" + button + "')]"));
    }

}