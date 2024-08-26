package samplePrograms;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testFlipkart {

WebDriver driver;

	@Test
	void login() {
	
	// Initialize required variables	
    String strLoginValue;
    String strHeaderName;
	String strHeader;		
    
	// Open chrome browser 
	driver = new ChromeDriver();
	
	// Navigate to Flipkart application
	driver.get("https://www.flipkart.com/");
	
	// To maximize the chrome browser
	driver.manage().window().maximize();
	
	// Wait until Flipkart logo is displayed
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='Flipkart']")));
	
	// Verify  Flipkart logo is displayed
	WebElement strFlipkartLogo = driver.findElement(By.xpath("//img[@title='Flipkart']"));
	Assert.assertEquals(true, strFlipkartLogo.isDisplayed()); 
	
	// Locating the login
	WebElement strLogin = driver.findElement(By.xpath("//div//a[@title='Login' and @aria-haspopup='true']"));

	//Instantiating Actions class
	Actions actions = new Actions(driver);

	//Hovering on main menu
	actions.moveToElement(strLogin).perform();
	
	// Get the size of login values
	List <WebElement> lstLoginValues = driver.findElements(By.xpath("//div/a[@title='Login']//following::ul/a[contains(@href,'home') or contains(@href,'plus')]//li"));
    
	// Loop until all the login values are displayed
	for (int i=0; i<lstLoginValues.size();)
	{ 
	   // Verify all the login values are displayed	
	   Assert.assertEquals(true, lstLoginValues.get(i).isDisplayed());
	   
	   // Get the name of the header
	   strLoginValue = lstLoginValues.get(i).getText();
	   i++;
	   
	   System.out.println("Login value is:"+strLoginValue);
	}
	
	
	
	// Click on login button
	driver.findElement(By.xpath("//div//a[@title='Login' and @aria-haspopup='true']")).click();
	
	// Wait until Headers are displayed
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[@class='TSD49J']")));
	
	// Get the size of Header
	List <WebElement> lstHeardes = driver.findElements(By.xpath("//div//span[@class='TSD49J']"));
	
	// Loop until all the headers are displayed
	for (int i=0; i<lstHeardes.size();)
	{
	   // Verify all the Headers are displayed	
	   Assert.assertEquals(true, lstHeardes.get(i).isDisplayed());
	   
	   // Get Header Name
	   strHeaderName = lstHeardes.get(i).getText();
	   
	   i++;
	   
	   System.out.println("Header name is:"+strHeaderName);
	}
	
	// Get the size of header
	List <WebElement> lstHeader = driver.findElements(By.xpath("//div//following::a[@class='TSD49J']"));
    
	// Loop until all the headers are displayed
	for (int i=0; i<lstHeader.size();)
	{
	   Assert.assertEquals(true, lstHeader.get(i).isDisplayed());
	   
	   strHeader = lstHeader.get(i).getText();
	   
	   i++;
	   
	   System.out.println("Header is:"+strHeader);
	}
	
	// Verify Login logo is displayed
	WebElement strLoginLogo = driver.findElement(By.xpath("//div//span[text()='Login']"));
	Assert.assertEquals(true, strLoginLogo.isDisplayed()); 
	
	// Verify Search box is displayed
	WebElement strSearchBox = driver.findElement(By.xpath("//div//form[not(contains(@action,'/search'))]//input"));
	Assert.assertEquals(true, strSearchBox.isDisplayed()); 
	
	// Close the browser
	driver.close();
	
	}
	
}
