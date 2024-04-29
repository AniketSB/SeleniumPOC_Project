package UtilsLayer;

import BaseLayer.BaseClass;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UtilClass extends BaseClass {

    public static void click(WebElement wb) {
        if (wb.isDisplayed()) {
            wb.click();
        }
    }

    public static void enterdata(WebElement wb, String value) {
        wb.sendKeys(value);
    }

    public static void selectdata(WebElement wb, String value) {
        Select s = new Select(wb);
        s.selectByVisibleText(value);
    }

    public static void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void dismissAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public static void excelreader(String filepath, int index, int row, int cell) throws FileNotFoundException {
        File f = new File(filepath);
        FileInputStream fs = new FileInputStream(f);
        // Create a new Workbook
        Workbook workbook = new XSSFWorkbook(); // For .xlsx format, use XSSFWorkbook; for .xls, use HSSFWorkbook

        // Create a new Sheet
        Sheet sheet = workbook.getSheetAt(index);
    }
}