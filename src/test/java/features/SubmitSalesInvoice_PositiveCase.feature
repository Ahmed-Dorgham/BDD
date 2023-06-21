Feature: Submit Sales Invoice (Positive Case)

  Background:
    Given user in dafater login page
  @Skip
  Scenario: user can submit sales invoice (using save and submit button ) (without update stock) ( not POS invoice )

    When user login successfully with valid credentials
    And user open sales invoice list and open new sales invoice
    And user enter mandatory fields in sales invoice ( client - item - series naming )
    And user verify that  Update Stock CheckBox is unchecked then submit sales invoice
    Then sales invoice created successfully with it's unique ID
    And sales invoice appear in general ledger and stock account not appear

  Scenario: user can submit sales invoice (using save and submit button ) (with update stock) ( not POS invoice )

    When user login successfully with valid credentials
    And user open sales invoice list and open new sales invoice
    And user enter mandatory fields in sales invoice ( client - item - series naming )
    And user click on Update Stock CheckBox then submit sales invoice
    Then sales invoice created successfully with it's unique ID
    And sales invoice appear in general ledger and stock account appear
  @Skip
  Scenario: user can submit sales invoice (using save and submit button ) ( POS invoice ) ( with update stock )

    When user login successfully with valid credentials ( POS user)
    And user open sales invoice list and open new sales invoice
    And user verify that POS invoice CheckBox is checked and add items to sales invoice
    And user verify that  Update Stock CheckBox is checked then submit sales invoice
    Then sales invoice created successfully with it's unique ID
    And sales invoice appear in general ledger and stock account appear
  @Skip
  Scenario: user can submit sales invoice (using save and submit button ) ( POS invoice ) ( without update stock )

    When user login successfully with valid credentials ( POS user)
    And user open sales invoice list and open new sales invoice
    And user verify that POS invoice CheckBox is checked and add items to sales invoice
    And user uncheck Update Stock CheckBox and verify that then submit sales invoice
    Then sales invoice created successfully with it's unique ID
    And sales invoice appear in general ledger and stock account not appear
  @Skip
  Scenario: user can submit sales invoice (using save and submit button ) ( POS invoice ) ( without update stock ) ( from delivery note )

    When user login successfully with valid credentials ( POS user)
    And user open sales invoice list and open new sales invoice
    And user verify that POS invoice CheckBox is checked and use delivery note to create sales invoice
    And user uncheck Update Stock CheckBox and verify that then submit sales invoice
    Then sales invoice created successfully with it's unique ID
    And sales invoice appear in general ledger and stock account not appear
  @Skip
  Scenario: user can submit sales invoice (using save and submit button ) ( POS invoice ) ( with update stock ) ( from sales order )

    When user login successfully with valid credentials ( POS user)
    And user open sales invoice list and open new sales invoice
    And user verify that POS invoice CheckBox is checked and use sales order to create sales invoice
    And user verify that  Update Stock CheckBox is checked then submit sales invoice
    Then sales invoice created successfully with it's unique ID
    And sales invoice appear in general ledger and stock account appear
  @Skip
  Scenario: user can submit sales invoice (using save and submit button ) ( POS invoice ) ( without update stock ) ( from sales order )

    When user login successfully with valid credentials ( POS user)
    And user open sales invoice list and open new sales invoice
    And user verify that POS invoice CheckBox is checked and use sales order to create sales invoice
    And user uncheck Update Stock CheckBox and verify that then submit sales invoice
    Then sales invoice created successfully with it's unique ID
    And sales invoice appear in general ledger and stock account not appear