Feature: Booking Management

  As a Restful Booker user, I want to be able to get, create, update, and delete bookings
  so that I can manage my reservations efficiently.

#  Background:
#    Given I am an authenticated user

  Scenario: Retrieve all bookings successfully
    When I send a GET request to the bookings API endpoint
    Then I receive a list of all bookings
    And the response status should be 200 OK

  @createBookingBeforeHook
  @deleteBookingAfterHook
  Scenario: Successfully retrieve a booking by ID
    Given a new booking has been created with the following details:
      | firstname      | Jim        |
      | lastname       | Brown      |
      | totalprice     | 111        |
      | depositpaid    | true       |
      | checkin        | 2018-01-01 |
      | checkout       | 2019-01-01 |
      | additionalneeds| Breakfast  |
    When I send a GET request with ID of the booking created in the previous step
    Then I receive a status code of 200
    And response body contains the following details:
      | firstname      | Jim        |
      | lastname       | Brown      |
      | totalprice     | 111        |
      | depositpaid    | true       |
      | checkin        | 2018-01-01 |
      | checkout       | 2019-01-01 |
      | additionalneeds| Breakfast  |


