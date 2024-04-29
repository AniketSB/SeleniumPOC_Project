package UtilsLayer;

import BaseLayer.BaseClass;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility extends BaseClass {

    public static Object[][] readExcel(String filePath, String sheetName, String testCase) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][columnCount];
        String columnName;
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.getCell(j);
                System.out.println("Cells ****" +cell);
                if (cell.getStringCellValue().equals(testCase)) {
                     columnName =cell.getRow().getCell(j+1).getStringCellValue();
                    if (columnName.equals("YES")) {
                        data[i][j] = cell.getStringCellValue();
                        System.out.println("Get cell values " + data[i][j]);
                    }
                }
            }
        }

        workbook.close();
        file.close();

        return data;
    }
}
