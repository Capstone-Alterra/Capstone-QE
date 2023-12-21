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



class fundraising {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I can verify the homepage after login")
	def I_on_the_homepage_after_login() {
		Mobile.callTestCase(findTestCase('Test Cases/Login tag1'), null)
	}

	@When("I click donasi button on the dashboard")
	def I_click_donation_button_on_dashboard() {
		Mobile.tap(findTestObject('Object Repository/fundraising/donation_button_on_dashboard'), 30)
		Mobile.delay(5)
		Mobile. verifyElementVisible(findTestObject('Object Repository/fundraising/verify_on_donation_screen'), 30)
	}

	@And("I can choose which donation that i want to")
	def choose_donation() {
		Mobile.tap(findTestObject('Object Repository/news/choose_domation_new'), 30)
		Mobile.delay(5)
		Mobile.verifyElementVisible(findTestObject('Object Repository/fundraising/verify_detail_penggalangan_dana'), 30)
	}

	@And("I click button donasi sekarang")
	def btn_donasi_sekarang() {
		Mobile.tap(findTestObject('Object Repository/fundraising/donasi_sekarang_btn'), 30)
		Mobile.delay(5)
	}
	@And("I input nominal donation manually")
	def input_nominal_manually() {
		Mobile.tap(findTestObject('Object Repository/fundraising/field_nominal_donasi'),30)
		Mobile.setText(findTestObject('Object Repository/fundraising/set_test_nominal_donation'), "20000", 30)
		Mobile.hideKeyboard()
	}

	@And("I choose nomnial")
	def choose_nominal() {
		Mobile.tap(findTestObject('Object Repository/fundraising/choose_nominal_donation'), 30)
	}

	@And("I click button lanjut")
	def click_btn_lanjut() {
		Mobile.tap(findTestObject('Object Repository/fundraising/lanjut_btn_on_choose_donation'), 300)
		Mobile.delay(5)
	}

	@Then("I direct to method of payment screen")
	def method_of_payment_sceen() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/fundraising/verify_on_choose_method_payment_screen'), 30)
	}

	@And("I choose which bank i want to transfer with")
	def choose_bank() {
		Mobile.tap(findTestObject('Object Repository/fundraising/tf_bank'), 30)
		Mobile.tap(findTestObject('Object Repository/fundraising/BCA'), 30)
		Mobile.delay(5)
		Mobile.tap(findTestObject('Object Repository/fundraising/lanjutkan_pembayaran_btn'), 30)
		Mobile.delay(5)
	}

	@And("I choose which E-wallet i want to transfer with")
	def choose_e_wallet() {
		Mobile.tap(findTestObject('Object Repository/fundraising/E_wallet'), 30)
		Mobile.tap(findTestObject('Object Repository/fundraising/qris'), 30)
		Mobile.delay(5)
		Mobile.tap(findTestObject('Object Repository/fundraising/lanjutkan_pembayaran_btn'), 30)
		Mobile.delay(5)
	}

	@And("I can see detail of my donation")
	def detail_of_donation() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/fundraising/Verify_transfer_by_BCA'), 30)
		Mobile.verifyElementVisible(findTestObject('Object Repository/fundraising/verify_VA'), 30)
		Mobile.verifyElementVisible(findTestObject('Object Repository/fundraising/verify_total_pembayaran'), 30)
		Mobile.tap(findTestObject('Object Repository/fundraising/lanjutkan_btn_after_choose_payment_method'), 30)
		Mobile.delay(5)
		Mobile.pressBack()
	}

	@And("I can see detail of my donation with e wallet")
	def detail_donation_with_e_wallet() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/fundraising/valid_until'), 30)
		Mobile.verifyElementVisible(findTestObject('Object Repository/fundraising/verify_total_payment'), 30)
		Mobile.tap(findTestObject('Object Repository/fundraising/simpan_QR_btn'), 30)
	}

	@Then("I success donate fundraising")
	def success_donate() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/fundraising/verify_donasi_berhasil'), 30)
		Mobile.delay(5)
		Mobile.tap(findTestObject('Object Repository/regression/halaman_riwayat_donation_btn'), 30)
		Mobile.tap(findTestObject('Object Repository/regression/beranda'), 30)
		Mobile.delay(5)
	}
}