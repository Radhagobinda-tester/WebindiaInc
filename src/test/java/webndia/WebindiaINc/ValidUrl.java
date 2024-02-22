package webndia.WebindiaINc;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidUrl {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("F:\\Book2.xlsx");
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
                        // Iterate through each cell in the row
                        for (Cell cell : row) {
                            // Check if the cell contains a URL
                            if (cell.getCellType() == CellType.STRING) {
                                String url = cell.getStringCellValue().trim();
                                // Check if the URL is not empty
                                if (!url.isEmpty()) {
                                    // Check if the URL is valid
                                    if (isValidUrl(url)) {
                                        System.out.println("Valid URL: " + url);
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
                                        System.out.println("Invalid URL: " + url);
                                    }
                                } else {
                                    System.out.println("Empty URL in row " + rowNum + ", column " + cell.getColumnIndex());
                                }
                            }
                        }
                    } else {
                        System.out.println("Row " + rowNum + " is null.");
                    }
                }
            } else {
                System.out.println("Sheet 'Sheet2' not found.");
            }

            // Close the FileInputStream
            fis.close();

        } catch (IOException | EncryptedDocumentException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to check if a URL is valid
    public static boolean isValidUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (IOException e) {
            return false;
        }
    }
}

