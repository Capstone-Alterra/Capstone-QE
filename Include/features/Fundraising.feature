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

Feature: Donate fundraising
  I want to use this template for my feature file


  #Scenario: I want input nominal of donation manually
    #Given I can verify the homepage after login
    #When I click donasi button on the dashboard
    #And I can choose which donation that i want to
    #And I click button donasi sekarang
    #And I input nominal donation manually
    #And I click button lanjut
    #Then I direct to method of payment screen
    #
    #Scenario: I want input nominal of donation by choosing nominal
    #Given I can verify the homepage after login
    #When I click donasi button on the dashboard
    #And I can choose which donation that i want to
    #And I click button donasi sekarang
    #And I choose nomnial
    #And I click button lanjut
    #Then I direct to method of payment screen
    
    Scenario: I donate with transfer bank 
    Given I can verify the homepage
    When I click donasi button on the dashboard
    And I can choose which donation that i want to
    And I click button donasi sekarang
    And I choose nomnial
    And I click button lanjut
    And I direct to method of payment screen
    And I choose which bank i want to transfer with
    And I can see detail of my donation
    Then I success donate fundraising
    
    
    #Scenario: I donate with E wallet
    #Given I can verify the homepage after login
    #When I click donasi button on the dashboard
    #And I can choose which donation that i want to
    #And I click button donasi sekarang
    #And I choose nomnial
    #And I click button lanjut
    #And I direct to method of payment screen
    #And I choose which E-wallet i want to transfer with
    #And I can see detail of my donation with e wallet
    #Then I success donate fundraising
    

