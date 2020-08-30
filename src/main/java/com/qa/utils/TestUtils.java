package com.qa.utils;

import com.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TestUtils extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 30;
    public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"/src/main/java/com/qa/testdata/Book1.xlsx";
    static Workbook book;
    static Sheet sheet;

    public void switchToFrame() {
        driver.switchTo().frame("mainframe");
    }

    public static void click(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //Workbook
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // System.out.println(sheet.getLastRowNum() + "--------" +
        // sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                 System.out.println(data[i][k]);
            }
        }
        return data;
    }


    public static class ElementImpl implements Element {

        private final WebElement element;

        public ElementImpl(final WebElement element) {
            this.element = element;
        }

        public void click() {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
           // driver.findElement(element).click();
            element.click();
        }

        public void submit() {

        }

        public void sendKeys(CharSequence... keysToSend) {
            element.sendKeys(keysToSend);
        }

        public void clear() {

        }

        public String getTagName() {
            return null;
        }

        public String getAttribute(String s) {
            return null;
        }

        public boolean isSelected() {
            return false;
        }

        public boolean isEnabled() {
            return false;
        }

        public String getText() {
            return null;
        }

        public List<WebElement> findElements(By by) {
            return null;
        }

        public WebElement findElement(By by) {
            return null;
        }

        public boolean isDisplayed() {
            return false;
        }

        public Point getLocation() {
            return null;
        }

        public Dimension getSize() {
            return null;
        }

        public Rectangle getRect() {
            return null;
        }

        public String getCssValue(String s) {
            return null;
        }

        public boolean elementWired() {
            return false;
        }

        public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
            return null;
        }

        public WebElement getWrappedElement() {
            return null;
        }

        public Coordinates getCoordinates() {
            return null;
        }
    }


}


