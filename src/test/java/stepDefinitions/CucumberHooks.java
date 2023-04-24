package stepDefinitions;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.EmailException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import driverManager.TLDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import objectsContainer.ObjectsContainer;
import utilities.EmailableReportsClass;
import utilities.EnvironmentVals;


public class CucumberHooks 
{
	public String scenarioName;
	public ObjectsContainer pageObjects;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static CucumberHooks setUpObject;
	public Exception except;
	public static String path;
	public static boolean isPluginEnabled;

	@AfterAll
	public static void afterAll() throws EmailException
	{
		extent.flush();
		EmailableReportsClass emailableReports = null;
		emailableReports = new EmailableReportsClass();
		//emailableReports.multiPartEmailWithAttachment();
	}

	@BeforeAll
	public static void beforeAll()
	{
		String browserName = System.getProperty("browser");
		if(browserName == null) 
		{
			if(browserName == null) 
			{
				browserName = EnvironmentVals.getEnvInstance().getBrowser();
			}
		}
		System.out.println("*browserName:- "+ browserName);

		String localeinfo = System.getProperty("locale");
		if(localeinfo == null) 
		{ 
			if(localeinfo == null)
			{
				localeinfo = EnvironmentVals.getEnvInstance().getInstanceAndLocale();
			}
		}
		System.out.println("***localeinfo:- "+ localeinfo);
		EnvironmentVals.getEnvInstance().setLocale(localeinfo);
		TLDriverFactory.setDriver(browserName);

		setUpExtentReports();
	}

	public static void setUpExtentReports() 
	{
		extent=new ExtentReports(); 
		ExtentHtmlReporter repo;
		DateFormat dateFormat = new SimpleDateFormat("yyyy_dd_MMM_HH_mm_ss");
		Date date = new Date();
		String getCurrentDate = dateFormat.format(date);
		path = EnvironmentVals.getEnvInstance().getConfig().getProperty("ExtentHtmlReporterFile")+"-"+getCurrentDate+".html";
		repo=new ExtentHtmlReporter(path);
		repo.config().setEncoding("UTF-8");
		repo.config().setReportName("Extent Reports");
		repo.config().setDocumentTitle("Extent Reports");
		repo.config().setTheme(Theme.DARK); 
		extent.attachReporter(repo);
	}
	@Before
	public void before(Scenario scenario) 
	{
		setUpObject = this;
		pageObjects = new ObjectsContainer();
		scenarioName = scenario.getName();
		test = extent.createTest(scenarioName);
	}
	@After
	public void after(Scenario scenario) throws IOException, EmailException  
	{	
		if(scenario.isFailed())
		{
			String fileName = scenario.getName();
			fileName = new PredefinedSteps(TLDriverFactory.getDriver()).takeScreenshot(fileName);
			if(fileName != null)
			{
				test.log(Status.FAIL, "\""+scenario.getName()+"\" scenario execution FAILED", MediaEntityBuilder.createScreenCaptureFromPath(fileName).build());
				test.log(Status.FAIL, except);
			}
			else
			{
				test.log(Status.FAIL, "\""+scenario.getName()+"\" scenario execution FAILED");
			}
		}
		else
		{
			test.log(Status.PASS, "\""+scenario.getName()+"\" scenario execution PASSED");
		}
	}
	@AfterStep
	public void afterStep(Scenario scenario)
	{

	}
	@BeforeStep
	public void before_step(Scenario scenario)
	{

	}
}
