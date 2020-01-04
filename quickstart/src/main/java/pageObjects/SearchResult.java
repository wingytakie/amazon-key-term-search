package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResult {
	public WebElement showingResults;
	public String key;
	
	
	public SearchResult(WebDriver driver) {
		
	showingResults = driver.findElement(By.xpath("(//*[@id='search']//span[@data-component-type='s-result-info-bar']//div/span)[1]"));
	key = "software developerment";
	
	}
}
