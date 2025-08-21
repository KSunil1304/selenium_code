package StepDefinitions;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
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

public class Prescription {
	WebDriver driver = null;

	@Given("User navigates to the web portal")
	public void user_navigates_to_the_web_portal() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver130.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		co.addArguments("use-fake-ui-for-media-stream");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@When("User enter the email  {string}")
	public void user_enter_the_email(String email) {
		driver.findElement(By.cssSelector("input.string.optional")).sendKeys(email);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("User enter the password  {string}")
	public void user_enter_the_password(String password) throws Exception {
		driver.findElement(By.cssSelector("input.password.optional")).sendKeys(password);
		Thread.sleep(1000);
	}

	@And("click on the signin button")
	public void click_on_the_signin_button() throws Exception {
		driver.findElement(By.cssSelector("input.sign-btn.full-btn")).click();
		Thread.sleep(3000);
	}

	@Then("user will select role")
	public void Then_user_will_select_role() throws Exception {
//		// selecting Role clicking on cdpadmin
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[14]/div/div/div/div[2]")).click();
//		Thread.sleep(5000);
	}

	@And("user successfully login with the role")
	public void user_successfully_login_with_the_role() {
//		System.out.println("user successfully logged in");
	}

	@Then("deleting the existing patient through search")
	public void deleting_the_existing_patient_through_search() throws Exception {
//		driver.findElement(By.id("frst_nm")).sendKeys("Cucumberprescription");
//		Thread.sleep(3000);
////		// clicking on the name
////		driver.findElement(By.xpath("(//a[text()='Cucumber Prescription'])[1]")).click();
////		Thread.sleep(3000);
//		// clicking on the patient name
//		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
//		Thread.sleep(3000);
//		// clicking on the view profile
//		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
//		Thread.sleep(3000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_SUBTRACT);
//		Thread.sleep(1000);
//		robot.keyRelease(KeyEvent.VK_SUBTRACT);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(1000);
//		// close for pending amount
//		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
//			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.id("admin-billing-tab")).click();
//			// clicking on the delete
//			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")).click();
//			Thread.sleep(1000);
//		} else {
//			// clicking on the delete
//			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")).click();
//			Thread.sleep(1000);
//		}
//		// deleteing
//		driver.findElement(By.xpath("//button[text()='Confirm!']")).click();
//		Thread.sleep(5000);
//		Robot robot1 = new Robot();
//		robot1.keyPress(KeyEvent.VK_CONTROL);
//		robot1.keyPress(KeyEvent.VK_ADD);
//		Thread.sleep(1000);
//		robot1.keyRelease(KeyEvent.VK_ADD);
//		robot1.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
//		Thread.sleep(2000);
		// selecting clinic manager
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[7]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
	}

	@When("user clicks on the add patient icon")
	public void user_clicks_on_the_add_patient_icon() throws Exception {
		// clicking on the add patient icon
		driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img")).click();
		Thread.sleep(2000);
	}

	@Then("registration form will open")
	public void registration_form_will_open() {
//		System.out.println("user is in the registration form");
	}

	@When("user select the title automatically it will select the gender")
	public void user_select_the_title_automatically_it_will_select_the_gender() throws Exception {
		// selecting the title
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@And("user enter the firstname {string}")
	public void user_enter_the_firstname(String firstname) {
		driver.findElement(By.id("first_name")).sendKeys(firstname);
	}

	@And("user enter the lastname {string}")
	public void user_enter_the_lastname(String lastname) {
		driver.findElement(By.id("lst_name")).sendKeys(lastname);
	}

	@And("user enter the age {string}")
	public void user_enter_the_age(String age) {
		driver.findElement(By.id("age")).sendKeys(age);
	}

	@When("user selects the country code")
	public void user_selects_the_country_code() {
		// country code
		driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='+91']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("user enter the phonenumber {string}  and gmail {string}")
	public void user_enter_the_phonenumber_and_gmail(String phonenumber, String gmail) {
		driver.findElement(By.id("nmbr")).sendKeys(phonenumber);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("email")).sendKeys(gmail);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("user enter the addresslineone {string} , addresslinetwo {string} , Landmark {string}")
	public void user_enter_the_addresslineone_addresslinetwo_landmark(String addresslineone, String addresslinetwo,
			String Testlandmark) {
		driver.findElement(By.id("address-line1")).sendKeys(addresslineone);
		driver.findElement(By.name("adrs_line2")).sendKeys(addresslinetwo);
		driver.findElement(By.id("landmark")).sendKeys(Testlandmark);
		driver.findElement(By.id("district")).clear();
		driver.findElement(By.id("district")).sendKeys("district");
	}

	@And("user select the state and country")
	public void user_select_the_state_and_country() throws Exception {
		// aadharcardnumber
		driver.findElement(By.xpath("/html/body/main/div/form/div[2]/div/ul/li/div/div[9]/div[2]/input"))
				.sendKeys("172387238923");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("user click on the add button for referred by")
	public void user_click_on_the_add_button_for_referred_by() throws Exception {
		// abhacard
		WebElement ac = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
		ac.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// profession
//		driver.findElement(By.xpath("(//input[@name='patient_master[profession]'])[1]")).sendKeys("test profession");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// referred by
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Referral'])[1]")).click();
		Thread.sleep(1000);
		// self
		driver.findElement(By.xpath("(//div[@class='icon'])[3]")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.cssSelector("span.cls.btn.green.right.referral_submit")).click();
		Thread.sleep(2000);
		// demand program
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='NanoHealth-HYD'])")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
	}

	@And("user select the self option")
	public void user_select_the_self_option() throws Exception {
	}

	@Then("user click on the Choose file for profile picture and uploads picture")
	public void user_click_on_the_choose_file_for_profile_picture_and_uploads_picture() throws Exception {
	}

	@And("user clicks on the Choose file for Id card and uploads picture")
	public void user_clicks_on_the_choose_file_for_id_card_and_uploads_picture() throws Exception {
	}

	@When("user click on the submit button1")
	public void user_click_on_the_submit_button1() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// submit
		driver.findElement(By.id("update_submit")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		Thread.sleep(5000);
	}

	@Then("it will take to the user to the patientprofile page")
	public void it_will_take_to_the_user_to_the_patientprofile_page() {
	}

	@And("user click on the Book Doctor Appointment")
	public void user_click_on_the_book_doctor_appointment() throws Exception {
		// clicking on the doctor appointment
		driver.findElement(By.xpath("(//div[@class='bkng_services_prfl'])/div/a[1]")).click();
		Thread.sleep(3000);
	}

	@Then("avaible doctors list will open and click on Book Appointment")
	public void avaible_doctors_list_will_open_and_click_on_book_appointment() throws Exception {
		// clicking on the book appointment
		driver.findElement(By.xpath("(//a[text()='Book Appointment'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("select the type clinic")
	public void select_the_type_clinic() throws Exception {
		// selecting the type - clinic type
		driver.findElement(By.xpath("(//div[@class='icon'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("select the location")
	public void select_the_location() throws Exception {
		// Location
		driver.findElement(By.xpath("(//div[@id='saved-addresses'])/div[1]")).click();
		Thread.sleep(1000);
		Robot robot11 = new Robot();
		for (int i = 0; i < 2; i++) {
			robot11.keyPress(KeyEvent.VK_CONTROL);
			robot11.keyPress(KeyEvent.VK_SUBTRACT);
			robot11.keyRelease(KeyEvent.VK_SUBTRACT);
			robot11.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(2000);
	}

	@When("user click on tomorrow slots will shown")
	public void user_click_on_tomorrow_slots_will_shown() throws Exception {
		// selecting the date and time - tomorrow
		driver.findElement(By.xpath("//div[@class='row dates-container']/div[2]")).click();
		Thread.sleep(2000);
	}

	@And("select the slot time")
	public void select_the_slot_time() throws Exception {
		if (driver.findElement(By.xpath("(//div[@class='slots'])[4]/div[1]/span")).isDisplayed()) {
			// night slot
			driver.findElement(By.xpath("(//div[@class='slots'])[4]/div[1]/span")).click();
			Thread.sleep(2000);

		} else if (driver.findElement(By.xpath("(//div[@class='slots'])[3]/div[1]/span")).isDisplayed()) {
			// evening slot
			driver.findElement(By.xpath("(//div[@class='slots'])[3]/div[1]/span")).click();
			Thread.sleep(1000);

		} else {
			// afternoon slot
			driver.findElement(By.xpath("(//div[@class='slots'])[2]/div[1]/span")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
	}

	@Then("user select the notify patient checkboxes")
	public void user_select_the_notify_patient_checkboxes() throws Exception {
		WebElement fee = driver.findElement(By.xpath("//label[text()='50']"));
		fee.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the notify
		WebElement gmail = driver.findElement(By.xpath("(//label[text()='Email'])[2]"));
		gmail.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS'])[2]"));
		sms.click();
		Thread.sleep(2000);
	}

	@When("user clicks on the submit button2")
	public void user_clicks_on_the_submit_button2() throws Exception {
		// clicking on the submit
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(10000);
	}

	@Then("it will redirect to the proforma invoice page")
	public void it_will_redirect_to_the_proforma_invoice_page() throws Exception {
//		System.out.println("you are in the proforma invoice page");
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

	}

	@When("user select the radio button from payment methods")
	public void user_select_the_radio_button_from_payment_methods() throws Exception {
		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash.click();
		Thread.sleep(1000);
	}

	@Then("the cursor will move to the transaction amount field")
	public void the_cursor_will_move_to_the_transaction_amount_field() throws InterruptedException {
	}

	@When("user enter the cash")
	public void user_enter_the_cash() throws Exception {
		// entering the amount
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("550");
		Thread.sleep(2000);
	}

	@Then("receipt comment icon will enable and click on it")
	public void receipt_comment_icon_will_enable_and_click_on_it() {
		// clicking on the comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("enter the {string} and click on ok")
	public void enter_the_cash_receipt_comments_and_click_on_ok(String comment) throws Exception {
		// comment
		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys(comment);
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		Thread.sleep(1000);
	}

	@When("user clicks on the submit button3")
	public void user_clicks_on_the_submit_button3() throws Exception {
		// clicking on the submit
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
	}

	@Then("it will redirect to the invoice page")
	public void it_will_redirect_to_the_invoice_page() {
	}

	@And("downloading invoice by clicking on the print icon")
	public void downloading_invoice_by_clicking_on_the_print_icon() throws Exception {
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
	}

	@And("downloading receipt by clicking on the receipt id")
	public void downloading_receipt_by_clicking_on_the_receipt_id() throws Exception {
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
//		// clicking on the receipt id
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[2]/div[2]/a")).click();
//		Thread.sleep(3000);
	}

	@And("downloading pdf by clicking on the total advance pdf icon")
	public void downloading_pdf_by_clicking_on_the_total_advance_pdf_icon() throws Exception {
//		// clicking on the total receipt
//		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[3]/div[1]/strong/span/a/img")).click();
//		Thread.sleep(2000);
	}

	@And("downloading invoice by clicking on the print icon in the page bottom")
	public void downloading_invoice_by_clicking_on_the_print_icon_in_the_page_bottom() throws Exception {
//		// clicking on the print
//		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(2000);
	}

	@When("user click on the share invoice")
	public void user_click_on_the_share_invoice() throws Exception {
//		// clicking on the share invoice
//		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
//		Thread.sleep(8000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@And("clearing the already given mail and mobile number")
	public void clearing_the_already_given_mail_and_mobile_number() {
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("phone")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("enter the emails {string}")
	public void enter_the_emails(String emails) throws Exception {
//		driver.findElement(By.id("emails")).sendKeys(emails);
//		Thread.sleep(1000);
	}

	@And("click on submit button4")
	public void click_on_submit_button4() throws Exception {
//		// submit
//		WebElement submit1 = driver.findElement(By.xpath("/html/body/main/div/div[12]/div/div[2]/form/div[2]/input"));
//		submit1.click();
//		Thread.sleep(18000);
	}

	@Then("user click on the back button")
	public void user_click_on_the_back_button() throws Exception {
//		driver.findElement(By.xpath("//a[text()='Back']")).click();
//		Thread.sleep(2000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions apts = new Actions(driver);
		apts.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@id='admin-doc-consultations'])[1]")).click();
		Thread.sleep(3000);

	}

	@And("user click on confirmed status")
	public void user_click_on_confirmed_status() throws Exception {
		// clicking on the confirmed
		WebDriverWait conf = new WebDriverWait(driver, Duration.ofSeconds(30));
		conf.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.cssSelector("a.btn-loader.status_links.cnfrd_btn.tooltipped"))))
				.click();
		// driver.findElement(By.cssSelector("a.btn-loader.status_links.cnfrd_btn.tooltipped")).click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("user click on the first appointment id")
	public void user_click_on_the_first_appointment_id() throws Exception {
		// clicking on the first patient id
		WebElement pat = driver.findElement(By.xpath("(//tr[@class='consultRow odd'])[1]/td[2]/a"));
		pat.click();
		Thread.sleep(3000);
	}

	@Then("pop-up will open")
	public void pop_up_will_open() {
	}

	@And("click on the Add Vitals")
	public void click_on_the_add_vitals() throws Exception {
	}

	@Then("enter the bp_complaint_examination")
	public void enter_the_bp_complaint_examination() throws Exception {
		String parentwind = driver.getWindowHandle();
		driver.findElement(By.cssSelector("div.row.appointment-buttons>div>div>a:nth-of-type(3)>img")).click();
		Thread.sleep(2000);
		Set<String> childwind = driver.getWindowHandles();
		for (String handle : childwind) {
			if (!handle.equals(parentwind)) {
				driver.switchTo().window(handle);
				Thread.sleep(1000);
			}
		}
		// bp
		driver.findElement(By.id("bp-s")).sendKeys("120");
		driver.findElement(By.id("bp-d")).sendKeys("90");
		Thread.sleep(1000);

		// save as draft
		driver.findElement(By.xpath("(//input[@name='create'])[1]")).click();
		Thread.sleep(3000);

		driver.switchTo().window(parentwind);
		Thread.sleep(2000);
	}

	@And("click on save as draft button")
	public void click_on_save_as_draft_button() throws Exception {
	}

	@When("user clicks on save as draft button it will redirect to the pop-up page")
	public void user_clicks_on_save_as_draft_button_it_will_redirect_to_the_pop_up_page() {
	}

	@And("closes the pop-up")
	public void closes_the_pop_up() throws Exception {
		// closing
		driver.findElement(By.cssSelector("div#modalApmntShow>div>div>span:nth-of-type(1)")).click();
		Thread.sleep(2000);
	}

	@When("user click on the profile img")
	public void user_click_on_the_profile_img() throws Exception {
		// clicking on the logo
		driver.findElement(By.xpath("/html/body/header/nav/ul/li/a/div/div[1]/img")).click();
		Thread.sleep(1000);
	}

	@Then("from options click on signout")
	public void from_options_click_on_signout() throws Exception {
		// clicking on sign out
		driver.findElement(By.xpath("/html/body/header/nav/ul/li/ul/li[5]/a")).click();
		Thread.sleep(1000);
	}

	@When("user navigates to the url")
	public void user_navigates_to_the_url() throws Exception {
		// navigate
		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(2000);
	}

	@Then("login page opens")
	public void login_page_opens() {
	}

	@And("enter the doctorrole mail {string}")
	public void enter_the_doctorrole_mail(String mail) throws Exception {
		driver.findElement(By.id("user_login")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("user_login")).sendKeys(mail);
		Thread.sleep(1000);
	}

	@Then("enter the doctorrole password {string}")
	public void enter_the_doctorrole_password(String password) throws Exception {
		driver.findElement(By.id("user_password")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(password);
		Thread.sleep(1000);
	}

	@And("click on signin button")
	public void click_on_signin_button() throws Exception {
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		Thread.sleep(3000);
	}

	@When("doctor signedup sucessfully")
	public void doctor_signedup_sucessfully() {
	}

	@Then("click on the week button from the doctor dashboard")
	public void click_on_the_week_button_from_the_doctor_dashboard() throws Exception {
		// clicking on the week
		driver.findElement(By.xpath("(//a[text()='Week'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("click on the patient name")
	public void click_on_the_patient_name() {
		driver.findElement(By.xpath("(//a[text()='Cucumber Prescription'])[1]")).click();
	}

	@And("click on the add prescription button")
	public void click_on_the_add_prescription_button() throws Exception {
		// clicking on the add prescription
		driver.findElement(By.xpath("(//button[text()='Add Prescription'])[1]")).click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		for (int i = 0; i < 2; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	@Then("add prescription pages opens")
	public void add_prescription_pages_opens() throws Exception {
		// prescription
		// symptoms
		driver.findElement(By.xpath("(//input[@id='doctor_visit_symptoms'])[1]")).click();
		Thread.sleep(1000);
		Robot sym1 = new Robot();
		sym1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[1]")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			Robot tab = new Robot();
			tab.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(1000);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot enter = new Robot();
		for (int i = 0; i <= 2; i++) {
			enter.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}
		for (int i = 0; i <= 2; i++) {
			enter.keyPress(KeyEvent.VK_LEFT);
			Thread.sleep(1000);
		}
		enter.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[2]")).sendKeys("3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot tab = new Robot();
		tab.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Months'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='doctor_visit_symptoms'])[1]")).sendKeys("Automationsymptom1");
		Thread.sleep(4000);
		Robot ent = new Robot();
		ent.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[3]")).sendKeys("3");
		Thread.sleep(1000);
		// remove
		driver.findElement(By.xpath("(//div[@id='input_close'])[2]/i[1]")).click();
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
		// chief complaints
		driver.findElement(By.xpath("(//label[text()='Chief Complaints'])[1]/following-sibling::input[1]")).click();
		Thread.sleep(1000);
		Robot enter1 = new Robot();
		enter1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[1]")).sendKeys("3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		enter1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Weeks'])[1]")).click();
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			enter1.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}
		for (int i = 0; i <= 2; i++) {
			enter1.keyPress(KeyEvent.VK_LEFT);
			Thread.sleep(1000);
		}
		enter1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[2]")).sendKeys("3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		enter1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Months'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Chief Complaints'])[1]/following-sibling::input[1]"))
				.sendKeys("Automateccone");
		Thread.sleep(4000);
		Robot ent1 = new Robot();
		ent1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[3]")).sendKeys("3");
		Thread.sleep(1000);
		// removing
		driver.findElement(By.xpath("(//div[@id='input_close_cmpl'])[2]/i[1]")).click();
		Thread.sleep(2000);

		// clinical examination
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]")).sendKeys("demo clinicalexamination1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]")).sendKeys("demo clinicalexamination2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]")).sendKeys("demo clinicalexamination3");
		Thread.sleep(1000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// patient history
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys("demo patienthistory1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys("demo patienthistory2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys("demo patienthistory3");
		Thread.sleep(1000);
//		JavascriptExecutor jse11 = (JavascriptExecutor) driver;
//		jse11.executeScript("window.scrollBy(0,100)", "");
//		Thread.sleep(1000);

		// family history
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[3]")).sendKeys("demo familyhistory1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[3]")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[3]")).sendKeys("demo familyhistory2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[3]")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[3]")).sendKeys("demo familyhistory3");
		Thread.sleep(1000);
		JavascriptExecutor jse111 = (JavascriptExecutor) driver;
		jse111.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// diagnosis
		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).click();
		Thread.sleep(1000);
		Robot enterrr = new Robot();
		enterrr.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[diagnosis][][dur]'])[1]")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		robot.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		robot.keyPress(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).click();
		Thread.sleep(1000);
		for (int i = 0; i <= 3; i++) {
			Robot diag = new Robot();
			diag.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}

		for (int i = 0; i <= 3; i++) {
			Robot diaRobot = new Robot();
			diaRobot.keyPress(KeyEvent.VK_LEFT);
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[diagnosis][][dur]'])[2]")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot doag = new Robot();
		doag.keyPress(KeyEvent.VK_TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		doag.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		doag.keyPress(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[diagnosis][][dur]'])[3]")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// removing
		driver.findElement(By.xpath("(//div[@class='input_close_diag'])[3]/i")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(1000);
		JavascriptExecutor jse1111 = (JavascriptExecutor) driver;
		jse1111.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		// pulse
		driver.findElement(By.xpath("(//label[text()='Pulse (bpm)'])/following-sibling::input")).sendKeys("102");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// height
		driver.findElement(By.xpath("(//label[text()='Height (Cms)'])/following-sibling::input")).sendKeys("180");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// weight
		driver.findElement(By.xpath("(//label[text()='Weight (Kgs)'])/following-sibling::input")).sendKeys("80");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		JavascriptExecutor jse11111 = (JavascriptExecutor) driver;
		jse11111.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		// pain scale
		driver.findElement(By.xpath("(//div[@class='icon'])[1]/img[1]")).click();
		Thread.sleep(1000);
		JavascriptExecutor pain = (JavascriptExecutor) driver;
		pain.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// medications
		Thread.sleep(3000);
		driver.findElement(By.id("patient_prescription_header_patient_prescription_lines_attributes_0_brand_name"))
				.click();
		Thread.sleep(2000);
		Robot medi = new Robot();
		medi.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		// clicking on the notes
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='Less'])[1]")).click();
		Thread.sleep(1000);
		// another
		driver.findElement(By.xpath(
				"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[20]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/input[1]"))
				.click();
		Thread.sleep(2000);
		for (int i = 0; i <= 3; i++) {
			Robot a = new Robot();
			a.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}

		for (int i = 0; i <= 3; i++) {
			Robot b = new Robot();
			b.keyPress(KeyEvent.VK_LEFT);
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		Robot c = new Robot();
		c.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// clicking on the notes
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='Less'])[2]")).click();
		Thread.sleep(1000);
		// removing
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[4]")).click();
		Thread.sleep(2000);
		JavascriptExecutor medico = (JavascriptExecutor) driver;
		medico.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		// duration
		driver.findElement(By.xpath("(//input[@id='doctor_visit_nxt_vst_dur'])[1]")).sendKeys("20");
		Thread.sleep(1000);

		// next visit type
		WebElement type = driver.findElement(By.xpath("(//label[text()='Tele-consultation'])[1]"));
		type.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement inper = driver.findElement(By.xpath("(//label[text()='In-person'])[1]"));
		inper.click();
		Thread.sleep(1000);

		// labs
		Thread.sleep(2000);
		driver.findElement(By.id("recommended_lab_input_helper")).sendKeys("Ecg");
		Thread.sleep(1000);
		Robot roblabot = new Robot();
		roblabot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// selecting through cursor
		driver.findElement(By.xpath("(//a[@class='btn green diagnosticTestSltd'])[4]")).click();
		Thread.sleep(1000);
		// selecting through enter button
		driver.findElement(By.id("recommended_lab_input_helper")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		// removing
		driver.findElement(By.xpath("(//i[@class='material-icons close lab_chip_close'])[3]")).click();
		Thread.sleep(2000);
		// removing
		driver.findElement(By.xpath("(//i[@class='material-icons close lab_chip_close'])[2]")).click();
		Thread.sleep(2000);
		// request
		driver.findElement(By.xpath("(//a[text()='Request'])[1]")).click();
		Thread.sleep(2000);
		// clicking on request again
		driver.findElement(By.id("requestLabs")).click();
		Thread.sleep(2000);
		JavascriptExecutor request = (JavascriptExecutor) driver;
		request.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		// procedures
		driver.findElement(By.cssSelector("input#packages_input")).click();
		Thread.sleep(2000);
		Robot proced = new Robot();
		proced.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#packages_input")).sendKeys("program");
		Thread.sleep(4000);
		Robot proced1 = new Robot();
		proced1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#packages_input")).sendKeys("Automateprocedure");
		Thread.sleep(3000);
		Robot proced2 = new Robot();
		proced2.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		// removing
		driver.findElement(By.xpath("(//i[@class='material-icons close package_chip_close'])[2]")).click();
		Thread.sleep(2000);

		// comments
		driver.findElement(By.cssSelector("textarea#prescriptionComments")).sendKeys("test comments");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("textarea#prescriptionComments")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("textarea#prescriptionComments")).sendKeys("test comments2");
		Thread.sleep(2000);

		// attachments
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Attachment'])[1]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div.col.right_side_layer.hide-on-small-only>img:nth-of-type(1)")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#attachmentsUploader"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\IP-09691 (1).pdf");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@onclick='closeAttachments()'])[1]")).click();
		Thread.sleep(3000);
		
		Actions lp = new Actions(driver);
		lp.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Last prescription'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Last prescription'])[1]")).click();
		Thread.sleep(2000);
		// all
		Actions all = new Actions(driver);
		all.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='All'])[1]/img"))).build().perform();
		Thread.sleep(1000);
		WebDriverWait all1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		all1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='All'])[1]/img"))))
				.click();
		Thread.sleep(1000);

		// doctor visits
		WebDriverWait dv = new WebDriverWait(driver, Duration.ofSeconds(30));
		dv.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Doctor Visits'])[1]/img")))).click();
		Thread.sleep(1000);

		// Chemotheraphy order
		WebDriverWait co = new WebDriverWait(driver, Duration.ofSeconds(30));
		co.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Chemotherapy Order'])[1]/img"))))
				.click();
		Thread.sleep(1000);

		// Dietitian visits
		WebDriverWait diev = new WebDriverWait(driver, Duration.ofSeconds(30));
		diev.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Dietician Vists'])[1]/img")))).click();
		Thread.sleep(1000);

		// Diagnostic reports
		WebDriverWait dr = new WebDriverWait(driver, Duration.ofSeconds(30));
		dr.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Diagnostic Reports'])[1]/img"))))
				.click();
		Thread.sleep(1000);

		// Procedures
		WebDriverWait p = new WebDriverWait(driver, Duration.ofSeconds(30));
		p.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Procedures'])[1]/img")))).click();
		Thread.sleep(1000);

		// Forms
		WebDriverWait forms = new WebDriverWait(driver, Duration.ofSeconds(30));
		forms.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Forms'])[1]/img"))))
				.click();
		Thread.sleep(1000);

		// DS
		WebDriverWait ds = new WebDriverWait(driver, Duration.ofSeconds(30));
		ds.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Discharge Summary'])[1]/img")))).click();
		Thread.sleep(1000);

		// closing
		driver.findElement(By.cssSelector("div#patientHistoryModal>div>div>span>i")).click();
		Thread.sleep(2000);
		Actions closi = new Actions(driver);
		closi.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Lab Reports'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);
		// lab reports
		driver.findElement(By.xpath("(//a[@data-tooltip='Lab Reports'])[1]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div#patientHistoryModal>div>div>span>i")).click();
		Thread.sleep(2000);
		// save as draft
		driver.findElement(By.xpath("//input[@value='Save as Draft'][1]")).click();
		Thread.sleep(3000);

		// clicking on the add prescription
		driver.findElement(By.xpath("//button[text()='Add Prescription']")).click();
		Thread.sleep(2000);
		// save
		driver.findElement(By.id("saveBtn")).click();
		Thread.sleep(3000);
		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor jdse = (JavascriptExecutor) driver;
			jdse.executeScript("window.scrollBy(0,100)", "");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		Robot rob123 = new Robot();
		rob123.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// without header & footer
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// with header and footer
		String parentwind = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img[1]")).click();
		Thread.sleep(1000);
		Set<String> childwindow = driver.getWindowHandles();
		for (String handle : childwindow) {
			if (!handle.equals(parentwind)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind);
			}
		}
		Thread.sleep(3000);
		// sharing
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("emails")).clear();
		driver.findElement(By.id("phone")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@value='Submit'])[2]")).click();
		Thread.sleep(18000);
		// clicking on the edit button
		driver.findElement(By.cssSelector("a.tooltipped.add-rescription-button.btn.green.editButton")).click();
		Thread.sleep(2000);
		// changing the duration 20 to 30 days
		Robot rowe1 = new Robot();
		rowe1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.id("doctor_visit_nxt_vst_dur")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("doctor_visit_nxt_vst_dur")).sendKeys("30");
		Thread.sleep(3000);
		driver.findElement(By.id("saveBtn")).click();
		Thread.sleep(2000);
		Robot rowe2 = new Robot();
		rowe2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// without header & footer
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img[1]")).click();
		Thread.sleep(3000);
		// with header & footer
		String parentwind1 = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img[1]")).click();
		Thread.sleep(2000);
		Set<String> childwind1 = driver.getWindowHandles();
		for (String handle : childwind1) {
			if (!childwind1.equals(parentwind1)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind1);
			}
		}
		Thread.sleep(1000);
		// sharing
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[3]/img")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("emails")).sendKeys("lokhsai.chenna@nanohealth.in");
		Thread.sleep(1000);
		// submit
				driver.findElement(By.xpath("(//input[@value='Submit'])[2]")).click();
				Thread.sleep(18000);
		// sharing
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[3]/img")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("emails")).sendKeys("lokhsai.chenna@nanohealth.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[2]")).click();
		Thread.sleep(18000);
		// close
		driver.findElement(By.cssSelector("a.left.btn.btn-loader.orange")).click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Medical Summary'])[1]/img")))).click();
//				driver.findElement(By.xpath("(//a[@data-tooltip='Medical Summary'])[1]/img")).click();
		Thread.sleep(3000);
		// patient history
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.id("patientHistoryBtn")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='Prescription']")).click();
		Thread.sleep(2000);
		// String parentwind = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]")).click();
		Thread.sleep(1000);
		Robot robot14 = new Robot();
		robot14.keyPress(KeyEvent.VK_CONTROL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		robot14.keyPress(KeyEvent.VK_W);
		Thread.sleep(1000);
		// clicking on the print without header & footer.
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]")).click();
		Thread.sleep(3000);
		// share invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).sendKeys("lokhsai.chenna@nanohealth.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[2]")).click();
		Thread.sleep(18000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Load Prescription'])[1]")).click();
		Thread.sleep(3000);

		// Accoimpained by
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]")).sendKeys("test clinical examination");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor cc = (JavascriptExecutor) driver;
			cc.executeScript("window.scrollBy(0,100)", "");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		driver.findElement(By.id("saveBtn")).click();
		Thread.sleep(3000);

		Robot w = new Robot();
		w.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// without header & footer
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[1]/img")).click();
		Thread.sleep(3000);
		// with header & footer
		String parentwind11 = driver.getWindowHandle();
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[2]/img")).click();
		Thread.sleep(2000);
		Set<String> childwind11 = driver.getWindowHandles();
		for (String handle : childwind11) {
			if (!childwind11.equals(parentwind11)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind11);
			}
		}
		Thread.sleep(1000);
		// sharing
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[3]/img")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("emails")).sendKeys("lokhsai.chenna@nanohealth.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[2]")).click();
		Thread.sleep(18000);

		driver.findElement(By.xpath("(//a[text()='Cucumber Prescription'])[1]")).click();
		Thread.sleep(3000);
		// patient history
		Robot err = new Robot();
		err.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.id("patientHistoryBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='Prescription'])[1]")).click();
		Thread.sleep(2000);

		// without header & footer
		driver.findElement(By.xpath("(//div[@class='card_overflow'])/ul/li[1]/div[3]/a[2]/img")).click();
		Thread.sleep(3000);
		// with header & footer
		String parentwind1111 = driver.getWindowHandle();
		driver.findElement(By.xpath("(//div[@class='card_overflow'])/ul/li[1]/div[3]/a[1]/img")).click();
		Thread.sleep(2000);
		Set<String> childwind111 = driver.getWindowHandles();
		for (String handle : childwind111) {
			if (!childwind111.equals(parentwind1111)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind1111);
			}
		}
		Thread.sleep(1000);
		 

	}

	@And("selects the consultation type")
	public void selects_the_consultation_type() throws Exception {
//		for (int i = 0; i <= 1; i++) {
//			driver.findElement(By.xpath("(//label[text()='In-person'])[1]")).click();
//			Thread.sleep(1000);
//		}
	}

	@Then("enter the accompained by")
	public void enter_the_accompained_by() {
//		driver.findElement(By.id("healthHistoryTxt")).sendKeys("demo test");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("healthHistoryTxt")).sendKeys(Keys.ENTER);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("healthHistoryTxt")).sendKeys("demo test2");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("enter the patient history")
	public void enter_the_patient_history() throws Exception {
//		Thread.sleep(1000);
//		// patient history
//		driver.findElement(By.xpath("(//div[@class='section_header'])[3]//following-sibling::div/textarea"))
//				.sendKeys("demo");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//div[@class='section_header'])[3]//following-sibling::div/textarea"))
//				.sendKeys(Keys.ENTER);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//div[@class='section_header'])[3]//following-sibling::div/textarea"))
//				.sendKeys("demo1");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//div[@class='section_header'])[3]//following-sibling::div/textarea"))
//				.sendKeys(Keys.ENTER);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//div[@class='section_header'])[3]//following-sibling::div/textarea"))
//				.sendKeys("demo2");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//div[@class='section_header'])[3]//following-sibling::div/textarea"))
//				.sendKeys(Keys.ENTER);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//div[@class='section_header'])[3]//following-sibling::div/textarea"))
//				.sendKeys("demo3");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,100)", "");
//		Thread.sleep(1000);

	}

	@Then("selects the symptoms from the suggestions")
	public void selects_the_symptoms_from_the_suggestions() throws Exception {
//		// chief complaints
//		driver.findElement(By.xpath("(//label[text()='Chief Complaints'])[1]/following-sibling::input[1]")).click();
//		Thread.sleep(1000);
//		Robot enter = new Robot();
//		enter.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[1]")).sendKeys("3");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		enter.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Weeks'])[1]")).click();
//		Thread.sleep(1000);
//		for (int i = 0; i <= 2; i++) {
//			enter.keyPress(KeyEvent.VK_RIGHT);
//			Thread.sleep(1000);
//		}
//		for (int i = 0; i <= 2; i++) {
//			enter.keyPress(KeyEvent.VK_LEFT);
//			Thread.sleep(1000);
//		}
//		enter.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[2]")).sendKeys("3");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		enter.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Months'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Chief Complaints'])[1]/following-sibling::input[1]"))
//				.sendKeys(Keys.ESCAPE);
//		Thread.sleep(2000);
//
//		driver.findElement(By.id("doctor_visit_symptoms")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("doctor_visit_symptoms")).sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
	}

	@When("symptom selected cursor goes to the duration field")
	public void symptom_selected_cursor_goes_to_the_duration_field() {
	}

	@And("enter the duration")
	public void enter_the_duration() {
//		// enterng the duration
//		driver.findElement(By.name("doctor_visit[symptoms][][dur]")).sendKeys("1");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("clicks on dropdown and selects the week")
	public void clicks_on_dropdown_and_selects_the_week() throws Exception {
//		// clicking on the dropdown
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_TAB);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// selecting the week
//		driver.findElement(By.xpath("//li[text()='Week']")).click();
//		Thread.sleep(2000);
	}

	@And("select another symptom using leftandright arrowkeys")
	public void select_another_symptom_using_leftandright_arrowkeys() throws Exception {
//		for (int i = 0; i <= 2; i++) {
//			driver.findElement(By.id("doctor_visit_symptoms")).sendKeys(Keys.RIGHT);
//			Thread.sleep(1000);
//		}
//		for (int i = 0; i <= 2; i++) {
//			driver.findElement(By.id("doctor_visit_symptoms")).sendKeys(Keys.LEFT);
//			Thread.sleep(1000);
//		}
//		driver.findElement(By.id("doctor_visit_symptoms")).sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
	}

	@Then("enters duration")
	public void enters_duration() throws Exception {
//		// duration
//		driver.findElement(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[2]")).sendKeys("20");
//		Thread.sleep(1000);
	}

	@And("clicks on symptoms field and search with name")
	public void clicks_on_symptoms_field_and_search_with_name() throws Exception {
//		driver.findElement(By.id("doctor_visit_symptoms")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.id("doctor_visit_symptoms")).sendKeys("gg");
//		Thread.sleep(1000);
	}

	@Then("click enter")
	public void click_enter() throws Exception {
//		driver.findElement(By.id("doctor_visit_symptoms")).sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
	}

	@And("enter duration")
	public void enter_duration() throws InterruptedException {
//		// duration
//		driver.findElement(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[3]")).sendKeys("20");
//		Thread.sleep(2000);
	}

	@Then("remove last two added symptoms")
	public void remove_last_two_added_symptoms() throws Exception {
//		// removing
//		driver.findElement(By.xpath("(//div[@id='input_close'])[3]")).click();
//		Thread.sleep(1000);
//		// removing
//		driver.findElement(By.xpath("(//div[@id='input_close'])[2]")).click();
//		Thread.sleep(2000);
	}

	@When("doctor click on symptoms field it will show the suggestions")
	public void doctor_click_on_symptoms_field_it_will_show_the_suggestions() throws Exception {
//		driver.findElement(By.id("doctor_visit_symptoms")).click();
//		Thread.sleep(2000);
	}

	@And("clicks on escape button to hide suggestion")
	public void clicks_on_escape_button_to_hide_suggestion() throws Exception {
//		driver.findElement(By.id("doctor_visit_symptoms")).sendKeys(Keys.ESCAPE);
//		Thread.sleep(3000);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,100)", "");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on the diagnosis field to select")
	public void click_on_the_diagnosis_field_to_select() throws Exception {
//		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).click();
//		Thread.sleep(1000);
	}

	@When("diagnosis field is clicked it will show the suggestions")
	public void diagnosis_field_is_clicked_it_will_show_the_suggestions() {
	}

	@And("select diagnosis by clicking enter button")
	public void select_diagnosis_by_clicking_enter_button() throws Exception {
//		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
	}

	@Then("enter duration and select duration from the dropdown")
	public void enter_duration_and_select_duration_from_the_dropdown() throws AWTException {
//		driver.findElement(By.xpath("(//input[@name='doctor_visit[diagnosis][][dur]'])[1]")).sendKeys("2");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_TAB);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		robot.keyPress(KeyEvent.VK_DOWN);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		robot.keyPress(KeyEvent.VK_ENTER);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("select another diagnosis by using left and right arrow keys and select by clicking enter")
	public void select_another_diagnosis_by_using_left_and_right_arrow_keys_and_select_by_clicking_enter()
			throws Exception {
//		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).click();
//		Thread.sleep(1000);
//		for (int i = 0; i <= 3; i++) {
//			Robot robot = new Robot();
//			robot.keyPress(KeyEvent.VK_RIGHT);
//			Thread.sleep(1000);
//		}
//
//		for (int i = 0; i <= 3; i++) {
//			Robot robot1 = new Robot();
//			robot1.keyPress(KeyEvent.VK_LEFT);
//			Thread.sleep(1000);
//		}
//		Thread.sleep(1000);
//		Robot robot2 = new Robot();
//		robot2.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
	}

	@Then("enter duration and select duration from the dropdown for diagnosis2")
	public void enter_duration_and_select_duration_from_the_dropdown_for_diagnosis2() throws Exception {
//		driver.findElement(By.xpath("(//input[@name='doctor_visit[diagnosis][][dur]'])[2]")).sendKeys("2");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_TAB);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		robot.keyPress(KeyEvent.VK_DOWN);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		robot.keyPress(KeyEvent.VK_ENTER);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("select another diagnosis and remove the last added diagnosis")
	public void select_another_diagnosis_and_remove_the_last_added_diagnosis() throws Exception {
//		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@name='doctor_visit[diagnosis][][dur]'])[3]")).sendKeys("2");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// removing
//		driver.findElement(By.xpath("(//div[@class='input_close_diag'])[3]/i")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ESCAPE);
//		Thread.sleep(1000);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,200)", "");
//		Thread.sleep(1000);
	}

	@When("enter the following details into the vitals field from the prescription")
	public void enter_the_following_details_into_the_vitals_field_from_the_prescription(
			io.cucumber.datatable.DataTable dataTable) throws Exception {
//		List<List<String>> Vitals = dataTable.asLists(String.class);
//		// pulse
//		driver.findElement(By.xpath("(//label[text()='Pulse (bpm)'])/following-sibling::input"))
//				.sendKeys(Vitals.get(0).get(1));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// height
//		driver.findElement(By.xpath("(//label[text()='Height (Cms)'])/following-sibling::input"))
//				.sendKeys(Vitals.get(1).get(1));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// weight
//		driver.findElement(By.xpath("(//label[text()='Weight (Kgs)'])/following-sibling::input"))
//				.sendKeys(Vitals.get(2).get(1));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		Thread.sleep(1000);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,200)", "");
//		Thread.sleep(1000);
	}

	@Then("adding history of line")
	public void adding_history_of_line() throws Exception {
//		driver.findElement(By.xpath("(//div[@class='section_header'])[9]//following-sibling::div/textarea"))
//				.sendKeys("test history");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[@class='section_header'])[9]//following-sibling::div/textarea"))
//				.sendKeys(Keys.ENTER);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[@class='section_header'])[9]//following-sibling::div/textarea"))
//				.sendKeys("test history");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,200)", "");
//		Thread.sleep(1000);
	}

	@And("selecting the medication clicking enter button")
	public void selecting_the_medication_clicking_enter_button() throws Exception {
//		Thread.sleep(3000);
//		driver.findElement(By.id("patient_prescription_header_patient_prescription_lines_attributes_0_brand_name"))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(By.id("patient_prescription_header_patient_prescription_lines_attributes_0_brand_name"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
	}

	@Then("clicking on medication notes icons and closing it")
	public void clicking_on_medication_notes_icons_and_closing_it() throws Exception {
//		// clicking on the notes
//		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//img[@data-tooltip='Less'])[1]")).click();
//		Thread.sleep(1000);
	}

	@And("adding another medicine using enter")
	public void adding_another_medicine_using_enter() throws Exception {
//		// another
//		driver.findElement(By.xpath(
//				"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[23]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/input[1]"))
//				.click();
//		Thread.sleep(2000);
//		for (int i = 0; i <= 3; i++) {
//			Robot robot = new Robot();
//			robot.keyPress(KeyEvent.VK_RIGHT);
//			Thread.sleep(1000);
//		}
//
//		for (int i = 0; i <= 3; i++) {
//			Robot robot1 = new Robot();
//			robot1.keyPress(KeyEvent.VK_LEFT);
//			Thread.sleep(1000);
//		}
//		Thread.sleep(1000);
//		Robot robot2 = new Robot();
//		robot2.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
	}

	@Then("click on medication notes icons and closing it")
	public void click_on_medication_notes_icons_and_closing_it() throws Exception {
//		// clicking on the notes
//		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[2]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//img[@data-tooltip='Less'])[2]")).click();
//		Thread.sleep(1000);
	}

	@And("removing last added medication scrolling page down")
	public void removing_last_added_medication_scrolling_page_down() throws Exception {
//		// removing
//		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[5]")).click();
//		Thread.sleep(2000);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,200)", "");
//		Thread.sleep(1000);
	}

//	@Then("click on the plus button for notes")
//	public void click_on_the_plus_button_for_notes() throws Exception {
//		driver.findElement(By.cssSelector("div#prescriptionNotesDiv>div:nth-of-type(1)>a>i")).click();
//		Thread.sleep(1000);
//	}
//
//	@And("enter the notes1 and click on plus again to add new notes2 row")
//	public void enter_the_notes1_and_click_on_plus_again_to_add_new_notes2_row() throws Exception {
//		driver.findElement(By.xpath("(//input[@class='bip_input new_lifestyle_text'])[1]")).sendKeys("test notes1");
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("div#prescriptionNotesDiv>div:nth-of-type(1)>a>i")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	}
//
//	@Then("enter the notes2 and click on plus again to add new notes3 row")
//	public void enter_the_notes2_and_click_on_plus_again_to_add_new_notes3_row() throws Exception {
//		driver.findElement(By.xpath("(//input[@class='bip_input new_lifestyle_text'])[2]")).sendKeys("test notes2");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.cssSelector("div#prescriptionNotesDiv>div:nth-of-type(1)>a>i")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	}
//
//	@And("enter the notes3 and remove the last added notes")
//	public void enter_the_notes3_and_remove_the_last_added_notes() throws Exception {
//		driver.findElement(By.xpath("(//input[@class='bip_input new_lifestyle_text'])[3]")).sendKeys("test notes3");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.cssSelector(
//				"div#prescriptionNotesDiv>div:nth-of-type(2)>div>div:nth-of-type(4)>div>div:nth-of-type(2)>a>i"))
//				.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	}

	@Then("entering duration for next visit date")
	public void entering_duration_for_next_visit_date() throws Exception {
//		// next visit date
//		driver.findElement(By.cssSelector("input#doctor_visit_nxt_vst_dur")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.id("doctor_visit_nxt_vst_dur")).sendKeys("20");
//		Thread.sleep(1000);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,100)", "");
//		Thread.sleep(1000);
	}

	@And("selecting nextvisittype")
	public void selecting_nextvisittype() throws Exception {
//		// next visit type
//		WebElement nvt = driver.findElement(By.xpath("(//label[text()='In-person'])[2]"));
//		nvt.click();
//		Thread.sleep(1000);
	}

	@Then("selecting labs using search")
	public void selecting_labs_using_search() throws Exception {
//		Thread.sleep(2000);
//		driver.findElement(By.id("recommended_lab_input_helper")).sendKeys("Ecg");
//		Thread.sleep(1000);
	}

	@And("clicking enter to select lab")
	public void clicking_enter_to_select_lab() throws Exception {
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
	}

	@When("doctor clicks on labs suggestions will show")
	public void doctor_clicks_on_labs_suggestions_will_show() throws Exception {
//		// selecting through cursor
//		driver.findElement(By.xpath("(//a[@class='btn green diagnosticTestSltd'])[4]")).click();
//		Thread.sleep(1000);
	}

	@And("selecting labs from suggestions using enter button")
	public void selecting_labs_from_suggestions_using_enter_button() throws Exception {
		// selecting through enter button
//		driver.findElement(By.id("recommended_lab_input_helper")).sendKeys(Keys.ENTER);
//		Thread.sleep(3000);
	}

	@Then("removing the labs")
	public void removing_the_labs() throws Exception {
//		// removing
//		driver.findElement(By.xpath("(//i[@class='material-icons close lab_chip_close'])[3]")).click();
//		Thread.sleep(2000);
//		// removing
//		driver.findElement(By.xpath("(//i[@class='material-icons close lab_chip_close'])[2]")).click();
//		Thread.sleep(2000);
	}

	@And("enter the free text for labs and click enter button")
	public void enter_the_free_text_for_labs_and_click_enter_button() throws Exception {
//		driver.findElement(By.id("recommended_lab_input_helper")).sendKeys("testfreetextforlabinprescription");
//		Thread.sleep(1000);
//		driver.findElement(By.id("recommended_lab_input_helper")).sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
	}

	@When("clicking on request button popup will opens")
	public void clicking_on_request_button_popup_will_opens() throws Exception {
//		// request
//		driver.findElement(By.xpath("(//a[text()='Request'])[1]")).click();
//		Thread.sleep(2000);
	}

	@And("clicking on the request button")
	public void clicking_on_the_request_button() throws Exception {
//		// clicking on request again
//		driver.findElement(By.id("requestLabs")).click();
//		Thread.sleep(2000);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,200)", "");
//		Thread.sleep(1000);
	}

	@Then("entering comments")
	public void entering_comments() throws Exception {
	}

	@And("selecting procedures using searching")
	public void selecting_procedures_using_searching() throws Exception {

	}

	@Then("selecting the procedures using cursor")
	public void selecting_the_procedures_using_cursor() throws Exception {
	}

	@And("removing added procedures")
	public void removing_added_procedures() throws Exception {

	}

	@And("enter the free text for procedures")
	public void enter_the_free_text_for_procedures() throws Exception {

	}

	@Then("select the pain scale emoji")
	public void select_the_pain_scale_emoji() throws Exception {

	}

	@And("enter the investigation")
	public void enter_the_investigation() {

	}

	@Then("enter the advice in the prescription form")
	public void enter_the_advice_in_the_prescription_form() {

	}

	@And("click on the attachment present at top right middle")
	public void click_on_the_attachment_present_at_top_right_middle() throws Exception {
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Attachment'])[1]"))).build().perform();
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("div.col.right_side_layer.hide-on-small-only>img:nth-of-type(1)")).click();
//		Thread.sleep(2000);
	}

	@When("attachment is clicked attach files popup will opened")
	public void attachment_is_clicked_attach_files_popup_will_opened() {
	}

	@Then("from the attach files popup send the file and click on the ok button")
	public void from_the_attach_files_popup_send_the_file_and_click_on_the_ok_button() throws Exception {
//		driver.findElement(By.cssSelector("input#attachmentsUploader"))
//				.sendKeys("C:\\Users\\Lenovo\\Desktop\\Automation Run Outputs\\01_Dec_23\\Prescription.pdf");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[@onclick='closeAttachments()'])[1]")).click();
//		Thread.sleep(3000);
	}

	@When("ok button is clicked attach files popup will be closed")
	public void ok_button_is_clicked_attach_files_popup_will_be_closed() {
	}

	@And("click on the health information present at bottom right side")
	public void click_on_the_health_information_present_at_bottom_right_side() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Health Information'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//a[@data-tooltip='Health Information'])[1]/img")).click();
		Thread.sleep(2000);
	}

	@When("health information is clicked it will open the health information")
	public void health_information_is_clicked_it_will_open_the_health_information() {
	}

	@Then("give the necessary health information and submit")
	public void give_the_necessary_health_information_and_submit() throws Exception {

	}

	@And("close the health information popup")
	public void close_the_health_information_popup() throws Exception {
		// closing the popup
		driver.findElement(By.cssSelector("div#patientHistoryInfoModal>div>div>span>i")).click();
		Thread.sleep(1000);
	}

	@Then("click on the doctor notes present bottom of health information")
	public void click_on_the_doctor_notes_present_bottom_of_health_information() throws Exception {

	}

	@When("doctor notes is clicked it will open the popup for notes")
	public void doctor_notes_is_clicked_it_will_open_the_popup_for_notes() {
	}

	@Then("enter the message for notes")
	public void enter_the_message_for_notes() throws Exception {

	}

	@And("enable the checkboxes if necessary click on the save button")
	public void enable_the_checkboxes_if_necessary_click_on_the_save_button() throws Exception {

	}

	@Then("close the notes popup in the prescription")
	public void close_the_notes_popup_in_the_prescription() throws Exception {
//		driver.findElement(By.cssSelector("div#doctor_notes_new_modal>div>div>div>span>i")).click();
//		Thread.sleep(1000);
	}

	@And("click on the favourite prescription and close it")
	public void click_on_the_favourite_prescription_and_close_it() throws InterruptedException {

	}

	@Then("click on the past prescription")
	public void click_on_the_past_prescription() throws InterruptedException {
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Last prescription'])[1]/img"))).build()
//				.perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Last prescription'])[1]")).click();
//		Thread.sleep(2000);
//		// all
//		Actions all = new Actions(driver);
//		all.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='All'])[1]/img"))).build().perform();
//		Thread.sleep(1000);
//		WebDriverWait all1 = new WebDriverWait(driver, Duration.ofSeconds(30));
//		all1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='All'])[1]/img"))))
//				.click();
//		// driver.findElement(By.xpath("(//a[@data-tooltip='All'])[1]/img")).click();
//		Thread.sleep(1000);
//
//		// doctor visits
//		WebDriverWait dv = new WebDriverWait(driver, Duration.ofSeconds(30));
//		dv.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Doctor Visits'])[1]/img")))).click();
//		Thread.sleep(1000);
//
//		// Chemotheraphy order
//		WebDriverWait co = new WebDriverWait(driver, Duration.ofSeconds(30));
//		co.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Chemotherapy Order'])[1]/img"))))
//				.click();
//		Thread.sleep(1000);
//
//		// Dietitian visits
//		WebDriverWait diev = new WebDriverWait(driver, Duration.ofSeconds(30));
//		diev.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Dietician Vists'])[1]/img")))).click();
//		Thread.sleep(1000);
//
//		// Diagnostic reports
//		WebDriverWait dr = new WebDriverWait(driver, Duration.ofSeconds(30));
//		dr.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Diagnostic Reports'])[1]/img"))))
//				.click();
//		Thread.sleep(1000);
//
//		// Procedures
//		WebDriverWait p = new WebDriverWait(driver, Duration.ofSeconds(30));
//		p.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Procedures'])[1]/img")))).click();
//		Thread.sleep(1000);
//
//		// Forms
//		WebDriverWait forms = new WebDriverWait(driver, Duration.ofSeconds(30));
//		forms.until(
//				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Forms'])[1]/img"))))
//				.click();
//		Thread.sleep(1000);
//
//		// DS
//		WebDriverWait ds = new WebDriverWait(driver, Duration.ofSeconds(30));
//		ds.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Discharge Summary'])[1]/img")))).click();
//		Thread.sleep(1000);
//
//		// closing
//		driver.findElement(By.cssSelector("div#patientHistoryModal>div>div>span>i")).click();
//		Thread.sleep(2000);
	}

	@When("past prescription is clicked it will open the recently saved prescription")
	public void past_prescription_is_clicked_it_will_open_the_recently_saved_prescription() {

	}

	@And("click on the lab reports and close it")
	public void click_on_the_lab_reports_and_close_it() throws InterruptedException {
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Lab Reports'])[1]/img"))).build()
//				.perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Lab Reports'])[1]/img")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("div#patientHistoryModal>div>div>span>i")).click();
//		Thread.sleep(2000);
	}

	@When("doctor clicks on saveasdraft it will redirect to the patient profile")
	public void doctor_clicks_on_saveasdraft_it_will_redirect_to_the_patient_profile() throws Exception {
//		// save as draft
//		driver.findElement(By.xpath("//input[@value='Save as Draft']")).click();
//		Thread.sleep(3000);
//		for (int i = 0; i <= 3; i++) {
//			Robot robot = new Robot();
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_ADD);
//			robot.keyRelease(KeyEvent.VK_ADD);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
	}

	@And("clicking Add Prescription and saving")
	public void clicking_add_prescription_and_saving() throws Exception {
//		// clicking on the add prescription
//		driver.findElement(By.xpath("//button[text()='Add Prescription']")).click();
//		Thread.sleep(2000);
//		// save
//		driver.findElement(By.id("saveBtn")).click();
//		Thread.sleep(3000);
//		for (int i = 0; i <= 10; i++) {
//			JavascriptExecutor jse = (JavascriptExecutor) driver;
//			jse.executeScript("window.scrollBy(0,100)", "");
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
//		Thread.sleep(1000);
	}

	@Then("Scrolling pagedown and downloading pdfs")
	public void scrolling_pagedown_and_downloading_pdfs() throws Exception {
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		// without header & footer
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[1]/img")).click();
//		Thread.sleep(2000);
//		// with header and footer
//		String parentwind = driver.getWindowHandle();
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[2]/img")).click();
//		Thread.sleep(1000);
//		Set<String> childwindow = driver.getWindowHandles();
//		for (String handle : childwindow) {
//			if (!handle.equals(parentwind)) {
//				Thread.sleep(2000);
//				driver.switchTo().window(parentwind);
//			}
//		}
//		Thread.sleep(3000);
	}

	@And("sharing the prescription to mailid1 {string}")
	public void sharing_the_prescription_to_mailid1(String mailid1) throws Exception {
//		// sharing
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[3]/img")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.id("emails")).clear();
//		driver.findElement(By.id("phone")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.id("emails")).sendKeys(mailid1);
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
//		Thread.sleep(18000);
	}

	@When("doctor click on edit button")
	public void doctor_click_on_edit_button() throws Exception {
//		// clicking on the edit button
//		driver.findElement(By.cssSelector("a.tooltipped.add-rescription-button.btn.green.editButton")).click();
//		Thread.sleep(2000);
	}

	@Then("prescription opens")
	public void prescription_opens() {
//		System.out.println("Edit prescription is opened");
	}

	@And("editing the nextvisitdate duration")
	public void editing_the_nextvisitdate_duration() throws Exception {
//		// changing the duration 20 to 30 days
//		Robot robot1 = new Robot();
//		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		driver.findElement(By.id("doctor_visit_nxt_vst_dur")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.id("doctor_visit_nxt_vst_dur")).sendKeys("30");
//		Thread.sleep(3000);
	}

	@Then("clicking on save button for prescription")
	public void clicking_on_save_button_for_prescription() throws Exception {
//		driver.findElement(By.id("saveBtn")).click();
//		Thread.sleep(2000);
	}

	@And("Scrolling pagedown and download pdfs")
	public void scrolling_pagedown_and_download_pdfs() throws Exception {
//		Robot robot2 = new Robot();
//		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		// without header & footer
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[1]/img")).click();
//		Thread.sleep(3000);
//		// with header & footer
//		String parentwind1 = driver.getWindowHandle();
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[2]/img")).click();
//		Thread.sleep(2000);
//		Set<String> childwind1 = driver.getWindowHandles();
//		for (String handle : childwind1) {
//			if (!childwind1.equals(parentwind1)) {
//				Thread.sleep(2000);
//				driver.switchTo().window(parentwind1);
//			}
//		}
//		Thread.sleep(1000);
	}

	@Then("sharing the prescription to emailid2 {string}")
	public void sharing_the_prescription_to_emailid2(String emailid2) throws Exception {
//		// sharing
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[3]/img")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.id("phone")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.id("emails")).sendKeys(emailid2);
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
//		Thread.sleep(18000);
	}

	@And("clicking on the close button of prescription")
	public void clicking_on_the_close_button_of_prescription() throws Exception {
//		// close
//		driver.findElement(By.cssSelector("a.left.btn.btn-loader.orange")).click();
//		Thread.sleep(2000);
	}

	@When("doctor clicks on close it will redirect to the patient profile")
	public void doctor_clicks_on_close_it_will_redirect_to_the_patient_profile() {
	}

	@And("click on the medical conditions icon")
	public void click_on_the_medical_conditions_icon() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Medical Summary'])[1]/img")))).click();
////		driver.findElement(By.xpath("(//a[@data-tooltip='Medical Summary'])[1]/img")).click();
//		Thread.sleep(3000);
	}

	@When("medical condition icon is clicked it will download the medical pdf contains medicine")
	public void medical_condition_icon_is_clicked_it_will_download_the_medical_pdf_contains_medicine() {

	}

	@Then("clicks on historybutton")
	public void clicks_on_historybutton() throws Exception {
//		// patient history
//		Robot robot4 = new Robot();
//		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
//		driver.findElement(By.id("patientHistoryBtn")).click();
//		Thread.sleep(1000);
	}

	@When("history open then prescription row will display")
	public void history_open_then_prescription_row_will_display() {
	}

	@And("downloads pdfs and share to the mailid3 {string}")
	public void downloads_pdfs_and_share_to_the_mailid3(String mailid3) throws Exception {
//		driver.findElement(By.xpath("//span[text()='Prescription']")).click();
//		Thread.sleep(2000);
//		// String parentwind = driver.getWindowHandle();
//		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]")).click();
//		Thread.sleep(1000);
//		Robot robot14 = new Robot();
//		robot14.keyPress(KeyEvent.VK_CONTROL);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		robot14.keyPress(KeyEvent.VK_W);
//		Thread.sleep(1000);
//		// clicking on the print without header & footer.
//		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]")).click();
//		Thread.sleep(3000);
//		// share invoice
//		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("phone")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.id("emails")).sendKeys(mailid3);
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[27]/div/div[2]/form/div[2]/input")).click();
//		Thread.sleep(18000);
//		// clicking on the prescription
//		driver.findElement(By.xpath("//span[text()='Prescription']")).click();
//		Thread.sleep(5000);
//		// driver.quit();
	}

	@Then("click on the load prescription from history of patientprofile")
	public void click_on_the_load_prescription_from_history_of_patientprofile() throws Exception {
//		driver.findElement(By.xpath("(//a[@data-tooltip='Load Prescription'])[1]")).click();
//		Thread.sleep(3000);
	}

	@When("load prescription is clicked it will open prescription")
	public void load_prescription_is_clicked_it_will_open_prescription() {
	}

	@Then("click on the save button after opening prescription")
	public void click_on_the_save_button_after_opening_prescription() throws Exception {
//		// Accoimpained by
//		driver.findElement(By.id("healthHistoryTxt")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("healthHistoryTxt")).sendKeys("Mother");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		Thread.sleep(1000);
//		for (int i = 0; i <= 10; i++) {
//			JavascriptExecutor jse = (JavascriptExecutor) driver;
//			jse.executeScript("window.scrollBy(0,100)", "");
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
//		Thread.sleep(1000);
//		driver.findElement(By.id("saveBtn")).click();
//		Thread.sleep(3000);
	}

	@And("download the pdfs and share invoice after loading prescription")
	public void download_the_pdfs_and_share_invoice_after_loading_prescription() throws Exception {
//		Robot robot2 = new Robot();
//		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		// without header & footer
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[1]/img")).click();
//		Thread.sleep(3000);
//		// with header & footer
//		String parentwind1 = driver.getWindowHandle();
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[2]/img")).click();
//		Thread.sleep(2000);
//		Set<String> childwind1 = driver.getWindowHandles();
//		for (String handle : childwind1) {
//			if (!childwind1.equals(parentwind1)) {
//				Thread.sleep(2000);
//				driver.switchTo().window(parentwind1);
//			}
//		}
//		Thread.sleep(1000);
//		// sharing
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[3]/img")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.id("phone")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.id("emails")).sendKeys("Sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
//		Thread.sleep(18000);
	}

	@Then("click on the patient name from the prescription after saving loaded prescription")
	public void click_on_the_patient_name_from_the_prescription_after_saving_loaded_prescription() throws Exception {
//		driver.findElement(By.xpath("(//a[text()='Cucumber Prescription'])[1]")).click();
//		Thread.sleep(3000);
	}

	@And("click on the history from the patientprofile")
	public void click_on_the_history_from_the_patientprofile() throws Exception {
//		// patient history
//		Robot robot4 = new Robot();
//		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
//		driver.findElement(By.id("patientHistoryBtn")).click();
//		Thread.sleep(1000);
	}

	@When("history is clicked there will be two rows for prescription")
	public void history_is_clicked_there_will_be_two_rows_for_prescription() {
	}

	@Then("download the pdfs from the prescription row from history")
	public void download_the_pdfs_from_the_prescription_row_from_history() throws Exception {
//		driver.findElement(By.xpath("(//span[text()='Prescription'])[1]")).click();
//		Thread.sleep(2000);
//
//		// without header & footer
//		driver.findElement(By.xpath("(//div[@class='card_overflow'])/ul/li[1]/div[3]/a[2]/img")).click();
//		Thread.sleep(3000);
//		// with header & footer
//		String parentwind1 = driver.getWindowHandle();
//		driver.findElement(By.xpath("(//div[@class='card_overflow'])/ul/li[1]/div[3]/a[1]/img")).click();
//		Thread.sleep(2000);
//		Set<String> childwind1 = driver.getWindowHandles();
//		for (String handle : childwind1) {
//			if (!childwind1.equals(parentwind1)) {
//				Thread.sleep(2000);
//				driver.switchTo().window(parentwind1);
//			}
//		}
//		Thread.sleep(1000);
//		// sharing
//		driver.findElement(By.xpath("(//div[@class='card_overflow'])/ul/li[1]/div[3]/a[3]/img")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.id("phone")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.id("emails")).sendKeys("Sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
//		Thread.sleep(20000);
	}

	@And("clicking on the diagnostic trends")
	public void clicking_on_the_diagnostic_trends() throws Exception {
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[32]/div[2]/div[1]/ul/li[3]/a")).click();
//		Thread.sleep(2000);
	}

	@Then("select the diagnostic trend from the dropdown and search")
	public void select_the_diagnostic_trend_from_the_dropdown_and_search() throws Exception {
//		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//li[text()='Weight'])[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
//		Thread.sleep(1000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
	}

	@When("search is clicked then it will show the weight in the graph")
	public void search_is_clicked_then_it_will_show_the_weight_in_the_graph() {

	}

	@And("click on the table to show the weight in the table")
	public void click_on_the_table_to_show_the_weight_in_the_table() throws Exception {
//		driver.findElement(By.cssSelector("a#table_btn")).click();
//		Thread.sleep(2000);
	}

	@Then("click on the medicine chart")
	public void click_on_the_medicine_chart() throws Exception {
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[32]/div[2]/div[1]/ul/li[4]/a")).click();
//		Thread.sleep(2000);
//		// driver.quit();
	}
}
