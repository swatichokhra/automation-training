package WebdriverTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment1_script4_4 {
	@Test
	public void verifyFactorialIsEven()
	{
		int n=5;
		int fact=1;
		for(int i=1;i<=n;i++)
		{
			fact=fact*i;
		}
		
		Assert.assertTrue(fact%2==0, "factorial is not even");
		System.out.println("factorial is even");
	}
}
