@tag
Feature: User can manage news

  @OpenNewsPage
  Scenario Outline: User success open News page
    Given I am on the login page
    When I enter my <email> and <password>
    And I click login button
    And I should successfully log in to my account
    And I click news menu
    Then I should be on the news page
    Examples: 
      | email                  | password  | 
      | admin@raihpeduli.my.id | user12345 |

	@Add
  Scenario Outline: User can add news
		Given I click news menu
		When I click button add news
		And I input valid judul <judul> news
		And I input valid gambar
		And I input valid deskripsi <deskripsi> news
		And I click button simpan news
		Then I should received message Success created news
		Examples:
		| judul 																					| deskripsi 																																			 |
		| Peninggkatan kesadaran lingkungan di masyarakat | Berita ini membahas perkembangan positif dalam kesadaran lingkungan di Indonesia |
	
	Scenario Outline: User cannot add news with empty Title
		Given I should be on the news page
		When I click button add news
		And I input valid gambar
		And I input valid deskripsi <deskripsi> news
		And I click button simpan
		Then I should received error message Kolom judul berita harus diisi
		Examples:
		| deskripsi 																																			 |
		| Berita ini membahas perkembangan positif dalam kesadaran lingkungan di Indonesia |
	
	Scenario Outline: User cannot add a news with empty Gambar
		Given I click news menu
		When I click button add news
		And I input valid judul <judul> news
		And I input valid deskripsi <deskripsi> news
		And I click button simpan
		Then I should received error message Kolom foto berita harus diisi
		Examples:
		| judul 																					| deskripsi 																																			 |
		| Peninggkatan kesadaran lingkungan di masyarakat | Berita ini membahas perkembangan positif dalam kesadaran lingkungan di Indonesia |
	
	Scenario Outline: User cannot add a news with empty Description
		Given I click news menu
		When I click button add news
		And I input valid judul <judul> news
		And I input valid gambar
		And I click button simpan
		Then I should received error message Kolom deskripsi berita harus diisi
		Examples:
		| judul 																					|
		| Peninggkatan kesadaran lingkungan di masyarakat |
	
		Scenario Outline: User cannot add news if the image file is not JPG, PNG, and JPEG
		Given I click news menu
		When I click button add news
		And I input valid judul <judul> news
		And I input gambar with file txt
		And I input valid deskripsi <deskripsi> news
		And I click button simpan
		Then I should received error message Format gambar wajib JPG, JPEG, dan PNG
		Examples:
		| judul 																					| deskripsi 																																			 |
		| Peninggkatan kesadaran lingkungan di masyarakat | Berita ini membahas perkembangan positif dalam kesadaran lingkungan di Indonesia |
		
	Scenario Outline: User cannot add a news if judul less than 20 characters
		Given I click news menu
		When I click button add news
		And I input judul <judul> news less than 20 characters
		And I input valid gambar
		And I input valid deskripsi <deskripsi> news
		And I click button simpan
		Then I should received error message Kolom judul berita harus memiliki minimal 20 karakter
		Examples:
		| judul  | deskripsi 																																				|
		| banjir | Berita ini membahas perkembangan positif dalam kesadaran lingkungan di Indonesia |
	
	Scenario Outline: User cannot add a news if deskripsi less than 50 characters
		Given I click news menu
		When I click button add news
		And I input valid judul <judul> news
		And I input valid gambar
		And I input deskripsi <deskripsi> news less than 50 characters
		And I click button simpan
		Then I should received error message Kolom deskripsi berita harus memiliki minimal 50 karakter
		Examples:
		| judul 																				  | deskripsi      |
		| Peninggkatan kesadaran lingkungan di masyarakat | banjir jakarta |
	
	Scenario Outline: User cannot add a news if image large than 5mb
		Given I click news menu
		When I click button add news
		And I input valid judul <judul> news
		And I input gambar news large than 5MB
		And I input valid deskripsi <deskripsi> news
		And I click button simpan
		Then I should received error message Ukuran Gambar Maksimal 5MB
		Examples:
		| judul 																					| deskripsi 																																			 |
		| Peninggkatan kesadaran lingkungan di masyarakat | Berita ini membahas perkembangan positif dalam kesadaran lingkungan di Indonesia |
	
	Scenario: User cannot add a news if all fields empty
		Given I click news menu
		When I click button add news
		And I click button simpan
		Then I should received error message on field judul, gambar and deskripsi
	
	@Edit
	Scenario Outline: User can Edit news
		Given I click news menu
		When I click icon Edit news on the action coloumn
		And I edit valid judul <judul> news
		And I edit valid gambar
		And I edit valid deskripsi <deskripsi> news
		And I click button simpan edit
		Then I should received message Success update news
		Examples:
		| judul 																																	| deskripsi 																																			 |
		| Banjir Melanda Wilayah Jakarta, Ribuan Warga Mengungsi Menjadi Sorotan | Jakarta - Banjir parah melanda wilayah Jakarta akibat hujan deras yang terus menerus mengguyur ibu kota dalam beberapa hari terakhir. Bencana ini telah menyebabkan ribuan warga mengungsi dan banyak infrastruktur yang terendam air.Menurut Badan Penanggulangan Bencana Daerah (BPBD) Jakarta, banjir yang terjadi kali ini merupakan yang terparah dalam beberapa tahun terakhir. Air banjir mencapai ketinggian hingga dua meter di beberapa tempat, menyebabkan sejumlah jalan raya dan pemukiman warga terisolasi.Sebanyak 10.000 lebih warga telah dievakuasi ke tempat penampungan sementara yang disediakan oleh pemerintah setempat. Terdapat laporan mengenai sejumlah warga yang terjebak di rumah mereka dan memerlukan bantuan untuk dievakuasi. Tim penyelamat terus bekerja dengan keras untuk mengevakuasi mereka yang terjebak. |
	
	Scenario: User cannot Edit news with empty Title
		Given I click news menu
		When I click icon Edit news on the action coloumn
		And I edit judul news to empty
		And I click button simpan
		Then I should received error message Kolom judul berita harus diisi
		
	Scenario: User cannot Edit a news with empty Description
		Given I click news menu
		When I click icon Edit news on the action coloumn
		And I edit deskripsi news to empty
		And I click button simpan
		Then I should received error message Kolom deskripsi berita harus diisi
		
	Scenario: User cannot Edit a news if all fields empty
		Given I click news menu
		When I click icon Edit news on the action coloumn
		And I edit judul news to empty
		And I edit deskripsi news to empty
		And I click button simpan
		Then I should received error message on field judul and deskripsi
	
	Scenario: User cannot add news if the image file is not JPG, PNG, and JPEG
		Given I click news menu
		When I click icon Edit news on the action coloumn
		And I edit gambar with file txt
		And I click button simpan
		Then I should received error message Format gambar wajib JPG, JPEG, dan PNG
		
	Scenario Outline: User cannot edit a news if judul less than 20 characters
		Given I click news menu
		When I click icon Edit news on the action coloumn
		And I edit judul news <judul> less than 20 characters
		And I click button simpan
		Then I should received error message Kolom judul berita harus memiliki minimal 20 karakter
		Examples:
		| judul  |
		| banjir |
	
	Scenario Outline: User cannot edit a news if deskripsi less than 50 characters
		Given I click news menu
		When I click icon Edit news on the action coloumn
		And I edit deskripsi news <deskripsi> less than 50 characters
		And I click button simpan
		Then I should received error message Kolom deskripsi berita harus memiliki minimal 50 karakter
		Examples:
	  | deskripsi      |
	  | banjir jakarta |
	
	Scenario: User cannot edit a news if image large than 5mb
		Given I click news menu
		When I click icon Edit news on the action coloumn
		And I edit gambar news large than 5MB
		And I click button simpan
		Then I should received error message Ukuran Gambar Maksimal 5MB
    
  @CancelDeleteNews
  Scenario: User can cancel delete news
    Given I click news menu
    When I Click icon Delete on the action coloumn
    And I click button Batal
    Then I should be on the news page
    
  @DeleteNews
  Scenario: User can delete news
    Given I click news menu
    When I Click icon Delete on the action coloumn
    And I click button Ya Hapus
    Then Should receive message Berhasil mengapus berita
    
  @ViewDetail
  Scenario: User can view detail news
    Given I should be on the news page
    When I Click icon detail news on the action coloumn
    Then I should be on the detail News page
    
	@View5newsData
  Scenario: User can view 5 news data
    Given I click news menu
    When I click dropdown and click 5 news
    Then I received a display of 5 news data
    
  @Movingpage
  Scenario: User can move page news using pagination button 
    Given I click news menu
    When I click button panigation news
    Then Should direct to page 2 of the news
		
	@Searchnews
  Scenario Outline: User can search news
    Given I should be on the news page
    When I Input spesific news search field <search>
    Then should be show data news that match with inputted data
    Examples: 
      | search  |	
      | Dampak  |
      
  @SearchInvalid
  Scenario Outline: User can search news with DATA NOT FOUND
    Given I should be on the news page
    When I Input spesific news search field <search>
    Then I should be show data that match with inputted data no found
    Examples: 
      | search  |
      | Invalid | 
