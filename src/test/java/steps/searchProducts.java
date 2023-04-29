package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class searchProducts {
	
	WebDriver driver;
	
	
	@Given("i am on the google homepage")
	public void i_am_on_the_google_homepage() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize(); 
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
	}

	@When("i enter the {string} in the search bar")
	public void i_enter_the_in_the_search_bar(String  product_name) throws InterruptedException {
	    
		WebElement searchBar = driver.findElement(By.className("gLFyf"));
		searchBar.sendKeys(product_name);
		
		
		
	}

	@When("i click on the search button")
	public void i_click_on_the_search_button() {
	    
		WebElement searchButton = driver.findElement(By.name("btnK"));
		searchButton.click();
	}

	@Then("i can see the search result sucessfully")
	public void i_can_see_the_search_result_sucessfully() {
	    
		WebElement searchResult = driver.findElement(By.id("result-stats"));
		
		String resultText = searchResult.getText();
		
		System.out.println("===================================================");
		
		System.out.println(resultText);
		
		System.out.println("====================================================");
    
		Assert.assertTrue(searchResult.isDisplayed());
		
	}


}
