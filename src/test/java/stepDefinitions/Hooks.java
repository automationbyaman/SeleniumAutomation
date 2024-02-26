package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
    public static void init() throws Exception {
 
       Base.setUp();
    }
 
    @After
    public static void tearDown(Scenario scenario) throws IOException {
 
        //validate if scenario has failed
        if(scenario.isFailed()) {
        	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyHHmmss");  
			 LocalDateTime now = LocalDateTime.now();  
//			 File destFile = new File(".//Screenshots/"+now+".png");
			 String scenarioName = scenario.getName().replace(" ","_")+dtf.format(now);
//			 File srcFile = ((TakesScreenshot)Base.getDriver()).getScreenshotAs(OutputType.FILE);
//			 FileUtils.copyFile(srcFile, destFile);
            final byte[] screenshot = ((TakesScreenshot) Base.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenarioName); 
        }   
         
        Base.tearDown();
    }
    
    @AfterStep
    public void addScreenshot(Scenario sc) {
    	if(sc.isFailed()) {
    		final byte[] screenshot = ((TakesScreenshot)Base.getDriver()).getScreenshotAs(OutputType.BYTES);
    		sc.attach(screenshot, "image/png", sc.getName());
    	}
    }
}
