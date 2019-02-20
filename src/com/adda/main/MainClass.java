package com.adda.main;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.adda.home.DubaiRequestDemo;
import com.adda.home.HelpDeskUser;
import com.adda.home.HelpdeskAdmin;
import com.adda.home.LoginAsAdmin;
import com.adda.home.LoginAsResidence;
import com.adda.home.MyUnit;
import com.adda.home.RequestDemo;
import com.adda.home.VerifyConversations;
import com.adda.home.ConvienienceChargeCalculation;
import com.adda.home.CreateAndVerifyNotice;
import com.adda.home.DirectMessage;
import com.adda.utility.Log;

public class MainClass {

	static WebDriver driver;
	LoginAsResidence home;
	LoginAsAdmin admin;
	VerifyConversations convrstn;
	RequestDemo demo;
	DubaiRequestDemo dubai;
	CreateAndVerifyNotice notice;
	MyUnit unit;
	DirectMessage message;
	HelpDeskUser helpdesk;
	ConvienienceChargeCalculation conv;
	HelpdeskAdmin help;
	// String residenceUrl = "https://www.apartmentadda.com";
	String addaIOurl = "http://adda.io";

	@BeforeSuite
	public void beforeMethod() {
//		String log4jConfPath = "\\Users\\ADDA\\workspace\\ADDA\\log4j.xml";
		String log4jConfPath = "/home/jenkins/ADDA/log4j.xml";
		DOMConfigurator.configure(log4jConfPath);
		Log.info("Starting chrome browser");
		
//		System.setProperty("webdriver.chrome.driver",
//				"\\Users\\ADDA\\workspace\\ADDA\\Browsers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				"/usr/bin/chromedriver");
		ChromeOptions ChromeOptions = new ChromeOptions();
	      ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
	      driver = new ChromeDriver(ChromeOptions);
		
		// Log.info("Staring Firfox Browser");
		// System.setProperty("webdriver.gecko.driver",
		// "D:\\geckodriver-v0.21.0-win32\\geckodriver.exe");
		// driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(addaIOurl);
	}

	public void logInToResidence() throws InterruptedException, AWTException {
		driver.navigate().to(addaIOurl);
		home = PageFactory.initElements(driver, LoginAsResidence.class);
		home.loginToResidence("mynewadda.15@gmail.com", "adda1234");
		Log.info("User has logged in successfully!!");
		Thread.sleep(6000);
	}
	
	public void logInToResidenceRare() throws InterruptedException, AWTException {
		driver.navigate().to(addaIOurl);
		home = PageFactory.initElements(driver, LoginAsResidence.class);
		home.rareSignOut();
		home.loginToResidence("mynewadda.15@gmail.com", "adda1234");
		Log.info("User has logged in again successfully!!");
		Thread.sleep(6000);
	}

	public void LogOutAsResidence() {
		home = PageFactory.initElements(driver, LoginAsResidence.class);
		home.logoutUser();
		Log.info("User has logged out successfully!!");
	}

	public void LogInAsAdmin() throws InterruptedException {
		admin = PageFactory.initElements(driver, LoginAsAdmin.class);
		driver.navigate().to(addaIOurl);
		admin.loginToAdmin("mynewadda.1@gmail.com", "adda1234");
		Thread.sleep(3000);
	}

	public void LogoutFromAdmin() {
		admin = PageFactory.initElements(driver, LoginAsAdmin.class);
		admin.logoutFromAdmin();
	}

	
	
	@Test(priority=1)
	public void AdminCreateNotice() throws InterruptedException, AWTException {
		LogInAsAdmin();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		notice = PageFactory.initElements(driver, CreateAndVerifyNotice.class);
		notice.createNotice();
		Thread.sleep(4000);
		LogoutFromAdmin();
		
	}
	@Test(priority=2)
	public void UserVerifyNotice() throws InterruptedException, AWTException {
		logInToResidenceRare();
		notice = PageFactory.initElements(driver, CreateAndVerifyNotice.class);
		notice.verifyNotice();
	}

	@Test(priority=3)
	public void verifyMyUnit() throws InterruptedException, AWTException, MalformedURLException, IOException {
//		logInToResidence();
		unit = PageFactory.initElements(driver, MyUnit.class);
		unit.addMember();
		unit.addVehicle();
		unit.makePayment();
		LogOutAsResidence();
		driver.navigate().to(addaIOurl);
		Thread.sleep(2000);
		home = PageFactory.initElements(driver, LoginAsResidence.class);
		home.rareSignOut();
		home.loginToResidence("bibhuti@3five8.com", "Bibhuti@1993");
		unit.makePayment();
		LogOutAsResidence();
	}
	@Test(priority=4)
	public void validateDirectMessage() throws InterruptedException, AWTException {
		logInToResidenceRare();
		message = PageFactory.initElements(driver, DirectMessage.class);
		message.createDirectMessage();
		LogOutAsResidence();
		driver.navigate().to(addaIOurl);
		home = PageFactory.initElements(driver, LoginAsResidence.class);
		home.rareSignOut();
		home.loginToResidence("mynewadda.6@gmail.com", "adda1234");
		message.validateDirectMessage();
		LogOutAsResidence();
	}

	@Test(priority=5)
	public void ValidateHelpdesk() throws InterruptedException, AWTException {
		logInToResidenceRare();
	//	LogInAsAdmin();
//		help = PageFactory.initElements(driver, HelpdeskAdmin.class);
//		help.dashBoardHelpDeskTicketCounts();
		helpdesk = PageFactory.initElements(driver, HelpDeskUser.class);
		helpdesk.createHelpDeskTicket();
		helpdesk.ValidateHelpdesk();
		Thread.sleep(4000);
	}
	
	@Test(priority=6)
	public void createConversations() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		convrstn = PageFactory.initElements(driver, VerifyConversations.class);
		convrstn.CreateConversations();
		Thread.sleep(4000);
		convrstn.createPoll();
		Thread.sleep(3000);
		convrstn.uploadPhotos();
		Thread.sleep(4000);
		LogOutAsResidence();
	} 
	
	
	//@Test
	public void concinienceCharges() throws InterruptedException, AWTException
	{
		logInToResidence();
		conv = PageFactory.initElements(driver, ConvienienceChargeCalculation.class);
		float num =conv.getUPIChargesLessThan2000();
		System.out.println(num);
		LogOutAsResidence();
	}
	
	// @Test
	// public void dubaiAdda() throws InterruptedException {
	// dubai = PageFactory.initElements(driver, DubaiRequestDemo.class);
	//// dubai.verifyContactPage();
	//// dubai.verifyContactUsForm();
	// dubai.verifyGetStared();
	// dubai.verifyJoinAddaFlow();C:\Users\ADDA\Pictures\Screenshots\Screenshot (1).png
	// }
	
	//
	//
	@AfterSuite
	public void afterMethod() {

		driver.quit();

	}

}
