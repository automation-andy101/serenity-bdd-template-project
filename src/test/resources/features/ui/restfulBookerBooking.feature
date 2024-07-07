Feature: Booking Management

  As a Restful Booker user, I want to be able to get, create, update, and delete bookings
  so that I can manage my reservations efficiently.

  Background:
    Given I am an authenticated user

  Scenario: Retrieve all bookings successfully
    When I send a GET request to the bookings API endpoint
    Then I should receive a list of all bookings
    And the response status should be 200 OK
    And the response should contain an array of booking IDs