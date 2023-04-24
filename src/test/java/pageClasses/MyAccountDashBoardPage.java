package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.PredefinedSteps;

public class MyAccountDashBoardPage {
	public PredefinedSteps predef;
	public MyAccountDashBoardPage() {
		
		PageFactory.initElements(driverManager.TLDriverFactory.getDriver(), this);
		predef = new PredefinedSteps(driverManager.TLDriverFactory.getDriver());
	}
	@FindBy(css = "a[id='myaccount']")
	public WebElement myAccountLink;
	
	public void iSeeMyAccountLink()
	{
		predef.i_see_element(myAccountLink);
	}
}
