package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base {
	public WebDriver driver;
	@Test
	public void testThree() throws IOException, InterruptedException {
		System.out.println("TestThree");
		System.out.println("Vishnu updated this code");
		System.out.println("Vishnu updated this code for 2nd time");
		driver = initializeDriver();
		driver.get("https://www.selenium.dev/");
		Thread.sleep(3000);
		Assert.assertTrue(false);
		driver.close();
	}
	
	
}
