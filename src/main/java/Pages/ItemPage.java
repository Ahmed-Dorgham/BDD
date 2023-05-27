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

public class ItemPage extends UtilitiesMethods {
    private WebDriver driver;

    private JavascriptExecutor js;
    private WebDriverWait wait;
    private Wait<WebDriver> fluent_Wait;
    private WebElement item_group_field;
    private WebElement selected_group;
    private WebElement item_code_field;
    private WebElement item_english_name_field;
    private WebElement item_english_name_title;
    private WebElement default_warehouse_title;
    private WebElement save_button;
    private WebElement make_copy_button;
    private WebElement default_warehouse;
    private WebElement valuation_method_field;
    private WebElement valuation_method_title;
    private WebElement selected_valuation_method;
    private WebElement item_list_icon;


    private WebElement item_group_list_element;
    private List<WebElement> item_group_list;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public void create_item_with_all_mandatory_ui_fields(String item_name, String warehouse_name) {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Item']//span//h5")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@id='page-Form/Item']//div//button//i[@class='icon-computers-floppy-disk'])[1]")));
        item_group_field = driver.findElement(By.xpath
                ("//div[@id='page-Form/Item']//input[@data-fieldname='item_group']"));
        click_on_element(item_group_field);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("(//a[contains(@class,'ui-corner-all')])[1]")));
        selected_group = driver.findElement(By.xpath
                ("(//a[contains(@class,'ui-corner-all')])[1]"));
        click_on_element(selected_group);
        item_code_field = driver.findElement(By.xpath("//div[@id='page-Form/Item']//input[@data-fieldname='item_code']"));
        enter_data_to_input_field(item_code_field, item_name);
        item_english_name_title = driver.findElement(By.xpath(
                ("//span[contains(text(),'اسم الصنف (إنجليزي)')]")));
        item_english_name_field = driver.findElement(RelativeLocator.with(By.xpath
                ("//div[@id='page-Form/Item']//input[@data-fieldname='item_name']")).below(item_english_name_title));
        click_on_element(item_english_name_field);
        js.executeScript("window.scrollBy(0,800)");
        default_warehouse = driver.findElement(By.xpath
                ("//div[@id='page-Form/Item']//input[@data-fieldname='default_warehouse']"));
        enter_data_to_input_field(default_warehouse, warehouse_name);

        valuation_method_title = driver.findElement(By.xpath(
                ("//span[contains(text(),' طريقة التقييم')]")));

        valuation_method_field = driver.findElement(RelativeLocator.with(By.xpath
                ("(//div[@id='page-Form/Item']//button[@title='إختر'])")).below(valuation_method_title));
        click_on_element(valuation_method_field);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Item']//ul//span[contains(text(),'المتوسط \u200B\u200Bالمتحرك')]")));
        selected_valuation_method = driver.findElement(By.xpath
                ("//div[@id='page-Form/Item']//ul//span[contains(text(),'المتوسط \u200B\u200Bالمتحرك')]"));
        click_on_element(selected_valuation_method);

    }

    /****************************************************************************************************************************-*/

    public void enter_item_code(String item_name) {
        item_code_field = driver.findElement(By.xpath("//div[@id='page-Form/Item']//input[@data-fieldname='item_code']"));
        enter_data_to_input_field(item_code_field, item_name);
    }


    /*********************************************************************************************************************************/
    public void click_on_save_button() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(120));
        js.executeScript("window.scrollTo(0,0)");
        save_button = driver.findElement(By.xpath
                ("//button[@id='appframe-btn-حفظ']"));
        js.executeScript("arguments[0].click();", save_button);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Item']//button[@id='appframe-btn-عمل نسخة']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//div[@id='page-Form/Item']//button[@id='appframe-btn-عمل نسخة']")));
    }

    /**************************************************************************************************************************************/
    public void click_on_make_copy_button() {
        wait = new WebDriverWait(driver, ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@id='page-Form/Item']//button[@id='appframe-btn-عمل نسخة']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//div[@id='page-Form/Item']//button[@id='appframe-btn-عمل نسخة']")));
        make_copy_button = driver.findElement(By.xpath
                ("//div[@id='page-Form/Item']//button[@id='appframe-btn-عمل نسخة']"));
        click_on_element(make_copy_button);
    }

    /*********************************************************************************************************************************************/
    public ItemsListPage return_to_item_list_page() {
        item_list_icon = driver.findElement(By.xpath
                ("//div[@id='page-Form/Item']//i[@doctype-name='Item']"));
        click_on_element(item_list_icon);
        return new ItemsListPage(driver);
    }

    /************************************************************************************************************************************/

    public void waiting_for_received_tag_element_to_be_invisible(WebElement element) {
        fluent_Wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(180))
                .pollingEvery(Duration.ofSeconds(18))
                .ignoring(Exception.class);
        fluent_Wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));

    }

    public void waiting_for_element_to_be_visible(WebElement element) {
        fluent_Wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(180))
                .pollingEvery(Duration.ofSeconds(18))
                .ignoring(Exception.class);
        fluent_Wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));

    }

    public void waiting(long seconds) throws InterruptedException {
        Thread.sleep(seconds);
    }
}
