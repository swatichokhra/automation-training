package WebdriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment3_script8

{

	WebDriver driver;
	
	@BeforeClass
	void launchBrowser()
	{
		driver = new FirefoxDriver();
		
	}
	
	@BeforeMethod
	void launchApplication()
	{
		driver.get("http://www.seleniumframework.com/Practiceform/");
		driver.manage().window().maximize();
			}
	@Test
	void  verifyDropdownOptioncanbeSelected()
	{
		Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
		dropdown.selectByIndex(1);
		
	}
	
	@AfterMethod
	void closeBrowser()
		{
		driver.close();
		driver.quit();
	}
	
}

