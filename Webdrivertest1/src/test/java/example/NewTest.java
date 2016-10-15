package example;		

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class NewTest {		
	    private WebDriver driver;		
		@Test				
		public void testEasy() {	
			driver.get("http://192.168.1.200:8083/hanzolabs_hcm/showLogin.action");  
			String getTitle = driver.getTitle();
			Assert.assertEquals(getTitle, "HCMOne");
			WebElement id = driver.findElement(By.name("username"));
	        WebElement pass = driver.findElement(By.name("password"));
	        WebElement captcha=driver.findElement(By.name("captchacode"));
	        WebElement button = driver.findElement(By.id("form_login_button_label_login"));
	        id.sendKeys("admin");
	        pass.sendKeys("admin");
	        //captcha.sendKeys()
	        button.submit();
		}	
		@BeforeTest
		public void beforeTest() {	
			File pathBinary = new File("/usr/bin/firefox");
			FirefoxBinary Binary = new FirefoxBinary(pathBinary);
			FirefoxProfile firefoxPro = new FirefoxProfile();  
			//System.setProperty("webdriver.firefox.bin","/usr/bin/firefox");
			driver = new FirefoxDriver(Binary,firefoxPro);
		    
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}	