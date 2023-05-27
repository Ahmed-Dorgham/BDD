package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class SalesInvoicePage extends UtilitiesMethods {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement updateStockCheckbox;
    private WebElement POS_invoice_checkbox;
    private WebElement add_new_row_button;
    private WebElement close_icon;
    private WebElement itemField;
    private WebElement quantityField;

    private WebElement save_and_Submit_button;
    private WebElement save_button;

    private WebElement submit_button;
    private WebElement make_copy_button;

    private WebElement invoiceIDName;
    private WebElement acceptSubmit;
    private WebElement basic_price;
    private WebElement terriority;
    private WebElement validatioMessage;

    private WebElement seriesNumberField;
    private WebElement date_field;
    private WebElement client_name_field;
    private WebElement showAccountButton;
    private WebElement sales_list_icon;
    private WebElement submitted_icon;
    private WebElement received_tag;
    private WebElement received_message;
    ;
    private WebElement stock_validation_message;
    private WebElement error_validation_message;
    private WebElement fromDeliveryNote;
    private WebElement fromSalesOrder;
    private WebElement get_button;
    private WebElement selected_delivery_note;
    private WebElement selectedSalesOrder;
    private List<WebElement> deliveryNoteList;
    private WebElement deliveryNoteListElement;
    private WebElement amountField;
    private List<WebElement> salesOrderList;
    private WebElement salesOrderListElement;
    private WebElement advancesTab;
    private WebElement fiscalYear;
    private WebElement fiscalYearListElement;
    private List<WebElement> fiscalYearList;
    private WebElement differentFiscalYear;
    private WebElement postingDate;
    private WebElement discountsAndWriteOffsButton;
    private WebElement writeOffOutstandingAmountCheckBox;
    private WebElement deliveryNoteValidationMessage;
    private WebElement backendValidationMessage;

    private WebElement INVJ;
    private JavascriptExecutor js;
    private Wait<WebDriver> fluent_Wait;

    public SalesInvoicePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFloatNumberInQuantityField() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        quantityField = driver.findElement(By.xpath("//input[@data-fieldname='qty']"));
        js.executeScript("arguments[0].value = '';", quantityField);
        enter_data_to_input_field(quantityField, "1.5");

    }

    /***************************************************************************************************************************************/
    public void create_sales_invoice_with_all_mandatory_ui_fields(String itemName) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(40));
        Thread.sleep(4000);
        seriesNumberField = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[1]"));
        js.executeScript("arguments[0].click();", seriesNumberField);
        INVJ = driver.findElement(By.xpath
                ("(//span[contains(text(),'INVJ')])[1]"));
        click_on_element(INVJ);
        client_name_field = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='customer']"));
        enter_data_to_input_field(client_name_field, "عميل نقدي");
        terriority = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='إقليم']//div//div"));
        click_on_element(terriority);
        Thread.sleep(16000);
        js.executeScript("window.scrollBy(0,900)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='entries']//a[contains(text(),'+ إضافة صف جديد')]")));
        add_new_row_button = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='entries']//a[contains(text(),'+ إضافة صف جديد')]"));
        js.executeScript("arguments[0].click();", add_new_row_button);
        //click_on_element(add_new_row_button);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='رمز الصنف']//input")));
        itemField = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='رمز الصنف']//input"));
        enter_data_to_input_field(itemField, itemName);
        basic_price = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='export_rate']"));
        //  js.executeScript("arguments[0].click();", basic_price);
        click_on_element(basic_price);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='export_amount']//div//div"), "ر.س 100.0000"));
    }

    /****************************************************************************************************************************-*/

    public void select_series_number() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,250)");
        seriesNumberField = driver.findElement(By.xpath
                ("(//div[@id='page-Form/Sales Invoice']//span[contains(text(),'إختر')])[1]"));
        js.executeScript("arguments[0].click();", seriesNumberField);
        INVJ = driver.findElement(By.xpath
                ("(//div[@id='page-Form/Sales Invoice']//span[contains(text(),'INV')])[1]"));
        //   click_on_element(INV);
        js.executeScript("arguments[0].click();", INVJ);
    }

    /*************************************************************************************************************************************/
    public void enter_date() throws InterruptedException {
        date_field = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='posting_date']"));
        js.executeScript("arguments[0].value='';", date_field);
        enter_data_to_input_field(date_field, "1-3-2023");
    }

    /*************************************************************************************************************************************/
    public void createSalesInvoiceWithOutAllMandatory_UI_Fields(String itemName) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//h5[@class='title-text pull-left'])[2]")));

    }

    /*************************************************************************************************************************************/
    public void createSalesInvoiceWithoutSeriesNaming(String itemName) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//h5[@class='title-text pull-left']")));
        client_name_field = driver.findElement(By.xpath
                ("//input[@data-fieldname='customer']"));
        enter_data_to_input_field(client_name_field, "عميل نقدي");
        terriority = driver.findElement(By.xpath
                ("//div[@title='إقليم']/div[1]/div/input"));
        click_on_element(terriority);
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,800)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//a[contains(text(),'+ إضافة صف جديد')])[1]")));
        add_new_row_button = driver.findElement(By.xpath
                ("(//a[contains(text(),'+ إضافة صف جديد')])[1]"));
        click_on_element(add_new_row_button);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@title='رمز الصنف']/div[1]/div/input")));
        itemField = driver.findElement(By.xpath
                ("//div[@title='رمز الصنف']/div[1]/div/input"));
        enter_data_to_input_field(itemField, itemName);
        basic_price = driver.findElement(By.xpath
                ("//div[@title='export_rate']/div[1]/input"));
        click_on_element(basic_price);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@title='export_amount']/div[2]/div"), "ر.س 100.00"));
    }

    /*****************************************************************************************************************************/

    public void createSalesInvoiceWithoutAddItems() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//h5[@class='title-text pull-left'])[2]")));
        seriesNumberField = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[1]"));
        js.executeScript("arguments[0].click();", seriesNumberField);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//span[contains(text(),'INV')])[1]")));
        INVJ = driver.findElement(By.xpath
                ("(//span[contains(text(),'INV')])[1]"));
        click_on_element(INVJ);
        client_name_field = driver.findElement(By.xpath
                ("//input[@data-fieldname='customer']"));
        enter_data_to_input_field(client_name_field, "عميل نقدي");
        terriority = driver.findElement(By.xpath
                ("//div[@title='إقليم']/div[1]/div/input"));
        click_on_element(terriority);
        Thread.sleep(5000);

    }

    /*****************************************************************************************************************************************/
    public WebElement getUpdateStockCheckBoxElement() {
        updateStockCheckbox = driver.findElement(By.xpath("//input[@data-fieldname='update_stock']"));
        return updateStockCheckbox;
    }

    /***********************************************************************************************************************/
    public void createSalesInvoiceWithoutTerriority(String itemName) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//h5[@class='title-text pull-left'])[2]")));
        seriesNumberField = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[1]"));
        js.executeScript("arguments[0].click();", seriesNumberField);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//span[contains(text(),'INV')])[1]")));
        INVJ = driver.findElement(By.xpath
                ("(//span[contains(text(),'INV')])[1]"));
        click_on_element(INVJ);
        client_name_field = driver.findElement(By.xpath
                ("//input[@data-fieldname='customer']"));
        enter_data_to_input_field(client_name_field, "عميل نقدي");
        terriority = driver.findElement(By.xpath
                ("//div[@title='إقليم']/div[1]/div/input"));
        click_on_element(terriority);
        Thread.sleep(5000);
        js.executeScript("arguments[0].value='';", terriority);
        js.executeScript("window.scrollBy(0,800)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//a[contains(text(),'+ إضافة صف جديد')])[1]")));
        add_new_row_button = driver.findElement(By.xpath
                ("(//a[contains(text(),'+ إضافة صف جديد')])[1]"));
        click_on_element(add_new_row_button);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@title='رمز الصنف']/div[1]/div/input")));
        itemField = driver.findElement(By.xpath
                ("//div[@title='رمز الصنف']/div[1]/div/input"));
        enter_data_to_input_field(itemField, itemName);
        basic_price = driver.findElement(By.xpath
                ("//div[@title='export_rate']/div[1]/input"));
        click_on_element(basic_price);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@title='export_amount']/div[2]/div"), "ر.س 100.00"));

    }

    /********************************************************************************************************************************/
    public void createSalesInvoiceWithoutClient(String itemName) throws InterruptedException {

        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//h5[@class='title-text pull-left'])[2]")));
        seriesNumberField = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[1]"));
        js.executeScript("arguments[0].click();", seriesNumberField);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//span[contains(text(),'INV')])[1]")));
        INVJ = driver.findElement(By.xpath
                ("(//span[contains(text(),'INV')])[1]"));
        click_on_element(INVJ);
        terriority = driver.findElement(By.xpath
                ("//div[@title='إقليم']/div[1]/div/input"));
        click_on_element(terriority);
        enter_data_to_input_field(terriority, "قطر");
        client_name_field = driver.findElement(By.xpath
                ("//input[@data-fieldname='customer']"));
        click_on_element(client_name_field);
        Thread.sleep(3000);

    }

    /***********************************************************************************************************************************/

    public void click_on_advances_tab() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//a[@id='advances_tab-tab-body']")));
        advancesTab = driver.findElement(By.xpath
                ("//a[@id='advances_tab-tab-body']"));
        js.executeScript("arguments[0].click();", advancesTab);

    }

    /********************************************************************************************************************************/

    public void change_fiscal_year() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='السنة المالية']//button")));
        fiscalYear = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='السنة المالية']//button"));
        //  click_on_element(fiscalYear);
        js.executeScript("arguments[0].click();", fiscalYear);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='السنة المالية']//ul")));
        fiscalYearListElement = driver.findElement(By.xpath("//div[@id='page-Form/Sales Invoice']//div[@title='السنة المالية']//ul"));
        fiscalYearList = fiscalYearListElement.findElements(By.tagName("a"));
        differentFiscalYear = fiscalYearList.get(1);
        js.executeScript("arguments[0].click();", differentFiscalYear);


    }
/*************************************************************************************************************************/


    /*********************************************************************************************************************/

    public void enter_value_in_amount_field() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@data-fieldname='amount']//div")));
        amountField = driver.findElement(By.xpath
                ("//div[@data-fieldname='amount']//div"));
        js.executeScript("arguments[0].click();", amountField);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//input[@data-fieldname='amount']")));
        amountField = driver.findElement(By.xpath
                ("//input[@data-fieldname='amount']"));
        js.executeScript("arguments[0].value='';", amountField);
        js.executeScript("arguments[0].value='';", amountField);
        enter_data_to_input_field(amountField, "200");

    }

    /************************************************************************************************************************/
    public WebElement get_validation_message_for_mandatory_ui_fields() {
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='msgprint']")));
        validatioMessage = driver.findElement(By.xpath("//div[@class='msgprint']"));
        return validatioMessage;
    }

    /******************************************************************************************************************************/
    public WebElement get_pos_nvoice_checkbox_element() {
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//span[contains(text(),'INVJ')])[1]")));
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath
                ("//input[@data-fieldname='is_pos']")));
        POS_invoice_checkbox = driver.findElement(By.xpath("//input[@data-fieldname='is_pos']"));
        return POS_invoice_checkbox;
    }

    /*****************************************************************************************************************************/
    public void add_item_to_Sale_invoice(String itemName) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(30));
        js.executeScript("window.scrollBy(0,900)");
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='update_stock']//input[@data-fieldname='update_stock']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='entries']//a[contains(text(),'إضافة صف جديد')]")));
        add_new_row_button = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='entries']//a[contains(text(),'+ إضافة صف جديد')]"));
        js.executeScript("arguments[0].click();", add_new_row_button);
        //click_on_element(add_new_row_button);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='رمز الصنف']//input")));
        itemField = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='رمز الصنف']//input"));
        enter_data_to_input_field(itemField, itemName);
        basic_price = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='export_rate']"));
        //  js.executeScript("arguments[0].click();", basic_price);
        click_on_element(basic_price);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//div[@title='export_amount']//div//div"), "ر.س 100.0000"));

    }

    /*********************************************************************************************************************************/

    public void apply_write_off_without_acount_for_write_off() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        discountsAndWriteOffsButton = driver.findElement(By.xpath
                ("//button[contains(text(),'الخصومات والشطب')]"));
        click_on_element(discountsAndWriteOffsButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//input[@data-fieldname='write_off_outstanding_amount_automatically']")));
        writeOffOutstandingAmountCheckBox = driver.findElement(By.xpath
                ("//input[@data-fieldname='write_off_outstanding_amount_automatically']"));
        click_on_element(writeOffOutstandingAmountCheckBox);

    }

    /*********************************************************************************************************************************/
    public void select_delivery_note() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        fromDeliveryNote = driver.findElement(By.id(
                ("appframe-btn-من سند تسليم")));
        click_on_element(fromDeliveryNote);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id
                ("Button-الحصول_على")));
        get_button = driver.findElement(By.id
                ("Button-الحصول_على"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                ("//div[contains(@class,'modal-body')][@style='padding: 25px;']//ul[contains(@class,'ui-front')]"))));
        deliveryNoteListElement = driver.findElement(By.xpath
                ("//div[contains(@class,'modal-body')][@style='padding: 25px;']//ul[contains(@class,'ui-front')]"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                ("//div[contains(@class,'modal-body')][@style='padding: 25px;']//ul[contains(@class,'ui-front')]//li"))));
        deliveryNoteList = deliveryNoteListElement.findElements(By.tagName("li"));
        System.out.println(deliveryNoteList.size());
        selected_delivery_note = deliveryNoteList.get(deliveryNoteList.size() - 1);
        // click_on_element(selected_delivery_note);
        js.executeScript("arguments[0].click();", selected_delivery_note);
        js.executeScript("arguments[0].click();", get_button);
        //  click_on_element(get_button);
        Thread.sleep(3000);
    }

    public void selectSalesOrder() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        fromSalesOrder = driver.findElement(By.id(
                ("appframe-btn-من أمر بيع")));
        click_on_element(fromSalesOrder);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id
                ("Button-الحصول_على")));
        get_button = driver.findElement(By.id
                ("Button-الحصول_على"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                ("//*[contains(@class,'modal-body')][@ style='padding: 25px;']//ul[contains(@class,'ui-front')]"))));
        salesOrderListElement = driver.findElement(By.xpath
                ("//*[contains(@class,'modal-body')][@ style='padding: 25px;']//ul[contains(@class,'ui-front')]"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                ("//div[contains(@class,'modal-body')][@style='padding: 25px;']//ul[contains(@class,'ui-front')]//li"))));
        salesOrderList = salesOrderListElement.findElements(By.tagName("li"));
        System.out.println(salesOrderList.size());
        selectedSalesOrder = salesOrderList.get(salesOrderList.size() - 1);
        click_on_element(selectedSalesOrder);
        click_on_element(get_button);
        Thread.sleep(3000);
    }

    /*********************************************************************************************************************************/
    public void click_on_update_stock_checkbox_element() {

        updateStockCheckbox = driver.findElement(By.xpath("//input[@data-fieldname='update_stock']"));
        click_on_element(updateStockCheckbox);
    }

    /************************************** **************************************************************************************/
    public void close_window() {
        wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']")));
        close_icon = driver.findElement(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']"));
        click_on_element(close_icon);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//span[@class='label label-success']")));
    }

    /************************************************************************************************************************************/
    public void click_on_make_copy_button() {
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//button[@id='appframe-btn-عمل نسخة']")));
        make_copy_button = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//button[@id='appframe-btn-عمل نسخة']"));
        click_on_element(make_copy_button);
    }

    /************************************************************************************************************************************/
    public String get_invoice_id_name() {
        wait = new WebDriverWait(driver, ofSeconds(120));
        invoiceIDName = driver.findElement(By.xpath("//div[@id='page-Form/Sales Invoice']//h5"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//h5"), "INV"));
        invoiceIDName = driver.findElement(By.xpath("//div[@id='page-Form/Sales Invoice']//h5"));
        return invoiceIDName.getText();
    }

    /********************************************************************************************************************************************/
    public WebElement get_submit_button() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//button[@id='appframe-btn-اعتماد']")));
        submit_button = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//button[@id='appframe-btn-اعتماد']"));
        return submit_button;
    }

    /******************************************************************************************************************************************/

    public void click_on_save_and_submit_button() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        save_and_Submit_button = driver.findElement(By.xpath
                ("//button[@id='appframe-btn-حفظ و اعتماد']//i"));
        click_on_element(save_and_Submit_button);

    }

    /*************************************************************************************************************************************/
    public void click_on_submit_button() {
        submit_button = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//button[@id='appframe-btn-اعتماد']"));
        click_on_element(submit_button);
    }

    /*************************************************************************************************************************************/
    public void change_quantity_of_item() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        js.executeScript("window.scrollBy(0,400)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@data-fieldname='qty']//div")));
        quantityField = driver.findElement(By.xpath
                ("//div[@data-fieldname='qty']//div"));
        js.executeScript("arguments[0].click();", quantityField);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//input[@data-fieldname='qty']")));
        quantityField = driver.findElement(By.xpath("//input[@data-fieldname='qty']"));
        js.executeScript("arguments[0].click();", quantityField);
        js.executeScript("arguments[0].value='';", quantityField);
        enter_data_to_input_field(quantityField, "3");
    }

    /********************************************************************************************************************************-*/
    public void click_on_accept_button() {
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//button[@class = 'btn btn-info btn-yes']")));
        acceptSubmit = driver.findElement(By.xpath
                ("//button[@class = 'btn btn-info btn-yes']"));
        click_on_element(acceptSubmit);

    }

    /*******************************************************************************************************************************/
    public void click_on_save_button() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        save_button = driver.findElement(By.xpath
                ("//button[@id='appframe-btn-حفظ']"));
        js.executeScript("arguments[0].click();", save_button);
    }

    /**************************************************************************************************************************************/
    public WebElement get_stock_validation_message() {
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[contains(text(),'خطأ بسبب مخزون سالب :')]")));
        stock_validation_message = driver.findElement(By.xpath(
                "//div[contains(text(),'خطأ بسبب مخزون سالب :')]"));
        return stock_validation_message;
    }

    /*******************************************************************************************************************************************/
    public WebElement get_error_validation_message() {
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='modal-content']//div[@class='msgprint']")));
        error_validation_message = driver.findElement(By.xpath
                ("//div[@class='modal-content']//div[@class='msgprint']"));
        //   System.out.println(error_validation_message.getText());
        return error_validation_message;
    }


    /********************************************************************************************************************************************/
    public WebElement get_delivery_note_validation_message() {
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[contains(text(),'لايمكن عمل تحديث للمخزون بالكميات الموجوده بسند التسليم')]")));
        deliveryNoteValidationMessage = driver.findElement(By.xpath(
                "//div[contains(text(),'لايمكن عمل تحديث للمخزون بالكميات الموجوده بسند التسليم')]"));
        return deliveryNoteValidationMessage;
    }

    /****************************************************************************************************************************************/
    public WebElement get_backend_validation_message() {
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@class='msgprint']")));
        backendValidationMessage = driver.findElement(By.xpath(
                "//div[@class='msgprint']"));
        return backendValidationMessage;
    }

    /**************************************************************************************************************************************/
    public GeneralLedgerPage open_general_ledger() {
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(
                "appframe-btn-عرض حساب فرعي")));
        showAccountButton = driver.findElement(By.id(
                "appframe-btn-عرض حساب فرعي"));
        click_on_element(showAccountButton);
        return new GeneralLedgerPage(driver);
    }

    /*************************************************************************************************************************************************/
    public SalesInvoicesListPage return_to_sales_invoices_list_page() {
        sales_list_icon = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//i[@doctype-name='Sales Invoice']"));
        click_on_element(sales_list_icon);
        return new SalesInvoicesListPage(driver);
    }

    /*********************************************************************************************************************************************/
    public WebElement get_submitted_icon_element() {
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//i[@class='icon-lock-lock-close-1']")));
        submitted_icon = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//i[@class='icon-lock-lock-close-1']"));
        return submitted_icon;
    }

    /******************************************************************************************************************************************/

    public WebElement get_received_message_element() {
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='msgprint']")));
        received_message = driver.findElement(By.xpath
                ("//div[@class='msgprint']"));
        return received_message;
    }

    public WebElement get_received_tag_element() {
      /*  wait = new WebDriverWait(driver, ofSeconds(180));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='main_content']//div[@class='badge-bar']//span")));*/
        received_tag = driver.findElement(By.xpath
                ("//div[@id='main_content']//div[@class='badge-bar']//span"));
        return received_tag;
    }

    public void waiting_for_element_to_be_visible(By locator) {
        wait = new WebDriverWait(driver, ofSeconds(180));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }


    public void waiting_for_received_tag_element_to_be_invisible(WebElement element) {
        fluent_Wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(180))
                .pollingEvery(Duration.ofSeconds(18))
                .ignoring(Exception.class);
        fluent_Wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));

    }

}
