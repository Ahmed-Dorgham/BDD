package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofSeconds;

public class ClientPage extends UtilitiesMethods {

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
    private WebElement return_note_id_name;
    private WebElement save_and_Submit_button;
    private WebElement invoice_link;
    private WebElement from_sales_invoice;
    private WebElement get_button;
    private WebElement client_name_field;
    private WebElement address_type;
    private WebElement address_line_1;
    private WebElement city;
    private WebElement phone;
    private WebElement country;
    private WebElement customer_type;
    private WebElement terriority;
    private WebElement customer_group;
    private WebElement client_name;
    private WebElement save_button;
    private WebElement add_address_button;
    private WebElement tax_number;
    private WebElement client_number;
    public ClientPage(WebDriver driver) {
        this.driver = driver;
    }

    public void refersh_page() {
        driver.navigate().refresh();
    }

    /*******************************************************************************************************************************/
    public void create_client_with_all_mandatory_fields(String customer_name) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        Actions actions = new Actions(driver);
        client_name_field = driver.findElement(By.xpath
                ("//div[@id='page-Form/Customer']//input[@data-fieldname='customer_name']"));
        enter_data_to_input_field(client_name_field, customer_name);
        customer_type = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[2]"));
        js.executeScript("arguments[0].click();", customer_type);
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ENTER).perform();
        terriority = driver.findElement(By.xpath
                ("//div[@id='page-Form/Customer']//input[@data-fieldname='territory']"));
        click_on_element(terriority);
        Thread.sleep(3000);
        actions.keyDown(Keys.ENTER).perform();
        customer_group = driver.findElement(By.xpath
                ("//div[@id='page-Form/Customer']//input[@data-fieldname='customer_group']"));
        click_on_element(customer_group);
        Thread.sleep(3000);
        actions.keyDown(Keys.ENTER).perform();
        Thread.sleep(3000);

    }

    /****************************************************************************************************************************-*/
    public void create_client_with_all_mandatory_fields_with_address(String customer_name, String tax_number_text, String client_number_text) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        Actions actions = new Actions(driver);
        client_name_field = driver.findElement(By.xpath
                ("//div[@id='page-Form/Customer']//input[@data-fieldname='customer_name']"));
        enter_data_to_input_field(client_name_field, customer_name);
        customer_type = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[2]"));
        js.executeScript("arguments[0].click();", customer_type);
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ENTER).perform();
        terriority = driver.findElement(By.xpath
                ("//div[@id='page-Form/Customer']//input[@data-fieldname='territory']"));
        click_on_element(terriority);
        Thread.sleep(3000);
        actions.keyDown(Keys.ENTER).perform();
        customer_group = driver.findElement(By.xpath
                ("//div[@id='page-Form/Customer']//input[@data-fieldname='customer_group']"));
        click_on_element(customer_group);
        Thread.sleep(3000);
        actions.keyDown(Keys.ENTER).perform();
        Thread.sleep(3000);
        tax_number = driver.findElement(By.xpath
                ("//div[@id='page-Form/Customer']//input[@data-fieldname='tax_number']"));
        enter_data_to_input_field(tax_number, tax_number_text);
        client_number = driver.findElement(By.xpath
                ("//div[@id='page-Form/Customer']//input[@data-fieldname='customer_id']"));
        enter_data_to_input_field(client_number, client_number_text);
    }

    /****************************************************************************************************************************-*/
    public void enter_address_details()  {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Button-add")));
        address_type = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[3]"));
        js.executeScript("arguments[0].click();", address_type);
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ENTER).perform();

        address_line_1 = driver.findElement(By.xpath
                ("//div[@class='modal-content']//input[@data-fieldname='address_line1']"));
        enter_data_to_input_field(address_line_1, "address_line_1");
        city = driver.findElement(By.xpath
                ("//div[@class='modal-content']//input[@data-fieldname='city']"));
        enter_data_to_input_field(city, "city");

        phone = driver.findElement(By.xpath
                ("//div[@class='modal-content']//input[@data-fieldname='phone']"));
        enter_data_to_input_field(phone, "123456789");
        country = driver.findElement(By.xpath
                ("(//span[contains(text(),'إختر')])[3]"));
        js.executeScript("arguments[0].click();", country);
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ARROW_DOWN).perform();
        actions.keyDown(Keys.ENTER).perform();
        add_address_button = driver.findElement(By.id
                ("Button-add"));
        js.executeScript("arguments[0].click();", add_address_button);
    }

    /****************************************************************************************************************************-*/
    public String get_client_name() {
        wait = new WebDriverWait(driver, ofSeconds(30));
        client_name = driver.findElement(By.xpath
                ("//div[@id='page-Form/Customer']//h5"));
        return client_name.getText();
    }

    /********************************************************************************************************************************************/
    public void click_on_save_button() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0)");
        save_button = driver.findElement(By.xpath
                ("//button[@id='appframe-btn-حفظ']"));
        js.executeScript("arguments[0].click();", save_button);
    }

    /**************************************************************************************************************************************/
    public void wait_text_to_present_in_element(By locator, String client_name) {
        wait = new WebDriverWait(driver, ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, client_name));
    }

    public void click_on_add_address() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(30));
        js.executeScript("window.scrollTo(0,100)");
        add_address_button = driver.findElement(By.id
                ("Customer-Button-add_new_address_fields"));
        js.executeScript("arguments[0].click();", add_address_button);
    }
}
