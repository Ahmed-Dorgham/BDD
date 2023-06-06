package TestCases;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        // System.setProperty("webdriver.chrome.driver", "D:\\to run  intelliJ & to begin automation\\chromedriverr_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

  //  @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}

