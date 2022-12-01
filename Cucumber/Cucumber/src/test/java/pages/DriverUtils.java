package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtils {

    public WebDriver driver;

    public DriverUtils(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
}
