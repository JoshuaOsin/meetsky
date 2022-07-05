Feature: Checking functionality of log out.

@METSK-379
  Scenario: Verify that user can log out and ends up in login page

    Given user should be in the main page
    When user clicks to user avatar
    And user clicks the logout
    Then user lands on the login page

  @METSK-384
  Scenario: Verify that user can not go to home page again by clicking step back button after successfully logged out.

    Given user should be in the main page
    When user clicks to user avatar
    And user clicks the logout
    Then user lands on the login page
    And user click step back button
    Then user lands on the login page


