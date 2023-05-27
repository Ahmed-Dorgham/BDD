Feature: Enqueue Submit Sales Invoice (Positive Case)


  Background:

    Given user login sucessfully and open sales invoice list page
    And user create sales invoice and save it

  Scenario: user can submit sales invoice

    When user submit sales invoice
    Then sales invoice should be submitted successfully and a notification should be increased



