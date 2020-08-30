package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class DealsPageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	DealsPage dp;

	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		dp=new DealsPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		hp.clickDealslink();
	}

	@Test//(priority = 1)
	public void verifyDealsPageLableTest() {
		Assert.assertTrue(dp.verifyDealsPageLable(), "Deals label is not displayed");
	}

	@Test//(priority = 2)
	public void verifySearchbarTest() {
		
		Assert.assertEquals(dp.verifySearchBar("Aswath"), "Aswath Whitebox");
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
