package com.cucumberFramework.stepdefinitions;


import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.loginlogout;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginlogoutStepDefinitions extends TestBase  {
	
		loginlogout loginlogout = new loginlogout(driver);
		WaitHelper waitHelper = new WaitHelper(driver);
		
		@Given("^I am on the url$")
		public void i_am_on_the_url() throws Throwable {
		    driver.get(Constants.URL);
		}

		@Then("^I click on login link and wait for sign in page$")
		public void i_click_on_login_link_and_wait_for_sign_in_page() throws Throwable {
		    loginlogout.clickLoginLink();
		}

		@Then("^I should see login Page$")
		public void i_should_see_login_Page() throws Throwable {
		    loginlogout.isLoginFormDisplayed();
		}

		@When("^I enter username$")
		public void i_enter_username() throws Throwable {
		    loginlogout.enterUsername();
		}

		@When("^I enter password$")
		public void i_enter_password() throws Throwable {
		    loginlogout.enterPassword();
		}

		@When("^I check on Remember me$")
		public void i_check_on_Remember_me() throws Throwable {
			loginlogout.clickRememberMe();
		}

		@When("^I click on Sign In button$")
		public void i_click_on_Sign_In_button() throws Throwable {
			loginlogout.clickSignIn();
		}

		@Then("^I am logged in with my account displayed on the top-right of page$")
		public void i_am_logged_in_with_my_account_displayed_on_the_top_right_of_page() throws Throwable {
		    loginlogout.isNameAccountTrue();
		}

		@When("^I Click on log out$")
		public void i_Click_on_log_out() throws Throwable {
			loginlogout.clickLogout();
		}

		@Then("^I got log out from the application and land on home page$")
		public void i_got_log_out_from_the_application_and_land_on_home_page() throws Throwable {
			loginlogout.isLoginpageDisplayed();
		}

		@When("^I enter username of admin$")
		public void i_enter_username_of_admin() throws Throwable {
			loginlogout.enterAdminUsername();
		}
	
		@When("^I enter password of admin$")
		public void i_enter_password_of_admin() throws Throwable {
			loginlogout.enterAdminPassword();
		}
	
		@Then("^I am logged in with my role \"([^\"]*)\" displayed on the top-right of page$")
		public void i_am_logged_in_with_my_role_displayed_on_the_top_right_of_page(String arg1) throws Throwable {
			loginlogout.isAdminRoleDisplayed();
		}
		
		@When("^enter username(.+)$")
		public void enter_username(String input) throws Throwable {
			loginlogout.enterusername(input);
		}

		@When("^enter password(.+)$")
		public void enter_password(String input) throws Throwable {
			loginlogout.enterpassword(input);
		}

		@Then("^I see the \"([^\"]*)\" displayed$")
		public void i_see_the_error_message_displayed(String input) throws Throwable {
			loginlogout.isErrorMessageDisplayed(input);
		}


		
		
	}

