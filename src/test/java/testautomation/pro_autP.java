package testautomation;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class pro_autP {
	
	public static void main(String args[]) throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		// Launch the browser
		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		
		Actions actn=new Actions(driver);
		
		// enter name
driver.findElement(By.id("name")).sendKeys("Pavithra");
		
		// enter email
		driver.findElement(By.id("email")).sendKeys("Pavi123@gmail.com");
		
		// enter ph.no
		driver.findElement(By.id("phone")).sendKeys("9876543210");
		
		// enter address 
		driver.findElement(By.id("textarea")).sendKeys("SR nagar,");

		actn.sendKeys(Keys.ENTER).perform();
		
		driver.findElement(By.id("textarea")).sendKeys("Hyderabad");	
		actn.sendKeys(Keys.ENTER).perform();	
		driver.findElement(By.id("textarea")).sendKeys("Telangana");	
		actn.sendKeys(Keys.ENTER).perform();
		
		// select gender
		driver.findElement(By.id("female")).click();
		
		//select the check boxes
		List<WebElement>  check= driver.findElements(By.cssSelector("[class=\"form-check-input\"][type=\"checkbox\"]"));
		System.out.println("size   :" +check.size());
		
		for(int  i=0 ; i<=2;i++) {
			check.get(i).click();
			
		}
		for(int  j=4 ; j<=6;j++) {
			check.get(j).click();
			
		}
		
		
		//select the countries
		
		Select op=new Select(driver.findElement(By.cssSelector("#country")));
		List<WebElement>  options=  driver.findElements(By.xpath("//select[@id=\"country\"]/option"));
		System.out.println("size of the countries names: " +options.size());
		
		op.selectByValue("france");
		for(WebElement option:options ) {
			System.out.println(option.getText());
			if (option.getText().equals("India")) {
				option.click();
			}
		}
		
		Select op1=new Select(driver.findElement(By.cssSelector("#colors")));
		List<WebElement>  cols=  driver.findElements(By.xpath("//select[@id=\"colors\"]/option"));
		System.out.println("size of the countries names: " +cols.size());
		
//		op1.selectByVisibleText("Blue");
		for(WebElement col:cols ) {
			System.out.println(col.getText());
			if (col.getText().equals("White")) {
				col.click();
			}
		}
		
		driver.findElement(By.cssSelector("#datepicker")).click();
		
		driver.findElement(By.xpath("//span[.=\"Next\" ][@class=\"ui-icon ui-icon-circle-triangle-e\"]")).click();
		
		driver.findElement(By.xpath("//a[.=\"26\"]")).click();
		
		//click on orange hrm
		
		driver.findElement(By.xpath("//a[.=\"orange HRM\"]")).click();
		
		//enter user name and password
		driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[.=\" Login \"]")).click();
		
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		
		
		//clicking on home page
		
		driver.findElement(By.xpath("//a[.=\"Home\"]")).click();
		Thread.sleep(4000);
		driver.navigate().back();
		
		driver.findElement(By.xpath("//h2[.=\"Pagination Table\"]/parent::div//a[.=\"2\"]")).click();
		Thread.sleep(4000);
	List<WebElement>  ele=	driver.findElements(By.xpath("//td/input[@type=\"checkbox\"]"));
	Thread.sleep(2000);
	System.out.println("size  " +ele.size());
	for(int k=0;k<2;k++) {
		ele.get(k).click();
	}
	Thread.sleep(2000);
	
	
	for(int i=3;i<=4;i++) {
		ele.get(i).click();
	}
		
	
	
	//searching something
	
	driver.findElement(By.cssSelector("#Wikipedia1_wikipedia-search-input")).sendKeys("selenium automation testing");
	driver.findElement(By.cssSelector(".wikipedia-search-button")).click();
	
	 String parent_id=driver.getWindowHandle();
	 System.out.println(parent_id);
	
	driver.findElement(By.xpath("//button[.=\"New Browser Window\"]")).click();
	
	
	Thread.sleep(4000);

	Set<String>  winids=driver.getWindowHandles();
for(String  id:winids) {
	
	System.out.println(id);
}
String child_id=driver.getWindowHandle();
System.out.println(child_id);


driver.switchTo().window(parent_id);

//Alerts 
		//ok
driver.findElement(By.xpath("//button[.=\"Alert\"]")).click();
System.out.println(" Text in the alert box : "+driver.switchTo().alert().getText());
driver.switchTo().alert().accept();

// cancle
driver.findElement(By.xpath("//button[.=\"Confirm Box\"]")).click();
System.out.println(" Text in the alert box : "+driver.switchTo().alert().getText());
driver.switchTo().alert().dismiss();
System.out.println("msg "+driver.findElement(By.cssSelector("[id=\"demo\"]")).getText());

//prompt
driver.findElement(By.xpath("//button[.=\"Prompt\"]")).click();
Alert al=driver.switchTo().alert();
System.out.println(" Text in the alert box : "+al.getText());

al.sendKeys("hi im pavithra");
Thread.sleep(4000);

al.dismiss();
System.out.println("msg "+driver.findElement(By.cssSelector("[id=\"demo\"]")).getText());


//double click 

 WebElement doubleclick  = driver.findElement(By.xpath("//button[.=\"Copy Text\"]"));

//actn.doubleClick(doubleclick).build().perform();
WebElement fd1=driver.findElement(By.cssSelector("[id=\"field1\"]"));
WebElement fd2=driver.findElement(By.cssSelector("[id=\"field2\"]"));


 
	String fd2_value=fd2.getAttribute("value");
	System.out.println("fd2_value"+fd2_value);
	if(fd2_value.equals("Hello World!")) {
		System.out.println("pass");
				}

	
	
	  WebElement src=  driver.findElement(By.xpath("//p[.=\"Drag me to my target\"]"));
   WebElement des=driver.findElement(By.xpath("//p[.=\"Drop here\"]"));
   actn.dragAndDrop(src, des).perform();
   Thread.sleep(2000);
   

   WebElement slider=  driver.findElement(By.xpath("//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"]"));
 System.out.println(  slider.getLocation());
//slider.click();
	actn.dragAndDropBy(src, 900, 1144).perform();
	System.out.println("min is pass"); 

	
		//frames
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name=\"RESULT_TextField-0\"]")).sendKeys("Pawan kalyan");
		driver.findElement(By.xpath("//td/label[.=\"Female\"]")).click();
		
		//calender
		
		WebElement cal=driver.findElement(By.cssSelector("[name=\"RESULT_TextField-2\"]"));
		cal.click();
		cal.sendKeys("05/02/2026");
		
		driver.findElement(By.cssSelector("datepicker")).click();
		
		
		//drop down
	
		Select  sel =new Select(driver.findElement(By.cssSelector("[id=\"RESULT_RadioButton-3\"]")));
		
		sel.selectByVisibleText("Automation Engineer");
		
		driver.findElement(By.xpath("input[type=\"submit\"][id=\"FSsubmit\"]")).click();
		
		//resizable
		
       WebElement	resizable =	driver.findElement(By.cssSelector("[class=\"ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se\"]"));
//       System.out.println(resizable.geo);
  
    actn.dragAndDropBy(resizable, 1300, 700).perform();

	}
}
