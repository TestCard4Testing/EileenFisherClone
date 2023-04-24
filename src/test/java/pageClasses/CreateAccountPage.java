package pageClasses;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import objectsContainer.ObjectsContainer;
import stepDefinitions.PredefinedSteps;

public class CreateAccountPage {
	PredefinedSteps predef;

	public CreateAccountPage() 
	{
		PageFactory.initElements(driverManager.TLDriverFactory.getDriver(), this);
		predef = new PredefinedSteps(driverManager.TLDriverFactory.getDriver());
	}
	
	@FindBy(css = "")
	public WebElement firstName;
	
	@FindBy(css = "")
	public WebElement lastName;
	
	@FindBy(css = "")
	public WebElement emailField;
	
	@FindBy(css = "")
	public WebElement createPassword;
	
	@FindBy(css = "")
	public WebElement confirmPassword;
	
	@FindBy(css = "")
	public WebElement creatAccountButton;
	
	public void createAccount(String rowRef) throws IOException 
	{
		HashMap<String, String> account = predef.readDataFromExcelSheet(rowRef, "NewAccountDetails");
		predef.typeinEditbox(firstName, account.get("FirstName"));
		predef.typeinEditbox(lastName, account.get("LastName"));
		String email = account.get("Email")+System.currentTimeMillis()+"@gmail.com";
		predef.typeinEditbox(emailField, email);
		predef.typeinEditbox(createPassword, "*Rajendra1");
		predef.typeinEditbox(confirmPassword, "*Rajendra1");
		
		predef.clickOnElement(creatAccountButton);	
	}
	
}