package com.adda.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpdeskAdmin {
	final WebDriver driver;
	static int personalHelpDeskCounts =0;
	static int communityHelpdeskCounts =0;
	
	@FindBy(xpath="//div[@id='row-1']//div[@class='col-xs-12 col-sm-4 col-lg-4 padding-panel']//div[@class='row']//div[1]//div[1]")
	WebElement personalTicketCountsHeader;
	
	@FindBy(xpath="//div[@id='row-1']//div[@class='col-xs-12 col-sm-4 col-lg-4 padding-panel']//div[@class='row']//div[2]//div[1]")
	WebElement communityTicketCountsHeader;
	
	@FindBy(xpath="//td[@class='t']/strong[1]")
	WebElement fetchedHepldeskTicketCounts;
	
	public HelpdeskAdmin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void dashBoardHelpDeskTicketCounts()
	{
		String personalTicketCountsText= personalTicketCountsHeader.getText();
		System.out.println(personalTicketCountsText);
	}

}
