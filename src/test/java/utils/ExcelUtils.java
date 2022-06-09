package utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtils {

    public static void writeExcelTable(String path, String sheetName, List<WebElement> dataToWrite) throws IOException {
        File file = new File(path);
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sh = wb.createSheet(sheetName);

        for (int row = 0; row < dataToWrite.size(); row++) {
            XSSFRow rowValue = sh.createRow(row);
            List<WebElement> totalColumns = dataToWrite.get(row).findElements(By.tagName("td"));
            List<WebElement> totalth = dataToWrite.get(row).findElements(By.tagName("th"));
            if (totalth.size() > 0) {
                for (int column = 0; column < totalth.size(); column++) {
                    String alo = totalth.get(column).getText();
                    rowValue.createCell(column).setCellValue(alo);
                }

                for (int col = 0; col < totalColumns.size(); col++) {
                    String cellValue = totalColumns.get(col).getText();
                    rowValue.createCell(col + 1).setCellValue(cellValue);
                }
            } else {
                for (int col = 0; col < totalColumns.size(); col++) {
                    String cellValue = totalColumns.get(col).getText();
                    rowValue.createCell(col).setCellValue(cellValue);
                }
            }
        }
        FileOutputStream fos = new FileOutputStream(file);
        wb.write(fos);
        wb.close();

    }
}
