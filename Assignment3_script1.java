package WebdriverTest;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Assignment3_script1 {
	
	WebDriver driver;
	
	@BeforeClass
		public void LaunchBrowser() 
	{
		driver = new FirefoxDriver();
		
	}

	@BeforeMethod
	public void PassApplicationURL() 
	{
		
		driver.get("http://www.seleniumframework.com/Practiceform/");
		
	}

	@Test
    public void verifyThisisaLinkExists()
	{
		Boolean iselementpresent = driver.findElements(By.linkText("This is a link")).size() > 0;
	    Assert.assertTrue(iselementpresent==true,"link is not present on the page");
				
	}
	
	
		
	@AfterClass
	public void CloseBrowser() {
		driver.close();
		driver.quit();
	}

}