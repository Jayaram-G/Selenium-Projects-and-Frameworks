package com.bdd.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "@target/failed_scenarios.txt",
		glue = "com.bdd.step_definitions",
		dryRun = false,
		monochrome = true
		)
public class ReRunner {
	

}
