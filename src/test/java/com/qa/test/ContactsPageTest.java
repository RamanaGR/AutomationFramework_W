package com.qa.test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class ContactsPageTest extends TestBase {

    LoginPage lp;
    HomePage hp;
    ContactsPage cp;
    String sheetname = "Contacts";

    public ContactsPageTest() {

        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        lp = new LoginPage();
        cp = new ContactsPage();
        hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
        hp.clickContactslink();
    }

    //@Test(priority = 1)
    public void verifyConatctsPageLabelTest() {
        Assert.assertTrue(cp.verifyConatctLabel(), "Cotacts lbel is not displayed");
    }

    //@Test(priority = 3)
    public void selectcontactTest() {
        cp.selectContactsByCount(2);
    }

    // @Test(priority = 2)//(dataProvider="getContactTestData")
    public void validateCreateNewContact() throws InterruptedException, IOException {
        String actual = cp.creatNewContact(prop.getProperty("firstName"), prop.getProperty("lastName"), prop.getProperty("cmny"));
        Assert.assertEquals(actual, "Monica Neena");
    }

    @DataProvider
    public Object[][] getContactTestData() {
        Object data[][] = TestUtils.getTestData(sheetname);
        return data;
    }
    //csv - comma seperated values- abu,mondal,inno -- OpenCSV lib

    @Test(dataProvider = "getContactTestData")
    public void validateCreateNewContact(String fname, String lname, String cpny) throws IOException, InterruptedException {
        cp.creatNewContact(fname, lname, cpny);
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }



    	/*@Test//(priority=3)
	public void selectMultiContactsTest() {
		cp.selectContactsByCount(1);
		cp.selectContactsByCount(2);
	}*/
    		/*@DataProvider
	public Object[][] getContactTestData() {
		Object data[][]=TestUtil.getTestData(sheetname);
	return data;
	}*/
}

