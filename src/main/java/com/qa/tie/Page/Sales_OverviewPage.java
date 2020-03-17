package com.qa.tie.Page;
import org.openqa.selenium.WebDriver;

import com.qa.tie.Base.BasePage;
import com.qa.tie.Util.AppConstants;
import com.qa.tie.Util.ElementUtil;


public class Sales_OverviewPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;


	public Sales_OverviewPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	public String getCustomerPageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.CUSTOMER_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}
}