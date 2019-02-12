package com.adda.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adda.utility.Log;

public class LoginAsResidence {
	final WebDriver driver;

	@FindBy(xpath = "//a[@class='nav-link bar-line']")
	WebElement signinBtn;

	@FindBy(xpath = "//div[@class='form-group']//input[@name='email']")
	WebElement emailTextBox;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTextBox;

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	WebElement loginSubmitBtn;

	@FindBy(id = "userMenu")
	WebElement profileDrpDwn;

	@FindBy(xpath = "//a[@href='/user/logout.php']")
	WebElement signOut;

	@FindBy(xpath = "//a[@class='nav-link signOutBtn']")
	WebElement signOutBtn;
	
	@FindBy(xpath="//span[contains(text(),'Switch ADDA')]")
	WebElement switchAddaButton;
	

	public LoginAsResidence(WebDriver driver) {
		this.driver = driver;
	}

	public void loginToResidence(String email, String password) throws InterruptedException {
		Log.startTestCase("loginToResidence");
		Thread.sleep(2000);
		signinBtn.click();
		emailTextBox.sendKeys(email);
		passwordTextBox.sendKeys(password);
		Log.info("Entered Username and Password Successfully");
		loginSubmitBtn.click();
		Log.endTestCase("loginToResidence");
	}
	
	public void switchAdda() throws InterruptedException
	{
		Thread.sleep(2000);
		switchAddaButton.click();
		List<WebElement> addaList = driver.findElements(By.xpath("//div[@id='mCSB_3_container']/a"));
		for(int i=0;i<addaList.size();i++)
		{
			String adda = addaList.get(i).getText();
			if(adda=="Service Apartment")
			{
				
			}
		}
	}

	public void logoutUser() {
		profileDrpDwn.click();
		signOut.click();
	}

	public void rareSignOut() {
		signOutBtn.click();
	}
}
