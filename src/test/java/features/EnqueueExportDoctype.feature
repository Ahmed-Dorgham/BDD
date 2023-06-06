Feature:  Export DocType With Large Data With Enqueue

  Background:
    Given user login successfully and open setup page

  Scenario Outline: Export DocType With Large Data

    When user open data import page
    And user select doctype to export "<doctype>"
    And user download main table with data
    And user click on adding to waiting list button
    Then message appear say recieved done then alert appear say process done
    And message will appear in table indicates that exporting is successful
    Examples:
      | doctype       |
      | صنف           |
      | فاتورة مبيعات |