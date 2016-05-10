package WebdriverTest;

import java.util.concurrent.TimeUnit;
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

public class Assignment3_script11 
{

	WebDriver driver;
	
	@BeforeClass
	void LaunchBrowser()
	{
		driver = new FirefoxDriver();
		
	}
	
	@BeforeMethod
	void LaunchApplication()
	{
		driver.get("http://www.google.co.in/");
		driver.manage().window().maximize();
			}
	@Test
	void  verifyFirstSearchResultisMetacubeSoftware()
	{
		WebElement searchfield = driver.findElement(By.cssSelector("input#lst-ib"));
		searchfield.sendKeys("Metacube Software");
		WebElement searchbutton = driver.findElement(By.cssSelector("span.sbico"));
        searchbutton.click();
        long timeoutInSeconds = 10;
		WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='srg']/div[1]//a")));
        WebElement searchresult = driver.findElement(By.xpath("//div[@class='srg']/div[1]//a"));
        Assert.assertEquals(searchresult.getText(),"Metacube Software","first link is not the expected one");
        searchresult.click();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
               String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"http://www.metacube.com/","corect website is not launched");
            
				}
		
    @AfterMethod
	void closeBrowser()
		{
		driver.close();
		driver.quit();
	}
	
}
