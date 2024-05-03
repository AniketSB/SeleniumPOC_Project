package PageLayer;

import UtilsLayer.CaptureRequest;
import UtilsLayer.ExcelUtility;
import UtilsLayer.UtilClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Properties;

public class LoginPage extends BaseClass {

	@FindBy (xpath="//form[@action=\"/login\"]//input[@type='email']")
	private WebElement emailId;
	@FindBy (xpath="//form[@action=\"/login\"]//input[@type='password']")
	private WebElement Password;
	@FindBy (xpath="//button[contains(text(),\"Login\")]")
	private WebElement signInButton;

	@FindBy(linkText = "Forgot your password?111")
	private WebElement forgotPwdLink;

	@FindBy(xpath="//a[contains(text(),\"Logout\")]")
	private WebElement logout;
	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	private WebElement SignUplogin;

	@FindBy(xpath = "//button[contains(text(),\"Login\")]")
	private WebElement login;

//
//	// 1. By Locators: ORH
//	private By SignUp_Login = By.xpath("//a[normalize-space()='Signup / Login']");
//
//	private By LogInemail = By.xpath("//form[@action=\"/login\"]//input[@type='email']");
//
//	private By LogInpassword = By.xpath("//form[@action=\"/login\"]//input[@type='password']");
//
//	private By LogIn = By.xpath("//button[contains(text(),\"Login\")]");
//	private By existingUserText = By.xpath("//form[@action=\"/login\"]//following::p[contains(text(),\"Your email or password is incorrect!\")]");
//
//	private By SignUpName = By.xpath("//form[@action=\"/signup\"]//input[@type='Name']");
//
//	private By SignUpEmail = By.xpath("//form[@action=\"/signup\"]//input[@name='email']");
//
//	private By SignUp = By.xpath("//button[contains(text(),\"Signup\")]");


	public void selectSignUplogin()
	{
		UtilClass.click(SignUplogin);
	}

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}


	public String getLoginPageTitle() throws Exception{
		return driver.getTitle();
	}

	public String getLogout(){
		return logout.getText();
	}

	public boolean isForgotPwdLinkExist() {
		return forgotPwdLink.isDisplayed();
	}

	public void enterUserName(String username ) throws IOException {
//		Object[][] testData =ExcelUtility.readExcel(p.getProperty("filepath"),"Login",username);
//		for (Object[] dataRow: testData) {
//			username = (String) dataRow[0];
//		}
		UtilClass.enterdata(emailId,username);
	}

	public void enterPassWord( String password ) {
		UtilClass.enterdata(Password,password);
	}

	public void clickOnsignin() {
		UtilClass.click(signInButton);
	}

	public void clickOnLogin() {
		UtilClass.click(login);
	}

	public void clickOnLogout(){
		UtilClass.click(logout);
	}

	public void quitBrowser(){
		driver.quit();
	}

//	public void apiCalls(){
//		CaptureRequest.captureHttpRequest(driver);
//	}
	
}

