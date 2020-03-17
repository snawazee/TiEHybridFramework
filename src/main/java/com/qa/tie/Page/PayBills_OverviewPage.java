package com.qa.tie.Page;
import org.openqa.selenium.WebDriver;

import com.qa.tie.Base.BasePage;
import com.qa.tie.Util.AppConstants;
import com.qa.tie.Util.ElementUtil;


public class PayBills_OverviewPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;


	public PayBills_OverviewPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	public String getCustomerPageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.PAYBILLSOVERVIEW_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}
}