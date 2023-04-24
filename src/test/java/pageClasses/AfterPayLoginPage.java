package pageClasses;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.PredefinedSteps;

public class AfterPayLoginPage {
	
	PredefinedSteps predef;

	public AfterPayLoginPage() {

		PageFactory.initElements(driverManager.TLDriverFactory.getDriver(), this);
		predef = new PredefinedSteps(driverManager.TLDriverFactory.getDriver());
	}
	
	@FindBy(xpath = "//input[@type='email']")
	public WebElement email;

	@FindBy(xpath = "//span[text()='Continue']//ancestor::button")
	public WebElement continueButton;
	
	@FindBy(xpath = "//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath = "//span[text()='Confirm']//ancestor::button")
	public WebElement confirmButton;
	
	public void enterAfterPayLoginDetails()
	{
		HashMap<String, String> data = predef.readDataFromExcelSheet("AfterPay", "AfterPayLoginData");
		String emailId = data.get("Email");
		String password = data.get("Password");
		
		predef.typeinEditbox(email, emailId);
		predef.clickOnElement(continueButton);
		predef.typeinEditbox(this.password, password);
		predef.clickOnElement(continueButton);
		predef.clickOnElement(confirmButton);

	}

}