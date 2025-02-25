package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/cucumber-WEB-report.html", "json:reports/cucumberWEB.json"},
        glue = {"webUIstepDef"},
        features = {"src/test/java/webUIfeature/WEB.feature"},
        tags = "@web"
)

public class webRunner {
}
