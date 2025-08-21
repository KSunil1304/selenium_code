package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GynecPrescription {
	WebDriver driver = null;

	@Given("navigate to the NanoHealth portal website")
	public void navigate_to_the_nano_health_portal_website() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver130.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Then("enter the emailormobileforcm  {string} passwordforcm {string}")
	public void enter_the_emailormobileforcm_passwordforcm(String emailormobileforcm, String passwordforcm)
			throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(emailormobileforcm);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(passwordforcm);
		Thread.sleep(2000);
	}

	@Then("click on the sign in button to login into the clinicmanager dashboard")
	public void click_on_the_sign_in_button_to_login_into_the_clinicmanager_dashboard() throws Exception {
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
	}

	@Then("select the role of clinicmanager as NH_IP_OP")
	public void select_the_role_of_clinicmanager_as_nh_ip_op() throws Exception {
		// selecting Role clicking on Clinic manager Role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[7]/div/div/div/div[2]")).click();
		Thread.sleep(5000);
	}

	@Then("deleting the already existing patient from clinicmanager NH_IP_OP")
	public void deleting_the_already_existing_patient_from_clinicmanager_nh_ip_op() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.id("frst_nm")).sendKeys("Cucumgynec");
		Thread.sleep(5000);
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
		Thread.sleep(8000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(1000);
		robot1.keyRelease(KeyEvent.VK_ADD);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
	}

	@Then("click on the add patient icon from the clinicmanger NH_IP_OP")
	public void click_on_the_add_patient_icon_from_the_clinicmanger_nh_ip_op() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Patient'])[2]/img")).click();
	}

	@Then("select title_of_the_patient")
	public void select_title_of_the_patient() throws Exception {
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

	@When("user enters the following details into registration form from the NH_IP_OP clinicmanager role")
	public void user_enters_the_following_details_into_registration_form_from_the_nh_ip_op_clinicmanager_role(
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
		// aadharcardnumber
		driver.findElement(
				By.xpath("(//input[@id='patient_master_patient_questnr_value_details_attributes_2_result_value'])[1]"))
				.sendKeys(regData.get(8).get(1));
	}

	@Then("select the radio_buttons in the registration form from the clinicmanager role")
	public void select_the_radio_buttons_in_the_registration_form_from_the_clinicmanager_role() throws Exception {
		// abhacard
		WebElement ac = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		ac.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// profession
		driver.findElement(By.xpath("(//input[@name='patient_master[profession]'])[1]")).sendKeys("test profession");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// referred by
//		driver.findElement(By.xpath("(//a[@data-tooltip='Add Referral'])[1]")).click();
//		Thread.sleep(1000);
//		// corporate
//		driver.findElement(By.xpath("(//div[@class='icon'])[6]")).click();
//		Thread.sleep(1000);
//		// corporate name
//		driver.findElement(By.cssSelector("input#corp_name")).sendKeys("NH Corporate");
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.cssSelector("span.cls.btn.green.right.referral_submit")).click();
//		Thread.sleep(2000);
		// demand program
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='NanoHealth-HYD'])")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
	}

	@Then("click on the submit_button_to_register_the_new_patient from the NH_IP+OP")
	public void click_on_the_submit_button_to_register_the_new_patient_from_the_nh_ip_op() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// submit
		driver.findElement(By.id("update_submit")).click();
		Thread.sleep(5000);
	}

	@When("patient is registered it will navigate to the patient profile")
	public void patient_is_registered_it_will_navigate_to_the_patient_profile() {
	}

	@Then("click on book doctor appointment from the booking services section")
	public void click_on_book_doctor_appointment_from_the_booking_services_section() throws Exception {
		// clicking on the doctor appointment
		driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(1)>img")).click();
		Thread.sleep(5000);
	}

	@And("search and book appointment to the doctor")
	public void search_and_book_appointment_to_the_doctor() throws Exception {
		driver.findElement(By.cssSelector("input#q_doctor_master_frst_nm_or_doctor_master_lst_nm_cont"))
				.sendKeys("Manvitha");
		Thread.sleep(2000);
		// clicking on the search button
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the book appointment
		driver.findElement(By.cssSelector("a.modal-trigger.btn.green.right.btn-loader:nth-of-type(1)")).click();
		Thread.sleep(2000);
	}

	@Then("select the type of the appointment")
	public void select_the_type_of_the_appointment() throws Exception {
		// selecting the type - video type
		driver.findElement(By.xpath("(//div[@class='icon'])[1]")).click();
		Thread.sleep(8000);
	}

	@Then("select the location for the appointment")
	public void select_the_location_for_the_appointment() throws Exception {
		driver.findElement(By.xpath("(//div[@id='saved-addresses'])[2]/div/div/div[1]/div[1]")).click();
		Thread.sleep(2000);
	}

	@And("select the slot time for the appointment")
	public void select_the_slot_time_for_the_appointment() throws Exception {
//		// selecting the date and time - tomorrow
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("//div[@class='row dates-container']/div[2]")))).click();
		driver.findElement(By.xpath("//div[@class='row dates-container']/div[2]")).click();
		Thread.sleep(2000);
		Robot robot11 = new Robot();
		for (int i = 0; i < 3; i++) {
			robot11.keyPress(KeyEvent.VK_CONTROL);
			robot11.keyPress(KeyEvent.VK_SUBTRACT);
			robot11.keyRelease(KeyEvent.VK_SUBTRACT);
			robot11.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(2000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("(//div[@class='slots'])[1]/div[1]/span")).isDisplayed()) {
			// morning slot
			driver.findElement(By.xpath("(//div[@class='slots'])[1]/div[1]/span")).click();
			Thread.sleep(2000);

		} else if (driver.findElement(By.xpath("(//div[@class='slots'])[2]/div[1]/span")).isDisplayed()) {
			// afternoon slot
			driver.findElement(By.xpath("(//div[@class='slots'])[2]/div[1]/span")).click();
			Thread.sleep(1000);

		} else {
			// evening slot
			driver.findElement(By.xpath("(//div[@class='slots'])[3]/div[1]/span")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
	}

	@Then("select the neccessary checkboxes in the payment popup")
	public void select_the_neccessary_checkboxes_in_the_payment_popup() throws Exception {
		WebElement fee = driver.findElement(By.xpath("//label[text()='50']"));
		fee.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the notify
		WebElement gmail = driver.findElement(By.xpath("(//label[text()='Email'])[2]"));
		gmail.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS'])[2]"));
		sms.click();
		Thread.sleep(1000);

	}

	@And("click on the submit button from the payment popup")
	public void click_on_the_submit_button_from_the_payment_popup() throws Exception {
		// clicking on the submit
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@Then("select the payment method radio button")
	public void select_the_payment_method_radio_button() {
		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("enter the amount for the appointment")
	public void enter_the_amount_for_the_appointment() throws Exception {
		// entering the amount
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("1000");
		Thread.sleep(2000);
	}

	@When("amount is entered then receipt comment is enabled")
	public void amount_is_entered_then_receipt_comment_is_enabled() {
	}

	@Then("click on the receipt comment and enter the comment click on the ok button")
	public void click_on_the_receipt_comment_and_enter_the_comment_click_on_the_ok_button() {
		// clicking on the comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test receipt comment");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("click on the submit_button from the proforma invoice page")
	public void click_on_the_submit_button_from_the_proforma_invoice_page() throws Exception {
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// clicking on the submit
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
	}

	@Then("click on the print invoice icon")
	public void click_on_the_print_invoice_icon() throws Exception {
		// printing
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@And("click on the receipt id total advance icons")
	public void click_on_the_receipt_id_total_advance_icons() throws Exception {
		// clicking on the receipt id
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[2]/div[2]/a")).click();
		Thread.sleep(3000);
		// clicking on the total receipt
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[3]/div[1]/strong/span/a/img"))
				.click();
		Thread.sleep(3000);
	}

	@Then("click on the print and prescription buttons in the bottom of the page")
	public void click_on_the_print_and_prescription_buttons_in_the_bottom_of_the_page() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/i")).click();
		Thread.sleep(2000);
		// clicking on the prescription button
		driver.findElement(By.xpath("(//a[text()='Prescription'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("share the invoice by clicking share invoice button in the bottom of page")
	public void share_the_invoice_by_clicking_share_invoice_button_in_the_bottom_of_page() throws Exception {
//		// clicking on the share invoice
//		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("phone")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// submit
//		WebElement submit1 = driver.findElement(By.xpath("/html/body/main/div/div[12]/div/div[2]/form/div[2]/input"));
//		submit1.click();
//		Thread.sleep(30000);
	}

	@Then("logout from the role")
	public void logout_from_the_role() throws Exception {
		driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@class='fa fa-sign-out'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("naviagate_ to_the NH_Web_portal application")
	public void naviagate_to_the_nh_web_portal_application() throws Exception {
		// navigate
		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(2000);
	}

	@Then("enter the emailormobile3 {string} password3 {string}")
	public void enter_the_emailormobile3_password3(String emailormobile3, String password3) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(emailormobile3);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(password3);
		Thread.sleep(1000);
	}

	@And("click sign_in_button to login")
	public void click_sign_in_button_to_login() throws Exception {
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		Thread.sleep(3000);
	}

	@When("doctor dashboard will be opened")
	public void doctor_dashboard_will_be_opened() {
	}

	@Then("from the dashboard click on the week from the list view")
	public void from_the_dashboard_click_on_the_week_from_the_list_view() throws Exception {
		// clicking on the week
		driver.findElement(By.xpath("(//a[text()='Week'])[1]")).click();
		Thread.sleep(5000);
	}

	@When("week is clicked it will show list of appointments for this week")
	public void week_is_clicked_it_will_show_list_of_appointments_for_this_week() {
	}

	@Then("click on the patient name to add gynec prescription")
	public void click_on_the_patient_name_to_add_gynec_prescription() throws Exception {
		// clicking on the name
		driver.findElement(By.xpath("(//a[text()='Cucum Gynec'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the add prescription from the patient profile")
	public void click_on_the_add_prescription_from_the_patient_profile() throws Exception {
		driver.findElement(By.xpath("(//button[text()='Add Prescription'])[1]")).click();
		Thread.sleep(3000);
		Robot robot11 = new Robot();
		for (int i = 0; i < 3; i++) {
			robot11.keyPress(KeyEvent.VK_CONTROL);
			robot11.keyPress(KeyEvent.VK_ADD);
			robot11.keyRelease(KeyEvent.VK_ADD);
			robot11.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(2000);
	}

	@When("add prescription is clicked it will open the prescription form page")
	public void add_prescription_is_clicked_it_will_open_the_prescription_form_page() {
	}

	@Then("write the clinical examination")
	public void write_the_clinical_examination() {
		driver.findElement(By
				.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[1]/div[2]/div/div[2]/textarea"))
				.sendKeys("Clinical examination test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("click on the enter button to add new clinical examination")
	public void click_on_the_enter_button_to_add_new_clinical_examination() {
		driver.findElement(By
				.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[1]/div[2]/div/div[2]/textarea"))
				.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("enter button is clicked then in new line will be opened with bullet point")
	public void enter_button_is_clicked_then_in_new_line_will_be_opened_with_bullet_point() {
	}

	@Then("enter the new clinical examination text")
	public void enter_the_new_clinical_examination_text() {
		driver.findElement(By
				.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[1]/div[2]/div/div[2]/textarea"))
				.sendKeys("Clinical examination test1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("select the menustral history radio button")
	public void select_the_menustral_history_radio_button() {
		WebElement radio = driver.findElement(By.xpath("(//label[text()='Regular'])[1]"));
		radio.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("select the LMP date")
	public void select_the_lmp_date() throws Exception {
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[4]/div[2]/div/input[2]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@data-day='1'])[1]")).click();
	}

	@And("select the EDD date")
	public void select_the_edd_date() throws Exception {
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[4]/div[3]/div/input[2]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();

	}

	@Then("enter the menustral history")
	public void enter_the_menustral_history() {
		driver.findElement(By
				.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[8]/div[1]/div/div[2]/textarea"))
				.sendKeys("Menstrual history");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("click on the enter button to add new menustral history")
	public void click_on_the_enter_button_to_add_new_menustral_history() {
		driver.findElement(By
				.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[8]/div[1]/div/div[2]/textarea"))
				.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("enter button is clicked then in new line will be opened with bullet point for menustral history")
	public void enter_button_is_clicked_then_in_new_line_will_be_opened_with_bullet_point_for_menustral_history() {
	}

	@Then("enter the new menustral history text")
	public void enter_the_new_menustral_history_text() {
		driver.findElement(By
				.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[8]/div[1]/div/div[2]/textarea"))
				.sendKeys("Menstrual history1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("enter the obsteric history")
	public void enter_the_obsteric_history() {
		driver.findElement(By
				.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[8]/div[2]/div/div[2]/textarea"))
				.sendKeys("Obsteric history test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on the enter button to add new obsteric history")
	public void click_on_the_enter_button_to_add_new_obsteric_history() {
		driver.findElement(By
				.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[8]/div[2]/div/div[2]/textarea"))
				.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("enter button is clicked then in new line will be opened with bullet point for obsteric history")
	public void enter_button_is_clicked_then_in_new_line_will_be_opened_with_bullet_point_for_obsteric_history() {
	}

	@Then("enter the another obsteric history")
	public void enter_the_another_obsteric_history() {
		driver.findElement(By
				.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[8]/div[2]/div/div[2]/textarea"))
				.sendKeys("Obsteric history test1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("enter the following into the vitals in the gynec prescription")
	public void enter_the_following_into_the_vitals_in_the_gynec_prescription(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		List<List<String>> vitals = dataTable.asLists(String.class);

		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[12]/div[1]/div/input[2]"))
				.sendKeys(vitals.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[12]/div[2]/div/input[2]"))
				.sendKeys(vitals.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[12]/div[3]/div/input[2]"))
				.sendKeys(vitals.get(2).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("bp-s")).sendKeys(vitals.get(3).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("bp-d")).sendKeys(vitals.get(4).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[12]/div[5]/div/input[2]"))
				.sendKeys(vitals.get(5).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[16]/div[1]/div/input[2]"))
				.sendKeys(vitals.get(6).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[16]/div[2]/div/input[2]"))
				.sendKeys(vitals.get(7).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[16]/div[2]/div/input[2]"))
				.sendKeys(Keys.TAB);
		Thread.sleep(2000);
	}

	@Then("select the pain scale from the gynec prescription")
	public void select_the_pain_scale_from_the_gynec_prescription() throws Exception {
		driver.findElement(By.xpath("(//div[@class='icon'])[1]/img")).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@And("click on the medicine field in gynec prescription")
	public void click_on_the_medicine_field_in_gynec_prescription() throws Exception {
		driver.findElement(
				By.cssSelector("input#patient_prescription_header_patient_prescription_lines_attributes_0_brand_name"))
				.click();
		Thread.sleep(3000);
	}

	@When("medicine field is clicked it will show the medicine suggestions")
	public void medicine_field_is_clicked_it_will_show_the_medicine_suggestions() {
	}

	@Then("select the medicine using enter button")
	public void select_the_medicine_using_enter_button() throws Exception {
		driver.findElement(
				By.cssSelector("input#patient_prescription_header_patient_prescription_lines_attributes_0_brand_name"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@class='mrng numeric autocmplt'])[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[text()='1-1-0-0'])[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[text()='Alternate day'])[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(
//				By.xpath("(//input[@class='prescriptionInput-medications end_duration numeric_with_out_dot'])[1]"))
//				.sendKeys("2");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("click on the notes icon to show notes and close it")
	public void click_on_the_notes_icon_to_show_notes_and_close_it() throws Exception {
		driver.findElement(By.cssSelector(
				"div#patient_prescription_lines>div:nth-of-type(1)>div>div:nth-of-type(10)>a>img:nth-of-type(1)"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(
				"div#patient_prescription_lines>div:nth-of-type(1)>div>div:nth-of-type(10)>a>img:nth-of-type(2)"))
				.click();
		Thread.sleep(2000);
	}

	@Then("click on the medicine field again to add new medicine")
	public void click_on_the_medicine_field_again_to_add_new_medicine() throws Exception {
		driver.findElement(By.xpath(
				"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[22]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/input[1]"))
				.click();
		Thread.sleep(1000);
	}

	@And("using right and left arrow keys select medicine by clicking enter button")
	public void using_right_and_left_arrow_keys_select_medicine_by_clicking_enter_button() throws Exception {

		for (int i = 0; i <= 2; i++) {
			driver.findElement(By.xpath(
					"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[22]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/input[1]"))
					.sendKeys(Keys.RIGHT);
			Thread.sleep(1000);
		}
		for (int i = 0; i <= 2; i++) {
			driver.findElement(By.xpath(
					"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[22]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/input[1]"))
					.sendKeys(Keys.LEFT);
			Thread.sleep(1000);
		}
		for (int i = 0; i <= 2; i++) {
			driver.findElement(By.xpath(
					"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[22]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/input[1]"))
					.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
		}

		// driver.findElement(By.xpath("(//input[@class='mrng numeric
		// autocmplt'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@class='mrng numeric autocmplt'])[2]")).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@class='mrng numeric autocmplt'])[2]")).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@class='mrng numeric autocmplt'])[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//div[text()='1-1-0-0'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//div[text()='Daily'])[1]")).click();
		driver.findElement(By.xpath("(//input[@class='frequency'])[2]")).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@class='frequency'])[2]")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(
				By.xpath("(//input[@class='prescriptionInput-medications end_duration numeric_with_out_dot'])[2]"))
				.sendKeys("3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on the notes icon again to show notes and close it")
	public void click_on_the_notes_icon_again_to_show_notes_and_close_it() throws Exception {
//		driver.findElement(By.cssSelector(
//				"div#patient_prescription_lines>div:nth-of-type(2)>div>div:nth-of-type(10)>a>img:nth-of-type(1)"))
//				.click();
//		Thread.sleep(1000);

		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(1000);

//		driver.findElement(By.cssSelector(
//				"div#patient_prescription_lines>div:nth-of-type(2)>div>div:nth-of-type(10)>a>img:nth-of-type(2)"))
//				.click();
//		Thread.sleep(1000);

//		// clicking on the plus button
//		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
//		Thread.sleep(2000);
	}

//	@And("select third medicine and remove it")
//	public void select_third_medicine_and_remove_it() throws Exception {
//		driver.findElement(By.xpath(
//				"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[22]/div/div[2]/div/div[1]/div[3]/div/div[2]/div/input[1]"))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(
//				"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[22]/div/div[2]/div/div[1]/div[3]/div/div[2]/div/input[1]"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[3]")).click();
//		Thread.sleep(1000);
//	}

	@Then("enter the next visit date")
	public void enter_the_next_visit_date() {
		driver.findElement(By.cssSelector("input#doctor_visit_nxt_vst_dur")).sendKeys("20");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("next visit date is entered then visit date will be displayed beside calendar icon")
	public void next_visit_date_is_entered_then_visit_date_will_be_displayed_beside_calendar_icon() {
	}

	@Then("select next visit type radio button")
	public void select_next_visit_type_radio_button() throws Exception {
		WebElement radio = driver.findElement(By.xpath("(//label[text()='In-person'])[1]"));
		radio.click();
		Thread.sleep(2000);
		WebElement radio1 = driver.findElement(By.xpath("(//label[text()='In-person'])[1]"));
		radio1.click();
		Thread.sleep(2000);
	}

	@And("click on the labs field from the gynec prescription")
	public void click_on_the_labs_field_from_the_gynec_prescription() throws InterruptedException {
		driver.findElement(By.cssSelector("input#recommended_lab_input_helper")).click();
		Thread.sleep(2000);
	}

	@When("labs field is clicked it will show lab suggestions")
	public void labs_field_is_clicked_it_will_show_lab_suggestions() {

	}

	@Then("select lab using enter button")
	public void select_lab_using_enter_button() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
	}

	@And("select another using search and click enter button")
	public void select_another_using_search_and_click_enter_button() throws Exception {
		driver.findElement(By.cssSelector("input#recommended_lab_input_helper")).sendKeys("RBS");
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
	}

	@Then("select the third lab")
	public void select_the_third_lab() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}

	@And("remove one of the labs from the selected labs")
	public void remove_one_of_the_labs_from_the_selected_labs() throws Exception {
		driver.findElement(By.xpath("(//i[@class='material-icons close lab_chip_close'])[3]")).click();
		Thread.sleep(2000);
	}

	@Then("click on the request button for labs")
	public void click_on_the_request_button_for_labs() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Request'])[1]")).click();
		Thread.sleep(2000);
	}

	@When("request button is clicked it will open a popup")
	public void request_button_is_clicked_it_will_open_a_popup() {
	}

	@Then("click on the request button from the popup")
	public void click_on_the_request_button_from_the_popup() throws Exception {
		driver.findElement(By.cssSelector("div#requestLabs")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@When("request button from the popup is clicked popup will be closed")
	public void request_button_from_the_popup_is_clicked_popup_will_be_closed() {
	}

	@Then("click on the procedures field from the gynec prescription")
	public void click_on_the_procedures_field_from_the_gynec_prescription() throws Exception {
		driver.findElement(By.cssSelector("input#packages_input")).click();
		Thread.sleep(2000);
	}

	@When("procedures field is clicked it will show the suggestions")
	public void procedures_field_is_clicked_it_will_show_the_suggestions() {
	}

	@And("select the procedure by clicking enter button in gynec prescription")
	public void select_the_procedure_by_clicking_enter_button_in_gynec_prescription() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}

	@Then("select the another procedure using search and clicking enter button")
	public void select_the_another_procedure_using_search_and_clicking_enter_button() throws Exception {
		driver.findElement(By.cssSelector("input#packages_input")).sendKeys("covid");
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}

	@And("select the procedures and remove the last added procedure")
	public void select_the_procedures_and_remove_the_last_added_procedure() throws Exception {
		driver.findElement(By.xpath("(//i[@class='material-icons close package_chip_close'])[3]")).click();
		Thread.sleep(2000);
	}

	@Then("enter the comments in the comments field")
	public void enter_the_comments_in_the_comments_field() {
		driver.findElement(By.cssSelector("textarea#prescriptionComments")).sendKeys("testing comments");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("click on the enter button in the comments field")
	public void click_on_the_enter_button_in_the_comments_field() {
		driver.findElement(By.cssSelector("textarea#prescriptionComments")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("comments field enter button is clicked it will show a new bullet point")
	public void comments_field_enter_button_is_clicked_it_will_show_a_new_bullet_point() {
	}

	@Then("enter the comments again")
	public void enter_the_comments_again() throws Exception {
		driver.findElement(By.cssSelector("textarea#prescriptionComments")).sendKeys("testing comments2");
		Thread.sleep(1000);
	}

	@And("click on the attachment present at top right middle in gynec prescription")
	public void click_on_the_attachment_present_at_top_right_middle_in_gynec_prescription() throws Exception {
		driver.findElement(By.cssSelector("div.col.right_side_layer.hide-on-small-only>img:nth-of-type(1)")).click();
		Thread.sleep(2000);
	}

	@When("attachment is clicked attach files popup will opened in gynec prescription")
	public void attachment_is_clicked_attach_files_popup_will_opened_in_gynec_prescription() {
	}

	@Then("from the attach files popup send the file and click on the ok button in gynec prescription")
	public void from_the_attach_files_popup_send_the_file_and_click_on_the_ok_button_in_gynec_prescription()
			throws Exception {
		driver.findElement(By.cssSelector("input#attachmentsUploader"))
				.sendKeys("C:\\Users\\Lenovo\\Downloads\\OP-05000.pdf");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@onclick='closeAttachments()'])[1]")).click();
		Thread.sleep(3000);
	}

	@When("ok button is clicked attach files popup will be closed in gynec prescription")
	public void ok_button_is_clicked_attach_files_popup_will_be_closed_in_gynec_prescription() {
	}

	@And("click on the health information present at bottom right side in gynec prescription")
	public void click_on_the_health_information_present_at_bottom_right_side_in_gynec_prescription() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Health Information'])[1]/img")).click();
		Thread.sleep(2000);
	}

	@When("health information is clicked it will open the health information in gynec prescription")
	public void health_information_is_clicked_it_will_open_the_health_information_in_gynec_prescription() {
	}

	@Then("give the necessary health information and submit in gynec prescription")
	public void give_the_necessary_health_information_and_submit_in_gynec_prescription() throws Exception {
		// blood group
		driver.findElement(By.xpath("(//a[@id='edit_patient'])[1]/img")).click();
		Thread.sleep(1000);
		// selecting blood group from the dropdown
		driver.findElement(By.cssSelector("span#select2-result_value-container")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='O+'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
		Thread.sleep(2000);

		// smoking
		driver.findElement(By.xpath("(//a[@id='edit_patient'])[2]/img")).click();
		Thread.sleep(1000);
		WebElement never = driver.findElement(By.xpath("(//label[text()='Never'])[1]"));
		never.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
		Thread.sleep(2000);

		// alcohol
		driver.findElement(By.xpath("(//a[@id='edit_patient'])[3]/img")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#result_value")).sendKeys("3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
		Thread.sleep(2000);

		// diet
		driver.findElement(By.xpath("(//a[@id='edit_patient'])[4]/img")).click();
		Thread.sleep(1000);
		// selecting diet from the dropdown
		driver.findElement(By.cssSelector("span#select2-result_value-container")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='2'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
		Thread.sleep(2000);

		// Excerise
		driver.findElement(By.xpath("(//a[@id='edit_patient'])[5]/img")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#result_value")).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
		Thread.sleep(2000);

//						// other dieases
//						driver.findElement(By.xpath("(//a[@id='edit_patient'])[6]/img")).click();
//						Thread.sleep(1000);
//						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//						wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//label[text()='N'])[7]")))).click();
////						WebElement N = driver.findElement(By.xpath("(//label[text()='N'])[7]"));
////						never.click();
//						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//						driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
//						Thread.sleep(2000);
//						// closing the popup
//						driver.findElement(By.cssSelector("div#patientHistoryInfoModal>div>div>span>i")).click();
//						Thread.sleep(2000);
	}

	@And("close the health information popup in gynec prescription")
	public void close_the_health_information_popup_in_gynec_prescription() throws Exception {
		// closing the popup
		driver.findElement(By.cssSelector("div#patientHistoryInfoModal>div>div>span>i")).click();
		Thread.sleep(1000);
	}

	@Then("click on the doctor notes present bottom of health information in gynec prescription")
	public void click_on_the_doctor_notes_present_bottom_of_health_information_in_gynec_prescription()
			throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Doctor notes'])[1]")).click();
		Thread.sleep(2000);
	}

	@When("doctor notes is clicked it will open the popup for notes in gynec prescription")
	public void doctor_notes_is_clicked_it_will_open_the_popup_for_notes_in_gynec_prescription() {
	}

	@Then("enter the message for notes in gynec prescription")
	public void enter_the_message_for_notes_in_gynec_prescription() throws Exception {
		driver.findElement(By.cssSelector("textarea#message")).sendKeys("test message");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#files_constr")).sendKeys("C:\\Users\\Lenovo\\Downloads\\OP-05000.pdf");
		Thread.sleep(3000);
	}

	@And("enable the checkboxes if necessary click on the save button in gynec prescription")
	public void enable_the_checkboxes_if_necessary_click_on_the_save_button_in_gynec_prescription() throws Exception {
		// dietician
		for (int i = 0; i <= 2; i++) {
			WebElement dietician = driver.findElement(By.xpath("(//label[text()='Dietitian'])[1]"));
			dietician.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

		// patient
		for (int i = 0; i <= 2; i++) {
			WebElement patient = driver.findElement(By.xpath("(//label[text()='Patient'])[1]"));
			patient.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

		// others
		for (int i = 0; i <= 2; i++) {
			WebElement other = driver.findElement(By.xpath("(//label[text()='Others'])[1]"));
			other.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Save'])[2]")).click();
		Thread.sleep(2000);
	}

	@Then("close the notes popup in the prescription in gynec prescription")
	public void close_the_notes_popup_in_the_prescription_in_gynec_prescription() throws Exception {
		driver.findElement(By.cssSelector("div#doctor_notes_new_modal>div>div>div>span>i")).click();
		Thread.sleep(1000);
	}

	@And("click on the favourite prescription and close it in gynec prescription")
	public void click_on_the_favourite_prescription_and_close_it_in_gynec_prescription() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Favourite Gynec Prescription'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div#patientHistoryInfoModal>div>div>span>i")).click();
		Thread.sleep(2000);
	}

	@Then("click on the past prescription in gynec prescription")
	public void click_on_the_past_prescription_in_gynec_prescription() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Last prescription'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div#patientHistoryModal>div>div>span>i")).click();
		Thread.sleep(2000);
	}

	@When("past prescription is clicked it will open the recently saved prescription in gynec prescription")
	public void past_prescription_is_clicked_it_will_open_the_recently_saved_prescription_in_gynec_prescription() {
	}

	@And("click on the lab reports and close it in gynec prescription")
	public void click_on_the_lab_reports_and_close_it_in_gynec_prescription() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Lab Reports'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div#patientHistoryModal>div>div>span>i")).click();
		Thread.sleep(2000);
	}

	@When("doctor clicks on saveasdraft for gynec prescription it redirect to patient profile")
	public void doctor_clicks_on_saveasdraft_for_gynec_prescription_it_redirect_to_patient_profile() throws Exception {
		// save as draft
		driver.findElement(By.xpath("//input[@value='Save as Draft']")).click();
		Thread.sleep(3000);
	}

	@And("clicking on the  Add Prescription and saving gynec prescription")
	public void clicking_on_the_add_prescription_and_saving_gynec_prescription() throws Exception {
		// clicking on the add prescription
		driver.findElement(By.xpath("//button[text()='Add Prescription']")).click();
		Thread.sleep(2000);
		// save
		driver.findElement(By.id("saveBtn")).click();
		Thread.sleep(3000);
	}

	@Then("Scrolling pagedown and downloading pdfs in the gynec preview prescription page")
	public void scrolling_pagedown_and_downloading_pdfs_in_the_gynec_preview_prescription_page() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(5000);
		// without header & footer
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[1]/img")).click();
		Thread.sleep(2000);
		// with header and footer
		String parentwind = driver.getWindowHandle();
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[2]/img")).click();
		Thread.sleep(1000);
		Set<String> childwindow = driver.getWindowHandles();
		for (String handle : childwindow) {
			if (!handle.equals(parentwind)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind);
			}
		}
		Thread.sleep(3000);
	}

	@And("sharing the gynec prescription to mailid1 {string}")
	public void sharing_the_gynec_prescription_to_mailid1(String mailid1) throws Exception {
		// sharing
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[3]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("emails")).clear();
		driver.findElement(By.id("phone")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).sendKeys(mailid1);
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
		Thread.sleep(30000);
	}

	@When("doctor click on edit button in the gynec prescription")
	public void doctor_click_on_edit_button_in_the_gynec_prescription() throws Exception {
		// clicking on the edit button
		driver.findElement(By.cssSelector("a.tooltipped.add-rescription-button.btn.green.editButton")).click();
		Thread.sleep(2000);
	}

	@Then("gynec prescription form opens")
	public void gynec_prescription_form_opens() {

	}

	@And("editing the nextvisitdate for gynec prescription duration")
	public void editing_the_nextvisitdate_for_gynec_prescription_duration() throws Exception {
		// changing the duration 20 to 30 days
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.id("doctor_visit_nxt_vst_dur")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("doctor_visit_nxt_vst_dur")).sendKeys("30");
		Thread.sleep(3000);
	}

	@Then("clicking on save button for saving gynec prescription")
	public void clicking_on_save_button_for_saving_gynec_prescription() throws Exception {
		driver.findElement(By.id("saveBtn")).click();
		Thread.sleep(2000);
	}

	@And("Scrolling pagedown and download pdfs in the gynec prescription preview page")
	public void scrolling_pagedown_and_download_pdfs_in_the_gynec_prescription_preview_page() throws Exception {
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		// without header & footer
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[1]/img")).click();
		Thread.sleep(3000);
		// with header & footer
		String parentwind1 = driver.getWindowHandle();
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[2]/img")).click();
		Thread.sleep(2000);
		Set<String> childwind1 = driver.getWindowHandles();
		for (String handle : childwind1) {
			if (!childwind1.equals(parentwind1)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind1);
			}
		}
		Thread.sleep(1000);
	}

	@Then("sharing the gynec prescription to emailid2 {string}")
	public void sharing_the_gynec_prescription_to_emailid2(String emailid2) throws Exception {
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[3]/img")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("emails")).sendKeys(emailid2);
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
		Thread.sleep(20000);
	}

	@And("clicking on the close button of gynec prescription")
	public void clicking_on_the_close_button_of_gynec_prescription() throws Exception {
		// close
		driver.findElement(By.cssSelector("a.left.btn.btn-loader.orange")).click();
		Thread.sleep(2000);
	}

	@When("doctor clicks close it will redirect to patient profile")
	public void doctor_clicks_close_it_will_redirect_to_patient_profile() {
	}

	@And("click on the medical conditions icon from the patient profile")
	public void click_on_the_medical_conditions_icon_from_the_patient_profile() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Medical Summary'])[1]/img")).click();
		Thread.sleep(3000);
	}

	@When("medical condition icon is clicked it will download the medical pdf")
	public void medical_condition_icon_is_clicked_it_will_download_the_medical_pdf() {
	}

	@Then("clicks on historybutton in  patient profile")
	public void clicks_on_historybutton_in_patient_profile() throws Exception {
		// patient history
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.id("patientHistoryBtn")).click();
		Thread.sleep(1000);
	}

	@When("history open then gynec prescription row will display")
	public void history_open_then_gynec_prescription_row_will_display() {
	}

	@Then("click on the Gynec Prescription middle of the first row")
	public void click_on_the_gynec_prescription_middle_of_the_first_row() throws Exception {
		driver.findElement(By.xpath("(//span[text()='Gynec Prescription'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("download the with and without header footers from the first row")
	public void download_the_with_and_without_header_footers_from_the_first_row() throws Exception {
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
	}

	@Then("share the gynec prescription to mail using share prescription")
	public void share_the_gynec_prescription_to_mail_using_share_prescription() throws Exception {
		// share invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).sendKeys("Sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@value='Submit'])[2]")).click();
		Thread.sleep(25000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@And("click on the load prescription button from the first row")
	public void click_on_the_load_prescription_button_from_the_first_row() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Load Prescription'])[1]/img")).click();
		Thread.sleep(3000);
	}

	@When("load prescription is clicked it will load and open gynec prescription form")
	public void load_prescription_is_clicked_it_will_load_and_open_gynec_prescription_form() {
	}

	@Then("make changes if any in the load prescription")
	public void make_changes_if_any_in_the_load_prescription() {
		driver.findElement(By
				.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[1]/div[2]/div/div[2]/textarea"))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By
				.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[1]/div[2]/div/div[2]/textarea"))
				.sendKeys("Clinical examination test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("click on the save button in the gynec prescription form after loading")
	public void click_on_the_save_button_in_the_gynec_prescription_form_after_loading() throws Exception {
		// save
		driver.findElement(By.id("saveBtn")).click();
		Thread.sleep(3000);
	}

	@When("load prescription is saved then it will create another row in the patients history")
	public void load_prescription_is_saved_then_it_will_create_another_row_in_the_patients_history() {
	}

	@Then("download the header footer pdfs from the preview page")
	public void download_the_header_footer_pdfs_from_the_preview_page() throws Exception {
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		// without header & footer
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[1]/img")).click();
		Thread.sleep(3000);
		// with header & footer
		String parentwind1 = driver.getWindowHandle();
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[2]/img")).click();
		Thread.sleep(2000);
		Set<String> childwind1 = driver.getWindowHandles();
		for (String handle : childwind1) {
			if (!childwind1.equals(parentwind1)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind1);
			}
		}
		Thread.sleep(1000);

	}

	@And("share the pdf using share prescription from the preview page")
	public void share_the_pdf_using_share_prescription_from_the_preview_page() throws Exception {
		// sharing
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a[3]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("emails")).clear();
		driver.findElement(By.id("phone")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).sendKeys("Sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
		Thread.sleep(30000);
	}

	@Then("click on the patients name from the preview page")
	public void click_on_the_patients_name_from_the_preview_page() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Cucum Gynec'])[1]")).click();
		Thread.sleep(3000);

	}

	@And("click on the history button again in the patient profile after loading prescription")
	public void click_on_the_history_button_again_in_the_patient_profile_after_loading_prescription() throws Exception {
		// patient history
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.id("patientHistoryBtn")).click();
		Thread.sleep(1000);
	}

	@Then("click on the Gynec Prescription middle of the first row after saving load prescription")
	public void click_on_the_gynec_prescription_middle_of_the_first_row_after_saving_load_prescription()
			throws Exception {
		driver.findElement(By.xpath("(//span[text()='Gynec Prescription'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("download the with and without header footers from the first row after saving load prescription")
	public void download_the_with_and_without_header_footers_from_the_first_row_after_saving_load_prescription()
			throws Exception {
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		// without header & footer
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")).click();
		Thread.sleep(3000);
		// with header & footer
		String parentwind1 = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img")).click();
		Thread.sleep(2000);
		Set<String> childwind1 = driver.getWindowHandles();
		for (String handle : childwind1) {
			if (!childwind1.equals(parentwind1)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind1);
			}
		}
		Thread.sleep(1000);
	}

	@Then("share the gynec prescription to mail using share prescription after saving load prescription")
	public void share_the_gynec_prescription_to_mail_using_share_prescription_after_saving_load_prescription()
			throws Exception {
		// sharing
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("phone")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).sendKeys("Sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@name='commit'])[3]")).click();
		Thread.sleep(30000);
	}
}
