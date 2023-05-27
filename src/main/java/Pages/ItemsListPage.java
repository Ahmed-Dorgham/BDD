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

public class ItemsListPage extends UtilitiesMethods {
    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private WebElement item_list_header;
    private WebElement new_button;
    private WebElement update_icon;
    private WebElement navigation_500;
    private List<WebElement> shown_items;
    private WebElement first_shown_item;
    private WebElement delete_button;
    private WebElement accept_submit;
    private WebElement items_list_element;
    private List<WebElement> id_checkboxes;

    public ItemsListPage(WebDriver driver) {
        this.driver = driver;
    }

    public ItemPage open_new_item() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//button[@id='appframe-btn-جديد']")));
        new_button = driver.findElement(By.id("appframe-btn-جديد"));
        js.executeScript("arguments[0].click();", new_button);
        return new ItemPage(driver);
    }

    /*******************************************************************************************************************************/
    public WebElement get_entire_checkboxes_in_sales_invoices_list(int number) {
        id_checkboxes = driver.findElements(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])"));
        return id_checkboxes.get(number);
    }

    /**************************************************************************************************************************************/
    public void click_on_entire_checkbox_of_sales_invoices(int number) {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        js.executeScript("window.scrollBy(0,20)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
        id_checkboxes = driver.findElements(By.xpath("(//div[@class='result-list']//input[@type='checkbox'])"));
        js.executeScript("arguments[0].click();", id_checkboxes.get(number));
    }

    /**************************************************************************************************************************************/
    public String get_first_shown_item_name_before_any_process() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]")));
        items_list_element = driver.findElement(By.xpath
                ("//div[@class='result-list']"));
        shown_items = items_list_element.findElements(By.xpath
                ("//div[@class='result-list']//div[@class='list-row']//a"));
        first_shown_item = shown_items.get(0);
        System.out.println("the last created item is " + first_shown_item.getText());
        return first_shown_item.getText();
    }

    /******************************************************************************************************************************************/
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
    public WebElement get_item_list_header() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h5[contains(text(),'قائمة صنف')]")));
        item_list_header = driver.findElement(By.xpath
                ("//h5[contains(text(),'قائمة صنف')]"));
        return item_list_header;
    }

    /******************************************************************************************************************************************/
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
    public void click_on_update_icon() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@id='appframe-btn-']")));
        update_icon = driver.findElement(By.xpath
                ("//button[@id='appframe-btn-']"));
        js.executeScript("arguments[0].click();", update_icon);
    }

    /************************************************************************************************************************************/
    public void click_on_500_navigation_bar() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@data-value='500']")));
        navigation_500 = driver.findElement(By.xpath("//button[@data-value='500']"));
        click_on_element(navigation_500);
    }

    /******************************************************************************************************************************************/
    public void scroll_to_top() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        js.executeScript("window.scrollTo(0,0)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h5[contains(text(),'قائمة صنف')]")));
    }

    /********************************************************************************************************************************/
    public void scroll_down() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,500)");
    }

    /********************************************************************************************************************************/
    public void wait_elememt_to_be_selected(WebElement e) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeSelected(e));
    }

    /********************************************************************************************************************************/

    public void waiting(long seconds) throws InterruptedException {
        Thread.sleep(seconds);
    }

    /*******************************************************************************************************************************/
    public void waiting_for_text_not_to_be_visible_in_element(By locator, String text) {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,500)");
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
    }
}
