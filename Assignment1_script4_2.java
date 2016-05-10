package WebdriverTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment1_script4_2 
{
	@Test
	public void verifyOneNumberIsGreaterThanOther()
	{
		int firstno=21;
		int secondno=3;
		
		Assert.assertTrue(firstno>secondno, "first no. is not greater than other");
		System.out.println("first no. is greater than other");
	}
}

