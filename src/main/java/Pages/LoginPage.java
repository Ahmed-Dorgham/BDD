package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends UtilitiesMethods {

    private WebDriver driver;
    private WebElement emailIdField;
    private WebElement passwordField;
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /******************************************************************************************************************************************/
    public HomePage login_with_valid_data(String emailID, String password) {
        emailIdField = driver.findElement(By.id("login_id"));
        passwordField = driver.findElement(By.id("pass"));
        loginButton = driver.findElement(By.id("login_btn"));
        clearField(emailIdField);
        clearField(passwordField);
        enter_data_to_input_field(emailIdField, emailID);
        enter_data_to_input_field(passwordField, password);
        click_on_element(loginButton);
        return new HomePage(driver);
    }

}
