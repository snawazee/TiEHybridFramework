package com.qa.tie.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.tie.base.BasePage;
import com.qa.tie.util.AppConstants;
import com.qa.tie.util.ElementUtil;

public class HomePage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;

	By header = By.xpath("//div[@class='client-name-section']");
	By accountName = By.xpath("//div[@class='client-name-section']");
	
	By mainContactsLink = By.id("nav-primary-contacts-branch");
	By childContactsLink = By.id("nav-secondary-contacts");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	public String getHomePageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.HOME_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}

	public String getHomePageHeader() {
		return elementUtil.doGetText(header);
	}

	public String getLoggedInUserAccountName() {
		return elementUtil.doGetText(accountName);
	}

	public void clickOnContacts() {
		elementUtil.waitForElementPresent(mainContactsLink);
		elementUtil.doClick(mainContactsLink);
		
		elementUtil.waitForElementPresent(childContactsLink);
		elementUtil.doClick(childContactsLink);
		
	}

	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}

}
