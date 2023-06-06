Feature: Export DocType With Large Data

  Background:
    Given user login successfully and open setup page

  Scenario Outline: Export DocType With Large Data

    When user open data import page
    And user select doctype to export "<doctype>"
    And user download main table with data
    And user click on wait until finish button
    Then Doctype should be exported successfully
    Examples:
      | doctype       |
      | صنف           |
      | فاتورة مبيعات |