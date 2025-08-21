package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingServices {
	WebDriver driver = null;

	@Given("navigate_to_nanohealth_on_the_web")
	public void navigate_to_nanohealth_on_the_web() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver132.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@Then("logging with the  emailid {string} and  password {string}")
	public void login_with_sunilcm_gmail_com_and_demo(String emailid, String password) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(emailid);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(password);
		Thread.sleep(2000);
	}

	@And("click on sign_in_button")
	public void click_on_sign_in_button() throws Exception {
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
	}

	@Then("select_the_profile")
	public void select_the_profile() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);

	}

	@And("deleting existing patient using search")
	public void deleting_existing_patient_using_search() throws Exception {
		// selecting Role clicking on CDPAdmin
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[8]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
		Thread.sleep(2000);
		driver.findElement(By.id("frst_nm")).sendKeys("Cucumoppatient");
		Thread.sleep(10000);
		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);
		// clicking on the view profile
		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("admin-billing-tab")).click();
			// clicking on the delete
			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")).click();
			Thread.sleep(1000);
		} else {
			// clicking on the delete
			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")).click();
			Thread.sleep(1000);
		}
		// deleteing
		driver.findElement(By.xpath("//button[text()='Confirm!']")).click();
		Thread.sleep(13000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(1000);
		robot1.keyRelease(KeyEvent.VK_ADD);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		// clicking on the brand logo
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("existing patient deleted")
	public void existing_patient_deleted() {
	}

	@And("click on add_patient_icon for registration")
	public void click_on_add_patient_icon_for_registration() throws Exception {

		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on clinic manager
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[3]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
		// clicking on the add patient
		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("select title_of_patient")
	public void select_title_of_patient() throws Exception {
		// selecting the title
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
//				driver.findElement(By.xpath("(//span[@class='selection'])[1]")).sendKeys(Keys.DOWN);
//				Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@When("user enters the following details into the registration form")
	public void user_enters_the_following_details_into_the_registration_form(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> regData = dataTable.asLists(String.class);

		// firstname
		driver.findElement(By.id("first_name")).sendKeys(regData.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// lastname
		driver.findElement(By.id("lst_name")).sendKeys(regData.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		driver.findElement(By.id("age")).sendKeys(regData.get(2).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// phone
		driver.findElement(By.id("nmbr")).sendKeys(regData.get(3).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// email
		driver.findElement(By.id("email")).sendKeys(regData.get(4).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// addressline
		driver.findElement(By.id("address-line1")).sendKeys(regData.get(5).get(1));
		driver.findElement(By.id("autocomplete-input")).sendKeys(regData.get(6).get(1));
		driver.findElement(By.id("landmark")).sendKeys(regData.get(7).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// city/html/body/main/div/form/div[2]/div/ul/li/div/div[9]/div[2]/input
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).sendKeys(regData.get(8).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// district
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).sendKeys(regData.get(9).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// pincode
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys(regData.get(10).get(1));
//		// aadharcardnumber
//		driver.findElement(By.xpath("/html/body/main/div/form/div[2]/div[1]/div/div[9]/div[2]/input"))
//				.sendKeys(regData.get(11).get(1));
	}

	@Then("select the radio_buttons")
	public void select_the_radio_buttons() throws Exception {
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
//		// abhacard
//		WebElement ac = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
//		ac.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys("767676");
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
//		// profession
//		driver.findElement(By.xpath("(//input[@name='patient_master[profession]'])[1]")).sendKeys("test profession");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// referred by
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Referral'])[1]")).click();
		Thread.sleep(1000);
		// digital
		driver.findElement(By.xpath("(//div[@class='icon'])[2]")).click();
		Thread.sleep(1000);
		// instagram
		driver.findElement(By.cssSelector("i.fa.fa-instagram.circle.pink.tooltipped")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.cssSelector("span.cls.btn.green.right.referral_submit")).click();
		Thread.sleep(2000);
		// demand program
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='NanoHealth Program1'])[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
	}

	@And("click on  submit_button_to_register")
	public void click_on_submit_button_to_register() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("update_submit")))).click();
//		driver.findElement(By.id("update_submit")).click();
		Thread.sleep(5000);
	}

	@Then("it will redirects to the patient_profile")
	public void it_will_redirects_to_the_patient_profile() {
	}

	@When("user click on ambulance from book appointment")
	public void user_click_on_ambulance_from_book_appointment() throws Exception {
		// mouse hovering on the ambulance
		Actions ambul = new Actions(driver);
		ambul.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Ambulance'])/img[1]"))).build().perform();
		Thread.sleep(1000);
		// clicking on the ambulance
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Ambulance'])/img[1]")))).click();
		// driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(9)")).click();
		Thread.sleep(3000);
	}

	@Then("from popup select the pickup location")
	public void from_popup_select_the_pickup_location() {
		// selecting the clinic
		driver.findElement(By.xpath("(//h6[text()='Clinic'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@And("select the location and choose address")
	public void select_the_location_and_choose_address() {
		// selecting the address
		driver.findElement(By.xpath("(//div[@class='provider-addresses'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("from popup select the drop location")
	public void from_popup_select_the_drop_location() {
		// clicking on the home
		driver.findElement(By.xpath("(//h6[text()='Home'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@And("select the location and choose address for drop location")
	public void select_the_location_and_choose_address_for_drop_location() throws InterruptedException {
		// selecting the home
		driver.findElement(By.xpath("(//div[@class='provider-addresses'])[2]")).click();
		Thread.sleep(1000);
	}

	@Then("select the date and time for appointment")
	public void select_the_date_and_time_for_appointment() throws Exception {
		// date-time-selection
		driver.findElement(By.cssSelector("input#appointment_tracking_apmnt_date")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("td.is-today")).click();
		Thread.sleep(1000);
		// slot-time
		driver.findElement(By.cssSelector("input#appointment_tracking_slot_time")).click();
		Thread.sleep(1000);
		// clicking on the ok
		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[2]/button[text()='Ok']")).click();
		Thread.sleep(3000);
	}

	@And("click on continue button")
	public void click_on_continue_button() throws Exception {
		// continue
		try {
			driver.findElement(By.cssSelector("button.waves-effect.waves-dark.btn.green.date-continue.next-step.right"))
					.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Then("enter the price and click on submit button")
	public void enter_the_price_and_click_on_submit_button() throws Exception {
		// entering the price
		driver.findElement(By.cssSelector("input#appointment_tracking_order_value")).sendKeys("1000");
		Thread.sleep(5000);
		try {
			// submit
			driver.findElement(By.xpath("/html/body/div[35]/div/div[2]/form/ul/li[4]/div[2]/div[2]/div/div[2]/input"))
					.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}

//		Robot robot1 = new Robot();
//		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
	}

	@And("select the paymentmethods1")
	public void select_the_paymentmethods1() throws Exception {
		// entering the discount amount
		driver.findElement(By.cssSelector("input#promo_amnt")).sendKeys("100");
		Thread.sleep(2000);
		// clicking on the apply
		driver.findElement(By.cssSelector("span#applyCouponModal")).click();
		Thread.sleep(3000);
		// entering the comments
		driver.findElement(By.cssSelector("textarea#comments")).sendKeys("Discount 100");
		Thread.sleep(1000);
		// clicking on the submit button
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Submit'])[3]"))))
				.click();
//		driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
		Thread.sleep(3000);

		// clicking on the close button for applied discount
		WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		close.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.custom_chip>i")))).click();
//		driver.findElement(By.cssSelector("div.custom_chip>i")).click();
		Thread.sleep(3000);

		// entering the discount amount
		driver.findElement(By.cssSelector("input#promo_amnt")).sendKeys("100");
		Thread.sleep(5000);
		// clicking on the apply
		driver.findElement(By.cssSelector("span#applyCouponModal")).click();
		Thread.sleep(3000);
		// entering the comments
		driver.findElement(By.cssSelector("textarea#comments")).sendKeys("Discount 100");
		Thread.sleep(1000);
		// clicking on the submit button
		WebDriverWait submit1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Submit'])[3]"))))
				.click();
//		driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
		Thread.sleep(3000);

//		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
//		cash.click();
//		Thread.sleep(1000);
	}

	@When("user enter transactionamount as partial for paymentmethodone")
	public void user_enter_transactionamount_as_partial_for_paymentmethodone() {
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("Receiptcomment1 will be visible click on it")
	public void receiptcomment1_will_be_visible_click_on_it() {
	}

	@And("enter the receiptcomments1 and click on ok")
	public void enter_the_receiptcomments1_and_click_on_ok() throws Exception {
		// clicking on the comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.cssSelector("textarea#payment_cmnt"))
				.sendKeys("receipt comment for 100 rupees for payment method cash");
		Thread.sleep(1000);
		// ok
		driver.findElement(By.cssSelector("a.modal-close.btn.green.right.payCmntOk")).click();
		Thread.sleep(1000);
	}

	@Then("click on the submit button  inthe proformainvoice1")
	public void click_on_the_submit_button_inthe_proformainvoice1() throws Exception {
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@And("click on the paybalance button")
	public void click_on_the_paybalance_button() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Pay Balance'])[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

	}

	@Then("billing invoice page will open select the payment methodtwo and enter partial amount")
	public void billing_invoice_page_will_open_select_the_payment_methodtwo_and_enter_partial_amount()
			throws Exception {
		// select the paymentmethod as card
		WebElement card = driver.findElement(By.xpath("(//label[text()='Card'])[1]"));
		card.click();
		Thread.sleep(1000);
		// enter transaction amount
		driver.findElement(By.cssSelector("input#txn_id")).sendKeys("12345");
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// entering amount partially
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("100");
		Thread.sleep(2000);
		// entering receipt comment

		// clicking on the comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.cssSelector("textarea#payment_cmnt"))
				.sendKeys("receipt comment for 100 rupees for payment method card");
		Thread.sleep(1000);

		// ok
		driver.findElement(By.cssSelector("a.modal-close.btn.green.right.payCmntOk")).click();
		Thread.sleep(1000);

	}

	@And("click on the submit button from the invoice_page")
	public void click_on_the_submit_button_from_the_invoice_page() throws Exception {
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(5000);
	}

	@Then("click on the paybalance button again")
	public void click_on_the_paybalance_button_again() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Pay Balance'])[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@And("select the paymentmethodthree and enter partial amount")
	public void select_the_paymentmethodthree_and_enter_partial_amount() throws Exception {
		// select the paymentmethod as other
		WebElement card = driver.findElement(By.xpath("(//label[text()='Other'])[1]"));
		card.click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// selecting the phonpe/googlepay
		driver.findElement(By.xpath("(//li[@class='select2-results__option'])[3]/span/img[1]")).click();
		Thread.sleep(1000);
		// enter transaction amount
		driver.findElement(By.cssSelector("input#other_txn_id")).sendKeys("12345");
		Thread.sleep(1000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// entering amount partially
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("100");
		Thread.sleep(1000);
		// clicking on the comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.cssSelector("textarea#payment_cmnt"))
				.sendKeys("receipt comment for 100 rupees for payment method other");
		Thread.sleep(1000);
		// ok
		driver.findElement(By.cssSelector("a.modal-close.btn.green.right.payCmntOk")).click();
		Thread.sleep(1000);
	}

	@Then("click on the submit button again from the invoice page")
	public void click_on_the_submit_button_again_from_the_invoice_page() throws Exception {
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(5000);
	}

	@And("Click on the generate button in the top to generate invoice id")
	public void Click_on_the_generate_button_in_the_top_to_generate_invoice_id() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		Thread.sleep(3000);
		// download the op invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")).click();
		Thread.sleep(2000);
	}

	@And("click on the paybalance button again to pay partial amount")
	public void click_on_the_paybalance_button_again_to_pay_partial_amount() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Pay Balance'])[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@Then("select paymentmethod as send link and enter details")
	public void select_paymentmethod_as_send_link_and_enter_details() throws Exception {
		// select the paymentmethod as send link
		WebElement card = driver.findElement(By.xpath("(//label[text()='Send link'])[1]"));
		card.click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// adding partial amount in the send link option
		driver.findElement(By.cssSelector("input#request_amt")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#request_amt")).sendKeys("12");
		Thread.sleep(2000);
		// clearing the percentage
		driver.findElement(By.cssSelector("input#extra_charge")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#extra_charge")).sendKeys("1" + Keys.TAB);
		Thread.sleep(2000);
		// clearing the percentage
		driver.findElement(By.cssSelector("input#extra_charge")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#extra_charge")).sendKeys("0" + Keys.TAB);
		Thread.sleep(2000);
		// clearing mail and writing another email
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// clearing mobile number
		driver.findElement(By.xpath("(//input[@id='mobile'])[1]")).clear();
		Thread.sleep(2000);

		// clicking on the send icon
		driver.findElement(By.cssSelector("i.small.material-icons.sendPaymentLink")).click();
		Thread.sleep(5000);
		// enter transaction amount
		driver.findElement(By.cssSelector("input#link_txn_id")).sendKeys("12345");
		Thread.sleep(1000);
	}

	@And("click on the submit from the proforma invoice page")
	public void click_on_the_submit_from_the_proforma_invoice_page() throws Exception {
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("(//a[text()='Pay Balance'])[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// select the paymentmethod as send link
		WebElement card = driver.findElement(By.xpath("(//label[text()='Send link'])[1]"));
		card.click();
		Thread.sleep(1000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// adding partial amount in the send link option
		driver.findElement(By.cssSelector("input#request_amt")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#request_amt")).sendKeys("588");
		Thread.sleep(2000);
		// clearing the percentage
		driver.findElement(By.cssSelector("input#extra_charge")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#extra_charge")).sendKeys("0" + Keys.TAB);
		Thread.sleep(2000);
		// clearing mail and writing another email
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// clearing mobile number
		driver.findElement(By.xpath("(//input[@id='mobile'])[1]")).clear();
		Thread.sleep(2000);

		// clicking on the send icon
		driver.findElement(By.cssSelector("i.small.material-icons.sendPaymentLink")).click();
		Thread.sleep(5000);
		// enter transaction amount
		driver.findElement(By.cssSelector("input#link_txn_id")).sendKeys("1234");
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(5000);

	}

	@And("clicking on the appointmentid at righttop")
	public void clicking_on_the_appointmentid_at_righttop() throws Exception {
		// clicking on the appointment id
		WebDriverWait aptidclick = new WebDriverWait(driver, Duration.ofSeconds(30));
		aptidclick
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("(//div[@class='row summary'])[1]/div[2]/a[1]"))))
				.click();
		Thread.sleep(4000);
	}

	@Then("reducingscreensize click on the proformainvoice")
	public void reducingscreensize_click_on_the_proformainvoice() throws Exception {
		Robot robot3 = new Robot();
		for (int i = 0; i < 4; i++) {
			robot3.keyPress(KeyEvent.VK_CONTROL);
			robot3.keyPress(KeyEvent.VK_SUBTRACT);
			Thread.sleep(1000);
			robot3.keyRelease(KeyEvent.VK_SUBTRACT);
			robot3.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(1000);
		// proforma invoice
		driver.findElement(By.xpath("(//div[@class='price-block'])[1]/div[1]/div[2]/a[2]")).click();
		Thread.sleep(2000);

	}

	@And("clicking on the viewbutton and closingpopup for ambulancebooking")
	public void clicking_on_the_viewbutton_and_closingpopup_for_ambulancebooking() throws Exception {
		// clicking on the view
		driver.findElement(By.xpath("(//a[text()='View'])[1]")).click();
		Thread.sleep(4000);
		Robot robot4 = new Robot();
		for (int i = 0; i < 4; i++) {
			robot4.keyPress(KeyEvent.VK_CONTROL);
			robot4.keyPress(KeyEvent.VK_ADD);
			Thread.sleep(1000);
			robot4.keyRelease(KeyEvent.VK_ADD);
			robot4.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(1000);
		// closing the popup
		WebDriverWait close = new WebDriverWait(driver, Duration.ofSeconds(30));
		close.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.cssSelector("div#modalApmntShow>div>div>span:nth-of-type(1)"))))
				.click();
//		driver.findElement(By.cssSelector("div#modalApmntShow>div>div>span:nth-of-type(1)")).click();
		Thread.sleep(2000);
	}

	@And("selecting Servicewise Datewise Itemwise Summary and downloading the invoice")
	public void selecting_Servicewise_Datewise_Itemwise_Summary_and_downloading_the_invoice() throws Exception {
		// selecting datewsie and download inovice
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		Thread.sleep(1000);
		WebDriverWait datewise = new WebDriverWait(driver, Duration.ofSeconds(30));
		datewise.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Datewise'])[1]"))))
				.click();
		Thread.sleep(3000);
		// OP -Invoice datewise wise pdf
		driver.findElement(By.cssSelector("a.tooltipped.date_wise_pdf>img")).click();
		Thread.sleep(2000);

		// selecting summary and download inovice
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		WebDriverWait summary = new WebDriverWait(driver, Duration.ofSeconds(30));
		summary.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Summary'])[1]"))))
				.click();
		Thread.sleep(3000);
		// OP -Invoice summary wise pdf
		driver.findElement(By.cssSelector("a.tooltipped.datewise_summary_pdf>img")).click();
		Thread.sleep(2000);

		// selecting itemwise and download inovice
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		WebDriverWait itemwise = new WebDriverWait(driver, Duration.ofSeconds(30));
		itemwise.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Itemwise'])[1]"))))
				.click();
		Thread.sleep(3000);
		// OP -Invoice itemwise wise pdf
		driver.findElement(By.cssSelector("a.tooltipped.date_wise_pdf>img")).click();
		Thread.sleep(2000);

		// selecting itemwise and download inovice
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		Thread.sleep(1000);
		WebDriverWait servicewise = new WebDriverWait(driver, Duration.ofSeconds(30));
		servicewise
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Servicewise'])[1]"))))
				.click();
		Thread.sleep(3000);

	}

	@And("download the Invoice_receipt_totaladvance_printpdf1")
	public void download_the_invoice_receipt_totaladvance_printpdf1() throws Exception {
		// OP -Invoice pdf
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// mouse hovering on the discount i icon
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("i.fa.fa-info-circle.tooltipped:nth-of-type(1)")))
				.build().perform();
		Thread.sleep(2000);
		// receipt download
		WebElement receipt1 = driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[2]/div[2]/a[1]"));
		JavascriptExecutor rpt1 = (JavascriptExecutor) driver;
		rpt1.executeScript("arguments[0].scrollIntoView(true)", receipt1);
		// driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[2]/div[2]/a")).click();
		Thread.sleep(1000);

		WebElement receipt2 = driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[3]/div[2]/a[1]"));
		JavascriptExecutor rpt2 = (JavascriptExecutor) driver;
		rpt2.executeScript("arguments[0].scrollIntoView(true)", receipt2);
		// driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[3]/div[2]/a")).click();
		Thread.sleep(1000);

		WebElement receipt3 = driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[4]/div[2]/a[1]"));
		JavascriptExecutor rpt3 = (JavascriptExecutor) driver;
		rpt3.executeScript("arguments[0].scrollIntoView(true)", receipt3);
		// driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[4]/div[2]/a")).click();
		Thread.sleep(1000);

//		WebElement receipt4 = driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[5]/div[2]/a[1]"));
//		JavascriptExecutor rpt4 = (JavascriptExecutor) driver;
//		rpt4.executeScript("arguments[0].scrollIntoView(true)", receipt4);
//		// driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[4]/div[2]/a")).click();
//		Thread.sleep(1000);

		// driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[5]/div[2]/a")).click();
		Thread.sleep(1000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		Actions receipt = new Actions(driver);
		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);
//		// pdf downloading
//		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[3]/div[1]/strong/span/a/img")).click();
//		Thread.sleep(1000);
		// print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(4000);
		// print without details
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(4000);

	}

	@Then("click on shareinvoice1 button")
	public void click_on_shareinvoice1_button() throws Exception {
		// share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(3000);
	}

	@And("clears existing mail and phone for ambulance appointment")
	public void clears_existing_mail_and_phone_for_ambulance_appointment() {
	}

	@Then("enter phone and click on submit button  for shareinvoice1")
	public void enter_phone_and_click_on_submit_button_for_shareinvoice1() throws Exception {
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).sendKeys("8790098500");
		Thread.sleep(1000);
		// submit
		WebElement sub = driver.findElement(By.xpath("/html/body/main/div/div[13]/div/div[2]/form/div[2]/input"));
		sub.click();
		Thread.sleep(15000);
	}

	@When("user click on patientsname from ambulance proformainvoicepage")
	public void user_click_on_patientsname_from_ambulance_proformainvoicepage() throws Exception {
		// clicking on the patient name
		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(2000);

	}

	@Then("patientprofile page will be opened")
	public void patientprofile_page_will_be_opened() {
	}

	@When("user click on bookhomecareservice from book appointment")
	public void user_click_on_bookhomecareservice_from_book_appointment() throws Exception {
		// mouse hover on the hcs
		Actions hcs = new Actions(driver);
		hcs.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Home Care Service'])/img[1]"))).build()
				.perform();
		Thread.sleep(1000);

		// clicking on the homecareservices img icon
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Book Home Care Service'])/img[1]"))))
				.click();
//		driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(10)>img")).click();
		Thread.sleep(3000);
	}

	@Then("services page will open")
	public void services_page_will_open() {

	}

	@And("select the homecare services and remove one of the selected services")
	public void select_the_homecare_services_and_remove_one_of_the_selected_services() throws Exception {
		// adding the services
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[text()='add'])[3]")).click();
		Thread.sleep(2000);

		// removing last added
		driver.findElement(By.xpath("(//i[text()='remove'])[3]")).click();
		Thread.sleep(2000);
	}

	@Then("click on checkout button from homecare service page")
	public void click_on_checkout_button_from_homecare_service_page() throws Exception {
		// clicking on the checkout
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		Thread.sleep(2000);
	}

	@And("select the location and address")
	public void select_the_location_and_address() throws Exception {
//		// clicking on the addresss
//		driver.findElement(By.xpath(
//				"/html/body/main/div/div[3]/div/div/div[2]/form/ul/li[1]/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div/div/div[2]"))
//				.click();
//		Thread.sleep(1000);
	}

	@Then("select the start date and end date with timings")
	public void select_the_start_date_and_end_date_with_timings() throws Exception {
//		// start date
//		driver.findElement(By.cssSelector("input#appointment_tracking_apmnt_date")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
//		// driver.findElement(By.xpath("//button[text()='21']")).click();
//		Thread.sleep(1000);
//		// start time
//		driver.findElement(By.id("start_time")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div[text()='11']")).click();
//		Thread.sleep(2000);
//		// am
//		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div[text()='00']")).click(); // 00
//		Thread.sleep(2000);
//		// clicking on the ok
//		driver.findElement(By.xpath("(//button[text()='Ok'])[1]")).click();
//		Thread.sleep(1000);
//		// end date
//		driver.findElement(By.cssSelector("input#appointment_tracking_apmnt_end_date")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click(); // 10
//		Thread.sleep(1000);
//		// end time
//		driver.findElement(By.name("hc_end_time")).click();
//		Thread.sleep(1000);
//		// selecting time
//		driver.findElement(By.xpath("(//div[text()='3'])[2]")).click(); // 4
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[2]/div[2]")).click(); // pm
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//div[text()='00'])[2]")).click(); // 00
//		Thread.sleep(1000);
//		// clicking on the ok
//		driver.findElement(By.xpath("(//button[text()='Ok'])[2]")).click();
//		Thread.sleep(1000);
//		// clicking on the continue
//		driver.findElement(By.cssSelector("div.step-actions>button:nth-of-type(1)")).click();
//		Thread.sleep(1000);
	}

	@And("enter the age and click on continue")
	public void enter_the_age_and_click_on_continue() throws Exception {
//		// selecting sex radio button
//		WebElement fm = driver.findElement(By.xpath("(//label[text()='F'])[1]"));
//		fm.click();
//		Thread.sleep(1000);
//		// entering the age
//		driver.findElement(By.cssSelector("input#age")).sendKeys("35");
//		Thread.sleep(1000);
//		// clicking on the continue
//		driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div/div[2]/form/ul/li[3]/div[2]/div[3]/button"))
//				.click();
//		Thread.sleep(3000);
	}

	@Then("changing time in the invoice page")
	public void changing_time_in_the_invoice_page() throws Exception {
//		// selecting the time-slot
//		driver.findElement(By.cssSelector("input#appointment_tracking_slot_time")).click();
//		Thread.sleep(1000);
//		// 6pm
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[3]/following-sibling::div[1]/div[6]")).click();
//		Thread.sleep(1000);
//		// 30mins
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[3]/following-sibling::div[2]/div[7]")).click();
//		Thread.sleep(1000);
//		// PM
//		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[3]/div[2]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// ok
//		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[3]/button[2]")).click();
//		Thread.sleep(2000);
	}

	@And("clicking on submit button")
	public void clicking_on_submit_button() throws Exception {
		// clicking on the submit
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
	}

	@Then("it will open the proformainvoice page for homecareservice")
	public void it_will_open_the_proformainvoice_page_for_homecareservice() throws Exception {
//		System.out.println("you are in the proforma invoice page.");
		// deleting the one invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Delete Item'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// yes
		driver.findElement(By.xpath("(//a[text()='Yes'])[2]")).click();
		Thread.sleep(3000);
	}

	@And("changing the comments by clearing existing comment beside services name")
	public void changing_the_comments_by_clearing_existing_comment_beside_services_name() throws Exception {
		driver.findElement(By.xpath("(//i[@class='fa fa-comment pointer'])[1]")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("(//input[@id='btnCmntClear'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// entering comment
		driver.findElement(By.xpath("(//textarea[@class='materialize-textarea'])[1]"))
				.sendKeys("Home care services comment 1");
		Thread.sleep(1000);
		// submit
		driver.findElement(
				By.xpath("(//div[@class='modal nh_modal invoiceCommentModal open'])[1]/div[1]/div[3]/div[1]/input[1]"))
				.click();
		Thread.sleep(3000);

//		driver.findElement(By.xpath("(//i[@class='fa fa-comment pointer'])[2]")).click();
//		Thread.sleep(1000);
//		// reset
//		driver.findElement(By.xpath("(//input[@id='btnCmntClear'])[2]")).click();
//		Thread.sleep(1000);
//		// entering comment
//		driver.findElement(By.xpath("(//textarea[@class='materialize-textarea'])[2]"))
//				.sendKeys("Home care services comment 2");
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.xpath("(//input[@value='Submit'])[2]")).click();
//		Thread.sleep(1000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
		// editing the amount for service
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#net_pay")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("input#net_pay")).sendKeys("250");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//div[@id='invoiceNetPay'])[1]/div/div[2]/form/div[1]/span/input[1]")).click();
		Thread.sleep(2000);
	}

	@And("edit the invoice date for home care services")
	public void edit_the_invoice_date_for_home_care_services() throws Exception {
		// clicking on the edit invoice date
		driver.findElement(By.xpath("(//a[@class='edit-invoice-date'])[1]/i[1]")).click();
		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("input#created_at")).click();
		LocalDate today = LocalDate.now();
		int previousWeekDay = today.minusDays(1).getDayOfMonth(); // one day ago
		System.out.println("Date to select (one day ago): " + previousWeekDay);

		// Step 4: Locate all the day elements in the calendar
		List<WebElement> dateElements = driver.findElements(By.xpath("//button[@class='datepicker-day-button']"));

		// Step 5: Iterate through the list and find the required date
		for (WebElement dateElement : dateElements) {
			if (dateElement.getText().equals(String.valueOf(previousWeekDay))) {
				System.out.println("Clicking on date: " + dateElement.getText());
				dateElement.click();
				break;
			}
		}

		System.out.println("Previous date selected successfully!");
		Thread.sleep(2000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@Then("select pay later option from the payments")
	public void select_pay_later_option_from_the_payments() throws Exception {
		WebElement paylater = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
		paylater.click();
		Thread.sleep(1000);
	}

//	@And("select the paymentmode as insured")
//	public void select_the_paymentmode_as_insured() throws Exception {
//		WebElement insured = driver.findElement(By.xpath("(//label[text()='Insured'])[1]"));
//		insured.click();
//		Thread.sleep(2000);
//	}
//
//	@When("user selects the insured then popup will open that no valid insurer is associated")
//	public void user_selects_the_insured_then_popup_will_open_that_no_valid_insurer_is_associated() {
//
//	}
//
//	@Then("click on the yes button from no insurer popup")
//	public void click_on_the_yes_button_from_no_insurer_popup() throws Exception {
//		driver.findElement(By.xpath("(//a[text()='Yes'])[1]")).click();
//		Thread.sleep(3000);
//	}
//
//	@And("select the insurance_radio_button from the new insurer popup")
//	public void select_the_insurance_radio_button_from_the_new_insurer_popup() throws Exception {
//		WebElement insurance = driver.findElement(By.xpath("(//label[text()='Insurance'])[2]"));
//		insurance.click();
//		Thread.sleep(1000);
//	}
//
//	@Then("enter the insurance details in the new insurer popup")
//	public void enter_the_insurance_details_in_the_new_insurer_popup() throws Exception {
//		// id number
//		driver.findElement(By.cssSelector("input#insurance_policy_detail_id_card")).sendKeys("123");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// policy no
//		driver.findElement(By.cssSelector("input#insurance_policy_detail_policy_no")).sendKeys("1234567890");
//		Thread.sleep(1000);
//		// date
//		driver.findElement(By.cssSelector("input#insurance_policy_detail_policy_start_date")).click();
//		Thread.sleep(1000);
//		// today date
//		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
//		Thread.sleep(1000);
//		// insurance company
//		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
//		Robot robot1 = new Robot();
//		robot1.keyPress(KeyEvent.VK_UP);
//		Thread.sleep(1000);
//		Robot robot2 = new Robot();
//		robot2.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
//
//		// TPA
//		driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//		Robot r1 = new Robot();
//		r1.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
//		Robot r2 = new Robot();
//		r2.keyPress(KeyEvent.VK_UP);
//		Thread.sleep(1000);
//		Robot r3 = new Robot();
//		r3.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
//	}
//
//	@And("click on the submit button from the new insurer popup")
//	public void click_on_the_submit_button_from_the_new_insurer_popup() throws Exception {
//		driver.findElement(By.cssSelector("input.btn.right.green.ins_submit.btn-loader")).click();
//		Thread.sleep(3000);
//		Robot pgdw = new Robot();
//		pgdw.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//	}
//
//	@Then("select the payment mode as insured radio button again")
//	public void select_the_payment_mode_as_insured_radio_button_again() throws Exception {
//		WebElement insured = driver.findElement(By.xpath("(//label[text()='Insured'])[1]"));
//		insured.click();
//		Thread.sleep(2000);
//	}
//
//	@And("select the insurance radio button under the payment mode")
//	public void select_the_insurance_radio_button_under_the_payment_mode() throws Exception {
//		WebElement ins = driver.findElement(By.xpath("(//label[text()='Insurance'])[1]"));
//		ins.click();
//		Thread.sleep(2000);
//	}
//
//	@When("insurance is selected it will show the provide also in the dropdown")
//	public void insurance_is_selected_it_will_show_the_provide_also_in_the_dropdown() {
//	}

	@Then("click on the submit button inthe proformainvoice2")
	public void click_on_the_submit_button_inthe_proformainvoice2() throws Exception {
		// clicking on the submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a#bookLater")))).click();
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
	}

	@And("download the Invoice_receipt_totaladvance_printpdf2")
	public void download_the_invoice_receipt_totaladvance_printpdf2() throws Exception {
		// OP invoice pdf
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
//		// clicking on the receipt id
//		driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[2]/div[2]/a")).click();
//		Thread.sleep(2000);
//		// clicking on the total receipt
//		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[3]/div[1]/strong/span/a/img")).click();
//		Thread.sleep(2000);
		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(2000);
	}

	@Then("click on the invoice id to generate the invoice id")
	public void click_on_the_invoice_id_to_generate_the_invoice_id() throws Exception {
		// clicking on the invoice id button
		driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[2]")).click();
		Thread.sleep(5000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@Then("click on shareinvoice2 button")
	public void click_on_shareinvoice2_button() throws Exception {
		// clicking on the share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(5000);
	}

	@And("clears existing mail and phone for homecareservices appointment")
	public void clears_existing_mail_and_phone_for_homecareservices_appointment() {
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("enter mail and click on submit button for shareinvoice2")
	public void enter_mail_and_click_on_submit_button_for_shareinvoice2() throws Exception {
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebElement submit1 = driver.findElement(By.xpath("/html/body/main/div/div[13]/div/div[2]/form/div[2]/input"));
		submit1.click();
		Thread.sleep(17000);
	}

	@When("user click on patientsname from homecareservices proformainvoicepage")
	public void user_click_on_patientsname_from_homecareservices_proformainvoicepage() throws Exception {
//		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
//		Thread.sleep(2000);
//		// close for pending amount
//		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
//			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.id("admin-billing-tab")).click();
//			Thread.sleep(1000);
//		}
		// searching patient and booking diagnostic from search bar.
		driver.findElement(By.cssSelector("input#frst_nm")).sendKeys("Cucumoppatient");
		Thread.sleep(2000);
		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);

	}

	@Then("patientprofile page will open")
	public void patientprofile_page_will_open() {
	}

	@When("user click on bookdiagnostic from book appointment")
	public void user_click_on_bookdiagnostic_from_book_appointment() throws Exception {
		// mouse hover on the diagnostic booking
		Actions diag = new Actions(driver);
		diag.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])/img")))
				.build().perform();
		Thread.sleep(1000);
//		// clicking on the book diagonstic appointment
//		driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(3)>img")).click();
//		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Book Diagnostic Appointment'])/img[1]")).click();
		Thread.sleep(3000);
	}

	@Then("it will show the avaible labs and tests")
	public void it_will_show_the_avaible_labs_and_tests() {
	}

	@When("select lab from the dropdown")
	public void select_lab_from_the_dropdown() throws Exception {
		// clicking on the drop down
		driver.findElement(By.cssSelector("span.selection")).click();
		Thread.sleep(2000);
		// thyrocare
		driver.findElement(By.xpath("(//li[text()='NanoHealth_Lab1'])[1]")).click();
		Thread.sleep(10000);
	}

	@Then("avaible tests from that lab will be reflected")
	public void avaible_tests_from_that_lab_will_be_reflected() {

	}

	@And("select the diagnostic services and remove one of the selected services")
	public void select_the_diagnostic_services_and_remove_one_of_the_selected_services() throws Exception {
		// clicking on the plus
		driver.findElement(By.xpath("(//a/i[text()='add'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a/i[text()='add'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a/i[text()='add'])[1]")).click();
		Thread.sleep(2000);
		// removing last added
		driver.findElement(By.xpath("(//a/i[text()='remove'])[5]")).click();
		Thread.sleep(2000);
	}

	@Then("click on checkout button from diagnostic service page")
	public void click_on_checkout_button_from_diagnostic_service_page() throws Exception {
		// clicking on the checkout button
		driver.findElement(By.cssSelector("a.btn-loader.btn.checkout.btn-block")).click();
		Thread.sleep(2000);
	}

	@And("select the type")
	public void select_the_type() throws Exception {
		// selecting the type - Lab Visit
		driver.findElement(By.xpath("(//div[@class='icon'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("select the address for the selected lab")
	public void select_the_address_for_the_selected_lab() throws Exception {
//		// selecting the location - address
//		driver.findElement(
//				By.xpath("(//div[@id='lab_saved-addresses'])[1]//following-sibling::div/div/div/div/div/span[1]"))
//				.click();
//		Thread.sleep(2000);
	}

	@And("select the slot for diagnostic appointment")
	public void select_the_slot_for_diagnostic_appointment() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Find all available slots
		List<WebElement> slots = driver
				.findElements(By.xpath("//div[@class='slots-container']//span[contains(text(), 'PM')]"));

		if (!slots.isEmpty()) {
			for (WebElement slot : slots) {
				if (slot.isDisplayed() && slot.isEnabled()) {
					try {
						wait.until(ExpectedConditions.elementToBeClickable(slot));
						js.executeScript("arguments[0].scrollIntoView(true);", slot);
						Thread.sleep(500); // Small pause to ensure visibility
						js.executeScript("arguments[0].click();", slot);
						System.out.println("Selected time slot: " + slot.getText());
						break;
					} catch (Exception e) {
						System.out.println("Failed to click slot: " + slot.getText());
					}
				}
			}
		} else {
			System.out.println("No available time slots found.");
		}
//		Robot robot = new Robot();
//		for (int i = 0; i <= 1; i++) {
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_SUBTRACT);
//			Thread.sleep(1000);
//			robot.keyRelease(KeyEvent.VK_SUBTRACT);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			Thread.sleep(1000);
//		}
////		// clicking on the tomorrow
////		driver.findElement(By.xpath("(//div[@class='col s4 date tomorrow'])[1]")).click();
////		Thread.sleep(3000);
////		driver.findElement(By.xpath("(//div[@class='col s4 date tomorrow'])[1]")).sendKeys(Keys.PAGE_DOWN);
////		Thread.sleep(1000);
//
//		if (driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[2]/div[2]/div/div[1]/span"))
//				.isDisplayed()) {
//			// afternoon slot
//			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[2]/div[2]/div/div[1]/span")).click();
//			Thread.sleep(1000);
//		} else if (driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[3]/div[2]/div/div[1]/span"))
//				.isDisplayed()) {
//			// evening slot
//			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[3]/div[2]/div/div[1]/span")).click();
//			Thread.sleep(1000);
//		} else {
//			// night slot
//			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[4]/div[2]/div/div[1]/span")).click();
//			Thread.sleep(1000);
//		}
//		Thread.sleep(1000);

		// selecting the time-slot
		driver.findElement(By.xpath("(//input[@id='appointment_tracking_slot_time'])[1]")).click();
		Thread.sleep(1000);
		// 6
		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[1]/following-sibling::div[1]/div[6]")).click();
		Thread.sleep(1000);
		// 30
		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[1]/following-sibling::div[2]/div[7]")).click();
		Thread.sleep(1000);
		// pm
		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[2]")).click();
		Thread.sleep(1000);
		// ok
		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
//		

	}

	@Then("enter referredby delivery charges")
	public void enter_referredby_delivery_charges() throws Exception {
		// entering referred by
		driver.findElement(By.xpath("(//input[@id='referred_by'])[1]")).sendKeys("d");
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//div[text()='Dr.Sneha R , , ']")).click();
		Thread.sleep(1000);
		// entering the delivery charges
		driver.findElement(By.xpath("(//input[@id='delivery_charges'])[1]")).sendKeys("50");
		Thread.sleep(2000);
	}

	@And("select the notify patient checkboxes for diagnostic booking")
	public void select_the_notify_patient_checkboxes_for_diagnostic_booking() throws Exception {
		// clicking on the check boxes
		WebElement cbox1 = driver.findElement(By.xpath("(//label[text()='Email'])[1]"));
		cbox1.click();
		WebElement cbox2 = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
		cbox2.click();
		Thread.sleep(1000);
	}

	@Then("click on submit from paymentpage for diagnostic booking")
	public void click_on_submit_from_invoicepage_for_diagnostic_booking() throws Exception {
		// clicking on the submit
		driver.findElement(By.id("btn-loader")).click();
		Thread.sleep(2000);
		Robot robot5 = new Robot();
		robot5.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

//		robot5.keyPress(KeyEvent.VK_CONTROL);
//		robot5.keyPress(KeyEvent.VK_SUBTRACT);
//		robot5.keyRelease(KeyEvent.VK_SUBTRACT);
//		robot5.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(2000);
	}

	@Then("it will open the proformainvoice page for diagnostic booking")
	public void it_will_open_the_proformainvoice_page_for_diagnostic_booking() {

	}

	@And("give the hundered percent discount and apply")
	public void give_the_hundered_percent_discount_and_apply() throws Exception {
		driver.findElement(By.cssSelector("input#promo_disc")).sendKeys("100");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span#applyCouponModal")).click();
		Thread.sleep(2000);
		// entering comments
		driver.findElement(By.cssSelector("textarea#comments")).sendKeys("applied 100% discount");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#applyCouponBtn")).click();
		Thread.sleep(5000);
	}

	@Then("click on the submit button inthe proformainvoice3")
	public void click_on_the_submit_button_inthe_proformainvoice3() throws Exception {
		// clicking on the submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
	}

	@And("download the Invoice_receipt_totaladvance_printpdf3")
	public void download_the_invoice_receipt_totaladvance_printpdf3() throws Exception {
//		Robot robot5 = new Robot();
//		robot5.keyPress(KeyEvent.VK_CONTROL);
//		robot5.keyPress(KeyEvent.VK_ADD);
//		robot5.keyRelease(KeyEvent.VK_ADD);
//		robot5.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(2000);
		// OP invoice
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		// clicking on the apt id
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//div[@class='row summary'])[1]/div[2]/a")))).click();
		Thread.sleep(3000);
		// downloading op invoice
		driver.findElement(By.xpath("(//a[@class='right tooltipped service_wise_pdf'])[1]/img[1]")).click();
		Thread.sleep(3000);
		// clicking on the invoice
		driver.findElement(By.xpath("(//a[text()='Invoice'])[4]")).click();
		Thread.sleep(5000);

		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
//		// clicking on the receipt id
//		driver.findElement(By.xpath("//div[@class='card'][1]/div/div[5]/div[2]/div[2]/a")).click();
//		Thread.sleep(2000);

//		Actions receipt = new Actions(driver);
//		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build().perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
//		Thread.sleep(2000);
//		// clicking on the total advance
//		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[3]/div[1]/strong/span/a/img")).click();
//		Thread.sleep(2000);
		// mouse hover on the i button to show discount
		Actions discount = new Actions(driver);
		discount.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-info-circle tooltipped'])[1]"))).build()
				.perform();
		Thread.sleep(2000);
		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(3000);
		// clicking on the print without details
		driver.findElement(By.xpath("(//a[@data-tooltip='Print without details'])[1]/i")).click();
		Thread.sleep(3000);
	}

	@Then("click on shareinvoice3 button")
	public void click_on_shareinvoice3_button() throws Exception {
		// clicking on the share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(5000);
	}

	@And("clears existing mail and phone for diagnostic appointment")
	public void clears_existing_mail_and_phone_for_diagnostic_appointment() throws Exception {
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("phone")).clear();
		Thread.sleep(1000);
	}

	@Then("enter mail and click on submit button for shareinvoice3")
	public void enter_mail_and_click_on_submit_button_for_shareinvoice3() throws Exception {
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// clicking on the submit button
		driver.findElement(By.xpath("/html/body/main/div/div[13]/div/div[2]/form/div[2]/input")).click();
		Thread.sleep(18000);
	}

	@When("user click on patientsname from diagnostic proformainvoicepage")
	public void user_click_on_patientsname_from_diagnostic_proformainvoicepage() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
		Thread.sleep(3000);
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
			// driver.findElement(By.id("admin-billing-tab")).click();
			Thread.sleep(1000);
		}
	}

	@Then("patientprofile  will be open")
	public void patientprofile_will_be_open() {
//		System.out.println("you are in the patient profile.");
	}

//	@When("user click on bookdietitianappointment from book appointment")
//	public void user_click_on_bookdietitianappointment_from_book_appointment() throws Exception {
//		// clicking on the book dietician
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(2)>img"))))
//				.click();
////		driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(2)>img")).click();
//		Thread.sleep(3000);
//	}
//
//	@Then("list of avaible dietitians will be displayed")
//	public void list_of_avaible_dietitians_will_be_displayed() {
//
//	}
//
//	@And("select the dietitan and click on book appointment")
//	public void select_the_dietitan_and_click_on_book_appointment() throws Exception {
//		// clicking on the book appointment
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(
//				driver.findElement(By.cssSelector("a.modal-trigger.waves-effect.btn.green.right:nth-of-type(1)"))))
//				.click();
////		driver.findElement(By.cssSelector("a.modal-trigger.waves-effect.btn.green.right:nth-of-type(1)")).click();
//		Thread.sleep(3000);
//	}
//
//	@Then("select the type and slot for dietitan appointment")
//	public void select_the_type_and_slot_for_dietitan_appointment() throws Exception {
//		// clicking on the video
//		driver.findElement(By.xpath("(//div[@class='icon'])[2]")).click();
//		Thread.sleep(2000);
//		// clicking on the date and time
//		driver.findElement(
//				By.xpath("/html/body/main/div/div[3]/div/div/div[2]/form/ul/li[3]/div[2]/div[2]/div[1]/div[2]"))
//				.click(); // 13-12-2022
//		Thread.sleep(2000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//
//		// clicking on the slot
//		if (driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[2]/div[2]/div/div/span[1]"))
//				.isDisplayed()) {
//			// afternoon slot
//			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[2]/div[2]/div/div/span[1]")).click();
//			Thread.sleep(1000);
//		} else if (driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[3]/div[2]/div/div/span[1]"))
//				.isDisplayed()) {
//			// evening slot
//			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[3]/div[2]/div/div/span[1]")).click();
//			Thread.sleep(1000);
//		} else {
//			// morning slot
//			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[1]/div[2]/div/div/span[1]")).click();
//			Thread.sleep(1000);
//		}
//		Thread.sleep(1000);
//	}
//
//	@And("here we can change timings")
//	public void here_we_can_change_timings() throws Exception {
//		// clicking on the slot time
//		driver.findElement(By.id("appointment_tracking_slot_time")).click();
//		Thread.sleep(1000);
//		// 6
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[1]/following-sibling::div[1]/div[6]")).click();
//		Thread.sleep(1000);
//		// 30 mins
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[1]/following-sibling::div[2]/div[7]")).click();
//		Thread.sleep(1000);
//		// pm
//		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[2]")).click();
//		Thread.sleep(1000);
//		// ok
//		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
//		Thread.sleep(1000);
//	}
//
//	@Then("select the checkboxes for notifypatient for dietitanappointment")
//	public void select_the_checkboxes_for_notifypatient_for_dietitanappointment() throws Exception {
//		// clicking on the reg.fees cbox
//		WebElement cbox = driver.findElement(By.xpath("(//label[text()='50'])[1]"));
//		cbox.click();
//		Thread.sleep(1000);
//		// clicking on the notify
//		WebElement gmail = driver.findElement(By.xpath("(//label[text()='Email'])[1]"));
//		gmail.click();
//		Thread.sleep(1000);
//		WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
//		sms.click();
//		Thread.sleep(1000);
//	}
//
//	@And("click on the submit from paymentpage for dietitanappointment")
//	public void click_on_the_submit_from_paymentpage_for_dietitanappointment() throws Exception {
//		// clicking on the submit
//		driver.findElement(By.id("bookNowBtn")).click();
//		Thread.sleep(2000);
//		Robot robot1 = new Robot();
//		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//	}
//
//	@Then("it will open proformainvoice page for dietitanappointment")
//	public void it_will_open_proformainvoice_page_for_dietitanappointment() {
//
//	}
//
//	@And("select the paymentmethods4")
//	public void select_the_paymentmethods4() throws Exception {
//		WebElement other = driver.findElement(By.xpath("//label[text()='Other']"));
//		other.click();
//		Thread.sleep(2000);
//		// phonepe
//		driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[4]/span/img")).click();
//		Thread.sleep(1000);
//		// transaction id
//		driver.findElement(By.cssSelector("input#other_txn_id")).sendKeys("123456");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// entering the amount
//		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("250");
//		Thread.sleep(2000);
//	}
//
//	@When("user enters the transactionamount then receiptcomment will visible")
//	public void user_enters_the_transactionamount_then_receiptcomment_will_visible() throws Exception {
//
//	}
//
//	@Then("click on receiptcomment and enter the comment")
//	public void click_on_receiptcomment_and_enter_the_comment() throws Exception {
//		// clicking on the comment
//		driver.findElement(By.cssSelector("i#paymentComment")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// comment
//		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test receipt comment");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// submit
//		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}
//
//	@Then("click on the submit button inthe proformainvoice4")
//	public void click_on_the_submit_button_inthe_proformainvoice4() throws Exception {
//		// clicking on the submit
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
////		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
//		Thread.sleep(2000);
//	}
//
//	@And("download the Invoice_receipt_totaladvance_printpdf4")
//	public void download_the_invoice_receipt_totaladvance_printpdf4() throws Exception {
//		// printing
//		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
//		Thread.sleep(2000);
//		Robot robot4 = new Robot();
//		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
//		// clicking on the receipt id
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[2]/div[2]/a")).click();
//		Thread.sleep(2000);
//		// clicking on the receipt id 2
//		// driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[3]/div[2]/a")).click();
//		// Thread.sleep(2000);
//		// clicking on the total receipt
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[3]/div[1]/strong/span/a/img"))
//				.click();
//		Thread.sleep(2000);
//		// clicking on the print
//		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(1000);
//	}
//
//	@Then("click on shareinvoice4 button")
//	public void click_on_shareinvoice4_button() throws Exception {
//		// clicking on the share invoice
//		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
//		Thread.sleep(5000);
//	}
//
//	@And("clears existing mail and phone for dietitianappointment")
//	public void clears_existing_mail_and_phone_for_dietitianappointment() {
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("phone")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}
//
//	@Then("enter mail and click on submit button for shareinvoice4")
//	public void enter_mail_and_click_on_submit_button_for_shareinvoice4() throws Exception {
//		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// clicking on the submit
//		WebElement sub = driver.findElement(By.xpath("/html/body/main/div/div[12]/div/div[2]/form/div[2]/input"));
//		sub.click();
//		Thread.sleep(18000);
//	}
//
//	@When("user click on patientsname from dietitian proformainvoicepage")
//	public void user_click_on_patientsname_from_dietitian_proformainvoicepage() throws Exception {
//		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
//		Thread.sleep(2000);
//		// close for pending amount
//		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
//			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.id("admin-billing-tab")).click();
//			Thread.sleep(1000);
//		}
//	}
//
//	@Then("patientprofile  will be opened")
//	public void patientprofile_will_be_opened() {
//	}

//	@When("user click on bookpharmacyorder from book appointment")
//	public void user_click_on_bookpharmacyorder_from_book_appointment() throws Exception {
//		// clicking on the book pharmacy order
//		driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(5)>img")).click();
//		Thread.sleep(2000);
//	}
//
//	@Then("new order page will be opened")
//	public void new_order_page_will_be_opened() {
//		System.out.println("new pharmacy order page is opened");
//	}
//
//	@And("enter the doctorname")
//	public void enter_the_doctorname() throws Exception {
//		// enterng the doctor name
//		driver.findElement(By.cssSelector("input#prescription_sale_order_header_doctor_name")).sendKeys("sunil");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input#prescription_sale_order_header_doctor_name")).sendKeys(Keys.DOWN);
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input#prescription_sale_order_header_doctor_name")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//	}
//
//	@Then("search and select a brandmaster and enter the quantity")
//	public void search_and_select_a_brandmaster_and_enter_the_quantity() throws Exception {
//		// entering the brand name
//		driver.findElement(By.id("prescription_sale_order_header_prescription_order_lines_attributes_0_brand_name"))
//				.sendKeys("Dola");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[text()='DOLAMIDE'])[1]")).click();
//		Thread.sleep(2000);
////		Robot robot6 = new Robot();
////		robot6.keyPress(KeyEvent.VK_ENTER);
////		Thread.sleep(2000);
//		// selecting the batch
//		if (driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/form/div[4]/div[4]/ul/li[1]/div/div[2]/a"))
//				.isDisplayed()) {
//			driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/form/div[4]/div[4]/ul/li[1]/div/div[2]/a"))
//					.click();
//			Thread.sleep(2000);
//		} else {
//			// quantity
//			driver.findElement(By.id("prescription_sale_order_header_prescription_order_lines_attributes_0_quantity"))
//					.sendKeys("1");
//			Thread.sleep(2000);
//		}
////		driver.findElement(By.xpath("(//li[@class='collection-item'])[2]/div/div[2]/a")).click();
////		Thread.sleep(2000);
//		// quantity
//		driver.findElement(By.id("prescription_sale_order_header_prescription_order_lines_attributes_0_quantity"))
//				.clear();
//		Thread.sleep(1000);
//		// quantity
//		driver.findElement(By.id("prescription_sale_order_header_prescription_order_lines_attributes_0_quantity"))
//				.sendKeys("1");
//		Thread.sleep(2000);
//	}
//
//	@And("adding another and removing it")
//	public void adding_another_and_removing_it() throws Exception {
//		// clicking on the add plus
//		driver.findElement(By.cssSelector("a.btn-floating.red.medicine_add.add_fields>i")).click();
//		Thread.sleep(1000);
//		// removing last added
//		driver.findElement(By.xpath("(//a[@class='remove_fields dynamic'])[2]/i")).click();
//		Thread.sleep(2000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
//	}
//
//	@Then("click on delivery_button")
//	public void click_on_delivery_button() throws Exception {
//		// clicking on the deliver
//		driver.findElement(By.id("saveBtn")).click();
//		Thread.sleep(2000);
//	}
//
//	@When("user select the pharmacy fill date and click on submit")
//	public void user_select_the_pharmacy_fill_date_and_click_on_submit() throws Exception {
//		// refill date
//		driver.findElement(By.cssSelector("input#refill-date")).click();
//		Thread.sleep(1000);
//		// 28
//		driver.findElement(By.xpath("//button[text()='28']")).click();
//		Thread.sleep(2000);
//		// submit
//		driver.findElement(By.cssSelector("input#refillButton")).click();
//		Thread.sleep(2000);
//		Robot robot1 = new Robot();
//		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
//	}
//
//	@Then("it will open proformainvoice page for pharmacyorder")
//	public void it_will_open_proformainvoice_page_for_pharmacyorder() {
//
//	}
//
//	@And("select the paymentmethods5")
//	public void select_the_paymentmethods5() throws Exception {
//		// cash
//		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
//		cash.click();
//		Thread.sleep(1000);
//	}
//
//	@When("user enters_the transaction_amount then receipt_comment will visible")
//	public void user_enters_the_transaction_amount_then_receipt_comment_will_visible() throws Exception {
//		// amount entering
//		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("1");
//		Thread.sleep(2000);
//	}
//
//	@Then("click on receipt_comment and enter_comment")
//	public void click_on_receipt_comment_and_enter_comment() {
//		// clicking on the comment
//		driver.findElement(By.cssSelector("i#paymentComment")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// comment
//		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test receipt comment");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//
//	}
//
//	@Then("click on the submit button inthe proformainvoice5")
//	public void click_on_the_submit_button_inthe_proformainvoice5() throws Exception {
//		// submit
//		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// submit
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
//		Thread.sleep(2000);
//	}
//
//	@And("download the Invoice_receipt_totaladvance_printpdf5")
//	public void download_the_invoice_receipt_totaladvance_printpdf5() throws Exception {
//		// printing
//		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
//		Thread.sleep(2000);
//		Robot robot2 = new Robot();
//		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
//		// clicking on the receipt id
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[2]/div[2]/a")).click();
//		Thread.sleep(2000);
//		// print pdf
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[3]/div[1]/strong/span/a")).click();
//		Thread.sleep(2000);
//		// print
//		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(2000);
//	}
//
//	@Then("click on shareinvoice5 button")
//	public void click_on_shareinvoice5_button() throws Exception {
//		// share invoice
//		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
//		Thread.sleep(5000);
//	}
//
//	@And("clears existing mail and phone for pharmacyorder")
//	public void clears_existing_mail_and_phone_for_pharmacyorder() {
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("phone")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}
//
//	@Then("enter mail and click on submit button for shareinvoice5")
//	public void enter_mail_and_click_on_submit_button_for_shareinvoice5() throws Exception {
//		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// submit
//		WebElement sub = driver.findElement(By.xpath("/html/body/main/div/div[12]/div/div[2]/form/div[2]/input"));
//		sub.click();
//		Thread.sleep(18000);
//	}
//
//	@When("user click on patientsname from pharmacyorder proformainvoicepage")
//	public void user_click_on_patientsname_from_pharmacyorder_proformainvoicepage() throws Exception {
//		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
//		Thread.sleep(2000);
//	}
//
//	@Then("patientprofile  will opens")
//	public void patientprofile_will_opens() {
//	}

//	@When("user click on vaccineappointment from book appointment")
//	public void user_click_on_vaccineappointment_from_book_appointment() throws Exception {
//		// mouse hover on the vaccine booking
//		Actions vac = new Actions(driver);
//		vac.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Vaccine Appointment'])/img[1]")))
//				.build().perform();
//		Thread.sleep(1000);
//		// clicking on the booking vaccine appointment img icon
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Book Vaccine Appointment'])/img[1]"))))
//				.click();
//		// driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(6)>img")).click();
//		Thread.sleep(2000);
//	}
//
//	@Then("list of vaccines will be displayed")
//	public void list_of_vaccines_will_be_displayed() {
////		System.out.println("list of vaccinations are displayed");
//	}
//
//	@And("select the vaccines and remove one of them and click on checkout")
//	public void select_the_vaccines_and_remove_one_of_them_and_click_on_checkout() throws Exception {
//		// clicking on the plus
//		driver.findElement(By.xpath("(//a/i[text()='add'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a/i[text()='add'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a/i[text()='add'])[1]")).click();
//		Thread.sleep(1000);
//		// removing last added
//		driver.findElement(By.xpath("(//i[text()='remove'])[6]")).click();
//		Thread.sleep(2000);
//		// checkout
//		driver.findElement(By.cssSelector("a.waves-effect.btn.checkout.btn-block")).click();
//		Thread.sleep(2000);
//	}
//
//	@Then("Accept the consent form from vaccination details")
//	public void accept_the_consent_form_from_vaccination_details() throws Exception {
//		// consent form agree
//		driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/ul/li[1]/div[2]/div[2]/button"))
//				.click();
//		Thread.sleep(2000);
//	}
//
//	@And("select the type for vaccination appointment")
//	public void select_the_type_for_vaccination_appointment() throws Exception {
//		// selecting the type - clinic
//		driver.findElement(By.xpath("(//div[@class='icon'])[2]")).click();
//		Thread.sleep(1000);
//	}
//
//	@Then("select the location for vaccination appointment")
//	public void select_the_location_for_vaccination_appointment() throws Exception {
//		// selecting the clinic-location
//		driver.findElement(By.xpath(
//				"/html/body/main/div/div[3]/div/div[2]/form/ul/li[3]/div[2]/div[2]/div/div[2]/div/div/div/div/div/div/div[2]"))
//				.click();
//		Thread.sleep(1000);
//	}
//
//	@And("select the dateandtime select the slot")
//	public void select_the_dateandtime_select_the_slot() throws Exception {
//		// selecting tomorrow date
//		driver.findElement(By.xpath("//div[@class='row dates-container']/div[2]")).click();
//		Thread.sleep(2000);
//		// slot time selection - 12;00 pm
//		if (driver.findElement(By.xpath("//div[@class='slots-container']/div[2]/div[2]/div/div/span[1]"))
//				.isDisplayed()) {
//			// afternoon slot
//			driver.findElement(By.xpath("//div[@class='slots-container']/div[2]/div[2]/div/div/span[1]")).click();
//			Thread.sleep(1000);
//		} else if (driver.findElement(By.xpath("//div[@class='slots-container']/div[1]/div[2]/div/div/span[1]"))
//				.isDisplayed()) {
//			// morning slot
//			driver.findElement(By.xpath("//div[@class='slots-container']/div[1]/div[2]/div/div/span[1]")).click();
//			Thread.sleep(1000);
//		} else {
//			// evening slot
//			driver.findElement(By.xpath("//div[@class='slots-container']/div[3]/div[2]/div/div/span[1]")).click();
//			Thread.sleep(1000);
//		}
//		Thread.sleep(1000);
//	}
//
//	@Then("select the providers for vaccination appointment")
//	public void select_the_providers_for_vaccination_appointment() throws Exception {
//		// clicking on the health coach
//		driver.findElement(By.xpath(
//				"/html/body/main/div/div[3]/div/div[2]/form/ul/li[5]/div[2]/div[2]/div[1]/span/span[1]/span/span[1]"))
//				.click();
//		Thread.sleep(1000);
//		// selecting the healthcoach
//		driver.findElement(By.xpath("//li[text()='Shanthi Athkuri']")).click();
//		Thread.sleep(1000);
//
//		// clicking on the doctor
//		WebElement doctor = driver.findElement(By.xpath("(//label[text()='Doctors'])[1]"));
//		doctor.click();
//		Thread.sleep(1000);
//		// clicking on the dropdown
//		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
//		Thread.sleep(1000);
//
//		// clicking on the healthcoach
//		WebElement hc = driver.findElement(By.xpath("//label[text()='Health Coach']"));
//		hc.click();
//		Thread.sleep(1000);
//
//	}
//
//	@And("click on continue button from vaccination details")
//	public void click_on_continue_button_from_vaccination_details() throws Exception {
//		// continue
//		driver.findElement(By.cssSelector("button.waves-effect.waves-dark.btn.green.date-continue.next-step")).click();
//		Thread.sleep(2000);
//	}
//
//	@Then("select the slottime for vaccination and click on submit button")
//	public void select_the_slottime_for_vaccination_and_click_on_submit_button() throws Exception {
//		// clicking on the time
//		driver.findElement(By.cssSelector("input#appointment_tracking_slot_time")).click();
//		Thread.sleep(1000);
//		// 6
//		driver.findElement(By.xpath("//div[@class='timepicker-dial timepicker-hours']/div[6]")).click();
//		Thread.sleep(1000);
//		// 30
//		driver.findElement(By.xpath("//div[@class='timepicker-dial timepicker-minutes']/div[7]")).click();
//		Thread.sleep(1000);
//		// ok
//		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.cssSelector("input#btn-loader")).click();
//		Thread.sleep(2000);
//
//	}
//
//	@And("in the proformainvoice page delete one vaccine")
//	public void in_the_proformainvoice_page_delete_one_vaccine() throws Exception {
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Delete Item'])[4]/i[1]"))).build()
//				.perform();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Delete Item'])[4]/i[1]")).click();
//		Thread.sleep(2000);
//		// driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
//		// clicking on the yes button
//		WebDriverWait yes = new WebDriverWait(driver, Duration.ofSeconds(30));
//		yes.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Yes'])[2]")))).click();
//		Thread.sleep(3000);
//
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
//	}
//
//	@And("select the insurer or credit to pay")
//	public void select_the_insurer_or_credit_to_pay() throws Exception {
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Insurer'])[1]/img[1]"))).build()
//				.perform();
//		Thread.sleep(2000);
//	}
//
//	@When("user click on insurerorcredit new insurer popup will open")
//	public void user_click_on_insurerorcredit_new_insurer_popup_will_open() throws InterruptedException {
//		driver.findElement(By.xpath("(//a[@data-tooltip='Insurer'])[1]/img[1]")).click();
//		Thread.sleep(3000);
//	}
//
//	@Then("select the insurance and enter the id and policy numbers")
//	public void select_the_insurance_and_enter_the_id_and_policy_numbers() throws InterruptedException {
//		WebElement insurance = driver.findElement(By.xpath("(//label[text()='Insurance'])[2]"));
//		insurance.click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input#insurance_policy_detail_id_card")).sendKeys("1234");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.cssSelector("input#insurance_policy_detail_policy_no")).sendKeys("123");
//		Thread.sleep(2000);
//		// submit
//		driver.findElement(By.xpath("(//input[@class='btn right green ins_submit btn-loader'])[1]")).click();
//		Thread.sleep(3000);
////		// edit the insurer
////		driver.findElement(By.xpath("(//tbody[@id='insurance_details'])[1]/tr/td[7]/a[2]/i[1]")).click();
////		Thread.sleep(2000);
////		driver.findElement(By.cssSelector("input#insurance_policy_detail_id_card")).clear();
////		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
////		driver.findElement(By.cssSelector("input#insurance_policy_detail_id_card")).sendKeys("1234");
////		Thread.sleep(2000);
////		// submit
////		driver.findElement(By.xpath("(//input[@class='btn right green ins_submit btn-loader'])[1]")).click();
////		Thread.sleep(3000);
//	}
//
//	@And("select the insurance that have been created")
//	public void select_the_insurance_that_have_been_created() throws InterruptedException {
//		driver.findElement(By.xpath("(//tbody[@id='insurance_details'])[1]/tr/td[7]/a[1]")).click();
//		Thread.sleep(3000);
//	}
//
//	@Then("click on pre authorization button fill the form of pre authorization response")
//	public void click_on_pre_authorization_button_fill_the_form_of_pre_authorization_response()
//			throws InterruptedException {
//		driver.findElement(By.xpath("(//a[text()='Pre-authorization Response'])[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(
//				By.cssSelector("input#patient_master_patient_questnr_value_details_attributes_0_result_value")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
//		Thread.sleep(2000);
//		WebElement issued = driver.findElement(By.xpath("(//label[text()='Issued'])[1]"));
//		issued.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// submit
//		driver.findElement(By.cssSelector("input#update_submit")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/main/div[15]/div/form/div[2]/div[1]/div/div[3]/div[2]/input"))
//				.sendKeys("950");
//		Thread.sleep(2000);
//		// submit
//		driver.findElement(By.cssSelector("input#update_submit")).click();
//		Thread.sleep(2000);
//	}
//
//	@And("click on the claimed amount button and fill the claimed amount form")
//	public void click_on_the_claimed_amount_button_and_fill_the_claimed_amount_form() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Claimed amount'])[1]"))))
//				.click();
//		Thread.sleep(3000);
//		driver.findElement(
//				By.xpath("(//input[@id='patient_master_patient_questnr_value_details_attributes_0_result_value'])[1]"))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
//		Thread.sleep(1000);
//		// entering the claim number
//		driver.findElement(
//				By.xpath("(//input[@id='patient_master_patient_questnr_value_details_attributes_1_result_value'])[1]"))
//				.sendKeys("1234567890");
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("(//input[@id='patient_master_patient_questnr_value_details_attributes_2_result_value'])[1]"))
//				.sendKeys("950");
//		Thread.sleep(2000);
//		// submit
//		driver.findElement(By.cssSelector("input#update_submit")).click();
//		Thread.sleep(3000);
//	}
//
//	@Then("click on the submit button inthe proformainvoice6")
//	public void click_on_the_submit_button_inthe_proformainvoice6() throws Exception {
//		// submit
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a#bookLater")))).click();
////		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
//		Thread.sleep(2000);
//
//	}
//
//	@And("edit the invoice date for vaccine appointment")
//	public void edit_the_invoice_date_for_vaccine_appointment() throws Exception {
//		// clicking on the edit invoice date
//		driver.findElement(By.xpath("(//a[@class='edit-invoice-date'])[2]/i[1]")).click();
//		Thread.sleep(3000);
//		List<WebElement> dates = driver.findElements(By.xpath("(//button[@class='datepicker-day-button'])"));
//		WebElement lastdate = dates.get(dates.size() - 1);
//		lastdate.click();
//		Thread.sleep(2000);
//	}
//
//	@And("download the Invoice_receipt_totaladvance_printpdf6")
//	public void download_the_invoice_receipt_totaladvance_printpdf6() throws Exception {
//		// op-invoice
//		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
//		Thread.sleep(2000);
//		Robot robot1 = new Robot();
//		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
//
////		// receipt download
////		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[2]/div[2]/a")).click();
////		Thread.sleep(2000);
////		Actions receipt = new Actions(driver);
////		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build()
////				.perform();
////		Thread.sleep(1000);
////		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
////		Thread.sleep(2000);
//		// print
//		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(3000);
//		// print without details
//		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(4000);
//	}
//
//	@Then("click on shareinvoice6 button")
//	public void click_on_shareinvoice6_button() throws Exception {
//		// share invoice
//		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
//		Thread.sleep(5000);
//
//	}
//
//	@And("clears existing mail and phone for vaccinaation")
//	public void clears_existing_mail_and_phone_for_vaccinaation() {
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("phone")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}
//
//	@Then("enter mail and click on submit button for shareinvoice6")
//	public void enter_mail_and_click_on_submit_button_for_shareinvoice6() throws Exception {
//		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// submit
//		WebElement sub = driver.findElement(By.xpath("/html/body/main/div/div[13]/div/div[2]/form/div[2]/input"));
//		sub.click();
//		Thread.sleep(18000);
//	}
//
//	@When("user click on patientsname from vaccination proformainvoicepage")
//	public void user_click_on_patientsname_from_vaccination_proformainvoicepage() throws Exception {
//		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
//		Thread.sleep(2000);
//		// close for pending amount
//		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
//			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
//			Thread.sleep(1000);
//			// driver.findElement(By.id("admin-billing-tab")).click();
//			Thread.sleep(1000);
//		}
//	}
//
//	@Then("patientprofile  will opened after vaccination appointment")
//	public void patientprofile_will_opened_after_vaccination_appointment() {
//
//	}

	@When("user click on bookopprocedures from book appointment")
	public void user_click_on_bookopprocedures_from_book_appointment() throws Exception {
		// mouse hover on the oppro booking
		Actions op = new Actions(driver);
		op.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Minor Procedures'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// clicking on the book op procedures
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Book Minor Procedures'])[1]/img[1]"))))
				.click();
		// driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(8)>img")).click();
		Thread.sleep(2000);
	}

	@Then("list of procedures will be displayed for opprocedures")
	public void list_of_procedures_will_be_displayed_for_opprocedures() {
	}

	@And("select the procedures and remove of them")
	public void select_the_procedures_and_remove_of_them() throws Exception {
		// clicking on the add
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the add again
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
		// removing
		driver.findElement(By.xpath("(//i[text()='remove'])[2]")).click();
		Thread.sleep(3000);

	}

	@Then("click on the checkout for op procedure booking")
	public void click_on_the_checkout_for_op_procedure_booking() throws Exception {
		// checkout
		WebDriverWait checkout = new WebDriverWait(driver, Duration.ofSeconds(30));
		checkout.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.cssSelector("a.btn-loader.btn.checkout.btn-block")))).click();
		Thread.sleep(3000);

	}

	@And("select the procedure start time and end time")
	public void select_the_procedure_start_time_and_end_time() throws Exception {
//		// start time
//		driver.findElement(By.cssSelector("input#start_time")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[1]//following-sibling::div[1]/div[6]"))
//				.click(); //
//		Thread.sleep(1000);
//		// end time
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[1]//following-sibling::div[2]/div[7]"))
//				.click(); // 30mins
//		Thread.sleep(1000);
//		// ok
//		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
//		Thread.sleep(1000);
//		// end time
//		driver.findElement(By.cssSelector("input#end_time")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// start time
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[2]//following-sibling::div[1]/div[7]"))
//				.click();
//		Thread.sleep(1000);
//		// end time
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[2]//following-sibling::div[2]/div[1]"))
//				.click();
//		Thread.sleep(1000);
//		// ok
//		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[2]/button[2]")).click();
//		Thread.sleep(1000);
	}

	@Then("select the procedure room for op procedure appointment")
	public void select_the_procedure_room_for_op_procedure_appointment() throws Exception {
//		// clicking on the procedure rooms
//		driver.findElement(By.xpath("//span[@class='selection'][1]")).click();
//		Thread.sleep(1000);
//		// selecting the room
//		driver.findElement(By.xpath("//li[text()='454']")).click();
//		Thread.sleep(2000);

	}

	@When("user click on submit button")
	public void user_click_on_submit_button() throws Exception {
//		// continue
//		driver.findElement(By.cssSelector("input#continue-ot")).click();
//		Thread.sleep(2000);
	}

	@Then("from team popup select the therapist_leaddoctor_supportingdoctor_counsellor")
	public void from_team_popup_select_the_therapist_leaddoctor_supportingdoctor_counsellor() throws Exception {
//		// clicking on the nurse
//		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Sunil cm'])[1]")).click();
//		Thread.sleep(1000);
//		// clicking on the doctor
//		driver.findElement(By.cssSelector("input#op_patient_detail_referred_by")).click();
//		Thread.sleep(1000);
//		// nh doctor
//		driver.findElement(By.xpath("(//a[text()='Dr. NH Doctor'])[1]")).click();
//		Thread.sleep(1000);
//		// supporting doctor
//		driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[1]/div[2]/form/ul/li[2]/div[2]/div[4]/div/div[3]/span/span[1]/span/ul/li/input")).click();
//		Thread.sleep(1000);
//		// dr harshita
//		driver.findElement(By.xpath("//li[text()='Dr. Manager T']")).click();
//		Thread.sleep(1000);
//		Robot robot = new Robot();
//		for (int i = 0; i < 2; i++) {
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_SUBTRACT);
//			robot.keyRelease(KeyEvent.VK_SUBTRACT);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//		}
////		// clicking on the counsellor
////		driver.findElement(By.xpath(
////				"/html/body/main/div/div[4]/div[1]/div[2]/form/ul/li[2]/div[2]/div[5]/div/div[3]/span/span[1]/span"))
////				.click();
////		Thread.sleep(1000);
////		// selecting the counsellor
////		driver.findElement(By.xpath("//li[text()='Anita Sharma']")).click();
////		Thread.sleep(1000);

	}

	@And("click on continue button from team")
	public void click_on_continue_button_from_team() throws InterruptedException {
//		// continue
//		driver.findElement(By.cssSelector("input#continue-team")).click();
//		Thread.sleep(2000);
	}

	@Then("enter the nursing and additional charges")
	public void enter_the_nursing_and_additional_charges() throws Exception {
		// nursing charges
		driver.findElement(By.cssSelector("input#appointment_tracking_nursing_chrge")).sendKeys("1");
		Thread.sleep(1000);
		// additional charges
		driver.findElement(By.cssSelector("input#additional_charges")).sendKeys("1");
		Thread.sleep(1000);

	}
//	@And("click on the existing_invoice radio button")
//	public void click_on_the_existing_invoice_radio_button() throws Exception{
//		WebElement existinv = driver.findElement(By.xpath("(//label[text()='Existing Invoice'])[1]"));
//		existinv.click();
//		Thread.sleep(2000);
//		
//	}
//	@Then("select the already existing_invoice radio button")
//	public void select_the_already_existing_invoice_radio_button() throws Exception {
////		WebElement op = driver.findElement(By.xpath("(//div[@class='row existing_inv_radio'])[1]/div[1]/div[1]/label[1]"));
////		op.click();
////		Thread.sleep(2000);
//		//(//div[@class='row existing_inv_radio'])[1]/div[1]/div[1]/label[1]
//		WebElement op1 = driver.findElement(By.xpath(""));
//		op1.click();
//		Thread.sleep(2000);
//	}

	@And("click on the submit button from opprocedure invoice page")
	public void click_on_the_submit_button_from_opprocedure_invoice_page() throws Exception {
		// submit
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@Then("proformainvoice page will be opened for opprocedure")
	public void proformainvoice_page_will_be_opened_for_opprocedure() {

	}

	@And("select the paymentmethods7")
	public void select_the_paymentmethods7() throws InterruptedException {
		// cash
		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash.click();
		Thread.sleep(1000);
	}

	@When("user enters_the transaction_amount for opprocedure then receipt_comment will visible")
	public void user_enters_the_transaction_amount_for_opprocedure_then_receipt_comment_will_visible()
			throws InterruptedException {
		// entering amount
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("102");
		Thread.sleep(2000);

	}

	@Then("click on receipt_comment and enter_comment for opprocedure appointment")
	public void click_on_receipt_comment_and_enter_comment_for_opprocedure_appointment() {
		// clicking on the comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("receipt comment for minor procedure");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the submit button inthe proformainvoice7")
	public void click_on_the_submit_button_inthe_proformainvoice7() throws Exception {
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
	}

	@And("download the Invoice_receipt_totaladvance_printpdf7")
	public void download_the_invoice_receipt_totaladvance_printpdf7() throws InterruptedException, Exception {
		// printing
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// receipt id
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[7]/div[2]/div[2]/a")).click();
		Thread.sleep(2000);
		Actions receipt = new Actions(driver);
		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(2000);
		// print without details
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(4000);
	}

	@Then("click on shareinvoice7 button")
	public void click_on_shareinvoice7_button() throws InterruptedException {
		// share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(5000);

	}

	@And("clears existing mail and phone for opprocedure")
	public void clears_existing_mail_and_phone_for_opprocedure() {
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("enter mail and click on submit button for shareinvoice7")
	public void enter_mail_and_click_on_submit_button_for_shareinvoice7() throws Exception {
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebElement submit = driver.findElement(By.xpath("/html/body/main/div/div[13]/div/div[2]/form/div[2]/input"));
		submit.click();
		Thread.sleep(20000);
//		Robot robot1 = new Robot();
//		for (int i = 0; i < 2; i++) {
//			robot1.keyPress(KeyEvent.VK_CONTROL);
//			robot1.keyPress(KeyEvent.VK_ADD);
//			robot1.keyRelease(KeyEvent.VK_ADD);
//			robot1.keyPress(KeyEvent.VK_CONTROL);
//		}
		Thread.sleep(5000);
	}

	@When("user click on patientsname from opprocedure proformainvoicepage")
	public void user_click_on_patientsname_from_opprocedure_proformainvoicepage() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
		Thread.sleep(2000);
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(2000);
			// driver.findElement(By.id("admin-billing-tab")).click();
			Thread.sleep(2000);
		}
	}

	@Then("patientprofile  will opened after opprocedure appointment")
	public void patientprofile_will_opened_after_opprocedure_appointment() throws InterruptedException {
	}

//	@When("advance button is clicked from the patient profile")
//	public void advance_button_is_clicked_from_the_patient_profile() {
//
//	}
//
//	@Then("advance popup will be open and enter the amount for load advance")
//	public void advance_popup_will_be_open_and_enter_the_amount_for_load_advance() throws Exception {
//		driver.findElement(By.cssSelector("div.invoice_container.patientLoadBalance>a")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input#load_amount")).sendKeys("500");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	}
//
//	@And("select the payment method and click on the save button")
//	public void select_the_payment_method_and_click_on_the_save_button() throws Exception {
//		WebElement card = driver.findElement(By.xpath("(//label[text()='Card'])[1]"));
//		card.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.cssSelector("input#txn_id")).sendKeys("1234");
//		Thread.sleep(1000);
//		// save
//		driver.findElement(By.cssSelector("input#save")).click();
//		Thread.sleep(5000);
//	}
//
//	@When("save button is clicked then money will load succesfully")
//	public void save_button_is_clicked_then_money_will_load_succesfully() {
//
//	}
//
//	@Then("click on advance again to return some amount and save")
//	public void click_on_advance_again_to_return_some_amount_and_save() throws Exception {
//		driver.findElement(By.cssSelector("div.invoice_container.patientLoadBalance>a")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("a.return_amnt")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input#load_amount")).sendKeys("100");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
////		WebElement card = driver.findElement(By.cssSelector("(//label[text()='Card'])[1]"));
////		card.click();
////		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
////		driver.findElement(By.cssSelector("input#txn_id")).sendKeys("9878");
//		Thread.sleep(1000);
//		// save
//		driver.findElement(By.cssSelector("input#save")).click();
//		Thread.sleep(5000);
//	}

	@When("user click on bookdoctorappointment from book appointment")
	public void user_click_on_bookdoctorappointment_from_book_appointment() throws Exception {
		// mouse hover on the doc booking
		Actions doc = new Actions(driver);
		doc.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Doctor Appointment'])/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// clicking on the doctor appointment
		driver.findElement(By.xpath("(//a[@data-tooltip='Book Doctor Appointment'])/img[1]")).click();
		Thread.sleep(2000);

	}

	@Then("list of avaible doctors list will be displayed")
	public void list_of_avaible_doctors_list_will_be_displayed() {
//		System.out.println("list of available doctors list is displayed");
	}

	@And("select the doctor and click on book appointment")
	public void select_the_doctor_and_click_on_book_appointment() throws Exception {
		// clicking on the book appointment
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)"))))
				.click();
//		driver.findElement(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)")).click();
		Thread.sleep(2000);

	}

	@Then("select the type for doctorappointment")
	public void select_the_type_for_doctorappointment() throws Exception {
		// selecting the type - video type
		driver.findElement(By.xpath("(//div[@class='icon'])[2]")).click();
		Thread.sleep(2000);

	}

	@And("select the dateandtime and slot for doctor appointment")
	public void select_the_dateandtime_and_slot_for_doctor_appointment() throws Exception {
		// selecting the date and time - tomorrow
		driver.findElement(By.xpath("//div[@class='row dates-container']/div[2]")).click();
		Thread.sleep(2000);
		Robot robot11 = new Robot();
		for (int i = 0; i < 4; i++) {
			robot11.keyPress(KeyEvent.VK_CONTROL);
			robot11.keyPress(KeyEvent.VK_SUBTRACT);
			Thread.sleep(1000);
			robot11.keyRelease(KeyEvent.VK_SUBTRACT);
			robot11.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(2000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("(//div[@class='slots'])[2]/div[1]/span")).isDisplayed()) {
			// night slot
			driver.findElement(By.xpath("(//div[@class='slots'])[2]/div[1]/span")).click();
			Thread.sleep(2000);

		} else if (driver.findElement(By.xpath("(//div[@class='slots'])[4]/div[1]/span")).isDisplayed()) {
			// evening slot
			driver.findElement(By.xpath("(//div[@class='slots'])[4]/div[1]/span")).click();
			Thread.sleep(1000);

		} else {
			// afternoon slot
			driver.findElement(By.xpath("(//div[@class='slots'])[1]/div[1]/span")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
	}

	@Then("we can change the slottime here for doctorappointment")
	public void we_can_change_the_slottime_here_for_doctorappointment() throws Exception {
		// clicking on the slot time
		driver.findElement(By.cssSelector("input#appointment_tracking_slot_time")).click();
		Thread.sleep(1000);
		// 6
		driver.findElement(By.xpath("//div[@class='timepicker-canvas']/following-sibling::div[1]/div[6]")).click();
		Thread.sleep(1000);
		// ok
		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
		Thread.sleep(2000);
	}

	@And("select the registrationfees_notifypatients checkboxes")
	public void select_the_registrationfees_notifypatients_checkboxes() throws Exception {
//		WebElement fee = driver.findElement(By.xpath("//label[text()='50']"));
//		fee.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the notify
		WebElement gmail = driver.findElement(By.xpath("(//label[text()='Email'])[1]"));
		gmail.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
		sms.click();
		Thread.sleep(1000);

	}

	@Then("click on the submit button from payment popup")
	public void click_on_the_submit_button_from_payment_popup() throws Exception {
		// clicking on the submit
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(3000);
		Robot robot12 = new Robot();
		for (int i = 0; i < 4; i++) {
			robot12.keyPress(KeyEvent.VK_CONTROL);
			robot12.keyPress(KeyEvent.VK_ADD);
			Thread.sleep(1000);
			robot12.keyRelease(KeyEvent.VK_ADD);
			robot12.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(2000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

	}

	@And("applying discount for five percentage and entering the comments")
	public void applying_discount_for_five_percentage_and_entering_the_comments() throws Exception {
		// adding 10% discount
		driver.findElement(By.cssSelector("input#promo_disc")).sendKeys("10");
		Thread.sleep(2000);
		// adding comment for the discount
		driver.findElement(By.cssSelector("span#applyCouponModal")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("textarea#comments")).sendKeys("10% discount for the doctor appointment");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#applyCouponBtn")).click();
		Thread.sleep(2000);
	}

	@Then("paying the remaining balance and entering the comments")
	public void paying_the_remaining_balance_and_entering_the_comments() throws Exception {
		// entering the cash
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("1440");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		Thread.sleep(2000);
		/*
		 * // clicking yes on the payment update popup
		 * driver.findElement(By.cssSelector("input#negotiableYes")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.cssSelector("i#paymentComment")).click();
		 * Thread.sleep(2000);
		 */ driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("Remaining balance amt paid.");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='modal-close btn green right payCmntOk'])[1]")).click();
		Thread.sleep(2000);

//		// selecting the cash rad.btn
//		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
//		cash.click();
//		Thread.sleep(1000);
//		// entering the amount
//		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("250");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// clicking on the comment
//		driver.findElement(By.cssSelector("i#paymentComment")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// comment
//		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test receipt comment 1");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// submit
//		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//		WebElement cash = driver.findElement(By.xpath("(//label[text()='Redeem'])[1]"));
//		cash.click();
//		Thread.sleep(2000);
	}

	@Then("click on receipt_comment and enter_comment for doctor appointment")
	public void click_on_receipt_comment_and_enter_comment_for_doctor_appointment() {
//		// clicking on the comment
//		driver.findElement(By.cssSelector("i#paymentComment")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// comment
//		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test receipt comment");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("click on the submit button inthe proformainvoice8")
	public void click_on_the_submit_button_inthe_proformainvoice8() throws Exception {
//		// submit
//		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// clicking on the submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
	}

	@And("download the Invoice_receipt_totaladvance_printpdf8")
	public void download_the_invoice_receipt_totaladvance_printpdf8() throws Exception {
		// printing
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the receipt id
		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[2]/div[2]/a[1]")).click();
		Thread.sleep(3000);
		// clicking on the receipt id 2
		// driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[3]/div[2]/a")).click();
		// Thread.sleep(3000);
		Actions receipt = new Actions(driver);
		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);

	}

	@When("user click on the back button from the doctor appointment profoma invoice")
	public void user_click_on_the_back_button_from_the_doctor_appointment_profoma_invoice() throws Exception {
//		driver.findElement(By.xpath("//a[text()='Back']")).click();
//		Thread.sleep(2000);
	}

	@Then("it will redirect to the doctor appointment page")
	public void it_will_redirect_to_the_doctor_appointment_page() {
	}

	@And("click on the confirmed status for doctor in the appointments")
	public void click_on_the_confirmed_status_for_doctor_in_the_appointments() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@id='admin-doc-consultations'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the confirmed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.cssSelector("a.btn-loader.status_links.cnfrd_btn.tooltipped"))))
				.click();
//		driver.findElement(By.cssSelector("a.btn-loader.status_links.cnfrd_btn.tooltipped")).click();
		Thread.sleep(2000);
	}

	@Then("click on the first patients appointment id")
	public void click_on_the_first_patients_appointment_id() throws Exception {
		// clicking on the first patient id
		WebElement pat = driver.findElement(By.xpath("(//tr[@class='consultRow odd'])[1]/td[2]/a"));
		pat.click();
		Thread.sleep(2000);
	}

	@And("click on the cancel button from the popup")
	public void click_on_the_cancel_button_from_the_popup() throws Exception {
		// clicking on the cancel
		driver.findElement(By.xpath("(//a[text()='Cancel'])[3]")).click();
		Thread.sleep(1000);
	}

	@Then("from cancel appointment popup enter the cancellation reason")
	public void from_cancel_appointment_popup_enter_the_cancellation_reason() throws Exception {
		// cancel reason
		driver.findElement(By.id("comments")).sendKeys("test reason");
		Thread.sleep(1000);
	}

	@And("click on the refund button from cancel appointment popup")
	public void click_on_the_refund_button_from_cancel_appointment_popup() throws Exception {
		// clicking on the refund
		driver.findElement(By.xpath("(//a[text()='Refund'])[1]")).click();
		Thread.sleep(1000);
		Robot robot111 = new Robot();
		robot111.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@Then("it will redirect to the proformainvoice for refund")
	public void it_will_redirect_to_the_proformainvoice_for_refund() {
	}

	@And("select the paymentmethod for refund")
	public void select_the_paymentmethod_for_refund() throws Exception {
		WebElement cash1 = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash1.click();
		Thread.sleep(1000);

	}

	@Then("enter the  amount for refund")
	public void enter_the_amount_for_refund() throws Exception {
		// entering the cash
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("1440");
		Thread.sleep(1000);
	}

	@When("receipt comment is visible")
	public void receipt_comment_is_visible() {

	}

	@Then("click on it and enter the receipt comment and click on ok")
	public void click_on_it_and_enter_the_receipt_comment_and_click_on_ok() throws Exception {
		// clicking on the receipt comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		Thread.sleep(2000);
		// entering the reason
		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test reason");
		Thread.sleep(1000);
		// clicking on the ok
		driver.findElement(By.cssSelector("a.modal-close.btn.green.right.payCmntOk")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@And("enter the refund reason and click on ok")
	public void enter_the_refund_reason_and_click_on_ok() throws Exception {
		// entering the refund reason
		driver.findElement(By.cssSelector("textarea#refund_rsn")).sendKeys("refund reason");
		Thread.sleep(1000);
		// clicking on the ok
		driver.findElement(By.cssSelector("a.modal-close.btn.green.right.refundOk")).click();
		Thread.sleep(2000);
	}

	@Then("click on the submit button from the refund proformainvoice page")
	public void click_on_the_submit_button_from_the_refund_proformainvoice_page() throws Exception {
		// clicking on the submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
		// driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(3000);

	}

	@And("download the invoice_receiptIDs_totaladvance_printpdf from the refund proformainvoice page")
	public void download_the_invoice_receipt_i_ds_totaladvance_printpdf_from_the_refund_proformainvoice_page()
			throws Exception {
		// printing
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// clicking on the receipt1
		String parentwindw = driver.getWindowHandle();
		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[2]/div[2]/a[1]")).click();
		Thread.sleep(1000);
		Set<String> childwind = driver.getWindowHandles();
		for (String handle : childwind) {
			if (!handle.equals(parentwindw)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwindw);
				Thread.sleep(2000);
			}
		}
		Robot robot5 = new Robot();
		robot5.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

		// clicking on the receipt2
		String parentwindw1 = driver.getWindowHandle();
		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[3]/div[2]/a[1]")).click();
		Thread.sleep(1000);
		Set<String> childwind1 = driver.getWindowHandles();
		for (String handle1 : childwind1) {
			if (!handle1.equals(parentwindw1)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwindw1);
				Thread.sleep(2000);
			}
		}
		Actions receipt = new Actions(driver);
		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(5000);

	}

	@When("user click on patientsname from refund proformainvoicepage")
	public void user_click_on_patientsname_from_refund_proformainvoicepage() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
		Thread.sleep(2000);
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(2000);
			try {
//				driver.findElement(By.id("admin-billing-tab")).click();
//				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		Thread.sleep(2000);
	}

	@Then("patientprofile  will opened after refund proformainvoicepage")
	public void patientprofile_will_opened_after_refund_proformainvoicepage() {

	}

//	@When("user click on bookappointment  from book appointment")
//	public void user_click_on_bookappointment_from_book_appointment() throws Exception {
//		// mouse hover on the dept booking
//		Actions dept = new Actions(driver);
//		dept.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Appointment'])/img[1]"))).build()
//				.perform();
//		Thread.sleep(1000);
//		// clicking on the Book Appointment
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Book Appointment'])/img[1]")))).click();
//		// driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(12)>img")).click();
//		Thread.sleep(1000);
//	}
//
//	@Then("select the type for department booking")
//	public void select_the_type_for_department_booking() throws Exception {
//		// clicking on the clinic
//		driver.findElement(By
//				.xpath("/html/body/main/div/div[28]/div/div/div[2]/form/ul/li[1]/div[2]/div[1]/div[2]/div/div/div[1]"))
//				.click();
//		Thread.sleep(2000);
//
//	}
//
//	@And("click on the choosedate for department appointment")
//	public void click_on_the_choosedate_for_department_appointment() {
//		// clicking on the calender
//		driver.findElement(By.cssSelector("div.choose-date")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}
//
//	@Then("select the mondays date")
//	public void select_the_mondays_date() throws Exception {
//		driver.findElement(By.xpath("//div[@class='selects-container']/div[1]")).click();
//		Thread.sleep(1000);
//		// selecting the month
//		driver.findElement(By.xpath("(//li/span[text()='December'])")).click();
//		Thread.sleep(1000);
//
//	}
//
//	@And("select the date and slot time")
//	public void select_the_date_and_slot_time() throws Exception {
//		// selecting the date
//		driver.findElement(By.xpath("//button[text()='30']")).click();
//		Thread.sleep(1000);
//
//		Robot red = new Robot();
//		for (int i = 0; i <= 1; i++) {
//			red.keyPress(KeyEvent.VK_CONTROL);
//			Thread.sleep(1000);
//			red.keyPress(KeyEvent.VK_SUBTRACT);
//			Thread.sleep(1000);
//			red.keyRelease(KeyEvent.VK_SUBTRACT);
//			Thread.sleep(1000);
//			red.keyRelease(KeyEvent.VK_CONTROL);
//			Thread.sleep(1000);
//		}
//		Thread.sleep(2000);
//		// selecting the slot
//		if (driver.findElement(By.xpath("//div[@class='slots-container']/div[2]/div[2]/div/div/span[1]"))
//				.isDisplayed()) {
//			// afternoon slot
//			driver.findElement(By.xpath("//div[@class='slots-container']/div[2]/div[2]/div/div/span[1]")).click();
//			Thread.sleep(1000);
//
//		} else if (driver.findElement(By.xpath("//div[@class='slots-container']/div[3]/div[2]/div/div/span[1]"))
//				.isDisplayed()) {
//			// evening slot
//			driver.findElement(By.xpath("//div[@class='slots-container']/div[3]/div[2]/div/div/span[1]")).click();
//			Thread.sleep(1000);
//
//		} else {
//			// morning slot
//			driver.findElement(By.xpath("//div[@class='slots-container']/div[1]/div[2]/div/div/span[1]")).click();
//			Thread.sleep(1000);
//		}
//		Robot inc = new Robot();
//		for (int i = 0; i <= 1; i++) {
//			inc.keyPress(KeyEvent.VK_CONTROL);
//			Thread.sleep(1000);
//			inc.keyPress(KeyEvent.VK_ADD);
//			Thread.sleep(1000);
//			inc.keyRelease(KeyEvent.VK_ADD);
//			Thread.sleep(1000);
//			inc.keyRelease(KeyEvent.VK_CONTROL);
//			Thread.sleep(1000);
//		}
//		Thread.sleep(1000);
//	}
//
//	@And("change slot_time for department booking")
//	public void change_slot_time_for_department_booking() throws Exception {
//		// selecting the slot
//		driver.findElement(By.cssSelector("input#appointment_tracking_slot_time")).click();
//		Thread.sleep(1000);
//		// 6
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[1]/following-sibling::div[1]/div[6]")).click();
//		Thread.sleep(1000);
//		// 30 mins
//		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[1]/following-sibling::div[2]/div[7]")).click();
//		Thread.sleep(1000);
//		// pm
//		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[2]")).click();
//		Thread.sleep(1000);
//		// ok
//		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
//		Thread.sleep(1000);
//
//	}
//
//	@Then("select the doctor from dropdown in the review")
//	public void select_the_doctor_from_dropdown_in_the_review() throws InterruptedException {
//		// clicking on the doctor assign drop down
//		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
//		Thread.sleep(1000);
//		// selecting the doctor
//		driver.findElement(By.xpath("//li[text()='Dr. NH Doctor']")).click();
//		Thread.sleep(1000);
//
//	}
//
//	@And("click on the submit button from the review popup")
//	public void click_on_the_submit_button_from_the_review_popup() throws Exception {
//		// submit
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
//		Thread.sleep(2000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
//	}
//
//	@Then("proformainvoice page will be opened for departmentbooking")
//	public void proformainvoice_page_will_be_opened_for_departmentbooking() {
//	}
//
//	@And("select the paymentmethods9")
//	public void select_the_paymentmethods9() throws Exception {
//		// selecting the cash rad.btn
//		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
//		cash.click();
//		Thread.sleep(1000);
//	}
//
//	@When("user enters_the transaction_amount for department then receipt_comment will visible")
//	public void user_enters_the_transaction_amount_for_department_then_receipt_comment_will_visible() {
//		// entering the amount
//		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("400");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//
//	}
//
//	@Then("click on receipt_comment and enter_comment for department appointment")
//	public void click_on_receipt_comment_and_enter_comment_for_department_appointment() {
//		// clicking on the comment
//		driver.findElement(By.cssSelector("i#paymentComment")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// comment
//		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test receipt comment 1");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// submit
//		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//
//	}
//
//	@Then("click on the submit button inthe proformainvoice9")
//	public void click_on_the_submit_button_inthe_proformainvoice9() throws Exception {
//		// submit
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
//		// driver.findElement(By.cssSelector("button#bookNowBtn")).click();
//		Thread.sleep(2000);
//	}
//
//	@And("download the Invoice_receipt_totaladvance_printpdf9")
//	public void download_the_invoice_receipt_totaladvance_printpdf9() throws Exception {
//		// print invoice
//		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
//		Thread.sleep(1000);
//		Robot robot1 = new Robot();
//		for (int i = 0; i < 2; i++) {
//			robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
//		}
//		// clicking on the receipt id
//		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[2]/div[2]/a[1]")).click();
//		Thread.sleep(1000);
//		Actions receipt = new Actions(driver);
//		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build()
//				.perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
//		Thread.sleep(2000);
//		// clicking on the print
//		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(1000);
//		// print without details
//		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(4000);
//	}
//
//	@Then("click on shareinvoice9 button")
//	public void click_on_shareinvoice9_button() throws Exception {
//		// share invoice
//		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
//		Thread.sleep(1000);
//
//	}
//
//	@And("clears existing mail and phone for departmentbooking")
//	public void clears_existing_mail_and_phone_for_departmentbooking() {
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("phone")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}
//
//	@Then("enter mail and click on submit button for shareinvoice9")
//	public void enter_mail_and_click_on_submit_button_for_shareinvoice9() throws Exception {
//		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.xpath("/html/body/main/div/div[13]/div/div[2]/form/div[2]/input")).click();
//		Thread.sleep(18000);
//	}
//
//	@When("user click on back button it will redirect to the doctor appointments")
//	public void user_click_on_back_button_it_will_redirect_to_the_doctor_appointments() throws InterruptedException {
////		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
////		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Back']")))).click();
//////		driver.findElement(By.xpath("//a[text()='Back']")).click();
//
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).click().build().perform();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[@id='admin-doc-consultations'])[1]")).click();
//		Thread.sleep(2000);
//
//	}
//
//	@Then("click on confirmed status and click on the first patient appointment id")
//	public void click_on_confirmed_status_and_click_on_the_first_patient_appointment_id() throws Exception {
//		// clicking on the confirmed status
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.cssSelector("a.btn-loader.status_links.cnfrd_btn.tooltipped"))))
//				.click();
////		driver.findElement(By.cssSelector("a.btn-loader.status_links.cnfrd_btn.tooltipped")).click();
//		Thread.sleep(2000);
//		// clicking on the first patient id
//		WebElement pat = driver.findElement(By.xpath("(//tr[@class='consultRow odd'])[1]/td[2]/a"));
//		pat.click();
//		Thread.sleep(4000);
//		Robot robot11 = new Robot();
//		for (int i = 0; i <= 2; i++) {
//			robot11.keyPress(KeyEvent.VK_CONTROL);
//			robot11.keyPress(KeyEvent.VK_SUBTRACT);
//			robot11.keyRelease(KeyEvent.VK_SUBTRACT);
//			robot11.keyRelease(KeyEvent.VK_CONTROL);
//		}
//		Thread.sleep(3000);
//
//	}
//
//	@And("click on the view button from the appointment_popup")
//	public void click_on_the_view_button_from_the_appointment_popup() throws Exception {
//		// clicking on the view
//		try {
//			driver.findElement(By.xpath("(//a[text()='View'])[1]")).click();
//			Thread.sleep(2000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//	}
//
//	@Then("click on the addcomplaints")
//	public void click_on_the_addcomplaints() {
//	}
//
//	@When("addcomplaints is clicked")
//	public void addcomplaints_is_clicked() {
//	}
//
//	@Then("addcomplaints is opened in a new page")
//	public void addcomplaints_is_opened_in_a_new_page() {
//	}
//
//	@And("enter the bp vitals")
//	public void enter_the_bp_vitals() throws Exception {
//		// clicking on the add complaints
//		String parentwind = driver.getWindowHandle();
//		driver.findElement(By.cssSelector("div.row.appointment-buttons>div>div>a:nth-of-type(3)>img")).click();
//		Thread.sleep(2000);
//		Set<String> childwind = driver.getWindowHandles();
//		for (String handle : childwind) {
//			if (!handle.equals(parentwind)) {
//				driver.switchTo().window(handle);
//				Thread.sleep(1000);
//			}
//		}
//		// vitals
//		// bp
//		driver.findElement(By.id("bp-s")).sendKeys("120");
//		driver.findElement(By.id("bp-d")).sendKeys("89");
//		Thread.sleep(1000);
//		// save as draft
//		driver.findElement(By.xpath("(//input[@name='create'])[1]")).click();
//		Thread.sleep(7000);
//		driver.switchTo().window(parentwind);
//		Thread.sleep(3000);
//		Robot robot21 = new Robot();
//		for (int i = 0; i <= 2; i++) {
//			robot21.keyPress(KeyEvent.VK_CONTROL);
//			robot21.keyPress(KeyEvent.VK_ADD);
//			robot21.keyRelease(KeyEvent.VK_ADD);
//			robot21.keyRelease(KeyEvent.VK_CONTROL);
//		}
//		// closing
//		driver.findElement(By.cssSelector("div#modalApmntShow>div>div>span:nth-of-type(1)")).click();
//		Thread.sleep(1000);
//
//	}
//
//	@Then("click on the saveasdraft in the addcomplainst page")
//	public void click_on_the_saveasdraft_in_the_addcomplainst_page() throws Exception {
//
//	}
//
//	@When("user click on saveasdraft it will redirect to the parentwindow")
//	public void user_click_on_saveasdraft_it_will_redirect_to_the_parentwindow() {
//	}
//
//	@Then("closing the appointment popup in the parentwindow")
//	public void closing_the_appointment_popup_in_the_parentwindow() {
//	}
//
//	@And("clicking on the profileicon")
//	public void clicking_on_the_profileicon() throws Exception {
//		// clicking on the cm icon
//		driver.findElement(By.xpath("/html/body/header/nav/ul/li/a/div/div[1]/img")).click();
//		Thread.sleep(2000);
//
//	}
//
//	@Then("clicking on the signout button from clinicmanager role")
//	public void clicking_on_the_signout_button_from_clinicmanager_role() throws Exception {
//		// clicking on sign out
//		driver.findElement(By.xpath("/html/body/header/nav/ul/li/ul/li[5]/a")).click();
//		Thread.sleep(2000);
//	}
//
//	@And("navigating to the login url")
//	public void navigating_to_the_login_url() throws InterruptedException {
//		// navigating
//		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
//		Thread.sleep(2000);
//	}
//
//	@Then("entering the doctor emailid {string} and password {string}")
//	public void entering_the_doctor_emailid_and_password(String emailid, String password) throws Exception {
//		driver.findElement(By.id("user_login")).sendKeys(emailid);
//		Thread.sleep(1000);
//		driver.findElement(By.id("user_password")).sendKeys(password);
//		Thread.sleep(1000);
//
//	}
//
//	@And("clicking on the signin for doctorrole")
//	public void clicking_on_the_signin_for_doctorrole() throws Exception {
//		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
//		Thread.sleep(2000);
//	}
//
//	@Then("clicking on the month from listview")
//	public void clicking_on_the_month_from_listview() throws Exception {
//		// month
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Month']")))).click();
//		// driver.findElement(By.xpath("//a[text()='Month']")).click();
//		Thread.sleep(8000);
//
//	}
//
//	@And("click on the patientsname")
//	public void click_on_the_patientsname() throws Exception {
//		// clicking on the patient name
//		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
//		Thread.sleep(5000);
//	}
//
//	@Then("click on the add prescritpion")
//	public void click_on_the_add_prescritpion() throws Exception {
//		// add prescription
//		driver.findElement(By.xpath("//button[text()='Add Prescription']")).click();
//		Thread.sleep(5000);
//		Robot robot2 = new Robot();
//		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		Robot robot3 = new Robot();
//		robot3.keyPress(KeyEvent.VK_PAGE_UP);
//		Thread.sleep(3000);
//
//	}
//
//	@And("closing prescription by clicking close icon")
//	public void closing_prescription_by_clicking_close_icon() throws Exception {
//		// closing prescription
//		for (int i = 0; i <= 2; i++) {
//			Robot robot = new Robot();
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_SUBTRACT);
//			robot.keyRelease(KeyEvent.VK_SUBTRACT);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			Thread.sleep(1000);
//		}
//		driver.findElement(By.xpath("(//span[@class='btn-close nh_close btn-floating'])[1]")).click();
//		Thread.sleep(2000);
//		for (int i = 0; i <= 2; i++) {
//			Robot robot = new Robot();
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_ADD);
//			robot.keyRelease(KeyEvent.VK_ADD);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			Thread.sleep(1000);
//		}
//	}
//
//	@Then("clicking on the doctor profileicon")
//	public void clicking_on_the_doctor_profileicon() throws Exception {
//		driver.findElement(By.xpath("(//div[@class='profile-img'])[1]")).click();
//		Thread.sleep(2000);
//
//	}
//
//	@And("clicking on the signout from docotr role")
//	public void clicking_on_the_signout_from_docotr_role() throws Exception {
//		driver.findElement(By.xpath("(//i[@class=\"fa fa-sign-out\"])[1]")).click();
//		Thread.sleep(3000);
//	}
//
//	@Then("navigate to the logging url")
//	public void navigate_to_the_logging_url() throws Exception {
//		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
//		Thread.sleep(2000);
//	}
//
//	@And("logg with_the  clinic manager emailid {string} and  password {string}")
//	public void logg_with_the_clinic_manager_emailid_and_password(String emailid, String password) throws Exception {
//		driver.findElement(By.id("user_login")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.id("user_login")).sendKeys(emailid);
//		Thread.sleep(1000);
//		driver.findElement(By.id("user_password")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.id("user_password")).sendKeys(password);
//		Thread.sleep(1000);
//
//	}
//
//	@Then("click on signin button for clinic manager")
//	public void click_on_signin_button_for_clinic_manager() throws Exception {
//		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
//		Thread.sleep(2000);
//
//	}
//
//	@And("select_the_profile_role")
//	public void select_the_profile_role() throws Exception {
//		// selecting Role clicking on Clinic manager Role
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[7]/div/div/div/div[2]")).click();
//		Thread.sleep(1000);
//
//	}
//
//	@Then("opening the patient by searching and closing if there is pending amount")
//	public void opening_the_patient_by_searching_and_closing_if_there_is_pending_amount() throws Exception {
//		driver.findElement(By.id("frst_nm")).sendKeys("Cucumoppatient");
//		Thread.sleep(2000);
////		// clicking on the name
////		driver.findElement(By.xpath("(//a[text()='Cucum Oppatient'])[1]")).click();
////		Thread.sleep(2000);
//		// clicking on the patient name
//		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
//		Thread.sleep(3000);
//		// clicking on the view profile
//		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
//		Thread.sleep(3000);
//		// close for pending amount
//		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
//			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
//			Thread.sleep(1000);
////			try {
////				driver.findElement(By.id("admin-billing-tab")).click();
////				Thread.sleep(2000);
////			} catch (Exception e) {
////				// TODO: handle exception
////			}
//		}
//	}

	@When("user click on addprogram from book appointment")
	public void user_click_on_addprogram_from_book_appointment() throws Exception {
		// mouse hover on the program booking
		Actions pro = new Actions(driver);
		pro.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add Program'])/img[1]"))).build().perform();
		Thread.sleep(1000);
		// clicking on the add program
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add Program'])/img[1]")))).click();
//		driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(15)>img")).click();
		Thread.sleep(3000);
	}

	@Then("it will display the programs")
	public void it_will_display_the_programs() {
	}

	@And("select the programs and remove one of the program")
	public void select_the_programa_and_remove_one_of_the_program() throws Exception {
		// clicking on the plus
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
		// clicking on the plus
		driver.findElement(By.xpath("(//i[text()='add'])[3]")).click();
		Thread.sleep(2000);
		// removing the last added program
		driver.findElement(By.xpath("(//i[text()='remove'])[4]")).click();
		Thread.sleep(2000);
	}

	@Then("click on the checkout for the program booking")
	public void click_on_the_checkout_for_the_program_booking() throws Exception {
		// checkout
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.cssSelector("a.waves-effect.btn.checkout.btn-block")))).click();
//		driver.findElement(By.cssSelector("a.waves-effect.btn.checkout.btn-block")).click();
		Thread.sleep(2000);
	}

	@And("select addreferredby and select the program start date")
	public void select_addreferredby_and_select_the_program_start_date() throws Exception {
		// referred by
		driver.findElement(By.xpath("(//label[text()='Referred By'])[1]/following-sibling::span/input[1]"))
				.sendKeys("d");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Referred By'])[1]/following-sibling::span/input[1]"))
				.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Referred By'])[1]/following-sibling::span/input[1]"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		// start date
		driver.findElement(By.cssSelector("input.pick-date.stdt")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@class='is-today']")).click();
		// driver.findElement(By.xpath("//button[text()='21']")).click();
		Thread.sleep(3000);
		// click on the activity list
		driver.findElement(By.xpath("(//img[@data-tooltip='View activity list'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the back button
		driver.findElement(By.xpath("(//span[text()='Back'])[2]")).click();
		Thread.sleep(3000);
	}

	@Then("click on the submit button from select invoice of addprogram booking")
	public void click_on_the_submit_button_from_select_invoice_of_addprogram_booking() throws Exception {
		// submit
		driver.findElement(By.cssSelector("input#btn-loader")).click();
		Thread.sleep(2000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@And("select the paymentmethods10")
	public void select_the_paymentmethods10() throws Exception {
		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash.click();
		Thread.sleep(1000);
	}

	@When("user enters_the transaction_amount for program then receipt_comment will visible")
	public void user_enters_the_transaction_amount_for_program_then_receipt_comment_will_visible() throws Exception {
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("10");
		Thread.sleep(1000);
	}

	@Then("click on receipt_comment and enter_comment for program appointment")
	public void click_on_receipt_comment_and_enter_comment_for_program_appointment() throws Exception {
		// clicking on the comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test receipt comment");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		Thread.sleep(1000);

	}

	@Then("click on the submit button inthe proformainvoice10")
	public void click_on_the_submit_button_inthe_proformainvoice10() throws Exception {
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
	}

	@And("download the Invoice_receipt_totaladvance_printpdf10")
	public void download_the_invoice_receipt_totaladvance_printpdf10() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Generate Invoice Id'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		Thread.sleep(2000);
		// printing
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the receipt id
		driver.findElement(By.xpath("(//a[contains(text(),'R-')])[1]")).click();
		Thread.sleep(3000);
		Actions receipt = new Actions(driver);
		receipt.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(3000);
		// print without details
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(4000);
	}

	@Then("click on shareinvoice10 button")
	public void click_on_shareinvoice10_button() throws Exception {
		// clicking on the share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(5000);
	}

	@And("clears existing mail and phone for program")
	public void clears_existing_mail_and_phone_for_program() {
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("enter mail and click on submit button for shareinvoice10")
	public void enter_mail_and_click_on_submit_button_for_shareinvoice10() throws Exception {
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		WebElement sub = driver.findElement(By.xpath("/html/body/main/div/div[13]/div/div[2]/form/div[2]/input"));
		sub.click();
		Thread.sleep(20000);
	}

	@And("mouse hover on history and select the invoice")
	public void mouse_hover_on_history_and_select_the_invoice() throws Exception {
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
			try {
				// driver.findElement(By.id("admin-billing-tab")).click();
				// Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	@Then("list of invoices will be displayed that appointments are booked for this patient")
	public void list_of_invoices_will_be_displayed_that_appointments_are_booked_for_this_patient() {

	}

	@And("click on the print invoice for the appointment")
	public void click_on_the_print_invoice_for_the_appointment() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img")).click();
		Thread.sleep(3000);

	}

	@Then("click on the invoice id number for the appointment")
	public void click_on_the_invoice_id_number_for_the_appointment() throws Exception {
		driver.findElement(By.xpath("(//div[@id='example_wrapper'])/table/tbody/tr[1]/td[1]/a[1]")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(2000);
	}

	@And("it will open the invoice page")
	public void it_will_open_the_invoice_page() {

	}
}
