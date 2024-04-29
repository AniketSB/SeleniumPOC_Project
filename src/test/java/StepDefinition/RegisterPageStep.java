package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegisterPageStep {
    public static WebDriver driver;

    @Given("User visits a page")
    public void userVisitsAPage() {
        driver=new ChromeDriver();
    }

    @When("User enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String arg0, String arg1) {
    }
}
