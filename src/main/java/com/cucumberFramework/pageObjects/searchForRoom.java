package com.cucumberFramework.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.AbstractPage;
import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;

public class searchForRoom extends AbstractPage{

	
	private WebDriver driver;
	private WaitHelper waitHelper;
	
	
	
	@FindBy(xpath = "//*[@id='searchForm']/span")
	public WebElement searchBtn;
	
	@FindBy(name = "bookingUID")
	public WebElement bookingIdTxt;
	
	@FindBy(xpath = "//span[@class='green_text1 float-right']")
	public WebElement bookingIdResult;
	
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[1]/div/div[2]/div/ul/li[2]/span")
	public WebElement nightNumberResult;
	
	@FindBy(xpath = "/html/body/section[2]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/p[2]")
	public WebElement adultNoResult;
	
	@FindBy(xpath = "/html/body/section[2]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/p[2]/span[2]")
	public WebElement childrenNoResult;
	
	
	public searchForRoom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	public void clickSearchButton () {
		waitHelper.WaitForElement(this.searchBtn, 3);
		searchBtn.click();		
	}
	
	public void enterbookingID(String input) {
		waitHelper.WaitForElement(this.bookingIdTxt, 3);
		bookingIdTxt.sendKeys(input);
	}
	
	public void enterbookingNo() {
		bookingIdTxt.sendKeys(Constants.bookingId);
	}
	
	
	public void clickSubmitButton() {
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void isSearchSuccessful(String input) {
		waitHelper.WaitForElement(this.bookingIdResult, 3);
		String bookNo_actual= bookingIdResult.getText();
		assertTrue(bookNo_actual.contains(input));
	}
}
