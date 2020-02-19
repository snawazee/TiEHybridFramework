package com.tie.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tie.Base.BasePage;
import com.tie.Pages.HomePage;
import com.tie.Pages.LoginPage;
import com.tie.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	SoftAssert softAssert;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("BO_UserName"), prop.getProperty("BO_Password"));
		softAssert = new SoftAssert();
	}
/*
	@Test(priority = 1)
	public void verifyHomePageHeaderValueTest() {
		softAssert.assertTrue(homePage.verifyHomePageHeader());
		String headerValue = homePage.getHomePageHeader();
		System.out.println("home page header is: " + headerValue);
		Assert.assertEquals(headerValue, Constants.HOME_PAGE_HEADER, "home page header mismatched...");
		System.out.println("end of the test.......");
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void verifyLoggedInUserTest() {
		softAssert.assertTrue(homePage.verifyLoggedAccountName());
		String accountName = homePage.getLoggedAccountName();
		System.out.println("account Name is: " + accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
		softAssert.assertAll();
	}
*/
	
	@Test(priority = 1, description="verifying Sales Tab is Dispaying")
	@Severity(SeverityLevel.NORMAL)
	@Description("verifying Sales Tab is Dispaying...")	
	@Story("Story Name:verifying Sales Tab is Dispaying") 
	public void verifySalesTabTest() {
		Assert.assertTrue(homePage.verifySalesParentTab(), "sales tab is present or not...");
	}

	@Test(priority = 2)
	public void verifyPayBillsTabTest() {
		Assert.assertTrue(homePage.verifySalesParentTab(), "Paybills  tab is present or not...");
	}
	
	@Test(priority = 3)
	public void verifyCompanytNameTest() {
		Assert.assertTrue(homePage.verifyCompanytName(), "Company name is display is present or not...");
	}
	

	@Test(priority = 4)
	public void verifySalesParentTabTest() throws Exception {
		homePage.verifySalesParentTab();
		
	}
	
	@Test(priority = 5)
	public void veriyPayBillsOverviewTabTest() throws Exception {
		homePage.veriyPayBillsOverviewTab();
		
	}
	
	@Test(priority = 6)
	public void veriyBillsMenuTabTest() throws Exception {
		homePage.veriyBillsMenuTab();
		
	}
	@Test(priority = 7)
	public void veriyVendorMenuTabTest() throws Exception {
		homePage.veriyVendorMenuTab();
		
	}
	
	@Test(priority = 8)
	public void veriyPayBillsTransactionMenuTabTest() throws Exception {
		homePage.veriyPayBillsTransactionMenuTab();
		
	}
	
	@Test(priority = 9)
	public void veriyPayBillsReportMenuTabTest() throws Exception {
		homePage.veriyPayBillsReportMenuTab();
		
	}
	
	
	@Test(priority = 10)
	public void veriySalesOverviewTabTest() throws Exception {
		homePage.veriySalesOverviewTab();
		
	}
	
	@Test(priority = 11)
	public void veriyCustomerTabTest() throws Exception {
		homePage.veriyCustomerTab();
		
	}
	
	@Test(priority = 12)
	public void veriyInvoiceMenuTabTest() throws Exception {
		homePage.veriyInvoiceMenuTab();
		
	}
	
	@Test(priority = 13)
	public void veriySalesTransactiomTabTest() throws Exception {
		homePage.veriySalesTransactiomTab();
		
	}
	
	@Test(priority = 14)
	public void veriySalesReportTabTest() throws Exception {
		homePage.veriySalesReportTab();
		
	}
	
		@AfterTest
	public void quitBrowser() {
		driver.quit();
	
	}

}
