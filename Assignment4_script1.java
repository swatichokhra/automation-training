package WebdriverTest;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class Assignment4_script1 {
	WebDriver driver;
		
		@BeforeClass
		void launchBrowser()
		{
			driver = new FirefoxDriver();
			
		}
		
		@BeforeMethod
		void launchApplication()
		{
			driver.get("http://adam.goucher.ca/parkcalc/");
			driver.manage().window().maximize();
				}
		@Test
		void  calculateCostOfParking()
		{
			String month = "April";
			int entryday = 4;
			int exitday=5;
			
			Select dropdown = new Select(driver.findElement(By.id("Lot")));
			dropdown.selectByVisibleText("Valet Parking");;
			WebElement entryfield = driver.findElement(By.cssSelector("input#EntryTime"));
			entryfield.clear();
			entryfield.sendKeys("02:00");
			driver.findElement(By.cssSelector("input[name='EntryTimeAMPM'][value='PM']")).click();
			WebElement entrydatefield = driver.findElement(By.cssSelector("input#EntryDate"));
			entrydatefield.clear();
			String handle1 = driver.getWindowHandle();
			// driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/font/a/img")).click();
			driver.findElement(By.xpath("//a[contains(@href,'EntryDate')]")).click();
			
			    
		    for(String winHandle : driver.getWindowHandles()){
		        driver.switchTo().window(winHandle);
		    }
		   // WebElement searchresult = driver.findElement(By.xpath("//table/tbody/tr[5]/td/font/a"));
		   
		    Select cal1_monthdropdown = new Select(driver.findElement(By.name("MonthSelector")));
		    String cal1_selectedValue = cal1_monthdropdown.getFirstSelectedOption().getText();
		    if (!cal1_selectedValue.equals(month))
		      {
		    	cal1_monthdropdown.selectByVisibleText(month);
		      }
		    selectDate(entryday);
			//driver.close();
		    driver.switchTo().window(handle1);
		    WebElement Leavingfield = driver.findElement(By.cssSelector("input#ExitTime"));
			Leavingfield.clear();
			Leavingfield.sendKeys("02:00");
			driver.findElement(By.cssSelector("input[name='ExitTimeAMPM'][value='PM']")).click();
			WebElement exitdatefield = driver.findElement(By.cssSelector("input#ExitDate"));
			exitdatefield.clear();
			String handle2 = driver.getWindowHandle();
			driver.findElement(By.xpath("//a[contains(@href,'ExitDate')]")).click();
			    
		    for(String winHandle : driver.getWindowHandles()){
		        driver.switchTo().window(winHandle);
		    }
		    
		    Select cal2_monthdropdown = new Select(driver.findElement(By.name("MonthSelector")));
		    String cal2_selectedValue = cal2_monthdropdown.getFirstSelectedOption().getText();
		    if (!cal2_selectedValue.equals(month))
		      {
		    	cal2_monthdropdown.selectByVisibleText(month);
		      }
		    selectDate(exitday);
		    
		    //WebElement searchresult1 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]/font/a"));
		   	//driver.close();
		    driver.switchTo().window(handle2);
			WebElement button= driver.findElement(By.cssSelector("input[value='Calculate']"));
		    button.click();
		    WebElement cost = driver.findElement(By.xpath("//span[@class='SubHead']"));
			System.out.println("cost="+ cost.getText());
		}
		
		
		public void selectDate(int date)
		{
				 WebElement searchresult = driver.findElement(By.xpath("//a[text()='" +date+ "']"));
			     searchresult.click();
		}
		
		
		@AfterMethod
		void closeBrowser()
			{
			driver.close();
			driver.quit();
		}

	}
