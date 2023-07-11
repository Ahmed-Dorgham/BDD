package StepDefinition.MakeReceiptVoucher;

import Pages.*;
import TestBase.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MakeReceiptVoucher extends TestBase {
    String invoice_name_after_submitting;
    String total_amount;
    String client_name;
    String client_namee = "عميل نقدي";
    String invoice_id;
    //String file_path = "C:\\Users\\ahmed\\OneDrive\\Desktop\\Item (1).xlsx";
    //  private String vm_link = "https://engineering-dorgham.dafater.biz/index.html";
    String invoiceNameAfterSubmitting;
    String return_note_after_Submitting;
    String receipt_voucher_after_Submitting;
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
    private ReceiptVoucherssListPage receipt_vouchers_list_page_object;
    private ItemsListPage items_list_page_object;
    private ItemPage item_page_object;
    private GeneralLedgerPage general_ledger_page_object;
    private ReportsPage reports_page_object;
    private AccountStatementReportPage account_statement_report_page_object;
    private FinancialStatementsReportPage financial_statements_report_page_object;
    private SalesInvoicePage sales_invoice_page_object;
    //private ReturnNotePage receipt_vouchers_list_page_object;
    private ReceiptVoucherPage receipt_voucher_page_object;
    private DataImportPage data_import_page_object;

    @Given("user in dafater login page")
    public void open_login_page() {

        driver.get(vm_link);
        // driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(), vm_link);
    }

    @When("user create sales invoice and submit it")
    public void user_create_sales_invoice_and_submit_it() throws InterruptedException {
        loginPageObject = new LoginPage(driver);
        homePageObject = new HomePage(driver);
        homePageObject = loginPageObject.login_with_valid_data(not_pos_user, password);
        Assert.assertTrue(homePageObject.get_dashboard_header_element().isDisplayed());
        sales_invoices_list_Page_object = homePageObject.open_sales_invoices_list_page();
        sales_invoice_page_object = sales_invoices_list_Page_object.open_new_sales_invoice();
        sales_invoice_page_object.create_sales_invoice_with_all_mandatory_ui_fields(stock_item);
        sales_invoice_page_object.get_update_stock_checkBox_element();
        Assert.assertFalse(sales_invoice_page_object.get_update_stock_checkBox_element().isSelected());
        sales_invoice_page_object.click_on_save_and_submit_button();
        sales_invoice_page_object.click_on_accept_button();
        sales_invoice_page_object.close_window();
        invoiceNameAfterSubmitting = sales_invoice_page_object.get_invoice_id_name();
        Assert.assertTrue(invoiceNameAfterSubmitting.contains("INV"));
        System.out.println("the ID of submitted sales invoice is  " + sales_invoice_page_object.get_invoice_id_name());
        sales_invoice_page_object.scroll_down();
        total_amount = sales_invoice_page_object.total_amount().getText();
        sales_invoice_page_object.scroll_up();
        client_name = sales_invoice_page_object.client_name().getText();
        invoice_id = sales_invoice_page_object.get_invoice_id_name();

    }

    @When("user click on make payment entry")
    public void user_click_on_make_payment_entry() {
        receipt_voucher_page_object = sales_invoice_page_object.click_on_make_paymen_entry();
    }

    @When("user enter mandatory fields in receipt voucher and submit it")
    public void user_enter_mandatory_fields_in_receipt_voucher_and_submit_it() throws InterruptedException {
        receipt_voucher_page_object.create_receipt_voucher_with_all_mandatory_ui_fields_without_client();
        receipt_voucher_page_object.click_on_save_and_submit_button();
        receipt_voucher_page_object.click_on_accept_button();


    }

    @Then("receipt voucher should be submitted successfully")
    public void receipt_voucher_should_be_submitted_successfully() {

        receipt_voucher_after_Submitting = receipt_voucher_page_object.get_receipt_voucher_id_name();
        Assert.assertTrue(receipt_voucher_after_Submitting.contains("CRV"));
        System.out.println("the ID of submitted receipt voucher is  " + receipt_voucher_page_object.get_receipt_voucher_id_name());

    }

    @Then("status of sales invoice should be paid")
    public void status_of_sales_invoice_should_be_paid() throws InterruptedException {
        sales_invoice_page_object = receipt_voucher_page_object.click_on_invoice_id();
        sales_invoice_page_object.refersh_page();
        Assert.assertTrue(sales_invoice_page_object.get_returned_amount_element().getText().contains("100% مدفوع"));
        System.out.println("the " + invoiceNameAfterSubmitting + " is completely paid with this receipt voucher " + receipt_voucher_after_Submitting);
    }

    @Then("status of selected sales invoice should be paid")
    public void status_of_selected_sales_invoice_should_be_paid() throws InterruptedException {
        sales_invoices_list_Page_object = receipt_voucher_page_object.open_sales_invoices_list_page();
        sales_invoices_list_Page_object.refersh_page();
        sales_invoice_page_object = sales_invoices_list_Page_object.open_paid_invoice();
        Assert.assertTrue(sales_invoice_page_object.get_returned_amount_element().getText().contains("100% مدفوع"));
       System.out.println("the " + invoiceNameAfterSubmitting + " is completely paid with this receipt voucher " + receipt_voucher_after_Submitting);
    }

    @When("user open receipt vouchers list and open new receipt voucher")
    public void open_receipt_vouchers_list_and_open_new_receipt_voucher() {
        receipt_vouchers_list_page_object = sales_invoice_page_object.open_receipt_vouchers_list_page();
        receipt_vouchers_list_page_object.refersh_page();
        receipt_voucher_page_object = receipt_vouchers_list_page_object.open_new_receipt_voucher();
    }

    @When("user select sales invoice to make receipt voucher and submit receipt voucher")
    public void select_sales_invoice_to_make_receipt_voucher_and_submit_receipt_voucher() throws InterruptedException {
        receipt_voucher_page_object.create_receipt_voucher_with_all_mandatory_ui_fields_using_client();
//        receipt_voucher_page_object.select_sales_invoice();
        receipt_voucher_page_object.click_on_save_and_submit_button();
        receipt_voucher_page_object.click_on_accept_button();
    }
}
