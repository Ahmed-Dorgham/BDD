package runner;

import TestBase.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/ReceiptVoucher/MakeReceiptVoucher.feature",
        glue = {"StepDefinition.MakeReceiptVoucher"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
        tags = "not @Skip"
)
public class TestRunner extends TestBase {
}
//  plugin = {"pretty", "html:target/cucumber-html-report"})