@tag
Feature: Title of your feature
  I want to use this template for my feature file

  Scenario Outline: User cannot navigate to the Masukan OTP page if unregistered email is input.
    Given I am on the login page
    When Click button Lupa password on login page
    And I Input unregistered email <email>
    And I click button Lupa password
    Then I should have received an error message Email tidak terdaftar

    Examples: 
      | email  														 |
      | testtesttesttesttesttest@gmail.com |
      
  Scenario Outline: User cannot navigate to the Masukan OTP page if not using @
    Given I am on the login page
    When Click button Lupa password on login page
    And I Input invalid email <email>
    And I click button Lupa password
    Then I should have received an error message Penggunaan email tidak valid

    Examples: 
      | email  					|
      | irfansyahreyhan |
      
  Scenario Outline: User cannot navigate to the Masukan OTP page if unregistered email is input
    Given I am on the login page
    When Click button Lupa password on login page
    And I Input my email <email>
    And I click button Lupa password
    And I input invalid otp <otp>
    And I click button selanjutnya
    Then I should have received an error message Kesalahan saat memverifikasi OTP. Silakan coba lagi nanti.

    Examples: 
      | email  					          | otp    |
      | irfansyahreyhan@gmail.com | 111111 | 
      