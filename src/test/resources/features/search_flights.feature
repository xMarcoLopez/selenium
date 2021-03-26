Feature: Search flights
  AS a customer
  I want to search for flights
  TO pick a flight

  Scenario: Search for the lower flight with departure Medellin and destination Bogota
    Given Daniel wants to search for flights
    When  Daniel enters departure Medellin and destination Bogota
    Then Daniel should pick up the lower flight