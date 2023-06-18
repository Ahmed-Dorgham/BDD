package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import static java.time.Duration.ofSeconds;

public class DataImportPage extends UtilitiesMethods {
    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private Wait<WebDriver> fluent_Wait;
    private WebElement page_header;
    private WebElement uploading_message_element;
    private WebElement importing_failed_message_element;
    private WebElement receiving_message_element;
    private WebElement upload_button;
    private WebElement close_icon;
    private WebElement alert_notification;
    private WebElement first_row_element;
    private WebElement warning_message_element;
    private WebElement creating_date;
    private WebElement upload_field;
    private WebElement import_button;
    private WebElement wait_until_finish_button;
    private WebElement select_button;
    private WebElement search_input;
    private WebElement selected_doctype;
    private WebElement download_with_data_checkbox;
    private WebElement csv_checkbox;
    private WebElement main_table;
    private WebElement adding_to_waiting_list_button;

    public DataImportPage(WebDriver driver) {
        this.driver = driver;
    }

    /*************************************************************************************************************************************/
    public WebElement get_data_import_tool_header() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h5[contains(text(),'أداة استيراد البيانات')]")));
        page_header = driver.findElement(By.xpath
                ("//h5[contains(text(),'أداة استيراد البيانات')]"));
        return page_header;
    }

    /*************************************************************************************************************************************/

    public void click_on_upload_button() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='fileUpload btn btn-inverse']")));
        upload_button = driver.findElement(By.xpath
                ("//div[@class='fileUpload btn btn-inverse']"));
        click_on_element(upload_button);
    }

    /************************************************************************************************************************************/
    public void upload_file(String file_path) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='fileUpload btn btn-inverse']")));
        upload_field = driver.findElement(By.xpath
                ("//div[@class='fileUpload btn btn-inverse']//input[@id='uploadBtn']"));
        upload_field.sendKeys(file_path);
        //enter_data_to_input_field(upload_field, file_path);
    }

    /************************************************************************************************************************************/
    public void click_on_import_button() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//input[@class='btn btn-info btn-upload']")));
        import_button = driver.findElement(By.xpath
                ("//input[@class='btn btn-info btn-upload']"));
        click_on_element(import_button);
    }

    /********************************************************************************************************************************************/
    public void click_on_adding_to_waiting_list_button() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='msgprint']//p//button[2]")));
        adding_to_waiting_list_button = driver.findElement(By.xpath
                ("//div[@class='msgprint']//p//button[2]"));
        click_on_element(adding_to_waiting_list_button);
    }

    /************************************************************************************************************************************/
    public void click_on_wait_until_finish_button() {
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='msgprint']//p//button[1]")));
        wait_until_finish_button = driver.findElement(By.xpath
                ("//div[@class='msgprint']//p//button[1]"));
        click_on_element(wait_until_finish_button);
    }


    /***********************************************************************************************************************************/
    public void select_doctype(String doctype) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//p//button[@title='إختر']")));
        select_button = driver.findElement(By.xpath
                ("//p//button[@title='إختر']"));
        click_on_element(select_button);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//p//input[@aria-label='Search']")));
        search_input = driver.findElement(By.xpath
                ("//p//input[@aria-label='Search']"));
        enter_data_to_input_field(search_input, doctype);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("(//p//li[@class='active']//span)[1]")));
        selected_doctype = driver.findElement(By.xpath
                ("(//p//li[@class='active']//span)[1]"));

        click_on_element(selected_doctype);


    }

    /***********************************************************************************************************************************/
    public void download_main_table_with_data() {
      /*  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div//p[contains(text(),'تحميل قالب لاستيراد الجدول.')]")));*/
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div//span[contains(text(),'الجدول الرئيس:')]")));
        download_with_data_checkbox = driver.findElement(By.xpath
                ("//div//input[@name='dit-with-data']"));
        click_on_element(download_with_data_checkbox);
        csv_checkbox = driver.findElement(By.xpath
                ("//div//input[@name='csv']"));
        click_on_element(csv_checkbox);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//p[@id='dit-download']//a")));
        main_table = driver.findElement(By.xpath
                ("//p[@id='dit-download']//a"));
        click_on_element(main_table);
    }

    /************************************************************************************************************************************/
    public void close_window() {
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']")));
        close_icon = driver.findElement(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']"));
        click_on_element(close_icon);

    }

    /************************************************************************************************************************************/
    public WebElement get_receiving_message_element() {
        wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='modal-content']//div[contains(text(),'سنقوم بإخطارك وإرسال بريد إلكتروني لك عند اكتمال عملية')]")));
        receiving_message_element = driver.findElement(By.xpath
                ("//div[@class='modal-content']//div[contains(text(),'سنقوم بإخطارك وإرسال بريد إلكتروني لك عند اكتمال عملية')]"));
        return receiving_message_element;
    }

    /*************************************************************************************************************************************/
    public WebElement get_uploading_message_element() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='modal-content']//div[@class='msgprint']")));
        uploading_message_element = driver.findElement(By.xpath
                ("//div[@class='modal-content']//div[@class='msgprint']"));
        return uploading_message_element;
    }

    /*************************************************************************************************************************************/
    public WebElement get_importing_message_element() {
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//p[@id='dit-output']//h4")));
        importing_failed_message_element = driver.findElement(By.xpath
                ("//p[@id='dit-output']//h4"));
        return importing_failed_message_element;

    }

    /*************************************************************************************************************************************/
//<a href="#data-import-tool">تم ( <strong>استيراد</strong> (نوع الوثيقة) (صنف) ) بنجاح</a>
    public WebElement get_alert_notification() {
        wait = new WebDriverWait(driver, ofSeconds(3600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='alert-container']//a")));
        alert_notification = driver.findElement(By.xpath
                ("//div[@id='alert-container']//a"));
        return alert_notification;
    }

    /************************************************************************************************************************************/
    public WebElement get_message_element_in_table() {
        wait = new WebDriverWait(driver, ofSeconds(300));

        warning_message_element = driver.findElement(By.xpath
                ("//table//tbody//tr[1]//td[5]"));

        return warning_message_element;
    }

    /************************************************************************************************************************************/
    public WebElement get_date_in_table() {
        try {
            wait = new WebDriverWait(driver, ofSeconds(300));
            creating_date = driver.findElement(By.xpath
                    ("//table//tbody//tr[1]//td[4]"));
            return creating_date;
        } catch (Exception exception) {
            return creating_date;
        }
    }

    /*************************************************************************************************************************************/
    public WebElement get_first_row_in_table_table() {
        wait = new WebDriverWait(driver, ofSeconds(300));

        first_row_element = driver.findElement(By.xpath
                ("//table//tbody//tr[1]"));

       /* recent_request_table = driver.findElement(By.className(
                (".table.table-striped.import-export-feeds-table")));*/
        return first_row_element;
    }

    /************************************************************************************************************************************/

    public void waiting_for_element_to_be_visible(WebElement element) {
        wait = new WebDriverWait(driver, ofSeconds(900));
        wait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
    }

    /************************************************************************************************************************************/
    public void waiting_for_text_not_to_be_in_element(WebElement element, String date) {
        wait = new WebDriverWait(driver, ofSeconds(1500));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, date)));
    }


    /************************************************************************************************************************************/

    public void waiting_for_element_to_be_invisible(WebElement element) {
        fluent_Wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .ignoring(StaleElementReferenceException.class);
        fluent_Wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
        System.out.println("alert notification disappear now ");
    }

    /************************************************************************************************************************************/
    public void scroll_down() {

        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,900)");
    }

    /************************************************************************************************************************************/

    public void wait_alert_to_be_invisible_then_scroll() {
        js = (JavascriptExecutor) driver;
        fluent_Wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .ignoring(StaleElementReferenceException.class);
        fluent_Wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.
                xpath("//div[@id='alert-container']//a"))));
        // System.out.println("alert notification disappear now ");
        js.executeScript("window.scrollTo(0,800)");
    }
}