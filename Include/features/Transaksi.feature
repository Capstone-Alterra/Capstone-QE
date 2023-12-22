@tag
Feature: User can see transaction 

  @OpenTransactionPage
  Scenario Outline: User success open transaction page
    Given I am on the login page
    When I enter my <email> and <password>
    And I click login button
    And I should successfully log in to my account
    And I click transaction menu
    Then I should be on the transaction page
    Examples: 
      | email                  | password  | 
      | admin@raihpeduli.my.id | user12345 |
      
  @DetailTransaction
  Scenario: User can view detail transaction 
    Given I click transaction menu
    When I click button detail transaction
    Then Should direct to detail transaksi page
    
  @DetailTransaction
  Scenario: User can go to the fundraiser using the fundraiser title in the transaction details 
    Given Should direct to detail transaksi page
    When Click fundraiser title
    Then Should direct to detail fundraiser
    
  @View5TransactionData
  Scenario: User can view 5 Transaction data
    Given I click transaction menu
    When I click dropdown and click 5 transaction
    Then I received a display of 5 transaction data
      
  @Movingpage
  Scenario: User can move page using pagination button 
    Given I should be on the transaction page
    When I click button panigation
    Then Should direct to page 2 of the customer

  #FITUR BELUM JADI
  #@Searchtransaction
  #Scenario Outline: 
    #Given I should be on the transaction page
    #When I Input spesific transaction search field <search>
    #Then I should be show data that match with inputted data
    #Examples: 
      #| search  |	
      #| Mandiri |
      #
  #@Searchtransaction
  #Scenario Outline: User can search transaction with DATA NOT FOUND
    #Given I should be on the transaction page
    #When I Input spesific transaction search field <search>
    #Then I should be show data that match with inputted data no found
    #Examples: 
      #| search  |
      #| Invalid | 