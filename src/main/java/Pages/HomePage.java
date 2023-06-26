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
    private WebElement dashboard_header;
    private WebElement sales_anchor;
    private WebElement stock_anchor;
    private WebElement sales_invoices;
    private WebElement items;
    private WebElement setting_icon;
    private WebElement setup_element;
    private WebElement close_icon;
    private WebElement hr_module;
    private WebElement reports_module;
    private WebElement settingIcon;
    private WebElement clear_cash_element;
    private WebElement yes_button;
    private WebElement account_statement_element;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /******************************************************************************************************************************************/
    public WebElement get_dashboard_header_element() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(300));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[contains(@class ,'dashboard-header')]")));

        dashboard_header = driver.findElement(By.xpath
                ("//div[contains(@class ,'dashboard-header')]"));
        return dashboard_header;
    }

    /******************************************************************************************************************************************/
    public SalesInvoicesListPage open_sales_invoices_list_page() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
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
        wait = new WebDriverWait(driver, ofSeconds(300));
        stock_anchor = driver.findElement(By.id("module-anchor-Stock"));
        js.executeScript("arguments[0].click();", stock_anchor);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sidebar-stock-item")));
        items = driver.findElement(By.id("sidebar-stock-item"));
        js.executeScript("arguments[0].click();", items);
        return new ItemsListPage(driver);
    }

    /**********************************************************************************************************************************************/
    public SetupPage open_setup_page() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        setting_icon = driver.findElement(By.xpath
                ("//i[@data-kooltip='إعداد']"));
        js.executeScript("arguments[0].click();", setting_icon);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//a[@id='toolbar-setup']")));
        setup_element = driver.findElement(By.xpath
                ("//a[@id='toolbar-setup']"));
        js.executeScript("arguments[0].click();", setup_element);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//i[@class='pull-left icon-settings-cog']")));
        return new SetupPage(driver);
    }

    /**************************************************************************************************************************************/
    public void close_window() {
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']")));
        close_icon = driver.findElement(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']"));
        click_on_element(close_icon);
    }

    /************************************************************************************************************************************/
    public ReportsPage open_reports_page() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));

        hr_module = driver.findElement(By.id
                ("module-anchor-HR"));
        click_on_element(hr_module);
        //js.executeScript("arguments[0].click();", hr_module);
        js.executeScript("window.scrollBy(0,800)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id
                ("module-anchor-reports")));
        reports_module = driver.findElement(By.id
                ("module-anchor-reports"));
        click_on_element(reports_module);
        //js.executeScript("arguments[0].click();", reports_module);
        return new ReportsPage(driver);
    }

    /**************************************************************************************************************************************/
    public void clear_cash() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//i[@data-kooltip='إعداد']")));
        settingIcon = driver.findElement(By.xpath
                ("//i[@data-kooltip='إعداد']"));
        click_on_element(settingIcon);
        //js.executeScript("arguments[0].click();", settingIcon);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//li[@id='clear-cach-icon']")));
        clear_cash_element = driver.findElement(By.xpath
                ("//li[@id='clear-cach-icon']"));
        click_on_element(clear_cash_element);
        //js.executeScript("arguments[0].click();", clear_cash_element);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//button[@class='btn btn-info btn-yes']")));
        yes_button = driver.findElement(By.xpath
                ("//button[@class='btn btn-info btn-yes']"));
        click_on_element(yes_button);
        //js.executeScript("arguments[0].click();", yes_button);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[contains(@class ,'dashboard-header')]")));
    }

    /**************************************************************************************************************************************/
}
