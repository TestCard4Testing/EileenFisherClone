package stepDefinitions;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.And;
import objectsContainer.ObjectsContainer;

public class LoginPageStepDefinition {
	
	@And("^I log in using \"(.*)\" in LoginPage$")
	public void login(String rowRef) 
	{
		ObjectsContainer.getObjectsContainer().getLoginPage().login(rowRef);
	}
}
