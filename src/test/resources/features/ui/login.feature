Feature: Login Functionality

  Background:
    Given user is on the Orange HRM Live login page

  Scenario: Successful Login with valid credentials
    When user enters "Admin" into the username input field
    And user enters "admin123" into the password input field
    And clicks Login button
    Then user is successfully logged into the app
    And dashboard header text is visible

  Scenario: Unsuccessful Login with invalid username credential
    When user enters "INVALID" into the username input field
    And user enters "admin123" into the password input field
    And clicks Login button
    Then user is not logged into the app
    And invalid credentials error area is visible