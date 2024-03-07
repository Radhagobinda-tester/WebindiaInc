package Poshpeople;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cartfunctionality {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String Url = "https://poshpeople.in/";
		WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        // Navigate to the URL
        driver.get(Url);

        WebElement title = driver.findElement(By.id("elementor-search-form-7b3f33d4"));
        title.sendKeys("test");

        Thread.sleep(20000);
        driver.findElement(By.xpath("(//i[@class='fas fa-search'])[1]")).click();
        Thread.sleep(20000);

        driver.findElement(By.xpath("//a[contains(text(),'				test			')]")).click();

        Thread.sleep(10000);

        //Add to cart button
        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();

        Thread.sleep(20000);
        driver.navigate().to("https://poshpeople.in");

        Thread.sleep(10000);

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("menu-item-3597"));

        actions.moveToElement(element).perform();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//span[normalize-space()='iPhone 15 Pro Max']")).click();

         Thread.sleep(20000);
         driver.findElement(By.xpath("//h2[normalize-space()='Artistic Colorful Bubble Wave Cases for iPhone']")).click();
         Thread.sleep(20000);
         WebElement dropdown = driver.findElement(By.xpath("(//select[@class='select-brands'])"));
         Select select = new Select(dropdown);
         Thread.sleep(10000);
         select.selectByVisibleText("iPhone 14 Pro Max");


        driver.findElement(By.xpath("(//button[normalize-space()='Add to cart'])[1]")).click();
        Thread.sleep(20000);


        //clicks on add to cart button present on top header
        driver.findElement(By.xpath("(//i[contains(@class,'eicon-bag-medium')])[1]")).click();

        Thread.sleep(10000);
        // click on view cart button
        driver.findElement(By.xpath("(//span[contains(text(),'View cart')])[1]")).click();
        Thread.sleep(20000);
        //click on +ve icon
        driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(5) div:nth-child(1) input:nth-child(3)")).click();

        Thread.sleep(10000);
      //click on - ve icon
        driver.findElement(By.xpath("(//input[@value='-'])[7]")).click();
        Thread.sleep(10000);
        //click on number field
       WebElement numField =  driver.findElement(By.xpath("(//input[@title='Qty'])[7]"));
       numField.clear();
       numField.sendKeys("4");
        Thread.sleep(10000);
        //Clicks on Update cart button
        driver.findElement(By.xpath("(//button[normalize-space()='Update cart'])[1]")).click();

        Thread.sleep(10000);

        // Clicks on proceed to cart button
        driver.findElement(By.xpath("//a[normalize-space()='Proceed to checkout']")).click();

        Thread.sleep(10000);
        //navigate back

        driver.navigate().back();
     	   Thread.sleep(30000);

        driver.findElement(By.xpath("(//a[@aria-label='Remove this item'])[13]")).click();

        Thread.sleep(30000);

        driver.findElement(By.xpath("(//a[@class='remove'])[1]")).click();

        Thread.sleep(30000);

        driver.findElement(By.xpath("(//a[normalize-space()='Return to shop'])[1]")).click();

        Thread.sleep(20000);


        String currentURl= driver.getCurrentUrl();

        String ExpectedURL5= "https://poshpeople.in/shop/";

        if(currentURl.equals(ExpectedURL5)) {
     	   System.out.println("actualurl is  matching with the expected url,user is able to add single product program is succesfully executed. ");
        }
        else {
     	   System.out.println("actualurl is not matching with the expected url");
        }

        Thread.sleep(30000);
        driver.quit();







	}

}
