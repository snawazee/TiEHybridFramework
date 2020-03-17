package com.qa.tie.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.tie.base.BasePage;
import com.qa.tie.util.AppConstants;
import com.qa.tie.util.Credentials;
import com.qa.tie.util.ElementUtil;
import com.qa.tie.util.JavaScriptUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;
//====================================================================================================================
	// 1. locators - By
	By emailId = By.id("emailId");
	By password = By.xpath("//input[@id='passId']");
	By loginButton = By.id("loginBtnId");
	By signUpLink = By.xpath("//p[@id='signUpId']");
	By loginErrorText = By.xpath("//div[contains(@class,'errorMsg_bottom')]");
	By logo = By.id("logoId");
	By emailID = By.id("emailId");
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

 
//===================================================================================================================	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	// page actions:
	public String getPageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.LOGIN_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}
	
	public String getPageTitleUsingJS(){
		return jsUtil.getTitleByJS();
	}
	
	
	@Step("checking logo is present or not....")
	public boolean LogoExist(){
		return elementUtil.doIsDisplayed(logo);
	}

	
	public boolean isSignUpLinkExist() {
		elementUtil.waitForElementPresent(signUpLink);
		return elementUtil.doIsDisplayed(signUpLink);
	}
	
	@Step("checking tesrms and condition  is present or not....")
	public boolean isTermsConditionyLinkExists() {
		elementUtil.waitForElementPresent(tesrmsandService);
		return elementUtil.doIsDisplayed(tesrmsandService);
	}
	
	@Step("checking privacy policy is present or not....")
	public boolean isPrivacyPolicyLinkExists() {
		elementUtil.waitForElementPresent(privacyPolicy);
		return elementUtil.doIsDisplayed(privacyPolicy);
	}

	
	@Step("checking Reset password is present or not....")
	public boolean isResetPassLinkExists() {
		elementUtil.waitForElementPresent(resetPass);
		return elementUtil.doIsDisplayed(resetPass);
	}
	
	
	@Step("checking forgot password is present or not....")
	public LoginPage doPasswordReset() throws Exception {
		elementUtil.doClick(forgotPassword);
		//elementUtil.waitForElementPresent(forgotPassword);
		elementUtil.doSendKeys(forgotPassEmail, "snawazee@gmail.com");
		elementUtil.doClick(passResetBtn);
		elementUtil.doSendKeys(resetPass, "dipl@1234");
		elementUtil.doSendKeys(resetconfirmPass, "dipl@1234");
		Thread.sleep(30000);
		elementUtil.doClick(savePassword);
		elementUtil.doBackNavigate();
		return new LoginPage(driver);
		
	}
	
	@Step("checking register with business account....")
	public LoginPage registerWithBusinessAccount() {
		elementUtil.doClick(signUpLink);
		elementUtil.doClick(businessOwnerBtn);
		elementUtil.doSendKeys(fullname, "Safdar Nawaz");
		elementUtil.doSendKeys(phone, "9931333088");
		elementUtil.doSendKeys(email, "snawazee11@gmail.com");
		elementUtil.doSendKeys(pass, "dipl@1234");
		elementUtil.doSendKeys(confirmPass, "dipl@1234");
		elementUtil.doClick(iAgreeeCheckBox);
		elementUtil.doClick(registerBtn);
		elementUtil.doBackNavigate();
		return new LoginPage(driver);


	}
	
	@Step("checking register with Accountant User....")
	public LoginPage registerWithAccountantUser() {
		elementUtil.doClick(signUpLink);
		elementUtil.doClick(AccountantUserBtn);
		elementUtil.doSendKeys(fullname, "Safdar Nawaz");
		elementUtil.doSendKeys(phone, "9931333088");
		elementUtil.doSendKeys(email, "snawazee22@gmail.com");
		elementUtil.doSendKeys(pass, "dipl@1234");
		elementUtil.doSendKeys(confirmPass, "dipl@1234");
		elementUtil.doClick(iAgreeeCheckBox);
		elementUtil.doClick(registerBtn);
		elementUtil.doBackNavigate();
		return new LoginPage(driver);

	}
	
	
	@Step("checking register with Owner Assistant....")
	public LoginPage registerWithOwnerAssistant() {
		elementUtil.doClick(signUpLink);
		elementUtil.doClick(ownerAssisistantBtn);
		elementUtil.doSendKeys(fullname, "Safdar Nawaz");
		elementUtil.doSendKeys(phone, "9931333088");
		elementUtil.doSendKeys(email, "snawazee33@gmail.com");
		elementUtil.doSendKeys(pass, "dipl@1234");
		elementUtil.doSendKeys(confirmPass, "dipl@1234");
		elementUtil.doClick(iAgreeeCheckBox);
		elementUtil.doClick(registerBtn);
		elementUtil.doBackNavigate();
		return new LoginPage(driver);

	}
	
	
	public DashboardPage doLogin(Credentials userCred) {
		elementUtil.waitForElementPresent(emailId);
		elementUtil.doSendKeys(emailId, userCred.getAppUsername());
		elementUtil.doSendKeys(password, userCred.getAppPassword());
		elementUtil.doClick(loginButton);
		return new DashboardPage(driver);
	}
	
	public boolean checkLoginErrorMesg(){
		return elementUtil.doIsDisplayed(loginErrorText);
	}

}
