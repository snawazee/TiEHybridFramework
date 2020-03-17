package com.qa.tie.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.tie.Base.BasePage;
import com.qa.tie.Util.ElementUtil;
import com.qa.tie.Util.JavaScriptUtil;

import io.qameta.allure.Step;

public class MyAccountPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;

	By createContactButton = By.xpath("(//button[@type='button']//span[text()='Create contact'])[position()=1]");
	By createContactFormButton = By.xpath("(//button[@type='button']//span[text()='Create contact'])[position()=2]");

	By companyName = By.xpath("//input[@name='companyName']");
	By email = By.xpath("//input[@name='email']");
	By phoneNo = By.xpath("//input[@name='phone']");
	By address = By.xpath("//input[@name='address']");
	By city = By.xpath("//input[@name='city']");
	By zipCode = By.xpath("//input[@name='zip']");
	By contactName = By.xpath("//input[@name='contactName']");
	By fullAddress = By.xpath("//textarea[@name='contactAddress']");
	By saveBtn = By.xpath("//button[@class='btn btn-primary']");

	

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
		
	}


	@Step("Create new contact with {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}")
	public void createNewCompany(String cName , String mail, String mobile, String add, String CT, String zip, String contact, 
			String fullAdd ) throws Exception {
		//Thread.sleep(5000);
		//elementUtil.waitForElementPresent(createContactButton);
		//elementUtil.doClick(createContactButton);
		elementUtil.waitForElementPresent(companyName);
		elementUtil.doSendKeys(companyName, cName);
		elementUtil.doSendKeys(email, mail);
		elementUtil.doSendKeys(phoneNo, mobile);
		Thread.sleep(1000);
		Select merchantType = new Select(driver.findElement(By.xpath("//input[@name='mcc code']")));  
		merchantType.selectByIndex(1);
		Thread.sleep(1000);
		elementUtil.doSendKeys(address, add);
		elementUtil.doSendKeys(city, CT);
		Thread.sleep(1000);
		Select status = new Select(driver.findElement(By.xpath("//select[@name='state']")));  
		status.selectByIndex(1);
		Thread.sleep(1000);
		elementUtil.doSendKeys(zipCode, zip);
		elementUtil.doSendKeys(contactName, contact);
		elementUtil.doSendKeys(fullAddress, fullAdd);

		//elementUtil.doClick(createContactFormButton);
		jsUtil.clickElementByJS(elementUtil.getElement(saveBtn));
		
	}

}