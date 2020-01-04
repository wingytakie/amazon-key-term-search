package com.amazonSearch.maven.quickstart;

import java.util.concurrent.TimeUnit;
import java.util.regex.*;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.SearchResult;
import pageObjects.RelatedSearch;

public class AppTest
{
	WebDriver driver;
	HomePage h;
	SearchResult r;
	RelatedSearch rs;
	
	String result, amountOfResult;

	
	@BeforeMethod
	public void init()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		h = new HomePage(driver);
	}
	
	@AfterMethod
	public void exit()
	{
		driver.close();
	}
	
	@Test
	public void searchResult()
	{
		h.searchBar.sendKeys(h.key);
		h.searchButton.click();
		r = new SearchResult(driver);
		result = r.showingResults.getText();
		Assert.assertTrue("There are no results in this search! Please check your keyword!", resultREGEX(result));
	}
	
	@Test(dependsOnMethods= {"searchResult"})
	public void numberOfResultDisplayed()
	{
		h.searchBar.sendKeys(h.key);
		h.searchButton.click();
		r = new SearchResult(driver);
		result = r.showingResults.getText();
		resultREGEX(result);
		System.out.println("When search with term:" + h.key);
		System.out.println("There are " + amountOfResult + ".");
	}
	
	@Test
	public void relatedItem() throws InterruptedException, NullPointerException
	{
		h.searchBar.sendKeys(h.partialKey);
		rs = new RelatedSearch(driver);
		System.out.println("Below are list of related item of partial term: '" + h.partialKey + "' typed in search bar");
		for(WebElement item: rs.relatedKeys) {
			Assert.assertTrue("Related item is not displaying.",item.isDisplayed());
			System.out.println(item.getText());
		}
	}
	

	
	public boolean resultREGEX(String result)
	{
		boolean hasResult = false;
		Pattern pattern = Pattern.compile("over ([0-9,]+) results|([0-9,]+) results|([0-9]+) results|1 result");
		Matcher matcher = pattern.matcher(result);
		if (matcher.find())
		{
			amountOfResult = matcher.group();
			hasResult = true;
		} 
		return hasResult;
	}
}
