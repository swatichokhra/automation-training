package WebdriverTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment4_script2_2 {
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
		 
		 
			//int counter = 0;
			//WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds );
	       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.product_list.grid.row")));
			
			List<WebElement> listItems=driver.findElements(By.xpath("//div[@class='product-container']"));
	        System.out.println("No. of Items: "+listItems.size());
	       
	        // for(WebElement image:listItems)
	       // {
	       // if(image.isDisplayed())
	       // {
	       // counter++;
		//}
	        //}
	        //System.out.println("No. of items displayed on summer dresses menu : " +counter);
		
        }
	
        @AfterMethod
	void closeBrowser()
		{
		driver.close();
		driver.quit();
	}

}