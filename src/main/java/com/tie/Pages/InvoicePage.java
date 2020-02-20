package com.tie.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.tie.Base.BasePage;
import com.tie.util.TestUtil;

import io.qameta.allure.Step;

	public class InvoicePage extends BasePage {
		WebDriver driver;
		TestUtil TestUtil;

		By SalesParentTab = By.xpath("//div[@class='nav-link']");
		By InvoiceMenu = By.xpath("(//div[contains(.,'INVOICES')])[7]");
		By CustDropDown =By.xpath("//select[@id='id1']");
		By StartDate = By.xpath("//span[@class='fa fa-calendar text-primary calendarIcon']");
		By EndDate = By.xpath("//span[@class='fa fa-calendar calendarIcon text-primary']");
		By SearchBtn = By.xpath("(//button[contains(.,'Search')])[2]");
		
		By AddInvoiceBtn =By.xpath("//span[@class='newCustBtn']");
		By SalesPerson =By.xpath("//input[@name='salesPerson']");
		By Description = By.xpath("//input[@placeholder='Description']");
		By ItemTextBox= By.xpath("[placeholder='Name']");
		By ItemAddBtn = By.xpath("//p[contains(.,'Add Item')]')");
		By AddItemBtn = By.xpath("(//button[@type='button'])[1]");
		By SaveBtn = By.xpath("//button[contains(.,'Save')]");
		By ItemNametextBox= By.xpath("//input[@name='itemName']");
		By PriceTextBox= By.xpath("//input[@name='price']");
		By TaxableChekBox = By.cssSelector("[for='taxable']");
		By ProductRadioBtn= By.xpath("//label[@for='product']");
		By ItemSaveBtn=By.xpath("//button[@type='submit']");
		By itemList=By.xpath("//li[contains(.,'Book')]");
		
		
		public InvoicePage(WebDriver driver) {
			this.driver = driver;
			TestUtil = new TestUtil(driver);
		}
			
		@Step("Creating Invoice......")
		public void createInvoice(){
			TestUtil.doClick(SalesParentTab);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TestUtil.doClick(InvoiceMenu);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TestUtil.doClick(AddInvoiceBtn);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select custName = new Select(driver.findElement(By.id("customerId")));
			custName.selectByIndex(1);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			
			TestUtil.doClick(ItemTextBox);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TestUtil.doClick(itemList);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TestUtil.doClick(AddItemBtn);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TestUtil.doClick(SaveBtn);
			
			
		
			
			
			
			
		
	}

}
