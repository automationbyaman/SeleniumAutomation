package pageObject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import junit.framework.Assert;

public class AmazonHomePage extends Base{

	static WebDriver driver;
	
	public AmazonHomePage(){
		driver = Base.getDriver();
	}
	
	public static By returnLocator(String elementName) throws Exception {
		switch (elementName) {
		case "Search Bar" : return By.xpath("//input[@id='twotabsearchtextbox']");
		case "Search" : return By.xpath("//input[@type='submit' and @value='Go']");
//		case "Search Dropdown" : return By.xpath("//div[@id='nav-search-dropdown-card']/div/select[@id='searchDropdownBox']");
		case "Search Dropdown" : return By.xpath("//div[@class='nav-search-scope nav-sprite']");
		default:
			throw new Exception(elementName+" xpath is not defined");
		}
	}
	
	public void enterIntoTextField(String value, String element) throws Exception {
		driver.findElement(returnLocator(element)).clear();
		Thread.sleep(2000);
		driver.findElement(returnLocator(element)).sendKeys(value);
	}
	
	
	public void displayedOrNotDisplayed(String element, String status) throws Exception { 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(returnLocator(element)));
//		driver.findElement(returnLocator(element)).click();
		
		if(!driver.findElement(returnLocator(element)).isDisplayed()) {
			throw new Exception("Element "+element+" is not Displayed");	
		}
	}
	
	public void dropdownSelectedOrNotSelected(String value, String status, String element) throws Exception {
		String selectedValueXpath = returnLocator(element).toString().replace("By.xpath:", "")+"/select/option[1]";
		if(driver.findElement(By.xpath(selectedValueXpath)).getAttribute("selected")=="selected") {
			String actualValue = driver.findElement(By.xpath(selectedValueXpath)).getText();
			Assert.assertEquals(actualValue,value);
		}
	}
	
	public void verifyDropdownSize(String element, String size) throws Exception {
		String selectedValueXpath = returnLocator(element).toString().replace("By.xpath:", "")+"/select/option";
		int actualSize = driver.findElements(By.xpath(selectedValueXpath)).size();
		log.info("Actual size of dropdown - "+actualSize);
		log.info("Expected size of dropdown - "+size);
		if(actualSize!=Integer.parseInt(size))
			throw new Exception("Actual size is "+actualSize+" and not "+size);
	}
	
	public void clickOnSearchBtn(String element) throws Exception {	 
			driver.findElement(returnLocator(element)).click();
		}
}
