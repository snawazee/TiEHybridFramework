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
	By MyAccount= By.xpath("//span[contains(.,'MY ACCOUNT')]");
	By AddCompany =By.xpath("//span[contains(.,'Add Company')]");

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
		Thread.sleep(500);
		elementUtil.doClick(PayBillsOverview);
		Thread.sleep(2000);
	}
	
	public void veriyBillsMenuTab() throws Exception{
		elementUtil.doClick(PayBillsMenu);
		Thread.sleep(500);
		elementUtil.doClick(BillsMenu);
		Thread.sleep(2000);
	}

	public void veriyVendorMenuTab() throws Exception{
		elementUtil.doClick(PayBillsMenu);
		Thread.sleep(500);
		elementUtil.doClick(VendorMenu);
		Thread.sleep(2000);
	}
	public void veriyPayBillsTransactionMenuTab() throws Exception{
		elementUtil.doClick(PayBillsMenu);
		Thread.sleep(500);
		elementUtil.doClick(PayBillsTransactionMenu);
		Thread.sleep(2000);
	}
	public void veriyPayBillsReportMenuTab() throws Exception{
		elementUtil.doClick(PayBillsMenu);
		Thread.sleep(500);
		elementUtil.doClick(PayBillsReport);
		Thread.sleep(500);
	}
	
	public void veriySalesOverviewTab() throws Exception{
		elementUtil.doClick(SalesMenu);
		Thread.sleep(500);
		elementUtil.doClick(SalesOverview);
		Thread.sleep(500);
	}
	
	public void veriyCustomerTab() throws Exception{
		elementUtil.doClick(SalesMenu);
		Thread.sleep(500);
		elementUtil.doClick(Customer);
		Thread.sleep(500);
	}
	
	public void verifyInvoiceMenu() throws Exception{
		elementUtil.doClick(SalesMenu);
		Thread.sleep(500);
		elementUtil.doClick(InvoiceMenu);
		Thread.sleep(2000);
	}
	
	public void veriySalesTransactiomTab() throws Exception{
		elementUtil.doClick(SalesMenu);
		Thread.sleep(500);
		elementUtil.doClick(SalesTransactiom);
		Thread.sleep(2000);
	}
	
	public void veriySalesReportTab() throws Exception{
		elementUtil.doClick(SalesMenu);
		Thread.sleep(500);
		elementUtil.doClick(SalesReport);
		Thread.sleep(2000);
	}
	
	public void clickOnSalesMenu() {
		elementUtil.waitForElementPresent(SalesMenu);
		elementUtil.doClick(SalesMenu);
		elementUtil.waitForElementPresent(InvoiceMenu);
		elementUtil.doClick(InvoiceMenu);
		
	}
	
	public void clickOnMyAccountMenu() {
		elementUtil.waitForElementPresent(MyAccount);
		elementUtil.doClick(MyAccount);
		elementUtil.waitForElementPresent(AddCompany);
		elementUtil.doClick(AddCompany);
		
	}
	
	public MyAccountPage goToMyAccountPage() {
		clickOnMyAccountMenu();
		return new MyAccountPage(driver);
	}

}
