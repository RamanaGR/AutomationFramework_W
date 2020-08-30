package com.qa.pages;

import com.qa.base.TestBase;
import com.qa.utils.TestUtils;
import com.qa.utils.TestUtils.ElementImpl;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends TestBase {
    ElementImpl ele;
    @FindBy(xpath = "//span[contains(text(),'Log In')]")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@name='email']")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    WebElement login;

    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement signupBtn;

    @FindBy(xpath = "//div[@class='header']")
    WebElement failedMsg;
   // By loginBy = By.xpath("//div[@class='ui fluid large blue submit button']");

    public LoginPage() {

        PageFactory.initElements(driver, this);
        logger = Logger.getLogger(LoginPage.class.getName());
        logger.info("***********************LoginPageTest Started***************************");
    }

    public String validateLoginPage() {
        logger.info("Getting Title of LoginPage");
        return driver.getTitle();
    }

    public HomePage login(String un, String pwd) {
        logger.info("Click Login Btn");
        //loginBtn.click();
        ele=new ElementImpl(loginBtn);
        ele.click();

        logger.info("Entering UserName");

        ele=new ElementImpl(username);
        ele.sendKeys(un);

        //username.sendKeys(un);
        logger.info("Entering PW");
        password.sendKeys(pwd);
        login.click();
        //TestUtils.click(driver,loginBy);
        logger.info("*****************Login Completed******************");
        return new HomePage();
    }

    public String loginFail(String un, String pwd) throws IOException {
        loginBtn.click();
        username.sendKeys(un);
        password.sendKeys(pwd);
        login.click();
        TestUtils.takeScreenshotAtEndOfTest();
        return failedMsg.getText();
    }
}
