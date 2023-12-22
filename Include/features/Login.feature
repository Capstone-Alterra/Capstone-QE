@tag
Feature: Login

  @ValidLogin
  Scenario Outline: User successfully login
    Given I am on the login page
    When I enter my <email> and <password>
    And I click login button
    Then I should successfully log in to my account
    Examples: 
      | email                  | password  | 
      | admin@raihpeduli.my.id | user12345 | 
      
  @InvalidEmail
  Scenario Outline: User failed login with wrong Email
    Given I am on the login page
    When I enter an invalid <email> and valid <password>
    And I click login button
    Then I should not be able to login successfully
    Examples: 
      | email                     | password  | 
      | admin1@raihpeduli.my.id   | user12345 | 
      
  @InvalidPassword
  Scenario Outline: User failed login with wrong password
    Given I am on the login page
    When I enter valid <email> and Invalid <password>
    And I click login button
    Then I should not be able to login successfully
    Examples: 
      | email                     | password    | 
      | admin@raihpeduli.my.id    | user1234567 |
     
  @InvalidEmailAndPassword
  Scenario Outline: User failed login with wrong password less than eight digit
    Given I am on the login page
    When I enter <email> and Invalid <password> less than eight digit
    And I click login button
    Then I should not be able to login successfully
    Examples: 
      | email                     | password | 
      | admin@raihpeduli.my.id    | Us123    |
      
  @InvalidEmptyEmail
  Scenario Outline: User failed login with empty Email
    Given I am on the login page
    When I enter <password> and let my email empty
    And I click login button
    Then I should receive an error message that email is required
    Examples: 
      | email  | password  | 
      |        | user12345 |
    
  @InvalidEmptyPassword
  Scenario Outline: User failed login with empty Password
    Given I am on the login page
    When I enter <email> and let my password empty
    And I click login button
    Then I should receive an error message that password is required
    Examples: 
      | email                  | password | 
      | admin@raihpeduli.my.id |          |
      
  @InvalidEmptyEmailAndPassword
  Scenario: User failed to login with empty Email and empty password
    Given I am on the login page
    When I click login button
    Then I should receive an error message that email and password are required
    
  @InvalidSpaceInTheEmailField
  Scenario Outline: User failed login with only space in the Email field
    Given I am on the login page
    When I enter <email> with space and valid <password>
    And I click login button
    Then I should not be able to login
    Examples: 
      | email          | password  | 
      | "        "     | user12345 |
      
  @InvalidEmailformat
  Scenario Outline: User failed login with wrong Email Without @
    Given I am on the login page
    When I enter invalid <email> without @ and valid <password>
    And I click login button
    Then I should not be able to login
    Examples: 
      | email                    | password  | 
      | adminraihpeduli.my.id    | user12345 |
