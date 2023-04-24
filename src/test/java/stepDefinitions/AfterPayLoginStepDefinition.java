package stepDefinitions;

import io.cucumber.java.en.And;
import objectsContainer.ObjectsContainer;

public class AfterPayLoginStepDefinition {

	@And("^I enter AfterPay log in details$")
    public void enterAfterPayLoginDetails()
	{
		ObjectsContainer.getObjectsContainer().afterPay.enterAfterPayLoginDetails();
	}
}