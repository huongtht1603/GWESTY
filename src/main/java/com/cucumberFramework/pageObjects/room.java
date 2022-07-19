package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebElement;

public class room {
	
	String roomName = "";
	int roomAdult, roomChildren;
	double roomPrice;
	WebElement viewDetails_Btn;

	public room(String pname,int padult, int pchildren, double pprice, WebElement pviewDetailsBtn ) {

		setRoomName(pname);
		setAdult(padult);
		setChildren(pchildren);
		setRoomPrice(pprice);
		setViewDetailBtn(pviewDetailsBtn);
		
	}
	
	
	public void setRoomName(String name) {
		roomName = name;
	}

	public void setAdult(int adult) {
		roomAdult = adult;
	}
	
	public void setChildren(int children) {
		roomChildren = children;
	}
	
	public void setRoomPrice(double price) {
		roomPrice = price;
	}	
	
	public void setViewDetailBtn(WebElement viewDetailsBtn) {
		viewDetails_Btn = viewDetailsBtn;
	}
	
	
	
	public int getAdultNo() {
		return roomAdult;
	}
	
	public int getChildrenNo() {
		return roomChildren;
	}
	
	public WebElement getWebElement() {
		return viewDetails_Btn;
	}
}
