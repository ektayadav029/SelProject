package SelTests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import java.util.concurrent.TimeUnit;




import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GMailCompleteTest {
	private WebDriver driver;
	private Properties properties = new Properties();

	@BeforeClass
	public void setUp() throws Exception {
		properties.load(new FileReader(
				new File("/Users/EktaYadav/Downloads/qa-automation-selenium-java/src/test/resources/test.properties")));
	
		System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testSendEmail() throws Exception {
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

		Thread.sleep(4000);

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
