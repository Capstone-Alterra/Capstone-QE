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



class Create_donation {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@And("I click request donation")
	def click_request_donation() {
		Mobile.tap(findTestObject('Object Repository/request donasi/icon request'), 30)
		Mobile.tap(findTestObject('Object Repository/request donasi/buat_req_donasi_btn'), 30)
	}

	@And("I input judul (.*) penggalangan dana")
	def I_input_judul_donasi(String Judul) {
		Mobile.tap(findTestObject('Object Repository/request donasi/field_judul_donasi'), 30)
		Mobile.setText(findTestObject('Object Repository/request donasi/set_text_donasi'), Judul, 30)
		Mobile.delay(5)
	}

	@And("I input isi deskripsi (.*) penggalangan dana")
	def I_input_deskripsi_donasi(String Deskripsi) {
		Mobile.tap(findTestObject('Object Repository/request donasi/field_deskripsi_penggalangan_dana'), 30)
		Mobile.setText(findTestObject('Object Repository/request donasi/set_text_isi_deskripsi_penggalangan_dana'), Deskripsi, 30)
		Mobile.delay(5)
	}

	@And("I input target (.*) penggalangan dana")
	def I_input_target_donasi(String Target) {
		Mobile.tap(findTestObject('Object Repository/request donasi/field_target_penggalangan_dana'), 30)
		Mobile.setText(findTestObject('Object Repository/request donasi/set_text_target_penggalangan_dana'), Target, 30)
		Mobile.delay(5)
	}

	@And("I input tanggal mulai dan tanggal selesai")
	def input_tanggal_donasi() {
		Mobile.tap(findTestObject('Object Repository/request donasi/field_tanggal_mulai_penggalangan_dana'), 30)
		Mobile.tap(findTestObject('Object Repository/request donasi/tanggal_mulai_14'), 30)
		Mobile.tap(findTestObject('Object Repository/request donasi/OK_tanggal'), 30)
		Mobile.tap(findTestObject('Object Repository/request donasi/field_tanggal_selesai_penggalangan_dana'), 30)
		Mobile.tap(findTestObject('Object Repository/request donasi/tanggal_selesai_17'), 30)
		Mobile.tap(findTestObject('Object Repository/request donasi/OK_tanggal'), 30)
		Mobile.hideKeyboard()
	}

	@And("I upload gambar penggalagan dana")
	def upload_gambar_donasi() {
		Mobile.tap(findTestObject('Object Repository/request donasi/upload_gambar_penggalagan_dana'), 30)
		Mobile.tapOnImage("storage/emulated/0/Pictures/IMG_20231214_203301.jpg")
	}

	@And("I click tambah button on penggalangan dana")
	def click_tambah_btn_on_donasi() {
		Mobile.tap(findTestObject('Object Repository/request donasi/button_tambah_penggalangan_dana'), 30)
	}

	@Then("I verify request donation is success")
	def request_donation_success() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/request donasi/verify_success_request_donation'), 30)
	}
}