package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DoctorFavPrescription {
	WebDriver driver = null;

	@Test(priority = 0)
	public void FavPs() throws Exception {
		WebDriverWait profileclick = new WebDriverWait(driver, Duration.ofSeconds(30));
		profileclick.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img[1]")))).click();
		Thread.sleep(2000);
		WebDriverWait myaccountclick = new WebDriverWait(driver, Duration.ofSeconds(30));
		myaccountclick
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//i[@class='fa fa-cog'])[1]"))))
				.click();
		Thread.sleep(3000);
		WebDriverWait configclick = new WebDriverWait(driver, Duration.ofSeconds(30));
		configclick.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Configurations'])[1]"))))
				.click();
		Thread.sleep(2000);
		WebDriverWait favpsclick = new WebDriverWait(driver, Duration.ofSeconds(30));
		favpsclick.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a#doctorFavPrescBtn"))))
				.click();
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void Createanewfavprescription() throws Exception {
		WebDriverWait addfavpsclick = new WebDriverWait(driver, Duration.ofSeconds(30));
		addfavpsclick
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("(//a[@id='fav_precription_creation'])[1]/i[1]"))))
				.click();
		Thread.sleep(3000);
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#saveBtn")))).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#Favourite_Prescription_Name")).sendKeys("CucumFavPrescription");
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#Favourite_Prescription_Name")).sendKeys("CucumFavPrescription");
		Thread.sleep(2000);
		// Symptoms
		driver.findElement(By.cssSelector("input#doctor_visit_symptoms")).click();
		Thread.sleep(1000);
		Robot enter1 = new Robot();
		enter1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[1]")).sendKeys("2");
		Thread.sleep(1000);
		enter1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Weeks'])")).click();
		Thread.sleep(2000);
		for (int i = 0; i <= 3; i++) {
			Robot diag = new Robot();
			diag.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}

		for (int i = 0; i <= 3; i++) {
			Robot diaRobot = new Robot();
			diaRobot.keyPress(KeyEvent.VK_LEFT);
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[2]")).sendKeys("3");
		Thread.sleep(1000);
		enter1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Days'])")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#doctor_visit_symptoms")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#doctor_visit_symptoms")).sendKeys("Cucumfavpssymptoms");
		Thread.sleep(1000);
		enter1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[symptoms][][dur]'])[3]")).sendKeys("3");
		Thread.sleep(1000);
		enter1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Years'])")).click();
		Thread.sleep(2000);
		// remove the second one
		driver.findElement(By.xpath("(//div[@id='input_close'])[2]/i[1]")).click();
		Thread.sleep(2000);

		// chief-complaints
		driver.findElement(By.cssSelector("input#doctor_visit_complaints")).click();
		Thread.sleep(1000);
		Robot cc = new Robot();
		cc.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[1]")).sendKeys("5");
		Thread.sleep(1000);
		cc.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Weeks'])")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#doctor_visit_complaints")).click();
		Thread.sleep(1000);
		Robot cc1 = new Robot();
		cc1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[2]")).sendKeys("1");
		Thread.sleep(1000);
		cc1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Month'])")).click();
		Thread.sleep(1000);
		// remove the second one
		driver.findElement(By.xpath("(//div[@id='input_close_cmpl'])[2]/i[1]")).click();
		Thread.sleep(2000);

		// patient history
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]"))
				.sendKeys("demo clinicalexamination1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]"))
				.sendKeys("demo clinicalexamination2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]"))
				.sendKeys("demo clinicalexamination3" + Keys.ENTER);
		Thread.sleep(1000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// diagnosis
		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).click();
		Thread.sleep(1000);
		Robot enterrr = new Robot();
		enterrr.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[5]/div[2]/div[1]/div/div[4]/span/span[1]/span/span[1]"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Since Birth'])[1]")).click();
		Thread.sleep(1000);
		// notes-click
		driver.findElement(By.xpath("(//div[@class='input_note_diag'])[1]/img[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='diagnosis_notes'])[1]"))
				.sendKeys("Having BP since from birth notes");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='input_note_diag'])[1]/img[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#doctor_visit_diagnosis")).click();
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			Robot diag1 = new Robot();
			diag1.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
		}

		for (int i = 0; i <= 2; i++) {
			Robot diaRobot = new Robot();
			diaRobot.keyPress(KeyEvent.VK_LEFT);
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[diagnosis][][dur]'])[2]")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot doag = new Robot();
		doag.keyPress(KeyEvent.VK_TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		doag.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		doag.keyPress(KeyEvent.VK_ENTER);
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
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(1000);
		jse1.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		// comorbdity
		driver.findElement(By.cssSelector("input#doctor_visit_comorbidity")).click();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[1]")).sendKeys("2");
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Months'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#doctor_visit_comorbidity")).sendKeys("Cucumcomorbidity");
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[2]")).sendKeys("2");
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Days'])[1]")).click();
		Thread.sleep(1000);
		// remove first comorbidity
		driver.findElement(By.xpath("(//div[@class='input_close_cmrb'])[1]/i[1]")).click();
		Thread.sleep(1000);
		jse1.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		// vitals
		driver.findElement(By.xpath("(//label[text()='Temp (F)'])[1]/following-sibling::input")).sendKeys("102");
		driver.findElement(By.cssSelector("input#bp-s")).sendKeys("120");
		driver.findElement(By.cssSelector("input#bp-d")).sendKeys("80");
		driver.findElement(By.xpath("(//label[text()='SpO2(%)'])[1]/following-sibling::input")).sendKeys("55");
		driver.findElement(By.xpath("(//label[text()='Height (Cms)'])/following-sibling::input")).sendKeys("180");
		driver.findElement(By.xpath("(//label[text()='Weight (Kgs)'])/following-sibling::input")).sendKeys("73");
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		jse1.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		// pain-scale
		driver.findElement(By.xpath("(//div[@class='icon'])[1]/img[1]")).click();
		Thread.sleep(1000);
		jse1.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		// medicine
		driver.findElement(By.xpath("(//input[@class='typeahead brand-name medBrandName_inputbox tt-input '])[1]"))
				.click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='mrng numeric autocmplt'])[1]")).sendKeys("0");
		driver.findElement(By.xpath("(//input[@class='aftn numeric autocmplt'])[1]")).sendKeys("1");
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Route'])[1]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Oral'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='After Food'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Frequency'])[1]/following-sibling::input[1]")).sendKeys("D");
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Duration'])[1]/following-sibling::input[1]")).sendKeys("2");
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Weeks'])[1]")).click();
		Thread.sleep(1000);
		// notes-click
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='medication_notes'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@class='medication_notes'])[1]")).sendKeys("test medicine notes");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='Less'])[1]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(2000);
		// close
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(2000);
		jse1.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		// next visit date
		driver.findElement(By.cssSelector("input#doctor_visit_nxt_vst_dur")).sendKeys("25");
		Thread.sleep(1000);

		// next visit mode
		WebElement teleconsult = driver.findElement(By.xpath("(//label[text()='Tele-consultation'])[1]"));
		teleconsult.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (int i = 0; i <= 2; i++) {
			WebElement person = driver.findElement(By.xpath("(//label[text()='In-person'])[1]"));
			person.click();
		}
		Thread.sleep(1000);

		// recommended programs
		driver.findElement(By.cssSelector("input#packages_input")).click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#packages_input")).sendKeys("Cucum");
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#packages_input")).sendKeys("Cucumberprogram");
		Thread.sleep(2000);
		// remove second program
		driver.findElement(By.xpath("(//i[@class='material-icons close package_chip_close'])[2]")).click();
		Thread.sleep(2000);
		jse1.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		// comments
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys("test comments" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys("test comments2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys("test comments3");

	}

	@BeforeClass
	public void Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver132.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_login")).sendKeys("doctor1@nh.com");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		Thread.sleep(1000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
	}

	@AfterClass
	public void afterClass() {
	}

}
