package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class Login extends Base{
	WebDriver driver;
	LoginPage login;
	  @Given("^open any browser$")
	    public void open_any_browser() throws Throwable {
	        
		  driver=initializeDriver();
	    }

	  @And("^Navigate to login page$")
	    public void navigate_to_login_page() throws Throwable {
	      driver.get(prop.getProperty("Url"));
	      LandingPage landing = new LandingPage(driver);
	      landing.getMyAccountDropDown().click();
	      landing.getLoginOption().click();
	    }
	    @When("^user enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	    public void user_enters_username_as_something_and_password_as_something(String strArg1, String strArg2) throws Throwable {
	        login= new LoginPage(driver);
	        login.getEmail().sendKeys(strArg1);
	        login.getPassword().sendKeys(strArg2);
	    }
	    
	    @And("^user clicks on login button$")
	    public void user_clicks_on_login_button() throws Throwable {
	       login.getLoginBtn().click();
	    }

	    @Then("^verify user is able to successfully login$")
	    public void verify_user_is_able_to_successfully_login() throws Throwable {
	       AccountPage accountPage= new AccountPage(driver);
	       Assert.assertTrue(accountPage.getEditaccInfo().isDisplayed());
	    }
	    @After
	    public void closure() {
	    	driver.close();
	    }
	   

	  


}
