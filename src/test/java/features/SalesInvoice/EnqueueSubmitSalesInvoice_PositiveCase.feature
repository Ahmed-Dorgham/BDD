Feature: Submit Sales Invoice (Positive Case) (With Enqueue)


  Background:

    Given user login successfully and open sales invoice list page
    And user create sales invoice and save it

  Scenario: user can submit sales invoice

    When user submit sales invoice
    Then sales invoice should be submitted successfully and a notification appear tell user that



