Feature: Submit Sales Invoice (Error Handling)

  Background:
    Given user in dafater login page

  Scenario: user can't submit sales invoice (using save and submit button ) ( POS invoice ) ( with update stock ) ( from delivery note)

    When user login successfully with valid credentials ( POS user)
    And user open sales invoice list and open new sales invoice
    And user verify that POS invoice CheckBox is checked and use delivery note to create sales invoice
    And user verify that  Update Stock CheckBox is checked then submit sales invoice
    Then sales invoice not created successfully and validation message appear (Stock update can not be made against Delivery Note)

  Scenario: user can't submit sales invoice (no stock in warehouse ) (using save and submit button ) ( not POS invoice )

    When user login successfully with valid credentials
    And user open sales invoice list and open new sales invoice
    And user enter mandatory fields in sales invoice ( client - non stock item - series naming )
    And user click on Update Stock CheckBox then submit sales invoice
    Then sales invoice not created successfully and validation message appear (Negative stock error)







