package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilitiesMethods {
    private WebDriverWait wait;
    private WebDriver driver;


    public static void click_on_element(WebElement element) {
        element.click();
    }

    public void enter_data_to_input_field(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void clearField(WebElement element) {
        element.clear();
    }
}
