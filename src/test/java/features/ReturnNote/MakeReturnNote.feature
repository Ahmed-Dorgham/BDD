Feature: Make Return Note
  Background:
    Given user in dafater login page
    And user create sales invoice and submit it
  Scenario: create return note (through sales invoice)

    When user click on make return note
    When user enter mandatory fields in return note and submit it
    Then return note should be submitted successfully
    And status of sales invoice should be returned

  Scenario: create return note (through return note itself)

    When user open return note list and open new return note
    When user select sales invoice to make return note and submit return note
    Then return note should be submitted successfully
    And status of sales invoice should be returned