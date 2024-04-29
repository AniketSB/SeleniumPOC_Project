//package PageLayer;
//
//import BaseLayer.BaseClass;
//import UtilsLayer.ExcelUtility;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.io.IOException;
//
//public class ExcelTest extends BaseClass {
//
//    // Path to your Excel file
//    String filePath = "path/to/your/excel/file.xlsx";
//    // Name of the sheet in Excel file
//    String sheetName = "Sheet1";
//
//    // Initialize WebDriver
//    WebDriver driver = new ChromeDriver();
//
//
//    // Read data from Excel file
//    Object[][] testData = ExcelUtility.readExcel(filePath, sheetName);
//
//    // Loop through the data and perform actions
//        for (Object[] dataRow: testData) {
//        String username = (String) dataRow[0];
//        String password = (String) dataRow[1];
//
//        // Enter username and password
//        WebElement usernameInput = driver.findElement(By.id("username"));
//        WebElement passwordInput = driver.findElement(By.id("password"));
//        usernameInput.sendKeys(username);
//        passwordInput.sendKeys(password);
//
//        // Perform other actions and assertions
//
//        // Clear inputs for next iteration (if needed)
//        usernameInput.clear();
//        passwordInput.clear();
//    }
//
//
//
//    public ExcelTest() throws IOException {
//    }
//
//}
//}
