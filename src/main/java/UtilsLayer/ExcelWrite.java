package UtilsLayer;

import BaseLayer.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWrite extends BaseClass {

    public static void writeDataToExcel(String filePath, List<List<Object>> data) {
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("API_DATA");

        int rowCount = sheet.getPhysicalNumberOfRows();
        // Write data to the sheet
//        int rowCount = 0;
            for (List<Object> rowData : data) {
                Row row = sheet.createRow(rowCount++);
                int columnCount = 0;
                for (Object field : rowData) {
                    Cell cell = row.createCell(columnCount++);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    } else if (field instanceof Double) {
                        cell.setCellValue((Double) field);
                    } // Add more data types as needed
            }
        }

        // Write the workbook content to the file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            System.out.println("Excel file has been created successfully at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the workbook to release resources
            try {
                workbook.close();
                System.out.println("Workbook has been closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void storeURLInWorkbook(String url,Sheet sheet,int statusCode) {
        // You can implement your logic here to store the URL in the workbook
        // For simplicity, let's just create a new row and store the URL in the first cell

        int lastRowNum = sheet.getLastRowNum();
        Row row = sheet.createRow(lastRowNum + 1);
        Cell cell_response = row.createCell(0);
        Cell cell_url= row.createCell(1);
        cell_response.setCellValue(statusCode);
        cell_url.setCellValue(url);
    }

    public static void storeAPIResponseInWorkbook(String apiEndpoint, Workbook workbook, int sheetIndex) {

        // Create a new sheet for each API endpoint

    Sheet sheet = workbook.createSheet("Response_" + (sheetIndex + 1));

    // Create headers row
    Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("url");
        headerRow.createCell(1).setCellValue("ResponseCode");

    // Create data row
    Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue(apiEndpoint);

}
}
