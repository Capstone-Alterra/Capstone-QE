#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario Outline: success login
    Given I already open application
    When I click masuk button
    And I input my email <Email> on the login page
    And I input my password <Password> on the login page
    And click masuk button on the login page
    Then I can verify the homepage
    

    Examples: 
      | Email  											 | Password 			|
      | valenmargaretha249@gmail.com |     siahaan232 | 
      
  @tag2
  Scenario Outline: failed login with invalid password
    Given I already open application
    When I click masuk button
    And I input my email <Email> on the login page
    And I input my password <Password> on the login page
    And click masuk button on the login page
    Then I can verify error message that credentials is invalid
    

    Examples: 
      | Email  											 | Password 			  |
      | valenmargaretha249@gmail.com |     siahaan23222 | 
      
  @tag3
  Scenario Outline: failed login with invalid email
    Given I already open application
    When I click masuk button
    And I input my email <Email> on the login page
    And I input my password <Password> on the login page
    And click masuk button on the login page
		Then I can verify error message that credentials is invalid
    

    Examples: 
      | Email  											   | Password 			  |
      | valenmargarethaaa249@gmail.com |     siahaan232   | 
      
      
      
    @tag4
  Scenario Outline: failed login with invalid format email
    Given I already open application
    When I click masuk button
    And I input my email <Email> on the login page
    And I input my password <Password> on the login page
    And click masuk button on the login page
		Then I can verify error message that email format is invalid
    

    Examples: 
      | Email  											   | Password 			  |
      | valenmargarethaaa249gmail.com |     siahaan232   | 
      
     @tag5 
    Scenario Outline: failed login with email not inputted
    Given I already open application
    When I click masuk button
    And I input my password <Password> on the login page
    And click masuk button on the login page
		Then I can verify error message that email is required on the login page
    

    Examples:
    	| Password 			   |
      | siahaan232       | 
      
      
      @tag6
    Scenario Outline: failed login with password not inputted
    Given I already open application
    When I click masuk button
    And I input my email <Email> on the login page
    And click masuk button on the login page
		Then I can verify error message that password is required on the login page
    

    Examples:
    	| Email 			  								  |
      | valenmargaretha@gmail.com       | 
      
    @tag6
    Scenario Outline: failed login with email and password not inputted
    Given I already open application
    When I click masuk button
    And click masuk button on the login page
		Then I can verify error message that email is required on the login page
		Then I can verify error message that password is required on the login page
		
    

      
 