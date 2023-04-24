package stepDefinitions;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.And;
import objectsContainer.ObjectsContainer;

public class MyAccountDashboardPageStepDefinition {
	@And("^I see the myAccountLink$")
	public void iSeeMyAccountLink()
	{
		ObjectsContainer.getObjectsContainer().account.iSeeMyAccountLink();
		CucumberHooks.test.log(Status.PASS, "Logged in successfully");
	}

}
