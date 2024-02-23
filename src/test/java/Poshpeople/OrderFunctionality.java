package Poshpeople;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderFunctionality {

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
        
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//i[@class='fas fa-search'])[1]")).click();
        Thread.sleep(10000);
        
        driver.findElement(By.xpath("//a[contains(text(),'				test			')]")).click();
        Thread.sleep(10000);
        //+ ve icon on product details page 
        driver.findElement(By.xpath("//input[contains(@value,'+')]")).click();
        Thread.sleep(10000);
      //-ve icon on product details page
        driver.findElement(By.xpath("//input[contains(@value,'-')]")).click();
        Thread.sleep(10000);
       WebElement numberfield = driver.findElement(By.xpath("//input[contains(@class,'input-text qty text')]"));
       numberfield.clear();
       Thread.sleep(10000);
       numberfield.sendKeys("4");
       Thread.sleep(10000);
       //Add to cart button 
       driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
       Thread.sleep(10000);
       driver.findElement(By.xpath("(//i[contains(@class,'eicon-bag-medium')])[1]")).click();
       Thread.sleep(10000);
       driver.findElement(By.xpath("(//div[contains(@class,'elementor-menu-cart__close-button')])[1]")).click();
       Thread.sleep(10000);
       driver.findElement(By.xpath("(//button[contains(text(),'Buy Now')])[1]")).click();
       String actualurl = driver.getCurrentUrl();
       String expecteurl = "https://poshpeople.in/checkout/";
       Thread.sleep(10000);
       System.out.println(actualurl);
       if(actualurl.equals(expecteurl)) {
    	   System.out.println("actualurl is  matching with the expected url,program succesfully executed ");
       }
       else {
    	   System.out.println("actualurl is not matching with the expected url");
       }
       
      
        Thread.sleep(10000);
        
        
        
        
        
        driver.quit();
        
		
        
		
	}
	
}


	
		
		
		
		
		
		
	


