package Poshpeople;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test(invocationCount = 3)
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

        Thread.sleep(20000);
        driver.findElement(By.xpath("(//i[@class='fas fa-search'])[1]")).click();
        Thread.sleep(20000);

        driver.findElement(By.xpath("//a[contains(text(),'				test			')]")).click();



        Thread.sleep(20000);
        //+ ve icon on product details page
        driver.findElement(By.xpath("//input[contains(@value,'+')]")).click();
        Thread.sleep(10000);
      //-ve icon on product details page
        driver.findElement(By.xpath("//input[contains(@value,'-')]")).click();
        Thread.sleep(10000);
       WebElement numberfield = driver.findElement(By.xpath("//input[contains(@class,'input-text qty text')]"));
       numberfield.clear();
       Thread.sleep(10000);
       numberfield.sendKeys("1");
       Thread.sleep(10000);

       //Add to cart button
       driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
       Thread.sleep(20000);
       //clicks on cart button present on  top header
       driver.findElement(By.xpath("(//i[contains(@class,'eicon-bag-medium')])[1]")).click();
       Thread.sleep(10000);

       driver.findElement(By.xpath("(//div[contains(@class,'elementor-menu-cart__close-button')])[1]")).click();
       Thread.sleep(10000);
       WebElement qty = driver.findElement(By.xpath("(//span[contains(text(),'1')])[1]"));
       Thread.sleep(10000);
       String actualqty = "1";
       Thread.sleep(10000);

       String expectedqty = qty.getText();
       Thread.sleep(10000);

       System.out.println(expectedqty);
       Thread.sleep(10000);

      if(actualqty.equals(expectedqty)) {
    	  System.out.println("Add product quantity is matching with the cart quantity");
      }
      else {
    	  System.out.println("Add product quantity is matching with the cart quantity");
      }
       Thread.sleep(5000);
       driver.findElement(By.xpath("(//button[contains(text(),'Buy Now')])[1]")).click();
       Thread.sleep(10000);
       String actualurl = driver.getCurrentUrl();
       String expecteurl = "https://poshpeople.in/checkout/";
       Thread.sleep(20000);
       System.out.println(actualurl);

       if(actualurl.equals(expecteurl)) {
    	   System.out.println("actualurl is  matching with the expected url,user is able to add single product program is succesfully executed. ");
       }
       else {
    	   System.out.println("actualurl is not matching with the expected url");
       }

       Thread.sleep(10000);


       driver.navigate().to("https://poshpeople.in");

       Thread.sleep(10000);

       Actions actions = new Actions(driver);
       WebElement element = driver.findElement(By.id("menu-item-3597"));

       actions.moveToElement(element).perform();
       Thread.sleep(10000);

        driver.findElement(By.xpath("(//span[contains(text(),'1')])[1]")).click();

        Thread.sleep(20000);
        driver.findElement(By.xpath("//h2[normalize-space()='Artistic Colorful Bubble Wave Cases for iPhone']")).click();
        Thread.sleep(20000);
        WebElement dropdown = driver.findElement(By.xpath("(//select[@class='select-brands'])"));
        Select select = new Select(dropdown);
        Thread.sleep(10000);
        select.selectByVisibleText("iPhone 14 Pro Max");


        /*
        driver.findElement(By.xpath("(//select[@class='select-brands']")).click();
        Thread.sleep(20000);
        driver.findElement(By.xpath("((//option[contains(text(),'iPhone 14 Pro Max')])[2]")).click();
        */
        Thread.sleep(20000);
        //Add to wish list option
        driver.findElement(By.xpath("//a[@name='add-to-wishlist']")).click();
        Thread.sleep(20000);
       driver.navigate().refresh();
        Thread.sleep(20000);



       driver.findElement(By.xpath("(//a[@name='wishlist'])[1]")).click();
        Thread.sleep(20000);
        WebElement text = driver.findElement(By.xpath("//a[normalize-space(text())='Artistic Colorful Bubble Wave Cases for iPhone - iPhone 14 Pro Max']"));
        String expectedText = "Artistic Colorful Bubble Wave Cases for iPhone - iPhone 14 Pro Max";
        String actualText = text.getText();
        if(actualText.equals(expectedText)) {
     	   System.out.println("The added product name :"+ ""+actualText);
        }
        else {
     	   System.out.println("The added product is not added ");
        }
        Thread.sleep(20000);
        //Check box
        driver.findElement(By.xpath(" //input[@title='Select all for bulk action']")).click();
        Thread.sleep(20000);
        //Action Dropdown
        WebElement actionDD = driver.findElement(By.id("tinvwl_product_actions"));
        Thread.sleep(20000);
        scrollToElement(driver, actionDD);
        Thread.sleep(20000);
        Select select1 = new Select(actionDD);
        select1.selectByVisibleText("Remove");

        Thread.sleep(10000);
      //Apply action button

        driver.findElement(By.xpath("(//button[@title='Apply Action'])[1]")).click();
        Thread.sleep(20000);

        driver.navigate().to("https://poshpeople.in/product/artistic-colorful-bubble-wave-cases-for-iphone/?attribute_pa_brand=iphone-14-pro-max");
        Thread.sleep(20000);

        WebElement dropdown1 = driver.findElement(By.xpath("(//select[@class='select-brands'])"));
        Select select2 = new Select(dropdown1);
        Thread.sleep(10000);
        select2.selectByVisibleText("iPhone 14 Pro Max");


        driver.findElement(By.cssSelector(" div[class='woocommerce-variation-add-to-cart variations_button woocommerce-variation-add-to-cart-enabled'] input[value='+']")).click();
        Thread.sleep(10000);
        //div[class='woocommerce-variation-add-to-cart variations_button woocommerce-variation-add-to-cart-enabled'] input[value='+']
        driver.findElement(By.cssSelector("div[class='woocommerce-variation-add-to-cart variations_button woocommerce-variation-add-to-cart-enabled'] input[value='-']")).click();

        Thread.sleep(10000);
        WebElement qty1 =  driver.findElement(By.xpath("(//input[contains(@name,'quantity')])"));
       Thread.sleep(10000);
       qty1.clear();
       Thread.sleep(10000);
       qty1.sendKeys("1");
       Thread.sleep(20000);


       driver.findElement(By.xpath("//button[normalize-space(text())='Add to cart']")).click();
       Thread.sleep(20000);
       driver.findElement(By.cssSelector("button[value='17197']")).click();
      // button[value='17197']
       //driver.findElement(By.xpath("//button[normalize-space(text()='Buy Now']")).click();
       Thread.sleep(10000);

       String actualurl1 = driver.getCurrentUrl();
       String expecteurl1 = "https://poshpeople.in/checkout/";
       Thread.sleep(20000);
       System.out.println(actualurl1);
       Thread.sleep(20000);
       if(actualurl1.equals(expecteurl1)) {
    	   System.out.println("actualurl is  matching with the expected url,user is able to add multiple product program is succesfully executed. ");
       }
       else {
    	   System.out.println("actualurl is not matching with the expected url");
       }

       Thread.sleep(10000);

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

       Thread.sleep(20000);

       driver.findElement(By.xpath("(//a[@class='remove'])[1]")).click();
       Thread.sleep(30000);

       driver.findElement(By.xpath("(//a[normalize-space()='Return to shop'])[1]")).click();

       Thread.sleep(20000);


       String currentURl= driver.getCurrentUrl();

       String ExpectedURL5= "https://poshpeople.in/shop/";
       Thread.sleep(10000);

       if(currentURl.equals(ExpectedURL5)) {

    	   System.out.println("Congrats user is on shop page the program exucted Successfully");
       }

       else {
    	   System.out.println("user is not on shop page ");
       }

       Thread.sleep(10000);
       driver.quit();
	}

	// Function to scroll to a specific WebElement
    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
	}

}









