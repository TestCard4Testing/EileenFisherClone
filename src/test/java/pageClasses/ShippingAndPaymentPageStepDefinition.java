package pageClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import driverManager.TLDriverFactory;
import stepDefinitions.PredefinedSteps;

public class ShippingAndPaymentPageStepDefinition {
	
	PredefinedSteps predef;

	public ShippingAndPaymentPageStepDefinition() {

		PageFactory.initElements(driverManager.TLDriverFactory.getDriver(), this);
		predef = new PredefinedSteps(driverManager.TLDriverFactory.getDriver());
	}
	@FindBy(xpath = "(//iframe[@class='js-iframe'])[1]")
	public WebElement cardNumberIframe;
	
	@FindBy(xpath = "(//iframe[@class='js-iframe'])[2]")
	public WebElement expiryDateIframe;
	
	@FindBy(css = "iframe[title='PayPal']")
	public WebElement payPalIframe;
	
	@FindBy(css = "div[class='buttons-container'] div[class='paypal-button-label-container']")
	public WebElement payPalImage;
	
	@FindBy(xpath = "(//iframe[@class='js-iframe'])[3]")
	public WebElement cvvIframe;
	
	@FindBy(css = "button[value='submit-payment']")
	public WebElement reviewAndPlaceOrderButton;
	
	@FindBy(css = "div[class='row no-gutters'] div[class='row'] button[class='btn btn-primary btn-block place-order']")
	public WebElement placeOrdeButton;
	
	@FindBy(css = "button[class='btn btn-save btn-block btn-primary edq-primary-btn']")
	public WebElement nextPaymentButton;
	
	@FindBy(css = "input[id='shippingFirstNamedefault']")
	public WebElement shippingFirstName;
	
	@FindBy(css = "input[id='shippingLastNamedefault']")
	public WebElement shippingLasttName;
	
	@FindBy(css = "input[id='shippingAddressOnedefault']")
	public WebElement shippingStreeAddress;
	
	@FindBy(css = "input[id='shippingZipCodedefault']")
	public WebElement shippingZipCode;
	
	@FindBy(css = "input[id='shippingAddressCitydefault']")
	public WebElement shippingCity;
	
	@FindBy(css = "select[id='shippingStatedefault']")
	public WebElement shippingState;
	
	@FindBy(css = "input[id='shippingPhoneNumberdefault']")
	public WebElement shippingPhoneNumber;
	
	@FindBy(css = "div[class='tab-pane active adyen-component-content'] ul[id='paymentMethodsList'] li button svg[class='payment-svg paypal']")
	public WebElement payPalButton;

	@FindBy(css = "input[id='encryptedCardNumber']")
	public WebElement paymentCardNumber;
	
	@FindBy(css = "div[id = 'wrapper'] div[class='selected-option']+ul")
	public WebElement paymentExpMonth; 
	
	@FindBy(css = "input[id='encryptedExpiryDate']")
	public WebElement paymentExpDate; 
	
	@FindBy(css = "input[id='encryptedSecurityCode']")
	public WebElement paymentCodeCVN;
	
	@FindBy(css = "input[placeholder='J. Smith']")
	public WebElement nameOnCard;
	
	@FindBy(css = "input[id='billingFirstName']")
	public WebElement billingFirstName;
	
	@FindBy(css = "input[id='billingLastName']")
	public WebElement billingLastName;
	
	@FindBy(css = "#dwfrm_billing_billingAddress_addressFields_Email")
	public WebElement billingEmail;
	
	@FindBy(css = "input[id='billingAddressOne']")
	public WebElement billingStreetAddress;
	
	@FindBy(css = "input[id='billingZipCode']")
	public WebElement billingZipCode;

	@FindBy(css = "input[id='billingAddressCity']")
	public WebElement billingCity;
	
	@FindBy(css = "select[id='billingState']")
	public WebElement billingState;
	
	@FindBy(css = "input[id='phoneNumber']")
	public WebElement billingPhoneNumber;
	
	@FindBy(css = "input[id='shippingFirstNamedefault']")
	public WebElement pickUpFirstName;
	
	@FindBy(css = "input[class='form-control shippingLastName']")
	public WebElement pickUpLastName;
	
	@FindBy(css = "input[class='form-control shippingPhoneNumber valPhone']")
	public WebElement pickUPhoneNumber;
	
	@FindBy(css = "input[class='form-control pickupEmail']")
	public WebElement pickUpEmail;
	
	public void iEnterPickUpDetails(String rowRef)
	{
		HashMap<String, String> userData = predef.readDataFromExcelSheet(rowRef, "PickUPDetails");
		predef.typeinEditbox(pickUpFirstName, userData.get("FirstName"));
		predef.typeinEditbox(pickUpLastName, userData.get("LastName"));
		predef.typeinEditbox(pickUPhoneNumber, userData.get("PhoneNumber"));
		predef.typeinEditbox(pickUpEmail, userData.get("Email"));
	}
	
	public void enterBillingAddress(String rowRef)
	{
		HashMap<String, String> addressDetails = predef.readDataFromExcelSheet(rowRef, "Address");
		
		predef.typeinEditbox(billingFirstName, addressDetails.get("FirstName"));
		predef.typeinEditbox(billingLastName, addressDetails.get("LastName"));
		predef.typeinEditbox(billingStreetAddress, addressDetails.get("Address1"));
		predef.selectOption(billingState, addressDetails.get("State"));
		predef.typeinEditbox(billingCity, addressDetails.get("City"));
		predef.typeinEditbox(billingZipCode, addressDetails.get("PostalCode"));
		predef.typeinEditbox(billingPhoneNumber, addressDetails.get("Phone"));
		
	}
	
	public void enterShippingAddress(String rowRef)
	{
		HashMap<String, String> addressDetails = predef.readDataFromExcelSheet(rowRef, "Address");
		
		predef.typeinEditbox(shippingFirstName, addressDetails.get("FirstName"));
		predef.typeinEditbox(shippingLasttName, addressDetails.get("LastName"));
		predef.typeinEditbox(shippingPhoneNumber, addressDetails.get("Phone"));
		predef.typeinEditbox(shippingStreeAddress, addressDetails.get("Address1"));
		predef.selectOption(shippingState, addressDetails.get("State"));
		predef.waitSeconds(2000);
		predef.typeinEditbox(shippingCity, addressDetails.get("City"));
		predef.typeinEditbox(shippingZipCode, addressDetails.get("PostalCode"));
		
	}	
	public void enterCardDetails(String rowRef)
	{
		HashMap<String, String> cardDetails = predef.readDataFromExcelSheet(rowRef, "CardDetails");
		predef.switchToFrame(cardNumberIframe);
		predef.typeinEditbox(paymentCardNumber, cardDetails.get("CardNumber"));
		predef.switchToDefaultContent();
		predef.switchToFrame(expiryDateIframe);
		predef.typeinEditbox(paymentExpDate, cardDetails.get("ExpDate"));
		predef.switchToDefaultContent();
		predef.switchToFrame(cvvIframe);
		predef.typeinEditbox(paymentCodeCVN, cardDetails.get("CVV"));
		predef.switchToDefaultContent();
		predef.typeinEditbox(nameOnCard, cardDetails.get("NameOnCard"));
	}
	public void clickOnPayPal()
	{
		JavascriptExecutor js = (JavascriptExecutor)TLDriverFactory.getDriver();
		try
		{
			js.executeScript("arguments[0].click();", payPalButton);
		}
		catch(Exception e)
		{
			Assert.assertFalse(false, "Could not click on payPalButton"+e.getMessage());
		}
		predef.switchToFrame(payPalIframe);
		predef.waitSeconds(1000);
		predef.clickOnElement(payPalImage);
		predef.switchToDefaultContent();
		predef.waitSeconds(1000);
		List<String> handles = new ArrayList<String>(TLDriverFactory.getDriver().getWindowHandles());
		TLDriverFactory.getDriver().switchTo().window(handles.get(handles.size()-1));
		predef.waitSeconds(3000);
	}
	public void iClickOnNextPaymentButton()
	{
		predef.clickOnElement(nextPaymentButton);
	}
	public void iClickOnReviewAndPlaceOrderButton()
	{
		predef.clickOnElement(reviewAndPlaceOrderButton);
	}
	public void iClickOnPlaceOrderButton()
	{
		JavascriptExecutor js = (JavascriptExecutor)TLDriverFactory.getDriver();
		try
		{
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			predef.waitForElementVisibility(placeOrdeButton);
			js.executeScript("arguments[0].scrollIntoView(true);", placeOrdeButton);
			placeOrdeButton.click();
		}
		catch(Exception e)
		{
			js.executeScript("arguments[0].click();", placeOrdeButton);
		}
		
	}
}
