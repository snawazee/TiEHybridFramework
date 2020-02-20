package com.tie.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.tie.Base.BasePage;
import com.tie.util.TestUtil;

public class DashboardPage extends BasePage {
	WebDriver driver;
	TestUtil TestUtil;

	
	By PayBillsParentTab = By.id("payTabId");
	By PayBillsOverview = By.id("ovrwId");
	By BillsMenu =By.id("billsId");
	By VendorMenu =By.id("vendorId");
	By PayBillsTransactionMenu = By.id("transId");
	By PayBillsReport = By.id("reportsId");
	////
	
	By SalesParentTab = By.id("salestabId");
	By SalesOverview = By.id("salesTabOvrvwId");
	By Customer = By.id("custId");
	By InvoiceMenu = By.id("InvId");
	By SalesTransactiom = By.id("salesTransId");
	By SalesReport = By.id("salesTabReportsId");
	By PayBillsButton = By.xpath("//div[@class='nav-dropdown']/div[contains(.,'TRANSACTIONS')]");
	

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		TestUtil = new TestUtil(driver);

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
		TestUtil.doClick(PayBillsReport);
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
