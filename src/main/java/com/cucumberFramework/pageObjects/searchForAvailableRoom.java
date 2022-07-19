package com.cucumberFramework.pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.AbstractPage;
import com.cucumberFramework.helper.WaitHelper;



public class searchForAvailableRoom extends AbstractPage {
	
	private WebDriver driver;
	WaitHelper waitHelper;

	
	@FindBy(xpath = "//input[@id='check-in']")
	public WebElement checkIn;
	
	@FindBy(xpath = "//input[@id='check-out']")
	public WebElement checkOut;
	
	@FindBy(xpath = "//input[@placeholder='Adult']")
	public WebElement adultTxt;
	
	@FindBy(xpath = "//input[@placeholder='Children']")
	public WebElement childrenTxt;
	
	@FindBy(xpath = "//input[@value='Search']")
	public WebElement searchBtn;
	
	@FindBy(xpath = "/html/body/section[2]/div/div/div/div/div[2]")
	public List <WebElement> roomList;
	
	@FindBy(xpath = "//h4[@class='form_title']")
	public WebElement bookingformTitle;
	
	@FindBy(xpath = "//input[@value='Book Now']")
	public WebElement bookingnowBtn;
	
	@FindBy(xpath = "//*[@id='adult']")
	public WebElement adultResult;
	
	@FindBy(xpath = "//*[@id='room']")
	public WebElement roomResult;
	
	
	public searchForAvailableRoom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	public void compareCapacity (int input1, int input2) throws InterruptedException {
		
		List<room> listOfRoom = new ArrayList<>();
		
		for (int i = 0; i < roomList.size(); i++) {	
			
		String roomname = roomList.get(i).findElement(By.xpath("div/h5")).getText(); 					
		System.out.println(roomname);
		
		
		String Adult = roomList.get(i).findElement(By.xpath("div/div[1]/strong[1]")).getText().replaceAll("[^0-9]", "");
		int adult = Integer.parseInt(Adult);	
		System.out.println(adult);
		
		String Children = roomList.get(i).findElement(By.xpath("div/div[1]/strong[2]")).getText().replaceAll("[^0-9]", "");	
		int children = Integer.parseInt(Children);
		System.out.println(children);
		
		String price = roomList.get(i).findElement(By.xpath("div/p/strong")).getText().replace("$", "");
		double Price = Double.parseDouble(price); 
		System.out.println(Price);
						
		WebElement viewDetailsBtn= driver.findElement(By.cssSelector("[class ='btn btn-success float-right']"));
		
		room r = new room(roomname, adult, children, Price, viewDetailsBtn);
		listOfRoom.add(r);	
		}
		
		for (room ro:listOfRoom) {	
			if ((ro.getAdultNo()<input1) && (ro.getChildrenNo()<input2)) {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				waitHelper.WaitForElement(ro.getWebElement(), 3);
				js.executeScript("arguments[0].click()", ro.getWebElement());
				int room_result = Integer.parseInt(roomResult.getAttribute("value"));
				int adultCapacity= (ro.getAdultNo())*room_result;
				int childrenCapacity= (ro.getChildrenNo())*room_result;
				assertTrue(adultCapacity>=input1);
				assertTrue(childrenCapacity>=input2);
				break;
			}
			}
	}
						
	
}

