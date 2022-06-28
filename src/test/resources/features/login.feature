@METSK-331
Feature: Login functionality works properly

  @METSK-330
  Scenario: Checking login functionality with valid credentials
    Given user goes to login page
    When user enters valid "username" to the username box
    And user enters valid "password" to the password box
    And user clicks the log in button
    Then user should be navigate to main page