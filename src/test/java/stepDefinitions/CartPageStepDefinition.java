package stepDefinitions;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.And;
import objectsContainer.ObjectsContainer;

public class CartPageStepDefinition {
	
	@And("^I checkout product as guest user$")
	public void iCheckOutProductAsGuestUser()
	{
		ObjectsContainer.getObjectsContainer().cart.checkOutAsGuestUser();
		CucumberHooks.test.log(Status.PASS, "Checkout as Guest user");
	}
	
	@And("^I click on pickUpRadioButton$")
	public void iClickOnPickUpRadioButton()
	{
		ObjectsContainer.getObjectsContainer().cart.iClickOnPickUpRadioButton();
	}

}
