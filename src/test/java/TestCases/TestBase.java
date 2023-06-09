package TestCases;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        // System.setProperty("webdriver.chrome.driver", "D:\\to run  intelliJ & to begin automation\\chromedriverr_win32\\chromedriver.exe");
        // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
        // driver = new ChromeDriver();
        //ChromeOptions options = new ChromeOptions();
        // options.addExtensions(new File("C:\\Users\\ahmed\\OneDrive\\Desktop\\extension_3_3_0_0.crx"));
   /*    // DesiredCapabilities capabilities = new DesiredCapabilities();
       // capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        // ChromeDriver driver = new ChromeDriver(capabilities);*/
        //  driver = new ChromeDriver(options);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        // Create the driver object
        // driver = new ChromeDriver();
       /* MutableCapabilities capabilities = new MutableCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");  // ChromeOptions for starting chrome in incognito mode

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
// other capability declarations
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "latest");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("os", "Windows");
        browserstackOptions.put("osVersion", "10");
        capabilities.setCapability("bstack:options", browserstackOptions);
        public static final String URL = "https://YOUR_USERNAME:YOUR_ACCESS_KEY@hub-cloud.browserstack.com/wd/hub";
        WebDriver driver = new RemoteWebDriver(new URL(URL), capabilities);*/

// rest of the test case goes here


    }

    // @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}

