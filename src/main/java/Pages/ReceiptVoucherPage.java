package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofSeconds;

public class ReceiptVoucherPage extends UtilitiesMethods {

    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private WebElement account_statement_element;
    private WebElement financial_statements_element;
    private WebElement yes_button;
    private WebElement clear_cash_element;
    private WebElement accept_submit;
    private WebElement settingIcon;
    private WebElement close_icon;
    private WebElement selected_sales_invoice;
    private WebElement sales_invoice_list_element;
    private List<WebElement> sales_invoice_list;
    private WebElement receipt_voucher_id_name;
    private WebElement save_and_Submit_button;
    private WebElement invoice_link;
    private WebElement from_sales_invoice;
    private WebElement get_button;
    private WebElement series_number_field;
    private WebElement CRV;
    private WebElement paid_field;
    private WebElement show_account_button;
    private WebElement sales_invoices;
    private WebElement paid_amount;
    private WebElement account_field;
    private WebElement client_name_field;
    private List <WebElement> row_indexes;
    private WebElement invoices_table;
    public ReceiptVoucherPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clear_cash() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//i[@data-kooltip='إعداد']")));
        settingIcon = driver.findElement(By.xpath
                ("//i[@data-kooltip='إعداد']"));
        // click_on_element(settingIcon);
        js.executeScript("arguments[0].click();", settingIcon);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//li[@id='clear-cach-icon']")));
        clear_cash_element = driver.findElement(By.xpath
                ("//li[@id='clear-cach-icon']"));
        click_on_element(clear_cash_element);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//button[@class='btn btn-info btn-yes']")));
        yes_button = driver.findElement(By.xpath
                ("//button[@class='btn btn-info btn-yes']"));
        click_on_element(yes_button);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h5[contains(text(),'التقارير')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("report-account-statement")));
    }

    /**************************************************************************************************************************************/
    public void waiting_for_element_to_be_visible(By locator) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /*************************************************************************************************************************************/
    public void click_on_save_and_submit_button() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//button[@id='appframe-btn-حفظ و اعتماد']//i")));
        save_and_Submit_button = driver.findElement(By.xpath
                ("//button[@id='appframe-btn-حفظ و اعتماد']//i"));
        //click_on_element(save_and_Submit_button);
        js.executeScript("arguments[0].click();", save_and_Submit_button);
        //click_on_element(save_and_Submit_button);
    }

    /*************************************************************************************************************************************/
    public void close_window() {
        wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']")));
        close_icon = driver.findElement(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']"));
        click_on_element(close_icon);

    }

    /************************************************************************************************************************************/
    public String get_receipt_voucher_id_name() {
        wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                ("//div[@id='page-Form/Receipt Voucher']//h5"))));
        receipt_voucher_id_name = driver.findElement(By.xpath
                ("//div[@id='page-Form/Receipt Voucher']//h5"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@id='page-Form/Receipt Voucher']//h5"), "CRV"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@id='page-Form/Receipt Voucher']//span[@class='label label-success']"), "تم اعتماده"));
        receipt_voucher_id_name = driver.findElement(By.xpath
                ("//div[@id='page-Form/Receipt Voucher']//h5"));
        return receipt_voucher_id_name.getText();
    }

    /********************************************************************************************************************************************/
    public void select_sales_invoice() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        //Thread.sleep(8000);
        from_sales_invoice = driver.findElement(By.id(
                ("appframe-btn-من فاتورة مبيعات")));
        click_on_element(from_sales_invoice);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id
                ("Button-الحصول_على")));
        get_button = driver.findElement(By.id
                ("Button-الحصول_على"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                ("//div[contains(@class,'modal-body')][@style='padding: 25px;']//ul[contains(@class,'ui-front')]"))));
        sales_invoice_list_element = driver.findElement(By.xpath
                ("//div[contains(@class,'modal-body')][@style='padding: 25px;']//ul[contains(@class,'ui-front')]"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                ("//div[contains(@class,'modal-body')][@style='padding: 25px;']//ul[contains(@class,'ui-front')]//li"))));
        sales_invoice_list = sales_invoice_list_element.findElements(By.tagName("li"));
        System.out.println(sales_invoice_list.size());
        selected_sales_invoice = sales_invoice_list.get(sales_invoice_list.size() - 1);
        // click_on_element(selected_delivery_note);
        js.executeScript("arguments[0].click();", selected_sales_invoice);
        js.executeScript("arguments[0].click();", get_button);
    }

    /*************************************************************************************************************************************/
    public void click_on_accept_button() {
        wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//button[@class = 'btn btn-info btn-yes']")));
        accept_submit = driver.findElement(By.xpath
                ("//button[@class = 'btn btn-info btn-yes']"));
        click_on_element(accept_submit);
    }

    /*******************************************************************************************************************************/

    public SalesInvoicePage click_on_invoice_id() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        //  Thread.sleep(10000);
        wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//li[contains(@data-route,'Form/Sales Invoice')]")));
        invoice_link = driver.findElement(By.xpath
                ("//li[contains(@data-route,'Form/Sales Invoice')]"));
        click_on_element(invoice_link);
        return new SalesInvoicePage(driver);
    }

    /*************************************************************************************************************************************/
    public void refersh_page() {
        driver.navigate().refresh();
    }

    /*******************************************************************************************************************************/
    public void create_receipt_voucher_with_all_mandatory_ui_fields_without_client() throws InterruptedException {
        Actions actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        Thread.sleep(10000);
        series_number_field = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[6]"));
        js.executeScript("arguments[0].click();", series_number_field);
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyUp(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ENTER).perform();
        actions.keyUp(Keys.ENTER).perform();
      /*  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[contains(text(),'CRV')]")));
        CRV = driver.findElement(By.xpath
                ("//span[contains(text(),'CRV')]"));
        click_on_element(CRV);*/
        account_field = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[6]"));
        js.executeScript("arguments[0].click();", account_field);
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyUp(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ENTER).perform();
        actions.keyUp(Keys.ENTER).perform();
        js.executeScript("window.scrollBy(0,900)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("(//div[@data-fieldname= 'amount_to_be_paid'])[2]")));
        paid_field = driver.findElement(By.xpath
                ("(//div[@data-fieldname= 'amount_to_be_paid'])[2]"));
        js.executeScript("arguments[0].click();", paid_field);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//input[@data-fieldname= 'amount_to_be_paid']")));
        paid_amount = driver.findElement(By.xpath
                ("//input[@data-fieldname= 'amount_to_be_paid']"));
        click_on_element(paid_amount);
        enter_data_to_input_field(paid_amount, "115");
        js.executeScript("window.scrollTo(0,0)");
    }

    /****************************************************************************************************************************-*/
    public void create_receipt_voucher_with_all_mandatory_ui_fields_using_client() throws InterruptedException {
        Actions actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(30));
        Thread.sleep(8000);
        series_number_field = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[2]"));
        js.executeScript("arguments[0].click();", series_number_field);
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyUp(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ENTER).perform();
        actions.keyUp(Keys.ENTER).perform();
        account_field = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[2]"));
        js.executeScript("arguments[0].click();", account_field);
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyUp(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ENTER).perform();
        actions.keyUp(Keys.ENTER).perform();
        js.executeScript("window.scrollBy(0,600)");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//input[@data-fieldname='customer']")));
        client_name_field = driver.findElement(By.xpath
                ("//input[@data-fieldname='customer']"));
        enter_data_to_input_field(client_name_field, "عميل نقدي");
        Thread.sleep(3000);
        actions.keyDown(Keys.ENTER).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//form//div[@class='panel-body']//div[@class='rows ui-sortable']")));
        invoices_table = driver.findElement(By.xpath("//form//div[@class='panel-body']//div[@class='rows ui-sortable']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//form//div[@class='panel-body']//div[@class='rows ui-sortable']//div[contains(@class,'row-index')]")));
        row_indexes = invoices_table.findElements(By.xpath("//div[contains(@class,'row-index')]"));
       // System.out.println(row_indexes.size());
        wait.until(ExpectedConditions.visibilityOf((row_indexes.get(row_indexes.size()-1))));
        //js.executeScript("window.scrollBy(0,60000)");
        click_on_element(row_indexes.get(row_indexes.size()-1));
       /* wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("(//input[@data-fieldname='amount_to_be_paid'])[2]")));*/
        paid_amount = driver.findElement(By.xpath
                ("(//input[@data-fieldname='amount_to_be_paid'])"));
        enter_data_to_input_field(paid_amount, "115");
        js.executeScript("window.scrollTo(0,0)");
    }

    /****************************************************************************************************************************-*/
    public GeneralLedgerPage open_general_ledger() {
        wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(
                "appframe-btn-عرض حساب فرعي")));
        show_account_button = driver.findElement(By.id(
                "appframe-btn-عرض حساب فرعي"));
        click_on_element(show_account_button);
        return new GeneralLedgerPage(driver);
    }

    /*************************************************************************************************************************************************/
    public SalesInvoicesListPage open_sales_invoices_list_page() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));

        sales_invoices = driver.findElement(By.id("sidebar-selling-invoice"));
        js.executeScript("arguments[0].click();", sales_invoices);
        return new SalesInvoicesListPage(driver);
    }

}
