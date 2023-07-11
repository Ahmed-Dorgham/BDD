package StepDefinition.SubmitSalesInvoice_PositiveCase;

import Pages.*;
import TestBase.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SubmitSalesInvoice_PositiveCase extends TestBase {

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
    private String total_incomes_before_invoice;
    private String total_profit_loss_before_invoice;
    private String total_debit_after_invoice;
    private String total_incomes_after_invoice;
    private String total_profit_loss_after_invoice;
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
    private FinancialStatementsReportPage financial_statements_report_page_object;
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

    @When("user verify that POS invoice CheckBox is checked and add items to sales invoice")
    public void verify_that_pos_invoice_check_box_is_checked_and_add_items_to_sales_invoice() throws InterruptedException {
        Assert.assertTrue(sales_invoice_page_object.get_pos_invoice_checkbox_element().isSelected());
        sales_invoice_page_object.add_item_to_Sale_invoice(stock_item);
    }

    @When("user login successfully with valid credentials \\( POS user)")
    public void user_login_successfully_pos_user() {
        loginPageObject = new LoginPage(driver);
        homePageObject = new HomePage(driver);
        homePageObject = loginPageObject.login_with_valid_data(pos_user, pos_password);
        Assert.assertTrue(homePageObject.get_dashboard_header_element().isDisplayed());
    }

    @When("user uncheck Update Stock CheckBox and verify that then submit sales invoice")
    public void uncheck_update_stock_check_box_and_verify_that_then_submit_sales_invoice() {
        sales_invoice_page_object.scroll_down_and_wait();
        sales_invoice_page_object.click_on_update_stock_checkbox_element();
        Assert.assertFalse(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
        sales_invoice_page_object.click_on_save_and_submit_button();
        sales_invoice_page_object.click_on_accept_button();
    }

    @When("user verify that  Update Stock CheckBox is checked then submit sales invoice")
    public void verify_that_update_stock_check_box_is_checked_then_submit_sales_invoice() {
        sales_invoice_page_object.scroll_down_and_wait();
        //sales_invoice_page_object.click_on_update_stock_checkbox_element();
        Assert.assertTrue(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
        sales_invoice_page_object.click_on_save_and_submit_button();
        sales_invoice_page_object.click_on_accept_button();
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
    @When("user open financial statements report and get current data")
    public void user_open_financial_statements_report_and_get_current_data() throws InterruptedException {
       //homePageObject.close_window();
        reports_page_object = homePageObject.open_reports_page();
        financial_statements_report_page_object = reports_page_object.open_financial_statements_report();
        financial_statements_report_page_object.clear_cash();
        financial_statements_report_page_object.waiting_for_element_to_be_visible(By.xpath
                ("//button[@id='appframe-btn-طباعة']"));
        financial_statements_report_page_object.enter_all_data_using_filters();
        financial_statements_report_page_object.click_on_create_button();
        total_incomes_before_invoice=financial_statements_report_page_object.incomes_in_financial_statements_report();
        total_profit_loss_before_invoice= financial_statements_report_page_object.profit_loss_in_financial_statements_report();
        System.out.println("the total incomes before creating new invoice is  " + total_incomes_before_invoice);
        System.out.println("the total profit & loss before creating new invoice is  " + total_profit_loss_before_invoice);
        homePageObject = financial_statements_report_page_object.return_to_homepage();
        homePageObject.clear_cash();
        homePageObject.close_window();




    /*    account_statement_report_page_object.click_on_load_data_before(client_namee);
        total_debit_before_invoice = account_statement_report_page_object.total_debit_in_account_statement_report();
        System.out.println("the total debit on " + client_namee + " before creating new invoice is  " + total_debit_before_invoice);
        homePageObject = account_statement_report_page_object.return_to_homepage();
        homePageObject.clear_cash();
        homePageObject.close_window();*/
    }
    @When("user enter mandatory fields in sales invoice \\( client - item - series naming )")
    public void enter_mandatory_fields_in_sales_invoice() throws InterruptedException {
        sales_invoice_page_object.create_sales_invoice_with_all_mandatory_ui_fields(stock_item);
    }

    @When("user verify that  Update Stock CheckBox is unchecked then submit sales invoice")
    public void verify_that_update_stock_check_box_is_unchecked_then_submit_sales_invoice() {
        sales_invoice_page_object.get_update_stock_checkBox_element();
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

    @When("user open sales invoice list and open new sales invoice")
    public void open_sales_invoice_list_and_open_new_sales_invoice() {
        sales_invoices_list_Page_object = homePageObject.open_sales_invoices_list_page();

        sales_invoice_page_object = sales_invoices_list_Page_object.open_new_sales_invoice();
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

    @When("user verify that Update Stock CheckBox is unchecked then submit sales invoice")
    public void user_verify_that_Update_Stock_CheckBox_is_unchecked_then_submit_sales_invoice() {
        sales_invoice_page_object.scroll_down_and_wait();
        //sales_invoice_page_object.click_on_update_stock_checkbox_element();
        Assert.assertFalse(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
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

    @Then("created sales invoice affect on account statement report \\(unpaid invoice)")
    public void unpaid_sales_invoice_affect_on_account_statement_report() throws InterruptedException {
        reports_page_object = general_ledger_page_object.open_reports_page();

        account_statement_report_page_object = reports_page_object.open_account_statement_report();
        account_statement_report_page_object.waiting_for_element_to_be_visible(By.xpath
                ("//button[@id='appframe-btn-طباعة']"));
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
                System.out.println("there is something wrong!!!!!!!!!!!!!!!!");
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
            System.out.println("there is something wrong!!!!!!!!!!!!!!!!");
            System.out.println("this is (unpaid invoice) and total debit on client " + client_name + " after creating invoice less or equal total debit before creating invoice and this is wrong !!!!!!!");

        }
    }
    @Then("created sales invoice affect on financial statements report")
    public void sales_invoice_affect_on_financial_statements_report() throws InterruptedException {
        homePageObject = financial_statements_report_page_object.return_to_homepage();
        homePageObject.clear_cash();
        homePageObject.close_window();
        reports_page_object = homePageObject.open_reports_page();
        financial_statements_report_page_object = reports_page_object.open_financial_statements_report();
        financial_statements_report_page_object.clear_cash();
        financial_statements_report_page_object.waiting_for_element_to_be_visible(By.xpath
                ("//button[@id='appframe-btn-طباعة']"));
        financial_statements_report_page_object.enter_all_data_using_filters();
        financial_statements_report_page_object.click_on_create_button();
        total_incomes_after_invoice=financial_statements_report_page_object.incomes_in_financial_statements_report();
        total_profit_loss_after_invoice= financial_statements_report_page_object.profit_loss_in_financial_statements_report();
        System.out.println("the total incomes after creating new invoice is  " + total_incomes_after_invoice);
        System.out.println("the total profit & loss after creating new invoice is  " + total_profit_loss_after_invoice);


            if (!financial_statements_report_page_object.incomes_in_financial_statements_report().contains(total_incomes_before_invoice)) {
                System.out.println("the sales invoice affect on the financial statememnts report" );

            } else {
                System.out.println("there is something wrong!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
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
                System.out.println("there is something wrong!!!!!!!!!!!!!!!!!!!");
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
            System.out.println("there is something wrong!!!!!!!!!!!!!!!!!!!");
            System.out.println("this is (paid invoice) and total debit on client " + client_name +
                    " before and after creating invoice not the same and this is wrong!!!!!!!!!!");
        }
    }


}
