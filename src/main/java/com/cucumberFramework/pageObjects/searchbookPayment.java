package com.cucumberFramework.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.AbstractPage;
import com.cucumberFramework.helper.WaitHelper;

public class searchbookPayment extends AbstractPage {
	
	private WebDriver driver;
	WaitHelper waitHelper;

	
	@FindBy(xpath = "//input[@id='check-in']")
	public WebElement checkIn;
	
	@FindBy(xpath = "//input[@id='check-out']")
	public WebElement checkOut;
	
	@FindBy(xpath = "//input[@placeholder='Adult']")
	public WebElement adult;
	
	@FindBy(xpath = "//input[@placeholder='Children']")
	public WebElement children;
	
	@FindBy(xpath = "//input[@value='Search']")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//div[3]//div[1]//div[2]//div[1]//a[1]")
	public WebElement viewDetailsBtn;
	
	@FindBy(xpath = "//h4[@class='form_title']")
	public WebElement bookingformTitle;
	
	@FindBy(xpath = "//input[@value='Book Now']")
	public WebElement bookingnowBtn;
	
	@FindBy(id = "name")
	public WebElement name;
	
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "phone")
	public WebElement phone;
	
	@FindBy(id = "address")
	public WebElement address;
	
	@FindBy(xpath = "//label[@class='custom-control custom-checkbox']")
	public WebElement agreeChbox;
	
	@FindBy(xpath = "//input[@value='Submit']")
	public WebElement submitBtn;
	
	@FindBy(xpath = "//h4[@class='float-left']")
	public WebElement checkoutformTitle;
	
	@FindBy(id = "cardNumber")
	public WebElement cardNumber;
	
	@FindBy(id = "ownerName")
	public WebElement nameOnCard;
	
	@FindBy(name = "expiry")
	public WebElement expiryDate;
	
	@FindBy(id = "cvvcode")
	public WebElement CVV;
	
	@FindBy(xpath = "//*[@id='cardForm']/div[6]/input[2]")
	public WebElement payNowBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	public WebElement msg;
	
	@FindBy(xpath = "//span[@class='green_text1 float-right']")
	public WebElement bookingNumber;
	
	
	
	public searchbookPayment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	public void enterCheckinCheckout () {
		waitHelper.WaitForElement(this.checkIn, 3);
		this.checkIn.sendKeys(Constants.checkin);
		waitHelper.WaitForElement(this.checkOut, 3);
		this.checkOut.sendKeys(Constants.checkout);
	}
	
	public int enterAdultNo (){
		Constants.adult= randomInterger(1,4);
		waitHelper.WaitForElement(this.adult, 3);
		adult.sendKeys(Integer.toString(Constants.adult));
		return Constants.adult;
	}
	
	public int enterChildrenNo () {	
		Constants.children= randomInterger(1,4);
		waitHelper.WaitForElement(this.children, 3);
		children.sendKeys(Integer.toString(Constants.children));
		return Constants.children;
	}
	
	public void clickSearch () {
		waitHelper.WaitForElement(this.searchBtn, 3);
		searchBtn.click();		
	}
	
	public void clickviewDetails () {
		waitHelper.WaitForElement(this.viewDetailsBtn, 3);
		viewDetailsBtn.click();		
	}
	
	public void isBookNowFormDisplayed() {
		waitHelper.WaitForElement(this.bookingformTitle, 3);
		assertTrue(bookingformTitle.isDisplayed());
	}
	
	public void clickbookNow () {
		waitHelper.WaitForElement(this.bookingnowBtn, 3);
		bookingnowBtn.click();		
	}
	
	public void enterInformation () throws InterruptedException{
		waitHelper.WaitForElement(this.name, 3);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",name);
		name.sendKeys(Constants.name);
		waitHelper.WaitForElement(this.email, 3);
		email.sendKeys(Constants.email);
		waitHelper.WaitForElement(this.phone, 3);
		phone.sendKeys(Constants.phone);
		waitHelper.WaitForElement(this.address, 3);
		address.sendKeys(Constants.address);
	}
	
	public void enterCustomerInformation () throws InterruptedException{
		waitHelper.WaitForElement(this.phone, 3);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",phone);
		waitHelper.WaitForElement(this.phone, 3);
		phone.sendKeys(Constants.phone);
		waitHelper.WaitForElement(this.address, 3);
		address.sendKeys(Constants.address);
	}
	
	public void clickAgree () {
		waitHelper.WaitForElement(this.agreeChbox, 3);
		agreeChbox.click();		
	}
	
	public void clickSubmit () {
		waitHelper.WaitForElement(this.submitBtn, 3);
		submitBtn.click();		
	}
	
	public void isCheckoutFormDisplayed() {
		waitHelper.WaitForElement(this.checkoutformTitle, 3);
		assertTrue(checkoutformTitle.isDisplayed());
	}
	
	public void enterPaymentMethod () {
		waitHelper.WaitForElement(this.cardNumber, 3);
		cardNumber.sendKeys(Constants.cardNumber);
		waitHelper.WaitForElement(this.nameOnCard, 3);
		nameOnCard.sendKeys(Constants.nameOnCard);
		waitHelper.WaitForElement(this.expiryDate, 3);
		expiryDate.sendKeys(Constants.expiryDate);
		waitHelper.WaitForElement(this.CVV, 3);
		CVV.clear();
		CVV.sendKeys(Constants.CVV);
	}
	
	public void clickPayNow () {
		waitHelper.WaitForElement(this.payNowBtn, 3);
		payNowBtn.click();		
	}
	
	public void isSuccessMessageDisplayed(String input) throws InterruptedException {
		Thread.sleep(5000);
		waitHelper.WaitForElement(this.msg, 3);
		String msg_actual= msg.getText();
		assertTrue(msg_actual.contains(input));
	}
	
	public String getBookingNumber () throws InterruptedException {
		Thread.sleep(5000);
		waitHelper.WaitForElement(this.bookingNumber, 3);
		String BookingNumber= bookingNumber.getText().replace("Id: ","");	
		return BookingNumber;
	}
	
	
}
