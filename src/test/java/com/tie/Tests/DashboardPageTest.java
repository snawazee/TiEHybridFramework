package com.tie.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tie.Base.BasePage;
import com.tie.Listeners.TestAllureListener;
import com.tie.Pages.DashboardPage;
import com.tie.Pages.LoginPage;
import com.tie.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;




//@Listeners(ExtentReportListener.class)
@Epic("Regression Test")
@Feature("Dashboard Page Test")
@Listeners(TestAllureListener.class)
public class DashboardPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	SoftAssert softAssert;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		dashboardPage = loginPage.doLogin(prop.getProperty("BO_UserName"), prop.getProperty("BO_Password"));
		softAssert = new SoftAssert();
	}

	
	@Test(priority = 1, description="verifying Sales Tab is Dispaying")
	@Severity(SeverityLevel.NORMAL)
	@Description("verifying Sales Tab is Dispaying...")	
	@Story("Story Name:verifying Sales Tab is Dispaying") 
	public void verifySalesTabTest() {
		Assert.assertTrue(dashboardPage.verifySalesParentTab(), "sales tab is present or not...");
	}

	@Test(priority = 2, description="Pay Bills Button Test...")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see Pay Bills Button on dashboard....")	
	@Story("user should be able to see Pay Bills Button on dashboard....") 
	public void verifyPayBillsTabTest() {
		Assert.assertTrue(dashboardPage.verifySalesParentTab(), "Paybills  tab is present or not...");
	}
	
	@Test(priority = 3, description="Company Name Test...")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see company name....")	
	@Story("user should be able to see company name....") 
	public void verifyCompanytNameTest() {
		Assert.assertTrue(dashboardPage.verifyCompanytName(), "Company name is display is present or not...");
	}
	

	@Test(priority = 4, description="Verify Sales Menu....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see sales menu...")	
	@Story("user should be able to see sales menu...") 
	public void verifySalesParentTabTest() throws Exception {
		dashboardPage.verifySalesParentTab();
		
	}
	
	@Test(priority = 5, description="Verify Pay Bills Menu....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and open paybills menu...")	
	@Story("user should be able to see and open paybills menu...") 
	public void veriyPayBillsOverviewTabTest() throws Exception {
		dashboardPage.veriyPayBillsOverviewTab();
		
	}
	
	@Test(priority = 6, description="Verify Bills Menu under Pay Bills....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and open bills  menu under Pay Bills...")	
	@Story("user should be able to see and open bills  menu under Pay Bills...") 
	public void veriyBillsMenuTabTest() throws Exception {
		dashboardPage.veriyBillsMenuTab();
		
	}
	
	@Test(priority = 7, description="Verify Vendor Menu under Pay Bills....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne vendor  menu under Pay Bills...")	
	@Story("user should be able to see and opne vendor  menu under Pay Bills...") 
	public void veriyVendorMenuTabTest() throws Exception {
		dashboardPage.veriyVendorMenuTab();
		
	}
	
	@Test(priority = 8, description="Verify transaction Menu under Pay Bills....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne transaction  menu under Pay Bills...")	
	@Story("user should be able to see and opne transaction  menu under Pay Bills...") 
	public void veriyPayBillsTransactionMenuTabTest() throws Exception {
		dashboardPage.veriyPayBillsTransactionMenuTab();
		
	}
	
	@Test(priority = 9, description="Verify reports Menu under Pay Bills....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne reports  menu under Pay Bills...")	
	@Story("user should be able to see and opne reports  menu under Pay Bills...") 
	public void veriyPayBillsReportMenuTabTest() throws Exception {
		dashboardPage.veriyPayBillsReportMenuTab();
		
	}
	
	@Test(priority = 10, description="Verify Overview Menu under Sales....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne Overview  menu under Sales...")	
	@Story("user should be able to see and opne Overview  menu under Sales...") 
	public void veriySalesOverviewTabTest() throws Exception {
		dashboardPage.veriySalesOverviewTab();
		
	}
	
	@Test(priority = 11, description="Verify Customer Menu under Sales....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne Customer  menu under Sales...")	
	@Story("user should be able to see and opne Customer  menu under Sales...") 
	public void veriyCustomerTabTest() throws Exception {
		dashboardPage.veriyCustomerTab();
		
	}
	
	@Test(priority = 12, description="Verify Invoice Menu under Sales....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne Invoice  menu under Sales...")	
	@Story("user should be able to see and opne Invoice  menu under Sales...") 
	public void veriyInvoiceMenuTabTest() throws Exception {
		dashboardPage.veriyInvoiceMenuTab();
		
	}
	
	
	@Test(priority = 13, description="Verify Transaction Menu under Sales....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne Transaction  menu under Sales...")	
	@Story("user should be able to see and opne Transaction  menu under Sales...") 
	public void veriySalesTransactiomTabTest() throws Exception {
		dashboardPage.veriySalesTransactiomTab();
		
	}
	
	
	@Test(priority = 14, description="Verify Reports Menu under Sales....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see and opne Reports  menu under Sales...")	
	@Story("user should be able to see and opne Reports  menu under Sales...") 
	public void veriySalesReportTabTest() throws Exception {
		dashboardPage.veriySalesReportTab();
		
	}
	
		@AfterTest
	public void quitBrowser() {
		driver.quit();
	
	}

}
