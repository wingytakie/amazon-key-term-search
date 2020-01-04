package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RelatedSearch {
	public List<WebElement> relatedKeys;

	
	public RelatedSearch(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		relatedKeys = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='suggestions']/div[@data-alias='aps']")));
	}
}
