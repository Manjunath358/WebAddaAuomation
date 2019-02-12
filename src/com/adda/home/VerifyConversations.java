package com.adda.home;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adda.utility.Log;

public class VerifyConversations {
	final WebDriver driver;

	@FindBy(xpath = "//li[@id='my_adda-tab']//a[@href='#']//span[@class='menu-item']//span[@class='ng-binding'][contains(text(),'My ADDA')]")
	WebElement myAddaTab;

	@FindBy(xpath = "//div[@class='input-placeholder']")
	WebElement startConvrstn;

	@FindBy(id = "topic-1")
	WebElement conversationTitleTextBox;

	@FindBy(xpath = "//div[@id='new-message']/div/div[2]/div[3]")
	WebElement messageTextBox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement createConvrstn;

	@FindBy(xpath = "//a[@title='Poll']")
	WebElement pollBtn;

	@FindBy(xpath = "//input[@id='topic-2']")
	WebElement pollTopicTextBox;

	@FindBy(xpath = "//textarea[@placeholder='Poll Description']")
	WebElement pollDescriptionTextBox;

	@FindBy(xpath = "//input[@id='newPollOptId_0']")
	WebElement pollOptionOne;

	@FindBy(xpath = "//input[@id='newPollOptId_1']")
	WebElement pollOptionTwo;

	@FindBy(xpath = "//input[@id='newPollOptId_2']")
	WebElement pollOptionThree;

	@FindBy(xpath = "//input[@id='newPollOptId_3']")
	WebElement pollOptionFour;

	@FindBy(xpath = "//input[@id='datepicker']")
	WebElement datePicker;

	@FindBy(xpath = "//label[@class='font-14 ng-binding']")
	WebElement oneVotePerUnitBtn;

	@FindBy(xpath = "//input[@value='Start Poll']")
	WebElement startPollBtn;

	// Upload photos objects

	@FindBy(xpath = "//a[@title='Images']")
	WebElement photosBtn;

	@FindBy(xpath = "//div[@class='upload-images']//a[@class='cursor-pointer'][contains(text(),'Click here to Add')]")
	WebElement clickHereToAddBtn;

	@FindBy(xpath = "//input[@value='Upload']")
	WebElement uploadPhotosBtn;

	@FindBy(xpath = "//select[@name='galleryId']")
	WebElement selectAlbumDrpDwn;

	@FindBy(xpath = "//select[@name='galleryId']/option[2]")
	WebElement albumSelected;

	public VerifyConversations(WebDriver driver) {
		this.driver = driver;
	}

	public void CreateConversations() throws InterruptedException, AWTException {
		Log.startTestCase("CreateConversations");
		myAddaTab.click();
		Thread.sleep(2000);
		startConvrstn.click();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		conversationTitleTextBox.sendKeys("Testing Conversation Automation " + timestamp);
		messageTextBox.click();
		messageTextBox.sendKeys("Testing Conversation " + timestamp);
		createConvrstn.click();
		Log.info("Conversation created successfully!!");
		Thread.sleep(10000);
		Log.endTestCase("CreateConversations");
	}

	public void createPoll() {
		Log.startTestCase("createPoll");
		startConvrstn.click();
		pollBtn.click();
		pollTopicTextBox.sendKeys("Creating a Test Poll 15");
		pollDescriptionTextBox.sendKeys("Test Poll 15");
		pollOptionOne.sendKeys("One");
		pollOptionTwo.sendKeys("Two");
		pollOptionThree.sendKeys("Three");
		pollOptionFour.sendKeys("Four");
		oneVotePerUnitBtn.click();
		startPollBtn.click();
		Log.info("Poll created successfully!!");
		Log.endTestCase("createPoll");

	}

	public void uploadPhotos() throws AWTException, InterruptedException {
		Log.startTestCase("uploadPhotos");
		myAddaTab.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		startConvrstn.click();
		photosBtn.click();
		clickHereToAddBtn.click();
		Robot robot = new Robot();
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// Set the String to Enter

		StringSelection stringSelection = new StringSelection(
				"C:\\Users\\ADDA\\Pictures\\Screenshots\\Screenshot (1).png");
		// Copy the String to Clipboard

		clipboard.setContents(stringSelection, null);
		// Use Robot class instance to simulate CTRL+C and CTRL+V key events :

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		// Simulate Enter key event
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		selectAlbumDrpDwn.click();
		String selectedAlbum = albumSelected.getText();
		albumSelected.click();
		Thread.sleep(5000);
		uploadPhotosBtn.click();
		Log.info("Photo uploaded to " + selectedAlbum + " successfully!!");
		Thread.sleep(5000);
		Log.endTestCase("uploadPhotos");

	}

}
