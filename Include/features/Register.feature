
@tag
Feature: Register

  @tag1
  Scenario Outline: User success sign up
    Given I already open application
    When i click daftar button
    And I input nama <Nama>
    And I input alamat <Alamat>
    And I input email <Email>
    And I choose my gender
    And I input password <Password>
    And I input nomor <Nomor>
    And I click register button
    Then I success register my account

    Examples: 

      | Nama  				| Email 												| Alamat  | Nomor 			| Password 		|
      | valen siahaan | valenmargaretha249@gmail.com	| Medan		|'082272978461' | siahaan1234 |
 
   @tag2
  Scenario Outline: User failed sign up with nama lengkap not inputted
    Given I already open application
    When i click daftar button
    And I input email <Email>
    And I input alamat <Alamat>
    And I choose my gender
    And I input password <Password>
    And I input nomor <Nomor>
    And I click register button
    Then I can verify error message that nama is required

    Examples: 
      | Email 												| Alamat  | Nomor 			| Password 		|
      | valenmargaretha249@gmail.com	| Medan		|'082272978461' | siahaan1234 |     
      
     @tag3
  Scenario Outline: User failed sign up with Email not inputted
    Given I already open application
    When i click daftar button
    And I input nama <Nama>
    And I input alamat <Alamat>
    And I choose my gender
    And I input password <Password>
    And I input nomor <Nomor>
    And I click register button
    Then I can verify error message that email is required

    Examples: 
      | Nama  				| Email 												| Alamat  | Nomor 			| Password 		|
      | valen siahaan | 													 		| Medan		|'082272978461' | siahaan1234 |
      
    @tag4
  Scenario Outline: User failed sign up with Alamat not inputted
    Given I already open application
    When i click daftar button
    And I input nama <Nama>
    And I input email <Email>
    And I choose my gender
    And I input password <Password>
    And I input nomor <Nomor>
    And I click register button
    Then I can verify error message that alamat is required

    Examples: 
      | Nama  				| Email 												| Alamat  | Nomor 			| Password 		|
      | valen siahaan | valenmargaretha249@gmail.com	| 				|'082272978461' | siahaan1234 |
      
     @tag5
  Scenario Outline:User failed sign up with no hp not inputted
   	Given I already open application
    When i click daftar button
    And I input nama <Nama>
    And I input email <Email>
    And I input alamat <Alamat>
    And I choose my gender
    And I input password <Password>
    And I click register button
    Then I can verify error message that no hp is required

    Examples: 
      | Nama  				| Email 												| Alamat  | Nomor 			| Password 		|
      | valen siahaan | valenmargaretha249@gmail.com	| Medan		|						  | siahaan1234 |
      
      
  @tag6
  Scenario Outline: User failed sign up with Jenis Kelamin not inputted
    Given I already open application
    When i click daftar button
    And I input nama <Nama>
    And I input email <Email>
    And I input alamat <Alamat>
    And I input password <Password>
    And I input nomor <Nomor>
    And I click register button
    Then I can verify error message that gender is required

    Examples: 
      | Nama  				| Email 												| Alamat  | Nomor 			| Password 		|
      | valen siahaan | valenmargaretha249@gmail.com	| Medan		|'082272978461' | siahaan1234 |
      
      
  @tag7
  Scenario Outline: User failed sign up with Kata Sandi not inputted
    Given I already open application
    When i click daftar button
    And I input nama <Nama>
    And I input email <Email>
    And I input alamat <Alamat>
    And I input nomor <Nomor>
    And I choose my gender
    And I click register button
    Then I can verify that password is a required field

    Examples: 
      | Nama  				| Email 												| Alamat  | Nomor 			| Password 		|
      | valen siahaan | valenmargaretha249@gmail.com	| Medan		|'082272978461' | 						|