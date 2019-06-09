package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Setup.DriverSetup;

public class LoginPage extends DriverSetup {


	public void Login() throws InterruptedException
	{
		driver.get("https://mail.google.com/");

		// Entered username
		WebElement userElement = driver.findElement(By.id("identifierId"));
		userElement.sendKeys(properties.getProperty("username"));

		driver.findElement(By.id("identifierNext")).click();

		System.out.println("username");
		
		Thread.sleep(1000);

		// Entered password
		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys(properties.getProperty("password"));
		driver.findElement(By.id("passwordNext")).click();
		System.out.println("password");

		Thread.sleep(1000);

	}
	
}
