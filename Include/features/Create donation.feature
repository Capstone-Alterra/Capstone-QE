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
  Scenario Outline: Create donation success
    Given I can verify the homepage after login
    When I click donasi button on the dashboard 
    And I click request donation
    And I input judul <Judul> penggalangan dana
    And I input isi deskripsi <Deskripsi> penggalangan dana
    And I input target <Target> penggalangan dana
    And I input tanggal mulai dan tanggal selesai
    And I upload gambar penggalagan dana
    And I click tambah button on penggalangan dana
    Then I verify request donation is success

    Examples: 
      | Judul 															 | Deskripsi 																															  | Target  |
      | Membantu korban bencana alam di Riau | Bantulah saudara saudara kita di riau yang terkena dampak bencana alam   | '300000' |
      