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
Feature: Volunteer vacancies

  @tag1
  Scenario Outline: Apply volunteer vacancies success
    Given I can verify the homepage
    When I click volunteer button on dashboard
    And I can choose which vacancies i want to apply
    And I click ikuti program button
    And I input my skill
    And I input my resume <Resume>
    And I input my alasan <Alasan>
    And I upload my photo
    Then I verify success apply volunteer vacancies

    Examples: 
      | Resume  																																	 | Alasan 																																															|
      | Saya seseorang yang berkomitmen dalam melakukan sesuatu dan saya juga ulet | Karena saya suka membantu orang-orang kesusahan baik itu anakk-anak maupun nenek-nenek yang kesusahan|
      
    