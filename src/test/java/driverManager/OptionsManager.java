package driverManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import utilities.EnvironmentVals;

public class OptionsManager {


	public ChromeOptions getChromeOptions() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-notifications");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", prefs);

		String isHeadless = System.getProperty("headless");
		if(isHeadless == null)
		{
			isHeadless = EnvironmentVals.getEnvInstance().isHeadless();
		}
		String isBopis = System.getProperty("bopis");
		if(isBopis == null)
		{
			isBopis = EnvironmentVals.getEnvInstance().isBopis();
		}	
		if(isBopis.equalsIgnoreCase("true"))
		{
			options.addArguments("load-extension=C:\\Users\\rprasad01\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 3\\Extensions\\majdfhpaihoncoakbjgbdhglocklcgno\\2.6.0_0");
		}


		// options.addArguments("user-data-dir=C:\\Users\\rprasad01\\AppData\\Local\\Google\\Chrome\\User Data\\Guest Profile");
		//options.addArguments("--headless");

		//        options.addArguments("--allow-insecure-localhost");

		//        options.addArguments("--ignore-certificate-errors");

		//        options.setAcceptInsecureCerts(true);
		//        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		//        
		//        options.addArguments("--disable-blink-features=AutomationControlled");//To set navigator.webdriver flag false, not to recognize as chrome is being driven by Selenium
		//        options.setExperimentalOption("useAutomationExtension","false");//To disable the use of extension
		//        
		//        
		//        options.addArguments("--disable-blink-features=AutomationControlled");
		//        options.addArguments("--disable-automation");// To disable infobar
		//        options.setExperimentalOption("excludeSwitches","enable-automation");
		//        options.setExperimentalOption("excludeSwitches","enable-logging");
		//        options.setExperimentalOption("useAutomationExtension","false");
		//        options.addArguments("--incognito");
		return options;
	}

	//Get Firefox Options
	public FirefoxOptions getFirefoxOptions () {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-popup-blocking");
		String isHeadless = System.getProperty("headless");
		if(isHeadless == null)
		{
			isHeadless = EnvironmentVals.getEnvInstance().isHeadless();
		}
		String isBopis = System.getProperty("bopis");
		if(isBopis == null)
		{
			isBopis = EnvironmentVals.getEnvInstance().isBopis();
		}	
		if(isBopis.equalsIgnoreCase("true"))
		{
			options.addArguments("load-extension=C:\\Users\\rprasad01\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 3\\Extensions\\majdfhpaihoncoakbjgbdhglocklcgno\\2.6.0_0");
		}


		//options.addArguments("--incognito");
		return options;
	}

	public InternetExplorerOptions getIEOptions() {

		InternetExplorerOptions options = new InternetExplorerOptions();
		return options;	
	}

	//    public DesiredCapabilities getIEOptions() {  	
	//    	DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	//		caps.setBrowserName("internet explorer");
	//		caps.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
	//        caps.setCapability(CapabilityType.PLATFORM_NAME, "WINDOWS");
	//	
	//		caps.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
	//		caps.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, false);
	//		System.setProperty("webdriver.ie.driver", EnvironmentVals.getEnvInstance().getieDriver());
	//		return caps;		
	//    }

	//    public DesiredCapabilities getMobileOptions(String browser) {
	//    	
	//    	String mobile = browser.split("_")[1];
	//    	DesiredCapabilities caps = DesiredCapabilities.chrome();
	//    	caps.setCapability("platform", "WINDOWS");
	//    	caps.setBrowserName("chrome");
	//
	//		Map<String, String> mobileEmulation = new HashMap<String, String>();
	//		mobileEmulation.put("deviceName", mobile);
	//		Map<String, Object> chromeOptions = new HashMap<String, Object>();
	//		chromeOptions.put("mobileEmulation", mobileEmulation);
	//
	//		ChromeOptions options = new ChromeOptions();
	//
	//		options.setExperimentalOption("mobileEmulation", mobileEmulation);
	//		caps.setCapability(ChromeOptions.CAPABILITY, options);	
	//		return caps;
	//    }



	public DesiredCapabilities getBrowserStackCapabilities()
	{

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "chrome");
		caps.setCapability("browser_version", "101.0");
		caps.setCapability("browserstack.local", "false");
		//  caps.setCapability("browserstack.selenium_version", "3.10.0");

		/*
		 * caps.setCapability("browserName", "Chrome"); caps.setCapability("device",
		 * "Windows 11"); caps.setCapability("realMobile", "true");
		 * caps.setCapability("os_version", "11"); caps.setCapability("name",
		 * "Bstack-[Java] Sample Test");
		 */   return caps;
	}

	//    public DesiredCapabilities getSafariOptions () {
	//        
	//        DesiredCapabilities caps = DesiredCapabilities.safari();
	//        caps.setCapability(CapabilityType.BROWSER_NAME, "safari");
	////      caps.setCapability(CapabilityType.PLATFORM_NAME, "OSX");
	//      
	//        System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
	//        return caps;
	//    }

	public DesiredCapabilities getSafariOptions () {

		/*FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        options.setCapability(FirefoxDriver.PROFILE, profile);
		 */
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability(CapabilityType.BROWSER_NAME, "safari");
		caps.setCapability(CapabilityType.PLATFORM_NAME, "WINDOWS");
		System.setProperty("webdriver.safari.driver", EnvironmentVals.getEnvInstance().getSafariDriver());
		return caps;
	}


}
