package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	public ReadConfig() throws IOException {
		properties = new Properties();
		FileInputStream fis = new FileInputStream("config.properties");
		properties.load(fis);
	}
	
	public String getBrowserDetails() throws Exception {
		String browser = properties.getProperty("browser");
		if(browser.isBlank() || browser.isEmpty())
			throw new Exception("Bowser key is empty in config properties");
		else
			return browser;
	}
	
	public String getAppURL(String app) throws Exception {
		String url = properties.getProperty(app);
		if(url.isBlank() || url.isEmpty())
			throw new Exception("URL key is empty in config properties");
		else
			return url;
	}

}
