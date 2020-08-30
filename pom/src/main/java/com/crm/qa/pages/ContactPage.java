package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtil;

public class ContactPage extends TestBase {

	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactpagelable;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[1]/div")
	WebElement checkbox2;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(xpath="//div[@name='company']")
	WebElement cmpny;
	
	@FindBy(xpath="//button[@class=\"ui linkedin button\"]")
	WebElement save;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyConatctLabel() {
		return contactpagelable.isDisplayed();
	}
	
	public void selectContactsByCount(int count) {
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr["+ count +"]/td[1]/div")).click();
	}
	
	public void creatNewContact(String ftname, String ltname, String cmp) {
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='"+cmp+"';", cmpny);
		//cmpny.sendKeys(cmp);
		save.click();
		
	}
	
}
