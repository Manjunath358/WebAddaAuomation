package com.adda.home;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.adda.utility.Log;

public class DirectMessage {
	final WebDriver driver;
	String message = "Test message through automation by bibhu";
	static String actualMessage;
	
	@FindBy(xpath = "//li[@id='directory-tab']//a[@href='#']//span[@class='menu-item']//span[@class='ng-binding'][contains(text(),'Directory')]")
	WebElement directoryTab;

	@FindBy(xpath = "//input[@placeholder='Search Resident']")
	WebElement searchResidentTextBox;

	@FindBy(xpath = "//div[@class='card-header-title pull-left ng-binding']")
	WebElement searchResidentResult;

	@FindBy(xpath = "//button[@class='profile-modal-buttons ml-20']")
	WebElement sendDirectMessageButton;

	@FindBy(xpath = "//textarea[@placeholder='Type a message...']")
	WebElement messageTextArea;

	@FindBy(xpath = "//i[@class='send-button fa fa-paper-plane']")
	WebElement sendButton;

	@FindBy(xpath = "//i[@class='fa fa-commenting dm-icon']")
	WebElement messageInboxButton;

	@FindBy(xpath = "//div[@class='card-header spaced clearfix']")
	WebElement checkMessage;

	@FindBy(xpath = "//div[@id='mCSB_5_container']/div/p/span[2]")
	WebElement messageContent;

	public DirectMessage(WebDriver driver) {
		this.driver = driver;
	}

	public void createDirectMessage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Log.startTestCase("createDirectMessage");
		directoryTab.click();
		searchResidentTextBox.sendKeys("adda6");
		searchResidentResult.click();
		Thread.sleep(2000);
		sendDirectMessageButton.click();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		messageTextArea.sendKeys(message+" "+timestamp);
		Thread.sleep(2000);
		actualMessage=messageTextArea.getAttribute("value");
		sendButton.click();
		Log.info("Message succesfully sent to the User!!");
		Log.endTestCase("createDirectMessage");
		Thread.sleep(4000);

	}

	public void validateDirectMessage() throws InterruptedException {
		Log.startTestCase("validateDirectMessage");
		Thread.sleep(2000);
		messageInboxButton.click();
		Thread.sleep(5000);
		checkMessage.click();
		Thread.sleep(4000);
		List<WebElement> message = driver
				.findElements(By.xpath("//div[@class='main-container main-content']/div[1]/div[1]/div/div/p/span[2]"));
		int messageCounts = message.size();
		System.out.println("Number of messages available are-: " + message.size());
		Log.info("Number of messages available are-: " + message.size());
		for (int i = 0; i < message.size(); i++) {
			if (i == messageCounts - 1) {
				String expectedMessage = message.get(i).getText();
				System.out.println(expectedMessage);
				Assert.assertEquals(actualMessage, expectedMessage, "Message successfully delivered to User");
				Log.info("Message successfully delivered to User!!");
				System.out.println("Message successfully delivered to the User");
			} else {
				continue;
			}
		}
		Log.endTestCase("validateDirectMessage");
	}

}
