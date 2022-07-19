package com.cucumberFramework.pageObjects;



import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumberFramework.helper.AbstractPage;
import com.cucumberFramework.helper.WaitHelper;

public class cancel extends AbstractPage {

	private WebDriver driver;
	WaitHelper waitHelper;

	@FindBy(xpath = "/html/body/section/div/div/div[3]/div[1]/a")
	public WebElement cancelBtn;

	@FindBy(xpath = "//*[@id='cancel-booking']/div/div/form/div[1]/div[1]/select")
	public static WebElement cancelReasonDrp;

	@FindBy(xpath = "//*[@id='cancel-booking']/div/div/form/div[2]/input")
	public WebElement cancelpopup;

	@FindBy(xpath = "/html/body/section/div/div[1]/div/h4")
	public List<WebElement> list;


	public void clickCancel() throws InterruptedException {
		waitHelper.WaitForElement(this.cancelBtn, 3);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", cancelBtn);
		js.executeScript("arguments[0].click()", cancelBtn);
	}

	public void selectReason() throws InterruptedException {

		Select mSelect = new Select(cancelReasonDrp);

		int count = cancelReasonDrp.findElements(By.xpath("option")).size();

		int random = ThreadLocalRandom.current().nextInt(1, count + 1);	
		mSelect.selectByIndex(random - 1);

	}

	public void clickCancelPopup() {
		waitHelper.WaitForElement(this.cancelpopup, 3);
		cancelpopup.click();
	}
	
	public int getSize() {
		return list.size();
	}

	public cancel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

}
