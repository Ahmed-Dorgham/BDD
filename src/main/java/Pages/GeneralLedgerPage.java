package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;

public class GeneralLedgerPage extends UtilitiesMethods {
    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private WebElement account_cell;

    public GeneralLedgerPage(WebDriver driver) {
        this.driver = driver;
    }

    /************************************************************************************************************************************/
    public WebElement verify_Sales_invoice_appeared_in_genera_ledger() {
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, ofSeconds(300));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//h5[contains(text(),'تقرير استعلام: دفتر الأستاذ العام')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//div[@class='slick-viewport']//div[@class='slick-cell b1 f1'])[1]//a")));

        account_cell = driver.findElement(By.xpath(
                "(//div[@class='slick-viewport']//div[@class='slick-cell b1 f1'])[1]//a"));
        return account_cell;
    }
    /************************************************************************************************************************************/
}
