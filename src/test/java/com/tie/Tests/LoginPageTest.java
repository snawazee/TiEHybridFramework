package com.tie.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tie.Base.BasePage;
import com.tie.Listeners.TestAllureListener;
import com.tie.Pages.HomePage;
import com.tie.Pages.LoginPage;
import com.tie.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(ExtentReportListener.class)
@Epic("EPIC - Login screen is having fields to enter Username / Email Address and Password with Submit and/or Reset button.")
@Feature("US 1005: create a login page with title, header, reset password, sign up and login method")
@Listeners(TestAllureListener.class)
public class LoginPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

	}
	@Test(priority = 1, description="verifying lofin page title")
	@Severity(SeverityLevel.NORMAL)
	@Description("verify login page title test...")	
	@Story("Story Name:check login page title") 
	public void verifyLoginPageTitleTest() {
		Reporter.log("Test started--> "+ "verifyLoginPageTitleTest" +"\n" );
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is: " + title);
		Reporter.log("login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		Reporter.log("Test ended--> "+ "verifyLoginPageTitleTest" );

	}
	
	
	@Description("verify logo on login page test...")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2, enabled=true)
	public void TiELogoTest(){
		boolean flag = loginPage.ValidateLogo();
		Assert.assertTrue(flag);
	}
	

	@Description("verify sign up link test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.isSignUpLinkExists());
	}
	
	@Description("verify Forgot Password link test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4)
	public void verifyisForgotPasswordExistsTest() {
		Assert.assertTrue(loginPage.isForgotPasswordExists());
	}
	
	@Description("verify terms and service test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 5)
	public void VerifyTearmAndServiceLinkExistsTest() {
		Assert.assertTrue(loginPage.isTearmAndServiceLinkExists());
	}
	
	@Description("verify privacy policy test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 6)
	public void verifyisPrivacyPolicyLinkExistsTest() {
		Assert.assertTrue(loginPage.isPrivacyPolicyLinkExists());
	}
	
	
	@Description("verify register With Business Account test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 7)
	public void VerifyregisterWithBusinessAccountTest() {
		loginPage.registerWithBusinessAccount();
	}
	
	@Description("verify register With Accountant User test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 8)
	public void VerifyregisterWithAccountantUserTest() {
		loginPage.registerWithAccountantUser();
	}
	
	
	@Description("verify register With Owner Assistant test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 9)
	public void VerifyregisterWithOwnerAssistantTest() {
		loginPage.registerWithOwnerAssistant();
	}
	
	
	@Description("verify password reset test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 10)
	public void doPasswordResetTest() throws Exception {
		loginPage.doPasswordReset();
	}
	

	@Description("verify login feature test...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 11)
	public void verifyLoginTest() throws Exception {
		homePage = loginPage.doLogin(prop.getProperty("BO_UserName"), prop.getProperty("BO_Password"));
		Assert.assertTrue(homePage.verifyLoggedAccountName());
		Assert.assertEquals(homePage.verifyLoggedAccountName(), prop.getProperty("BO_AccountName"));
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}
