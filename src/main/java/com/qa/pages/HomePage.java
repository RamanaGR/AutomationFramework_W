package com.qa.pages;

import com.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {


    @FindBy(xpath = "//span[contains(text(),'Lakshay V')]")
    WebElement namelabel;

    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    WebElement contactslink;

    @FindBy(xpath = "//span[contains(text(),'Deals')]")
    WebElement dealslink;

    @FindBy(xpath = "//span[contains(text(),'Tasks')]")
    WebElement tasklink;

    public HomePage() {
        logger = Logger.getLogger(HomePage.class.getName());
        PageFactory.initElements(driver, this);
    }

    public String validateHomePageTitle() {
        return driver.getTitle();
    }

    public String validateHomePageNameLable() {
        logger.info("*************Checking Home Page Lable*********");
        return namelabel.getText();
        // driver.getTitle();
    }

    public ContactsPage clickContactslink() {
        contactslink.click();
        return new ContactsPage();

    }

    public DealsPage clickDealslink() {
        dealslink.click();
        return new DealsPage();

    }

    public TaskPage clickTasklink() {
        tasklink.click();
        return new TaskPage();

    }


}

