package com.salesforce.pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class ServiceHomePage extends ProjectSpecificMethods {

	public ServiceHomePage verifyServiceHomePage() {
		verifyDisplayed(locateElement(Locators.XPATH, "//span[@title='Sales']"));
		return this;
	}

	public ServiceHomePage clickReports() {
		clickUsingJs(locateElement(Locators.XPATH,
				"//span[text()='Reports']"));
		return this;
	}

	public ServiceHomePage clickNewReport() {
		click(locateElement(Locators.XPATH, "//div[@title='New Report (Salesforce Classic)']"));
		return this;
	}

	public ServiceHomePage saveImage() throws MalformedURLException, IOException {
		String src = locateElement(Locators.XPATH, "//img[@id='thePage:dummyForm:report_img']").getAttribute("src");
		BufferedImage bufferedImage = ImageIO.read(new URL(src));
		File outputfile = new File("saved.png");
		ImageIO.write(bufferedImage, "png", outputfile);
		return this;
	}

	public ServiceHomePage clickLeads() {
		switchToFrame(locateElement(Locators.XPATH, "//iframe[@title='Select Report Type ~ Salesforce - Developer Edition']"));
		click(locateElement(Locators.XPATH, "//div[@id='reportTypeTree']//ul/div/li[4]"));
		return this;
	}

	public ServiceHomePage clickCreate() {
		click(locateElement(Locators.XPATH, "//input[@id='thePage:rtForm:createButton']"));
		reportStep("Create button click success", "pass");
		return this;
	}

	public ServiceHomePage selectRange() {
		defaultContent();
		switchToFrame(locateElement(Locators.XPATH, "//iframe[@title='Unsaved Report ~ Salesforce - Developer Edition']"));
		click(locateElement(Locators.XPATH, "//input[@name='duration']"));
		click(locateElement(Locators.XPATH, "//div[text()='All Time']"));
		reportStep("More Tabs Clicked.", "pass");
		return this;
	}

	public ServiceHomePage enterStartDate() throws InterruptedException {
		clearAndType(locateElement(Locators.XPATH, "//input[@name='startDate']"), "12/16/2021");
		reportStep("Date entered success", "pass");
		return this;
	}


	public NewLeadPage clickLeadsTab()
	{
		clickUsingJs(locateElement(Locators.XPATH, "//span[text()='Leads']"));
		reportStep("More Tabs Clicked.", "pass");
		return new NewLeadPage();
	}
	
	public ServiceHomePage clickOpportunitiesDropdown() {
		click(locateElement(Locators.XPATH, "//a[contains(@class,'slds-button slds-button_reset')]"));
		return this;
	}

	public ServiceHomePage chooseAllOpportunities() {
		clickUsingJs(locateElement(Locators.XPATH, "//span[contains(text(),'All Opportunities')]"));
		return this;
	}
}
