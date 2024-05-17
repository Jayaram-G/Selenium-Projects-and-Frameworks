package com.bdd.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.bdd.step_definitions",
		dryRun = false,
		monochrome = true,
		plugin = {"rerun:target/failed_scenario.txt",
				"html:target/cucumber_reports/report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				 }
		
		)
public class TestRunner {
	
	

}
