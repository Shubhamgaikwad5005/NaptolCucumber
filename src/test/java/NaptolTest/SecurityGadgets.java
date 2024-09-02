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

public class SecurityGadgets {
	
	WebDriver driver;
	@Given("Open the browser, Enter the naptol webisite url")
	public void open_the_browser_enter_the_naptol_webisite_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naaptol.com/");
	  
	}

	@Given("User click on shopping categories and click on consumer electronics")
	public void user_click_on_shopping_categories_and_click_on_consumer_electronics() {
		driver.findElement(By.id("cate_head")).click();
		driver.findElement(By.id("cshow8")).click();
	}

	@Given("User click on security Security & Gadgets")
	public void user_click_on_security_security_gadgets() {
		driver.findElement(By.linkText("Security & Gadgets")).click();
	}

	@Given("User click on Security Devices")
	public void user_click_on_security_devices() {
		driver.findElement(By.linkText("Security Devices")).click();
		driver.findElement(By.id("iscod")).click();
		driver.findElement(By.cssSelector("[onclick=\"productSearch.setPersonalisedFilter(false);\"]")).click();
	    
	}

	@When("User select branded option")
	public void user_select_branded_option() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("brandFilterBox8313")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("priceFilterBox5")).click();
	    
	}



	@When("User Click on WiFI CCTV product")
	public void user_click_on_wi_fi_cctv_product() {
		driver.findElement(By.linkText("Wi-Fi Camera for Ear, Nose & Mouth - Safe Cleaning & Care (E")).click();
	    
	}

	@When("user Click on add to cart and click on check out button")
	public void user_click_on_add_to_cart_and_click_on_check_out_button() {
		
		String parentid = driver.getWindowHandle();
		
		Set<String> allids = driver.getWindowHandles();
		
		String expectedtitle = "";
		
		for (String id : allids) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(expectedtitle)) {
				break;
			}
		}
	    driver.findElement(By.id("cart-panel-button-0")).click();
	    driver.findElement(By.className("red_button2")).click();
	}

	@Then("user navigate the page")
	public void user_navigate_the_page() {
	    driver.findElement(By.cssSelector("[alt=\"Online Shopping in India\"]")).click();
	    driver.quit();
	}

}
