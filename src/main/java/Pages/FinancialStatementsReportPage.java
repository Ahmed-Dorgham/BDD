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

public class FinancialStatementsReportPage extends UtilitiesMethods {
    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private WebElement create_button;
    private WebElement load_data;
    private WebElement client_name_field;
    private WebElement client_name_input;
    private WebElement row_element;
    private WebElement incomes_title;
    private WebElement profit_loss_title;
    private WebElement incomes_amount_element;
    private WebElement profit_loss_amount_element;
    private WebElement profit_element;

    private WebElement company_element;
    private WebElement period_element;
    private WebElement year_element;
    private WebElement remove_element;
    private WebElement level_element;
    private WebElement voucher_description;
    private WebElement document_number;
    private WebElement debit;
    private WebElement clickable_element_in_table;
    private WebElement table_element;
    private WebElement homepage_icon;
    private WebElement settingIcon;
    private WebElement yes_button;
    private WebElement close_icon;
    private WebElement list_field;
    private WebElement select_field;


    private WebElement clear_cash_element;
    private List<WebElement> rows_list;
    private List<WebElement> voucher_list;

    private List<WebElement> debit_list;
    private List<WebElement> credit_list;

    public FinancialStatementsReportPage(WebDriver driver) {
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

    public void click_on_create_button() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        create_button = driver.findElement(By.id
                ("appframe-btn-إنشاء"));
        js.executeScript("arguments[0].click();", create_button);
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

    public void enter_all_data_using_filters() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class='clearfix form-group col-md-2 form-column'])[1]")));
        select_field = driver.findElement(By.xpath
                ("(//div[@class='clearfix form-group col-md-2 form-column'])[1]"));
        js.executeScript("arguments[0].click();", select_field);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//span[contains(text(),'الربح والخسارة')]")));
        profit_element = driver.findElement(By.xpath
                ("//span[contains(text(),'الربح والخسارة')]"));
        js.executeScript("arguments[0].click();", profit_element);
        select_field = driver.findElement(By.xpath
                ("(//div[@class='clearfix form-group col-md-2 form-column'])[2]"));
        //js.executeScript("arguments[0].click();", select_field);
        click_on_element(select_field);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//ul[@class='dropdown-menu inner scroll-styler'])[2]//li[2]")));
        company_element = driver.findElement(By.xpath
                ("(//ul[@class='dropdown-menu inner scroll-styler'])[2]//li[2]"));
        Thread.sleep(10000);
        click_on_element(company_element);

        select_field = driver.findElement(By.xpath
                ("(//div[@class='clearfix form-group col-md-2 form-column'])[3]"));
        js.executeScript("arguments[0].click();", select_field);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//span[contains(text(),'سنويا')]")));
        period_element = driver.findElement(By.xpath
                ("//span[contains(text(),'سنويا')]"));
        js.executeScript("arguments[0].click();", period_element);

        select_field = driver.findElement(By.xpath
                ("(//div[@class='clearfix form-group col-md-2 form-column'])[4]"));
        js.executeScript("arguments[0].click();", select_field);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//span[contains(text(),'2023')]")));
        remove_element = driver.findElement(By.xpath
                ("//span[contains(text(),'إزالة الأختيار عن الكل')]"));
        js.executeScript("arguments[0].click();", remove_element);
        year_element = driver.findElement(By.xpath
                ("//span[contains(text(),'2023')]"));
        js.executeScript("arguments[0].click();", year_element);

        select_field = driver.findElement(By.xpath
                ("(//div[@class='clearfix form-group col-md-2 form-column'])[5]"));
        js.executeScript("arguments[0].click();", select_field);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//span[contains(text(),'المستوى الأول')]")));
        level_element = driver.findElement(By.xpath
                ("//span[contains(text(),'المستوى الأول')]"));
        js.executeScript("arguments[0].click();", level_element);



     /*   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//div[@class='slick-viewport']//div[@class='slick-cell b4 f4'])[1]")));
        voucher_description = driver.findElement(By.xpath
                ("(//div[@class='results']//div[@class='ui-state-default slick-headerrow-column b4 f4'])//input"));
        enter_data_to_input_field(voucher_description, "إغلاق (الإفتتاح + المجموع)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[contains(text(),'إغلاق (الإفتتاح + المجموع)')]")));
        debit = driver.findElement(By.xpath
                ("(//div[@class='slick-viewport']//div[@class='slick-cell b5 f5'])"));
        return debit.getText();*/
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

    public void clear_cash() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(30));
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
        wait.until(ExpectedConditions.titleContains(("Dafater")));

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
    public String incomes_in_financial_statements_report() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//b[contains(text(),'الايرادات')]")));
        incomes_title = driver.findElement(By.xpath
                ("//b[contains(text(),'الايرادات')]"));
        incomes_amount_element = driver.findElement(RelativeLocator.with(By.tagName("td")).toLeftOf(incomes_title));
        //System.out.println(incomes_amount_element.getText());
        return incomes_amount_element.getText();
    }
    public String profit_loss_in_financial_statements_report() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(50));
        profit_loss_title = driver.findElement(By.xpath
                ("//b[contains(text(),'الربح / الخسارة')]"));
        profit_loss_amount_element = driver.findElement(RelativeLocator.with(By.tagName("td")).toLeftOf(profit_loss_title));
        //System.out.println(profit_loss_amount_element.getText());
        return profit_loss_amount_element.getText();
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


