package pageClasses;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import objectsContainer.ObjectsContainer;
import stepDefinitions.PredefinedSteps;

public class CartPage {
	
	PredefinedSteps predef;
	
	public CartPage() {

		PageFactory.initElements(driverManager.TLDriverFactory.getDriver(), this);
		predef = new PredefinedSteps(driverManager.TLDriverFactory.getDriver());
	}
	@FindBy(css = "a[class='btn btn-primary btn-block checkout-btn ']")
	public WebElement checkoutButton;
	
	@FindBy(css = "input[id='login-form-email']")
	public WebElement emailInputField;

	@FindBy(css = "input[class='storePickup bopis-sth-radio']")
	public WebElement pickUpRadioButton;

	public void checkOutAsGuestUser()
	{
		try
		{
			ObjectsContainer.getObjectsContainer().pdp.emailSubscriptionSignUp.click();
		}
		catch(Exception e)
		{
			
		}
		predef.clickOnElement(checkoutButton);
		HashMap<String, String> userData = predef.readDataFromExcelSheet("ValidCredentials", "LoginData");
		predef.typeinEditbox(emailInputField, userData.get("Email"));
	}
	
	public void iClickOnPickUpRadioButton()
	{
		try
		{
			predef.waitSeconds(3000);
			ObjectsContainer.getObjectsContainer().pdp.emailSubscriptionSignUp.click();
			predef.clickOnElement(pickUpRadioButton);
			predef.waitSeconds(6000);
			ObjectsContainer.getObjectsContainer().pdp.emailSubscriptionSignUp.click();
		}
		catch(Exception e)
		{
			
		}
	}
}
