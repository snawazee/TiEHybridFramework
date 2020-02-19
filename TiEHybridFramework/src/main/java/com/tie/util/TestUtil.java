package com.tie.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

public class TestUtil {

	WebDriver driver;
	WebDriverWait wait;

	public TestUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);

	}

	@Step("getting tht element with : {0}")
	public WebElement getElement(By locator) {
		waitForElementPresent(locator);
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some exception got occurred while creating the webelement : " + locator);
			System.out.println(e.getMessage());
		}
		return element;
	}

	public void doClick(By locator) {
		try {
			Thread.sleep(500);
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occurred while clicking on the webelement : " + locator);
			System.out.println(e.getMessage());

		}
	}

	
	
	public void doActionsClick(By locator) {
		try {
			Actions action = new Actions(driver);
			action.click(getElement(locator)).build().perform();
		} catch (Exception e) {
			System.out.println("some exception got occurred while clicking on the webelement : " + locator);
			System.out.println(e.getMessage());

		}
	}

	public void doSendKeys(By locator, String... value) {
		try {
			getElement(locator).clear();
			Thread.sleep(500);
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception got occurred while sending the text to the webelement : " + locator);
			System.out.println(e.getMessage());

		}
	}

	public void doActionsSendKeys(By locator, String... value) {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(getElement(locator), value).build().perform();
		} catch (Exception e) {
			System.out.println("some exception got occurred while passing the values to the webelement : " + locator);
			System.out.println(e.getMessage());
		}
	}

	public String doGetText(By locator) {
		String text = null;
		try {
			text = getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception got occurred while getting the test from webelement : " + locator);
			System.out.println(e.getMessage());
		}
		return text;
	}

	public boolean doIsDisplayed(By locator) {
		
		boolean flag = false;
		try {
			flag = getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out
					.println("some exception got occurred while checking isDisplayed for the webelement : " + locator);
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public String doGetTitle() {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occurred while getting the title of the page");
			System.out.println(e.getMessage());
		}
		return title;
	}

	public void doActionsMoveToElement(By locator) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(getElement(locator)).build().perform();
		} catch (Exception e) {
			System.out.println("some exception got occurred while moving on the webelement : " + locator);
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static void selectValueFromDropDownByText(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	
	public static void selectValueFromDropDownByIndex(WebElement element, int value)
	{
		Select select = new Select(element);
		select.selectByIndex(value);
	}
	
	public static void selectValueFromDropDownByValue(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;


	public void waitForPageUrl(String url) {
		wait.until(ExpectedConditions.urlToBe(url));
	}

	public void waitForPageTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void waitForElementPresent(By locator){
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitForElementClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void doBackNavigate() {
		driver.navigate().back();
	}
	
	
	public void scrollPageDown(WebDriver driver)
    {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
	
	
	public void Highlight_Element(By locator)
	   {
	      JavascriptExecutor js=(JavascriptExecutor)driver; 
	      js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", locator);
	      try 
	      {
	         Thread.sleep(1000);
	      } 
	      catch (InterruptedException e) 
	      { 
	         System.out.println(e.getMessage());
	      }
	      js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", locator);
	   }
	
	public static void doAcceptAlert(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}
	
	public static void doDismissAlert(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
	}
	
	public static void verifyAlertText(WebDriver driver,String expectedText)
	{
		WebDriverWait wait=new WebDriverWait(driver, 15);
		String alert_text_actual=wait.until(ExpectedConditions.alertIsPresent()).getText();
		Assert.assertEquals(alert_text_actual, expectedText);
	}
	
	public static List<WebElement> waitForMultipleWebElement(WebDriver driver, By byLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		List<WebElement> allElements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
		return allElements;
	}
	
	public static List<WebElement> waitForMultipleWebElement(WebDriver driver, By byLocator,int time) {	
		WebDriverWait wait = new WebDriverWait(driver, time);
		List<WebElement> allElements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
		return allElements;
	}

	public static void selectValueFromCalendar(List<WebElement> elements,String values) {
	for(WebElement ele:elements)
	{
		String data=ele.getText();
		if(data.equalsIgnoreCase(values))
		{
			ele.click();
			break;
		}
	}	
}

	public static void wait(int time){
		try 
	{
	Thread.sleep(time*1000);
	} 
		catch (InterruptedException e) 
		{	
	}
}


}
