package WebdriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment3_script4 {
	
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() 
	{
		driver = new FirefoxDriver();
	}

	@BeforeMethod
	public void passApplicationURL() 
	{

		driver.get("http://www.seleniumframework.com/Practiceform/");
	}

	@Test
    public void verifyifabletoInputvalueinText()
	{
		WebElement inputArea = driver.findElement(By.id("vfb-9"));
				inputArea.clear();
		inputArea.sendKeys("aaa");
	}
	
		
	@AfterClass
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}