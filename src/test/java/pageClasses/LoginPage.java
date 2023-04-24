package pageClasses;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import stepDefinitions.PredefinedSteps;

public class LoginPage{
	public PredefinedSteps predef; 
	public LoginPage() {
		
		PageFactory.initElements(driverManager.TLDriverFactory.getDriver(), this);
		predef = new PredefinedSteps(driverManager.TLDriverFactory.getDriver());
	}
	@FindBy(css = "button[class='slds-button alternative_button']")
	public WebElement createAccountButton;
	
	@FindBy(css = "input[id='login-form-email']")
	public WebElement usernameOrEmail;
	
	@FindBy(css = "button[class='slds-button slds-button_neutral sfdc_button']")
	public WebElement nextButton;
	
	@FindBy(css = "input[id='login-form-password']")
	public WebElement password;
	
	@FindBy(css = "button[id='login-submit-btn']")
	public WebElement loginButton;
	
	@FindBy(css = "a[id='login-tab']")
	public WebElement loginLink;
	
	public void login(String rowRef) {
		
		predef.waitForElementVisibility(loginLink);
		HashMap<String, String> loginData = predef.readDataFromExcelSheet(rowRef, "LoginData");
		predef.typeinEditbox(usernameOrEmail, loginData.get("Email"));
		predef.typeinEditbox(this.password, loginData.get("Password"));
		predef.clickOnElement(loginButton);
	}
	
}

