package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "Feature", glue = "stepDefinition")

public class SlotTestRunner extends AbstractTestNGCucumberTests {

}
