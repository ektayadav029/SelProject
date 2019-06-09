package Setup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverSetup {
	public static  WebDriver driver;
	public static Properties properties = new Properties();
	
	@BeforeSuite
	public void Setup()
	{
		try {
			properties.load(new FileReader(
					new File("//resources/test.properties")));
			
			//Users/EktaYadav/Documents/workspace/SeleniumProject/resources/test.properties
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@AfterSuite
	public void Shutdown()
	{
		driver.quit();
	}
	
}
