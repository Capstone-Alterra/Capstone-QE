import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor


class StepDefinition {
	// User success login
	@Given("I am on the login page")
	def OnLoginPage() {
		String loginPageUrl = 'https://dev-raihpeduli.netlify.app/login'
		WebUI.openBrowser(loginPageUrl)
		WebUI.maximizeWindow()
		WebUI.verifyElementVisible(findTestObject('LoginPage/Validation Login Page'))
	}
	@When("I enter my (.*) and (.*)")
	def InputValidEmailAndValidPassword(String email, String password) {
		WebUI.setText(findTestObject('LoginPage/email'), email)
		WebUI.setText(findTestObject('LoginPage/password'), password)
	}
	@And("I click login button")
	def clickLoginButton() {
		WebUI.click(findTestObject('LoginPage/btn-login'))
	}
	@Then("I should successfully log in to my account")
	def VerifyStepSuccessLogin() {
		WebUI.verifyElementVisible(findTestObject('Dashboard/IconRaihPeduli'))
	}

	//User failed login with wrong Email
	@When("I enter an invalid (.*) and valid (.*)")
	def EnterAInvalidEmailAndValidPassword(String email, String password) {
		WebUI.setText(findTestObject('LoginPage/email'), email)
		WebUI.setText(findTestObject('LoginPage/password'), password)
	}
	@Then("I should not be able to login successfully")
	def VerifyStepInvalidEmail() {
		WebUI.verifyElementVisible(findTestObject('LoginPage/Login failed. Please check your credentials'))
	}

	//User failed login with wrong password
	@When("I enter valid (.*) and Invalid (.*)")
	def EnterValidEmailAndInvalidPassword(String email, String password) {
		WebUI.setText(findTestObject('LoginPage/email'), email)
		WebUI.setText(findTestObject('LoginPage/password'), password)
	}

	//User failed login with wrong password <8 digit
	@When("I enter (.*) and Invalid (.*) less than eight digit")
	def InvalidPasswordMin8Digit(String email, String password) {
		WebUI.setText(findTestObject('LoginPage/email'), email)
		WebUI.setText(findTestObject('LoginPage/password'), password)

	}

	//User failed login with empty Email
	@When("I enter (.*) and let my email empty")
	def InvalidEmailEmpty(String password) {
		WebUI.setText(findTestObject('LoginPage/password'), password)
	}
	@Then("I should receive an error message that email is required")
	def VerifyStepEmailRequired() {
		WebUI.verifyElementVisible(findTestObject('LoginPage/Email tidak boleh kosong'))
	}

	//User failed login with empty Password
	@When("I enter (.*) and let my password empty")
	def InvalidEmptyPassword(String email) {
		WebUI.setText(findTestObject('LoginPage/email'), email)
	}
	@Then("I should receive an error message that password is required")
	def VerifyStepInvalidEmptyPassword() {
		WebUI.verifyElementVisible(findTestObject('LoginPage/Password tidak boleh kosong'))
	}

	//User failed to login with empty Email and empty password
	@Then("I should receive an error message that email and password are required")
	def InvalidEmptyEmailandpassword() {
		WebUI.verifyElementVisible(findTestObject('LoginPage/Email tidak boleh kosong'))
		WebUI.verifyElementVisible(findTestObject('LoginPage/Password tidak boleh kosong'))
	}

	//User failed login with only space in the Email field
	@When("I enter (.*) with space and valid (.*)")
	def EnterAInvalidEmailWithSpace(String email, String password) {
		WebUI.setText(findTestObject('LoginPage/email'), email)
		WebUI.setText(findTestObject('LoginPage/password'), password)
	}
	@Then("I should not be able to login")
	def EmailNotValid() {
		WebUI.verifyElementVisible(findTestObject('LoginPage/Penggunaan Email Tidak Valid'))
	}

	//User failed login with wrong Email Without
	@When("I enter invalid (.*) without @ and valid (.*)")
	def EnterInvalidEmailWithout(String email, String password){
		WebUI.setText(findTestObject('LoginPage/email'), email)
		WebUI.setText(findTestObject('LoginPage/password'), password)
	}


	//	FUNDRAISING
	//	FUNDRAISING
	//	FUNDRAISING
	//	FUNDRAISING
	//	FUNDRAISING
	//	FUNDRAISING
	//toFundraisingpage
	@And("I click Fundraising menu")
	def IClickFundraisingMenu() {
		WebUI.click(findTestObject('Fundraising/navigate-to-fundraise'))
	}
	@Then("I should be on the fundraising page")
	def OnFundraisingpage() {
		WebUI.verifyElementVisible(findTestObject('Fundraising/btn-add-fundraise'))
	}

	//validsearch
	@When("I Input spesific Fundraising search field (.*)")
	def searchValid(String search){
		WebUI.setText(findTestObject('Fundraising/input-search-fundraise'), search)
	}
	@Then("I should be show data that match with inputted data")
	def showdatathatmatch() {
		WebUI.verifyElementVisible(findTestObject('Fundraising/ValidateValidSearch'))
	}

	//invalidsearch
	@Then("I should be show data that match with inputted data no found")
	def showdatanotfound() {
		WebUI.verifyElementVisible(findTestObject('Fundraising/ValidateSearchNotFound'))
	}

	//	User can add fundraising
	@When("I click add button fundraising")
	def AddButtonFundraising(){
		WebUI.click(findTestObject('Fundraising/btn-add-fundraise'))
	}
	@And("I on the add fundraising page")
	def Onfundraisingpage(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/btn-action-tambah di add Fundraise'))
	}
	@And("I input valid judul (.*) fundraising")
	def ValidJudul(String judul){
		WebUI.setText(findTestObject('Fundraising/input-fundraise-title'), judul)
	}
	@And("I input valid deskripsi (.*) fundraising")
	def ValidDeskripsi(String deskripsi){
		WebUI.setText(findTestObject('fundraising/input-fundraise-description'), deskripsi)
	}
	@And("I input valid target (.*) fundraising")
	def ValidTarget(String target){
		WebUI.setText(findTestObject('Fundraising/input-fundraise-target'), target)
	}
	@And("I input valid tanggal mulai")
	def ValidTanggalmulai(){
		WebUI.scrollToElement(findTestObject('Fundraising/btn-action-tambah di add Fundraise'), 0)
		WebUI.click(findTestObject('Fundraising/Tanggal mulai/input-fundraise-start-date'))
		WebUI.click(findTestObject('Fundraising/Tanggal mulai/Select 23 Desember 2023'))
	}
	@And("I input valid tanggal selesai 2 februari 2024")
	def ValidTanggalselesai(){
		WebUI.click(findTestObject('Fundraising/Tanggal selesai/input-fundraise-end-date'))
		WebUI.click(findTestObject('Fundraising/Tanggal selesai/Ganti bulan kedepan'))
		WebUI.click(findTestObject('Fundraising/Tanggal selesai/Ganti bulan kedepan'))
		WebUI.click(findTestObject('Fundraising/Tanggal selesai/Select 2 februari 2024'))
	}
	@And("I input valid image on fundraising")
	def ValidImage(){
		WebUI.uploadFile(findTestObject('Fundraising/input-fundraise-image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\Foto Jpg.jpg')
	}
	@And("I click button simpan")
	def ButtonSimpan(){
		WebUI.click(findTestObject('Fundraising/btn-action-tambah di add Fundraise'))
	}
	@Then("I should have received a success message")
	def ReceivedSuccessMessage(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/btn-add-fundraise'))
	}

	// User cannot add fundraising if Judul less than 20 character
	@And("I input (.*) less than 20 character")
	def AddJudulLessThan20(String judul){
		WebUI.setText(findTestObject('Fundraising/input-fundraise-title'), judul)
	}
	@And("I input valid tanggal selesai 29 desember 2023")
	def ValidTanggalselesai29Des(){
		WebUI.click(findTestObject('Fundraising/Tanggal selesai/input-fundraise-end-date'))
		WebUI.click(findTestObject('Fundraising/Tanggal selesai/Select 29 desember 2023'))
	}
	@Then("I should have received a error message Judul minimal 20 karakter")
	def ReceivedError20karakterMessage(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Judul less than 20 karakter'))
	}

	// User cannot add fundraising with empty Title
	@Then("I should have received a error message Kolom judul penggalangan dana harus diisi")
	def JudulEmpty(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Kolom judul harus diisi'))
	}

	// User cannot add fundraising if Deskripsi less than 50 character
	@And("I input (.*) less than 50 character")
	def AddDeskripsiLessThan50(String deskripsi){
		WebUI.setText(findTestObject('Fundraising/input-fundraise-description'), deskripsi)
	}
	@Then("I should have received a error message Deskripsi minimal 50 karakter")
	def Deskripsi50karakter(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Deskripsi penggalangan dana minimal 50 karakter'))
	}

	// User cannot add a fundraising with empty Description
	@Then("I should have received a success message Kolom deskripsi penggalangan dana harus diisi")
	def DeskripsiEmpty(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Kolom deskripsi harus di isi'))
	}

	// ser cannot add a fundraising with empty target
	@Then("I should have received a error message Kolom target penggalangan dana harus diisi")
	def TargetEmpty(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Kolom target harus diisi'))
	}

	// User cannot add a fundraising with empty start date
	@Then("I should have received a error message Masukkan tanggal mulai penggalangan dana")
	def TanggalMulaiEmpty(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Kolom tanggal mulai harus diisi'))
	}

	// User cannot add a fundraising with empty end date
	@Then("I should have received a error message Masukkan tanggal berakhir penggalangan dana")
	def TanggalSelesaiEmpty(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Kolom tanggal selesai harus diisi'))
	}

	// User cannot add a fundraising with empty Image
	@Then("I should have received a error message Kolom foto penggalangan dana harus diisi")
	def ImageEmpty(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Kolom foto harus diisi'))
	}

	// User cannot add a fundraiser with all fields empty
	@Then("I should have received a error message on all fields")
	def AllFieldEmpty(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Kolom judul harus diisi'))
		WebUI.verifyElementVisible(findTestObject('Fundraising/Kolom deskripsi harus di isi'))
		WebUI.verifyElementVisible(findTestObject('Fundraising/Kolom target harus diisi'))
		WebUI.verifyElementVisible(findTestObject('Fundraising/Kolom tanggal mulai harus diisi'))
		WebUI.verifyElementVisible(findTestObject('Fundraising/Kolom tanggal selesai harus diisi'))
		WebUI.verifyElementVisible(findTestObject('Fundraising/Kolom foto harus diisi'))
	}

	// User cannot add a fundraising if the end date is earlier than the start date
	@And("I input valid tanggal mulai 30 desember 2023")
	def Tanggalmulai30desember(){
		WebUI.scrollToElement(findTestObject('Fundraising/btn-action-tambah di add Fundraise'), 0)
		WebUI.click(findTestObject('Fundraising/Tanggal mulai/input-fundraise-start-date'))
		WebUI.click(findTestObject('Fundraising/Tanggal mulai/Select 30 Desember 2023'))
	}
	@And("I input tanggal selesai earlier than the start date")
	def ValidTanggalselesaiearlier(){
		WebUI.click(findTestObject('Fundraising/Tanggal selesai/input-fundraise-end-date'))
		WebUI.click(findTestObject('Fundraising/Tanggal selesai/Select 29 desember 2023'))
	}
	@Then("I should have received a error message Tanggal selesai tidak boleh kurang dari tanggal mulai")
	def TanggalSelesaiEarlier(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Tanggal selesai/Tanggal selesai tidak boleh kurang dari tanggal mulai'))
	}

	// User cannot add fundraising using dot (.) in the target field
	@And("I input target (.*) fundraising using dot")
	def TargetUsingdot(String target){
		WebUI.setText(findTestObject('Fundraising/input-fundraise-target'), target)
	}

	// User cannot add fundraiser if the image file is not JPG, PNG, and JPEG
	@And("I input file txt on image fundraising")
	def Imagetxt(){
		WebUI.uploadFile(findTestObject('Fundraising/input-fundraise-image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\Txt.txt')
	}
	@Then("I should have received a error message Format gambar harus .jpg, .png, .jpeg")
	def FormatGambarFudraising(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/format gambar'))
	}

	// user cannot add fundraisers with a target of less than IDR 100
	@And("I input target (.*) fundraising less than IDR 100")
	def TargetLessThan100(String target){
		WebUI.setText(findTestObject('Fundraising/input-fundraise-target'), target)
	}
	@Then("I should have received a error message Jumlah target minimum Rp100")
	def MessageTargetMinimum(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Target Minimal 100'))
	}

	// User cannot add fundraisers with images larger than 5mb
	@And("I input image larger than 5MB on fundraising")
	def Imagelargerthan5mb(){
		WebUI.uploadFile(findTestObject('Fundraising/input-fundraise-image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\foto 20mb.jpg')
	}
	@Then("I should have received a error message Ukuran gambar maksimal 5MB")
	def ukuranGambarFudraising(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/format gambar'))
	}

	// EDIT
	// User can edit fundraiser
	@When("Click icon edit on the action coloumn")
	def EditButtonFundraising(){
		WebUI.click(findTestObject('Fundraising/Button edit'))
	}
	@And("I on the fundraising edit page")
	def OnfundraisingEditpage(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/On edit page'))
	}
	@And("I edit valid judul (.*) fundraising")
	def editValidJudul(String judul){
		WebUI.clearText(findTestObject('Fundraising/input-fundraise-title'))
		WebUI.setText(findTestObject('Fundraising/input-fundraise-title'), judul)
	}
	@And("I edit valid deskripsi (.*) fundraising")
	def editValidDeskripsi(String deskripsi){
		WebUI.clearText(findTestObject('Fundraising/input-fundraise-description'))
		WebUI.setText(findTestObject('Fundraising/input-fundraise-description'), deskripsi)
	}
	@And("I edit valid target (.*) fundraising")
	def editValidTarget(String target){
		WebUI.clearText(findTestObject('Fundraising/input-fundraise-target'))
		WebUI.setText(findTestObject('Fundraising/input-fundraise-target'), target)
	}
	@And("I edit valid tanggal mulai")
	def editValidTanggalmulai(){
		WebUI.scrollToElement(findTestObject('Fundraising/btn-action-tambah di add Fundraise'), 0)
		WebUI.click(findTestObject('Fundraising/Tanggal mulai/input-fundraise-start-date'))
		WebUI.click(findTestObject('Fundraising/Tanggal mulai/Select 24 Desember 2023'))
	}
	@And("I edit valid image on fundraising")
	def editValidImage(){
		WebUI.uploadFile(findTestObject('Fundraising/input-fundraise-image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\Masjid.jpg')
	}
	@And("I click a button edit data")
	def ButtonEditData(){
		WebUI.click(findTestObject('Fundraising/btn-action-tambah di edit Fundraise'))
	}
	@Then("I should receive an edit success message")
	def ReceivedSuccesseditMessage(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/btn-add-fundraise'))
	}

	// User cannot Edit fundraising if Judul penggalangan dana less than 20 characters
	@And("I edit fundraising (.*) less than 20 characters")
	def EditJudulLessThan20(String judul){
		WebUI.clearText(findTestObject('Fundraising/input-fundraise-title'))
		WebUI.setText(findTestObject('Fundraising/input-fundraise-title'), judul)
	}
	@Then("I should have received a error message Judul penggalangan dana minimal 20 karakter")
	def ReceivedError20CharactersMessage(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Judul less than 20 karakter'))
	}

	// User cannot edit fundraising with empty Title
	@And("I edit judul to blank")
	def JudulBlank(){
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-title'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-title'), Keys.chord(Keys.BACK_SPACE))
	}

	// User cannot edit a fundraising with empty Description
	@And("I edit deskripsi to blank")
	def DeskripsiBlank(){
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-description'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-description'), Keys.chord(Keys.BACK_SPACE))
	}

	// User cannot edit a fundraising with empty target
	@And("I edit target to blank")
	def targetBlank(){
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-target'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-target'), Keys.chord(Keys.BACK_SPACE))
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-target'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-target'), Keys.chord(Keys.BACK_SPACE))
	}

	// User cannot edit a fundraiser with all fields empty
	@Then("I should have received a error message on fields")
	def ReceivedErrorMessage(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Target Minimal 100'))
	}

	// User cannot edit a fundraising if the end date is earlier than the start date
	@And("I edit tanggal mulai 29 desember 2023")
	def ValidTanggalmulaiear29desember2023(){
		WebUI.click(findTestObject('Fundraising/Tanggal mulai/input-fundraise-start-date'))
		WebUI.click(findTestObject('Fundraising/Tanggal mulai/Select 29 desember 2023'))
	}
	@And("I edit tanggal selesai 25 desember 2023")
	def ValidTanggalselesai25desember2023(){
		WebUI.click(findTestObject('Fundraising/Tanggal selesai/input-fundraise-end-date'))
		WebUI.click(findTestObject('Fundraising/Tanggal selesai/Select 25 desember 2023'))
	}

	// User cannot edit fundraiser if the image file is not JPG, PNG, and JPEG
	@And("I edit image with file txt")
	def editimagetxt(){
		WebUI.uploadFile(findTestObject('Fundraising/input-fundraise-image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\Txt.txt')
	}

	// User cannot edit fundraising using dot (.) in the target field
	@And("I edit target (.*) fundraising with dot")
	def EditTargetUsingdot(String target){
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-target'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-target'), Keys.chord(Keys.BACK_SPACE))
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-target'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-target'), Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(findTestObject('Fundraising/input-fundraise-target'), target)
	}

	// user cannot edit fundraisers with a target of less than IDR 100
	@And("I edit target (.*) fundraising less than IDR 100")
	def EditTargetLessThan100(String target){
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-target'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-target'), Keys.chord(Keys.BACK_SPACE))
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-target'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-target'), Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(findTestObject('Fundraising/input-fundraise-target'), target)
	}

	// User cannot EDIT fundraisers with images larger than 5mb
	@And("I edit image larger than 5mb")
	def EditImagelargerthan5mb(){
		WebUI.uploadFile(findTestObject('Fundraising/input-fundraise-image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\foto 20mb.jpg')
	}

	// User cannot edit fundraising if Deskripsi less than 50 character
	@And("I edit fundraising deskripsi (.*) less than 50 characters")
	def EditDeskripsiLessThan50(String deskripsi){
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-description'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Fundraising/input-fundraise-description'), Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(findTestObject('Fundraising/input-fundraise-description'), deskripsi)
	}

	// user cancel delete data fundraising
	@And("I click button delete fundraising")
	def ButtonDeletefundraising() {
		WebUI.click(findTestObject('Fundraising/Button delete'))
	}
	@And("I click button batal")
	def ButtonBatalhapusfundraising() {
		WebUI.click(findTestObject('Fundraising/Button batal delete'))
	}
	@Then("I shouldn't have deleted the fundraiser")
	def Tidakmenghapusdata(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Button delete'))
	}

	// user delete data fundraising
	@And("I click button Ya hapus fundraising")
	def ButtonBatalyahapusfundraising() {
		WebUI.click(findTestObject('Fundraising/Button ya hapus'))
	}
	@Then("I should have received a success delete message")
	def receivemessage(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Button delete'))
	}

	// User accepts fundraising
	@When("I Click icon detail on the action coloumn")
	def ButtonDetailfundraising() {
		WebUI.click(findTestObject('Fundraising/Button detail'))
	}
	@And("I on the detail fundraising page")
	def OnDetailFundraising() {
		WebUI.click(findTestObject('Fundraising/OnDetail'))
	}
	@And("I Click button Terima")
	def ClickButtonTerima() {
		WebUI.click(findTestObject('Fundraising/Button terima'))
	}
	@Then("I should have received a success message Berhasil mengupdate status penggalangan dana")
	def Berhasilupdatestatus(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Success Terima'))
	}

	// User cannot reject fundraising if do not fill a reason
	@And("I Click button Tolak")
	def ClickButtonTolak() {
		WebUI.click(findTestObject('Fundraising/Button tolak'))
	}
	@And("I Click button tolak on reason page")
	def ClickButtonTolakReason() {
		WebUI.click(findTestObject('Fundraising/Button tolak reason'))
	}
	@Then("I should have received a error message Kolom harus diisi")
	def KolomHarusDiisi(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Kolom harus diisi'))
	}

	// User cannot reject fundraising if input reason less than 20 characters
	@Given("I input reason (.*) less than 20 characters")
	def ReasonLessThan20(String reason){
		WebUI.setText(findTestObject('Fundraising/input reason'), reason)
	}
	@Then("I should have received a error message Alasan penolakan minimal 20 karakter")
	def ReasonAlert20karakter(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/Kolom harus diisi'))
	}

	// User reject fundraising
	@Given("I input valid reason (.*) for reject fundraising")
	def ValidReason(String reason){
		WebUI.setText(findTestObject('Fundraising/input reason'), reason)
	}

	// User reject fundraising
	@Then("I should have receive a success message Berhasil mengupdate status penggalangan dana")
	def mengupdate(){
		WebUI.verifyElementVisible(findTestObject('Fundraising/btn-add-fundraise'))
	}

	// User can view 50 fundraising data reject fundraising
	@And("I click dropdown and click 50 data")
	def clickDropdown() {
		WebUI.click(findTestObject('Fundraising/Click dropdown'))
		WebUI.click(findTestObject('Fundraising/Click 50 data'))
		WebUI.scrollToElement(findTestObject('Fundraising/Validate-50Data'), 0)
	}
	@Then("I received a display of 50 fundraising data")
	def validate50DataFundraising() {
		WebUI.verifyElementVisible(findTestObject('Fundraising/btn-add-fundraise'))
	}

	// User can move page fundraising using pagination button
	@When("I click button panigation fundraising")
	def ButtonPanigationfundraising() {
		WebUI.scrollToElement(findTestObject('Fundraising/button-pagination'), 0)
		WebUI.click(findTestObject('Fundraising/button-pagination'))
	}
	@Then("Should direct to page 2 of the fundraising")
	def page2fundraising() {
		WebUI.verifyElementVisible(findTestObject('Fundraising/btn-add-fundraise'))
	}

	// User can Export Csv
	@When("I click button ekspor csv")
	def ButtonCSVfundraising() {
		WebUI.click(findTestObject('Fundraising/Ekspor csv'))
	}
	@Then("I should have received a success message berhasil mengekspor csv")
	def successmessageeksporcsv() {
		WebUI.delay(10)
		WebUI.verifyElementVisible(findTestObject('Fundraising/Success Terima'))
	}


	//	CUSTOMER
	//	CUSTOMER
	//	CUSTOMER
	//	CUSTOMER
	//	CUSTOMER
	//	CUSTOMER
	//	ToCustomerPage
	@And("I click Customer menu")
	def IClickCustomerMenu() {
		WebUI.click(findTestObject('Customer/navigate-to-user'))
	}
	@Then("I should be on the Customer page")
	def OnCustomerpage() {
		WebUI.verifyElementVisible(findTestObject('Customer/OnListCustomer'))
	}

	// Minimisedmenu
	@When("Click hamburger button")
	def HumbergerButton() {
		WebUI.click(findTestObject('Dashboard/HamburgerButton'))
	}
	@Then("Minimised menu")
	def Minimisedmenu() {
		WebUI.verifyElementVisible(findTestObject('Customer/navigate-to-user'))
	}

	// MovingPage
	@When("I click button panigation")
	def ButtonPanigation() {
		WebUI.scrollToElement(findTestObject('Customer/button-pagination-customer-1'), 0)
		WebUI.click(findTestObject('Customer/button-pagination-customer-1'))
	}
	@Then("Should direct to page 2 of the customer")
	def page2() {
		WebUI.verifyElementVisible(findTestObject('Customer/OnListCustomer'))
	}

	// Edit Success
	@When("I click edit button customer 11")
	def Customer11() {
		WebUI.scrollToElement(findTestObject('Customer/OnListCustomer'), 0)

		WebUI.click(findTestObject('Customer/Edit-Customer-11'))
	}
	@And("I on the customer edit page")
	def editpage() {
		WebUI.verifyElementVisible(findTestObject('Customer/OnEditPage'))
	}
	@And("I  input valid email (.*)")
	def InputValidEmail(String email) {
		WebUI.clearText(findTestObject('Customer/FieldEmail'))
		WebUI.setText(findTestObject('Customer/FieldEmail'), email)
	}
	@And("I input valid fullname (.*)")
	def InputValidfullname(String fullname) {
		WebUI.clearText(findTestObject('Customer/FieldFullname'))
		WebUI.setText(findTestObject('Customer/FieldFullname'), fullname)
	}
	@And("I input valid Alamat (.*)")
	def InputValidAlamat(String Alamat) {
		WebUI.clearText(findTestObject('Customer/FieldAddress'))
		WebUI.setText(findTestObject('Customer/FieldAddress'), Alamat)
	}
	@And("I input valid Handphone (.*)")
	def InputValidNoHandphone(String Handphone) {
		WebUI.clearText(findTestObject('Customer/FieldNoHandphone'))
		WebUI.setText(findTestObject('Customer/FieldNoHandphone'), Handphone)
	}
	@And("I input valid gender (.*)")
	def InputValidgender(String gender) {
		WebUI.clearText(findTestObject('Customer/FieldGender'))
		WebUI.setText(findTestObject('Customer/FieldGender'), gender)
	}
	@And("I input valid image")
	def InputValidImage() {
		WebUI.uploadFile(findTestObject('Customer/FieldImage'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\foto orang.jpg')
	}
	@And("I click button edit data")
	def ClickButtonEditOnEditCustomerPage() {
		WebUI.click(findTestObject('Customer/Button-Edit data'))
	}
	@Then("I should have received a success edit customer message")
	def successeditcustomer() {
		WebUI.verifyElementVisible(findTestObject('Customer/SuccessEditCustomer'))
	}

	// Display 5 Data Customer
	@When("I click dropdown and click 5")
	def ClickDropdownAndClick5() {
		//		WebUI.click(findTestObject('Dashboard/HamburgerButton'))
		WebUI.scrollToElement(findTestObject('Customer/DropdownShowData'), 0)
		WebUI.click(findTestObject('Customer/DropdownShowData'))
		WebUI.click(findTestObject('Customer/View5Data'))
	}
	@Then("I received a display of 5 customer data")
	def DisplayOf5CustomerData() {
		WebUI.verifyElementVisible(findTestObject('Customer/OnListCustomer'))
	}

	// User cannot Edit Fullname with special character
	@When("I click edit button customer 5")
	def Customer5() {
		WebUI.scrollToElement(findTestObject('Customer/OnListCustomer'), 0)
		WebUI.click(findTestObject('Customer/Edit-Customer-5'))
	}
	@And("I input Fullname with special character (.*)")
	def InputFullnamewithspecialcharacter(String fullname) {
		WebUI.clearText(findTestObject('Customer/FieldFullname'))
		WebUI.setText(findTestObject('Customer/FieldFullname'), fullname)
	}
	@Then("Should show error message Nama lengkap harus alfabet")
	def Namalengkapharusalfabet() {
		WebUI.verifyElementVisible(findTestObject('Customer/Nama Lengkap harus alfabet'))
	}

	// User cannot Edit Fullname with number
	@And("I input Fullname with number (.*)")
	def InputFullnamewithnumber(String fullname) {
		WebUI.clearText(findTestObject('Customer/FieldFullname'))
		WebUI.setText(findTestObject('Customer/FieldFullname'), fullname)
	}

	//User cannot edit customer data if the Phone number less than 10 digits
	@And("I input Phone number less than 10 digits (.*)")
	def InputPhonenumberlessthan10(String Handphone) {
		WebUI.clearText(findTestObject('Customer/FieldNoHandphone'))
		WebUI.setText(findTestObject('Customer/FieldNoHandphone'), Handphone)
	}
	@Then("Should show Error message Kolom No. Handphone minimal 10 karakter")
	def NomorHandphoneminimal10() {
		WebUI.verifyElementVisible(findTestObject('Customer/No Handphone minimal 10 digit'))
	}

	//User cannot edit customer data with special characters on mobile phone numbers
	@And("I input special characters on mobile phone numbers (.*)")
	def InputPhonenumberspecialcharacters(String Handphone) {
		WebUI.clearText(findTestObject('Customer/FieldNoHandphone'))
		WebUI.setText(findTestObject('Customer/FieldNoHandphone'), Handphone)
	}
	@Then("Should show Error message Kolom harus berisi angka")
	def NomorHandphoneHarusdiisi() {
		WebUI.verifyElementVisible(findTestObject('Customer/Kolom harus berisi angka on field phone number'))
	}

	//User cannot edit a customers' mobile phone number if it is more than 13.
	@And("I input more than 13 digit on mobile phone numbers (.*)")
	def InputPhonenumbermorethan13digit(String Handphone) {
		WebUI.clearText(findTestObject('Customer/FieldNoHandphone'))
		WebUI.setText(findTestObject('Customer/FieldNoHandphone'), Handphone)
	}
	@Then("Should show Error message Kolom No Handphone maksimal 13 karakter")
	def NomorHandphoneMaksimal13digit() {
		WebUI.verifyElementVisible(findTestObject('Customer/Nomor Handphone maksimal 13 digit'))
	}

	//user cannot edit the subscriber if the email uses spaces
	@And("I input email with space (.*)")
	def InputEmailWithSpace(String email) {
		WebUI.clearText(findTestObject('Customer/FieldEmail'))
		WebUI.setText(findTestObject('Customer/FieldEmail'), email)
	}
	@Then("Should show Error message Format email tidak valid")
	def FormatEmailTidakValid() {
		WebUI.verifyElementVisible(findTestObject('Customer/Format email tidak valid'))
	}

	//user cannot edit customer if email does not exist @
	@And("I input email without @ (.*)")
	def InputEmailWithout(String email) {
		WebUI.clearText(findTestObject('Customer/FieldEmail'))
		WebUI.setText(findTestObject('Customer/FieldEmail'), email)
	}

	// User cannot edit customer with foto larger than 5mb
	@And("I input image larger than 5mb customer")
	def InputImageLargerthan5mbCustomer() {
		WebUI.uploadFile(findTestObject('Customer/FieldImage'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\foto 20mb.jpg')
	}
	@Then("Should show Error message Ukuran gambar maksimal 5MB customer")
	def GambarMaksimal5MBCustomer() {
		WebUI.verifyElementVisible(findTestObject('Customer/GambarMaksimal5MB'))
	}

	// User cannot edit customer with foto larger than 5mb
	@And("I input image with file is not JPG, PNG, and JPEG customer")
	def InputImagetxtCustomer() {
		WebUI.uploadFile(findTestObject('Customer/FieldImage'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\Txt.txt')
	}
	@Then("Should show Error message Format gambar harus .jpg, .png, .jpeg")
	def FormatgambarCustomer() {
		WebUI.verifyElementVisible(findTestObject('Customer/FormatGambar'))
	}
	@And("I clear email")
	def clearEmail() {
		WebUI.sendKeys(findTestObject('Customer/FieldEmail'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Customer/FieldEmail'), Keys.chord(Keys.BACK_SPACE))
	}
	@And("I clear fullname")
	def clearfullname() {
		WebUI.sendKeys(findTestObject('Customer/FieldFullname'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Customer/FieldFullname'), Keys.chord(Keys.BACK_SPACE))
	}
	@And("I clear Alamat")
	def clearAlamat() {
		WebUI.sendKeys(findTestObject('Customer/FieldAddress'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Customer/FieldAddress'), Keys.chord(Keys.BACK_SPACE))
	}
	@And("I clear Nomor Handphone")
	def clearNoHandphone() {
		WebUI.sendKeys(findTestObject('Customer/FieldNoHandphone'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Customer/FieldNoHandphone'), Keys.chord(Keys.BACK_SPACE))
	}
	@And("I clear gender")
	def cleargender() {
		WebUI.sendKeys(findTestObject('Customer/FieldGender'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Customer/FieldGender'), Keys.chord(Keys.BACK_SPACE))
	}
	@Then("Should show Error message")
	def Errormessage() {
		WebUI.verifyElementVisible(findTestObject('Customer/Kolom email wajib diisi'))
		WebUI.verifyElementVisible(findTestObject('Customer/Kolom Nama Lengkap harus diisi'))
		WebUI.verifyElementVisible(findTestObject('Customer/Kolom No. Handphone harus diisi'))
		WebUI.verifyElementVisible(findTestObject('Customer/Kolom Alamat harus diisi'))
		WebUI.verifyElementVisible(findTestObject('Customer/Kolom Jenis Kelamin harus diisi'))
	}

	// User cannot empty the customer email field
	@Then("Should show error message Kolom email wajib diisi")
	def EmailWajibDiisi() {
		WebUI.verifyElementVisible(findTestObject('Customer/Kolom email wajib diisi'))
	}

	// User cannot empty the customer Fullname field
	@Then("Should show error message Kolom Nama Lengkap harus diisi")
	def FullnameWajibDiisi() {
		WebUI.verifyElementVisible(findTestObject('Customer/Kolom Nama Lengkap harus diisi'))
	}

	// User cannot empty the customer Alamat field
	@Then("Should show error message Kolom Alamat harus diisi")
	def AlamatWajibDiisi() {
		WebUI.verifyElementVisible(findTestObject('Customer/Kolom Alamat harus diisi'))
	}

	// User cannot empty the customer No. Handphone field
	@Then("Should show error message Kolom No. Handphone harus diisi")
	def NoHandphoneWajibDiisi() {
		WebUI.verifyElementVisible(findTestObject('Customer/Kolom No. Handphone harus diisi'))
	}

	// User cannot empty the customer Jenis Kelamin field
	@Then("Should show error message Kolom Jenis Kelamin harus diisi")
	def genderWajibDiisi() {
		WebUI.verifyElementVisible(findTestObject('Customer/Kolom Jenis Kelamin harus diisi'))
	}

	// user cancel editing data
	@And("I click button kembali")
	def CancelEditCustomer() {
		WebUI.click(findTestObject('Customer/Button-Kembali'))
	}

	// user delete data customer
	@When("I click dropdown and click 50")
	def ClickDropdownAndClick50() {
		WebUI.scrollToElement(findTestObject('Customer/DropdownShowData'), 0)
		WebUI.click(findTestObject('Customer/DropdownShowData'))
		WebUI.click(findTestObject('Customer/View50Data'))
	}
	@And("I click edit button customer 52")
	def Deleteuser52() {
		WebUI.scrollToElement(findTestObject('Customer/OnListCustomer'), 0)
		WebUI.click(findTestObject('Customer/Delete-Customer'))
	}
	@And("I click button Ya hapus customer")
	def ButtonYaHapusCustomer() {
		WebUI.click(findTestObject('Customer/Button Ya Hapus'))
	}

	// user cancel delete data customer
	@And("I click button batal customer")
	def ButtonBatalhapusCustomer() {
		WebUI.click(findTestObject('Customer/Button Batal delete'))
	}

	//validsearchcustomer
	@When("I Input spesific customer search field (.*)")
	def searchValidCustomer(String search){
		WebUI.setText(findTestObject('fundraising/input-search-fundraise'), search)
	}
	@Then("should be show data customer that match with inputted data")
	def showdatathatmatchCustomer() {
		WebUI.delay(5)
		WebUI.verifyElementVisible(findTestObject('fundraising/ValidateValidSearch'))
	}

	//invalidsearchcustomer
	@Then("should be show data that match with inputted data no found customer")
	def showdatanotfoundcustomer() {
		WebUI.verifyElementVisible(findTestObject('fundraising/ValidateSearchNotFound'))
	}

	// TRANSAKSI
	// TRANSAKSI
	// TRANSAKSI
	// TRANSAKSI
	// TRANSAKSI
	// TRANSAKSI
	//User success open transaction page
	@And("I click transaction menu")
	def IClicktransactionMenu() {
		WebUI.click(findTestObject('Transaction/navigate-to-transaction'))
	}
	@Then("I should be on the transaction page")
	def OnTransactionpage() {
		WebUI.verifyElementVisible(findTestObject('Transaction/On-Transaction-Page'))
	}

	// User can view detail transaction
	@When("I click button detail transaction")
	def buttondetailtransaction() {
		WebUI.click(findTestObject('Transaction/btn-detail-transaksi-1895605'))
	}
	@Then("Should direct to detail transaksi page")
	def Ondetailtransaksipage() {
		WebUI.verifyElementVisible(findTestObject('Transaction/On-Detail-Transaction'))
	}

	//	//searchtransaction
	//	@When("I Input spesific transaction search field (.*)")
	//	def searchValidTransaction(String search){
	//		WebUI.setText(findTestObject('fundraising/input-search-fundraise'), search)
	//	}

	// User can go to the fundraiser using the fundraiser title in the transaction details
	@When("Click fundraiser title")
	def Clickfundraisertitle() {
		WebUI.click(findTestObject('Transaction/ClickJudulPenggalanganDana'))
	}
	@Then("Should direct to detail fundraiser")
	def Ondetailfundraiserpage() {
		WebUI.verifyElementVisible(findTestObject('Fundraising/On-Detail-Penggalangan-Dana'))
	}

	// User can view 5 Transaction data
	@When("I click dropdown and click 5 transaction")
	def ClickDropdownAndClick5transaction() {
		WebUI.scrollToElement(findTestObject('Transaction/ClickDropdown'), 0)
		WebUI.click(findTestObject('Transaction/ClickDropdown'))
		WebUI.click(findTestObject('Transaction/View5Data'))
	}
	@Then("I received a display of 5 transaction data")
	def DisplayOf5transactionData() {
		WebUI.verifyElementVisible(findTestObject('Transaction/On-Transaction-Page'))
	}

	// logout
	@Given("User click the Hi, Admin dropdown!")
	def ClickHi() {
		WebUI.click(findTestObject('Logout/HiAdmin'))
	}
	@Given("I click button keluar")
	def ButtonKeluar() {
		WebUI.click(findTestObject('Logout/Button Logout'))
	}
	@Then("I should successfully Direct to Login page")
	def DirectToLogin() {
		WebUI.verifyElementVisible(findTestObject('LoginPage/Validation Login Page'))
	}


	// NEWS
	// NEWS
	// NEWS
	// NEWS
	// NEWS
	// NEWS

	// User success open News page
	@And("I click news menu")
	def IClickNewsMenu() {
		WebUI.click(findTestObject('News/navigate-to-news'))
	}
	@Then("I should be on the news page")
	def OnNewspage() {
		WebUI.verifyElementVisible(findTestObject('News/On news page'))
	}

	//Valid search
	@When("I Input spesific news search field (.*)")
	def searchValidNews(String search){
		WebUI.setText(findTestObject('fundraising/input-search-fundraise'), search)
	}
	@Then("should be show data news that match with inputted data")
	def showdatathatmatchnews() {
		WebUI.delay(5)
		WebUI.verifyElementVisible(findTestObject('fundraising/ValidateValidSearch'))
	}

	// MovingPage
	@When("I click button panigation news")
	def ButtonPanigationnews() {
		WebUI.scrollToElement(findTestObject('Customer/button-pagination-customer-1'), 0)
		WebUI.click(findTestObject('Customer/button-pagination-customer-1'))
	}
	@Then("Should direct to page 2 of the news")
	def page2news() {
		WebUI.verifyElementVisible(findTestObject('Customer/OnListCustomer'))
	}

	// User can view 5 news data
	@When("I click dropdown and click 5 news")
	def ButtonDrop() {
		WebUI.scrollToElement(findTestObject('News/Dropdown'), 0)
		WebUI.click(findTestObject('News/Dropdown'))
		WebUI.click(findTestObject('News/View5Data'))
	}
	@Then("I received a display of 5 news data")
	def news5data() {
		WebUI.verifyElementVisible(findTestObject('News/On news page'))
	}

	// User can view detail news
	@When("I Click icon detail news on the action coloumn")
	def ButtonDetailNews() {
		WebUI.click(findTestObject('News/Button detail'))
	}
	@And("I should be on the detail News page")
	def OnDetailNews() {
		WebUI.click(findTestObject('News/OnDetail'))
	}

	// User can cancel delete news
	@When("I Click icon Delete on the action coloumn")
	def ButtonDeleteNews() {
		WebUI.click(findTestObject('News/Button delete'))
	}
	@And("I click button Batal")
	def ButtonBatal() {
		WebUI.click(findTestObject('News/Button Batal'))
	}

	// User can delete news
	@And("I click button Ya Hapus")
	def ButtonYahapus() {
		WebUI.click(findTestObject('News/Button Ya hapus'))
	}
	@Then("Should receive message Berhasil mengapus berita")
	def BerhasilMengapus() {
		WebUI.verifyElementVisible(findTestObject('News/On news page'))
	}

	// User can add news
	@When("I click button add news")
	def ButtonAddNews() {
		WebUI.click(findTestObject('News/AddBerita'))
	}
	@And("I input valid judul (.*) news")
	def inputValidJudul(String judul) {
		WebUI.setText(findTestObject('News/Judul'), judul)
	}
	@And("I input valid gambar")
	def ValidGambar(){
		WebUI.uploadFile(findTestObject('News/Image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\Sampah.jpg')
	}
	@And("I input valid deskripsi (.*) news")
	def inputValiddeskripsi(String deskripsi) {
		WebUI.setText(findTestObject('News/deskripsi'), deskripsi)
	}
	@And("I click button simpan news")
	def ButtonSimpanNews() {
		WebUI.click(findTestObject('News/Simpan'))
	}
	@Then("I should received message Success created news")
	def Successcreated() {
		WebUI.verifyElementVisible(findTestObject('News/Success'))
	}

	// User cannot add news with empty Title
	@Then("I should received error message Kolom judul berita harus diisi")
	def EmptyJudul() {
		WebUI.verifyElementVisible(findTestObject('News/AlertJudul'))
	}

	// User cannot add a news with empty Gambar
	@Then("I should received error message Kolom foto berita harus diisi")
	def EmptyGambar() {
		WebUI.verifyElementVisible(findTestObject('News/AlertGambar'))
	}

	// User cannot add a news with empty Description
	@Then("I should received error message Kolom deskripsi berita harus diisi")
	def EmptyDeskripsi() {
		WebUI.verifyElementVisible(findTestObject('News/AlertDeskripsi'))
	}

	// User cannot add news if the image file is not JPG, PNG, and JPEG
	@And("I input gambar with file txt")
	def GambarTxt(){
		WebUI.uploadFile(findTestObject('News/Image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\Txt.txt')
	}
	@Then("I should received error message Format gambar wajib JPG, JPEG, dan PNG")
	def ErrorGambartxt() {
		WebUI.verifyElementVisible(findTestObject('News/AlertGambar'))
	}

	// User cannot add a news if judul less than 20 characters
	@And("I input judul (.*) news less than 20 characters")
	def JudulLessThan20(String judul) {
		WebUI.setText(findTestObject('News/Judul'), judul)
	}
	@Then("I should received error message Kolom judul berita harus memiliki minimal 20 karakter")
	def ErrorJudulLessThan20() {
		WebUI.verifyElementVisible(findTestObject('News/AlertJudul'))
	}

	// User cannot add a news if deskripsi less than 50 characters
	@And("I input deskripsi (.*) news less than 50 characters")
	def DeskripsiLessThan50(String deskripsi) {
		WebUI.setText(findTestObject('News/deskripsi'), deskripsi)
	}
	@Then("I should received error message Kolom deskripsi berita harus memiliki minimal 50 karakter")
	def ErrorDeskripsiLessThan50() {
		WebUI.verifyElementVisible(findTestObject('News/AlertDeskripsi'))
	}

	// User cannot add a news if image large than 5mb
	@And("I input gambar news large than 5MB")
	def GambarLargeThan5MB(){
		WebUI.uploadFile(findTestObject('News/Image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\foto 20mb.jpg')
	}
	@Then("I should received error message Ukuran Gambar Maksimal 5MB")
	def ErrorGambarLargeThan5MB() {
		WebUI.verifyElementVisible(findTestObject('News/AlertGambar'))
	}

	// User cannot add a news if all fields empty
	@Then("I should received error message on field judul, gambar and deskripsi")
	def EmptyAllField() {
		WebUI.verifyElementVisible(findTestObject('News/AlertJudul'))
		WebUI.verifyElementVisible(findTestObject('News/AlertGambar'))
		WebUI.verifyElementVisible(findTestObject('News/AlertDeskripsi'))
	}

	// User can Edit news
	@When("I click icon Edit news on the action coloumn")
	def ButtonEditNews() {
		WebUI.click(findTestObject('News/Edit'))
	}
	@And("I edit valid judul (.*) news")
	def EditValidJudul(String judul) {
		WebUI.clearText(findTestObject('News/Judul'))
		WebUI.setText(findTestObject('News/Judul'), judul)
	}
	@And("I edit valid gambar")
	def EditGambar(){
		WebUI.uploadFile(findTestObject('News/Image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\BANJIR.jpg')
	}
	@And("I edit valid deskripsi (.*) news")
	def editValiddeskripsi(String deskripsi) {
		WebUI.clearText(findTestObject('News/deskripsi'))
		WebUI.setText(findTestObject('News/deskripsi'), deskripsi)
	}
	@And("I click button simpan edit")
	def ButtonSimpanEditNews() {
		WebUI.click(findTestObject('News/Simpan'))
	}
	@Then("I should received message Success update news")
	def Successupdate() {
		WebUI.verifyElementVisible(findTestObject('News/Success'))
	}

	// User cannot Edit news with empty Title
	@And("I edit judul news to empty")
	def EmptyJudulNews(){
		WebUI.sendKeys(findTestObject('News/Judul'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('News/Judul'), Keys.chord(Keys.BACK_SPACE))
	}

	// User cannot Edit a news with empty Description
	@And("I edit deskripsi news to empty")
	def EmptydeskripsiNews(){
		WebUI.sendKeys(findTestObject('News/deskripsi'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('News/deskripsi'), Keys.chord(Keys.BACK_SPACE))
	}

	// User cannot Edit a news if all fields empty
	@Then("I should received error message on field judul and deskripsi")
	def EmptyJudulAndDeskripsiField() {
		WebUI.verifyElementVisible(findTestObject('News/AlertJudul'))
		WebUI.verifyElementVisible(findTestObject('News/AlertDeskripsi'))
	}

	// User cannot add news if the image file is not JPG, PNG, and JPEG
	@And("I edit gambar with file txt")
	def EditGambarTxt(){
		WebUI.uploadFile(findTestObject('News/Image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\Txt.txt')
	}

	// User cannot edit a news if judul less than 20 characters
	@And("I edit judul news (.*) less than 20 characters")
	def EditNewsJudulLessThan20characters(String judul) {
		WebUI.clearText(findTestObject('News/Judul'))
		WebUI.setText(findTestObject('News/Judul'), judul)
	}

	// User cannot edit a news if deskripsi less than 50 characters
	@And("I edit deskripsi news (.*) less than 50 characters")
	def EditNewsDeskripsiLessThan50characters(String deskripsi) {
		WebUI.clearText(findTestObject('News/deskripsi'))
		WebUI.setText(findTestObject('News/deskripsi'), deskripsi)
	}

	// User cannot edit a news if image large than 5mb
	@And("I edit gambar news large than 5MB")
	def editGambarLargeThan5MB(){
		WebUI.uploadFile(findTestObject('News/Image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\foto 20mb.jpg')
	}


	// FORGET PASSWORD
	// User cannot navigate to the Masukan OTP page if unregistered email is input.
	@When("Click button Lupa password on login page")
	def ButtonLupaPasswordOnlogin() {
		WebUI.click(findTestObject('LoginPage/ForgetPassword/forgot-password button'))
	}
	@And("I Input unregistered email (.*)")
	def unregisteredEmail(String email){
		WebUI.setText(findTestObject('LoginPage/ForgetPassword/email on forget password page'), email)
	}
	@And("I click button Lupa password")
	def ButtonLupaPasswordOnlupapasswordpage() {
		WebUI.click(findTestObject('LoginPage/ForgetPassword/btn-Lupa Password on forget password page'))
	}
	@Then("I should have received an error message Email tidak terdaftar")
	def AlertunregisteredEmail() {
		WebUI.verifyElementVisible(findTestObject('LoginPage/ForgetPassword/AlertEmail'))
	}

	// User cannot navigate to the Masukan OTP page if not using @
	@And("I Input invalid email (.*)")
	def invalidEmail(String email){
		WebUI.setText(findTestObject('LoginPage/ForgetPassword/email on forget password page'), email)
	}
	@Then("I should have received an error message Penggunaan email tidak valid")
	def AlertinvalidEmail() {
		WebUI.waitForAlert(3)
	}

	// User cannot navigate to the Masukan OTP page if unregistered email is input
	@And("I Input my email (.*)")
	def ValidEmail(String email){
		WebUI.setText(findTestObject('LoginPage/ForgetPassword/email on forget password page'), email)
	}
	@And("I input invalid otp (.*)")
	def InvalidOTP(String otp){
		WebUI.setText(findTestObject('LoginPage/ForgetPassword/Input otp'), otp)
	}
	@And("I click button selanjutnya")
	def ButtonSelanjutnya() {
		WebUI.click(findTestObject('LoginPage/ForgetPassword/Button selanjutnya'))
	}
	@Then("I should have received an error message Kesalahan saat memverifikasi OTP. Silakan coba lagi nanti.")
	def GagalOTP() {
		// Tunggu hingga pop-up muncul
		WebUI.waitForAlert(10)
		WebUI.acceptAlert() // Untuk menerima (OK)
	}



	// Volunteer
	// Volunteer
	// Volunteer
	// Volunteer
	// Volunteer
	// Volunteer

	// User success open Volunteer page
	@And("I click volunteer vacancies menu")
	def IClickVolunteerMenu() {
		WebUI.click(findTestObject('Volunteer/navigate-to-volunteer-vacancies'))
	}
	@Then("I should be on the volunteer vacancies page")
	def OnVolunteerpage() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/On volunteer vacancies page'))
	}

	//Valid search
	@When("I Input spesific volunteer vacancies search field (.*)")
	def searchValidvolunteer(String search){
		WebUI.setText(findTestObject('Fundraising/input-search-fundraise'), search)
	}

	// MovingPage
	@When("I click button panigation volunteer vacancies")
	def ButtonPanigationvolunteer() {
		WebUI.scrollToElement(findTestObject('Volunteer/btn-pagination-page-1'), 0)
		WebUI.click(findTestObject('Volunteer/btn-pagination-page-1'))
	}
	@Then("Should direct to page 2 of the volunteer vacancies")
	def page2volunteer() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/On volunteer vacancies page'))
	}

	// User can view 5 news data
	@When("I click dropdown and click 5 volunteer vacancies")
	def ButtonDropdown() {
		WebUI.scrollToElement(findTestObject('Volunteer/Dropdown'), 0)
		WebUI.click(findTestObject('Volunteer/Dropdown'))
		WebUI.click(findTestObject('Volunteer/View5Data'))
	}
	@Then("I received a display of 5 volunteer vacancies data")
	def volunteer5data() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/On volunteer vacancies page'))
	}

	// User can cancel delete volunteer vacancies
	@When("I Click icon Delete on the action coloumn volunteer vacancies")
	def ButtonDeleteVolunteer() {
		WebUI.click(findTestObject('Volunteer/Button delete'))
	}
	@And("I click button Batal delete")
	def ButtonBatalVolunteer() {
		WebUI.click(findTestObject('Volunteer/Button Batal'))
	}

	// User can delete volunteer vacancies
	@And("I click button Ya Hapus volunteer vacancies")
	def ButtonYahapusVolunteer() {
		WebUI.click(findTestObject('Volunteer/Button Ya hapus'))
	}
	@Then("Should receive message Berhasil mengapus lowongan volunteer")
	def BerhasilMengapusVolunteer() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/On volunteer vacancies page'))
	}

	// User can add volunteer vacancies
	@When("I click button add volunteer vacancies")
	def ButtonADDVolunteer() {
		WebUI.click(findTestObject('Volunteer/Button Add'))
	}
	@And("I input valid judul (.*) volunteer vacancies")
	def inputValidJudulvolunteer(String judul) {
		WebUI.setText(findTestObject('Volunteer/Judul'), judul)
	}
	@And("I input valid jumlah (.*) volunteer vacancies")
	def inputValidjumlahvolunteer(String jumlah) {
		WebUI.setText(findTestObject('Volunteer/jumlah'), jumlah)
	}
	@And("I input valid deskripsi (.*) volunteer vacancies")
	def inputValiddeskripsivolunteer(String deskripsi) {
		WebUI.setText(findTestObject('Volunteer/deskripsi'), deskripsi)
	}
	@And("I input valid contact email (.*) volunteer vacancies")
	def inputValidemailvolunteer(String email) {
		WebUI.setText(findTestObject('Volunteer/email'), email)
	}
	@And("I input valid skill (.*) volunteer vacancies")
	def inputValidskillvolunteer(String skill) {
		WebUI.setText(findTestObject('Volunteer/Input skill'), skill)
		WebUI.click(findTestObject('Volunteer/skill'))
	}
	@And("I input Valid tanggal selesai volunteer vacancies")
	def ValidTanggalselesaivolunteer(){
		WebUI.click(findTestObject('Volunteer/Tanggal selesai'))
		WebUI.click(findTestObject('Volunteer/29 desember 2023'))
	}
	@And("I input valid Provinsi volunteer vacancies")
	def InputProvinsi(){
		WebUI.click(findTestObject('Volunteer/Input provinsi'))
		WebUI.click(findTestObject('Volunteer/DKI JAKARTA'))
	}
	@And("I input valid Kabupaten volunteer vacancies")
	def InputKabupaten(){
		WebUI.click(findTestObject('Volunteer/Input Kabupaten'))
		WebUI.click(findTestObject('Volunteer/KOTA JAKARTA SELATAN'))
	}
	@And("I input valid Kecamatan volunteer vacancies")
	def InputKecamatan(){
		WebUI.click(findTestObject('Volunteer/Input Kecamatan'))
		WebUI.click(findTestObject('Volunteer/JAGAKARSA'))
	}
	@And("I input valid Lokasi Detail volunteer vacancies")
	def InputLokasiDetail(){
		WebUI.click(findTestObject('Volunteer/Input Lokasi Detail'))
		WebUI.click(findTestObject('Volunteer/CIGANJUR'))
	}
	@And("I input valid gambar volunteer vacancies")
	def ValidGambarvolunteer(){
		WebUI.uploadFile(findTestObject('Volunteer/Image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\Foto jpg2.jpg')
	}
	@And("I click button Tambah volunteer vacancies")
	def ButtonTambah(){
		WebUI.click(findTestObject('Volunteer/Button Tambah'))
	}
	@Then("I should received message Success Menambahkan lowongan relawan")
	def ValidateMenambahkanlowonganrelawan() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/On volunteer vacancies page'))
	}

	// User cannot add volunteer vacancies if judul less than 20 characters
	@And("I input judul (.*) volunteer vacancies less than 20 characters")
	def inputJudulvolunteerLessThan20(String judul) {
		WebUI.setText(findTestObject('Volunteer/Judul'), judul)
	}
	@Then("I should received error message Judul lowongan relawan minimal 20 karakter")
	def AlertJudulLessThan20() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert Judul'))
	}

	// User cannot add volunteer vacancies if deskripsi less than 50characters
	@And("I input deskripsi (.*) volunteer vacancies less than 50 characters")
	def inputdeskripsivolunteerLessThan50(String deskripsi) {
		WebUI.setText(findTestObject('Volunteer/deskripsi'), deskripsi)
	}
	@Then("I should received error message Kolom deskripsi lowongan relawan minimal 50 karakter")
	def AlertdeskripsiLessThan50() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert deskripsi'))
	}

	// User cannot add volunteer vacancies if Jumlah Lowongan 0
	@And("I input jumlah (.*) volunteer vacancies")
	def inputjumlahvolunteer(String jumlah) {
		WebUI.setText(findTestObject('Volunteer/jumlah'), jumlah)
	}
	@Then("I should received error message Kolom jumlah lowongan relawan harus diisi")
	def Alertjumlah0() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert jumlah'))
	}

	// User cannot add volunteer vacancies with empty Title
	@Then("I should received error message Kolom judul lowongan relawan harus diisi")
	def AlertJudulEmpty() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert Judul'))
	}

	// User cannot add volunteer vacancies with empty Description
	@Then("I should received error message Kolom deskripsi lowongan relawan harus diisi")
	def AlertDeskripsiempty() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert deskripsi'))
	}

	// User cannot add a volunteer vacancies with empty skill
	@Then("I should received error message Kolom keahlian harus diisi")
	def AlertSkillempty() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert skill'))
	}

	// User cannot add a volunteer vacancies with empty Contact email
	@Then("I should received error message Kolom alamat email harus diisi")
	def AlertEmailempty() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert Email'))
	}

	// User cannot add a volunteer vacancies with empty Tanggal selesai
	@Then("I should received error message Kolom tanggal selesai lowongan relawan harus diisi")
	def Alerttanggalselesai() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert tanggal selesai'))
	}

	// User cannot add a volunteer vacancies with empty Provinsi
	@Then("I should received error message Kolom provinsi harus diisi")
	def AlertProvinsi() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert provinsi'))
	}

	// User cannot add a volunteer vacancies with empty kabupaten
	@Then("I should received error message Kolom kabupaten harus diisi")
	def Alertkabupaten() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert kabupaten'))
	}

	// User cannot add a volunteer vacancies with empty kecamatan
	@Then("I should received error message Kolom kecamatan harus diisi")
	def Alertkecamatan() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert kecamatan'))
	}

	// User cannot add a volunteer vacancies with empty Lokasi detail
	@Then("I should received error message Kolom Lokasi detail harus diisi")
	def AlertLokasidetail() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert Lokasi detail'))
	}

	// User cannot add a volunteer vacancies with empty Gambar
	@Then("I should received error message Kolom foto lowongan relawan harus diisi")
	def Alertfoto() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert foto'))
	}

	// User cannot add volunteer vacancies if the image file is not JPG, PNG, and JPEG
	@And("I input gambar with file txt volunteer vacancies")
	def InputImagetxt(){
		WebUI.uploadFile(findTestObject('Volunteer/Image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\Txt.txt')
	}
	@Then("I should received error message Format gambar harus .jpg, .png, .jpeg")
	def Alertfototxt() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert foto'))
	}

	// User cannot add a volunteer vacancies with all fields empty
	@Then("I should received error message on all fields")
	def AlertAllfields() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert deskripsi'))
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert jumlah'))
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert Judul'))
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert skill'))
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert kabupaten'))
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert kecamatan'))
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert Lokasi detail'))
	}

	// User cannot add volunteer vacancies if the email format does not use @
	@And("I input invalid contact email (.*) volunteer vacancies")
	def inputInvalidemailvolunteer(String email) {
		WebUI.setText(findTestObject('Volunteer/email'), email)
	}

	@Then("I should received error message Alamat email tidak valid. Mohon periksa kembali")
	def AlertEmailInvalid() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert Email'))
	}

	// User cannot add volunteer vacancies if image large than 5mb
	@And("I input gambar large than 5mb volunteer vacancies")
	def InputImage20mb(){
		WebUI.uploadFile(findTestObject('Volunteer/Image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\foto 20mb.jpg')
	}
	@Then("I should received error message Ukuran gambar maksimal 5MB")
	def Alertfoto20mb() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert foto'))
	}

	// User cannot add a volunteer vacancy if select not listed in the keahlian list
	@And("I input invalid skill (.*) volunteer vacancies")
	def inputInvalidSkillvolunteer(String skill) {
		WebUI.setText(findTestObject('Volunteer/Input skill'), skill)
	}
	@Then("I should received error message No Option")
	def NoOption() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/Alert No Option'))
	}

	// edit
	// User can edit volunteer vacancies
	@When("I Click icon edit volunteer vacancies on the action coloumn")
	def ButtonEditvolunteer() {
		WebUI.click(findTestObject('Volunteer/Button edit'))
	}
	@And("I edit valid judul (.*) volunteer vacancies")
	def editValidJudulvolunteer(String judul) {
		WebUI.clearText(findTestObject('Volunteer/Judul'))
		WebUI.setText(findTestObject('Volunteer/Judul'), judul)
	}
	@And("I edit valid jumlah (.*) volunteer vacancies")
	def editValidjumlahvolunteer(String jumlah) {
		WebUI.clearText(findTestObject('Volunteer/jumlah'))
		WebUI.setText(findTestObject('Volunteer/jumlah'), jumlah)
	}
	@And("I edit valid deskripsi (.*) volunteer vacancies")
	def editValiddeskripsivolunteer(String deskripsi) {
		WebUI.clearText(findTestObject('Volunteer/deskripsi'))
		WebUI.setText(findTestObject('Volunteer/deskripsi'), deskripsi)
	}
	//	@And("I edit valid contact email (.*) volunteer vacancies")
	//	def editValidemailvolunteer(String email) {
	//		WebUI.clearText(findTestObject('Volunteer/email'))
	//		WebUI.setText(findTestObject('Volunteer/email'), email)
	//	}
	@And("I edit valid skill (.*) volunteer vacancies")
	def editValidskillvolunteer(String skill) {
		//clear
		WebUI.click(findTestObject('Volunteer/clear skill'))
		WebUI.setText(findTestObject('Volunteer/Input skill'), skill)
		WebUI.click(findTestObject('Volunteer/skill'))
	}
	@And("I edit Valid tanggal selesai volunteer vacancies")
	def editValidTanggalselesaivolunteer(){
		WebUI.click(findTestObject('Volunteer/Tanggal selesai'))
		WebUI.click(findTestObject('Volunteer/27 desember 2023'))
	}
	@And("I edit valid Provinsi volunteer vacancies")
	def editProvinsi(){
		WebUI.click(findTestObject('Volunteer/Input provinsi'))
		WebUI.click(findTestObject('Volunteer/BENGKULU'))
	}
	@And("I edit valid Kabupaten volunteer vacancies")
	def editKabupaten(){
		WebUI.click(findTestObject('Volunteer/Input Kabupaten'))
		WebUI.click(findTestObject('Volunteer/BENGKULU SELATAN'))
	}
	@And("I edit valid Kecamatan volunteer vacancies")
	def EditInputKecamatan(){
		WebUI.click(findTestObject('Volunteer/Input Kecamatan'))
		WebUI.click(findTestObject('Volunteer/KEDURANG'))
	}
	@And("I edit valid Lokasi Detail volunteer vacancies")
	def editLokasiDetail(){
		WebUI.click(findTestObject('Volunteer/Input Lokasi Detail'))
		WebUI.click(findTestObject('Volunteer/TANJUNG ALAM'))
	}
	@And("I edit valid gambar volunteer vacancies")
	def editValidGambarvolunteer(){
		WebUI.uploadFile(findTestObject('Volunteer/Image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\BANJIR.jpg')
	}
	@And("I click button edit data volunteer vacancies")
	def ButtonEdit(){
		WebUI.click(findTestObject('Volunteer/Button edit data'))
	}
	@Then("I should received message Berhasil mengedit lowongan relawan")
	def ValidateSuccessEdit() {
		WebUI.verifyElementVisible(findTestObject('Volunteer/On volunteer vacancies page'))
	}

	// User cannot edit volunteer vacancies if judul less than 20 characters
	@And("I edit judul (.*) less than 20 characters volunteer vacancies")
	def editJudulvolunteerlessthan20(String judul) {
		WebUI.clearText(findTestObject('Volunteer/Judul'))
		WebUI.setText(findTestObject('Volunteer/Judul'), judul)
	}

	// User cannot edit volunteer vacancies if deskripsi less than 50 characters
	@And("I edit deskripsi (.*) less than 50 characters volunteer vacancies")
	def editdeskripsivolunteerlessThan50(String deskripsi) {
		WebUI.clearText(findTestObject('Volunteer/deskripsi'))
		WebUI.setText(findTestObject('Volunteer/deskripsi'), deskripsi)
	}

	// User cannot edit volunteer vacancies if number of vacancies 0
	@And("I edit jumlah (.*) volunteer vacancies")
	def editjumlahvolunteer(String jumlah) {
		WebUI.clearText(findTestObject('Volunteer/jumlah'))
		WebUI.setText(findTestObject('Volunteer/jumlah'), jumlah)
	}

	// User cannot edit volunteer vacancies with empty Title
	@And("I edit judul empty volunteer vacancies")
	def EditEmptyJudul() {
		WebUI.sendKeys(findTestObject('Volunteer/Judul'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Volunteer/Judul'), Keys.chord(Keys.BACK_SPACE))
	}

	// User cannot edit a volunteer vacancies with empty Description
	@And("I edit deskripsi empty volunteer vacancies")
	def EditdeskripsiEmpty() {
		WebUI.sendKeys(findTestObject('Volunteer/deskripsi'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Volunteer/deskripsi'), Keys.chord(Keys.BACK_SPACE))
	}

	// User cannot edit a volunteer vacancies with empty skill
	@And("I edit skill empty volunteer vacancies")
	def EditSkillEmpty() {
		WebUI.click(findTestObject('Volunteer/clear skill'))
	}

	// User cannot edit a volunteer vacancies with empty Lokasi detail
	@And("I edit kecamatan empty volunteer vacancies")
	def EmptyDetailLokasi() {
		WebUI.click(findTestObject('Volunteer/Input Kecamatan'))
		WebUI.click(findTestObject('Volunteer/JAGAKARSA'))
	}

	// User cannot edit a volunteer vacancies with empty kecamatan
	@And("I edit Kabupaten empty volunteer vacancies")
	def EmptyKecamatan() {
		WebUI.click(findTestObject('Volunteer/Input Kabupaten'))
		WebUI.click(findTestObject('Volunteer/KOTA JAKARTA SELATAN'))
	}

	// User cannot edit a volunteer vacancies with empty kabupaten
	@And("I edit Provinsi empty volunteer vacancies")
	def EmptyKabupaten() {
		WebUI.click(findTestObject('Volunteer/Input provinsi'))
		WebUI.click(findTestObject('Volunteer/DKI JAKARTA'))
	}

	// User cannot edit volunteer vacancies if the image file is not JPG, PNG, and JPEG
	@And("I edit gambar with file txt volunteer vacancies")
	def EditImagetxt(){
		WebUI.uploadFile(findTestObject('Volunteer/Image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\Txt.txt')
	}

	// User cannot edit a volunteer vacancies with empty Jumlah lowongan
	@And("I edit jumlah volunteer vacancies empty")
	def EditEmptyjumlah() {
		WebUI.sendKeys(findTestObject('Volunteer/jumlah'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Volunteer/jumlah'), Keys.chord(Keys.BACK_SPACE))
	}

	// User cannot edit volunteer vacancies if image large than 5mb
	@And("I edit gambar large than 5mb volunteer vacancies")
	def EditImage20mb(){
		WebUI.uploadFile(findTestObject('Volunteer/Image'), 'C:\\Users\\irfan\\Pictures\\Screenshots\\TEST DATA\\foto 20mb.jpg')
	}

	// User cannot edit a volunteer vacancy if select not listed in the keahlian list
	@And("I edit invalid skill (.*) volunteer vacancies")
	def editEmptyskillvolunteer(String skill) {
		//clear
		WebUI.click(findTestObject('Volunteer/clear skill'))
		WebUI.setText(findTestObject('Volunteer/Input skill'), skill)
	}

	// User can view detail volunteer list
	@When("I Click icon detail volunteer vacancies on the action coloumn")
	def Buttondetailvolunteervacancies() {
		WebUI.click(findTestObject('Volunteer/Detail'))
	}
	@And("I on the detail volunteer vacancies page")
	def OnDetailvolunteervacancies() {
		WebUI.click(findTestObject('Volunteer/OnDetailLowonganRelawan'))
	}
	@And("I Click button Pendaftar relawan")
	def Buttondetailvolunteer() {
		WebUI.click(findTestObject('Volunteer/Detail volunteer'))
	}
	@Then("I should be on the list volunteer page")
	def OnDetailvolunteer() {
		WebUI.click(findTestObject('Volunteer/OnListVolunteer'))
	}

	// user can accept a list of waiting volunteer vacancies
	@And("I Click button Terima volunteer vacancies")
	def ButtonTerimaLowongan() {
		WebUI.click(findTestObject('Volunteer/ButtonTerimaLowongan'))
	}
	@Then("I should received message Berhasil menerima lowongan relawan")
	def BerhasilmenerimaLowongan() {
		WebUI.click(findTestObject('Volunteer/On volunteer vacancies page'))
	}

	// User cannot reject volunteer vacancies if do not fill a reason
	@And("I Click button Tolak volunteer vacancies")
	def ButtonTolakLowongan() {
		WebUI.click(findTestObject('Volunteer/ButtonTolakLowongan'))
	}
	@And("I Click button tolak volunteer vacancies on reason page")
	def ButtonTolakLowonganOnReasonPage() {
		WebUI.click(findTestObject('Volunteer/ButtonTolakLowonganOnReasonPage'))
	}
	@Then("I should have received a error message Kolom reason harus diisi")
	def AlertReasonEmpty() {
		WebUI.click(findTestObject('Volunteer/AlertReason'))
	}

	// User cannot reject volunteer vacancies if input reason less than 20 characters
	@And("I input invalid reason (.*) volunteer vacancies less than 20 characters")
	def InputInvalidReason(String reason) {
		WebUI.setText(findTestObject('Volunteer/Input reason'), reason)
	}
	@Then("I should have received error message Alasan penolakan minimal 20 karakter")
	def AlertReason20karakter() {
		WebUI.click(findTestObject('Volunteer/AlertReason'))
	}

	// User reject volunteer vacancies
	@And("I input valid reason (.*) for reject volunteer vacancies")
	def InputValidReason(String reason) {
		WebUI.setText(findTestObject('Volunteer/Input reason'), reason)
	}
	@Then("I should have receive a success message Berhasil mengupdate status Lowongan relawan")
	def Berhasilmengupdate() {
		WebUI.click(findTestObject('Volunteer/On volunteer vacancies page'))
	}


}