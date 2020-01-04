package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage{
	public WebElement searchBar, searchButton;
	public String key, partialKey;	
	
	
	public HomePage(WebDriver driver) {
		
	searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
	
	key = "software development";
	partialKey = "software";
	
	
	}
}
