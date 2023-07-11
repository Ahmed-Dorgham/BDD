package StepDefinition.CreateNewClient;

import Pages.ClientPage;
import Pages.ClientsListPage;
import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CreateNewClient extends TestBase {

    String customer_name_individual = "invndicvidual";
    String customer_name_company = "covcvcany";
    String tax_number_text = "123222222212321";
    String client_number_text = "1232222212";

    private String vm_link = "https://temp-t88989.dafater.biz/index.html";
    private String not_pos_user = "not@gmail.com";
    private String password = "123456";
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private ClientsListPage clients_list_page_object;
    private ClientPage client_page_object;

    @Given("user in dafater login page")
    public void user_in_dafater_login_page() {
        driver.get(vm_link);
        // driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(), vm_link);
    }

    @When("user login successfully with valid credentials")
    public void user_login_successfully_with_valid_credentials() {
        loginPageObject = new LoginPage(driver);
        homePageObject = new HomePage(driver);
        homePageObject = loginPageObject.login_with_valid_data(not_pos_user, password);
        Assert.assertTrue(homePageObject.get_dashboard_header_element().isDisplayed());
    }

    @Then("client created successfully")
    public void client_created_successfully() {
        client_page_object.click_on_save_button();
        client_page_object.wait_text_to_present_in_element(By.xpath
                ("//div[@id='page-Form/Customer']//h5"), customer_name_individual);
        System.out.println("the name of new client is " + client_page_object.get_client_name());
    }

    @Then("client created successfully with address")
    public void client_created_successfully_with_address() {
        client_page_object.click_on_save_button();
        client_page_object.wait_text_to_present_in_element(By.xpath
                ("//div[@id='page-Form/Customer']//h5"), customer_name_company);
        System.out.println("the name of new client is " + client_page_object.get_client_name());
    }

    @When("user open clients list and open new client doc")
    public void user_open_clients_list_and_open_new_client_doc() {
        clients_list_page_object = homePageObject.open_clients_list_page();
        client_page_object = clients_list_page_object.open_new_client();
    }
    @When("user enter address")
    public void user_enter_address() {
        client_page_object.click_on_add_address();
        client_page_object.enter_address_details();
    }

    @When("user enter mandatory fields in client doc")
    public void user_enter_mandatory_fields_in_client_doc() throws InterruptedException {
        client_page_object.create_client_with_all_mandatory_fields(customer_name_individual);
    }

    @When("user enter mandatory fields in client doc with address")
    public void user_enter_mandatory_fields_in_client_doc_with_address() throws InterruptedException {
        client_page_object.create_client_with_all_mandatory_fields_with_address(customer_name_company, tax_number_text, client_number_text);
    }
}
