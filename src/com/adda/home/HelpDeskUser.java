package com.adda.home;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adda.utility.Log;

public class HelpDeskUser {
	final WebDriver driver;
	static String unitNumber;
	static String ticketNumber;

	@FindBy(xpath = "//li[@id='helpdesk-tab']//a[@href='#']//span[@class='menu-item']//span[@class='ng-binding'][contains(text(),'Helpdesk')]")
	WebElement helpdeskTab;

	@FindBy(xpath = "//li[@id='my_unit-tab']//a[@href='#']")
	WebElement myUnitTab;

	@FindBy(xpath = "//a[@class='pt10']")
	WebElement myUnitDropDown;

	@FindBy(xpath = "//i[@class='mfb-component__main-icon--active fa fa-plus']")
	WebElement addButton;

	@FindBy(xpath = "//input[@placeholder='Search Ticket']")
	WebElement searchTicketTextBox;

	@FindBy(xpath = "//div[@class='card-header clearfix']")
	WebElement searchTicketResult;

	@FindBy(xpath = "//span[@class='main-heading ng-binding']")
	WebElement ticketContentHeading;

	@FindBy(xpath = "//form[@name='FormNewTicker']/div[1]/div/div/a")
	WebElement categoryDropDownButton;

	@FindBy(xpath = "//form[@name='FormNewTicker']/div[1]/div/div/ul/a[1]")
	WebElement selectCategory;

	@FindBy(xpath = "//form[@name='FormNewTicker']/div[2]/div/div/a")
	WebElement subCategoryDropDownButton;

	@FindBy(xpath = "//form[@name='FormNewTicker']/div[2]/div/div/ul/a[1]")
	WebElement selectSubCategory;

	@FindBy(xpath = "//form[@name='FormNewTicker']/div[3]/div/div/a")
	WebElement unitDropDownButton;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchUnitHelpdeskTextBox;

	@FindBy(xpath = "//div[@class='dropdown open']//ul[@class='dropdown-menu dropdown-greetings']/a")
	WebElement searchResult;

	@FindBy(xpath = "//input[@id='personal']")
	WebElement personalTicketCheckBox;

	@FindBy(xpath = "//input[@id='community']")
	WebElement commmunityTicketCheckBox;

	@FindBy(xpath = "//div[@class='helpdesk-issue-box']/div/div[2]/div[3]")
	WebElement issueTextBox;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitButtonHelpdesk;

	@FindBy(xpath = "//div[@id='alerts-modal']/div/div/div/span[5]")
	WebElement helpdeskResponse;

	public HelpDeskUser(WebDriver driver) {
		this.driver = driver;
	}

	public void getUnitNumber() throws InterruptedException {
		myUnitTab.click();
		Thread.sleep(3000);
		myUnitDropDown.click();
		Thread.sleep(3000);
		List<WebElement> units = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-greetings']/a"));
		for (int i = 0; i < units.size(); i++) {
			unitNumber = units.get(0).getText();
		}
	}

	public void createHelpDeskTicket() throws InterruptedException {
		Log.startTestCase("createHelpDeskTicket");
		getUnitNumber();
		helpdeskTab.click();
		Thread.sleep(3000);
		addButton.click();
		Thread.sleep(5000);
		categoryDropDownButton.click();
		Thread.sleep(2000);
		selectCategory.click();
		Thread.sleep(2000);
		subCategoryDropDownButton.click();
		List<WebElement> subCategoryLists = driver
				.findElements(By.xpath("//form[@name='FormNewTicker']/div[2]/div/div/ul/a"));
		int size = subCategoryLists.size();
		if (size != 0) {
			selectSubCategory.click();
		}
		// searchUnitHelpdeskTextBox.sendKeys(unitNumber);
		// Thread.sleep(2000);
		// searchResult.click();
		personalTicketCheckBox.click();
		Thread.sleep(3000);
		issueTextBox.sendKeys("Ticket created through automation script");
		Thread.sleep(3000);
		submitButtonHelpdesk.click();
		Thread.sleep(1500);
		String response = helpdeskResponse.getText();
		Log.info("Helpdesk " + response);
		System.out.println(response);
		String ticketArray[] = response.split(" ");
		System.out.println(ticketArray[1]);
		ticketNumber = ticketArray[1];
		Thread.sleep(2000);
		Log.endTestCase("createHelpDeskTicket");
	}

	public void ValidateHelpdesk() throws InterruptedException {
		Log.startTestCase("ValidateHelpdesk");
		Thread.sleep(3000);
		searchTicketTextBox.sendKeys(ticketNumber);
		Thread.sleep(3000);
		searchTicketResult.click();
		Log.info("Ticket " + ticketNumber + " successfully Validated");
		Log.endTestCase("ValidateHelpdesk");
	}

}

