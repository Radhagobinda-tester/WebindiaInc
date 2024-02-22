package webndia.WebindiaINc;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllUrltest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		try {
            FileInputStream fis = new FileInputStream("F:\\Book1.xls");
            Workbook wb = WorkbookFactory.create(fis);

            // Get the sheet
            org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("Sheet1");

            // Check if the sheet exists
            if (sheet != null) {
                // Set the limit for row processing
                int startRow = 0; // Start row (inclusive)
                int endRow = 5; // End row (inclusive)

                // Iterate through each row within the specified range
                for (int rowNum = startRow; rowNum <= endRow; rowNum++) {
                    Row row = sheet.getRow(rowNum);

                    // Check if the row exists
                    if (row != null) {
                        // Get the cell value from the first column (index 0)
                        String url = row.getCell(1).getStringCellValue();

                        // Check if the URL is not empty
                        if (!url.isEmpty()) {
                            // Set up WebDriver
                            WebDriverManager.firefoxdriver().setup();
                            FirefoxDriver driver = new FirefoxDriver();
                            driver.manage().window().maximize();

                            // Navigate to the URL
                            driver.get(url);

                            // Wait for some time (5 seconds)
                            Thread.sleep(5000);

                            // Quit WebDriver
                            driver.quit();
                        } else {
                            System.out.println("URL is empty in row " + rowNum + ", column 1.");
                        }
                    } else {
                        System.out.println("Row " + rowNum + " is null.");
                    }
                }
            } else {
                System.out.println("Sheet 'Sheet1' not found.");
            }

            // Close the FileInputStream
            fis.close();

        } catch (IOException | EncryptedDocumentException | InterruptedException e) {
            e.printStackTrace();
        }




	}

}
