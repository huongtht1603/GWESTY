package com.cucumberFramework.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.WaitHelper;

public class bookingManagement {
	
	
	private WebDriver driver;
	private WaitHelper waitHelper;
	
	@FindBy(xpath = "//*[@id='remove-scroll']/ul/li[7]/a/span")
	public WebElement bookingTab;
	
	@FindBy(xpath = "//*[@id='nav']/li[2]/a")
	public WebElement byBookingNoTab;
	
	@FindBy(id = "bookingNumber")
	public WebElement bookingNoTxt;
	
	@FindBy(xpath = "//*[@id='example4']/tbody/tr/td[1]")
	public WebElement bookNoResult;
	
	@FindBy(xpath = "//*[@id='example4']/tbody/tr/td[3]/a")
	public WebElement nameResult;
	
	
	public bookingManagement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	
	public void clickAddBookingTab() {	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",bookingTab);
		js.executeScript("arguments[0].click()", bookingTab);
	}
	
	public void clickByBookingNoTab() {
		waitHelper.WaitForElement(this.byBookingNoTab, 3);
		byBookingNoTab.click();
	}
	
	public void enterbookingNo(String input) {
		waitHelper.WaitForElement(this.bookingNoTxt, 3);
		bookingNoTxt.sendKeys(input);
	}
	
	public void clickSubmitButton() {
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void isSearchSuccessful(String input1, String input2) {
		waitHelper.WaitForElement(this.bookNoResult, 3);
		String bookNo_actual= bookNoResult.getText();
		assertTrue(bookNo_actual.contains(input1));
		waitHelper.WaitForElement(this.nameResult, 3);
		String name_actual= nameResult.getText();
		assertTrue(name_actual.contains(input2));
	}
	
}
