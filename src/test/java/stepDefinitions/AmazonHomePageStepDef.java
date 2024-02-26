package stepDefinitions;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AmazonHomePage;

public class AmazonHomePageStepDef{
	
	AmazonHomePage ahp = new AmazonHomePage();
	
	
	
	
	
	
	@Then("User verifies {string} is {string} for {string} on Amazon Home page")
	public void user_verifies_is_for_on_Amazon_Home_page(String value, String status, String element) throws Exception {
		ahp.dropdownSelectedOrNotSelected(value,status,element);
	}
	
	@And("User verifies {string} values are displayed in {string} on Amazon Home page")
	public void check(String size, String element) throws Exception {
		ahp.verifyDropdownSize(element, size);
	}
	
	@Then("User enters {string} in the {string} textfield on Amazon Home page")
	public void user_enters_in_the_textfield_on_page(String value, String element) throws Exception {
		ahp.enterIntoTextField(value, element);
	}

	@Then("User verifies {string} is {string} on Amazon Home page")
	public void user_verifies_is_on_Amazon_Home_page(String element, String status) throws Exception {
		ahp.displayedOrNotDisplayed(element, status);
	}
	
	@And("User clicks on {string} button on Amazon Home page")
	public void user_clicks_on_button_on_Amazon_Home_page(String element) throws Exception {
		ahp.clickOnSearchBtn(element);
	}
}
