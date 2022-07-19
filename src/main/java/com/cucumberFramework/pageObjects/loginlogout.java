package com.cucumberFramework.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;
	
	public class loginlogout {
		
		private WebDriver driver;

		@FindBy(linkText = "Login")
		public WebElement loginLnk;
		
		@FindBy(name = "email")
		public WebElement username;
		
		@FindBy(name = "password")
		public WebElement password;
		
		@FindBy(xpath = "//*[@id='Login_tab']/form/div[4]/input")
		public WebElement signInBtn;
		
		@FindBy(xpath = "//*[@id=\"Login_tab\"]/form/div[3]/label")
		public WebElement rememberMeChkbox;
		
		@FindBy(id = "NavebarProfileDrop")
		public WebElement nameAccount;
		
		@FindBy(xpath = "//*[@id=\"NavebarProfileDrop\"]/i")
		public WebElement nameAccountDrp;
		
		@FindBy(xpath = "//a[normalize-space()='My Bookings']")
		public WebElement myBookingsTab;
		
		@FindBy(xpath = "//a[normalize-space()='Go to Admin']")
		public WebElement adminTab;
		
		@FindBy(xpath = "//a[normalize-space()='Log Out']")
		public WebElement logoutTab;
		
		@FindBy(xpath = "//*[@id='loginError']")
		public WebElement errormsg;
		
		
		WaitHelper waitHelper;

		public loginlogout(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			waitHelper = new WaitHelper(driver);
		}
		
		public void clickLoginLink() {
			waitHelper.WaitForElement(this.loginLnk, 3);
			this.loginLnk.click();
		}
		
		public void isLoginFormDisplayed() {
			waitHelper.WaitForElement(this.signInBtn, 3);
			assertTrue(signInBtn.isDisplayed());
		}
		
		public void enterUsername() {
			waitHelper.WaitForElement(this.username, 3);
			username.sendKeys(Constants.userName);
		}
		
		public void enterPassword() {
			waitHelper.WaitForElement(this.password, 3);
			password.sendKeys(Constants.password);
		}

		public void clickRememberMe() {
			waitHelper.WaitForElement(this.rememberMeChkbox, 3);
			this.rememberMeChkbox.click();
		}
		
		public void clickSignIn() {
			waitHelper.WaitForElement(this.signInBtn, 3);
			this.signInBtn.click();
		}
		
		public void isNameAccountTrue() {
			waitHelper.WaitForElement(this.nameAccount, 3);
			String nameAccount_actual= nameAccount.getText();
			assertTrue(nameAccount_actual.contains(Constants.nameAccount));
		}
		
		public void clickLogout() {
			waitHelper.WaitForElement(this.nameAccountDrp, 3);
			this.nameAccountDrp.click();
			waitHelper.WaitForElement(this.logoutTab, 3);
			this.logoutTab.click();
		}
		
		public void isLoginpageDisplayed() {
			waitHelper.WaitForElement(this.loginLnk, 3);
			assertTrue(loginLnk.isEnabled());
		}
		
		public void enterAdminUsername() {
			waitHelper.WaitForElement(this.username, 3);
			username.sendKeys(Constants.admin_userName);
		}
		
		public void enterAdminPassword() {
			waitHelper.WaitForElement(this.password, 3);
			password.sendKeys(Constants.admin_password);
		}
		
		
		public void clickAdminTab() {
			waitHelper.WaitForElement(this.nameAccountDrp, 3);
			this.nameAccountDrp.click();
			waitHelper.WaitForElement(this.adminTab, 3);
			this.adminTab.click();
		}
		
		public void clickMyBookingsTab() {
			waitHelper.WaitForElement(this.nameAccountDrp, 3);
			this.nameAccountDrp.click();
			waitHelper.WaitForElement(this.myBookingsTab, 3);
			this.myBookingsTab.click();
		}
		
		public void isAdminRoleDisplayed() {
			waitHelper.WaitForElement(this.nameAccount, 3);
			String nameAccount_actual= nameAccount.getText();
			assertTrue(nameAccount_actual.contains(Constants.nameRole));
		}
		
		public void enterusername(String arg1) {
			waitHelper.WaitForElement(this.username, 3);
			username.sendKeys(arg1);
		}
		
		public void enterpassword(String arg1) {
			waitHelper.WaitForElement(this.password, 3);
			password.sendKeys(arg1);
		}
		
		public void isErrorMessageDisplayed(String input) {
			waitHelper.WaitForElement(this.errormsg, 3);
			String errormsg_actual= errormsg.getText();
			System.out.println(errormsg_actual);
			assertTrue(errormsg_actual.contains(input));
		}
		
		
	}

