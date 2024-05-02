package StepDefinition;

import BaseLayer.BaseClass;
import PageLayer.LoginPage;
import UtilsLayer.ExcelReader;
import UtilsLayer.ExcelUtility;
import UtilsLayer.UtilClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoginPageStepDef extends BaseClass {

    LoginPage loginPage;
    private static String title;

    @Given("User launch a browser")
    public void user_launch_a_browser() throws IOException {
        BaseClass.initialization();
//        loginPage = new LoginPage();
    }
    //LoginPageObject obj=new LoginPageObject();
    @Given("user is on login page")
    public void user_is_on_login_page() throws IOException {
        loginPage = new LoginPage();
        loginPage.selectSignUplogin();
    }

    @And("user verify logout button")
    public void userVerifyLogoutButton() {
        String logoutText= loginPage.getLogout();
        Assert.assertEquals("Logout is not getting displayed",logoutText,"Logout");
        loginPage.clickOnLogout();
        loginPage.quitBrowser();
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() throws Exception {
       title = loginPage.getLoginPageTitle();
       System.out.println("Page title is: " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        System.out.println("Expected value " +expectedTitleName);
        System.out.println("Title is " +title);
        String loginTitle = driver.getTitle();
        Assert.assertTrue(title.contains(loginTitle));
    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
        loginPage.clickOnsignin();
    }


    @When("user enters username {string}")
    public void user_enters_username(String username) throws IOException {
        loginPage.enterUserName(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassWord(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLogin();
    }

    @When("user enters credentials for {string} and sheetname {string}")
    public void userEntersCredentialsForAndSheetname(String testCase, String sheetName) throws IOException {


//        ExcelReader reader = new ExcelReader();
//        List<Map<String,String>> testData =
//                reader.getData(p.getProperty("filepath"), sheetName);
//        int testCaseNumber = Integer.parseInt(testCase);
//
//        String username =testData.get(testCaseNumber).get("TESTCASES");
//
//        String email = testData.get(testCaseNumber).get("USERNAME");
//        String Subject = testData.get(testCaseNumber).get("PASSWORD");
//
//
//        loginPage.enterUserName();
//        loginPage.enterPassWord();
//        contactUsPage.filldata(name,email,Subject,message);

        Object[][] testData = ExcelUtility.readExcel(p.getProperty("filepath"),sheetName,testCase);
        for (Object[] dataRow: testData) {
//			username = (String) dataRow[0];
            System.out.println("Get dataRow ******" +dataRow);
        }

    }

    @And("User close a browser")
    public void userCloseABrowser() throws IOException {
        UtilClass.closeBrowser();
    }

    @When("user enters credentials for {} and sheetname {string}")
    public void userEntersCredentialsForAndSheetname(Integer testCase, String sheetName) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData(p.getProperty("filepath"), sheetName);

        String username,password;

        for (int i = 0; i < testData.size()-1; i++) {
            String number =testData.get(i).get("TESTCASES");
            int convertedNumber =Integer.parseInt(number);
            if (testCase==convertedNumber) {
                String status = testData.get(i).get("STATUS");
                if (status.equalsIgnoreCase("YES")) {
                    username = testData.get(i).get("USERNAME");
                    password = testData.get(i).get("PASSWORD");
                    loginPage.enterUserName(username);
                    loginPage.enterPassWord(password);
                } else {
                    System.out.println("Test case execution status is NO");
                    loginPage.quitBrowser();
                }
            }
        }
    }
}
