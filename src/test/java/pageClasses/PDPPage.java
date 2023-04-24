package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.PredefinedSteps;

public class PDPPage {
PredefinedSteps predef;
	
	public PDPPage() {

		PageFactory.initElements(driverManager.TLDriverFactory.getDriver(), this);
		predef = new PredefinedSteps(driverManager.TLDriverFactory.getDriver());

	}
	@FindBy(css = "button[class='close closemodal-emailsignup'] svg")
	public WebElement emailSubscriptionSignUp;
	
	@FindBy(css = "div[data-attr='size'] div[class='select-size d-flex flex-wrap'] div[class*='pdp-bisn-tooltip-container'] button[class='pl-2 pr-2 pdp-bisn-tooltip   ']") 
	public WebElement sizeButton;
	
	@FindBy(css = "button[class='add-to-cart btn btn-primary d-flex align-items-center justify-content-center ']")
	public WebElement addToCart;
	
	@FindBy(css = "a[class='btn btn-primary btn-block checkout-btn ']")
	public WebElement checkoutButton;
}
