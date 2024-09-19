package infosys_web_app;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Home_Page {
	

	
     WebDriver driver;
     
     
          @BeforeTest
	 void openApp() {
		  driver= new ChromeDriver();
		 driver.get("https://www.infosys.com/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));
		 driver.manage().window().maximize();	
	}
	
	    @Test(priority = 2)
		 void actions() throws InterruptedException {
			 
//		 1.click on careers
		 
		 driver.findElement(By.xpath("//a[.=\"Careers\" and @title=\"Explore Careers Opportunities\"]")).click();
		
//		 driver.findElement(By.xpath(""));
//		 driver.findElement(By.cssSelector(""));
		 
		 WebElement ele=driver.findElement(By.xpath("//input[@id=\"keywordSearch\"]"));
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView({block:'center'})" , ele);
		 driver.findElement(By.xpath("//input[@id=\"keywordSearch\"]")).sendKeys("QA automation tester");
		
		 
		 
		 driver.findElement(By.xpath("//span[.=\"Location\"]/parent::button[@type=\"button\"]")).click();
		 
		
			List<WebElement>  options=  driver.findElements(By.xpath("//input[@type=\"checkbox\"]/parent::label"));
			System.out.println("size of the countries names: " +options.size());
			
			
			for(WebElement option:options ) {
				System.out.println("->"+option.getText());
				if (option.getText().equals("India")) {
					
					option.click();
					break;
					
				}
				
			}
			
			driver.findElement(By.xpath("//span[.=\"Search\"]")).click();
			
		 System.out.println("pass1");
		 Thread.sleep(3000);
		 
		
		
		 }
		 
	   @AfterTest
	    void closeApp() {
		  ;
	    	driver.quit();;
	    }


	}


