package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DoctorFavDischargeSummary {
	WebDriver driver = null;

	@Test(priority = 0)
	public void DocFavDS() throws Exception {
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
		favpsclick.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a#doctorDesSum")))).click();
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void CreatingDocFavDS() throws Exception {
		WebDriverWait addfavpsclick = new WebDriverWait(driver, Duration.ofSeconds(30));
		addfavpsclick
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("(//a[@id='fav_precription_creation'])[1]/i[1]"))))
				.click();
		Thread.sleep(3000);
		WebDriverWait save = new WebDriverWait(driver, Duration.ofSeconds(30));
		save.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#saveBtn")))).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#Favourite_Prescription_Name")).sendKeys("CucumFavDissum");
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#Favourite_Prescription_Name")).sendKeys("CucumFavDs");
		Thread.sleep(2000);

		// selecting discharge date
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[2]/div/div/input[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='28'])[1]")).click();
		Thread.sleep(1000);

		// Provisional Diagnosis at the time of Admission
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]"))
				.sendKeys("Test Provisional Diagnosis1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[1]"))
				.sendKeys("Test Provisional Diagnosis2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot backspace = new Robot();
		for (int i = 0; i <= 2; i++) {
			backspace.keyPress(KeyEvent.VK_BACK_SPACE);
		}
		Thread.sleep(1000);

		// final diagnosis
		driver.findElement(By.cssSelector("input#doctor_visit_comorbidity")).click();
		Thread.sleep(2000);
		Robot enter = new Robot();
		enter.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[1]")).sendKeys("2");
		Thread.sleep(1000);
		enter.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Weeks'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='input_note_cmrb'])[1]/i[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[comorbidity][][note]'])[1]"))
				.sendKeys("Fav DS Test Diagnosis notes");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='input_note_cmrb'])[1]/i[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#doctor_visit_comorbidity")).click();
		Thread.sleep(2000);
		for (int i = 0; i <= 1; i++) {
			enter.keyPress(KeyEvent.VK_RIGHT);
		}
		for (int i = 0; i <= 1; i++) {
			enter.keyPress(KeyEvent.VK_LEFT);
		}
		Thread.sleep(1000);
		enter.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[comorbidity][][dur]'])[2]")).sendKeys("2");
		Thread.sleep(1000);
		enter.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Days'])[1]")).click();
		Thread.sleep(1000);
		// remove one of final diagnosis
		driver.findElement(By.xpath("(//div[@class='input_close_cmrb'])[2]")).click();
		Thread.sleep(1000);

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// entering the patient history
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]"))
				.sendKeys("Test patient history1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]"))
				.sendKeys("Test patient history2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[2]")).sendKeys("Test patient history3");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);

		// selecting Reason for Admission/Symptoms & Clinical findings
		driver.findElement(By.xpath("(//input[@id='doctor_visit_complaints'])[1]")).click();
		Thread.sleep(1000);
		enter.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='doctor_visit[complaints][][dur]'])[1]")).sendKeys("3");
		Thread.sleep(1000);

		// entering Procedure at Hospital/Treatment given
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[3]"))
				.sendKeys("Test Procedure at Hospital/Treatment given1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[3]"))
				.sendKeys("Test Procedure at Hospital/Treatment given2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// entering Medication given during hospitalization
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[4]"))
				.sendKeys("Test Medication given during hospitalization" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[4]"))
				.sendKeys("Test Medication given during hospitalization" + Keys.ENTER);
		Thread.sleep(1000);
		// JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
		// entering Condition on Discharge
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[5]"))
				.sendKeys("Test Condition on Discharge1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[5]"))
				.sendKeys("Test Condition on Discharge2");
		Thread.sleep(1000);
		// JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
		// entering the vitals
		// height
		driver.findElement(By.xpath("(//label[text()='Height(Cms)'])[1]/following-sibling::input")).sendKeys("180");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Sp02
		driver.findElement(By.xpath("(//label[text()='SpO2(%)'])[1]/following-sibling::input")).sendKeys("55");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// BP
		driver.findElement(By.id("bp-s")).sendKeys("120");
		driver.findElement(By.id("bp-d")).sendKeys("90");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// entering Advice on Discharge
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[6]"))
				.sendKeys("Test Advice on Discharge1" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//textarea[@id='healthHistoryTxt'])[6]"))
				.sendKeys("Test Advice on Discharge2" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(1000);
//		Robot backspace = new Robot();
		for (int i = 0; i <= 2; i++) {
			backspace.keyPress(KeyEvent.VK_BACK_SPACE);
		}
		Thread.sleep(3000);

		// selecting the dischare medication
		driver.findElement(By.xpath(
				"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[24]/div/div[2]/div/div[1]/div/div/div[2]/div/input[1]"))
				.click();
		Thread.sleep(2000);
		enter.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='mrng numeric autocmplt'])[1]")).click();
		Thread.sleep(1000);
		Robot down = new Robot();
		for (int i = 0; i <= 1; i++) {
			down.keyPress(KeyEvent.VK_DOWN);
		}
		enter.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='frequency'])[1]")).sendKeys("D" + Keys.DOWN + Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Duration'])[1]/following-sibling::input[1]")).sendKeys("5");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='More'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='medication_notes'])[1]")).sendKeys("Test Fav DS medicine notes1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@data-tooltip='Less'])[1]")).click();
		Thread.sleep(1000);
		// clicking on the add button
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/main/div/div[2]/div/div[3]/div/div/div/div/form/div[24]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/input[1]"))
				.click();
		Thread.sleep(2000);
		enter.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='right remove_fields dynamic'])[2]/i[1]")).click();
		Thread.sleep(1000);

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
