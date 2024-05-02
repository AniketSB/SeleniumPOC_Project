package StepDefinition;

import BaseLayer.BaseClass;
import PageLayer.ContactUs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ContactUsStepDef extends BaseClass {
    ContactUs contactUs = new ContactUs();

    @Given("user navigates to contact us page")
    public void user_navigates_to_contact_us_page() {
        contactUs.clickcontactus();
    }

    @When("user fills the form from given sheetname {string} and rownumber {string} and {string} and {string}")
    public void user_fills_the_form_from_given_sheetname_and_rownumber_and_and(String fname, String femail, String fsubject, String fmessage) {
        contactUs.filldata("abc","abc@gmail.com","online shopping","Product is good");
    }

    @And("user clicks on submit button")
    public void user_clicks_on_submit_button() {
        contactUs.submitdata();
        contactUs.handleAlert("OK");
    }

    @Then("it shows a successful message {string}")
    public void it_shows_a_successful_message(String ExpectedString) {
        String SuccessMsg = contactUs.getSuccessMessage();
        Assert.assertEquals(SuccessMsg,ExpectedString);

    }
}
