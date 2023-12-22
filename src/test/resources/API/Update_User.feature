Feature: Update User
#  Scenario: TC01 - Successfully update a user with valid endpoint and body is filled with valid parameter
#    Given I set update user endpoint
#    When I fill valid parameter update in body
#    Then I successfully update user with status code 200

  Scenario: TC02 - Failed update a user because parameter value is empty
    Given I set Update User Endpoint
    When I fill empty parameter update in body
    Then I fail update user with status code 400