package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.DriverUtils;
import utilities.ScreenshotClass;

public class BaseStepDefinitions extends BasePage {
    //WebDriver driver;

    public BaseStepDefinitions(DriverUtils d) {
        super(d.driver);
    }

    @Given("Launch the browser")
    public void launch_the_browser() {
        System.out.println("Browser is opened!");
    }
    @Given("Maximize the browser window")
    public void maximize_the_browser_window() {
        driver.manage().window().maximize();
    }
    @Given("Open automation practice")
    public void open_automation_practice() {
        driver.get("http://automationpractice.com/index.php");
    }
    @After
    public void teardown(Scenario scenario){
        if (scenario.isFailed()) {
            //byte[] data =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            //scenario.attach(data, "image/png", "My screenshot");
            ScreenshotClass screenshotClass = new ScreenshotClass(driver);
            screenshotClass.takeScreenshot(scenario);
        }
        driver.quit();
    }
}
