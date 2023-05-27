Feature: Delete Action On Bulk Sales Invoices

  Background:
    Given user login sucessfully and open sales invoice list page
    And user create bulk of sales invoices and save it

  Scenario: Bulk delete N Sales Invoice (draft invoices only )

    When user select number of sales invoices
    And user delete all selected sales invoices
    Then all sales invoices should be deleted successfully and no error message will be appeared

  Scenario: Bulk delete N Sales Invoice (draft & submitted)

    When user create bulk of sales invoices and submit it
    And user select number of sales invoices (draft & submitted)
    And user delete all selected sales invoices
    Then some or all sales invoices shouldn't be deleted successfully and others should be deleted successfully