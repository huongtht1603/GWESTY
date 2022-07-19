package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;

import com.cucumberFramework.pageObjects.loginlogout;
import com.cucumberFramework.pageObjects.searchForRoom;
import com.cucumberFramework.pageObjects.searchForAvailableRoom;
import com.cucumberFramework.pageObjects.searchbookPayment;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class searchForAvailableRoomStepDefinitions extends TestBase{
		
		String bookNo;
		loginlogout loginlogout = new loginlogout(driver);
		searchbookPayment searchbookPayment = new searchbookPayment(driver);
		searchForAvailableRoom searchForAvailableRoom = new searchForAvailableRoom(driver);
		searchForRoom searchForRoom = new searchForRoom(driver);
		WaitHelper waitHelper = new WaitHelper(driver);
		
	
		@Given("^I am on booking hotel page$")
		public void i_am_on_booking_hotel_page() throws Throwable {
			driver.get(Constants.URL);
		}
		
		
		@Given("^I log in as a customer$")
		public void i_log_in_as_a_customer() throws Throwable {
			driver.get(Constants.URL);
			loginlogout.clickLoginLink();
			loginlogout.enterUsername();
			loginlogout.enterPassword();
			loginlogout.clickSignIn();
		}

		@When("^I enter checkin and checkout$")
		public void i_enter_checkin_and_checkout_as_and() throws Throwable {
			searchbookPayment.enterCheckinCheckout();
		}

		@When("^I enter adult and children$")
		public void i_enter_adult_and_children() throws Throwable {
			Constants.adult= searchbookPayment.enterAdultNo();
			Constants.children= searchbookPayment.enterChildrenNo();
			
		}

		@When("^I click a Search button$")
		public void i_click_a_Search_button() throws Throwable {
			searchbookPayment.clickSearch();
		}

		@When("^I see displayed rooms in this page meet number of adult and children$")
		public void i_see_displayed_rooms_in_this_page_meet_number_of_adult_and_children() throws Throwable {
			searchForAvailableRoom.getRoomDetails(Constants.adult, Constants.children );
		}


		

}
