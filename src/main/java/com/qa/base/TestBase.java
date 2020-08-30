package com.qa.base;

import com.qa.utils.WebEventListener;
import net.bytebuddy.implementation.FieldAccessor;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public Properties prop;
    public static WebDriver driver;
    public static Logger logger = null;
    EventFiringWebDriver e_driver;
    WebEventListener eventListener;

    @BeforeTest
    public static void setLog4j() {
        String log4jPath = System.getProperty("user.dir") + "/src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jPath);
    }

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/qa/config/configuration.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //@Parameters("browser")
    public void initialization() {
        String browserName = prop.getProperty("browser");//Opera
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equals("FireFox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equals("Opera")) {
            System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/drivers/operadriver.exe");
            driver = new OperaDriver();
        } else if (browserName.equals("Safari")) {
            System.setProperty("webdriver.safari.driver", System.getProperty("user.dir") + "/drivers/safaridriver.exe");
            driver = new SafariDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();//Maximize window
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));

    }
}
