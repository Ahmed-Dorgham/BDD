Feature:  Cancel Action On Bulk Sales Invoices

  Background:
    Given user login sucessfully and open sales invoice list page

  Scenario: Bulk Cancel N Sales Invoice (submitted or drafts invoices)(without error)

    When user create bulk of sales invoices and submit it
    And user select number of sales invoices
    And user cancel all selected sales invoices
    Then all sales invoices should be canceled successfully and no error message will be appeared