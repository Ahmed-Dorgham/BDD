Feature:  Submit Action On Bulk Sales Invoices

  Background:
    Given user login successfully and open sales invoice list page
    And user create bulk of sales invoices and save it

  Scenario: Bulk Submit N Sales Invoice (without error)

    When user select number of sales invoices
    And user submit all selected sales invoices
    Then all sales invoices should be submitted successfully and no error message will be appeared
  @Skip
  Scenario: Bulk Submit N Sales Invoice (with error)

    When user create bulk of sales invoices with error and save it
    And user select number of sales invoices (with error)
    And user submit all selected sales invoices
    Then some invoices shouldn't be submitted successfully and error message will be appeared to tell user that

















