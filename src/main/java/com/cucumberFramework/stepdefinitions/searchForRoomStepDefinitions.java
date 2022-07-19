package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.searchForRoom;
import com.cucumberFramework.pageObjects.loginlogout;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class searchForRoomStepDefinitions extends TestBase{
	
	searchForRoom searchForRoom = new searchForRoom(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	
	@Given("^I am on the Url$")
	public void i_am_on_the_Url() throws Throwable {
	    driver.get(Constants.URL);
	}

	@When("^I click on search button$")
	public void i_click_on_search_button() throws Throwable {
		searchForRoom.clickSearchButton();
	}

	@When("^enter \"([^\"]*)\"$")
	public void enter(String arg1) throws Throwable {
		searchForRoom.enterbookingID(arg1);
	}
	
	@When("^enter booking id$")
	public void enter_booking_id() throws Throwable {
		searchForRoom.enterbookingNo();
	}
	
	@When("^I click on the search button$")
	public void i_click_on_the_search_button() throws Throwable {
		searchForRoom.clickSubmitButton();
	}

	@Then("^see information of \"([^\"]*)\"$")
	public void see_information_of(String arg1) throws Throwable {
		searchForRoom.isSearchSuccessful(arg1);
	}
	
	

}
