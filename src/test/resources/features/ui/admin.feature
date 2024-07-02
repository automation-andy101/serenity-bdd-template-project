Feature: Admin Functionality

  Background:
    Given user has successfully logged in
    And is on the Admin page

  Scenario Outline: Add a new user
    Given user clicks Add button
    And user enters "<role>", "<name>", "<status>", "<username>" and "<password>"
    When user clicks Save button
    Then Success toast popup appears
    And new user card appears containing <name>, <username>, <role> and <status>

    Examples:
      | role  | name          | status  | username   | password    |
      | Admin | James  Butler | Enabled | AdminTest3 | password123 |
