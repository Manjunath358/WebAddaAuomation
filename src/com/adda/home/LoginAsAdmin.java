package com.adda.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adda.utility.Log;

public class LoginAsAdmin {
	final WebDriver driver;

	@FindBy(id = "admin-link")
	WebElement adminLink;

	@FindBy(xpath = "//a[@href='../myadda/index.php']")
	WebElement myAddaBtn;

	@FindBy(xpath = "//button[@class='dropbtn']")
	WebElement logoutDrpDwn;

	@FindBy(xpath = "//a[@href='/user/logout.php']")
	WebElement logoutBtn;

	@FindBy(xpath = "//a[@class='nav-link bar-line']")
	WebElement signinBtn;

	@FindBy(xpath = "//div[@class='form-group']//input[@name='email']")
	WebElement emailTextBox;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTextBox;

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	WebElement loginSubmitBtn;

	public LoginAsAdmin(WebDriver driver) {
		this.driver = driver;
	}

	public void loginToAdmin(String email, String password) {
		signinBtn.click();
		emailTextBox.sendKeys(email);
		passwordTextBox.sendKeys(password);
		Log.info("Entered Username and Password Successfully");
		loginSubmitBtn.click();
		adminLink.click();
		Log.info("Logged in as Admin Successfully!!");
	}

	public void backToResidence() {
		myAddaBtn.click();
		Log.info("Back to residence URL");
	}

	public void logoutFromAdmin() {
		logoutDrpDwn.click();
		logoutBtn.click();
		Log.info("Logged out from admin successfully!!");
	}

}
