package com.tie.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.tie.Base.BasePage;
import com.tie.util.TestUtil;

public class DashboardPage extends BasePage {
	WebDriver driver;
	TestUtil TestUtil;

	By header = By.xpath("//div[@class='client-name-section']");
	By CompanyName = By.xpath("//div[@class='client-name-section']");
	By MyAccount = By.xpath("li>a#nav-primary-home");
	By AccountName = By.xpath("//div[contains(@class,'basic-info_name')]");
	By SalesParentTab = By.xpath("//div[@class='nav-link']");
	By PayBillsParentTab = By.xpath("(//div[contains(.,'PAYBILLS')])[10]");
	By InvoiceMenu = By.xpath("(//div[contains(.,'INVOICES')])[7]");
	By PayBillsOverview = By.xpath("(//div[@class='sub-nav-link'])[1]");
	By SalesOverview = By.xpath("(//div[@class='sub-nav-link'])[1]");
	By Customer = By.xpath("(//div[@class='sub-nav-link'])[2]");
	By SalesTransactiom = By.xpath("(//div[@class='sub-nav-link'])[3]");
	By SalesReport = By.xpath("(//div[@class='sub-nav-link'])[4]");
	By PayBillsButton = By.xpath("//div[@class='nav-dropdown']/div[contains(.,'TRANSACTIONS')]");
	By VendorMenu =By.xpath("(//div[@class='sub-nav-link'])[3]");
	By PayBillsTransactionMenu = By.xpath("(//div[@class='sub-nav-link'])[4]");
	By PayBillsReportMenu =By.xpath("(//div[contains(.,'REPORTS')])[7]");
	By BillsMenu =By.xpath("//div[@class='nav-dropdown']/div[contains(.,'BILLS')]");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		TestUtil = new TestUtil(driver);
		TestUtil.waitForElementPresent(header);

	}


	public boolean verifySalesParentTab() {
		return TestUtil.doIsDisplayed(SalesParentTab);
	}
	
	public boolean verifyPayBillsParentTab() {
		return TestUtil.doIsDisplayed(PayBillsParentTab);
	}

	public boolean verifyPayBillsButton() {
		return TestUtil.doIsDisplayed(PayBillsButton);
	}
	
	public boolean verifyCompanytName() {
		return TestUtil.doIsDisplayed(CompanyName);
	}

	public boolean verifyLoggedAccountName() throws Exception {
		TestUtil.doClick(MyAccount);
		Thread.sleep(2000);
		return TestUtil.doIsDisplayed(AccountName);
	}
	
	
	public void veriyPayBillsOverviewTab() throws Exception{
		TestUtil.doClick(PayBillsParentTab);
		Thread.sleep(2000);
		TestUtil.doClick(PayBillsOverview);
	}
	
	public void veriyBillsMenuTab() throws Exception{
		TestUtil.doClick(PayBillsParentTab);
		Thread.sleep(2000);
		TestUtil.doClick(BillsMenu);
	}

	public void veriyVendorMenuTab() throws Exception{
		TestUtil.doClick(PayBillsParentTab);
		Thread.sleep(2000);
		TestUtil.doClick(VendorMenu);
	}
	public void veriyPayBillsTransactionMenuTab() throws Exception{
		TestUtil.doClick(PayBillsParentTab);
		Thread.sleep(2000);
		TestUtil.doClick(PayBillsTransactionMenu);
	}
	public void veriyPayBillsReportMenuTab() throws Exception{
		TestUtil.doClick(PayBillsParentTab);
		Thread.sleep(2000);
		TestUtil.doClick(PayBillsReportMenu);
	}
	
	public void veriySalesOverviewTab() throws Exception{
		TestUtil.doClick(SalesParentTab);
		Thread.sleep(2000);
		TestUtil.doClick(SalesOverview);
	}
	
	
	public void veriyCustomerTab() throws Exception{
		TestUtil.doClick(SalesParentTab);
		Thread.sleep(2000);
		TestUtil.doClick(Customer);
	}
	
	
	public void veriyInvoiceMenuTab() throws Exception{
		TestUtil.doClick(SalesParentTab);
		Thread.sleep(2000);
		TestUtil.doClick(InvoiceMenu);
	}
	
	
	public void veriySalesTransactiomTab() throws Exception{
		TestUtil.doClick(SalesParentTab);
		Thread.sleep(2000);
		TestUtil.doClick(SalesTransactiom);
	}
	
	
	public void veriySalesReportTab() throws Exception{
		TestUtil.doClick(SalesParentTab);
		Thread.sleep(2000);
		TestUtil.doClick(SalesReport);
	}
	
}
