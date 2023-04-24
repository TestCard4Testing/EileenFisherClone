package pageClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import driverManager.TLDriverFactory;
import io.cucumber.java.en.And;
import stepDefinitions.CucumberHooks;
import stepDefinitions.PredefinedSteps;

public class OrderConfirmationPage {
	
	PredefinedSteps predef;

	public OrderConfirmationPage() {

		PageFactory.initElements(driverManager.TLDriverFactory.getDriver(), this);
		predef = new PredefinedSteps(driverManager.TLDriverFactory.getDriver());

	}
	
	@FindBy(css = "div[class='card confirm-details'] div[class='card-body'] p span[class='summary-details order-number']")
	public WebElement orderNumber;

	@FindBy(css = "div[class='confirmation-message'] h1")
	public WebElement confirmationMessage;
	
	public void storeOrderDetails(String scenarioName) throws IOException
	{
		predef.waitForElementVisibility(orderNumber);
		CucumberHooks.test.log(Status.PASS, "Order placed successfully and the order number is "+ orderNumber.getText());
		predef.writeToTextFile(orderNumber.getText(), scenarioName);	
	}
}
