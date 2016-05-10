package WebdriverTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment1_script4_1 
{

	@Test
	public void verifyTwoNUmbersAreSame()
	{
		int n1=1;
		int n2=1;		
		Assert.assertEquals(n1,n2, "numbers are not equal");
		System.out.println("Numbers are equal");
	}

}
