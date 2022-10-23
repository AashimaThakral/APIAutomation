package cucmberOptions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
// import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/features", glue = {"stepDefinition"})
public class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void setUp() throws Exception
    {
  testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider="features")
      public void my_test(PickleWrapper pickle, FeatureWrapper cucumberFeature)
    {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass()
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
    
}
