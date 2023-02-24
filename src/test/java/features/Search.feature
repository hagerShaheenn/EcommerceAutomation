@UItest
Feature: seacrh
  Scenario: Logged User could search for any product
    Given user logged in successfuly
    When user enter product in the search field
    And click on search button
    Then list of product appear related to search product


