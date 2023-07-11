Feature: Make Receipt Voucher

  Background:
    Given user in dafater login page
    And user create sales invoice and submit it

  Scenario: create Receipt Voucher (through sales invoice)

    When user click on make payment entry
    And user enter mandatory fields in receipt voucher and submit it
    Then receipt voucher should be submitted successfully
    And status of sales invoice should be paid

  Scenario: create Receipt Voucher (through Receipt Voucher itself)

    When user open receipt vouchers list and open new receipt voucher
    And user select sales invoice to make receipt voucher and submit receipt voucher
    Then receipt voucher should be submitted successfully
    And status of selected sales invoice should be paid