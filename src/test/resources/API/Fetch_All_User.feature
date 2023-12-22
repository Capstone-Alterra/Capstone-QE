Feature: Fetch All User
  Scenario: TC01 - Successfully get fetch all with valid endpoint
    Given I set fetch all endpoint
    When I request get fetch all
    Then I successfully fetch all with status code 200

  Scenario: TC02 - Failed get fetch all with invalid endpoint
    Given I set invalid fetch all endpoint
    When  I request fetch all
    Then I failed fetch all with status code 404

  Scenario: TC03 - Failed fetch all because method is invalid
    Given I set valid fetch all endpoint
    When  I request fetch all with PUT method
    Then I failed fetch all with status code 401