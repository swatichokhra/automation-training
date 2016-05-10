package WebdriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment3_script5 {
	
	WebDriver driver;
	@BeforeClass
	
	public void launchBrowser() 
	{
		driver = new FirefoxDriver();
	}

	@BeforeMethod
	public void passApplicationURL() {

		driver.get("http://www.seleniumframework.com/Practiceform/");
		driver.manage().window().maximize();
	}

	@Test
    public void verifyIfCheckboxesSelectable()
	{
		WebElement Checkbox1 = driver.findElement(By.id("vfb-6-0"));
				Checkbox1.click();
				WebElement Checkbox3 = driver.findElement(By.id("vfb-6-2"));
				Checkbox3.click();
	}
	
		
	@AfterClass
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
