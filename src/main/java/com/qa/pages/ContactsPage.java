package com.qa.pages;

import com.qa.base.TestBase;
import com.qa.utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class ContactsPage extends TestBase {
    TestUtils testUtils = new TestUtils();

    @FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
    WebElement contactpagelable;

//    @FindBy(xpath = "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[1]/div")
//    WebElement checkbox2;

    @FindBy(name = "first_name")
    WebElement firstname;

    @FindBy(name = "last_name")
    WebElement lastname;

    @FindBy(xpath = "//div[@name='company']")
    WebElement cmpny;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement save;
    @FindBy(xpath = "//button[contains(text(),'New')]")
    WebElement newBtn;
    @FindBy(xpath = "//div[@id='dashboard-toolbar']/div[1]")
    WebElement contactName;

    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyConatctLabel() {
        return contactpagelable.isDisplayed();
    }

    public void selectContactsByCount(int count) {
        driver.findElement(By.xpath("//*[@id='ui']/div/div[2]/div[2]/div/div[2]/table/tbody/tr[" + count + "]/td[1]/div")).click();
    }

    public String creatNewContact(String ftname, String ltname, String cmp) throws InterruptedException, IOException {
        newBtn.click();
        firstname.sendKeys(ftname);
        lastname.sendKeys(ltname);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value='" + cmp + "';", cmpny);
        //cmpny.sendKeys(cmp);
        save.click();
        Thread.sleep(10000);
        testUtils.takeScreenshotAtEndOfTest();
        return contactName.getText();
    }

}


