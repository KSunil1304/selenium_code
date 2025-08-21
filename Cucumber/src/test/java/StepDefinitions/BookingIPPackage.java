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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingIPPackage {
	WebDriver driver = null;

	@Given("navigate to the nanohealth website url")
	public void navigate_to_the_nanohealth_website_url() throws Exception {
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

	@Then("enter the emailormobile1 {string} and password1 {string}")
	public void enter_the_emailormobile1_and_password1(String emailormobile1, String password1) throws Exception {
		driver.findElement(By.id("user_login")).sendKeys(emailormobile1);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(password1);
		Thread.sleep(2000);
	}

	@And("click on the signin button to login ipbillingmanager")
	public void click_on_the_signin_button_to_login_ipbillingmanager() throws Exception {
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("select the ipbillingmanager profile")
	public void select_the_ipbillingmanager_profile() throws Exception {
		// selecting cdpadmin Role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[8]/div/div/div/div[2]")).click();
		Thread.sleep(5000);
	}

	@And("delete existing patient using search bar in ipbillingmanager")
	public void delete_existing_patient_using_search_bar_in_ipbillingmanager() throws Exception {
		// DELETE ICON IS NOT SHOWING IN THE PATIENT PROFILE, SO DELETING PATIENT FROM
		// cdp admin ROLE
		Thread.sleep(2000);
		driver.findElement(By.id("frst_nm")).sendKeys("Cucumippackage");
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
		// clicking on the brand logo and selecting IP Billing Manager
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("existing patient_deleted from the ipbillingmanager role")
	public void existing_patient_deleted_from_the_ipbillingmanager_role() {

	}

	@And("click on the add_patient_icon for registration")
	public void click_on_the_add_patient_icon_for_registration() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role as IPBillingManager
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[14]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
		// clicking on the add patient
		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("selecting the  title_of_the_patient")
	public void selecting_the_title_of_the_patient() throws Exception {
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

	@When("user enters details into registration form")
	public void user_enters_details_into_registration_form(io.cucumber.datatable.DataTable dataTable) {
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
		// city
		driver.findElement(By.cssSelector("input#city:nth-of-type(1)")).sendKeys(regData.get(7).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// district
		driver.findElement(By.cssSelector("input#district:nth-of-type(1)")).sendKeys(regData.get(8).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// pincode
		driver.findElement(By.cssSelector("input#pn_cd:nth-of-type(1)")).sendKeys(regData.get(9).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// aadharcardnumber
//		driver.findElement(By.xpath("/html/body/main/div/form/div[2]/div[1]/div/div[9]/div[2]/input"))
//				.sendKeys(regData.get(10).get(1));
	}

	@Then("selecting_the radio_button to register patient")
	public void selecting_the_radio_button_to_register_patient() throws Exception {
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
		// self
		driver.findElement(By.xpath("(//div[@class='icon'])[3]")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.cssSelector("span.cls.btn.green.right.referral_submit")).click();
		Thread.sleep(2000);
//		// insurance
//		driver.findElement(By.xpath("(//a[@data-tooltip='Add Insurance'])[1]")).click();
//		Thread.sleep(1000);
//		// policy no
//		driver.findElement(By.cssSelector("input#policy_no:nth-of-type(1)")).sendKeys("12345");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// id card
//		driver.findElement(By.cssSelector("input#id_card:nth-of-type(1)")).sendKeys("123");
//		Thread.sleep(1000);
//		// policy start date
//		driver.findElement(By.cssSelector("input#policy_start_date:nth-of-type(1)")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Insurance Company'])[1]/following-sibling::span[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//li[text()='Bajaj Allianz General Insurance Co Ltd'])[1]")).click();
//		Thread.sleep(1000);
//		// submit
//		driver.findElement(By.cssSelector("span.cls2.btn.green.right.ins_submit")).click();
//		Thread.sleep(2000);
		// demand program
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='NanoHealth Program1'])[1]")).click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
	}

	@And("click on submitbutton_to_register_patient")
	public void click_on_submitbutton_to_register_patient() throws Exception {
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("update_submit")))).click();
//		driver.findElement(By.id("update_submit")).click();
		Thread.sleep(5000);
	}

	@Then("click on the admission detail from the patient profile")
	public void click_on_the_admission_detail_from_the_patient_profile() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Admit Now'])[1]"))))
				.click();
//		driver.findElement(By.xpath("(//a[text()='Admission Detail'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("fillup the form of admission detail in the ipbillingmanager role")
	public void fillup_the_form_of_admission_detail_in_the_ipbillingmanager_role() throws Exception {
		WebElement self = driver.findElement(By.xpath("(//label[text()='Self'])[1]"));
		self.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// selecting the department
		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Emergency'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0]);", 200);
		driver.findElement(By.xpath("(//span[@class='selection'])[4]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Test room'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0]);", 200);
		// selecting the Lead doctor
		driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Dr. Doctor One'])[1]")).click();
		Thread.sleep(1000);
		Robot pgwn = new Robot();
		pgwn.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		WebElement surgery = driver.findElement(By.xpath("(//label[text()='Surgery'])[1]"));
		surgery.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[8]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")).click();
		Thread.sleep(1000);
//		// entering the comments
//		driver.findElement(
//				By.xpath("//*[@id=\"patient_master_patient_questnr_value_details_attributes_10_result_value\"]"))
//				.sendKeys("Test admit comments");
//		Thread.sleep(2000);
	}

	@Then("click on the submit button from the admission detail form")
	public void click_on_the_submit_button_from_the_admission_detail_form() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#update_submit")))).click();
		Thread.sleep(5000);
//		driver.navigate().refresh();
//		Thread.sleep(2000);
		// clicking on the patient name
		driver.findElement(By.xpath("(//li[@class='col s3 patient_card ip_card'])[1]/a[1]")).click();
		Thread.sleep(3000);

//		driver.findElement(By.cssSelector("input#update_submit")).click();
//		Actions action = new Actions(driver);
//		action.doubleClick(driver.findElement(By.cssSelector("li#clinic_patient_profile:nth-of-type(1)"))).perform();
//		Thread.sleep(1000);
//		WebElement element = driver.findElement(By.cssSelector("li#clinic_patient_profile:nth-of-type(1)"));
//		Actions action = new Actions(driver);
//		action.doubleClick(element).perform();
//		Thread.sleep(1000);
//		String patid = element.getText();
//		System.out.println("Patient registrationid: " + patid);
//		// driver.close();
	}

	@When("after submitting the form it will redirect to the patient profile page")
	public void after_submitting_the_form_it_will_redirect_to_the_patient_profile_page() {
	}

	@Then("search and open the patient profile from the ipbillingmanager")
	public void search_and_open_the_patient_profile_from_the_ipbillingmanager() throws Exception {
//		// clicking on the brand logo and selecting IP Billing Manager
//		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]")).click();
//		Thread.sleep(3000);
		// selecting Role clicking on IP Billing manager Role
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[13]/div/div/div/div[2]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.id("frst_nm")).sendKeys("Cucumippackage");
//		Thread.sleep(5000);
////		// clicking on the patient name
//		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
//		Thread.sleep(3000);
//		// clicking on the view profile
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='View Profile'])[1]"))))
//				.click();
//		// driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
//		Thread.sleep(3000);
//		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
//			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
//			Thread.sleep(2000);
//			// driver.findElement(By.id("admin-billing-tab")).click();
//			// Thread.sleep(1000);
//			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
//			wait1.until(ExpectedConditions
//					.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add IP Package'])[1]/img"))))
//					.click();
//			Thread.sleep(2000);
//		} else {
//			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
//			wait2.until(ExpectedConditions
//					.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add IP Package'])[1]/img"))))
//					.click();
//			Thread.sleep(2000);
//		}

	}

	@And("click on the add ip package icon from the book appointment section")
	public void click_on_the_add_ip_package_icon_from_the_book_appointment_section() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add IP Package'])[1]/img")))).click();
		// driver.findElement(By.xpath("(//a[@data-tooltip='Add IP
		// Package'])[1]/img")).click();
		Thread.sleep(2000);
	}

	@Then("select the packages using plus button")
	public void select_the_packages_using_plus_button() throws Exception {
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
	}

	@And("remove one of the package using remove button")
	public void remove_one_of_the_package_using_remove_button() throws Exception {
		driver.findElement(By.xpath("(//i[text()='remove'])[2]")).click();
		Thread.sleep(2000);
	}

	@Then("click on the checkout button from the cart of ip packages")
	public void click_on_the_checkout_button_from_the_cart_of_ip_packages() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Checkout'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("search and select the doctor name for referred by")
	public void search_and_select_the_doctor_name_for_referred_by() throws Exception {
		driver.findElement(By.xpath("(//input[@class='typeahead tt-input'])[1]")).sendKeys("d");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='typeahead tt-input'])[1]")).sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='typeahead tt-input'])[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("select the program start date for booking ip package")
	public void select_the_program_start_date_for_booking_ip_package() throws Exception {
		driver.findElement(By.xpath("(//input[@class='pick-date stdt'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
	}

	@When("start date is selected it will select automatically end date")
	public void start_date_is_selected_it_will_select_automatically_end_date() {

	}

	@Then("click on the submit button from the popup")
	public void click_on_the_submit_button_from_the_popup() throws Exception {
		driver.findElement(By.cssSelector("input#btn-loader")).click();
		Thread.sleep(3000);
	}

	@And("select the paymentmethods11 as cash")
	public void select_the_paymentmethods11_as_cash() throws Exception {
		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash.click();
		Thread.sleep(1000);
	}

	@When("user enters_the transaction_amount for ippackage then receipt_comment will visible")
	public void user_enters_the_transaction_amount_for_ippackage_then_receipt_comment_will_visible() {
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("10");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on receipt_comment and enter_comment for ippackage appointment")
	public void click_on_receipt_comment_and_enter_comment_for_ippackage_appointment() {
		// clicking on the comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test receipt comment");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("click on the submit button inthe proformainvoice11")
	public void click_on_the_submit_button_inthe_proformainvoice11() throws Exception {
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
//		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
	}

	@Then("download the Invoice_receipt_totaladvance_printpdf11")
	public void download_the_invoice_receipt_totaladvance_printpdf11() throws Exception {
		// printing
		driver.findElement(By.xpath("(//a[@class='tooltipped summary_pdf'])[1]/img[1]")).click();
		Thread.sleep(2000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the receipt id
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[8]/div[2]/div[2]/a")).click();
		Thread.sleep(3000);
		// clicking on the total receipt
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(3000);
		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.summary_pdf")).click();
		Thread.sleep(3000);
	}

	@And("click on shareinvoice11 button")
	public void click_on_shareinvoice11_button() throws Exception {
		// clicking on the share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.summary_pdf")).click();
		Thread.sleep(5000);
	}

	@Then("clears existing mail and phone for ippackage")
	public void clears_existing_mail_and_phone_for_ippackage() {
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("enter mail and click on submit button for shareinvoice11")
	public void enter_mail_and_click_on_submit_button_for_shareinvoice11() throws Exception {
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		WebElement sub = driver.findElement(By.xpath("/html/body/main/div/div[13]/div/div[2]/form/div[2]/input"));
		sub.click();
		Thread.sleep(20000);
		driver.close();
	}

}
