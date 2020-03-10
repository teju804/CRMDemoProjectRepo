package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
public 	static WebDriver driver;
	public static Properties prop;
	public static Loginpage loginpage;
	public static Homepage homepage;
	public static EventFiringWebDriver eventFiredriver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		try {
			prop =  new Properties();
			FileInputStream fis = new FileInputStream("F:\\Ecilpse_Workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fis);
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
	public static void initialization() {
		String broswerName=prop.getProperty("browser");
		if(broswerName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	        driver = new ChromeDriver();
		}
		else if(broswerName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\chromedriver_win32\\geckodriver.exe");
	        driver = new FirefoxDriver();
		}	
		eventFiredriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventFiredriver.register(eventListener);
		driver = eventFiredriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
}
}

	

	
