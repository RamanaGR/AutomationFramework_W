package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parallel {
    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setupBrowser(String browserName) throws InterruptedException {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            //driver.get("https://www.google.com/");
        } else if (browserName.equals("FireFox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equals("opera")) {
            System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/drivers/operadriver.exe");
            driver = new OperaDriver();
        }
    }

    @Test
    public void method() {
        driver.get("https://chromedriver.chromium.org/downloads");
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
