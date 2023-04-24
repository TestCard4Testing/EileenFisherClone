package stepDefinitions;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.And;

import objectsContainer.ObjectsContainer;

public class ShippingAndPaymentPageStepDefinition {
	@And("^I enter \"(.*)\" Details$")
	public void enterPickUpDetails(String rowRef)
	{
		ObjectsContainer.getObjectsContainer().getShippingAndPaymentPage().iEnterPickUpDetails(rowRef);
		CucumberHooks.test.log(Status.PASS, rowRef+" details entered");
	}
	
	@And("^I enter \"(.*)\" details on the Billing page$")
	public void digiEnterCardDetailsForClasses(String rowRef)
	{
		ObjectsContainer.getObjectsContainer().getShippingAndPaymentPage().enterCardDetails(rowRef);
		CucumberHooks.test.log(Status.PASS, rowRef+" Card details entered");
	}
	@And("^I enter Shipping \"(.*)\" details on the Shipping page$")
	public void digiEnterShippingAddressDetails(String rowRef)
	{
		ObjectsContainer.getObjectsContainer().getShippingAndPaymentPage().enterShippingAddress(rowRef);
		CucumberHooks.test.log(Status.PASS, rowRef+" Shipping address details entered");
	}
	@And("^I enter billing \"(.*)\" details$")
	public void digiEnterBillingAddressDetails(String rowRef)
	{
		ObjectsContainer.getObjectsContainer().getShippingAndPaymentPage().enterBillingAddress(rowRef);
		CucumberHooks.test.log(Status.PASS, rowRef+" Shipping address details entered");
	}
	
	@And("^I click on the payPalButton$")
	public void iClickOnPayPalRadioButton()
	{
		ObjectsContainer.getObjectsContainer().getShippingAndPaymentPage().clickOnPayPal();
	}
	@And("^I click on the nextPaymentButton$")
	public void iClickOnNextPaymentButton()
	{
		ObjectsContainer.getObjectsContainer().getShippingAndPaymentPage().iClickOnNextPaymentButton();
	}
	@And("^I click on the reviewAndPlaceOrderButton$")
	public void iClickOnReviewAndPlaceOrderButton()
	{
		ObjectsContainer.getObjectsContainer().getShippingAndPaymentPage().iClickOnReviewAndPlaceOrderButton();
	}
	
	@And("^I click on the placeOrderButton$")
	public void iClickOnPlaceOrderButton()
	{
		ObjectsContainer.getObjectsContainer().getShippingAndPaymentPage().iClickOnPlaceOrderButton();
	}
	
}
