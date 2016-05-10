package WebdriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment4_script3 {
WebDriver driver;
	
	@BeforeClass
	void LaunchBrowser()
	{
		driver = new FirefoxDriver();
		
	}
	
	@BeforeMethod
	void LaunchApplication()
	{
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
			}
	@Test
	
	void countNoOfItemsonmenusummerdresses()
	{   
		long timeoutInSeconds =10;
		
		WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds );
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("DRESSES")));
		WebElement menuitem = driver.findElement(By.linkText("DRESSES"));
		Actions action = new Actions(driver);
		action.moveToElement(menuitem).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SUMMER DRESSES")));
		 driver.findElement(By.linkText("SUMMER DRESSES")).click();
		 wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.cat-name"),"SUMMER DRESSES"));
		 WebElement we = driver.findElement(By.linkText("List"));
		 we.click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-image-container'][1]")));
		 WebElement link = driver.findElement(By.xpath("//div[@class='product-image-container'][1]"));
			Actions action1 = new Actions(driver);
			action1.moveToElement(link).build().perform();
		 WebElement firstelement = driver.findElement(By.xpath("//div[@class='product-image-container'][1]//span[text()='Quick view']"));
		 
		 firstelement.click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe"))); 
		 driver.switchTo().frame(0);
		 	    WebElement wishelement = driver.findElement(By.cssSelector("a#wishlist_button"));
		wishelement.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.fancybox-error")));
		WebElement errtext = driver.findElement(By.cssSelector("p.fancybox-error"));
		String str = errtext.getText();
		Assert.assertEquals(str,"You must be logged in to manage your wishlist.","error message is not correct");
		
	}
	
	      
	
        @AfterMethod
	void closeBrowser()
		{
		driver.close();
		driver.quit();
	}

}