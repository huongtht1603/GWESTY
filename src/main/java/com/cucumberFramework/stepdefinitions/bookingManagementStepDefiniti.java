package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.bookingManagement;
import com.cucumberFramework.pageObjects.loginlogout;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class bookingManagementStepDefiniti extends TestBase{

	
	bookingManagement bookingManagement = new bookingManagement(driver);
	loginlogout loginlogout = new loginlogout(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	
	
	@Given("^I login as an admin role$")
	public void i_login_as_an_admin_role() throws Throwable {
		driver.get(Constants.URL);
		loginlogout.clickLoginLink();
		loginlogout.enterAdminUsername();
		loginlogout.enterAdminPassword();
		loginlogout.clickSignIn();
		loginlogout.clickAdminTab();
	}

	@When("^I click on Booking at the left panel$")
	public void i_click_on_Booking_at_the_left_panel() throws Throwable {
		bookingManagement.clickAddBookingTab();
	}

	@When("^I click on By  booking number tab$")
	public void i_click_on_By_booking_number_tab() throws Throwable {
		bookingManagement.clickByBookingNoTab();
	}
	
	
	@When("^I enter booking number as \"([^\"]*)\"$")
	public void i_enter_booking_number_as(String arg1) throws Throwable {
		bookingManagement.enterbookingNo(arg1);
	}

	@When("^I click on the Submit button$")
	public void i_click_on_the_Submit_button() throws Throwable {
		bookingManagement.clickSubmitButton();
	}

	@Then("^I see search result a booking number as \"([^\"]*)\" and customer name as \"([^\"]*)\"$")
	public void i_see_search_result_of_booking_number_as_and_customer_name_as(String arg1, String arg2) throws Throwable {
		bookingManagement.isSearchSuccessful(arg1, arg2);
	}
}
