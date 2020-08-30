package com.qa.test;

import com.qa.base.TestBase;
import com.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTest extends TestBase {
    LoginPage lp;
    HomePage hp;
    ContactsPage cp;
    DealsPage dp;
    TaskPage tp;
    //TestUtil testUtil;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        lp = new LoginPage();
        cp = new ContactsPage();
        dp = new DealsPage();
        tp = new TaskPage();
        hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    //@Test//(priority = 1)
    public void verifyHomePageTitleTest() {
        String actualHpTitle = hp.validateHomePageTitle();
        Assert.assertEquals(actualHpTitle, "Cogmento CRM", "HP Title not matched");
    }

    @Test
    public void verifyHomePageNameLabel() {
        String hpNameLabel = hp.validateHomePageNameLable();
        Assert.assertEquals(hpNameLabel, "Lakshay V", "HP NameLabel not matched");
    }

    //@Test
    public void verifyContactPageLinkTest() {
        cp = hp.clickContactslink();
    }
//
//	@Test
//	public void verifyDealsPageLinkTest() {
//		dp = hp.clickDealslink();
//	}

//	@Test(priority=5)
//	public void verifyTaskPageTest() {
//		tp=hp.clickTasklink();
//	}

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}


