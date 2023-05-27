package Pages;

import Utilities.UtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends UtilitiesMethods {

    private WebDriver driver;
    private WebElement email_id_field;
    private WebElement password_field;
    private WebElement login_button;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /******************************************************************************************************************************************/
    public HomePage login_with_valid_data(String emailID, String password) {
        email_id_field = driver.findElement(By.id("login_id"));
        password_field = driver.findElement(By.id("pass"));
        login_button = driver.findElement(By.id("login_btn"));
        clearField(email_id_field);
        clearField(password_field);
        enter_data_to_input_field(email_id_field, emailID);
        enter_data_to_input_field(password_field, password);
        click_on_element(login_button);
        return new HomePage(driver);
    }
}
