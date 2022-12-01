package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.DriverUtils;

public class LoginStepDefinitions extends BasePage {
    public LoginStepDefinitions(DriverUtils d) {
        super(d.driver);
    }
    @Given("Navigate to Sign in page")
    public void navigateToSignInPage(){
        click(By.className("login"));
    }
    @When("User enters {string} in email field")
    public void userEntersInEmailField(String email) {
        writeText(By.id("email"), email);
    }
    @And("User enters {string} in password field")
    public void userEntersInPasswordField(String password) {
        writeText(By.id("passwd"), password);
    }
    @And("User clicks on Sign in button")
    public void userClicksOnSignInButton() {
        click(By.id("SubmitLogin"));
    }
}
