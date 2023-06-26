package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReceiptVoucherPage extends UtilitiesMethods {

    private WebDriver driver;
    public ReceiptVoucherPage (WebDriver driver) {
        this.driver = driver;
    }
    private JavascriptExecutor js;
    private WebDriverWait wait;
}
