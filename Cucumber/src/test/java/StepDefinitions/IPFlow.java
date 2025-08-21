package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
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

public class IPFlow {
	WebDriver driver = null;

	@Given("naviagate to the NH_Web_portal application")
	public void naviagate_to_the_nh_web_portal_application() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver132.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@When("the nanohealth login page opens")
	public void the_nanohealth_login_page_opens() {
	}

	@Then("enter the emailormobile {string} password {string}")
	public void enter_the_emailormobile_password(String emailormobile, String password) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(emailormobile);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(password);
		Thread.sleep(2000);
	}

	@And("click on the sign in button to login into the nanohealth portal")
	public void click_on_the_sign_in_button_to_login_into_the_nanohealth_portal() throws Exception {
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
	}

	@When("select the profile when the popup opens")
	public void select_the_profile_when_the_popup_opens() {
	}

	@Then("select the role as CDPAdmin")
	public void select_the_role_as_CDPAdmin() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the cdp admin role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[7]/div/div/div/div[2]")).click();
		Thread.sleep(5000);
	}

	@When("CDPAdmin dashboard opens")
	public void CDPAdmin_dashboard_opens() {

	}

	@And("deleting the already existing patient in the CDPAdmin role")
	public void deleting_the_already_existing_patient_in_the_CDPAdmin_role() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.id("frst_nm")).sendKeys("Cucumdissummary");
		Thread.sleep(3000);
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
			// driver.findElement(By.id("admin-billing-tab")).click();
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
		Thread.sleep(5000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(1000);
		robot1.keyRelease(KeyEvent.VK_ADD);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		// clicking on the brand logo
		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(3000);

	}

	@Then("selecting the role as IP_Billing_Manager")
	public void selecting_the_role_as_IP_Billing_Manager() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the IP_Billing_Manager
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[13]/div/div/div/div[2]")).click();
		Thread.sleep(5000);
	}

	@Then("click on the add patient icon from the IP_Billing_Manager")
	public void click_on_the_add_patient_icon_from_the_IP_Billing_Manager() throws Exception {
		Thread.sleep(2000);
		// clicking on the add patient
		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("select title_of_ip_patient")
	public void select_title_of_ip_patient() throws Exception {
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

	@When("user enters the following details into registration form from the IP_Billing_Manager")
	public void user_enters_the_following_details_into_registration_form_from_the_IP_Billing_Manager(
			io.cucumber.datatable.DataTable dataTable) throws Exception {
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
		// addressline
		driver.findElement(By.id("address-line1")).sendKeys(regData.get(4).get(1));
		driver.findElement(By.id("autocomplete-input")).sendKeys(regData.get(5).get(1));
		driver.findElement(By.id("landmark")).sendKeys(regData.get(6).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// city
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).sendKeys(regData.get(7).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// district
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).sendKeys(regData.get(8).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// pincode
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys(regData.get(9).get(1));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
//		// aadharcardnumber
//		driver.findElement(By.xpath("/html/body/main/div/form/div[2]/div[1]/div/div[9]/div[2]/input"))
//				.sendKeys(regData.get(10).get(1));
	}

	@Then("selecting the radio_buttons in the registration form")
	public void selecting_the_radio_buttons_in_the_registration_form() throws Exception {
//		// abhacard
//		WebElement ac = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
//		ac.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys("767676");
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
		// insurance
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Insurance'])[1]")).click();
		Thread.sleep(1000);
		// policy no
		driver.findElement(By.cssSelector("input#policy_no:nth-of-type(1)")).sendKeys("12345");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// id card
		driver.findElement(By.cssSelector("input#id_card:nth-of-type(1)")).sendKeys("123");
		Thread.sleep(1000);
		// policy start date
		driver.findElement(By.cssSelector("input#policy_start_date:nth-of-type(1)")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Insurance Company'])[1]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Bajaj Allianz General Insurance Co Ltd'])[1]")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.cssSelector("span.cls2.btn.green.right.ins_submit")).click();
		Thread.sleep(2000);
		// demand program
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='NanoHealth Program1'])[1]")).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
	}

	@And("click on the submit_button_to_register from the IP_Billing_Manager")
	public void click_on_the_submit_button_to_register_from_the_IP_Billing_Manager() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// submit
		driver.findElement(By.id("update_submit")).click();
		Thread.sleep(5000);
	}

	@Then("it will open the patient profile from the IP_Billing_Manager")
	public void it_will_open_the_patient_profile_from_the_IP_Billing_Manager() {

	}

	@And("click on the advance button present in the right side")
	public void click_on_the_advance_button_present_in_the_right_side() throws Exception {
		// clicking on the advance
		driver.findElement(
				By.xpath("//div[@class='invoice_container patientLoadBalance']/a[contains(text(),'Advance: ')]"))
				.click();
		Thread.sleep(2000);
	}

	@When("advance is clicked load amount popup opens")
	public void advance_is_clicked_load_amount_popup_opens() {

	}

	@Then("enter the amount of the advance payment")
	public void enter_the_amount_of_the_advance_payment() throws Exception {
		// entering amount
		driver.findElement(By.cssSelector("input#load_amount")).sendKeys("50000");
		Thread.sleep(1000);
	}

	@And("select the payment method radio button after entering advance amount")
	public void select_the_payment_method_radio_button_after_entering_advance_amount() throws Exception {
		WebElement other = driver.findElement(By.xpath("//label[text()='Card']"));
		other.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering other transaction id
		driver.findElement(By.cssSelector("input#txn_id")).sendKeys("12345");
		Thread.sleep(1000);
	}

	@Then("click on the save button to save advance amount")
	public void click_on_the_save_button_to_save_advance_amount() throws Exception {
		// clicking on the save
//		driver.findElement(By.cssSelector("input#save")).click();
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#save")))).click();
		Thread.sleep(5000);
	}

	@When("save is clicked it will show the loaded amount in the advance field button")
	public void save_is_clicked_it_will_show_the_loaded_amount_in_the_advance_field_button() {

	}

	@Then("returning advance amount")
	public void returning_advance_amount() throws Exception {
		// clicking on the advance
		driver.findElement(
				By.xpath("//div[@class='invoice_container patientLoadBalance']/a[contains(text(),'Advance: ')]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='return_amnt'])[1]")).click();
		Thread.sleep(2000);
		// load return amount
		driver.findElement(By.cssSelector("input#load_amount")).sendKeys("10000");
		Thread.sleep(2000);
		WebElement other = driver.findElement(By.xpath("(//label[text()='Other'])[1]"));
		other.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Other adv payment type '])[1]/following-sibling::span[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='UPI'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#other_txn_id")).sendKeys("123456");
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@When("deleting the already existing family member")
	public void deleting_the_already_existing_family_member() throws Exception {
		// clicking on the brand logo
		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the Cdpadmin
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[8]/div/div/div/div[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("frst_nm")).sendKeys("Cucumfamilymember");
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
		Thread.sleep(5000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(1000);
		robot1.keyRelease(KeyEvent.VK_ADD);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
	}

	@And("click on the brandlogo and select the IpBillingManager role")
	public void click_on_the_brandlogo_and_select_the_IpBillingManager_role() throws Exception {
		try {
			driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img")).click();
			Thread.sleep(3000);

		} catch (Exception e) {
			// TODO: handle exception
		}
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on IpBillingManager
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[13]/div/div/div/div[2]")).click();
		Thread.sleep(5000);
	}

	@Then("search and open the patient that want to admit from IpBillingManager role")
	public void search_and_open_the_patient_that_want_to_admit_from_IpBillingManager_role() throws Exception {
		driver.findElement(By.id("frst_nm")).sendKeys("Cucumdissummary");
		Thread.sleep(5000);
		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);

	}

	@Then("click on the admission detail button under the bookappointments section")
	public void click_on_the_admission_detail_button_under_the_bookappointments_section() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Admission Form'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("click on the add family member icon from primary attendant field")
	public void click_on_the_add_family_member_icon_from_primary_attendant_field() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Family Member'])[1]")).click();
		Thread.sleep(2000);

	}

	@When("add family member popup opens enter the following details1")
	public void add_family_member_popup_opens_enter_the_following_details1(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> regData = dataTable.asLists(String.class);
		// firstname
		driver.findElement(By.cssSelector("input#first_name")).sendKeys(regData.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// lastname
		driver.findElement(By.cssSelector("input#lst_name")).sendKeys(regData.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("select the sex of the family member for the family member")
	public void select_the_sex_of_the_family_member_for_the_family_member() {
		WebElement f = driver.findElement(By.xpath("(//label[text()='F'])[1]"));
		f.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("add family member popup opens enter the following details2")
	public void add_family_member_popup_opens_enter_the_following_details2(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> regData = dataTable.asLists(String.class);
		// age
		driver.findElement(By.cssSelector("input#age")).sendKeys(regData.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// phone
		driver.findElement(By.cssSelector("input#nmbr")).sendKeys(regData.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("select the relation from the dropdown from the add family member")
	public void select_the_relation_from_the_dropdown_from_the_add_family_member() throws Exception {
		driver.findElement(By
				.xpath("/html/body/main/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div[4]/div[2]/span/span[1]/span"))
				.click();
		Thread.sleep(1000);
//		driver.switchTo().alert().accept();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Mother'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("click on the submit button to addfamily member")
	public void click_on_the_submit_button_to_addfamily_member() throws Exception {
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[2]/div/div[3]/form/div[6]/input[1]"))
				.click();
		Thread.sleep(10000);
	}

	@And("select the paymentmode as self radio button")
	public void select_the_paymentmode_as_self_radio_button() throws Exception {
		WebElement insurance = driver.findElement(By.xpath("(//label[text()='Insurance'])[1]"));
		insurance.click();
		Thread.sleep(1000);
		// selecting the payment detail
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@And("select the department from the dropdown")
	public void select_the_department_from_the_dropdown() {
		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='All'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("select the single from the roomtype dropdown")
	public void select_the_single_from_the_roomtype_dropdown() {
		driver.findElement(By.xpath("(//span[@class='selection'])[4]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Single Room'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("select the lead doctor from the dropdown")
	public void select_the_lead_doctor_from_the_dropdown() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Dr. NH Doctor'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(
				By.cssSelector("input#patient_master_patient_questnr_value_details_attributes_8_result_value"))
				.sendKeys("Test admission detail comments");
		Thread.sleep(1000);
	}

	@And("select the admission type radio button")
	public void select_the_admission_type_radio_button() {
		WebElement surgery = driver.findElement(By.xpath("(//label[text()='Surgery'])[1]"));
		surgery.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("select NH_IP Ward from the dropdown on clicking admission site")
	public void select_nh_ip_ward_from_the_dropdown_on_clicking_admission_site() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[8]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='NH_IP'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("click on the submit button")
	public void click_on_the_submit_button() throws Exception {
		driver.findElement(By.cssSelector("input#update_submit")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.cssSelector("li#clinic_patient_profile:nth-of-type(1)"));
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
		Thread.sleep(1000);
		String patid = element.getText();
		System.out.println("Patient registrationid: " + patid);
	}

	@Given("naviagate to the NH_Web_portal application2")
	public void naviagate_to_the_nh_web_portal_application2() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver131.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@When("the nanohealth login page opens2")
	public void the_nanohealth_login_page_opens2() {

	}

	@Then("enter the emailormobile1 {string} password1 {string}")
	public void enter_the_emailormobile1_password1(String emailormobile1, String password1) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(emailormobile1);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(password1);
		Thread.sleep(2000);
	}

	@And("click on the sign in button to login into the nanohealth portal2")
	public void click_on_the_sign_in_button_to_login_into_the_nanohealth_portal2() throws Exception {
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
	}

	@When("select the profile when the popup opens2")
	public void select_the_profile_when_the_popup_opens2() {
	}

	@Then("select the role as IpBillingManager2")
	public void select_the_role_as_ip_billing_manager2() throws Exception {
		// selecting Role clicking on IPBilling manager
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[8]/div/div/div/div[2]")).click();
		Thread.sleep(5000);
	}

	@And("mouse hover to the reports and click on the patients")
	public void mouse_hover_to_the_reports_and_click_on_the_patients() throws Exception {
		Thread.sleep(1000);
		Actions reports = new Actions(driver);
		reports.moveToElement(driver.findElement(By.cssSelector("a#admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		reports.moveToElement(driver.findElement(By.xpath("(//a[text()='Patients'])[1]"))).click().build().perform();
		Thread.sleep(10000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Patients'])[1]"))))
//				.click();
//		Thread.sleep(3000);
	}

	@When("patient is clicked it will show all the ip list")
	public void patient_is_clicked_it_will_show_all_the_ip_list() {
	}

	@Then("click on the patients name from the ip list")
	public void click_on_the_patients_name_from_the_ip_list() throws Exception {
		// Thread.sleep(2000);
		// clicking on the name
		driver.findElement(By.xpath("(//a[text()='Cucum Dissummary'])[1]")).click();
		Thread.sleep(5000);
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
		} else {
			Actions id1 = new Actions(driver);
			id1.moveToElement(driver.findElement(By.xpath("(//div[@class='invoice_container'])[3]/a[1]"))).build()
					.perform();
			Thread.sleep(1000);
		}

	}

	@When("patient status is updated then ipprocedures icon and assignroom icons will enabled")
	public void patient_status_is_updated_then_ipprocedures_icon_and_assignroom_icons_will_enabled() {
	}

	@And("a new invoice will be generated on the ip number invoice mouse hover on it and click on it")
	public void a_new_invoice_will_be_generated_on_the_ip_number_invoice_mouse_hover_on_it_and_click_on_it()
			throws Exception {
		Actions id1 = new Actions(driver);
		id1.moveToElement(driver.findElement(By.xpath("(//div[@class='invoice_container'])[3]/a[1]"))).build()
				.perform();
		Thread.sleep(1000);
		WebDriverWait id = new WebDriverWait(driver, Duration.ofSeconds(30));
		id.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//div[@class='invoice_container'])[3]/a[1]")))).click();
		Thread.sleep(3000);
		// mouse hover on to the add service
		Actions addservice = new Actions(driver);
		addservice.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add Service'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(1000);
		WebDriverWait addservice1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		addservice1
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add Service'])[1]/i[1]"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("adding one of the service from here and doing pay later")
	public void adding_one_of_the_service_from_here_and_doing_pay_later() throws Exception {
		// selecting the date
		driver.findElement(By.cssSelector("input#created_at")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// selecting site
		driver.findElement(By.xpath("(//label[text()='Site'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait nhip = new WebDriverWait(driver, Duration.ofSeconds(30));
		nhip.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='NanoHealth_IPD'])[1]"))))
				.click();
		Thread.sleep(5000);
		// searching and adding the ip procedure
		driver.findElement(By.cssSelector("input#invoice_search")).sendKeys("ip-");
		Thread.sleep(2000);
		// clicking on the plus button to add
		driver.findElement(By.xpath("(//a[@class='btn-floating green insert_row'])[2]/i[1]")).click();
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("input#invoice_search")).sendKeys("ip-");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@class='insert_row tooltipped'])[3]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='insert_row tooltipped'])[3]")).click();
		Thread.sleep(1000);
		// removing one
		driver.findElement(By.xpath("(//a[@class='remove_fields dynamic'])[2]/i[1]")).click();
		Thread.sleep(2000);
		// submit
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("(//input[@class='btn green right btn-loader sbmtBtn'])[1]")))).click();
//		 driver.findElement(By.xpath("(//input[@class='btn green right btn-loader sbmtBtn'])[1]")).click();
		Thread.sleep(5000);

//		Robot pgdwn = new Robot();
//		pgdwn.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		// paylater and submit
//		WebElement pyltr = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
//		pyltr.click();
//		Thread.sleep(1000);
//		WebDriverWait submit1 = new WebDriverWait(driver, Duration.ofSeconds(30));
//		submit1.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a#bookLater")))).click();
////		 driver.findElement(By.xpath("(//input[@class='btn green right btn-loader sbmtBtn'])[1]")).click();
//		Thread.sleep(5000);

	}

	@And("again clicking on the opening invoice id to add other services")
	public void again_clicking_on_the_opening_invoice_id_to_add_other_services() throws Exception {
		// mouse hover on to the add service
		Actions addservice = new Actions(driver);
		addservice.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add Service'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(1000);
		WebDriverWait addservice1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		addservice1
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add Service'])[1]/i[1]"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("add OT Charges service using opening invoice id")
	public void add_OT_Charges_service_using_opening_invoice_id() throws Exception {
		// selecting site
		WebDriverWait nhip = new WebDriverWait(driver, Duration.ofSeconds(30));
		nhip.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='NanoHealth_IPD'])[1]"))))
				.click();
		Thread.sleep(3000);
		// selecting service type
		driver.findElement(By.xpath("(//label[text()='Service Type'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait ot = new WebDriverWait(driver, Duration.ofSeconds(30));
		ot.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='OT'])[1]")))).click();
		Thread.sleep(1000);
		// selecting service
		driver.findElement(By.xpath("(//label[text()='Service'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait otcharges = new WebDriverWait(driver, Duration.ofSeconds(30));
		otcharges.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='OT Charges'])[1]"))))
				.click();
		Thread.sleep(1000);
		// selecting service detail
		driver.findElement(By.xpath("(//label[text()='Service Detail'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait minorotcharge = new WebDriverWait(driver, Duration.ofSeconds(30));
		minorotcharge.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Minor OT Charge'])[1]"))))
				.click();
		Thread.sleep(1000);
		// clicking add button
		WebDriverWait add = new WebDriverWait(driver, Duration.ofSeconds(30));
		add.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Add'])[1]")))).click();
		Thread.sleep(2000);
	}

	@And("add ER Charges service using opening invoice id")
	public void add_ER_Charges_service_using_opening_invoice_id() throws Exception {
		// selecting service type
		driver.findElement(By.xpath("(//label[text()='Service Type'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait er = new WebDriverWait(driver, Duration.ofSeconds(30));
		er.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='ER Charges'])[1]"))))
				.click();
		Thread.sleep(1000);
		// selecting service
		driver.findElement(By.xpath("(//label[text()='Service'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait er1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		er1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='ER'])[1]")))).click();
		Thread.sleep(1000);
		// selecting service detail
		driver.findElement(By.xpath("(//label[text()='Service Detail'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait emercharges = new WebDriverWait(driver, Duration.ofSeconds(30));
		emercharges.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Emergency Charges'])[1]"))))
				.click();
		Thread.sleep(1000);
		// clicking add button
		WebDriverWait add = new WebDriverWait(driver, Duration.ofSeconds(30));
		add.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Add'])[1]")))).click();
		Thread.sleep(2000);
	}

	@Then("sync the data and selecting previous dates")
	public void sync_the_data_and_selecting_previous_dates() throws Exception {
		Actions syncdata = new Actions(driver);
		syncdata.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Sync Data'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(1000);
		WebDriverWait syncdata2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		syncdata2
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Sync Data'])[1]/i[1]"))))
				.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(8000);
//		driver.findElement(By.cssSelector("input#created_at")).click();
//		List<WebElement> dates = driver.findElements(By.xpath("(//button[@class='datepicker-day-button'])"));
//		WebElement lastdate = dates.get(dates.size() - 1);
//		lastdate.click();
//		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#created_at")).click();
		LocalDate today = LocalDate.now();
		int previousWeekDay = today.minusDays(7).getDayOfMonth(); // Date one week ago
		System.out.println("Date to select (one week ago): " + previousWeekDay);

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

		System.out.println("Previous week's date selected successfully!");
		Thread.sleep(2000);
	}

	@And("add investigation lab service by searching the charge code")
	public void add_investigation_lab_service_by_searching_the_charge_code() throws Exception {
		WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		search.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#invoice_search"))))
				.sendKeys("1455");
		Thread.sleep(2000);
		WebDriverWait lab = new WebDriverWait(driver, Duration.ofSeconds(30));
		lab.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='1455'])[1]")))).click();
		Thread.sleep(2000);

	}

	@And("add minor procedure service by searching charge code")
	public void add_minor_procedure_service_by_searching_charge_code() throws Exception {
		WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		search.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#invoice_search"))))
				.sendKeys("1456");
		Thread.sleep(2000);
		WebDriverWait lab = new WebDriverWait(driver, Duration.ofSeconds(30));
		lab.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='1456'])[1]")))).click();
		Thread.sleep(2000);

	}

	@And("add radiology test using opening invoice id")
	public void add_radiology_test_using_opening_invoice_id() throws Exception {
		WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		search.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#invoice_search"))))
				.sendKeys("1457");
		Thread.sleep(2000);
		WebDriverWait lab = new WebDriverWait(driver, Duration.ofSeconds(30));
		lab.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='1457'])[1]")))).click();
		Thread.sleep(2000);
	}

	@And("add miscellaneous using opening invoice id")
	public void add_miscellaneous_using_opening_invoice_id() throws Exception {
		// selecting service type
		driver.findElement(By.xpath("(//label[text()='Service Type'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait misc = new WebDriverWait(driver, Duration.ofSeconds(30));
		misc.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Miscellaneous'])[1]"))))
				.click();
		Thread.sleep(1000);
		// selecting service
		driver.findElement(By.xpath("(//label[text()='Service'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait others = new WebDriverWait(driver, Duration.ofSeconds(30));
		others.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Others'])[1]"))))
				.click();
		Thread.sleep(1000);
		// selecting service detail
		driver.findElement(By.xpath("(//label[text()='Service Detail'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait patfoodcharges = new WebDriverWait(driver, Duration.ofSeconds(30));
		patfoodcharges
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("(//li[text()='Patient food charges'])[1]"))))
				.click();
		Thread.sleep(1000);
		// changing price
		driver.findElement(By.cssSelector("input#unit_cost")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#unit_cost")).sendKeys("1000");
		Thread.sleep(2000);
		// clicking add button
		WebDriverWait add = new WebDriverWait(driver, Duration.ofSeconds(30));
		add.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Add'])[1]")))).click();
		Thread.sleep(2000);

		// selecting service type
		driver.findElement(By.xpath("(//label[text()='Service Type'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait misc1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		misc1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Miscellaneous'])[1]"))))
				.click();
		Thread.sleep(1000);
		// selecting service
		driver.findElement(By.xpath("(//label[text()='Service'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait others1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		others1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Others'])[1]"))))
				.click();
		Thread.sleep(1000);
		// selecting service detail
		driver.findElement(By.xpath("(//label[text()='Service Detail'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait medicalcharges = new WebDriverWait(driver, Duration.ofSeconds(30));
		medicalcharges
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("(//li[text()='Bio Medical Waste Charges'])[1]"))))
				.click();
		Thread.sleep(2000);
		// clicking add button
		WebDriverWait add1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		add1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Add'])[1]")))).click();
		Thread.sleep(2000);
	}

	@And("add room_nursing charges using opening invoice id")
	public void add_room_nursing_charges_using_opening_invoice_id() throws Exception {
		// selecting service type
		driver.findElement(By.xpath("(//label[text()='Service Type'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait room = new WebDriverWait(driver, Duration.ofSeconds(30));
		room.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Room & Nursing'])[1]"))))
				.click();
		Thread.sleep(1000);
		// selecting service
		driver.findElement(By.xpath("(//label[text()='Service'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait nursing = new WebDriverWait(driver, Duration.ofSeconds(30));
		nursing.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Nursing'])[1]"))))
				.click();
		Thread.sleep(1000);
		// selecting service detail
		driver.findElement(By.xpath("(//label[text()='Service Detail'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		WebDriverWait nursecharges = new WebDriverWait(driver, Duration.ofSeconds(30));
		nursecharges.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Nursing Charges'])[1]"))))
				.click();
		Thread.sleep(2000);
		// clicking add button
		WebDriverWait add1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		add1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Add'])[1]")))).click();
		Thread.sleep(2000);
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the submit button
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.cssSelector("input.btn.green.right.btn-loader.sbmtBtn")))).click();
		Thread.sleep(3000);
	}

	@And("click on the patient name to open patients profile")
	public void click_on_the_patient_name_to_open_patients_profile() throws Exception {
		driver.findElement(By.xpath("(//li[@class='col s3 patient_card ip_card'])[1]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span/i[1]")).click();
		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("a#admin-billing-tab")).click();
//		Thread.sleep(2000);
	}

	@And("clicking on the IP Number in the patient profile")
	public void clicking_on_the_IP_Number_in_the_patient_profile() throws Exception {
		WebDriverWait ipnoclick = new WebDriverWait(driver, Duration.ofSeconds(30));
		ipnoclick
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("(//div[@class='invoice_container'])[2]/a[1]"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("clicking on the QR Code icon and Admission detail pdf icon")
	public void clicking_on_the_QR_Code_icon_and_Admission_detail_pdf_icon() throws Exception {
		// clicking on the qr code
		driver.findElement(By.cssSelector("div#ip_forms_modal>div>div:nth-of-type(1)>a>img")).click();
		Thread.sleep(5000);

		// WebDriverWait admdetailpdfclick = new WebDriverWait(driver,
		// Duration.ofSeconds(30));
		WebElement pdfclick = driver
				.findElement(By.xpath("(//a[contains(@href, 'pdf_reports/screening_form/')])/img[1]"));
		pdfclick.click();
		Thread.sleep(2000);

		// clicking on the registration pdf
		WebElement regpdf = driver
				.findElement(By.xpath("(//a[contains(@href, 'pdf_reports/screening_form/')])[2]/img[1]"));
		regpdf.click();
		Thread.sleep(3000);

	}

	@And("download the consent forms for ippatient")
	public void download_the_consent_forms_for_ippatient() throws Exception {
		// consent forms download
//		WebElement consentformpdfclick = driver
//				.findElement(By.xpath("(//a[contains(@href, '/patient/history_activity/')])/img[1]"));
//		consentformpdfclick.click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[contains(@href, '/patient/history_activity/')])[2]")).click();
//		Thread.sleep(2000);
//		WebElement consentformpdfclick2 = driver
//				.findElement(By.xpath("(//a[contains(@href, '/patient/history_activity/')])[3]/img[1]"));
//		consentformpdfclick2.click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[contains(@href, '/patient/history_activity/')])[4]")).click();
//		Thread.sleep(2000);
//		WebElement consentformpdfclick3 = driver
//				.findElement(By.xpath("(//a[contains(@href, '/patient/history_activity/')])[5]/img[1]"));
//		consentformpdfclick3.click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[contains(@href, '/patient/history_activity/')])[6]")).click();
//		Thread.sleep(2000);

		// Store the current window handle
		String parentWindow = driver.getWindowHandle();

		WebElement consentformpdfclick = driver
				.findElement(By.xpath("(//a[contains(@href, '/patient/history_activity/')])/img[1]"));
		consentformpdfclick.click();
		Thread.sleep(2000);

		// Switch to the new tab
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Close the new tab and switch back to the parent window
		driver.close();
		driver.switchTo().window(parentWindow);

		// Continue with the next actions
		driver.findElement(By.xpath("(//a[contains(@href, '/patient/history_activity/')])[2]")).click();
		Thread.sleep(2000);

		// Repeat the process for the remaining elements
		WebElement consentformpdfclick2 = driver
				.findElement(By.xpath("(//a[contains(@href, '/patient/history_activity/')])[3]/img[1]"));
		consentformpdfclick2.click();
		Thread.sleep(2000);

		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		driver.close();
		driver.switchTo().window(parentWindow);

		// Repeat for the next links
		driver.findElement(By.xpath("(//a[contains(@href, '/patient/history_activity/')])[4]")).click();
		Thread.sleep(2000);

		WebElement consentformpdfclick3 = driver
				.findElement(By.xpath("(//a[contains(@href, '/patient/history_activity/')])[5]/img[1]"));
		consentformpdfclick3.click();
		Thread.sleep(2000);

		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		driver.close();
		driver.switchTo().window(parentWindow);

		driver.findElement(By.xpath("(//a[contains(@href, '/patient/history_activity/')])[6]")).click();
		Thread.sleep(2000);
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		driver.close();
		driver.switchTo().window(parentWindow);
		Thread.sleep(1000);

	}

	@And("closing the ip forms popup")
	public void closing_the_ip_forms_popup() throws Exception {
		// closing popup
		driver.findElement(By.cssSelector("div#ip_forms_modal>div>div:nth-of-type(1)>span>i")).click();
		Thread.sleep(3000);

		// ip icon mouse hovering
		Actions ip = new Actions(driver);
		ip.moveToElement(driver.findElement(By.cssSelector("span.ip_card.ip_ico"))).build().perform();
		Thread.sleep(1000);

//		// mouse hovering on to the hospital assign room
//		Actions ar = new Actions(driver);
//		ar.moveToElement(driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(7)"))).build()
//				.perform();
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(7)")).click();
//		Thread.sleep(1000);
//		// closing popup
//		driver.findElement(By.xpath("(//div[@id='allottedBed'])[1]/div[1]/div[1]/span/i")).click();
//		Thread.sleep(2000);

//		WebDriverWait logo = new WebDriverWait(driver, Duration.ofSeconds(30));
//		logo.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img"))))
//				.click();
////		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img")).click();
//		// selecting ip ward profile
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[8]/div/div/div/div[2]")).click();
//		Thread.sleep(5000);
//
//		// clicking on the hospital beds
//		Actions hb = new Actions(driver);
//		hb.moveToElement(driver.findElement(By.cssSelector("a#admin-apmnts"))).build().perform();
//		Thread.sleep(1000);
//		WebDriverWait hb1 = new WebDriverWait(driver, Duration.ofSeconds(30));
//		hb1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@id='admin-rooms'])[1]")))).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//li[text()='NH_IP Ward'])[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//li[text()='Single Room'])[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// driver.findElement(By.xpath("(//li[text()='108'])[1]")).click();
//		Thread.sleep(1000);
//		// search
//		WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
//		search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
//				.click();
//		Thread.sleep(5000);
//		// bedview
//		WebDriverWait bedview = new WebDriverWait(driver, Duration.ofSeconds(30));
//		bedview.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Bed View'])[1]"))))
//				.click();
//		Thread.sleep(3000);
	}

	@Then("click on the ipprocedures icon under bookappointments section")
	public void click_on_the_ipprocedures_icon_under_bookappointments_section() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book IP Procedures'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book IP Procedures'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(3000);
	}

	@Then("select the procedures and removing one of the selected ip procedures")
	public void select_the_procedures_and_removing_one_of_the_selected_ip_procedures() throws Exception {
		// adding procedures
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//i[text()='add'])[4]")).click();
//		Thread.sleep(2000);
		// remove
		driver.findElement(By.xpath("(//i[text()='remove'])[2]")).click();
		Thread.sleep(2000);

	}

	@And("click on the checkout button from the selected ip procedures page")
	public void click_on_the_checkout_button_from_the_selected_ip_procedures_page() throws Exception {
		// checkout
		driver.findElement(By.xpath("//a[text()='Checkout'][1]")).click();
		Thread.sleep(2000);
	}

	@Then("select the discharge date and click on the continue button")
	public void select_the_discharge_date_and_click_on_the_continue_button() throws Exception {
		// discharge date
		driver.findElement(By.cssSelector("input#in_patient_detail_discharge_dt")).click();
		Thread.sleep(2000);
		// today
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
//		// clicking on the month
//		driver.findElement(By.xpath("(//div[@class='selects-container'])[1]/div[1]/input")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li/span[text()='May'])[2]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//td[@class='is-today'])[2]")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='discharge_time'])[2]")).click();
		Thread.sleep(1000);
		// 11
		driver.findElement(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[1]/div[2]/div[11]"))
				.click();
		Thread.sleep(1000);
		// 00mins
		driver.findElement(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[1]/div[3]/div[1]"))
				.click();
		Thread.sleep(1000);
		// pm
		driver.findElement(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]"))
				.click();
		Thread.sleep(1000);
		// ok
		driver.findElement(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[2]/div[1]/button[2]"))
				.click();
		Thread.sleep(1000);
		// continue
		driver.findElement(By.cssSelector("button#continue-btn")).click();
		Thread.sleep(3000);
	}

	@And("select the supporting doctor from the dropdown and click on continue button")
	public void select_the_supporting_doctor_from_the_dropdown_and_click_on_continue_button() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[11]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Dr. NH Doctor'])[1]")).click();
		Thread.sleep(1000);
		// continue
		driver.findElement(By.cssSelector("button#continue-team")).click();
		Thread.sleep(2000);
	}

	@Then("select the procedure start and end date from the procedure rooms popup")
	public void select_the_procedure_start_and_end_date_from_the_procedure_rooms_popup() throws Exception {
		// start time
		driver.findElement(By.cssSelector("input#start_time")).click();
		Thread.sleep(1000);
		// 10am
		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[7]/following-sibling::div[1]/div[10]"))
				.click();
		Thread.sleep(1000);
		// 00
		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[7]/following-sibling::div[2]/div[1]")).click();
		Thread.sleep(1000);
		// am
		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[7]/div[1]")).click();
		Thread.sleep(1000);
		// ok button
		driver.findElement(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[2]/div[1]/button[2]"))
				.click();
		Thread.sleep(1000);

		// end date
		driver.findElement(By.cssSelector("input#end_time")).click();
		Thread.sleep(1000);
		// 11
		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[8]/following-sibling::div[1]/div[11]"))
				.click();
		Thread.sleep(1000);
		// 00
		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[8]/following-sibling::div[2]/div[1]")).click();
		Thread.sleep(1000);
		// pm
		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[8]/div[2]")).click();
		Thread.sleep(1000);
		// ok button
		driver.findElement(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[2]/div[1]/button[2]"))
				.click();
		Thread.sleep(1000);

	}

	@And("selecting the procedure room no and table no")
	public void selecting_the_procedure_room_no_and_table_no() throws Exception {
		driver.findElement(By.xpath("(//label[text()='Procedure Room no.'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		Robot one = new Robot();
		one.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		one.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='01'])[1]")).click();
//		Thread.sleep(1000);
	}

	@When("procedure room is selected table no will automatically selected")
	public void procedure_room_is_selected_table_no_will_automatically_selected() {

	}

	@Then("click on the continue button from the procedure rooms page")
	public void click_on_the_continue_button_from_the_procedure_rooms_page() throws Exception {
		driver.findElement(By.cssSelector("button#continue-ot")).click();
		Thread.sleep(2000);
	}

	@And("click on the submit button from the review and save page")
	public void click_on_the_submit_button_from_the_review_and_save_page() throws Exception {
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(2000);
	}

//	@When("proforma invoice page is opened for cucum dissummary patient")
//	public void proforma_invoice_page_is_opened_for_cucum_dissummary_patient() {
//	}
//
//	@Then("click on plus button present at the top right")
//	public void click_on_plus_button_present_at_the_top_right() throws Exception {
//		WebDriverWait addservice = new WebDriverWait(driver, Duration.ofSeconds(30));
//		addservice.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a.btn-floating.red"))))
//				.click();
//		Thread.sleep(5000);
//	}
//
//	@When("add services popup opens")
//	public void add_services_popup_opens() {
//	}
//
//	@Then("selecting the date as today from the add services popup")
//	public void selecting_the_date_as_today_from_the_add_services_popup() throws Exception {
//		driver.findElement(By.cssSelector("input#created_at")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Site'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		// selecting site
//		WebDriverWait nhip = new WebDriverWait(driver, Duration.ofSeconds(30));
//		nhip.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='NH_IP'])[1]")))).click();
//		Thread.sleep(3000);
//	}
//
//	@Then("select the room&nursing service type from dropdown")
//	public void select_the_room_nursing_service_type_from_dropdown() throws Exception {
//		driver.findElement(By.xpath("(//label[text()='Service Type'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		WebDriverWait room = new WebDriverWait(driver, Duration.ofSeconds(30));
//		room.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Room & Nursing'])[1]"))))
//				.click();
//		Thread.sleep(3000);
//	}
//
//	@And("selecting the room from service dropdown")
//	public void selecting_the_room_from_service_dropdown() throws Exception {
//		driver.findElement(By.xpath("(//label[text()='Service'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		WebDriverWait room = new WebDriverWait(driver, Duration.ofSeconds(30));
//		room.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Room'])[1]")))).click();
//		Thread.sleep(3000);
//	}
//
//	@When("room is selected it will open a popup of admission details")
//	public void room_is_selected_it_will_open_a_popup_of_admission_details() {
//
//	}
//
////	@Then("select the admission date from the popup of admission details")
////	public void select_the_admission_date_from_the_popup_of_admission_details() throws Exception {
//////		driver.findElement(By.cssSelector("input#in_patient_detail_planned_admission_dt")).click();
//////		Thread.sleep(1000);
//////		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
//////		Thread.sleep(1000);
////	}
////
////	@And("click on the continue button from the popup of admission details")
////	public void click_on_the_continue_button_from_the_popup_of_admission_details() throws Exception {
//////		driver.findElement(By.cssSelector("button#continue-btn")).click();
//////		Thread.sleep(2000);
////	}
//
//	@And("select the single room from the room type")
//	public void select_the_single_room_from_the_room_type() throws Exception {
//		driver.findElement(By.xpath("(//label[text()='Room Type'])[2]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		WebDriverWait testroom = new WebDriverWait(driver, Duration.ofSeconds(30));
//		testroom.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Test room'])[1]"))))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Room Type'])[2]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		WebDriverWait singleroom = new WebDriverWait(driver, Duration.ofSeconds(30));
//		singleroom
//				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Single Room'])[1]"))))
//				.click();
//		Thread.sleep(1000);
//	}
//
//	@Then("select the room no from the room no drop down")
//	public void select_the_room_no_from_the_room_no_drop_down() throws Exception {
//		WebDriverWait room = new WebDriverWait(driver, Duration.ofSeconds(30));
//		room.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='101'])[1]")))).click();
//		Thread.sleep(2000);
////		Robot esc = new Robot();
////		esc.keyPress(KeyEvent.VK_ESCAPE);
////		Thread.sleep(2000);
//	}
//
//	@And("select the bed no from the drop down")
//	public void select_the_bed_no_from_the_drop_down() throws Exception {
////		driver.findElement(By.xpath("(//label[text()='Bed no.'])[1]/following-sibling::span[1]")).click();
////		Thread.sleep(1000);
////		WebDriverWait onethreeB = new WebDriverWait(driver, Duration.ofSeconds(30));
////		onethreeB.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='13B'])[1]"))))
////				.click();
////		Thread.sleep(2000);
//	}
//
//	@Then("click on the alloteddate and select today")
//	public void click_on_the_alloteddate_and_select_today() throws Exception {
//		WebDriverWait dateclick = new WebDriverWait(driver, Duration.ofSeconds(30));
//		dateclick
//				.until(ExpectedConditions
//						.visibilityOf(driver.findElement(By.cssSelector("input#in_patient_detail_admission_dt"))))
//				.click();
//		Thread.sleep(1000);
//		WebDriverWait todaydate = new WebDriverWait(driver, Duration.ofSeconds(30));
//		todaydate.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//td[@class='is-today'])[1]"))))
//				.click();
//		Thread.sleep(1000);
//	}
//
//	@When("today date is selected from the admission details")
//	public void today_date_is_selected_from_the_admission_details() {
//	}
//
//	@Then("click on the assign button from the admission details bed page")
//	public void click_on_the_assign_button_from_the_admission_details_bed_page() throws Exception {
//
////		driver.findElement(By.cssSelector("button#continue-room")).click();
////		Thread.sleep(2000);
//		// assign
//		WebDriverWait assign = new WebDriverWait(driver, Duration.ofSeconds(30));
//		assign.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Assign'])[1]"))))
//				.click();
//		Thread.sleep(3000);
//	}
//
//	@And("click on the submit button from the invoice page")
//	public void click_on_the_submit_button_from_the_invoice_page() throws Exception {
//		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
//		submit.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.cssSelector("input.btn.green.right.btn-loader.sbmtBtn")))).click();
//		Thread.sleep(2000);
//
//	}
//
//	@Then("click on the add service button again to add previous dates service")
//	public void click_on_the_add_service_button_again_to_add_previous_dates_service() {
//
//	}
//
////	@When("add service popup opens select previous date and service and then")
////	public void add_service_popup_opens_select_previous_date_and_service_and_then() throws Exception {
////		driver.findElement(By.cssSelector("input#created_at")).click();
////		Thread.sleep(2000);
////
////		List<WebElement> lastdate = driver.findElements(By.xpath("(//table[@class='datepicker-table'])[1]/tbody[1]"));
////		WebElement lastlabclick = lastdate.get(lastdate.size() - 1);
////		lastlabclick.click();
////		Thread.sleep(2000);
////	}
//
//	@Then("click on the submit again from the add services popup")
//	public void click_on_the_submit_again_from_the_add_services_popup() {
//
//	}

	@And("select the paylater option radio button to paylater for ippatient")
	public void select_the_paylater_option_radio_button_to_paylater_for_ippatient() throws Exception {
		for (int i = 0; i <= 3; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(2000);
		}
		Thread.sleep(1000);
		WebElement paylater = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
		paylater.click();
		Thread.sleep(1000);
	}

//	@When("redeem is clicked automatically bill amount will be entered")
//	public void redeem_is_clicked_automatically_bill_amount_will_be_entered() {
//
//	}

	@Then("click on the submit button from the proforma invoice page")
	public void click_on_the_submit_button_from_the_proforma_invoice_page() throws Exception {
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a#bookLater")))).click();
		Thread.sleep(3000);
	}

	@And("clicking on the print invoice to download poinvoice")
	public void clicking_on_the_print_invoice_to_download_poinvoice() throws Exception {
		// OP invoice pdf
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		for (int i = 0; i <= 3; i++) {
			Robot robot2 = new Robot();
			robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1000);
		}

	}

	@Then("click on the receipt id and total advance pdf icon and print button to download")
	public void click_on_the_receipt_id_and_total_advance_pdf_icon_and_print_button_to_download() throws Exception {
		// receipt download
		// driver.findElement(By.xpath("//div[@class='card'][1]/div/div[6]/div[2]/div[2]/a")).click();
		// Thread.sleep(1000);
		// pdf downloading
		// driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[3]/div[1]/strong/span/a/img")).click();
		// Thread.sleep(1000);
		// print pdf with details
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(2000);
		// print pdf without details
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf>i")).click();
		Thread.sleep(2000);
	}

	@And("click on the share invoice at the bottom of the invoice page")
	public void click_on_the_share_invoice_at_the_bottom_of_the_invoice_page() throws Exception {
		// share invoice
		WebDriverWait shareinvoice = new WebDriverWait(driver, Duration.ofSeconds(30));
		shareinvoice.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("remove and enter the mail id to share invoice")
	public void remove_and_enter_the_mail_id_to_share_invoice() throws Exception {
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
	}

	@And("click on the submit button to share invoice to mail")
	public void click_on_the_submit_button_to_share_invoice_to_mail() throws Exception {
		// submit
		WebElement sub = driver.findElement(By.xpath("/html/body/main/div/div[13]/div/div[2]/form/div[2]/input"));
		sub.click();
		Thread.sleep(20000);
	}

	@Then("clicking on the patients name in the IpBillingManager role")
	public void clicking_on_the_patients_name_in_the_ip_billing_manager_role() throws Exception {
//		Thread.sleep(1000);
//		// clicking on the name
//		driver.findElement(By.xpath("(//a[text()='Cucum Dissummary'])[1]")).click();
//		Thread.sleep(2000);
//		// close for pending amount
//		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
//			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
//			Thread.sleep(1000);
//			// driver.findElement(By.id("admin-billing-tab")).click();
//			// clicking on the billing
//			// driver.findElement(By.cssSelector("a#admin-billing-tab")).click();
//			// Thread.sleep(1000);
//		} else {
//			// clicking on the billing
//			// driver.findElement(By.cssSelector("a#admin-billing-tab")).click();
//			// Thread.sleep(1000);
//		}
	}

	@And("mouse hovering to the ip icon which is present beside patients name")
	public void mouse_hovering_to_the_ip_icon_which_is_present_beside_patients_name() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("span.ip_card.ip_ico"))).build().perform();
		Thread.sleep(1000);
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//span[@class='ip_card ip_ico'])[2]"))).build().perform();
		Thread.sleep(1000);
	}

	@Then("mouse hovering to the assign room icon under the book appointments section")
	public void mouse_hovering_to_the_assign_room_icon_under_the_book_appointments_section() throws Exception {
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(7)>img")))
//				.build().perform();
//		Thread.sleep(1000);
	}

	@Given("naviagating to the NH_Web_portal application")
	public void naviagating_to_the_nh_web_portal_application() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver128.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@When("the nanohealth login page opened")
	public void the_nanohealth_login_page_opened() {

	}

	@Then("enter the emailormobile2 {string} password2 {string}")
	public void enter_the_emailormobile2_password2(String emailormobile2, String password2) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(emailormobile2);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(password2);
		Thread.sleep(2000);
	}

	@And("click on sign_in_button to login into the nanohealth portal")
	public void click_on_sign_in_button_to_login_into_the_nanohealth_portal() throws Exception {
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
	}

	@Then("mouse hovering to the iplist module and selecting NH_IP Ward")
	public void mouse_hovering_to_the_iplist_module_and_selecting_nh_ip_ward() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("a#doctor-iplist"))).build().perform();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='NH_IP Ward'])[2]"))))
				.click();
//		driver.findElement(By.xpath("(//a[text()='NH_IP Ward'])[2]")).click();
		Thread.sleep(5000);
	}

	@And("ip patients from NH_IP Ward will be displayed")
	public void ip_patients_from_nh_ip_ward_will_be_displayed() {
	}

	@Then("clicking on the patients name to write the discharge summary")
	public void clicking_on_the_patients_name_to_write_the_discharge_summary() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Cucum Dissummary'])[1]"))))
				.click();

//		driver.findElement(By.xpath("(//a[text()='Cucum Dissummary'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the discharge summary button")
	public void click_on_the_discharge_summary_button() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Discharge Summary'])[1]"))))
				.click();
//		driver.findElement(By.xpath("(//a[text()='Discharge Summary'])[1]")).click();
		Thread.sleep(3000);
		// discharge date
		driver.findElement(By.xpath("(//label[text()='Discharge Date'])/following-sibling::input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='28'])[1]")).click();
		Thread.sleep(1000);
	}

	@When("discharge summary button is clicked it will open the discharge summary form")
	public void discharge_summary_button_is_clicked_it_will_open_the_discharge_summary_form() {
	}

	@Then("enter the provisional diagnosis at the time of admission")
	public void enter_the_provisional_diagnosis_at_the_time_of_admission() throws Exception {
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]")).sendKeys("test demo1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("click on the enter then bullet point will come")
	public void click_on_the_enter_then_bullet_point_will_come() throws Exception {
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("enter the provisional diagnosis again")
	public void enter_the_provisional_diagnosis_again() throws Exception {
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]")).sendKeys("test demo2");
		Thread.sleep(1000);
	}

	@And("click on the final diagnosis field")
	public void click_on_the_final_diagnosis_field() throws Exception {
		driver.findElement(By.cssSelector("input#doctor_visit_comorbidity")).click();
		Thread.sleep(1000);
	}

	@When("diagnosis suggestions will be shown1")
	public void diagnosis_suggestions_will_be_shown1() {

	}

	@Then("click on the enter button to select the first diagnosis from the suggestions")
	public void click_on_the_enter_button_to_select_the_first_diagnosis_from_the_suggestions() throws Exception {
		driver.findElement(By.id("doctor_visit_comorbidity")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@And("enter the duration of the finaldiagnosis1")
	public void enter_the_duration_of_the_finaldiagnosis1() throws Exception {
		// duration
		driver.findElement(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[1]")).sendKeys("2");
		Thread.sleep(1000);
	}

	@Then("clicking on the notes icon for finaldiagnosis1")
	public void clicking_on_the_notes_icon_for_finaldiagnosis1() {
		// clicking on the notes
		driver.findElement(By.xpath("(//i[text()='arrow_drop_down_circle'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("enter the notes for final diagnosis1")
	public void enter_the_notes_for_final_diagnosis1() throws Exception {
		// entering the notes
		driver.findElement(By.xpath("(//input[@name='doctor_visit[comorbidity][][note]'])[1]")).sendKeys("test1");
		Thread.sleep(1000);

	}

	@Then("click on the notes icon again to close for final diagnosis1")
	public void click_on_the_notes_icon_again_to_close_for_final_diagnosis1() throws Exception {
		// clicking on the notes again to close
		driver.findElement(By.xpath("(//i[text()='arrow_drop_down_circle'])[1]")).click();
		Thread.sleep(2000);
	}

	@When("diagnosis suggestions will be shown2")
	public void diagnosis_suggestions_will_be_shown2() {
	}

	@Then("click on the right and left keys and click on the enter button to select the final diagnosis2")
	public void click_on_the_right_and_left_keys_and_click_on_the_enter_button_to_select_the_final_diagnosis2()
			throws Exception {
		driver.findElement(By.id("doctor_visit_comorbidity")).click();
		Thread.sleep(2000);
		// Robot robot = new Robot();
		for (int i = 0; i <= 2; i++) {
			driver.findElement(By.id("doctor_visit_comorbidity")).sendKeys(Keys.RIGHT);
			Thread.sleep(1000);
		}
		for (int i = 0; i <= 2; i++) {
			driver.findElement(By.id("doctor_visit_comorbidity")).sendKeys(Keys.LEFT);
			Thread.sleep(1000);
		}
		driver.findElement(By.id("doctor_visit_comorbidity")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@And("enter the duration of the finaldiagnosis2")
	public void enter_the_duration_of_the_finaldiagnosis2() throws Exception {
		// duration
		driver.findElement(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[2]")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// clicking on the dropdown
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// years
		driver.findElement(By.xpath("//li[text()='Years']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("clicking on the notes icon for finaldiagnosis2")
	public void clicking_on_the_notes_icon_for_finaldiagnosis2() {
		// clicking on the notes
		driver.findElement(By.xpath("(//i[text()='arrow_drop_down_circle'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("enter the notes for final diagnosis2")
	public void enter_the_notes_for_final_diagnosis2() {
		// entering the notes
		driver.findElement(By.xpath("(//input[@name='doctor_visit[comorbidity][][note]'])[2]")).sendKeys("test2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the notes icon again to close for final diagnosis2")
	public void click_on_the_notes_icon_again_to_close_for_final_diagnosis2() {
		// clicking on the notes again to close
		driver.findElement(By.xpath("(//i[text()='arrow_drop_down_circle'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("clicking on the final diagnosis to add final diagnosis3")
	public void clicking_on_the_final_diagnosis_to_add_final_diagnosis3() throws Exception {
		driver.findElement(By.cssSelector("input#doctor_visit_comorbidity")).click();
		Thread.sleep(1000);
	}

	@Then("enter the oral and then clicking on the enter button")
	public void enter_the_oral_and_then_suggestions_will_be_shown() {
		driver.findElement(By.id("doctor_visit_comorbidity")).sendKeys("oral");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("doctor_visit_comorbidity")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("enter the duration of the finaldiagnosis3")
	public void enter_the_duration_of_the_finaldiagnosis3() throws Exception {
		// duration
		driver.findElement(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[3]")).sendKeys("2");
		Thread.sleep(1000);
	}

	@Then("removing the last added final diagnosis3")
	public void removing_the_last_added_final_diagnosis3() throws Exception {
		// removing last added comorbidity
		driver.findElement(By.xpath("(//div[@class='input_close_cmrb'])[3]/i")).click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
	}

	@And("click on the patient history and enter the history")
	public void click_on_the_patient_history_and_enter_the_history() throws Exception {
		// entering the pat.his.
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys("demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the enter to add the patienthistory2")
	public void click_on_the_enter_to_add_the_patienthistory2() {
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("enter clicked bullet point will be created in patienthistory field")
	public void enter_clicked_bullet_point_will_be_created_in_patienthistory_field() {
	}

	@Then("enter another line of patienthistory2")
	public void enter_another_line_of_patienthistory2() {
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys("demo1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("click on the enter to add the patienthistory3")
	public void click_on_the_enter_to_add_the_patienthistory3() {
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("enter another line of patienthistory3")
	public void enter_another_line_of_patienthistory3() {
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys("demo2");
	}

	@And("clicking on the up key to see the upper history data")
	public void clicking_on_the_up_key_to_see_the_upper_history_data() throws Exception {
		Robot robot = new Robot();
		for (int i = 0; i <= 2; i++) {
			robot.keyPress(KeyEvent.VK_UP);
			Thread.sleep(1000);
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

	}

	@Then("reducing the screensize1 in dischargesummary")
	public void reducing_the_screensize1_in_dischargesummary() throws Exception {
//		Robot robot = new Robot();
//		for (int i = 0; i <= 2; i++) {
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_SUBTRACT);
//			robot.keyRelease(KeyEvent.VK_SUBTRACT);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//		}
//		Thread.sleep(1000);
	}

	@And("clicking on the reason for admission_symptoms_clinicalfindings and clicking enter button")
	public void clicking_on_the_reason_for_admission_symptoms_clinicalfindings_and_clicking_enter_button()
			throws Exception {
		// adding reason
		driver.findElement(By.id("doctor_visit_complaints")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("doctor_visit_complaints")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("selecting the duration from the dropdown for admissionreason1")
	public void selecting_the_duration_from_the_dropdown_for_admissionreason1() throws Exception {
		// duration
		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[1]")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// dropdwon
		Robot tab = new Robot();
		tab.keyPress(KeyEvent.VK_TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// years
		driver.findElement(By.xpath("//li[text()='Years']")).click();
		Thread.sleep(1000);
	}

	@And("click on the admission_symptoms_clinicalfindings to add admissionreason2")
	public void click_on_the_admission_symptoms_clinicalfindings_to_add_admissionreason2() throws Exception {
		driver.findElement(By.id("doctor_visit_complaints")).click();
		Thread.sleep(2000);
	}

	@Then("click on the right and left keys and click on the enter button to select the admissionreason2")
	public void click_on_the_right_and_left_keys_and_click_on_the_enter_button_to_select_the_admissionreason2()
			throws Exception {
		Robot robot = new Robot();
		for (int i = 0; i <= 2; i++) {
			robot.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}
		for (int i = 0; i <= 2; i++) {
			robot.keyPress(KeyEvent.VK_LEFT);
			Thread.sleep(1000);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@And("selecting the duration from the dropdown for admissionreason2")
	public void selecting_the_duration_from_the_dropdown_for_admissionreason2() throws Exception {
		// duration
		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[2]")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// dropdwon
		Robot tab = new Robot();
		tab.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		// years
		driver.findElement(By.xpath("//li[text()='Years']")).click();
		Thread.sleep(2000);
	}

	@Then("selecting the admissionreason3 by searching in the field")
	public void selecting_the_admissionreason3_by_searching_in_the_field() {
		// adding reason
		driver.findElement(By.id("doctor_visit_complaints")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("doctor_visit_complaints")).sendKeys("pain");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("doctor_visit_complaints")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("entering the duration for admissionreason3")
	public void entering_the_duration_for_admissionreason3() throws Exception {
		// duration
		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[3]")).sendKeys("200");
		Thread.sleep(1000);
	}

	@Then("removing the last added admissionreason3")
	public void removing_the_last_added_admissionreason3() throws Exception {
		// removing last one
		driver.findElement(By.xpath("(//div[@id='input_close_cmpl'])[3]/i")).click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("entering the hospital course in dischargesummary")
	public void entering_the_hospital_course_in_dischargesummary() throws Exception {
		// procedure at hospital/treatment
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[3]")).sendKeys("test course");
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("reducing the screensize2 in dischargesummary")
	public void reducing_the_screensize2_in_dischargesummary() throws Exception {
		// Thread.sleep(1000);
//		Robot robot = new Robot();
//		for (int i = 0; i <= 0; i++) {
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_SUBTRACT);
//			Thread.sleep(1000);
//			robot.keyRelease(KeyEvent.VK_SUBTRACT);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			Thread.sleep(1000);
//		}
	}

	@And("click on the plus button to add medication1 given during hospitalization")
	public void click_on_the_plus_button_to_add_medication1_given_during_hospitalization() throws Exception {
//		driver.findElement(By.xpath(
//				"//a[@id='discharge_add_past_medication_btn']//i[@class='material-icons'][normalize-space()='add']"))
//				.click();
//		Thread.sleep(1000);
	}

	@When("plus button is clicked then it will add a new row")
	public void plus_button_is_clicked_then_it_will_add_a_new_row() {
	}

	@And("click on the medicine field for adding medication1 given during hospitalization")
	public void click_on_the_medicine_field_for_adding_medication1_given_during_hospitalization() throws Exception {
//		driver.findElement(By
//				.cssSelector("div#patient_past_prescription_lines>div>div>div:nth-of-type(2)>div>input:nth-of-type(1)"))
//				.click();
//		Thread.sleep(1000);
	}

	@Then("select the medication1 given during hospitalization1")
	public void select_the_medication1_given_during_hospitalization1() throws Exception {
//		// mouse-hovering on the medicine to show the salt name of the brand
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//div[@class='medicines_suggestion'])[1]/div/ul/li[1]")))
//				.build().perform();
//		Thread.sleep(1000);
//		// selecting the first medicine
//		driver.findElement(By.xpath("(//div[@class='medicines_suggestion'])[1]/div/ul/li[1]")).click();
//		Thread.sleep(1000);
//		// clicking on the notes
//		driver.findElement(By.xpath("(//a[@class='show_note'])[1]/img[1]")).click();
//		Thread.sleep(1000);
//		// clicking on the notes again to close
//		driver.findElement(By.xpath("(//a[@class='show_note'])[1]/img[2]")).click();
//		Thread.sleep(1000);

	}

	@And("click on the plus button to add medication2 and click on the medicine field to select medicine")
	public void click_on_the_plus_button_to_add_medication2_and_click_on_the_medicine_field_to_select_medicine()
			throws Exception {
//		driver.findElement(By.xpath(
//				"//a[@id='discharge_add_past_medication_btn']//i[@class='material-icons'][normalize-space()='add']"))
//				.click();
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector(
//				"div#patient_past_prescription_lines>div:nth-of-type(2)>div>div:nth-of-type(2)>div>input:nth-of-type(1)"))
//				.click();
//		Thread.sleep(1000);
	}

	@And("select the medication2 given during hospitalization2")
	public void select_the_medication2_given_during_hospitalization2() throws Exception {
//		// selecting the second medicine
//		driver.findElement(By.xpath("(//div[@class='medicines_suggestion'])[2]/div/ul/li[2]")).click();
//		Thread.sleep(1000);
	}

	@Then("remove the recent added medication given during hospitalization2")
	public void remove_the_recent_added_medication_given_during_hospitalization2() throws Exception {
//		driver.findElement(
//				By.cssSelector("div#patient_past_prescription_lines>div:nth-of-type(2)>div>div:nth-of-type(10)>a>i"))
//				.click();
//		Thread.sleep(1000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
	}

	@And("enter the condition on discharge1 in discharge summary")
	public void enter_the_condition_on_discharge1_in_discharge_summary() throws Exception {
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[5]")).sendKeys("test condition1");
		Thread.sleep(1000);
	}

	@Then("click on the enter button from the condition on discharge")
	public void click_on_the_enter_button_from_the_condition_on_discharge() throws Exception {
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[5]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@When("enter button is clicked it will show bullet point for next line")
	public void enter_button_is_clicked_it_will_show_bullet_point_for_next_line() {
	}

	@Then("enter the condition on discharge2 in discharge summary")
	public void enter_the_condition_on_discharge2_in_discharge_summary() throws Exception {
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[5]")).sendKeys("test condition2");
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		Robot robot = new Robot();
//		for (int i = 0; i <= 2; i++) {
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_ADD);
//			robot.keyRelease(KeyEvent.VK_ADD);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//		}
//		Thread.sleep(1000);

	}

	@When("enter the following details into the vitals field")
	public void enter_the_following_details_into_the_vitals_field(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> vitals = dataTable.asLists(String.class);
		// height
		driver.findElement(By.xpath("(//label[text()='Height(Cms)'])/following-sibling::input"))
				.sendKeys(vitals.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='bp-s']")).sendKeys(vitals.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='bp-d']")).sendKeys(vitals.get(2).get(1));

	}

	@And("enter the advice on discharge in discharge summary")
	public void enter_the_advice_on_discharge_in_discharge_summary() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[6]")).sendKeys("test advice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on the enter button to add new line")
	public void click_on_the_enter_button_to_add_new_line() {
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[6]")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("enter the advice2 in the new line")
	public void enter_the_advice2_in_the_new_line() throws Exception {
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[6]")).sendKeys("test advice1");
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
	}

	@Then("click on the medicine field in the discharge medication1")
	public void click_on_the_medicine_field_in_the_discharge_medication1() throws Exception {
		driver.findElement(By
				.xpath("//input[@id='patient_prescription_header_patient_prescription_lines_attributes_0_brand_name']"))
				.click();
		Thread.sleep(1000);
	}

	@When("medication field is clicked it will show the suggestions of the avaible medicines")
	public void medication_field_is_clicked_it_will_show_the_suggestions_of_the_avaible_medicines() {
	}

	@Then("mousehover on the medicine name and selecting the medicine1")
	public void mousehover_on_the_medicine_name_and_selecting_the_medicine1() throws Exception {
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(
//				By.cssSelector("div.medicines_suggestion>div>ul>li:nth-of-type(1)>div>div:nth-of-type(2)>a"))).build()
//				.perform();
//		Thread.sleep(1000);
		driver.findElement(By
				.xpath("//input[@id='patient_prescription_header_patient_prescription_lines_attributes_0_brand_name']"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

	}

	@And("click on the notes icons and close for medicine1")
	public void click_on_the_notes_icons_and_close_for_medicine1() throws Exception {
		// opening notes
		driver.findElement(By.cssSelector(
				"div#patient_prescription_lines>div:nth-of-type(1)>div>div:nth-of-type(10)>a>img:nth-of-type(1)"))
				.click();
		Thread.sleep(1000);
		// closing notes
		driver.findElement(By.cssSelector(
				"div#patient_prescription_lines>div:nth-of-type(1)>div>div:nth-of-type(10)>a>img:nth-of-type(2)"))
				.click();
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);
	}

	@Then("click on the medicine field in the discharge medication2")
	public void click_on_the_medicine_field_in_the_discharge_medication2() throws Exception {
		driver.findElement(By.xpath(
				"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[23]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/input[1]"))
				.click();
		Thread.sleep(1000);
	}

	@And("using right and left keys select the medicine2 by clicking enter button")
	public void using_right_and_left_keys_select_the_medicine2_by_clicking_enter_button() throws Exception {
		for (int i = 0; i <= 2; i++) {
			driver.findElement(By.xpath(
					"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[23]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/input[1]"))
					.sendKeys(Keys.RIGHT);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		for (int i = 0; i <= 2; i++) {
			driver.findElement(By.xpath(
					"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[23]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/input[1]"))
					.sendKeys(Keys.LEFT);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.findElement(By.xpath(
				"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[23]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/input[1]"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("click on the notes icons and close for medicine2")
	public void click_on_the_notes_icons_and_close_for_medicine2() throws Exception {
		// opening notes
		driver.findElement(By.cssSelector(
				"div#patient_prescription_lines>div:nth-of-type(2)>div>div:nth-of-type(10)>a>img:nth-of-type(1)"))
				.click();
		Thread.sleep(1000);
		// closing notes
		driver.findElement(By.cssSelector(
				"div#patient_prescription_lines>div:nth-of-type(2)>div>div:nth-of-type(10)>a>img:nth-of-type(2)"))
				.click();
		Thread.sleep(1000);
	}

	@And("click on the medicine field in the discharge medication3")
	public void click_on_the_medicine_field_in_the_discharge_medication3() throws Exception {
//		driver.findElement(By.xpath(
//				"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[23]/div/div[2]/div/div[1]/div[6]/div/div[2]/div/input[1]"))
//				.click();
//		Thread.sleep(1000);
	}

	@Then("click on the enter button to select the medicine")
	public void click_on_the_enter_button_to_select_the_medicine() throws Exception {
//		driver.findElement(By.xpath(
//				"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[23]/div/div[2]/div/div[1]/div[6]/div/div[2]/div/input[1]"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
	}

	@When("enter button is clicked medicine will be selected")
	public void enter_button_is_clicked_medicine_will_be_selected() {
	}

	@Then("remove one of the medicine from the discharge medication")
	public void remove_one_of_the_medicine_from_the_discharge_medication() throws Exception {
		driver.findElement(
				By.cssSelector("div#patient_prescription_lines>div:nth-of-type(3)>div>div:nth-of-type(11)>a>i"))
				.click();
		Thread.sleep(1000);
		driver.findElement(
				By.cssSelector("div#patient_prescription_lines>div:nth-of-type(2)>div>div:nth-of-type(11)>a>i"))
				.click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
	}

	@And("clicking on the labs field in discharge summary")
	public void clicking_on_the_labs_field_in_discharge_summary() throws Exception {
		driver.findElement(By.cssSelector("input#recommended_lab_input_helper")).click();
		Thread.sleep(1000);
	}

	@When("field is clicked then labs suggestions will show")
	public void field_is_clicked_then_labs_suggestions_will_show() {
	}

	@Then("click on the enter button to select the lab")
	public void click_on_the_enter_button_to_select_the_lab() throws Exception {
		driver.findElement(By.cssSelector("input#recommended_lab_input_helper")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@And("search and select the lab in discharge summary")
	public void search_and_select_the_lab_in_discharge_summary() throws Exception {
		driver.findElement(By.cssSelector("input#recommended_lab_input_helper")).sendKeys("Ecg");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#recommended_lab_input_helper")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@Then("select the another lab clicking enter button")
	public void select_the_another_lab_clicking_enter_button() throws Exception {
		driver.findElement(By.cssSelector("input#recommended_lab_input_helper")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@And("remove one of the selected lab in discharge summary")
	public void remove_one_of_the_selected_lab_in_discharge_summary() throws Exception {
		driver.findElement(By.cssSelector("div#recommended_lab_custom_chips>div:nth-of-type(3)>i")).click();
		Thread.sleep(1000);
	}

	@Then("enter the free text test for lab and click on ok button")
	public void enter_the_free_text_test_for_lab_and_click_on_ok_button() throws Exception {
		driver.findElement(By.cssSelector("input#recommended_lab_input_helper"))
				.sendKeys("freetextforlabindischargesummary");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#recommended_lab_input_helper")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@Then("click on the request button in discharge summary")
	public void click_on_the_request_button_in_discharge_summary() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Request'])[1]")).click();
		Thread.sleep(2000);
	}

	@When("request button is clicked then popup will be opened")
	public void request_button_is_clicked_then_popup_will_be_opened() throws Exception {
	}

	@Then("click on the request button present in the popup")
	public void click_on_the_request_button_present_in_the_popup() throws Exception {
		driver.findElement(By.cssSelector("div#requestLabs")).click();
		Thread.sleep(2000);
	}

	@And("click on the procedures field in the discharge summary")
	public void click_on_the_procedures_field_in_the_discharge_summary() throws Exception {
		driver.findElement(By.cssSelector("input#packages_input")).click();
		Thread.sleep(2000);
	}

	@Then("select the procedure by clicking enter button")
	public void select_the_procedure_by_clicking_enter_button() throws Exception {
		driver.findElement(By.cssSelector("input#packages_input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@And("search and select the procedure in discharge summary")
	public void search_and_select_the_procedure_in_discharge_summary() throws Exception {
		driver.findElement(By.cssSelector("input#packages_input")).sendKeys("management");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#packages_input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@Then("select the another procedure by clicking enter button")
	public void select_the_another_procedure_by_clicking_enter_button() throws Exception {
		driver.findElement(By.cssSelector("input#packages_input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@And("remove one of the selected procedure")
	public void remove_one_of_the_selected_procedure() throws Exception {
		driver.findElement(By.cssSelector("div#package_custom_chips>div:nth-of-type(3)>i")).click();
		Thread.sleep(2000);
	}

	@Then("enter the free text test for procedure and click on ok button")
	public void enter_the_free_text_test_for_procedure_and_click_on_ok_button() throws Exception {
		driver.findElement(By.cssSelector("input#packages_input")).sendKeys("textfreeforprocedureindischargesummary");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#packages_input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@Then("click on the duration field of next visit date")
	public void click_on_the_duration_field_of_next_visit_date() throws Exception {
		driver.findElement(By.cssSelector("input#doctor_visit_nxt_vst_dur")).click();
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);
	}

	@And("click on the calendar icon for next visit date in discharge summary")
	public void click_on_the_calendar_icon_for_next_visit_date_in_discharge_summary() throws Exception {
//		driver.findElement(By.cssSelector("input#nxtVisitDate")).click();
//		Thread.sleep(2000);
	}

	@When("calendar icon is clicked it will open calendar")
	public void calendar_icon_is_clicked_it_will_open_calendar() {
	}

	@Then("click on the cancel button in the calendar popup")
	public void click_on_the_cancel_button_in_the_calendar_popup() throws Exception {
//		WebElement calendarclick = driver.findElement(By.xpath("/html/body/div[25]/div/div[2]/div[2]/div/button[1]"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", calendarclick);
		// driver.findElement(By.xpath("/html/body/div[25]/div/div[2]/div[2]/div/button[1]")).click();
		Thread.sleep(2000);
	}

	@And("enter the duration in the field and select the duration from the dropdown")
	public void enter_the_duration_in_the_field_and_select_the_duration_from_the_dropdown() {
		driver.findElement(By.cssSelector("input#doctor_visit_nxt_vst_dur")).sendKeys("25");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// on clicking dropdown days,weeks,months options are not showing but showing in
		// the test env.
//		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//li[text()='Weeks'])[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("select the next visit type radio button in discharge summary")
	public void select_the_next_visit_type_radio_button_in_discharge_summary() {
		for (int i = 0; i <= 1; i++) {
			WebElement nvt = driver.findElement(By.xpath("(//label[text()='In-person'])[1]"));
			nvt.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	}

	@And("enter the comments in discharge summary")
	public void enter_the_comments_in_discharge_summary() {
		driver.findElement(By.cssSelector("textarea#prescriptionComments")).sendKeys("test comments");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on enter button to add new comment")
	public void click_on_enter_button_to_add_new_comment() {
		driver.findElement(By.cssSelector("textarea#prescriptionComments")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("enter the another comment in discharge summary")
	public void enter_the_another_comment_in_discharge_summary() throws Exception {
		driver.findElement(By.cssSelector("textarea#prescriptionComments")).sendKeys("test comments1");
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

	}

	@Then("enter the doctors attended in discharge summary")
	public void enter_the_doctors_attended_in_discharge_summary() {
		driver.findElement(By.xpath("(//label[text()='Physiotherapist'])/following-sibling::input"))
				.sendKeys("test physiotherapist");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='DMO'])/following-sibling::input")).sendKeys("test dmo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='Pain Physician'])/following-sibling::input"))
				.sendKeys("test pain physician");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("click on the Attachment icon present at the right top of the page")
	public void click_on_the_attachment_icon_present_at_the_right_top_of_the_page() throws Exception {
		driver.findElement(By.cssSelector("div.col.right_side_layer.hide-on-small-only>img:nth-of-type(1)")).click();
		Thread.sleep(2000);
	}

	@Then("upload the file and click on the save button from the attachment popup")
	public void upload_the_file_and_click_on_the_save_button_from_the_attachment_popup() throws Exception {
		driver.findElement(By.cssSelector("input#attachmentsUploader"))
				.sendKeys("C:\\Users\\Lenovo\\Downloads\\MR. CUCUM DISSUMMARY.pdf");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@onclick='closeAttachments()'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("Health information icon below the attachment icon")
	public void health_information_icon_below_the_attachment_icon() throws Exception {
//		driver.findElement(By.xpath("(//a[@data-tooltip='Health Information'])[1]/img")).click();
//		Thread.sleep(2000);
	}

	@When("icon is clicked popup will be opened about health information")
	public void icon_is_clicked_popup_will_be_opened_about_health_information() {
	}

	@Then("add the necessary health information and save by clicking save button")
	public void add_the_necessary_health_information_and_save_by_clicking_save_button() throws Exception {
//		// blood group
//		driver.findElement(By.xpath("(//a[@id='edit_patient'])[1]/img")).click();
//		Thread.sleep(1000);
//		// selecting blood group from the dropdown
//		driver.findElement(By.cssSelector("span#select2-result_value-container")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//li[text()='O+'])[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
//		Thread.sleep(2000);
//
//		// smoking
//		driver.findElement(By.xpath("(//a[@id='edit_patient'])[2]/img")).click();
//		Thread.sleep(1000);
//		WebElement never = driver.findElement(By.xpath("(//label[text()='Never'])[1]"));
//		never.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
//		Thread.sleep(2000);
//
//		// alcohol
//		driver.findElement(By.xpath("(//a[@id='edit_patient'])[3]/img")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("input#result_value")).sendKeys("3");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
//		Thread.sleep(2000);
//
//		// diet
//		driver.findElement(By.xpath("(//a[@id='edit_patient'])[4]/img")).click();
//		Thread.sleep(1000);
//		// selecting diet from the dropdown
//		driver.findElement(By.cssSelector("span#select2-result_value-container")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//li[text()='2'])[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
//		Thread.sleep(2000);
//
//		// Excerise
//		driver.findElement(By.xpath("(//a[@id='edit_patient'])[5]/img")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("input#result_value")).sendKeys("1");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
//		Thread.sleep(2000);
//
////		// other dieases
////		driver.findElement(By.xpath("(//a[@id='edit_patient'])[6]/img")).click();
////		Thread.sleep(1000);
////		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
////		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//label[text()='N'])[7]")))).click();
//////		WebElement N = driver.findElement(By.xpath("(//label[text()='N'])[7]"));
//////		never.click();
////		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
////		driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
////		Thread.sleep(2000);
//		// closing the popup
//		driver.findElement(By.cssSelector("div#patientHistoryInfoModal>div>div>span>i")).click();
//		Thread.sleep(2000);
	}

	@And("click on the doctor notes from the discharge summary")
	public void click_on_the_doctor_notes_from_the_discharge_summary() throws Exception {
//		driver.findElement(By.xpath("(//a[@data-tooltip='Doctor notes'])[1]")).click();
//		Thread.sleep(2000);
	}

	@Then("enter the message and upload the file for doctor notes")
	public void enter_the_message_and_upload_the_file_for_doctor_notes() throws Exception {
//		driver.findElement(By.cssSelector("textarea#message")).sendKeys("test message");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.cssSelector("input#files_constr")).sendKeys("C:\\Users\\Lenovo\\Downloads\\OP-05000.pdf");
//		Thread.sleep(3000);

	}

	@And("enable the necessary checkboxes and click on save button")
	public void enable_the_necessary_checkboxes_and_click_on_save_button() throws Exception {
//		// dietician
//		for (int i = 0; i <= 2; i++) {
//			WebElement dietician = driver.findElement(By.xpath("(//label[text()='Dietitian'])[1]"));
//			dietician.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
//
//		// patient
//		for (int i = 0; i <= 2; i++) {
//			WebElement patient = driver.findElement(By.xpath("(//label[text()='Patient'])[1]"));
//			patient.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
//
//		// others
//		for (int i = 0; i <= 2; i++) {
//			WebElement other = driver.findElement(By.xpath("(//label[text()='Others'])[1]"));
//			other.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@value='Save'])[2]")).click();
//		Thread.sleep(2000);
	}

	@Then("close the popup for doctor notes")
	public void close_the_popup_for_doctor_notes() throws Exception {
//		driver.findElement(By.cssSelector("div#doctor_notes_new_modal>div>div>div>span>i")).click();
//		Thread.sleep(2000);
	}

	@And("click on the favourite discharge summary and close it")
	public void click_on_the_favourite_discharge_summary_and_close_it() throws Exception {
//		driver.findElement(By.xpath("(//a[@data-tooltip='Favourite Discharge Summary'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("div#patientHistoryInfoModal>div>div>span>i")).click();
//		Thread.sleep(2000);
	}

	@Then("click on the last prescription and close it")
	public void click_on_the_last_prescription_and_close_it() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Last prescription'])[1]/img"))).build()
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
		// driver.findElement(By.xpath("(//a[@data-tooltip='All'])[1]/img")).click();
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
	}

	@And("click on the lab reports in discharge summary and close it")
	public void click_on_the_lab_reports_in_discharge_summary_and_close_it() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Lab Reports'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div#patientHistoryModal>div>div>span>i")).click();
		Thread.sleep(2000);
	}

	@Then("click on the save as draft in the discharge summary page")
	public void click_on_the_save_as_draft_in_the_discharge_summary_page() throws Exception {
		driver.findElement(By.xpath("(//input[@value='Save as Draft'])[1]")).click();
		Thread.sleep(6000);
	}

	@When("save as draft is clicked it will navigate to the patient profile")
	public void save_as_draft_is_clicked_it_will_navigate_to_the_patient_profile() {
	}

	@And("click on the discharge summary button from the patient profile")
	public void click_on_the_discharge_summary_button_from_the_patient_profile() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Discharge Summary'])[1]")).click();
		Thread.sleep(5000);
	}

	@And("click on the save button in the discharge summary page")
	public void click_on_the_save_button_in_the_discharge_summary_page() throws Exception {
		driver.findElement(By.cssSelector("input#saveBtn")).click();
		Thread.sleep(3000);
	}

	@Then("click on the edit button from the preview discharge summary")
	public void click_on_the_edit_button_from_the_preview_discharge_summary() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Edit Prescription'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("enter the comments by pagedowning in the edit discharge summary")
	public void enter_the_comments_by_pagedowning_in_the_edit_discharge_summary() throws Exception {
		driver.findElement(By.cssSelector("textarea#prescriptionComments")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("textarea#prescriptionComments")).sendKeys("test comments2");
		Thread.sleep(2000);
	}

	@Then("click on the save button again to save edited discharge summary")
	public void click_on_the_save_button_again_to_save_edited_discharge_summary() throws Exception {
		driver.findElement(By.cssSelector("input#saveBtn")).click();
		Thread.sleep(3000);
	}

	@And("click on the print with header_footer in discharge summary")
	public void click_on_the_print_with_header_footer_in_discharge_summary() throws Exception {
		// with header and footer
		String parentwind = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]")).click();
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

	@Then("click on the print without header_footer discharge summary")
	public void click_on_the_print_without_header_footer_discharge_summary() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("click on the share invoice button in discharge summary")
	public void click_on_the_share_invoice_button_in_discharge_summary() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("enter email id and click on the submit button to send the discharge summary to given mailid")
	public void enter_email_id_and_click_on_the_submit_button_to_send_the_discharge_summary_to_given_mailid()
			throws Exception {
		driver.findElement(By.cssSelector("input#emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#emails")).sendKeys("Sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[2]")).click();
		Thread.sleep(20000);
	}

	@And("click on the close button in discharge summary")
	public void click_on_the_close_button_in_discharge_summary() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Close'])[1]")).click();
		Thread.sleep(3000);
	}

	@When("close is clicked it will take to the patient profile from discharge summary preview")
	public void close_is_clicked_it_will_take_to_the_patient_profile_from_discharge_summary_preview() {
	}

	@And("click on the history button in the patient profile")
	public void click_on_the_history_button_in_the_patient_profile() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a#patientHistoryBtn")).click();
		Thread.sleep(3000);
	}

	@Then("download the pdfs of the discharge summary")
	public void download_the_pdfs_of_the_discharge_summary() throws Exception {
		// clicking on the discharge summary
		driver.findElement(By.xpath("(//span[text()='Discharge Summary'])[1]")).click();
		Thread.sleep(2000);
		// print with header and footer
		String parentwind = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img")).click();
		Thread.sleep(1000);
		Set<String> childwindow = driver.getWindowHandles();
		for (String handle : childwindow) {
			if (!handle.equals(parentwind)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind);
			}
		}
		Thread.sleep(3000);
		// print without header and footer
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")).click();
		Thread.sleep(3000);

		// share invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#emails")).sendKeys("Sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[2]")).click();
		Thread.sleep(18000);
	}

	@And("click on the load discharge summary from the history of the patient profile")
	public void click_on_the_load_discharge_summary_from_the_history_of_the_patient_profile() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Load Discharge Summary'])[1]/img")).click();
		Thread.sleep(3000);

	}

	@When("load discharge summary is clicked it will load discharge summary")
	public void load_discharge_summary_is_clicked_it_will_load_discharge_summary() {
	}

	@Then("edit the necessary changes from the load discharge summary page")
	public void edit_the_necessary_changes_from_the_load_discharge_summary_page() throws Exception {
		// hsptl.course
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[5]/div/div[2]/textarea"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[5]/div/div[2]/textarea"))
				.sendKeys("test course1");
		Thread.sleep(2000);
	}

	@And("click on the save button after editing from the load discharge summary page")
	public void click_on_the_save_button_after_editing_from_the_load_discharge_summary_page() throws Exception {
		driver.findElement(By.cssSelector("input#saveBtn")).click();
		Thread.sleep(3000);
	}

	@Then("download the pdfs with_without header_footer and share the ds")
	public void download_the_pdfs_with_without_header_footer_and_share_the_ds() throws Exception {
		// with header and footer
		String parentwind = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]")).click();
		Thread.sleep(1000);
		Set<String> childwindow = driver.getWindowHandles();
		for (String handle : childwindow) {
			if (!handle.equals(parentwind)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind);
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#emails")).sendKeys("Sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[2]")).click();
		Thread.sleep(20000);
	}

	@And("click on the patient name from the discharge summary")
	public void click_on_the_patient_name_from_the_discharge_summary() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Cucum Dissummary'])[1]"))))
				.click();
//		driver.findElement(By.xpath("(//a[text()='Cucum Dissummary'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on the history button in the patient profile after saving load prescription")
	public void click_on_the_history_button_in_the_patient_profile_after_saving_load_prescription() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a#patientHistoryBtn")).click();
		Thread.sleep(3000);
	}

	@When("history is clicked a new discharge summary row will create")
	public void history_is_clicked_a_new_discharge_summary_row_will_create() {
	}

	@Then("download the pdfs with_without header_footer from the history of patient profile")
	public void download_the_pdfs_with_without_header_footer_from_the_history_of_patient_profile() throws Exception {
		// with header and footer
		String parentwind = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img")).click();
		Thread.sleep(1000);
		Set<String> childwindow = driver.getWindowHandles();
		for (String handle : childwindow) {
			if (!handle.equals(parentwind)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind);
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#emails")).sendKeys("Sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Submit'])[2]"))))
				.click();
		Thread.sleep(20000);
	}

}
