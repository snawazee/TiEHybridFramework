package com.qa.tie.Tests;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.tie.Base.BasePage;
import com.qa.tie.Page.DashboardPage;
import com.qa.tie.Page.LoginPage;
import com.qa.tie.Page.MyAccountPage;
import com.qa.tie.Util.AppConstants;
import com.qa.tie.Util.Credentials;
import com.qa.tie.Util.ExcelUtil;



public class MyAccountPageTest {

	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	MyAccountPage myAccountPage;
	Credentials userCred;


	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = loginPage.doLogin(userCred);
		myAccountPage = dashboardPage.goToMyAccountPage();
	}


	@DataProvider
	public Object[][] getCompanyTestData() {
		Object[][] data = ExcelUtil.getTestData(AppConstants.COMPANY_SHEET_NAME);
		return data;
	}

	@Test(priority = 1, dataProvider = "getCompanyTestData")
	public void createComapnyTest(String companyName , String email, String phoneNo, String address, String city, String zipCode, String contactName, 
			String fullAddress ) throws Exception {
		myAccountPage.createNewCompany( companyName ,  email,  phoneNo,  address,  city,  zipCode,  contactName, fullAddress );
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}