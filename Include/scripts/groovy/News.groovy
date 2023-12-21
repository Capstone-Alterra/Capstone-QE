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



class News {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@When("I click news on the dashboard")
	def I_click_news() {
		Mobile.tap(findTestObject('Object Repository/news/Berita_btn'), 30)
	}

	@When("I verify i am on the news page")
	def I_am_on_the_news_page() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/news/verify_on_news_page'), 30)
		Mobile.delay(5)
	}

	@And("I input spesific keyword on search field")
	def input_keyword_on_seacrh_field() {
		Mobile.tap(findTestObject('Object Repository/news/field_search_news'), 30)
		Mobile.setText(findTestObject('Object Repository/news/set_text_search_news'), "Gempa", 30)
		Mobile.delay(3)
		Mobile.tap(findTestObject('Object Repository/news/icon_search_news'), 30)
		Mobile.delay(3)
	}
	@And("I can see news based on inputted keyword")
	def news_based_on_inputted_keyword() {
	}
	@And("I click baca selengkapnya button")
	def click_baca_selengkapnya() {
		Mobile.tap(findTestObject('Object Repository/regression/baca_news'), 30)
		Mobile.delay(3)
	}

	@Then("I can see detail of news")
	def see_detail_of_news() {
		Mobile.tap(findTestObject('Object Repository/regression/back_news'), 30)
		Mobile.tap(findTestObject('Object Repository/regression/back_news'), 30)
	}
}