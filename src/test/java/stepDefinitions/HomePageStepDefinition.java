package stepDefinitions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import driverManager.TLDriverFactory;
import io.cucumber.java.en.And;
import objectsContainer.ObjectsContainer;

public class HomePageStepDefinition {
	WebDriver driver;
	PredefinedSteps predef;
	
	public HomePageStepDefinition()
	{
		this.driver = TLDriverFactory.getDriver();
		predef = new PredefinedSteps(driverManager.TLDriverFactory.getDriver());
	}
	@And("^I click on the loginLink$")
	public void iClickOnLoginLink()
	{
		ObjectsContainer.getObjectsContainer().getHomePage().iClickOnLoginLink();
	}
	@And("^I accept all Cookies$")
	public void iAcceptAllCookies()
	{
		ObjectsContainer.getObjectsContainer().getHomePage().iAcceptAllCookies();
	}
	@And("^I am on home page$")
	public void i_am_on_homepage()
	{
		ObjectsContainer.getObjectsContainer().getHomePage().i_am_on_homepage();
		CucumberHooks.test.log(Status.PASS, "Browser navigated to the Home page");
	}
	@And("^I search \"(.*)\" and add to the cart")
	public void iSearchProductAndAddToTheCart(String rowRef)
	{
		ObjectsContainer.getObjectsContainer().getHomePage().search(rowRef);
		HashMap<String, String> product = predef.readDataFromExcelSheet(rowRef, "ProductDetails");
		CucumberHooks.test.log(Status.PASS, "Product with SKU \""+product.get("ProductID")+"\" added to tha cart");
	}
	
}
