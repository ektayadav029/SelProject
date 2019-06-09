package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Setup.DriverSetup;

public class ComposePage extends DriverSetup{

	
	public void Compose() throws InterruptedException
	{
		WebElement composeElement = driver.findElement(By.xpath("//*[text()='Compose']"));
		composeElement.click();

		Thread.sleep(4000);

		// Entering "to" email ID
		driver.findElement(By.name("to")).sendKeys("testuser1475@gmail.com");
		Thread.sleep(2000);

		String emailSubject = properties.getProperty("email.subject");
		String emailBody = properties.getProperty("email.body");
		
		// Entering email subject
		driver.findElement(By.name("subjectbox")).sendKeys(emailSubject);
		Thread.sleep(4000);

		WebElement emailBodyElement =driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]"));
		emailBodyElement.sendKeys(emailBody);

		// Thread.sleep(4000);

		// Tapping on 'More options'
		WebElement moreOptElement =driver.findElement(By.xpath("//*[@aria-label='More options']/div[2]"));
		moreOptElement.click();
		Thread.sleep(4000);
		
		// Tapping on Label
		WebElement labelElement =driver.findElement(By.xpath("//*[text()='Label']"));
		labelElement.click();
		Thread.sleep(4000);

		// Tapping on social
		WebElement socialElement =driver.findElement(By.xpath("//div[@role='menu']//div[contains(@style,'user-select')]/div[text()='Social']"));
		
		socialElement.click();

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement e = driver.findElement(By.cssSelector("td[class='gU Up'] div div[role='button']"));
		js.executeScript("arguments[0].click();", e);

		Thread.sleep(6000);
		// Switching to Social Mails tab
		
		WebElement socialTab=driver.findElement(By.xpath("//div[contains(@data-tooltip,'Messages from social')]"));
		socialTab.click();
		Thread.sleep(3000);

		// verifying subject and marking email as starred
		String starredXpath = "(//td/div[@role='link']//span[text()='" + emailSubject
				+ "']/ancestor::td/preceding-sibling::td/span[@role='button'])";
		
		WebElement starredXpathElement =driver.findElement(By.xpath(starredXpath));
		starredXpathElement.click();

		
		String subXpath = "//td/div[@role='link']//span[text()='" + emailSubject + "']";

		Thread.sleep(3000);

		WebElement subXpathElement =driver.findElement(By.xpath(subXpath));
				
		if (subXpathElement.isDisplayed()) {
			System.out.println("Email received with subject " + emailSubject);
			subXpathElement.click();

			String bodyXpath = "//div[@dir='ltr'][text()='" + emailBody + "']";
			System.out.println("bodyXpath");

			WebElement bodyContentElement = driver.findElement(By.xpath(bodyXpath));
			boolean flag = bodyContentElement.isDisplayed();

			if (flag) {
				System.out.println("Email body verified");
			} else {
				System.out.println("Email body is not as expected");
				Assert.assertTrue(false);
			}

		} else {
			System.out.println("Expected mail not received");
			int i=10;
			System.out.println(i);
		}

	
	}
}
