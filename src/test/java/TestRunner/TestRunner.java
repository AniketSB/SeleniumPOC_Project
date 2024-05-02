package TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"FeatureFiles"},
		glue= {"StepDefinition"},
		plugin = {"pretty","json:target/cucumber.json", "html:target/cucumber-html-report.html"},
//		plugin = {"pretty",
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//				"timeline:test-output-thread/"
//		},
		tags = "@WIP",
		monochrome = true)

public class TestRunner {

	
	
	
	
}
