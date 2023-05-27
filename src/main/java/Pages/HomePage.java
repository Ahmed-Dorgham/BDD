package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class HomePage extends UtilitiesMethods {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private WebElement assertItem;
    private WebElement sales_anchor;
    private WebElement stock_anchor;

    private WebElement sales_invoices;
    private WebElement items;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /******************************************************************************************************************************************/
    public WebElement get_web_element() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[contains(@class ,'dashboard-header')]")));
        // wait.until(ExpectedConditions.visibilityOf(assertItem));
        assertItem = driver.findElement(By.xpath
                ("//div[contains(@class ,'dashboard-header')]"));
        return assertItem;
    }

    /******************************************************************************************************************************************/
    public SalesInvoicesListPage open_sales_invoices_list_page() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        sales_anchor = driver.findElement(By.id("module-anchor-Selling"));
        js.executeScript("arguments[0].click();", sales_anchor);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sidebar-selling-invoice")));
        sales_invoices = driver.findElement(By.id("sidebar-selling-invoice"));
        js.executeScript("arguments[0].click();", sales_invoices);
        return new SalesInvoicesListPage(driver);
    }

    /**********************************************************************************************************************************************/
    public ItemsListPage open_items_list_page() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        stock_anchor = driver.findElement(By.id("module-anchor-Stock"));
        js.executeScript("arguments[0].click();", stock_anchor);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sidebar-stock-item")));
        items = driver.findElement(By.id("sidebar-stock-item"));
        js.executeScript("arguments[0].click();", items);
        return new ItemsListPage(driver);
    }
/**********************************************************************************************************************************************/
}
