package com.qa.test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
    }

   // @Test(priority = 1)
    public void loginPageTitle() {
        String title = loginPage.validateLoginPage();//Title
        Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
    }

    @Test//(priority = 2)
    public void loginTest() {
        String un = prop.getProperty("username");
        String pw = prop.getProperty("password");
        homePage = loginPage.login(un, pw);
    }
    //@Test(priority = 3)
    public void shouldFailLogin() throws IOException {
        String un = prop.getProperty("wrongusername");
        String pw = prop.getProperty("wrongpassword");
        String fail = loginPage.loginFail(un, pw);
        Assert.assertEquals(fail,"Something went wrong...");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

