package com.qa.tie.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.tie.base.BasePage;
import com.qa.tie.page.HomePage;
import com.qa.tie.page.InvoicePage;
import com.qa.tie.page.LoginPage;
import com.qa.tie.util.Credentials;


import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Epic("Epic - 102 : Invoice Page features")
@Feature("US - 502 : invoice ")
public class InvoicePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	Credentials userCred;
	InvoicePage invoicePage;

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
		homePage = loginPage.doLogin(userCred);
	}
		
		
	@Test(priority = 1)
	public void verifyAllSubMenuClickkableTest() throws Exception{
			invoicePage.verifyAllSubMenuClickkable();
	}
	
	@Test(priority = 2)
	public void FilterInvoiceWithCustomerTest() throws Exception{
			invoicePage.FilterInvoiceWithCustomer();
	}
	
	@Test(priority = 3)
	public void verifyAllHeaderTest() throws Exception{
			invoicePage.verifyAllHeader();
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
}