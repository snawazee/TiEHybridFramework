package com.qa.tie.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.tie.base.BasePage;
import com.qa.tie.page.InvoicePage;
import com.qa.tie.page.HomePage;
import com.qa.tie.page.LoginPage;
import com.qa.tie.util.AppConstants;
import com.qa.tie.util.Credentials;
import com.qa.tie.util.ExcelUtil;


public class InvoicePageTest {

	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	InvoicePage invoicePage;
	Credentials userCred;


	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.doLogin(userCred);
		invoicePage = homePage.goToInvoicePage();
	}

	@Test(priority = 1)
	public void verifyContactsPageTitle() {
		String title = invoicePage.getContactsPageTitle();
		System.out.println("contacts page title is: " + title);
		Assert.assertEquals(title, "Contacts");
	}

	@DataProvider
	public Object[][] getContactsTestData() {
		Object[][] data = ExcelUtil.getTestData(AppConstants.CONTACTS_SHEET_NAME);
		return data;
	}

	@Test(priority = 2, dataProvider = "getContactsTestData")
	public void createContactsTest(String email, String firstName, String lastName, String jobTitle) {
		invoicePage.createNewContact(email, firstName, lastName, jobTitle);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
