Feature: Delete Action On Bulk Items

  Background:
    Given user login sucessfully and open items list page
    And user create bulk of items and save it

  Scenario: Bulk delete N items

    When user select number of  items
    And user delete all selected items
    Then all items should be deleted successfully and no error message will be appeared