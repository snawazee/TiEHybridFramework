package com.tie.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.tie.Base.BasePage;
import com.tie.Pages.HomePage;
import com.tie.Pages.InvoicePage;
import com.tie.Pages.LoginPage;

public class InvoicePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	InvoicePage invoicePage;
	
	//SoftAssert softAssert;

	@BeforeTest
	@BeforeMethod
	public void setUp() throws Exception {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("BO_UserName"), prop.getProperty("BO_Password"));
		invoicePage = homePage.goInvoicePage();
	}
		
		
	@Test(priority = 1)
	public void createInvoiceTest() throws Exception {
		invoicePage.createInvoice();
	}
		
	@AfterTest
	public void quitBrowser() {
		driver.quit();
		
	}
}