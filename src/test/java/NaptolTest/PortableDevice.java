package NaptolTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PortableDevice {
	
	WebDriver driver;
	@Given("Open the the browser, enter the naptol website url")
	public void open_the_the_browser_enter_the_naptol_website_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naaptol.com/");
		
	  
	}

	@Given("User click on shopping category option and click on Consumer electronic option")
	public void user_click_on_shopping_category_option_and_click_on_consumer_electronic_option() {
		driver.findElement(By.id("cate_head")).click();
		driver.findElement(By.id("cshow8")).click();  
	}

	@Given("User click on portable devices")
	public void user_click_on_portable_devices() {
		driver.findElement(By.linkText("Portable Devices")).click();
	}

	@Given("User Click on royal search option")
	public void user_click_on_royal_search_option() {
		driver.findElement(By.cssSelector("[title=\"Royal Home\"]")).click();
	  
	}

	@When("User select bright feature led light")
	public void user_select_bright_feature_led_light() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// scroll down page page to till find the Bright LED light
		
		WebElement nightlamp = driver.findElement(By.linkText("Festive & Decorative Bright LED Lights - Pick Any 1 (L6)"));
		
		js.executeScript("arguments[0].scrollIntoView()",nightlamp);
		
		driver.findElement(By.linkText("Festive & Decorative Bright LED Lights - Pick Any 1 (L6)")).click();

	   
	}

	@When("User select the colour and enter pincode")
	public void user_select_the_colour_and_enter_pincode() {
		String parentid = driver.getWindowHandle();
		
		Set<String> allids = driver.getWindowHandles();
		
		String expectedtitle = "Buy Festive & Decorative Bright LED Lights - Pick Any 1 (L6) Online at Best Price in India on Naaptol.com";
		
		for (String id : allids) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(expectedtitle)) {
				break;
			}
		}
		
		driver.findElement(By.linkText("Bottle")).click();
		
		driver.findElement(By.id("pincodeDeliveryId_0")).sendKeys("422207");
		driver.findElement(By.cssSelector("[onclick=\"javascript:bestOfferOnPincode.getBestOfferOnDelivery(null,'12612226', 'Festive & Decorative Bright LED Lights - Pick Any 1 (L6)');\"]")).click();

	}

	@When("User click on  Add to cart")
	public void user_click_on_add_to_cart() {
		driver.findElement(By.linkText("Click here to Buy")).click();
	    
	}

	@When("user click on checkout button and click on home button")
	public void user_click_on_checkout_button_and_click_on_home_button() {
		driver.findElement(By.cssSelector("[onclick=\"cart.submitOrder()\"]")).click();
		driver.findElement(By.cssSelector("[alt=\"Online Shopping in India\"]")).click();
	   
	}

	@Then("user validate the outcomes")
	public void user_validate_the_outcomes() {
	   driver.quit();
	}

}
