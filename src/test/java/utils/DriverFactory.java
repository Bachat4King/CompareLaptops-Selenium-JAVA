package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> hiloLocal = new ThreadLocal<>();

    public WebDriver init_driver(String browser) {
        System.out.println("corriendo en navegador: " + browser);

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            hiloLocal.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            hiloLocal.set(new FirefoxDriver());
        } else {
            System.out.println("por favor ingresa un navegador soportado: " + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return hiloLocal.get();
    }
}
