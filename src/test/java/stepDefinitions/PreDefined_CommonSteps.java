package stepDefinitions;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import driverManager.TLDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectsContainer.ObjectsContainer;
import utilities.EnvironmentVals;

public class PreDefined_CommonSteps
{
	WebDriver driver;
	PredefinedSteps predefSteps;
	Properties prop;
	
	public PreDefined_CommonSteps()
	{
		this.driver = TLDriverFactory.getDriver();		
		predefSteps= new PredefinedSteps(driver);	
	}
	
	@And("^I click on (.*) in (.*)$")
	public void clickOn(String fieldName, String page) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		WebElement ele = ObjectsContainer.getObjectsContainer().getPageObject(fieldName, page);
		if(ele!=null)
		{
			predefSteps.clickOnElement(ele);
		}
		else
		{
			Assert.fail(fieldName +" IS NOT THERE IN "+page);
		}
	}
	@When("^I enter text \"(.*)\" into (.*) in (.*)$")
	public void inputTo(String text, String fieldName, String page) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		WebElement ele = ObjectsContainer.getObjectsContainer().getPageObject(fieldName, page);
		if(ele!=null)
		{
			predefSteps.typeinEditbox(ele, text);
		}
		else
		{
			Assert.fail(fieldName +"IS NOT THERE IN  "+page);
		}
		
	}
	@And("^I see element (.*) in (.*)$")
	public void i_see_element(String fieldName, String page) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		WebElement ele = ObjectsContainer.getObjectsContainer().getPageObject(fieldName, page);
		predefSteps.i_see_element(ele);
	}
	@When("I press \"(.*)\" key on (.*) in (.*)$")
	public void keyBoardAction(String event, String fieldName, String page) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{  
		WebElement	element = ObjectsContainer.getObjectsContainer().getPageObject(fieldName, page);
			
		switch(event.toUpperCase()){
             case "TAB":
            	 element.sendKeys(Keys.TAB);
            	 break;
             case "BACKSPACE":
            	 element.sendKeys(Keys.BACK_SPACE);
            	 break;
             case "CLEAR":
            	 element.sendKeys(Keys.CLEAR);
            	 break;
             case "CANCEL":
            	 element.sendKeys(Keys.CANCEL);
            	 break;
             case "ENTER":
            	 element.sendKeys(Keys.ENTER);
            	 break;
		}
    }	
		
	//Step definition to verify given element contains given partial text message - Can be verified to notice error messages 
	@And("^I notice (.*) contains \"(.*) in (.*)\"$")
	public void i_notice_text(String fieldName, String partialText, String page)
	{
		try {
			WebElement	element = ObjectsContainer.getObjectsContainer().getPageObject(fieldName, page);
			Assert.assertTrue(element.getAttribute("innerText").toLowerCase().contains(partialText.toLowerCase()), fieldName +" doed not contain " + partialText);
			Reporter.log("Verified presence of message that contains '"+ partialText + "'");
		} catch (Exception e) {
			CucumberHooks.setUpObject.except = e;
			Assert.assertTrue(false);
		}	
	}
	
	@And("^I verify the dialog popup (.*) open in (.*)$")
	public void i_see_dialog_pop_up_is_open(String fieldName, String page) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		WebElement	element = ObjectsContainer.getObjectsContainer().getPageObject(fieldName, page);
		Assert.assertTrue(element.isDisplayed(), fieldName + " is not seen on page");
		Reporter.log(fieldName + " is verified for its presence");
	}
	
	@When("^I wait (\\d+)$")
	public void wait(int time) throws Throwable {
	   try
	   {
		 Thread.sleep(time);  
	   }
	   catch (Exception E)
	   {
		   Reporter.log(E.getMessage());
	   }
	}
	
	@Given("^I open the application$")
	public void i_open_application()
	{
		Reporter.log("*********************************************************");
		predefSteps.navigate_to_env_url();
		System.out.println("*****Application loaded");
		String isBopis = System.getProperty("bopis");
		if(isBopis == null)
		{
			isBopis = EnvironmentVals.getEnvInstance().isBopis();
		}
		
		if(isBopis.equalsIgnoreCase("true"))
		{
			//predefSteps.enableVeepnPlugin();
			if(CucumberHooks.isPluginEnabled)
			{
				
			}
			else
			{
				predefSteps.waitSeconds(25000);
				driver.manage().deleteAllCookies();
				CucumberHooks.isPluginEnabled = true;
			}
		}
		try
		{
			ObjectsContainer.getObjectsContainer().pdp.emailSubscriptionSignUp.click();
		}
		catch(Exception e)
		{
			
		}
	}
	
	@And("^I mouseover on (.*) in (.*)$")
	public void i_hover_on(String fieldName, String page) throws Throwable {

	 WebElement	element = ObjectsContainer.getObjectsContainer().getPageObject(fieldName, page);
	 predefSteps.hoverOnElement(element);
	 predefSteps.waitSeconds(1000);
	 Reporter.log("Mouse hovered on "+ fieldName);
	}

	@When("^I check (.*) checkbox$")
	public void i_check_element(String fieldName, String page) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
	 WebElement	element = ObjectsContainer.getObjectsContainer().getPageObject(fieldName, page);
	 JavascriptExecutor js= (JavascriptExecutor)TLDriverFactory.getDriver(); 
	 js.executeScript("arguments[0].click();", element);
	}

	@Then("^(.*) checkbox is checked in (.*)$")
	public void element_checked(String fieldName, String page) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		WebElement	element = ObjectsContainer.getObjectsContainer().getPageObject(fieldName, page);
		Assert.assertTrue(element.isSelected(), fieldName+" is not checked");
	}
			
	@When("^I choose \"([^\']*)\" from (.*) in (.*)$")
	public void chooseOption_from_dropdown(String option, String fieldName, String page) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException 
	{
		WebElement	element = ObjectsContainer.getObjectsContainer().getPageObject(fieldName, page);	
		predefSteps.chooseOptionFromDropDown(element, option);
	}
	@When("^I select \"([^\']*)\" from (.*) in (.*)$")
	public void select_from_dropdown(String option, String fieldName, String page) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException 
	{
		WebElement	element = ObjectsContainer.getObjectsContainer().getPageObject(fieldName, page);	
		predefSteps.selectOption(element, option);
	}
	@And("^I clear cookies$")
	public void clear_cookies()
	{
		driver.manage().deleteAllCookies();
		Reporter.log("Delete all cookies");
	}
	
	@When("^I scroll down to footer$")
	public void i_scroll_down_tofooter()
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
	}
}
