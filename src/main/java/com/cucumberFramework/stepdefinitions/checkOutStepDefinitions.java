package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.bookingManagement;
import com.cucumberFramework.pageObjects.checkOut;
import com.cucumberFramework.pageObjects.loginlogout;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class checkOutStepDefinitions extends TestBase {
	

	loginlogout loginlogout = new loginlogout(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	bookingManagement bookingManagement=  new bookingManagement(driver);
	checkOut checkOut=  new checkOut(driver);
			
	@Given("^i login into application with the role of admin$")
	public void i_login_into_application_with_the_role_of_admin() throws Throwable {
		driver.get(Constants.URL);
		loginlogout.clickLoginLink();
		loginlogout.enterAdminUsername();
		loginlogout.enterAdminPassword();
		loginlogout.clickSignIn();
		loginlogout.clickAdminTab();
	}

	@When("^I navigate to Booking at the left panel$")
	public void i_navigate_to_Booking_at_the_left_panel() throws Throwable {
		bookingManagement.clickAddBookingTab();
	}

	@When("^I enter \"([^\"]*)\" to search field$")
	public void i_enter_to_search_field(String arg1) throws Throwable {
	    checkOut.enterSearchData(arg1);
	}

	@When("^I click on any room in Staying status$")
	public void i_click_on_any_room_in_Staying_status() throws Throwable {
		checkOut.clickEyeIcon();
	}

	@Then("^I calculate fee and verify the Total at the end of the booking details page is correctly calculated$")
	public void i_calculate_fee_and_verify_the_Total_at_the_end_of_the_booking_details_page_is_correctly_calculated() throws Throwable {
	    checkOut.isTotalPaidNightCorrected();
	}

}
