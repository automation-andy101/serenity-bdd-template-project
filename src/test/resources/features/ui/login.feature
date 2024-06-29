Feature: Login Functionality

  Background:
    Given user is on the Orange HRM Live login page

  Scenario: Successful Login with valid credentials
    When user enters "Admin" into the username input field
    And user enters "admin123" into the password input field
    And clicks Login button
#    Then user is successfully logged into the app