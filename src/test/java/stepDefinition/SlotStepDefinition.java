package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class SlotStepDefinition {
	WebDriver driver;
	
	@Given("user on home page")
	public void user_on_home_page() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/");
	   
	}

	@When("click login button and enter the valid details {string} and {string}")
	public void click_login_button_and_enter_the_valid_details_and(String email, String password) {
		driver.findElement(By.xpath("//button[@type='button']")).click();
		   driver.findElement(By.id("email")).sendKeys(email);
		   driver.findElement(By.id("password")).sendKeys(password);
		   driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@When("click on upcoming slot button")
	public void click_on_upcoming_slot_button() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Upcoming')]")).click();
		
		WebElement upcomings = driver.findElement(By.xpath("//a[contains(text(),'Upcoming')]"));
		String text = upcomings.getText();
		String expected = "Upcoming";
		Assert.assertEquals(expected, text);

		
		
		
		
		
		//driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	    
	}

	@When("click on cancelled button")
	public void click_on_cancelled_button() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Canceled')]")).click();
		
		WebElement cancle = driver.findElement(By.xpath("//a[contains(text(),'Canceled')]"));
		String text = cancle.getText();
		String expected = "Canceled";
		Assert.assertEquals(expected, text);

	    
	}

	@When("click on past slot button")
	public void click_on_past_slot_button() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Past')]")).click();
		WebElement pasts = driver.findElement(By.xpath("//a[contains(text(),'Past')]"));
		 String text = pasts.getText();
		 String expected="Past";
		 Assert.assertEquals(expected, text);
		
	
		WebElement logOut = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
	     
	     Thread.sleep(2000);
	     
	     Actions actions=new Actions(driver);
	     actions.moveToElement(logOut).perform();
	     
	     driver.findElement(By.xpath("//a[@class='dropdown-item']")).click();
	     System.out.println("User successfully loged out");
	}

	@Then("successfully user should able to see the slots")
	public void successfully_user_should_able_to_see_the_slots() throws InterruptedException {
	   System.out.println("sucessfully user able to see the slots");
	   Thread.sleep(3000);
	   driver.close();
	}
}
