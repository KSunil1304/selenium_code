package StepDefinitions;

import java.awt.AWTException;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Patientprofileicons {
	WebDriver driver = null;

	@Given("navigate to the nanohealth web application portal")
	public void navigate_to_the_nanohealth_web_application_portal() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver132.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		// WebDriver driver = new ChromeDriver(co);
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@Then("login with the details")
	public void login_with_the_details(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> regData = dataTable.asLists(String.class);
		driver.findElement(By.id("user_login")).sendKeys(regData.get(0).get(1));
		driver.findElement(By.id("user_password")).sendKeys(regData.get(1).get(1));
	}

	@And("clicking on the signin button")
	public void clicking_on_the_signin_button() throws Exception {
		driver.findElement(By.name("commit")).click();
		Thread.sleep(2000);
	}

	@Then("select the profile with facility type")
	public void select_the_profile_with_facility_type() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on CdpAdmin
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[8]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
	}

	@And("deleting the existing patient using search bar")
	public void deleting_the_existing_patient_using_search_bar() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.id("frst_nm")).sendKeys("Demoicons");
		Thread.sleep(10000);
		// // clicking on the name
		// driver.findElement(By.xpath("(//a[text()='Demo Icons'])[1]")).click();
		// Thread.sleep(8000);
		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);
		// clicking on the view profile
		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
		Thread.sleep(3000);
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
		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
	}

	@Then("patient deleted successfully")
	public void patient_deleted_successfully() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting clinic manager
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[3]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
	}

	@And("click on the add patient icon for new registration of patient")
	public void click_on_the_add_patient_icon_for_new_registration_of_patient() throws Exception {
		// clicking on the add patient
		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("select title of the patient")
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

	@When("user enter the following details into the registration form")
	public void user_enter_the_following_details_into_the_registration_form(io.cucumber.datatable.DataTable dataTable) {
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
//		// email
//		driver.findElement(By.id("email")).sendKeys(regData.get(4).get(1));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// addressline
		driver.findElement(By.id("address-line1")).sendKeys(regData.get(4).get(1));
		driver.findElement(By.id("autocomplete-input")).sendKeys(regData.get(5).get(1));
		driver.findElement(By.id("landmark")).sendKeys(regData.get(6).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// aadharcardnumber
//		driver.findElement(By.xpath("/html/body/main/div/form/div[2]/div[1]/div/div[8]/div[2]/input"))
//				.sendKeys(regData.get(8).get(1));
	}

	@Then("selecting radio_buttons for new registration")
	public void selecting_radio_buttons_for_new_registration() throws Exception {
		// district
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).sendKeys("test");
		Thread.sleep(1000);
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
//		// abhacard
//		WebElement ac = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
//		ac.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// // profession
		// driver.findElement(By.xpath("(//input[@name='patient_master[profession]'])[1]")).sendKeys("test
		// profession");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		 // referred by
//		 driver.findElement(By.xpath("(//a[@data-tooltip='Add Referral'])[1]")).click();
//		 Thread.sleep(1000);
//		 // others
//		 driver.findElement(By.xpath("(//div[@class='icon'])[5]")).click();
//		 Thread.sleep(1000);
//		 driver.findElement(By.cssSelector("input#other_name")).sendKeys("test name");
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		 driver.findElement(By.cssSelector("input#other_note")).sendKeys("test notes");
//		 Thread.sleep(1000);
//		 // submit
//		 driver.findElement(By.cssSelector("span.cls.btn.green.right.referral_submit")).click();
//		 Thread.sleep(2000);
		// // demand program
		// driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(By.xpath("(//li[text()='NanoHealth-HYD'])")).click();
		// Thread.sleep(1000);
		// Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		// Thread.sleep(1000);
		// demand program
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='NanoHealth Program1'])[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
	}

	@And("click on the submit to register patient")
	public void click_on_the_submit_to_register_patient() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		// submit
		driver.findElement(By.id("update_submit")).click();
		Thread.sleep(8000);
	}

	@Then("it will redirect to patient profile")
	public void it_will_redirect_to_patient_profile() {
	}

	@When("patient profile is opened")
	public void patient_profile_is_opened() {
	}

	@Then("click on the pencil icon to the edit details")
	public void click_on_the_pencil_icon_to_the_edit_details() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Edit Profile'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("select the programme name from dropdown")
	public void select_the_programme_name_from_dropdown() throws Exception {
//		WebElement radiobtn = driver.findElement(By.xpath("(//label[text()='M'])[1]"));
//		radiobtn.click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='NanoHealth Program1'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("click on the submit button to save changes")
	public void click_on_the_submit_button_to_save_changes() throws Exception {
		driver.findElement(By.cssSelector("input#update_submit")).click();
		Thread.sleep(3000);
	}

	@Then("click on the Home icon from the left side beside patient profile image")
	public void click_on_the_home_icon_from_the_left_side_beside_patient_profile_image() throws Exception {
		// adding home
		driver.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[1]/a[1]/img[1]"))
				.click();
		Thread.sleep(2000);
	}

	@And("click on the add new address")
	public void click_on_the_add_new_address() throws Exception {
		// adding new address
		driver.findElement(By.xpath("//a[@data-tooltip='Add New Address']/i[1]")).click();
		Thread.sleep(2000);
	}

	@Then("enter the following details under new address1")
	public void enter_the_following_details_under_new_address1(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		List<List<String>> regData = dataTable.asLists(String.class);
		driver.findElement(By.id("address_detail_address_line1")).sendKeys(regData.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("address_detail_area")).sendKeys(regData.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("address_detail_landmark")).sendKeys(regData.get(2).get(1));
		Thread.sleep(1000);
		// entering the district
		driver.findElement(By.id("dist_nm")).sendKeys(regData.get(3).get(1));
		Thread.sleep(1000);
	}

	@And("selecting city from the dropdown for new address")
	public void selecting_city_from_the_dropdown_for_new_address() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Hyderabad'][1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("entering the pincode")
	public void entering_the_pincode() throws InterruptedException {
		// entering the pincode
		driver.findElement(By.id("address_detail_pin_code")).sendKeys("500034");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//div/a[text()='500034'])[1]")).click();
//		Thread.sleep(3000);
	}

	@When("user click on the save button for new address")
	public void user_click_on_the_save_button_for_new_address() throws Exception {
		// clicking on the location icon
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath("(//div[@class='input-field col s12 m4'])[1]/a/img[1]"));
			jse.executeScript("arguments[0].click();", element);
			Thread.sleep(8000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// current location
		driver.findElement(By.xpath("(//button[text()='Current Location'])[1]")).click();
		Thread.sleep(3000);
		// update
		driver.findElement(By.cssSelector("input#saveLoc")).click();
		Thread.sleep(3000);
		try {
			// clicking on the submit
			driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		driver.navigate().refresh();
		Thread.sleep(2000);
		// adding home
		driver.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[1]/a[1]/img[1]"))
				.click();
		Thread.sleep(2000);
	}

	@Then("it will redirect to the addresses page popup")
	public void it_will_redirect_to_the_addresses_page_popup() {

	}

	@Then("updating the pincode for the new address")
	public void updating_the_pincode_for_the_new_address() throws Exception {
		if (driver.findElement(By.xpath("(//a[@class='address-btn '])[2]/i")).isDisplayed())
			;
		{
			driver.findElement(By.xpath("(//a[@class='address-btn '])[2]/i")).click();
			Thread.sleep(1000);
			// updating the landmark
			driver.findElement(By.cssSelector("input#address_detail_landmark")).clear();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(By.cssSelector("input#address_detail_landmark")).sendKeys("Test landmark");
			Thread.sleep(2000);
			// clicking on the submit
			driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
			Thread.sleep(5000);
		}
		driver.navigate().refresh();
		Thread.sleep(2000);
		// adding home
		driver.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[1]/a[1]/img[1]"))
				.click();
		Thread.sleep(2000);
	}

	@And("clicking on the save button for new address in edit address page")
	public void clicking_on_the_save_button_for_new_address_in_edit_address_page() {

	}

	@And("deleting the already existing address")
	public void deleting_the_already_existing_address() throws Exception {
		if (driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).isDisplayed())
			;
		{
			driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='Confirm!']")).click();
			Thread.sleep(1000);
		}

	}

	@Then("closing the addresses popup")
	public void closing_the_addresses_popup() throws Exception {
		// closing
		try {
			driver.findElement(By.xpath(
					"/html/body/main/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[2]/div/div[1]/span/i"))
					.click();
			Thread.sleep(2000);

		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@Then("click on the contact icon beside of home icon")
	public void click_on_the_contact_icon_beside_of_home_icon() throws Exception {

		// adding contact
		driver.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[2]/a[1]/img[1]"))
				.click();
		Thread.sleep(2000);
	}

	@Then("contact popup will open")
	public void contact_popup_will_open() {

	}

	@Then("click on the add new contact")
	public void click_on_the_add_new_contact() throws Exception {
		driver.findElement(By.xpath("//a[@data-tooltip='Add New Contact']")).click();
		Thread.sleep(1000);
	}

	@Then("enter the following details under new contact1")
	public void enter_the_following_details_under_new_contact1(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		List<List<String>> regData = dataTable.asLists(String.class);
		// type
		driver.findElement(By.cssSelector("input#autocomplete-input")).sendKeys(regData.get(0).get(1));
		Thread.sleep(1000);
	}

	@Then("select the country code for new contact from dropdown")
	public void select_the_country_code_for_new_contact_from_dropdown() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='+91']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("enter the following details under new contact2")
	public void enter_the_following_details_under_new_contact2(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> regData = dataTable.asLists(String.class);

		// number
		driver.findElement(By.id("contact_detail_nmbr")).sendKeys(regData.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// mail
		driver.findElement(By.id("contact_detail_email")).sendKeys(regData.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the save button for new contact")
	public void click_on_the_save_button_for_new_contact() throws Exception {
		// save
		driver.findElement(By.xpath("//input[@value='Save'][1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		// adding contact
		driver.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[2]/a[1]/img[1]"))
				.click();
		Thread.sleep(2000);
	}

	@And("updating the contact by clicking edit")
	public void updating_the_contact_by_clicking_edit() throws Exception {
		driver.findElement(
				By.cssSelector("div#saved-contact>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>a>i"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.id("contact_detail_nmbr")).clear();
		driver.findElement(By.id("contact_detail_nmbr")).sendKeys("76543345671");
		Thread.sleep(1000);

	}

	@Then("saving it")
	public void saving_it() throws Exception {
		// save
		driver.findElement(By.xpath("//input[@value='Save'][1]")).click();
		Thread.sleep(5000);
	}

	@Then("closing the contact popup")
	public void closing_the_contact_popup() throws Exception {
		// close
		WebElement close = driver.findElement(By
				.xpath("/html/body/main/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[3]/div/div[1]/span/i"));
		close.click();
		Thread.sleep(2000);
	}

	@And("click on the add identification icon")
	public void click_on_the_add_identification_icon() throws Exception {
		driver.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[3]/a[1]/img[1]"))
				.click();
		Thread.sleep(2000);
	}

	@Then("clicking on the qr code")
	public void clicking_on_the_qr_code() throws Exception {
		// clicking on the qr code
		driver.findElement(By.xpath("//a[@data-tooltip='Print']/img[1]")).click();
		Thread.sleep(3000);

	}

	@And("adding one identification aadhar no")
	public void adding_one_identification_aadhar_no() throws Exception {
		driver.findElement(By.xpath("(//label[text()='Identification Type'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Aadhar card'])[1]")).click();
		Thread.sleep(1000);
		Robot tab = new Robot();
		tab.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Parameter value'])[1]/following-sibling::input[1]"))
				.sendKeys("987788990022");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='patient_parameter_detail_file_location'])[1]"))
				.sendKeys("C:\\Users\\Lenovo\\Pictures\\Screenshots\\Aadhartest.png");
		Thread.sleep(2000);

//		//start-date
//		driver.findElement(By.xpath("(//label[text()='Start Date'])[1]/preceding-sibling::input[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//div[@class='select-wrapper select-year'])[1]/input[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li/span[text()='2015'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
//		Thread.sleep(1000);
//		//expiry-date
//		driver.findElement(By.xpath("(//label[text()='Start Date'])[1]/preceding-sibling::input[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//div[@class='select-wrapper select-year'])[2]/input[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li/span[text()='2030'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[text()='1'])[2]")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Save'])[2]")).click();
		Thread.sleep(7000);

	}

	@And("closing the identification popup")
	public void closing_the_identification_popup() throws Exception {
		// close
		driver.findElement(By.xpath("(//div[@id='modal_identification_list'])[1]/div/div[1]/span/i[1]")).click();
		Thread.sleep(2000);
	}

	@Then("adding another mr number identification")
	public void adding_another_mr_number_identification() throws Exception {
//		
//		Thread.sleep(1000);
//		driver.findElement(By.id("frst_nm")).sendKeys("Demoicons");
//		Thread.sleep(7000);
//		// clicking on the patient name
//		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
//		Thread.sleep(3000);
//		// clicking on the identification details
//		driver.findElement(By.xpath("(//a[@data-tooltip='Identification Details'])[1]/img[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Add New'])[1]/i[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//li[text()='MR No'])[1]")).click();
//		Thread.sleep(2000);
//		Robot tab = new Robot();
//		tab.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@id='patient_parameter_detail_parameter_value'])[1]")).sendKeys("8790098");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@value='Save'])[2]")).click();
//		Thread.sleep(7000);

//		// edit
//		driver.findElement(By.xpath("(//div[@id='saved-identification'])[1]/div[1]/div[2]/div[1]/a/i[1]")).click();
//		Thread.sleep(3000);
//		// selecting mr no for
//		driver.findElement(By.xpath("(//label[text()='Identification Type'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Aadhaar No'])[1]")).click();
//		Thread.sleep(2000);
//		Robot tab1 = new Robot();
//		tab1.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@id='patient_parameter_detail_file_location'])[1]"))
//				.sendKeys("999988887777");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@value='Save'])[2]")).click();
//		Thread.sleep(7000);

	}

	@And("deleting one identification of the patient")
	public void deleting_one_identification_of_the_patient() throws Exception {
//		// delete
//		driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[6]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
//		Thread.sleep(3000);
//
//		Thread.sleep(2000);
//		driver.findElement(By.id("frst_nm")).sendKeys("Demoicons");
//		Thread.sleep(10000);
//		// clicking on the patient name
//		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
//		Thread.sleep(3000);
//		// clicking on the view profile
//		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
//		Thread.sleep(3000);
	}

	@Then("click on the files icon")
	public void click_on_the_files_icon() throws Exception {
		driver.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[4]/a[1]/img[1]"))
				.click();
		Thread.sleep(2000);
	}

	@And("entering the label name")
	public void entering_the_label_name() throws Exception {
		// label name
		driver.findElement(By.id("label_name")).sendKeys("Demo test label");
		Thread.sleep(1000);
	}

	@Then("clicking on the upload icon")
	public void clicking_on_the_upload_icon() throws Exception {
		driver.findElement(By.id("custom_img_url_"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\Prescriptionupload.pdf");
		Thread.sleep(2000);
	}

	@And("sending the file")
	public void sending_the_file() {

	}

	@Then("click on the submit button from files popup")
	public void click_on_the_submit_button_from_files_popup() throws Exception {
		// submit
		driver.findElement(By.cssSelector("input.modal-action.btn.green.right")).click();
		Thread.sleep(2000);
	}

	@When("file uploaded")
	public void file_uploaded() {

	}

	@Then("clicking on the uploaded pdf")
	public void clicking_on_the_uploaded_pdf() throws Exception {
		driver.findElement(By.xpath("(//img[@class='responsive-img photo'])[1]")).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		robot.keyPress(KeyEvent.VK_W);
		Thread.sleep(1000);
	}

	@And("closing the file popup")
	public void closing_the_file_popup() throws Exception {
		WebElement close = driver.findElement(By.xpath("(//div[@id='modal_files_list'])[1]/div[1]/div[1]/span/i[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", close);
		Thread.sleep(2000);
	}

	@Then("clicking on the add referral icon")
	public void clicking_on_the_add_referral_icon() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver
				.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[5]/a[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(2000);
	}

	@And("selecting the referral type as TV")
	public void selecting_the_referral_type_as_TV() throws Exception {
		// digital
		driver.findElement(By.xpath("(//div[@class='icon'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='TV'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("clicking on the submit in referral popup")
	public void clicking_on_the_submit_in_referral_popup() throws Exception {
		// submit
		driver.findElement(By.cssSelector("input.btn.right.green.btn-loader.on_submit")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
	}

	@When("referral is added")
	public void referral_is_added() {

	}

	@Then("mouse hovering to the add referral")
	public void mouse_hovering_to_the_add_referral() throws Exception {
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver
				.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[5]/a[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
	}

	@And("mouse hovering to the program icon")
	public void mouse_hovering_to_the_program_icon() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver
				.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[6]/a[1]/img[1]")))
				.build().perform();
		Thread.sleep(2000);
	}

	@Then("click on the share credentials icon")
	public void click_on_the_share_credentials_icon() throws Exception {
		driver.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[7]/a[1]/img[1]"))
				.click();
		Thread.sleep(2000);

		// select create a password
		WebElement createpswd = driver.findElement(By.xpath("(//label[text()='Create Password'])[1]"));
		createpswd.click();
		Thread.sleep(1000);
		// share
		driver.findElement(By.xpath("(//input[@value='Share'])[1]")).click();
		Thread.sleep(3000);
		// entering test dummy password
		driver.findElement(By.cssSelector("input#user_password")).sendKeys("Demo@123");
		Thread.sleep(1000);
		// //select automatically generate a password
		// WebElement automatpswd =
		// driver.findElement(By.xpath("(//label[text()='Automatically generate a
		// password'])[1]"));
		// createpswd.click();
		// Thread.sleep(1000);
		// share
		driver.findElement(By.xpath("(//input[@value='Share'])[1]")).click();
		Thread.sleep(5000);
	}

	// @And("click on the yes button in the share credentials popup")
	// public void click_on_the_yes_button_in_the_share_credentials_popup() throws
	// Exception {
	// // yes
	//// driver.findElement(By.xpath("(//a[text()='Yes'])[1]")).click();
	//// Thread.sleep(3000);
	// }

	@Then("clicking on the insurance button")
	public void clicking_on_the_insurance_button() throws Exception {
		driver.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[8]/a[1]/img[1]"))
				.click();
		Thread.sleep(2000);
	}

	@And("click on the plus button in insurance popup")
	public void click_on_the_plus_button_in_insurance_popup() throws Exception {
	}

	@When("new insurance popup opens")
	public void new_insurance_popup_opens() {

	}

	@And("select the insurance radio button from the new insurer popup")
	public void select_the_insurance_radio_button_from_the_new_insurer_popup() throws Exception {
		WebElement insurnace = driver.findElement(By.xpath("(//label[text()='Insurance'])[1]"));
		insurnace.click();
		Thread.sleep(2000);

		// // clicking on the add button[plus]
		// driver.findElement(By.xpath("(//a[@data-tooltip='Add New'])[2]")).click();
		// Thread.sleep(2000);
	}

	@Then("enter the following in the insurance popup")
	public void enter_the_following_in_the_insurance_popup(io.cucumber.datatable.DataTable dataTable) throws Exception {
		List<List<String>> regData = dataTable.asLists(String.class);
		driver.findElement(By.cssSelector("input#insurance_policy_detail_id_card:nth-of-type(1)"))
				.sendKeys(regData.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("input#insurance_policy_detail_policy_no:nth-of-type(1)"))
				.sendKeys(regData.get(1).get(1));
		Thread.sleep(2000);
	}

	@And("select the policy start and end dates")
	public void select_the_policy_start_and_end_dates() throws Exception {
		// clicking on the policy start date
		driver.findElement(By.id("insurance_policy_detail_policy_start_date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//td[@class='is-today']")).click();
		Thread.sleep(1000);
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
		Thread.sleep(3000);
	}

	@Then("clicking on the save button from insurance popup")
	public void clicking_on_the_save_button_from_insurance_popup() throws Exception {
		// // clicking on the dropdown
		// driver.findElement(By.xpath("//span[@class='selection']")).click();
		// submit
		driver.findElement(By.cssSelector("input.btn.right.green.ins_submit")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@And("clicking on the edit and updating the policy no")
	public void clicking_on_the_edit_and_updating_the_policy_no() throws Exception {
		driver.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[8]/a[1]/img[1]"))
				.click();
		Thread.sleep(2000);
		// WebElement insurnace =
		// driver.findElement(By.xpath("(//label[text()='Insurance'])[1]"));
		// insurnace.click();
		// Thread.sleep(2000);
		// clicking on the edit
		driver.findElement(By.cssSelector("tbody#insurance_details>tr>td:nth-of-type(7)>a:nth-of-type(1)>i")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("insurance_policy_detail_policy_no")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("insurance_policy_detail_policy_no")).sendKeys("123456");
		Thread.sleep(3000);

	}

	@Then("saving the insurance with new policy no")
	public void saving_the_insurance_with_new_policy_no() throws Exception {
		// submit
		driver.findElement(By.cssSelector("input.btn.right.green.ins_submit")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[8]/a[1]/img[1]"))
				.click();
		Thread.sleep(2000);
	}

	@And("adding new insurance")
	public void adding_new_insurance() throws Exception {
		// clicking on the add button[plus]
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New'])[1]")).click();
		Thread.sleep(2000);
		WebElement insurnace = driver.findElement(By.xpath("(//label[text()='Corporate'])[1]"));
		insurnace.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#emp_id")).sendKeys("143");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Company'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='NanoHealth-HYD'])[1]")).click();
//		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// submit
		driver.findElement(By.cssSelector("input.btn.right.green.ins_submit")).click();
		Thread.sleep(3000);
	}

	@Then("deleting the newly added insurance")
	public void deleting_the_newly_added_insurance() throws Exception {
		driver.findElement(
				By.cssSelector("tbody#insurance_details>tr:nth-of-type(2)>td:nth-of-type(7)>a:nth-of-type(2)>i"))
				.click();
		Thread.sleep(2000);
		// confirm
		WebDriverWait confirm = new WebDriverWait(driver, Duration.ofSeconds(30));
		confirm.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Confirm!']"))))
				.click();

		// driver.findElement(By.xpath("//button[text()='Confirm!']")).click();
		Thread.sleep(5000);
	}

	@And("closing the insurance popup")
	public void closing_the_insurance_popup() throws Exception {
		driver.navigate().refresh();
		Thread.sleep(2000);
//		// closing
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement element = driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[5]/div/div[1]/span/i"));
//		js.executeScript("arguments[0].click();", element);
//		//driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[5]/div/div[1]/span/i")).click();
//		Thread.sleep(3000);

	}

	// @Then("mouse hovering on the profession icon")
	// public void mouse_hovering_on_the_profession_icon() throws Exception {
	// Actions action = new Actions(driver);
	// action.moveToElement(driver.findElement(By.xpath("//div[@class='row
	// mobile_patient_info']/div[10]/a/img")))
	// .build().perform();
	// Thread.sleep(1000);
	// }

	@Then("click on the transfer icon and transfer the patient to another hospital")
	public void click_on_the_transfer_icon_and_transfer_the_patient_to_another_hospital() throws Exception {
//		// transfer patient
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//div[@class='row mobile_patient_info']/div[11]/a/img")))
//				.build().perform();
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("(//div[@class='row mobile_patient_info curved_div'])[1]/div[11]/a[1]/img[1]"))
//				.click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='NH_OP'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@value='Transfer'])[1]")).click();
//		Thread.sleep(3000);
	}

	@Then("click on the reviews icon")
	public void click_on_the_reviews_icon() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Reviews'])[1]/img[1]")).click();
		Thread.sleep(4000);

	}

	@And("clicking on the plus button in the review popup")
	public void clicking_on_the_plus_button_in_the_review_popup() throws Exception {
		// plus icon
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("giving the ratings and entering the comments")
	public void giving_the_ratings_and_entering_the_comments() throws Exception {
		driver.findElement(By.xpath("//a[@data-rating-text='5']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comments
		driver.findElement(By.id("patient_rating_detail_comments")).sendKeys("demo comments");
		Thread.sleep(1000);
	}

	@And("clicking on the submit from the add review popup")
	public void clicking_on_the_submit_from_the_add_review_popup() throws Exception {
		// submit
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[19]/div/div[2]/form/div[3]/input")).click();
		Thread.sleep(5000);
	}

	@Then("adding another review and submitting")
	public void adding_another_review_and_submitting() throws Exception {
		// plus icon
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New'])[1]/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-rating-text='5'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comments
		driver.findElement(By.id("patient_rating_detail_comments")).sendKeys("demo commenttwo");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[19]/div/div[2]/form/div[3]/input")).click();
		Thread.sleep(3000);
	}

	@And("editing the comments and deleting one review")
	public void editing_the_comments_and_deleting_one_review() throws Exception {
		// edit
		driver.findElement(By.xpath("//tbody[@id='saved_rating']/tr[2]/td[5]/a[1]")).click();
		Thread.sleep(1000);
		// comments
		driver.findElement(By.id("patient_rating_detail_comments")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comments
		driver.findElement(By.id("patient_rating_detail_comments")).sendKeys("demo commentstwo");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[19]/div/div[2]/form/div[3]/input")).click();
		Thread.sleep(5000);
		// delete
		driver.findElement(By.xpath("//tbody[@id='saved_rating']/tr[1]/td[5]/a[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Confirm!']")).click();
		Thread.sleep(3000);
	}

	@Then("closing the review popup")
	public void closing_the_review_popup() throws Exception {
		// closing
		WebElement close = driver
				.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div[2]/div/div[2]/div/div[1]/span/i"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", close);
		// driver.findElement(By.xpath("/html/body/main/div/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/span/i"));
		Thread.sleep(2000);
	}

	@And("clicking on the careteam icon")
	public void clicking_on_the_careteam_icon() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Care team'])[1]/img[1]")).click();
		Thread.sleep(2000);
	}

	@Then("clicking on the plus button in the careteam popup")
	public void clicking_on_the_plus_button_in_the_careteam_popup() {
//		// add [plus]
//		driver.findElement(By.xpath(
//				"/html/body/main/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div/a/i"))
//				.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("selecting provider type and name")
	public void selecting_provider_type_and_name() throws Exception {
		// provider type
		driver.findElement(By.xpath("(//label[text()='Provider Type'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='ClinicManager'][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Sunil K (sunilk@nh.com)'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("assigning another and deleting it")
	public void assigning_another_and_deleting_it() throws Exception {
		// add [plus]
		driver.findElement(By.xpath(
				"/html/body/main/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div/a/i"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// provider type
		driver.findElement(By.xpath("(//label[text()='Provider Type'])[2]/following-sibling::span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li[text()='HealthCoach'])[1]")).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[text()='Dhanalaxmi
		// Bagadam'])[1]")).click();
		// Thread.sleep(1000);
		// removing
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(1000);
	}

	@Then("clicking on the submit button")
	public void clicking_on_the_submit_button() throws Exception {
		// save
		driver.findElement(By.id("saveBtn")).click();
		Thread.sleep(2000);
	}

	@And("clicking on the patient engagement icon")
	public void clicking_on_the_patient_engagement_icon() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Patient Engagement'])[1]/img[1]")).click();
		Thread.sleep(2000);
	}

	@When("patient engagemnet popup opens")
	public void patient_engagemnet_popup_opens() {
	}

	@Then("select the engagement method from the dropdown")
	public void select_the_engagement_method_from_the_dropdown() throws Exception {
		// selecting the sms
		driver.findElement(By.xpath("//li[text()='SMS']")).click();
		Thread.sleep(2000);
	}

	@And("select the date for engagement as today")
	public void select_the_date_for_engagement_as_today() throws Exception {
		// date
		driver.findElement(By.id("patient_engagement_detail_engagement_date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@class='is-today']")).click();
		Thread.sleep(1000);
	}

	@Then("select the time for engagement")
	public void select_the_time_for_engagement() throws Exception {
		// time
		driver.findElement(By.id("patient_engagement_detail_engagement_time")).click();
		Thread.sleep(1000);
//		// 12
//		driver.findElement(By.xpath("(//div[text()='10'])[1]")).click();
//		Thread.sleep(1000);
//		// pm
//		driver.findElement(By.xpath("(//div[text()='AM'])[1]")).click();
//		Thread.sleep(1000);
//		// 00 mins
//		driver.findElement(By.xpath("(//div[text()='00'])[1]")).click();
//		Thread.sleep(1000);
		// ok
		driver.findElement(By.xpath("(//button[text()='Ok'])[2]")).click();
		Thread.sleep(1000);
	}

	@And("enter the sms text in the sms field")
	public void enter_the_sms_text_in_the_sms_field() {
		// entering the sms text
		driver.findElement(By.cssSelector("textarea#patient_engagement_detail_user_message"))
				.sendKeys("Hi user, test is done.");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on the send icon beside of the sms field")
	public void click_on_the_send_icon_beside_of_the_sms_field() throws Exception {
		driver.findElement(By.cssSelector("img#sendMessageIcon")).click();
		Thread.sleep(3000);
	}

	@When("send icon is clicked it will sent sms successfully")
	public void send_icon_is_clicked_it_will_sent_sms_successfully() {
	}

	@And("select the status from the dropdown")
	public void select_the_status_from_the_dropdown() throws Exception {
		// status
		// WebElement click =
		// driver.findElement(By.xpath("(//span[@class='selection']/span)[2]/span[1]"))
		driver.findElement(By.cssSelector("span#select2-patient_engagement_detail_global_status_master_id-container"))
				.click();
		Thread.sleep(1000);
		// done
		driver.findElement(By.xpath("(//li[text()='Pending'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("enter the engagement description")
	public void enter_the_engagement_description() throws Exception {
		// description
		driver.findElement(By.id("patient_engagement_detail_notes")).sendKeys("Test is pending...");
		Thread.sleep(1000);
	}

	@Then("click on the submit button in the engagement popup")
	public void click_on_the_submit_button_in_the_engagement_popup() throws Exception {
		// submit
		driver.findElement(By.id("engmtSubmitBtn")).click();
		Thread.sleep(3000);
		// following up date
		driver.findElement(By.cssSelector("input#patient_engagement_detail_prfrd_followup_date")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(2000);
		// following up time
		driver.findElement(By.cssSelector("input#patient_engagement_detail_prfrd_followup_time")).click();
		Thread.sleep(2000);
		// ok
		driver.findElement(By.xpath("(//button[@class='btn-flat timepicker-close waves-effect'])[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Preferred Method'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Notification'])[1]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.id("engmtSubmitBtn")).click();
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(2000);
	}

	@When("history updated")
	public void history_updated() {
	}

	@Then("close the engagement popup")
	public void close_the_engagement_popup() throws Exception {
		// close
		driver.findElement(By.cssSelector("span#patient-engagement-modal-closeBtn>i")).click();
		Thread.sleep(5000);
	}

	@And("click on the Add Allergies from the patient profile")
	public void click_on_the_add_allergies_from_the_patient_profile() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@id='insert_allergy'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='insert_allergy'])[1]")).click();
		Thread.sleep(2000);

	}

	@Then("add allergies popup will be opened click on the add button to add")
	public void add_allergies_popup_will_be_opened_click_on_the_add_button_to_add() throws Exception {
		driver.findElement(By.xpath("(//button[@class='add_allergies btn-floating orange'])[1]/i[1]")).click();
		Thread.sleep(2000);
	}

	@And("select the allergie type and enter the text for allergie")
	public void select_the_allergie_type_and_enter_the_text_for_allergie() throws Exception {
		WebElement allergey1 = driver.findElement(By.xpath("(//select[@name='allergy_type[]'])[1]"));
		Select all1 = new Select(allergey1);
		all1.selectByVisibleText("Food");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='allergies[]'])[1]"))
				.sendKeys("testing allergie testing allergie testing allergie testing allergie testing allergie");
		Thread.sleep(1000);
	}

	@Then("click on add button again to add new allergie")
	public void click_on_add_button_again_to_add_new_allergie() throws Exception {
		driver.findElement(By.xpath("(//button[@class='add_allergies btn-floating orange'])[1]/i[1]")).click();
		Thread.sleep(2000);
	}

	@And("select the type of allergie and enter the allergie text")
	public void select_the_type_of_allergie_and_enter_the_allergie_text() throws Exception {
		WebElement allergey2 = driver.findElement(By.xpath("(//select[@name='allergy_type[]'])[2]"));
		Select all1 = new Select(allergey2);
		all1.selectByVisibleText("Others");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='allergies[]'])[2]"))
				.sendKeys("testing allergie testing allergie testing allergie testing allergie testing allergie");
		Thread.sleep(1000);
	}

	@Then("click on the submit button to save the allergies")
	public void click_on_the_submit_button_to_save_the_allergies() throws Exception {
		driver.findElement(By.xpath("(//input[@class='btn green submit-call right'])[1]")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@And("mouse hover on the Add Allergies to show the added allergies and click on any one allergie")
	public void mouse_hover_on_the_add_allergies_to_show_the_added_allergies_and_click_on_any_one_allergie()
			throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Allergies'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Allergies'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("allergies will be opened remove one allergie and submit again")
	public void allergies_will_be_opened_remove_one_allergie_and_submit_again() throws Exception {
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='btn green submit-call right'])[1]")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@And("mouse hover on the add allergies again to show the updated")
	public void mouse_hover_on_the_add_allergies_again_to_show_the_updated() throws InterruptedException {
		// Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.xpath("(//div[@id='insert_allergy'])[1]"))).build().perform();
		// Thread.sleep(2000);
	}

	@Then("mouse hover to upload reports and click on the upload doctor visit")
	public void mouse_hover_to_upload_reports_and_click_on_the_upload_doctor_visit() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='upld_dropdown'])[2]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@data-tooltip='Upload Doctor Visit']")).click();
		Thread.sleep(1000);
	}

	@When("doctor visit popup opens from the upload reports")
	public void doctor_visit_popup_opens_from_the_upload_reports() {
	}

	@Then("enter the doctors first_last name")
	public void enter_the_doctors_first_last_name() throws Exception {
		// doctor first name
		driver.findElement(By.id("doctor_visit_dummy2")).sendKeys("Doctor");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// doctor last name
		driver.findElement(By.id("doctor_visit_referral_reason")).sendKeys("One");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("select the hospital name for doctor visit upload")
	public void select_the_hospital_name_for_doctor_visit_upload() throws Exception {
		// hospital name
		driver.findElement(By.id("doctor_visit_hospital_master_id")).sendKeys("Nanohealth");
		Thread.sleep(1000);
		driver.findElement(By.id("doctor_visit_hospital_master_id")).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		driver.findElement(By.id("doctor_visit_hospital_master_id")).sendKeys(Keys.ENTER);
	}

	@Then("uploading the visit report pdf for doctor visit upload")
	public void uploading_the_visit_report_pdf_for_doctor_visit_upload() throws Exception {
		// sending the pdf
		driver.findElement(By.id("doctor_visit_prescription_img"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\Prescriptionupload.pdf");
		Thread.sleep(1000);
	}

	@And("selecting diagnosis for doctor visit")
	public void selecting_diagnosis_for_doctor_visit() throws Exception {
//		// diagnosis
//		driver.findElement(
//				By.xpath("/html/body/main/div/div[2]/div[3]/div/div[2]/div/form/div[3]/div[2]/div[1]/span/input[2]"))
//				.sendKeys("Bp");
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("/html/body/main/div/div[2]/div[3]/div/div[2]/div/form/div[3]/div[2]/div[1]/span/input[2]"))
//				.sendKeys(Keys.DOWN);
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("/html/body/main/div/div[2]/div[3]/div/div[2]/div/form/div[3]/div[2]/div[1]/span/input[2]"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
	}

	@And("entering the notes for doctor visit")
	public void entering_the_notes_for_doctor_visit() throws Exception {
		// notes
		driver.findElement(By.id("doctor_visit_cmmts")).sendKeys("demo notes");
		Thread.sleep(1000);
	}

	@Then("clicking on the submit button to save doctor visit upload")
	public void clicking_on_the_submit_button_to_save_doctor_visit_upload() throws Exception {
		// submit
		driver.findElement(By.cssSelector("input.modal-action.btn.green.right")).click();
		Thread.sleep(5000);
	}

	@And("mouse hover to upload reports and click on the upload dietician visit")
	public void mouse_hover_to_upload_reports_and_click_on_the_upload_dietician_visit() throws Exception {
		// dietician
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.xpath("(//div[@class='upld_dropdown'])[2]"))).build().perform();
		Thread.sleep(1000);
		action2.moveToElement(driver.findElement(By.xpath("//a[@data-tooltip='Upload Dietitian Visit']"))).click()
				.build().perform();
		Thread.sleep(1000);
	}

	@When("dietician visit popup opens from the upload reports")
	public void dietician_visit_popup_opens_from_the_upload_reports() {

	}

	@Then("select the visit date for dietician upload visit")
	public void select_the_visit_date_for_dietician_upload_visit() throws Exception {
		// dietitian visit date
		driver.findElement(By.id("patient_prescription_header_visit_date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//td[@class='is-today']/button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("enter the dietician first_last name")
	public void enter_the_dietician_first_last_name() throws Exception {
		// dietitan first name
		driver.findElement(By.id("patient_prescription_header_dummy2")).sendKeys("Dietitian");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// dietitian last name
		driver.findElement(By.id("patient_prescription_header_dummy1")).sendKeys("One");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("select the hospital name")
	public void select_the_hospital_name() throws Exception {
		// hospitalname
		driver.findElement(By.id("patient_prescription_header_form_hospital_name")).sendKeys("Nanohealth");
		Thread.sleep(1000);
		driver.findElement(By.id("patient_prescription_header_form_hospital_name")).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		driver.findElement(By.id("patient_prescription_header_form_hospital_name")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@And("uploading the visit report pdf")
	public void uploading_the_visit_report_pdf() throws Exception {
		// sending file
		driver.findElement(By.id("patient_prescription_header_prescription_img"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\Dietitianreportupload.pdf");
		Thread.sleep(3000);

	}

	@Then("clicking on the submit button to save dietician visit upload")
	public void clicking_on_the_submit_button_to_save_dietician_visit_upload() throws Exception {
		// submit
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[4]/div/div[2]/div/form/div[3]/span/input[1]"))
				.click();
		Thread.sleep(3000);
	}

	@And("mouse hover to upload reports and click on the upload diagnostic visit")
	public void mouse_hover_to_upload_reports_and_click_on_the_upload_diagnostic_visit() throws Exception {
		// diagnostic lab reports
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//div[@class='upld_dropdown'])[2]"))).build().perform();
		Thread.sleep(2000);
		action1.moveToElement(driver.findElement(By.xpath("//a[@data-tooltip='Upload Lab Reports']"))).click().build()
				.perform();
		Thread.sleep(2000);
	}

	@When("diagnostic visit popup opens from the upload reports")
	public void diagnostic_visit_popup_opens_from_the_upload_reports() {

	}

	@Then("select the visit date for diagnostic upload visit")
	public void select_the_visit_date_for_diagnostic_upload_visit() throws Exception {
		// diagnostic visit date
		driver.findElement(By.id("patient_labresult_header_test_date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//td[@class='is-today']/button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("enter the lab name for diagnostic upload visit")
	public void enter_the_lab_name_for_diagnostic_upload_visit() throws Exception {
		// lab name
		driver.findElement(By.id("patient_labresult_header_lab_name")).sendKeys("Nanohealth");
		Thread.sleep(1000);
		driver.findElement(By.id("patient_labresult_header_lab_name")).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		driver.findElement(By.id("patient_labresult_header_lab_name")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);

	}

	@Then("upload the diagnostic report pdf")
	public void upload_the_diagnostic_report_pdf() throws Exception {
		driver.findElement(By.id("patient_labresult_header_lab_image"))
				.sendKeys("C:\\Users\\Lenovo\\Downloads\\lab_report1726759480 (3).pdf");
		Thread.sleep(1000);
		// notes
		driver.findElement(By.id("patient_labresult_header_cmmts")).sendKeys("demo notes");
		Thread.sleep(1000);
	}

	@And("clicking on the submit button to save diagnostic visit upload")
	public void clicking_on_the_submit_button_to_save_diagnostic_visit_upload() throws Exception {
		// save
		driver.findElement(By.cssSelector("button.btn.green.btn-save.btn_submit")).click();
		Thread.sleep(5000);
	}

	@And("mouse hover to upload reports and click on the upload discharge summary")
	public void mouse_hover_to_upload_reports_and_click_on_the_upload_discharge_summary() throws Exception {
		// discharge summary
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(By.xpath("(//div[@class='upld_dropdown'])[2]"))).build().perform();
		Thread.sleep(1000);
		action3.moveToElement(driver.findElement(By.xpath("//a[@data-tooltip='Upload Discharge Summary']"))).click()
				.build().perform();
		Thread.sleep(1000);
	}

	@When("discharge summary  popup opens from the upload reports")
	public void discharge_summary_popup_opens_from_the_upload_reports() {

	}

	@Then("select the visit date for discharge summary")
	public void select_the_visit_date_for_discharge_summary() throws Exception {
		// test date
		driver.findElement(By.cssSelector("input#doctor_visit_visit_date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//td[@class='is-today']/button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("clicking on the submit button to save discharge summary")
	public void clicking_on_the_submit_button_to_save_discharge_summary() throws Exception {
		// doctor first name
		driver.findElement(By.cssSelector("input#doctor_visit_dummy2")).sendKeys("Doctor");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// doctor last name
		driver.findElement(By.cssSelector("input#doctor_visit_referral_reason")).sendKeys("One");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// hospital name
		driver.findElement(By.cssSelector("input#doctor_visit_hospital_master_id")).sendKeys("Nanohealth");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#doctor_visit_hospital_master_id")).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#doctor_visit_hospital_master_id")).sendKeys(Keys.ENTER);

		// sending pdf
		driver.findElement(By.cssSelector("input#doctor_visit_prescription_img"))
				.sendKeys("C:\\Users\\Lenovo\\Downloads\\DischargeSummary.pdf");
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[6]/div/div[2]/div/form/div[5]/span/input[1]"))
				.click();
		Thread.sleep(5000);
	}

	@And("click on the notes icon under uploads section")
	public void click_on_the_notes_icon_under_uploads_section() throws Exception {
		// notes
		// clicking on the notes
		driver.findElement(By.xpath("(//div[@class='options'])[2]/div/div/a[2]/img")).click();
		Thread.sleep(1000);
	}

	@Then("enter the message")
	public void enter_the_message() throws Exception {
		// entering the msg
		driver.findElement(By.id("message")).sendKeys("Test message");
		Thread.sleep(1000);
	}

	@And("upload the pdf file")
	public void upload_the_pdf_file() throws Exception {
		// sending file
		driver.findElement(By.id("files_constr"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\Dietitianreportupload.pdf");
		Thread.sleep(1000);
	}

	@Then("enable the checkboxes for notes")
	public void enable_the_checkboxes_for_notes() throws Exception {
		// check boxes
		for (int i = 0; i <= 2; i++) {
			WebElement doctor = driver.findElement(By.xpath("//label[text()='Doctor']"));
			doctor.click();
		}
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement dietitcian = driver.findElement(By.xpath("//label[text()='Dietitian']"));
			dietitcian.click();
		}
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement patient = driver.findElement(By.xpath("//label[text()='Patient']"));
			patient.click();
		}
		Thread.sleep(1000);
	}

	@And("click on the submit button from the notes popup")
	public void click_on_the_submit_button_from_the_notes_popup() throws Exception {
		// save
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(3000);
	}

	@Then("close the notes popup")
	public void close_the_notes_popup() throws Exception {
		// close
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[16]/div/div[1]/div/span/i")).click();
		Thread.sleep(3000);
	}

//	@Then("mouse hover to the forms icons under uploads section")
//	public void mouse_hover_to_the_forms_icons_under_uploads_section() throws Exception {
//		Actions forms = new Actions(driver);
//		forms.moveToElement(driver.findElement(By.xpath("(//div[@class='upld_dropdown'])[3]"))).build().perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[text()='IP Vitals'])[1]")).click();
//		Thread.sleep(2000);
//	}
//
//	@And("mouse hover again on to the form names")
//	public void mouse_hover_again_on_to_the_form_names() {
//
//	}
//
//	@Then("click on the form name")
//	public void click_on_the_form_name() {
//
//	}
//
//	@And("clicking on the pdf to download the form")
//	public void clicking_on_the_pdf_to_download_the_form() throws Exception {
//		// driver.findElement(By.xpath("(//a[@data-tooltip='Print PDF'])[1]")).click();
//		// Thread.sleep(3000);
//		// yes
//		// String parentwindow = driver.getWindowHandle();
//		// driver.findElement(By.xpath("(//a[text()='Yes'])[1]")).click();
//		// Thread.sleep(5000);
//		//
//		// Set<String> childwindow = driver.getWindowHandles();
//		// for (String handles : childwindow) {
//		// if (!childwindow.equals(parentwindow)) {
//		// driver.switchTo().window(parentwindow);
//		// Thread.sleep(2000);
//		// }
//	}
//
//	@Then("downloaded pdf will open in another tab")
//	public void downloaded_pdf_will_open_in_another_tab() {
//
//	}
//
//	@When("navigating back to the parent window")
//	public void navigating_back_to_the_parent_window() throws Exception {
//	}
//
//	@And("enter the details into the selected form")
//	public void enter_the_details_into_the_selected_form() throws Exception {
//		// feet
//		driver.findElement(By.xpath("(//input[@placeholder='Feet'])[1]")).sendKeys("6");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// weight-pounds
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div[1]/div/div[2]/div[2]/div[2]/input"))
//				.sendKeys("65");
//		// driver.findElement(By.cssSelector("input#weight_pnds")).sendKeys("65");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// hip-cms
//		driver.findElement(By.cssSelector("input#hip_cms")).sendKeys("180");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		Thread.sleep(1000);
//	}
//
//	@Then("click on the submit to save the form details")
//	public void click_on_the_submit_to_save_the_form_details() throws Exception {
//		// submit
//		driver.findElement(By.cssSelector("input#update_submit")).click();
//		Thread.sleep(3000);
//		// pulse
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div[1]/div/div[2]/div[4]/div[2]/input"))
//				.sendKeys("100");
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.cssSelector("input#update_submit")).click();
//		Thread.sleep(3000);
//	}
//
//	@When("form is submitted it will save into the history of the patient")
//	public void form_is_submitted_it_will_save_into_the_history_of_the_patient() {
//
//	}
//
//	@And("click on the history button from the patient profile")
//	public void click_on_the_history_button_from_the_patient_profile() throws Exception {
//		// clicking on the my history
//		driver.findElement(By.id("patientHistoryBtn")).click();
//		Thread.sleep(3000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		Robot robot1 = new Robot();
//		for (int i = 0; i < 1; i++) {
//			robot1.keyPress(KeyEvent.VK_UP);
//			Thread.sleep(1000);
//		}
//	}

//	@Then("click on the ip vitals")
//	public void click_on_the_ip_vitals() throws Exception {
//		driver.findElement(By.xpath("//div[@class='row']/span[text()='IP Vitals']")).click();
//		Thread.sleep(2000);
//	}

//	@And("click on the print pdf to download vitals")
//	public void click_on_the_print_pdf_to_download_vitals() throws Exception {
//		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/img[1]")).click();
//		Thread.sleep(2000);
//	}

//	@Then("click on the print pdf in the vitals header section")
//	public void click_on_the_print_pdf_in_the_vitals_header_section() throws Exception {
//		driver.findElement(By.xpath("//div[@class='row']/span[text()='IP Vitals']//following-sibling::span/a/img"))
//				.click();
//		Thread.sleep(3000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//	}

	@Then("click on the discharge summary")
	public void click_on_the_discharge_summary() throws Exception {
		// clicking on the discharge summary
		driver.findElement(By.xpath("//div[@class='row']/span[text()='Discharge Summary']")).click();
		Thread.sleep(3000);
	}

	@And("click on print pdf for discharge summary")
	public void click_on_print_pdf_for_discharge_summary() throws AWTException, Exception {
		// clicking on the pdf
		// String parentwind1 = driver.getWindowHandle();
		driver.findElement(
				By.xpath("//div[@class='row']/span[text()='Discharge Summary']//following-sibling::span/a/img"))
				.click();
		Thread.sleep(1000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot2.keyPress(KeyEvent.VK_W);
		Thread.sleep(1000);
	}

	@Then("ds pdf will open on new tab get back to the parent window")
	public void ds_pdf_will_open_on_new_tab_get_back_to_the_parent_window() {
	}

	@And("click on another pdf for discharge summary")
	public void click_on_another_pdf_for_discharge_summary() {
	}

	@Then("clicking on the dischare summary to close row")
	public void clicking_on_the_dischare_summary_to_close_row() throws Exception {
//		// clicking on the discharge summary
//		driver.findElement(By.xpath("//div[@class='row']/span[text()='Discharge Summary']")).click();
//		Thread.sleep(2000);

	}

	@When("row closed for dischare summary")
	public void row_closed_for_dischare_summary() {
	}

	@Then("click on the dietician visit")
	public void click_on_the_dietician_visit() throws Exception {
		// clicking on the Dietitian visit
		driver.findElement(By.xpath("//div[@class='row']/span[text()='Dietitian Visit']")).click();
		Thread.sleep(3000);
	}

	@And("click on print with header and footer for dietician visit")
	public void click_on_print_with_header_and_footer_for_dietician_visit() throws Exception {
		// clicking on the header & footer
		// String parentwind2 = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[2]")).click();
		Thread.sleep(1000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot3.keyPress(KeyEvent.VK_W);
		Thread.sleep(1000);
	}

	@Then("pdf will open on new tab get back to the parent window for dietician visit")
	public void pdf_will_open_on_new_tab_get_back_to_the_parent_window_for_dietician_visit() {

	}

	@And("click on print pdf for dietician visit")
	public void click_on_print_pdf_for_dietician_visit() {
	}

	@Then("share invoice to gmail clearing mobile number for for dietician visit")
	public void share_invoice_to_gmail_clearing_mobile_number_for_for_dietician_visit() throws Exception {
		// share invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[26]/div/div[2]/form/div[2]/input")).click();
		Thread.sleep(13000);
		Robot robot = new Robot();
		for (int i = 0; i <= 3; i++) {
			robot.keyPress(KeyEvent.VK_UP);
		}
		Thread.sleep(1000);
	}

	@When("invoice shared again clicking on dietician visit to close")
	public void invoice_shared_again_clicking_on_dietician_visit_to_close() throws Exception {
		// clicking on the Dietitian visit
		driver.findElement(By.xpath("//div[@class='row']/span[text()='Dietitian Visit']")).click();
		Thread.sleep(3000);
	}

	@Then("clicking on the diagnostic report")
	public void clicking_on_the_diagnostic_report() throws Exception {
		// clicking on the Diagnostic Report
		driver.findElement(By.xpath("//div[@class='row']/span[text()='Diagnostic Report']")).click();
		Thread.sleep(5000);
	}

	@And("click on print pdf for diagnostic report")
	public void click_on_print_pdf_for_diagnostic_report() throws Exception {
		// clicking on the pdf
		// String parentwind3 = driver.getWindowHandle();
		driver.findElement(
				By.xpath("//div[@class='row']/span[text()='Diagnostic Report']//following-sibling::span/a/img"))
				.click();
		Thread.sleep(1000);
		Robot robot5 = new Robot();
		robot5.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot5.keyPress(KeyEvent.VK_W);
		Thread.sleep(1000);
	}

	@Then("diagnostic report pdf will open on new tab get back to the parent window")
	public void diagnostic_report_pdf_will_open_on_new_tab_get_back_to_the_parent_window() {
	}

	@And("click on another pdf for diagnostic report")
	public void click_on_another_pdf_for_diagnostic_report() {
	}

	@Then("clicking on the diagnostic report to close row")
	public void clicking_on_the_diagnostic_report_to_close_row() throws Exception {
		// clicking on the Diagnostic Report
		driver.findElement(By.xpath("//div[@class='row']/span[text()='Diagnostic Report']")).click();
		Thread.sleep(2000);
	}

	@When("row closed for diagnostic report")
	public void row_closed_for_diagnostic_report() {
	}

	@Then("click on the prescription")
	public void click_on_the_prescription() throws Exception {
		// clicking on the prescription
		driver.findElement(By.xpath("//div[@class='row']/span[text()='Prescription']")).click();
		Thread.sleep(3000);
	}

	@And("click on print with header and footer for prescription")
	public void click_on_print_with_header_and_footer_for_prescription() throws Exception {
		// clicking on the print with header & footer
		// String parentwind = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]")).click();
		Thread.sleep(1000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot4.keyPress(KeyEvent.VK_W);
		Thread.sleep(1000);
	}

	@Then("pdf will open on new tab get back to the parent window for prescription")
	public void pdf_will_open_on_new_tab_get_back_to_the_parent_window_for_prescription() {
	}

	@And("click on print pdf for prescription")
	public void click_on_print_pdf_for_prescription() {
	}

	@Then("share invoice to gmail clearing mobile number for for prescription")
	public void share_invoice_to_gmail_clearing_mobile_number_for_for_prescription() throws Exception {
		// share invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[26]/div/div[2]/form/div[2]/input")).click();
		Thread.sleep(13000);
		Robot robot = new Robot();
		for (int i = 0; i <= 3; i++) {
			robot.keyPress(KeyEvent.VK_UP);
		}
		Thread.sleep(1000);

	}

	@When("invoice shared again clicking on prescription to close")
	public void invoice_shared_again_clicking_on_prescription_to_close() throws Exception {
		// clicking on the prescription
		driver.findElement(By.xpath("//span[text()='Prescription']")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}
