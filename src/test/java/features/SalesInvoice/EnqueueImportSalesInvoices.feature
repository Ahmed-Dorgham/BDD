Feature: Import Large Number of Sales Invoices With Enqueue

  Background:
    Given user login successfully and open setup page

  Scenario Outline: Import large number of Sales Invoices (valid & not valid Data)

    When user open data import page
    And user upload file contains sales invoices  "<file_path>"
    And user click on adding to waiting list button
    Then message appear say recieved done then alert appear say process done
    And warning message will appear in table indicates that there is an error

    Examples:
      | file_path                                                          |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\not_valid_invoice\\sales_invoices.xlsx |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\not_valid_invoice\\sales_invoices.xlsx |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\not_valid_invoice\\sales_invoices.xlsx |
@Skip
  Scenario Outline: Import large number of Sales Invoices (valid data only)

    When user open data import page
    And user upload file contains sales invoices  "<file_path>"
    And user click on adding to waiting list button
    Then message appear say recieved done then alert appear say process done
    And message will appear in table indicates that importing is successful

    Examples:
      | file_path                                                                |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\valid_invoice\\1000.csv |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\valid_invoice\\1000.csv |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\valid_invoice\\1000.csv |