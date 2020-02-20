package com.tie.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tie.Base.BasePage;
import com.tie.Listeners.TestAllureListener;
import com.tie.Pages.DashboardPage;
import com.tie.Pages.InvoicePage;
import com.tie.Pages.LoginPage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;



@Epic("Regression Test")
@Feature("Invoice Page Test")
@Listeners(TestAllureListener.class)
public class InvoicePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	InvoicePage invoicePage;


	@BeforeTest
	@BeforeMethod
	public void setUp() throws Exception {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		dashboardPage = loginPage.doLogin(prop.getProperty("BO_UserName"), prop.getProperty("BO_Password"));
		//invoicePage = dashboardPage.goInvoicePage();
	}
		
		
	@Test(priority = 1)
	public void createInvoiceTest(){
			invoicePage.createInvoice();
	}
	
	
	
	
	
	
	
	/*
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
		
	}*/
}