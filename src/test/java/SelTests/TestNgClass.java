package SelTests;

import org.testng.annotations.Test;

import Pages.ComposePage;
import Pages.LoginPage;
import Setup.DriverSetup;

public class TestNgClass extends DriverSetup {
	
	LoginPage loginObj = new LoginPage();
	ComposePage composeObj = new ComposePage();
		
  @Test
  public void testCase() throws InterruptedException {
	  
	  loginObj.Login();
	  composeObj.Compose();
	  
	  
  }
}
