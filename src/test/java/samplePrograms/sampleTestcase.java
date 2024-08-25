package samplePrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class sampleTestcase {
	
	WebDriver driver;
	
	@Test
	void login() {
	driver = new ChromeDriver();
	
	
	driver.get("https://www.facebook.com/");
	
//	driver.findElement(By.id("user_email_login")).sendKeys("abc@gmail.com");
	WebElement username=driver.findElement(By.id("email"));
	username.sendKeys("abc@gmail.com");
	
//	driver.findElement(By.id("user_password")).sendKeys("your_password");
	WebElement password=driver.findElement(By.id("pass"));
    password.sendKeys("your_password");
    
//  driver.findElement(By.id("user_password")).click();
//	WebElement login=driver.findElement(By.name("login"));
//	login.click();
	
	}

	
}
