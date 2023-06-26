package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofSeconds;

public class AccountStatementReportPage extends UtilitiesMethods {
    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private WebElement load_data;
    private WebElement client_name_field;
    private WebElement client_name_input;
    private WebElement row_element;
    private WebElement closing_element;
    private WebElement voucher_description;
    private WebElement document_number;
    private WebElement debit;
    private WebElement clickable_element_in_table;
    private WebElement table_element;
    private WebElement homepage_icon;
    private WebElement settingIcon;
    private WebElement yes_button;
    private WebElement close_icon;

    private WebElement clear_cash_element;
    private List<WebElement> rows_list;
    private List<WebElement> voucher_list;

    private List<WebElement> debit_list;
    private List<WebElement> credit_list;

    public AccountStatementReportPage(WebDriver driver) {
        this.driver = driver;
    }

    public void click_on_load_data_after_enter_client_name(String client_name) {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@id='appframe-btn-طباعة']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@id='appframe-btn-طباعة']")));
        client_name_field = driver.findElement(By.xpath("//div[@data-original-title='عميل']//div"));
        click_on_element(client_name_field);
        client_name_input = driver.findElement(By.xpath("//div[@data-original-title='عميل']//div//input"));
        enter_data_to_input_field(client_name_input, client_name);
        load_data = driver.findElement(By.id
                ("appframe-btn-تحميل البيانات"));
        js.executeScript("arguments[0].click();", load_data);
    }

    public void click_on_load_data_without_entries() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@id='appframe-btn-طباعة']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@id='appframe-btn-طباعة']")));
        load_data = driver.findElement(By.id
                ("appframe-btn-تحميل البيانات"));
        js.executeScript("arguments[0].click();", load_data);
    }

    public void click_on_load_data_before(String client_name) {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@id='appframe-btn-طباعة']")));
        client_name_field = driver.findElement(By.xpath("//div[@data-original-title='عميل']//div"));
        click_on_element(client_name_field);
        client_name_input = driver.findElement(By.xpath("//div[@data-original-title='عميل']//div//input"));
        enter_data_to_input_field(client_name_input, client_name);
        load_data = driver.findElement(By.id
                ("appframe-btn-تحميل البيانات"));
        js.executeScript("arguments[0].click();", load_data);
    }

    public String total_debit_in_account_statement_report() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//div[@class='slick-viewport']//div[@class='slick-cell b4 f4'])[1]")));
        voucher_description = driver.findElement(By.xpath
                ("(//div[@class='results']//div[@class='ui-state-default slick-headerrow-column b4 f4'])//input"));
        enter_data_to_input_field(voucher_description, "إغلاق (الإفتتاح + المجموع)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[contains(text(),'إغلاق (الإفتتاح + المجموع)')]")));
        debit = driver.findElement(By.xpath
                ("(//div[@class='slick-viewport']//div[@class='slick-cell b5 f5'])"));
        return debit.getText();
    }

    public int rows_number() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//div[@class='slick-viewport']//div[@class='slick-cell b5 f5'])")));
        table_element = driver.findElement(By.xpath
                ("//div[@class='slick-viewport']"));
        rows_list = table_element.findElements(By.xpath
                ("//div[contains(@class,'slick-cell b0 f0')]"));
        //  System.out.println(rows_list.size());
        return rows_list.size();
    }


    /************************************************************************************************************************************/
    public void scroll_down() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,500)");
    }

    public HomePage return_to_homepage() {
        homepage_icon = driver.findElement(By.xpath
                ("//div[@class='sidebar-brand sidebar-brand__desktop']"));
        click_on_element(homepage_icon);
        return new HomePage(driver);
    }

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
    }

    public void close_window() {
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']")));
        close_icon = driver.findElement(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']"));
        click_on_element(close_icon);
    }

    /************************************************************************************************************************************/
    public WebElement voucher_number_in_account_statement_report(int i) {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//div[@class='slick-viewport']//div[@class='slick-cell b5 f5'])[1]")));
        row_element = driver.findElement(By.xpath
                ("(//div[@class='slick-viewport']//div[contains(@class,'ui-widget-content slick-row')])"));
        voucher_list = row_element.findElements(By.xpath("//div[@class='slick-cell b3 f3']"));
        return voucher_list.get(i);
    }

    public String debit_in_account_statement_report(int i) {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//div[@class='slick-viewport']//div[@class='slick-cell b1 f1'])[1]")));
        row_element = driver.findElement(By.xpath
                ("(//div[@class='slick-viewport']//div[contains(@class,'ui-widget-content slick-row')])"));
        debit_list = row_element.findElements(By.xpath("//div[@class='slick-cell b5 f5']"));
        // System.out.println("debittttttttttttttttttttttttttttttttttttttttttttt");
        return debit_list.get(i).getText();
    }

    /**********************************************************************************************************************************/
    public String credit_in_account_statement_report(int i) {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//div[@class='slick-viewport']//div[@class='slick-cell b1 f1'])[1]")));
        row_element = driver.findElement(By.xpath
                ("(//div[@class='slick-viewport']//div[contains(@class,'ui-widget-content slick-row')])"));
        credit_list = row_element.findElements(By.xpath("//div[@class='slick-cell b6 f6']"));
//System.out.println("credittttttttttttttttttttttttttttttttttttttttttttt");
        return credit_list.get(i).getText();
    }

    /**********************************************************************************************************************************/
    public void search_with_invoice_id(String invoice_id) {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//div[@class='results']//div[@class='ui-state-default slick-headerrow-column b3 f3'])//input")));
        document_number = driver.findElement(By.xpath
                ("(//div[@class='results']//div[@class='ui-state-default slick-headerrow-column b3 f3'])//input"));
        enter_data_to_input_field(document_number, invoice_id);
    }
    public void waiting_for_element_to_be_visible(By locator) {
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}


