Feature: Greet

  Scenario: Succesful default greeting
    When user send a get request to the greeting endpoint
    Then a default greeting will be returned

  Scenario: Succesful greeting with name
    When user send a get request to the greeting endpoint with name "anita"
    Then a greeting will be returned with the same name
