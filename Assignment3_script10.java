package WebdriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment3_script10 {

	WebDriver driver;
	
	@BeforeClass
	void LaunchBrowser()
	{
		driver = new FirefoxDriver();
		
	}
	
	@BeforeMethod
	void LaunchApplication()
	{
		driver.get("http://www.seleniumframework.com/Practiceform/");
		driver.manage().window().maximize();
			}
	@Test
	void  verifyTitleofpageafterclick()
	{
		long timeoutInSeconds = 50;
		WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Element8")));
        WebElement verlinkfield = driver.findElement(By.linkText("Element8"));
		verlinkfield.click();
		String text = driver.getTitle();
		Assert.assertTrue(text.contains("Selenium Framework"),"rendered page not correct");
	}
			
	@AfterMethod
	void closeBrowser()
		{
		driver.close();
		driver.quit();
	}
	
}

