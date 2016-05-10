package WebdriverTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment4_script2_5 {
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
		 WebElement sliderelement = driver.findElement(By.cssSelector("div.ui-slider-range.ui-widget-header.ui-corner-all"));
		 Actions move = new Actions(driver);
	        Action action1 = move.dragAndDropBy(sliderelement, 10, 0).build();
	        	        action1.perform();
	        	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	

@AfterMethod
void closeBrowser()
	{
	driver.close();
	driver.quit();
}
	}