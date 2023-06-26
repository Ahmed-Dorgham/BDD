package StepDefinition;

import Pages.*;
import TestCases.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeoutException;

public class StepDefinition extends TestBase {
    String invoice_name_after_submitting;
    String total_amount;
    String client_name;
    String client_namee = "عميل نقدي";
    String invoice_id;
    //String file_path = "C:\\Users\\ahmed\\OneDrive\\Desktop\\Item (1).xlsx";
    //  private String vm_link = "https://engineering-dorgham.dafater.biz/index.html";

    private String vm_link = "https://temp-t88989.dafater.biz/index.html";
    private String not_pos_user = "not@gmail.com";
    private String password = "123456";
    private String pos_user = "ahmed@gmail.com";
    private String pos_password = "123456";
    private String stock_item = "item_2";
    private String non_stock_item = "non_stock_item";
    // private String warehouse_name = "مستودع البضاعة المكتملة - dorgh";
    private String warehouse_name = "139 مستودع تالف الموزع نوفل كنديلات فرع مكة Damaged Warehouse, Distributor Nofal Kandilat, Makkah Branch - أ ط";
    private String created_item = "item.";
    private String blue_color = "color: rgb(61, 38, 255);";
    private String red_color = "color: rgb(255, 38, 38);";
    private String enqueue_class_name = "fas fa-layer-group docstatus_icon";
    private String saved_class_name = "icon-computers-floppy-disk docstatus_icon";
    private String submitted_class_name = "icon-lock-lock-close-1 docstatus_icon";
    private String icon_locator =
            "//div[@id='page-List/Sales Invoice']//div[@class='result']//div[@class='result-list']//div[@class='list-row']//span//i";
    // private String exported_doctype = "صنف";
    // private String exported_doctype = "فاتورة مبيعات";
    private String date_before_enqueue;
    private String total_debit_before_invoice;
    private String total_debit_after_invoice;
    private String first_shown_invoice_name;
    private String first_shown_item_name;
    private LoginPage loginPageObject;
    private HomePage homePageObject;
    private SalesInvoicesListPage sales_invoices_list_Page_object;
    private ItemsListPage items_list_page_object;
    private ItemPage item_page_object;
    private GeneralLedgerPage general_ledger_page_object;
    private ReportsPage reports_page_object;
    private AccountStatementReportPage account_statement_report_page_object;
    private SalesInvoicePage sales_invoice_page_object;
    private SetupPage setup_page_object;
    private DataImportPage data_import_page_object;

    @Given("user in dafater login page")
    public void open_login_page() {

        driver.get(vm_link);
        // driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(), vm_link);
    }

    @When("user login successfully with valid credentials")
    public void user_login_successfully_not_pos_user() {
        loginPageObject = new LoginPage(driver);
        homePageObject = new HomePage(driver);
        homePageObject = loginPageObject.login_with_valid_data(not_pos_user, password);
        Assert.assertTrue(homePageObject.get_dashboard_header_element().isDisplayed());
    }

    @When("user login successfully with valid credentials \\( POS user)")
    public void user_login_successfully_pos_user() {
        loginPageObject = new LoginPage(driver);
        homePageObject = new HomePage(driver);
        homePageObject = loginPageObject.login_with_valid_data(pos_user, pos_password);
        Assert.assertTrue(homePageObject.get_dashboard_header_element().isDisplayed());
    }

    @When("user open sales invoice list and open new sales invoice")
    public void open_sales_invoice_list_and_open_new_sales_invoice() {
        sales_invoices_list_Page_object = homePageObject.open_sales_invoices_list_page();
        //  Assert.assertTrue(sales_invoices_list_Page_object.get_sales_invoices_list_header().isDisplayed());
        sales_invoice_page_object = sales_invoices_list_Page_object.open_new_sales_invoice();
    }

    @When("user verify that POS invoice CheckBox is checked and add items to sales invoice")
    public void verify_that_pos_invoice_check_box_is_checked_and_add_items_to_sales_invoice() throws InterruptedException {
        Assert.assertTrue(sales_invoice_page_object.get_pos_invoice_checkbox_element().isSelected());
        sales_invoice_page_object.add_item_to_Sale_invoice(stock_item);
    }

    @When("user enter mandatory fields in sales invoice \\( client - item - series naming )")
    public void enter_mandatory_fields_in_sales_invoice() throws InterruptedException {
        sales_invoice_page_object.create_sales_invoice_with_all_mandatory_ui_fields(stock_item);
    }

    @When("user enter mandatory fields in sales invoice \\( client - non stock item - series naming )")
    public void user_enter_mandatory_fields_in_sales_invoice_client_non_stock_item_and_series_naming() throws InterruptedException {
        sales_invoice_page_object.create_sales_invoice_with_all_mandatory_ui_fields(non_stock_item);
    }

    @When("user verify that  Update Stock CheckBox is unchecked then submit sales invoice")
    public void verify_that_update_stock_check_box_is_unchecked_then_submit_sales_invoice() {
        sales_invoice_page_object.get_update_stock_checkBox_element();
        Assert.assertFalse(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
        sales_invoice_page_object.click_on_save_and_submit_button();
        sales_invoice_page_object.click_on_accept_button();
    }

    @When("user uncheck Update Stock CheckBox and verify that then submit sales invoice")
    public void uncheck_update_stock_check_box_and_verify_that_then_submit_sales_invoice() {
        sales_invoice_page_object.scroll_down_and_wait();
        //sales_invoice_page_object.click_on_update_stock_checkbox_element();
        Assert.assertFalse(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
        sales_invoice_page_object.click_on_save_and_submit_button();
        sales_invoice_page_object.click_on_accept_button();
    }

    @When("user click on Update Stock CheckBox then submit sales invoice")
    public void click_on_update_stock_check_box_then_submit_sales_invoice() {
        sales_invoice_page_object.click_on_update_stock_checkbox_element();
        Assert.assertTrue(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
        sales_invoice_page_object.click_on_save_and_submit_button();
        sales_invoice_page_object.click_on_accept_button();
    }

    @When("user verify that  Update Stock CheckBox is checked then submit sales invoice")
    public void verify_that_update_stock_check_box_is_checked_then_submit_sales_invoice() {
        sales_invoice_page_object.scroll_down_and_wait();
        sales_invoice_page_object.click_on_update_stock_checkbox_element();
        Assert.assertTrue(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
        sales_invoice_page_object.click_on_save_and_submit_button();
        sales_invoice_page_object.click_on_accept_button();
    }

    @Then("sales invoice created successfully with it's unique ID")
    public void sales_invoice_created_with_it_s_unique_id() throws InterruptedException {
        sales_invoice_page_object.close_window();
        String invoiceNameAfterSubmitting = sales_invoice_page_object.get_invoice_id_name();
        Assert.assertTrue(invoiceNameAfterSubmitting.contains("INV"));
        System.out.println("the ID of submitted sales invoice is  " + sales_invoice_page_object.get_invoice_id_name());
        sales_invoice_page_object.scroll_down();
        total_amount = sales_invoice_page_object.total_amount().getText();
        sales_invoice_page_object.scroll_up();
        client_name = sales_invoice_page_object.client_name().getText();
        invoice_id = sales_invoice_page_object.get_invoice_id_name();
    }

    @Then("sales invoice appear in general ledger and stock account not appear")
    public void sales_invoice_appear_in_general_ledger_and_stock_account_not_appear() throws InterruptedException {
        general_ledger_page_object = sales_invoice_page_object.open_general_ledger();
        general_ledger_page_object.click_on_load_data();
        /******* assert that the stock account is appeared in general ledger report when creating sales invoice with update stock *******/

        if (general_ledger_page_object.get_report().getText().contains(" حساب المخزون")) {
            for (int i = 0; i < general_ledger_page_object.rows_number() - 1; i++) {
                if (general_ledger_page_object.account_in_general_ledger(i).getText().contains(" حساب المخزون")
                        && general_ledger_page_object.voucher_number_in_general_ledger(i).getText().contains(invoice_id)) {
                    System.out.println("this sales invoice with update stock and appeared in general ledger successfully with correct data ");
                }
            }
        } else {
            System.out.println("this invoice without update stock");
        }
        /******* assert that total amount of sales invoice is appeared correctly as debit on client in general ledger report *******/
        for (int i = 0; i < general_ledger_page_object.rows_number() - 1; i++) {
            if (general_ledger_page_object.debit_in_general_ledger(i).getText().contains(total_amount) &&
                    general_ledger_page_object.account_in_general_ledger(i).getText().contains(client_name)
                    && general_ledger_page_object.voucher_number_in_general_ledger(i).getText().contains(invoice_id)) {
                System.out.println("the debit on client in general ledger report is the same as the total amount of sales invoice and this is correct");
            }
        }
    }

    @Then("sales invoice appear in general ledger and stock account appear")
    public void sales_invoice_and_stock_account_appear_in_general_ledger() throws InterruptedException {
        general_ledger_page_object = sales_invoice_page_object.open_general_ledger();
        general_ledger_page_object.click_on_load_data();
        //  System.out.println(general_ledger_page_object.rows_number());
        /******* assert that the stock account is appeared in general ledger report when creating sales invoice with update stock *******/
        for (int i = 0; i < general_ledger_page_object.rows_number() - 1; i++) {
            if (general_ledger_page_object.account_in_general_ledger(i).getText().contains(" حساب المخزون")
                    && general_ledger_page_object.voucher_number_in_general_ledger(i).getText().contains(invoice_id)) {
                System.out.println("this sales invoice with update stock is appeared in general ledger report successfully with correct data ");
            }

        }

        /******* assert that total amount of sales invoice is appeared correctly as debit on client in general ledger report *******/
        for (int i = 0; i < general_ledger_page_object.rows_number() - 1; i++) {
            if (general_ledger_page_object.debit_in_general_ledger(i).getText().contains(total_amount) &&
                    general_ledger_page_object.account_in_general_ledger(i).getText().contains(client_name)
                    && general_ledger_page_object.voucher_number_in_general_ledger(i).getText().contains(invoice_id)) {
                System.out.println("the debit on client in general ledger report is the same as the total amount of sales invoice and this is correct");
            }
        }
    }

    @Then("sales invoice not created successfully and validation message appear \\(Negative stock error)")
    public void sales_invoice_not_created_and_validation_message_on_negative_stock_error_appear() {
        //Assert.assertTrue(salesInvoicePageObject.get_stock_validation_message().isDisplayed());
        //Assert.assertTrue(sales_invoice_page_object.get_error_validation_message().isDisplayed());
        System.out.println(sales_invoice_page_object.get_error_validation_message().getText());

    }

    @When("user click on  save sales invoice")
    public void user_click_on_save_sales_invoice() {
        sales_invoice_page_object.click_on_save_button();
    }

    @When("user select delivery note to create sales invoice")
    public void user_delivery_note_to_create_sales_invoice() throws InterruptedException {
        sales_invoice_page_object.enter_series_numbering();
        sales_invoice_page_object.select_delivery_note();

    }
    @When("user select sales order to create sales invoice")
    public void user_sales_order_to_create_sales_invoice() throws InterruptedException {
        sales_invoice_page_object.enter_series_numbering();
        sales_invoice_page_object.select_Sales_order();

    }
    @Then("sales invoice not created successfully and validation message appear \\(Stock update can not be made against Delivery Note)")
    public void sales_invoice_not_created_and_validation_message_for_delivery_note_appear() {
        Assert.assertTrue(sales_invoice_page_object.get_delivery_note_validation_message().isDisplayed());
        System.out.println(sales_invoice_page_object.get_error_validation_message().getText());

    }

    @When("user verify that POS invoice CheckBox is checked and use sales order to create sales invoice")
    public void verify_pos_invoice_check_box_is_checked_and_use_sales_order_to_create_sales_invoice() throws InterruptedException {
        Assert.assertTrue(sales_invoice_page_object.get_pos_invoice_checkbox_element().isSelected());
        sales_invoice_page_object.select_Sales_order();
    }

    @When("user enter float number in quantity field then click on save button")
    public void enter_float_number_in_quantity_field_then_click_on_save_button() {
        sales_invoice_page_object.enter_float_number_in_quantity_field();
        sales_invoice_page_object.click_on_save_button();
    }

    @Then("sales invoice not saved successfully and validation message appear \\(uom validation message)")
    public void sales_invoice_not_saved_and_uom_validation_message_appear() throws InterruptedException {
        //Assert.assertTrue(salesInvoicePageObject.getInvoiceIDName().contains("INV"));
        //  Assert.assertTrue( salesInvoicePageObject.getSubmitButton().isDisplayed());
        Assert.assertTrue(sales_invoice_page_object.get_backend_validation_message().isDisplayed());
        // Assert.assertFalse( salesInvoicePageObject.get_validation_message().isDisplayed());
        Assert.assertTrue(sales_invoice_page_object.get_backend_validation_message()
                .getText().contains("لايجب أن تكون الكميات عبارة عن أجزاء عشرية"));
        System.out.println(sales_invoice_page_object.get_error_validation_message().getText());
    }

    @Then("sales invoice not saved successfully and validation message appear \\(delivery note validation message)")
    public void sales_invoice_not_saved_and_validation_message_on_delivery_note_appear() {
        //Assert.assertTrue(salesInvoicePageObject.getInvoiceIDName().contains("INV"));
        //  Assert.assertTrue( salesInvoicePageObject.getSubmitButton().isDisplayed());
        Assert.assertTrue(sales_invoice_page_object.get_backend_validation_message().isDisplayed());
        // Assert.assertFalse( salesInvoicePageObject.get_validation_message().isDisplayed());
        Assert.assertTrue(sales_invoice_page_object.get_backend_validation_message()
                .getText().contains("لايمكن عمل تحديث للمخزون بالكميات الموجوده بسند التسليم"));
        System.out.println(sales_invoice_page_object.get_error_validation_message().getText());
    }

    @When("user verify that  Update Stock CheckBox is unchecked then save sales invoice")
    public void save_sales_invoice() {
        Assert.assertFalse(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
        sales_invoice_page_object.click_on_save_button();
    }

    @When("user verify that  Update Stock CheckBox is checked then save sales invoice")
    public void verify_that_Update_stock_checkbox_is_checked_and_save_Sales_invoice() {
        sales_invoice_page_object.scroll_down_and_wait();
        Assert.assertTrue(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
        sales_invoice_page_object.click_on_save_button();
    }

    @Then("sales invoice saved successfully with it's unique ID")
    public void verify_that_sales_invoice_saved_Successfully() {
        Assert.assertTrue(sales_invoice_page_object.get_invoice_id_name().contains("INV"));
        Assert.assertTrue(sales_invoice_page_object.get_submit_button().isDisplayed());
        System.out.println(sales_invoice_page_object.get_invoice_id_name() + " is created successfully");
    }

    @When("user click on Update Stock CheckBox then save sales invoice")
    public void user_click_on_update_stock_check_box_then_save_sales_invoice() {
        sales_invoice_page_object.click_on_update_stock_checkbox_element();
        Assert.assertTrue(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
        sales_invoice_page_object.click_on_save_button();
    }

    @When("user uncheck Update Stock CheckBox and verify that then save sales invoice")
    public void uncheck_update_stock_checkbox_and_verify_that_then_save_sales_invoice() {
        sales_invoice_page_object.scroll_down_and_wait();

        sales_invoice_page_object.click_on_update_stock_checkbox_element();
        //sales_invoice_page_object.waiting_for_element_to_be_not_selected(sales_invoice_page_object.get_update_stock_checkBox_element());
        // Assert.assertFalse(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
        sales_invoice_page_object.click_on_save_button();
    }

    @When("user enter mandatory fields in sales invoice \\( client - item )")
    public void user_enter_mandatory_fields_client_and_item() throws InterruptedException {
        sales_invoice_page_object.create_sales_invoice_without_Series_naming(stock_item);
    }

    @Then("sales invoice not saved successfully and validation messgae appear \\(validation on document numbering series )")
    public void sales_invoice_not_saved_and_validation_message_on_document_numbering_series_appear() {
        Assert.assertTrue(sales_invoice_page_object.get_validation_message_for_mandatory_ui_fields().
                getText().contains("سلسلة ترقيم الوثيقة"));
        System.out.println(sales_invoice_page_object.get_error_validation_message().getText());
    }

    @When("user enter mandatory fields in sales invoice \\( client - document numbering series  )")
    public void user_enter_mandatory_fields_client_and_document_numbering_series() throws InterruptedException {
        sales_invoice_page_object.create_sales_invoice_Without_add_items();
    }

    @Then("sales invoice not saved successfully and validation message appear \\(validation on add items )")
    public void sales_invoice_not_saved_and_validation_message_on_add_items_appear() {
        Assert.assertTrue(sales_invoice_page_object.get_validation_message_for_mandatory_ui_fields()
                .getText().contains("إضافة اصناف"));
        System.out.println(sales_invoice_page_object.get_error_validation_message().getText());
    }

    @Then("sales invoice not saved successfully and validation message appear \\(validation on terriority )")
    public void sales_invoice_not_saved_and_validation_message_on_terriority_appear() {
        Assert.assertTrue(sales_invoice_page_object.get_validation_message_for_mandatory_ui_fields()
                .getText().contains("إقليم"));
        System.out.println(sales_invoice_page_object.get_error_validation_message().getText());
    }

    @Then("sales invoice not saved successfully and validation message appear \\(validation on client and client account )")
    public void sales_invoice_not_saved_and_validatin_message_for_client_and_client_account_appear() {
        Assert.assertTrue(sales_invoice_page_object.get_validation_message_for_mandatory_ui_fields()
                .getText().contains("اسم العميل"));
        Assert.assertTrue(sales_invoice_page_object.get_validation_message_for_mandatory_ui_fields()
                .getText().contains("الخصم إلى (حساب العميل)"));
        System.out.println(sales_invoice_page_object.get_error_validation_message().getText());
    }

    @When("user enter mandatory fields in sales invoice \\(client - add item -  document numbering series) \\(without terriority)")
    public void user_enter_mandatory_ui_fields_without_terriority() throws InterruptedException {
        sales_invoice_page_object.create_sales_invoice_without_terriority(stock_item);
    }

    @When("user enter mandatory fields in sales invoice \\(add item -  document numbering series) \\(without client and client account )")
    public void user_enter_mandatory_ui_fields_without_client_and_client_account() throws InterruptedException {
        sales_invoice_page_object.create_sales_invoice_without_client(stock_item);
    }

    @Then("sales invoice not saved successfully and validation message appear \\(validation on all mandatory UI fields )")
    public void sales_invoice_not_saved_and_validation_message_on_all_mandatory_ui_fields_appear() {
        Assert.assertTrue(sales_invoice_page_object.get_validation_message_for_mandatory_ui_fields()
                .getText().contains("اسم العميل"));
        Assert.assertTrue(sales_invoice_page_object.get_validation_message_for_mandatory_ui_fields()
                .getText().contains("الخصم إلى (حساب العميل)"));
        Assert.assertTrue(sales_invoice_page_object.get_validation_message_for_mandatory_ui_fields().
                getText().contains("سلسلة ترقيم الوثيقة"));
        Assert.assertTrue(sales_invoice_page_object.get_validation_message_for_mandatory_ui_fields()
                .getText().contains("إضافة اصناف"));
        Assert.assertTrue(sales_invoice_page_object.get_validation_message_for_mandatory_ui_fields()
                .getText().contains("إقليم"));
        System.out.println(sales_invoice_page_object.get_error_validation_message().getText());
    }

    @When("user increase the paid amount then save sales invoice")
    public void user_increase_the_paid_amount_then_save_sales_invoice() {
        Assert.assertTrue(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
        sales_invoice_page_object.click_on_advances_tab();
        sales_invoice_page_object.enter_value_in_amount_field();
        sales_invoice_page_object.click_on_save_button();
    }

    @Then("sales invoice not saved successfully and validation message appear \\(account for change amount validation message)")
    public void sales_invoice_not_saved_and_account_for_change_amount_validation_message_appear() {
        //Assert.assertTrue(salesInvoicePageObject.getInvoiceIDName().contains("INV"));
        //  Assert.assertTrue( salesInvoicePageObject.getSubmitButton().isDisplayed());
        Assert.assertTrue(sales_invoice_page_object.get_backend_validation_message().isDisplayed());
        // Assert.assertFalse( salesInvoicePageObject.get_validation_message().isDisplayed());
        Assert.assertTrue(sales_invoice_page_object.get_backend_validation_message()
                .getText().contains("من فضلك قم بتحديد الحساب الخاص بالمبلغ المتبقى"));
        System.out.println(sales_invoice_page_object.get_error_validation_message().getText());
    }

    @When("user apply write off on sales invoice without specify account for write off then save sales invoice")
    public void user_apply_write_off_without_account_for_write_off_then_save_sales_invoice() {
        Assert.assertFalse(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
        sales_invoice_page_object.apply_write_off_without_acount_for_write_off();
        sales_invoice_page_object.close_window();
        sales_invoice_page_object.click_on_save_button();
    }

    @Then("sales invoice not saved successfully and validation message appear \\(account for write off validation message)")
    public void sales_invoice_not_saved_and_account_for_write_off_validation_message_appear() {
        //Assert.assertTrue(salesInvoicePageObject.getInvoiceIDName().contains("INV"));
        //  Assert.assertTrue( salesInvoicePageObject.getSubmitButton().isDisplayed());
        Assert.assertTrue(sales_invoice_page_object.get_backend_validation_message().isDisplayed());
        // Assert.assertFalse( salesInvoicePageObject.get_validation_message().isDisplayed());
        Assert.assertTrue(sales_invoice_page_object.get_backend_validation_message()
                .getText().contains("الرجاء تحديد حساب الشطب"));
        System.out.println(sales_invoice_page_object.get_error_validation_message().getText());
    }

    @When("user change the fiscal year to be not the same in invoice issue date  then save sales invoice")
    public void change_the_fiscal_then_save_sales_invoice() {
        sales_invoice_page_object.change_fiscal_year();
        sales_invoice_page_object.click_on_save_button();
    }

    @Then("sales invoice not saved successfully and validation message appear \\(validation on fiscal year)")
    public void sales_invoice_not_saved_and_fiscal_year_validation_message_appear() {

        //Assert.assertTrue(salesInvoicePageObject.getInvoiceIDName().contains("INV"));
        //  Assert.assertTrue( salesInvoicePageObject.getSubmitButton().isDisplayed());
        Assert.assertTrue(sales_invoice_page_object.get_backend_validation_message().isDisplayed());
        // Assert.assertFalse( salesInvoicePageObject.get_validation_message().isDisplayed());
        Assert.assertTrue(sales_invoice_page_object.get_backend_validation_message()
                .getText().contains("تاريخ ادخال الفاتورة"));
        Assert.assertTrue(sales_invoice_page_object.get_backend_validation_message()
                .getText().contains("ليست في أي سنة مالية"));
        System.out.println(sales_invoice_page_object.get_error_validation_message().getText());
    }

    @When("user uncheck Update Stock CheckBox and change quantity then save sales invoice")
    public void uncheck_update_stock_and_change_quantity_then_save_sales_invoice() {
        sales_invoice_page_object.click_on_update_stock_checkbox_element();
        Assert.assertFalse(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
        sales_invoice_page_object.change_quantity_of_item();
        sales_invoice_page_object.click_on_save_button();
    }

    @Then("sales invoice not saved successfully and validation message appear \\(validation on different quantity)")
    public void sales_invoice_not_saved_and_validation_message_on_different_quantity_appear() {
        //Assert.assertTrue(salesInvoicePageObject.getInvoiceIDName().contains("INV"));
        //  Assert.assertTrue( salesInvoicePageObject.getSubmitButton().isDisplayed());
        Assert.assertTrue(sales_invoice_page_object.get_backend_validation_message().isDisplayed());
        // Assert.assertFalse( salesInvoicePageObject.get_validation_message().isDisplayed());
        Assert.assertTrue(sales_invoice_page_object.get_backend_validation_message()
                .getText().contains("لايمكن عمل تحديث للمخزون بالكميات الموجوده بسند التسليم"));
        System.out.println(sales_invoice_page_object.get_error_validation_message().getText());
    }

    @When("user open sales invoice list page and select all appeared sales invoices \\(twenty invoices)")
    public void select_sales_invoices() {
        sales_invoices_list_Page_object = homePageObject.open_sales_invoices_list_page();
        Assert.assertTrue(sales_invoices_list_Page_object.get_sales_invoices_list_header().isDisplayed());
        sales_invoices_list_Page_object.click_on_id_checkbox();
        Assert.assertTrue(sales_invoices_list_Page_object.get_id_checkbox_element().isSelected());
        /*salesInvoicesListPageObject.get_number_of_shown_sales_invoices_before_any_process();
        salesInvoicesListPageObject.get_number_of_saved_sales_invoices_before_any_process();
        salesInvoicesListPageObject.get_number_of_submitted_sales_invoices_before_any_process();*/
    }

    @When("user select number of sales invoices")
    public void user_select_number_of_sales_invoices() throws InterruptedException {
        sales_invoices_list_Page_object.click_on_update_icon();
        sales_invoices_list_Page_object.waiting(8000);
        sales_invoices_list_Page_object.click_on_500_navigation_bar();
        sales_invoices_list_Page_object.scroll_to_top();
        sales_invoices_list_Page_object.click_on_update_icon();
        sales_invoices_list_Page_object.waiting(17000);
        sales_invoices_list_Page_object.scroll_down();

        for (int i = 0; i <= 1; i++) {
            sales_invoices_list_Page_object.click_on_entire_checkbox_of_sales_invoices(i);
            System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getText() + " this invoice is created successfully");
        }
        sales_invoices_list_Page_object.wait_elememt_to_be_selected
                (sales_invoices_list_Page_object.get_entire_checkboxes_in_sales_invoices_list(1));
        sales_invoices_list_Page_object.scroll_to_top();
    }

    /****************************************************** select all appeared sales invoices (20) ********************************************/
   /*
    public void select_all_sales_invoices() {
        salesInvoicesListPageObject.clear_cash();
        salesInvoicesListPageObject.waiting_for_title_to_contain("قائمة فاتورة مبيعات");
        Assert.assertTrue(salesInvoicesListPageObject.get_sales_invoices_list_header().isDisplayed());
        salesInvoicesListPageObject.click_on_id_checkbox();
        Assert.assertTrue(salesInvoicesListPageObject.get_id_checkbox_element().isSelected());
        salesInvoicesListPageObject.get_number_of_shown_sales_invoices_before_any_process();
        salesInvoicesListPageObject.get_number_of_saved_sales_invoices_before_any_process();
        salesInvoicesListPageObject.get_number_of_submitted_sales_invoices_before_any_process();
    }

    */
    @When("user select number of sales invoices for enqueue")
    public void user_select_number_of_sales_invoices_for_enqueue() throws InterruptedException {
        sales_invoices_list_Page_object.click_on_update_icon();
        sales_invoices_list_Page_object.waiting(8000);
        sales_invoices_list_Page_object.click_on_500_navigation_bar();
        sales_invoices_list_Page_object.scroll_to_top();
        sales_invoices_list_Page_object.click_on_update_icon();
        sales_invoices_list_Page_object.waiting(17000);
        sales_invoices_list_Page_object.scroll_down();

        for (int i = 0; i <= 1; i++) {
            if (sales_invoices_list_Page_object.get_saved_icon_in_row(i).
                    getAttribute("class").contains(saved_class_name)) {

                Assert.assertTrue(sales_invoices_list_Page_object.get_saved_icon_in_row(i).isDisplayed());
                System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_before_action(i).getText() + " is saved ");
            } else
                System.out.println("result not as expected");

            sales_invoices_list_Page_object.click_on_entire_checkbox_of_sales_invoices(i);

        }
        sales_invoices_list_Page_object.wait_elememt_to_be_selected
                (sales_invoices_list_Page_object.get_entire_checkboxes_in_sales_invoices_list(1));
        sales_invoices_list_Page_object.scroll_to_top();
    }

    @When("user select number of sales invoices \\(draft & submitted)")
    public void select_number_of_sales_invoices_draft_and_submitted() throws InterruptedException {
        sales_invoices_list_Page_object.click_on_update_icon();
        sales_invoices_list_Page_object.waiting(8000);
        sales_invoices_list_Page_object.click_on_500_navigation_bar();
        sales_invoices_list_Page_object.scroll_to_top();
        Assert.assertTrue(sales_invoices_list_Page_object.get_sales_invoices_list_header().isDisplayed());
        sales_invoices_list_Page_object.click_on_update_icon();
        sales_invoices_list_Page_object.waiting(17000);
        sales_invoices_list_Page_object.scroll_down();

        for (int i = 0; i <= 3; i++) {
            sales_invoices_list_Page_object.click_on_entire_checkbox_of_sales_invoices(i);
        }
        sales_invoices_list_Page_object.wait_elememt_to_be_selected(sales_invoices_list_Page_object.get_entire_checkboxes_in_sales_invoices_list(3));
        sales_invoices_list_Page_object.scroll_to_top();
    }

    @When("user select number of sales invoices \\(with error)")
    public void select_number_of_sales_invoices_with_error() throws InterruptedException {
        sales_invoices_list_Page_object.click_on_update_icon();
        sales_invoices_list_Page_object.waiting(8000);
        sales_invoices_list_Page_object.click_on_500_navigation_bar();
        sales_invoices_list_Page_object.scroll_to_top();
        Assert.assertTrue(sales_invoices_list_Page_object.get_sales_invoices_list_header().isDisplayed());
        sales_invoices_list_Page_object.click_on_update_icon();
        sales_invoices_list_Page_object.waiting(17000);
        sales_invoices_list_Page_object.scroll_down();

        for (int i = 0; i <= 3; i++) {
            sales_invoices_list_Page_object.click_on_entire_checkbox_of_sales_invoices(i);
        }
        sales_invoices_list_Page_object.wait_elememt_to_be_selected(sales_invoices_list_Page_object.get_entire_checkboxes_in_sales_invoices_list(1));
        sales_invoices_list_Page_object.scroll_to_top();
    }

    @When("user select number of sales invoices for enqueue \\(with error)")
    public void select_number_of_sales_invoices_for_enqueue_with_error() throws InterruptedException {
        sales_invoices_list_Page_object.click_on_update_icon();
        sales_invoices_list_Page_object.waiting(8000);
        sales_invoices_list_Page_object.click_on_500_navigation_bar();
        sales_invoices_list_Page_object.scroll_to_top();
        Assert.assertTrue(sales_invoices_list_Page_object.get_sales_invoices_list_header().isDisplayed());
        sales_invoices_list_Page_object.click_on_update_icon();
        sales_invoices_list_Page_object.waiting(17000);
        sales_invoices_list_Page_object.scroll_down();

        for (int i = 0; i <= 3; i++) {
            if (sales_invoices_list_Page_object.get_saved_icon_in_row(i).
                    getAttribute("class").contains(saved_class_name)) {

                Assert.assertTrue(sales_invoices_list_Page_object.get_saved_icon_in_row(i).isDisplayed());
                System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_before_action(i).getText() + " is saved ");
            } else
                System.out.println("result not as expected");
            sales_invoices_list_Page_object.click_on_entire_checkbox_of_sales_invoices(i);

        }
        sales_invoices_list_Page_object.wait_elememt_to_be_selected
                (sales_invoices_list_Page_object.get_entire_checkboxes_in_sales_invoices_list(3));
        sales_invoices_list_Page_object.scroll_to_top();
    }

    @When("user submit all selected sales invoices")
    public void submit_sales_invoices() {

        sales_invoices_list_Page_object.click_on_submit_button();
        sales_invoices_list_Page_object.click_on_accept_button();
    }

    @Then("some or all sales invoices shouldn't be submitted successfully and error message will be appeared to tell user that")
    public void unsuccessful_submitting_with_enqueue() throws InterruptedException, TimeoutException {
        sales_invoices_list_Page_object.get_submitting_in_process_message();
        sales_invoices_list_Page_object.close_and_scroll();
        //sales_invoices_list_Page_object.waiting_for_element_to_be_visible(By.xpath(icon_locator), "class", enqueue_class_name);
        for (int i = 0; i <= 3; i++) {
            sales_invoices_list_Page_object.waiting_for_element_to_be_visible(i, By.xpath(icon_locator), "class", enqueue_class_name);
            if (sales_invoices_list_Page_object.get_icon_element_in_row(i).getAttribute("class").contains(enqueue_class_name)
                    && sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getAttribute("style").contains(blue_color)) {
                System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getText() + " in enqueue now");
            } else
                System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getText() + " returned from enqueue");
        }

        for (int i = 0; i <= 3; i++) {

            sales_invoices_list_Page_object.waiting_for_element_to_be_invisible(i, By.xpath(icon_locator), "class", enqueue_class_name);
            if (sales_invoices_list_Page_object.get_icon_element_in_row(i).getAttribute("class").contains(saved_class_name) &&
                    sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getAttribute("style").contains(red_color)) {
                Assert.assertTrue(sales_invoices_list_Page_object.get_saved_icon_in_row(i).isDisplayed());
                System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getText() +
                        " not submitted successfully and there is an error");

            } else if (sales_invoices_list_Page_object.get_icon_element_in_row(i).getAttribute("class").contains(submitted_class_name)
                    || !sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getAttribute("style").contains(red_color)
                    || !sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getAttribute("style").contains(blue_color)) {
                //  Assert.assertTrue(sales_invoices_list_Page_object.get_submitted_icon_in_row(i).isDisplayed());
                System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getText()
                        + " submitted successfully and no error");
            } else
                System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getText()
                        + " still in enqueue");
        }
    }

    @Then("some invoices shouldn't be submitted successfully and error message will be appeared to tell user that")
    public void unsuccessful_submitting_without_enqueue() throws InterruptedException, TimeoutException {
        sales_invoices_list_Page_object.get_error_validation_message();
        //System.out.println(sales_invoices_list_Page_object.get_error_validation_message().getText());
        sales_invoices_list_Page_object.close_window();
        sales_invoices_list_Page_object.scroll_down();
        sales_invoices_list_Page_object.waiting_for_element_to_be_clickable(By.xpath
                ("(//div[@class='result-list']//input[@type='checkbox'])[1]"));
        //sales_invoices_list_Page_object.waiting_for_element_to_be_visible(By.xpath(icon_locator), "class", submitted_class_name);

        for (int i = 0; i <= 3; i++) {
            sales_invoices_list_Page_object.waiting_for_element_to_be_visible(i, By.xpath(icon_locator), "class", submitted_class_name);

            if (sales_invoices_list_Page_object.get_icon_element_in_row(i).getAttribute("class").contains(saved_class_name)
                    || !sales_invoices_list_Page_object.get_icon_element_in_row(i).getAttribute("class").contains(submitted_class_name)) {
                // Assert.assertTrue(sales_invoices_list_Page_object.get_saved_icon_in_row(i).isDisplayed());
                System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getText() +
                        " not submitted successfully and there is an error");

            } else if (sales_invoices_list_Page_object.get_icon_element_in_row(i).getAttribute("class").contains(submitted_class_name)
                    || !sales_invoices_list_Page_object.get_icon_element_in_row(i).getAttribute("class").contains(saved_class_name)) {

                System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getText()
                        + " submitted successfully and no error");
            }
        }
    }

    @Then("all sales invoices should be submitted successfully and no error message will be appeared")
    public void successful_submitting() {
        sales_invoices_list_Page_object.scroll_down();
        for (int i = 0; i <= 1; i++) {
            sales_invoices_list_Page_object.waiting_for_element_to_be_invisible(i, By.xpath(icon_locator), "class", saved_class_name);

            Assert.assertTrue(sales_invoices_list_Page_object.get_submitted_icon_element(i).isDisplayed());
            System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getText() + " this invoice is submitted now");
        }
    }

    @When("user delete all selected sales invoices")
    public void delete_sales_invoices() {
        first_shown_invoice_name = sales_invoices_list_Page_object.get_first_shown_invoice_name_before_any_process();
        sales_invoices_list_Page_object.click_on_delete_button();
        sales_invoices_list_Page_object.click_on_accept_button();
    }

    @Then("all sales invoices should be deleted successfully and no error message will be appeared")
    public void successful_deleting() {
        sales_invoices_list_Page_object.waiting_for_text_not_to_be_visible_in_element(By.
                xpath("(//div[@class='result-list']//div[@class='list-row']//a)[1]"), first_shown_invoice_name);
        sales_invoices_list_Page_object.waiting_for_title_to_contain("قائمة فاتورة مبيعات");
        Assert.assertFalse(sales_invoices_list_Page_object.get_first_shown_invoice_row().getText().contains(first_shown_invoice_name));
        System.out.println(first_shown_invoice_name + " this invoice is deleted now");
    }

    @Then("some or all sales invoices shouldn't be deleted successfully and error message will be appeared to tell user that")
    public void unsuccessful_deleting() {
        Assert.assertTrue(sales_invoices_list_Page_object.get_error_validation_message().isDisplayed());
        sales_invoices_list_Page_object.close_window();
        sales_invoices_list_Page_object.clear_cash();
        sales_invoices_list_Page_object.waiting_for_title_to_contain("قائمة فاتورة مبيعات");
        sales_invoices_list_Page_object.waiting_for_text_not_to_be_visible_in_element(By.xpath
                ("(//div[@class='result-list']//div[@class='list-row']//a)[1]"), first_shown_invoice_name);
        sales_invoices_list_Page_object.get_first_shown_invoice_name_after_any_process();
    }

    @When("user cancel all selected sales invoices")
    public void cancel_sales_invoices() {
        first_shown_invoice_name = sales_invoices_list_Page_object.get_first_shown_invoice_name_before_any_process();
        sales_invoices_list_Page_object.click_on_cancel_button();
        sales_invoices_list_Page_object.click_on_accept_button();

    }

    @Then("all sales invoices should be canceled successfully and no error message will be appeared")
    public void successful_cancelling() {
        sales_invoices_list_Page_object.waiting_for_text_not_to_be_visible_in_element(By.
                xpath("(//div[@class='result-list']//div[@class='list-row']//a)[1]"), first_shown_invoice_name);
        // salesInvoicesListPageObject.clear_cash();
        Assert.assertFalse(sales_invoices_list_Page_object.get_first_shown_invoice_row().getText().contains(first_shown_invoice_name));
        sales_invoices_list_Page_object.show_cancelled_invoices();
       /* sales_invoices_list_Page_object.waiting_for_text_to_be_visible_in_element(By.xpath
                ("//div[@class='result-list']"), first_shown_invoice_name);*/

        for (int i = 0; i <= 1; i++) {
            System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getText() + " this invoice is cancelled now");
        }
    }

    @Then("some or all sales invoices shouldn't be cancelled successfully and error message will be appeared to tell user that")
    public void unsuccessful_cancelling() {
        Assert.assertTrue(sales_invoices_list_Page_object.get_error_validation_message().isDisplayed());
        sales_invoices_list_Page_object.close_window();
        //salesInvoicesListPageObject.clear_cash();
        //  salesInvoicesListPageObject.waiting_for_title_to_contain("قائمة فاتورة مبيعات");
        sales_invoices_list_Page_object.get_number_of_shown_sales_invoices_after_any_process();
        sales_invoices_list_Page_object.get_number_of_saved_sales_invoices_after_any_process();
        sales_invoices_list_Page_object.get_number_of_submitted_sales_invoices_after_any_process();
    }

    @Given("user login successfully and open sales invoice list page")
    public void user_login_sucessfully_and_open_sales_invoice_list_page() {
        driver.get(vm_link);
        //  driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(), vm_link);
        loginPageObject = new LoginPage(driver);
        homePageObject = new HomePage(driver);
        homePageObject = loginPageObject.login_with_valid_data(not_pos_user, password);
        Assert.assertTrue(homePageObject.get_dashboard_header_element().isDisplayed());
        sales_invoices_list_Page_object = homePageObject.open_sales_invoices_list_page();
        Assert.assertTrue(sales_invoices_list_Page_object.get_sales_invoices_list_header().isDisplayed());
    }

    @When("user create bulk of sales invoices and submit it")
    public void create_sales_invoices_and_submit_it() throws InterruptedException {

        /************************* create sales invoices and submit it using new button which existed in  list page **********************************************/
     /*
      for (int i = 0; i < 20; i++) {
            salesInvoicePageObject = salesInvoicesListPageObject.open_new_sales_invoice();
            salesInvoicePageObject.create_sales_invoice_with_all_mandatory_ui_fields(itemName_2);
            salesInvoicePageObject.click_on_save_and_submit_button();
            salesInvoicePageObject.click_on_accept_button();
            salesInvoicePageObject.close_window();
            String invoiceNameAfterSubmitting = salesInvoicePageObject.get_invoice_id_name();
            Assert.assertTrue(invoiceNameAfterSubmitting.contains("INV"));
            salesInvoicePageObject.return_to_sales_invoices_list_page();
        }
        */
        /************************* create sales invoices  and submit it using make copy button which existed sales invoice itself *********************/

        sales_invoice_page_object = sales_invoices_list_Page_object.open_new_sales_invoice();
        sales_invoice_page_object.create_sales_invoice_with_all_mandatory_ui_fields(stock_item);
        sales_invoice_page_object.click_on_save_and_submit_button();
        sales_invoice_page_object.click_on_accept_button();
        sales_invoice_page_object.close_window();
        invoice_name_after_submitting = sales_invoice_page_object.get_invoice_id_name();
        Assert.assertTrue(invoice_name_after_submitting.contains("INV"));
        for (int i = 0; i < 1; i++) {
            sales_invoice_page_object.click_on_make_copy_button();
            sales_invoice_page_object.select_series_number();
            sales_invoice_page_object.click_on_save_and_submit_button();
            sales_invoice_page_object.click_on_accept_button();
            sales_invoice_page_object.close_window();
            invoice_name_after_submitting = sales_invoice_page_object.get_invoice_id_name();
            Assert.assertTrue(invoice_name_after_submitting.contains("INV"));
        }
        sales_invoice_page_object.return_to_sales_invoices_list_page();
    }

    @When("user create bulk of sales invoices and save it")
    public void create_sales_invoices_and_save_it() throws InterruptedException {

        /************************* create sales invoices and save it using make copy button which existed sales invoice itself *********************/

        sales_invoice_page_object = sales_invoices_list_Page_object.open_new_sales_invoice();
        sales_invoice_page_object.create_sales_invoice_with_all_mandatory_ui_fields(stock_item);
        sales_invoice_page_object.click_on_save_button();
        Assert.assertTrue(sales_invoice_page_object.get_invoice_id_name().contains("INV"));
        Assert.assertTrue(sales_invoice_page_object.get_submit_button().isDisplayed());
        for (int i = 0; i < 1; i++) {
            sales_invoice_page_object.click_on_make_copy_button();
            sales_invoice_page_object.select_series_number();
            sales_invoice_page_object.click_on_save_button();
            Assert.assertTrue(sales_invoice_page_object.get_invoice_id_name().contains("INV"));
            Assert.assertTrue(sales_invoice_page_object.get_submit_button().isDisplayed());
        }
        sales_invoice_page_object.return_to_sales_invoices_list_page();
    }

    /************************* create sales invoices  and save it using new button which existed in  list page **********************************************/
     /*
      for (int i = 0; i < 20; i++) {
            salesInvoicePageObject = salesInvoicesListPageObject.open_new_sales_invoice();
            salesInvoicePageObject.create_sales_invoice_with_all_mandatory_ui_fields(itemName_2);
        salesInvoicePageObject.click_on_save_button();
        Assert.assertTrue(salesInvoicePageObject.get_invoice_id_name().contains("INVJ"));
        Assert.assertTrue(salesInvoicePageObject.getSubmitButton().isDisplayed());
            salesInvoicePageObject.return_to_sales_invoices_list_page();
        }
      */
    @When("user create bulk of sales invoices with error and save it")
    public void create_sales_invoices_with_error_and_save_it() throws InterruptedException {

        for (int i = 0; i < 2; i++) {
            sales_invoice_page_object = sales_invoices_list_Page_object.open_new_sales_invoice();
            sales_invoice_page_object.create_sales_invoice_with_all_mandatory_ui_fields(stock_item);
            sales_invoice_page_object.click_on_update_stock_checkbox_element();
            sales_invoice_page_object.enter_date();
            sales_invoice_page_object.click_on_save_button();
            Assert.assertTrue(sales_invoice_page_object.get_invoice_id_name().contains("INV"));
            Assert.assertTrue(sales_invoice_page_object.get_submit_button().isDisplayed());
            sales_invoice_page_object.return_to_sales_invoices_list_page();
        }
    }

    @When("user create bulk of sales invoices from delivery notes")
    public void user_create_bulk_of_sales_invoices_from_delivery_notes() throws InterruptedException {

        for (int i = 0; i < 2; i++) {
            sales_invoice_page_object = sales_invoices_list_Page_object.open_new_sales_invoice();
            sales_invoice_page_object.select_delivery_note();
            sales_invoice_page_object.select_series_number();
            sales_invoice_page_object.click_on_save_and_submit_button();
            sales_invoice_page_object.click_on_accept_button();
            sales_invoice_page_object.close_window();
            invoice_name_after_submitting = sales_invoice_page_object.get_invoice_id_name();
            Assert.assertTrue(invoice_name_after_submitting.contains("INV"));
            sales_invoice_page_object.return_to_sales_invoices_list_page();
        }
    }

    @Given("user create sales invoice and save it")
    public void user_create_sales_invoice_and_save_it() throws InterruptedException {
        sales_invoice_page_object = sales_invoices_list_Page_object.open_new_sales_invoice();
        sales_invoice_page_object.create_sales_invoice_with_all_mandatory_ui_fields(stock_item);
        sales_invoice_page_object.click_on_save_button();
        Assert.assertTrue(sales_invoice_page_object.get_invoice_id_name().contains("INV"));
        Assert.assertTrue(sales_invoice_page_object.get_submit_button().isDisplayed());
    }

    @When("user submit sales invoice")
    public void user_submit_sales_invoice() {
        sales_invoice_page_object.click_on_submit_button();
        sales_invoice_page_object.click_on_accept_button();
    }

    @Then("sales invoice should be submitted successfully and a notification appear tell user that")
    public void invoice_submitted_successfully_and_notification_appear_to_user() {
        Assert.assertTrue(sales_invoice_page_object.get_received_message_element().getText().contains
                ("جاري العمل على تنفيذ طلبك. سنبلغك عن طريق الإشعارات عند الانتهاء"));
        Assert.assertTrue(sales_invoice_page_object.get_received_tag_element().isDisplayed());
        sales_invoice_page_object.close_window();
        sales_invoice_page_object.waiting_for_element_to_be_visible(sales_invoice_page_object.get_alert_notification());
        sales_invoice_page_object.waiting_for_received_tag_element_to_be_invisible();
        Assert.assertTrue(sales_invoice_page_object.get_submitted_icon_element().isDisplayed());
        System.out.println(sales_invoice_page_object.get_invoice_id_name() + " returned from enqueue and submitted successfully");
    }

    @Then("sales invoice not submitted successfully and a notification appear tell user that")
    public void invoice_not_submitted_and_notification_appear() {
      /*  Assert.assertEquals(sales_invoice_page_object.get_received_message_element().getText(),
                ("جاري العمل على تنفيذ طلبك. سنبلغك عن طريق الإشعارات عند الانتهاء"));
        Assert.assertTrue(sales_invoice_page_object.get_received_tag_element().isDisplayed());
        sales_invoice_page_object.close_window();*/
        sales_invoice_page_object.waiting_for_element_to_be_visible(sales_invoice_page_object.get_alert_notification());
        sales_invoice_page_object.waiting_for_received_tag_element_to_be_invisible();
        Assert.assertTrue(sales_invoice_page_object.get_error_message_after_enqueue_element().isDisplayed());
        System.out.println(sales_invoice_page_object.get_invoice_id_name() + " returned from enqueue and not submitted successfully and there is an error happen");
        System.out.println(sales_invoice_page_object.get_error_message_after_enqueue_element().getText());
    }

    @Then("some or all sales invoices shouldn't be deleted successfully and others should be deleted successfully")
    public void some_or_all_sales_invoices_shouldn_t_be_deleted_successfully_and_others_should_be_deleted_successfully() {

    }

    @Given("user login sucessfully and open items list page")
    public void user_login_sucessfully_and_open_item_list_page() {
        driver.get(vm_link);
        //driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(), vm_link);
        loginPageObject = new LoginPage(driver);
        homePageObject = new HomePage(driver);
        homePageObject = loginPageObject.login_with_valid_data(pos_user, pos_password);
        Assert.assertTrue(homePageObject.get_dashboard_header_element().isDisplayed());
        items_list_page_object = homePageObject.open_items_list_page();
        Assert.assertTrue(items_list_page_object.get_item_list_header().isDisplayed());

    }

    @Given("user create bulk of items and save it")
    public void user_create_bulk_of_items_and_save_it() throws InterruptedException {
        item_page_object = items_list_page_object.open_new_item();
        item_page_object.create_item_with_all_mandatory_ui_fields(created_item, warehouse_name);
        item_page_object.waiting(7000);
        item_page_object.click_on_save_button();

        for (int i = 0; i < 1; i++) {
            item_page_object.click_on_make_copy_button();
            item_page_object.enter_item_code(created_item + " " + i);
            item_page_object.click_on_save_button();
        }

        item_page_object.return_to_item_list_page();
    }


    @When("user select number of  items")
    public void user_select_number_of_items() throws InterruptedException {
        items_list_page_object.click_on_500_navigation_bar();
        items_list_page_object.scroll_to_top();
        items_list_page_object.click_on_update_icon();
        items_list_page_object.scroll_down();
        items_list_page_object.waiting(15000);
        items_list_page_object.scroll_to_top();
        items_list_page_object.click_on_update_icon();
        items_list_page_object.scroll_down();
        items_list_page_object.waiting(15000);


        for (int i = 0; i <= 1; i++) {
            items_list_page_object.click_on_entire_checkbox_of_items(i);
            System.out.println(items_list_page_object.get_item_name_in_row(i).getText() + " is created successfully");
        }
        items_list_page_object.wait_elememt_to_be_selected(items_list_page_object.get_entire_checkboxes_in_sales_invoices_list(1));
        items_list_page_object.scroll_to_top();
    }

    @When("user delete all selected items")
    public void user_delete_all_selected_items() {
        first_shown_item_name = items_list_page_object.get_first_shown_item_name_before_any_process();
        items_list_page_object.click_on_delete_button();
        items_list_page_object.click_on_accept_button();
    }

    @Then("all items should be deleted successfully and no error message will be appeared")
    public void all_items_should_be_deleted_successfully_and_no_error_message_will_be_appeared() {
        items_list_page_object.waiting_for_text_not_to_be_visible_in_element(By.
                xpath("(//div[@class='result-list']//div[@class='list-row']//a)[1]"), first_shown_item_name);
        System.out.println(first_shown_item_name + " this item is deleted now");
    }

    @Given("user login successfully and open setup page")
    public void login_successfully_and_open_setup_page() {
        driver.get(vm_link);
        // driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(), vm_link);
        loginPageObject = new LoginPage(driver);
        homePageObject = new HomePage(driver);
        homePageObject = loginPageObject.login_with_valid_data(not_pos_user, password);
        homePageObject.close_window();
        Assert.assertTrue(homePageObject.get_dashboard_header_element().isDisplayed());
        setup_page_object = homePageObject.open_setup_page();
        Assert.assertTrue(setup_page_object.get_setup_header().isDisplayed());
    }

    @When("user open data import page")
    public void open_data_import_page() {
        data_import_page_object = setup_page_object.open_data_import_page();
        Assert.assertTrue(data_import_page_object.get_data_import_tool_header().isDisplayed());
    }

    @When("user upload file contains sales invoices  {string}")
    public void upload_file_contains__sales_invoices(String file_path) {

        data_import_page_object.scroll_down();
        data_import_page_object.upload_file(file_path);
        data_import_page_object.click_on_import_button();
        System.out.println(file_path);

    }

    @When("user upload file contains items {string}")
    public void upload_file_contains_items(String file_path) {

        data_import_page_object.scroll_down();
        data_import_page_object.upload_file(file_path);
        data_import_page_object.click_on_import_button();
        System.out.println(file_path);

    }

    @When("user click on adding to waiting list button")
    public void user_click_on_adding_to_waiting_list_button() {
        data_import_page_object.click_on_adding_to_waiting_list_button();
    }

    @When("user click on wait until finish button")
    public void user_click_on_wait_until_finish_button() {
        data_import_page_object.click_on_wait_until_finish_button();

    }

    @Then("unsuccessful importing and  error message should appear tell user what is error")
    public void unsuccessful_importing_and_error_message_should_appear_tell_user_what_is_error() {

        data_import_page_object.close_window();
        data_import_page_object.close_window();
        data_import_page_object.scroll_down();
        Assert.assertTrue(data_import_page_object.get_importing_message_element().isDisplayed());
        System.out.println(data_import_page_object.get_importing_message_element().getText());
        Assert.assertEquals("Import Failed!",
                data_import_page_object.get_importing_message_element().getText());
    }

    @Given("user open new sales invoice")
    public void open_new_sales_invoice() {
        sales_invoice_page_object = sales_invoices_list_Page_object.open_new_sales_invoice();
    }

    @Then("successful importing and no error message appear")
    public void successful_importing_and_no_error_message_appear() {

        data_import_page_object.close_window();
        data_import_page_object.scroll_down();
        Assert.assertTrue(data_import_page_object.get_importing_message_element().isDisplayed());
        System.out.println(data_import_page_object.get_importing_message_element().getText());
        Assert.assertEquals("Import Successful!",
                data_import_page_object.get_importing_message_element().getText());
    }

    @Then("message appear say recieved done then alert appear say process done")
    public void message_appear_say_recieved_done_then_alert_appear_say_importing_done() {
        Assert.assertTrue(data_import_page_object.get_receiving_message_element().isDisplayed());
        data_import_page_object.close_window();
        data_import_page_object.scroll_down();
        date_before_enqueue = data_import_page_object.get_date_in_table().getText();
        System.out.println("this date before enqueue " + data_import_page_object.get_date_in_table().getText());
        data_import_page_object.waiting_for_element_to_be_visible(data_import_page_object.get_alert_notification());
        data_import_page_object.wait_alert_to_be_invisible_then_scroll();

    }

    @Then("warning message will appear in table indicates that there is an error")
    public void warning_message_will_appear_in_table_indicates_that_there_is_an_error() {
        data_import_page_object.waiting_for_text_not_to_be_in_element
                (data_import_page_object.get_date_in_table(), date_before_enqueue);
        System.out.println("this date after enqueue " + data_import_page_object.get_date_in_table().getText());
        Assert.assertEquals("تم استيراد البيانات بنجاح، ولكن بعض الصفوف لم تستورد. لمزيد من التفاصيل انقر هنا.",
                data_import_page_object.get_message_element_in_table().getText());
        System.out.println(data_import_page_object.get_message_element_in_table().getText());
        Assert.assertTrue(data_import_page_object.get_first_row_in_table_table().getText().
                contains(data_import_page_object.get_message_element_in_table().getText()));
    }

    @Given("message will appear in table indicates that importing is successful")
    public void message_will_appear_in_table_indicates_that_importing_is_successful() {
        data_import_page_object.waiting_for_text_not_to_be_in_element
                (data_import_page_object.get_date_in_table(), date_before_enqueue);
        System.out.println("this date after enqueue " + data_import_page_object.get_date_in_table().getText());
        Assert.assertEquals("تم استيراد البيانات بنجاح. لمزيد من التفاصيل انقر هنا.",
                data_import_page_object.get_message_element_in_table().getText());
        System.out.println(data_import_page_object.get_message_element_in_table().getText());
        Assert.assertTrue(data_import_page_object.get_first_row_in_table_table().getText().
                contains(data_import_page_object.get_message_element_in_table().getText()));
    }

    @Given("message will appear in table indicates that exporting is successful")
    public void message_will_appear_in_table_indicates_that_exporting_is_successful() {
        data_import_page_object.waiting_for_text_not_to_be_in_element
                (data_import_page_object.get_date_in_table(), date_before_enqueue);
        System.out.println("this date after enqueue " + data_import_page_object.get_date_in_table().getText());
        Assert.assertEquals("تم تصدير البيانات بنجاح. الرجاء النقر هنا لتحميل البيانات.",
                data_import_page_object.get_message_element_in_table().getText());
        System.out.println(data_import_page_object.get_message_element_in_table().getText());
        Assert.assertTrue(data_import_page_object.get_first_row_in_table_table().getText().
                contains(data_import_page_object.get_message_element_in_table().getText()));
    }

    @When("user select doctype to export {string}")
    public void user_select_doctype_to_export(String doctype) {
        data_import_page_object.select_doctype(doctype);
        System.out.println("the exported doctype is " + doctype);
    }

    @When("user download main table with data")
    public void download_main_table_with_data() {
        data_import_page_object.download_main_table_with_data();
    }

    @Then("Doctype should be exported successfully")
    public void doctype_should_be_exported_successfully() {

    }

    @Then("all sales invoices should be submitted successfully and a notifications appear tell user that")
    public void all_sales_invoices_should_be_submitted_successfully_and_a_notifications_appear_tell_user_that() throws Exception, TimeoutException {
        sales_invoices_list_Page_object.get_submitting_in_process_message();
        sales_invoices_list_Page_object.close_and_scroll();
        // sales_invoices_list_Page_object.waiting_for_element_to_be_visible(By.xpath(icon_locator), "class", enqueue_class_name);
        for (int i = 0; i <= 1; i++) {
            sales_invoices_list_Page_object.waiting_for_element_to_be_visible(i, By.xpath(icon_locator), "class", enqueue_class_name);
            if (sales_invoices_list_Page_object.get_icon_element_in_row(i).getAttribute("class").contains(enqueue_class_name)
                    && sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getAttribute("style").contains(blue_color)) {
                System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getText() + " in enqueue now");
            } else
                System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getText() + " returned from enqueue");
        }

        for (int i = 0; i <= 1; i++) {
            sales_invoices_list_Page_object.waiting_for_element_to_be_invisible(i, By.xpath(icon_locator), "class", enqueue_class_name);
            if (sales_invoices_list_Page_object.get_icon_element_in_row(i).getAttribute("class").contains(saved_class_name) &&
                    sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getAttribute("style").contains(red_color)) {
                Assert.assertTrue(sales_invoices_list_Page_object.get_saved_icon_in_row(i).isDisplayed());
                System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getText() +
                        " not submitted successfully and there is an error");

            } else if (sales_invoices_list_Page_object.get_icon_element_in_row(i).getAttribute("class").contains(submitted_class_name)
                    || !sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getAttribute("style").contains(red_color)
                    || !sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getAttribute("style").contains(blue_color)) {
                Assert.assertTrue(sales_invoices_list_Page_object.get_submitted_icon_in_row(i).isDisplayed());
                System.out.println(sales_invoices_list_Page_object.get_invoice_id_in_row_after_action(i).getText()
                        + " submitted successfully and no error");
            } else
                System.out.println(" result not as expected");
        }
    }

    @Then("created sales invoice affect on account statement report \\(paid invoice)")
    public void paid_sales_invoice_affect_on_account_statement_report() {
        reports_page_object = general_ledger_page_object.open_reports_page();
        account_statement_report_page_object = reports_page_object.open_account_statement_report();
        account_statement_report_page_object.clear_cash();
        account_statement_report_page_object.close_window();
        account_statement_report_page_object.click_on_load_data_after_enter_client_name(client_name);
        account_statement_report_page_object.search_with_invoice_id(invoice_id);
        System.out.println("the sales invoice appear in account statement report number of times = "
                + account_statement_report_page_object.rows_number());
        for (int i = 0; i < account_statement_report_page_object.rows_number(); i++) {
            if (account_statement_report_page_object.voucher_number_in_account_statement_report(i).getText().contains(invoice_id)
                    && account_statement_report_page_object.debit_in_account_statement_report(i).contains(total_amount)) {
                System.out.println("the debit on client according to this invoice " + invoice_id +
                        " in account statement report is the same as the total amount of this invoice and this is correct");
            } else if (account_statement_report_page_object.voucher_number_in_account_statement_report(i).getText().contains(invoice_id)
                    && account_statement_report_page_object.credit_in_account_statement_report(i).contains(total_amount)) {
                System.out.println("the credit on client according to this invoice " + invoice_id +
                        " in account statement report is the same as the total amount of this invoice and this is correct");
            } else {
                System.out.println("there is something wrong");
            }
        }
        System.out.println("this invoice " + invoice_id +
                " for this client " + client_name + " appear in account statement report twice (first one as debit and second one as credit with the total amount of this invoice");
        account_statement_report_page_object.click_on_load_data_without_entries();
        total_debit_after_invoice = account_statement_report_page_object.total_debit_in_account_statement_report();
        System.out.println("the total debit on " + client_namee + " after creating new invoice is  " + total_debit_after_invoice);

        if (total_debit_before_invoice.contains(total_debit_after_invoice)) {
            System.out.println("this is (paid invoice) and total debit on client " + client_name +
                    " before and after creating invoice is the same and this is correct");
        } else {
            System.out.println("this is (paid invoice) and total debit on client " + client_name +
                    " before and after creating invoice not the same and this is wrong!!!!!!!!!!");
        }
    }

    @Then("created sales invoice affect on account statement report \\(unpaid invoice)")
    public void unpaid_sales_invoice_affect_on_account_statement_report() throws InterruptedException {
        reports_page_object = general_ledger_page_object.open_reports_page();

        account_statement_report_page_object = reports_page_object.open_account_statement_report();
        account_statement_report_page_object.clear_cash();
        account_statement_report_page_object.close_window();
        account_statement_report_page_object.click_on_load_data_after_enter_client_name(client_name);
        account_statement_report_page_object.search_with_invoice_id(invoice_id);
        System.out.println("the sales invoice appear in account statement report number of times = "
                + account_statement_report_page_object.rows_number());
        for (int i = 0; i < account_statement_report_page_object.rows_number(); i++) {
            if (account_statement_report_page_object.voucher_number_in_account_statement_report(i).getText().contains(invoice_id)
                    && account_statement_report_page_object.debit_in_account_statement_report(i).contains(total_amount)) {
                System.out.println("the debit on client according to this invoice " + invoice_id +
                        " in account statement report is the same as the total amount of this invoice and this is correct");
            } else {
                System.out.println("there is something wrong");
            }
        }
        System.out.println("this invoice " + invoice_id +
                " for this client " + client_name + " appear in account statement report once (as debit with the total amount of this invoice");
        account_statement_report_page_object.click_on_load_data_without_entries();

        total_debit_after_invoice = account_statement_report_page_object.total_debit_in_account_statement_report();
        System.out.println("the total debit on " + client_namee + " after creating new invoice is  " + total_debit_after_invoice);

        if (!total_debit_after_invoice.contains(total_debit_before_invoice)) {
            System.out.println("this is (unpaid invoice) and total debit on client " + client_name + " after creating invoice is greater than total debit before creating invoice and this is correct");
        } else {
            System.out.println("this is (unpaid invoice) and total debit on client " + client_name + " after creating invoice less or equal total debit before creating invoice and this is wrong !!!!!!!");

        }
    }

    @When("user open account statement report and get current data")
    public void user_open_account_statement_report_and_get_current_data() throws InterruptedException {
        homePageObject.close_window();
        reports_page_object = homePageObject.open_reports_page();
        account_statement_report_page_object = reports_page_object.open_account_statement_report();
        account_statement_report_page_object.click_on_load_data_before(client_namee);
        total_debit_before_invoice = account_statement_report_page_object.total_debit_in_account_statement_report();
        System.out.println("the total debit on " + client_namee + " before creating new invoice is  " + total_debit_before_invoice);
        homePageObject = account_statement_report_page_object.return_to_homepage();
        homePageObject.clear_cash();
        homePageObject.close_window();
    }
}
