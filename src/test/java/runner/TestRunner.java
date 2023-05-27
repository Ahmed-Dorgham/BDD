package runner;

import TestCases.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/CancelActionOnBulkSalesInvoices.feature",
        glue = {"Steps"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"}
)
public class TestRunner extends TestBase {
}
//  plugin = {"pretty", "html:target/cucumber-html-report"})