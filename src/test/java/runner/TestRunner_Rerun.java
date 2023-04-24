//package runner;
//
//
//import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
//
//
////@RunWith(Cucumber.class)
//@CucumberOptions(
//		features = "@target/failed_scenario/rerun.txt", // Path of feature files
//				junit = "--step-notifications",
//		glue={"stepDefinitions"}, // We give the path of step definition package
//		monochrome=true, //Display the output in readable format
//		dryRun=false,//It checks whether all the steps have got step definitions methods
//
//				plugin = { "pretty",  "junit:target/cucumber-reports_rerun/Cucumber.xml",
//						"json:target/surefire-reports/Cucumber.json",
//							 "html:target/surefire-reports",
//							 "rerun:target/failed_scenario/rerun1.txt"
//						}
//				
//	
//		)
//
//public class TestRunner_Rerun extends AbstractTestNGCucumberTests {
//
//	
//
//}
