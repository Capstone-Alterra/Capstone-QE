@tag
Feature: User can manage customer

  @OpenCustomerPage
  Scenario Outline: Open customer page
    Given I am on the login page
    When I enter my <email> and <password>
    And I click login button
    And I should successfully log in to my account
    And I click Customer menu
    Then I should be on the Customer page
    Examples: 
      | email                  | password  | 
      | admin@raihpeduli.my.id | user12345 |
      
  #@Minimisedmenu
  #Scenario: User can minimize menu using hamburger button 
    #Given I should be on the Customer page
    #When Click hamburger button
    #Then Minimised menu
      
  @Movingpage
  Scenario: User can move page using pagination button 
    Given I should be on the Customer page
    When I click button panigation
    Then Should direct to page 2 of the customer

  @UserCanEdit
  Scenario Outline: User can edit customer data
    Given I click Customer menu
    When I click edit button customer 11
    And I on the customer edit page
    And I  input valid email <email>
    And I input valid fullname <fullname>
    And I input valid Alamat <Alamat>
    And I input valid Handphone <Handphone>
    And I input valid gender <gender>
    And I input valid image
    And I click button edit data
    Then I should have received a success edit customer message
    Examples: 
      | email                     | fullname				 | Alamat          | Handphone    |	gender    |
      | irfansyahreyhan@gmail.com | Reyhan Irfansyah | Jakarta selatan | 089675382136 | Laki-Laki |
      
  @View5CustomerData
  Scenario: User can view 5 customer data
    Given I should be on the Customer page
    When I click dropdown and click 5
    Then I received a display of 5 customer data
    
  @UserCannotEdit
  Scenario Outline: User cannot Edit Fullname with special character
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I input Fullname with special character <fullname>
    And I click button edit data
    Then Should show error message Nama lengkap harus alfabet
    Examples: 
      | fullname				  | 
      | "!@#$%^&*()"      |
      
  @UserCannotEdit
  Scenario Outline: User cannot Edit Fullname with number
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I input Fullname with number <fullname>
    And I click button edit data
    Then Should show error message Nama lengkap harus alfabet
    Examples: 
      | fullname				 | 
      | 1234567890       |
      
  @UserCannotEdit
  Scenario Outline: User cannot edit customer data if the Phone number less than 10 digits
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I input Phone number less than 10 digits <Handphone>
    And I click button edit data
    Then Should show Error message Kolom No. Handphone minimal 10 karakter
    Examples: 
      | Handphone  | 
      | 0896       |
      
  @UserCannotEdit
  Scenario Outline: User cannot edit customer data with special characters on mobile phone numbers
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I input special characters on mobile phone numbers <Handphone>
    And I click button edit data
    Then Should show Error message Kolom harus berisi angka
    Examples: 
      | Handphone  | 
      | 0986.78909 |
      
  @UserCannotEdit
  Scenario Outline: User cannot edit a customers mobile phone number if it is more than 13
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I input more than 13 digit on mobile phone numbers <Handphone>
    And I click button edit data
    Then Should show Error message Kolom No Handphone maksimal 13 karakter
    Examples: 
      | Handphone      | 
      | 08967538213601 |
    
  @UserCannotEdit
  Scenario Outline: user cannot edit the Customer if the email uses spaces
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I input email with space <email>
    And I click button edit data
    Then Should show Error message Format email tidak valid
    Examples: 
      | email                      | 
      | irfansyahreyhan @gmail.com |

  @UserCannotEdit
  Scenario Outline: user cannot edit customer if email does not exist @
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I input email without @ <email>
    And I click button edit data
    Then Should show Error message Format email tidak valid
    Examples: 
      | email                      | 
      | irfansyahreyhan.gmail.com  |
      
  @UserCannotEdit
  Scenario: User cannot edit customer with foto larger than 5mb
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I input image larger than 5mb customer
    And I click button edit data
    Then Should show Error message Ukuran gambar maksimal 5MB customer
    
  @UserCannotEdit
  Scenario: User cannot edit customer if the foto file is not JPG, PNG, and JPEG
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I input image with file is not JPG, PNG, and JPEG customer
    And I click button edit data
    Then Should show Error message Format gambar harus .jpg, .png, .jpeg
      
  @UserCannotEdit
  Scenario: User cannot empty all fields
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I clear email
    And I clear fullname
    And I clear Alamat
    And I clear Nomor Handphone
    And I clear gender
    And I click button edit data	
    Then Should show Error message

  @UserCannotEdit
  Scenario: User cannot empty the customer email field
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I clear email
    And I click button edit data
    Then Should show error message Kolom email wajib diisi
    
  @UserCannotEdit
  Scenario: User cannot empty the customer Fullname field
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I clear fullname
    And I click button edit data
    Then Should show error message Kolom Nama Lengkap harus diisi
    
	@UserCannotEdit
  Scenario: User cannot empty the customer Alamat field
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I clear Alamat
    And I click button edit data
    Then Should show error message Kolom Alamat harus diisi
    
	@UserCannotEdit
  Scenario: User cannot empty the customer No.Handphone field
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I clear Nomor Handphone
    And I click button edit data
    Then Should show error message Kolom No. Handphone harus diisi
    
	@UserCannotEdit
  Scenario: User cannot empty the customer Jenis kelamin field
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I clear gender
    And I click button edit data
    Then Should show error message Kolom Jenis Kelamin harus diisi
    
	@Canceledit
  Scenario: user cancel editing data
    Given I click Customer menu
    When I click edit button customer 5
    And I on the customer edit page
    And I click button kembali
    Then I should be on the Customer page
    
	@Delete
  Scenario: user delete data customer
    Given I click Customer menu
    When I click dropdown and click 50
    And I click button panigation
    And I click edit button customer 52
    And I click button Ya hapus customer
    Then I should be on the Customer page
    
	@CancelDelete
  Scenario: user cancel delete data customer
    Given I click Customer menu
    When I click dropdown and click 50
    And I click button panigation
    And I click edit button customer 52
    And I click button batal customer
    Then I should be on the Customer page
    
  @SearchCustomer
  Scenario Outline: User can search customer
    Given I should be on the Customer page
    When I Input spesific customer search field <search>
    Then should be show data customer that match with inputted data
    Examples: 
      | search  |	
      | Reyhan  |
      
  @SearchInvalid
  Scenario Outline: User can search customer with DATA NOT FOUND
    Given I should be on the Customer page
    When I Input spesific customer search field <search>
    Then should be show data that match with inputted data no found customer
    Examples: 
      | search  |
      | Invalid | 
   
    