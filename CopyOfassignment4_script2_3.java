package WebdriverTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CopyOfassignment4_script2_3 {
	WebDriver driver;

	@BeforeClass
	void LaunchBrowser() {
		driver = new FirefoxDriver();

	}

	@BeforeMethod
	void LaunchApplication() {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@Test
	void countNoOfItemsonmenusummerdresses() {
		long timeoutInSeconds = 10;
		int countWhite = 0;

		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.linkText("DRESSES")));
		WebElement menuitem = driver.findElement(By.linkText("DRESSES"));
		Actions action = new Actions(driver);
		action.moveToElement(menuitem).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.linkText("SUMMER DRESSES")));
		driver.findElement(By.linkText("SUMMER DRESSES")).click();
		WebElement checkbox = driver
				.findElement(By
						.cssSelector("input#layered_id_attribute_group_8.color-option"));
		checkbox.click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.cat-name"),"SUMMER DRESSES > COLOR WHITE"));
		 		List<WebElement> listItems = driver.findElements(By
				.xpath("//ul[@class='product_list grid row']/li"));
		int n = listItems.size();
		System.out.println("No of items on page: " + n);

		/*
		 * List<WebElement> listItems = driver.findElements(By
		 * .xpath("//ul[@class='product_list row list']/li"));
		 */
		int noOfFilteredItems = listItems.size();

		ExpectedCondition<List<WebElement>> condition1 = ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By
						.cssSelector(".product_list .color-list-container ul li a"));
		List<WebElement> checkboxItems = wait.until(condition1);

		for (WebElement image : checkboxItems) {
			if (image.isDisplayed()) {
				String str = image.getAttribute("style");
				if (str.contains("#ffffff") == true) {
					countWhite++;
				}
			}
		}
		if (countWhite == noOfFilteredItems) {
			System.out.println("Total White Elements: " + countWhite
					+ "Filters not applied correctly");
		} else {
			System.out.println("Filtered not applied correctly");
		}

	}

	@AfterMethod
	void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
