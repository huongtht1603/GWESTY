package com.cucumberFramework.pageObjects;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.AbstractPage;
import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;

public class checkOut extends AbstractPage{
	
	private WebDriver driver;
	WaitHelper waitHelper;
	
	@FindBy(xpath = "//*[@id='remove-scroll']/ul/li[7]/a/span")
	public WebElement bookingTab;
	
	@FindBy(xpath = "//input[@type='search']")
	public WebElement searchtxt;
	
	@FindBy(xpath = "//tbody/tr/td[8]/a[1]/i[1]")
	public WebElement eyeIcon;
	
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	public WebElement checkoutBtn;
	
	@FindBy(id = "btn-submit")
	public WebElement submitBtn;
	
	@FindBy(xpath = "//*[@id='tab1']/div/div/div/div[2]/div[2]/div/table/tbody[1]")
	public List <WebElement> rows;
	
	@FindBy(xpath = "//*[@id='tab1']/div/div/div/div[2]/div[3]/div/table/tbody[1]/tr/td[4]")
	public List <WebElement> servicesrows;
	
	@FindBy(xpath = "//*[@id='tab1']/div/div/div/div[2]/div[3]/div[1]/h3[1]")
	public WebElement total;
	
	
	
	
	public checkOut(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	public void clickAddBookingTab() {	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",bookingTab);
		js.executeScript("arguments[0].click()", bookingTab);
	}
	
	public void enterSearchData(String input) {
		waitHelper.WaitForElement(this.searchtxt, 3);
		searchtxt.sendKeys(input);
	}
	
	
	public void clickEyeIcon() {
		waitHelper.WaitForElement(this.eyeIcon, 3);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",eyeIcon);
		Constants.no = randomNumberString(1);
		driver.findElement(By.xpath("//tbody/tr["+ (Constants.no) + "]/td[8]/a[1]/i[1]")).click();
		}
	
	public void clickcheckoutButton() {
		waitHelper.WaitForElement(this.checkoutBtn, 3);
		checkoutBtn.click();
	}
	
	public void clicksubmitButton() {
		waitHelper.WaitForElement(this.submitBtn, 3);
		submitBtn.click();
	}
	
	public void isTotalPaidNightCorrected() throws ParseException {
		String price;
		String priceSer, qtySer = null;
		double priceRoom, priceService;
		double QtySer;
		double sum=0;
		double sumSer= 0, serFee_Total= 0;

        for (int i =0;i<rows.size();i++)
        {    
        	price= driver.findElement(By.xpath("//*[@id='tab1']/div/div/div/div[2]/div[2]/div/table/tbody[1]/tr[" + (i+1)+ "]/td[4]")).getText();
            priceRoom = Double.parseDouble(price);
            sum+=priceRoom;
        }
        	if (!(servicesrows.size()==0)) {
        		for (int i =0;i<servicesrows.size();i++){    
        			priceSer= driver.findElement(By.xpath("//*[@id='tab1']/div/div/div/div[2]/div[3]/div/table/tbody[1]/tr[" + (i+1)+ "]/td[4]")).getText();
        			priceService = Double.parseDouble(priceSer);
            
        			qtySer= driver.findElement(By.xpath("//*[@id='tab1']/div/div/div/div[2]/div[3]/div/table/tbody[1]/tr[" + (i+1)+ "]/td[5]")).getText();
            
        			QtySer = Double.parseDouble(qtySer);
        			sumSer= (priceService*QtySer);
        			sumSer+=sumSer;
        }
        }
        
        	String roomfee_total= driver.findElement(By.xpath("//*[@id='tab1']/div/div/div/div[2]/div[2]/div/table/tbody[2]/tr/td[2]/b")).getText().replace("$", "");;

        	double roomfee_Total = Double.parseDouble(roomfee_total);
        	
        	if (!(servicesrows.size()==0)) {
        		String serFee_total= driver.findElement(By.xpath("//*[@id='tab1']/div/div/div/div[2]/div[3]/div/table/tbody[2]/tr/td[2]/b")).getText().replace("$", "");;
        		serFee_Total = Double.parseDouble(serFee_total);
        	}
      
        	double Total= roomfee_Total+ serFee_Total+ (0.1* roomfee_Total);
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    		js.executeScript("arguments[0].scrollIntoView(true);", total);
        	String total_actual= total.getText().replace("Total : $", "");
        	System.out.println(total_actual);
        	double total_Actual = Double.parseDouble(total_actual);
        	assertTrue(Total==total_Actual);
      
	}
	
}
