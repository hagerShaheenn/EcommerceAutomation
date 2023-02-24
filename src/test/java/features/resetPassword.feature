@UItest
Feature: reset password
  Scenario: User could log in with valid email and password
    Given user navigate to login  page
    When user click Forgot password?
    Then user write his email
    And user click on RECOVER
    Then message of instruction send to email


