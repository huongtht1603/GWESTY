package com.cucumberFramework.stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.cancel;
import com.cucumberFramework.pageObjects.loginlogout;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class cancelStepDefinitions extends TestBase {

		cancel cancel = new cancel(driver);
		loginlogout loginlogout = new loginlogout(driver);
		WaitHelper waitHelper = new WaitHelper(driver);
		
		int sizebefore, sizeafter;
		
		
		
		
		@Given("^i login into application with the role of customer$")
		public void i_login_into_application_with_the_role_of_customer() throws Throwable {
			driver.get(Constants.URL);
			loginlogout.clickLoginLink();
			loginlogout.enterUsername();
			loginlogout.enterPassword();
			loginlogout.clickSignIn();
		}
		
		@When("^I navigate to My bookings tab$")
		public void i_navigate_to_My_bookings_tab() throws Throwable {
		    loginlogout.clickMyBookingsTab();
		}
	
		@When("^I click on cancel button of any room$")
		public void i_click_on_cancel_button_of_any_room() throws Throwable {
			sizebefore=cancel.getSize();
		    cancel.clickCancel();
		}
	
		@When("^I click on any reason for cancelation$")
		public void i_click_on_any_reason_for_cancelation() throws Throwable {
			cancel.selectReason();
		}
	
		@When("^I click on Cancel button on popup$")
		public void i_click_on_Cancel_button_on_popup() throws Throwable {
			cancel.clickCancelPopup();
		    int sizeafter= cancel.getSize();
		}
	
		@Then("^this booking is canceled successfully and the number of booking in My history is reduced by 1$")
		public void this_booking_is_canceled_successfully_and_I_am_on_My_history_page() throws Throwable {
			assertTrue(sizeafter==(sizebefore-1));
		}
		
}
