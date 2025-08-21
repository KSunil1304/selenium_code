package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
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

public class Dtteleconsultation {
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
				.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add Patient'])[2]/img")))).click();
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
		driver.findElement(By.id("lst_name")).sendKeys("Dietteleconsult");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// age
		driver.findElement(By.id("age")).sendKeys("44");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// phone
		driver.findElement(By.id("nmbr")).sendKeys("7718110012");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		// email
//		driver.findElement(By.id("email")).sendKeys("diettele@gmail.com");
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
		Thread.sleep(1000);
		Robot pd = new Robot();
		pd.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// aadharcardnumber
		driver.findElement(
				By.xpath("(//input[@id='patient_master_patient_questnr_value_details_attributes_2_result_value'])[1]"))
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
		driver.findElement(By.xpath("(//span[@class='selection'])[7]")).click();
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
	public void Bookingappointment() throws Exception {
		// clicking on the book dietician
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(2)>img"))))
				.click();
		// driver.findElement(By.cssSelector("div.bkng_services_prfl>div>a:nth-of-type(2)>img")).click();
		Thread.sleep(3000);
		// clicking on the book appointment
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("a.modal-trigger.waves-effect.btn.green.right:nth-of-type(1)"))))
				.click();
		// driver.findElement(By.cssSelector("a.modal-trigger.waves-effect.btn.green.right:nth-of-type(1)")).click();
		Thread.sleep(3000);
		// clicking on the video
		driver.findElement(By.xpath("(//div[@class='icon'])[2]")).click();
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
		// clicking on the reg.fees cbox
		WebElement cbox = driver.findElement(By.xpath("(//label[text()='50'])[1]"));
		cbox.click();
		Thread.sleep(1000);
		// clicking on the notify
		WebElement gmail = driver.findElement(By.xpath("(//label[text()='Email'])[1]"));
		gmail.click();
		Thread.sleep(1000);
		WebElement sms = driver.findElement(By.xpath("(//label[text()='SMS'])[1]"));
		sms.click();
		Thread.sleep(1000);// clicking on the submit
		driver.findElement(By.id("bookNowBtn")).click();
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
		driver.findElement(By.cssSelector("input#advance_field")).sendKeys("250");
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
//		Thread.sleep(1000);
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
//		WebElement sub = driver.findElement(By.xpath("/html/body/main/div/div[12]/div/div[2]/form/div[2]/input"));
//		sub.click();
//		Thread.sleep(20000);
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img")).click();
		Thread.sleep(1000);
		// selecting the dietitian role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[13]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
		// clicking on the week
		driver.findElement(By.xpath("(//a[text()='Week'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the consult button
		driver.findElement(By.xpath("(//a[text()='Consult'])[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void Teleconsultation() throws Exception {
		Actions telec = new Actions(driver);
		telec.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='SendLink'])[3]/img"))).build().perform();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='SendLink'])[3]/img"))))
				.click();
		Thread.sleep(3000);
		// clearing email id and number
		driver.findElement(By.xpath("(//input[@id='email'])[2]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='mobile'])[2]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(2000);
		// submit
		WebDriverWait sub = new WebDriverWait(driver, Duration.ofSeconds(30));
		sub.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("(//div[@id='modal_consult'])[1]/div/div[2]/form/div[2]/input[1]"))))
				.click();
		Thread.sleep(25000);

//		Alert med = driver.switchTo().alert();
//		med.accept();

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
		driver.findElement(By.xpath("(//label[text()='Physical exercise'])/following-sibling::input")).sendKeys("Yes");
		Thread.sleep(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// entering exercise timing
		driver.findElement(By.xpath("(//label[text()='ExerciseTiming'])/following-sibling::input"))
				.sendKeys("In the morning");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(1000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		Actions pview = new Actions(driver);
		pview.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Prescription View'])[1]"))).build()
				.perform();
		Thread.sleep(1000);
		pview.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Prescription View'])[1]"))).click()
				.build().perform();
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
		driver.findElement(By.xpath("(//label[text()='Present dietary habits:'])/following-sibling::input"))
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
		driver.findElement(By.xpath("(//label[text()='Lunch'])/following-sibling::input"))
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

		// icons
		// health-information
//		Actions hf = new Actions(driver);
//		hf.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Health Information'])[1]/img"))).build()
//				.perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@data-tooltip='Health Information'])[1]/img")).click();
//		Thread.sleep(2000);
//		// blood group
//		driver.findElement(By.xpath("(//a[@id='edit_patient'])[1]")).click();
//		Thread.sleep(1000);

		// clicking on the full screen
		Actions fscreen = new Actions(driver);
		fscreen.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='FullScreen View'])[1]"))).build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='FullScreen View'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the grid view
		Actions gview = new Actions(driver);
		gview.moveToElement(driver.findElement(By.xpath("(//img[@data-tooltip='Grid View'])[1]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='Grid View'])[1]")).click();
		Thread.sleep(2000);

		// clicking on the save as draft
		WebDriverWait sad = new WebDriverWait(driver, Duration.ofSeconds(30));
		sad.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Save as Draft'])[1]"))))
				.click();
		// driver.findElement(By.xpath("(//input[@value='Save as Draft'])[1]")).click();
		Thread.sleep(3000);

//		// clicking on the prescription
//		driver.findElement(By.xpath("(//button[text()='Add Prescription'])[1]")).click();
//		Thread.sleep(3000);

//		for (int i = 0; i <= 10; i++) {
//			JavascriptExecutor pd = (JavascriptExecutor) driver;
//			pd.executeScript("window.scrollBy(0,100)", "");
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
		Thread.sleep(3000);
		// edit prescription
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Edit Prescription'])[1]")).click();
		Thread.sleep(3000);

		for (int i = 0; i <= 10; i++) {
			JavascriptExecutor pd = (JavascriptExecutor) driver;
			pd.executeScript("window.scrollBy(0,-100)", "");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

		// entering physical exercsie
		driver.findElement(By.xpath("(//label[text()='Physical exercise'])/following-sibling::input")).click();
		Thread.sleep(1000);
		JavascriptExecutor pe = (JavascriptExecutor) driver;
		pe.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
		// entering exercise timing
		driver.findElement(By.xpath("(//label[text()='ExerciseTiming'])/following-sibling::input")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='ExerciseTiming'])/following-sibling::input"))
				.sendKeys("In the evening.");

		// clicking on the save button
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#saveBtn")))).click();
		Thread.sleep(3000);

		Alert leave = driver.switchTo().alert();
		leave.accept();
		Thread.sleep(1000);

//		for (int i = 0; i <= 10; i++) {
//			JavascriptExecutor pd = (JavascriptExecutor) driver;
//			pd.executeScript("window.scrollBy(0,100)", "");
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		}
		Robot pgdw = new Robot();
		pgdw.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(5000);

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
		pdf2.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/img"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/img")).click();
		Thread.sleep(3000);
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
		driver.findElement(By.id("emails")).sendKeys("Sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebDriverWait subm = new WebDriverWait(driver, Duration.ofSeconds(30));
		subm.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@name='commit'])[2]"))))
				.click();
		// driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
		Thread.sleep(20000);

		// close
		driver.findElement(By.xpath("(//a[text()='Close'])[1]")).click();
		Thread.sleep(5000);

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
		driver.findElement(By.id("emails")).sendKeys("Sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		// submit
		WebDriverWait wait0 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@name='commit'])[3]"))))
				.click();
		// driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
		Thread.sleep(20000);

	}

	@BeforeClass
	public void Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver125.exe");
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
		// selecting Role clicking on CDPAdmin role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[13]/div/div/div/div[2]")).click();
		Thread.sleep(3000);

		// deleting existing patient
		Thread.sleep(2000);
		WebDriverWait frstnm = new WebDriverWait(driver, Duration.ofSeconds(30));
		frstnm.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("frst_nm"))))
				.sendKeys("cucumdietteleconsult");
		// driver.findElement(By.id("frst_nm")).sendKeys("Cucumdietprescription");
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
//		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
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
