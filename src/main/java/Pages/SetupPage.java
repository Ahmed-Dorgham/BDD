package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class SetupPage extends UtilitiesMethods {
    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private WebElement page_header;
    private WebElement data_import_element;
    private WebElement close_icon;
    private Wait<WebDriver> fluent_Wait;

    public SetupPage(WebDriver driver) {
        this.driver = driver;
    }

    /******************************************************************************************************************************************/
    public WebElement get_setup_header() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h5[contains(text(),'إعداد')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                (" //h5[contains(text(),' المنظمة')]")));
        page_header = driver.findElement(By.xpath
                ("//h5[contains(text(),'إعداد')]"));
        return page_header;
    }

    /*************************************************************************************************************************************/
    public DataImportPage open_data_import_page() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(300));
        js.executeScript("window.scrollTo(0,3000)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id
                ("setup-page-data-import-tool")));
        data_import_element = driver.findElement(By.id("setup-page-data-import-tool"));
        click_on_element(data_import_element);
        return new DataImportPage(driver);
    }

    /******************************************************************************************************************************************/
    public void close_window() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']")));
        close_icon = driver.findElement(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']"));
        click_on_element(close_icon);
    }

    /************************************************************************************************************************************/
    public void scroll_down() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,3000)");
    }

    /***********************************************************************************************************************************/

    public void scroll_to_element(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        // WebElement element = driver.findElement(By.id("my-id"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
    /******************************************************************************************************************************************/
}
