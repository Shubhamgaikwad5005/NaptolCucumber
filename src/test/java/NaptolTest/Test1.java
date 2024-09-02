package NaptolTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test1 {
	
	WebDriver driver;
	@Given("Open the browser, enter the Naptol website url")
	public void open_the_browser_enter_the_naptol_website_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naaptol.com/");
	    
	}

	@When("User Click on Shopping categories")
	public void user_click_on_shopping_categories() {
		driver.findElement(By.id("cate_head")).click();
	}

	@When("User click on Consumer Electronics")
	public void user_click_on_consumer_electronics() {
		driver.findElement(By.cssSelector("[class=\'catIconMenu electronics\']")).click();
	}

	@When("User click on Electronics Accessories")
	public void user_click_on_electronics_accessories() {
		driver.findElement(By.linkText("Electronics Accessories")).click();
	   
	}
	
	@When("user click cod button and set")
	public void user_click_cod_button_and_set() {
	    driver.findElement(By.id("iscod")).click();
	    driver.findElement(By.cssSelector("[onclick=\"productSearch.setPersonalisedFilter(false);\"]")).click();
	}

	@When("user click branded option and click price option")
	public void user_click_branded_option_and_click_price_option() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("brandFilterBox8313")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("priceFilterBox1")).click();
	   
	}

	@When("user select Home Cinema Projector and click on add to cart")
	public void user_select_home_cinema_projector_and_click_on_add_to_cart() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Home Cinema Projector (HCP)")).click();
		String parentid = driver.getWindowHandle();
		Set<String> allids = driver.getWindowHandles();
		String expectedtitle = "Buy Home Cinema Projector (HCP) Online at Best Price in India on Naaptol.com";
		for (String id : allids) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(expectedtitle)) {
					break;
				
			}
			
		}
		driver.findElement(By.id("cart-panel-button-0")).click();

	}
	

	@When("user click on Check out button")
	public void user_click_on_check_out_button() {
		
		driver.findElement(By.className("red_button2")).click();   
	}

	@When("user click on home button")
	public void user_click_on_home_button() {
	    
		driver.findElement(By.cssSelector("[alt=\"Online Shopping in India\"]")).click();
	}

	@Then("validate the outcomes")
	public void validate_the_outcomes() {
		driver.quit();
	   
	}
	

}
