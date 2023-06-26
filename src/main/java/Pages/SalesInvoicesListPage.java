package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static java.time.Duration.ofSeconds;

public class SalesInvoicesListPage extends UtilitiesMethods {
    private WebDriver driver;

    public SalesInvoicesListPage(WebDriver driver) {
        this.driver = driver;
    }
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private Wait<WebDriver> fluent_Wait;
    private WebElement sales_invoices_list_header;
    private WebElement error_validation_message;
    private WebElement message;
    private WebElement submitted_icon;
    private WebElement new_button;
    private WebElement alert_notification;
    private WebElement id_checkbox;
    private List<WebElement> id_checkboxes;
    private WebElement submit_button;
    private WebElement delete_button;
    private WebElement cancel_button;
    private WebElement accept_submit;
    private WebElement clear_cash_element;
    private WebElement settingIcon;
    private WebElement cancel_filter_button;
    private WebElement yes_button;
    private WebElement close_icon;
    private WebElement update_icon;
    private WebElement sales_invoice_list_element;
    private WebElement navigation_500;
    private WebElement first_shown_invoice;
    private WebElement sales_invoice_id;
    private WebElement submitted_icon_element;
    private WebElement enqueue_icon_element;
    private WebElement saved_icon_element;
    private WebElement result_list;
    private List<WebElement> shown_sales;
    private List<WebElement> saved_sales;
    private List<WebElement> submitted_sales;
    private WebElement saved_icon_in_row;
    private WebElement icon_element_in_row;
    private WebElement submitted_icon_in_row;
    private WebElement invoice_id_in_row;

    private List<WebElement> rows_in_result_list;



    /***********************************************************************************************************************/
    public SalesInvoicePage open_new_sales_invoice() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@id='appframe-btn-جديد']")));
        new_button = driver.findElement(By.id("appframe-btn-جديد"));
        js.executeScript("arguments[0].click();", new_button);
        return new SalesInvoicePage(driver);
    }

    /*******************************************************************************************************************************/

    public void click_on_id_checkbox() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        js.executeScript("window.scrollBy(0,400)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
        id_checkbox = driver.findElement(By.xpath
                ("//div[@class='list-headers']//input[@type='checkbox']"));
        js.executeScript("arguments[0].click();", id_checkbox);
    }

    /**************************************************************************************************************************************/
    public void click_on_entire_checkbox_of_sales_invoices(int number) {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        js.executeScript("window.scrollBy(0,20)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
        id_checkboxes = driver.findElements(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])"));

        js.executeScript("arguments[0].click();", id_checkboxes.get(number));
    }

    /**************************************************************************************************************************************/
    public WebElement get_entire_checkboxes_in_sales_invoices_list(int number) {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        id_checkboxes = driver.findElements(By.xpath("(//div[@class='result-list']//input[@type='checkbox'])"));
        return id_checkboxes.get(number);
    }

    /**************************************************************************************************************************************/
    public WebElement get_id_checkbox_element() {
        id_checkbox = driver.findElement(By.xpath
                ("//div[@class='list-headers']//input[@type='checkbox']"));
        return id_checkbox;
    }

    /*****************************************************************************************************************************************/
    public void click_on_submit_button() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        js.executeScript("window.scrollTo(0,-document.body.scrollHight)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@id='appframe-btn-اعتماد']")));
        submit_button = driver.findElement(By.xpath("//button[@id='appframe-btn-اعتماد']"));
        js.executeScript("arguments[0].click();", submit_button);
    }

    /*****************************************************************************************************************************************/
    public void click_on_delete_button() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        js.executeScript("window.scrollTo(0,-document.body.scrollHight)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@id='appframe-btn-حذف']")));
        delete_button = driver.findElement(By.xpath
                ("//button[@id='appframe-btn-حذف']"));
        js.executeScript("arguments[0].click();", delete_button);
    }

    /*****************************************************************************************************************************************/
    public void click_on_cancel_button() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        js.executeScript("window.scrollTo(0,-document.body.scrollHight)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@id='appframe-btn-إلغاء']")));
        cancel_button = driver.findElement(By.xpath
                ("//button[@id='appframe-btn-إلغاء']"));
        js.executeScript("arguments[0].click();", cancel_button);
    }

    /*****************************************************************************************************************************************/
    public void click_on_accept_button() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//button[@class = 'btn btn-info btn-yes']")));
        accept_submit = driver.findElement(By.xpath
                ("//button[@class = 'btn btn-info btn-yes']"));
        click_on_element(accept_submit);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
    }

    /*******************************************************************************************************************************/

    public WebElement get_sales_invoices_list_header() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h5[contains(text(),'قائمة فاتورة مبيعات')]")));
        sales_invoices_list_header = driver.findElement(By.xpath
                ("//h5[contains(text(),'قائمة فاتورة مبيعات')]"));
        return sales_invoices_list_header;
    }

    /******************************************************************************************************************************************/

    public WebElement get_error_validation_message() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='modal-content']//div[@class='msgprint']")));
        error_validation_message = driver.findElement(By.xpath
                ("//div[@class='modal-content']//div[@class='msgprint']"));
        return error_validation_message;
    }

    /******************************************************************************************************************************************/
    public WebElement get_submitting_in_process_message() {
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='msgprint']//h4[contains(text(),'جاري الآن الاعتماد')]")));
        message = driver.findElement(By.xpath
                ("//div[@class='msgprint']//h4[contains(text(),'جاري الآن الاعتماد')]"));
        return message;
    }

    /******************************************************************************************************************************************/
    public WebElement get_submitted_icon_element(int index) {
        fluent_Wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .ignoring(StaleElementReferenceException.class);
        result_list = driver.findElement(By.xpath
                ("//div[@id='page-List/Sales Invoice']//div[@class='result']//div[@class='result-list']"));
        rows_in_result_list = result_list.findElements(By.className("list-row"));
        submitted_icon_in_row = rows_in_result_list.get(index).findElement(By.xpath
                ("//span//i[contains(@class,'icon-lock-lock-close-1')]"));
        return submitted_icon_in_row;
    }

    /******************************************************************************************************************************************/
    public String get_first_shown_invoice_name_before_any_process() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
        sales_invoice_list_element = driver.findElement(By.xpath("//div[@class='result-list']"));
        shown_sales = sales_invoice_list_element.findElements(By.xpath
                ("//div[@class='result-list']//div[@class='list-row']//a"));
        first_shown_invoice = shown_sales.get(0);
        //System.out.println("the last created invoice is " + first_shown_invoice.getText());
        return first_shown_invoice.getText();
    }

    /******************************************************************************************************************************************/
    public WebElement get_first_shown_invoice_row() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
        sales_invoice_list_element = driver.findElement(By.xpath
                ("//div[@class='result-list']"));
        shown_sales = sales_invoice_list_element.findElements(By.xpath
                ("//div[@class='result-list']//div[@class='list-row']//a"));
        first_shown_invoice = shown_sales.get(0);
        return first_shown_invoice;
    }

    /************************************************************************************************************************************/

    public String get_first_shown_invoice_name_after_any_process() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
        sales_invoice_list_element = driver.findElement(By.xpath
                ("//div[@class='result-list']"));
        shown_sales = sales_invoice_list_element.findElements(By.xpath
                ("//div[@class='result-list']//div[@class='list-row']//a"));
        first_shown_invoice = shown_sales.get(0);
        System.out.println("the first shown sales invoice after  process  is " + first_shown_invoice.getText());
        return first_shown_invoice.getText();
    }

    /******************************************************************************************************************************************/
    public void click_on_500_navigation_bar() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@data-value='500']")));
        navigation_500 = driver.findElement(By.xpath
                ("//button[@data-value='500']"));
        js.executeScript("arguments[0].click();", navigation_500);
        // click_on_element(navigation_500);
    }

    /******************************************************************************************************************************************/
    public int get_number_of_shown_sales_invoices_before_any_process() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
        sales_invoice_list_element = driver.findElement(By.xpath("//div[@class='result-list']"));
        shown_sales = sales_invoice_list_element.findElements(By.xpath
                ("//div[@class='result-list']//div[@class='list-row']"));
        System.out.println("the number of all shown sales invoices before  process  is " + shown_sales.size());
        return shown_sales.size();
    }

    /*******************************************************************************************************************************/
    public int get_number_of_shown_sales_invoices_after_any_process() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
        sales_invoice_list_element = driver.findElement(By.xpath("//div[@class='result-list']"));
        shown_sales = sales_invoice_list_element.findElements(By.xpath
                ("//div[@class='result-list']//div[@class='list-row']//a"));
        first_shown_invoice = shown_sales.get(0);
        System.out.println("the first shown sales invoice after any process  is " + first_shown_invoice.getText());
        System.out.println("the number of all shown sales invoices after  process  is " + shown_sales.size());
        return shown_sales.size();
    }

    /*******************************************************************************************************************************/
    public int get_number_of_saved_sales_invoices_before_any_process() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
        sales_invoice_list_element = driver.findElement(By.xpath("//div[@class='result-list']"));
        saved_sales = sales_invoice_list_element.findElements(By.xpath
                ("//div[@class='result-list']//i[@class='icon-computers-floppy-disk']"));
        System.out.println("the number of saved sales invoices only before  process  is " + saved_sales.size());
        return saved_sales.size();
    }

    /*******************************************************************************************************************************/
    public int get_number_of_saved_sales_invoices_after_any_process() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
        sales_invoice_list_element = driver.findElement(By.xpath("//div[@class='result-list']"));
        saved_sales = sales_invoice_list_element.findElements(By.xpath
                ("//div[@class='result-list']//i[@class='icon-computers-floppy-disk']"));
        System.out.println("the number of saved sales invoices only after  process is " + saved_sales.size());
        return saved_sales.size();
    }

    /*******************************************************************************************************************************/
    public int get_number_of_submitted_sales_invoices_before_any_process() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
        sales_invoice_list_element = driver.findElement(By.xpath("//div[@class='result-list']"));
        submitted_sales = sales_invoice_list_element.findElements(By.xpath
                ("//div[@class='result-list']//i[@class='icon-lock-lock-close-1']"));
        System.out.println("the number of submitted sales invoices only  before process is " + submitted_sales.size());
        return submitted_sales.size();
    }

    /*******************************************************************************************************************************/
    public int get_number_of_submitted_sales_invoices_after_any_process() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
        sales_invoice_list_element = driver.findElement(By.xpath("//div[@class='result-list']"));
        submitted_sales = sales_invoice_list_element.findElements(By.xpath
                ("//div[@class='result-list']//i[@class='icon-lock-lock-close-1']"));
        System.out.println("the number of submitted sales invoices only after process is " + submitted_sales.size());
        return submitted_sales.size();
    }

    /*******************************************************************************************************************************/
    public void close_window() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']")));
        close_icon = driver.findElement(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']"));
        click_on_element(close_icon);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));

    }

    /************************************************************************************************************************************/
    public void close_and_scroll() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']")));
        close_icon = driver.findElement(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']"));
        click_on_element(close_icon);
        js.executeScript("window.scrollTo(0,500)");

    }

    /************************************************************************************************************************************/
    public void click_on_update_icon() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@id='appframe-btn-']")));
        update_icon = driver.findElement(By.xpath
                ("//button[@id='appframe-btn-']"));
        js.executeScript("arguments[0].click();", update_icon);
    }

    /************************************************************************************************************************************/
    public void clear_cash() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        settingIcon = driver.findElement(By.xpath
                ("//i[@data-kooltip='إعداد']"));
        click_on_element(settingIcon);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//li[@id='clear-cach-icon']")));
        clear_cash_element = driver.findElement(By.xpath
                ("//li[@id='clear-cach-icon']"));
        click_on_element(clear_cash_element);
        yes_button = driver.findElement(By.xpath
                ("//button[@class='btn btn-info btn-yes']"));
        click_on_element(yes_button);
        wait.until(ExpectedConditions.titleContains("Dafater"));
    }

    /**************************************************************************************************************************************/
    public void show_cancelled_invoices() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        js.executeScript("window.scrollBy(0,450)");
        cancel_filter_button = driver.findElement(By.xpath
                ("//button[@title='الغاء التصفية']//i"));

        js.executeScript("arguments[0].click();", cancel_filter_button);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//i[@title='تم إلغاؤه']")));
    }

    /********************************************************************************************************************************/

    public void x() {
        sales_invoice_id = driver.findElement(By.xpath
                ("//div[@class='result-list']//div[@class='doclist-row row']//a"));
        submitted_icon_element = driver.findElement(By.xpath
                ("//div[@class='result-list']//i[@class='icon-lock-lock-close-1 docstatus_icon']"));
        enqueue_icon_element = driver.findElement(By.xpath
                ("//div[@class='result-list']//i[@class='fas fa-layer-group docstatus_icon']"));
    }

    /************************************************************************************************************************************/
    public WebElement get_saved_icon_element() {
        saved_icon_element = driver.findElement(By.xpath
                ("//div[@class='result-list']//i[@class='icon-computers-floppy-disk docstatus_icon']"));
        return saved_icon_element;
    }

    /************************************************************************************************************************************/
    public WebElement get_saved_icon_in_row(int index) {
        fluent_Wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(90))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .ignoring(StaleElementReferenceException.class);
        result_list = driver.findElement(By.xpath
                ("//div[@id='page-List/Sales Invoice']//div[@class='result']//div[@class='result-list']"));
        rows_in_result_list = result_list.findElements(By.className("list-row"));
        saved_icon_in_row = rows_in_result_list.get(index).findElement(By.xpath
                ("//span//i[contains(@class,'icon-computers-floppy-disk')]"));

        return saved_icon_in_row;
    }

    /************************************************************************************************************************************/
    public WebElement get_enqueue_icon_in_row(int index) {
        wait = new WebDriverWait(driver, ofSeconds(30));
        fluent_Wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .ignoring(StaleElementReferenceException.class);
        result_list = driver.findElement(By.xpath
                ("//div[@id='page-List/Sales Invoice']//div[@class='result']//div[@class='result-list']"));
        rows_in_result_list = result_list.findElements(By.className("list-row"));
        icon_element_in_row = rows_in_result_list.get(index).findElement(By.xpath(
                ("//span//i[contains(@class,'fas fa-layer-group')]")));
//div[@id='page-List/Sales Invoice']//div[@class='result']//div[@class='result-list']//div[@class='result-list']//span//i[contains(@class,'fas fa-layer-group')]"
        return icon_element_in_row;
    }

    /************************************************************************************************************************************/
    public WebElement get_icon_element_in_row(int index) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        fluent_Wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .ignoring(StaleElementReferenceException.class);
        result_list = driver.findElement(By.xpath
                ("//div[@id='page-List/Sales Invoice']//div[@class='result']//div[@class='result-list']"));
        rows_in_result_list = result_list.findElements(By.className("list-row"));
        icon_element_in_row = rows_in_result_list.get(index).findElement(By.xpath(
                ("//div[@class='doclist-row row']//div//span//i")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
        return icon_element_in_row;
    }

    /*********************************************-*********************************************************************************************/
    public WebElement waiting_for_element_to_be_invisible(int index, By locator, String attribute_name, String attribute_value) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        try {
            result_list = driver.findElement(By.xpath
                    ("//div[@id='page-List/Sales Invoice']//div[@class='result']//div[@class='result-list']"));
            rows_in_result_list = result_list.findElements(By.className("list-row"));
            icon_element_in_row = rows_in_result_list.get(index).findElement(By.xpath(
                    ("//div[@class='doclist-row row']//div//span//i")));
            wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(locator, attribute_name, attribute_value)));
            return icon_element_in_row;
        } catch (Exception exception) {
       //     System.out.println("this invoice still in enqueue after 5 minutes and may be there is unexpected behaviour happen  ");

            return icon_element_in_row;
        }

    }

    /************************************************************************************************************************************/
    public WebElement get_submitted_icon_in_row(int index) {
        fluent_Wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .ignoring(StaleElementReferenceException.class);
        result_list = driver.findElement(By.xpath
                ("//div[@id='page-List/Sales Invoice']//div[@class='result']//div[@class='result-list']"));
        rows_in_result_list = result_list.findElements(By.className("list-row"));
        submitted_icon_in_row = rows_in_result_list.get(index).findElement(By.xpath
                ("//span//i[contains(@class,'icon-lock-lock-close-1')]"));
        return submitted_icon_in_row;
    }

    /*****************************************************-******************************************************************************************/
    public WebElement get_invoice_id_in_row_after_action(int index) {

     try {
         result_list = driver.findElement(By.xpath
                 ("//div[@id='page-List/Sales Invoice']//div[@class='result']//div[@class='result-list']"));

        rows_in_result_list = result_list.findElements(By.className("list-row"));
        invoice_id_in_row = rows_in_result_list.get(index).findElement(By.partialLinkText("INV"));

        return invoice_id_in_row;
     }
     catch (Exception exception)
     {
         return invoice_id_in_row;
     }
    }
    /*****************************************************-******************************************************************************************/

    public WebElement get_invoice_id_in_row_before_action(int index) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        result_list = driver.findElement(By.xpath
                ("//div[@id='page-List/Sales Invoice']//div[@class='result']//div[@class='result-list']"));
        rows_in_result_list = result_list.findElements(By.className("list-row"));
        invoice_id_in_row = rows_in_result_list.get(index).findElement(By.partialLinkText("INV"));
        return invoice_id_in_row;
    }

    /***************************************************************************************************************************************/
    public WebElement get_alert_notification() {
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='alert-container']//a")));
        alert_notification = driver.findElement(By.xpath
                ("//div[@id='alert-container']//a"));
        return alert_notification;
    }

    /************************************************************************************************************************************/
    public void waiting_for_text_not_to_be_visible_in_element(By locator, String text) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
    }

    /************************************************************************************************************************************/

    public void waiting_for_text_to_be_visible_in_element(By locator, String text) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /************************************************************************************************************************************/

    public void waiting_for_element_to_be_invisible(By locator, String attribute_name, String attribute_value) {
        wait = new WebDriverWait(driver, ofSeconds(50));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(locator, attribute_name, attribute_value)));
    }

    /************************************************************************************************************************************/
    public void waiting_for_element_to_be_visible(By locator, String attribute_name, String attribute_value) throws TimeoutException {
        wait = new WebDriverWait(driver, ofSeconds(120));
        try {
            wait.until((ExpectedConditions.attributeToBe(locator, attribute_name, attribute_value)));

        } catch (Exception exception) {
            System.out.println("enqueue icon for the below invoice had been disappeared now ");
        }
    }

    /************************************************************************************************************************************/
    public WebElement waiting_for_element_to_be_visible(int index, By locator, String attribute_name, String attribute_value) {
        wait = new WebDriverWait(driver, ofSeconds(30));
        try {
            result_list = driver.findElement(By.xpath
                    ("//div[@id='page-List/Sales Invoice']//div[@class='result']//div[@class='result-list']"));
            rows_in_result_list = result_list.findElements(By.className("list-row"));
            icon_element_in_row = rows_in_result_list.get(index).findElement(By.xpath(
                    ("//div[@class='doclist-row row']//div//span//i")));
            wait.until(ExpectedConditions.attributeToBe(locator, attribute_name, attribute_value));
            return icon_element_in_row;
        } catch (Exception exception) {
           // System.out.println("enqueue icon for the below invoice had been disappeared now ");
            return icon_element_in_row;
        }


    }

    /************************************************************************************************************************************/
    public void waiting_for_element_to_be_clickable(By locator) {
        wait = new WebDriverWait(driver, ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /************************************************************************************************************************************/

    public void waiting_for_title_to_contain(String text) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.titleContains(text));
    }

    /**************************************************************************************************************************************/
    public void scroll_to_top() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        js.executeScript("window.scrollTo(0,0)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h5[contains(text(),'قائمة فاتورة مبيعات')]")));
    }

    /********************************************************************************************************************************/
    public void scroll_down() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,500)");
    }

    /***********************************************************************************************************************************/
    public void wait_elememt_to_be_selected(WebElement e) {
        wait = new WebDriverWait(driver, ofSeconds(180));
        wait.until(ExpectedConditions.elementToBeSelected(e));
    }

    /***********************************************************************************************************************************/
    public void waiting(long seconds) throws InterruptedException {
        Thread.sleep(seconds);
    }

    /************************************************************************************************************************************/

    public void implicit_wait(long seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    /************************************************************************************************************************************/
    public void wait_alert_to_be_invisible() {
        js = (JavascriptExecutor) driver;
        fluent_Wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .ignoring(StaleElementReferenceException.class);
        fluent_Wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.
                xpath("//div[@id='alert-container']//a"))));
        System.out.println("alert notification disappear now ");
    }

    /************************************************************************************************************************************/
    public void waiting_for_element_to_be_visible(WebElement element) {
        wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /************************************************************************************************************************************/
    public void fluent_waiting_for_element_to_be_visible(WebElement element) {
        fluent_Wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .ignoring(StaleElementReferenceException.class);
        fluent_Wait.until(ExpectedConditions.visibilityOf(element));
    }

    /************************************************************************************************************************************/
    public void waiting_for_value_to_be_in_attribute(WebElement element, String style, String value) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.attributeToBe(element, style, value));
    }

    public WebElement get_web_element(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    }
}
