Feature: Create a New User
  Scenario: TC01 - Successfully create a new user with valid endpoint and body is filled with valid parameter
    Given I set create user endpoint
    When I fill valid parameter in body
    Then I successfully create new user with status code 200

  Scenario: TC02 - Failed create a new user because parameter value is empty
    Given I set Create User Endpoint
    When I fill empty parameter in body
    Then I fail create new user with status code 400