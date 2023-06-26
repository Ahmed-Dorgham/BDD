package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofSeconds;

public class GeneralLedgerPage extends UtilitiesMethods {
    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private WebElement account_cell;
    private WebElement account_coulmn;
    private WebElement load_data;
    private WebElement reports_module;
    private WebElement hr_module;
    private WebElement row_element;
    private WebElement report_element;
    private List<WebElement> accounts_list;
    private List<WebElement> debit_list;
    private List<WebElement> voucher_list;

    public GeneralLedgerPage(WebDriver driver) {
        this.driver = driver;
    }

    /************************************************************************************************************************************/
    public int rows_number() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//div[@class='slick-viewport']//div[@class='slick-cell b1 f1'])[1]//a")));
        row_element = driver.findElement(By.xpath
                ("(//div[@class='slick-viewport']//div[contains(@class,'ui-widget-content slick-row')])"));
        accounts_list = row_element.findElements(By.xpath("//div[@class='slick-cell b1 f1']"));

        return accounts_list.size();
    }

    /************************************************************************************************************************************/
    public WebElement account_in_general_ledger(int i) {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//div[@class='slick-viewport']//div[@class='slick-cell b1 f1'])[1]//a")));
        row_element = driver.findElement(By.xpath
                ("(//div[@class='slick-viewport']//div[contains(@class,'ui-widget-content slick-row')])"));
        accounts_list = row_element.findElements(By.xpath("//div[@class='slick-cell b1 f1']//a"));
        return accounts_list.get(i);
    }

    /************************************************************************************************************************************/
    public void click_on_load_data() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//input[@data-fieldname='group_by_voucher']")));
        load_data = driver.findElement(By.id
                ("appframe-btn-تحميل البيانات"));
        //click_on_element(load_data);
        js.executeScript("arguments[0].click();", load_data);
    }

    public WebElement debit_in_general_ledger(int i) {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//div[@class='slick-viewport']//div[@class='slick-cell b1 f1'])[1]//a")));
        row_element = driver.findElement(By.xpath
                ("(//div[@class='slick-viewport']//div[contains(@class,'ui-widget-content slick-row')])"));
        debit_list = row_element.findElements(By.xpath("//div[@class='slick-cell b5 f5']//div"));
        return debit_list.get(i);
    }

    public WebElement voucher_number_in_general_ledger(int i) {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//div[@class='slick-viewport']//div[@class='slick-cell b1 f1'])[1]//a")));
        row_element = driver.findElement(By.xpath
                ("(//div[@class='slick-viewport']//div[contains(@class,'ui-widget-content slick-row')])"));
        voucher_list = row_element.findElements(By.xpath("//div[@class='slick-cell b3 f3']"));
        return voucher_list.get(i);
    }

    public WebElement get_report() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//div[@class='slick-viewport']//div[@class='slick-cell b1 f1'])[1]//a")));
        report_element = driver.findElement(By.xpath
                ("//div[@class='slick-viewport']"));
        return report_element;
    }

    public ReportsPage open_reports_page() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        Actions mouse = new Actions(driver);
        hr_module = driver.findElement(By.id
                ("module-anchor-HR"));
        click_on_element(hr_module);
        js.executeScript("window.scrollBy(0,800)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id
                ("module-anchor-reports")));
        reports_module = driver.findElement(By.id
                ("module-anchor-reports"));
        js.executeScript("arguments[0].click();", reports_module);
        return new ReportsPage(driver);
    }
}
