package driverManager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import stepDefinitions.CucumberHooks;
import utilities.EnvironmentVals;
 
public class InvokedMethodListener implements IInvokedMethodListener
{

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) 
	{
		 if (method.isTestMethod()) 
		{
           System.out.println("Test Method BeforeInvocation is started. " + Thread.currentThread().getId());
           /*
           String browserName = System.getProperty("browser");
           if(browserName == null) 
           {
        	   browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browser");
        	   if(browserName == null) 
        		   browserName = EnvironmentVals.getEnvInstance().getBrowser();
           }
           
           System.out.println("*browserName:- "+ browserName);
           
           String localeinfo = System.getProperty("locale");
           if(localeinfo == null) 
           { 
        	   localeinfo = method.getTestMethod().getXmlTest().getLocalParameters().get("locale");
        	   if(localeinfo == null)
        		   localeinfo = EnvironmentVals.getEnvInstance().getInstanceAndLocale();
           }
           System.out.println("***localeinfo:- "+ localeinfo);

           EnvironmentVals.getEnvInstance().setLocale(localeinfo);
          
           TLDriverFactory.setDriver(browserName); 
           
           */
		 }
			 

	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) 
	{
		if (method.isTestMethod())
		{
            System.out.println("Test Method AfterInvocation is started. " + Thread.currentThread().getId());
            WebDriver driver = TLDriverFactory.getDriver();
            if (driver != null) 
            {
            }
		}	
	}
}