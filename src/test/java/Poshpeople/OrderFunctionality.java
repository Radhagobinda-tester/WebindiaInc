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
       
        Thread.sleep(5000);
        //+ ve icon on product details page 
        driver.findElement(By.xpath("//input[contains(@value,'+')]")).click();
        Thread.sleep(5000);
      //-ve icon on product details page
        driver.findElement(By.xpath("//input[contains(@value,'-')]")).click();
        Thread.sleep(5000);
       WebElement numberfield = driver.findElement(By.xpath("//input[contains(@class,'input-text qty text')]"));
       numberfield.clear();
       Thread.sleep(5000);
       numberfield.sendKeys("4");
       Thread.sleep(5000);
       //Add to cart button 
       driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
       Thread.sleep(5000);
       driver.findElement(By.xpath("(//i[contains(@class,'eicon-bag-medium')])[1]")).click();
       Thread.sleep(5000);
       driver.findElement(By.xpath("(//div[contains(@class,'elementor-menu-cart__close-button')])[1]")).click();
       Thread.sleep(5000);
       WebElement qty = driver.findElement(By.xpath("(//span[contains(text(),'4')])[1]"));
       Thread.sleep(5000);
       String actualqty = "4";
       Thread.sleep(5000);

       String expectedqty = qty.getText();
       Thread.sleep(5000);

       System.out.println(expectedqty);
       Thread.sleep(5000);

      if(actualqty.equals(expectedqty)) {
    	  System.out.println("Add product quantity is matching with the cart quantity");
      }
      else {
    	  System.out.println("Add product quantity is matching with the cart quantity");
      }
       Thread.sleep(5000);
       driver.findElement(By.xpath("(//button[contains(text(),'Buy Now')])[1]")).click();
       Thread.sleep(5000);
       String actualurl = driver.getCurrentUrl();
       String expecteurl = "https://poshpeople.in/checkout/";
       Thread.sleep(5000);
       System.out.println(actualurl);
      
       if(actualurl.equals(expecteurl)) {
    	   System.out.println("actualurl is  matching with the expected url,program succesfully executed. ");
       }
       else {
    	   System.out.println("actualurl is not matching with the expected url");
       }
        
       
       driver.navigate().back();
       Thread.sleep(10000);
       // click on cart button 
       driver.findElement(By.xpath("(//i[contains(@class,'eicon-bag-medium')])[1]")).click();
       Thread.sleep(5000);
       // click on view cart button 
       driver.findElement(By.xpath("(//span[contains(text(),'View cart')])[1]")).click();
       Thread.sleep(5000);
       driver.findElement(By.xpath("(//input[contains(@class,'plus')])[3]")).click();
       Thread.sleep(5000);
       driver.findElement(By.xpath("(//input[contains(@class,'minus')])[3]")).click();
       Thread.sleep(5000);
     WebElement t =   driver.findElement(By.xpath(" (//input[contains(@class,'input-text qty text')])[3]"));
     Thread.sleep(5000);
      t.clear();
      Thread.sleep(5000);
      t.sendKeys("4");
      // click on update cart
      driver.findElement(By.xpath("(//button[contains(text(),'Update cart')])")).click();
      Thread.sleep(10000);
      driver.findElement(By.xpath("(//a[normalize-space(text())='Proceed to checkout'])")).click();
      Thread.sleep(5000);
   
      
      String actualurl1 = driver.getCurrentUrl();
      Thread.sleep(5000);
      String expecteur1 = "https://poshpeople.in/checkout/";
      Thread.sleep(5000);
      System.out.println(actualurl);
     
      if(actualurl.equals(expecteurl)) {
   	   System.out.println("actualurl is  matching with the expected url,user naviagates through the cart button and program is succesfully executed. ");
      }
      else {
   	   System.out.println("actualurl is not matching with the expected url");
      }
       Thread.sleep(10000);
        
        driver.quit();
        
		
        
		
	}
}


	
		
		
		
		
		
		
	


