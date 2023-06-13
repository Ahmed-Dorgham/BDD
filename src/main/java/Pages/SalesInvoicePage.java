package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
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
    private JavascriptExecutor js;
    private Wait<WebDriver> fluent_Wait;
    private WebElement update_stock_checkbox;
    private WebElement POS_invoice_checkbox;
    private WebElement add_new_row_button;
    private WebElement close_icon;
    private WebElement item_field;
    private WebElement alert_notification;
    private WebElement error_message_after_enqueue;
    private WebElement more_details_button;
    private WebElement quantity_field;
    private WebElement save_and_Submit_button;
    private WebElement save_button;
    private WebElement submit_button;
    private WebElement make_copy_button;
    private WebElement invoice_id_name;
    private WebElement accept_submit;
    private WebElement basic_price;
    private WebElement amount_sar;
    private WebElement amount_field;
    private WebElement terriority;
    private WebElement validation_message;
    private WebElement series_number_field;
    private WebElement date_field;
    private WebElement client_name_field;
    private WebElement show_account_button;
    private WebElement sales_list_icon;
    private WebElement submitted_icon;
    private WebElement received_tag;
    private WebElement received_message;
    private WebElement stock_validation_message;
    private WebElement error_validation_message;
    private WebElement from_delivery_note;
    private WebElement from_sales_order;
    private WebElement get_button;
    private WebElement selected_delivery_note;
    private WebElement selected_sales_order;
    private List<WebElement> delivery_note_list;
    private WebElement delivery_note_list_element;
    private List<WebElement> sales_orderlist;
    private WebElement sales_order_list_element;
    private WebElement advances_tab;
    private WebElement fiscal_year;
    private WebElement fiscal_year_list_element;
    private List<WebElement> fiscal_year_list;
    private WebElement different_fiscal_year;
    private WebElement discounts_and_write_offs_button;
    private WebElement write_off_outstanding_amount_checkbox;
    private WebElement delivery_note_validation_message;
    private WebElement backend_validation_message;
    private WebElement INVJ;
    //private WebElement INV;

    public SalesInvoicePage(WebDriver driver) {
        this.driver = driver;
    }

    /************************************************************************************************************************************/

    public void enter_float_number_in_quantity_field() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        quantity_field = driver.findElement(By.xpath
                ("//input[@data-fieldname='qty']"));
        js.executeScript("arguments[0].value = '';", quantity_field);
        enter_data_to_input_field(quantity_field, "1.5");
    }

    /***************************************************************************************************************************************/
    public void create_sales_invoice_with_all_mandatory_ui_fields(String itemName) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        Thread.sleep(15000);
        series_number_field = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[1]"));
        js.executeScript("arguments[0].click();", series_number_field);
        INVJ = driver.findElement(By.xpath
                ("(//span[contains(text(),'INV')])[1]"));
        //click_on_element(INVJ);
        js.executeScript("arguments[0].click();", INVJ);
        client_name_field = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='customer']"));
        enter_data_to_input_field(client_name_field, "عميل نقدي");
        terriority = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='territory']"));
        click_on_element(terriority);
        // js.executeScript("arguments[0].click();", terriority);
        Thread.sleep(15000);
        js.executeScript("window.scrollBy(0,900)");
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(" إضافة صف جديد")));
       /* wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//form//div[contains(@title,'entries')]//a//span[contains(text(),' إضافة صف جديد')]")));*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='panel-table']//span[contains(text(),' إضافة صف جديد')]")));
        //add_new_row_button = driver.findElement(By.linkText(" إضافة صف جديد"));
        add_new_row_button = driver.findElement(By.xpath
                ("//div[@class='panel-table']//span[contains(text(),' إضافة صف جديد')]"));
        js.executeScript("arguments[0].click();", add_new_row_button);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='item_code']")));
        item_field = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='item_code']"));
        enter_data_to_input_field(item_field, itemName);
        basic_price = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='export_rate']"));
        click_on_element(basic_price);
        //  Thread.sleep(5000);
        amount_sar = driver.findElement(RelativeLocator.with(By.xpath
                        ("//div[@id='page-Form/Sales Invoice']//div[contains(@class,'control-value like-disabled-input ')]"))
                .toLeftOf(basic_price));
        wait.until(ExpectedConditions.textToBePresentInElement(amount_sar, "ر.س 100.0000"));

    }

    /****************************************************************************************************************************-*/
    public void create_sales_invoice_without_terriority(String itemName) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//h5[@class='title-text pull-left'])[2]")));
        series_number_field = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[1]"));
        js.executeScript("arguments[0].click();", series_number_field);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//span[contains(text(),'INV')])[1]")));
        INVJ = driver.findElement(By.xpath
                ("(//span[contains(text(),'INV')])[1]"));
        click_on_element(INVJ);
        client_name_field = driver.findElement(By.xpath
                ("//input[@data-fieldname='customer']"));
        enter_data_to_input_field(client_name_field, "عميل نقدي");
        terriority = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='territory']"));
        click_on_element(terriority);
        Thread.sleep(5000);
        js.executeScript("arguments[0].value='';", terriority);
        js.executeScript("window.scrollBy(0,900)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("+ إضافة صف جديد")));
        add_new_row_button = driver.findElement(By.linkText("+ إضافة صف جديد"));
        js.executeScript("arguments[0].click();", add_new_row_button);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='item_code']")));
        item_field = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='item_code']"));
        enter_data_to_input_field(item_field, itemName);
        basic_price = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='export_rate']"));
        click_on_element(basic_price);
        amount_sar = driver.findElement(RelativeLocator.with(By.xpath
                        ("//div[@id='page-Form/Sales Invoice']//div[contains(@class,'control-value like-disabled-input ')]"))
                .toLeftOf(basic_price));
        wait.until(ExpectedConditions.textToBePresentInElement(amount_sar, "ر.س 100.00"));
    }

    /********************************************************************************************************************************/

    public void select_series_number() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,250)");
        series_number_field = driver.findElement(By.xpath
                ("(//div[@id='page-Form/Sales Invoice']//span[contains(text(),'إختر')])[1]"));
        js.executeScript("arguments[0].click();", series_number_field);
        INVJ = driver.findElement(By.xpath
                ("(//div[@id='page-Form/Sales Invoice']//span[contains(text(),'INV')])[1]"));
        //   click_on_element(INV);
        js.executeScript("arguments[0].click();", INVJ);
    }

    /*************************************************************************************************************************************/
    public void enter_date() {
        date_field = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='posting_date']"));
        js.executeScript("arguments[0].value='';", date_field);
        enter_data_to_input_field(date_field, "1-3-2023");
    }

    /*************************************************************************************************************************************/
    public void create_sales_invoice_without_all_mandatory_ui_fields(String itemName) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//h5[@class='title-text pull-left'])[2]")));

    }

    /*************************************************************************************************************************************/
    public void create_sales_invoice_without_Series_naming(String itemName) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//h5[@class='title-text pull-left']")));
        client_name_field = driver.findElement(By.xpath
                ("//input[@data-fieldname='customer']"));
        enter_data_to_input_field(client_name_field, "عميل نقدي");
        terriority = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='territory']"));
        click_on_element(terriority);
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,800)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("+ إضافة صف جديد")));
        add_new_row_button = driver.findElement(By.linkText("+ إضافة صف جديد"));
        js.executeScript("arguments[0].click();", add_new_row_button);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='item_code']")));
        item_field = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='item_code']"));
        enter_data_to_input_field(item_field, itemName);
        basic_price = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='export_rate']"));
        click_on_element(basic_price);
        amount_sar = driver.findElement(RelativeLocator.with(By.xpath
                        ("//div[@id='page-Form/Sales Invoice']//div[contains(@class,'control-value like-disabled-input ')]"))
                .toLeftOf(basic_price));
        wait.until(ExpectedConditions.textToBePresentInElement(amount_sar, "ر.س 100.00"));
    }

    /*****************************************************************************************************************************/

    public void create_sales_invoice_Without_add_items() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//h5[@class='title-text pull-left'])[2]")));
        series_number_field = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[1]"));
        js.executeScript("arguments[0].click();", series_number_field);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//span[contains(text(),'INV')])[1]")));
        INVJ = driver.findElement(By.xpath
                ("(//span[contains(text(),'INV')])[1]"));
        click_on_element(INVJ);
        client_name_field = driver.findElement(By.xpath
                ("//input[@data-fieldname='customer']"));
        enter_data_to_input_field(client_name_field, "عميل نقدي");
        terriority = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='territory']"));
        click_on_element(terriority);
        Thread.sleep(5000);
    }

    /*****************************************************************************************************************************************/
    public WebElement get_update_stock_checkBox_element() {
        update_stock_checkbox = driver.findElement(By.xpath
                ("//input[@data-fieldname='update_stock']"));
        return update_stock_checkbox;
    }

    /***********************************************************************************************************************/

    public void create_sales_invoice_without_client(String itemName) throws InterruptedException {

        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//h5[@class='title-text pull-left'])[2]")));
        series_number_field = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[1]"));
        js.executeScript("arguments[0].click();", series_number_field);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//span[contains(text(),'INV')])[1]")));
        INVJ = driver.findElement(By.xpath
                ("(//span[contains(text(),'INV')])[1]"));
        click_on_element(INVJ);
        terriority = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='territory']"));
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
        wait = new WebDriverWait(driver, ofSeconds(300));
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//a[@id='advances_tab-tab-body']")));
        advances_tab = driver.findElement(By.xpath
                ("//a[@id='advances_tab-tab-body']"));
        js.executeScript("arguments[0].click();", advances_tab);
    }

    /********************************************************************************************************************************/

    public void change_fiscal_year() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(30));
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("(//div[@id='page-Form/Sales Invoice']//div//button[@data-toggle='dropdown'])[2]")));
        fiscal_year = driver.findElement(By.xpath
                ("(//div[@id='page-Form/Sales Invoice']//div//button[@data-toggle='dropdown'])[2]"));
        //  click_on_element(fiscalYear);
        js.executeScript("arguments[0].click();", fiscal_year);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("(//div[@id='page-Form/Sales Invoice']//form//ul[@aria-expanded='true'])[1]")));
        fiscal_year_list_element = driver.findElement(By.xpath
                ("(//div[@id='page-Form/Sales Invoice']//form//ul[@aria-expanded='true'])[1]"));
        fiscal_year_list = fiscal_year_list_element.findElements(By.tagName("a"));
        different_fiscal_year = fiscal_year_list.get(1);
        js.executeScript("arguments[0].click();", different_fiscal_year);
    }

    /*************************************************************************************************************************/
    public void enter_value_in_amount_field() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@data-fieldname='amount']//div")));
        amount_field = driver.findElement(By.xpath
                ("//div[@data-fieldname='amount']//div"));
        js.executeScript("arguments[0].click();", amount_field);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//input[@data-fieldname='amount']")));
        amount_field = driver.findElement(By.xpath
                ("//input[@data-fieldname='amount']"));
        js.executeScript("arguments[0].value='';", amount_field);
        js.executeScript("arguments[0].value='';", amount_field);
        enter_data_to_input_field(amount_field, "200");
    }

    /************************************************************************************************************************/
    public WebElement get_validation_message_for_mandatory_ui_fields() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='msgprint']")));
        validation_message = driver.findElement(By.xpath
                ("//div[@class='msgprint']"));
        return validation_message;
    }

    /******************************************************************************************************************************/
    public WebElement get_pos_nvoice_checkbox_element() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//span[contains(text(),'INV')])[1]")));
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath
                ("//input[@data-fieldname='is_pos']")));
        POS_invoice_checkbox = driver.findElement(By.xpath
                ("//input[@data-fieldname='is_pos']"));
        return POS_invoice_checkbox;
    }

    /*****************************************************************************************************************************/
    public void add_item_to_Sale_invoice(String item_name) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        js.executeScript("window.scrollBy(0,900)");
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='update_stock']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("+ إضافة صف جديد")));
        add_new_row_button = driver.findElement(By.linkText("+ إضافة صف جديد"));
        js.executeScript("arguments[0].click();", add_new_row_button);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='item_code']")));
        item_field = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='item_code']"));
        enter_data_to_input_field(item_field, item_name);
        basic_price = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//input[@data-fieldname='export_rate']"));
        click_on_element(basic_price);
        amount_sar = driver.findElement(RelativeLocator.with(By.xpath
                        ("//div[@id='page-Form/Sales Invoice']//div[contains(@class,'control-value like-disabled-input ')]"))
                .toLeftOf(basic_price));
        wait.until(ExpectedConditions.textToBePresentInElement(amount_sar, "ر.س 100.00"));
    }

    /*********************************************************************************************************************************/

    public void apply_write_off_without_acount_for_write_off() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        discounts_and_write_offs_button = driver.findElement(By.xpath
                ("//button[contains(text(),'الخصومات والشطب')]"));
        click_on_element(discounts_and_write_offs_button);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//input[@data-fieldname='write_off_outstanding_amount_automatically']")));
        write_off_outstanding_amount_checkbox = driver.findElement(By.xpath
                ("//input[@data-fieldname='write_off_outstanding_amount_automatically']"));
        click_on_element(write_off_outstanding_amount_checkbox);
    }

    /*********************************************************************************************************************************/
    public void select_delivery_note() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        from_delivery_note = driver.findElement(By.id(
                ("appframe-btn-من سند تسليم")));
        click_on_element(from_delivery_note);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id
                ("Button-الحصول_على")));
        get_button = driver.findElement(By.id
                ("Button-الحصول_على"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                ("//div[contains(@class,'modal-body')][@style='padding: 25px;']//ul[contains(@class,'ui-front')]"))));
        delivery_note_list_element = driver.findElement(By.xpath
                ("//div[contains(@class,'modal-body')][@style='padding: 25px;']//ul[contains(@class,'ui-front')]"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                ("//div[contains(@class,'modal-body')][@style='padding: 25px;']//ul[contains(@class,'ui-front')]//li"))));
        delivery_note_list = delivery_note_list_element.findElements(By.tagName("li"));
        System.out.println(delivery_note_list.size());
        selected_delivery_note = delivery_note_list.get(delivery_note_list.size() - 1);
        // click_on_element(selected_delivery_note);
        js.executeScript("arguments[0].click();", selected_delivery_note);
        js.executeScript("arguments[0].click();", get_button);
        Thread.sleep(3000);
    }

    /************************************************************************************************************************************/

    public void select_Sales_order() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        from_sales_order = driver.findElement(By.id(
                ("appframe-btn-من أمر بيع")));
        click_on_element(from_sales_order);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id
                ("Button-الحصول_على")));
        get_button = driver.findElement(By.id
                ("Button-الحصول_على"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                ("//*[contains(@class,'modal-body')][@ style='padding: 25px;']//ul[contains(@class,'ui-front')]"))));
        sales_order_list_element = driver.findElement(By.xpath
                ("//*[contains(@class,'modal-body')][@ style='padding: 25px;']//ul[contains(@class,'ui-front')]"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                ("//div[contains(@class,'modal-body')][@style='padding: 25px;']//ul[contains(@class,'ui-front')]//li"))));
        sales_orderlist = sales_order_list_element.findElements(By.tagName("li"));
        System.out.println(sales_orderlist.size());
        selected_sales_order = sales_orderlist.get(sales_orderlist.size() - 1);
        click_on_element(selected_sales_order);
        click_on_element(get_button);
        Thread.sleep(3000);
    }

    /*********************************************************************************************************************************/
    public void click_on_update_stock_checkbox_element() {

        update_stock_checkbox = driver.findElement(By.xpath
                ("//input[@data-fieldname='update_stock']"));
        click_on_element(update_stock_checkbox);
    }

    /************************************** **************************************************************************************/
    public void close_window() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']")));
        close_icon = driver.findElement(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']"));
        click_on_element(close_icon);
       /* wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//span[@class='label label-success']")));*/
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
        wait = new WebDriverWait(driver, ofSeconds(300));
        invoice_id_name = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//h5"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//h5"), "INV"));
        invoice_id_name = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//h5"));
        return invoice_id_name.getText();
    }

    /********************************************************************************************************************************************/
    public WebElement get_submit_button() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//button[@id='appframe-btn-اعتماد']")));
        submit_button = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//button[@id='appframe-btn-اعتماد']"));
        return submit_button;
    }

    /******************************************************************************************************************************************/

    public void click_on_save_and_submit_button() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
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
        wait = new WebDriverWait(driver, ofSeconds(300));
        js.executeScript("window.scrollBy(0,400)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@data-fieldname='qty']//div")));
        quantity_field = driver.findElement(By.xpath
                ("//div[@data-fieldname='qty']//div"));
        js.executeScript("arguments[0].click();", quantity_field);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//input[@data-fieldname='qty']")));
        quantity_field = driver.findElement(By.xpath
                ("//input[@data-fieldname='qty']"));
        js.executeScript("arguments[0].click();", quantity_field);
        js.executeScript("arguments[0].value='';", quantity_field);
        enter_data_to_input_field(quantity_field, "3");
    }

    /********************************************************************************************************************************-*/
    public void click_on_accept_button() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//button[@class = 'btn btn-info btn-yes']")));
        accept_submit = driver.findElement(By.xpath
                ("//button[@class = 'btn btn-info btn-yes']"));
        click_on_element(accept_submit);
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
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[contains(text(),'خطأ بسبب مخزون سالب :')]")));
        stock_validation_message = driver.findElement(By.xpath(
                "//div[contains(text(),'خطأ بسبب مخزون سالب :')]"));
        return stock_validation_message;
    }

    /*******************************************************************************************************************************************/
    public WebElement get_error_validation_message() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='modal-content']//div[@class='msgprint']")));
        error_validation_message = driver.findElement(By.xpath
                ("//div[@class='modal-content']//div[@class='msgprint']"));
        return error_validation_message;
    }

    /********************************************************************************************************************************************/
    public WebElement get_delivery_note_validation_message() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[contains(text(),'لايمكن عمل تحديث للمخزون بالكميات الموجوده بسند التسليم')]")));
        delivery_note_validation_message = driver.findElement(By.xpath(
                "//div[contains(text(),'لايمكن عمل تحديث للمخزون بالكميات الموجوده بسند التسليم')]"));
        return delivery_note_validation_message;
    }

    /****************************************************************************************************************************************/
    public WebElement get_backend_validation_message() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@class='msgprint']")));
        backend_validation_message = driver.findElement(By.xpath(
                "//div[@class='msgprint']"));
        return backend_validation_message;
    }

    /**************************************************************************************************************************************/
    public GeneralLedgerPage open_general_ledger() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(
                "appframe-btn-عرض حساب فرعي")));
        show_account_button = driver.findElement(By.id(
                "appframe-btn-عرض حساب فرعي"));
        click_on_element(show_account_button);
        return new GeneralLedgerPage(driver);
    }

    /*************************************************************************************************************************************************/
    public SalesInvoicesListPage return_to_sales_invoices_list_page() {
        js = (JavascriptExecutor) driver;
        sales_list_icon = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//i[@doctype-name='Sales Invoice']"));
        //click_on_element(sales_list_icon);
        js.executeScript("arguments[0].click();", sales_list_icon);
        return new SalesInvoicesListPage(driver);
    }

    /*********************************************************************************************************************************************/
    public WebElement get_submitted_icon_element() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//i[@class='icon-lock-lock-close-1']")));
        submitted_icon = driver.findElement(By.xpath
                ("//div[@id='page-Form/Sales Invoice']//i[@class='icon-lock-lock-close-1']"));
        return submitted_icon;
    }

    /******************************************************************************************************************************************/
    public WebElement get_error_message_after_enqueue_element() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(
                ("alert.alert-danger.bg-job-feed-msg"))));
        error_message_after_enqueue = driver.findElement(By.className(
                ("alert.alert-danger.bg-job-feed-msg")));
        return error_message_after_enqueue;
    }

    /******************************************************************************************************************************************/
    public WebElement show_error_message_after_enqueue() {
        wait = new WebDriverWait(driver, ofSeconds(300));

        more_details_button = driver.findElement(By.xpath(
                ("//div[@class='alert alert-danger bg-job-feed-msg']//a[@class='more-details']")));
        click_on_element(more_details_button);
        return error_message_after_enqueue;
    }

    /******************************************************************************************************************************************/
    public WebElement get_received_message_element() {
        wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='msgprint']")));
        received_message = driver.findElement(By.xpath
                ("//div[@class='msgprint']"));
        return received_message;
    }

    /************************************************************************************************************************************/
    public WebElement get_alert_notification() {
        wait = new WebDriverWait(driver, ofSeconds(600));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='alert-container']//a")));
        //  Thread.sleep(3000);
        alert_notification = driver.findElement(By.xpath
                ("//div[@id='alert-container']//a"));

        return alert_notification;
    }

    /************************************************************************************************************************************/

    public WebElement get_received_tag_element() {
        received_tag = driver.findElement(By.xpath
                ("//div[@id='main_content']//div[@class='badge-bar']//span"));
        return received_tag;
    }

    /************************************************************************************************************************************/

    public void waiting_for_element_to_be_visible(By locator) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /************************************************************************************************************************************/

    public void waiting_for_received_tag_element_to_be_invisible() {
        fluent_Wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(Exception.class);
        fluent_Wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.
                xpath("//div[@id='main_content']//div[@class='badge-bar']//span"))));
        System.out.println("recieved tag should be disappear");
    }

    /***************************************************************************************************************************************/
    public void waiting_for_element_to_be_visible(WebElement element) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
    }

    /************************************************************************************************************************************/
}
