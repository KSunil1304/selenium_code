package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	WebDriver driver = null;

	@Given("User navigates to the NanoHealth web application")
	public void user_navigates_to_the_nano_health_web_application() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver132.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@When("User enters the email address {string}")
	public void user_enters_the_email_address(String Emailaddress) {
		driver.findElement(By.cssSelector("input.string.optional")).sendKeys(Emailaddress);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("User enters the password {string}")
	public void user_enters_the_password(String Pswd) {
		driver.findElement(By.cssSelector("input.password.optional")).sendKeys(Pswd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("User clicks on the sign in button")
	public void user_click_on_the_sign_in_button() throws Exception {
		driver.findElement(By.cssSelector("input.sign-btn.full-btn")).click();
		Thread.sleep(3000);
	}

	@Then("user select the role")
	public void user_select_the_role() throws Exception {
		// selecting Role clicking on Clinic manager Role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[7]/div/div/div/div[2]")).click();
		Thread.sleep(2000);
	}

	@And("user successfully loggined with the role")
	public void user_successfully_loggined_with_the_role() {
		System.out.println("user successfully logged in");
	}

	@Then("signing out")
	public void signing_out() throws Exception {

		// clicking on the cm icon
		driver.findElement(By.xpath("/html/body/header/nav/ul/li/a/div/div[1]/img")).click();
		Thread.sleep(2000);
		// clicking on sign out
		driver.findElement(By.xpath("/html/body/header/nav/ul/li/ul/li[5]/a")).click();
		Thread.sleep(3000);
	}

	@Given("user naviage to NanoHealth webportal")
	public void user_naviage_to_nano_health_webportal() {
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@When("user enters the valid email {string}")
	public void user_enters_the_valid_email(String email) {
		driver.findElement(By.cssSelector("input.string.optional")).sendKeys(email);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("user enter the Invalid password {string}")
	public void user_enter_the_invalid_password(String password) {
		driver.findElement(By.cssSelector("input.password.optional")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("user click on the signin button")
	public void user_click_on_the_signin_button() throws Exception {
		driver.findElement(By.cssSelector("input.sign-btn.full-btn")).click();
		Thread.sleep(3000);
	}

	@Then("it should show error message and popup that Invalid Email or Password")
	public void it_should_show_error_message_and_popup_that_invalid_email_or_password() {
	}

//	@After
//	public void sendingEmail() throws Exception {
//		// Create the attachment
//		EmailAttachment attachment = new EmailAttachment();
//		// attachment.setPath("C:\\Users\\Lenovo\\eclipse-workspace\\NHMAVEN\\test-output\\emailable-report.html");
//		attachment.setPath("C:\\Users\\Lenovo\\eclipse-workspace\\Cucumber\\target\\Cucumberreport.html");
//		attachment.setDisposition(EmailAttachment.ATTACHMENT);
//		attachment.setDescription("Automation result");
//		attachment.setName("Automation result");
//
//		// Create the email message
//		MultiPartEmail email = new MultiPartEmail();
//		email.setHostName("smtp.gmail.com");
//		email.setSmtpPort(465);
//		email.setAuthenticator(new DefaultAuthenticator("sunil.kommayella@nanohealth.in", "Sunil@nanohealth1304"));
//		email.setSSLOnConnect(true);
//		email.setFrom("sunil.kommayella@nanohealth.in");
//		email.setSubject("TestMail");
//		// email.add
//		email.addTo("jaysudheer71@gmail.com");
//		email.setSubject("Automation report");
//		email.setMsg("Reports");
//		// add the attachment
//		email.attach(attachment);
//
//		// send the email
//		email.send();
//
//		System.out.println("mail has been sent.");
//	}

}
