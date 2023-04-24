package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import com.aventstack.extentreports.Status;

import driverManager.TLDriverFactory;
import io.cucumber.java.en.And;
import objectsContainer.ObjectsContainer;

public class PayPalLoginPageStepDefinition {

	@And("^I enter paypal login details of \"(.*)\"$")
	public void enterPaypalLoginDetails(String rowRef)
	{
		ObjectsContainer.getObjectsContainer().payPal.enterPayPalLoginDetails(rowRef);
		CucumberHooks.test.log(Status.PASS, "PayPal log in and payment is successful");
		List<String> handles = new ArrayList<String>(TLDriverFactory.getDriver().getWindowHandles());
		TLDriverFactory.getDriver().switchTo().window(handles.get(0));
	}
}
