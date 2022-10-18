package cucmberOptions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features={"src/test/java/features/Register.feature"}, glue = {"stepDefinition"})
public class TestRunner {
    
}
