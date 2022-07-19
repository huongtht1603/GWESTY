package com.cucumberFramework.helper;

import java.time.Duration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumberFramework.helper.AutomationControl;

public class AbstractPage {

	public String randomText(int length) {

		String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		Random rand = new Random();

		// consider using a Map<String,Boolean> to say whether the identifier is being
		// used or not
		Set<String> identifiers = new HashSet<String>();

		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
			for (int i = 0; i < length; i++) {
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			}
			if (identifiers.contains(builder.toString())) {
				builder = new StringBuilder();
			}
		}
		return builder.toString();
	}
	
	
	public String randomNumberString(int length) {

		String lexicon = "1234567890";

		Random rand = new Random();

		// consider using a Map<String,Boolean> to say whether the identifier is being
		// used or not
		Set<String> identifiers = new HashSet<String>();

		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
		
			for (int i = 0; i < length; i++) {
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			}
			if (identifiers.contains(builder.toString())) {
				builder = new StringBuilder();
			}
		}
		return builder.toString();
	}
	
	
	public String randomString(int length) {

		String lexicon = "0123456789";

		Random rand = new Random();

		// consider using a Map<String,Boolean> to say whether the identifier is being
		// used or not
		Set<String> identifiers = new HashSet<String>();

		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
		
			for (int i = 0; i < length; i++) {
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			}
			if (identifiers.contains(builder.toString())) {
				builder = new StringBuilder();
			}
		}
		return builder.toString();
	}
	public void sleep(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Object executeJavaScript(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	public void scrollToBottomPage(WebDriver driver) {
		executeJavaScript(driver, "window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	}
	
	public void moveMouseToElement(WebDriver driver, String controlName) {
		waitForControl(driver, controlName, timeWait);
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, controlName), 156, 20);
		action.build().perform();
	}


	private void waitForControl(WebDriver driver, String controlName, int timeWait2) {
		// TODO Auto-generated method stub
		
	}

	public int randomInterger(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	public WebElement getElement(WebDriver driver, String controlName) {
		element = control.findElement(driver, controlName);
		return element;
	}
	
	public WebElement getElement(WebDriver driver, String specialControl, String value) {
		element = control.findElement(driver, specialControl, value);
		return element;
	}

	protected AutomationControl control = new AutomationControl();
	protected int timeWait = 30;
	protected int timeSleep = 2;
	protected WebElement element;
}
