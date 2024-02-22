package webndia.WebindiaINc;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public class Urltest {



	public static  void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		/*FileInputStream fis = new FileInputStream("F:\\Book1.xls");
		Workbook wb = WorkbookFactory.create(fis);
		String Url = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Url);

		Thread.sleep(5000);
        driver.quit();

		*/

		/*
		        try {
		            FileInputStream fis = new FileInputStream("F:\\Book1.xls");
		            Workbook wb = WorkbookFactory.create(fis);

		            // Get the sheet
		            org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("Sheet1");

		            // Check if the sheet exists
		            if (sheet != null) {
		                // Get the row
		                Row row = sheet.getRow(0);

		                // Check if the row exists
		                if (row != null) {
		                    // Get the cell value
		                    String Url = row.getCell(1).getStringCellValue();

		                    // Check if the URL is not empty
		                    if (!Url.isEmpty()) {
		                        // Set up WebDriver
		                        WebDriverManager.firefoxdriver().setup();
		                        WebDriver driver = new FirefoxDriver();
		                        driver.manage().window().maximize();

		                        // Navigate to the URL
		                        driver.get(Url);

		                        // Wait for some time (5 seconds)
		                        Thread.sleep(5000);

		                        // Quit WebDriver
		                        driver.quit();


		                    } else {
		                        System.out.println("URL is empty in row 1, column 1.");
		                    }
		                } else {
		                    System.out.println("Row 1 is null.");
		                }
		            } else {
		                System.out.println("Sheet 'Sheet1' not found.");
		            }

		            // Close the FileInputStream
		            fis.close();

		        } catch (IOException | EncryptedDocumentException | InterruptedException e) {
		            e.printStackTrace();
		        }
		        */
		    }


	}


