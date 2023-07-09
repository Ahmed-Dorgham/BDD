package runner;

import TestCases.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/SalesInvoice/SubmitSalesInvoice_PositiveCase.feature",
        glue = {"StepDefinition.SubmitSalesInvoice_PositiveCase"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
        tags = "not @Skip"
)
public class TestRunner extends TestBase {
}
//  plugin = {"pretty", "html:target/cucumber-html-report"})