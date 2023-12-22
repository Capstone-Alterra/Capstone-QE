@tag
Feature: User can manage Volunteer

  @OpenVolunteerPage
  Scenario Outline: User success open volunteer vacancies page
    Given I am on the login page
    When I enter my <email> and <password>
    And I click login button
    And I should successfully log in to my account
    And I click volunteer vacancies menu
    Then I should be on the volunteer vacancies page
    Examples: 
      | email                  | password  | 
      | admin@raihpeduli.my.id | user12345 |

	@Add
  Scenario Outline: User can add volunteer vacancies
		Given I should be on the volunteer vacancies page
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received message Success Menambahkan lowongan relawan
		Examples:
		| judul 								 | deskripsi 																											 | skill | jumlah| email            |                             
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 20		 | reyhan@gmail.com |
	
  Scenario Outline: User cannot add volunteer vacancies if judul less than 20 characters
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input judul <judul> volunteer vacancies less than 20 characters
		And I input valid jumlah <jumlah> volunteer vacancies 
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Judul lowongan relawan minimal 20 karakter
		Examples:
		| judul 	 | deskripsi 																											 | skill | jumlah| email            |                             
		| mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 20		 | reyhan@gmail.com |
      
  Scenario Outline: User cannot add volunteer vacancies if deskripsi less than 50characters
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input deskripsi <deskripsi> volunteer vacancies less than 50 characters
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Kolom deskripsi lowongan relawan minimal 50 karakter
		Examples:
		| judul 								 | deskripsi 					| skill | jumlah | email            |                             
		| Relawan untuk mengajar | Membantu anak-anak | Guru  | 20		 | reyhan@gmail.com |
	
  Scenario Outline: User cannot add volunteer vacancies if Jumlah Lowongan 0
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Kolom jumlah lowongan relawan harus diisi
		Examples:
		| judul 								 | deskripsi 																											 | skill | jumlah| email            |                             
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 0		 | reyhan@gmail.com |
      
  Scenario Outline: User cannot add volunteer vacancies with empty Title
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Kolom judul lowongan relawan harus diisi
		Examples:
		| deskripsi 																											| skill | jumlah | email            |                             
		| Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 20		 | reyhan@gmail.com |
      
  Scenario Outline: User cannot add a volunteer vacancies with empty Description
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Kolom deskripsi lowongan relawan harus diisi
		Examples:
		| judul 								  | skill | jumlah | email            |                             
		| Relawan untuk mengajar  | Guru  | 20		 | reyhan@gmail.com |
      
  Scenario Outline: User cannot add a volunteer vacancies with empty skill
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Kolom keahlian harus diisi
		Examples:
		| judul 								 | deskripsi 																											   | jumlah| email            |                             
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar   | 20		 | reyhan@gmail.com |   
      
  Scenario Outline: User cannot add a volunteer vacancies with empty Contact email
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Kolom alamat email harus diisi
		Examples:
		| judul 								 | deskripsi 																											 | skill | jumlah|                            
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 20		 |
      
  Scenario Outline: User cannot add a volunteer vacancies with empty Tanggal selesai
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Kolom tanggal selesai lowongan relawan harus diisi
		Examples:
		| judul 								 | deskripsi 																											 | skill | jumlah| email            |                             
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 20		 | reyhan@gmail.com |
      
  Scenario Outline: User cannot add a volunteer vacancies with empty Provinsi
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Kolom provinsi harus diisi
		Examples:
		| judul 								 | deskripsi 																											 | skill | jumlah| email            |                             
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 20		 | reyhan@gmail.com |
		
  Scenario Outline: User cannot add a volunteer vacancies with empty kabupaten
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Kolom kabupaten harus diisi
		Examples:
		| judul 								 | deskripsi 																											 | skill | jumlah| email            |                             
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 20		 | reyhan@gmail.com |
		
  Scenario Outline: User cannot add a volunteer vacancies with empty kecamatan
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Kolom kecamatan harus diisi
		Examples:
		| judul 								 | deskripsi 																											 | skill | jumlah| email            |                             
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 20		 | reyhan@gmail.com |
		
  Scenario Outline: User cannot add a volunteer vacancies with empty Lokasi detail
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Kolom Lokasi detail harus diisi
		Examples:
		| judul 								 | deskripsi 																											 | skill | jumlah | email            |                             
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 20		  | reyhan@gmail.com |
      
  Scenario Outline: User cannot add a volunteer vacancies with empty Gambar
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Kolom foto lowongan relawan harus diisi
		Examples:
		| judul 								 | deskripsi 																											 | skill | jumlah | email            |                             
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 20		  | reyhan@gmail.com |
      
  Scenario Outline: User cannot add volunteer vacancies if the image file is not JPG, PNG, and JPEG
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input gambar with file txt volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Format gambar harus .jpg, .png, .jpeg
		Examples:
		| judul 								 | deskripsi 																											 | skill | jumlah| email            |                             
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 20		 | reyhan@gmail.com |
      
  Scenario Outline: User cannot add a volunteer vacancies with empty jumlah lowongan
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Kolom jumlah lowongan relawan harus diisi
		Examples:
		| judul 								 | deskripsi 																											 | skill | email            |                             
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | reyhan@gmail.com |
      
  Scenario: User cannot add a volunteer vacancies with all fields empty
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message on all fields
		
  Scenario Outline: User cannot add volunteer vacancies if the email format does not use @
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input invalid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Alamat email tidak valid. Mohon periksa kembali
		Examples:
		| judul 								 | deskripsi 																											 | skill | jumlah| email            |                             
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 20		 | reyhan.gmail.com |
		
  Scenario Outline: User cannot add volunteer vacancies if using spaces in the email field
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input invalid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Alamat email tidak valid. Mohon periksa kembali
		Examples:
		| judul 								 | deskripsi 																											 | skill | jumlah| email             |                             
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 20		 | reyhan @gmail.com |
      
  Scenario Outline: User cannot add volunteer vacancies if image large than 5mb
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input gambar large than 5mb volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received error message Ukuran gambar maksimal 5MB
		Examples:
		| judul 								 | deskripsi 																											 | skill | jumlah| email            |                             
		| Relawan untuk mengajar | Membantu anak-anak yang terkena bencana agar bisa tetap belajar | Guru  | 20		 | reyhan@gmail.com |
      
  Scenario Outline: User cannot add a volunteer vacancy if select not listed in the keahlian list
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input invalid skill <skill> volunteer vacancies
		Then I should received error message No Option
		Examples:
		| skill         |                          
		| Manjat pohon  |
		
		
	@Edit
  Scenario Outline: User can edit volunteer vacancies
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit valid judul <judul> volunteer vacancies
		And I edit valid jumlah <jumlah> volunteer vacancies
		And I edit valid deskripsi <deskripsi> volunteer vacancies
		And I edit valid skill <skill> volunteer vacancies
		And I edit Valid tanggal selesai volunteer vacancies
		And I edit valid Provinsi volunteer vacancies
		And I edit valid Kabupaten volunteer vacancies
		And I edit valid Kecamatan volunteer vacancies
		And I edit valid Lokasi Detail volunteer vacancies
		And I edit valid gambar volunteer vacancies
		And I click button edit data volunteer vacancies
		Then I should received message Berhasil mengedit lowongan relawan
		Examples:
		| judul 								       | deskripsi 																							| skill   | jumlah |                             
		| Relawan untuk bencana banjir | Membantu korban-korban yang terkena bencana banjir     | Dokter  | 10		 |

  Scenario Outline: User cannot edit volunteer vacancies if judul less than 20 characters
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit judul <judul> less than 20 characters volunteer vacancies
		And I click button edit data volunteer vacancies
		Then I should received error message Judul lowongan relawan minimal 20 karakter
		Examples:
		| judul 				 |                          
		| Relawan banjir |
      
  Scenario Outline: User cannot edit volunteer vacancies if deskripsi less than 50 characters
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit deskripsi <deskripsi> less than 50 characters volunteer vacancies
		And I click button edit data volunteer vacancies
		Then I should received error message Kolom deskripsi lowongan relawan minimal 50 karakter
		Examples:
		| deskripsi 										 |                             
		| Membantu korban bencana banjir |
		
  Scenario Outline: User cannot edit volunteer vacancies if number of vacancies 0
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit jumlah <jumlah> volunteer vacancies
		And I click button edit data volunteer vacancies
		Then I should received error message Kolom jumlah lowongan relawan harus diisi
		Examples:
		| jumlah |                             
		| 0		   |
		
  Scenario: User cannot edit volunteer vacancies with empty Title
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit judul empty volunteer vacancies
		And I click button edit data volunteer vacancies
		Then I should received error message Kolom judul lowongan relawan harus diisi
      
  Scenario: User cannot edit a volunteer vacancies with empty Description
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit deskripsi empty volunteer vacancies
		And I click button edit data volunteer vacancies
		Then I should received error message Kolom deskripsi lowongan relawan harus diisi
		
  Scenario: User cannot edit a volunteer vacancies with empty skill
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit skill empty volunteer vacancies
		And I click button edit data volunteer vacancies
		Then I should received error message Kolom keahlian harus diisi
		
  Scenario: User cannot edit a volunteer vacancies with empty Lokasi detail
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit kecamatan empty volunteer vacancies
		And I click button edit data volunteer vacancies
		Then I should received error message Kolom Lokasi detail harus diisi
      
  Scenario: User cannot edit a volunteer vacancies with empty kecamatan
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit Kabupaten empty volunteer vacancies
		And I click button edit data volunteer vacancies
		Then I should received error message Kolom kecamatan harus diisi
		
  Scenario: User cannot edit a volunteer vacancies with empty kabupaten
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit Provinsi empty volunteer vacancies
		And I click button edit data volunteer vacancies
		Then I should received error message Kolom kabupaten harus diisi   
		
  Scenario: User cannot edit volunteer vacancies if the image file is not JPG, PNG, and JPEG
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit gambar with file txt volunteer vacancies
		And I click button edit data volunteer vacancies
		Then I should received error message Format gambar harus .jpg, .png, .jpeg  
		
  Scenario: User cannot edit a volunteer vacancies with empty Jumlah lowongan
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit jumlah volunteer vacancies empty
		And I click button edit data volunteer vacancies
		Then I should received error message Kolom jumlah lowongan relawan harus diisi  
      
  Scenario: User cannot edit a volunteer vacancies with all fields empty
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit judul empty volunteer vacancies
		And I edit deskripsi empty volunteer vacancies
		And I edit skill empty volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I edit jumlah volunteer vacancies empty
		And I click button edit data volunteer vacancies
		Then I should received error message on all fields
      
  Scenario: User cannot edit volunteer vacancies if image large than 5mb
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit gambar large than 5mb volunteer vacancies
		And I click button edit data volunteer vacancies
		Then I should received error message Ukuran gambar maksimal 5MB

  Scenario Outline: User cannot add a volunteer vacancy if select not listed in the keahlian list
		Given I click volunteer vacancies menu
		When I Click icon edit volunteer vacancies on the action coloumn
		And I edit invalid skill <skill> volunteer vacancies
		Then I should received error message No Option
		Examples:
		| skill         |                          
		| Manjat pohon  |

  Scenario: User can view detail volunteer list
		Given I click volunteer vacancies menu
		When I Click icon detail volunteer vacancies on the action coloumn
		And I on the detail volunteer vacancies page
		And I Click button Pendaftar relawan
		Then I should be on the list volunteer page
			
  Scenario: user can accept a list of waiting volunteer vacancies
		Given I click volunteer vacancies menu
		When I Click icon detail volunteer vacancies on the action coloumn
		And I on the detail volunteer vacancies page
		And I Click button Terima volunteer vacancies
		Then I should received message Berhasil menerima lowongan relawan
		
  Scenario Outline: User can add volunteer vacancies
		Given I click volunteer vacancies menu
		When I click button add volunteer vacancies
		And I input valid judul <judul> volunteer vacancies
		And I input valid jumlah <jumlah> volunteer vacancies
		And I input valid deskripsi <deskripsi> volunteer vacancies
		And I input valid contact email <email> volunteer vacancies
		And I input valid skill <skill> volunteer vacancies
		And I input Valid tanggal selesai volunteer vacancies
		And I input valid Provinsi volunteer vacancies
		And I input valid Kabupaten volunteer vacancies
		And I input valid Kecamatan volunteer vacancies
		And I input valid Lokasi Detail volunteer vacancies
		And I input valid gambar volunteer vacancies
		And I click button Tambah volunteer vacancies
		Then I should received message Success Menambahkan lowongan relawan
		Examples:
		| judul 								        | deskripsi 																											 | skill | jumlah| email            |                             
		| TEST TEST TEST TEST TEST TEST | TEST TEST TEST TEST TEST TESTTEST TEST TEST TEST TEST TEST TEST  | Guru  | 20		 | reyhan@gmail.com |
		
  Scenario: User cannot reject volunteer vacancies if do not fill a reason
    Given I click volunteer vacancies menu
    When I Click icon detail volunteer vacancies on the action coloumn
    And I on the detail volunteer vacancies page
    And I Click button Tolak volunteer vacancies
    And I Click button tolak volunteer vacancies on reason page
    Then I should have received a error message Kolom reason harus diisi
    
  Scenario Outline: User cannot reject volunteer vacancies if input reason less than 20 characters
    Given I input invalid reason <reason> volunteer vacancies less than 20 characters
    When I Click button tolak volunteer vacancies on reason page
    Then I should have received error message Alasan penolakan minimal 20 karakter
    Examples: 
      | reason       |
      | Kami menolak |
    
  Scenario Outline: User reject volunteer vacancies
    Given I input valid reason <reason> for reject volunteer vacancies
    When I Click button tolak volunteer vacancies on reason page
    Then I should have receive a success message Berhasil mengupdate status Lowongan relawan
    Examples: 
      | reason       																															|
      | Kami menolak penggalangan dana anda karena tidak sesuai dengan ketentuan  |

	@CancelDeleteNews
  Scenario: User can cancel delete volunteer vacancies
    Given I click volunteer vacancies menu
    When I Click icon Delete on the action coloumn volunteer vacancies
    And I click button Batal delete
    Then I should be on the volunteer vacancies page
    
  @DeleteNews
  Scenario: User can delete volunteer vacancies
    Given I click volunteer vacancies menu
    When I Click icon Delete on the action coloumn volunteer vacancies
    And I click button Ya Hapus volunteer vacancies
    Then Should receive message Berhasil mengapus lowongan volunteer
          
	@View5newsData
  Scenario: User can view 5 volunteer vacancies data
    Given I click volunteer vacancies menu
    When I click dropdown and click 5 volunteer vacancies
    Then I received a display of 5 volunteer vacancies data
    
  @Movingpage
  Scenario: User can move page volunteer vacancies using pagination button 
    Given I click volunteer vacancies menu
    When I click button panigation volunteer vacancies
    Then Should direct to page 2 of the volunteer vacancies

	@SearchFundraising
  Scenario Outline: User can search volunteer vacancies
    Given I click volunteer vacancies menu
    When I Input spesific volunteer vacancies search field <search>
    Then I should be show data that match with inputted data
    Examples: 
      | search   |	
      | Membantu |
      
  @SearchFundraising
  Scenario Outline: User can search volunteer vacancies with DATA NOT FOUND
    Given I click volunteer vacancies menu
    When I Input spesific volunteer vacancies search field <search>
    Then I should be show data that match with inputted data no found
    Examples: 
      | search    |
      | Invalid   |