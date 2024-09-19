package infosys_web_app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sign_in_page {
	WebDriver driver;
	@BeforeClass
	     void openApp() {
		driver= new ChromeDriver();
		 driver.get("https://intapidm.infosysapps.com/auth/realms/careersite/protocol/openid-connect/auth?client_id=careersite&redirect_uri=https%3A%2F%2Fcareer.infosys.com%2Fjobs%2Fprivacy-consent&state=94c42ba4-886e-434f-88b8-0b331ec5a401&response_mode=fragment&response_type=code&scope=openid&nonce=b5642f10-598b-47e1-96fc-745e536bde29");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));
		 driver.manage().window().maximize();
	}
	@Test
	void actions() throws InterruptedException {
		System.out.println("title of the webpage : "+driver.getTitle());
		
//		1.enter email
		driver.findElement(By.id("username")).sendKeys("pavipavitra.1005@gmail.com");
		
//      2.click hidden eye
		
		driver.findElement(By.xpath("//img[@src=\"/auth/resources/8zoiq/login/INTAP/img/icon-eye.png\"]")).click();
		Thread.sleep(3000);
		
//		3.enter password as per the registration
		driver.findElement(By.id("password")).sendKeys("Pavi9391@");
		
		
//		4.click on submit
		driver.findElement(By.id("btnSubmit")).click();
		String con=driver.findElement(By.id("input-error")).getText();
		System.out.println(con);
	}

		
	
               @AfterClass
               void close() {
            	   driver.quit();
               }

}
