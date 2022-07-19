package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;

import com.cucumberFramework.pageObjects.loginlogout;
import com.cucumberFramework.pageObjects.searchForRoom;
import com.cucumberFramework.pageObjects.searchbookPayment;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class searchbookPaymentStepDefinitions extends TestBase {
	
	String bookNo;
	loginlogout loginlogout = new loginlogout(driver);
	searchbookPayment searchbookPayment = new searchbookPayment(driver);
	searchForRoom searchForRoom = new searchForRoom(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	
	@Given("^I login as a customer$")
	public void i_login_as_a_customer() throws Throwable {
		driver.get(Constants.URL);
		loginlogout.clickLoginLink();
		loginlogout.enterUsername();
		loginlogout.enterPassword();
		loginlogout.clickSignIn();
	}

	@When("^I enter Checkin and Checkout$")
	public void i_enter_Checkin_and_Checkout_as_and() throws Throwable {
		searchbookPayment.enterCheckinCheckout();
	}

	@When("^I enter Adult and Children$")
	public void i_enter_Adult_and_Children() throws Throwable {
		Constants.adult= searchbookPayment.enterAdultNo();
		Constants.children= searchbookPayment.enterChildrenNo();
		
	}

	@When("^I click Search button$")
	public void i_click_Search_button() throws Throwable {
		searchbookPayment.clickSearch();
	}

	@When("^I click into view details of any room displayed$")
	public void i_click_into_view_details_of_any_room_displayed() throws Throwable {
		searchbookPayment.clickviewDetails();
	}

	@Then("^I see a booking form$")
	public void i_see_a_booking_form() throws Throwable {
	    searchbookPayment.isBookNowFormDisplayed();
	}

	@When("^I click on Book Now button after checking all information$")
	public void i_click_on_Book_Now_button_after_checking_all_information() throws Throwable {
		searchbookPayment.clickbookNow();
	}

	@When("^I fill out data on Add your informations, tick on I agree with Terms and Conditions, and click on Summit button$")
	public void i_fill_out_data_on_Add_your_informations_tick_on_I_agree_with_Terms_and_Conditions_and_click_on_Summit_button() throws Throwable {
		searchbookPayment.enterInformation();
		searchbookPayment.clickAgree();
		searchbookPayment.clickSubmit();
	}
	
	@When("^I fill out data on Add your informations, tick on I agree with Terms and Conditions, and click on the Summit button$")
	public void i_fill_out_data_on_Add_your_informations_tick_on_I_agree_with_Terms_and_Conditions_and_click_on_the_Summit_button() throws Throwable {
		searchbookPayment.enterCustomerInformation();
		searchbookPayment.clickAgree();
		searchbookPayment.clickSubmit();
	}

	@Then("^I am on Checkout page$")
	public void i_am_on_Checkout_page() throws Throwable {
		searchbookPayment.isCheckoutFormDisplayed();
	}

	@When("^I fill out credit card information and click paynow$")
	public void i_fill_out_credit_card_information_and_click_paynow() throws Throwable {
		searchbookPayment.enterPaymentMethod();
		searchbookPayment.clickPayNow();
	}

	@Then("^I see a  message for successfull booking as \"([^\"]*)\" and i got the booking  number$")
	public void i_see_a_message_for_successfull_booking_as_and_i_got_the_booking_number(String arg1) throws Throwable {
		searchbookPayment.isSuccessMessageDisplayed(arg1);
		bookNo= searchbookPayment.getBookingNumber();
	}

	@Then("^I search if this booking number is successful booking$")
	public void i_search_if_this_booking_number_is_successful_booking() throws Throwable {
		searchForRoom.clickSearchButton();
		searchForRoom.enterbookingID(bookNo);
		searchForRoom.clickSubmitButton();
		searchForRoom.isSearchSuccessful(bookNo);
	}
}
