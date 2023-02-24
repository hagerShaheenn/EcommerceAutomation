@UItest
Feature: register
  Scenario: User could register with valid data
    Given user navigate to register page
    Then user click on register button from home page
    When user enter valid data
    And user click on register button
    Then user registered successfully



