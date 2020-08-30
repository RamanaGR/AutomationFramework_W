package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreeCRMApp {
    public static void main(String[] args) {
        //Setup-- System.setProperties("webdriver.crome.driver","//driver path")
        WebDriver driver = new ChromeDriver();
        driver.get("https://ui.freecrm.com/home");
        driver.findElement(By.xpath("loginxpath")).click();
        //signUP
        driver.get("");
        driver.navigate().to("");
        //loginpage
        //homepage
        //deals
        //comtacts
        //tasks
    }
    public void method(){

    }
}