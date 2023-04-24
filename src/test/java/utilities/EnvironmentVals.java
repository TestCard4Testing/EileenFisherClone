package utilities;

import java.util.Properties;

public class EnvironmentVals {
	
	 
	public static Properties prop = null;
	private String configPropFilePath = System.getProperty("user.dir")+"//src//test//java//config//config.properties";
	private String locatorsPath = System.getProperty("user.dir")+"//src//test//java//selectors//";
	private String localeVal;
	//private String env;
	public static EnvironmentVals globalVals = new EnvironmentVals();
	static FileReaderUtils flReader;
	private static String locatorsFilePath;
    
	public EnvironmentVals()
	{
	}
	
	public static EnvironmentVals getEnvInstance()
	{
		return globalVals;		
	}
	
	public String isBopis()
	{
		return (String) getConfig().get("bopis");
	}
	public String isHeadless()
	{
		return (String) getConfig().get("headless");
	}
	
	public Properties getConfig()
	{
		flReader = new FileReaderUtils();
		prop =  flReader.ReadFromTextFile(configPropFilePath);
		return prop;
	}
	
	
	public String getChromeDriver()
	{   
		String driverPath = getConfig().getProperty("chromeDriver");	
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Chrome driverPath is not specified in the config.properties file.");		
	}
	
	public String getFirefoxDriver()
	{
		String driverPath = getConfig().getProperty("firefoxDriver");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Firefox driverPath is not specified in the config.properties file.");
	}
	public String getieDriver()
	{
		String driverPath = getConfig().getProperty("ieDriver");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("IE driverPath is not specified in the config.properties file.");
	}
	
	public String getEnvURL()
	{    
		String locale = getLocale().toLowerCase();
		String envURL = getConfig().getProperty(locale+"_"+"testEnvironment");		
		if(envURL != null) return envURL;
		else throw new RuntimeException("Test environment URL not specified in the config.properties file.");
	}
	
	public String getBrowser()
	{
		String browser = getConfig().getProperty("browser");
//		return browser;
		if(browser != null) return browser;
		else throw new RuntimeException("Browser is not specified in the config.properties file.");
	}
	
	public String getTestDataPath()
	{
		String locale = getLocale();
		String testDataFilePath = getConfig().getProperty(locale+"_"+"testData");	
		if(testDataFilePath != null) return testDataFilePath;
		else throw new RuntimeException("Test Data file path is not specified in config.properties file.");	
	}
	
//	To return the Locale defined in the config.properties file when scripts running by maven install
	public String getInstanceAndLocale() {
		String instanceAndLocale = getConfig().getProperty("locale");	
		if(instanceAndLocale != null) return instanceAndLocale;
		else throw new RuntimeException("Instance And Locale are not specified in the config.properties file.");
	}
	
	public String getSafariDriver()
    {
        String driverPath = "/usr/local/safaridriver"; //getConfig().getProperty("firefoxDriver");
//        String driverPath = getConfig().getProperty("safaridriver");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("Firefox driverPath is not specified in the config.properties file.");
    }

//	Returns the Locators file path
	public String getLocatorFilePath()
	{
		String locale = getLocale();
		locatorsFilePath = getConfig().getProperty(locale+"_"+"selectors");
		return locatorsFilePath;
	}
	
//	To set the locators file
	 public static void setLocatorProperties()
    {	
    	locatorsFilePath = EnvironmentVals.getEnvInstance().getLocatorFilePath();	
	}
	   
	 public void setLocale(String locale)
    {	
    	localeVal = locale.toLowerCase();
    	locatorsFilePath = getConfig().getProperty(locale+"_"+"selectors");
	}
 
	 public String getLocale()
    {	
    	return localeVal;
    	//System.out.println("locatorsFilePath:" + locatorsFilePath);
	}
	 
	 
    public static Properties getLocatorProperties()
    {	
    	prop = flReader.ReadFromTextFile(locatorsFilePath);
		return prop;
    }
    
    
    public String getRemoteExecution()
	{
		String remoteExec = getConfig().getProperty("RemoteExecution");	
		if(remoteExec!= null) return remoteExec;
		else throw new RuntimeException("Remote Execution is not specified in the config.properties file.");		

	}
	public String getRemoteURL()
	{
		String remoteURL = getConfig().getProperty("RemoteURL");	
		if(remoteURL != null) return remoteURL;
		else throw new RuntimeException("Remote URL is not specified in the config.properties file.");		

	}
	
	public String getBrowserStackExecution()
	{
		String browserStack = getConfig().getProperty("BrowserStackExecution");	
		if(browserStack != null) return browserStack;
		else throw new RuntimeException("Browser Stack Execution value is not specified in the config.properties file.");	
	}
	
	public String getBrowStackUserName()
	{
		String userName = getConfig().getProperty("UserName");	
		if(userName != null) return userName;
		else throw new RuntimeException("Browser Stack UserName value is not specified in the config.properties file.");	
	}

	public String getBrowStackAccessKey()
	{
		String accessKey = getConfig().getProperty("AccessKey");	
		if(accessKey != null) return accessKey;
		else throw new RuntimeException("Browser Stack AccessKey value is not specified in the config.properties file.");	
	}
	
}
