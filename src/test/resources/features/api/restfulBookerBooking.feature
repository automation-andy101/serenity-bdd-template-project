Feature: Booking Management

  As a Restful Booker user, I want to be able to get, create, update, and delete bookings
  so that I can manage my reservations efficiently.

  Scenario: Retrieve all bookings successfully
    When I send a GET request to the bookings API endpoint
    Then I receive a list of all bookings
    And get bookings response status code is 200 OK

  @deleteBookingAfterHook
  Scenario: Successfully retrieve a booking by ID
    Given a new booking has been created with the following details:
      | firstname       | Jim        |
      | lastname        | Brown      |
      | totalprice      | 111        |
      | depositpaid     | true       |
      | checkin         | 2018-01-01 |
      | checkout        | 2019-01-01 |
      | additionalneeds | Breakfast  |
    When I send a GET request to the Get Booking by ID endpoint with ID of the booking created in the previous step
    Then get booking by ID response status code is 200 OK
    And get booking by ID response body contains the following details:
      | firstname      | Jim        |
      | lastname       | Brown      |
      | totalprice     | 111        |
      | depositpaid    | true       |
      | checkin        | 2018-01-01 |
      | checkout       | 2019-01-01 |
      | additionalneeds| Breakfast  |

  @deleteBookingAfterHook
  Scenario: Successful booking creation
    When I send a POST request to create a new booking with the following details:
      | firstname       | John       |
      | lastname        | Doe        |
      | totalprice      | 100        |
      | depositpaid     | true       |
      | checkin         | 2024-07-20 |
      | checkout        | 2024-07-25 |
      | additionalneeds | Breakfast  |
    Then create new booking response status code is 200 OK
    And the response body should contain the following details:
      | firstname       | John       |
      | lastname        | Doe        |
      | totalprice      | 100        |
      | depositpaid     | true       |
      | checkin         | 2024-07-20 |
      | checkout        | 2024-07-25 |
      | additionalneeds | Breakfast  |
    And the booking ID should be present in the response

  @deleteBookingAfterHook
  Scenario: Successful update an existing booking
    Given a new booking has been created with the following details:
      | firstname       | Andrew       |
      | lastname        | Short        |
      | totalprice      | 777          |
      | depositpaid     | false        |
      | checkin         | 2024-07-15   |
      | checkout        | 2019-07-17   |
      | additionalneeds | Extra pillow |
    When I send a PUT request to the update booking endpoint with the following details:
      | firstname       | Andrew       |
      | lastname        | Long         |
      | totalprice      | 777          |
      | depositpaid     | false        |
      | checkin         | 2024-07-15   |
      | checkout        | 2019-07-17   |
      | additionalneeds | Extra pillow |
    Then update booking response status code is 200 OK
    And the update booking response body should contain the following details:
      | firstname       | Andrew       |
      | lastname        | Long         |
      | totalprice      | 777          |
      | depositpaid     | false        |
      | checkin         | 2024-07-15   |
      | checkout        | 2019-07-17   |
      | additionalneeds | Extra pillow |

  Scenario: Successful delete an existing booking
    Given a new booking has been created with the following details:
      | firstname       | Andrew              |
      | lastname        | Short               |
      | totalprice      | 777                 |
      | depositpaid     | false               |
      | checkin         | 2024-07-15          |
      | checkout        | 2019-07-17          |
      | additionalneeds | Delete this booking |
    When I send a Delete request to delete the booking created in the previous step
    Then a delete response status code is 201 OK


