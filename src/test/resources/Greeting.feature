Feature: Greet

  Scenario: Succesful default greeting
    When user send a get request to the greeting endpoint
    Then a default greeting will be returned

  Scenario: Succesful greeting with name0
    When user send a get request to the greeting endpoint with name "sdfsd"
    Then a greeting will be returned with name "sdfsd"

