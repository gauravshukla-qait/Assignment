package com.qait.automation.Test2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestClass {

	WebDriver driver;
	HomePageAction homeAction;
	
	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://10.0.31.161:9292/");
	}
	
	@Test
	public void verifyBasicAuthPromptDisplayed() {
		homeAction = new HomePageAction(driver);
		homeAction.clickOnBasicAuthLink();
		homeAction.testBasicPromptDisplayed();
	}
	
	@Test(dependsOnMethods= {"verifyBasicAuthPromptDisplayed"})
	public void verifySuccessfulAuthentication() {
		homeAction.testSuccessfulAuthentication();
	}
}
