Feature: Import Large Number of Sales Invoices

  Background:
    Given user login successfully and open setup page

  Scenario Outline: Import large number of  Sales Invoices  (valid & not valid Data)

    When user open data import page
    And user upload file contains sales invoices  "<file_path>"
    And user click on wait until finish button
    Then unsuccessful importing and  error message should appear tell user what is error

    Examples:
      | file_path                                                                     |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\not_valid_invoice\\sales_invoices.xlsx |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\not_valid_invoice\\sales_invoices.xlsx |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\not_valid_invoice\\sales_invoices.xlsx |


  @Skip
  Scenario Outline: Import large number of  Sales Invoices  (valid data only)

    When user open data import page
    And user upload file contains sales invoices  "<file_path>"
    And user click on wait until finish button
    Then successful importing and no error message appear

    Examples:
      | file_path                                                                           |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\valid_invoice\\sales_invoices.xlsx |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\valid_invoice\\sales_invoices.xlsx |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\valid_invoice\\sales_invoices.xlsx |
