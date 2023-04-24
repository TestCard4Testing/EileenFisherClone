package pageClasses;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverManager.TLDriverFactory;
import objectsContainer.ObjectsContainer;
import stepDefinitions.PredefinedSteps;

public class HomePage{
	
	PredefinedSteps predef;
	
	public HomePage() {

		PageFactory.initElements(driverManager.TLDriverFactory.getDriver(), this);
		predef = new PredefinedSteps(driverManager.TLDriverFactory.getDriver());

	}
	@FindBy(css = "a[id='mylogin']")
	public WebElement loginLink;
	
	@FindBy(css = "button[id='onetrust-accept-btn-handler']")
	public WebElement acceptAllCookies;
	
	@FindBy(css = "svg[class='logo-svg']") 
	public WebElement eileenFisherLogo;
	
	@FindBy(css = "button[class='search-btn']") 
	public WebElement searchButton;
	
	@FindBy(css = "input[class='form-control search-field']") 
	public WebElement searchBox;
	
	@FindBy(css = "button[name='search-button']") 
	public WebElement searchSubmitButton;
	
	public void i_am_on_homepage()
	{
		predef.findElementNotPresent(eileenFisherLogo);
	}
	public void iAcceptAllCookies()
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)TLDriverFactory.getDriver();
			js.executeScript("arguments[0].click();", acceptAllCookies);
		}
		catch(Exception e)
		{
			
		}
	}
	public void search(String rowRef)
	{
		predef.clickOnElement(searchButton);
		HashMap<String, String> product = predef.readDataFromExcelSheet(rowRef, "ProductDetails");
		predef.typeinEditbox(searchBox, product.get("ProductID"));
		predef.clickOnElement(searchSubmitButton);
		
		predef.clickOnElement(ObjectsContainer.getObjectsContainer().plp.firstProduct);
		try
		{
			ObjectsContainer.getObjectsContainer().pdp.emailSubscriptionSignUp.click();
		}
		catch(Exception e)
		{
			
		}
		predef.clickOnElement(ObjectsContainer.getObjectsContainer().pdp.sizeButton);
		predef.waitSeconds(3000);
		predef.clickOnElement(ObjectsContainer.getObjectsContainer().pdp.addToCart);
		predef.clickOnElement(ObjectsContainer.getObjectsContainer().pdp.checkoutButton);
	}
	public void iClickOnLoginLink()
	{
		predef.clickOnElement(loginLink);
	}
}