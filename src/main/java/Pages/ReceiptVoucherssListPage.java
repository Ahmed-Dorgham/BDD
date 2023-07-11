package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class ReceiptVoucherssListPage extends UtilitiesMethods {

    private WebDriver driver;

    public ReceiptVoucherssListPage(WebDriver driver) {this.driver = driver;}
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private WebElement account_statement_element;
    private WebElement financial_statements_element;
    private WebElement yes_button;
    private WebElement clear_cash_element;
    private WebElement settingIcon;
    private WebElement close_icon;
    private WebElement return_note_id_name;
    private WebElement save_and_Submit_button;
    private WebElement new_button;

    public void clear_cash() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h5[contains(text(),'قائمة مرتجع مبيعات')]")));
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
        //js.executeScript("arguments[0].click();", clear_cash_element);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//button[@class='btn btn-info btn-yes']")));
        yes_button = driver.findElement(By.xpath
                ("//button[@class='btn btn-info btn-yes']"));
        click_on_element(yes_button);

      /*  wait.until(ExpectedConditions.elementToBeClickable(By.id("report-account-statement")));*/
    }

    /**************************************************************************************************************************************/
    public void waiting_for_element_to_be_visible(By locator) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void click_on_save_and_submit_button() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        Thread.sleep(10000);
        save_and_Submit_button = driver.findElement(By.xpath
                ("//button[@id='appframe-btn-حفظ و اعتماد']//i"));
        click_on_element(save_and_Submit_button);
    }

    /*************************************************************************************************************************************/
    public ReceiptVoucherPage open_new_receipt_voucher() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h5[contains(text(),'قائمة سند قبض')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
               ("//button[@id='appframe-btn-جديد']//i")));
        new_button = driver.findElement(By.id("appframe-btn-جديد"));
        js.executeScript("arguments[0].click();", new_button);
        return new ReceiptVoucherPage(driver);
    }

    /*******************************************************************************************************************************/
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
        wait = new WebDriverWait(driver, ofSeconds(30));
        return_note_id_name = driver.findElement(By.xpath
                ("//div[@id='page-Form/Return Note']//h5"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath
                ("//div[@id='page-Form/Return Note']//h5"), "RN"));
        return_note_id_name = driver.findElement(By.xpath
                ("//div[@id='page-Form/Return Note']//h5"));
        return return_note_id_name.getText();
    }

    /********************************************************************************************************************************************/
    public void refersh_page() {
        driver.navigate().refresh();
    }

}
