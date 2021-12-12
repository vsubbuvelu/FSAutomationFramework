package com.salesforce.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class Assessment extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testcaseName = "VerifyFollowUpTask";
		testDescription = "Verify Edit Task functionality with positive data";
		authors = "Subramanian";
		category = "Smoke";
	}

	@Test
	public void runCreateReport() throws InterruptedException, MalformedURLException, IOException {
		new LoginPage().enterUsername("fullstack@testleaf.com").enterPassword("SelBootcamp$123").clickLogin()
				.clickToggleMenu().clickViewAll().clickService().clickReports().clickNewReport().clickLeads().saveImage().clickCreate().selectRange().enterStartDate();
	}
}