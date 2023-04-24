package driverManager;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.EnvironmentVals;

public class TLDriverFactory
{
	private static OptionsManager optionsManager = new OptionsManager();
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
    public static String browseris;
    
  
	@SuppressWarnings("deprecation")
	public static synchronized void setDriver(String browser) {
		browseris = browser;
    	String strRemoteURL =null;
    	String strBrowserStackURL =null; 
    	String strRemoteExec =  EnvironmentVals.getEnvInstance().getRemoteExecution();
    	String strBrowserStackExec =  EnvironmentVals.getEnvInstance().getBrowserStackExecution();
    	try 
		{	
	    	if(strRemoteExec.equalsIgnoreCase("true"))
	    	strRemoteURL =  EnvironmentVals.getEnvInstance().getRemoteURL();    		
	    	//Below code has to be verified for the correctness yet.
	    	else if(strBrowserStackExec.equalsIgnoreCase("true"))
	    	{
	    		
	    		strBrowserStackURL = "https://" + EnvironmentVals.getEnvInstance().getBrowStackUserName() + ":" + EnvironmentVals.getEnvInstance().getBrowStackAccessKey() + "@hub-cloud.browserstack.com/wd/hub";
	    		try {
					tlDriver.set(new RemoteWebDriver(new URL(strBrowserStackURL), optionsManager.getBrowserStackCapabilities()));
				} catch (MalformedURLException e) {				
					e.printStackTrace();
				}
	    	}
	    	else
	    	{
				if (browser.equalsIgnoreCase("firefox"))
				{
		            if (strRemoteExec.equalsIgnoreCase("true"))
		            {
		            	//DesiredCapabilities caps = DesiredCapabilities.firefox();
		            	tlDriver.set(new RemoteWebDriver(new URL(strRemoteURL+"/wd/hub"), optionsManager.getFirefoxOptions()));
		            }
		            
		            else {
		            	
//		            	tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		            	WebDriverManager.firefoxdriver().setup();
//		            	tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		            	tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
	                    tlDriver.get().manage().window().maximize();
		            }
		        } 

				else if (browser.equals("chrome"))
	            {
	                if (strRemoteExec.equalsIgnoreCase("true"))
	                    tlDriver.set(new RemoteWebDriver(new URL(strRemoteURL+"/wd/hub"), optionsManager.getChromeOptions()));
	               
	                else
	                {
	                    //tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
	                    WebDriverManager.chromedriver().setup();
	                    tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
	                    tlDriver.get().manage().window().maximize();
	                }
	            }
				else if (browser.equals("internet explorer"))
				{
					if (strRemoteExec.equalsIgnoreCase("true"))
					{
		    			tlDriver.set(new RemoteWebDriver(new URL(strRemoteURL+"/wd/hub"), optionsManager.getIEOptions()));
					}
					
		            else
		            {
		            	WebDriverManager.iedriver().setup();
		            	tlDriver.set(new InternetExplorerDriver(optionsManager.getIEOptions()));
		            	tlDriver.get().manage().window().maximize();
		            	
//		            	System.setProperty("webdriver.ie.driver", EnvironmentVals.getEnvInstance().getieDriver());
//		            	tlDriver.set(new InternetExplorerDriver(optionsManager.getIEOptions()));
		            }
				}
				else if (browser.contains("mobile"))
				{
					  /*
					   * https://cs.chromium.org/chromium/src/chrome/test/chromedriver/chrome/mobile_device_list.cc
					   	  iPad
						  Nexus 6
						  Nexus 5
						  Galaxy Note 3
						  Nexus 6P
						  iPhone 8 Plus
						  iPhone 7 Plus
						  Nexus 7
						  iPhone 7
						  Nexus 10
						  iPhone 8
						  iPhone 6
						  Nexus 5X
						  Galaxy Note II
						  iPhone 6 Plus
						  iPhone X
						  Galaxy S5
					   */
					
					System.setProperty("webdriver.chrome.driver", EnvironmentVals.getEnvInstance().getChromeDriver());
//	            	tlDriver.set(new ChromeDriver(optionsManager.getMobileOptions(browser)));
				}
				
//				else if (browser.equals("safari"))
//	            {
//	                if (strRemoteExec.equalsIgnoreCase("true"))
//	                    tlDriver.set(new RemoteWebDriver(new URL(strRemoteURL+"/wd/hub"), optionsManager.getSafariOptions()));
//
//	 
//
//	                else
//	                    tlDriver.set(new SafariDriver());
//	                tlDriver.get().manage().window().maximize();
//
//
//	            }
				
				else if (browser.equals("safari"))
	            {
	                if (strRemoteExec.equalsIgnoreCase("true"))
	                    tlDriver.set(new RemoteWebDriver(new URL(strRemoteURL+"/wd/hub"), optionsManager.getSafariOptions()));
	               
	                else
	                    tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
	            }
		 	}
		}
		catch (MalformedURLException e) 
		{
			Reporter.log("WebDriver instantiation failed");
			e.printStackTrace();
		}
    	
	}
	public static synchronized WebDriverWait getWait (WebDriver driver, int seconds)
	{
		return new WebDriverWait(driver, seconds);
	}

	public synchronized static WebDriver getDriver()
	{
		return tlDriver.get();
	}
 
}
