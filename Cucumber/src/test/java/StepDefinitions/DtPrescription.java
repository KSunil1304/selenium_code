package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

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

public class DtPrescription {
	WebDriver driver = null;

	@Test(priority = 0)
	public void RegisteringAAPatient() throws Exception {
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
		driver.findElement(By.id("lst_name")).sendKeys("Dietprescription");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		driver.findElement(By.id("age")).sendKeys("44");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// phone
		driver.findElement(By.id("nmbr")).sendKeys("7718110015");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// email
//		driver.findElement(By.id("email")).sendKeys("dietpshh@gmail.com");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		Thread.sleep(2000);
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
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
		driver.findElement(By.xpath("(//li[text()='NanoHealth Program1'])[1]")).click();
		Thread.sleep(1000);
//		Robot robot1 = new Robot();
//		robot1.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
//		Robot rob = new Robot();
//		rob.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("update_submit")))).click();
		Thread.sleep(5000);
//		// edit profile
//		driver.findElement(By.xpath("(//a[@data-tooltip='Edit Profile'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//li[text()='NanoHealth-HYD'])[1]")).click();
//		Thread.sleep(3000);
//		Robot robot11 = new Robot();
//		robot11.keyPress(KeyEvent.VK_PAGE_DOWN);
//		Thread.sleep(3000);
//		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
//		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#update_submit"))))
//				.click();
//		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void BookingDietitianappointment() throws Exception {
		// clicking on the book dietician
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("(//a[@data-tooltip='Book Dietitian Appointment'])[1]/img[1]")))).click();
		// driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(2)>img")).click();
		Thread.sleep(3000);
		// clicking on the book appointment
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Book Appointment'])[2]"))))
				.click();
		// driver.findElement(By.cssSelector("a.modal-trigger.waves-effect.btn.green.right:nth-of-type(1)")).click();
		Thread.sleep(3000);
		// clicking on the clinic
		driver.findElement(By.xpath("(//div[@class='icon'])[1]")).click();
		Thread.sleep(2000);
		// selecting the location
		driver.findElement(By.xpath("(//div[@class='address-container'])[2]")).click();
		Thread.sleep(2000);
		// clicking on the date and time
		driver.findElement(
				By.xpath("/html/body/main/div/div[3]/div/div/div[2]/form/ul/li[3]/div[2]/div[2]/div[1]/div[2]"))
				.click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

		// clicking on the slot
		if (driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[2]/div[2]/div/div/span[1]"))
				.isDisplayed()) {
			// afternoon slot
			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[2]/div[2]/div/div/span[1]")).click();
			Thread.sleep(1000);
		} else if (driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[3]/div[2]/div/div/span[1]"))
				.isDisplayed()) {
			// evening slot
			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[3]/div[2]/div/div/span[1]")).click();
			Thread.sleep(1000);
		} else {
			// morning slot
			driver.findElement(By.xpath("(//div[@class='slots-container'])[1]/div[1]/div[2]/div/div/span[1]")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		// clicking on the notify
		WebElement gmail = driver.findElement(By.xpath("(//label[text()='Email'])[1]"));
		gmail.click();
		Thread.sleep(1000);
		WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
		sms.click();
		Thread.sleep(1000);
		// clicking on the submit
		driver.findElement(By.id("bookNowBtn")).click();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(3000);
		// applying promocode
		driver.findElement(By.cssSelector("input#promo_code")).sendKeys("Cucumber code");
		Thread.sleep(2000);
		// clicking on the apply
		driver.findElement(By.cssSelector("span#applyCouponModal")).click();
		Thread.sleep(2000);
		// removing the coupon code
		driver.findElement(By.xpath("(//i[@class='material-icons close sale_discount_det_close'])[1]")).click();
		Thread.sleep(2000);

		// applying promocode
		driver.findElement(By.cssSelector("input#promo_code")).sendKeys("Cucumber code");
		Thread.sleep(2000);
		// clicking on the apply
		driver.findElement(By.cssSelector("span#applyCouponModal")).click();
		Thread.sleep(2000);

		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		WebElement other = driver.findElement(By.xpath("//label[text()='Other']"));
		other.click();
		Thread.sleep(2000);
		// phonepe
		driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[4]/span/img")).click();
		Thread.sleep(1000);
		// transaction id
		driver.findElement(By.cssSelector("input#other_txn_id")).sendKeys("123456");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// entering the amount
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("474"); // 111
		Thread.sleep(2000);
		// clicking on the submit
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait4.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
		// driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("input#negotiableYes")).click();
		Thread.sleep(2000);

		// clicking on the comment
		driver.findElement(By.cssSelector("i#paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.cssSelector("textarea#payment_cmnt")).sendKeys("test receipt comment");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// clicking on the submit
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#bookNowBtn")))).click();
		// driver.findElement(By.cssSelector("button#bookNowBtn")).click();
		Thread.sleep(2000);

		// printing
		driver.findElement(By.cssSelector("a.tooltipped.service_wise_pdf>img")).click();
		Thread.sleep(2000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
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
//		// clicking on the share invoice
//		driver.findElement(By.cssSelector("a.btn.green.right.btn-loader2.service_wise_pdf")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.id("emails")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("phone")).clear();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
//		Thread.sleep(1000);
//		// clicking on the submit
//		WebElement sub = driver.findElement(By.xpath("/html/body/main/div/div[13]/div/div[2]/form/div[2]/input"));
//		sub.click();
//		Thread.sleep(20000);
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img")).click();
		Thread.sleep(1000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting the dietitian role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[5]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
		// clicking on the list view
		driver.findElement(By.xpath("(//button[text()='List View'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the week
		driver.findElement(By.xpath("(//a[text()='Week'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the consult button
		driver.findElement(By.xpath("(//a[text()='Consult'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the diet assessement form
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[21]/div/div[3]/div[2]/div/div[2]/a")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void Dietassessmentform() throws Exception {
		// entering patient history
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]")).sendKeys("test history");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]")).sendKeys("test history2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]")).sendKeys("test history2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// entering food allergies
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys("no food allergies");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// entering physical exercsie
		driver.findElement(By.xpath("(//label[text()='Physical exercise'])[1]/following-sibling::input[1]"))
				.sendKeys("Yes");
		Thread.sleep(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// entering exercise timing
		driver.findElement(By.xpath("(//label[text()='ExerciseTiming'])[1]/following-sibling::input"))
				.sendKeys("In the morning");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(1000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// selecting medication radio btn options
		for (int i = 0; i <= 2; i++) {
			WebElement yes = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
			yes.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// selecting presently using oil radio btn options
		for (int i = 0; i <= 2; i++) {
			WebElement yes = driver.findElement(By.xpath("(//label[text()='Refined oil'])[1]"));
			yes.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse3 = (JavascriptExecutor) driver;
		jse3.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// selecting name the oil radio btn options
		for (int i = 0; i <= 2; i++) {
			WebElement yes = driver.findElement(By.xpath("(//label[text()='Sunflower oil'])[1]"));
			yes.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse4 = (JavascriptExecutor) driver;
		jse4.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// selecting quantity of the oil
		for (int i = 0; i <= 2; i++) {
			WebElement yes = driver.findElement(By.xpath("(//label[text()='3-4 spoons per day'])[1]"));
			yes.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse5 = (JavascriptExecutor) driver;
		jse5.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// selecting Deep fried food how many times in a month
		for (int i = 0; i <= 2; i++) {
			WebElement yes = driver.findElement(By.xpath("(//label[text()='Once'])[1]"));
			yes.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		jse6.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// selecting Any super foods
		for (int i = 0; i <= 2; i++) {
			WebElement yes = driver.findElement(By.xpath("(//label[text()=' Badam '])[1]"));
			yes.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse7 = (JavascriptExecutor) driver;
		jse7.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// selecting Salads and soup
		for (int i = 0; i <= 3; i++) {
			WebElement yes = driver.findElement(By.xpath("(//label[text()='1 serving/day'])[1]"));
			yes.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse8 = (JavascriptExecutor) driver;
		jse8.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// entering Present dietary habits
		driver.findElement(By.xpath("(//label[text()='Present dietary habits:'])[1]/following-sibling::input"))
				.sendKeys("Fruits, vegetables, whole grains");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse9 = (JavascriptExecutor) driver;
		jse9.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// entering Early Morning
		driver.findElement(By.xpath("(//label[text()='Early Morning'])/following-sibling::input")).sendKeys("Apple");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse10 = (JavascriptExecutor) driver;
		jse10.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// entering Breakfast
		driver.findElement(By.xpath("(//label[text()='Breakfast'])/following-sibling::input")).sendKeys("Eggs");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse11 = (JavascriptExecutor) driver;
		jse11.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// entering Mid-Morning
		driver.findElement(By.xpath("(//label[text()='Mid-morning'])/following-sibling::input")).sendKeys("Test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse12 = (JavascriptExecutor) driver;
		jse12.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// entering Lunch
		driver.findElement(By.xpath("(//label[text()= 'Lunch'])/following-sibling::input"))
				.sendKeys("Vegetables, fruits");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse13 = (JavascriptExecutor) driver;
		jse13.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// entering Snack time
		driver.findElement(By.xpath("(//label[text()='Snack time'])/following-sibling::input")).sendKeys("Popcorn");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse14 = (JavascriptExecutor) driver;
		jse14.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// entering Dinner
		driver.findElement(By.xpath("(//label[text()='Dinner'])/following-sibling::input")).sendKeys("Chicken");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse15 = (JavascriptExecutor) driver;
		jse15.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// entering Bed time
		driver.findElement(By.xpath("(//label[text()='Bed time'])/following-sibling::input")).sendKeys("Almonds");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		JavascriptExecutor jse16 = (JavascriptExecutor) driver;
		jse16.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// entering Weekend menu
		driver.findElement(By.xpath("(//label[text()='Weekend menu'])/following-sibling::input"))
				.sendKeys("Green tea, grilled chicken for lunch, salmon for dinner");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(1000);
		JavascriptExecutor jse17 = (JavascriptExecutor) driver;
		jse17.executeScript("window.scrollBy(0,100)", "");
		// Thread.sleep(1000);
		// entering Changes to be done
		driver.findElement(By.xpath("(//label[text()='Changes to be done'])/following-sibling::input"))
				.sendKeys("Increase vegetable intake, stay hydrated");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		// clicking on the save as draft
		WebDriverWait sad = new WebDriverWait(driver, Duration.ofSeconds(30));
		sad.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save as Draft'])[1]"))))
				.click();
		// driver.findElement(By.xpath("(//input[@value='Save as Draft'])[1]")).click();
		Thread.sleep(3000);

		// clicking on the prescription
		driver.findElement(By.xpath("(//button[text()='Add Prescription'])[1]")).click();
		Thread.sleep(3000);

		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor pd = (JavascriptExecutor) driver;
			pd.executeScript("window.scrollBy(0,100)", "");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(2000);

		// clicking on the save button
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#saveBtn")))).click();
		Thread.sleep(3000);

		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor pd = (JavascriptExecutor) driver;
			pd.executeScript("window.scrollBy(0,100)", "");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(2000);

		// downloading pdf without header & footer
		Actions pdf1 = new Actions(driver);
		pdf1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")).click();
		Thread.sleep(3000);
		// downloading pdf with header & footer
		String parentwind1 = driver.getWindowHandle();
		Actions pdf2 = new Actions(driver);
		pdf2.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[1]/img")).click();
		Thread.sleep(2000);
		Set<String> childwind1 = driver.getWindowHandles();
		for (String handle : childwind1) {
			if (!childwind1.equals(parentwind1)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind1);
			}
		}
		Thread.sleep(2000);
		// share prescription
		Actions sp = new Actions(driver);
		sp.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Submit'])[2]"))))
				.click();
		// driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
		Thread.sleep(20000);

		// edit prescription
		Actions editp = new Actions(driver);
		editp.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Edit Prescription'])[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Edit Prescription'])[1]")).click();
		Thread.sleep(3000);

		// entering physical exercsie
		driver.findElement(By.xpath("(//label[text()='Physical exercise'])/following-sibling::input")).click();
		Thread.sleep(1000);

		JavascriptExecutor pe = (JavascriptExecutor) driver;
		pe.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// entering exercise timing
		driver.findElement(By.xpath("(//label[text()='ExerciseTiming'])[1]/following-sibling::input")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='ExerciseTiming'])[1]/following-sibling::input"))
				.sendKeys("In the evening.");

		Thread.sleep(2000);
		// clicking on the save button
		WebDriverWait save1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		save1.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#saveBtn")))).click();
		Thread.sleep(3000);

		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor pd = (JavascriptExecutor) driver;
			pd.executeScript("window.scrollBy(0,100)", "");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		Thread.sleep(2000);

		// downloading pdf without header & footer
		Actions pdf3 = new Actions(driver);
		pdf3.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[1]/img")).click();
		Thread.sleep(3000);
		// downloading pdf with header & footer
		String parentwind2 = driver.getWindowHandle();
		Actions pdf4 = new Actions(driver);
		pdf4.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/img"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/img")).click();
		Thread.sleep(2000);
		Set<String> childwind2 = driver.getWindowHandles();
		for (String handle : childwind2) {
			if (!childwind2.equals(parentwind2)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind2);
			}
		}
		Thread.sleep(2000);
		// share prescription
		Actions sp1 = new Actions(driver);
		sp1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[1]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Submit'])[2]"))))
				.click();
		// driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
		Thread.sleep(20000);

//		// clicking on the patients name
//		WebDriverWait patp = new WebDriverWait(driver, Duration.ofSeconds(30));
//		patp.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("(//a[text()='Cucum Dietprescription'])[1]")))).click();
//		// driver.findElement(By.xpath("(//a[text()='Cucum
//		// Dietprescription'])[1]")).click();
//		Thread.sleep(3000);

		// clicking on the close button
		driver.findElement(By.xpath("(//a[text()='Close'])[1]")).click();
		Thread.sleep(3000);

		Robot pagedown = new Robot();
		pagedown.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// clicking on the history button
		driver.findElement(By.cssSelector("a#patientHistoryBtn")).click();
		Thread.sleep(2000);
		// clicking on the dietitian visit
		driver.findElement(By.xpath("(//span[text()='Dietitian Visit'])[1]")).click();
		Thread.sleep(2000);

		// downloading pdf without header & footer
		Actions hf1 = new Actions(driver);
		hf1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[2]")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer'])[2]")).click();
		Thread.sleep(2000);

		// downloading pdf with header & footer
		String parentwind3 = driver.getWindowHandle();
		Actions hf2 = new Actions(driver);
		hf2.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[2]/img")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer'])[2]/img")).click();
		Thread.sleep(2000);
		Set<String> childwind3 = driver.getWindowHandles();
		for (String handle : childwind3) {
			if (!childwind3.equals(parentwind3)) {
				Thread.sleep(2000);
				driver.switchTo().window(parentwind3);
			}
		}
		Thread.sleep(2000);
		// share prescription
		Actions sp5 = new Actions(driver);
		sp5.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[2]/img"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Share Prescription'])[2]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebDriverWait wait0 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Submit'])[2]"))))
				.click();
		// driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
		Thread.sleep(20000);

	}

	@BeforeClass
	public void Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver132.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_login")))).sendKeys("Sunilk@nh.com");
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		Thread.sleep(2000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);

		// selecting Role clicking on cdpadmin Role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[8]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
		// deleting existing patient
		Thread.sleep(2000);
		WebDriverWait frstnm = new WebDriverWait(driver, Duration.ofSeconds(30));
		frstnm.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("frst_nm"))))
				.sendKeys("Cucumdietprescription");
		// driver.findElement(By.id("frst_nm")).sendKeys("Cucumdietprescription");
		Thread.sleep(10000);
		// clicking on the patient name
		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
		Thread.sleep(5000);
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
		driver.findElement(By.xpath("(//a[@class='brand-logo'])/img[1]")).click();
		Thread.sleep(2000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting clinic manager
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[3]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
	}

	@AfterClass
	public void afterClass() {
	}

}
