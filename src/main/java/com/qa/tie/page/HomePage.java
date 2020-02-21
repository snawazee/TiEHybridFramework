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
	
	By SalesMenu = By.id("salestabId");
	By PayBillsMenu = By.id("payTabId");
	By PayBillsBtn=By.xpath("//button[@class='pay-blueBtn']");
	
	By PayBillsOverview = By.id("ovrwId");
	By BillsMenu =By.id("billsId");
	By VendorMenu =By.id("vendorId");
	By PayBillsTransactionMenu = By.id("transId");
	By PayBillsReport = By.id("reportsId");
	
	
	By SalesOverview = By.id("salesTabOvrvwId");
	By Customer = By.id("custId");
	By InvoiceMenu = By.id("InvId");
	By SalesTransactiom = By.id("salesTransId");
	By SalesReport = By.id("salesTabReportsId");
	By PayBillsButton = By.xpath("//div[@class='nav-dropdown']/div[contains(.,'TRANSACTIONS')]");

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

	public boolean verifySalesMenu() {
		return elementUtil.doIsDisplayed(SalesMenu);
	}
	
	public boolean verifyPayBillsMenu() {
		return elementUtil.doIsDisplayed(PayBillsMenu);
	}

	public boolean verifyPayBillsBtn() {
		return elementUtil.doIsDisplayed(PayBillsBtn);
	}
	
	
	public void veriyPayBillsOverviewTab() throws Exception{
		elementUtil.doClick(PayBillsMenu);
		Thread.sleep(2000);
		elementUtil.doClick(PayBillsOverview);
	}
	
	public void veriyBillsMenuTab() throws Exception{
		elementUtil.doClick(PayBillsMenu);
		Thread.sleep(2000);
		elementUtil.doClick(BillsMenu);
	}

	public void veriyVendorMenuTab() throws Exception{
		elementUtil.doClick(PayBillsMenu);
		Thread.sleep(2000);
		elementUtil.doClick(VendorMenu);
	}
	public void veriyPayBillsTransactionMenuTab() throws Exception{
		elementUtil.doClick(PayBillsMenu);
		Thread.sleep(2000);
		elementUtil.doClick(PayBillsTransactionMenu);
	}
	public void veriyPayBillsReportMenuTab() throws Exception{
		elementUtil.doClick(PayBillsMenu);
		Thread.sleep(2000);
		elementUtil.doClick(PayBillsReport);
	}
	
	public void veriySalesOverviewTab() throws Exception{
		elementUtil.doClick(SalesMenu);
		Thread.sleep(2000);
		elementUtil.doClick(SalesOverview);
	}
	
	
	public void veriyCustomerTab() throws Exception{
		elementUtil.doClick(SalesMenu);
		Thread.sleep(2000);
		elementUtil.doClick(Customer);
	}
	
	
	public void verifyInvoiceMenu() throws Exception{
		elementUtil.doClick(SalesMenu);
		Thread.sleep(2000);
		elementUtil.doClick(InvoiceMenu);
	}
	
	public void veriySalesTransactiomTab() throws Exception{
		elementUtil.doClick(SalesMenu);
		Thread.sleep(2000);
		elementUtil.doClick(SalesTransactiom);
	}
	
	
	public void veriySalesReportTab() throws Exception{
		elementUtil.doClick(SalesMenu);
		Thread.sleep(2000);
		elementUtil.doClick(SalesReport);
	}
	
	
	public void clickOnSalesMenu() {
		elementUtil.waitForElementPresent(SalesMenu);
		elementUtil.doClick(SalesMenu);
		
		elementUtil.waitForElementPresent(InvoiceMenu);
		elementUtil.doClick(InvoiceMenu);
		
	}
	
	public InvoicePage goToInvoicePage() {
		clickOnSalesMenu();
		return new InvoicePage(driver);
	}

}
