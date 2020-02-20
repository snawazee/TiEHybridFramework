package com.tie.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	public WebDriver init_driver(Properties prop) {
		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			//driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			tldriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			tldriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			//driver = new SafariDriver();
			tldriver.set(new SafariDriver());
			
		} else if (browser.equals("ie")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			//driver = new SafariDriver();
			tldriver.set(new SafariDriver());

		} else {
			System.out.println("Please pass the correct browser name....");
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();
	}

	
	public Properties init_properties() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\Safdar\\git\\TiEHybridFramework\\src\\main\\java\\com\\tie\\Config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
	
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}

}
