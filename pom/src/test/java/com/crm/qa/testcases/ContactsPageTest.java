package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;
//import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage lp;
	HomePage hp;
	ContactPage cp;
	//DealsPage dp;
	//TaskPage tp;
	String sheetname="Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		cp = new ContactPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		hp.clickContactslink();
	}
	@Test//(priority=1)
	public void verifyConatctsPageLabelTest() {
		Assert.assertTrue(cp.verifyConatctLabel(), "Cotacts lbel is not displayed");
	}
	/*
	@Test//(priority=2)
	public void selectcontactTest() {
		cp.selectContactsByCount(2);
		
	}*/
	/*@Test//(priority=3)
	public void selectMultiContactsTest() {
		cp.selectContactsByCount(1);
		cp.selectContactsByCount(2);
	}
	*/
	/*@DataProvider
	public Object[][] getContactTestData() {
		Object data[][]=TestUtil.getTestData(sheetname);
	return data;
	}
	
	@Test(dataProvider="getContactTestData")
	public void validateCreateNewContact(String fname, String lname, String cpny) {
		hp.newContactLink();
		cp.creatNewContact(fname,lname,cpny);
	 
	}*/
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
}
