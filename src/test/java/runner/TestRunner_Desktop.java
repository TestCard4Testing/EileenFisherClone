package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "Features", // Path of feature files

		glue={"stepDefinitions", "pageClasses"}, // We give the path of step definition package
		monochrome=true, //Display the output in readable format
		dryRun=false,//It checks whether all the steps have got step definitions methods
		plugin = { "pretty", "junit:target/cucumber-reports/Cucumber.xml"},
		tags= "@ShipToHome or @Login"
		)
public class TestRunner_Desktop extends AbstractTestNGCucumberTests 
{
	
}
