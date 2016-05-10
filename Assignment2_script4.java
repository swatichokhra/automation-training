package WebdriverTest;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment2_script4 {
	
WebDriver driver;
	
	@BeforeClass
	
	public void LaunchBrowser()
	{
	driver= new FirefoxDriver();
	}
	
	@BeforeMethod
	
	public void passApplicationURL()
	{
		driver.navigate().to("http://www.metacube.com");
	}
	
	@Test 
	public void verifySecondStringofApplicationTitleisSoftware()
	{
		String title =  driver.getTitle();
		String[] titleArray = title.split(" ");
		List<String> wordList = Arrays.asList(titleArray);  
		String s = wordList.get(1);
      Assert.assertEquals(s,"Software");
	 	
	}
	
	@AfterClass 
	
	public void CloseBrowser()
	{
		driver.close();
		driver.quit();
	}

}
