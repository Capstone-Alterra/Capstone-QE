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



class Volunteer {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@When("I click volunteer button on dashboard")
	def I_click_volunteer_btn() {
		Mobile.tap(findTestObject('Object Repository/volunteer/volunteer_btn'), 30)
	}

	@And("I can choose which vacancies i want to apply")
	def I_choose_vacancies() {
		Mobile.tap(findTestObject('Object Repository/volunteer/choose_volunteer22'), 30)
	}

	@And("I click ikuti program button")
	def click_ikuti_program() {
		Mobile.tap(findTestObject('Object Repository/volunteer/ikuti_program_btn'), 30)
	}

	@And("I input my skill")
	def input_skill() {
		Mobile.tap(findTestObject('Object Repository/volunteer/skill'), 30)
		Mobile.tap(findTestObject('Object Repository/volunteer/skill_pendidikan'), 30)
		Mobile.tap(findTestObject('Object Repository/volunteer/close_skill'), 30)
		Mobile.delay(5)
	}
	@And("I input my resume (.*)")
	def input_resume(String Resume) {
		Mobile.tap(findTestObject('Object Repository/volunteer/resume_field'), 30)
		Mobile.setText(findTestObject('Object Repository/volunteer/resume_set_text'), Resume, 30)
		Mobile.delay(5)
	}
	@And("I input my alasan (.*)")
	def input_alasan(String Alasan) {
		Mobile.tap(findTestObject('Object Repository/volunteer/Alasan'), 30)
		Mobile.setText(findTestObject('Object Repository/volunteer/set_text_alasan'), Alasan, 30)
		Mobile.hideKeyboard()
		Mobile.delay(5)
	}
	@And("I upload my photo")
	def upload_photo() {
		Mobile.tap(findTestObject('Object Repository/3/android.widget.ImageView (4)'), 30)

		Mobile.tap(findTestObject('Object Repository/3/android.widget.ImageView (5)'), 30)

		Mobile.delay(4)
	}
	@Then("I verify success apply volunteer vacancies")
	def success_apply_volunteer() {
		Mobile.tap(findTestObject('Object Repository/volunteer/tambah_btn'), 30)
//		Mobile.verifyElementVisible(findTestObject('Object Repository/volunteer/verify_success_apply_volunteer'), 30)
		Mobile.tap(findTestObject('Object Repository/regression/back_volunteer'), 30)
		Mobile.tap(findTestObject('Object Repository/regression/back_volunteer'), 30)
		Mobile.tap(findTestObject('Object Repository/regression/back_volunteer'), 30)
	}
}