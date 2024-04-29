package BaseLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import UtilsLayer.CaptureRequest;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;
	 public static Properties p;

	public BaseClass()
	{
	p=new Properties();
		try
		{
		FileInputStream f=new FileInputStream("/Users/aniket_mac/Documents/Aniket's_Personal/Interview/Coforge/Coforge_project/DemoProject/src/main/java/ConfigueLayer/Config.Properties");
	p.load(f);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	

	public static void initialization() throws IOException
	{
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		options.addArguments("start-maximized");
//		options.addArguments("disable-popup-blocking");
		driver = new ChromeDriver();
		CaptureRequest captureRequest = new CaptureRequest();
		captureRequest.captureHttpRequest(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(p.getProperty("url"));

	}


	public static void closeBrowser() throws IOException
	{
		driver.quit();
	}

}
