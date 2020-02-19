package com.tie.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.tie.Base.BasePage;
import com.tie.util.TestUtil;

import io.qameta.allure.Step;

	public class InvoicePage extends BasePage {
		WebDriver driver;
		TestUtil TestUtil;

		By SalesMenu = By.xpath("//div[@class='nav-link checkActive']");
		By InvoiceSubMenu = By.xpath("//div[@class='sub-nav-link posRelative']");
		
		By CustDropDown =By.xpath("//select[@id='id1']");
		By StartDate = By.xpath("//span[@class='fa fa-calendar text-primary calendarIcon']");
		By EndDate = By.xpath("//span[@class='fa fa-calendar calendarIcon text-primary']");
		By SearchBtn = By.xpath("(//button[contains(.,'Search')])[2]");
		
		By AddInvoiceBtn =By.xpath("//span[@class='newCustBtn']");
		By SalesPerson =By.xpath("//input[@name='salesPerson']");
		By Description = By.xpath("//input[@placeholder='Description']");
		By ItemTextBox= By.xpath("//input[@class='form-control border-dashed ng-pristine ng-valid ng-touched']");
		By ItemAddBtn = By.xpath("//p[contains(.,'Add Item')]')");
		By AddItemBtn = By.xpath("(//button[@type='button'])[1]");
		By SaveBtn = By.xpath("//button[contains(.,'Save')]");
		By ItemNametextBox= By.xpath("//input[@name='itemName']");
		By PriceTextBox= By.xpath("//input[@name='price']");
		By TaxableChekBox = By.cssSelector("[for='taxable']");
		By ProductRadioBtn= By.xpath("//label[@for='product']");
		By ItemSaveBtn=By.xpath("//button[@type='submit']");
		
		
		public InvoicePage(WebDriver driver) {
			this.driver = driver;
			TestUtil = new TestUtil(driver);
		}
			
		@Step("Creating Invoice......")
		public void createInvoice() throws Exception {
			TestUtil.doClick(SalesMenu);
			TestUtil.doClick(InvoiceSubMenu);
			Thread.sleep(2000);
			TestUtil.doClick(AddInvoiceBtn);
			Select custName = new Select(driver.findElement(By.id("customerId")));
			custName.selectByIndex(1);
			TestUtil.doSendKeys(SalesPerson, "Safdar Nawaz");
			TestUtil.doClick(ItemTextBox);
			TestUtil.doClick(ItemAddBtn);
			TestUtil.doClick(ItemNametextBox);
			TestUtil.doSendKeys(PriceTextBox, "1000");
			TestUtil.doClick(TaxableChekBox);
			TestUtil.doClick(ProductRadioBtn);
			TestUtil.doClick(ItemSaveBtn);
			TestUtil.doSendKeys(Description, "Testing Descriptions");
			TestUtil.doClick(AddItemBtn);
			Thread.sleep(1000);
			TestUtil.doClick(SaveBtn);
			
			
		
			
			
			
			
		
	}

}
