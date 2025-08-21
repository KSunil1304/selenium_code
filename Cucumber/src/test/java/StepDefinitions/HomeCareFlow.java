package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeCareFlow {
	WebDriver driver = null;

	@Test(priority = 0)
	public void Addingapatient() throws Exception {
		// clinic manager role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[1]/div/div/div/div[2]")).click();
		Thread.sleep(4000);
		// clicking on the add patient
		WebDriverWait addpatinet = new WebDriverWait(driver, Duration.ofSeconds(60));
		addpatinet
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		Thread.sleep(3000);
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='first_name'])[1]")).sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='lst_name'])[1]")).sendKeys("Homecare");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the age
		driver.findElement(By.xpath("(//input[@id='age'])[1]")).sendKeys("40");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// country code
		driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='+91']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(By.id("nmbr")).sendKeys("9988771122");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("homecareauto@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='address-line1'])[1]")).sendKeys("Hyderabad");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@name='adrs_line2'])[1]")).sendKeys("Hyderabad");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='landmark'])[1]")).sendKeys("Ameerpet");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// city
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).sendKeys("testcity");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// district
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).sendKeys("testdist");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		// pincode
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys("500034");
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		// selecting the demand program
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Emoha'])[1]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void BookingNursingOfficerApt() throws Exception {

		// mouse hovering on the book nursing officer appointment
		Actions ambul = new Actions(driver);
		ambul.moveToElement(
				driver.findElement(By.xpath("(//a[@data-tooltip='Book Nursing Officer Appointment'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		// clicking on the ambulance
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("(//a[@data-tooltip='Book Nursing Officer Appointment'])[1]/img[1]"))))
				.click();
		// driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(9)")).click();
		Thread.sleep(3000);

		// searching the executive with filter
		driver.findElement(By.xpath("(//label[text()='Name'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Sunil'])[1]")).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// book appointment
		driver.findElement(By.xpath("(//a[text()='Book Appointment'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='icon'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#start_date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#start_time")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='timepicker-analog-display'])[1]/div[2]/div[1]/button[2]")).click();
		Thread.sleep(2000);
		// continue
		driver.findElement(
				By.xpath("(//button[@class='waves-effect waves-dark btn green next-step right btn_cnt'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/main/div/div[5]/div/div/div[2]/form/ul/li[3]/div[2]/div[1]/div/div[2]/div/div/div/div[1]/div/div"))
				.click();
		Thread.sleep(2000);
		// clicking on the book now button
		driver.findElement(By.xpath("(//input[@id='bookNowBtn'])[1]")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//label[text()='Price'])[1]/following-sibling::input[1]")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//label[text()='Price'])[1]/following-sibling::input[1]")).sendKeys("100");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@id='bookNowBtn'])[1]")).click();
//		Thread.sleep(4000);
//		Robot pgdwn = new Robot();
//		pgdwn.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		WebElement pyltr = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
//		pyltr.click();
//		Thread.sleep(2000);
//		// submit
//		driver.findElement(By.cssSelector("a#bookLater")).click();
//		Thread.sleep(4000);
//		// mouse-hover on invoice - print invoice
//		Actions invoice1 = new Actions(driver);
//		invoice1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).build()
//				.perform();
//		Thread.sleep(1000);
//		invoice1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).click()
//				.build().perform();
//		Thread.sleep(2000);
//		Robot robot4 = new Robot();
//		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(2000);
//		// clicking on the print
//		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(1000);
//		// clicking on the print without details
//		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(3000);
////		// share invoice
////		driver.findElement(By.xpath("(//a[@class='btn green right btn-loader2 service_wise_pdf'])[1]")).click();
////		Thread.sleep(3000);
////		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).clear();
////		Thread.sleep(1000);
////		driver.findElement(By.xpath("(//input[@id='phone'])[1]")).clear();
////		Thread.sleep(1000);
////		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).sendKeys("sunil.kommayella@nanohealth.in");
////		Thread.sleep(3000);
////		// submit
////		driver.findElement(By.xpath("(//input[@class='btn green right btn-loader submitBtn'])[1]")).click();
////		Thread.sleep(10000);
	}

	@Test(priority = 2)

	public void BookHomeCareAttendantApt() throws Exception {
		// clicking on brand logo
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]")).click();
		Thread.sleep(3000);
		// clicking on the executive role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[3]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
		// clicking on the nursing officer booking
		driver.findElement(By.xpath("(//div[text()='Nursing Officer Bookings'])[1]/following-sibling::div[1]")).click();
		Thread.sleep(4000);
		// download
		driver.findElement(By.xpath("(//i[text()='file_download'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Cucum Homecare'])[1]")).click();
		Thread.sleep(2000);
//		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
//			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
//			Thread.sleep(1000);
//		}
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Home Attendant'])[1]/img[1]")))
				.build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Home Attendant'])[1]/img[1]")))
				.click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[@id='services_step'])[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='row address-box'])[1]/div[1]/div[1]/div[1]")).click();
		Thread.sleep(2000);
		// from date
		WebElement startDate = driver.findElement(By.cssSelector("input#appointment_tracking_apmnt_date"));
		startDate.click();
		Thread.sleep(1000);
		WebElement todaydate = driver.findElement(By.xpath("(//td[@class='is-today'])[1]"));
		todaydate.click();
		Thread.sleep(1000);
		WebElement endDate = driver.findElement(By.cssSelector("input#appointment_tracking_apmnt_end_date"));
		endDate.click();
		Thread.sleep(1000);

		List<WebElement> dates = driver.findElements(By.xpath("(//button[@class='datepicker-day-button'])"));
		WebElement lastdate = dates.get(dates.size() - 1);
		lastdate.click();
		Thread.sleep(2000);
		// click on the continue button
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div[57]/div/div/div[2]/form/ul/li[3]/div[2]/div[3]/button"))
				.click();
		Thread.sleep(2000);

		// search the task and add the task
		driver.findElement(By.xpath("(//input[@id='myInput'])[1]")).sendKeys("Foot");
		Thread.sleep(2000);
		for (int i = 0; i <= 1; i++) {
			WebElement vac = driver.findElement(By.xpath("(//label[text()='Foot care'])[1]"));
			vac.click();
			Thread.sleep(2000);
		}
		driver.findElement(By.xpath("(//input[@id='myInput'])[1]")).clear();
		Thread.sleep(2000);
		// search the task and add the task
		driver.findElement(By.xpath("(//input[@id='myInput'])[1]")).sendKeys("M");
		Thread.sleep(2000);
		WebElement vac = driver.findElement(By.xpath("(//label[contains(text(), 'Morning')])[1]"));
		vac.click();
		Thread.sleep(2000);
//		WebElement input = driver.findElement(By.xpath("(//input[@id='myInput'])[1]"));
//		input.clear();
//		input.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
////		driver.findElement(By.xpath("(//input[@id='myInput'])[1]")).click();
////		Thread.sleep(2000);
//		// selecting another task
//		WebElement footmsg = driver.findElement(By.xpath("(//label[text()='Foot Massage'])[1]"));
//		footmsg.click();
//		Thread.sleep(2000);

		// click on the date
		driver.findElement(By.xpath("(//input[@class='service_time timepicker'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("(//div[@class='modal timepicker-modal open'])[1]/div[1]/div[2]/div[1]/div[2]/div[10]"))
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
		Thread.sleep(2000);
		// continue
		driver.findElement(By.xpath("(//button[contains(text(), 'Continue')])[2]")).click();
		Thread.sleep(2000);
		// submit
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[@id='bookNowBtn'])[1]"))))
				.click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		WebElement cash = driver.findElement(By.xpath("(//label[text()='Cash'])[1]"));
		cash.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("10");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(3000);
		// generate inv
		driver.findElement(By.xpath("(//a[text()='Generate'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]")).click();
		Thread.sleep(2000);
		// print invoice -download
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")).click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// clicking on the receipt id
		driver.findElement(By.xpath("(//a[contains(text(), 'R-')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(2000);
		// print without details
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(4000);
		// share invoice
		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebElement submitbtn = driver.findElement(By.xpath("/html/body/main/div/div[13]/div/div[2]/form/div[2]/input"));
		submitbtn.click();
		Thread.sleep(20000);
	}

	@Test(priority = 3)
	public void AssignCarer() throws Exception {
		// clicking on the patient name
		driver.findElement(By.xpath("(//a[text()='Cucum Homecare'])[1]")).click();
		Thread.sleep(10000);
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
		}

//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		WebElement targetElement = driver
//				.findElement(By.xpath("(//div[@id='active_prgrms_sec'])[1]/table[1]/thead[1]/tr[1]/th[1]"));
//		jse.executeScript("arguments[0].scrollIntoView(true);", targetElement);
//		Thread.sleep(2000);

		// clicking on the all checkboxes
		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.xpath("(//div[@id='active_prgrms_sec'])[1]/table[1]/thead[1]/tr[1]/th[1]")).click();
			Thread.sleep(1000);
		}
		// clicking on the checkbox
		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.xpath("(//td[@class='hide_add_btns'])[1]")).click();
			Thread.sleep(1000);
		}
		// clicking on more button
		WebDriverWait sch = new WebDriverWait(driver, Duration.ofSeconds(30));
		sch.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='More Schedules'])[1]")))).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("(//td[@class='hide_add_btns'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='hide_add_btns'])[2]")).click();
		Thread.sleep(1000);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		WebElement Assign = driver.findElement(By.xpath("(//input[@value='Assign'])[1]"));
//		jse.executeScript("arguments[0].scrollIntoView(true);", Assign);
//		Thread.sleep(3000);

		WebElement slider = driver.findElement(By.cssSelector("div#active_prgrms_sec"));
		Actions slide = new Actions(driver);
		slide.dragAndDropBy(slider, 150, 0).perform();
		Thread.sleep(2000);

		// clicking on the assign button
		driver.findElement(By.xpath("(//input[@value='Assign'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Provider'])[1]/preceding-sibling::span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Sunil K (sunilkhc@nh.com)'])[1]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@id='submit'])[1]")).click();
		Thread.sleep(5000);

		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(2000);
		}
		driver.findElement(By.cssSelector("a#admin-dashboard")).click();
		Thread.sleep(3000);
		// clicking on the due amount
		driver.findElement(By.cssSelector("div#due")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[text()='file_download'])[1]")).click();
		Thread.sleep(2000);
		// close popup
		driver.findElement(By.xpath("(//div[@id='modal_service_billing'])[1]/div/div[1]/span/i[1]")).click();
		Thread.sleep(3000);
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void Updatingthetasks() throws Exception {

		// CLICKING ON THE PATIENT NAME
		driver.findElement(By.xpath("(//a[text()='Cucum Homecare'])[1]")).click();
		Thread.sleep(15000);
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(5000);
		// WebElement slider =
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 150);");
		Thread.sleep(3000);
//		// clicking on the add/update task img
//		WebDriverWait task = new WebDriverWait(driver, Duration.ofSeconds(30));
//		task.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add/Update Tasks'])[1]/img[1]"))))
//				.click();
//		Thread.sleep(4000);
//		WebElement taskadd = driver.findElement(By.xpath(""));
//		taskadd.click();
//		Thread.sleep(3000);
//		// submit
//		driver.findElement(By.cssSelector("input#submit")).click();
//		Thread.sleep(8000);
//		// clicking on the add/update task img
//		WebDriverWait task1 = new WebDriverWait(driver, Duration.ofSeconds(30));
//		task1.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add/Update Tasks'])[1]/img[1]"))))
//				.click();
//		Thread.sleep(4000);
//		WebElement taskremove = driver.findElement(By.xpath("(//label[text()='Diabetic Foot Assessment'])[1]"));
//		taskremove.click();
//		Thread.sleep(3000);
//		// submit
//		driver.findElement(By.cssSelector("input#submit")).click();
//		Thread.sleep(8000);
//		WebDriverWait task2 = new WebDriverWait(driver, Duration.ofSeconds(30));
//		task2.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add/Update Tasks'])[1]/img[1]"))))
//				.click();
//		Thread.sleep(5000);
//		// closing task popup
//		WebElement close = driver.findElement(By.xpath("(//div[@id='homeCareTasksModal'])[1]/div[1]/div[1]/span/i[1]"));
//		close.click();
//		Thread.sleep(3000);

	}

	@Test(priority = 5)
	public void OnHold() throws Exception {
		// clicking on the appointment id
		WebDriverWait aptid = new WebDriverWait(driver, Duration.ofSeconds(30));
		aptid.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@class='btn-loader show_apmnts show-highlight'])[1]"))))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='OnHold'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),' Others')])[1]")).click();
		Thread.sleep(2000);
		// entering the comment
		driver.findElement(By.cssSelector("textarea#cmmts")).sendKeys("This Appointment is onhold");
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//input[@value='Yes'])[1]")).click();
		Thread.sleep(3000);
		// onhold other appointments Yes
		driver.findElement(By.xpath("(//input[@value='Yes'])[1]")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 150);");
		Thread.sleep(2000);
	}

	@Test(priority = 6)
	public void Activateafterhold() throws Exception {
		// clicking on the appointment id
		WebDriverWait aptid = new WebDriverWait(driver, Duration.ofSeconds(30));
		aptid.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@class='btn-loader show_apmnts show-highlight'])[1]"))))
				.click();
		Thread.sleep(3000);
		// clicking on the activate button
		driver.findElement(By.xpath("(//a[text()='Activate'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the yes button
		driver.findElement(By.xpath("(//input[@value='Yes'])[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(8000);
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(5000);

	}

	@Test(priority = 6)
	public void Removeassignment() throws Exception {
		// selecting the checkbox
		driver.findElement(By.xpath("(//td[@class='hide_add_btns'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Remove Assignment'])[1]")).click();
		Thread.sleep(5000);
		// yes
		driver.findElement(
				By.xpath("(//div[@id='assign-hc-modal'])[1]/div[1]/div[2]/div[1]/span[1]/following-sibling::a[1]"))
				.click();
		Thread.sleep(5000);
		// close for pending amount
		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(5000);
		// re-assigining the carer
		// selecting the checkbox
		driver.findElement(By.xpath("(//td[@class='hide_add_btns'])[2]")).click();
		Thread.sleep(2000);
		// clicking on the assign button
		driver.findElement(By.xpath("(//input[@value='Assign'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Provider'])[1]/preceding-sibling::span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Sunil K (sunilkhc@nh.com)'])[1]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@id='submit'])[1]")).click();
		Thread.sleep(5000);

		if (driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).isDisplayed()) {
			driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[1]/span/i")).click();
			Thread.sleep(2000);
		}
		driver.findElement(By.cssSelector("a#admin-dashboard")).click();
		Thread.sleep(3000);

	}

	@BeforeClass
	public void Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver132.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user_login")).sendKeys("sunilkhc@nh.com");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		driver.findElement(By.name("commit")).click();
		Thread.sleep(2000);

		// selecting Role clicking on CDPAdmin Role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[2]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("frst_nm")).sendKeys("Cucumhomecare");
		Thread.sleep(5000);
		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);
		// clicking on the view profile
		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
		Thread.sleep(3000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_SUBTRACT);
//		Thread.sleep(1000);
//		robot.keyRelease(KeyEvent.VK_SUBTRACT);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(1000);
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
		Thread.sleep(15000);
		// brand logo
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]")).click();
		Thread.sleep(3000);
	}

	@AfterClass
	public void afterClass() {
	}

}
