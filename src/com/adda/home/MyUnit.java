package com.adda.home;

import java.awt.AWTException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.adda.utility.Log;

public class MyUnit {

	final WebDriver driver;
	int statusCode;
	String[] payOption = new String[10];
	HttpURLConnection huc = null;
	int count = 0;
	
	@FindBy(xpath = "//li[@id='my_unit-tab']//a[@href='#']")
	WebElement myUnitTab;
	
	@FindBy(xpath = "//a[@class='mfb-component__button--main']")
	WebElement addBtn;
	
	@FindBy(xpath = "//a[@class='mfb-component__button--child']")
	WebElement addMemberBtn;
	
	@FindBy(xpath = "//input[@id='firstName']")
	WebElement firstNameTextBox;
	
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastNameTextBox;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailTextBox;

	@FindBy(xpath = "//input[@id='mobile']")
	WebElement mobileNumberTextBox;

	@FindBy(xpath = "//input[@id='owner']")
	WebElement ownerRadioBtn;
	
	@FindBy(xpath = "//input[@id='tenant']")
	WebElement tenantRadioBtn;
	
	@FindBy(xpath = "//textarea[@id='notes_m']")
	WebElement notesForModerator;
	
	@FindBy(xpath = "//form[@name='AddMemberForm']//input[@value='Add']")
	WebElement addBtnPopup;
	
	@FindBy(xpath = "//ul[@class='mfb-component__list']//li[2]//a[1]")
	WebElement addVehicleBtn;
	
	@FindBy(xpath = "//input[@id='slotno']")
	WebElement slotNoTextBox;

	@FindBy(xpath = "//input[@id='sticker']")
	WebElement stickerTextBox;

	@FindBy(xpath = "//input[@id='model_make']")
	WebElement modelTextBox;

	@FindBy(xpath = "//input[@id='vehicle_no']")
	WebElement vehicleNoTextBox;

	@FindBy(xpath = "//input[@value='2']")
	WebElement twoWheelerRadioBtn;

	@FindBy(xpath = "//input[@value='4']")
	WebElement fourWheelerRadioBtn;

	@FindBy(xpath = "//div[@id='vehicleAddModal']//input[@value='Add']")
	WebElement addVehicleBtnPopup;

	@FindBy(xpath = "//div[@id='alerts-modal']/div/div/div")
	WebElement alertPopup;

	@FindBy(xpath = "//button[@class='blue-button']")
	WebElement payNowBtn;

	@FindBy(xpath = "//table[@class=\"tListIssues hasStyle\"]/tbody/tr/td[2]")
	WebElement billValueCheck;

	@FindBy(xpath = "//table[@class='tListIssues hasStyle']//tbody//tr[1]//td[1]//input[1]")
	WebElement billCheckBox;

	@FindBy(xpath = "//div[contains(@ng-show,\"pg.pg_enabled == '1' && pg.provider2_enabled == '1'\")]//thead//tr[@align='center']/th")
	WebElement paymentOptions;

	@FindBy(xpath = "//table[@class='tListIssues hasStyle']//input[@value='upi']")
	WebElement upiCheckBox;

	@FindBy(xpath = "//table[@class='tListIssues hasStyle']//input[@value='n']")
	WebElement netBankingAllExceptSBICheckBox;

	@FindBy(xpath = "//input[@value='ns']")
	WebElement netBankingSBICheckBox;

	@FindBy(xpath = "//table[@class='tListIssues hasStyle']//input[@value='d']")
	WebElement debitCardCheckBox;

	@FindBy(xpath = "//table[@class='tListIssues hasStyle']//input[@value='c']")
	WebElement creditCardCheckBox;

	@FindBy(xpath = "//input[@value='amex']")
	WebElement amexCheckBox;

	@FindBy(xpath = "//table[@class='tListIssues hasStyle']//input[@value='ic']")
	WebElement interNationalCardsCheckBox;

	@FindBy(xpath = "//input[@placeholder='Comments']")
	WebElement commentsPayment;
	
	@FindBy(xpath="//div[@ng-show=\"pg.pg_enabled == '1'\"]//table[@class='tListIssues hasStyle']/tbody/tr[1]/td[2]")
	WebElement amountPayble;
	
	@FindBy(xpath="//div[@ng-show=\"pg.pg_enabled == '1'\"]//table[@class='tListIssues hasStyle']/tbody/tr[2]/td[2]")
	WebElement convinienceCharge;
	
	@FindBy(xpath="//div[@ng-show=\"pg.pg_enabled == '1'\"]//table[@class='tListIssues hasStyle']/tbody/tr[3]/td[2]")
	WebElement totalPayble;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement payOnlineButton;
	
	ConvienienceChargeCalculation conv;

	public MyUnit(WebDriver driver) {
		this.driver = driver;
	}

	public void addMember() throws InterruptedException {
		Log.startTestCase("addMember");
		Thread.sleep(3000);
		myUnitTab.click();
		Thread.sleep(3000);
		addBtn.click();
		Thread.sleep(2000);
		addMemberBtn.click();
		Thread.sleep(2000);
		firstNameTextBox.sendKeys("Bibhuti");
		lastNameTextBox.sendKeys("Bhusan");
		emailTextBox.sendKeys("testingadda@noone.com");
		mobileNumberTextBox.sendKeys("2345490987");
		tenantRadioBtn.click();
		notesForModerator.sendKeys("New Member Added");
		Thread.sleep(4000);
		addBtnPopup.click();
		Log.info("Member added to the Flat successfully!!");
		Thread.sleep(4000);
		Log.endTestCase("addMember");
	}

	public void addVehicle() throws InterruptedException {
		Log.startTestCase("addVehicle");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Thread.sleep(3000);
		myUnitTab.click();
		Thread.sleep(2000);
		addBtn.click();
		Thread.sleep(3000);
		addVehicleBtn.click();
		Thread.sleep(3000);
		slotNoTextBox.sendKeys("2019 " + timestamp);
		stickerTextBox.sendKeys("OmmNamaShivay");
		modelTextBox.sendKeys("R15Yahmha");
		vehicleNoTextBox.sendKeys("MH02TA7654");
		twoWheelerRadioBtn.click();
		Thread.sleep(3000);
		addVehicleBtnPopup.click();
		Thread.sleep(2000);
		String message = alertPopup.getText();
		System.out.println(message);
		if (message.equalsIgnoreCase("Success !    Vehicle Added Successfully")) {
			Log.info("Two Wheeler Vehicle Added Suceessfully!!");
		}
		Log.info(message);
		Thread.sleep(4000);
		Log.endTestCase("addVehicle");

	}

	public void checkPaymentOptions() throws InterruptedException, MalformedURLException, IOException {
		Thread.sleep(3000);
		payOnlineButton.click();
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		huc = (HttpURLConnection) (new URL(url).openConnection());

		huc.setRequestMethod("HEAD");

		huc.connect();

		int respCode = huc.getResponseCode();

		if (respCode >= 400) {
			System.out.println(url + " is a broken link");
		} else {
			System.out.println(url + " is a valid link");
		}
		driver.navigate().back();

		Thread.sleep(4000);

	}

	public void makePayment() throws InterruptedException, MalformedURLException, IOException, AWTException {
		Log.startTestCase("MakePayment Test Case Started");
		conv = PageFactory.initElements(driver, ConvienienceChargeCalculation.class);
		myUnitTab.click();
		driver.navigate().refresh();
		payNowBtn.click();
		Thread.sleep(3000);
		String billValueString = billValueCheck.getText();
		System.out.println(billValueString);
		Thread.sleep(4000);
		if (!billValueString.equalsIgnoreCase("Rs. 0.00")) {
			Thread.sleep(4000);
			
//			List<WebElement> payList = driver.findElements(By.xpath(
//					"//div[contains(@ng-show,\"pg.pg_enabled == '1' && pg.provider2_enabled == '1'\")]//thead//tr[@align='center']/th"));
			
			List<WebElement> payList = driver.findElements(By.xpath(
					"//div[contains(@ng-show,\"pg.pg_enabled == '1' && pg.provider2_enabled == '1'\")]//table[@class='tListIssues hasStyle']/thead/tr/th"));
			
			System.out.println(payList.size());
			for (int i = 0; i < payList.size(); i++) {
				payOption[i] = payList.get(i).getText();
			}
			System.out.println("Goint to print Payment Options name");
			for (int i = 0; i < payOption.length; i++) {
				System.out.println(payOption[i]);

			}
			for (int i = 0; i < 6; i++) {
				System.out.println(payOption[i]);
				if (payOption[i].equalsIgnoreCase("null")) {
					break;
				}
				billCheckBox.click();
				if (payOption[i].equalsIgnoreCase("UPI")) {
					upiCheckBox.click();
					commentsPayment.sendKeys("Paying through " + payOption[i]);
					Log.info("Paying through " + payOption[i]);
					String amountPaybleString= amountPayble.getText();
					float amountPayble = Float.parseFloat(amountPaybleString);
					String convinienceChargeString= convinienceCharge.getText();
					float convinienceCharge = Float.parseFloat(convinienceChargeString);
					if(amountPayble<2000)
					{
						float getUPIChargesLessThan2000 =conv.getUPIChargesLessThan2000();
						Assert.assertEquals(convinienceCharge, getUPIChargesLessThan2000, "Convinince charge of UPI when Amount payble is less than 2000 Checked");
						Log.info("Convinince charge of UPI when Amount payble is less than 2000 Checked!!");
					}
					else
					{
						float getUPIChargesGreaterThan2000 = conv.getUPIChargesGreaterThan2000();
						Assert.assertEquals(convinienceCharge, getUPIChargesGreaterThan2000, "Convinince charge of UPI when Amount payble is greater than 2000 Checked");
						Log.info("Convinince charge of UPI when Amount payble is greater than 2000 Checked!!");
					}
					checkPaymentOptions();
				} else if (payOption[i].equalsIgnoreCase("Debit Card")) {
					debitCardCheckBox.click();
					commentsPayment.sendKeys("Paying through " + payOption[i]);
					Log.info("Paying through " + payOption[i]);
					String amountPaybleString= amountPayble.getText();
					float amountPayble = Float.parseFloat(amountPaybleString);
					String convinienceChargeString= convinienceCharge.getText();
					float convinienceCharge = Float.parseFloat(convinienceChargeString);
					if(amountPayble<2000)
					{
						float debitCardLess2000ChargesPercentage =conv.getDebitCardLess2000Charges();
						float debitConvinienceCharges = (float) (Math.round(debitCardLess2000ChargesPercentage*amountPayble)/100.0);
						Assert.assertEquals(convinienceCharge, debitConvinienceCharges, "Convinince charge of Debit Card when Amount payble is less than 2000 Checked");
						Log.info("Convinince charge of Debit Card when Amount payble is less than 2000 Checked");
					}
					else
					{
						float DebitCardGreaterThan2000ChargesPercentage =conv.getDebitCardGreaterThan2000Charges();
						float debitConvinienceCharges = (float) (Math.round(DebitCardGreaterThan2000ChargesPercentage*amountPayble)/100.0);
						Assert.assertEquals(convinienceCharge, debitConvinienceCharges, "Convinince charge of Debit Card when Amount payble is greater than 2000 Checked");
						Log.info("Convinince charge of Debit Card when Amount payble is greater than 2000 Checked");
					}
					checkPaymentOptions();
				}
				if (payOption[i].equalsIgnoreCase("Credit Card")) {
					creditCardCheckBox.click();
					commentsPayment.sendKeys("Paying through " + payOption[i]);
					String amountPaybleString= amountPayble.getText();
					float amountPayble = Float.parseFloat(amountPaybleString);
					String convinienceChargeString= convinienceCharge.getText();
					float convinienceCharge = Float.parseFloat(convinienceChargeString);
					float creditCardChrages =conv.getCreditCardChrages();
					float creditConvinienceCharges = (float) (Math.round(creditCardChrages*amountPayble)/100.0);
					Assert.assertEquals(convinienceCharge, creditConvinienceCharges, "Convinince charge of Credit Card is Checked");
					Log.info("Convinince charge of Credit Card is Checked");
					Log.info("Paying through " + payOption[i]);
					checkPaymentOptions();
				}
				if (payOption[i].equalsIgnoreCase("AMEX")) {
					amexCheckBox.click();
					commentsPayment.sendKeys("Paying through " + payOption[i]);
					String amountPaybleString= amountPayble.getText();
					float amountPayble = Float.parseFloat(amountPaybleString);
					String convinienceChargeString= convinienceCharge.getText();
					float convinienceCharge = Float.parseFloat(convinienceChargeString);
					float amexCardCharges =conv.getAmexCardChrages();
					float amexConvinienceCharges = (float) (Math.round(amexCardCharges*amountPayble)/100.0);
					Assert.assertEquals(convinienceCharge, amexConvinienceCharges, "Convinince charge of Amex Card is Checked");
					Log.info("Convinince charge of Amex Card is Checked");
					Log.info("Paying through " + payOption[i]);
					
					checkPaymentOptions();
				}

			}
			Log.endTestCase("makePayment");
		} else {
			System.out.println("There are no bills to pay!!");
			Log.info("There are no bills to pay!!");
			Log.info("makePayment Test Case end!!");
		}
	}
	
	public void convinienceChargeCalculation()
	{
		
	}

}
