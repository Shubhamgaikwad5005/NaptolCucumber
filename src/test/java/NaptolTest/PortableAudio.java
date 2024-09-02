package NaptolTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PortableAudio {
WebDriver driver;

@Given("User Open the browser and enter the naptol website url")
public void user_open_the_browser_and_enter_the_naptol_website_url() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.naaptol.com/");
	
}

@Given("User click shopping category and select consumer electronic category")
public void user_click_shopping_category_and_select_consumer_electronic_category() {
	driver.findElement(By.id("cate_head")).click();
	driver.findElement(By.cssSelector("[class=\'catIconMenu electronics\']")).click();
    
}

@Given("user select portable audio and click portable speaker")
public void user_select_portable_audio_and_click_portable_speaker() {
    
	driver.findElement(By.linkText("Portable Audio")).click();
	driver.findElement(By.linkText("Portable Speakers")).click();
}

@Given("user click all brands options")
public void user_click_all_brands_options() throws InterruptedException {
	driver.findElement(By.id("brandFilterBox35768")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("brandFilterBox38822")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("brandFilterBox38905")).click();
    
}

@When("user select Saregama Carvaan")
public void user_select_saregama_carvaan() {
	driver.findElement(By.linkText("Saregama Carvaan")).click();
   
}

@Then("user click on back to homepage")
public void user_click_on_back_to_homepage() throws InterruptedException {
	
	String parentid = driver.getWindowHandle();
	Set<String> allids = driver.getWindowHandles();
	String expectedtitle = "Buy Saregama Carvaan Online at Best Price in India on Naaptol.com";
	for (String id : allids) {
		driver.switchTo().window(id);
		if (driver.getTitle().equals(expectedtitle)) {
				break;
			
		}
		
	}
	driver.findElement(By.id("pincodeDeliveryId_0")).sendKeys("424407");
	driver.findElement(By.linkText("Home")).click();
	//driver.findElement(By.cssSelector("[alt="Online Shopping in India"]")).click();
	driver.quit();
}
}
