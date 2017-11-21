package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/feature"
                 ,glue="testcases"
                 ,plugin = {"pretty",
                		    "html:target/cucumber-htmlreport",
                		    "json:target/json-report/cucumber.json",
                            "junit:target/junit-xml/cucumber.xml",
                            "com.cucumber.listener.ExtentCucumberFormatter:extent-report/extent-report.html"
                            }
                 ,tags = {"@SmokeTest"}
                 ,monochrome = true //display console output in readable format
                 //,strict = true
                 //,dryRun = false //check mapping between feature file and dtep definition 
                 )

/*{"@SmokeTest,@RegressionTest"} - Smoke OR Regression
{"@SmokeTest","@RegressionTest"} - Smoke AND Regression
{"@SmokeTest","~@RegressionTest"} - All Smoke SKIP Regression*/

public class RunnerTest { //extends AbstractTestNGCucumberTests {

	 @AfterClass
	    public static void reportSetup() 
	 	{
	        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	        /*Properties p = System.getProperties();
	        p.list(System.out);*/
	        
	        Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
	        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	        Reporter.setSystemInfo("2.53.0", "Selenium");
	        Reporter.setTestRunnerOutput("Cucumber JUnit Test Runner");
	 	}
	
	 //Reporter.addStepLog("Step Log message goes here");
	 //Reporter.addScenarioLog("Scenario Log message goes here");
}

