import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gmailLogin {
    public static void main(String[] args) throws InterruptedException {
        // Set up WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to Gmail login page
        driver.get("https://mail.google.com");

        // Enter email and proceed to the next step
        WebElement emailInput = driver.findElement(By.id("identifierId"));
        emailInput.sendKeys("radhagobinda7894@gmail.com");

        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(15000);
        // Add a wait here if needed for the password field to load
        Thread.sleep(25000); // Adjust the wait time as needed

        // Enter password and proceed to login
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("your_password");
        driver.findElement(By.id("passwordNext")).click();

        // Handling Two-Factor Authentication (2FA) if enabled
        // You need to implement the code to input the 2FA verification code if required

        // Add a wait here if needed for the Gmail page to load after login
        Thread.sleep(10000); // Adjust the wait time as needed

        // Perform actions after successful login
        // For example, compose and send an email
        /*
        driver.findElement(By.cssSelector(".T-I-KE")).click(); // Click on compose button
        WebElement toInput = driver.findElement(By.name("to"));
        toInput.sendKeys("hr_email@company.com");

        WebElement subjectInput = driver.findElement(By.name("subjectbox"));
        subjectInput.sendKeys("Subject of your email");

        WebElement bodyInput = driver.findElement(By.cssSelector(".Am.Al.editable.LW-avf"));
        bodyInput.sendKeys("Body of your email");

        driver.findElement(By.cssSelector(".T-I.J-J5-Ji.aoO.T-I-atl.L3")).click(); // Click on send button
        */

        // Close the browser session
        driver.quit();
    }
}
