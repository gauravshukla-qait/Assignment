package com.qait.automation.Test2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageAction {

	WebDriver driver;
	WebElement link;
	WebElement userName;
	WebElement password;
	Alert promptAlert;
	
	public HomePageAction(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void clickOnBasicAuthLink(){
		driver.findElement(By.linkText("Basic Auth")).click();
	}
	
	public void testBasicPromptDisplayed() {
		boolean flag = false;
		try {
			promptAlert = driver.switchTo().alert();
			flag = true;
		}catch (Exception e) {
			flag = false;
		}
		assertTrue(flag);
	}
	
	public void sendKeysInAlertBox() {
		JavascriptExecutor executer = (JavascriptExecutor) driver;
		executer.executeScript("arguments[0].sendKeys'admin'");
		executer.executeScript("arguments[1].sendKeys'admin'");
		promptAlert.accept();
	}
	
	public void testSuccessfulAuthentication() {
		String s = driver.findElement(By.cssSelector("div.example p")).getText();
		assertEquals(s, "Congratulations! You must have the proper credentials.");
	}
	
	
	
	
	
	
	
	
	
	
	
}
