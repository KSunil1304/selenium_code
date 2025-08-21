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

public class Masterdata {
	WebDriver driver = null;

	@Given("naviagate to the NH_Web_portal")
	public void naviagate_to_the_nh_web_portal() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver132.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
	}

	@When("loginpage opens")
	public void loginpage_opens() {

	}

	@Then("enter emailormobile {string} password {string}")
	public void enter_emailormobile_password(String emailormobile, String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user_login")).sendKeys(emailormobile);
		driver.findElement(By.id("user_password")).sendKeys(password);

	}

	@And("click on the sign in button")
	public void click_on_the_sign_in_button() throws Exception {
		driver.findElement(By.name("commit")).click();
		Thread.sleep(1000);
	}

	@When("select a profile popup opens")
	public void select_a_profile_popup_opens() throws Exception {

	}

	@Then("select the role as clinic manager")
	public void select_the_role_as_clinic_manager() throws Exception {
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on Clinic manager Role
		driver.findElement(By.xpath("//*[@id=\"account-selection\"]/div/div[2]/a[3]/div/div/div/div[2]")).click();
		Thread.sleep(5000);
	}

	@When("dashboard opens mousehover on the reports")
	public void dashboard_opens_mousehover_on_the_reports() throws Exception {
		// hover the mouse on Reports
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Master Data']"))).click().build().perform();
		Thread.sleep(1000);
	}

	@Then("click on the master data")
	public void click_on_the_master_data() {

	}

	@When("master_data_dashboard opens")
	public void master_data_dashboard_opens() throws Exception {
		Thread.sleep(1000);
	}

	@Then("click on the facility digital twin from the masterdata")
	public void click_on_the_facility_digital_twin_from_the_masterdata() {

	}

	@And("mouse hover on to the clinic_hopsital")
	public void mouse_hover_on_to_the_clinic_hopsital() {

	}

	@Then("drag and drop to add a new clinic_hospital")
	public void drag_and_drop_to_add_a_new_clinic_hospital() throws Exception {
		WebDriverWait ht = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			ht.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]")))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(18000);
		Actions action1 = new Actions(driver);
		try {
			action1.moveToElement(driver.findElement(By.xpath("(//img[@alt='HosplIcon'])[1]"))).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(1000);
		action1.dragAndDrop(driver.findElement(By.xpath("(//img[@alt='HosplIcon'])[1]")),
				driver.findElement(By.xpath("(//div[@class='react-flow__pane'])[1]"))).build().perform();
	}

	@And("enter the details of the clinic_hospital with mouse hover actions")
	public void enter_the_details_of_the_clinic_hospital_with_mouse_hover_actions() throws Exception {
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[1]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// entering the hospital name
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[1]/following-sibling::div/input[1]"))
				.sendKeys("Cucum Hospital");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action1 = new Actions(driver);
		action1.moveToElement(
				driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[2]/span/following-sibling::img"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// selecting the facility type
		WebElement ftype = driver
				.findElement(By.xpath("(//label[@id='HospitalLabel'])[2]/following-sibling::div/select[1]"));
		Select select = new Select(ftype);
		select.selectByVisibleText("OP Only");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[3]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// entering the registration year
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[3]/following-sibling::div/input[1]"))
				.sendKeys("2013");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[4]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// entering the registration number
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[4]/following-sibling::div/input[1]"))
				.sendKeys("123456789");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action4 = new Actions(driver);
		action4.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[5]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// entering the patient id format
//		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[5]/following-sibling::div/input[1]"))
//				.sendKeys("Number");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// header image upload
		Actions action5 = new Actions(driver);
		action5.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[7]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		try {
			driver.findElement(By.cssSelector("input#fileInputH"))
					.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\NODEHEADER.png");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Actions action6 = new Actions(driver);
		action6.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[8]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// header image height
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[8]/following-sibling::div/input[1]"))
				.sendKeys("70");
		Thread.sleep(1000);

		// footer image upload
		Actions action7 = new Actions(driver);
		action7.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[9]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		try {
			driver.findElement(By.cssSelector("input#fileInputF"))
					.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\NODEFOOTER.png");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Actions action8 = new Actions(driver);
		action8.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[10]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// footer image height
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[10]/following-sibling::div/input[1]"))
				.sendKeys("30");
		Thread.sleep(2000);

		// preview
		driver.findElement(By.cssSelector("a#hospitalPBtn")).click();
		Thread.sleep(2000);

		// is day clinic
		Actions action9 = new Actions(driver);
		action9.moveToElement(driver.findElement(By.xpath("(//span[text()='Is day clinic'])[1]"))).build().perform();
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement idc = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
			idc.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

		// is active
		Actions action10 = new Actions(driver);
		action10.moveToElement(driver.findElement(By.xpath("(//span[text()='Is Active'])[1]"))).build().perform();
		Thread.sleep(1000);
		for (int i = 0; i <= 1; i++) {
			WebElement idc = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
			idc.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(2000);

	}

	@Then("add invoice pdf configuration header and footer from create new hospital")
	public void add_invoice_pdf_configuration_header_and_footer_from_create_new_hospital() throws Exception {
		// by default invoice pdf configuration header and footer from cdp level

		// removing the invoice pdf header
		driver.findElement(By.xpath("(//span[@title='Remove'])[3]")).click();
		Thread.sleep(3000);

		// removing the invoice pdf footer
		driver.findElement(By.xpath("(//span[@title='Remove'])[3]")).click();
		Thread.sleep(3000);

		// adding header & footer for invoice pdf
		// header
		driver.findElement(By.cssSelector("input#fileInputHIn"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\Androcare_header.png");
		Thread.sleep(2000);
		// changing the header height
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[12]/following-sibling::div/input[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[12]/following-sibling::div/input[1]"))
				.sendKeys("55");
		Thread.sleep(1000);

		// footer
		driver.findElement(By.cssSelector("input#fileInputFIn"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\Androcare_footer.png");
		Thread.sleep(2000);
		// changing the footer height
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[14]/following-sibling::div/input[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[14]/following-sibling::div/input[1]"))
				.sendKeys("55");
		Thread.sleep(1000);

		WebElement footertype = driver
				.findElement(By.xpath("(//label[@id='HospitalLabel'])[15]/following-sibling::div/select[1]"));
		Select footertype1 = new Select(footertype);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		footertype1.selectByVisibleText("Continuous");
		Thread.sleep(1000);

		// clicking on the preview
		driver.findElement(By.cssSelector("a#hospitalPBtn")).click();
		Thread.sleep(3000);

		Robot pagedown = new Robot();
		pagedown.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

		// mouse hovering on the Font size large icon
		Actions fzl = new Actions(driver);
		fzl.moveToElement(
				driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[16]/span/following-sibling::img[1]")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[16]/following-sibling::div/input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[16]/following-sibling::div/input[1]"))
				.sendKeys("10");
		Thread.sleep(1000);

		// mouse hovering on the Font size medium icon
		Actions fz2 = new Actions(driver);
		fz2.moveToElement(
				driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[17]/span/following-sibling::img[1]")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[17]/following-sibling::div/input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[17]/following-sibling::div/input[1]"))
				.sendKeys("10");
		Thread.sleep(1000);

		// mouse hovering on the Font size small icon
		Actions fz3 = new Actions(driver);
		fz3.moveToElement(
				driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[18]/span/following-sibling::img[1]")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[18]/following-sibling::div/input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[18]/following-sibling::div/input[1]"))
				.sendKeys("7");
		Thread.sleep(1000);

	}

	@Then("click on the submit button to create a new hospital")
	public void click_on_the_submit_button_to_create_a_new_hospital() throws Exception {
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Submit'])[1]"))))
				.click();
		Thread.sleep(10000);

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//img[@class='addphone'])[1]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@class='addphone'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the edit
		try {
			driver.findElement(By.xpath("(//button[text()='Edit'])[1]")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[23]/following-sibling::div/input[1]"))))
				.sendKeys("Test");

//		// address line1
//		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[22]/following-sibling::div/input[1]"))
//		.sendKeys("Test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// address line2
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[24]/following-sibling::div/input[1]"))
				.sendKeys("Test two");
		Thread.sleep(1000);
		// city
		WebElement city = driver
				.findElement(By.xpath("(//label[@id='HospitalLabel'])[25]/following-sibling::div/select"));
		Select hyd = new Select(city);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		hyd.selectByVisibleText("Hyderabad");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// area
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[27]/following-sibling::div/input[1]"))
				.sendKeys("Test area");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// landmark
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[28]/following-sibling::div/input"))
				.sendKeys("Test landmark");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// pincode
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[29]/following-sibling::div/input"))
				.sendKeys("667788");
		Thread.sleep(1000);
		// add location
		WebDriverWait loc = new WebDriverWait(driver, Duration.ofSeconds(30));
		loc.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[@class='convert-text'])[1]/img"))))
				.click();
		Thread.sleep(3000);
		// current location
		driver.findElement(By.xpath("(//button[text()='Current Location'])[1]")).click();
		Thread.sleep(2000);
		// add
		driver.findElement(By.xpath("(//button[text()='Add'])[1]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//div[@id='fixed_footerr'])[2]/button[2]")).click();
		Thread.sleep(2000);
		WebDriverWait submit1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Submit'])[1]"))))
				.click();
		Thread.sleep(5000);
	}

	@When("hospital is created successfully alert will come")
	public void hospital_is_created_successfully_alert_will_come() {

	}

	@Then("search the hospital from the search bar")
	public void search_the_hospital_from_the_search_bar() throws InterruptedException {
		driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum Hospital");
		Thread.sleep(2000);

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);

		// driver.findElement(By.xpath("(//option[text()='Cucum Hospital
		// (Hospital)'])[1]")).click();
		// Thread.sleep(2000);

	}

	@When("searched hospital appears on the UI")
	public void searched_hospital_appears_on_the_UI() {

	}

	@Then("double click on the hospital name and click on the edit button")
	public void double_click_on_the_hospital_name_and_click_on_the_edit_button() throws InterruptedException {
		WebElement doubleclick = driver.findElement(By.xpath("(//img[@alt='HosplIcon'])[2]"));
		Actions action = new Actions(driver);
		action.doubleClick(doubleclick).build().perform();
		Thread.sleep(3000);
		// edit
		driver.findElement(By.xpath("(//button[text()='Edit'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("add the address contact and save again")
	public void add_the_address_contact_and_save_again() throws Exception {
		// Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.xpath("(//img[@class='addphone'])[1]"))).build().perform();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//img[@class='addphone'])[1]")).click();
		// Thread.sleep(3000);
		// // clicking on the edit
		// try {
		// driver.findElement(By.xpath("(//button[text()='Edit'])[1]")).click();
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// // TODO: handle exception
		// }
		//
		// // address line1
		// driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[10]/following-sibling::div/input[1]"))
		// .sendKeys("Test");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// // address line2
		// driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[11]/following-sibling::div/input[1]"))
		// .sendKeys("Test two");
		// Thread.sleep(1000);
		// // city
		// WebElement city = driver
		// .findElement(By.xpath("(//label[@id='HospitalLabel'])[12]/following-sibling::div/select"));
		// Select hyd = new Select(city);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// hyd.selectByIndex(6);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// // area
		// driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[14]/following-sibling::div/input"))
		// .sendKeys("Test area");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// // landmark
		// driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[15]/following-sibling::div/input"))
		// .sendKeys("Test landmark");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// // pincode
		// driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[16]/following-sibling::div/input"))
		// .sendKeys("667788");
		// Thread.sleep(1000);
		// // add location
		// WebDriverWait loc = new WebDriverWait(driver, Duration.ofSeconds(30));
		// loc.until(
		// ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[@class='convert-text'])[1]/img"))))
		// .click();
		// Thread.sleep(3000);
		// // current location
		// driver.findElement(By.xpath("(//button[text()='Current
		// Location'])[1]")).click();
		// Thread.sleep(2000);
		// // add
		// driver.findElement(By.xpath("(//button[text()='Add'])[1]")).click();
		// Thread.sleep(2000);
		// // submit
		// driver.findElement(By.xpath("(//div[@id='fixed_footerr'])[2]/button[2]")).click();
		// Thread.sleep(2000);
		// ############################################################################//
		// adding contact
		driver.findElement(By.xpath("(//img[@class='addphone'])[2]")).click();
		Thread.sleep(2000);

		// add
		driver.findElement(By.xpath("(//button[text()='Add +'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("input#hospital-number")).sendKeys("789321456");
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#hospital-number")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#hospital-number")).sendKeys("7893214569");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#hospital-email")).sendKeys("hospitalw@gmail.com");
		Thread.sleep(1000);

		try {
			// save
			driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Thread.sleep(2000);
		// edit number
		driver.findElement(By.xpath("(//img[@alt='editBtn'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#hospital-number")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#hospital-number")).sendKeys("7893214560");
		Thread.sleep(3000);
		// save
		driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[text()='Close'])[3]")).click();
		Thread.sleep(2000);
		// // close
		// driver.findElement(By.xpath("(//div[@class='popClose'])[1]")).click();
		// Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//div[@id='fixed_footerr'])[1]/button[2]")).click();
		Thread.sleep(5000);
	}

	@Then("alert with the updation will appear")
	public void alert_with_the_updation_will_appear() {
	}

	@And("search the hospital and mouse hover on to the hospital")
	public void search_the_hospital_and_mouse_hover_on_to_the_hospital() throws Exception {
		driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum Hospital");
		Thread.sleep(2000);

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);

		// mouse hovering on to the hospital
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[text()='Cucum Hospital'])[1]"))).build().perform();
		Thread.sleep(3000);
	}

	@When("team details icon is visible click on it")
	public void team_details_icon_is_visible_click_on_it() throws Exception {
		Actions img = new Actions(driver);
		img.moveToElement(driver.findElement(By.xpath("(//span[@title='Team details'])[1]/img[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@title='Team details'])[1]/img[1]")).click();
		Thread.sleep(7000);
	}

	@And("team details is clicked then user details")
	public void team_details_is_clicked_then_user_details() {

	}

	@Then("add new doctor from the user details")
	public void add_new_doctor_from_the_user_details() throws Exception {
		// clicking on the add new +
		WebDriverWait add = new WebDriverWait(driver, Duration.ofSeconds(30));
		add.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[text()='add']")))).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#first_name")).sendKeys("Hospital");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#lst_name")).sendKeys("Doctor");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// gender
		WebElement male = driver.findElement(By.xpath("//label[text()='M']"));
		male.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		driver.findElement(By.cssSelector("input#age")).sendKeys("30");
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("//li[text()='+91']")).click();
		// Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#nmbr")).sendKeys("8733828282");
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='selection'])[8]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Doctor'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='select2-search__field'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='Cucum Hospital'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[1]")).click();
		Thread.sleep(1000);
		// full access
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("//label[text()='Full Access']"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// masterdata access
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Master Data Access'])"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// verified
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Verified'])"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);

		// hover the mouse on Reports
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Master Data']"))).click().build().perform();
		Thread.sleep(1000);
		WebDriverWait ht = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			ht.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[1]/a")))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(18000);

		driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum Hospital");
		Thread.sleep(2000);

		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		driver.close();

	}

	@When("doctor is added and hospital is active then hospital will be darken")
	public void doctor_is_added_and_hospital_is_active_then_hospital_will_be_darken() {

	}

	@When("the masterdata dashboard")
	public void the_masterdata_dashboard() {
	}

	@Then("click on the doctors button")
	public void click_on_the_doctors_button() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='Doctors'])[2]")).click();
		Thread.sleep(1000);
		String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
		System.out.println(md);
	}

	@When("doctor masters page open")
	public void doctor_masters_page_open() {

	}

	@Then("click on the add button to add a new doctor master")
	public void click_on_the_add_button_to_add_a_new_doctor_master() throws Exception {
		// clicking on the add new +
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(1000);
	}

	@And("enter the following details in the new doctor popup page1")
	public void enter_the_following_details_in_the_new_doctor_popup_page1(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		List<List<String>> regData = dataTable.asLists(String.class);
		driver.findElement(By.cssSelector("input#first_name")).sendKeys(regData.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#lst_name")).sendKeys(regData.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("select the gender radiobutton for the doctor")
	public void select_the_gender_radiobutton_for_the_doctor() {
		// gender
		WebElement male = driver.findElement(By.xpath("//label[text()='M']"));
		male.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("enter the following details in the doctor page6")
	public void enter_the_following_details_in_the_doctor_page6(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		List<List<String>> regData = dataTable.asLists(String.class);
		// age
		driver.findElement(By.cssSelector("input#age")).sendKeys(regData.get(0).get(1));
		Thread.sleep(1000);
	}

	@Then("selecting the country code from dropdown for doctormasters")
	public void selecting_the_country_code_from_dropdown_for_doctormasters() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[9]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//li[text()='+91']")).click();
		Thread.sleep(1000);
	}

	@Then("enter the following details in the new doctor popup page2")
	public void enter_the_following_details_in_the_new_doctor_popup_page2(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		List<List<String>> regData = dataTable.asLists(String.class);
		driver.findElement(By.cssSelector("input#nmbr")).sendKeys(regData.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.id("email")).sendKeys(regData.get(1).get(1));
		// Thread.sleep(1000);
	}

	@And("click on the continue button to add doctor role in the next popup")
	public void click_on_the_continue_button_to_add_doctor_role_in_the_next_popup() throws Exception {
		// upload picture
		driver.findElement(By.xpath("(//a[@data-tooltip='Upload Picture'])[1]/span/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#upload_img"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\doctor.png");
		Thread.sleep(2000);

		WebElement slider = driver.findElement(By.xpath("(//div[@class='cr-slider-wrap'])[1]/input[1]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, -300, 0).perform();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button#submitBtn")).click();
		Thread.sleep(2000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
				.click();
		Thread.sleep(3000);

	}

	@Then("select the role and existing hospital from the dropdown")
	public void select_the_role_and_existing_hospital_from_the_dropdown() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[10]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Doctor'])[1]")).click();
		Thread.sleep(2000);
		// WebElement existhosp = driver.findElement(By.xpath("(//label[text()='Existing
		// Hospital'])[1]"));
		// existhosp.click();
		// Thread.sleep(2000);
		// selecting the existing hospital
		driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")).click();
		Thread.sleep(1000);

		// selecting the existing hospital
		// driver.findElement(By.xpath("(//span[@class='select2-selection
		// select2-selection--multiple'])[3]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(By.xpath("(//li[text()='NH_OP'])[1]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//span[@class='select2-selection
		// select2-selection--multiple'])[3]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(By.xpath("(//li[text()='NH_IP Ward'])[1]")).click();
		// Thread.sleep(1000);
	}

	@And("upload the doctor signature")
	public void upload_the_doctor_signature() throws Exception {
		driver.findElement(By.cssSelector("input#files_sign"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\doctorsignature.png");
		Thread.sleep(1000);
	}

	@Then("clicking on the more icon to enable access checkboxes")
	public void clicking_on_the_more_icon_to_enable_access_checkboxes() throws Exception {
		// driver.findElement(By.xpath("(//img[@data-tooltip='More'])[1]")).click();
		// Thread.sleep(1000);
		//
		// JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("window.scrollBy(0,-500)", "");
		// Thread.sleep(1000);
		// // full access
		// for (int i = 0; i <= 2; i++) {
		// WebElement fa = driver.findElement(By.xpath("//label[text()='Full
		// Access']"));
		// fa.click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// }
		// Thread.sleep(1000);
		// // masterdata access
		// for (int i = 0; i <= 2; i++) {
		// WebElement fa = driver.findElement(By.xpath("(//label[text()='Master Data
		// Access'])"));
		// fa.click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// }
		// Thread.sleep(1000);
		// // verified
		// for (int i = 0; i <= 2; i++) {
		// WebElement fa = driver.findElement(By.xpath("(//label[text()='Verified'])"));
		// fa.click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// }
		// Thread.sleep(1000);
		// // qualification
		// driver.findElement(By.cssSelector("input#qualification")).sendKeys("MBBS");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// // reg number
		// driver.findElement(By.cssSelector("input#rgstrton_no")).sendKeys("12345678");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// // reg year
		// driver.findElement(By.cssSelector("input#rgstrton_yr")).sendKeys("2020");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.cssSelector("input#effctv_dt")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//div[@class='select-wrapper
		// select-year'])/input[1]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li/span[text()='2020'])[1]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		// Thread.sleep(1000);
		// Actions act1 = new Actions(driver);
		// act1.moveToElement(driver.findElement(By.xpath("(//i[@class='fa
		// fa-info-circle'])[1]"))).build().perform();
		// Thread.sleep(1000);
		// driver.findElement(By.cssSelector("input#time_sensivity")).sendKeys("5");
		// Thread.sleep(1000);
		// Actions act2 = new Actions(driver);
		// act2.moveToElement(driver.findElement(By.xpath("(//i[@class='fa
		// fa-info-circle'])[2]"))).build().perform();
		// Thread.sleep(1000);
		// driver.findElement(By.cssSelector("input#days_in_advnce")).sendKeys("5");
		// Thread.sleep(1000);
		// JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		// jse1.executeScript("window.scrollBy(0,200)", "");
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[@class='select2-search
		// select2-search--inline'])[6]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[text()='Internal
		// Medicine'])[1]")).click();
		// Thread.sleep(1000);
		// for (int i = 0; i <= 2; i++) {
		// WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS and
		// Email'])[1]"));
		// sms.click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// }
		// Thread.sleep(1000);

	}

	@Then("click on the save button from add doctor page")
	public void click_on_the_save_button_from_add_doctor_page() throws Exception {
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on the copy to clipboard button for doctormasters")
	public void click_on_the_copy_to_clipboard_button_for_doctormasters() throws Exception {
		// // clicking on the copy to clipboard
		// driver.findElement(By.cssSelector("img#copy_link_icon")).click();
		// Thread.sleep(2000);

	}

	@And("click on the add or edit consultations plus button")
	public void click_on_the_add_or_edit_consultations_plus_button() throws Exception {
		// // edit doctor
		// driver.findElement(By.cssSelector("input#q_mobile_or_email_cont")).sendKeys("7766554422");
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		// Thread.sleep(3000);
		// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		// Thread.sleep(3000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
		// .click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("(//input[@class='select2-search__field'])[1]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(By.xpath("(//li[text()='NH_IP Ward'])[1]")).click();
		// Thread.sleep(1000);
		// // save
		// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		// Thread.sleep(3000);

		// // clicking on the add/edit consultations
		// Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add/Edit
		// Consultations'])[1]/i"))).build()
		// .perform();
		// Thread.sleep(1000);
		// WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		// wait1.until(ExpectedConditions
		// .visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add/Edit
		// Consultations'])[1]/i"))))
		// .click();
		// Thread.sleep(2000);
	}

	@Then("addoredit consultations page opens")
	public void addoredit_consultations_page_opens() {

	}

	@And("click on the add icon to addconsultations for doctormaster")
	public void click_on_the_add_icon_to_addconsultations_for_doctormaster() throws Exception {
		// // clicking on the add icon
		// driver.findElement(By.cssSelector("a.btn-floating.green.right.add_fields")).click();
		// Thread.sleep(1000);

	}

	@Then("select the appointment type enter fee,slot duration1")
	public void select_the_appointment_type_enter_fee_slot_duration1() throws Exception {
		// driver.findElement(By.xpath("(//span[@class='selection'])[9]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("(//li[text()='Clinic'])[1]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.cssSelector("div#doctor_consultation_lines>div>div>div:nth-of-type(3)>div>input"))
		// .sendKeys("200");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.cssSelector("div#doctor_consultation_lines>div>div>div:nth-of-type(4)>div>input"))
		// .sendKeys("30");
		// Thread.sleep(1000);
		// // clicking on the select days
		// driver.findElement(By.xpath(
		// "/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
		// .click();
		// Thread.sleep(1000);
		// Robot mon = new Robot();
		// mon.keyPress(KeyEvent.VK_DOWN);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// mon.keyPress(KeyEvent.VK_ENTER);
		// Thread.sleep(1000);
		// for (int i = 0; i <= 0; i++) {
		// driver.findElement(By.xpath(
		// "/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
		// .sendKeys(Keys.DOWN);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// }
		// driver.findElement(By.xpath(
		// "/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
		// .sendKeys(Keys.ENTER);
		// Thread.sleep(1000);
		// for (int i = 0; i <= 1; i++) {
		// driver.findElement(By.xpath(
		// "/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
		// .sendKeys(Keys.DOWN);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// }
		// driver.findElement(By.xpath(
		// "/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
		// .sendKeys(Keys.ENTER);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		// for (int i = 0; i <= 2; i++) {
		// driver.findElement(By.xpath(
		// "/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
		// .sendKeys(Keys.DOWN);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// }
		// driver.findElement(By.xpath(
		// "/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
		// .sendKeys(Keys.ENTER);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		// for (int i = 0; i <= 3; i++) {
		// driver.findElement(By.xpath(
		// "/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
		// .sendKeys(Keys.DOWN);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// }
		// driver.findElement(By.xpath(
		// "/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
		// .sendKeys(Keys.ENTER);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		// for (int i = 0; i <= 4; i++) {
		// driver.findElement(By.xpath(
		// "/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
		// .sendKeys(Keys.DOWN);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// }
		// driver.findElement(By.xpath(
		// "/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
		// .sendKeys(Keys.ENTER);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		// for (int i = 0; i <= 5; i++) {
		// driver.findElement(By.xpath(
		// "/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
		// .sendKeys(Keys.DOWN);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// }
		// driver.findElement(By.xpath(
		// "/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
		// .sendKeys(Keys.ENTER);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		// // removing one day
		// driver.findElement(By.xpath("(//span[@class='select2-selection__choice__remove'])[1]")).click();
		// Thread.sleep(1000);
		//
		// // start time
		// driver.findElement(
		// By.xpath("/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[6]/div/input")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//div[@class='timepicker-dial
		// timepicker-hours'])[1]/div[9]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//div[@class='timepicker-dial
		// timepicker-minutes'])[1]/div[1]")).click();
		// Thread.sleep(1000);
		// // am
		// driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[1]")).click();
		// Thread.sleep(1000);
		// // ok
		// driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
		// Thread.sleep(1000);
		//
		// // end time
		// driver.findElement(
		// By.xpath("/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[7]/div/input")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//div[@class='timepicker-dial
		// timepicker-hours'])[1]/div[11]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//div[@class='timepicker-dial
		// timepicker-minutes'])[2]/div[1]")).click();
		// Thread.sleep(1000);
		// // am
		// driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[2]/div[2]")).click();
		// Thread.sleep(1000);
		// // ok
		// driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[2]/button[2]")).click();
		// Thread.sleep(1000);
		//
		// Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_CONTROL);
		// Thread.sleep(1000);
		// for (int i = 0; i <= 1; i++) {
		// robot.keyPress(KeyEvent.VK_SUBTRACT);
		// Thread.sleep(1000);
		// }
		// for (int i = 0; i <= 1; i++) {
		// robot.keyRelease(KeyEvent.VK_SUBTRACT);
		// Thread.sleep(1000);
		// }
		// robot.keyRelease(KeyEvent.VK_CONTROL);
		// Thread.sleep(1000);

	}

	@And("click on the add icon again to addconsultations for doctormaster")
	public void click_on_the_add_icon_again_to_addconsultations_for_doctormaster() throws Exception {
		// // clicking on the add icon again
		// driver.findElement(By.cssSelector("a.btn-floating.green.right.add_fields")).click();
		// Thread.sleep(1000);
		// // slot duration
		// driver.findElement(By.xpath("(//input[@class='active
		// form_inputF'])[2]")).sendKeys(Keys.PAGE_DOWN);
		// Thread.sleep(1000);
	}

	@Then("select the appointment type enter fee,slot duration2")
	public void select_the_appointment_type_enter_fee_slot_duration2() throws Exception {
		// driver.findElement(By.xpath("(//span[@class='selection'])[11]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("//li[text()='Video']")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("(//div[@id='doctor_consultation_lines'])[1]/div[2]/div[1]/div[3]/div/input"))
		// .sendKeys("200");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("(//div[@id='doctor_consultation_lines'])[1]/div[2]/div[1]/div[4]/div/input"))
		// .sendKeys("30");
		// Thread.sleep(1000);
	}

	@And("remove the last added consultation for doctormaster")
	public void remove_the_last_added_consultation_for_doctormaster() throws Exception {
		// // removing last added
		// driver.findElement(By.xpath("(//a[@class='right remove_fields
		// dynamic'])[2]/i")).click();
		// Thread.sleep(1000);
	}

	@Then("click on the save button from doctor consultations")
	public void click_on_the_save_button_from_doctor_consultations() throws Exception {
		// // saving
		// driver.findElement(By.xpath("//input[@value='Save']")).click();
		// Thread.sleep(5000);
	}

	@And("clicking on the sharecredentials button and click on confirm for doctormaster")
	public void clicking_on_the_sharecredentials_button_and_click_on_confirm_for_doctormaster() throws Exception {
		// share-credentials
		Actions sc = new Actions(driver);
		sc.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Share Credentials'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Credentials'])[1]/img[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Confirm!']")).click();
		Thread.sleep(3000);

		// edit doctor
		driver.findElement(By.xpath("(//a[@data-tooltip='Edit Doctor'])[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#nmbr")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#nmbr")).sendKeys("7766554423");
		Thread.sleep(3000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
				.click();
		Thread.sleep(3000);
		// adding more details of the doctor
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[1]")).click();
		Thread.sleep(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(1000);
		// full access
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("//label[text()='Full Access']"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// masterdata access
		for (int i = 0; i <= 3; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Master Data Access'])"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// verified
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Verified'])"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// qualification
		driver.findElement(By.cssSelector("input#qualification")).sendKeys("MBBS");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// reg number
		driver.findElement(By.cssSelector("input#rgstrton_no")).sendKeys("12345678");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// reg year
		driver.findElement(By.cssSelector("input#rgstrton_yr")).sendKeys("2020");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#effctv_dt")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='select-wrapper select-year'])/input[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li/span[text()='2020'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		Thread.sleep(1000);
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-info-circle'])[1]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#time_sensivity")).sendKeys("5");
		Thread.sleep(1000);
		Actions act2 = new Actions(driver);
		act2.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-info-circle'])[2]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#days_in_advnce")).sendKeys("5");
		Thread.sleep(1000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[@class='select2-search select2-search--inline'])[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Internal Medicine'])[1]")).click();
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS and Email'])[1]"));
			sms.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);

		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);

		// adding availability
		Actions ava = new Actions(driver);
		ava.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Availability'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Availability'])[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[@class='selection'])[9]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Clinic'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("div#doctor_consultation_lines>div>div>div:nth-of-type(3)>div>input"))
				.sendKeys("200");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("div#doctor_consultation_lines>div>div>div:nth-of-type(4)>div>input"))
				.sendKeys("30");
		Thread.sleep(1000);
		// clicking on the select days
		driver.findElement(By.xpath(
				"/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
				.click();
		Thread.sleep(1000);
		Robot mon = new Robot();
		mon.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		mon.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		for (int i = 0; i <= 0; i++) {
			driver.findElement(By.xpath(
					"/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
					.sendKeys(Keys.DOWN);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.findElement(By.xpath(
				"/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.xpath(
					"/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
					.sendKeys(Keys.DOWN);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.findElement(By.xpath(
				"/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
				.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			driver.findElement(By.xpath(
					"/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
					.sendKeys(Keys.DOWN);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.findElement(By.xpath(
				"/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
				.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		for (int i = 0; i <= 3; i++) {
			driver.findElement(By.xpath(
					"/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
					.sendKeys(Keys.DOWN);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.findElement(By.xpath(
				"/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
				.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		for (int i = 0; i <= 4; i++) {
			driver.findElement(By.xpath(
					"/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
					.sendKeys(Keys.DOWN);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.findElement(By.xpath(
				"/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
				.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		for (int i = 0; i <= 5; i++) {
			driver.findElement(By.xpath(
					"/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
					.sendKeys(Keys.DOWN);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.findElement(By.xpath(
				"/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[5]/div/span/span[1]/span/ul/li/input"))
				.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		// removing one day
		driver.findElement(By.xpath("(//span[@class='select2-selection__choice__remove'])[1]")).click();
		Thread.sleep(1000);

		// start time
		driver.findElement(
				By.xpath("/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[6]/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[9]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[1]/div[1]")).click();
		Thread.sleep(1000);
		// am
		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[1]")).click();
		Thread.sleep(1000);
		// ok
		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
		Thread.sleep(1000);

		// end time
		driver.findElement(
				By.xpath("/html/body/main/div/div[8]/div/div[2]/form/div[2]/div[1]/div/div/div[7]/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[11]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[2]/div[1]")).click();
		Thread.sleep(1000);
		// am
		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[2]/div[2]")).click();
		Thread.sleep(1000);
		// ok
		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[2]/button[2]")).click();
		Thread.sleep(1000);

		// save
		driver.findElement(By.xpath("(//input[@id='saveBtn'])[1]")).click();
		Thread.sleep(10000);

		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		for (int i = 0; i <= 1; i++) {
			robot1.keyPress(KeyEvent.VK_SUBTRACT);
			Thread.sleep(1000);
		}
		for (int i = 0; i <= 1; i++) {
			robot1.keyRelease(KeyEvent.VK_SUBTRACT);
			Thread.sleep(1000);
		}
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
//		Actions profile = new Actions(driver);
//		profile.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Profile Download'])[1]/img[1]"))).build()
//				.perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Profile Download'])[1]/img[1]")).click();
//		Thread.sleep(3000);
//		// navigate to
//		driver.navigate().to("https://customer.nanohealthplan.com/user_role_details");
//		Thread.sleep(2000);
	}

	@Then("download the doctor profile")
	public void download_the_doctor_profile() throws Exception {

	}

	@Then("search the recent added doctor using search field")
	public void search_the_recent_added_doctor_using_search_field() throws Exception {
		// navigate to
		driver.navigate().to("https://customer.nanohealthplan.com/user_role_details");
		Thread.sleep(2000);
		// searching with mobile
		driver.findElement(By.cssSelector("input#q_mobile_or_email_cont")).sendKeys("7766554423");
		Thread.sleep(1000);
		// search
		WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(3000);
		// clicking on the doctor
		driver.findElement(By.xpath("(//a[@class='user_role_name'])[1]")).click();
		Thread.sleep(3000);
		// availability
		driver.findElement(By.xpath("(//a[text()='Availability'])[1]")).click();
		Thread.sleep(2000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_SUBTRACT);
//		Thread.sleep(1000);
//		robot.keyRelease(KeyEvent.VK_SUBTRACT);
//		Thread.sleep(1000);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(1000);

		// selecting nh_ipward
		WebElement hos = driver.findElement(By.xpath("(//select[@id='hospital_master_id'])[1]"));
		Select hosp = new Select(hos);
		hosp.selectByVisibleText("NanoHealth_IPD");
		Thread.sleep(1000);
		// add
		try {
			driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Video'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='active form_inputF'])[1]")).sendKeys("200");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@class='active form_inputF'])[2]")).sendKeys("30");
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).sendKeys(Keys.PAGE_DOWN);
		// Thread.sleep(1000);

		// clicking on the select days
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		Thread.sleep(1000);
		Robot mon = new Robot();
//		mon.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
//		mon.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
//		Thread.sleep(1000);
//		mon.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
//		mon.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);

		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Monday'])[1]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Tuesday'])[1]")).click();
		Thread.sleep(1000);

		// removing one day
		driver.findElement(By.xpath("(//span[@class='select2-selection__choice__remove'])[2]")).click();
		Thread.sleep(1000);

		// available start time
		driver.findElement(By.xpath("(//input[@class='pick-time'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[9]")).click();
		Thread.sleep(1000);
		// mins
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[1]/div[1]")).click();
		Thread.sleep(1000);
		// am
		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[1]")).click();
		Thread.sleep(1000);
		// ok
		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
		Thread.sleep(1000);

		// end time
		driver.findElement(By.xpath("(//input[@class='pick-time'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[10]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[2]/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[2]/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[2]/button[2]")).click();
		Thread.sleep(1000);

		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the doctor
		try {
			driver.findElement(By.xpath("(//a[@class='user_role_name'])[1]")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// availability
		driver.findElement(By.xpath("(//a[text()='Availability'])[1]")).click();
		Thread.sleep(2000);
		// close
		driver.findElement(By.cssSelector("div#doctor-apmnt-modal>div>div>span>i")).click();
		Thread.sleep(2000);
		// clicking on the doctor
		driver.findElement(By.xpath("(//a[@class='user_role_name'])[1]")).click();
		Thread.sleep(3000);
		// availability
		driver.findElement(By.xpath("(//a[text()='Availability'])[1]")).click();
		Thread.sleep(2000);
		WebElement hospita2 = driver.findElement(By.id("hospital_master_id"));
		Select hos11 = new Select(hospita2);
		hos11.selectByVisibleText("NanoHealth_IPD");
		Thread.sleep(3000);
		// close
		driver.findElement(By.cssSelector("div#doctor-apmnt-modal>div>div>span>i")).click();
		Thread.sleep(2000);
		// WebElement hospital = driver.findElement(By.id("hospital_master_id"));
		// Select hos1 = new Select(hospital);
		// hos1.selectByVisibleText("NH_IP Ward");
		// Thread.sleep(3000);
		// // add
		// driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		// Thread.sleep(3000);
		// driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[text()='Video'])[1]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//input[@class='active
		// form_inputF'])[1]")).sendKeys("500");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("(//input[@class='active
		// form_inputF'])[2]")).sendKeys("60");
		// Thread.sleep(1000);
		//
		// driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		// Thread.sleep(1000);
		//
		// Robot mon1 = new Robot();
		// mon1.keyPress(KeyEvent.VK_DOWN);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// mon1.keyPress(KeyEvent.VK_ENTER);
		// Thread.sleep(1000);
		//
		// driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		// mon1.keyPress(KeyEvent.VK_DOWN);
		// Thread.sleep(1000);
		// mon1.keyPress(KeyEvent.VK_ENTER);
		// Thread.sleep(1000);
		//
		// driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		// for (int i = 0; i <= 1; i++) {
		// mon1.keyPress(KeyEvent.VK_DOWN);
		// Thread.sleep(1000);
		// }
		// mon1.keyPress(KeyEvent.VK_ENTER);
		// Thread.sleep(1000);
		//
		// driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		// for (int i = 0; i <= 2; i++) {
		// mon1.keyPress(KeyEvent.VK_DOWN);
		// Thread.sleep(1000);
		// }
		// mon1.keyPress(KeyEvent.VK_ENTER);
		// Thread.sleep(1000);
		//
		// // removing one day
		// driver.findElement(By.xpath("(//span[@class='select2-selection__choice__remove'])[1]")).click();
		// Thread.sleep(1000);
		//
		// // available start time
		// driver.findElement(By.xpath("(//input[@class='pick-time'])[1]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//div[@class='timepicker-dial
		// timepicker-hours'])[1]/div[9]")).click();
		// Thread.sleep(1000);
		// // mins
		// driver.findElement(By.xpath("(//div[@class='timepicker-dial
		// timepicker-minutes'])[1]/div[1]")).click();
		// Thread.sleep(1000);
		// // am
		// driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[1]")).click();
		// Thread.sleep(1000);
		// // ok
		// driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
		// Thread.sleep(1000);
		//
		// // end time
		// driver.findElement(By.xpath("(//input[@class='pick-time'])[2]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//div[@class='timepicker-dial
		// timepicker-hours'])[1]/div[10]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//div[@class='timepicker-dial
		// timepicker-minutes'])[2]/div[1]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[2]/div[2]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[2]/button[2]")).click();
		// Thread.sleep(1000);

		// // save
		// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		// Thread.sleep(3000);
		// // clicking on the doctor
		// driver.findElement(By.xpath("(//a[@class='user_role_name'])[1]")).click();
		// Thread.sleep(3000);
		// // availability
		// driver.findElement(By.xpath("(//a[text()='Availability'])[1]")).click();
		// Thread.sleep(2000);

	}

	@And("navigate to the masterdata dashboard from doctormasters")
	public void navigate_to_the_masterdata_dashboard_from_doctormasters() throws Exception {
		// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		Thread.sleep(1000);
		driver.close();
	}

	@When("the masterdata dashboard is opened")
	public void the_masterdata_dashboard_is_opened() throws Exception {
		Thread.sleep(2000);
	}

	@Then("click on the userdetails button")
	public void click_on_the_userdetails_button() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='User Details'])[1]")).click();
		Thread.sleep(1000);
		String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
		System.out.println(md);
	}

	@When("userdetails page open")
	public void userdetails_page_open() {
	}

	@Then("click on the add button to add a new dietician master")
	public void click_on_the_add_button_to_add_a_new_dietician_master() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New User'])[1]/i")).click();
		Thread.sleep(3000);
	}

	@And("enter the details of the dietitian")
	public void enter_the_details_of_the_dietitian() throws Exception {
		driver.findElement(By.cssSelector("input#first_name")).sendKeys("Cucumber");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#lst_name")).sendKeys("Dietitian");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement male = driver.findElement(By.xpath("(//label[text()='M'])[1]"));
		male.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#age")).sendKeys("56");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='+91'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#nmbr")).sendKeys("7788992222");
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		// continue
		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("select the role and hospital from the creation page")
	public void select_the_role_and_hospital_from_the_creation_page() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[8]")).click();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Dietitian'])[1]"))))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[1]")).click();
		Thread.sleep(1000);
		// full access
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("//label[text()='Full Access']"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// masterdata access
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Master Data Access'])"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// verified
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Verified'])"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);

	}

	@And("click on the save button from add dietician page")
	public void click_on_the_save_button_from_add_dietician_page() throws Exception {
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on the edit button for newly created dietician")
	public void click_on_the_edit_button_for_newly_created_dietician() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]"))))
				.click();
	}

	@And("edit the phonenumber click on save button for dietician")
	public void edit_the_phonenumber_click_on_save_button_for_dietician() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#nmbr")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("input#nmbr")).sendKeys("7788992232");
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		// continue
		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		Thread.sleep(3000);

		// clicking on the save button
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("click on the dietitian role name and add availability")
	public void click_on_the_dietitian_role_name_and_add_availability() throws Exception {
		// searching with mobile
		driver.findElement(By.cssSelector("input#q_mobile_or_email_cont")).sendKeys("7788992232");
		Thread.sleep(1000);
		// search
		WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(3000);
		// clicking on the dietitian
		driver.findElement(By.xpath("(//a[@class='user_role_name'])[1]")).click();
		Thread.sleep(3000);

		String parentwindow = driver.getWindowHandle();
		// availability
		driver.findElement(By.xpath("(//a[text()='Availability'])[1]")).click();
		Thread.sleep(2000);
		// JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		// jse5.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);

		// add
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Video'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='active form_inputF'])[1]")).sendKeys("500");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@class='active form_inputF'])[2]")).sendKeys("60");
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		Thread.sleep(1000);

		Robot mon1 = new Robot();
		mon1.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		mon1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		mon1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		mon1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		for (int i = 0; i <= 1; i++) {
			mon1.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
		}
		mon1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		for (int i = 0; i <= 2; i++) {
			mon1.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
		}
		mon1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		// removing one day
		driver.findElement(By.xpath("(//span[@class='select2-selection__choice__remove'])[1]")).click();
		Thread.sleep(1000);

		// available start time
		driver.findElement(By.xpath("(//input[@class='pick-time'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[9]")).click();
		Thread.sleep(1000);
		// mins
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[1]/div[1]")).click();
		Thread.sleep(1000);
		// am
		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[1]")).click();
		Thread.sleep(1000);
		// // ok
		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
		Thread.sleep(1000);
		//
		// // end time
		driver.findElement(By.xpath("(//input[@class='pick-time'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-hours'])[1]/div[10]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[2]/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[2]/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[2]/button[2]")).click();
		Thread.sleep(1000);

		// // save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
		// // clicking on the doctor
		driver.findElement(By.xpath("(//a[@class='user_role_name'])[1]")).click();
		Thread.sleep(3000);
		// // availability
		driver.findElement(By.xpath("(//a[text()='Availability'])[1]")).click();
		Thread.sleep(2000);
		// close
		driver.findElement(By.xpath("(//span[@class='modal-close nh_close btn-floating'])[2]/i[1]")).click();
		Thread.sleep(2000);

	}

	@And("click on the add available time to addconsultations for dietician")
	public void click_on_the_add_available_time_to_addconsultations_for_dietician() throws Exception {
		//
	}

	// @Then("select the appointment type enter fee,slot duration1 for dietician")
	// public void
	// select_the_appointment_type_enter_fee_slot_duration1_for_dietician() {
	// driver.findElement(By.cssSelector("div.nested-fields>div>div:nth-of-type(1)>div>span:nth-of-type(1)")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("//li[text()='Clinic']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("(//div[@id='dietician_consultation_lines'])[1]/div/div/div[2]/div/input"))
	// .sendKeys("200");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("(//div[@id='dietician_consultation_lines'])[1]/div/div/div[3]/div/input"))
	// .sendKeys("30");
	// }
	//
	// @And("click on the add icon again to addconsultations for dietician")
	// public void click_on_the_add_icon_again_to_addconsultations_for_dietician()
	// throws Exception {
	// // clicking on the add icon again
	// driver.findElement(By.cssSelector("a.btn-floating.green.right.add_fields")).click();
	// Thread.sleep(1000);
	// }

	@Then("select the appointment type_days_slot_timings for dietician")
	public void select_the_appointment_type_days_slot_timings_for_dietician() throws Exception {

	}

	// @And("remove the last added consultation for dietician")
	// public void remove_the_last_added_consultation_for_dietician() throws
	// Exception {
	// // removing last added
	// driver.findElement(By.xpath("(//a[@class='right remove_fields
	// dynamic'])[2]/i")).click();
	// Thread.sleep(1000);
	// }

	@Then("click on the save button from dietician consultations")
	public void click_on_the_save_button_from_dietician_consultations() throws Exception {
		// // saving
		// driver.findElement(By.xpath("//input[@value='Save']")).click();
		// Thread.sleep(2000);
		// driver.findElement(
		// By.cssSelector("a.btn-floating.btn-large.waves-effect.waves-light.red.user_card_rmv>i:nth-of-type(1)"))
		// .click();
		// Thread.sleep(1000);
	}

	@And("clicking on the sharecredentials button and click on confirm for dietician")
	public void clicking_on_the_sharecredentials_button_and_click_on_confirm_for_dietician() throws Exception {
		// share-credentials
		driver.findElement(By.cssSelector("a.share_crdls.tooltipped>img:nth-of-type(1)")).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//button[text()='Confirm!']")).click();
		// Thread.sleep(5000);
		// clicking on the create password
		WebElement pswd = driver.findElement(By.xpath("(//label[text()='Create Password'])[1]"));
		pswd.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='user_password'])[1]")).sendKeys("1234567");
		Thread.sleep(2000);
		// share
		driver.findElement(By.xpath("(//input[@value='Share'])[1]")).click();
		Thread.sleep(3000);

		// clicking on the automatic generate password
		WebElement pswd1 = driver.findElement(By.xpath("(//label[text()='Automatically generate a password'])[1]"));
		pswd1.click();
		Thread.sleep(2000);
		// share
		driver.findElement(By.xpath("(//input[@value='Share'])[1]")).click();
		Thread.sleep(5000);
		driver.close();
	}

	@Then("search the recent added dietician using search field")
	public void search_the_recent_added_dietician_using_search_field() throws Exception {
		// // searching with the dietician last name
		// driver.findElement(By.cssSelector("input#q_frst_nm_or_lst_nm_cont")).sendKeys("Cucumber");
		// Thread.sleep(1000);
		// // search
		// driver.findElement(By.xpath("//input[@name='commit']")).click();
		// Thread.sleep(1000);
		// // reset
		// driver.findElement(By.xpath("//a[text()='Reset']")).click();
		// Thread.sleep(2000);
	}

	@When("the masterdata dashboard opened")
	public void the_masterdata_dashboard_opened() {
	}

	@Then("click on the digital twin from masterdata dashboard")
	public void click_on_the_digital_twin_from_masterdata_dashboard() throws Exception {
		WebDriverWait ht = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			ht.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]")))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(18000);
	}

	@And("drag and drop to create a new pharmacy")
	public void drag_and_drop_to_create_a_new_pharmacy() throws Exception {

		Actions action1 = new Actions(driver);
		try {
			action1.moveToElement(driver.findElement(By.xpath("(//img[@alt='PharmaIcon'])[1]"))).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(1000);
		action1.dragAndDrop(driver.findElement(By.xpath("(//img[@alt='PharmaIcon'])[1]")),
				driver.findElement(By.xpath("(//div[@class='react-flow__pane'])[1]"))).build().perform();
	}

	@When("add pharmacy popup opens enter the following details")
	public void add_pharmacy_popup_opens_enter_the_following_details() {

	}

	@And("enter the details in the create new pharmacy popup")
	public void enter_the_details_in_the_create_new_pharmacy_popup() throws Exception {
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[1]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Pharmacy name
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[1]/following-sibling::div/input"))
				.sendKeys("Cucum Pharmacy");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[2]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Pharmacy license code
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[2]/following-sibling::div/input"))
				.sendKeys("12345678910");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[3]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// GST Number
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[3]/following-sibling::div/input"))
				.sendKeys("22AAAAA0000A1Z5");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action4 = new Actions(driver);
		action4.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[4]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Pharmacy header image
		driver.findElement(By.cssSelector("input#fileInputH"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\pharmacyheader.png");
		Thread.sleep(1000);
		Actions action5 = new Actions(driver);
		action5.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[5]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Pharmacy header image height
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[5]/following-sibling::div/input")).sendKeys("70");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action6 = new Actions(driver);
		action6.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[6]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Pharmacy footer image
		driver.findElement(By.cssSelector("input#fileInputF"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\pharmacyfooter.png");
		Thread.sleep(1000);
		Actions action7 = new Actions(driver);
		action7.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[7]/img[1]"))).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Pharmacy footer image height
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[7]/following-sibling::div/input")).sendKeys("20");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// preview
		driver.findElement(By.cssSelector("a#hospitalPBtn")).click();
		Thread.sleep(2000);
		Actions action8 = new Actions(driver);
		action8.moveToElement(driver.findElement(By.xpath("(//span[text()='Is retailer'])[1]"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			// is retailer
			WebElement isret = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
			isret.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

		Actions action9 = new Actions(driver);
		action9.moveToElement(driver.findElement(By.xpath("(//span[text()='Is Active'])[1]"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			// is active
			WebElement isact = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
			isact.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

		Actions action10 = new Actions(driver);
		action10.moveToElement(driver.findElement(By.xpath("(//span[text()='Is distributor'])[1]"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			// is distributor
			WebElement isdist = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
			isdist.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(2000);
	}

	@Then("click on the submit button from the create new pharmacy popup")
	public void click_on_the_submit_button_from_the_create_new_pharmacy_popup() throws Exception {
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Submit'])[1]"))))
				.click();
		Thread.sleep(10000);

//		String toast = driver.findElement(By.xpath("(//div[@class='Toastify__toast-body'])[1]/div[2]")).getText();
//
//		String expected_toast = "Cucum Pharmacy (pharmacy) created.";
//
//		Assert.assertEquals(toast, expected_toast);
//
//		Assert.assertTrue(toast.contains("Cucum Pharmacy (pharmacy) created."));
//
//		System.out.println("Toast message for creation verification is done:-" + toast);
	}

	@And("add the address for pharmacy and save the pharmacy")
	public void add_the_address_for_pharmacy_and_save_the_pharmacy() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//img[@class='addphone'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@class='addphone'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[8]/following-sibling::div/input[1]"))
				.sendKeys("Test line1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[9]/following-sibling::div/input[1]"))
				.sendKeys("Test line2");
		Thread.sleep(1000);
		// city
		WebElement city = driver
				.findElement(By.xpath("(//label[@id='HospitalLabel'])[10]/following-sibling::div/select"));
		Select hyd = new Select(city);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		hyd.selectByIndex(6);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// area
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[12]/following-sibling::div/input"))
				.sendKeys("Test area");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// landmark
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[13]/following-sibling::div/input"))
				.sendKeys("Test landmark");
		Thread.sleep(2000);
		// clicking on the save button
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Save'])[1]"))))
				.click();
		Thread.sleep(3000);
		// entering the pincode
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[14]/following-sibling::div/input"))
				.sendKeys("556677");
		Thread.sleep(2000);
		// clicking on the save button
		WebDriverWait save1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		save1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Save'])[1]"))))
				.click();
		Thread.sleep(2000);

		WebDriverWait submit1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Submit'])[1]"))))
				.click();
		Thread.sleep(10000);
	}

	@And("search and click on the pharmacy from the search box")
	public void search_and_click_on_the_pharmacy_from_the_search_box() {
	}

	@Then("double click on the pharmacy to edit")
	public void double_click_on_the_pharmacy_to_edit() throws Exception {
		WebElement doubleclick = driver.findElement(By.xpath("(//div[text()='Cucum Pharmacy'])[1]"));
		Actions action = new Actions(driver);
		action.doubleClick(doubleclick).build().perform();
		Thread.sleep(5000);
		// edit
		driver.findElement(By.xpath("(//button[text()='Edit'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("edit the pharmacy and add address for the pharmacy")
	public void edit_the_pharmacy_and_add_address_for_the_pharmacy() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@id='rightCornerPA'])[1]/span[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@id='rightCornerPA'])[1]/span[1]/img[1]")).click();
		Thread.sleep(2000);
		// edit
		driver.findElement(By.xpath("(//button[text()='Edit'])[1]")).click();
		Thread.sleep(2000);
		// address line1
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[8]/following-sibling::div/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[8]/following-sibling::div/input"))
				.sendKeys("Testaddressline1");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// address line2
//		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[9]/following-sibling::div/input"))
//				.sendKeys("Test two");
//		Thread.sleep(1000);
//		WebElement city = driver
//				.findElement(By.xpath("(//label[@id='HospitalLabel'])[10]/following-sibling::div/select[1]"));
//		Select select = new Select(city);
//		Thread.sleep(1000);
//		select.selectByVisibleText("Sircilla");
//		Thread.sleep(1000);
//		// area
//		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[12]/following-sibling::div/input"))
//				.sendKeys("Test area");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// landmark
//		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[13]/following-sibling::div/input"))
//				.sendKeys("Test landmark");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// pincode
//		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[14]/following-sibling::div/input"))
//				.sendKeys("876543");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='convert-text'])[1]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#pac-input")).sendKeys("Ameerpet metro");
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Add'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on the submit button from the pharmacy address popup")
	public void click_on_the_submit_button_from_the_pharmacy_address_popup() throws Exception {
		// submit from add address for pharmacy popup
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/button[2]")).click();
		Thread.sleep(2000);
//		String toast = driver.findElement(By.xpath("(//div[@class='Toastify__toast-body'])[1]/div[2]")).getText();
//
//		String expected_toast = "Address added.";
//
//		Assert.assertEquals(toast, expected_toast);
//
//		Assert.assertTrue(toast.contains("Address added."));
//
//		System.out.println("Toast message for adding address verification is done:-" + toast);
//		Thread.sleep(2000);
	}

	@And("click on the submit button from the pharmacy popup")
	public void click_on_the_submit_button_from_the_pharmacy_popup() throws Exception {
		// adding number for the pharmacy
		// adding contact
		driver.findElement(By.xpath("(//img[@class='addphone'])[2]")).click();
		Thread.sleep(2000);

		// add
		driver.findElement(By.xpath("(//button[text()='Add +'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("input#hospital-number")).sendKeys("789321453");
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#hospital-number")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#hospital-number")).sendKeys("7893214521");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#hospital-email")).sendKeys("pharmacye@gmail.com");
		Thread.sleep(1000);

		try {
			// save
			driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Thread.sleep(2000);
		// edit number
		driver.findElement(By.xpath("(//img[@alt='editBtn'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#hospital-number")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#hospital-number")).sendKeys("7893214561");
		Thread.sleep(3000);
		// save
		driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[text()='Close'])[3]")).click();
		Thread.sleep(2000);
		// // close
		// driver.findElement(By.xpath("(//div[@class='popClose'])[1]")).click();
		// Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//div[@id='fixed_footerr'])[1]/button[2]")).click();
		Thread.sleep(5000);

//		// submit from the pharmacy popup
//		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
//		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Submit'])[1]"))))
//				.click();
//		Thread.sleep(3000);
	}

	@Then("connect this created pharmacy with the cucum hospital")
	public void connect_this_created_pharmacy_with_the_cucum_hospital() throws Exception {
		driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum Hospital");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);

		// mouse hover to the dot above of the hospital name
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@data-handleid='a'])[1]"))).build().perform();
		Thread.sleep(2000);

		List<WebElement> lastpharm = driver.findElements(By.xpath(
				"(//div[@class='react-flow__handle react-flow__handle-bottom nodrag nopan target connectable connectablestart connectableend connectionindicator'])"));
		WebElement lastpharm1 = lastpharm.get(lastpharm.size() - 1);

		Actions action1 = new Actions(driver);
		action1.dragAndDrop(driver.findElement(By.xpath("(//div[@data-handleid='a'])[1]")), lastpharm1).build()
				.perform();
		Thread.sleep(2000);
		// no
		driver.findElement(By.xpath("(//button[text()='No'])[1]")).click();
		Thread.sleep(2000);

		List<WebElement> lastpharmm = driver.findElements(By.xpath(
				"(//div[@class='react-flow__handle react-flow__handle-bottom nodrag nopan target connectable connectablestart connectableend connectionindicator'])"));
		WebElement lastpharm2 = lastpharmm.get(lastpharm.size() - 1);

		// connecting pharmacy to the hospital
		Actions connection = new Actions(driver);
		connection.dragAndDrop(driver.findElement(By.xpath("(//div[@data-handleid='a'])[1]")), lastpharm2).build()
				.perform();
		Thread.sleep(2000);

		// yes
		driver.findElement(By.xpath("(//button[text()='Yes'])[1]")).click();
		Thread.sleep(3000);

//		String toast = driver.findElement(By.xpath("(//div[@class='Toastify__toast-body'])[1]/div[2]")).getText();
//
//		String expected_toast = "Cucum Pharmacy is connected to Cucum Hospital.";
//
//		Assert.assertEquals(toast, expected_toast);
//
//		Assert.assertTrue(toast.contains("Cucum Pharmacy is connected to Cucum Hospital."));
//
//		System.out.println("Toast message for connection verification is done:-" + toast);

	}

	private WebElement lastpharm1() {
		// TODO Auto-generated method stub
		return null;
	}

	@And("add pharmacist user using created pharmacy from hospital digital twin")
	public void add_pharmacist_user_using_created_pharmacy_from_hospital_digital_twin() throws Exception {
		Actions pharm = new Actions(driver);
		pharm.moveToElement(driver.findElement(By.xpath("(//div[text()='Cucum Pharmacy'])[1]"))).build().perform();
		Thread.sleep(2000);
		pharm.moveToElement(
				driver.findElement(By.xpath("(//span[@title='Add Pharmacist/Technician/Manager'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@title='Add Pharmacist/Technician/Manager'])[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New User'])[1]/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#first_name")).sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#lst_name")).sendKeys("Pharmacist");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement male = driver.findElement(By.xpath("(//label[text()='M'])[1]"));
		male.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#age")).sendKeys("30");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#email")).sendKeys("cucumpharm@gmail.com");
		Thread.sleep(2000);
		Robot tab = new Robot();
		tab.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='selection'])[8]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Pharmacist'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucum Pharmacy'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(5000);
		driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		Thread.sleep(2000);
		WebDriverWait ht = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			ht.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[1]/a")))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(18000);
	}

	@And("disconnect the pharmacy with the hospital")
	public void disconnect_the_pharmacy_with_the_hospital() throws Exception {
		driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum Hospital");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// zoom in
		driver.findElement(By.xpath("(//button[@class='react-flow__controls-button react-flow__controls-zoomin'])[1]"))
				.click();
		Thread.sleep(1000);

		// disconnect
		Actions discon = new Actions(driver);
		discon.moveToElement(driver.findElement(By.xpath("(//span[@title='Disconnect'])[1]/button"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@title='Disconnect'])[1]/button")).click();
		Thread.sleep(1000);
		// yes
		driver.findElement(By.xpath("(//button[text()='Yes'])[1]")).click();
		Thread.sleep(3000);
//		String toast = driver.findElement(By.xpath("(//div[@class='Toastify__toast-body'])[1]/div[2]")).getText();
//
//		String expected_toast = "Cucum Pharmacy disconnected from Cucum Hospital.";
//
//		Assert.assertEquals(toast, expected_toast);
//
//		Assert.assertTrue(toast.contains("Cucum Pharmacy disconnected from Cucum Hospital."));
//
//		System.out.println("Toast message for disconnection verification is done:-" + toast);

		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum Hospital");
		Thread.sleep(2000);
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		WebElement element1 = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element1);
		Thread.sleep(3000);
		driver.close();
		// String toast1 =
		// driver.findElement(By.xpath("(//div[@class='Toastify__toast-body'])[1]/div[2]")).getText();
		// System.out.println(toast1);
	}

	@Then("click on facility digital_twin from the masterdata")
	public void click_on_facility_digital_twin_from_the_masterdata() throws Exception {
		WebDriverWait fdt = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			fdt.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("(//a[text()='Facility Digital Twin'])[1]")))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(15000);
	}

	@And("drag and drop the lab to create a new lab")
	public void drag_and_drop_the_lab_to_create_a_new_lab() throws Exception {
		Actions action1 = new Actions(driver);
		try {
			action1.moveToElement(driver.findElement(By.xpath("(//img[@alt='LabIcon'])[1]"))).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(1000);
		action1.dragAndDrop(driver.findElement(By.xpath("(//img[@alt='LabIcon'])[1]")),
				driver.findElement(By.xpath("(//div[@class='react-flow__pane'])[1]"))).build().perform();

	}

	@Then("enter the necessary details for the lab creation")
	public void enter_the_necessary_details_for_the_lab_creation() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// Lab name
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[1]/following-sibling::div/input"))
				.sendKeys("Cucum lab");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[2]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// lab header image
		driver.findElement(By.cssSelector("input#fileInputH"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\labheader.png");
		Thread.sleep(1000);
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[3]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// lab header image height
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[3]/following-sibling::div/input")).sendKeys("70");
		Thread.sleep(1000);
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[4]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// lab footer image
		driver.findElement(By.cssSelector("input#fileInputF"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\labfooter.png");
		Thread.sleep(1000);
		Actions action4 = new Actions(driver);
		action4.moveToElement(driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[5]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		// lab header image height
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[5]/following-sibling::div/input")).sendKeys("20");
		Thread.sleep(1000);

		// preview
		driver.findElement(By.cssSelector("a#hospitalPBtn")).click();
		Thread.sleep(2000);

		Actions is1 = new Actions(driver);
		is1.moveToElement(driver.findElement(By.xpath("(//span[text()='Is default'])[1]"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement is_def = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
			is_def.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Actions is2 = new Actions(driver);
		is2.moveToElement(driver.findElement(By.xpath("(//span[text()='Is Active'])[1]"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			WebElement is_act = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
			is_act.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
	}

	@And("click on the submit button to create a new lab")
	public void click_on_the_submit_button_to_create_a_new_lab() throws Exception {
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Submit'])[1]"))))
				.click();
		Thread.sleep(5000);
	}

	@Then("double click on the lab to edit")
	public void double_click_on_the_lab_to_edit() throws Exception {
		WebElement doubleclick = driver.findElement(By.xpath("(//div[text()='Cucum Lab'])[1]"));
		Actions action = new Actions(driver);
		action.doubleClick(doubleclick).build().perform();
		Thread.sleep(3000);
		// edit
		driver.findElement(By.xpath("(//button[text()='Edit'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("add the lab address and save it")
	public void add_the_lab_address_and_save_it() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//span[@title='Add/Update address'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@title='Add/Update address'])[1]/img")).click();
		Thread.sleep(1000);
		// click on the add
		driver.findElement(By.xpath("(//button[text()='Add +'])[1]")).click();
		Thread.sleep(2000);
		// edit
		driver.findElement(By.xpath("(//button[text()='Edit'])[1]")).click();
		Thread.sleep(1000);
		// address line1
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[6]/following-sibling::div/input"))
				.sendKeys("test one");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// address line2
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[7]/following-sibling::div/input"))
				.sendKeys("test two");
		Thread.sleep(1000);
		WebElement select = driver
				.findElement(By.xpath("(//label[@id='HospitalLabel'])[8]/following-sibling::div/select"));
		Select city = new Select(select);
		city.selectByVisibleText("Hyderabad");
		Thread.sleep(1000);
		// area
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[10]/following-sibling::div/input"))
				.sendKeys("test area");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// landmark
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[11]/following-sibling::div/input"))
				.sendKeys("test landmark");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// pincode
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[12]/following-sibling::div/input"))
				.sendKeys("879009");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='convert-text'])/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Current Location'])[1]")).click();
		Thread.sleep(2000);
		// update
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div[3]/button[2]")).click();
		Thread.sleep(2000);
		// save from the address popup
		driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@title='Add/Update address'])[1]/img")).click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
		// ##########################################################################################
		// adding another address
		// clicking on the add button
		driver.findElement(By.xpath("(//button[text()='Add +'])[1]")).click();
		Thread.sleep(2000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// edit
		driver.findElement(By.xpath("(//button[text()='Edit'])[2]")).click();
		Thread.sleep(2000);
		// address line1
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[15]/following-sibling::div/input"))
				.sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// address line2
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[16]/following-sibling::div/input"))
				.sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement select1 = driver
				.findElement(By.xpath("(//label[@id='HospitalLabel'])[17]/following-sibling::div/select"));
		Select city1 = new Select(select1);
		city1.selectByVisibleText("Ahmedabad");
		Thread.sleep(1000);
		// area
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[19]/following-sibling::div/input"))
				.sendKeys("test area");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// landmark
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[20]/following-sibling::div/input"))
				.sendKeys("test landmark");
		// pincode
		driver.findElement(By.xpath("(//label[@id='HospitalLabel'])[21]/following-sibling::div/input"))
				.sendKeys("879010");
		Thread.sleep(2000);

		// // close
		// driver.findElement(By.xpath("(//button[text()='X'])")).click();
		// Thread.sleep(2000);
		// #################################################################################################
		// save from the address popup
		driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@title='Add/Update address'])[1]/img")).click();
		Thread.sleep(2000);
		// edit
		driver.findElement(By.xpath("(//button[text()='Edit'])[2]")).click();
		Thread.sleep(2000);
		// close
		driver.findElement(By.xpath("(//button[text()='X'])[1]")).click();
		Thread.sleep(8000);

		// adding contact
		driver.findElement(By.xpath("(//img[@class='addphone'])[2]")).click();
		Thread.sleep(2000);
		// add
		driver.findElement(By.xpath("(//button[text()='Add +'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#hospital-number")).sendKeys("689321456");
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#hospital-number")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#hospital-number")).sendKeys("6893214569");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#hospital-email")).sendKeys("cucumlabw@gmail.com");
		Thread.sleep(1000);
		try {
			// save
			driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);
		// edit number
		driver.findElement(By.xpath("(//img[@alt='editBtn'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#hospital-number")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#hospital-number")).sendKeys("6893214560");
		Thread.sleep(3000);
		// save
		driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Close'])[3]")).click();
		Thread.sleep(2000);

		// close lab popup
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		WebElement click = driver.findElement(By.xpath("/html/body/div[2]/div[3]/h3/span[3]"));
		jse1.executeScript("arguments[0].click()", click);
		Thread.sleep(2000);

		// yes
		driver.findElement(By.xpath("(//button[text()='Yes'])[1]")).click();
		Thread.sleep(3000);

		// // submit
		// driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		// Thread.sleep(2000);
		// // zoom in
		// driver.findElement(By.xpath("(//button[@class='react-flow__controls-button
		// react-flow__controls-zoomin'])"))
		// .click();
		// Thread.sleep(1000);
	}

	@Then("map the lab with the hospital to create tests in the lab")
	public void map_the_lab_with_the_hospital_to_create_tests_in_the_lab() throws Exception {
		driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum Hospital");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);

		// mouse hover to the dot below of the hospital name
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@data-handleid='b'])[1]"))).build().perform();
		Thread.sleep(2000);

		Actions action1 = new Actions(driver);
		action1.dragAndDrop(driver.findElement(By.xpath("(//div[@data-handleid='b'])[1]")), driver.findElement(By.xpath(
				"(//div[@class='react-flow__handle react-flow__handle-top nodrag nopan target connectable connectablestart connectableend connectionindicator'])")))
				.build().perform();
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//button[text()='Yes'])[1]")).click();
		Thread.sleep(5000);

	}

	@And("search the created lab that is connected with the hospital")
	public void search_the_created_lab_that_is_connected_with_the_hospital() throws Exception {
		driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum Lab");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Lab (Lab)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);

	}

	@Then("mouse over on to the lab that created")
	public void mouse_over_on_to_the_lab_that_created() throws Exception {
		List<WebElement> lastlab = driver
				.findElements(By.xpath("(//div[@class='react-flow__node react-flow__node-Lab nopan selectable'])[1]"));
		WebElement lastlabclick = lastlab.get(lastlab.size() - 1);
		lastlabclick.click();
		Thread.sleep(2000);
	}

	@And("click on the lab test to create radiology pathology packages")
	public void click_on_the_lab_test_to_create_radiology_pathology_packages() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//span[@title='Lab test'])[1]/img[1]"))).build().perform();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[@title='Lab test'])[1]/img[1]"))))
				.click();
		Thread.sleep(5000);
	}

	// @Then("click on the lab test masters from the masterdata")
	// public void click_on_the_lab_test_masters_from_the_masterdata() throws
	// Exception {
	// driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[8]/a")).click();
	// Thread.sleep(2000);
	// String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
	// System.out.println(md);
	// }
	//
	// @And("click on the plus button to add new lab")
	// public void click_on_the_plus_button_to_add_new_lab() throws Exception {
	// // clicking on the add new lab master +
	// driver.findElement(By.xpath("//i[text()='add']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @When("new diagnostic lab popup opens")
	// public void new_diagnostic_lab_popup_opens() {
	// }
	//
	// @Then("enter the lab name to create a new lab")
	// public void enter_the_lab_name_to_create_a_new_lab() {
	// // entering the lab name
	// driver.findElement(By.id("check_test")).sendKeys("Cucumber testlab");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// }
	//
	// @And("select the hospital from the hospital_clinic dropdown")
	// public void select_the_hospital_from_the_hospital_clinic_dropdown() {
	// // selecting the hospital/clinic
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[1]/div[2]/div/span/span[1]/span"))
	// .click();
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[1]/div[2]/div/span/span[1]/span"))
	// .sendKeys(Keys.DOWN);
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[1]/div[2]/div/span/span[1]/span"))
	// .sendKeys(Keys.ENTER);
	// }
	//
	// @Then("enter the following details into the new diagnostic lab1")
	// public void
	// enter_the_following_details_into_the_new_diagnostic_lab1(io.cucumber.datatable.DataTable
	// dataTable)
	// throws Exception {
	// List<List<String>> lab1 = dataTable.asLists(String.class);
	// // entering the mobile number
	// driver.findElement(By.id("diagnostic_lab_master_mobile")).sendKeys(lab1.get(0).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // uploading header img
	// driver.findElement(By.id("header_img_url")).sendKeys(lab1.get(1).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the height
	// driver.findElement(By.id("diagnostic_lab_master_header_img_height")).sendKeys(lab1.get(2).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // uploading footer img
	// driver.findElement(By.id("footer_img_url")).sendKeys(lab1.get(3).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the height
	// driver.findElement(By.id("diagnostic_lab_master_footer_img_height")).sendKeys(lab1.get(4).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the address line 1
	// driver.findElement(By.id("diagnostic_lab_master_address_details_attributes_0_address_line1"))
	// .sendKeys(lab1.get(5).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the address line 2
	// driver.findElement(By.id("diagnostic_lab_master_address_details_attributes_0_address_line2"))
	// .sendKeys(lab1.get(6).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//
	// }
	//
	// @And("select the city name from the dropdown1")
	// public void select_the_city_name_from_the_dropdown1() {
	// // entering the area
	// driver.findElement(By.xpath("(//span[@class='selection'])[4]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("//li[text()='Hyderabad']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @Then("enter the following details into the new diagnostic lab2")
	// public void
	// enter_the_following_details_into_the_new_diagnostic_lab2(io.cucumber.datatable.DataTable
	// dataTable)
	// throws Exception {
	// List<List<String>> lab2 = dataTable.asLists(String.class);
	//
	// driver.findElement(By.id("diagnostic_lab_master_address_details_attributes_0_area"))
	// .sendKeys(lab2.get(0).get(1));
	// // entering the landmark
	// driver.findElement(By.id("diagnostic_lab_master_address_details_attributes_0_landmark"))
	// .sendKeys(lab2.get(1).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the pincode
	// driver.findElement(By.id("diagnostic_lab_master_address_details_attributes_0_pin_code"))
	// .sendKeys(lab2.get(2).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the latitude
	// driver.findElement(By.id("diagnostic_lab_master_address_details_attributes_0_lttd"))
	// .sendKeys(lab2.get(3).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the longitude
	// driver.findElement(By.id("diagnostic_lab_master_address_details_attributes_0_lgtd"))
	// .sendKeys(lab2.get(4).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @And("click on the plus button to add another Address")
	// public void click_on_the_plus_button_to_add_another_address() throws
	// Exception {
	// driver.findElement(By.id("diagnostic_lab_master_address_details_attributes_0_lgtd")).sendKeys(Keys.PAGE_DOWN);
	// Thread.sleep(1000);
	// // clicking on the plus button
	// driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("enter the following details into the new address row")
	// public void
	// enter_the_following_details_into_the_new_address_row(io.cucumber.datatable.DataTable
	// dataTable) {
	// List<List<String>> lab2 = dataTable.asLists(String.class);
	// // address line1
	// driver.findElement(By.xpath("(//input[@class='address_line1'])[2]")).sendKeys(lab2.get(0).get(1));
	// // entering the address line 2
	// driver.findElement(By.xpath("(//input[@class='address_line2'])[2]")).sendKeys(lab2.get(1).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @And("select the city name from the dropdown2")
	// public void select_the_city_name_from_the_dropdown2() {
	// // entering the area
	// driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("//li[text()='Hyderabad']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @Then("enter the following details into the new diagnostic lab3")
	// public void
	// enter_the_following_details_into_the_new_diagnostic_lab3(io.cucumber.datatable.DataTable
	// dataTable) {
	// List<List<String>> lab3 = dataTable.asLists(String.class);
	//
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[3]/div[2]/div/div[4]/input"))
	// .sendKeys(lab3.get(0).get(1));
	// // entering the landmark
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[3]/div[2]/div/div[5]/input"))
	// .sendKeys(lab3.get(1).get(1));
	// // entering the pincode
	// driver.findElement(By.xpath("(//input[@class='pincode'])[2]")).sendKeys(lab3.get(2).get(1));
	// // entering the latitude
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[3]/div[2]/div/div[7]/input"))
	// .sendKeys(lab3.get(3).get(1));
	// // entering the longitude
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[3]/div[2]/div/div[8]/input"))
	// .sendKeys(lab3.get(4).get(1));
	//
	// }
	//
	// @And("remove the one of the address")
	// public void remove_the_one_of_the_address() throws Exception {
	// driver.findElement(By.xpath("(//i[@class='fa
	// fa-times-circle'])[2]")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("enable the active checkbox for the new lab")
	// public void enable_the_active_checkbox_for_the_new_lab() {
	// for (int i = 0; i <= 1; i++) {
	// WebElement active =
	// driver.findElement(By.xpath("(//label[text()='Active'])[2]"));
	// active.click();
	// }
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// }
	//
	// @And("click on the save button from the new diagnostic lab popup")
	// public void click_on_the_save_button_from_the_new_diagnostic_lab_popup()
	// throws Exception {
	// // clicking on the save button
	// driver.findElement(By.xpath("//div[@class='modal-footer']/input[1]")).click();
	// Thread.sleep(5000);
	// }
	//
	// @Then("click on the edit button to update the mobile")
	// public void click_on_the_edit_button_to_update_the_mobile() throws Exception
	// {
	// // clicking on the edit
	// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("diagnostic_lab_master_mobile")).clear();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.id("diagnostic_lab_master_mobile")).sendKeys("9101511712");
	// Thread.sleep(1000);
	// }
	//
	// @And("click on the save button from the edit labmaster")
	// public void click_on_the_save_button_from_the_edit_labmaster() throws
	// Exception {
	// // clicking on the save button
	// driver.findElement(By.xpath("//div[@class='modal-footer']/input[1]")).click();
	// Thread.sleep(3000);
	// }
	//
	// @When("click on the view in maps button")
	// public void click_on_the_view_in_maps_button() throws Exception {
	// String parentwindow = driver.getWindowHandle();
	// driver.findElement(By.xpath("(//a[@data-tooltip='View in Google
	// Maps'])[1]")).click();
	// Thread.sleep(5000);
	//
	// Set<String> childwindow = driver.getWindowHandles();
	// for (String handle : childwindow) {
	// if (!childwindow.equals(parentwindow)) {
	// Robot robot = new Robot();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.switchTo().window(parentwindow);
	// }
	// }
	// }
	//
	// @Then("it will open in another tab showing map of lab")
	// public void it_will_open_in_another_tab_showing_map_of_lab() {
	//
	// }
	//
	// @And("close the tab and navigate to the parentwindow")
	// public void close_the_tab_and_navigate_to_the_parentwindow() {
	//
	// }
	//
	// @Then("adding slots to the added lab")
	// public void adding_slots_to_the_added_lab() throws Exception {
	// // clicking on the slots
	// driver.findElement(By.xpath("(//a[@data-tooltip='Slots'])[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//a[@data-tooltip='Add New
	// Slots'])[1]/i")).click();
	// Thread.sleep(1000);
	// // clicking on the drop-down
	// driver.findElement(By.xpath("(//input[@type='search'])[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys(Keys.ENTER);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// // clicking on the drop-down
	// driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
	// Thread.sleep(1000);
	// for (int i = 0; i <= 0; i++) {
	// driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.DOWN);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// }
	// driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
	// Thread.sleep(1000);
	// for (int i = 0; i <= 1; i++) {
	// driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.DOWN);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// }
	// driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
	// Thread.sleep(1000);
	// for (int i = 0; i <= 2; i++) {
	// driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.DOWN);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// }
	// driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
	// Thread.sleep(1000);
	// for (int i = 0; i <= 3; i++) {
	// driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.DOWN);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// }
	// driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
	// Thread.sleep(1000);
	// for (int i = 0; i <= 4; i++) {
	// driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.DOWN);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// }
	// driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
	// Thread.sleep(2000);
	// // removing the selected monday
	// driver.findElement(By.xpath("(//span[@class='select2-selection__choice__remove'])[2]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
	// Thread.sleep(1000);
	// // clicking on the time
	// driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("//li[text()='07:00 AM']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("//li[text()='30']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("//li[text()='10:00 PM']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("//li[text()='00']")).click();
	// Thread.sleep(1000);
	// // save
	// driver.findElement(By.cssSelector("input.btn.green.right")).click();
	// Thread.sleep(4000);
	// }
	//
	// @Then("search the lab name using dropdown")
	// public void search_the_lab_name_using_dropdown() throws Exception {
	// // searching on the lab name
	// driver.findElement(By.id("q_lab_name_cont")).sendKeys("Cucumber testlab");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // search
	// driver.findElement(By.xpath("(//div[@class='col s2'])[2]/input")).click();
	// Thread.sleep(3000);
	// }
	//
	// @And("click on the lab name")
	// public void click_on_the_lab_name() throws Exception {
	// // clicking on the lab name
	// driver.findElement(By.xpath("//a[text()='Cucumber testlab']")).click();
	// Thread.sleep(2000);
	// }
	//
	// @When("lab name is clicked it will open the the lab test master page")
	// public void lab_name_is_clicked_it_will_open_the_the_lab_test_master_page() {
	// }
	//
	@Then("click on the plus button to add new test1")
	public void click_on_the_plus_button_to_add_new_test1() throws Exception {
		// adding test
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(3000);
	}

	@And("select the individual radio button for adding pathology test to lab")
	public void select_the_individual_radio_button_for_adding_pathology_test_to_lab() {
		// individual
		WebElement ind = driver.findElement(By.xpath("(//label[text()='Individual'])[1]"));
		ind.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("select the pathology radio button to add pathology test")
	public void select_the_pathology_radio_button_to_add_pathology_test() {
		// pathology
		driver.findElement(By.xpath("//label[text()='Pathology']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("select the test name from the dropdown to add pathology test")
	public void select_the_test_name_from_the_dropdown_to_add_pathology_test() {
		// fbs
		driver.findElement(By.xpath("//li[text()='RBS'][1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("selecting pathology test")
	public void selecting_pathology_test() {
	}

	@Then("label name_department field automatically filled for pathology test")
	public void label_name_department_field_automatically_filled_for_pathology_test() {
	}

	@And("enter the technology for the pathology test")
	public void enter_the_technology_for_the_pathology_test() {
		driver.findElement(By.cssSelector("input#diagnostic_test_lab_detail_technology")).sendKeys("test tech");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("enable the active checkbox for the pathology test")
	public void enable_the_active_checkbox_for_the_pathology_test() {
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[2]"));
			active.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on the plus button to add ideal range")
	public void click_on_the_plus_button_to_add_ideal_range() throws Exception {
		// clicking on the + ADD ideal range
		driver.findElement(By.cssSelector("a.btn-floating.waves-effect.config_btn.green.tooltipped>i")).click();
		Thread.sleep(2000);
	}

	@And("enter the details for diagnostic test lab configurations")
	public void enter_the_details_for_diagnostic_test_lab_configurations() throws Exception {
		// lower
		driver.findElement(By.cssSelector(
				"input#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_lower_age"))
				.sendKeys("5");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// upper
		driver.findElement(By.cssSelector(
				"input#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_upper_age"))
				.sendKeys("200");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// gender selection
		driver.findElement(By.xpath("//label[@for='gender']/following-sibling::span/span[1]")).click();
		Thread.sleep(1000);
		// all
		driver.findElement(By.xpath("//li[text()='All']")).click();
		Thread.sleep(1000);
		// ideal range
		driver.findElement(By.cssSelector(
				"input#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_ideal_range"))
				.sendKeys("70-130");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// comments
		driver.findElement(By.cssSelector(
				"textarea#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_comments"))
				.sendKeys("test comments");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the plus to add new ideal range")
	public void click_on_the_plus_to_add_new_ideal_range() throws Exception {
		// clikcing on the add
		driver.findElement(By.xpath("//div[@class='row addBtn']/a/i")).click();
		Thread.sleep(2000);
	}

	@And("entering the details and remove last added")
	public void entering_the_details_and_remove_last_added() throws Exception {
		// lower
		driver.findElement(By.xpath("(//input[@class='lower-age'])[2]")).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// upper
		driver.findElement(By.xpath("(//input[@class='upper-age'])[2]")).sendKeys("150");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// gender-selection
		driver.findElement(By.xpath("(//label[@for='gender']/following-sibling::span/span[1])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='All']")).click();
		Thread.sleep(1000);
		// ideal range
		driver.findElement(By.xpath("(//input[@class='ideal-range'])[2]")).sendKeys("70-120");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// removing
		driver.findElement(By.xpath("(//a[@class='remove_fields dynamic'])[2]/i")).click();
		Thread.sleep(1000);
	}

	@Then("click on the continue button for pathology test")
	public void click_on_the_continue_button_for_pathology_test() throws Exception {
		// continue
		driver.findElement(By.cssSelector("button.waves-effect.waves-dark.btn.green.btnContinue.next-step.right"))
				.click();
		Thread.sleep(2000);

	}

	@And("entering the cost and price of that pathology test")
	public void entering_the_cost_and_price_of_that_pathology_test() {
		// cost
		driver.findElement(By.id("diagnostic_test_lab_detail_cost")).sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// price
		driver.findElement(By.id("diagnostic_test_lab_detail_price")).sendKeys("200");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the save button for saving pathology test")
	public void click_on_the_save_button_for_saving_pathology_test() throws Exception {
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the plus button to add new test2")
	public void click_on_the_plus_button_to_add_new_test2() throws Exception {
		// adding test
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(3000);
	}

	@Then("select the individual radio button for adding radiology test to lab")
	public void select_the_individual_radio_button_for_adding_radiology_test_to_lab() {
		WebElement ind1 = driver.findElement(By.xpath("(//label[text()='Individual'])[1]"));
		ind1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@And("select the radiology radio button to add radiology test")
	public void select_the_radiology_radio_button_to_add_radiology_test() {
		// radilogy
		WebElement rad = driver.findElement(By.xpath("(//label[text()='Radiology'])[1]"));
		rad.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("select the test name from the dropdown to add radiology test")
	public void select_the_test_name_from_the_dropdown_to_add_radiology_test() {
		// OPG
		driver.findElement(By.xpath("//li[text()='OPG with Cephalometry'][1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// active
		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.xpath("(//label[text()='Active'])[2]")).click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("selecting radiology test")
	public void selecting_radiology_test() {

	}

	@Then("click on the continue button for radiology test")
	public void click_on_the_continue_button_for_radiology_test() throws Exception {
		// continue
		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		Thread.sleep(1000);

	}

	@And("entering the cost and price of that radiology test")
	public void entering_the_cost_and_price_of_that_radiology_test() {
		// cost
		driver.findElement(By.id("diagnostic_test_lab_detail_cost")).sendKeys("1000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// price
		driver.findElement(By.id("diagnostic_test_lab_detail_price")).sendKeys("2500");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the save button for saving radiology test")
	public void click_on_the_save_button_for_saving_radiology_test() throws Exception {
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("click on the plus button to add new test3")
	public void click_on_the_plus_button_to_add_new_test3() throws Exception {
		// adding test
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(3000);
	}

	@Then("select the profile radio button for adding profile pathology test to lab")
	public void select_the_profile_radio_button_for_adding_profile_pathology_test_to_lab() throws Exception {
		WebElement profile = driver.findElement(By.xpath("(//label[text()='Profile'])[1]"));
		profile.click();
		Thread.sleep(1000);
	}

	@And("select the pathology radio button to add profile pathology test")
	public void select_the_pathology_radio_button_to_add_profile_pathology_test() {
		// pathology
		WebElement path = driver.findElement(By.xpath("(//label[text()='Pathology'])[1]"));
		path.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("select the test name from the dropdown to add profile pathology test")
	public void select_the_test_name_from_the_dropdown_to_add_profile_pathology_test() throws Exception {
		driver.findElement(By.xpath("(//li[text()='Thyroid Profile'])[1]")).click();
		Thread.sleep(1000);
	}

	@When("selecting profile pathology test")
	public void selecting_profile_pathology_test() {
	}

	@Then("label name_department field automatically filled for profile pathology test")
	public void label_name_department_field_automatically_filled_for_profile_pathology_test() {
	}

	@And("enter the technology for the profile pathology test")
	public void enter_the_technology_for_the_profile_pathology_test() {
		driver.findElement(By.cssSelector("input#diagnostic_test_lab_detail_technology")).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("enable the active checkbox for the profile pathology test")
	public void enable_the_active_checkbox_for_the_profile_pathology_test() {
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[2]"));
			active.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on the plus button to add ideal range for profile pathology test")
	public void click_on_the_plus_button_to_add_ideal_range_for_profile_pathology_test() throws Exception {
		// clicking on the + ADD ideal range
		driver.findElement(By.cssSelector("a.btn-floating.waves-effect.config_btn.green.tooltipped>i")).click();
		Thread.sleep(2000);
	}

	@And("enter the details for diagnostic test lab configurations for profile pathology test")
	public void enter_the_details_for_diagnostic_test_lab_configurations_for_profile_pathology_test() throws Exception {
		// lower
		driver.findElement(By.cssSelector(
				"input#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_lower_age"))
				.sendKeys("5");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// upper
		driver.findElement(By.cssSelector(
				"input#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_upper_age"))
				.sendKeys("200");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// gender selection
		driver.findElement(By.xpath("//label[@for='gender']/following-sibling::span/span[1]")).click();
		Thread.sleep(1000);
		// all
		driver.findElement(By.xpath("//li[text()='All']")).click();
		Thread.sleep(1000);
		// ideal range
		driver.findElement(By.cssSelector(
				"input#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_ideal_range"))
				.sendKeys("70-130");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// comments
		driver.findElement(By.cssSelector(
				"textarea#diagnostic_test_lab_detail_diagnostic_test_lab_ideal_config_masters_attributes_0_comments"))
				.sendKeys("test comments");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("click on the continue button for profile pathology test")
	public void click_on_the_continue_button_for_profile_pathology_test() throws Exception {
		// continue
		driver.findElement(By.cssSelector("button.waves-effect.waves-dark.btn.green.btnContinue.next-step.right"))
				.click();
		Thread.sleep(2000);
	}

	@And("entering the cost and price of that profile pathology test")
	public void entering_the_cost_and_price_of_that_profile_pathology_test() {
		// cost
		driver.findElement(By.id("diagnostic_test_lab_detail_cost")).sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// price
		driver.findElement(By.id("diagnostic_test_lab_detail_price")).sendKeys("200");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the save button for saving profile pathology test")
	public void click_on_the_save_button_for_saving_profile_pathology_test() throws Exception {
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(2000);

	}

	@And("click on the plus button to add new test4")
	public void click_on_the_plus_button_to_add_new_test4() throws Exception {
		// adding test
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(3000);
	}

	@Then("select the profile radio button for adding profile radiology test to lab")
	public void select_the_profile_radio_button_for_adding_profile_radiology_test_to_lab() throws Exception {
		WebElement profile = driver.findElement(By.xpath("(//label[text()='Profile'])[1]"));
		profile.click();
		Thread.sleep(1000);
	}

	@And("select the radiology radio button to add profile radiology test")
	public void select_the_radiology_radio_button_to_add_profile_radiology_test() {
		// radiology
		WebElement rad = driver.findElement(By.xpath("(//label[text()='Radiology'])[1]"));
		rad.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("select the test name from the dropdown to add profile radiology test")
	public void select_the_test_name_from_the_dropdown_to_add_profile_radiology_test() throws Exception {
		driver.findElement(By.xpath("(//label[text()='Test Name'])[2]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		//
		driver.findElement(By.xpath("(//label[text()='Test Name'])[2]/following-sibling::span[1]")).sendKeys("s");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'a')])[1]")).click();
		Thread.sleep(1000);
		// Robot radio = new Robot();
//		Thread.sleep(1000);
//		radio.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
//		radio.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
		// active
		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.xpath("(//label[text()='Active'])[2]")).click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("selecting profile radiology test")
	public void selecting_profile_radiology_test() {

	}

	@Then("click on the continue button for profile radiology test")
	public void click_on_the_continue_button_for_profile_radiology_test() throws Exception {
		// continue
		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("entering the cost and price of that profile radiology test")
	public void entering_the_cost_and_price_of_that_profile_radiology_test() {
		// cost
		driver.findElement(By.id("diagnostic_test_lab_detail_cost")).sendKeys("1000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// price
		driver.findElement(By.id("diagnostic_test_lab_detail_price")).sendKeys("2500");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("click on the save button for saving profile radiology test")
	public void click_on_the_save_button_for_saving_profile_radiology_test() throws Exception {
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("click on the plus button to add new test5")
	public void click_on_the_plus_button_to_add_new_test5() throws Exception {
		// adding test
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(3000);

	}

	@And("select the popular package radio button to add popular package")
	public void select_the_popular_package_radio_button_to_add_popular_package() {
		WebElement pkg = driver.findElement(By.xpath("(//label[text()=' Popular Package'])[1]"));
		pkg.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("enter the popular package test name")
	public void enter_the_popular_package_test_name() {
		// test name
		driver.findElement(By.id("diagnostic_test_lab_detail_test_name")).sendKeys("Cucum testpkg");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("disable and enable the checkboxes of the popular package")
	public void disable_and_enable_the_checkboxes_of_the_popular_package() {
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[2]"));
			active.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		for (int i = 0; i <= 1; i++) {
			WebElement individual = driver.findElement(By.xpath("(//label[text()='Individual'])[2]"));
			individual.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		for (int i = 0; i <= 1; i++) {
			WebElement grouponly = driver.findElement(By.xpath("(//label[text()='Group only'])[1]"));
			grouponly.click();
		}
	}

	@Then("selecting the test name from the dropdown to add into the popular package")
	public void selecting_the_test_name_from_the_dropdown_to_add_into_the_popular_package() {
		// clicking on the dropdown
		driver.findElement(By.xpath("(//label[text()='Test Name'])[3]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='Calcium'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("clicking on the plus button to select one more test1")
	public void clicking_on_the_plus_button_to_select_one_more_test1() {
		// add
		driver.findElement(By.xpath("(//i[text()='add'])[4]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("entering the order number1")
	public void entering_the_order_number1() {
		driver.findElement(By.xpath("(//label[@for='order_id'])[2]/following-sibling::input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//label[@for='order_id'])[2]/following-sibling::input[1]")).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("selecting the test name1 from the dropdown to add into the popular package")
	public void selecting_the_test_name1_from_the_dropdown_to_add_into_the_popular_package() {
		// clicking on the dropdown
		driver.findElement(By.xpath("(//label[text()='Test Name'])[4]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='Platelet Count'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("clicking on the plus button to select one more test2")
	public void clicking_on_the_plus_button_to_select_one_more_test2() {
		// add
		driver.findElement(By.xpath("(//i[text()='add'])[4]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("entering the order number2")
	public void entering_the_order_number2() {
		driver.findElement(By.xpath("(//label[@for='order_id'])[3]/following-sibling::input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//label[@for='order_id'])[3]/following-sibling::input[1]")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("selecting the test name2 from the dropdown to add into the popular package")
	public void selecting_the_test_name2_from_the_dropdown_to_add_into_the_popular_package() throws Exception {
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the dropdown
		driver.findElement(By.xpath("(//label[text()='Test Name'])[5]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[contains(text(),'Insulin')])[1]")).click();
		Thread.sleep(3000);
		for (int i = 0; i <= 1; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(2000);
	}

	@And("clicking on the plus button to select one more test3")
	public void clicking_on_the_plus_button_to_select_one_more_test3() {
		// add
		driver.findElement(By.xpath("(//i[text()='add'])[4]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("entering the order number3")
	public void entering_the_order_number3() {
		driver.findElement(By.xpath("(//label[@for='order_id'])[4]/following-sibling::input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//label[@for='order_id'])[4]/following-sibling::input[1]")).sendKeys("3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("selecting the test name3 from the dropdown to add into the popular package")
	public void selecting_the_test_name3_from_the_dropdown_to_add_into_the_popular_package() throws Exception {
		// clicking on the dropdown
		driver.findElement(By.xpath("(//label[text()='Test Name'])[6]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[contains(text(),'ECG')])[1]")).click();
		Thread.sleep(1000);
	}

	@And("removing the last added test name for the popular package")
	public void removing_the_last_added_test_name_for_the_popular_package() throws Exception {
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[6]")).click();
		Thread.sleep(1000);
		for (int i = 0; i <= 1; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(1000);
	}

	@Then("clicking on the continue button from the popular package popup")
	public void clicking_on_the_continue_button_from_the_popular_package_popup() throws Exception {
		// continue
		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("entering the cost and price for the popular package")
	public void entering_the_cost_and_price_for_the_popular_package() {
		// cost
		driver.findElement(By.id("diagnostic_test_lab_detail_cost")).sendKeys("1000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// price
		driver.findElement(By.id("diagnostic_test_lab_detail_price")).sendKeys("2000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the save button to save the popular package")
	public void click_on_the_save_button_to_save_the_popular_package() throws Exception {
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
//		// edit
//		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[2]")).click();
//		Thread.sleep(2000);
//		// continue
//		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//span[@class='selection'])[8]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='NanoHealth-HYD'])[1]")).click();
//		Thread.sleep(1000);
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add'])[1]/i"))).build().perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Add'])[1]/i")).click();
//		Thread.sleep(2000);
//		// cost
//		driver.findElement(By.xpath("(//label[text()='Cost'])[2]/following-sibling::input")).sendKeys("500");
//		Thread.sleep(1000);
//		// price
//		driver.findElement(By.xpath("(//label[text()='Price'])[2]/following-sibling::input")).sendKeys("700");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//span[@class='selection'])[9]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='NH Client'])[1]")).click();
//		Thread.sleep(1000);
//		// removing
//		driver.findElement(By.xpath("(//i[text()='remove'])[1]")).click();
//		Thread.sleep(1000);
//		// save
//		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
//		Thread.sleep(5000);

	}

	@When("popular package is saved")
	public void popular_package_is_saved() {

	}

	@And("deleting the one test OPG")
	public void deleting_the_one_test_OPG() throws Exception {
		driver.navigate().refresh();
		Thread.sleep(2000);
		// deleting the test OPG
		driver.findElement(By.xpath("(//label[text()='Test Name'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(),'OPG')])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Confirm!']")).click();
		Thread.sleep(2000);
	}

	@Then("mouse-hovering to the tests in the cucumber testlab")
	public void mouse_hovering_to_the_tests_in_the_cucumber_testlab() throws Exception {
		// mouse hovering to the package
		Actions pkg = new Actions(driver);
		pkg.moveToElement(driver.findElement(By.xpath("(//span[@data-tooltip='Package'])[1]/img"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// mouse hovering to the package i button
		Actions i = new Actions(driver);
		i.moveToElement(driver
				.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/table/tbody/tr[1]/td[2]/div/span/i")))
				.build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// mouse hovering to the radiology
		Actions rad = new Actions(driver);
		rad.moveToElement(driver.findElement(By.xpath("(//span[@name='Radiology'])[1]/img"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// mouse hovering to the profile pathology
		Actions propath = new Actions(driver);
		propath.moveToElement(driver.findElement(By.xpath("(//span[@name='HomeVisit'])[1]/img"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// mouse hovering to the pathology
		Actions path = new Actions(driver);
		path.moveToElement(driver.findElement(By.xpath("(//span[@data-tooltip='HomeVisit'])[2]/img"))).build()
				.perform();
		Thread.sleep(1000);

		// download report
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Download Reports'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Download Reports'])[1]/i[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the edit for popular package")
	public void click_on_the_edit_for_popular_package() throws Exception {
		// // EDIT
		// driver.findElement(By.xpath("(//I[@class='fa fa-pencil'])[1]")).click();
		// Thread.sleep(4000);
	}

	@Then("update the price and click on save button from edit package")
	public void update_the_price_and_click_on_save_button_from_edit_package() throws Exception {
		// // continue
		// driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		// Thread.sleep(1000);
		// // price
		// driver.findElement(By.id("diagnostic_test_lab_detail_price")).clear();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.id("diagnostic_test_lab_detail_price")).sendKeys("3000");
		// Thread.sleep(1000);
		// // save
		// driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
		// Thread.sleep(3000);
	}

	@And("click on the edit2")
	public void click_on_the_edit2() throws Exception {
		// EDIT
		driver.findElement(By.xpath("(//I[@class='fa fa-pencil'])[2]")).click();
		Thread.sleep(2000);
	}

	@Then("update the price and click on save button2")
	public void update_the_price_and_click_on_save_button2() throws Exception {
		// continue
		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		Thread.sleep(1000);
		// price
		driver.findElement(By.id("diagnostic_test_lab_detail_price")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("diagnostic_test_lab_detail_price")).sendKeys("1500");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Demand Program'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='NanoHealth-HYD'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Add'])[1]/i[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//label[text()='Cost'])[2]/following-sibling::input[1]")).sendKeys("1000");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Price'])[2]/following-sibling::input[1]")).sendKeys("2000");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Demand Program'])[2]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Eureka Forbes'])[1]")).click();
//		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
//		// EDIT
//		driver.findElement(By.xpath("(//I[@class='fa fa-pencil'])[2]")).click();
//		Thread.sleep(2000);
//		// continue
//		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
//		Thread.sleep(1000);
//		// remove
//		driver.findElement(By.xpath("(//i[text()='remove'])[2]")).click();
//		Thread.sleep(2000);
//		// save
//		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
//		Thread.sleep(3000);
	}

	@And("click on the edit3")
	public void click_on_the_edit3() throws Exception {
		// EDIT
		driver.findElement(By.xpath("(//I[@class='fa fa-pencil'])[3]")).click();
		Thread.sleep(2000);
	}

	@Then("update the price and click on save button3")
	public void update_the_price_and_click_on_save_button3() throws Exception {
		// continue
		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		Thread.sleep(1000);
		// price
		driver.findElement(By.id("diagnostic_test_lab_detail_price")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("diagnostic_test_lab_detail_price")).sendKeys("300");
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the edit4")
	public void click_on_the_edit4() throws Exception {
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[4]")).click();
		Thread.sleep(2000);
		WebElement active = driver.findElement(By.xpath("(//label[@for='diagnostic_test_lab_detail_is_active'])[1]"));
		active.click();
		Thread.sleep(1000);
	}

	@Then("update the price and click on save button4")
	public void update_the_price_and_click_on_save_button4() throws Exception {
		// continue
		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		Thread.sleep(2000);
		// // price
		// driver.findElement(By.id("diagnostic_test_lab_detail_price")).clear();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.id("diagnostic_test_lab_detail_price")).sendKeys("250");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("searching test name and type using search")
	public void searching_test_name_and_type_using_search() throws Exception {
		// test name
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='RBS']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// SEARCH
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// active
		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='Yes'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// SEARCH
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// active
		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='No'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// SEARCH
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// test type
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='Radiology'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// SEARCH
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
	}

	@Then("click on the linked hospital button")
	public void click_on_the_linked_hospital_button() throws Exception {
		// link-hospitals
		driver.findElement(By.xpath("//i[@class='fa fa-link'][1]")).click();
		Thread.sleep(1000);
	}

	@And("add the hospital name and save it")
	public void add_the_hospital_name_and_save_it() throws Exception {
		// add
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(1000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		robot2.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("clicking on the linked hospital button again")
	public void clicking_on_the_linked_hospital_button_again() throws Exception {
		// link-hospitals
		driver.findElement(By.xpath("//i[@class='fa fa-link']")).click();
		Thread.sleep(1000);
	}

	@And("removing the mapped hospital from linked hospitals")
	public void removing_the_mapped_hospital_from_linked_hospitals() throws Exception {
		// remove
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(3000);
		// closing
		driver.findElement(By.xpath("(//span[@class='modal-close nh_close btn-floating'])[2]/i[1]")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		// // back
		// driver.findElement(By.xpath("//a[text()='Back']")).click();
		// Thread.sleep(2000);
	}

	@When("linked hospital removed and clicking on the back button")
	public void linked_hospital_removed_and_clicking_on_the_back_button() {
	}

	// @Then("click on the tests button from lab_masters page")
	// public void click_on_the_tests_button_from_lab_masters_page() throws
	// Exception {
	//// // clicking on the tests
	//// driver.findElement(By.xpath("//a[text()='Tests']")).click();
	//// Thread.sleep(1000);
	// }
	//
	// @And("searching the test using search filters")
	// public void searching_the_test_using_search_filters() throws Exception {
	//// // clicking on the drop-down
	//// driver.findElement(By.xpath("(//span[@class='selection'])[2]/span")).click();
	//// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//// driver.findElement(By.xpath("//li[text()='FBS']")).click();
	//// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//// // search
	//// driver.findElement(By.xpath("//input[@name='commit']")).click();
	//// Thread.sleep(2000);
	// }
	@Then("open facility digital twin and search for the hospital")
	public void open_facility_digital_twin_and_search_for_the_hospital() throws Exception {
		// hover the mouse on Reports
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Master Data']"))).click().build().perform();
		Thread.sleep(1000);
		WebDriverWait fdt = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			fdt.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[1]/a")))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(18000);
		driver.findElement(By.cssSelector("input#searchBoxx")).sendKeys("Cucum Hospital");
		Thread.sleep(2000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//option[text()='Cucum Hospital (Hospital)'])[1]"));
		jse5.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		List<WebElement> lastlab = driver
				.findElements(By.xpath("(//div[@class='react-flow__node react-flow__node-Lab nopan selectable'])[8]"));
		WebElement lastlabclick = lastlab.get(lastlab.size() - 1);
		lastlabclick.click();
		Thread.sleep(2000);
	}

	@When("mouse hover on the lab and click on the add technician_pathologist")
	public void mouse_hover_on_the_lab_and_click_on_the_add_technician_pathologist() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("(//span[@title='Add Technician/Pathologist/Manager'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("(//span[@title='Add Technician/Pathologist/Manager'])[1]/img[1]"))))
				.click();
		Thread.sleep(5000);
	}

	@Then("user details page will be opened")
	public void user_details_page_will_be_opened() {
	}

	@And("click on the add button to create a new user with technician_pathologist")
	public void click_on_the_add_button_to_create_a_new_user_with_technician_pathologist() throws Exception {
		WebDriverWait plus = new WebDriverWait(driver, Duration.ofSeconds(30));
		plus.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//i[text()='add'])[1]")))).click();
		Thread.sleep(3000);

	}

	@Then("enter the details of the user and click on continue")
	public void enter_the_details_of_the_user_and_click_on_continue() throws Exception {
		driver.findElement(By.cssSelector("input#first_name")).sendKeys("CucumLab");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#lst_name")).sendKeys("Radiologist");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// gender
		WebElement male = driver.findElement(By.xpath("//label[text()='M']"));
		male.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		driver.findElement(By.cssSelector("input#age")).sendKeys("40");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("//li[text()='+91']")).click();
//		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#nmbr")).sendKeys("8833828282");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
				.click();
		Thread.sleep(3000);

	}

	@And("select the roles technician_pathologist and save")
	public void select_the_roles_technician_pathologist_and_save() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[8]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='LabTechnician'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[@class='select2-search select2-search--inline'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucum Lab'])[1]")).click();
		Thread.sleep(1000);
		// more
		driver.findElement(By.xpath("(//a[@class='show_more_fields'])[1]/img")).click();
		Thread.sleep(1000);
		// full access
		WebElement fa = driver.findElement(By.xpath("(//label[text()='Full Access'])[1]"));
		fa.click();
		Thread.sleep(1000);
		// verified
		WebElement ver = driver.findElement(By.xpath("(//label[text()='Verified'])[1]"));
		ver.click();
		Thread.sleep(1000);
		// less
		driver.findElement(By.xpath("(//img[@data-tooltip='Less'])[1]")).click();
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);

	}

	@When("existing teamdetails is deleted")
	public void existing_teamdetails_is_deleted() throws Exception {
	}

	@And("click on the teamdetails button from the masterdata dashboard")
	public void click_on_the_teamdetails_button_from_the_masterdata_dashboard() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='User Details'])[1]")).click();
		Thread.sleep(1000);
		String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
		System.out.println(md);
	}

	@Then("click on the plus button to add new user")
	public void click_on_the_plus_button_to_add_new_user() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add New User'])[1]/i"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New User'])[1]/i")).click();
		Thread.sleep(1000);
	}

	@And("enter the necessary details of the user")
	public void enter_the_necessary_details_of_the_user() throws Exception {
		// first name
		driver.findElement(By.cssSelector("input#first_name")).sendKeys("Cucumber");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// last name
		driver.findElement(By.cssSelector("input#lst_name")).sendKeys("Userrole");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement male = driver.findElement(By.xpath("(//label[text()='M'])[1]"));
		male.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		driver.findElement(By.cssSelector("input#age")).sendKeys("45");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// number
		driver.findElement(By.cssSelector("input#nmbr")).sendKeys("6566566560");
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		// // mail
		// driver.findElement(By.cssSelector("input#email:nth-of-type(1)")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// profile picture
		// driver.findElement(By.cssSelector("input#files_constr"))
		// .sendKeys("C:\\Users\\Lenovo\\Desktop\\userroleimage.png");
		// Thread.sleep(1000);
	}

	@When("details has been entered then continue button will enable and turn to green colour")
	public void details_has_been_entered_then_continue_button_will_enable_and_turn_to_green_colour() {
	}

	@Then("click on the continue button to add the roles to user")
	public void click_on_the_continue_button_to_add_the_roles_to_user() throws Exception {
		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("select the role from the roles popup and select the required options from the role fields")
	public void select_the_role_from_the_roles_popup_and_select_the_required_options_from_the_role_fields()
			throws InterruptedException, AWTException {
		driver.findElement(By.xpath("(//span[@class='selection'])[8]")).click();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='ClinicManager'])[1]"))))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[1]")).click();
		Thread.sleep(1000);
		WebDriverWait hsplt = new WebDriverWait(driver, Duration.ofSeconds(30));
		hsplt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='NanoHealth_OPD'])[1]"))))
				.click();
		Thread.sleep(2000);
		// clicking on the more
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[1]")).click();
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Full Access'])[1]"));
			fa.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement md = driver.findElement(By.xpath("(//label[text()='Master Data Access'])[1]"));
			md.click();
			Thread.sleep(1000);
		}

		// clicking on the less
		driver.findElement(By.xpath("(//img[@data-tooltip='Less'])[1]")).click();
		Thread.sleep(1000);

		// clicking on the save
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
				.click();
		// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(5000);

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add New User'])/i[1]")))).click();
		// driver.findElement(By.xpath("(//a[@data-tooltip='Add New
		// User'])/i[1]")).click();
		Thread.sleep(3000);
		// number
		driver.findElement(By.cssSelector("input#nmbr")).sendKeys("6566566560");
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		// YES
		WebDriverWait yes = new WebDriverWait(driver, Duration.ofSeconds(30));
		yes.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Yes'])[1]")))).click();
		// driver.findElement(By.xpath("(//a[text()='Yes'])[1]")).click();
		Thread.sleep(3000);
		// continue
		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		Thread.sleep(3000);

	}

	@Then("click on the plus button to add new role to the user")
	public void click_on_the_plus_button_to_add_new_role_to_the_user() throws Exception {
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
	}

	@And("select the another role and role required options from the dropdowns")
	public void select_the_another_role_and_role_required_options_from_the_dropdowns() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[14]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Doctor'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[16]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")).click();
		Thread.sleep(1000);
//		// signature of the doctor
//		driver.findElement(By.cssSelector("input#files_sign"))
//				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\doctorsignature.png");
//		Thread.sleep(1000);
		// clicking on the more
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[2]")).click();
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Full Access'])[2]"));
			fa.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement md = driver.findElement(By.xpath("(//label[text()='Master Data Access'])[2]"));
			md.click();
		}
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(1000);
		// clicking on the less
		driver.findElement(By.xpath("(//img[@data-tooltip='Less'])[2]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
	}

	@Then("click on the remove icon to remove one of the added role")
	public void click_on_the_remove_icon_to_remove_one_of_the_added_role() throws Exception {
		driver.findElement(By.xpath("(//a[@class='remove_fields dynamic'])[2]/i")).click();
		Thread.sleep(1000);
	}

	@And("click on the save button from the roles page")
	public void click_on_the_save_button_from_the_roles_page() throws Exception {
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@When("save button is clicked it will redirect to the users role page")
	public void save_button_is_clicked_it_will_redirect_to_the_users_role_page() {
	}

	@Then("click on the edit button and make changes")
	public void click_on_the_edit_button_and_make_changes() throws Exception {
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(3000);
		// number
		driver.findElement(By.cssSelector("input#nmbr")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// number
		driver.findElement(By.cssSelector("input#nmbr")).sendKeys("6566566561");
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the save button from the edit user role")
	public void click_on_the_save_button_from_the_edit_user_role() throws Exception {
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
		// share credentials
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Credetiatls'])[1]")).click();
		Thread.sleep(2000);
		// select create a password
		WebElement createpswd = driver.findElement(By.xpath("(//label[text()='Create Password'])[1]"));
		createpswd.click();
		Thread.sleep(1000);
		// entering test dummy password
		driver.findElement(By.cssSelector("input#user_password")).sendKeys("Demo@123");
		Thread.sleep(1000);
		// select automatically generate a password
		WebElement automatpswd = driver
				.findElement(By.xpath("(//label[text()='Automatically generate a password'])[1]"));
		createpswd.click();
		Thread.sleep(1000);
		// share
		driver.findElement(By.xpath("(//input[@value='Share'])[1]")).click();
		Thread.sleep(5000);
		// // confirm
		// driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		// Thread.sleep(3000);

		// searching through filter
		driver.findElement(By.cssSelector("input#q_frst_nm_or_lst_nm_cont")).sendKeys("userrole");
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.cssSelector("a.btn.clear_btn.btn-loader")).click();
		Thread.sleep(2000);

	}

	@Then("navigate to the masterdata dashboard from teamdetails page")
	public void navigate_to_the_masterdata_dashboard_from_teamdetails_page() throws Exception {
		// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		Thread.sleep(1000);
		driver.close();
	}

	@Then("click on the team details button from the masterdata")
	public void click_on_the_team_details_button_from_the_masterdata() throws Exception {
		WebDriverWait teamdetails = new WebDriverWait(driver, Duration.ofSeconds(30));
		teamdetails
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='User Details'])[1]"))))
				.click();
		Thread.sleep(3000);
	}

	@And("click on the plus button to add new healthcoach from teamdetails")
	public void click_on_the_plus_button_to_add_new_healthcoach_from_teamdetails() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New User'])[1]/i")).click();
		Thread.sleep(3000);
	}

	@Then("enter the details like first and last name age email no profile picture")
	public void enter_the_details_like_first_and_last_name_age_email_no_profile_picture() throws Exception {
		driver.findElement(By.cssSelector("input#first_name")).sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#lst_name")).sendKeys("Healthcoach");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement female = driver.findElement(By.xpath("(//label[text()='F'])[1]"));
			female.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.findElement(By.cssSelector("input#age")).sendKeys("35");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("email")).sendKeys("cucumhc@gmail.com");
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[2]"));
			active.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// driver.findElement(By.cssSelector("input#files_constr"))
		// .sendKeys("C:\\Users\\Lenovo\\Desktop\\Uploads\\hc.png");
		// Thread.sleep(1000);
		// Robot robot1 = new Robot();
		// robot1.keyPress(KeyEvent.VK_TAB);
		// Thread.sleep(1000);
	}

	@And("click on the continue button from the team details")
	public void click_on_the_continue_button_from_the_team_details() throws Exception {
		WebDriverWait cont = new WebDriverWait(driver, Duration.ofSeconds(30));
		cont.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("select the role as healthcoach from the dropdown")
	public void select_the_role_as_healthcoach_from_the_dropdown() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[8]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='HealthCoach'])[1]")).click();
		Thread.sleep(1000);
	}

	@When("healthcoach role is selected location will be automatically update")
	public void healthcoach_role_is_selected_location_will_be_automatically_update() throws Exception {
	}

	@Then("select the city and area from the dropdown")
	public void select_the_city_and_area_from_the_dropdown() throws Exception {
		driver.findElement(By.xpath("(//label[text()='City'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[contains(text(),'Hyd')])[1]")).click();
		Thread.sleep(2000);
		// selecting the area
		driver.findElement(By.xpath("(//li[contains(text(),'IndiraNagar_1')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Programs'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		// selecting the program
		driver.findElement(By.xpath("(//li[text()='NanoHealth Program1'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("click on the more button to add more details")
	public void click_on_the_more_button_to_add_more_details() throws InterruptedException {
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("enable the required checkboxes")
	public void enable_the_required_checkboxes() {
		for (int i = 0; i <= 2; i++) {
			WebElement fa = driver.findElement(By.xpath("(//label[text()='Full Access'])[1]"));
			fa.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement ma = driver.findElement(By.xpath("(//label[text()='Master Data Access'])[1]"));
			ma.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 1; i++) {
			WebElement a = driver.findElement(By.xpath("(//label[text()='Active'])[3]"));
			a.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement v = driver.findElement(By.xpath("(//label[text()='Verified'])[1]"));
			v.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	}

	@And("upload the Aadhar PAN files")
	public void upload_the_Aadhar_PAN_files() throws Exception {
		// Aadhar
		driver.findElement(By.cssSelector("a#uploadAadhar"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\Aadharcard.png");
		Thread.sleep(1000);
		// PAN
		driver.findElement(By.cssSelector("input#files_pan"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\Pancard.jpg");
		Thread.sleep(1000);
	}

	@Then("click on the save button from the popup to create a new healhcoach")
	public void click_on_the_save_button_from_the_popup_to_create_a_new_healhcoach() throws Exception {
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
				.click();
		Thread.sleep(5000);
	}

	@And("edit the age and save the user of healthcoach")
	public void edit_the_age_and_save_the_user_of_healthcoach() throws Exception {
		WebDriverWait edit = new WebDriverWait(driver, Duration.ofSeconds(30));
		edit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]"))))
				.click();
		// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(3000);
		// age
		driver.findElement(By.cssSelector("input#age")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#age")).sendKeys("45");
		Thread.sleep(2000);
		WebDriverWait cont = new WebDriverWait(driver, Duration.ofSeconds(30));
		cont.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Continue'])[1]"))))
				.click();
		Thread.sleep(3000);
//		// adding another program and saving
//		driver.findElement(By.xpath("(//label[text()='Programs'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//li[text()='NH Client'])[1]")).click();
//		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Then("click on the healthcoach role")
	public void click_on_the_healthcoach_role() throws Exception {
		driver.findElement(By.xpath("(//div[@class='user_detl_dropdown'])[1]/a[1]")).click();
		Thread.sleep(3000);
	}

	@And("download the profile and assign device and assign tablet")
	public void download_the_profile_and_assign_device_and_assign_tablet() throws Exception {
//		driver.findElement(By.xpath("(//a[@data-tooltip='Profile Download'])[1]/img")).click();
//		Thread.sleep(3000);
		// assign devices
		driver.findElement(By.xpath("(//a[@data-tooltip='Assign Devices'])[1]/img")).click();
		Thread.sleep(3000);
		// clicking on the add button
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
		// device type
		driver.findElement(By.xpath("(//span[@class='selection'])[4]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Cucum device type'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// device automatically will be selected
		// clicking on the add button
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
		// remove
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(5000);

		// clicking on the healthcoach role
		driver.findElement(By.xpath("(//div[@class='user_detl_dropdown'])[1]/a[1]")).click();
		Thread.sleep(3000);
		// assign tablet
		driver.findElement(By.xpath("(//a[@data-tooltip='Assign Tablet'])[1]/img")).click();
		Thread.sleep(2000);
		// app access
		for (int i = 0; i <= 1; i++) {
			WebElement appaccess = driver.findElement(By.xpath("(//label[@for='app_access'])[1]"));
			appaccess.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// mouse hover on the i
		Actions icard = new Actions(driver);
		icard.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-info-circle'])[1]"))).build().perform();
		Thread.sleep(1000);
		// device id
		driver.findElement(By.cssSelector("input#imei_code")).sendKeys("9cucum12hcimeicd");
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			// area-wise syncup
			WebElement syncup = driver.findElement(By.xpath("(//label[@for='area_sync'])[1]"));
			syncup.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		// searching with mobile/email
		driver.findElement(By.cssSelector("input#q_mobile_or_email_cont")).sendKeys("cucumhc@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='HealthCoach'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
		driver.close();
	}

	@And("changing role from clinicmanager to ipbillingmanager to create new ipprocedure")
	public void changing_role_from_clinicmanager_to_ipbillingmanager_to_create_new_ipprocedure() throws Exception {
		// clicking on the brand logo & changing role
		WebDriverWait logoclick = new WebDriverWait(driver, Duration.ofSeconds(30));
		logoclick.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]"))))
				.click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on IP Billing manager Role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[14]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Master Data']"))).click().build().perform();
		Thread.sleep(1000);
	}

	@Then("click on the charge masters from the dashboard to create ipprocedure")
	public void click_on_the_charge_masters_from_the_dashboard_to_create_ipprocedure() throws Exception {
		// clicking on the charge masters
		driver.findElement(By.xpath("(//a[text()='Charge Masters'])[2]")).click();
		Thread.sleep(3000);
	}

	@And("create a new ip procedure using surgery masters from the charge master")
	public void create_a_new_ip_procedure_using_surgery_masters_from_the_charge_master() throws InterruptedException {
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New Surgery'])[1]/i[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Service Name'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='IP Procedure'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#surgery_master_surgery_name")).sendKeys("Cucum ip pro");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[text()='arrow_drop_down'])[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Role Type'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Clinic_Manager'])[1]")).click();
		Thread.sleep(2000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("click on add new charge master from the charge masters")
	public void click_on_add_new_charge_master_from_the_charge_masters() throws InterruptedException {
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New Charge Code Detail'])[2]/i[1]")).click();
		Thread.sleep(3000);
	}

	@And("select the hospital service type service name code master")
	public void select_the_hospital_service_type_service_name_code_master() throws InterruptedException {
		driver.findElement(By.xpath("(//label[text()='Hospital'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Professional Fees'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()='Service Name'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='IP Procedure'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='DUMMYPC'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("select the ipprocedure using dropdown created before using surgery master")
	public void select_the_ipprocedure_using_dropdown_created_before_using_surgery_master()
			throws InterruptedException {
		driver.findElement(By.xpath("(//label[text()='Hospital Procedure Name'])[1]/following-sibling::span[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucum ip pro'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("enter the base price and select the variable price")
	public void enter_the_base_price_and_select_the_variable_price() throws Exception {
		driver.findElement(By.xpath("(//input[@id='hospital_surgery_mapping_master_price'])[1]")).sendKeys("10000");
		Thread.sleep(1000);

	}

	@Then("select the price type as self defined")
	public void select_the_price_type_as_self_defined() throws InterruptedException {
		WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		yes.click();
		Thread.sleep(2000);
		WebElement selfdefined = driver.findElement(By.xpath("(//label[text()='Self defined'])[1]"));
		selfdefined.click();
		Thread.sleep(2000);
	}

	@And("add provider and demand programs and save the ipprocedure")
	public void add_provider_and_demand_programs_and_save_the_ipprocedure() throws Exception {
		driver.findElement(By.xpath("(//label[text()='Health System'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Provider'])[1]")).click();
		Thread.sleep(1000);
		// entering the charge code
		driver.findElement(By.xpath("(//input[@class='charge_code_input'])[1]")).sendKeys("Cucum-ip1");
		Thread.sleep(2000);

//		// clicking on the plus to add new demand program
//		driver.findElement(By.xpath("(//i[text()='add'])[4]")).click();
//		Thread.sleep(1000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//label[text()='Health System'])[2]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Provider'])[1]")).click();
//		Thread.sleep(1000);
//		// entering the charge code
//		driver.findElement(By.xpath("(//input[@class='charge_code_input'])[2]")).sendKeys("Cucum-ip2");
//		Thread.sleep(2000);
//		// changing demand program
//		driver.findElement(By.xpath("(//label[text()='Program'])[2]/following-sibling::span[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//li[text()='NH Client'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//label[text()='Price'])[2]/following-sibling::input[1]")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Price'])[2]/following-sibling::input[1]")).sendKeys("25000");
//		Thread.sleep(2000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(5000);
	}

	@Then("select the facility and service and search for the ipprocedure")
	public void select_the_facility_and_service_and_search_for_the_ipprocedure() throws Exception {
		driver.findElement(By.xpath("(//label[text()='Facility'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Service'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='IP Procedure'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
//		// download
//		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
//		Thread.sleep(5000);
//		// reset
//		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
//		Thread.sleep(2000);

	}

	@And("edit and save the ipprocedure")
	public void edit_and_save_the_ipprocedure() throws Exception {
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#hospital_surgery_mapping_master_surgery_label_name")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#hospital_surgery_mapping_master_surgery_label_name"))
				.sendKeys("Cucum ip procedures");
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[text()='Facility'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Service'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='IP Procedure'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);

		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(5000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);

	}

	@And("navigate to the masterdata dashboard from ip procedures page")
	public void navigate_to_the_masterdata_dashboard_from_ip_procedures_page() throws Exception {
		driver.close();
	}

	@Then("click on the minor procedures from the dashboard")
	public void click_on_the_minor_procedures_from_the_dashboard() throws Exception {
		// clicking on the charge masters
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[9]/a")).click();
		Thread.sleep(3000);
		// creating new op procedure from charge masters
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add New Surgery'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New Surgery'])[1]/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@id='select2-surgery_master_service_id-container'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Minor Procedure'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#surgery_master_surgery_name")).sendKeys("Cucum op procedure");
		Thread.sleep(1000);
		WebElement no = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
		no.click();
		Thread.sleep(2000);
		WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		yes.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[text()='arrow_drop_down'])[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@id='select2-surgery_master_role_master_id-container'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Clinic_Manager'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='All'])[1]")).click();
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
		driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		Thread.sleep(2000);

		// clicking on the minor procedures
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[7]/a")).click();
		Thread.sleep(3000);
		String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
		System.out.println(md);
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add New Minor Procedures'])[1]/i[1]")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New Minor Procedures'])[1]/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Procedure'])[2]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucum op procedure'])[1]")).click();
		Thread.sleep(1000);
		// entering price
		driver.findElement(By.cssSelector("input#hospital_surgery_mapping_master_price")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#hospital_surgery_mapping_master_price")).sendKeys("500");
		Thread.sleep(2000);
//		Robot robot = new Robot();
//		for (int i = 0; i <= 1; i++) {
//			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[2]"));
//			active.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
//		driver.findElement(By.xpath("(//label[text()='Program Name'])[1]/following-sibling::span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='NanoHealth Program1'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Service Price'])[1]/following-sibling::input[1]"))
//				.sendKeys("400");
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Service Price'])[1]/following-sibling::input[1]")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Service Price'])[1]/following-sibling::input[1]"))
//				.sendKeys("500");
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);

		// variable price - yes
		WebElement Yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		Yes.click();
		Thread.sleep(2000);
		// variable price - no
		WebElement No = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
		No.click();
		Thread.sleep(2000);

		// variable price - yes
		WebElement Yes1 = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		Yes1.click();
		Thread.sleep(2000);
		// clicking on the continue button
		driver.findElement(By.cssSelector("input.btn.green.right.prcdbtn.continue_btn")).click();
		Thread.sleep(3000);

		// clicking on the self-defined
		WebElement selfdef = driver.findElement(By.xpath("(//label[text()='Self defined'])[1]"));
		selfdef.click();
		Thread.sleep(2000);
		// entering charge code
		driver.findElement(By.xpath("(//label[text()='Charge Code'])[1]/following-sibling::input[1]"))
				.sendKeys("Cucum-Hcs-01");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clear & entering the charge label name
		driver.findElement(By.xpath("(//label[text()='Charge Label Name'])[1]/following-sibling::input[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Charge Label Name'])[1]/following-sibling::input[1]"))
				.sendKeys("Cucum op-self");
		Thread.sleep(1000);
		// selecting the program
		driver.findElement(By.xpath("(//label[text()='Program'])[1]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='NanoHealth Program1'])[1]")).click();
		Thread.sleep(1000);
		// selecting the payment mode
		driver.findElement(By.xpath("(//label[text()='Payment Mode'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Self'])[1]")).click();
		Thread.sleep(1000);
		// clearing & entering the price
		driver.findElement(By.xpath("(//label[text()='Price'])[3]/following-sibling::input[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Price'])[3]/following-sibling::input[1]")).sendKeys("1000");
		Thread.sleep(1000);

		// clicking on the add button
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
		// entering charge code
		driver.findElement(By.xpath("(//label[text()='Charge Code'])[2]/following-sibling::input[1]"))
				.sendKeys("Cucum-Hcs-02");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clear & entering the charge label name
		driver.findElement(By.xpath("(//label[text()='Charge Label Name'])[2]/following-sibling::input[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Charge Label Name'])[2]/following-sibling::input[1]"))
				.sendKeys("Cucum op-self2");
		Thread.sleep(1000);
		// selecting the program
		driver.findElement(By.xpath("(//label[text()='Program'])[2]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='All'])[1]")).click();
		Thread.sleep(1000);
		// selecting the payment mode
		driver.findElement(By.xpath("(//label[text()='Payment Mode'])[2]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Insurance'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Apollo Munich Health Insurance Company Limited'])[1]")).clear();
		Thread.sleep(1000);
		// remove
		driver.findElement(By.xpath("(//a/i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("/html/body/main/div/div[3]/div/div[2]/form/ul/li[2]/div[2]/div/div/form/div[3]/input"))
				.click();
		Thread.sleep(2000);

		// clicking on the save button
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);

	}

	@And("edit the minor procedure and save it")
	public void edit_the_minor_procedure_and_save_it() throws Exception {
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Service Price'])[1]/following-sibling::input[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Service Price'])[1]/following-sibling::input[1]"))
				.sendKeys("600");
		Thread.sleep(1000);
		// continue
		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		Thread.sleep(2000);
//		// remove
//		driver.findElement(By.xpath("(//a/i[@class='fa fa-times-circle'])[2]")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucum op procedure'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the minor procedure name
		driver.findElement(By.xpath("(//div[@id='search-results'])[1]/table/tbody/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(3000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='newSurgeryMaster-modal'])[1]/div/div[1]/span[1]/i[1]")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
		driver.close();

	}

	@And("searching through using service dropdown for minorprocedures1")
	public void searching_through_using_service_dropdown_for_minorprocedures1() throws Exception {
		// // service name search
		// driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(By.xpath("//li[text()='test']")).click();
		// Thread.sleep(1000);
	}

	@Then("clicking on the search button and reseting after for minorprocedures1")
	public void clicking_on_the_search_button_and_reseting_after_for_minorprocedures1() throws Exception {
		// // search
		// driver.findElement(By.xpath("//input[@name='commit']")).click();
		// Thread.sleep(1000);
		// // reset
		// driver.findElement(By.xpath("//a[text()='Reset']")).click();
		// Thread.sleep(1000);
	}

	@And("searching using through active dropdown for minorprocedures2")
	public void searching_using_through_active_dropdown_for_minorprocedures2() throws Exception {
		// // active
		// driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(By.xpath("//li[text()='Yes']")).click();
		// Thread.sleep(1000);
	}

	@Then("clicking on the search button and reseting after for minorprocedures2")
	public void clicking_on_the_search_button_and_reseting_after_for_minorprocedures2() throws Exception {
		// // search
		// driver.findElement(By.xpath("//input[@name='commit']")).click();
		// Thread.sleep(1000);
		// // reset
		// driver.findElement(By.xpath("//a[text()='Reset']")).click();
		// Thread.sleep(1000);
	}

	@And("navigate to the masterdata dashboard from minor procedures page")
	public void navigate_to_the_masterdata_dashboard_from_minor_procedures_page() throws Exception {
		//// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		// Thread.sleep(1000);
		// driver.close();
	}

	// @Then("click on the chargemaster button from the dashboard")
	// public void click_on_the_chargemaster_button_from_the_dashboard() throws
	// Exception {
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[7]/a")).click();
	// Thread.sleep(1000);
	// String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
	// System.out.println(md);
	// }
	//
	// @When("plus button is clicked to add new charge master")
	// public void plus_button_is_clicked_to_add_new_charge_master() throws
	// Exception {
	// driver.findElement(By.xpath("(//a[@data-tooltip='Add New Charge Code
	// Detail'])[2]/i[1]")).click();
	// Thread.sleep(3000);
	//
	// }
	//
	// @And("select the service type from the dropdown")
	// public void select_the_service_type_from_the_dropdown() {
	// // selecting the hospital from dropdown
	// driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("(//li[text()='NH_OP'])[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// // selecting the service type
	//// driver.findElement(By.xpath("(//span[@class='selection'])[4]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("(//li[text()='Professional
	// Fees'])[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// }
	//
	// @When("professional fees is selected from service type service name will
	// automatically selected")
	// public void
	// professional_fees_is_selected_from_service_type_service_name_will_automatically_selected()
	// {
	//
	// }
	//
	// @Then("select the service detail from the dropdown")
	// public void select_the_service_detail_from_the_dropdown() {
	// driver.findElement(By.xpath("(//li[text()='Dr. NH Doctor'])[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//
	// }
	//
	// @And("enter hospital service name")
	// public void enter_hospital_service_name() {
	// driver.findElement(By.cssSelector("input#hospital_surgery_mapping_master_alias")).sendKeys("test
	// service name");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// }
	//
	// @Then("enter the base price")
	// public void enter_the_base_price() throws Exception {
	// driver.findElement(By.cssSelector("input#hospital_surgery_mapping_master_price")).sendKeys("50");
	// Thread.sleep(1000);
	// }
	//
	// @When("valuable price radio button yes is selected it will show other
	// options")
	// public void
	// valuable_price_radio_button_yes_is_selected_it_will_show_other_options()
	// throws Exception {
	// WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
	// yes.click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// Thread.sleep(1000);
	//
	// WebElement selfdefined = driver.findElement(By.xpath("(//label[text()='Self
	// defined'])[1]"));
	// selfdefined.click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// Thread.sleep(1000);
	//
	// WebElement flatinc = driver.findElement(By.xpath("(//label[text()='Flat
	// increase'])[1]"));
	// flatinc.click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// Thread.sleep(1000);
	//
	// WebElement perinc = driver.findElement(By.xpath("(//label[text()='Percentage
	// increase'])[1]"));
	// perinc.click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// Thread.sleep(1000);
	//
	// // clicking on the no radio button
	// WebElement no = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
	// no.click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.cssSelector("input#hospital_surgery_mapping_master_price")).clear();
	// Thread.sleep(1000);
	// driver.findElement(By.cssSelector("input#hospital_surgery_mapping_master_price")).sendKeys("50");
	// Thread.sleep(1000);
	// }
	//
	// @And("click on the save button from the charge masters popup")
	// public void click_on_the_save_button_from_the_charge_masters_popup() throws
	// Exception {
	// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
	// Thread.sleep(4000);
	// }
	//
	// @Then("click on the edit button from the charge masters")
	// public void click_on_the_edit_button_from_the_charge_masters() throws
	// Exception {
	// driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("(//li[text()='NH_OP'])[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("(//li[text()='Doctor
	// Consultation'])[1]")).click();
	// Thread.sleep(2000);
	// // search
	// driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
	// Thread.sleep(3000);
	// // edit
	// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
	// Thread.sleep(3000);
	// }
	//
	// @And("edit and save the charge masters")
	// public void edit_and_save_the_charge_masters() throws Exception {
	// driver.findElement(By.cssSelector("input#hospital_surgery_mapping_master_price")).clear();
	// Thread.sleep(1000);
	// driver.findElement(By.cssSelector("input#hospital_surgery_mapping_master_price")).sendKeys("500");
	// Thread.sleep(2000);
	// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
	// Thread.sleep(3000);
	// }
	//
	// @Then("search newly created charge masters from the search dropdown")
	// public void search_newly_created_charge_masters_from_the_search_dropdown()
	// throws Exception {
	// driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("(//li[text()='NH_OP'])[1]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("(//li[text()='Doctor
	// Consultation'])[1]")).click();
	// Thread.sleep(2000);
	// // search
	// driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
	// Thread.sleep(3000);
	// // download
	// Actions action = new Actions(driver);
	// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i"))).build().perform();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i")).click();
	// Thread.sleep(3000);
	// // reset
	// driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
	// Thread.sleep(2000);
	// }
	//
	// @And("navigate to the masterdata dashboard from the charge masters")
	// public void navigate_to_the_masterdata_dashboard_from_the_charge_masters()
	// throws Exception {
	//// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
	// Thread.sleep(1000);
	// driver.close();
	// }

	@Then("click on the room masters from the dashboard")
	public void click_on_the_room_masters_from_the_dashboard() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Patient Rooms'])[1]")).click();
		Thread.sleep(2000);
		String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
		System.out.println(md);
	}

	@And("click on the room type details from the clinic room masters page")
	public void click_on_the_room_type_details_from_the_clinic_room_masters_page() throws Exception {
		// // clicking on the room type details
		// driver.findElement(By.xpath("//a[text()='Room Type Details']")).click();
		// Thread.sleep(1000);

	}

	@Then("deleting the room type and room details from UI")
	public void deleting_the_room_type_and_room_details_from_UI() throws Exception {
		// // clicking on the room details
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Room
		// Details'])[1]"))))
		// .click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//li[text()='Cucumber room
		// type'])[1]")).click();
		// Thread.sleep(1000);
		// // search
		// WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		// search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
		// .click();
		// Thread.sleep(2000);
		// // mouse hover on the delete
		// Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Delete
		// Room Detail'])[1]"))).build()
		// .perform();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//a[@data-tooltip='Delete Room
		// Detail'])[1]")).click();
		// Thread.sleep(1000);
		// // confirm
		// driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		// Thread.sleep(2000);
		//
		// // clicking on the room type details
		// driver.findElement(By.xpath("//a[text()='Room Type Details']")).click();
		// Thread.sleep(1000);
		// // SEARCH
		// driver.findElement(By.cssSelector("input#q_room_type_cont")).sendKeys("Cucumber");
		// Thread.sleep(1000);
		// WebDriverWait search1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		// search1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
		// .click();
		// Thread.sleep(3000);
		// // mouse hover on the delete
		// Actions del = new Actions(driver);
		// del.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Delete
		// Room Type'])[1]"))).build().perform();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("(//a[@data-tooltip='Delete Room
		// Type'])[1]")).click();
		// Thread.sleep(2000);
		// // confirm
		// driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		// Thread.sleep(2000);

		// clicking on the room type details
		driver.findElement(By.xpath("//a[text()='Room Type Details']")).click();
		Thread.sleep(1000);
	}

	@Then("click on the plus to add room type")
	public void click_on_the_plus_to_add_room_type() throws Exception {
		// clicking on the plus - add room type
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add Room Type'])[1]/i"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Room Type'])[1]/i")).click();
		Thread.sleep(1000);
	}

	@And("enter the following details")
	public void enter_the_following_details(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> rm = dataTable.asLists(String.class);
		// room-type
		driver.findElement(By.cssSelector("input#clinic_room_type_master_room_type")).sendKeys(rm.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// description
		driver.findElement(By.cssSelector("input#clinic_room_type_master_desc")).sendKeys(rm.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("clicking on the dropdown charge code master")
	public void clicking_on_the_dropdown_charge_code_master() {
		// clicking on the drop-down
		driver.findElement(By.xpath("//span[@class='selection']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("selecting the general ward  charges")
	public void selecting_the_general_ward_charges() throws Exception {
		driver.findElement(By.xpath("(//li[text()='101001 (General Ward charges)'])[1]")).click();
		Thread.sleep(1000);
		// is-active
		// no
		WebElement no = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
		no.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// yes
		WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		yes.click();
		Thread.sleep(1000);
	}

	@Then("click on the save button from the room type details")
	public void click_on_the_save_button_from_the_room_type_details() throws Exception {
		// clicking on the save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("click on the edit button and update the room type name")
	public void click_on_the_edit_button_and_update_the_room_type_name() throws Exception {
		// clicking on the edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(1000);
		// room-type
		driver.findElement(By.cssSelector("input#clinic_room_type_master_room_type")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#clinic_room_type_master_room_type")).sendKeys("Cucumber room type");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on save button from the edit room type details page")
	public void click_on_save_button_from_the_edit_room_type_details_page() throws Exception {
		// clicking on the save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(2000);
		// SEARCH
		driver.findElement(By.cssSelector("input#q_room_type_cont")).sendKeys("Cucumber");
		Thread.sleep(1000);
		WebDriverWait search1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		search1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(3000);

	}

	@And("click on the Room details in the header section")
	public void click_on_the_room_details_in_the_header_section() throws Exception {
		// clicking on the room details
		driver.findElement(By.xpath("//a[text()='Room Details']")).click();
		Thread.sleep(2000);

	}

	@Then("click on the plus button to room")
	public void click_on_the_plus_button_to_room() throws Exception {
		// click on add room + button
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(1000);
	}

	@And("selecting the room type from the dropdown")
	public void selecting_the_room_type_from_the_dropdown() throws Exception {
		// selecting the site from the dropdown
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(
				By.xpath("/html/body/main/div/div[4]/div/div[2]/form/div[1]/div[1]/div/span/span[1]/span")))).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
		Thread.sleep(1000);

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		// Thread.sleep(1000);

		// driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//li[text()='Cucumber room type']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("entering the following details into room details")
	public void entering_the_following_details_into_room_details(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> rm = dataTable.asLists(String.class);
		// entering the room no
		driver.findElement(By.id("clinic_room_master_room_number")).sendKeys(rm.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("clinic_room_master_desc")).sendKeys(rm.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("clinic_room_master_price")).sendKeys(rm.get(2).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//label[text()='Bed no.'])[1]/following-sibling::input[1]"))
				.sendKeys(rm.get(3).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//label[text()='Description'])[2]/following-sibling::input[1]"))
				.sendKeys(rm.get(4).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("click on the plus button to add another bed in the same room")
	public void click_on_the_plus_button_to_add_another_bed_in_the_same_room(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		List<List<String>> rm = dataTable.asLists(String.class);
		// clicking on the add button
		driver.findElement(By.xpath("(//i[text()='add'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Bed no.'])[2]/following-sibling::input[1]"))
				.sendKeys(rm.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//label[text()='Description'])[3]/following-sibling::input[1]"))
				.sendKeys(rm.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("input#clinic_room_master_price")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("input#clinic_room_master_price")).sendKeys(rm.get(2).get(1));
		Thread.sleep(1000);
	}

	@And("removing the last added room")
	public void removing_the_last_added_room() throws Exception {
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(1000);
	}

	@Then("click on the save button from the room details popup")
	public void click_on_the_save_button_from_the_room_details_popup() throws Exception {
		// save
		driver.findElement(By.xpath("/html/body/main/div/div[4]/div/div[2]/form/div[4]/input[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the edit button and update the price")
	public void click_on_the_edit_button_and_update_the_price() throws Exception {
		// clicking on the edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("/html/body/main/div/div[4]/div/div[2]/form/div[2]/div[1]/div/div[2]/div/div[3]/div/input"))
				.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(
				By.xpath("/html/body/main/div/div[4]/div/div[2]/form/div[2]/div[1]/div/div[2]/div/div[3]/div/input"))
				.sendKeys("1000");
		Thread.sleep(1000);

	}

	@Then("click on the save button from the edit room details popup")
	public void click_on_the_save_button_from_the_edit_room_details_popup() throws Exception {
		driver.findElement(By.xpath("/html/body/main/div/div[4]/div/div[2]/form/div[4]/input[1]")).click();
		Thread.sleep(5000);

		// search with filters-site
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='NanoHealth_IPD'])[1]")).click();
		Thread.sleep(1000);
		WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);

		// search with filters-room type
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucumber room type'])[1]")).click();
		Thread.sleep(1000);
		WebDriverWait search1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		search1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);

		// search with filters-room type
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucumber room type'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#q_room_number_cont")).sendKeys("101");
		Thread.sleep(1000);
		WebDriverWait search2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		search2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("navigate to the masterdata dashboard from room masters page")
	public void navigate_to_the_masterdata_dashboard_from_room_masters_page() throws Exception {
		// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		Thread.sleep(1000);
		driver.close();
	}

	@Then("click on the home care services from the masterdata dashboard")
	public void click_on_the_home_care_services_from_the_masterdata_dashboard() throws InterruptedException, Exception {
		// clicking on the charge masters
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[9]/a")).click();
		Thread.sleep(3000);
		// creating new homecare procedure from charge masters
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add New Surgery'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New Surgery'])[1]/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@id='select2-surgery_master_service_id-container'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Home Care'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#surgery_master_surgery_name")).sendKeys("Cucum Hcs");
		Thread.sleep(1000);
		WebElement no = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
		no.click();
		Thread.sleep(2000);
		WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		yes.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[text()='arrow_drop_down'])[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@id='select2-surgery_master_role_master_id-container'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Clinic_Manager'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='All'])[1]")).click();
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
		// // edit and save
		// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.cssSelector("input#surgery_master_surgery_name")).clear();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.cssSelector("input#surgery_master_surgery_name")).sendKeys("Cucum
		// Hcs");
		// Thread.sleep(2000);
		// // save
		// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		// Thread.sleep(2000);
		driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		Thread.sleep(2000);
		// clicking on the home care services
		driver.findElement(By.xpath("(//a[text()='Home Care services'])[1]")).click();
		Thread.sleep(3000);
		String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
		System.out.println(md);
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add New HomeCare Services'])[1]/i[1]")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New HomeCare Services'])[1]/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Procedure'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucum Hcs'])[1]")).click();
		Thread.sleep(2000);
		// entering price
		driver.findElement(By.xpath("(//label[text()='Price'])[1]/following-sibling::input[1]")).sendKeys("500");
		Thread.sleep(2000);
		Robot robot = new Robot();
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[2]"));
			active.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		// variable price - yes
		WebElement Yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		Yes.click();
		Thread.sleep(2000);
		// variable price - no
		WebElement No = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
		No.click();
		Thread.sleep(2000);
//		// variable price - yes
//		WebElement Yes1 = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
//		Yes1.click();
//		Thread.sleep(2000);
//		// clicking on the continue button
//		driver.findElement(By.xpath("input.btn.green.right.prcdbtn.continue_btn")).click();
//		Thread.sleep(3000);
//
//		// clicking on the self-defined
//		WebElement selfdef = driver.findElement(By.xpath("(//label[text()='Self defined'])[1]"));
//		selfdef.click();
//		Thread.sleep(2000);
//		// entering charge code
//		driver.findElement(By.xpath("(//label[text()='Charge Code'])[1]/following-sibling::input[1]"))
//				.sendKeys("Cucum-Hcs-01");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// clear & entering the charge label name
//		driver.findElement(By.xpath("(//label[text()='Charge Label Name'])[1]/following-sibling::input[1]")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Charge Label Name'])[1]/following-sibling::input[1]"))
//				.sendKeys("Cucum Hcs-self");
//		Thread.sleep(1000);
//		// selecting the program
//		driver.findElement(By.xpath("(//label[text()='Program'])[1]/following-sibling::span[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//li[text()='NanoHealth Program1'])[1]")).click();
//		Thread.sleep(1000);
//		// selecting the payment mode
//		driver.findElement(By.xpath("(//label[text()='Payment Mode'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Self'])[1]")).click();
//		Thread.sleep(1000);
//		// clearing & entering the price
//		driver.findElement(By.xpath("(//label[text()='Price'])[3]/following-sibling::input[1]")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Price'])[3]/following-sibling::input[1]")).sendKeys("1000");
//		Thread.sleep(1000);
//
//		// clicking on the add button
//		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
//		Thread.sleep(2000);
//		// entering charge code
//		driver.findElement(By.xpath("(//label[text()='Charge Code'])[2]/following-sibling::input[1]"))
//				.sendKeys("Cucum-Hcs-02");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// clear & entering the charge label name
//		driver.findElement(By.xpath("(//label[text()='Charge Label Name'])[2]/following-sibling::input[1]")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Charge Label Name'])[2]/following-sibling::input[1]"))
//				.sendKeys("Cucum Hcs-self2");
//		Thread.sleep(1000);
//		// selecting the program
//		driver.findElement(By.xpath("(//label[text()='Program'])[2]/following-sibling::span[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//li[text()='All'])[1]")).click();
//		Thread.sleep(1000);
//		// selecting the payment mode
//		driver.findElement(By.xpath("(//label[text()='Payment Mode'])[2]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Insurance'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Apollo Munich Health Insurance Company Limited'])[1]")).clear();
//		Thread.sleep(1000);
//		// remove
//		driver.findElement(By.xpath("(//a/i[@class='fa fa-times-circle'])[2]")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@And("edit and save the homecareservices")
	public void edit_and_save_the_homecareservices() throws Exception {
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(1000);
		// continue
		driver.findElement(By.xpath("(//input[@value='Continue'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucum Hcs'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Yes'])[1]")).click();
		Thread.sleep(2000);

		// search
		WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(2000);
		// clicking on the home care service name
		driver.findElement(By.xpath("(//div[@id='search-results'])[1]/table/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(3000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='newSurgeryMaster-modal'])[1]/div/div[1]/span[1]/i[1]")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
		// download report
		Actions rep = new Actions(driver);
		rep.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Download Reports'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(1000);
		WebDriverWait download = new WebDriverWait(driver, Duration.ofSeconds(30));
		download.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Download Reports'])[1]/i[1]")))).click();
		Thread.sleep(3000);
		driver.close();
	}

	@And("searching through the service name for hcs")
	public void searching_through_the_service_name_for_hcs() {
		// // clicking on the service name
		// driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(By.xpath("//li[text()='Home service1']")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the search and reset buttons after getting the results1")
	public void click_on_the_search_and_reset_buttons_after_getting_the_results1() throws Exception {
		// // search
		// driver.findElement(By.xpath("//input[@name='commit']")).click();
		// Thread.sleep(1000);
		// // reset
		// driver.findElement(By.xpath("//a[text()='Reset']")).click();
		// Thread.sleep(1000);
	}

	@And("searching through the active for hcs")
	public void searching_through_the_active_for_hcs() {
		// // searching through the active
		// driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(By.xpath("//li[text()='Yes']")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("clicking on the search and reset buttons after getting the results2")
	public void clicking_on_the_search_and_reset_buttons_after_getting_the_results2() throws Exception {
		// search
		// driver.findElement(By.xpath("//input[@name='commit']")).click();
		// Thread.sleep(1000);
		// // reset
		// driver.findElement(By.xpath("//a[text()='Reset']")).click();
		// Thread.sleep(1000);
	}

	@And("navigate to the masterdata dashboard from home care services page")
	public void navigate_to_the_masterdata_dashboard_from_home_care_services_page() throws Exception {
		//// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		// Thread.sleep(1000);
		// driver.close();
	}

	@Then("click on the brandmaster from the masterdata dashboard")
	public void click_on_the_brandmaster_from_the_masterdata_dashboard() throws Exception {
		driver.findElement(By.xpath("(//a[text()='BrandMasters'])[3]")).click();
		Thread.sleep(1000);
		String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
		System.out.println(md);
	}

	@And("click on plus button to add new brand")
	public void click_on_plus_button_to_add_new_brand() throws Exception {
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(1000);
	}

	@Then("select the category of the brand using dropdown")
	public void select_the_category_of_the_brand_using_dropdown() throws Exception {
		driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[1]/div[1]/div/span/span[1]/span"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//li[text()='Vaccine']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("select the manufacturer of the brand using dropdown")
	public void select_the_manufacturer_of_the_brand_using_dropdown() throws Exception {
		driver.findElement(By.xpath("(//li[text()='Alcon Laboratories (India) Private Limited'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@Then("select the form of the brand using dropdown")
	public void select_the_form_of_the_brand_using_dropdown() throws Exception {
		driver.findElement(By.xpath("//li[text()='Tablet']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("enter the brand and salt names")
	public void enter_the_brand_and_salt_names() throws Exception {
		driver.findElement(By.cssSelector("input#brand_master_brand_name")).sendKeys("Cucumber brandmaster");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("input#brand_master_brand_desc")).sendKeys("NA");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@Then("select the route of the brand using dropdown")
	public void select_the_route_of_the_brand_using_dropdown() {
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='Oral'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("entering the HSN code for add new brand")
	public void entering_the_hsn_code_for_add_new_brand() throws Exception {
		driver.findElement(By.xpath("//input[@id='brand_master_tax_service_mapping_master_attributes_hsncode']"))
				.sendKeys("8790");
		Thread.sleep(2000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(2000);
//		Robot robot1 = new Robot();
//		robot1.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
//		robot1.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
//		robot1.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='IGST'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='12.0'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("selecting the GST rate from the dropdown")
	public void selecting_the_GST_rate_from_the_dropdown() throws Exception {
		// driver.findElement(
		// By.cssSelector("span#select2-brand_master_tax_service_mapping_master_attributes_igst-container"))
		// .click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//li[text()='12.0'])[1]")).click();
//		Thread.sleep(2000);
		// driver.findElement(By.xpath("//input[@id='brand_master_tax_service_mapping_master_attributes_hsncode']"))
		// .sendKeys(Keys.PAGE_DOWN);
	}

	@And("select the vaccine for from dropdown")
	public void select_the_vaccine_for_from_dropdown() throws Exception {
		// driver.findElement(By.xpath("(//span[@class='selection'])[10]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='COVID-19'][1]")).click();
		Thread.sleep(1000);
	}

	@Then("enter the price for the vaccine brand")
	public void enter_the_price_for_the_vaccine_brand() throws Exception {
		driver.findElement(By.xpath("//input[@id='brand_master_mrp']")).sendKeys("200");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='brand_master_mrp']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
	}

	@And("select the checkboxes active and verified")
	public void select_the_checkboxes_active_and_verified() throws Exception {
		for (int i = 0; i <= 2; i++) {
			WebElement checkbox1 = driver.findElement(By.xpath("//label[text()='Active']"));
			checkbox1.click();
		}
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement checkbox2 = driver.findElement(By.xpath("//label[text()='Verified']"));
			checkbox2.click();
		}
		Thread.sleep(1000);
		for (int i = 0; i <= 3; i++) {
			WebElement checkbox3 = driver.findElement(By.xpath("//label[text()='Serial Number Required?']"));
			checkbox3.click();
		}
		Thread.sleep(1000);
	}

	@Then("click on the save button from new brand popup")
	public void click_on_the_save_button_from_new_brand_popup() throws Exception {
		// save
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(5000);
	}

	@And("click on the edit button update the salt name")
	public void click_on_the_edit_button_update_the_salt_name() throws Exception {
		// clicking on the edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#brand_master_brand_desc")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#brand_master_brand_desc")).sendKeys("ABC12345");
		Thread.sleep(1000);
	}

	@Then("click on the save button from the edit new brand popup")
	public void click_on_the_save_button_from_the_edit_new_brand_popup() throws Exception {
		// save
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(3000);
	}

	@And("search the added brand by using brand name field")
	public void search_the_added_brand_by_using_brand_name_field() throws Exception {
		// searching with the brand name
		driver.findElement(By.cssSelector("input#q_brand_name_start")).sendKeys("Cucumber brandmaster");
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the brand name
		driver.findElement(By.xpath("(//a[text()='CUCUMBER BRANDMASTER'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='newBrand-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset'][1]")).click();
		Thread.sleep(2000);
	}

	@Then("navigate to the masterdata dashboard from brandmasters page")
	public void navigate_to_the_masterdata_dashboard_from_brandmasters_page() throws Exception {
		// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		// Thread.sleep(1000);
		driver.close();
	}

	@Then("click on the diease program from the masterdata dashboard")
	public void click_on_the_diease_program_from_the_masterdata_dashboard() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Disease Programs'])[1]")).click();
		Thread.sleep(1000);
		String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
		System.out.println(md);
	}

	@And("click on the plus button to add new program")
	public void click_on_the_plus_button_to_add_new_program() throws Exception {
		driver.findElement(By.xpath("//i[text()='add'][1]")).click();
		Thread.sleep(1000);
	}

	@Then("enter the program name from add new program popup")
	public void enter_the_program_name_from_add_new_program_popup() throws Exception {
		// entering the program name
		driver.findElement(By.cssSelector("input#package_master_pckg_nm")).sendKeys("Cucumberdiseaseprogram");
		Thread.sleep(1000);
		// entering the program group name
		driver.findElement(By.xpath("(//input[@id='package_master_package_group_name'])[1]"))
				.sendKeys("Cucum groupname");
		Thread.sleep(1000);
	}

	@And("select the effective start date")
	public void select_the_effective_start_date() throws Exception {
		// selecting the effective date
		driver.findElement(By.cssSelector("input.pick-date.stdt ")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the end date
		driver.findElement(By.cssSelector("input.pick-date.endt ")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// 28
		driver.findElement(By.xpath("(//button[text()='28'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("enter the package duration and select the days from dropdown")
	public void enter_the_package_duration_and_select_the_days_from_dropdown() throws Exception {
		// entering the duration
		driver.findElement(By.cssSelector("input#duration")).sendKeys("28");
		Thread.sleep(1000);
		// // selecting the months
		// driver.findElement(
		// By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[1]/div[5]/div/span/span[1]/span/span[1]"))
		// .click();
		// Thread.sleep(1000);
		// driver.findElement(By.xpath("//li[text()='Weeks']")).click();
		// Thread.sleep(1000);
	}

	@And("enter the description from add new program popup")
	public void enter_the_description_from_add_new_program_popup() throws Exception {
		driver.findElement(By.cssSelector("textarea#package_master_pckg_desc"))
				.sendKeys("Cucumberdiseaseprogram descriptionn");
		Thread.sleep(1000);
	}

	@Then("uploading the image of the program")
	public void uploading_the_image_of_the_program() throws Exception {
		// sending the demo pro.image
		driver.findElement(By.cssSelector("input#package_image_url"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\program.png");
		Thread.sleep(1000);
	}

	@And("enabling the checkboxes for the new program")
	public void enabling_the_checkboxes_for_the_new_program() {
		for (int i = 0; i <= 2; i++) {
			WebElement print = driver.findElement(By.xpath("//label[text()='Print description']"));
			print.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement radio = driver.findElement(By.xpath("//label[text()='Is Visible Web']"));
			radio.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

	}

	@Then("selecting the charge code and for ip from dropdown")
	public void selecting_the_charge_code_and_for_ip_from_dropdown() throws Exception {
		Thread.sleep(1000);
		// selecting the charge code from dropdown
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//li[text()='CardiologyPackage s']")).click();
		Thread.sleep(1000);
		// selecting the ip+op from dropdown
		// driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='OP Only'])[1]")).click();
		Thread.sleep(1000);
		// selecting the what from dropdown
		// driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//li[text()='Doctor Consultation']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("selecting services from add new program popup")
	public void selecting_services_from_add_new_program_popup() throws Exception {
		driver.findElement(By.xpath("(//li[text()='Cardiology'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='Clinic']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the whose resp
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Doctor']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the cost
		driver.findElement(By.id("package_master_patient_package_details_attributes_0_service_cost")).sendKeys("2000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the gst
		driver.findElement(By.id("package_master_patient_package_details_attributes_0_gst_amt")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("package_master_patient_package_details_attributes_0_gst_amt")).sendKeys("6");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// entering the pay %
//		driver.findElement(By.id("package_master_patient_package_details_attributes_0_min_pay")).sendKeys("4");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the time cycle
		// driver.findElement(By.id("package_master_patient_package_details_attributes_0_time_cycle")).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the time cycle type i.e dys,weeks,months etc.
		driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='Weeks']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the time
		driver.findElement(By.id("package_master_patient_package_details_attributes_0_service_time")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//button[text()='Ok'])[1]")).click();
		Thread.sleep(1000);
		// clicking on the description
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Add Description'])[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='Add Description'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// description
		driver.findElement(By.xpath("(//input[@class='line_desc'])[1]")).sendKeys("test1");
		Thread.sleep(2000);
	}

	@Then("clicking on the add plus button to add new service")
	public void clicking_on_the_add_plus_button_to_add_new_service() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		// clicking on the add button
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(1000);
		Robot pddw = new Robot();
		pddw.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

	}

	@And("selecting services again")
	public void selecting_services_again() throws Exception {
		// clicking on the what dropdown
		driver.findElement(By.xpath("(//label[text()='What'])[2]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='Dietician Consultation'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selectinging the service name
		driver.findElement(By.xpath("(//li[text()='Dietician Consultation'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the where
		driver.findElement(By.xpath("//li[text()='Clinic'][1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the whose responsible
		driver.findElement(By.xpath("//li[text()='Dietitian'][1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// cost
		driver.findElement(By.xpath("(//label[text()='Cost'])[2]/following-sibling::input[1]")).sendKeys("500");
		Thread.sleep(1000);
		// gst
		driver.findElement(By.xpath("(//label[text()='GST'])[2]/following-sibling::input[1]")).sendKeys("6");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// pay
//		driver.findElement(By.xpath("/html/body/header/div[18]/div/div[2]/form/div[3]/div[2]/div/div[5]/div[2]/input"))
//				.sendKeys("1");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the time cycle type i.e dys,weeks,months etc.
		driver.findElement(By.xpath("(//span[@class='selection'])[12]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='Weeks'][1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// time
		driver.findElement(By.xpath("(//input[@class='service_time timepicker'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//button[text()='Ok'])[6]")).click();
		Thread.sleep(1000);

		// clicking on the description
		driver.findElement(By.xpath("(//img[@data-tooltip='Add Description'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// description
		driver.findElement(By.xpath("(//input[@class='line_desc'])[2]")).sendKeys("test2");
		Thread.sleep(1000);
//		// save
//		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
//		Thread.sleep(2000);
	}

	@Then("remove last added services")
	public void remove_last_added_services() throws Exception {
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(1000);
	}

	@And("selecting the checkbox active")
	public void selecting_the_checkbox_active() {
		for (int i = 0; i <= 1; i++) {
			WebElement active2 = driver.findElement(By.xpath("(//label[text()='Active'])[1]"));
			active2.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the save button from the add new program popup")
	public void click_on_the_save_button_from_the_add_new_program_popup() throws Exception {
		// clicking on the save btn
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
				.click();
		// driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the edit button and updating the description")
	public void click_on_the_edit_button_and_updating_the_description() throws Exception {
		// clicking on the edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("package_master_pckg_desc")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("package_master_pckg_desc")).sendKeys("Cucumdiseaseprogram description");
		Thread.sleep(1000);
	}

	@Then("click on the save button from the edit program")
	public void click_on_the_save_button_from_the_edit_program() throws Exception {
		// clicking on the submit btn
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);

	}

	@And("selecting the program name from dropdown and searching")
	public void selecting_the_program_name_from_dropdown_and_searching() throws Exception {
		// searching with the name
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Cucumberdiseaseprogram']")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(1000);
		// clicking on the program name
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[text()='Cucumberdiseaseprogram'])[1]")))).click();
		Thread.sleep(3000);
		// edit
		WebDriverWait edit = new WebDriverWait(driver, Duration.ofSeconds(30));
		edit.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@class='btn green right btn-loader'])[1]")))).click();
		Thread.sleep(3000);
		WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[1]"));
		active.click();
		Thread.sleep(2000);
		// save
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
				.click();
		Thread.sleep(3000);
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(3000);
		WebElement active1 = driver.findElement(By.xpath("(//label[text()='Active'])[1]"));
		active1.click();
		Thread.sleep(2000);
		// save
		WebDriverWait save1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		save1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
				.click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("navigae to the masterdata dashboard from diease program page")
	public void navigae_to_the_masterdata_dashboard_from_diease_program_page() throws Exception {
		// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		Thread.sleep(1000);
		driver.close();
	}

	@Then("click on the promocode from the masterdata")
	public void click_on_the_promocode_from_the_masterdata() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Promo Code'])[2]")).click();
		Thread.sleep(1000);
		String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
		System.out.println(md);
	}

	@And("click on the plus button to add new promo code")
	public void click_on_the_plus_button_to_add_new_promo_code() throws Exception {
		// clicking on the add new icon +
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(1000);
	}

	@Then("enter promo code in the new promo code popup")
	public void enter_promo_code_in_the_new_promo_code_popup() {
		// entering the promo code
		driver.findElement(By.cssSelector("input#promo_code_master_promo_code")).sendKeys("Cucumber codee");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("select the start date from the calendar for new promo code")
	public void select_the_start_date_from_the_calendar_for_new_promo_code() throws Exception {
		// selecting the start date -
		driver.findElement(By.cssSelector("input#promo_code_master_start_date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1'][1]")).click();
		Thread.sleep(1000);
	}

	@Then("select the end date from the calendar for new promo code")
	public void select_the_end_date_from_the_calendar_for_new_promo_code() throws Exception {
		// selecting the end date
		driver.findElement(By.cssSelector("input#promo_code_master_end_date")).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[text()='28'])[2]")).click();
//		Thread.sleep(1000);

		List<WebElement> date = driver.findElements(By.xpath("//button[@class='datepicker-day-button']"));
		WebElement lastdate = date.get(date.size() - 1);
		lastdate.click();

	}

	@And("selecting the active checkbox for new promo code")
	public void selecting_the_active_checkbox_for_new_promo_code() {
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[1]"));
			active.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("select the program status_master service_master from the dropdown for new promo code")
	public void select_the_program_status_master_service_master_from_the_dropdown_for_new_promo_code()
			throws Exception {
		// selecting the program
		driver.findElement(By.xpath("(//label[text()='Program'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='NanoHealth Program1'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the status master
		driver.findElement(By.xpath("(//label[text()='Status Master'])[1]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='Registered Users']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the service master
		driver.findElement(By.xpath("(//label[text()='Service Master'])[1]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='Doctor Consultation']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//label[text()='Service Master'])[1]/following-sibling::span[1]")).click();
		driver.findElement(By.xpath("//li[text()='Dietician Consultation']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("entering the discount and enabling the checkbox for new promo code")
	public void entering_the_discount_and_enabling_the_checkbox_for_new_promo_code() throws Exception {
		// entering the discount
		driver.findElement(By.id("promo_code_master_promo_code_service_details_attributes_0_discount")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.className("discount")).sendKeys("5");
		Thread.sleep(1000);

		for (int i = 0; i <= 2; i++) {
			// clicking on the checkbox-family
			WebElement fam = driver.findElement(By.xpath("//label[text()='Family?']"));
			fam.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("click on the save button for new promo code")
	public void click_on_the_save_button_for_new_promo_code() throws Exception {
		// clicking on the save button
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(3000);
	}

	@Then("click on edit and update the promo code")
	public void click_on_edit_and_update_the_promo_code() throws Exception {
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(1000);
		// entering the promo code
		driver.findElement(By.cssSelector("input#promo_code_master_promo_code")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("input#promo_code_master_promo_code")).sendKeys("Cucumber code");
	}

	@And("click on the save button from the edit promo code page")
	public void click_on_the_save_button_from_the_edit_promo_code_page() throws Exception {
		// clicking on the save button
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(3000);
	}

	@Then("selecting the promo code from the dropdown and searching")
	public void selecting_the_promo_code_from_the_dropdown_and_searching() throws Exception {
		// searching with the promo code
		driver.findElement(By.xpath("//span[@class='selection']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Cucumber code']")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the promo code
		driver.findElement(By.xpath("(//a[text()='Cucumber code'])[1]")).click();
		Thread.sleep(2000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='promoCodeMaster-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset'][1]")).click();
		Thread.sleep(1000);
	}

	@Then("navigate to the masterdata dashboard from the promocode page")
	public void navigate_to_the_masterdata_dashboard_from_the_promocode_page() throws Exception {
		// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		Thread.sleep(1000);
		driver.close();
	}

	// @Then("click on the district from masterdata")
	// public void click_on_the_district_from_masterdata() throws Exception {
	// driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[20]/a")).click();
	// Thread.sleep(1000);
	// String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
	// System.out.println(md);
	// }
	//
	// @And("click on the plus button to add new distict")
	// public void click_on_the_plus_button_to_add_new_distict() throws Exception {
	// // click on the add new district icon +
	// driver.findElement(By.xpath("//i[text()='add']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("select the state from the dropdown to add new district")
	// public void select_the_state_from_the_dropdown_to_add_new_district() throws
	// Exception {
	// // clicking on the state
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[1]/div[1]/span/span[1]/span"))
	// .click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[1]/div[1]/span/span[1]/span"))
	// .sendKeys(Keys.DOWN);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[1]/div[1]/span/span[1]/span"))
	// .sendKeys(Keys.ENTER);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @And("enter the district name and code")
	// public void enter_the_district_name_and_code() {
	// driver.findElement(By.cssSelector("input#district_master_district_name")).sendKeys("Cucumber
	// district");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.cssSelector("input#district_master_district_code")).sendKeys("500001");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @Then("enable the active checkbox for the new district")
	// public void enable_the_active_checkbox_for_the_new_district() {
	// for (int i = 0; i <= 2; i++) {
	// WebElement active = driver.findElement(By.xpath("//label[text()='Active']"));
	// active.click();
	// }
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @And("click on the save button for new distrcit")
	// public void click_on_the_save_button_for_new_distrcit() throws Exception {
	// // save
	// driver.findElement(By.xpath("//input[@value='Save']")).click();
	// Thread.sleep(3000);
	// }
	//
	// @Then("edit and update the district code")
	// public void edit_and_update_the_district_code() throws Exception {
	// // edit
	// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.cssSelector("input#district_master_district_code")).clear();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.cssSelector("input#district_master_district_code")).sendKeys("500075");
	// Thread.sleep(1000);
	// }
	//
	// @And("click on the save button from the edit distict page")
	// public void click_on_the_save_button_from_the_edit_distict_page() throws
	// Exception {
	// // save
	// driver.findElement(By.xpath("//input[@value='Save']")).click();
	// Thread.sleep(3000);
	// }
	//
	// @Then("search the added district using dropdown")
	// public void search_the_added_district_using_dropdown() {
	// }
	//
	// @And("navigate to the masterdata dashboard from the district page")
	// public void navigate_to_the_masterdata_dashboard_from_the_district_page() {
	// driver.close();
	// }

	// @Then("click on the userdadetails from masterdata")
	// public void click_on_the_userdadetails_from_masterdata() throws Exception {
	// driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[21]/a")).click();
	// Thread.sleep(1000);
	// String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
	// System.out.println(md);
	// }
	//
	// @And("click on the plus button to add new user addetails")
	// public void click_on_the_plus_button_to_add_new_user_addetails() throws
	// Exception {
	// // clicking on the new userad details icon +
	// driver.findElement(By.xpath("//i[text()='add']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("select the cdp for the new useraddetials")
	// public void select_the_cdp_for_the_new_useraddetials() {
	//
	// }
	//
	// @And("select the service using dropdown")
	// public void select_the_service_using_dropdown() throws Exception {
	// // service
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[1]/div[2]/span/span[1]/span"))
	// .click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[1]/div[2]/span/span[1]/span"))
	// .sendKeys(Keys.DOWN);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[1]/div[2]/span/span[1]/span"))
	// .sendKeys(Keys.ENTER);
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("//li[text()='Diabetes Prevention
	// Program']")).click();
	// Thread.sleep(1000);
	//
	// }
	//
	// @Then("select the appointmenttype using dropdown")
	// public void select_the_appointmenttype_using_dropdown() throws Exception {
	// // appointment type
	// driver.findElement(By.xpath("//li[text()='Clinic']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("enter the following details into the new useraddetails")
	// public void
	// enter_the_following_details_into_the_new_useraddetails(io.cucumber.datatable.DataTable
	// dataTable)
	// throws Exception {
	// List<List<String>> uad = dataTable.asLists(String.class);
	//
	// // description
	// driver.findElement(By.cssSelector("textarea#user_add_detail_desc")).sendKeys(uad.get(0).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[2]/div[3]/input"))
	// .sendKeys(uad.get(1).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // sending the url
	// driver.findElement(By.cssSelector("input#add_url")).sendKeys(uad.get(2).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // sending the link url
	// driver.findElement(By.cssSelector("input#link_url")).sendKeys(uad.get(3).get(1));
	// }
	//
	// @And("enabling the isactive checkbox for the new useraddetails")
	// public void enabling_the_isactive_checkbox_for_the_new_useraddetails() {
	// for (int i = 0; i <= 1; i++) {
	// WebElement isactive = driver.findElement(By.xpath("//label[text()='Is
	// active']"));
	// isactive.click();
	// }
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @Then("click on the save button from the new useraddetails page")
	// public void click_on_the_save_button_from_the_new_useraddetails_page() throws
	// Exception {
	// // clicking on the save button
	// driver.findElement(By.xpath("//input[@value='Save']")).click();
	// Thread.sleep(3000);
	// }
	//
	// @And("click on the edit button and update the description")
	// public void click_on_the_edit_button_and_update_the_description() throws
	// Exception {
	// // edit
	// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.cssSelector("textarea#user_add_detail_desc")).clear();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.cssSelector("textarea#user_add_detail_desc")).sendKeys("Cucumber
	// description");
	// Thread.sleep(1000);
	// }
	//
	// @Then("click on the save button from the edit new useraddetails page")
	// public void click_on_the_save_button_from_the_edit_new_useraddetails_page()
	// throws Exception {
	// // clicking on the save button
	// driver.findElement(By.xpath("//input[@value='Save']")).click();
	// Thread.sleep(3000);
	// }
	//
	// @And("searching for lab using dropdown")
	// public void searching_for_lab_using_dropdown() throws Exception {
	// // searching witht the service
	// driver.findElement(By.xpath("//span[@class='selection']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("//li[text()='Lab']")).click();
	// Thread.sleep(1000);
	// // search
	// driver.findElement(By.xpath("//input[@name='commit']")).click();
	// Thread.sleep(1000);
	// // reset
	// driver.findElement(By.xpath("//a[text()='Reset']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("navigate to the masterdata from the useraddetails page")
	// public void navigate_to_the_masterdata_from_the_useraddetails_page() throws
	// Exception {
	//// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
	// Thread.sleep(1000);
	// driver.close();
	// }

	// @Then("click on the tax service from the masterdata")
	// public void click_on_the_tax_service_from_the_masterdata() throws Exception {
	// driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[22]/a")).click();
	// Thread.sleep(1000);
	// String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
	// System.out.println(md);
	// }
	//
	// @And("selecting the hsncode from the dropdown")
	// public void selecting_the_hsncode_from_the_dropdown() throws Exception {
	// driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//li[text()='8790'])[1]")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("clicking on the search button and delete")
	// public void clicking_on_the_search_button_and_delete() throws Exception {
	// driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
	// Thread.sleep(3000);
	// driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).click();
	// Thread.sleep(2000);
	// }
	//
	// @And("confirm the delete by clicking yes button")
	// public void confirm_the_delete_by_clicking_yes_button() throws Exception {
	// driver.findElement(By.xpath("(//a[text()='Yes'])[1]")).click();
	// Thread.sleep(3000);
	// }
	//
	// @And("click on the plus button to add new tax service")
	// public void click_on_the_plus_button_to_add_new_tax_service() throws
	// Exception {
	// // clicking on the add new tax service= +
	// driver.findElement(By.xpath("//i[text()='add']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("enter the following details into the new tax service popup")
	// public void
	// enter_the_following_details_into_the_new_tax_service_popup(io.cucumber.datatable.DataTable
	// dataTable) {
	// List<List<String>> ts = dataTable.asLists(String.class);
	// // entering the hsncode
	// driver.findElement(By.cssSelector("input#tax_service_mapping_master_hsncode")).sendKeys(ts.get(0).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the cgst
	// driver.findElement(By.cssSelector("input#tax_service_mapping_master_cgst")).sendKeys(ts.get(1).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the sgst
	// driver.findElement(By.cssSelector("input#tax_service_mapping_master_sgst")).sendKeys(ts.get(2).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the igst
	// driver.findElement(By.cssSelector("input#tax_service_mapping_master_igst")).sendKeys(ts.get(3).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @And("click on the save button")
	// public void click_on_the_save_button() throws Exception {
	// // clicking on the save button
	// driver.findElement(By.xpath("//input[@value='Save']")).click();
	// Thread.sleep(3000);
	// }
	//
	// @Then("click on the edit button and update the HSN Code")
	// public void click_on_the_edit_button_and_update_the_hsn_code() throws
	// Exception {
	// // edit
	// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
	// Thread.sleep(1000);
	// // entering the hsncode
	// driver.findElement(By.cssSelector("input#tax_service_mapping_master_hsncode")).clear();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the hsncode
	// driver.findElement(By.cssSelector("input#tax_service_mapping_master_hsncode")).sendKeys("8790");
	// Thread.sleep(1000);
	// }
	//
	// @And("click on save button in the edit tax service")
	// public void click_on_save_button_in_the_edit_tax_service() throws Exception {
	// // clicking on the save button
	// driver.findElement(By.xpath("//input[@value='Save']")).click();
	// Thread.sleep(2000);
	// }
	//
	// @Then("select the hsn code from dropdown and search")
	// public void select_the_hsn_code_from_dropdown_and_search() throws Exception {
	// // searching with the hsn code
	// driver.findElement(By.xpath("//span[@class='selection']")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("//li[text()='8790']")).click();
	// Thread.sleep(1000);
	// // search
	// driver.findElement(By.xpath("//input[@name='commit']")).click();
	// Thread.sleep(1000);
	// // reset
	// driver.findElement(By.xpath("//a[text()='Reset']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @And("navigate to the masterdata dashboard from the taxservice page")
	// public void navigate_to_the_masterdata_dashboard_from_the_taxservice_page()
	// throws Exception {
	//// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
	// Thread.sleep(1000);
	// driver.close();
	// }

	// @Then("click on the forms from the masterdata")
	// public void click_on_the_forms_from_the_masterdata() throws Exception {
	// driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[23]/a")).click();
	// Thread.sleep(1000);
	// }
	//
	// @And("click on the plus button to add new template")
	// public void click_on_the_plus_button_to_add_new_template() throws Exception {
	// driver.findElement(By.xpath("//i[text()='add']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("enter the template name from add new template page")
	// public void enter_the_template_name_from_add_new_template_page() {
	// // entering the template name
	// driver.findElement(By.cssSelector("input#custom_template_pdf_detail_template_name"))
	// .sendKeys("Cucumber testformm");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @And("select the service from the dropdown for new template")
	// public void select_the_service_from_the_dropdown_for_new_template() {
	// // selecting the service
	// driver.findElement(By.xpath("//span[@class='selection']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("//li[text()='Doctor Consultation']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @Then("enter the following details into the new template")
	// public void
	// enter_the_following_details_into_the_new_template(io.cucumber.datatable.DataTable
	// dataTable) {
	// List<List<String>> forms = dataTable.asLists(String.class);
	// // sending the header image [demo]
	// driver.findElement(By.cssSelector("input#custom_template_pdf_detail_template_header_url"))
	// .sendKeys("C:\\Users\\Lenovo\\OneDrive\\images\\header.png");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // sending the footer image [demo]
	// driver.findElement(By.cssSelector("input#custom_template_pdf_detail_footer_header_url"))
	// .sendKeys("C:\\Users\\Lenovo\\OneDrive\\images\\footer.png");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the header height
	// driver.findElement(By.cssSelector("input#custom_template_pdf_detail_template_header_height")).sendKeys("80");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the footer height
	// driver.findElement(By.cssSelector("input#custom_template_pdf_detail_template_footer_height")).sendKeys("30");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @And("click on the save button from the template page")
	// public void click_on_the_save_button_from_the_template_page() throws
	// Exception {
	// // clicking on the save
	// driver.findElement(By.xpath("//input[@value='Save']")).click();
	// Thread.sleep(3000);
	// }
	//
	// @Then("edit the form and update the form name")
	// public void edit_the_form_and_update_the_form_name() throws Exception {
	// // edit
	// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
	// Thread.sleep(1000);
	// // entering the template name
	// driver.findElement(By.cssSelector("input#custom_template_pdf_detail_template_name")).clear();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the template name
	// driver.findElement(By.cssSelector("input#custom_template_pdf_detail_template_name"))
	// .sendKeys("Cucumber testform");
	// Thread.sleep(1000);
	// }
	//
	// @And("click on the save button from the edit template")
	// public void click_on_the_save_button_from_the_edit_template() throws
	// Exception {
	// // clicking on the save
	// driver.findElement(By.xpath("//input[@value='Save']")).click();
	// Thread.sleep(3000);
	// }
	//
	// @Then("search with the template name")
	// public void search_with_the_template_name() throws Exception {
	// // searching with the template name
	// driver.findElement(By.cssSelector("input#q_template_name_eq")).sendKeys("Cucumber
	// testform");
	// Thread.sleep(1000);
	// // search
	// driver.findElement(By.xpath("//input[@name='commit']")).click();
	// Thread.sleep(1000);
	// // reset
	// driver.findElement(By.xpath("//a[text()='Reset']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @And("navigate to the masterdata dashboard from the forms page")
	// public void navigate_to_the_masterdata_dashboard_from_the_forms_page() throws
	// Exception {
	//// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
	// Thread.sleep(1000);
	// driver.close();
	// }

	@Then("click on the screening camps from the masterdata dashboard")
	public void click_on_the_screening_camps_from_the_masterdata_dashboard() throws Exception {
		driver.findElement(By.xpath("(//a[text()='ScreeningCamps'])[2]")).click();
		Thread.sleep(1000);
		String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
		System.out.println(md);
	}

	@Then("click on the add new camp from the screening camps")
	public void click_on_the_add_new_camp_from_the_screening_camps() throws Exception {
		// clicking on the add
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(1000);
	}

	@Then("entering the camp name to create new camp")
	public void entering_the_camp_name_to_create_new_camp() {
		// entering the camp name
		driver.findElement(By.cssSelector("input#camp_name")).sendKeys("Cucumber testcamptwo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("select the location from the dropdown")
	public void select_the_location_from_the_dropdown() throws InterruptedException {
		// clicking on the drop-down for selecting location
		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='Shivapuri Colony'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("select the program from the dropdown")
	public void select_the_program_from_the_dropdown() {
		// clicking on the drop-down for selecting program
		driver.findElement(By.xpath("(//span[@class='selection'])[4]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//span[@class='selection'])[4]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='NanoHealth Program1'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

//	@Then("select the promo code from the dropdown")
//	public void select_the_promo_code_from_the_dropdown() {
//		// clicking on the promocode
//		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("//li[text()='FREE']")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}

	@Then("entering the capacity for new camp")
	public void entering_the_capacity_for_new_camp() {
		// entering the capacity
		driver.findElement(By.cssSelector("input#capacity")).sendKeys("300");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("select the start date and time for new camp")
	public void select_the_start_date_and_time_for_new_camp() throws Exception {
		// clicking on the start date
		driver.findElement(By.cssSelector("input#starting-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// present date
		driver.findElement(By.xpath("//td[@class='is-today']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the camp start time
		driver.findElement(By.cssSelector("input#screening_camp_master_start_time")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// 8
		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[1]//following-sibling::div[1]/div[8]"))
				.click();
		Thread.sleep(1000);
		// clicking on the am
		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[1]/div[1]")).click();
		Thread.sleep(1000);
		// 00 minutes
		driver.findElement(By.xpath("//div[@class='timepicker-dial timepicker-minutes']/div[1]")).click();
		Thread.sleep(1000);
		// clicking on the ok
		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[1]/button[2]")).click();
		Thread.sleep(1000);
	}

	@Then("select the end date and time for new camp")
	public void select_the_end_date_and_time_for_new_camp() throws Exception {
		// clicking on the end date
		driver.findElement(By.cssSelector("input#end-date")).click();
		Thread.sleep(1000);
		// end date
//		driver.findElement(By.xpath("(//button[text()='28'])[2]")).click();
//		Thread.sleep(1000);
		List<WebElement> date = driver.findElements(By.xpath("//button[@class='datepicker-day-button']"));
		WebElement lastdate = date.get(date.size() - 1);
		lastdate.click();
		Thread.sleep(2000);
		// clicking on the end time
		driver.findElement(By.cssSelector("input#screening_camp_master_end_time")).click();
		Thread.sleep(1000);
		// 5
		driver.findElement(By.xpath("(//div[@class='timepicker-canvas'])[2]//following-sibling::div[1]/div[6]"))
				.click();
		Thread.sleep(1000);
		// pm
		driver.findElement(By.xpath("(//div[@class='timepicker-span-am-pm'])[2]/div[2]")).click();
		Thread.sleep(1000);
		// 30 minutes
		driver.findElement(By.xpath("(//div[@class='timepicker-dial timepicker-minutes'])[2]/div[7]")).click();
		Thread.sleep(1000);
		// clicking on the ok
		driver.findElement(By.xpath("(//div[@class='confirmation-btns'])[2]/button[2]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		for (int i = 0; i <= 2; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
		}
	}

	@Then("entering the age from and to for new camp")
	public void entering_the_age_from_and_to_for_new_camp() {
		// entering the age from
		driver.findElement(By.cssSelector("input#age_lwr_lmt")).sendKeys("20");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the age to
		driver.findElement(By.cssSelector("input#age_upr_lmt")).sendKeys("1000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("enabling the checkbox for ispublic")
	public void enabling_the_checkbox_for_ispublic() {
		// selecting the check box
		for (int i = 0; i <= 2; i++) {
			WebElement ispub = driver.findElement(By.xpath("//label[text()='Is Public']"));
			ispub.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("click on the save button for new camp")
	public void click_on_the_save_button_for_new_camp() throws Exception {
		// clicking on the submit button
		driver.findElement(By.cssSelector("input#submit")).click();
		Thread.sleep(3000);
	}

	// @Then("clicking on the edit and updating the capacity")
	// public void clicking_on_the_edit_and_updating_the_capacity() throws Exception
	// {
	// // clicking on the edit
	// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
	// Thread.sleep(3000);
	// // entering the capacity
	// driver.findElement(By.cssSelector("input#capacity")).clear();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.cssSelector("input#capacity")).sendKeys("400");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @Then("click on the save button from the edit screening camp page")
	// public void click_on_the_save_button_from_the_edit_screening_camp_page()
	// throws Exception {
	// // clicking on the submit button
	// driver.findElement(By.cssSelector("input#submit")).click();
	// Thread.sleep(2000);
	// }

	@Then("adding slots for the screeningcamp")
	public void adding_slots_for_the_screeningcamp() throws Exception {
		// add slots
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Slots'])[1]/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#slot_duration")).sendKeys("30");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#slot_capacity")).sendKeys("10");
		Thread.sleep(1000);
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#submit")))).click();
		Thread.sleep(2000);
	}

	@And("adding address for the screeningcamp")
	public void adding_address_for_the_screeningcamp() throws Exception {
		// add address
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Address'])[1]/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='address_detail_address_line1'])[1]")).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='address_detail_address_line2'])[1]")).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='address_detail_landmark'])[1]")).sendKeys("landmark");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//*[@id=\"new_address_detail\"]/div[2]/div[1]/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li/span[text()='Hyderabad'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='dist_nm'])[1]")).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='address_detail_pin_code'])[1]")).sendKeys("090909");
		Thread.sleep(1000);
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save'])[1]"))))
				.click();
		Thread.sleep(3000);
	}

	@Then("adding recommendations for the screeningcamp")
	public void adding_recommendations_for_the_screeningcamp() throws Exception {
		// recommendations
		driver.findElement(By.xpath("(//a[@data-tooltip='Recommendations'])[1]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='selection'])[4]")).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Doctor Consultation'])[1]")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Diagnostic Lab'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='HbA1c'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(1000);
		// removing last added
		driver.findElement(By.xpath("(//i[text()='remove'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[text()='remove'])[2]")).click();
		Thread.sleep(1000);
		// add
		WebDriverWait add = new WebDriverWait(driver, Duration.ofSeconds(30));
		add.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Add'])[1]")))).click();
		// driver.findElement(By.xpath("(//input[@value='Add'])[1]")).click();
		Thread.sleep(3000);

	}

	@Then("clicking on the camp name")
	public void clicking_on_the_camp_name() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Cucumber testcamptwo'])[1]")).click();
		Thread.sleep(1000);

	}

	@And("clicking on the filter icon")
	public void clicking_on_the_filter_icon() throws Exception {
		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.cssSelector("span#filter_ico")).click();
		}
		Thread.sleep(1000);
	}

	@Then("searching the patient name using filters")
	public void searching_the_patient_name_using_filters() throws Exception {

	}

	@And("clicking on the reset button in the camp page")
	public void clicking_on_the_reset_button_in_the_camp_page() {
	}

	@And("deleting already exisiting patient in the camp")
	public void deleting_already_exisiting_patient_in_the_camp() throws Exception {
//		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
//		Thread.sleep(2000);
//		// selecting the NanoHealth CDP
//		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[8]/div/div/div/div[2]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("frst_nm")).sendKeys("Cucumscamppat");
//		Thread.sleep(3000);
//		// // clicking on the name
//		// driver.findElement(By.xpath("(//a[text()='Cucum camppatient'])[1]")).click();
//		// Thread.sleep(3000);
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
//			Thread.sleep(2000);
//		} else {
//			// clicking on the delete
//			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")).click();
//			Thread.sleep(2000);
//		}
//		// deleteing
//		driver.findElement(By.xpath("//button[text()='Confirm!']")).click();
//		Thread.sleep(3000);
//		Robot robot1 = new Robot();
//		robot1.keyPress(KeyEvent.VK_CONTROL);
//		robot1.keyPress(KeyEvent.VK_ADD);
//		Thread.sleep(1000);
//		robot1.keyRelease(KeyEvent.VK_ADD);
//		robot1.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
//		Thread.sleep(2000);
//		// selecting the NanoHealth CDP
//		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[3]/div/div/div/div[2]")).click();
//		Thread.sleep(3000);
//		driver.navigate().to("https://customer.nanohealthplan.com/screening_camp_masters");
//		Thread.sleep(2000);
//		// clicking on the camp name
//		driver.findElement(By.xpath("(//a[text()='Cucumber testcamptwo'])[1]")).click();
//		Thread.sleep(1000);

	}

	@Then("click on the plus button to assign patients")
	public void click_on_the_plus_button_to_assign_patients() throws Exception {
		// assign patients-
		driver.findElement(By.xpath("(//a[@data-tooltip='Assign Patients'])[1]/i")).click();
		Thread.sleep(3000);

		// clicking on the registered user
		driver.findElement(By.xpath("(//a[text()='Registered User'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='register_patient_data'])[1]")).sendKeys("7781110011");
		Thread.sleep(2000);
		// clicking search
		driver.findElement(By.xpath("(//input[@value='Search'])[2]")).click();
		Thread.sleep(2000);
		// clicking on the submit to add existing patient to the camp
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(3000);
		// qr code download
		/*
		 * driver.findElement(By.xpath("(//a[@data-tooltip='Demo Mrfam'])[1]/img[1]")).
		 * click(); Thread.sleep(3000);
		 */
		// Searching & clicking on the patient name from eligible status to check
		// recommendations are added or not
		driver.findElement(By.xpath("(//input[@id='q_frst_nm_or_lst_nm_cont'])[1]")).sendKeys("Demo");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Demo Mrfam'])[1]")).click();
		Thread.sleep(2000);
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("admin-billing-tab")).click();
			Thread.sleep(2000);
		} else {
			for (int i = 0; i <= 1; i++) {
				driver.findElement(By.id("admin-billing-tab")).click();
				Thread.sleep(1000);
			}
			Thread.sleep(1000);
		}

		String recommendations1 = driver.findElement(By.xpath("(//div[@class='content-block'])[1]")).getText();
		System.out.println("Eligible patient recommendation is added & it is in pending status:" + recommendations1);
		Thread.sleep(2000);

		driver.navigate().to("https://customer.nanohealthplan.com/screening_camp_masters");
		Thread.sleep(2000);
		// clicking on the camp name
		driver.findElement(By.xpath("(//a[text()='Cucumber testcamptwo'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='q_frst_nm_or_lst_nm_cont'])[1]")).sendKeys("mrfam");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the eligible button
		driver.findElement(By.xpath("(//a[contains(text(), 'Eligible')])[1]"));
		Thread.sleep(3000);
		// clicking on the verify button
		driver.findElement(By.xpath("(//a[text()='Verify'])[1]")).click();
		Thread.sleep(2000);
		// verifying
		driver.findElement(By.xpath("(//input[@value='Yes'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the verified status
		driver.findElement(By.xpath("(//a[@class='btn-loader verify_btn'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Demo Mrfam'])[1]")).click();
		Thread.sleep(2000);
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("admin-billing-tab")).click();
			Thread.sleep(2000);
		} else {
			for (int i = 0; i <= 1; i++) {
				driver.findElement(By.id("admin-billing-tab")).click();
				Thread.sleep(1000);
			}
			Thread.sleep(1000);
		}
		// clicking on the appointments to check wheither recomm. are added or not
		driver.findElement(By.xpath("(//ul[@class='tabs'])[1]/li[2]/a[1]")).click();
		Thread.sleep(3000);

		String appointment = driver.findElement(By.xpath("(//div[@class='content-block'])[1]")).getText();
		System.out.println(
				"Appointment is created for patient recommendation & it is in confirmed status:" + appointment);
		Thread.sleep(2000);
		// clicking on the apt id
		driver.findElement(By.xpath("(//a[@class='btn-loader show_apmnts show-highlight'])[1]")).click();
		Thread.sleep(3000);

		String Appointmentdetails = driver.findElement(By.xpath("(//div[@class='blue_patch'])[2]")).getText();
		System.err.println("Appointment details:" + Appointmentdetails);
		Thread.sleep(3000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='modalApmntShow'])[1]/div[1]/div[1]/span/i[1]")).click();
		Thread.sleep(3000);
		driver.navigate().to("https://customer.nanohealthplan.com/screening_camp_masters");
		Thread.sleep(2000);
		// clicking on the camp name
		driver.findElement(By.xpath("(//a[text()='Cucumber testcamptwo'])[1]")).click();
		Thread.sleep(2000);
		// assign patients-
		driver.findElement(By.xpath("(//a[@data-tooltip='Assign Patients'])[1]/i")).click();
		Thread.sleep(3000);
	}

	@And("add patient in that new camp")
	public void add_patient_in_that_new_camp() throws Exception {
		// first name
		driver.findElement(By.cssSelector("input#first_name")).sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// last name
		driver.findElement(By.cssSelector("input#lst_name")).sendKeys("scamppat");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// gender
		WebElement male = driver.findElement(By.xpath("//label[text()='M']"));
		male.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		driver.findElement(By.cssSelector("input#age")).sendKeys("40");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// phone
		driver.findElement(By.cssSelector("input#nmbr")).sendKeys("5656565656");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// email
		driver.findElement(By.cssSelector("input#email:nth-of-type(1)")).sendKeys("scamppat@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#nmbr")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@value='Submit'])[2]")).click();
		Thread.sleep(7000);

		// searching with mobile nmbr
		try {
			driver.findElement(By.cssSelector("input#q_nmbr_cont")).sendKeys("5656565656");
			Thread.sleep(3000);
			WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
			search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
					.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// clicking on the verified status
		// driver.findElement(By.xpath("(//a[@class='btn-loader
		// verify_btn'])[1]")).click();
		// Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Cucum scamppat'])[1]")).click();
		Thread.sleep(2000);
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("admin-billing-tab")).click();
			Thread.sleep(2000);
		} else {
			for (int i = 0; i <= 1; i++) {
				driver.findElement(By.id("admin-billing-tab")).click();
				Thread.sleep(1000);
			}
			Thread.sleep(1000);
		}

		String recommendations1 = driver.findElement(By.xpath("(//div[@class='content-block'])[1]")).getText();
		System.out.println("Eligible patient recommendation is added & it is in pending status:" + recommendations1);
		Thread.sleep(2000);

		driver.navigate().to("https://customer.nanohealthplan.com/screening_camp_masters");
		Thread.sleep(2000);
		// clicking on the camp name
		driver.findElement(By.xpath("(//a[text()='Cucumber testcamptwo'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='q_frst_nm_or_lst_nm_cont'])[1]")).sendKeys("mrfam");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the eligible button
		driver.findElement(By.xpath("(//a[contains(text(), 'Eligible')])[1]")).click();
		Thread.sleep(3000);
		// clicking on the verify button
		driver.findElement(By.xpath("(//a[text()='Verify'])[1]")).click();
		Thread.sleep(2000);
		// verifying
		driver.findElement(By.xpath("(//input[@value='Yes'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the verified status
		driver.findElement(By.xpath("(//a[@class='btn-loader verify_btn'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Cucum scamppat'])[1]")).click();
		Thread.sleep(2000);
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("admin-billing-tab")).click();
			Thread.sleep(2000);
		} else {
			for (int i = 0; i <= 1; i++) {
				driver.findElement(By.id("admin-billing-tab")).click();
				Thread.sleep(2000);
			}
		}
		// clicking on the appointments to check wheither recomm. are added or not
		driver.findElement(By.xpath("(//ul[@class='tabs'])[1]/li[2]/a[1]")).click();
		Thread.sleep(3000);

		String appointment = driver.findElement(By.xpath("(//div[@class='content-block'])[1]")).getText();
		System.out.println(
				"Appointment is created for patient recommendation & it is in confirmed status:" + appointment);
		Thread.sleep(2000);
		// clicking on the apt id
		driver.findElement(By.xpath("(//a[@class='btn-loader show_apmnts show-highlight'])[1]")).click();
		Thread.sleep(3000);

		String Appointmentdetails = driver.findElement(By.xpath("(//div[@class='blue_patch'])[2]")).getText();
		System.err.println("Appointment details:" + Appointmentdetails);
		Thread.sleep(3000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='modalApmntShow'])[1]/div[1]/div[1]/span/i[1]")).click();
		Thread.sleep(3000);
		driver.navigate().to("https://customer.nanohealthplan.com/screening_camp_masters");
		Thread.sleep(2000);
		// clicking on the camp name
		driver.findElement(By.xpath("(//a[text()='Cucumber testcamptwo'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the verify button
		driver.findElement(By.xpath("(//a[contains(text(), 'Verified')])[1]")).click();
		Thread.sleep(3000);
		// clicking on the compledted button
		driver.findElement(By.xpath("(//a[text()='Complete'])[1]")).click();
		Thread.sleep(2000);
		// clicking yes
		driver.findElement(By.xpath("(//input[@value='Yes'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the completed button
		driver.findElement(By.xpath("(//a[contains(text(), 'Completed')])[1]")).click();
		Thread.sleep(2000);
		/*
		 * // // clicking on the appointments to check wheither recomm. are added or not
		 * //
		 * driver.findElement(By.xpath("(//ul[@class='tabs'])[1]/li[2]/a[1]")).click();
		 * // Thread.sleep(3000); // // String appointment =
		 * driver.findElement(By.xpath("(//div[@class='content-block'])[1]")).getText();
		 * // System.out.println( //
		 * "Appointment is created for patient recommendation & it is in confirmed status:"
		 * + appointment); // Thread.sleep(2000); // // clicking on the apt id //
		 * driver.findElement(By.
		 * xpath("(//a[@class='btn-loader show_apmnts show-highlight'])[1]")).click();
		 * // Thread.sleep(3000); // // closing the popup //
		 * driver.findElement(By.xpath(
		 * "(//div[@id='modalApmntShow'])[1]/div[1]/div[1]/span/i[1]")).click(); //
		 * Thread.sleep(3000); // driver.navigate().to(
		 * "https://customer.nanohealthplan.com/screening_camp_masters"); //
		 * Thread.sleep(2000); // // clicking on the camp name //
		 * driver.findElement(By.xpath("(//a[text()='Cucumber testcamptwo'])[1]")).click
		 * (); // Thread.sleep(2000); //
		 * driver.findElement(By.xpath("(//input[@id='q_frst_nm_or_lst_nm_cont'])[1]")).
		 * sendKeys("mrfam"); // Thread.sleep(2000); //
		 * driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click(); //
		 * Thread.sleep(2000); // // clicking on the verify button //
		 * driver.findElement(By.xpath("(//a[text()='Verify'])[1]")).click(); //
		 * Thread.sleep(2000); // // verifying //
		 * driver.findElement(By.xpath("(//input[@value='Yes'])[1]")).click(); //
		 * Thread.sleep(5000); // // clicking on the verified status //
		 * driver.findElement(By.xpath("(//a[@class='btn-loader verify_btn'])[1]")).
		 * click(); // Thread.sleep(3000); //
		 * driver.findElement(By.xpath("(//a[text()='Cucum scamppat'])[1]")).click(); //
		 * Thread.sleep(2000); // // close for pending amount // if
		 * (driver.findElement(By.xpath(
		 * "/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) { //
		 * driver.findElement(By.xpath(
		 * "/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click(); //
		 * Thread.sleep(1000); //
		 * driver.findElement(By.id("admin-billing-tab")).click(); //
		 * Thread.sleep(2000); // } else { // for (int i = 0; i <= 1; i++) { //
		 * driver.findElement(By.id("admin-billing-tab")).click(); //
		 * Thread.sleep(1000); // } // Thread.sleep(1000); // } // // clicking on the
		 * appointments to check wheither recomm. are added or not //
		 * driver.findElement(By.xpath("(//ul[@class='tabs'])[1]/li[2]/a[1]")).click();
		 * // Thread.sleep(3000); // // String appointment1 =
		 * driver.findElement(By.xpath("(//div[@class='content-block'])[1]")).getText();
		 * // System.out.println( //
		 * "Appointment is created for patient recommendation & it is in confirmed status:"
		 * + appointment1); // Thread.sleep(2000); // // clicking on the apt id //
		 * driver.findElement(By.
		 * xpath("(//a[@class='btn-loader show_apmnts show-highlight'])[1]")).click();
		 * // Thread.sleep(3000); // // closing the popup //
		 * driver.findElement(By.xpath(
		 * "(//div[@id='modalApmntShow'])[1]/div[1]/div[1]/span/i[1]")).click(); //
		 * Thread.sleep(3000); // driver.navigate().to(
		 * "https://customer.nanohealthplan.com/screening_camp_masters"); //
		 * Thread.sleep(2000); // // clicking on the camp name //
		 * driver.findElement(By.xpath("(//a[text()='Cucumber testcamptwo'])[1]")).click
		 * (); // Thread.sleep(2000); // // clicking on the verified status //
		 * driver.findElement(By.xpath("(//a[@class='btn-loader verify_btn active'])[1]"
		 * )).click(); // Thread.sleep(3000); //
		 * driver.findElement(By.xpath("(//input[@id='q_frst_nm_or_lst_nm_cont'])[1]")).
		 * sendKeys("Cucum"); // Thread.sleep(2000); //
		 * driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click(); //
		 * Thread.sleep(2000);
		 */
	}

	@Then("navigate to the masterdata dashboard from the screening camps")
	public void navigate_to_the_masterdata_dashboard_from_the_screening_camps() throws Exception {
		// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		Thread.sleep(1000);
		driver.close();
	}

	@Then("click on the device management from the masterdata")
	public void click_on_the_device_management_from_the_masterdata() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Device Mangement'])[2]")).click();
		Thread.sleep(1000);
//		String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
//		System.out.println(md);
	}

	@And("click on the device details to select device type")
	public void click_on_the_device_details_to_select_device_type() throws Exception {
		// clicking on the device type details
		driver.findElement(By.xpath("(//a[text()='Device Details'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("selecting the device type from the dropdown and searching")
	public void selecting_the_device_type_from_the_dropdown_and_searching() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucum device type'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div/div[1]/div/div/table/tbody/tr/td[7]/a[2]/img"))
				.click();
		Thread.sleep(2000);
		// de-link the healthcoach
		driver.findElement(By.xpath("(//a[@class='unlink_btn btn-loader'])[1]/img[1]")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucum device type'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("clicking on the delete button beside edit button")
	public void clicking_on_the_delete_button_beside_edit_button() throws Exception {
		driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("clicking on the confirm button to delete")
	public void clicking_on_the_confirm_button_to_delete() throws Exception {
		// clicking on the confirm button
		driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the device type details to select device type")
	public void click_on_the_device_type_details_to_select_device_type() throws Exception {
		// clicking on the device type details
		driver.findElement(By.xpath("//a[text()='Device Type Details']")).click();
		Thread.sleep(3000);
	}

	@Then("selecting the device type from the dropdown to delete")
	public void selecting_the_device_type_from_the_dropdown_to_delete() throws Exception {
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucum device type'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("clicking on the search button to get the device type details data")
	public void clicking_on_the_search_button_to_get_the_device_type_details_data() throws Exception {
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("clicking on the delete button and confirm deleting")
	public void clicking_on_the_delete_button_and_confirm_deleting() throws Exception {
		driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the confirm button
		driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the device type details from the device masters page")
	public void click_on_the_device_type_details_from_the_device_masters_page() throws Exception {
		// clicking on the device type details
		driver.findElement(By.xpath("//a[text()='Device Type Details']")).click();
		Thread.sleep(3000);
	}

	@Then("click on the plus button to add new device1")
	public void click_on_the_plus_button_to_add_new_device1() throws Exception {
		// clicking on the plus icon
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement add = driver.findElement(By.xpath("//i[text()='add']"));
		js.executeScript("arguments[0].click();", add);
		Thread.sleep(2000);
	}

	@And("enter the device type and description")
	public void enter_the_device_type_and_description() {
		// input#device_type_master_device_type
		// device type
		driver.findElement(By.cssSelector("input#device_type_master_device_type")).sendKeys("Cucumber device typeee");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// description
		driver.findElement(By.cssSelector("input#device_type_master_desc"))
				.sendKeys("Cucumber device type description");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("enable the active checkbox for new device")
	public void enable_the_active_checkbox_for_new_device() {
		for (int i = 0; i <= 1; i++) {
			WebElement active = driver.findElement(By.xpath("//label[text()='Active']"));
			active.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("click on the save button to add new device master")
	public void click_on_the_save_button_to_add_new_device_master() throws Exception {
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("Edit and update the device name")
	public void edit_and_update_the_device_name() throws Exception {
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(1000);
		// device type
		driver.findElement(By.cssSelector("input#device_type_master_device_type")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// device type
		driver.findElement(By.id("device_type_master_device_type")).sendKeys("Cucum device type");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("click on the save button from the edit device popup")
	public void click_on_the_save_button_from_the_edit_device_popup() throws Exception {
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("searching added device using dropdown")
	public void searching_added_device_using_dropdown() throws Exception {
		// searching with the device type name
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//li[text()='Cucum device type'][1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset'][1]")).click();
		Thread.sleep(2000);

	}

	@Then("click on the device details from the device masters page")
	public void click_on_the_device_details_from_the_device_masters_page() throws InterruptedException {
		// clicking on the device details
		driver.findElement(By.xpath("//a[text()='Device Details']")).click();
		Thread.sleep(1000);
	}

	@And("click on the plus button to add new device2")
	public void click_on_the_plus_button_to_add_new_device2() throws Exception {
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(1000);
	}

	@Then("select the device type from the dropdown to add new device")
	public void select_the_device_type_from_the_dropdown_to_add_new_device() throws Exception {
		// selecting the device type
		driver.findElement(By.xpath(
				"/html/body/main/div/div[3]/div/div/div[2]/div/div[2]/form/div[1]/div[1]/div/div/span/span[1]/span"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Cucum device type']")).click();
		Thread.sleep(1000);
	}

	@And("enter the following details in the add new device popup")
	public void enter_the_following_details_in_the_add_new_device_popup(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> dm = dataTable.asLists(String.class);
		// entering the device id
		driver.findElement(By.cssSelector("input#device_master_device_id")).sendKeys(dm.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the device name
		driver.findElement(By.cssSelector("input#device_master_device_name")).sendKeys(dm.get(1).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the UUID
		driver.findElement(By.cssSelector("input#device_master_uuid")).sendKeys(dm.get(2).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the major
		driver.findElement(By.cssSelector("input#device_master_major")).sendKeys(dm.get(3).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the minor
		driver.findElement(By.cssSelector("input#device_master_minor")).sendKeys(dm.get(4).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the rent p.day
		driver.findElement(By.cssSelector("input#device_master_rent_per_day")).sendKeys(dm.get(5).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the sale price
		driver.findElement(By.cssSelector("input#device_master_sale_price")).sendKeys(dm.get(6).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("enable the avaible checkbox to add new device popup")
	public void enable_the_avaible_checkbox_to_add_new_device_popup() {
		for (int i = 0; i <= 1; i++) {
			WebElement avaiable = driver.findElement(By.xpath("(//label[text()='Available'])[2]"));
			avaiable.click();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("click on the save button to add new device")
	public void click_on_the_save_button_to_add_new_device() throws Exception {
		// clicking on the save button
		driver.findElement(By.xpath("//input[@value='Save'][1]")).click();
		Thread.sleep(3000);
	}

	@Then("edit and update the rent per day")
	public void edit_and_update_the_rent_per_day() throws Exception {
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(1000);
		// entering the rent p.day
		driver.findElement(By.cssSelector("input#device_master_rent_per_day")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the rent p.day
		driver.findElement(By.cssSelector("input#device_master_rent_per_day")).sendKeys("2000");
		Thread.sleep(1000);
	}

	@And("click on the save button from the edit new device popup")
	public void click_on_the_save_button_from_the_edit_new_device_popup() throws Exception {
		// clicking on the save button
		driver.findElement(By.xpath("//input[@value='Save'][1]")).click();
		Thread.sleep(3000);
	}

	@Then("searching with the device type using dropdown")
	public void searching_with_the_device_type_using_dropdown() throws Exception {
		// searching with the device type
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Cucum device type']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the search
		driver.findElement(By.xpath("//input[@value='Search'][1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset'][1]")).click();
		Thread.sleep(2000);
	}

	@And("searching with the device id using dropdown")
	public void searching_with_the_device_id_using_dropdown() throws Exception {
		// searching with the device ID
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='cucumberid1234']")).click();
		Thread.sleep(1000);
		// clicking on the search
		driver.findElement(By.xpath("//input[@value='Search'][1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
	}

	@Then("searching with the avaible dropdown")
	public void searching_with_the_avaible_dropdown() throws Exception {
		// searching with the device avaible
		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Available Only']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the search
		driver.findElement(By.xpath("//input[@value='Search'][1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// download devices
		Actions down = new Actions(driver);
		down.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Download Reports'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Download Reports'])[1]/i[1]")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("/html/body/main/div/div[3]/div/div/div[1]/div/div/table/tbody/tr[1]/td[7]/a[2]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
		Thread.sleep(1000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[contains(text(), 'Cucum')])")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class='device_name'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("(//a[@class='btn-floating btn-large waves-effect waves-light red divc_card_rmv'])[1]/i[1]"))
				.click();
		Thread.sleep(2000);
	}

	@And("navigate to the masterdata dashboard from the device masters page")
	public void navigate_to_the_masterdata_dashboard_from_the_device_masters_page() throws Exception {
		// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		Thread.sleep(1000);
		driver.close();
	}

	@Then("click on the personalized feeds from the masterdata")
	public void click_on_the_personalized_feeds_from_the_masterdata() throws Exception {
		WebDriverWait feeds = new WebDriverWait(driver, Duration.ofSeconds(30));
		feeds.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Personalized Feeds'])[2]"))))
				.click();
		Thread.sleep(3000);
		String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
		System.out.println(md);
	}

	@And("click on the plus button to add new personalized feeds")
	public void click_on_the_plus_button_to_add_new_personalized_feeds() throws Exception {
		// clicking on the add new personalized feeds
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(1000);
	}

	@Then("entering the title name for feeds")
	public void entering_the_title_name_for_feeds() {
		// entering the title
		driver.findElement(By.cssSelector("input#personalized_feed_title")).sendKeys("Cucumber bloodpressuree");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@And("selecting the disease from the dropdown")
	public void selecting_the_disease_from_the_dropdown() throws Exception {
		// selecting the disease
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='Hypertension (BP)']")).click();
		Thread.sleep(1000);
	}

	@Then("enter the feed description")
	public void enter_the_feed_description() throws Exception {
		// entering the description
		driver.findElement(By.cssSelector("textarea#personalized_feed_feed_desc")).sendKeys(
				"High blood pressure is a common condition that affects the body's arteries. It's also called hypertension. If you have high blood pressure, the force of the blood pushing against the artery walls is consistently too high. The heart has to work harder to pump blood.\r\n"
						+ "\r\n"
						+ "Blood pressure is measured in millimeters of mercury (mm Hg). In general, hypertension is a blood pressure reading of 130/80 mm Hg or higher.\r\n"
						+ "\r\n"
						+ "The American College of Cardiology and the American Heart Association divide blood pressure into four general categories. Ideal blood pressure is categorized as normal.)\r\n"
						+ "\r\n" + "Normal blood pressure. Blood pressure is 120/80 mm Hg or lower.\r\n"
						+ "Elevated blood pressure. The top number ranges from 120 to 129 mm Hg and the bottom number is below, not above, 80 mm Hg.\r\n"
						+ "Stage 1 hypertension. The top number ranges from 130 to 139 mm Hg or the bottom number is between 80 and 89 mm Hg.\r\n"
						+ "Stage 2 hypertension. The top number is 140 mm Hg or higher or the bottom number is 90 mm Hg or higher.\r\n"
						+ "Blood pressure higher than 180/120 mm Hg is considered a hypertensive emergency or crisis. Seek emergency medical help for anyone with these blood pressure numbers.\r\n"
						+ "\r\n"
						+ "Untreated, high blood pressure increases the risk of heart attack, stroke and other serious health problems. It's important to have your blood pressure checked at least every two years starting at age 18. Some people need more-frequent checks.\r\n"
						+ "\r\n"
						+ "Healthy lifestyle habits —such as not smoking, exercising and eating well — can help prevent and treat high blood pressure. Some people need medicine to treat high blood pressure.");
		Thread.sleep(2000);
	}

	@And("enter the following details into the new personalized feed popup")
	public void enter_the_following_details_into_the_new_personalized_feed_popup(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<List<String>> feed = dataTable.asLists(String.class);
		// sending the feed url - demo url
		driver.findElement(By.cssSelector("input#feed_url")).sendKeys(feed.get(0).get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// sending the feed img
		driver.findElement(By.cssSelector("input#image_url")).sendKeys(feed.get(1).get(1));
		Thread.sleep(1000);
	}

	@Then("click on the save button from new personalized feed popup")
	public void click_on_the_save_button_from_new_personalized_feed_popup() throws Exception {
		// clicking on the save button
		driver.findElement(By.xpath("//input[@value='Save'][1]")).click();
		Thread.sleep(2000);
	}

	@And("click on edit and update the feed name")
	public void click_on_edit_and_update_the_feed_name() throws Exception {
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(1000);
		// entering the title
		driver.findElement(By.cssSelector("input#personalized_feed_title")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the title
		driver.findElement(By.cssSelector("input#personalized_feed_title")).sendKeys("Cucumber bp");
		Thread.sleep(1000);
	}

	@Then("click on the save from edit personalized feed popup")
	public void click_on_the_save_from_edit_personalized_feed_popup() throws Exception {
		// clicking on the save button
		driver.findElement(By.xpath("//input[@value='Save'][1]")).click();
		Thread.sleep(3000);
	}

	@And("searching the added feed using search field")
	public void searching_the_added_feed_using_search_field() throws Exception {
		// searching with the title
		driver.findElement(By.cssSelector("input#q_title_cont")).sendKeys("Cucumber bp");
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the feed name
		driver.findElement(By.xpath("(//a[text()='Cucumber bp'])[1]")).click();
		Thread.sleep(2000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='newFeed-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset'][1]")).click();
		Thread.sleep(1000);

	}

	@Then("navigate to the masterdata dashboard from the feeds page")
	public void navigate_to_the_masterdata_dashboard_from_the_feeds_page() throws Exception {
		driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		// driver.navigate().to("https://nhtestserver.ap-south-1.elasticbeanstalk.com/master_data_dashboard");
		Thread.sleep(1000);
		driver.quit();
	}

	@And("click on the formmasters button from the masterdata")
	public void click_on_the_formmasters_button_from_the_masterdata() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Form Masters'])[1]")).click();
		Thread.sleep(2000);
		String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
		System.out.println(md);
	}

	@And("delete the form created previously")
	public void delete_the_form_created_previously() throws Exception {
		/*
		 * // // deleting the last created form using search filters
		 * driver.findElement(By.cssSelector("input#q_form_name_cont")).sendKeys("cucum"
		 * ); Thread.sleep(1000);
		 * driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		 * Thread.sleep(3000); // delete
		 * driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		 * Thread.sleep(5000);
		 */
	}

	@Then("click on the questnr masters from the form master")
	public void click_on_the_questnr_masters_from_the_form_master() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Question Masters'])[1]"))))
				.click();
		Thread.sleep(3000);
	}

	@And("click on the plus button to add new question")
	public void click_on_the_plus_button_to_add_new_question() throws Exception {
		driver.findElement(By.xpath("(//a[@data-tooltip='Add New Question'])[1]/i[1]")).click();
		Thread.sleep(3000);
	}

	@Then("add and save the new question master")
	public void add_and_save_the_new_question_master() throws Exception {
		driver.findElement(By.xpath("(//label[text()='Field Type'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='String'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#questnr_master_questn_name")).sendKeys("Cucumberquestion");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#questnr_master_questn_code")).sendKeys("Cuc");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#questnr_master_questn_code")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#questnr_master_questn_code")).sendKeys("Cucum");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Gender'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='All'])[1]")).click();
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement isv = driver.findElement(By.xpath("(//label[text()='Is Viewable'])[1]"));
			isv.click();
			Thread.sleep(1000);
		}
		for (int i = 0; i <= 1; i++) {
			WebElement isv = driver.findElement(By.xpath("(//label[text()='Is Dependent'])[1]"));
			isv.click();
			Thread.sleep(1000);
		}
		for (int i = 0; i <= 1; i++) {
			WebElement isv = driver.findElement(By.xpath("(//label[text()='Is Active'])[1]"));
			isv.click();
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(5000);
	}

	@And("search for the newly added question master and edit it")
	public void search_for_the_newly_added_question_master_and_edit_it() throws Exception {
		driver.findElement(By.cssSelector("input#q_questn_name_eq")).sendKeys("Cucumberquestion");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the question name
		driver.findElement(
				By.xpath("(//div[@id='search-results'])[1]/table/thead/following-sibling::tbody[1]/tr/td[3]/a[1]"))
				.click();
		Thread.sleep(2000);
		// close
		driver.findElement(By.xpath("(//div[@id='questnrMaster-modal'])[1]/div/div[1]/span/i[1]")).click();
		Thread.sleep(3000);
		// edit the question
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#questnr_master_placeholder_label")).sendKeys("Cucumque");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(5000);

	}

	@Then("click on the formbuilder to create a new form")
	public void click_on_the_formbuilder_to_create_a_new_form() throws Exception {
		// hover the mouse on Reports
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("admin-reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Master Data']"))).click().build().perform();
		Thread.sleep(1000);
		// clicking on the form builder
		driver.findElement(By.xpath("(//a[text()='Form Builder'])[1]")).click();
		Thread.sleep(10000);
	}

	@And("mouse hover and click on the plus button to create a new form")
	public void mouse_hover_and_click_on_the_plus_button_to_create_a_new_form() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//span[@title='Create Form'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@title='Create Form'])[1]")).click();
		Thread.sleep(5000);

	}

	@Then("select the form type from form type and form name popup")
	public void select_the_form_type_from_form_type_and_form_name_popup() throws Exception {
		WebElement opform = driver
				.findElement(By.xpath("(//label/span[text()='Form Type'])/following-sibling::select"));
		Select formtype = new Select(opform);
		formtype.selectByVisibleText("Assessment Form");
		Thread.sleep(1000);

		// clicking on the reset button
		driver.findElement(By.xpath("(//div[text()='Reset'])[1]")).click();
		Thread.sleep(1000);

		WebElement opform1 = driver
				.findElement(By.xpath("(//label/span[text()='Form Type'])/following-sibling::select"));
		Select formtype1 = new Select(opform);
		formtype.selectByVisibleText("Assessment Form");
		Thread.sleep(1000);

		// clicking on the add button for error validation
		WebDriverWait add = new WebDriverWait(driver, Duration.ofSeconds(30));
		add.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[text()='Add'])[1]")))).click();
		Thread.sleep(3000);

//		// selecting the label config
//		WebElement labelselect = driver
//				.findElement(By.xpath("(//label/span[text()='Label Config'])[1]/following-sibling::div[1]"));
//		Select ls = new Select(labelselect);
//		ls.selectByVisibleText("");
//		Thread.sleep(1000);

	}

	@When("form type is selected then form name and label configuration question will display")
	public void form_type_is_selected_then_form_name_and_label_configuration_question_will_display() {
	}

	@Then("enter the form name and select the label configuration for that form")
	public void enter_the_form_name_and_select_the_label_configuration_for_that_form() throws Exception {
		driver.findElement(By.xpath("(//label/span[text()='Form Name'])[1]/following-sibling::input[1]"))
				.sendKeys("Cucum formbuilder");
		Thread.sleep(1000);
//		WebElement formlabelconfig = driver
//				.findElement(By.xpath("(//label/span[text()='Label Config'])[1]/following-sibling::select[1]"));
//		Select labelconfig = new Select(formlabelconfig);
//		labelconfig.selectByVisibleText("0");
//		Thread.sleep(1000);

		// clicking on the label config
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]/label[3]/div/div/div[1]/div[2]")).click();
		Thread.sleep(2000);
		// clicking on the label_config=0, img
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/img")).click();
		Thread.sleep(2000);
	}

	@And("click on the add button from form type and form name popup")
	public void click_on_the_add_button_from_form_type_and_form_name_popup() throws Exception {
		WebDriverWait add = new WebDriverWait(driver, Duration.ofSeconds(30));
		add.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[text()='Add'])[1]")))).click();
		Thread.sleep(3000);
	}

	@Then("add responsible role and add header footer for the form")
	public void add_responsible_role_and_add_header_footer_for_the_form() throws Exception {
		// clicking on the X remove all resp role name
		driver.findElement(By.xpath("(//div[@class='resp-role-posi'])[1]/div/div/div/div[2]/div[1]")).click();
		Thread.sleep(2000);
		// clicking on the dropdown button to add resp role name
		driver.findElement(
				By.xpath("(//div[@class='resp-role-posi'])[1]/div/div/div/div[2]/span[1]/following-sibling::div"))
				.click();
		Thread.sleep(2000);
//		// search and adding resp role name
//		driver.findElement(By.xpath("(//div[text()='Select responsible role'])[1]/following-sibling::div[1]/input[1]"))
//				.sendKeys("All" + Keys.ENTER);
//		Thread.sleep(2000);
//		// clicking on the dropdown button to add resp role name
//		driver.findElement(
//				By.xpath("(//div[@class='resp-role-posi'])[1]/div/div/div/div[2]/span[1]/following-sibling::div"))
//				.click();
//		Thread.sleep(2000);
		// selecting the resp role name from dropdown
		driver.findElement(By.xpath("(//div[text()='ClinicManager'])[1]")).click();
		Thread.sleep(1000);
		// is_active
		for (int i = 0; i <= 1; i++) {
			WebElement is_active = driver.findElement(By.xpath("(//div[@class='right-icon'])[1]/div[1]/input[1]"));
			is_active.click();
		}

		// clicking on the three dot s
		driver.findElement(By.xpath("(//div[@class='right-icon'])[1]/div[1]/following-sibling::img[1]")).click();
		Thread.sleep(3000);

		WebElement male = driver.findElement(By.xpath("(//label[text()=' Male'])[1]"));
		male.click();
		Thread.sleep(1000);
		WebElement all = driver.findElement(By.xpath("(//label[text()=' All'])[1]"));
		all.click();
		Thread.sleep(2000);

		// uploading header
		try {
			driver.findElement(By.cssSelector("input#fileInputF-header_img_url"))
					.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\NODEHEADER.png");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		driver.findElement(By.xpath("(//input[@name='header_img_height'])[1]")).sendKeys("40");
		Thread.sleep(1000);
		// uploading footer
		try {
			driver.findElement(By.cssSelector("input#fileInputF-footer_img_url"))
					.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\NODEFOOTER.png");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		driver.findElement(By.xpath("(//input[@name='footer_img_height'])[1]")).sendKeys("20");
		Thread.sleep(1000);
		// clicking on the save button from form details popup
		driver.findElement(By.xpath("(//div[text()='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("click on the string question type from left side question types")
	public void click_on_the_string_question_type_from_left_side_question_types() throws Exception {
		// mosue hovering on to the question name
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//img[@alt='String'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='String'])[1]")).click();
		Thread.sleep(2000);

	}

	@When("string question is clicked then Add String Type Question")
	public void string_question_is_clicked_then_add_string_type_question() {

	}

	@Then("select the question and give label configuration for that question")
	public void select_the_question_and_give_label_configuration_for_that_question() throws InterruptedException {
//		WebElement stringque = driver
//				.findElement(By.xpath("(//label/span[text()='Existing Question'])[1]/following-sibling::div[1]"));
//		Select que = new Select(stringque);
//		que.selectByVisibleText("Notes");
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label/span[text()='Existing Question'])[1]/following-sibling::div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='Notes'])[1]")).click();
		Thread.sleep(1000);
//		WebElement labelconfig = driver
//				.findElement(By.xpath("(//label/span[text()='Label Configuration'])[1]/following-sibling::div[1]"));
//		Select config = new Select(labelconfig);
//		config.selectByVisibleText("0");
//		Thread.sleep(1000)
		// changing the question label name
		driver.findElement(By.xpath("input#questionInput")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("input#questionInput")).sendKeys("Notes que");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label/span[text()='Label Configuration'])[1]/following-sibling::div[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/img")).click();
		Thread.sleep(2000);
	}

	@And("click on add button to add first question in the form")
	public void click_on_add_button_to_add_first_question_in_the_form() throws Exception {
		driver.findElement(By.xpath("(//div[text()='Add'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("click on the integer question type from left side question types")
	public void click_on_the_integer_question_type_from_left_side_question_types() throws Exception {
		// mosue hovering on to the question name
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div/span[text()='Integer'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div/span[text()='Integer'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("select the question for integer and give label configuration for that question")
	public void select_the_question_for_integer_and_give_label_configuration_for_that_question() throws Exception {
//		WebElement stringque = driver
//				.findElement(By.xpath("(//label/span[text()='Existing Question'])[1]/following-sibling::div[1]"));
//		Select que = new Select(stringque);
//		que.selectByVisibleText("Height");
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label/span[text()='Existing Question'])[1]/following-sibling::div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='Height'])[1]")).click();
		Thread.sleep(1000);
//		WebElement labelconfig = driver
//				.findElement(By.xpath("(//label/span[text()='Label Configuration'])[1]/following-sibling::select[1]"));
//		Select config = new Select(labelconfig);
//		config.selectByVisibleText("0");
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label/span[text()='Label Configuration'])[1]/following-sibling::div[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/img")).click();
		Thread.sleep(2000);
	}

	@And("click on add button to add second question in the form")
	public void click_on_add_button_to_add_second_question_in_the_form() throws Exception {
		driver.findElement(By.xpath("(//div[text()='Add'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("search the question type as radio and click on it")
	public void search_the_question_type_as_radio_and_click_on_it() throws Exception {
		driver.findElement(By.xpath("(//div[@class='searchBox'])[1]/input")).sendKeys("Radio");
		Thread.sleep(2000);
		// mosue hovering on to the question name
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//img[@alt='Radio'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Radio'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("select the question for radio and give label configuration for that question")
	public void select_the_question_for_radio_and_give_label_configuration_for_that_question() throws Exception {
//		WebElement radio = driver
//				.findElement(By.xpath("(//label/span[text()='Existing Question'])[1]/following-sibling::div[1]"));
//		Select que = new Select(radio);
//		que.selectByVisibleText("Diabetes");
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label/span[text()='Existing Question'])[1]/following-sibling::div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='Diabetes'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label/span[text()='Label Configuration'])[1]/following-sibling::div[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/img")).click();
		Thread.sleep(2000);

	}

	@Then("click on add button to add third question in the form")
	public void click_on_add_button_to_add_third_question_in_the_form() throws Exception {
		driver.findElement(By.xpath("(//div[text()='Add'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("search the question type as checkbox and click on it")
	public void search_the_question_type_as_checkbox_and_click_on_it() throws Exception {
		driver.findElement(By.xpath("(//div[@class='searchBox'])[1]/input")).sendKeys("Checkbox");
		Thread.sleep(2000);
		// mosue hovering on to the question name
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//img[@alt='Checkbox'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Checkbox'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("select the question for checkbox and give options and label configuration for that question")
	public void select_the_question_for_checkbox_and_give_options_and_label_configuration_for_that_question()
			throws Exception {
//		WebElement checkbox = driver
//				.findElement(By.xpath("(//label/span[text()='Existing Question'])[1]/following-sibling::div[1]"));
//		Select que = new Select(checkbox);
//		que.selectByVisibleText("Medication");
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label/span[text()='Existing Question'])[1]/following-sibling::div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='Medication'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label/span[text()='Label Configuration'])[1]/following-sibling::div[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/img")).click();
		Thread.sleep(2000);

		// giving options
		driver.findElement(By.xpath("(//label/span[text()='Options'])[1]/following-sibling::input[1]"))
				.sendKeys("A,B,C");
		Thread.sleep(1000);
	}

	@Then("click on add button to add fourth question in the form")
	public void click_on_add_button_to_add_fourth_question_in_the_form() throws Exception {
		driver.findElement(By.xpath("(//div[text()='Add'])[1]")).click();
		Thread.sleep(2000);
	}

	@And("remove the last question from the creating form")
	public void remove_the_last_question_from_the_creating_form() throws Exception {
		driver.findElement(By.xpath("(//img[@alt='Delete'])[5]")).click();
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//div[text()='Yes'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("drag and down the questions")
	public void drag_and_down_the_questions() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@id='draggablelistzindex'])[1]/div[1]/div[4]")))
				.build().perform();
		Thread.sleep(2000);

		WebElement source = driver.findElement(By.xpath("(//span[@title='Drag Up/Down to reorder'])/img[1]"));
		Actions a = new Actions(driver);
		Actions actions = new Actions(driver);
		actions.clickAndHold(source).moveToElement(source, 0, -200).release().build().perform();
	}

	@And("click on save button to create the new form")
	public void click_on_save_button_to_create_the_new_form() throws Exception {
		driver.findElement(By.xpath("(//div[text()='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("edit the form add the newly created question and save changes")
	public void edit_the_form_add_the_newly_created_question_and_save_changes() {

	}

//	@Then("click on the form masters button to create a new form")
//	public void click_on_the_form_masters_button_to_create_a_new_form() throws Exception {
//		driver.findElement(By.xpath("(//a[text()='Form Masters'])[1]")).click();
//		Thread.sleep(3000);
//	}
//
//	@Then("click on the plus button to add a new form")
//	public void click_on_the_plus_button_to_add_a_new_form() throws Exception {
//		driver.findElement(By.xpath("(//a[@data-tooltip='Add new form'])/i")).click();
//		Thread.sleep(3000);
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//
//	}
//
//	@When("plus button is clicked new form ui will be opened")
//	public void plus_button_is_clicked_new_form_ui_will_be_opened() {
//	}
//
//	@Then("enter the form name and select the form type masters from the dropdown")
//	public void enter_the_form_name_and_select_the_form_type_masters_from_the_dropdown() throws Exception {
//		// save
//		driver.findElement(By.xpath("/html/body/main/div/div[3]/div[1]/div/form/div/div[4]/div[3]/div/input[1]"))
//				.click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input#form_master_form_name")).sendKeys("Cucumber form");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='OP Form'])[1]")).click();
//		Thread.sleep(1000);
//		WebElement mul = driver.findElement(By.xpath("(//label[text()='Multiple'])[1]"));
//		mul.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		WebElement sin = driver.findElement(By.xpath("(//label[text()='Single'])[1]"));
//		sin.click();
//		Thread.sleep(1000);
//		for (int i = 0; i <= 1; i++) {
//			WebElement active = driver.findElement(By.xpath("(//label[text()='Active'])[1]"));
//			active.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
//		Thread.sleep(1000);
//		// clicking on the more_vert
//		driver.findElement(By.xpath("(//i[text()='more_vert'])[1]")).click();
//		Thread.sleep(2000);
//		// uploading header
//		driver.findElement(By.cssSelector("input#header_img_url"))
//				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\NODEHEADER.png");
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("input#form_master_header_img_height")).sendKeys("40");
//		Thread.sleep(1000);
//		// uploading footer
//		driver.findElement(By.cssSelector("input#footer_img_url"))
//				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\NODEFOOTER.png");
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("input#form_master_footer_img_height")).sendKeys("20");
//		Thread.sleep(1000);
//		// driver.findElement(By.xpath("(//li[@class='select2-search
//		// select2-search--inline'])[1]")).click();
//		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// driver.findElement(By.xpath("(//li[text()='Clinic_Manager'])[1]")).click();
//		// Thread.sleep(1000);
//
//		// save
//		driver.findElement(By.id("saveBtn")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("(//li[@class='select2-search select2-search--inline'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//li[text()='IPBillingManager'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//span[@class='select2-selection__choice__remove'])[2]")).click();
//		Thread.sleep(2000);
//	}
//
//	@And("click on the plus button to add questions in the new form")
//	public void click_on_the_plus_button_to_add_questions_in_the_new_form() throws Exception {
//		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
//		Thread.sleep(2000);
//	}
//
//	@Then("select the question from the dropdown")
//	public void select_the_question_from_the_dropdown() throws Exception {
//		driver.findElement(By.xpath("(//label[text()='Question * '])[1]/following-sibling::span")).click();
//		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[text()='Diabetes'])[1]"))))
//				.click();
//		// driver.findElement(By.xpath("(//li[text()='Diabetes'])[1]")).click();
//		Thread.sleep(1000);
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'));",
//				driver.findElement(By.xpath("(//label[text()='Question * '])[1]/following-sibling::span")));
//		Thread.sleep(5000);
//
//	}
//
//	@When("question is selected from dropdown then question name type options is automatically filledup based upon the question selected")
//	public void question_is_selected_from_dropdown_then_question_name_type_options_is_automatically_filledup_based_upon_the_question_selected() {
//
//	}
//
//	@Then("select the question as is_parent checkbox")
//	public void select_the_question_as_is_parent_checkbox() throws Exception {
//		for (int i = 0; i <= 1; i++) {
//			WebElement is_man = driver.findElement(By.xpath("(//label[text()='Is Mandatory ?'])[1]"));
//			is_man.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
//		Thread.sleep(1000);
//		for (int i = 0; i <= 1; i++) {
//			WebElement is_view = driver.findElement(By.xpath("(//label[text()='Is Viewable ?'])[1]"));
//			is_view.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
//		Thread.sleep(1000);
//		for (int i = 0; i <= 2; i++) {
//			WebElement is_parent = driver.findElement(By.xpath("(//label[text()='Is Parent?'])[1]"));
//			is_parent.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
//		Thread.sleep(1000);
//	}
//
//	@When("is_parent checkbox is enabled then derived questions will be shown in the dropdown")
//	public void is_parent_checkbox_is_enabled_then_derived_questions_will_be_shown_in_the_dropdown() {
//
//	}
//
//	@Then("enter the orderid for the first selected question")
//	public void enter_the_orderid_for_the_first_selected_question() throws Exception {
//		driver.findElement(By.xpath("(//input[@class='order_id'])[1]")).sendKeys("1");
//		Thread.sleep(1000);
//	}
//
//	@And("click on the plus button again to add new question")
//	public void click_on_the_plus_button_again_to_add_new_question() throws Exception {
//		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
//		Thread.sleep(1000);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,500)", "");
//		Thread.sleep(1000);
//	}
//
//	@Then("select the question from the dropdown and remainaing fields will be filled")
//	public void select_the_question_from_the_dropdown_and_remainaing_fields_will_be_filled() throws Exception {
//		driver.findElement(By.xpath("(//label[text()='Question * '])[2]/following-sibling::span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Diabetes Medication'])[1]")).click();
//		Thread.sleep(2000);
//	}
//
//	@And("select this question as is_dependent checkbox")
//	public void select_this_question_as_is_dependent_checkbox() throws Exception {
//		for (int i = 0; i <= 2; i++) {
//			WebElement is_dependent = driver.findElement(By.xpath("(//label[text()='Is Dependent ?'])[2]"));
//			is_dependent.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
//		Thread.sleep(1000);
//
//	}
//
//	@When("is_dependent checkbox is enabled then this question will be show in the derived questions dropdown")
//	public void is_dependent_checkbox_is_enabled_then_this_question_will_be_show_in_the_derived_questions_dropdown() {
//	}
//
//	@And("select the question in the derived questions field in the parent question")
//	public void select_the_question_in_the_derived_questions_field_in_the_parent_question()
//			throws InterruptedException {
//		driver.findElement(By.xpath("(//label[text()='Derived Questions'])[1]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Diabetes Medication'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@class='order_id'])[2]")).sendKeys("2");
//		Thread.sleep(1000);
//	}
//
//	@Then("click on the plus button again to add new question in the form")
//	public void click_on_the_plus_button_again_to_add_new_question_in_the_form() throws InterruptedException {
//		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
//		Thread.sleep(2000);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,500)", "");
//		Thread.sleep(1000);
//	}
//
//	@And("select the question and enter order id for the question")
//	public void select_the_question_and_enter_order_id_for_the_question() throws InterruptedException {
//		driver.findElement(By.xpath("(//label[text()='Question * '])[3]/following-sibling::span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Hypertension'])[1]")).click();
//		Thread.sleep(1000);
//		WebElement is_par = driver.findElement(By.xpath("(//label[text()='Is Parent?'])[3]"));
//		is_par.click();
//		Thread.sleep(1000);
//		WebElement is_man = driver.findElement(By.xpath("(//label[text()='Is Mandatory ?'])[3]"));
//		is_man.click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@class='order_id'])[3]")).sendKeys("3");
//		Thread.sleep(1000);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,500)", "");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//label[text()='Question * '])[4]/following-sibling::span")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Hypertension Medication'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@class='order_id'])[4]")).sendKeys("4");
//		Thread.sleep(1000);
//		WebElement is_dep = driver.findElement(By.xpath("(//label[text()='Is Dependent ?'])[4]"));
//		is_dep.click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Derived Questions'])[3]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Hypertension Medication'])[1]")).click();
//		Thread.sleep(1000);
//	}
//
//	@Then("add new question and remove the question")
//	public void add_new_question_and_remove_the_question() throws Exception {
//		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//label[text()='Question * '])[5]/following-sibling::span")).click();
//		Thread.sleep(1000);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,100)", "");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Weight'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@class='order_id'])[5]")).sendKeys("5");
//		Thread.sleep(1000);
//		Robot pgdwn = new Robot();
//		pgdwn.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		// more vert
//		driver.findElement(By.xpath("(//i[text()='more_vert'])[6]")).click();
//		Thread.sleep(2000);
//		// close
//		driver.findElement(By.xpath("(//div[@id='popup-section'])[5]/div[1]/span/i")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[5]")).click();
//		Thread.sleep(1000);
//
//	}
//
//	@And("click on the save button to save the form")
//	public void click_on_the_save_button_to_save_the_form() throws Exception {
//		// save
//		driver.findElement(By.xpath("/html/body/main/div/div[3]/div[1]/div/form/div/div[4]/div[3]/div/input[1]"))
//				.click();
//		Thread.sleep(3000);
//
//	}
//
//	@When("save is clicked it will redirect to the form_masters")
//	public void save_is_clicked_it_will_redirect_to_the_form_masters() {
//	}
//
//	@Then("search the created form using filters")
//	public void search_the_created_form_using_filters() throws Exception {
//		driver.findElement(By.cssSelector("input#q_form_name_cont")).sendKeys("cucumber");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
//		Thread.sleep(3000);
//	}
//
//	@And("edit the form and add new question and save again")
//	public void edit_the_form_and_add_new_question_and_save_again() throws Exception {
//		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
//		Thread.sleep(3000);
//		for (int i = 0; i <= 2; i++) {
//			JavascriptExecutor jse = (JavascriptExecutor) driver;
//			jse.executeScript("window.scrollBy(0,500)", "");
//			Thread.sleep(1000);
//		}
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Question * '])[5]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='Weight'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//label[text()='Question type'])[5]/following-sibling::span[1]")).click();
//		Thread.sleep(1000);
//		// driver.findElement(By.xpath("(//li[text()='Decimal'])[1]")).click();
//		// Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@class='order_id'])[5]")).sendKeys("5");
//		Thread.sleep(3000);
//		// save
//		driver.findElement(By.cssSelector("input.btn.green.right.btn-loader.savebtn.submitBtn")).click();
//		Thread.sleep(5000);
//		driver.navigate().to("https://customer.nanohealthplan.com/form_masters");
//		Thread.sleep(2000);
//	}
//
//	@Then("click on the preview button after searching the form")
//	public void click_on_the_preview_button_after_searching_the_form() throws Exception {
//		Actions preview = new Actions(driver);
//		preview.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Preview'])[1]/img"))).build().perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Preview'])[1]/img")).click();
//		Thread.sleep(3000);
//		Actions download = new Actions(driver);
//		download.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/img[1]"))).build()
//				.perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/img[1]")).click();
//		Thread.sleep(3000);
//		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
//		jse5.executeScript("window.scrollBy(0,100)", "");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[text()='Edit'])[1]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.cssSelector("input#form_master_form_name")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.cssSelector("input#form_master_form_name")).sendKeys("Cucum form");
//		Thread.sleep(1000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(1000);
//		// save
//		driver.findElement(By.cssSelector("input.btn.green.right.btn-loader.savebtn.submitBtn")).click();
//		Thread.sleep(10000);
//		driver.close();
//	}
//
//	@And("click on the download pdf button for form")
//	public void click_on_the_download_pdf_button_for_form() throws Exception {
//		// driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/img")).click();
//		// Thread.sleep(2000);
//	}

	// @When("masterdata dashboard is opened")
	// public void masterdata_dashboard_is_opened() {
	// }
	//
	// @Then("mouse hover to reports and masterdata")
	// public void mouse_hover_to_reports_and_masterdata() {
	// }
	//
	// @And("from masterdata mouse hover to specialization masters")
	// public void from_masterdata_mouse_hover_to_specialization_masters() {
	// }
	//
	// @Then("click on the specialization masters from the masterdata")
	// public void click_on_the_specialization_masters_from_the_masterdata() throws
	// Exception {
	// // hover the mouse on Reports
	// Actions action = new Actions(driver);
	// Thread.sleep(1000);
	// action.moveToElement(driver.findElement(By.id("admin-reports"))).build().perform();
	// action.moveToElement(driver.findElement(By.xpath("//a[text()='Master
	// Data']"))).build().perform();
	// Thread.sleep(1000);
	// action.moveToElement(driver.findElement(By.id("room_masters"))).build().perform();
	// Thread.sleep(1000);
	// driver.findElement(By.id("room_masters")).sendKeys(Keys.DOWN);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.id("room_masters")).sendKeys(Keys.DOWN);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.id("room_masters")).sendKeys(Keys.DOWN);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.id("room_masters")).sendKeys(Keys.DOWN);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.id("room_masters")).sendKeys(Keys.DOWN);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.id("room_masters")).sendKeys(Keys.DOWN);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.id("room_masters")).sendKeys(Keys.DOWN);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.id("room_masters")).sendKeys(Keys.DOWN);
	// Thread.sleep(1000);
	// action.moveToElement(driver.findElement(By.id("specialisation_master"))).click().build().perform();
	// Thread.sleep(1000);
	// String md = driver.findElement(By.cssSelector("a#admin-reports")).getText();
	// System.out.println(md);
	// }
	//
	// @When("specialization masters is opened")
	// public void specialization_masters_is_opened() {
	//
	// }
	//
	// @And("selecting specialist from dropdown and searching to delete the data")
	// public void
	// selecting_specialist_from_dropdown_and_searching_to_delete_the_data() throws
	// Exception {
	// driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//li[text()='cucum specialist'])[1]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
	// Thread.sleep(3000);
	//
	// }
	//
	// @Then("click on the delete and confirm")
	// public void click_on_the_delete_and_confirm() throws Exception {
	// driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).click();
	// Thread.sleep(3000);
	// // yes
	// driver.findElement(By.xpath("(//a[text()='Yes'])[1]")).click();
	// Thread.sleep(2000);
	//
	// }
	//
	// @Then("click on the plus button to add new specialization masters")
	// public void click_on_the_plus_button_to_add_new_specialization_masters()
	// throws Exception {
	// // clicking on the add new specialization master icon = +
	// driver.findElement(By.xpath("//i[text()='add']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @And("enter the following details in the new specialization popup")
	// public void
	// enter_the_following_details_in_the_new_specialization_popup(io.cucumber.datatable.DataTable
	// dataTable)
	// throws Exception {
	// List<List<String>> sm = dataTable.asLists(String.class);
	// // entering the specialization code
	// driver.findElement(By.cssSelector("input#specialisation_master_specialisation_code"))
	// .sendKeys(sm.get(0).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the specialization description
	// driver.findElement(By.cssSelector("input#specialisation_master_specialisation_desc"))
	// .sendKeys(sm.get(1).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the specialist
	// driver.findElement(By.cssSelector("input#specialisation_master_specialist")).sendKeys(sm.get(2).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the symptoms
	// driver.findElement(By.cssSelector("input#specialisation_master_symptoms")).sendKeys(sm.get(3).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the meta title
	// driver.findElement(By.cssSelector("input#specialisation_master_meta_title")).sendKeys(sm.get(4).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the meta description
	// driver.findElement(By.cssSelector("input#specialisation_master_meta_description")).sendKeys(sm.get(5).get(1));
	// Thread.sleep(1000);
	// Robot robot3 = new Robot();
	// for (int i = 0; i < 3; i++) {
	// robot3.keyPress(KeyEvent.VK_CONTROL);
	// robot3.keyPress(KeyEvent.VK_SUBTRACT);
	// robot3.keyRelease(KeyEvent.VK_SUBTRACT);
	// robot3.keyRelease(KeyEvent.VK_CONTROL);
	// }
	// // icon img
	// driver.findElement(By.cssSelector("input#icon_img")).sendKeys(sm.get(6).get(1));
	// Thread.sleep(1000);
	// // icon img
	// driver.findElement(By.cssSelector("input#og_image")).sendKeys(sm.get(7).get(1));
	// Thread.sleep(1000);
	// }
	//
	// @Then("enable the checkbox in the top of the specialization master")
	// public void enable_the_checkbox_in_the_top_of_the_specialization_master() {
	// for (int i = 0; i <= 1; i++) {
	// WebElement active = driver.findElement(By.xpath("//label[text()='Active']"));
	// active.click();
	// }
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @And("click on the save button from the new specialization")
	// public void click_on_the_save_button_from_the_new_specialization() throws
	// Exception {
	// // clicking on the save button
	// driver.findElement(By.xpath("//input[@value='Save']")).click();
	// Thread.sleep(3000);
	// }
	//
	// @Then("click on the edit button and update the specialization description")
	// public void
	// click_on_the_edit_button_and_update_the_specialization_description() throws
	// Exception {
	// // edit
	// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[2]")).click();
	// Thread.sleep(1000);
	// // entering the specialization description
	// driver.findElement(By.cssSelector("input#specialisation_master_specialisation_desc")).clear();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the specialization description
	// driver.findElement(By.cssSelector("input#specialisation_master_specialisation_desc"))
	// .sendKeys("cucumber spec description");
	// Thread.sleep(1000);
	// }
	//
	// @And("click on the save button from the edit specialization master")
	// public void click_on_the_save_button_from_the_edit_specialization_master()
	// throws Exception {
	// // clicking on the save button
	// driver.findElement(By.xpath("//input[@value='Save']")).click();
	// Thread.sleep(3000);
	// }
	//
	// @Then("searching the added specialization master using dropdown")
	// public void searching_the_added_specialization_master_using_dropdown() throws
	// Exception {
	// // searching with the specialist
	// driver.findElement(By.xpath("//span[@class='selection']")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("//li[text()='cucum specialist']")).click();
	// Thread.sleep(1000);
	// // search
	// driver.findElement(By.xpath("//input[@name='commit']")).click();
	// Thread.sleep(1000);
	// // reset
	// driver.findElement(By.xpath("//a[text()='Reset']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @And("navigate to the masterdata dashboard from the specialization masters")
	// public void
	// navigate_to_the_masterdata_dashboard_from_the_specialization_masters() throws
	// Exception {
	//// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
	// Thread.sleep(1000);
	// driver.close();
	// }

	// @Then("click on the healthcoach from the masterdata dashboard")
	// public void click_on_the_healthcoach_from_the_masterdata_dashboard() throws
	// Exception {
	// driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[9]/a")).click();
	// Thread.sleep(1000);
	// }
	//
	// @And("enter the name and search to delete existing healthcoach")
	// public void enter_the_name_and_search_to_delete_existing_healthcoach() throws
	// Exception {
	//// driver.findElement(By.xpath("(//input[@id='q_frst_nm_or_lst_nm_cont'])[1]")).sendKeys("Cucumber");
	//// Thread.sleep(2000);
	//// driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
	//// Thread.sleep(3000);
	// }
	//
	// @Then("click on delete button and confirm to delete the healthcoach")
	// public void click_on_delete_button_and_confirm_to_delete_the_healthcoach()
	// throws Exception {
	//// driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).click();
	//// Thread.sleep(2000);
	//// driver.findElement(By.xpath("(//a[text()='Yes'])[1]")).click();
	//// Thread.sleep(3000);
	// }
	//
	// @And("click on the plus button to add staff member for healthcocah")
	// public void click_on_the_plus_button_to_add_staff_member_for_healthcocah()
	// throws Exception {
	// // clicking on the add staff member
	// driver.findElement(By.xpath("//i[text()='add']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("enter the following details into the staff member details1")
	// public void
	// enter_the_following_details_into_the_staff_member_details1(io.cucumber.datatable.DataTable
	// dataTable) {
	// List<List<String>> hc = dataTable.asLists(String.class);
	// // entering the first name
	// driver.findElement(By.id("first_name")).sendKeys(hc.get(0).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the last name
	// driver.findElement(By.id("lst_name")).sendKeys(hc.get(1).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @And("selecting the sex of the healthcoach")
	// public void selecting_the_sex_of_the_healthcoach() {
	// // selecting the gender
	// WebElement gender = driver.findElement(By.xpath("//label[text()='M']"));
	// gender.click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @Then("selecting the age of healthcoach")
	// public void selecting_the_age_of_healthcoach() throws Exception {
	// // selecting the dob
	// driver.findElement(By.id("saathi_master_dob")).click();
	// Thread.sleep(1000);
	// // year
	// driver.findElement(By.xpath("//div[@class='selects-container']/div[2]/input")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // 1971
	// driver.findElement(By.xpath("/html/body/ul[1]/li[49]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // month
	// driver.findElement(By.xpath("//div[@class='selects-container']/div[1]/input")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // march
	// driver.findElement(By.xpath("/html/body/ul[2]/li[3]/span")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // date-1
	// driver.findElement(By.xpath("//button[text()='1']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @And("selecting the country code for mobile number of the healthcoach")
	// public void selecting_the_country_code_for_mobile_number_of_the_healthcoach()
	// {
	// driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("//li[text()='+91']")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @Then("enter the following details into the staff member details2")
	// public void
	// enter_the_following_details_into_the_staff_member_details2(io.cucumber.datatable.DataTable
	// dataTable)
	// throws Exception {
	// List<List<String>> hc = dataTable.asLists(String.class);
	// // entering the phone number
	// driver.findElement(By.id("nmbr")).sendKeys(hc.get(0).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//// // entering the mail id
	//// driver.findElement(By.id("email")).sendKeys(hc.get(1).get(1));
	//// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the address line1
	// driver.findElement(By.id("address-line1")).sendKeys(hc.get(1).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the address line2
	// driver.findElement(By.name("adrs_line2")).sendKeys(hc.get(2).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the landmark
	// driver.findElement(By.id("landmark")).sendKeys(hc.get(3).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// }
	//
	// @Then("select the city from the dropdown of healthcoach")
	// public void select_the_city_from_the_dropdown_of_healthcoach() throws
	// Exception {
	// driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.xpath("(//li[text()='Hyderabad'])[1]")).click();
	// Thread.sleep(1000);
	// }
	//
	// @And("enter the district and pincode for the healthcoach")
	// public void enter_the_district_and_pincode_for_the_healthcoach() throws
	// Exception {
	// // entering the district
	// driver.findElement(By.id("district")).sendKeys("test district");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // entering the pincode
	// driver.findElement(By.id("pn_cd")).sendKeys("767676");
	// Thread.sleep(1000);
	// Robot robot = new Robot();
	// robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	// Thread.sleep(2000);
	// }
	//
	// @And("select the martial status for the healthcoach")
	// public void select_the_martial_status_for_the_healthcoach() throws Exception
	// {
	// // selecting the martial status
	// WebElement gndr = driver.findElement(By.xpath("//label[text()='Single']"));
	// gndr.click();
	// Thread.sleep(1000);
	// }
	//
	// @Then("select the destignation from the dropdown for healthcoach")
	// public void select_the_destignation_from_the_dropdown_for_healthcoach()
	// throws Exception {
	// // selecting the designation
	// driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.findElement(By.xpath("//li[text()='Technician']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @When("designation is selected then location is automatically filledup")
	// public void designation_is_selected_then_location_is_automatically_filledup()
	// {
	//
	// }
	//
	// @Then("clear and enter the location of the healthcoach")
	// public void clear_and_enter_the_location_of_the_healthcoach() throws
	// Exception {
	// driver.findElement(By.cssSelector("input#imei_location")).clear();
	// Thread.sleep(1000);
	// driver.findElement(By.cssSelector("input#imei_location")).sendKeys("Testlocation");
	// Thread.sleep(1000);
	// }
	//
	// @And("enter the qualification of the healthcoach")
	// public void enter_the_qualification_of_the_healthcoach() throws Exception {
	// driver.findElement(By.cssSelector("input#education")).sendKeys("MCA");
	// Thread.sleep(1000);
	// }
	//
	// @When("enter the following details into healthcoach form")
	// public void
	// enter_the_following_details_into_healthcoach_form(io.cucumber.datatable.DataTable
	// dataTable)
	// throws Exception {
	// List<List<String>> regData = dataTable.asLists(String.class);
	//
	// // experience
	// driver.findElement(By.cssSelector("input#saathi_master_experience")).sendKeys(regData.get(0).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// // profile picture
	// driver.findElement(By.cssSelector("input#saathi_master_saathi_pht_file_name")).sendKeys(regData.get(1).get(1));
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// // profile
	// driver.findElement(By.cssSelector("textarea#saathi_master_description")).sendKeys(regData.get(2).get(1));
	// Thread.sleep(2000);
	// Robot robot = new Robot();
	// robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	// Thread.sleep(1000);
	// }
	//
	// @Then("select the demand program from the dropdown for the healthcoach")
	// public void select_the_demand_program_from_the_dropdown_for_the_healthcoach()
	// throws Exception {
	// // selecting the demand program
	// driver.findElement(By.xpath(
	// "/html/body/main/div/div[3]/div/div/div[2]/div/div[2]/form/div/div[13]/div[2]/span/span[1]/span/ul/li/input"))
	// .click();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.xpath("//li[text()='NanoHealth-HYD']")).click();
	// Thread.sleep(1000);
	// }
	//
	// @And("enable the active checkbox for the healthcoach")
	// public void enable_the_active_checkbox_for_the_healthcoach() {
	// for (int i = 0; i <= 1; i++) {
	// WebElement active =
	// driver.findElement(By.xpath("(//label[text()='Active'])[2]"));
	// active.click();
	// }
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// }
	//
	// @Then("click on the submit button from the staff member details")
	// public void click_on_the_submit_button_from_the_staff_member_details() throws
	// Exception {
	// // entering the mail id
	// // driver.findElement(By.id("email")).sendKeys("automationhcone@gmail.com");
	// // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// // clicking on the submit
	// driver.findElement(By.xpath("/html/body/main/div
	// /div[3]/div/div/div[2]/div/div[2]/form/div/div[14]/input[1]"))
	// .click();
	// Thread.sleep(3000);
	// }
	//
	// @And("closing the alert of the staff member")
	// public void closing_the_alert_of_the_staff_member() throws Exception {
	// // closing the alert
	// driver.findElement(By.xpath("/html/body/main/div/div[2]/div[12]/div/div[1]/span/i")).click();
	// Thread.sleep(3000);
	// }
	//
	// @Then("navigate to the staff members page")
	// public void navigate_to_the_staff_members_page() throws Exception {
	// driver.navigate().to("https://customer.nanohealthplan.com/staff_masters");
	// Thread.sleep(1000);
	// }
	//
	// @And("click on the edit button and update the mobile number")
	// public void click_on_the_edit_button_and_update_the_mobile_number() throws
	// Exception {
	// // clicking on the edit
	// driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
	// Thread.sleep(1000);
	// // entering the phone number
	// driver.findElement(By.id("nmbr")).clear();
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// driver.findElement(By.id("nmbr")).sendKeys("7123812398");
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//
	// }
	//
	// @Then("click on the save button from the edit staff member")
	// public void click_on_the_save_button_from_the_edit_staff_member() throws
	// Exception {
	// // clicking on the submit
	// driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div/div[2]/div/div[2]/form/div/div[14]/input[1]"))
	// .click();
	// Thread.sleep(2000);
	// }
	//
	// @And("navigate to the masterdata dashboard")
	// public void navigate_to_the_masterdata_dashboard() throws Exception {
	// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
	// Thread.sleep(1000);
	// Robot robot = new Robot();
	// robot.keyPress(KeyEvent.VK_SHIFT);
	// robot.keyPress(KeyEvent.VK_CONTROL);
	// robot.keyPress(KeyEvent.VK_F3);
	// Thread.sleep(1000);
	// robot.keyRelease(KeyEvent.VK_F3);
	// robot.keyRelease(KeyEvent.VK_CONTROL);
	// robot.keyRelease(KeyEvent.VK_SHIFT);
	// Thread.sleep(3000);
	// driver.quit();
	// }

	@Then("click on the storemaster from the masterdata")
	public void click_on_the_storemaster_from_the_masterdata() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Store Masters'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("search and delete the already existing storemaster")
	public void search_and_delete_the_already_existing_storemaster() throws Exception {
		driver.findElement(By.cssSelector("input#q_store_name_start")).sendKeys("Cucum");
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the delete button
		driver.findElement(By.xpath("(//i[@class='fa fa-trash-o fa-1x red-text'])[1]")).click();
		Thread.sleep(2000);
		// confirm
		driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		Thread.sleep(4000);
	}

	@When("existing storemaster is deleted")
	public void existing_storemaster_is_deleted() {

	}

	@Then("click on the plus button to add new storemaster")
	public void click_on_the_plus_button_to_add_new_storemaster() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add new store'])[1]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add new store'])[1]")).click();
		Thread.sleep(2000);
	}

	@When("plus button is clicked it will open a popup to add new storemaster")
	public void plus_button_is_clicked_it_will_open_a_popup_to_add_new_storemaster() {

	}

	@Then("select the hospital name from dropdown")
	public void select_the_hospital_name_from_dropdown() {
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='NanoHealth_OPD'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("enter the required store type and store name")
	public void enter_the_required_store_type_and_store_name() {
		// store type
		driver.findElement(By.cssSelector("input#hospital_store_master_store_type")).sendKeys("Test store type");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// store name
		driver.findElement(By.cssSelector("input#hospital_store_master_store_name")).sendKeys("Cucum store");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Then("click on the save button to save the new store master")
	public void click_on_the_save_button_to_save_the_new_store_master() throws Exception {
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("search the store and click on the edit button")
	public void search_the_store_and_click_on_the_edit_button() throws Exception {
		driver.findElement(By.cssSelector("input#q_store_name_start")).sendKeys("Cucum");
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("edit the changes and save again of store master")
	public void edit_the_changes_and_save_again_of_store_master() throws Exception {
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(2000);
		// store type
		driver.findElement(By.cssSelector("input#hospital_store_master_store_type")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#hospital_store_master_store_type")).sendKeys("Cucum store type");
		Thread.sleep(2000);
		// save
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@And("search the recently added store using search functionality")
	public void search_the_recently_added_store_using_search_functionality() throws Exception {
		driver.findElement(By.cssSelector("input#q_store_name_start")).sendKeys("Cucum");
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);

	}

	@Then("navigate to the masterdata dashboard from storemaster")
	public void navigate_to_the_masterdata_dashboard_from_storemaster() throws Exception {
		// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		Thread.sleep(1000);
		driver.close();
	}

	@And("click on the url shortener button from the masterdata")
	public void click_on_the_url_shortener_button_from_the_masterdata() throws Exception {
		driver.findElement(By.xpath("(//a[text()='URL Shortener'])[1]")).click();
		Thread.sleep(1000);
	}

	@Then("enter the url and click on the generate url button")
	public void enter_the_url_and_click_on_the_generate_url_button() throws Exception {
		driver.findElement(By.xpath("(//input[@name='url'])[1]"))
				.sendKeys("Https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(2000);
		// generate url
		driver.findElement(By.cssSelector("input#url_submit_btn")).click();
		Thread.sleep(2000);
	}

	@When("shortener link is generated then it will show the shortener url in the below")
	public void shortener_link_is_generated_then_it_will_show_the_shortener_url_in_the_below() {

	}

	@Then("copy the url using copy button")
	public void copy_the_url_using_copy_button() throws Exception {
		driver.findElement(By.xpath("(//i[text()='content_copy'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("paste it in the new tab and click enter")
	public void paste_it_in_the_new_tab_and_click_enter() throws Exception {
		// opening new tab
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_N);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_N);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		// pasting the url link
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		// clicking on the enter button
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	@When("it will open the link of the url shortener and closing this tab")
	public void it_will_open_the_link_of_the_url_shortener_and_closing_this_tab() throws Exception {
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot3.keyPress(KeyEvent.VK_W);
		Thread.sleep(2000);
	}

	@Then("navigated back to the previous page and just click on the close button")
	public void navigated_back_to_the_previous_page_and_just_click_on_the_close_button() throws Exception {
		driver.findElement(By.xpath("(//i[text()='clear'])[1]")).click();
		Thread.sleep(1000);
	}

	@And("clicking on the reset button from the url shortener page")
	public void clicking_on_the_reset_button_from_the_url_shortener_page() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
	}

	@Then("navigate to the masterdata dashboard from url shortener")
	public void navigate_to_the_masterdata_dashboard_from_url_shortener() throws Exception {
		// driver.navigate().to("https://customer.nanohealthplan.com/master_data_dashboard");
		Thread.sleep(1000);
		driver.close();
	}

	@And("click on the procedurerooms from the masterdata")
	public void click_on_the_procedurerooms_from_the_masterdata() throws Exception {
		driver.findElement(By.xpath("(//a[text()='Procedure Rooms'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("click on the plus button to add a new procedurerooms")
	public void click_on_the_plus_button_to_add_a_new_procedurerooms() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Add Procedure Room'])[1]/i[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Procedure Room'])[1]/i[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Users'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Sunil K'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#ot_room_master_ot_room_no")).sendKeys("1001");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#ot_room_master_desc")).sendKeys("cucumdescription");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#ot_room_master_price")).sendKeys("1000");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#ot_room_master_ot_room_table_masters_attributes_0_ot_table_no"))
				.sendKeys("1001A");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#ot_room_master_ot_room_table_masters_attributes_0_desc"))
				.sendKeys("testdesc1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#ot_room_master_ot_room_table_masters_attributes_0_price"))
				.sendKeys("1000");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[2]/div[2]/div/div[2]/div/div[1]/div/input"))
				.sendKeys("1001B");
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[2]/div[2]/div/div[2]/div/div[2]/div/input"))
				.sendKeys("test");
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[2]/div[2]/div/div[2]/div/div[3]/div/input"))
				.sendKeys("1000");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(2000);
	}

	@And("save the procedurerooms after entering the details")
	public void save_the_procedurerooms_after_entering_the_details() throws Exception {
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
	}

	@Then("edit and save again the procedurerooms")
	public void edit_and_save_again_the_procedurerooms() throws Exception {
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#ot_room_master_price")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#ot_room_master_price")).sendKeys("1500");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
		Thread.sleep(3000);
		driver.close();
	}

}
