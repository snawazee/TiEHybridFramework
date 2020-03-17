package com.qa.tie.tests;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.tie.base.BasePage;
import com.qa.tie.page.DashboardPage;
import com.qa.tie.page.LoginPage;
import com.qa.tie.page.MyAccountPage;
import com.qa.tie.util.AppConstants;
import com.qa.tie.util.Credentials;
import com.qa.tie.util.ExcelUtil;



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