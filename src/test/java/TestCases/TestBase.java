package TestCases;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

 @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}

