package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = {"src/test/java/features"},
    glue = {"stepDefinitions"},
    tags = "@login-portal",
    monochrome = false,
    dryRun = false,
    plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
)
public class MainRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
