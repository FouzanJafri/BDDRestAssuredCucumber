package StepRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/FeatureFiles",plugin = "json:target/jsonReport/cucmber-report.json",glue = {"StepDefinations"})
public class JunitTestRunner {

}
