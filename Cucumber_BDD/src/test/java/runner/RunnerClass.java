package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="featureFiles", 
		glue={"stepDefinitions","hooks"},
		dryRun = true,
		monochrome = true,
		plugin = {"pretty","html:report/cucumber-reports","json:report/jsonreport.json"},
		tags =  "@Hooks"
		)




public class RunnerClass {
	
	//it should combine the feature file and the step definition
	// Runner define
	

}
