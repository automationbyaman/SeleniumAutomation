package base;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ReadConfig;

public class Base {
	
	 public static Base base;
	 private static WebDriver driver;
	 public static ReadConfig readConfig;
	 public static Logger log;
	 
	 public Base() {
		 log = LogManager.getLogger("Base");
		 log.info("ReadConfig instantiated");
		 try {
			readConfig = new ReadConfig();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	 public static void openApp(String appURL) throws IOException, Exception {
         driver.get(new ReadConfig().getAppURL(appURL));
         log.info("Opening the url for "+appURL);
     }
	 
	 public static void setUp() throws Exception {
		 if(base==null) {
			 base = new Base();
			 log.info("Setup executed");
			 switch (readConfig.getBrowserDetails().toLowerCase()) {
				case "chrome" : driver = new ChromeDriver();
								driver.manage().window().maximize();
								driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
								break;
				case "msedge" : driver = new EdgeDriver();
								driver.manage().window().maximize();
								driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
								break;
				}
		 }
	 }
	 
	 public static void tearDown() throws IOException {
		 
		 if(driver!=null) {
			 log.info("Quiting the browser");
			 driver.quit();
		 }
		 base = null;
	 }
	 
	 public static WebDriver getDriver() {
		 log.info("getDriver is called");
         return driver;              
     }
	 
//	 public static void setCurrentPageObject(String pageName) throws Exception {
//			switch (pageName) {
//			case "Amazon Home": base = new AmazonHomePage();
//								break;
//			default:	
//			}
//		}
	 
//	 public static By returnLocator(String elementName) throws Exception {
//			switch (elementName) {
//			default:
//				throw new Exception(elementName+" xpath is not defined");
//			}
//		}
	 
	 public static void verifyPageTitle(String expectedTitle, String page) throws Exception {
			String actualTitle = driver.getTitle();
			log.info("Actual Title - "+actualTitle);
			log.info("Expected Title - "+expectedTitle);
			Assert.assertEquals(actualTitle,expectedTitle);
		}
	 
	 
	 
	 
	 
	 
		
	 
//	 public static void enterIntoTextField(String value,String element, String page) throws Exception {
////		 setCurrentPageObject(page);
////		 driver.findElement(base)
//	 }
	 
}
