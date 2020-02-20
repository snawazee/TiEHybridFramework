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
import com.tie.Pages.DashboardPage;
import com.tie.Pages.LoginPage;
import com.tie.util.Constants;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(ExtentReportListener.class)
@Epic("Regression Test")
@Feature("Login Page Test")
@Listeners(TestAllureListener.class)
public class LoginPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	DashboardPage dashboardPage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

	}
	
	@Test(priority = 1, description="verifying login page title")
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
	
	
	@Test(priority = 2, description="Check logo is persent or not?")
	@Severity(SeverityLevel.NORMAL)
	@Description("verify logo test...")	
	@Story("user should be able to see logo on login page.") 
	public void TiELogoTest(){
		Reporter.log("Test started--> "+ "verifyLogoTest" +"\n" );
		boolean flag = loginPage.ValidateLogo();
		Assert.assertTrue(flag);
		Reporter.log("Test ended--> "+ "verifyLogoTest" );
	}
	

	@Test(priority = 3, description="verifying signup link is Available on Login Page.")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see signup link...")	
	@Story("user should be able to see signup link...") 
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.isSignUpLinkExists());
	}
	
	
	@Test(priority = 4, description="verifying forgot password link is Available on Login Page.")
	@Severity(SeverityLevel.BLOCKER)
	@Description("user should be able to see forgot password link...")	
	@Story("user should be able to see forgot password link...") 
	public void verifyisForgotPasswordExistsTest() {
		Assert.assertTrue(loginPage.isForgotPasswordExists());
	}
	
	@Test(priority = 5, description="verifying Tearm And Service link is Available on Login Page.")
	@Severity(SeverityLevel.MINOR)
	@Description("user should be able to see Tearm And Service link...")	
	@Story("Story Name:check login page user should be able to see Tearm And Service link...") 
	public void VerifyTearmAndServiceLinkExistsTest() {
		Assert.assertTrue(loginPage.isTearmAndServiceLinkExists());
	}
	
	@Test(priority = 6, description="verifying Privacy Policy link is Available on Login Page.")
	@Severity(SeverityLevel.MINOR)
	@Description("Story Name:check login page user should be able to see Privacy Policy link...")	
	@Story("Story Name:check login page user should be able to see Privacy Policy link...") 
	public void verifyisPrivacyPolicyLinkExistsTest() {
		Assert.assertTrue(loginPage.isPrivacyPolicyLinkExists());
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
	
	
	@Test(priority = 10, description="To check that the forgot password link redirected to the forgot password page.")
	@Severity(SeverityLevel.BLOCKER)
	@Description("To check whether the link has sent to the mail to which the user has provided")	
	@Story("To check whether the user enters the new password and retype the password both should match until "
			+ "new password should not be set") 
	public void doPasswordResetTest() throws Exception {
		loginPage.doPasswordReset();
	}
	
	@Link ("url: https://app.dev.tieaccounting.com")
	@Test(priority = 11, description="Verify that User is able to Login with Valid Credentials")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify that User is able to Login with Valid Credentials")	
	@Story("Verify if a user will be able to login with a valid username and valid password.") 
	public void verifyLoginTest() throws Exception {
		dashboardPage = loginPage.doLogin(prop.getProperty("BO_UserName"), prop.getProperty("BO_Password"));
		
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}
