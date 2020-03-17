package com.qa.tie.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.tie.Base.BasePage;
import com.qa.tie.Page.BillsPage;
import com.qa.tie.Page.CustomerPage;
import com.qa.tie.Page.DashboardPage;
import com.qa.tie.Page.InvoicePage;
import com.qa.tie.Page.LoginPage;
import com.qa.tie.Page.PayBillsOverviewPage;
import com.qa.tie.Page.PayBills_ReportsPage;
import com.qa.tie.Page.PayBills_TransactionPage;
import com.qa.tie.Page.SalesTransactionPage;
import com.qa.tie.Util.AppConstants;
import com.qa.tie.Util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

	@Epic("Invoice  page features")
	@Feature("Invoice Page Test")
	public class PayBills_ReportsPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	Credentials userCred;
	InvoicePage invoicePage;
	CustomerPage customerPage;
	SalesTransactionPage salesTransationPage;
	BillsPage billsPage;
	PayBillsOverviewPage paybillsOverviewPage;
	PayBills_TransactionPage paybillsTransationPage;
	PayBills_ReportsPage paybillsReportsPage;
	

	@BeforeTest(alwaysRun=true)
	@Parameters(value={"browser"})
	public void setUp(String browser) {
	String browserName = null;
	basePage = new BasePage();
	prop = basePage.init_properties();
	
	if(browser.equals(null) || browser.equals("") || browser.isEmpty()){
		browserName = prop.getProperty("browser");
		}else{
			browserName = browser;
			}
			
			
	driver = basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	loginPage = new LoginPage(driver);
	userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	dashboardPage = loginPage.doLogin(userCred);
	paybillsReportsPage = dashboardPage.goToPayBillsReportsPage();
	}

	@Test(priority = 1, groups="sanity")
	@Description("verify Customer  Page Title Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyHomePageTitleTest() {
	String title = paybillsReportsPage.getCustomerPageTitle();
	System.out.println("home page title is : " + title);
	Assert.assertEquals(title, AppConstants.PAYBILLSREPORTS_PAGE_TITLE);
				
	}
}
