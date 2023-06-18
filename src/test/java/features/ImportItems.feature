Feature: Import Large Number of items

  Background:
    Given user login successfully and open setup page

  Scenario Outline: Import large number of items (valid & not valid Data)

    When user open data import page
    And user upload file contains items "<file_path>"
    And user click on wait until finish button
    Then unsuccessful importing and  error message should appear tell user what is error

    Examples:
      | file_path                                                                     |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\not_valid\\1000.xlsx |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\not_valid\\2000.xlsx |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\not_valid\\5000.xlsx |

  Scenario Outline: Import large number of items (valid data only)

    When user open data import page
    And user upload file contains items "<file_path>"
    And user click on wait until finish button
    Then successful importing and no error message appear

    Examples:
      | file_path                                                                       |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\valid\\1000_Valid.xlsx |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\valid\\2000_Valid.xlsx |
      | C:\\Users\\ahmed\\OneDrive\\Desktop\\performance\\files\\valid\\5000_Valid.xlsx |