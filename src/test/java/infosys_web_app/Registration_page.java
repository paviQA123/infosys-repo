package infosys_web_app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration_page {
	
	     WebDriver driver;
	     
	@BeforeMethod
	void openApp() {
		driver= new ChromeDriver();
		 driver.get("https://career.infosys.com/register");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));
		 driver.manage().window().maximize();	
		 
	}
		  
	@Test(priority = 1)
	
	void Actions() {
//		 1.enter first name
		driver.findElement(By.cssSelector("[name=\"firstnameX\"]")).sendKeys("Pavithra");
		
//		 2.enter middle name
		driver.findElement(By.cssSelector("[class=\"ng-untouched ng-pristine ng-valid\"]")).sendKeys("pavi");
		
//		 3.enter last name
		driver.findElement(By.cssSelector("[formcontrolname=\"lastnameX\"]"+ "")).sendKeys("Sankarapu");
	
	
		
//		4.enter email id
		driver.findElement(By.cssSelector("[formcontrolname=\"emailX\"]")).sendKeys("pavipavitra.1005@gmail.com");
		
//		 5.enter password
		driver.findElement(By.cssSelector("[name=\"passwordX\"]")).sendKeys("Pavi9391@");
		
//		 6.enter same password
		driver.findElement(By.cssSelector("[name=\"cpasswordX\"]")).sendKeys("Pavi9391@");
		
//		click on privacy policy check box
		driver.findElement(By.cssSelector("[formcontrolname=\"termsnconditionX\"]")).click();
		
//		click on submit
		driver.findElement(By.xpath("//button[@type=\"button\"]")).click();
		
		}
	
	@Test(enabled = false)
	void ignore() {
		System.out.println("ignore test");
	
		 
	}
	@AfterMethod
	void close() {
		driver.quit();
	}

}
