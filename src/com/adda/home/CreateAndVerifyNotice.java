package com.adda.home;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.adda.utility.Log;

public class CreateAndVerifyNotice {
	final WebDriver driver;
	static String adminNoticeHeader = "TEST NOTICE CREATED THROUGH AUTOMATION";

	@FindBy(xpath = "//p[@class='notification-heading-color font_size_16'][contains(text(),'Post Notice')]")
	WebElement postNoticeBtn;

	@FindBy(xpath = "//input[@id='brief-desc']")
	WebElement noticeBriefDesc;

	@FindBy(xpath = "//input[@id='expiryDate']")
	WebElement selectExpiryDate;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']")
	WebElement datePicker;

	@FindBy(xpath = "//div[@class=\"helpdesk-issue-box\"]/div/div[2]/div[3]")
	WebElement detailedDescp;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement postBtn;

	@FindBy(xpath = "//a[@id='notices-tab']")
	WebElement noticesTab;

	@FindBy(xpath = "//div[2][@class='card-container ng-scope']")
	WebElement noticeContent;

	@FindBy(xpath = "//span[@class='card-header-title pull-left ng-binding']")
	WebElement UserNoticeHeader;

	public CreateAndVerifyNotice(WebDriver driver) {
		this.driver = driver;
	}

	public void createNotice() throws InterruptedException, AWTException {
		Log.startTestCase("createNotice");
		Thread.sleep(5000);
		String winHandleBefore = driver.getWindowHandle();
		postNoticeBtn.click();

		Thread.sleep(5000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);
		noticeBriefDesc.sendKeys(adminNoticeHeader + " " + timestamp);
		adminNoticeHeader = noticeBriefDesc.getAttribute("value");
		System.out.println(adminNoticeHeader);
//		DateFormat dateFormat2 = new SimpleDateFormat("dd");
//		Date date2 = new Date();
		//String today = dateFormat2.format(date2);
		selectExpiryDate.click();
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Log.info("Notice created for Today");
		System.out.println("Todays selected");
//		List<WebElement> columns = datePicker.findElements(By.tagName("td"));
//
//		for (WebElement cell : columns) {
//			System.out.println(cell.getText());
//			if (cell.getText().equals(today)) {
//				cell.click();
//				Log.info("Notice created for Today");
//				System.out.println("Todays selected");
//				break;
//			}
//		}
		detailedDescp.click();
		Thread.sleep(5000);
		detailedDescp.sendKeys("Test Notice Automation");
		Thread.sleep(2000);
		postBtn.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		System.out.println("Notice posted");
		Log.info("Notice created successfully from Admin!!");
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(2000);
		Log.endTestCase("createNotice");
	}

	public void verifyNotice() throws InterruptedException {
		Log.startTestCase("verifyNotice");
		noticesTab.click();
		noticeContent.click();
		Thread.sleep(4000);
		String expectedNoticeHeader = UserNoticeHeader.getText();
		Assert.assertEquals(adminNoticeHeader, expectedNoticeHeader, "Notice Header not matching");
		Log.info("Notice verified successfully from user side!!");
		Log.endTestCase("verifyNotice");
	}

}
