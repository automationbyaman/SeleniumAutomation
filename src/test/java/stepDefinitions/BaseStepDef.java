package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BaseStepDef {

	Base base;
	
	@Given("User launches the browser and opens the {string} url")
    public void user_launches_the_browser_and_opens_the_url(String app) throws Exception {
        Base.setUp();
        Base.openApp(app);
    }
	
	@When("User verifies the title {string} of the {string} page")
	public void user_verifies_the_title_of_the_page(String expTitle, String page) throws Exception {
		Base.verifyPageTitle(expTitle,page);
	}
	
	
}
