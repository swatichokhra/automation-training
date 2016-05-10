package WebdriverTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment1_script4_3 
{
	@Test
	public void verifyStringIsPallindrome()
	{
		String s = "daad";
		int i=0;
		int n = s.length()-1;
		
		
			while(s.charAt(i)==s.charAt(n) && i <= n)
			{
				i++;
				n=n-1;			
			}
			
		Assert.assertTrue(i>n, "string is not pallindrome");
	    System.out.println("string is pallindrome");
			
	}
}

