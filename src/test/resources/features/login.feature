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
    Then user should see Wrong username or password

  @METSK-385
  Scenario: Checking that user can not login with any invalid password
    Given user goes to login page
    When user enters valid "username" to the username box
    And user enters invalid password to password box
    And user clicks the log in button
    Then user should see Wrong username or password

  @METSK-386
  Scenario: Checking that user can not login with any invalid username
    Given user goes to login page
    When user enters invalid username to username box
    And user enters valid "password" to the password box
    And user clicks the log in button
    Then user should see Wrong username or password

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

  @METSK-387
  Scenario: Checking that user can see the password explicitly if needed
    Given user goes to login page
    When user enters valid "password" to the password box
    And user click eye icon next to password
    Then user can see the password explicitly if needed

  @METSK-388
  Scenario: Checking that user can see the "Forgot password?" link on the login page
    Given user goes to login page
    When user clicks Forgot password link on the login page
    Then user can see Reset Password button on the next page

  @METSK-389
    Scenario: Checking that an see valid placeholders on Username
      Given user goes to login page
      Then user can see valid placeholders on username

  @METSK-390
  Scenario: Checking that an see valid placeholders on Password
    Given user goes to login page
    Then user can see valid placeholders on password



