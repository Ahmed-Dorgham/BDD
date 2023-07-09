Feature: Submit Sales Invoice (Error Handling) (With Enqueue)

  Background:

    Given user login successfully and open sales invoice list page
    And user open new sales invoice

  Scenario: user can't submit sales invoice

    When user enter mandatory fields in sales invoice ( client - non stock item - series naming )
    And user click on Update Stock CheckBox then submit sales invoice
    Then sales invoice not submitted successfully and a notification appear tell user that



