package com.adda.home;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adda.utility.Log;

public class ConvienienceChargeCalculation {
	
	final WebDriver driver;
	
	@FindBy(xpath = "//li[@id='my_unit-tab']//a[@href='#']")
	WebElement myUnitTab;
	
	@FindBy(xpath = "//button[@class='blue-button']")
	WebElement payNowBtn;
	
	@FindBy(xpath="//a[@class='cursor-pointer']")
	WebElement convinienceChargesButton;
	
	@FindBy(xpath="//div[@class='modal-body ng-binding']/ul/li[1]/strong[2]")
	WebElement UPIchargesLess2000;
	
	@FindBy(xpath="//div[@class='modal-body ng-binding']/ul/li[1]/strong[3]")
	WebElement UPIchargesGreater2000;
	
	@FindBy(xpath="//div[@class='modal-body ng-binding']/ul/li[2]/strong[2]")
	WebElement netBankingAllExceptSbiCharges;
	
	@FindBy(xpath="//div[@class='modal-body ng-binding']/ul/li[2]/strong[3]")
	WebElement netBankingSBICharges;
	
	@FindBy(xpath="//div[@class='modal-body ng-binding']/ul/li[3]/strong[2]")
	WebElement debitCardLessThan2000Charges;
	
	@FindBy(xpath="//div[@class='modal-body ng-binding']/ul/li[3]/strong[3]")
	WebElement debitCardGreaterThan2000Charges;
	
	@FindBy(xpath="//div[@class='modal-body ng-binding']/ul/li[4]/strong[2]")
	WebElement creditCardCharges;
	
	@FindBy(xpath="//div[@class='modal-body ng-binding']/ul/li[5]/strong[2]")
	WebElement amexCardCharges;
	
	@FindBy(xpath="//div[@class='modal-body ng-binding']/ul/li[6]/strong[2]")
	WebElement internationalCardCharges;
	
	@FindBy(xpath="//a[@type='button']")
	WebElement cancelPopupButton;
	
	public ConvienienceChargeCalculation(WebDriver driver) {
		this.driver = driver;
	}
	
	public float getUPIChargesLessThan2000() throws InterruptedException, AWTException
	{
		convinienceChargesButton.click();
		Thread.sleep(2000);
		String upi = UPIchargesLess2000.getText();
		String upiString[]=upi.split(" ");
		float upiChargesLessThan2000 = Float.parseFloat(upiString[1]);	
		System.out.println("UPI charges for less than 2000 is "+upiChargesLessThan2000);
		Log.info("UPI charges for less than 2000 is "+upiChargesLessThan2000);
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		//cancelPopupButton.click();
		return upiChargesLessThan2000;
	}
	
	public float getUPIChargesGreaterThan2000() throws InterruptedException, AWTException
	{
		convinienceChargesButton.click();
		Thread.sleep(2000);
		String upi = UPIchargesGreater2000.getText();
		String upiString[]=upi.split(" ");
		float upiChargesGreaterThan2000 = Float.parseFloat(upiString[1]);	
		System.out.println("UPI charges for greater than 2000 is "+upiChargesGreaterThan2000);
		Log.info("UPI charges for greater than 2000 is "+upiChargesGreaterThan2000);
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		//cancelPopupButton.click();
		return upiChargesGreaterThan2000;

	}
	
	public int getnetBankingAllExceptSBICharges() throws InterruptedException
	{
		convinienceChargesButton.click();
		Thread.sleep(2000);
		String upi = netBankingAllExceptSbiCharges.getText();
		String upiString[]=upi.split(" ");
		int netBankingAllExceptSbiCharges = Integer.parseInt(upiString[1]);	
		System.out.println("Netbankig Charges for All bank except SBI is "+netBankingAllExceptSbiCharges);
		Log.info("Netbankig Charges for All bank except SBI is "+netBankingAllExceptSbiCharges);
		Thread.sleep(2000);
		cancelPopupButton.click();
		return netBankingAllExceptSbiCharges;
		
	}
	
	public int getNetBankingSBICharges() throws InterruptedException
	{
		
		convinienceChargesButton.click();
		Thread.sleep(2000);
		String upi = netBankingSBICharges.getText();
		String upiString[]=upi.split(" ");
		int netBankingSBICharges = Integer.parseInt(upiString[1]);	
		System.out.println("Net Banking charges for all SBI banks is "+netBankingSBICharges);
		Log.info("Net Banking charges for all SBI banks is "+netBankingSBICharges);
		Thread.sleep(2000);
		cancelPopupButton.click();
		return netBankingSBICharges;
		
	}
	
	public float getDebitCardLess2000Charges() throws InterruptedException
	{
		convinienceChargesButton.click();
		Thread.sleep(2000);
		String upi = debitCardLessThan2000Charges.getText();
		String upiString[]=upi.split(" ");
		float debitCardLessThan2000Charges = Float.parseFloat(upiString[0].replace("%", ""));	
		System.out.println("Debit card charges When total amount is less than 2000 Rupees is "+debitCardLessThan2000Charges);
		Log.info("Debit card charges When total amount is less than 2000 Rupees is "+debitCardLessThan2000Charges);
		Thread.sleep(2000);
		cancelPopupButton.click();
		return debitCardLessThan2000Charges;
		
	}
	
	public float getDebitCardGreaterThan2000Charges() throws InterruptedException
	{
		convinienceChargesButton.click();
		Thread.sleep(2000);
		String upi = debitCardGreaterThan2000Charges.getText();
		String upiString[]=upi.split(" ");
		float debitCardGreaterThan2000Charges = Float.parseFloat(upiString[0].replace("%", ""));	
		System.out.println("Debit card charges When total amount is greater than 2000 Rupees is "+debitCardGreaterThan2000Charges);
		Log.info("Debit card charges When total amount is greater than 2000 Rupees is "+debitCardGreaterThan2000Charges);
		return debitCardGreaterThan2000Charges;
		
	}
	public  float getCreditCardChrages() throws InterruptedException
	{
		convinienceChargesButton.click();
		Thread.sleep(2000);
		String upi = creditCardCharges.getText();
		String upiString[]=upi.split(" ");
		float creditCardCharges = Float.parseFloat(upiString[0].replace("%", ""));	
		System.out.println("Credit card convineince charge is "+creditCardCharges+"%");
		Log.info("Credit card convineince charge is "+creditCardCharges+"%");
		Thread.sleep(2000);
		cancelPopupButton.click();
		return creditCardCharges;
	}
	
	public float getAmexCardChrages() throws InterruptedException
	{
		convinienceChargesButton.click();
		Thread.sleep(2000);
		String upi = amexCardCharges.getText();
		String upiString[]=upi.split(" ");
		float amexCardCharges = Float.parseFloat(upiString[0].replace("%", ""));	
		System.out.println("Amex card convineince charge is "+amexCardCharges+"%");
		Log.info("Amex card convineince charge is "+amexCardCharges+"%");
		Thread.sleep(2000);
		cancelPopupButton.click();
		return amexCardCharges;
	}
	
	public int getInternationalCardChrages() throws InterruptedException
	{
		convinienceChargesButton.click();
		Thread.sleep(2000);
		String upi = internationalCardCharges.getText();
		String upiString[]=upi.split(" ");
		int internationalCardCharges = Integer.parseInt(upiString[1]);	
		System.out.println("International card convineince charge is "+internationalCardCharges+"%");
		Log.info("International card convineince charge is "+internationalCardCharges+"%");
		Thread.sleep(2000);
		cancelPopupButton.click();  
		return internationalCardCharges;
	}
	
	

}
