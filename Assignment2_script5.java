package WebdriverTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment2_script5 {

	WebDriver driver;

	@BeforeClass
	public void LaunchBrowser() {
		driver = new FirefoxDriver();
		
	}

	@Test
	public void verifyseconditeminTitleisSoftware() 
	{
		launchApplication();
		String title = getTitle();
		String[] splitTitle = splitTitle(title);
		verifySecondItemInTitleIsSoftware(splitTitle);
	}

	public void launchApplication()
	{
		driver.navigate().to("http://www.metacube.com");
	}
	
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String[] splitTitle(String title) {
		return title.split(" ");
	}

	public void verifySecondItemInTitleIsSoftware(String[] wordList) {
		String s = wordList[1];
		Assert.assertEquals(s, "Software");
	}

	@AfterClass
	public void CloseBrowser() {
		driver.close();
		driver.quit();
	}

}
