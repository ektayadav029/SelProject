package SelTests;

import org.junit.runner.RunWith;

import Setup.DriverSetup;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="/Users/EktaYadav/Documents/workspace/SeleniumProject/Feat/test.feature",
		glue="Pages",
		format= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
		monochrome = true, //display the console output in a proper readable format
		strict = true, //it will check if any step is not defined in step definition file
		dryRun = true 
		
		)


public class Runner extends DriverSetup {

}
