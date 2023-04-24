package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.And;
import objectsContainer.ObjectsContainer;

public class OrderConfirmationPageStepDefinition {
	
	@And("^I save order details$")
	public void storeOrderDetails() throws IOException
	{
		ObjectsContainer.getObjectsContainer().getOrderConfirmationPage().storeOrderDetails(CucumberHooks.setUpObject.scenarioName);
	}
}
