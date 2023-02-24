@UItest
Feature: category
  Scenario: Logged user could select different Categories
    Given user logged in  successfuly
    When user select random category
    And sub-category if found
    Then list of products appear related to category


