package com.qa.tie.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.tie.base.BasePage;
import com.qa.tie.util.ElementUtil;


import io.qameta.allure.Step;

	public class InvoicePage extends BasePage {
		WebDriver driver;
		ElementUtil elementUtil;

		By SalesParentTab = By.id("salestabId");
		By InvoiceMenu = By.id("InvId");
		By InvoicesubMenu = By.id("InvoicesubMenuId");
		By CustDropDown =By.id("custDropId1");
		By StatusDropDown= By.id("custStatusId1");
		By StartDate = By.id("startDateId1");
		By EndDate = By.id("startDateId1");
		By SearchBtn = By.id("allInvoiceSearchId1");
		
		
		
		//----
		
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
			elementUtil = new ElementUtil(driver);
		}
			
		@Step("Creating Invoice......")
		public void verifyAllSubMenuClickkable() throws Exception {
			elementUtil.doClick(InvoicesubMenu);
			List<WebElement> submenu= driver.findElements(By.xpath("(//div[@tabindex='0'])"));
			for(int i=0; i<submenu.size(); i++)
			{
				if(!(submenu.get(i).getText().isEmpty())) {
					submenu.get(i).click();
					submenu=driver.findElements(By.xpath("(//div[@tabindex='0'])"));
				}
			}
	
			
		}
		
		public void FilterInvoiceWithCustomer() throws Exception {
			
			elementUtil.doClick(InvoicesubMenu);
			Thread.sleep(2000);
			Select Customer = new Select(driver.findElement(By.id("custDropId1")));
			Customer.selectByIndex(1);
			Thread.sleep(500);
			elementUtil.doClick(SearchBtn);
		}
		
		public void verifyAllHeader() throws Exception {
			elementUtil.doClick(InvoicesubMenu);
			Thread.sleep(2000);
			List<WebElement> allHeadersOfTable= driver.findElements(By.xpath("//th[contains(.,'')]"));
			System.out.println("Headers in table are below:");
			System.out.println("Total headers found: "+allHeadersOfTable.size());
			for(WebElement header:allHeadersOfTable)
			{
				System.out.println(header.getText());
			}
			
		}
		
		
		
}
