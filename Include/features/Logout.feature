@tag
Feature: Logout

  @Login
  Scenario Outline: Login
    Given I am on the login page
    When I enter my <email> and <password>
    And I click login button
    Then I should successfully log in to my account
    Examples: 
      | email                  | password  | 
      | admin@raihpeduli.my.id | user12345 |

  @Logout
  Scenario: User successfully logout
    Given User click the Hi, Admin dropdown!
    When I click button keluar
    Then I should successfully Direct to Login page