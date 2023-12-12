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



class registerr {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	@Given("I already open application")
	def I_already_open_application(){
		Mobile.startApplication('C:\\Users\\Valen\\Downloads\\base.apk', true)
	
		Mobile.tap(findTestObject('Object Repository/Landing Page/btn_selanjutnya'), 30)
	
		Mobile.tap(findTestObject('Object Repository/Landing Page/btn_lewati'), 30)
		
	}
	@When("i click daftar button")
	def click_daftar_button() {
		Mobile.tap(findTestObject('Object Repository/Landing Page/btn_daftar_at_landing_page'),30)
		Mobile.delay(10)
		
	}


	@And("I input nama (.*)")
	def I_input_nama(String Nama) {
		Mobile.tap(findTestObject('Object Repository/Register/field_nama_lengkap_regist'), 0)
		
		Mobile.setText(findTestObject('Object Repository/3/field_input_nama_lengkap_regist'), Nama, 0)
	
}


	@And("I input email (.*)")
	def I_input_email(String Email) {
		Mobile.tap(findTestObject('Object Repository/3/tap_field_email_regist'), 30)
		
		Mobile.delay(5)

		Mobile.setText(findTestObject('Object Repository/3/field_input_email_regist'), Email, 30)
		
	}

	@And("I input alamat (.*)")
	def I_input_alamat(String Alamat) {
		Mobile.tap(findTestObject('Object Repository/Alamat_regist/field_alamat_regist'), 30)
		Mobile.delay(5)

		Mobile.setText(findTestObject('Object Repository/Alamat_regist/input_alamat_regist'), Alamat, 30)
		Mobile.delay(5)
	}
	
	@And("I input nomor (.*)")
	def I_input_nomor(String Nomor) {
		Mobile.tap(findTestObject('Object Repository/3/field_nomor_regist'), 30)
		Mobile.delay(5)

		Mobile.setText(findTestObject('Object Repository/3/input_nomor_regist'), Nomor , 30)
		Mobile.delay(5)
		
		Mobile.hideKeyboard()
		
	}
	
	@And("I choose my gender")
	def I_choose_gender() {
		Mobile.tap(findTestObject('Object Repository/Register/dropdown_jenis_kelamin_regist'), 30)
		

		Mobile.tap(findTestObject('Object Repository/Register/gender_perempuan'), 30)
		
	}
	
	@And("I input password (.*)")
	def I_input_password(String Password) {

		Mobile.tap(findTestObject('Object Repository/3/field_pass_regist'), 30)
		Mobile.delay(5)

		Mobile.setText(findTestObject('Object Repository/3/input_pass_regist'), Password, 30)
		Mobile.delay(5)

		Mobile.hideKeyboard()
		
	}
	
	
	
	@And("I click register button")
	def I_click_register_btn() {
		Mobile.tap(findTestObject('Object Repository/Register/checkbox_regist'), 30)
		Mobile.delay(5)
		Mobile.tap(findTestObject('Object Repository/3/button_daftar_regist'), 30)
		Mobile.delay(5)

	}
	
	@Then("I success register my account")
	def I_succes_register() {
		Mobile.closeApplication()

	}
	
	@Then("I can verify error message that nama is required")
	def error_message_nama_is_required() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Register/error_message_nama_tidak_boleh_kosong_regist'), 30)
		Mobile.delay(5)
		Mobile.closeApplication()
	}
	
	@Then("I can verify error message that email is required")
	def error_message_email_is_required() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Register/error_message_email_tidak_boleh_kosong_regist'), 30)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("I can verify error message that alamat is required")
	def error_message_alamat_is_required() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Register/error_message_alamat_tidak_boleh_kosong_regist'), 30)
		Mobile.delay(5)
		Mobile.closeApplication()
	}
	
	@Then("I can verify error message that no hp is required")
	def error_message_nomor_is_required() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Register/error_message_nomor_tidak_boleh_kosong_regist'), 30)
		Mobile.delay(5)
		Mobile.closeApplication()
	}
	
	@Then("I can verify error message that gender is required")
	def error_message_gender_is_required() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Register/error_message_pilih_jenis_kelamin_regist'), 30)
		Mobile.delay(5)
		Mobile.closeApplication()
	}
	
	@Then("I can verify that password is a required field")
	def error_message_password_is_required() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Register/error_message_password_tidak_boleh_kosong_regist'), 30)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

}
