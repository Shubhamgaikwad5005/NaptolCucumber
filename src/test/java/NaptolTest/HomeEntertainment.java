package NaptolTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeEntertainment {
	WebDriver driver;
	@Given("Open the browser, enter the url")
	public void open_the_browser_enter_the_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naaptol.com/");
	   
	}

	@Given("User click on shopping and select consumer electronic category")
	public void user_click_on_shopping_and_select_consumer_electronic_category() {
	    
	    driver.findElement(By.id("cate_head")).click();
		driver.findElement(By.id("cshow8")).click();
	}

	@Given("user select entertainment and click on Home Speakers")
	public void user_select_entertainment_and_click_on_home_speakers() {
		
		driver.findElement(By.linkText("Home Entertainment")).click();
		driver.findElement(By.linkText("Home Speakers")).click();
	}

	@Given("user click branded option and select price")
	public void user_click_branded_option_and_select_price() throws InterruptedException {
	    driver.findElement(By.id("brandFilterBox8313")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("priceFilterBox4")).click();
	}

	@When("user select colour changing bulb")
	public void user_select_colour_changing_bulb() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.linkText("Colour Changing LED Bulb with Bluetooth Speaker & Remote")).click();
	}

	@When("user click on add to cart and click checkout button")
	public void user_click_on_add_to_cart_and_click_checkout_button() {
		String parentid = driver.getWindowHandle();
		Set<String> allids = driver.getWindowHandles();
		String expectedtitle = "Buy Colour Changing LED Bulb with Bluetooth Speaker & Remote Online at Best Price in India on Naaptol.com";
		for (String id : allids) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(expectedtitle)) {
				break;
			}
		}
		
		driver.findElement(By.id("cart-panel-button-0")).click();
		driver.findElement(By.className("red_button2")).click();
	}

	@Then("user click home page")
	public void user_click_home_page() {
	    driver.findElement(By.cssSelector("[alt=\"Online Shopping in India\"]")).click();
	    driver.quit();
	}
}
