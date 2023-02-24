@UItest
Feature: filter
  Scenario: Logged user could filter with color
    Given user logged  in successfuly
    When user select shoes from apparel category
    And user select color from filter
    Then list of products appear related to color


