package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	Logger log;
	public WebDriver driver;
	@BeforeMethod
	public void setup() throws IOException {
		log=LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("Url"));
		log.debug("Navigated to the application URL");
	}
	@Test(dataProvider = "getLogindata" )
	public void login(String email,String password,String expected) throws IOException {
		
		
		LandingPage landing= new LandingPage(driver);
		landing.getMyAccountDropDown().click();
		log.debug("Clicked on MyAccountDropDown element");
		landing.getLoginOption().click();
		log.debug("Clicked on Login option");
		LoginPage login= new LoginPage(driver);
		login.getEmail().sendKeys(email);
		log.debug("Entered email address");
		login.getPassword().sendKeys(password);
		log.debug("Entered Password");
		login.getLoginBtn().click();
		log.debug("Clicked on Login Button");
		AccountPage account= new AccountPage(driver);
		
		String actual=null;
		try {
		if(account.getEditaccInfo().isDisplayed()) {
			log.debug("User got logged in");
			actual="success";
		}
		}
		catch (Exception e) {
			log.debug("User didn't login ");
			actual="fail";
		}
		Assert.assertEquals(actual, expected);
		log.info("Login Test is passed");
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		log.debug("Browser got closed");
	}
	@DataProvider
	public Object[][] getLogindata() {
		
		Object[][] data= {{"phaniatw2@gmail.com","atw@123","success"},
				              {"sample@Test.com","sample123","fail"}};
		return data;
	}
}
