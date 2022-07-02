@METSK-331
Feature: Login functionality works properly

  @METSK-330
  Scenario: Checking login functionality with valid credentials
    Given user goes to login page
    When user enters valid "username" to the username box
    And user enters valid "password" to the password box
    And user clicks the log in button
    Then user should be navigate to main page

    @METSK-336
  Scenario: Checking that user can not login with any invalid credentials
    Given user goes to login page
    When user enters invalid username to username box
    And user enters invalid password to password box
    And user clicks the log in button
    Then user should not be able navigate to main page

   @METSK-366
  Scenario: Checking that user can not login with empty credentials (empty password)
    Given user goes to login page
    When user enters invalid username to username box
    And user clicks the log in button
    Then user should see please fill out this filed message in password box

  @METSK-368
  Scenario: Checking that user can not login with empty credentials (empty username)
    Given user goes to login page
    When user enters invalid password to password box
    And user clicks the log in button
    Then user should see please fill out this filed message in the username box

    @METSK-372
    Scenario: Checking that user can see the password in a form of dots by default
      Given user goes to login page
      When user enters valid "password" to the password box
      Then user can see the password in a form of dots by default




