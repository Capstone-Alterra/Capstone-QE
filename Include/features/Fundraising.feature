@tag
Feature: User can manage fundraising

  @OpenFundraisingPage
  Scenario Outline: Open Fundraising page
    Given I am on the login page
    When I enter my <email> and <password>
    And I click login button
    And I should successfully log in to my account
    And I click Fundraising menu
    Then I should be on the fundraising page
    Examples: 
      | email                  | password  | 
      | admin@raihpeduli.my.id | user12345 |

  @SearchFundraising
  Scenario Outline: 
    Given I click Fundraising menu
    When I Input spesific Fundraising search field <search>
    Then I should be show data that match with inputted data
    Examples: 
      | search  |	
      | SEKOLAH |
      
  @SearchFundraising
  Scenario Outline: User can search Fundraising with DATA NOT FOUND
    Given I should be on the fundraising page
    When I Input spesific Fundraising search field <search>
    Then I should be show data that match with inputted data no found
    Examples: 
      | search  |
      | Mobil   |
      
  @SuccessAddFundraising
  Scenario Outline: User can add fundraising
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I input valid judul <judul> fundraising
    And I input valid deskripsi <deskripsi> fundraising
		And I input valid target <target> fundraising
    And I input valid tanggal mulai 
    And I input valid tanggal selesai 2 februari 2024
    And I input valid image on fundraising
    And I click button simpan
    Then I should have received a success message
    Examples: 
      | judul                         | deskripsi																									 | target |
      | Bantu Anak-anak untuk sekolah | Membantu anak anak yang kurang mampu untuk bisa bersekolah | 100    |
      
  @CannotAdd
  Scenario Outline: User cannot add fundraising if Judul less than 20 character
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I input <judul> less than 20 character
    And I input valid deskripsi <deskripsi> fundraising
		And I input valid target <target> fundraising
    And I input valid tanggal mulai
    And I input valid tanggal selesai 29 desember 2023
    And I input valid image on fundraising
    And I click button simpan
    Then I should have received a error message Judul minimal 20 karakter
    Examples: 
      | judul              | deskripsi																									 | target |
      | Bantu Anak sekolah | Membantu anak anak yang kurang mampu untuk bisa bersekolah  | 100    |
      
  @CannotAdd
  Scenario Outline: User cannot add fundraising with empty Title
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I input valid deskripsi <deskripsi> fundraising
		And I input valid target <target> fundraising
    And I input valid tanggal mulai
    And I input valid tanggal selesai 29 desember 2023
    And I input valid image on fundraising
    And I click button simpan
    Then I should have received a error message Kolom judul penggalangan dana harus diisi
    Examples: 
      | deskripsi																									  | target |
      | Membantu anak anak yang kurang mampu untuk bisa bersekolah  | 100    |
        
  @CannotAdd 
  Scenario Outline: User cannot add fundraising if Deskripsi less than 50 character
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I input valid judul <judul> fundraising
    And I input <deskripsi> less than 50 character
		And I input valid target <target> fundraising
    And I input valid tanggal mulai
    And I input valid tanggal selesai 29 desember 2023
    And I input valid image on fundraising
    And I click button simpan
    Then I should have received a error message Deskripsi minimal 50 karakter
    Examples: 
      | judul                    | deskripsi					 | target |
      | Bantu Anak untuk sekolah | Membantu anak anak  | 100    |
      
  @CannotAdd 
  Scenario Outline: User cannot add a fundraising with empty Description
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I input valid judul <judul> fundraising
		And I input valid target <target> fundraising
    And I input valid tanggal mulai
    And I input valid tanggal selesai 29 desember 2023
    And I input valid image on fundraising
    And I click button simpan
    Then I should have received a success message Kolom deskripsi penggalangan dana harus diisi
    Examples: 
      | judul                  	  | target |
      | Bantu Anak untuk sekolah  | 100    |
      
  @CannotAdd
  Scenario Outline: User cannot add a fundraising with empty target
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I input valid judul <judul> fundraising
    And I input valid deskripsi <deskripsi> fundraising
    And I input valid tanggal mulai
    And I input valid tanggal selesai 29 desember 2023
    And I input valid image on fundraising
    And I click button simpan
    Then I should have received a error message Kolom target penggalangan dana harus diisi
    Examples: 
      | judul                    | deskripsi					 																				 |
      | Bantu Anak untuk sekolah | Membantu anak anak yang kurang mampu untuk bisa bersekolah  |
      
  @CannotAdd
  Scenario Outline: User cannot add a fundraising with empty start date
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I input valid judul <judul> fundraising
    And I input valid deskripsi <deskripsi> fundraising
    And I input valid target <target> fundraising 
    And I input valid tanggal selesai 29 desember 2023
    And I input valid image on fundraising
    And I click button simpan
    Then I should have received a error message Masukkan tanggal mulai penggalangan dana
    Examples: 
      | judul                         | deskripsi																									  | target |
      | Bantu Anak-anak untuk sekolah | Membantu anak anak yang kurang mampu untuk bisa bersekolah  | 100    |
      
  @CannotAdd
  Scenario Outline: User cannot add a fundraising with empty end date
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I input valid judul <judul> fundraising
    And I input valid deskripsi <deskripsi> fundraising
    And I input valid target <target> fundraising
    And I input valid tanggal mulai
    And I input valid image on fundraising
    And I click button simpan
    Then I should have received a error message Masukkan tanggal berakhir penggalangan dana
    Examples: 
      | judul                         | deskripsi																									 | target |
      | Bantu Anak-anak untuk sekolah | Membantu anak anak yang kurang mampu untuk bisa bersekolah | 100    |
      
  @CannotAdd
  Scenario Outline: User cannot add a fundraising with empty Image
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I input valid judul <judul> fundraising
    And I input valid deskripsi <deskripsi> fundraising
    And I input valid target <target> fundraising
    And I input valid tanggal mulai
    And I input valid tanggal selesai 29 desember 2023
    And I click button simpan
    Then I should have received a error message Kolom foto penggalangan dana harus diisi
    Examples: 
      | judul                         | deskripsi																									 | target |
      | Bantu Anak-anak untuk sekolah | Membantu anak anak yang kurang mampu untuk bisa bersekolah | 100    |
      
      
	@CannotAdd
  Scenario: User cannot add a fundraiser with all fields empty
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I click button simpan
    Then I should have received a error message on all fields
    
  @CannotAdd
  Scenario Outline: User cannot add a fundraising if the end date is earlier than the start date
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I input valid judul <judul> fundraising
    And I input valid deskripsi <deskripsi> fundraising
    And I input valid target <target> fundraising
    And I input valid tanggal mulai 30 desember 2023
    And I input tanggal selesai earlier than the start date
    And I input valid image on fundraising
    And I click button simpan
    Then I should have received a error message Tanggal selesai tidak boleh kurang dari tanggal mulai
    Examples: 
      | judul                         | deskripsi																									 | target |
      | Bantu Anak-anak untuk sekolah | Membantu anak anak yang kurang mampu untuk bisa bersekolah | 100    |
      
  @CannotAdd
  Scenario Outline: User cannot add fundraising using dot (.) in the target field
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I input valid judul <judul> fundraising
    And I input valid deskripsi <deskripsi> fundraising
    And I input target <target> fundraising using dot
    And I input valid tanggal mulai 
    And I input valid tanggal selesai 29 desember 2023
    And I input valid image on fundraising
    And I click button simpan
    Then I should have received a error message Kolom target penggalangan dana harus diisi
    Examples: 
      | judul                         | deskripsi																									 | target |
      | Bantu Anak-anak untuk sekolah | Membantu anak anak yang kurang mampu untuk bisa bersekolah | "."    |
      
  @CannotAdd
  Scenario Outline: User cannot add fundraiser if the image file is not JPG, PNG, and JPEG
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I input valid judul <judul> fundraising
    And I input valid deskripsi <deskripsi> fundraising
    And I input valid target <target> fundraising
    And I input valid tanggal mulai 
    And I input valid tanggal selesai 29 desember 2023
    And I input file txt on image fundraising
    And I click button simpan
    Then I should have received a error message Format gambar harus .jpg, .png, .jpeg
    Examples: 
      | judul                         | deskripsi																									 | target |
      | Bantu Anak-anak untuk sekolah | Membantu anak anak yang kurang mampu untuk bisa bersekolah | 100    |
      
  @CannotAdd
  Scenario Outline: user cannot add fundraisers with a target of less than IDR 100
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I input valid judul <judul> fundraising
    And I input valid deskripsi <deskripsi> fundraising
    And I input target <target> fundraising less than IDR 100
    And I input valid tanggal mulai 
    And I input valid tanggal selesai 29 desember 2023
    And I input valid image on fundraising
    And I click button simpan
    Then I should have received a error message Jumlah target minimum Rp100
    Examples: 
      | judul                         | deskripsi																									 | target |
      | Bantu Anak-anak untuk sekolah | Membantu anak anak yang kurang mampu untuk bisa bersekolah | 99     |
      
  @CannotAdd
  Scenario Outline: User cannot add fundraisers with images larger than 5mb
    Given I click Fundraising menu
    When I click add button fundraising
    And I on the add fundraising page
    And I input valid judul <judul> fundraising
    And I input valid deskripsi <deskripsi> fundraising
    And I input valid target <target> fundraising
    And I input valid tanggal mulai 
    And I input valid tanggal selesai 29 desember 2023
    And I input image larger than 5MB on fundraising
    And I click button simpan
    Then I should have received a error message Ukuran gambar maksimal 5MB
    Examples: 
      | judul                         | deskripsi																									| target |
      | Bantu Anak-anak untuk sekolah | Membantu anak anak yang kurang mampu untuk bisa bersekolah | 100    |
      
	#Edit
	
  @CanEdit
  Scenario Outline: User can edit fundraiser
    Given I click Fundraising menu
    When Click icon edit on the action coloumn
    And I on the fundraising edit page
    And I edit valid judul <judul> fundraising
    And I edit valid deskripsi <deskripsi> fundraising
		And I edit valid target <target> fundraising
    And I edit valid tanggal mulai
    And I input valid tanggal selesai 29 desember 2023
    And I edit valid image on fundraising
    And I click a button edit data
    Then I should receive an edit success message
    Examples: 
      | judul                             | deskripsi																						| target    |
      | Bangun masjid di daerah terpencil | Membantu untuk membangun masjid di daerah terpencil | 100000    |
      
  @CannotEdit
  Scenario Outline: User cannot Edit fundraising if Judul penggalangan dana less than 20 characters
    Given I click Fundraising menu
    When Click icon edit on the action coloumn
    And I on the fundraising edit page
    And I edit fundraising <judul> less than 20 characters
    And I click a button edit data
    Then I should have received a error message Judul penggalangan dana minimal 20 karakter
    Examples: 
      | judul         |
      | Bangun masjid |
      
  @CannotEdit
  Scenario: User cannot edit fundraising with empty Title
    Given I click Fundraising menu
    When Click icon edit on the action coloumn
    And I on the fundraising edit page
    And I edit judul to blank
    And I click a button edit data
    Then I should have received a error message Kolom judul penggalangan dana harus diisi
    
  @CannotEdit
  Scenario: User cannot edit a fundraising with empty Description
    Given I click Fundraising menu
    When Click icon edit on the action coloumn
    And I on the fundraising edit page
    And I edit deskripsi to blank
    And I click a button edit data
    Then I should have received a success message Kolom deskripsi penggalangan dana harus diisi
    
  @CannotEdit
  Scenario: User cannot edit a fundraising with empty target
    Given I click Fundraising menu
    When Click icon edit on the action coloumn
    And I on the fundraising edit page
    And I edit target to blank
    And I click a button edit data
    Then I should have received a error message Kolom target penggalangan dana harus diisi
    
  @CannotEdit
  Scenario: User cannot edit a fundraiser with all fields empty
    Given I click Fundraising menu
    When Click icon edit on the action coloumn
    And I on the fundraising edit page
    And I edit judul to blank
		And I edit deskripsi to blank
    And I edit target to blank
    And I click a button edit data
    Then I should have received a error message on fields
    
  @CannotEdit
  Scenario: User cannot edit a fundraising if the end date is earlier than the start date
    Given I click Fundraising menu
    When Click icon edit on the action coloumn
    And I on the fundraising edit page
    And I edit tanggal mulai 29 desember 2023
    And I edit tanggal selesai 25 desember 2023
    And I click a button edit data
    Then I should have received a error message Tanggal selesai tidak boleh kurang dari tanggal mulai

  @CannotEdit
  Scenario: User cannot edit fundraiser if the image file is not JPG, PNG, and JPEG
    Given I click Fundraising menu
    When Click icon edit on the action coloumn
    And I on the fundraising edit page
    And I edit image with file txt
    And I click a button edit data
    Then I should have received a error message Format gambar harus .jpg, .png, .jpeg
      
  @CannotEdit
  Scenario Outline: User cannot edit fundraising using dot (.) in the target field. 
    Given I click Fundraising menu
    When Click icon edit on the action coloumn
    And I on the fundraising edit page
    And I edit target <target> fundraising with dot
    And I click a button edit data
    And I should have received a error message Jumlah target minimum Rp100
    Examples: 
      | target |
      | "."    |
    
  @CannotEdit
  Scenario Outline: user cannot edit fundraisers with a target of less than IDR 100 
    Given I click Fundraising menu
    When Click icon edit on the action coloumn
    And I on the fundraising edit page
    And I edit target <target> fundraising less than IDR 100
    And I click a button edit data
    Then I should have received a error message Jumlah target minimum Rp100
    Examples: 
      | target |
      | 99     |
      
  @CannotEdit
  Scenario: User cannot edit fundraisers with image larger than 5mb
    Given I click Fundraising menu
    When Click icon edit on the action coloumn
    And I on the fundraising edit page
    And I edit image larger than 5mb
    And I click a button edit data
    Then I should have received a error message Ukuran gambar maksimal 5MB
    
  @CannotEdit
  Scenario Outline: User cannot edit fundraising if Deskripsi less than 50 character
    Given I click Fundraising menu
    When Click icon edit on the action coloumn
    And I on the fundraising edit page
    And I edit fundraising deskripsi <deskripsi> less than 50 characters
    And I click a button edit data
    Then I should have received a error message Deskripsi minimal 50 karakter
    Examples: 
      | deskripsi                      |
      | Membantu untuk bisa bersekolah |
      
  @CanAcc
  Scenario: User accepts fundraising
    Given I click Fundraising menu
    When I Click icon detail on the action coloumn
    And I on the detail fundraising page
    And I Click button Terima
    Then I should have received a success message Berhasil mengupdate status penggalangan dana
    
	@SuccessAdd2
  Scenario Outline: User can add fundraising again
    Given I should be on the fundraising page
    When I click add button fundraising
    And I on the add fundraising page
    And I input valid judul <judul> fundraising
    And I input valid deskripsi <deskripsi> fundraising
		And I input valid target <target> fundraising
    And I input valid tanggal mulai 
    And I input valid tanggal selesai 2 februari 2024
    And I input valid image on fundraising
    And I click button simpan
    Then I should have received a success message
    Examples: 
      | judul                             | deskripsi																									    | target |
      | Bantu Anak-anak agar bisa sekolah | Membantu anak anak yang kurang mampu agar bisa bersekolah | 10000  |
      
	@CannotReject
  Scenario: User cannot reject fundraising if do not fill a reason
    Given I click Fundraising menu
    When I Click icon detail on the action coloumn
    And I on the detail fundraising page
    And I Click button Tolak
    And I Click button tolak on reason page
    Then I should have received a error message Kolom harus diisi
    
  @CannotReject
  Scenario Outline: User cannot reject fundraising if input reason less than 20 characters
    Given I input reason <reason> less than 20 characters
    When I Click button tolak on reason page
    Then I should have received a error message Alasan penolakan minimal 20 karakter
    Examples: 
      | reason       |
      | Kami menolak |
    
  @CanReject
  Scenario Outline: User reject fundraising
    Given I input valid reason <reason> for reject fundraising
    When I Click button tolak on reason page
    Then I should have receive a success message Berhasil mengupdate status penggalangan dana
    Examples: 
      | reason       																															|
      | Kami menolak penggalangan dana anda karena tidak sesuai dengan ketentuan  |
    
	@CancelDelete
  Scenario: user cancel delete data fundraising
    Given I click Fundraising menu
    When I click button delete fundraising
    And I click button batal
    Then I shouldn't have deleted the fundraiser
    
	@Delete
  Scenario: user delete data fundraising
    Given I click Fundraising menu
    When I click button delete fundraising
    And I click button Ya hapus fundraising
    Then I should have received a success delete message
    
  @EksporCSV
  Scenario: user delete data fundraising
    Given I click Fundraising menu
    When I click button ekspor csv
    Then I should have received a success message berhasil mengekspor csv
    
  @Movingpage
  Scenario: User can move page fundraising using pagination button 
    Given I click Fundraising menu
    When I click button panigation fundraising
    Then Should direct to page 2 of the fundraising
    
	@View50fundraisingData
  Scenario: User can view 50 fundraising data
    Given I click Fundraising menu
    When I click dropdown and click 50 data
    Then I received a display of 50 fundraising data