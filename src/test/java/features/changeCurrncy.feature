@UItest
Feature: Change currency
  Scenario: Logged User could switch between currencies US to Euro
    Given user logged in succesfuly
    When user click on currency list and select Euro
    Then Euro appear on the currency field



  Scenario: Logged User could switch between currencies Euro to US
    Given user logged in succesfuly
    When user click on currency field and select US Dollar
    Then US Dollar appear on the currency field


