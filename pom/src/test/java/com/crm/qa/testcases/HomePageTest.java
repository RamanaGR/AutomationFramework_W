package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.utils.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	ContactPage cp;
	DealsPage dp;
	TaskPage tp;
	TestUtil testUtil;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		cp = new ContactPage();
		dp=new DealsPage();
		tp=new TaskPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test//(priority = 1)
	public void verifyHomePageTitleTest() {
		String hpTitle = hp.validateHomePageTitle();
		Assert.assertEquals(hpTitle, "Cogmento CRM", "HP Title not matched");
	}

	/*@Test
	public void verifyHomePageNameLabel() {
		String hpNameLabel = hp.validateHomePageNameLable();
		Assert.assertEquals(hpNameLabel, "Lakshay V", "HP NameLabel not matched");
	}

	@Test
	public void verifyContactPageLinkTest() {
		cp = hp.clickContactslink();
	}
	
	@Test
	public void verifyDealsPageLinkTest() {
		dp = hp.clickDealslink();
	}*/
//	@Test(priority=5)
//	public void verifyTaskPageTest() {
//		tp=hp.clickTasklink();
//	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
