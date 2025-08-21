package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Drteleconsultation {
	WebDriver driver = null;

	@Test(priority = 0)
	public void Registeringapatient() throws Exception {
		// brand logo click
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking CDPAdmin role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[7]/div/div/div/div[2]")).click();
		Thread.sleep(3000);

		WebDriverWait rp = new WebDriverWait(driver, Duration.ofSeconds(30));
		rp.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("/html/body/header/nav/ul/span[1]/li[1]/div/a/img"))))
				.click();
		// selecting the title
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//span[@class='selection'])[1]")).sendKeys(Keys.DOWN);
		// Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// firstname
		driver.findElement(By.id("first_name")).sendKeys("Cucum");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// lastname
		driver.findElement(By.id("lst_name")).sendKeys("Doctteleconsult");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		driver.findElement(By.id("age")).sendKeys("45");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// phone
		driver.findElement(By.id("nmbr")).sendKeys("7718110013");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// email
		driver.findElement(By.id("email")).sendKeys("doctele@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// addressline
		driver.findElement(By.id("address-line1")).sendKeys("ameerpet");
		driver.findElement(By.id("autocomplete-input")).sendKeys("ameerpet");
		driver.findElement(By.id("landmark")).sendKeys("metro station");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// city
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// district
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// pincode
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys("878787");
		Thread.sleep(1000);
		Robot pd = new Robot();
		pd.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// aadharcardnumber
		driver.findElement(By.xpath("/html/body/main/div/form/div[2]/div[1]/div/div[9]/div[2]/input"))
				.sendKeys("123456789012");
		// abhacard
		WebElement ac = driver.findElement(By.xpath("(//label[text()='No'])[1]"));
		ac.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		// driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys("767676");
		// profession
		driver.findElement(By.xpath("(//input[@name='patient_master[profession]'])[1]")).sendKeys("test profession");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
		Thread.sleep(1000);
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("update_submit")))).click();
		// driver.findElement(By.id("update_submit")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void Videoappointment() throws Exception {
		// mouse hover on the doc booking
		Actions doc = new Actions(driver);
		doc.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Book Doctor Appointment'])/img"))).build()
				.perform();
		Thread.sleep(1000);
		// clicking on the doctor appointment
		driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(1)>img")).click();
		Thread.sleep(2000);
		// clicking on the book appointment
		driver.findElement(By.xpath("(//a[text()='Book Appointment'])[1]")).click();
		Thread.sleep(1000);
		// selecting the type - video type
		driver.findElement(By.xpath("(//div[@class='icon'])[2]")).click();
		Thread.sleep(2000);
		Robot robot11 = new Robot();
		for (int i = 0; i < 2; i++) {
			robot11.keyPress(KeyEvent.VK_CONTROL);
			robot11.keyPress(KeyEvent.VK_SUBTRACT);
			robot11.keyRelease(KeyEvent.VK_SUBTRACT);
			robot11.keyRelease(KeyEvent.VK_CONTROL);
		}
		Thread.sleep(2000);
		// selecting the date and time - tomorrow
		driver.findElement(By.xpath("//div[@class='row dates-container']/div[2]")).click();
		Thread.sleep(2000);
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
		// clicking on the submit
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
		// driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(10000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash.click();
		Thread.sleep(1000);
		// entering the amount
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("250");
		Thread.sleep(2000);
		// clicking on the comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test comment");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		Thread.sleep(1000);
		// clicking on the submit
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
//		// clicking on the receipt id
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[5]/div[2]/div[2]/a")).click();
//		Thread.sleep(3000);
//		// clicking on the total receipt
//		driver.findElement(By.xpath("(//div[@class='price-details'])[2]/div[3]/div[1]/strong/span/a/img")).click();
//		Thread.sleep(2000);
//		// clicking on the print
//		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
//		Thread.sleep(2000);
//		// clicking on the share invoice
//		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
//		Thread.sleep(8000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("phone")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// submit
//		WebElement submit1 = driver.findElement(By.xpath("/html/body/main/div/div[12]/div/div[2]/form/div[2]/input"));
//		submit1.click();
//		Thread.sleep(18000);
		// clicking on the logo
		driver.findElement(By.xpath("/html/body/header/nav/ul/li/a/div/div[1]/img")).click();
		Thread.sleep(1000);
		// clicking on sign out
		driver.findElement(By.xpath("/html/body/header/nav/ul/li/ul/li[5]/a")).click();
		Thread.sleep(1000);
		// navigate
		driver.navigate().to("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(2000);
		driver.findElement(By.id("user_login")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("user_login")).sendKeys("dr@yourclinic.com");
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("user_password")).sendKeys("Demo@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		Thread.sleep(3000);// clicking on the week
		driver.findElement(By.xpath("(//a[text()='Week'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the consult button
		driver.findElement(By.xpath("(//a[text()='Consult'])[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void DocTeleconsultation() throws Exception {
		Actions telec = new Actions(driver);
		telec.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='SendLink'])[2]/img"))).build().perform();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='SendLink'])[2]/img"))))
				.click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		for (int i = 0; i < 2; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		// clearing email id and number
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='mobile'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(2000);
		// submit
		WebDriverWait sub = new WebDriverWait(driver, Duration.ofSeconds(30));
		sub.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("(//div[@id='modal_consult'])[1]/div/div[2]/form/div[2]/input[1]"))))
				.click();
		Thread.sleep(25000);
		// consultation type-video
		for (int i = 0; i <= 2; i++) {
			driver.findElement(By.xpath("(//label[text()='Video'])[1]")).click();
			Thread.sleep(1000);
		}
		// accompained by
		driver.findElement(By.id("healthHistoryTxt")).sendKeys("demo test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("healthHistoryTxt")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("healthHistoryTxt")).sendKeys("demo test2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// patient history
		driver.findElement(By.xpath("(//div[@class='section_header'])[3]//following-sibling::div/textarea"))
				.sendKeys("demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//div[@class='section_header'])[3]//following-sibling::div/textarea"))
				.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//div[@class='section_header'])[3]//following-sibling::div/textarea"))
				.sendKeys("demo1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//div[@class='section_header'])[3]//following-sibling::div/textarea"))
				.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//div[@class='section_header'])[3]//following-sibling::div/textarea"))
				.sendKeys("demo2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//div[@class='section_header'])[3]//following-sibling::div/textarea"))
				.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//div[@class='section_header'])[3]//following-sibling::div/textarea"))
				.sendKeys("demo3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(2000);

		Actions pview = new Actions(driver);
		pview.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Prescription View'])[1]"))).build()
				.perform();
		Thread.sleep(1000);
		pview.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Prescription View'])[1]"))).click()
				.build().perform();
		Thread.sleep(2000);

		// chief complaints
		driver.findElement(By.xpath("(//label[text()='Chief Complaints'])[1]/following-sibling::input[1]")).click();
		Thread.sleep(2000);
		Robot enter = new Robot();
		enter.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[1]")).sendKeys("3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		enter.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Weeks'])[1]")).click();
		Thread.sleep(1000);
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
		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[2]")).sendKeys("3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		enter.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Months'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Chief Complaints'])[1]/following-sibling::input[1]"))
				.sendKeys(Keys.ESCAPE);
		Thread.sleep(2000);
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(2000);

		// Actions pview = new Actions(driver);
		// pview.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Prescription
		// View'])[1]"))).build()
		// .perform();
		// Thread.sleep(1000);
		// pview.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Prescription
		// View'])[1]"))).click()
		// .build().perform();
		// Thread.sleep(2000);

		// symptoms
		driver.findElement(By.id("doctor_visit_symptoms")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("doctor_visit_symptoms")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[1]")).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the dropdown
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the week
		driver.findElement(By.xpath("//li[text()='Week']")).click();
		Thread.sleep(2000);
		for (int i = 0; i <= 2; i++) {
			driver.findElement(By.id("doctor_visit_symptoms")).sendKeys(Keys.RIGHT);
			Thread.sleep(1000);
		}
		for (int i = 0; i <= 2; i++) {
			driver.findElement(By.id("doctor_visit_symptoms")).sendKeys(Keys.LEFT);
			Thread.sleep(1000);
		}
		driver.findElement(By.id("doctor_visit_symptoms")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// duration
		driver.findElement(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[2]")).sendKeys("20");
		Thread.sleep(1000);
		driver.findElement(By.id("doctor_visit_symptoms")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("doctor_visit_symptoms")).sendKeys("gg");
		Thread.sleep(1000);
		driver.findElement(By.id("doctor_visit_symptoms")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// duration
		driver.findElement(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[3]")).sendKeys("20");
		Thread.sleep(2000);
		// removing
		driver.findElement(By.xpath("(//div[@id='input_close'])[3]")).click();
		Thread.sleep(1000);
		// removing
		driver.findElement(By.xpath("(//div[@id='input_close'])[2]")).click();
		Thread.sleep(2000);
		// symptoms
		driver.findElement(By.id("doctor_visit_symptoms")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("doctor_visit_symptoms")).sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("window.scrollBy(0,100)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// diagnosis
		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[diagnosis][][dur]'])[1]")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		robot3.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		robot3.keyPress(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).click();
		Thread.sleep(1000);
		for (int i = 0; i <= 3; i++) {
			Robot robot5 = new Robot();
			robot5.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}

		for (int i = 0; i <= 3; i++) {
			Robot robot6 = new Robot();
			robot6.keyPress(KeyEvent.VK_LEFT);
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		Robot robot7 = new Robot();
		robot7.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[diagnosis][][dur]'])[2]")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot8 = new Robot();
		robot8.keyPress(KeyEvent.VK_TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		robot8.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		robot8.keyPress(KeyEvent.VK_ENTER);
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
		Robot robot9 = new Robot();
		robot9.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(1000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse5.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// vitals
		// pulse
		driver.findElement(By.xpath("(//label[text()='Pulse (bpm)'])/following-sibling::input")).sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// height
		driver.findElement(By.xpath("(//label[text()='Height (Cms)'])/following-sibling::input")).sendKeys("170");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// weight
		driver.findElement(By.xpath("(//label[text()='Weight (Kgs)'])/following-sibling::input")).sendKeys("79");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		jse6.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		// history line
		driver.findElement(By.xpath("(//div[@class='section_header'])[9]//following-sibling::div/textarea"))
				.sendKeys("test history");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='section_header'])[9]//following-sibling::div/textarea"))
				.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='section_header'])[9]//following-sibling::div/textarea"))
				.sendKeys("test history");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse7 = (JavascriptExecutor) driver;
		jse7.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		// Medication
		Thread.sleep(3000);
		driver.findElement(By.id("patient_prescription_header_patient_prescription_lines_attributes_0_brand_name"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.id("patient_prescription_header_patient_prescription_lines_attributes_0_brand_name"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// clicking on the notes
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='Less'])[1]")).click();
		Thread.sleep(1000);
		// another
		driver.findElement(By.xpath(
				"/html/body/main/div/div[2]/div/div/div[2]/div/div/div/form/div[23]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/input[1]"))
				.click();
		Thread.sleep(2000);
		for (int i = 0; i <= 3; i++) {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}

		for (int i = 0; i <= 3; i++) {
			Robot l = new Robot();
			l.keyPress(KeyEvent.VK_LEFT);
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		Robot e = new Robot();
		e.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// clicking on the notes
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='Less'])[2]")).click();
		Thread.sleep(1000);
		// clicking on the notes
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='Less'])[2]")).click();
		Thread.sleep(1000);
		// removing
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[5]")).click();
		Thread.sleep(2000);
		JavascriptExecutor jse8 = (JavascriptExecutor) driver;
		jse8.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		// next visit date
		driver.findElement(By.cssSelector("input#doctor_visit_nxt_vst_dur")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("doctor_visit_nxt_vst_dur")).sendKeys("20");
		Thread.sleep(1000);
		JavascriptExecutor jse9 = (JavascriptExecutor) driver;
		jse9.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// labs
		Thread.sleep(2000);
		driver.findElement(By.id("recommended_lab_input_helper")).sendKeys("Ecg");
		Thread.sleep(3000);
		Robot labs = new Robot();
		labs.keyPress(KeyEvent.VK_ENTER);
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
		JavascriptExecutor jse10 = (JavascriptExecutor) driver;
		jse10.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		// comments
		driver.findElement(By.cssSelector("input#doctor_visit_procedure")).sendKeys("IV INFUSION");
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//div[@class='section_header'])[10]//following-sibling::div"))
		// .sendKeys("IV INFUSION");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='btn green procedureSltd prcdr_sltd_active'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Heart'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@name='doctor_visit[procedure][][dur_date]'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// notes
		driver.findElement(By.xpath("(//div[@class='input_note_prcdr'])[1]/img")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@name='doctor_visit[procedure][][note]'])[1]"))
				.sendKeys("IV Fusion test notes");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// notes
		driver.findElement(By.xpath("(//div[@class='input_note_prcdr'])[1]/img")).click();
		Thread.sleep(3000);

		// adding another procedure
		driver.findElement(By.cssSelector("input#doctor_visit_procedure")).sendKeys("Covid");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='btn green procedureSltd prcdr_sltd_active'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[procedure][][dur_date]'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// notes
		driver.findElement(By.xpath("(//div[@class='input_note_prcdr'])[2]/img")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@name='doctor_visit[procedure][][note]'])[2]"))
				.sendKeys("IV Fusion test notes");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// notes
		driver.findElement(By.xpath("(//div[@class='input_note_prcdr'])[2]/img")).click();
		Thread.sleep(1000);

		// removing last added procedure
		driver.findElement(By.xpath("(//div[@class='input_close_prcdr'])[2]/i")).click();
		Thread.sleep(2000);

		JavascriptExecutor jse11 = (JavascriptExecutor) driver;
		jse11.executeScript("window.scrollBy(0,200)", "");

		// pain scale
		driver.findElement(By.xpath("(//div[@class='icon'])[1]/img")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse12 = (JavascriptExecutor) driver;
		jse12.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// current procedures
		driver.findElement(By.cssSelector("input#doctor_visit_current_procedure")).sendKeys("IV INFUSION");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='curnt_prcdr_nm'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Heart'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot tB = new Robot();
		tB.keyPress(KeyEvent.VK_TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Session-2'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[current_procedure][][dur_date]'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// notes
		driver.findElement(By.xpath("(//div[@class='input_note_curnt_prcdr'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@name='doctor_visit[current_procedure][][note]'])[1]"))
				.sendKeys("IV Fusion test notes");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// notes
		driver.findElement(By.xpath("(//div[@class='input_note_curnt_prcdr'])[1]")).click();
		Thread.sleep(1000);

		// adding another current procedure
		driver.findElement(By.cssSelector("input#doctor_visit_current_procedure")).sendKeys("Covid");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='curnt_prcdr_nm'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[current_procedure][][dur_date]'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// notes
		driver.findElement(By.xpath("(//div[@class='input_note_curnt_prcdr'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@name='doctor_visit[current_procedure][][note]'])[2]"))
				.sendKeys("Covid test notes");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// notes
		driver.findElement(By.xpath("(//div[@class='input_note_curnt_prcdr'])[2]")).click();
		Thread.sleep(1000);
		// removing last added procedure
		driver.findElement(By.xpath("(//div[@class='input_close_curnt_prcdr'])[2]/i")).click();
		Thread.sleep(1000);
		JavascriptExecutor jse13 = (JavascriptExecutor) driver;
		jse13.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// Samudrikam Picture
		Actions capture1 = new Actions(driver);
		capture1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Capture'])[1]/img"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Capture'])[1]/img")).click();
		Thread.sleep(3000);
		// capture
		driver.findElement(By.cssSelector("div#capture")).click();
		Thread.sleep(2000);
		// capturing again
		driver.findElement(By.cssSelector("div#capture")).click();
		Thread.sleep(2000);
		// removing last captured photo
		driver.findElement(By.xpath("(//i[@class='material-icons close_captr'])[4]")).click();
		Thread.sleep(2000);
		// save
		driver.findElement(By.cssSelector("input#submitCaptures")).click();
		Thread.sleep(3000);

		// Upload
		Actions upload = new Actions(driver);
		upload.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Capture'])[2]/img"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Capture'])[2]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#files_constr"))
				.sendKeys("C:\\Users\\Lenovo\\Pictures\\Screenshots\\Screenshot (1926).png");
		Thread.sleep(2000);
		// save
		driver.findElement(By.cssSelector("input#submitUploads")).click();
		Thread.sleep(3000);

		JavascriptExecutor jse14 = (JavascriptExecutor) driver;
		jse14.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// Clinical photos/documents
		Actions cphotos = new Actions(driver);
		cphotos.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Capture'])[3]/img"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Capture'])[3]/img")).click();
		Thread.sleep(3000);
		// capture
		driver.findElement(By.cssSelector("div#capture")).click();
		Thread.sleep(2000);
		// capturing again
		driver.findElement(By.cssSelector("div#capture")).click();
		Thread.sleep(2000);
		// removing last captured photo
		driver.findElement(By.xpath("(//i[@class='material-icons close_captr'])[6]")).click();
		Thread.sleep(2000);
		// save
		driver.findElement(By.cssSelector("input#submitCaptures")).click();
		Thread.sleep(3000);

		// Upload
		Actions upload1 = new Actions(driver);
		upload1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Capture'])[4]/img"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Capture'])[4]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#files_constr"))
				.sendKeys("C:\\Users\\Lenovo\\Pictures\\Screenshots\\Screenshot (1926).png");
		Thread.sleep(2000);
		// save
		driver.findElement(By.cssSelector("input#submitUploads")).click();
		Thread.sleep(3000);

		JavascriptExecutor jse15 = (JavascriptExecutor) driver;
		jse15.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// Medication(s)
		for (int i = 0; i <= 2; i++) {
			WebElement cbox1 = driver
					.findElement(By.xpath("(//div[@class='section_header'])[16]//following-sibling::div/div[1]/label"));
			cbox1.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

		for (int i = 0; i <= 2; i++) {
			WebElement cbox1 = driver
					.findElement(By.xpath("(//div[@class='section_header'])[16]//following-sibling::div/div[3]/label"));
			cbox1.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		JavascriptExecutor jse16 = (JavascriptExecutor) driver;
		jse16.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement cbox1 = driver.findElement(
					By.xpath("(//div[@class='section_header'])[16]//following-sibling::div/div[10]/label"));
			cbox1.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		JavascriptExecutor jse17 = (JavascriptExecutor) driver;
		jse17.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//div[@class='section_header'])[17]//following-sibling::div/textarea"))
				.sendKeys("test investigation1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='section_header'])[17]//following-sibling::div/textarea"))
				.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='section_header'])[17]//following-sibling::div/textarea"))
				.sendKeys("test investigation2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("(//div[@class='section_header'])[18]//following-sibling::div/textarea"))
				.sendKeys("test advice1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='section_header'])[18]//following-sibling::div/textarea"))
				.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='section_header'])[18]//following-sibling::div/textarea"))
				.sendKeys("test advice2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);

		// grid view
		Actions grid = new Actions(driver);
		grid.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Grid View'])[1]"))).build().perform();
		Thread.sleep(1000);
		grid.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Grid View'])[1]"))).click().build()
				.perform();
		Thread.sleep(1000);

		// full screen view
		Actions Fsv = new Actions(driver);
		Fsv.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='FullScreen View'])[1]"))).build()
				.perform();
		Thread.sleep(1000);
		Fsv.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='FullScreen View'])[1]"))).click().build()
				.perform();
		Thread.sleep(1000);

		// prescription view
		driver.findElement(By.cssSelector("img#prescriptionView")).click();
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Health Information'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//a[@data-tooltip='Health Information'])[1]/img")).click();
		Thread.sleep(2000);
		// blood group
		driver.findElement(By.xpath("(//a[@id='edit_patient'])[1]/img")).click();
		Thread.sleep(1000);
		// selecting blood group from the dropdown
		driver.findElement(By.cssSelector("span#select2-result_value-container")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='O+'])[1]")).click();
		Thread.sleep(2000);
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Submit'])[3]"))))
				.click();
//				driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();
		Thread.sleep(2000);

		// smoking
		driver.findElement(By.xpath("(//a[@id='edit_patient'])[2]/img")).click();
		Thread.sleep(1000);
		WebElement never = driver.findElement(By.xpath("(//label[text()='Never'])[1]"));
		never.click();
		Thread.sleep(2000);
		WebDriverWait sub1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		sub1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Submit'])[3]"))))
				.click();
//				driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();

		// alcohol
		driver.findElement(By.xpath("(//a[@id='edit_patient'])[3]/img")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#result_value")).sendKeys("3");
		Thread.sleep(2000);
		WebDriverWait sub2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		sub2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Submit'])[3]"))))
				.click();
//				driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();

		// diet
		driver.findElement(By.xpath("(//a[@id='edit_patient'])[4]/img")).click();
		Thread.sleep(1000);
		// selecting diet from the dropdown
		driver.findElement(By.cssSelector("span#select2-result_value-container")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='2'])[1]")).click();
		Thread.sleep(2000);
		WebDriverWait sub3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		sub3.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Submit'])[3]"))))
				.click();
//				driver.findElement(By.xpath("(//input[@value='Submit'])[3]")).click();

		// Excerise
		driver.findElement(By.xpath("(//a[@id='edit_patient'])[5]/img")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#result_value")).sendKeys("1");
		Thread.sleep(2000);
		WebDriverWait sub4 = new WebDriverWait(driver, Duration.ofSeconds(30));
		sub4.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Submit'])[3]"))))
				.click();
		Thread.sleep(1000);
		// closing the popup
		driver.findElement(By.cssSelector("div#patientHistoryInfoModal>div>div>span>i")).click();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Last prescription'])[1]/img"))).build()
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
		Actions acti = new Actions(driver);
		acti.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Lab Reports'])[1]/img"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Lab Reports'])[1]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div#patientHistoryModal>div>div>span>i")).click();
		Thread.sleep(2000);

		// save as draft
		driver.findElement(By.xpath("//input[@value='Save as Draft']")).click();
		Thread.sleep(3000);
		for (int i = 0; i <= 5; i++) {
			JavascriptExecutor jse18 = (JavascriptExecutor) driver;
			jse18.executeScript("window.scrollBy(0,-100)", "");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(1000);
		for (int i = 0; i <= 5; i++) {
			JavascriptExecutor jse18 = (JavascriptExecutor) driver;
			jse18.executeScript("window.scrollBy(0,100)", "");
		}

		// print pdf without header & footer
		Actions pdf = new Actions(driver);
		pdf.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")).click();
		Thread.sleep(3000);
		// with header and footer
		String parentwind = driver.getWindowHandle();
		Actions pdf1 = new Actions(driver);
		pdf1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img")))
				.build().perform();
		Thread.sleep(1000);
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
		// share presciption
		WebDriverWait sp = new WebDriverWait(driver, Duration.ofSeconds(30));
		sp.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img"))))
				.click();
//		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='phone'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebDriverWait subm = new WebDriverWait(driver, Duration.ofSeconds(30));
		subm.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("/html/body/main/div/b/b/div[1]/div/div[2]/form/div[2]/input")))).click();
		Thread.sleep(15000);

		// edit
		Actions edit = new Actions(driver);
		edit.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Edit Prescription'])[1]"))).build()
				.perform();
		Thread.sleep(1000);
		WebDriverWait edit1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		edit1.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Edit Prescription'])[1]")))).click();
		Thread.sleep(3000);
		JavascriptExecutor jse19 = (JavascriptExecutor) driver;
		jse19.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(1000);
		driver.findElement(By.id("healthHistoryTxt")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("healthHistoryTxt")).sendKeys("Parents");
		Thread.sleep(2000);
		JavascriptExecutor jse20 = (JavascriptExecutor) driver;
		jse20.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(1000);
		// save
		driver.findElement(By.cssSelector("input#saveBtn")).click();
		Thread.sleep(5000);

		Alert acc = driver.switchTo().alert();
		acc.accept();
		Thread.sleep(1000);

		JavascriptExecutor jse21 = (JavascriptExecutor) driver;
		jse21.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(1000);
		// print pdf without header & footer
		Actions pdf2 = new Actions(driver);
		pdf2.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")).click();
		Thread.sleep(3000);
		// with header and footer
		String parentwind1 = driver.getWindowHandle();
		try {
			Actions pdf3 = new Actions(driver);
			pdf3.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/img"))).build().perform();
			Thread.sleep(1000);
		} catch (Exception e2) {
			// TODO: handle exception
		}

		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/img")).click();
		Thread.sleep(1000);
		Set<String> childwindow1 = driver.getWindowHandles();
		for (String handle : childwindow1) {
			if (!handle.equals(parentwind1)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind1);
			}

		}
		Thread.sleep(3000);
		// share presciption
		WebDriverWait sp1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		sp1.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img"))))
				.click();
//		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='phone'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebDriverWait subm1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		subm1.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/form/div[2]/input")))).click();
		Thread.sleep(20000);
		// close
		driver.findElement(By.xpath("(//a[text()='Close'])[1]")).click();
		Thread.sleep(3000);
		// mouse hover onto the medical summary
		Actions ms = new Actions(driver);
		ms.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Medical Summary'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Medical Summary'])[1]/img")).click();
		Thread.sleep(3000);
		JavascriptExecutor jse22 = (JavascriptExecutor) driver;
		jse22.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(1000);

		// clicking on the history
		driver.findElement(By.cssSelector("a#patientHistoryBtn")).click();
		Thread.sleep(2000);
		JavascriptExecutor jse23 = (JavascriptExecutor) driver;
		jse23.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
		// print pdf without header & footer
		Actions pdf4 = new Actions(driver);
		pdf4.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")).click();
		Thread.sleep(3000);
		// with header and footer
		Actions pdf5 = new Actions(driver);
		pdf5.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img")))
				.build().perform();
		Thread.sleep(1000);
		String parentwind2 = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img")).click();
		Thread.sleep(1000);
		Set<String> childwindow2 = driver.getWindowHandles();
		for (String handle : childwindow2) {
			if (!handle.equals(parentwind2)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind2);
			}

		}
		Thread.sleep(3000);
		// share presciption
		WebDriverWait sp2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		sp2.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img"))))
				.click();
//		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='phone'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebDriverWait subm2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		subm2.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//input[@class='btn green right btn-loader'])[1]"))))
				.click();
		Thread.sleep(20000);

	}

	@BeforeClass
	public void Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver130.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("use-fake-ui-for-media-stream");
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_login"))))
				.sendKeys("sunilcm@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys("Demo@1234");
		Thread.sleep(2000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// selecting Role clicking CDPAdmin role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[13]/div/div/div/div[2]")).click();
		Thread.sleep(3000);

		// deleting existing patient
		Thread.sleep(2000);
		WebDriverWait frstnm = new WebDriverWait(driver, Duration.ofSeconds(30));
		frstnm.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("frst_nm"))))
				.sendKeys("CucumDoctteleconsult");
		Thread.sleep(10000);
		// clicking on the patient name
		WebDriverWait ptnm = new WebDriverWait(driver, Duration.ofSeconds(30));
		ptnm.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search"))))
				.click();
		// driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(3000);
		// clicking on the view profile
		WebDriverWait profile = new WebDriverWait(driver, Duration.ofSeconds(30));
		profile.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='View Profile'])[1]"))))
				.click();
		// driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
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
	}

	@AfterClass
	public void afterClass() {
	}

}
