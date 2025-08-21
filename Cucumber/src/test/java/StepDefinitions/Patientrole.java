package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Patientrole {
	WebDriver driver = null;

	@Given("open browswer for login")
	public void open_browswer_for_login() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver131.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("navigate to nh url and login with below details")
	public void navigate_to_nh_url_and_login_with_below_details(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		List<List<String>> regData = dataTable.asLists(String.class);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_login")).sendKeys(regData.get(0).get(1));
		driver.findElement(By.id("user_password")).sendKeys(regData.get(1).get(1));
	}

	@Then("click on signin button to open profile page")
	public void click_on_signin_button_to_open_profile_page() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
	}

	@And("select the patient role from the profile page")
	public void select_the_patient_role_from_the_profile_page() throws Exception {
		// clicking on the patient role
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[1]/div/div/div/div[2]")).click();
//		Thread.sleep(3000);
	}

	@When("patient role homepage opens")
	public void patient_role_homepage_opens() {

	}

	@Then("mouse-hovering to the existing address home icon in patient role")
	public void mouse_hovering_to_the_existing_address_home_icon_in_patient_role() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='row mobile_patient_info']/div[1]/a/img")))
				.build().perform();
		Thread.sleep(1000);
	}

	@And("clicking on the address icon to add new address")
	public void clicking_on_the_address_icon_to_add_new_address() throws Exception {
		// clicking on the add address img icon
		driver.findElement(By.xpath("//div[@class='row mobile_patient_info']/div[1]/a/img")).click();
		Thread.sleep(2000);

	}

	@Then("click on the plus button to add new address in patient role")
	public void click_on_the_plus_button_to_add_new_address_in_patient_role() {
		// clicking on the plus
		driver.findElement(By.xpath("//a[@data-tooltip='Add New Address']/i")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("enter the following details to add new address in patient role")
	public void enter_the_following_details_to_add_new_address_in_patient_role(
			io.cucumber.datatable.DataTable dataTable) throws Exception {
		List<List<String>> regData = dataTable.asLists(String.class);
		// address line 1
		driver.findElement(By.id("address_detail_address_line1")).sendKeys(regData.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// address line 2
		driver.findElement(By.id("address_detail_address_line2")).sendKeys(regData.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// landmark
		driver.findElement(By.id("address_detail_landmark")).sendKeys(regData.get(2).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the district
		driver.findElement(By.id("dist_nm")).sendKeys(regData.get(3).get(1));
		Thread.sleep(1000);
	}

	@And("select city from the dropdown for new address in patient role")
	public void select_city_from_the_dropdown_for_new_address_in_patient_role() throws Exception {
		driver.findElement(By.xpath("//li[text()='Hyderabad']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("entering the pincode for new address in patient role")
	public void entering_the_pincode_for_new_address_in_patient_role() throws Exception {
		// entering the pincode
		driver.findElement(By.id("address_detail_pin_code")).sendKeys("500100");
		Thread.sleep(1000);
	}

	@When("user click on the save button for new address in patient role")
	public void user_click_on_the_save_button_for_new_address_in_patient_role() throws Exception {
		// clicking on the submit
		driver.findElement(By.xpath("(//input[@class='btn right green btn-loader'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("it will redirect to the addresses page popup in patient role")
	public void it_will_redirect_to_the_addresses_page_popup_in_patient_role() {

	}

	@And("deleting the already existing address in patient role")
	public void deleting_the_already_existing_address_in_patient_role() throws Exception {
		if (driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[2]")).isDisplayed())
			;
		{
			driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='Confirm!']")).click();
			Thread.sleep(1000);
		}
	}

	@Then("updating the pincode for the new address in patient role")
	public void updating_the_pincode_for_the_new_address_in_patient_role() throws InterruptedException {
		if (driver.findElement(By.xpath("(//a[@class='address-btn '])[1]/i")).isDisplayed())
			;
		{
			driver.findElement(By.xpath("(//a[@class='address-btn '])[1]/i")).click();
			Thread.sleep(1000);
			// entering the pincode
			driver.findElement(By.id("address_detail_pin_code")).clear();
			driver.findElement(By.id("address_detail_pin_code")).sendKeys("500101");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		}
	}

	@And("clicking on the save button for new address in edit address page from patient role")
	public void clicking_on_the_save_button_for_new_address_in_edit_address_page_from_patient_role() throws Exception {
		// clicking on the submit
		driver.findElement(By.xpath("(//input[@class='btn right green btn-loader'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("closing the addresses popup in patient role")
	public void closing_the_addresses_popup_in_patient_role() throws Exception {
		try {
			driver.findElement(By.xpath(
					"/html/body/main/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[2]/div/div[1]/span/i"))
					.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Then("mouse-hovering to the existing contact home icon in patient role")
	public void mouse_hovering_to_the_existing_contact_home_icon_in_patient_role() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='row mobile_patient_info']/div[2]/a/img")))
				.build().perform();
		Thread.sleep(1000);

	}

	@And("clicking on the contact icon to add new contact")
	public void clicking_on_the_contact_icon_to_add_new_contact() throws Exception {
		driver.findElement(By.xpath("//div[@class='row mobile_patient_info']/div[2]/a/img")).click();
		Thread.sleep(1000);
	}

	@Then("click on the plus button to add new contact in patient role")
	public void click_on_the_plus_button_to_add_new_contact_in_patient_role() throws Exception {
		// plus
		driver.findElement(By.xpath("//a[@data-tooltip='Add New Contact']/i")).click();
		Thread.sleep(1000);
	}

	@And("enter the contact type for new contact")
	public void enter_the_contact_type_for_new_contact() {
		// type
		driver.findElement(By.xpath("//input[@name='contact_detail[phn_nmbr_typ]']")).sendKeys("Personal");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("select the country code for new contact")
	public void select_the_country_code_for_new_contact() {
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='+91']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("enter the following details in the new contact popup")
	public void enter_the_following_details_in_the_new_contact_popup(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> pat = dataTable.asLists(String.class);
		// number
		driver.findElement(By.id("contact_detail_nmbr")).sendKeys(pat.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// mail
		driver.findElement(By.id("contact_detail_email")).sendKeys(pat.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the save button from the new contact popup")
	public void click_on_the_save_button_from_the_new_contact_popup() throws Exception {
		// save
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(5000);
	}

	@And("updating the mobile number from the contact")
	public void updating_the_mobile_number_from_the_contact() throws InterruptedException {
		// clicking on the edit
		driver.findElement(By.cssSelector(
				"div#saved-contact>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>a:nth-of-type(1)>i"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.id("contact_detail_nmbr")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("contact_detail_nmbr")).sendKeys("9812312399");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("clicking on the save button for contact in edit contact page from patient role")
	public void clicking_on_the_save_button_for_contact_in_edit_contact_page_from_patient_role() throws Exception {
		// save
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(3000);
	}

	@And("close the contact popup in patient role")
	public void close_the_contact_popup_in_patient_role() throws Exception {
		WebElement close = driver.findElement(By
				.xpath("/html/body/main/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/span/i"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", close);
		Thread.sleep(2000);
	}

	@Then("click on the patient chat in the patient role")
	public void click_on_the_patient_chat_in_the_patient_role() throws Exception {
		// clicking on the img icon of care team
		driver.findElement(By.xpath("//div[@class='row mobile_patient_info']/div[4]/a/img")).click();
		Thread.sleep(3000);
	}

	@And("enter the message in the patient chat popup")
	public void enter_the_message_in_the_patient_chat_popup() {
		// entering the message
		driver.findElement(By.id("pubnub-update-text")).sendKeys("demo test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the send message icon to send chat")
	public void click_on_the_send_message_icon_to_send_chat() throws Exception {
		// clicking on the sending icon img
		driver.findElement(By.id("pubnub-publish-btn-div")).click();
		Thread.sleep(2000);
	}

	@And("close the patient chat popup")
	public void close_the_patient_chat_popup() throws Exception {
		// closing
		driver.findElement(By.id("patient-chat-modal-closeBtn")).click();
		Thread.sleep(3000);
	}

	@Then("mouse-hovering to the insurance icon in the patient role")
	public void mouse_hovering_to_the_insurance_icon_in_the_patient_role() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='row mobile_patient_info']/div[5]/a/img")))
				.build().perform();
		Thread.sleep(1000);
	}

	@And("click on the insurance icon in the patient role")
	public void click_on_the_insurance_icon_in_the_patient_role() throws Exception {
		// clicking on the insurance img icon
		driver.findElement(By.xpath("//div[@class='row mobile_patient_info']/div[5]/a/img")).click();
		Thread.sleep(2000);
	}

	@When("insurance popup opens from the patient role")
	public void insurance_popup_opens_from_the_patient_role() {

	}

	@And("click on the plus button to add new insurance")
	public void click_on_the_plus_button_to_add_new_insurance() throws Exception {
		// clicking on the plus
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New']/i)[2]")).click();
		Thread.sleep(2000);
	}

	@And("select the insurance radio button from the new insurer")
	public void select_the_insurance_radio_button_from_the_new_insurer() throws Exception {
		WebElement insurnace = driver.findElement(By.xpath("(//label[text()='Insurance'])[1]"));
		insurnace.click();
		Thread.sleep(2000);
	}

	@Then("enter the following in the insurance popup in patient role")
	public void enter_the_following_in_the_insurance_popup_in_patient_role(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> ins = dataTable.asLists(String.class);
		// insurance policy no
		driver.findElement(By.id("insurance_policy_detail_id_card")).sendKeys(ins.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// id card
		driver.findElement(By.id("insurance_policy_detail_policy_no")).sendKeys(ins.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("select the start and end date for insurance")
	public void select_the_start_and_end_date_for_insurance() throws Exception {
		// clicking on the policy start date
		driver.findElement(By.id("insurance_policy_detail_policy_start_date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		Thread.sleep(1000);
		// clicking on the policy end date
		driver.findElement(By.id("insurance_policy_detail_policy_end_date")).click();
		Thread.sleep(1000);
		// clicking on the year
		driver.findElement(By.xpath("(//div[@class='select-wrapper select-year'])[2]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li/span[text()='2025'])[2]")).click();
		Thread.sleep(1000);
		// 30
		driver.findElement(By.xpath("(//button[text()='1'])[2]")).click();
		Thread.sleep(2000);
//		// clicking on the dropdown
//		driver.findElement(By.xpath("//span[@class='selection']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Bajaj Allianz General Insurance Co Ltd'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@Then("click on save button to save the insurance in patient role")
	public void click_on_save_button_to_save_the_insurance_in_patient_role() throws Exception {
		// submit
		driver.findElement(By.cssSelector("input.btn.right.green.ins_submit")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@When("insurance is saved by clicking save button")
	public void insurance_is_saved_by_clicking_save_button() {

	}

	@Then("edit and update the added insurance in patient role")
	public void edit_and_update_the_added_insurance_in_patient_role() throws Exception {
		// clicking on the insurance img icon
		driver.findElement(By.xpath("//div[@class='row mobile_patient_info']/div[5]/a/img")).click();
		Thread.sleep(2000);
		// clicking on the edit
		driver.findElement(By.xpath("(//tbody[@id='insurance_details'])/tr[1]/td[7]/a[1]/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("insurance_policy_detail_policy_no")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("insurance_policy_detail_policy_no")).sendKeys("123456");
		Thread.sleep(1000);
	}

	@And("click on save button from edit insurance popup in patient role")
	public void click_on_save_button_from_edit_insurance_popup_in_patient_role() throws Exception {
		// submit
		driver.findElement(By.cssSelector("input.btn.right.green.ins_submit")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(1000);
	}

	@Then("adding another insurance")
	public void adding_another_insurance() throws Exception {
		// clicking on the insurance img icon
		driver.findElement(By.xpath("//div[@class='row mobile_patient_info']/div[5]/a/img")).click();
		Thread.sleep(2000);
		// clicking on the add button[plus]
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New'])[2]")).click();
		Thread.sleep(2000);
		WebElement insurnace = driver.findElement(By.xpath("(//label[text()='Insurance'])[1]"));
		insurnace.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#insurance_policy_detail_id_card:nth-of-type(1)")).sendKeys("143");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("input#insurance_policy_detail_policy_no:nth-of-type(1)")).sendKeys("12343");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.cssSelector("input.btn.right.green.ins_submit")).click();
		Thread.sleep(3000);
	}

	@Then("delete the existing insurance in the patient role")
	public void delete_the_existing_insurance_in_the_patient_role() throws Exception {
		driver.findElement(
				By.cssSelector("tbody#insurance_details>tr:nth-of-type(2)>td:nth-of-type(7)>a:nth-of-type(2)>i"))
				.click();
		Thread.sleep(2000);
		// confirm
		driver.findElement(By.xpath("//button[text()='Confirm!']")).click();
		Thread.sleep(2000);
	}

	@When("insurance is deleted in the patient role")
	public void insurance_is_deleted_in_the_patient_role() {
	}

	@Then("closing the popup of the insurance popup")
	public void closing_the_popup_of_the_insurance_popup() throws Exception {
		driver.findElement(By.cssSelector("div#modal_insurance_list>div>div:nth-of-type(1)>span>i")).click();
		Thread.sleep(2000);
	}

	@When("patient dashboard is opened from patient role to book doctor appointment")
	public void patient_dashboard_is_opened_from_patient_role_to_book_doctor_appointment() {
	}

	@Then("click on book doctor appointment from book appointment section")
	public void click_on_book_doctor_appointment_from_book_appointment_section() throws Exception {
		// clicking on the book doc apt.
		driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(1)>img")).click();
		Thread.sleep(2000);
	}

	@And("click on the book appointment button to book doctor appointment")
	public void click_on_the_book_appointment_button_to_book_doctor_appointment() throws Exception {
		// book appointment
		driver.findElement(By.xpath("(//a[text()='Book Appointment'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("select the type for booking doctor appointment")
	public void select_the_type_for_booking_doctor_appointment() throws Exception {
		// type - video
		driver.findElement(By.xpath("(//div[@class='icon'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("select the location to book doctor appointment")
	public void select_the_location_to_book_doctor_appointment() throws Exception {
		driver.findElement(By.xpath("(//div[@id='saved-addresses'])[2]/div[1]")).click();
		Thread.sleep(1000);

	}

	@Then("select the date and slot for doctor appointment")
	public void select_the_date_and_slot_for_doctor_appointment() throws Exception {
		// clicking on the tomorrow
		driver.findElement(By.xpath("(//div[@class='col s4 date tomorrow'])[1]")).click();
		Thread.sleep(1000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);

		if (driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[2]/div[2]/div[1]/div[1]"))
				.isDisplayed()) {
			// afternoon slot
			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[2]/div[2]/div[1]/div[1]")).click();
			Thread.sleep(2000);

		} else if (driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[3]/div[2]/div[1]/div[1]"))
				.isDisplayed()) {
			// evening slot
			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[3]/div[2]/div[1]/div[1]")).click();
			Thread.sleep(2000);

		} else {
			// night slot
			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[4]/div[2]/div/div/span[1]")).click();
			Thread.sleep(2000);
		}
	}

	@And("click on the add to cart button for doctor appointment")
	public void click_on_the_add_to_cart_button_for_doctor_appointment() throws Exception {
		// add to cart
		driver.findElement(By.id("bookNowBtn")).click();
		Thread.sleep(5000);
	}

	@When("add to cart is clicked it will open cart to summary page")
	public void add_to_cart_is_clicked_it_will_open_cart_to_summary_page() {
	}

	@Then("click on the submit button to book doctor appointment")
	public void click_on_the_submit_button_to_book_doctor_appointment() throws Exception {
		// submit button
		driver.findElement(By.xpath("//*[@id=\"order_package\"]/input[7]")).click();
		Thread.sleep(5000);
	}

	@When("submit is clicked then it will open the payment method page")
	public void submit_is_clicked_then_it_will_open_the_payment_method_page() {
	}

	@Then("navigate to patient dashboard from doctor apt payment method page1")
	public void navigate_to_patient_dashboard_from_doctor_apt_payment_method_page1() throws Exception {
		driver.navigate().to("https://customer.nanohealthplan.com/patient_dashboard?role=Patient");
		Thread.sleep(2000);
		driver.close();
	}

	@When("patient dashboard is opened from patient role to book vaccine appointment")
	public void patient_dashboard_is_opened_from_patient_role_to_book_vaccine_appointment() {
	}

	@Then("click on book vaccine appointment from book appointment section")
	public void click_on_book_vaccine_appointment_from_book_appointment_section() throws Exception {
		// clicking on the vaccine
		driver.findElement(By.xpath("//div[@class='bkng_services_prfl']/div/a[8]/img")).click();
		Thread.sleep(2000);
	}

	@And("click on the plus button to add vaccine to book appointment section")
	public void click_on_the_plus_button_to_add_vaccine_to_book_appointment_section() throws Exception {
		if (driver.findElement(By.xpath("(//i[text()='remove'])[2]")).isSelected()) {
			for (int i = 0; i <= 5; i++) {
				driver.findElement(By.xpath("(//i[text()='remove'])[2]")).click();
				Thread.sleep(1000);
			}
		} else {
			// add
			driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
			Thread.sleep(2000);
		}
		Thread.sleep(2000);

	}

	@Then("click on plus button to add another vaccine and remove it")
	public void click_on_plus_button_to_add_another_vaccine_and_remove_it() throws Exception {
		// add
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(1000);
		// removing last added vaccine
		driver.findElement(By.xpath("(//i[text()='remove'])[4]")).click();
		Thread.sleep(1000);
	}

	@And("click on checkout from cart summary to book vaccine appointment")
	public void click_on_checkout_from_cart_summary_to_book_vaccine_appointment() throws Exception {
		// checkout
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		Thread.sleep(1000);

	}

	@Then("Agree the consent text for booking vaccine appointment")
	public void agree_the_consent_text_for_booking_vaccine_appointment() throws Exception {
		// clicking on the agree
		driver.findElement(By.xpath("//button[text()='Agree']")).click();
		Thread.sleep(1000);
	}

	@And("select the type for booking vaccine appointment")
	public void select_the_type_for_booking_vaccine_appointment() throws Exception {
		// clicking on the clinic
		driver.findElement(By.xpath("(//div[@class='icon'])[2]")).click();
		Thread.sleep(2000);
	}

	@Then("select the location for booking vaccine appointment")
	public void select_the_location_for_booking_vaccine_appointment() throws Exception {
		// clicking on the address
		driver.findElement(By.xpath("//div[@class='address-container']/div/div/div")).click();
		Thread.sleep(2000);
	}

	@And("select the date and slot booking vaccine appointment")
	public void select_the_date_and_slot_booking_vaccine_appointment() throws Exception {
		// clicking on the tomorrow
		driver.findElement(By.xpath("//div[@class='col s4 date tomorrow']")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[1]/div[2]/div/div[1]"))
				.isDisplayed()) {
			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[1]/div[2]/div/div[1]")).click();
			Thread.sleep(1000);

		} else if (driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[2]/div[2]/div[1]/div[1]"))
				.isDisplayed()) {
			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[2]/div[2]/div[1]/div[1]")).click();
			Thread.sleep(1000);
		} else {
			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[3]/div[2]/div[1]/div[1]")).click();
			Thread.sleep(1000);
		}

	}

	@Then("select the healthcoach from dropdown to book vaccine")
	public void select_the_healthcoach_from_dropdown_to_book_vaccine() throws Exception {
		// clicking on the drop down
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='Sneha R']")).click();
		Thread.sleep(1000);
	}

	@And("click on continue button to book vaccine appointment")
	public void click_on_continue_button_to_book_vaccine_appointment() throws Exception {
		// clicking on the continue
		driver.findElement(By.xpath("(//div[@class='step-actions loc'])[3]/button")).click();
		Thread.sleep(1000);
	}

	@Then("click on add to cart button book vaccine appointment")
	public void click_on_add_to_cart_button_book_vaccine_appointment() throws Exception {
		driver.findElement(By.id("btn-loader")).click();
		Thread.sleep(1000);

	}

	@Then("click on the submit button to book vaccine appointment")
	public void click_on_the_submit_button_to_book_vaccine_appointment() throws Exception {
		// clicking on the submit
		driver.findElement(By.xpath("(//input[@name='commit'])[1]")).click();
		Thread.sleep(3000);

	}

	@When("submit is clicked then it will open the payment method page to book vaccine appointment")
	public void submit_is_clicked_then_it_will_open_the_payment_method_page_to_book_vaccine_appointment() {
	}

	@Then("navigate to patient dashboard from doctor apt payment method page2")
	public void navigate_to_patient_dashboard_from_doctor_apt_payment_method_page2() throws Exception {
		driver.navigate().to("https://customer.nanohealthplan.com/patient_dashboard?role=Patient");
		Thread.sleep(2000);
		driver.close();
	}

	@When("patient dashboard is opened from patient role to book program appointment")
	public void patient_dashboard_is_opened_from_patient_role_to_book_program_appointment() {
	}

	@Then("click on book program appointment from book appointment section")
	public void click_on_book_program_appointment_from_book_appointment_section() throws Exception {
		// program
		driver.findElement(By.xpath("//div[@class='bkng_services_prfl']/div/a[3]/img")).click();
		Thread.sleep(2000);

		if (!driver.findElement(By.cssSelector("a.btn-floating.waves-effect.red.btn-loader")).isDisplayed()) {
			for (int i = 0; i <= 0; i++) {
				driver.findElement(By.cssSelector("a.btn-floating.waves-effect.red.btn-loader")).click();
				Thread.sleep(1000);
			}
		} else {
			// clicking on the add
			driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
			Thread.sleep(1000);
		}
	}

	@And("click on the plus button to add program to book appointment section")
	public void click_on_the_plus_button_to_add_program_to_book_appointment_section() throws Exception {
		// clicking on the add
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("click on plus button again to add another program and remove it")
	public void click_on_plus_button_again_to_add_another_program_and_remove_it() throws Exception {
		// clicking on the add
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(1000);
		// removing
		driver.findElement(By.xpath("(//i[text()='remove'])[4]")).click();
		Thread.sleep(1000);
	}

	@And("click on the checkout button from cart summary to book program appointment")
	public void click_on_the_checkout_button_from_cart_summary_to_book_program_appointment() throws Exception {
		// checkout
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		Thread.sleep(1000);

	}

	@Then("select the referred by by searching to book program")
	public void select_the_referred_by_by_searching_to_book_program() throws Exception {
		// referred by
		driver.findElement(By.cssSelector("input.typeahead.tt-input")).sendKeys("self");
		Thread.sleep(1000);

	}

	@And("select the program start date to book program")
	public void select_the_program_start_date_to_book_program() throws Exception {
		// start date
		driver.findElement(By.cssSelector("input.pick-date.stdt")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@class='is-today']")).click();
		Thread.sleep(1000);
	}

	@When("start date is selected as today")
	public void start_date_is_selected_as_today() {
	}

	@Then("end date is automatically selected according to the program end date")
	public void end_date_is_automatically_selected_according_to_the_program_end_date() {
	}

	@When("end date is selected according to the program end date")
	public void end_date_is_selected_according_to_the_program_end_date() {
	}

	@And("click on the add to cart button to book program")
	public void click_on_the_add_to_cart_button_to_book_program() throws Exception {
		// add to cart
		driver.findElement(By.name("commit")).click();
		Thread.sleep(2000);

	}

	@When("add to cart button is clicked from activity list")
	public void add_to_cart_button_is_clicked_from_activity_list() {

	}

	@Then("it will redirect to the patient dashboard from program activity list page")
	public void it_will_redirect_to_the_patient_dashboard_from_program_activity_list_page()
			throws InterruptedException {
		driver.navigate().to("https://customer.nanohealthplan.com/patient_dashboard?role=Patient");
		Thread.sleep(2000);
		driver.close();
	}

	@When("patient dashboard is opened from patient role to book diagnostic appointment")
	public void patient_dashboard_is_opened_from_patient_role_to_book_diagnostic_appointment() {
	}

	@Then("click on book diagnostic appointment from book appointment section")
	public void click_on_book_diagnostic_appointment_from_book_appointment_section() throws Exception {
		// clicking on the book diagnostic apt.
		driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(2)>img")).click();
		Thread.sleep(10000);
//		// adding the test
//		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
//		Thread.sleep(3000);
//		// deleting the cart summary
//		driver.findElement(By.xpath("(//a[@data-tooltip='Clear Cart'])[1]/i")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
//		Thread.sleep(5000);
	}

	@Then("click on the plus button to add diagnostic to book appointment section")
	public void click_on_the_plus_button_to_add_diagnostic_to_book_appointment_section() throws Exception {
		// adding the test
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on plus button again to add another diagnostic and remove it")
	public void click_on_plus_button_again_to_add_another_diagnostic_and_remove_it() throws Exception {

		// adding the test
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(3000);

		// removing the added test
		driver.findElement(By.xpath("(//i[text()='remove'])[4]")).click();
		Thread.sleep(2000);
	}

	@And("click on the checkout button from cart summary to book diagnostic appointment")
	public void click_on_the_checkout_button_from_cart_summary_to_book_diagnostic_appointment() throws Exception {
		// clicking on the checkout
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		Thread.sleep(2000);

	}

	@Then("select the type to book diagnostic appointment")
	public void select_the_type_to_book_diagnostic_appointment() throws Exception {
		// clicking on the home
		driver.findElement(By.xpath("(//div[@class='icon'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("select the slot for booking diagnostic appointment")
	public void select_the_slot_for_booking_diagnostic_appointment() throws Exception {
		if (driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[3]/div[2]/div[1]/div[1]"))
				.isDisplayed()) {
			// afternoon slot
			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[3]/div[2]/div[1]/div[1]")).click();
			Thread.sleep(2000);

		} else if (driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[2]/div[2]/div[1]/div[1]"))
				.isDisplayed()) {
			// evening slot
			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[2]/div[2]/div[1]/div[1]")).click();
			Thread.sleep(2000);

		} else {
			// night slot
			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[4]/div[2]/div/div/span[1]")).click();
			Thread.sleep(2000);
		}
	}

	@Then("click on the add to cart button to book diagnostic appointment")
	public void click_on_the_add_to_cart_button_to_book_diagnostic_appointment() throws Exception {
		driver.findElement(By.id("btn-loader")).click();
		Thread.sleep(1000);
	}

	@Then("click on the submit button to book diagnostic appointment")
	public void click_on_the_submit_button_to_book_diagnostic_appointment() throws Exception {
		// clicking on the submit
		driver.findElement(By.xpath("(//input[@name='commit'])[1]")).click();
		Thread.sleep(5000);

	}

	@When("submit is clicked then it will open the payment method page to book diagnostic appointment")
	public void submit_is_clicked_then_it_will_open_the_payment_method_page_to_book_diagnostic_appointment() {

	}

	@Then("navigate to patient dashboard from doctor apt payment method page3")
	public void navigate_to_patient_dashboard_from_doctor_apt_payment_method_page3() throws Exception {
		driver.navigate().to("https://customer.nanohealthplan.com/patient_dashboard?role=Patient");
		Thread.sleep(2000);
		driver.close();
	}

	@And("mousehovering to the uploadreports to upload reports")
	public void mousehovering_to_the_uploadreports_to_upload_reports() throws Exception {
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Upload Reports'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@data-tooltip='Upload Doctor Visit']")).click();
		Thread.sleep(1000);
	}

	@Then("mousehovering and clicking on the upload doctor visit")
	public void mousehovering_and_clicking_on_the_upload_doctor_visit() {

	}

	@When("Doctor visit popup opens in patientrole")
	public void doctor_visit_popup_opens_in_patientrole() {

	}

	@Then("enter the doctor first and last name")
	public void enter_the_doctor_first_and_last_name() throws Exception {
		// doctor first name
		driver.findElement(By.id("doctor_visit_dummy2")).sendKeys("Nh");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// doctor last name
		driver.findElement(By.id("doctor_visit_referral_reason")).sendKeys("doctor");
		Thread.sleep(1000);
	}

	@And("select the hospital name from the dropdown")
	public void select_the_hospital_name_from_the_dropdown() throws Exception {
		// hospital name
		driver.findElement(By.id("doctor_visit_hospital_master_id")).sendKeys("Nh hospital");
		Thread.sleep(1000);
		driver.findElement(By.id("doctor_visit_hospital_master_id")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("doctor_visit_hospital_master_id")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@Then("upload the prescription for upload doctor visit")
	public void upload_the_prescription_for_upload_doctor_visit() throws Exception {
		// sending the pdf
		driver.findElement(By.id("doctor_visit_prescription_img"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\Prescriptionupload.pdf");
		Thread.sleep(1000);
	}

	@And("select the diagnosis by searching")
	public void select_the_diagnosis_by_searching() throws Exception {
		// diagnosis
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div[3]/div/div[2]/div/form/div[3]/div[2]/div[1]/span/input[2]"))
				.sendKeys("Bp");
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div[3]/div/div[2]/div/form/div[3]/div[2]/div[1]/span/input[2]"))
				.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div[3]/div/div[2]/div/form/div[3]/div[2]/div[1]/span/input[2]"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

	}

	@Then("enter the notes for uploading doctor visit")
	public void enter_the_notes_for_uploading_doctor_visit() throws Exception {
		// notes
		driver.findElement(By.id("doctor_visit_cmmts")).sendKeys("Doctor visit notes");
		Thread.sleep(1000);
	}

	@And("click on the submit to upload doctor visit")
	public void click_on_the_submit_to_upload_doctor_visit() throws Exception {
		// submit
		driver.findElement(By.cssSelector("input.modal-action.btn.green.right")).click();
		Thread.sleep(5000);
	}

	@When("doctor visit report is uploaded in patient role")
	public void doctor_visit_report_is_uploaded_in_patient_role() {

	}

	@Then("mousehovering and clicking on the upload dietician visit")
	public void mousehovering_and_clicking_on_the_upload_dietician_visit() throws Exception {
		// dietician
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Upload Reports'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);
		action2.moveToElement(driver.findElement(By.xpath("//a[@data-tooltip='Upload Dietitian Visit']"))).click()
				.build().perform();
		Thread.sleep(1000);
	}

	@When("Dietician visit popup opens in patientrole")
	public void dietician_visit_popup_opens_in_patientrole() {

	}

	@Then("select the dietician visit date by clicking on Dietician Visit Date")
	public void select_the_dietician_visit_date_by_clicking_on_dietician_visit_date() throws Exception {
		// dietitian visit date
		driver.findElement(By.id("patient_prescription_header_visit_date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//td[@class='is-today']/button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@And("enter the dietician first and last name")
	public void enter_the_dietician_first_and_last_name() throws Exception {
		// dietitan first name
		driver.findElement(By.id("patient_prescription_header_dummy2")).sendKeys("Vidhi");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// dietitian last name
		driver.findElement(By.id("patient_prescription_header_dummy1")).sendKeys("Desai");
		Thread.sleep(1000);
	}

	@Then("select the hospital name from the dropdown to upload dietician report")
	public void select_the_hospital_name_from_the_dropdown_to_upload_dietician_report() throws Exception {
		// hospitalname
		driver.findElement(By.id("patient_prescription_header_form_hospital_name")).sendKeys("Nh clinic");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("patient_prescription_header_form_hospital_name")).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		driver.findElement(By.id("patient_prescription_header_form_hospital_name")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@Then("upload the dietician visit report")
	public void upload_the_dietician_visit_report() throws Exception {
		// sending file
		driver.findElement(By.id("patient_prescription_header_prescription_img"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\Dietitianreportupload.pdf");
		Thread.sleep(3000);
	}

	@And("click on the submit to upload the dietician visit")
	public void click_on_the_submit_to_upload_the_dietician_visit() throws Exception {
		// submit
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[4]/div/div[2]/div/form/div[3]/span/input[1]"))
				.click();
		Thread.sleep(3000);
	}

	@When("dietician visit report is uploaded in patient role")
	public void dietician_visit_report_is_uploaded_in_patient_role() {

	}

	@Then("mousehovering and clicking on the upload labreport visit")
	public void mousehovering_and_clicking_on_the_upload_labreport_visit() throws Exception {
		// diagnostic lab reports
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Upload Reports'])[1]/img"))).build()
				.perform();
		Thread.sleep(3000);
		action1.moveToElement(driver.findElement(By.xpath("//a[@data-tooltip='Upload Lab Reports']"))).click().build()
				.perform();
		Thread.sleep(1000);
	}

	@When("Lab report popup opens in patientrole")
	public void Lab_report_popup_opens_in_patientrole() {

	}

	@Then("select the test date of the diagnostic")
	public void select_the_test_date_of_the_diagnostic() {
		// diagnostic visit date
		driver.findElement(By.id("patient_labresult_header_test_date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//td[@class='is-today']/button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("select the lab name to upload labreport")
	public void select_the_lab_name_to_upload_labreport() throws Exception {
		// lab name
		driver.findElement(By.id("patient_labresult_header_lab_name")).sendKeys("NH Lab");
		Thread.sleep(1000);
		driver.findElement(By.id("patient_labresult_header_lab_name")).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		driver.findElement(By.id("patient_labresult_header_lab_name")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@Then("upload the labreport to uploaddiagnosticreport")
	public void upload_the_labreport_to_uploaddiagnosticreport() throws Exception {
		driver.findElement(By.id("patient_labresult_header_lab_image"))
				.sendKeys("C:\\Users\\Lenovo\\Desktop\\Uploads\\Diagnosticreportupload.pdf");
		Thread.sleep(1000);
	}

	@Then("enter the notes of lab report")
	public void enter_the_notes_of_lab_report() throws Exception {
		// notes
		driver.findElement(By.id("patient_labresult_header_cmmts")).sendKeys("demo notes");
		Thread.sleep(1000);

	}

	@And("click on the submit to upload diagnostic report")
	public void click_on_the_submit_to_upload_diagnostic_report() throws Exception {
		// save
		driver.findElement(By.cssSelector("button.btn.green.btn-save.btn_submit")).click();
		Thread.sleep(5000);
	}

	@When("lab report is uploaded in patient role")
	public void lab_report_is_uploaded_in_patient_role() {

	}

	@Then("mosuehovering and click on upload discharge summary")
	public void mosuehovering_and_click_on_upload_discharge_summary() throws Exception {
		// discharge summary
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Upload Reports'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);
		action3.moveToElement(driver.findElement(By.xpath("//a[@data-tooltip='Upload Discharge Summary']"))).click()
				.build().perform();
		Thread.sleep(1000);
	}

	@When("upload discharge summary popup opened")
	public void upload_discharge_summary_popup_opened() {

	}

	@Then("select the date for upload discharge summary")
	public void select_the_date_for_upload_discharge_summary() throws Exception {
		// test date
		driver.findElement(By.id("in_patient_detail_operation_dt")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//td[@class='is-today']/button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@And("upload the discharge summary pdf")
	public void upload_the_discharge_summary_pdf() throws Exception {
		// sending pdf
		driver.findElement(By.id("in_patient_detail_summary_images"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\Dietitianreportupload.pdf");
		Thread.sleep(2000);
	}

	@Then("click on the submit button to upload dischargesummary")
	public void click_on_the_submit_button_to_upload_dischargesummary() throws Exception {
		// submit
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[6]/div/div[2]/div/form/div[2]/span/input[1]"))
				.click();
		Thread.sleep(5000);
	}

	@When("discharge summary is uploaded")
	public void discharge_summary_is_uploaded() {

	}

	@Then("clicking on the notes icon beside the upload reports icon")
	public void clicking_on_the_notes_icon_beside_the_upload_reports_icon() throws Exception {
		// clicking on the notes
		driver.findElement(By.xpath("//a[@data-tooltip='Notes']")).click();
		Thread.sleep(1000);
	}

	@And("entering the message to upload notes")
	public void entering_the_message_to_upload_notes() throws Exception {
		// entering the msg
		driver.findElement(By.id("message")).sendKeys("Test message");
		Thread.sleep(1000);
	}

	@Then("uploading the file in patient role")
	public void uploading_the_file_in_patient_role() throws Exception {
		// sending file
		driver.findElement(By.id("files_constr"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\Dietitianreportupload.pdf");
		Thread.sleep(1000);
	}

	@And("enabling the checkboxes to whom its viewable")
	public void enabling_the_checkboxes_to_whom_its_viewable() throws Exception {
		// check boxes
		for (int i = 0; i <= 2; i++) {
			WebElement doctor = driver.findElement(By.xpath("//label[text()='Doctor']"));
			doctor.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement dietitcian = driver.findElement(By.xpath("//label[text()='Dietitian']"));
			dietitcian.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement others = driver.findElement(By.xpath("//label[text()='Others']"));
			others.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
	}

	@Then("clicking on the save button to upload notes")
	public void clicking_on_the_save_button_to_upload_notes() throws Exception {
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement save = driver.findElement(By.xpath("//input[@value='Save']"));
		save.click();
		Thread.sleep(8000);
	}

	@And("close the notes popup in patient role")
	public void close_the_notes_popup_in_patient_role() throws Exception {
		// close
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[15]/div/div[1]/div/span/i")).click();
		Thread.sleep(3000);

	}

	@Then("clicking on the history button after page downing")
	public void clicking_on_the_history_button_after_page_downing() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		driver.close();
	}

	@And("Scrolling down to show the uploaded reports")
	public void Scrolling_down_to_show_the_uploaded_reports() throws Exception {
		// clicking on the my history
		driver.findElement(By.id("patientHistoryBtn")).click();
		Thread.sleep(3000);
		Robot robot1 = new Robot();
		for (int i = 0; i < 9; i++) {
			robot1.keyPress(KeyEvent.VK_DOWN);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Thread.sleep(5000);
		}
		driver.quit();
	}
}
