package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"FeatureFiles/Login.feature"},
		glue= {"StepDefinition"},
		plugin = {"pretty","json:target/cucumber.json", "html:target/cucumber-html-report"},
		tags = "@WIP",
		dryRun=false)

public class TestRunner {

	
	
	
	
}
