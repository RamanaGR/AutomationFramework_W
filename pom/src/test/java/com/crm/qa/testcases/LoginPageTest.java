package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	HomePage hp;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitle() {
		String title = lp.validateLoginPage();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}

	@Test(priority = 2)
	public void loginTest() {
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
