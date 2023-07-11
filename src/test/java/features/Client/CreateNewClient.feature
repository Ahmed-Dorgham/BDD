Feature: Create New Client

  Background:
    Given user in dafater login page
    And user login successfully with valid credentials
    And user open clients list and open new client doc

  Scenario: user can create client (individual)

    When user enter mandatory fields in client doc
    Then client created successfully

  Scenario: user can create client (company)

    When user enter mandatory fields in client doc with address
    When user enter address
    Then client created successfully with address