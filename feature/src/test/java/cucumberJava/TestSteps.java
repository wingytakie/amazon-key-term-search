package cucumberJava; 

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager; 


public class TestSteps { 
   WebDriver driver = null; 
   String result, amountOfResult;
   List<WebElement> relatedKeys;

	
   @Given("^Launch the Amazon home page$") 
   public void openBrowser() throws IOException  { 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
   } 
	
   @When("^I enter (.*) into search bar and search$") 
   public void enterKeyTerm(String keyterm)  { 
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(keyterm);
		driver.findElement(By.xpath("//input[@value='Go']")).click();
   } 

   @When("^I enter a partial keyterm (.*)$")
   public void click_on_Search(String partialKey) {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(partialKey);
   }

   @Then("^Result should bring up and Displaying total number of results$")
   public void result_should_bring_up() {
	   result = driver.findElement(By.xpath("(//*[@id='search']//span[@data-component-type='s-result-info-bar']//div/span)[1]")).getText();
		Assert.assertTrue("There are no results in this search! Please check your keyword!", resultREGEX(result));
		System.out.println("There are " + amountOfResult + ".");
		driver.close();
   }

   @Then("^Related keyterm will display & clicking on any will bring related item$")
   public void displaying_total_number_of_results() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		relatedKeys = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='suggestions']/div[@data-alias='aps']")));
		System.out.println("Below are list of related item: ");
		for(WebElement item: relatedKeys) {
			Assert.assertTrue("Related item is not displaying.",item.isDisplayed());
			System.out.println(item.getText());
		}
		
		driver.close();

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
			System.out.println("There are results with your keyterm!");
		} 
		return hasResult;
	}
   
}