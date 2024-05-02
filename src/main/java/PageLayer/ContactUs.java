package PageLayer;

import BaseLayer.BaseClass;
import UtilsLayer.UtilClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static BaseLayer.BaseClass.driver;

public class ContactUs extends BaseClass {

    @FindBy(xpath="//a[text()=' Contact us']")
    private WebElement Contactus;

    @FindBy (name="name")
    private WebElement name;

    @FindBy (name="email")
    private WebElement email;

    @FindBy (name="subject")
    private WebElement subject;

    @FindBy (name="message")
    private WebElement message;

    @FindBy (name="submit")
    private WebElement submit;

    @FindBy(xpath="//h2[@class='title text-center']/following-sibling::div[contains(text(),\"Success! Your details have been submitted successfully.\")]")
    private WebElement successMesage;

    public ContactUs()
    {
        PageFactory.initElements(driver, this);

    }

    public void clickcontactus()
    {
        UtilClass.click(Contactus);
    }

    public void filldata(String fname,String femail,String fsubject,String fmessage)
    {
        UtilClass.enterdata(name,fname);
        UtilClass.enterdata(email,femail);
        UtilClass.enterdata(subject,fsubject);
        UtilClass.enterdata(message,fmessage);
    }

    public void submitdata()
    {
        UtilClass.click(submit);
    }

    public void handleAlert(String accept){
        if (accept.equals("OK")) {
            UtilClass.acceptAlert();
        } else if (accept.equals("CANCEL")) {
            UtilClass.dismissAlert();
        }

    }
    public String getSuccessMessage() {
        return successMesage.getText();
    }
}
