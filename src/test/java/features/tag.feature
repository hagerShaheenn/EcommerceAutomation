@UItest
Feature: tag
  Scenario: Logged user could select different tags
    Given user  logged in successfuly
    When user select books category
    And user select apparel tag
    Then list  of products appear related to tag
  Scenario: Logged user could select different tags
    Given user  logged in successfuly
    When user select books category
    And user select awesome tag
    Then list  of products appear related to tag
  Scenario: Logged user could select different tags
    Given user  logged in successfuly
    When user select books category
    And user select book tag
    Then list  of products appear related to tag



