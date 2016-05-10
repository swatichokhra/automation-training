package WebdriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment3_script2 {
	
	WebDriver driver;
	
	@BeforeClass
		public void launchBrowser() 
	{
		driver = new FirefoxDriver();
	}

	@BeforeMethod
	public void PassApplicationURL() {

		driver.get("http://www.seleniumframework.com/Practiceform/");
	}

	@Test
    public void verifyThereisanElementwithTagnameFieldset()
	{
		Boolean iselementpresent = driver.findElements(By.tagName("fieldset")).size()>0;
		Assert.assertTrue(iselementpresent==true,"tagname fieldset is not present on the page");
		}
	
	
		
	@AfterClass
	public void CloseBrowser() {
		driver.close();
		driver.quit();
	}

}