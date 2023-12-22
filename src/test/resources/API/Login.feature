Feature: Login
  Scenario: TC001 - Successfully login Admin by entering valid email and password
    Given I Set login endpoint
    When I send login POST HTTP request and fill body parameter for admin
    And I successfully login admin with status code 200
    Then I received barier token admin

  Scenario: TC001 - Successfully User login by entering valid email and password
    Given I set login endpoint
    When I send login POST HTTP request and fill body parameter for user
    And I successfully login user with status code 200
    Then I received barier token user

  Scenario: TC002 - Fail to login because email and password field is empty
    Given I set valid login endpoint
    When I send login POST HTTP request with empty email and password
    Then I fail login with status code 400

  Scenario: TC003 - Fail to login because email field is empty
    Given I set valid login endpoint url
    When I send login POST HTTP request with empty email
    Then I failed login with status code 400

  Scenario: TC004 - Fail to login because password field is empty
    Given I set login endpoint url
    When I send login POST HTTP request with empty password
    Then I fail to login with status code 400

  Scenario: TC005 - Fail to login because entering invalid email
    Given I set login endpoints
    When I send login POST HTTP request with invalid email
    Then I failed to login with status code 401

  Scenario: TC006 - Fail to login because filling email field with username
    Given I set login endpoints url
    When I send login POST HTTP request fill email with username
    Then I cant login and get status code 400

  Scenario: TC007 - Failed to login because body parameter is invalid
    Given I set valid login endpoints url
    When I send login POST HTTP request with invalid parameter
    Then I can not login and get status code 400

  Scenario: TC008 - Failed to login because body is empty
    Given I set valid endpoints url
    When I send login POST HTTP request with empty body
    Then I can not login and get response code 400

  Scenario: TC009 - Failed to login because method is wrong
    Given I set valid endpoint url
    When I send login POST HTTP request with wrong method
    Then I can not login and get response code 405