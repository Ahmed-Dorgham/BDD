Feature: Saving Sales Invoice

  Background:
    Given user in dafater login page

  Scenario: user can save sales invoice (using save) ( not POS invoice ) (without update stock)
    When user login successfully with valid credentials
    And user open sales invoice list and open new sales invoice
    And user enter mandatory fields in sales invoice ( client - item - series naming )
    And user verify that  Update Stock CheckBox is unchecked then save sales invoice
    Then sales invoice saved successfully with it's unique ID
  @Skip
  Scenario: user can save sales invoice (using save button ) ( not POS invoice ) (with update stock)

    When user login successfully with valid credentials
    And user open sales invoice list and open new sales invoice
    And user enter mandatory fields in sales invoice ( client - item - series naming )
    And user click on Update Stock CheckBox then save sales invoice
    Then sales invoice saved successfully with it's unique ID
  @Skip
  Scenario: user can save sales invoice (using save button )(POS invoice )(with update stock)

    When user login successfully with valid credentials ( POS user)
    And user open sales invoice list and open new sales invoice
    And user verify that POS invoice CheckBox is checked and add items to sales invoice
    And user verify that  Update Stock CheckBox is checked then save sales invoice
    Then sales invoice saved successfully with it's unique ID
  @Skip
  Scenario: user can save sales invoice (using save button )(POS invoice)(without update stock)

    When user login successfully with valid credentials ( POS user)
    And user open sales invoice list and open new sales invoice
    And user verify that POS invoice CheckBox is checked and add items to sales invoice
    And user uncheck Update Stock CheckBox and verify that then save sales invoice
    Then sales invoice saved successfully with it's unique ID
  @Skip
  Scenario: user can save sales invoice (using save button )(POS invoice )(without update stock)(from delivery note )

    When user login successfully with valid credentials ( POS user)
    And user open sales invoice list and open new sales invoice
    And user verify that POS invoice CheckBox is checked and use delivery note to create sales invoice
    And user uncheck Update Stock CheckBox and verify that then save sales invoice
    Then sales invoice saved successfully with it's unique ID
  @Skip
  Scenario: user can save sales invoice (using save button )( POS invoice )( with update stock )( from sales order )

    When user login successfully with valid credentials ( POS user)
    And user open sales invoice list and open new sales invoice
    And user verify that POS invoice CheckBox is checked and use sales order to create sales invoice
    And user verify that  Update Stock CheckBox is checked then save sales invoice
    Then sales invoice saved successfully with it's unique ID
  @Skip
  Scenario: user can save sales invoice (using save button )(POS invoice )(without update stock )( from sales order )

    When user login successfully with valid credentials ( POS user)
    And user open sales invoice list and open new sales invoice
    And user verify that POS invoice CheckBox is checked and use sales order to create sales invoice
    And user uncheck Update Stock CheckBox and verify that then save sales invoice
    Then sales invoice saved successfully with it's unique ID
  @Skip
  Scenario: user can't save sales invoice (using save button )( not POS invoice )(without terriority )

    When user login successfully with valid credentials
    And user open sales invoice list and open new sales invoice
    And user enter mandatory fields in sales invoice (client - add item -  document numbering series) (without terriority)
    And user verify that  Update Stock CheckBox is unchecked then save sales invoice
    Then sales invoice not saved successfully and validation message appear (validation on terriority )
  @Skip
  Scenario: user can't save sales invoice (using save button )( not POS invoice )(without add items )

    When user login successfully with valid credentials
    And user open sales invoice list and open new sales invoice
    And user enter mandatory fields in sales invoice ( client - document numbering series  )
    And user verify that  Update Stock CheckBox is unchecked then save sales invoice
    Then sales invoice not saved successfully and validation message appear (validation on add items )
  @Skip
  Scenario: user can't save sales invoice (using save button)(not POS invoice )(without Document Numbering Series )

    When user login successfully with valid credentials
    And user open sales invoice list and open new sales invoice
    And user enter mandatory fields in sales invoice ( client - item )
    And user verify that  Update Stock CheckBox is unchecked then save sales invoice
    Then sales invoice not saved successfully and validation messgae appear (validation on document numbering series )
@Skip
  Scenario: user can't save sales invoice (using save button )(not POS invoice)(without client and client account)

    When user login successfully with valid credentials
    And user open sales invoice list and open new sales invoice
    And user enter mandatory fields in sales invoice (add item -  document numbering series) (without client and client account )
    And user verify that  Update Stock CheckBox is unchecked then save sales invoice
    Then sales invoice not saved successfully and validation message appear (validation on client and client account )
  @Skip
  Scenario: user can't save sales invoice (using save button )(not POS invoice)
  (without all mandatory UI fields "teriority & client & client account & add item & document numbering series ")

    When user login successfully with valid credentials
    And user open sales invoice list and open new sales invoice
    And user click on  save sales invoice
    Then sales invoice not saved successfully and validation message appear (validation on all mandatory UI fields )
  @Skip
  Scenario: verify that user can't save sales invoice (uom is integer but entered value not integer)(not POS invoice)(validate_uom_is_integer)

    When user login successfully with valid credentials
    And user open sales invoice list and open new sales invoice
    And user enter mandatory fields in sales invoice ( client - item - series naming )
    And user enter float number in quantity field then click on save button
    Then sales invoice not saved successfully and validation message appear (uom validation message)

  @Skip
  Scenario: user can't save sales invoice (using update stock with delivery note at the same time )(using save button )( POS invoice )( from delivery note ) (validate_delivery_note)

    When user login successfully with valid credentials ( POS user)
    And user open sales invoice list and open new sales invoice
    And user verify that POS invoice CheckBox is checked and use delivery note to create sales invoice
    And user verify that  Update Stock CheckBox is checked then save sales invoice
    Then sales invoice not saved successfully and validation message appear (delivery note validation message)
  @Skip
  Scenario: user can't save sales invoice (the paid amount more than the deserved amount)(using save button )( with update stock )( POS invoice )(validate_account_for_change_amount)

    When user login successfully with valid credentials ( POS user)
    And user open sales invoice list and open new sales invoice
    And user verify that POS invoice CheckBox is checked and add items to sales invoice
    And user increase the paid amount then save sales invoice
    Then sales invoice not saved successfully and validation message appear (account for change amount validation message)

  @Skip
  Scenario: user can't save sales invoice (save without account for write off)(using save)(not POS invoice)(without update stock)(validate_write_off)

    When user login successfully with valid credentials
    And user open sales invoice list and open new sales invoice
    And user enter mandatory fields in sales invoice ( client - item - series naming )
    And user apply write off on sales invoice without specify account for write off then save sales invoice
    Then sales invoice not saved successfully and validation message appear (account for write off validation message)
  @Skip
  Scenario: user can't save sales invoice (using save)(not POS invoice )(without update stock)(validate_date_with_fiscal_year)

    When user login successfully with valid credentials
    And user open sales invoice list and open new sales invoice
    And user enter mandatory fields in sales invoice ( client - item - series naming )
    And user change the fiscal year to be not the same in invoice issue date  then save sales invoice
    Then sales invoice not saved successfully and validation message appear (validation on fiscal year)

  @Skip
  Scenario: user can't save sales invoice (using save button)(without update stock)(POS invoice)(from delivery note)
  (validate_with_previous_doc validate data of prev doctype like delivery note )(change quantity)

    When user login successfully with valid credentials ( POS user)
    And user open sales invoice list and open new sales invoice
    And user verify that POS invoice CheckBox is checked and use delivery note to create sales invoice
    And user uncheck Update Stock CheckBox and change quantity then save sales invoice
    Then sales invoice not saved successfully and validation message appear (validation on different quantity)

