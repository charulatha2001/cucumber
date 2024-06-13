package org.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleRun extends BaseClass {
	@When("To launch the url")
	public void to_launch_the_mynthra_url() {
		launchUrl("https://www.myntra.com/");
	    
	}

	@And("To pass the value {string} in women session")
	public void to_pass_the_value_in_women_session(String wo) {
		WebElement e1 = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		e1.sendKeys(wo);
	    
	}

	@And("To pass the value {string}   in men session")
	public void to_pass_the_value_in_men_session(String me) {
		WebElement e2 = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		e2.sendKeys(me);
	}

	@And("To pass the value {string}  in kids session")
	public void to_pass_the_value_in_kids_session(String ki) {
		WebElement e3 = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		e3.sendKeys(ki);
	}
	
	@Then("To close the browser")
	public void to_close_the_browser() {
		closeEntireBrowser();
	    
	}
}
