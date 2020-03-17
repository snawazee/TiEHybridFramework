package com.qa.tie.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.tie.base.BasePage;
import com.qa.tie.page.DashboardPage;
import com.qa.tie.page.LoginPage;
import com.qa.tie.util.AppConstants;
import com.qa.tie.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic - 101 : create login page features")
@Feature("US - 501 : create test for login page on hubspot")
public class LoginPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	Credentials userCred;

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
	}

	@Test(priority = 1, description = "verify login page title test.....!!!")
	@Description("verify LoginPage Title Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitleTest() throws InterruptedException {
		String title = loginPage.getPageTitle();
		System.out.println("login page title is : " + title);
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	
	@Test(priority = 2, description="Check logo is persent or not?")
	@Severity(SeverityLevel.NORMAL)
	@Description("verify logo test...")	
	@Story("user should be able to see logo on login page.") 
	public void TiELogoTest(){
		boolean flag = loginPage.LogoExist();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3, groups = "sanity", enabled=true)
	@Description("verify Sign up link Test....")
	@Severity(SeverityLevel.CRITICAL)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.isSignUpLinkExist());
	}
	
	@Test(priority = 4, groups = "sanity", enabled=true)
	@Description("verify Tearms and Condition link Test....")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyTermsAndConditionLinkTest() {
		Assert.assertTrue(loginPage.isTermsConditionyLinkExists());
	}
	
	@Test(priority = 5, groups = "sanity", enabled=true)
	@Description("verify Sign up link Test....")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyPrivacyPolicyLinkTest() {
		Assert.assertTrue(loginPage.isPrivacyPolicyLinkExists());
	}
	
	@Test(priority = 6, groups = "sanity", enabled=true)
	@Description("verify Sign up link Test....")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyResetPassLinkTest() {
		Assert.assertTrue(loginPage.isResetPassLinkExists());
	}
	
	
	@Test(priority = 7, description="User should be able to Register with Business Account....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify user should be able to Register with Business Account or Not?")	
	@Story("Check all required fields by entering the data and validating. Upon entering the all required fields "
			+ "User should be signed up, A successful registration message should be sent along with a mail.") 
	@Story("Check all required fields by not entering the data and (*) should be shown asking for mandatory field.") 
	public void VerifyregisterWithBusinessAccountTest() {
		loginPage.registerWithBusinessAccount();
	}
	
	@Test(priority = 8, description="User should be able to Register with Accountant User....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify user should be able to Register with Accountant User or Not?")	
	@Story("Check all required fields by entering the data and validating. Upon entering the all required fields "
			+ "User should be signed up, A successful registration message should be sent along with a mail.") 
	@Story("Check all required fields by not entering the data and (*) should be shown asking for mandatory field.")  
	public void VerifyregisterWithAccountantUserTest() {
		loginPage.registerWithAccountantUser();
	}
	
	
	@Test(priority = 9, description="User should be able to Register with Owner Assistant....")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify user should be able to Register with Owner Assistant User or Not?")	
	@Story("Check all required fields by entering the data and validating. Upon entering the all required fields "
			+ "User should be signed up, A successful registration message should be sent along with a mail.") 
	@Story("Check all required fields by not entering the data and (*) should be shown asking for mandatory field.") 
	public void VerifyregisterWithOwnerAssistantTest() {
		loginPage.registerWithOwnerAssistant();
	}
	

	
	@DataProvider
	public Object[][] getLoginInvaliData(){
		Object data[][] = { 
							{"test11111@gmail.com", "test123"},  
							{"test2@gmail.com", " "}, 
							{"  ", "test12345"}, 
							{"test", "test"},
							{" ", " "},
							{" ", "@#$%^@"}
						  };
		
		return data;
	}
	
	
	@Test(priority=10, dataProvider = "getLoginInvaliData", enabled=false)
	@Description("To check whether user should not able to login with invalid credentials....")
	public void login_InvalidTestCases(String username, String pwd){
		userCred.setAppUsername(username);
		userCred.setAppPassword(pwd);
		loginPage.doLogin(userCred);
		Assert.assertTrue(loginPage.checkLoginErrorMesg());
	}
	
	
	
	
	@Test(priority = 11, description="To check that the forgot password link redirected to the forgot password page.")
	@Severity(SeverityLevel.BLOCKER)
	@Description("To check whether the link has sent to the mail to which the user has provided")	
	@Story("To check whether the user enters the new password and retype the password both should match until "
			+ "new password should not be set") 
	public void doPasswordResetTest() throws Exception {
		loginPage.doPasswordReset();
	}

	@Test(priority = 12, enabled=true)
	@Description("verify Login Test....")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		DashboardPage dashboardPage = loginPage.doLogin(userCred);
		String accountName = dashboardPage.getLoggedInUserAccountName();
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
	@AfterTest(alwaysRun=false)
	public void tearDown() {
		driver.quit();
	}

}
