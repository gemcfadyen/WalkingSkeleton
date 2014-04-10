Feature: Trade Execution

  Scenario: New trade is confirmed between the bank and counterparty
    Given A new trade between the bank and counterparty
    When the trade is captured
    Then it sent to clearing house for matching