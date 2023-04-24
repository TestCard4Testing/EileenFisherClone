package pageClasses;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.PredefinedSteps;

public class PayPalLoginPage {
	PredefinedSteps predef;

	public PayPalLoginPage() {

		PageFactory.initElements(driverManager.TLDriverFactory.getDriver(), this);
		predef = new PredefinedSteps(driverManager.TLDriverFactory.getDriver());
	}
	
	@FindBy(css = "div[id='content'] input[id='email']")
	public WebElement payPalEmail;
	
	@FindBy(css = "div[id='content'] input[id='password']")
	public WebElement payPalPassword;
	
	@FindBy(css = "button[id='btnNext']")
	public WebElement next;
	
	@FindBy(css = "div[id='content'] button[name='btnLogin']")
	public WebElement payPalLoginButton;
	
	@FindBy(css = "button[id='payment-submit-btn']")
	public WebElement payPalContinueButton;
	
	public void enterPayPalLoginDetails(String rowRef)
	{	
		HashMap<String, String> payPalLoginDetails = predef.readDataFromExcelSheet(rowRef, "PayPalLoginDetails");
		predef.typeinEditbox(payPalEmail, payPalLoginDetails.get("Email"));
		if(predef.findElementNotPresent(next))
		{
			predef.clickOnElement(next);
		}
		predef.typeinEditbox(payPalPassword, payPalLoginDetails.get("Password"));
		predef.clickOnElement(payPalLoginButton);
		predef.waitSeconds(3000);
		predef.clickOnElement(payPalContinueButton);
	}

}
