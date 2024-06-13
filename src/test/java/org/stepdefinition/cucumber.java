package org.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class cucumber extends BaseClass{
	@Given("To launch the url of the Browser")
	public void to_launch_the_url_of_the_mynthra() {
		launchBrowser();
		windowMaximize();
	    
	}
	
	@When("To launch the url")
	public void to_launch_the_url() {
		launchUrl("https://www.myntra.com/");
		
	}
	
	@And("To pass the womens wear")
	public void to_pass_the_womens_wear() {
		WebElement women = driver.findElement(By.xpath("//a[text()='Women']"));
		women.click();
	   
	}

	@And("To pass the men wear")
	public void to_pass_the_men_wear() {
		WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		men.click();
	   
	}

	@And("To check whether it navigate to the homepage or not")
	public void to_check_whether_it_navigate_to_the_homepage_or_not() {
		System.out.println("Checking configuration.....");
	    
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
		closeEntireBrowser();
	    
	}

}
