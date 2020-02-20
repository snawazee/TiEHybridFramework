package com.tie.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.tie.Base.BasePage;
import com.tie.util.Constants;
import com.tie.util.TestUtil;

import io.qameta.allure.Step;
public class LoginPage extends BasePage {

	WebDriver driver;
	TestUtil TestUtil;

	// 1. Page Objects / By Locators
	By logo = By.id("logoId");
	By emailID = By.id("emailId");
	By password = By.xpath("//input[@id='passId']");
	By loginButton = By.id("loginBtnId");
	By signUpLink = By.xpath("//p[@id='signUpId']");
	By forgotPassword = By.id("resetPassId");
	By tesrmsandService = By.id("termsId");
	By privacyPolicy = By.id("privacyId");
	By businessOwnerBtn = By.xpath("//button[contains(.,'Business Owner')]");
	By AccountantUserBtn = By.xpath("//button[contains(.,'Accountant')]");
	By ownerAssisistantBtn = By.xpath("//button[contains(.,'Owner Assistant')]");
	By goToLoginScreenBtn = By.xpath("//span[contains(.,'Go to Login screen')]");
	By fullname = By.name("fullName");
	By phone = By.xpath("//input[@name='phone']");
	By email = By.xpath("//input[@name='email']");
	By pass=By.xpath("//input[@name='password']");
	By confirmPass= By.xpath("//input[@name='password_confirm']");
	By iAgreeeCheckBox = By.xpath("//span[@class='checkmark']");
	By registerBtn= By.xpath("//button[contains(.,'Register')]");
	By forgotPassEmail= By.xpath("//input[@type='email']");
	By passResetBtn = By.xpath("//button[contains(.,'Submit')]");
	By goToLoginScreen = By.xpath("//div[@class='font_lightblue text-center'][contains(.,'Go to Login screen')]");
	By resetPass = By.xpath("(//input[@name='password'])[1]");
	By resetconfirmPass = By.xpath("(//input[@type='password'])[2]");
	By savePassword = By.xpath("//button[contains(.,'Save Password')]");
	By closeBtn = By.xpath("//img[@alt='closeBtn']");
	



	public LoginPage(WebDriver driver) {
		this.driver = driver;
		TestUtil = new TestUtil(driver);
	}

	@Step("get login page title....")
	public String getLoginPageTitle() {
		TestUtil.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
		return TestUtil.doGetTitle();
	}

	@Step("checking logo is present or not....")
	public boolean ValidateLogo(){
		return TestUtil.doIsDisplayed(logo);
	}
	
	@Step("checking sigup link is present or not....")
	public boolean isSignUpLinkExists() {
		return TestUtil.doIsDisplayed(signUpLink);
		
	}
	
	@Step("checking tearm and service is present or not....")
	public boolean isTearmAndServiceLinkExists() {
		return TestUtil.doIsDisplayed(tesrmsandService);
	}
	
	@Step("checking tearm and service is present or not....")
	public void verifytermsAndService() {
		TestUtil.doClick(tesrmsandService);
		TestUtil.scrollPageDown(driver);
		TestUtil.doClick(closeBtn);
	}
	
	@Step("checking privacy policy is present or not....")
	public boolean isPrivacyPolicyLinkExists() {
		return TestUtil.doIsDisplayed(privacyPolicy);
	}
	
	@Step("checking register with business account....")
	public LoginPage registerWithBusinessAccount() {
		TestUtil.doClick(signUpLink);
		TestUtil.doClick(businessOwnerBtn);
		TestUtil.doSendKeys(fullname, "Safdar Nawaz");
		TestUtil.doSendKeys(phone, "9931333088");
		TestUtil.doSendKeys(email, "snawazee11@gmail.com");
		TestUtil.doSendKeys(pass, "dipl@1234");
		TestUtil.doSendKeys(confirmPass, "dipl@1234");
		TestUtil.doClick(iAgreeeCheckBox);
		TestUtil.doClick(registerBtn);
		TestUtil.doBackNavigate();
		return new LoginPage(driver);


	}
	
	@Step("checking register with Accountant User....")
	public LoginPage registerWithAccountantUser() {
		TestUtil.doClick(signUpLink);
		TestUtil.doClick(AccountantUserBtn);
		TestUtil.doSendKeys(fullname, "Safdar Nawaz");
		TestUtil.doSendKeys(phone, "9931333088");
		TestUtil.doSendKeys(email, "snawazee22@gmail.com");
		TestUtil.doSendKeys(pass, "dipl@1234");
		TestUtil.doSendKeys(confirmPass, "dipl@1234");
		TestUtil.doClick(iAgreeeCheckBox);
		TestUtil.doClick(registerBtn);
		TestUtil.doBackNavigate();
		return new LoginPage(driver);

	}
	
	
	@Step("checking register with Owner Assistant....")
	public LoginPage registerWithOwnerAssistant() {
		TestUtil.doClick(signUpLink);
		TestUtil.doClick(ownerAssisistantBtn);
		TestUtil.doSendKeys(fullname, "Safdar Nawaz");
		TestUtil.doSendKeys(phone, "9931333088");
		TestUtil.doSendKeys(email, "snawazee33@gmail.com");
		TestUtil.doSendKeys(pass, "dipl@1234");
		TestUtil.doSendKeys(confirmPass, "dipl@1234");
		TestUtil.doClick(iAgreeeCheckBox);
		TestUtil.doClick(registerBtn);
		TestUtil.doBackNavigate();
		return new LoginPage(driver);

	}
	
	@Step("checking forgot password is present or not....")
	public boolean isForgotPasswordExists() {
		return TestUtil.doIsDisplayed(forgotPassword);
	}

	@Step("checking forgot password is present or not....")
	public LoginPage doPasswordReset() throws Exception {
		TestUtil.doClick(forgotPassword);
		TestUtil.doSendKeys(forgotPassEmail, "snawazee@gmail.com");
		TestUtil.doClick(passResetBtn);
		TestUtil.doSendKeys(resetPass, "dipl@1234");
		TestUtil.doSendKeys(resetconfirmPass, "dipl@1234");
		Thread.sleep(30000);
		TestUtil.doClick(savePassword);
		TestUtil.doBackNavigate();
		return new LoginPage(driver);
		
	}
	
	@Step("login with {0} and {1}")
	public DashboardPage doLogin(String username, String pwd) {
		TestUtil.doSendKeys(emailID, username);
		TestUtil.doSendKeys(password, pwd);
		TestUtil.doClick(loginButton);

		return new DashboardPage(driver);

	}

}
