package com.adda.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.adda.utility.Log;

public class DubaiRequestDemo {
	final WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'Contact Us')]")
	WebElement contactLink;
	@FindBy(xpath = "//input[@name='Name_First']")
	WebElement firstNameTextBox;
	@FindBy(xpath = "//input[@name='Name_Last']")
	WebElement LastNameTextBox;
	@FindBy(xpath = "//input[@name='Email']")
	WebElement emailTextBox;
	@FindBy(xpath = "//input[@name='countrycode']")
	WebElement phoneTextBox;
	@FindBy(xpath = "//input[@name='SingleLine1']")
	WebElement messageTextBox;
	@FindBy(xpath = "//button[@value='submit']")
	WebElement submitButton;

	// Get Started form objects
	@FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Get Started')]")
	WebElement getStaredBtn;
	@FindBy(xpath = "//form[@class='query-form form ng-pristine ng-invalid ng-touched']//input[@name='fullName']")
	WebElement fullNameTxtBox;
	@FindBy(xpath = "//app-query-form[@class='ng-tns-c1-1 ng-tns-c5-4']/form/div[2]/input")
	WebElement phoneNumberTxtBox;
	@FindBy(xpath = "//app-query-form[@class='ng-tns-c1-1 ng-tns-c5-4']/form/div[3]/input")
	WebElement emailTxtBox;
	@FindBy(xpath = "//app-query-form[@class='ng-tns-c1-1 ng-tns-c5-4']/form/div[4]/input")
	WebElement cityTxtBox;
	@FindBy(xpath = "//app-query-form[@class='ng-tns-c1-1 ng-tns-c5-4']/form/div[5]/div/input")
	WebElement reCaptchaTxtBox;
	@FindBy(xpath = "//app-query-form[@class='ng-tns-c1-1 ng-tns-c5-4']/form/div[6]/button")
	WebElement requestCallBackBtn;

	// Join Adda Page Objects
	@FindBy(xpath = "//a[@class='nav-link bar-line']")
	WebElement signInBtn;
	@FindBy(xpath = "//button[@type='submit'][contains(text(),'Join')]")
	WebElement joinAddaBtn;
	@FindBy(xpath = "//input[@formcontrolname='addaName']")
	WebElement addaNameTextBox;
	@FindBy(xpath = "//input[@formcontrolname='userName']")
	WebElement userNameTextBox;
	@FindBy(xpath = "//input[@formcontrolname='email']")
	// @FindBy(xpath="//form[@class='ng-pristine ng-invalid ng-star-inserted
	// ng-touched']/div[3]/input")
	WebElement emailTextBoxJoinAdda;
	@FindBy(xpath = "//form[@class='ng-pristine ng-invalid ng-star-inserted ng-touched']/div[4]/input")
	WebElement passwordTextBox;
	@FindBy(xpath = "//input[@formcontrolname='isdNumber']")
	WebElement isdNumberTextBox;
	@FindBy(xpath = "//input[@formcontrolname='phoneNumber']")
	WebElement phoneNumberTextBox;

	// Home button
	@FindBy(xpath = "//body/div[@class='container-fluid']/div[@class='row']/app-root[@class='ng-tns-c0-0']/div[@class='container-fluid ng-tns-c0-0 ng-trigger ng-trigger-fadeIn ng-star-inserted']/div[@class='row']/app-common-header[@class='ng-tns-c0-0 ng-tns-c1-1']/div/nav[@class='navbar navbar-expand-lg fixed-top background-white']/a[@class='navbar-brand']/*[1]")
	WebElement logoBtn;

	public DubaiRequestDemo(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyContactPage() {
		Log.info("Clicked on Contact Link");
		contactLink.click();
		String expectedUrl = "https://adda.io/contact";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "You are not in Adda.io Contact us page");
		Log.info("You are in Adda.io Contact us page");
	}

	public void verifyContactUsForm() throws InterruptedException {
		Log.startTestCase("verifyContactUsForm");
		driver.switchTo().frame(1);
		Log.info("Switched to Contact Us IFrame");
		firstNameTextBox.sendKeys("Bibhuti");
		LastNameTextBox.sendKeys("Bhusan");
		Log.info("First and Last name entered");
		phoneTextBox.sendKeys("3434389898");
		Log.info("Phone Number entered");
		emailTextBox.sendKeys("bibhutiadda@gmail.com");
		Log.info("Email ID entered");
		Select drpCountry = new Select(driver.findElement(By.name("Address_Country")));
		drpCountry.selectByVisibleText("India");
		Log.info("Country Selected");
		Select productName = new Select(driver.findElement(By.name("Radio")));
		productName.selectByVisibleText("ADDA ERP");
		Log.info("Product Selected");
		messageTextBox.sendKeys("New Adda");
		Log.info("Comments entered");
		Thread.sleep(5000);
		submitButton.click();
		Log.info("Submit Button Clicked");
		Log.endTestCase("verifyContactUsForm");
		logoBtn.click();
		Thread.sleep(5000);
	}

	public void verifyGetStared() throws InterruptedException {
		Log.startTestCase("verifyGetStared");
		getStaredBtn.click();
		fullNameTxtBox.sendKeys("Test Automation");
		Log.info("Full name entered");
		phoneNumberTxtBox.sendKeys("4252627152");
		Log.info("Phone number entered");
		emailTxtBox.sendKeys("bibhuti@3five8.com");
		Log.info("EMail ID entered");
		cityTxtBox.sendKeys("Bangalore");
		Log.info("City entered");
		reCaptchaTxtBox.sendKeys("8");
		Log.info("Captcha entered");
		requestCallBackBtn.click();
		Log.info("Request call back Initiated");
		Log.endTestCase("verifyGetStared");
	}

	public void verifyJoinAddaFlow() throws InterruptedException {
		signInBtn.click();
		joinAddaBtn.click();
		addaNameTextBox.click();
		addaNameTextBox.sendKeys("Test Automation");
		Thread.sleep(4000);
		userNameTextBox.sendKeys("Bibhuti Bhusan");
		Thread.sleep(4000);
		emailTextBoxJoinAdda.sendKeys("testautomation");
		Thread.sleep(4000);
		passwordTextBox.sendKeys("adda1234");
		Thread.sleep(4000);
		isdNumberTextBox.sendKeys("345678");
		Thread.sleep(4000);
		phoneNumberTextBox.sendKeys("2345654567");
		Thread.sleep(4000);
	}

}
