package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginWithOTP {
	WebDriver driver = null;

	@Given("Naviagate to the NH Web portal")
	public void naviagate_to_the_nh_web_portal() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver132.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
	}

	@When("Login_page opens")
	public void loginpage_opens() {

	}

	@Then("Click on the Login with otp button")
	public void click_on_the_login_with_otp_button() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Login with OTP'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("Provide the valid mobile number or email id for otp verify")
	public void provide_the_valid_mobile_number_or_email_id_for_otp_verify() throws Exception {
		driver.findElement(By.cssSelector("input#login-mobile")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#login-mobile")).sendKeys("jaysudheer71@gmail.com");
		Thread.sleep(1000);
	}

	@When("Get otp button clicks otp will generate")
	public void get_otp_button_clicks_otp_will_generate() throws InterruptedException {
		driver.findElement(By.cssSelector("input#getOptBtn")).click();
		Thread.sleep(15000);

	}

	@Then("Enter the otp")
	public void enter_the_otp() {
	}

	@And("Click on the verify button to verify the valid gmail or mobile for login")
	public void click_on_the_verify_button_to_verify_the_valid_gmail_or_mobile_for_login() throws Exception {
		driver.findElement(By.cssSelector("input#verifyOptBtn")).click();
		Thread.sleep(5000);

	}

	@When("The otp is correct it will verify and login")
	public void the_otp_is_correct_it_will_verify_and_login() {

	}

	@And("provide the invalid mobile number or email id for otp verify")
	public void provide_the_invalid_mobile_number_or_email_id_for_otp_verify() throws Exception {
		driver.findElement(By.cssSelector("input#login-mobile")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#login-mobile")).sendKeys("7788990021");
		Thread.sleep(1000);
		// 7788990021
	}

	@When("Get otp button clicked otp will generate")
	public void get_otp_button_clicked_otp_will_generate() throws InterruptedException {
		driver.findElement(By.cssSelector("input#getOptBtn")).click();
		Thread.sleep(5000);
	}

	@Then("Mobile number or mail does not exist validation should show")
	public void mobile_number_or_mail_does_not_exist_validation_should_show() throws Exception {
		String mobile = driver.findElement(By.xpath("(//span[@class='error err_phone'])[1]")).getText();
		System.out.println("Validation:" + mobile);
		Thread.sleep(2000);
		driver.close();

	}

	@And("provide the valid mobile number or emailid for otp verify")
	public void provide_the_valid_mobile_number_or_emailid_for_otp_verify() throws InterruptedException {
		driver.findElement(By.cssSelector("input#login-mobile")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#login-mobile")).sendKeys("8790098500");
		Thread.sleep(1000);
	}

	@When("Get otp button clicked otp will_generate")
	public void Get_otp_button_clicked_otp_will_generate() throws InterruptedException {
		driver.findElement(By.cssSelector("input#getOptBtn")).click();
		Thread.sleep(20000);
	}

	@Then("enter the wrong otp")
	public void enter_the_wrong_otp() {

	}

	@And("click on the verify button")
	public void click_on_the_verify_button() throws Exception {
		driver.findElement(By.cssSelector("input#verifyOptBtn")).click();
		Thread.sleep(5000);
	}

	@Then("Sorry! The entered OTP is invalid. Please try again validation should show")
	public void sorry_the_entered_otp_is_invalid_please_try_again_validation_should_show() {
		String error = driver.findElement(By.xpath("(//span[@class='error'])[1]")).getText();
		System.out.println("Validation:" + error);
		driver.close();
	}

	@And("provide the valid number or email id for otp verify")
	public void provide_the_valid_number_or_email_id_for_otp_verify() throws InterruptedException {
		driver.findElement(By.cssSelector("input#login-mobile")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#login-mobile")).sendKeys("8790098500");
		Thread.sleep(1000);
	}

	@When("Get otp button is clicked otp will generate")
	public void get_otp_button_is_clicked_otp_will_generate() throws Exception {
		driver.findElement(By.cssSelector("input#getOptBtn")).click();
		Thread.sleep(20000);
	}

	@Then("enter the otp in five digits only")
	public void enter_the_otp_in_five_digits_only() {

	}

	@And("click the verify button")
	public void click_the_verify_button() throws Exception {
		driver.findElement(By.cssSelector("input#verifyOptBtn")).click();
		Thread.sleep(5000);
	}

	@Then("verify button should not work")
	public void verify_button_should_not_work() {

	}

}
