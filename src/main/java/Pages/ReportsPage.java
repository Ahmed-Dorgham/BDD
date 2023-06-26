package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class ReportsPage extends UtilitiesMethods {

    private WebDriver driver;

    public ReportsPage(WebDriver driver) {this.driver = driver;}
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private WebElement account_statement_element;
    private WebElement yes_button;
    private WebElement clear_cash_element;
    private WebElement settingIcon;
    private WebElement close_icon;
    public AccountStatementReportPage open_account_statement_report() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("report-account-statement")));
        account_statement_element = driver.findElement(By.id("report-account-statement"));
        click_on_element(account_statement_element);
        return new AccountStatementReportPage(driver);
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
    public void close_window() {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']")));
        close_icon = driver.findElement(By.xpath
                ("//div[contains(@style,'display: block;')]//a[@data-dismiss='modal']"));
        click_on_element(close_icon);
    }

    /************************************************************************************************************************************/
    public void waiting_for_element_to_be_visible(By locator) {
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
