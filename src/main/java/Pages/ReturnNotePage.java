package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofSeconds;

public class ReturnNotePage extends UtilitiesMethods {

    private WebDriver driver;

    public ReturnNotePage(WebDriver driver) {this.driver = driver;}
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
    private List <WebElement> sales_invoice_list;
    private WebElement return_note_id_name;
    private WebElement save_and_Submit_button;
    private WebElement invoice_link;
    private WebElement from_sales_invoice;
    private WebElement get_button;

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
        Thread.sleep(10000);
        save_and_Submit_button = driver.findElement(By.xpath
                ("//button[@id='appframe-btn-حفظ و اعتماد']//i"));
        click_on_element(save_and_Submit_button);
    }

    /*************************************************************************************************************************************/
    public void close_window() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']")));
        close_icon = driver.findElement(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']"));
        click_on_element(close_icon);

    }

    /************************************************************************************************************************************/
    public String get_return_note_id_name() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        return_note_id_name = driver.findElement(By.xpath
                ("//div[@id='page-Form/Return Note']//h5"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@id='page-Form/Return Note']//h5"), "RN"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@id='page-Form/Return Note']//span[@class='label label-success']"), "تم اعتماده"));
        return_note_id_name = driver.findElement(By.xpath
                ("//div[@id='page-Form/Return Note']//h5"));
        return return_note_id_name.getText();
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
//        System.out.println(sales_invoice_list.size());
        selected_sales_invoice = sales_invoice_list.get(sales_invoice_list.size()-1);
        // click_on_element(selected_delivery_note);
        js.executeScript("arguments[0].click();", selected_sales_invoice);
        js.executeScript("arguments[0].click();", get_button);
    }
    /*************************************************************************************************************************************/
    public void click_on_accept_button() {
        wait = new WebDriverWait(driver, ofSeconds(300));
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
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='control-value like-disabled-input']//a[contains(text(),'INV')]")));
        invoice_link = driver.findElement(By.xpath
                ("//div[@class='control-value like-disabled-input']//a[contains(text(),'INV')]"));
        click_on_element(invoice_link);
        return new SalesInvoicePage (driver);
    }

    /*************************************************************************************************************************************/
    public void refersh_page() {
        driver.navigate().refresh();
    }

    /*******************************************************************************************************************************/
}
