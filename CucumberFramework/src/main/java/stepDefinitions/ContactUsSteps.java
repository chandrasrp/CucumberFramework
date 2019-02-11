package stepDefinitions;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactUsSteps {

	WebDriver driver;
	//commented hooks so it wont open two browsers when I run different steps
	@Before()
	public void setup() throws IOException{
		System.setProperty("webdriver.chrome.driver", Paths.get(System.getProperty("user.dir")).toRealPath() + "\\src\\test\\java\\CucumberFramework\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}
	
	@After()
	public void teardown() throws IOException{
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
	}
	
	
	@Given("^I access webdriveruniversity contact us form$")
	public void i_access_webdriveruniversity_contact_us_form() {
		driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
	}

	@When("^I enter a valid firstname$")
	public void i_enter_a_valid_firstname() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("Chandra");
	}

	@And("^I enter a valid lastname$")
	public void i_enter_a_valid_lastname(DataTable dataTable)  {
		List<List<String>> data=dataTable.raw();
		driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys(data.get(0).get(1));
	}

	@And("^I enter valid email address$")
	public void i_enter_valid_email_address()  {
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("reddy@abc.com");
	}

	@And("^I enter comments$")
	public void i_enter_comments(DataTable messageTable) {
		List<List<String>> message=messageTable.raw();
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(message.get(0).get(0));
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(message.get(0).get(1));
	}

	@And("^I click on the submit button$")
	public void i_click_on_the_submit_button() {
		//driver.findElement(By.cssSelector("input[value='SUBMIT']")).click();
		driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
	}

	@Then("^the information successfully be submitted$")
	public void the_information_successfully_be_submitted() throws InterruptedException {
		Thread.sleep(3000);
		WebElement sucessfulSentMessage = driver.findElement(By.xpath("//*[@id=\"contact_reply\"]/h1"));
		Assert.assertEquals("thankyouforyourmessage!", sucessfulSentMessage.getText().toLowerCase().replaceAll("[ ()0-9]", ""));
	}
	//Thank You for your Message!
	//*[@id="contact_reply"]/h1
}
