package WebdriverTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment3_script9 
{

	static WebDriver driver;
	
	@BeforeClass
	void LaunchBrowser()
	{
		driver = new FirefoxDriver();
		driver.get("http://www.seleniumframework.com/Practiceform/");
		driver.manage().window().maximize();
	}
	
	@Test
	void  verifyErrorMessageinRedwhenTextentered()
	{
		WebElement vertextfield = driver.findElement(By.id("vfb-3"));
		vertextfield.sendKeys("aaa");
		vertextfield.sendKeys(Keys.TAB);
			WebElement errortext = driver.findElement(By.cssSelector("label.vfb-error"));
		String text = errortext.getText();
		Assert.assertEquals(text,"Please enter only digits.","not equal");
					
				}
	@Test	
	void  verifyErrorMessagewhennothingentered()
	{
		WebElement vertextfield = driver.findElement(By.id("vfb-3"));
		vertextfield.clear();
					WebElement btn = driver.findElement(By.cssSelector("input#vfb-4.vfb-submit"));
		btn.click();
		WebElement errortext = driver.findElement(By.cssSelector("label.vfb-error"));
		String text = errortext.getText();
		Assert.assertEquals(text,"This field is required.","not equal");
					
				}
	
	@Test	
	void  verifyMessageonSuccessfulSubmission()
	{
		WebElement vertextfield = driver.findElement(By.id("vfb-3"));
		vertextfield.clear();
		vertextfield.sendKeys("12");
					WebElement btn = driver.findElement(By.cssSelector("input#vfb-4.vfb-submit"));
		btn.click();
		WebElement successmsg = driver.findElement(By.id("form_success"));
		String text = successmsg.getText();
		Assert.assertEquals(text,"Your form was successfully submitted. Thank you for contacting us.","not equal");			
	}
	
	@AfterClass
	void closeBrowser()
		{
		driver.close();
		driver.quit();
	}
	
}

 	