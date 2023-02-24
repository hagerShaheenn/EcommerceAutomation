@UItest
Feature: login
  Scenario: User could log in with valid email and password
    Given user navigate to login page
    When user enter "most123@gmail.com" and "most1234"
    And user click on login button
    Then user could login successfully to home page

