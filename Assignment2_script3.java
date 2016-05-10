package WebdriverTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment2_script3 {

	WebDriver driver;
	
	@BeforeClass
	
	public void LaunchBrowser()
	{
	driver= new FirefoxDriver();
	}
	
	@Test
	
	public void passApplicationURLwithoutGetMethod()
	{
		driver.navigate().to("http://www.metacube.com");
		 driver.manage().window().maximize();
	}
	
	@AfterClass 
	
	public void CloseBrowser()
	{
		driver.close();
		driver.quit();
	}
	
}
	

	