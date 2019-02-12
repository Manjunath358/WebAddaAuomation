package com.adda.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class RequestDemo {
	final WebDriver driver;
	@FindBy(xpath = "//a[@href='http://contact.apartmentadda.com/apartment-management-accounting']")
	WebElement addaERPrequestDemoBtn;

	// Security page objects

	@FindBy(xpath = "//a[@href='http://contact.apartmentadda.com/gatekeeper-security']")
	WebElement addaSecurityRequestDemoBtn;
	@FindBy(xpath = "//a[@class='lp-button-react w-e326c8a4-c714-c9a7-2634-def686ad7e78 is-bold lp-button-react--small lp-button-react--line font-scale-4 line-height-scale-3']")
	WebElement RequestADemoBtn;
	@FindBy(xpath = "//input[@name='Name_First']")
	WebElement firstNameTextBox;
	@FindBy(xpath = "//input[@name='Name_Last']")
	WebElement LastNameTextBox;
	@FindBy(xpath = "//input[@name='Email']")
	WebElement emailTextBox;
	@FindBy(xpath = "//input[@name='countrycode']")
	WebElement phoneTextBox;
	@FindBy(xpath = "//textarea[@name='MultiLine']")
	WebElement messageTextBox;

	public RequestDemo(WebDriver driver) {
		this.driver = driver;
	}

	public void launchToASRequestDemoFormPage() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		addaSecurityRequestDemoBtn.click();
		Thread.sleep(4000);
		// String childWindow = driver.getWindowHandle();
		RequestADemoBtn.click();

	}

}
