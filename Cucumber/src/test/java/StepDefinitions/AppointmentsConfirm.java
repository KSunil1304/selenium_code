package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppointmentsConfirm {
	WebDriver driver = null;

	@Test(priority = 0)
	public void DoctorAptConfirm() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Doctor'])[1]")).click();
		Thread.sleep(3000);
		// filter click
		driver.findElement(By.xpath("(//div[@class='filter_ico'])[1]")).click();
		Thread.sleep(2000);
		// searching with the patient name
		driver.findElement(By.cssSelector("input#q_patient_master_frst_nm_or_patient_master_lst_nm_cont"))
				.sendKeys("Cucum");
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the apt id
		driver.findElement(By.xpath("(//tr[@class='consultRow odd'])[1]/td[2]/a[1]")).click();
		Thread.sleep(3000);
		// click on reschedule button
		driver.findElement(By.xpath("(//a[text()='Reschedule'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the apt date
		// driver.findElement(By.cssSelector("input#slot-date")).click();
		Thread.sleep(2000);
		try {
			// driver.get("YOUR_CALENDAR_URL"); // Replace with your calendar URL
			driver.findElement(By.cssSelector("input#slot-date")).click();
			Thread.sleep(2000);
			LocalDate today = LocalDate.now();
			YearMonth currentMonth = YearMonth.of(today.getYear(), today.getMonth());
			boolean mondayFound = false;

			// Find all date elements in the calendar for the current month
			List<WebElement> dateElements = driver.findElements(By.xpath("(//button[@class='datepicker-day-button'])"));

			for (WebElement dateElement : dateElements) {
				String dateText = dateElement.getText().trim();
				try {
					int day = Integer.parseInt(dateText);
					LocalDate date = LocalDate.of(today.getYear(), today.getMonth(), day);

					if (date.getDayOfWeek().getValue() == 1) { // 1 = Monday
						System.out.println("Clicking on Monday: " + date);
						dateElement.click();
						mondayFound = true;
						break; // Stop after clicking the first Monday
					}
				} catch (Exception e) {
					System.out.println("Skipping invalid date: " + dateText);
				}
			}

			// If no Monday found in the current month, navigate to next month and select
			if (!mondayFound) {
				System.out.println("No Mondays in this month. Navigating to next month...");
				WebElement nextMonthButton = driver.findElement(By.xpath("(//button[@class='month-next'])[1]")); // Replace
																													// with
																													// actual
																													// next-month
				// selector
				nextMonthButton.click();

				// Wait and fetch next month's dates
				Thread.sleep(2000); // Adjust wait time as needed
				List<WebElement> nextMonthDates = driver
						.findElements(By.xpath("(//button[@class='datepicker-day-button'])"));

				for (WebElement dateElement : nextMonthDates) {
					String dateText = dateElement.getText().trim();
					try {
						int day = Integer.parseInt(dateText);
						LocalDate date = LocalDate.of(today.getYear(), today.getMonth().plus(1), day);

						if (date.getDayOfWeek().getValue() == 1) { // 1 = Monday
							System.out.println("Clicking on Monday: " + date);
							dateElement.click();
							break; // Stop after clicking the first Monday
						}
					} catch (Exception e) {
						System.out.println("Skipping invalid date: " + dateText);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// entering the reschedule reason
		driver.findElement(By.xpath("(//input[@id='comments'])[1]")).sendKeys("Test rescheduling reason");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		// afternoon
		if (driver.findElement(By.xpath("(//div[@class='row session'])[2]/div[2]/div[1]/div[1]/span[1]"))
				.isDisplayed()) {
			driver.findElement(By.xpath("(//div[@class='row session'])[2]/div[2]/div[1]/div[1]/span[1]")).click();

		} else if (driver.findElement(By.xpath("(//div[@class='row session'])[3]/div[2]/div[1]/div[1]/span[1]"))
				.isDisplayed()) {
			// evening
			driver.findElement(By.xpath("(//div[@class='row session'])[3]/div[2]/div[1]/div[1]/span[1]")).click();
		} else if (driver.findElement(By.xpath("(//div[@class='row session'])[3]/div[2]/div[1]/div[1]/span[1]"))
				.isDisplayed()) {
			// morning
			driver.findElement(By.xpath("(//div[@class='row session'])[3]/div[2]/div[1]/div[1]/span[1]")).click();
		} else {
			driver.findElement(By.xpath("(//div[@class='row session'])[1]/div[2]/div[1]/div[1]/span[1]")).click();
		}

		// clicking on the reschedule button
		driver.findElement(By.xpath("(//input[@id='rescheduleButton'])[1]")).click();
		Thread.sleep(5000);
		// filter click
		driver.findElement(By.xpath("(//div[@class='filter_ico'])[1]")).click();
		Thread.sleep(2000);
		// searching with the patient name
		driver.findElement(By.cssSelector("input#q_patient_master_frst_nm_or_patient_master_lst_nm_cont"))
				.sendKeys("Cucum");
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the apt id
		driver.findElement(By.xpath("(//tr[@class='consultRow odd'])[1]/td[2]/a[1]")).click();
		Thread.sleep(3000);
		// clicking on the confirm button
		driver.findElement(By.xpath("(//a[text()='Confirm'])[1]")).click();
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//div[@id='confirmModal'])[1]/div[1]/div[2]/div[1]/a[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		// clicking on the confirmed status
		driver.findElement(By.xpath("(//a[@id='status_link_Confirmed'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the appointment id
		WebDriverWait aptid = new WebDriverWait(driver, Duration.ofSeconds(30));
		aptid.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//tr[@class='consultRow odd'])[1]/td[2]/a[1]")))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// view
		driver.findElement(By.xpath("(//a[text()='View'])[1]")).click();
		Thread.sleep(2000);
		// print pdf without header & footer
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Without Header & Footer (blank)'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// print pdf with header & footer
		driver.findElement(By.xpath("(//a[@data-tooltip='Print With Header & Footer (blank)'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='modalApmntShow'])[1]/div[1]/div/span[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void DietitianAptConfirm() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Dietitian'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the first confirm button
		driver.findElement(By.xpath("(//tr[@class='consultRow odd'])[1]/td[7]/a[1]")).click();
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//div[@id='confirmModal'])[1]/div[1]/div[2]/div[1]/a[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		// clicking on the confirmed status
		driver.findElement(By.xpath("(//a[@id='status_link_Confirmed'])[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void LabAptConfirm() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Diagnostic'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the first confirm button
		driver.findElement(By.xpath("(//tbody[@class='lab_row'])[1]/tr[1]/td[8]/a[1]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		// clicking on the confirmed status
		driver.findElement(By.xpath("(//a[@id='status_link_Confirmed'])[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void IPProceduresAptConfirm() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='IP Procedures'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the first confirm button
		driver.findElement(By.xpath("(//tr[@class='consultRow odd'])[1]/td[7]/a[1]")).click();
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//div[@id='confirmModal'])[1]/div[1]/div[2]/div[1]/a[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		// clicking on the confirmed status
		driver.findElement(By.xpath("(//a[@id='status_link_Confirmed'])[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void MinorProAptConfirm() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Minor Procedures'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the first appointment id
		driver.findElement(By.xpath("(//tbody[@id='header_row'])[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		// clicking on the confirm button
		driver.findElement(By.xpath("(//a[text()='Confirm'])[1]")).click();
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//div[@id='confirmModal'])[1]/div[1]/div[2]/div[1]/a[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		// clicking on the confirmed status
		driver.findElement(By.xpath("(//a[@id='status_link_Confirmed'])[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void HcsAptConfirm() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Home Care Services'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the first appointment id
		driver.findElement(By.xpath("(//tbody[@id='header_row'])[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(5000);
		// clicking on the confirm button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver
				.findElement(By.xpath("/html/body/main/div[2]/div/div[2]/div[3]/div/div[2]/div/div/a[2]")); // Replace
																											// with your
																											// element's
																											// locator
		js.executeScript("arguments[0].click();", element);
		// driver.findElement(By.xpath("/html/body/main/div[2]/div/div[2]/div[3]/div/div[2]/div/div/a[2]")).click();
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//div[@id='confirmModal'])[1]/div[1]/div[2]/div[1]/a[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		// clicking on the confirmed status
		driver.findElement(By.xpath("(//a[@id='status_link_Confirmed'])[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 6)
	public void AmbulanceAptConfirm() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Ambulance'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the first appointment id
		driver.findElement(By.xpath("(//tbody[@id='header_row'])[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		// clicking on the confirm button
		driver.findElement(By.xpath("(//a[text()='Confirm'])[1]")).click();
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//div[@id='confirmModal'])[1]/div[1]/div[2]/div[1]/a[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		// clicking on the confirmed status
		driver.findElement(By.xpath("(//a[@id='status_link_Confirmed'])[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 7)
	public void VaccineAptConfirm() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Vaccines'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the first appointment id
		driver.findElement(By.xpath("(//tbody[@id='header_row'])[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		// clicking on the confirm button
		driver.findElement(By.xpath("(//a[text()='Confirm'])[1]")).click();
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//div[@id='confirmModal'])[1]/div[1]/div[2]/div[1]/a[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		// clicking on the confirmed status
		driver.findElement(By.xpath("(//a[@id='status_link_Confirmed'])[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 8)
	public void AssignedProgramAptConfirm() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).click().build().perform();
		Thread.sleep(3000);
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//a[text()='Procedure Rooms'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Procedure Rooms'])[1]")).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//a[text()='Procedure Rooms'])[1]")).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//a[text()='Procedure Rooms'])[1]")).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait program = new WebDriverWait(driver, Duration.ofSeconds(30));
		program.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Assigned Program'])[1]"))))
				.click();
		// driver.findElement(By.xpath("")).click();
		Thread.sleep(3000);
		// clicking on the confirm button
		driver.findElement(By.xpath("(//a[text()='Confirm'])[1]")).click();
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//div[@id='confirmModal'])[1]/div[1]/div[2]/div[1]/a[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		// clicking on the confirmed status
		driver.findElement(By.xpath("(//ul[@class='tabs card'])[1]/li[2]/a[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 9)
	public void DeviceAptConfirm() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).click().build().perform();
		Thread.sleep(3000);
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//a[text()='Procedure Rooms'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Procedure Rooms'])[1]")).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//a[text()='Procedure Rooms'])[1]")).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//a[text()='Procedure Rooms'])[1]")).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait program = new WebDriverWait(driver, Duration.ofSeconds(30));
		program.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Devices'])[1]"))))
				.click();
		Thread.sleep(3000);
		// clicking on the first appointment id
		driver.findElement(By.xpath("(//tbody[@id='header_row'])[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		// clicking on the confirm button
		driver.findElement(By.xpath("(//a[text()='Confirm'])[1]")).click();
		Thread.sleep(2000);
		// yes
		driver.findElement(By.xpath("(//div[@id='confirmModal'])[1]/div[1]/div[2]/div[1]/a[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		// clicking on the confirmed status
		driver.findElement(By.xpath("(//a[@id='status_link_Confirmed'])[1]")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 10)
	public void TechinicianAptConfirm() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//a[@id='admin-apmnts'])[1]"))).click().build().perform();
		Thread.sleep(3000);
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//a[text()='Procedure Rooms'])[1]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Procedure Rooms'])[1]")).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//a[text()='Procedure Rooms'])[1]")).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//a[text()='Procedure Rooms'])[1]")).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait program = new WebDriverWait(driver, Duration.ofSeconds(30));
		program.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Technician'])[1]"))))
				.click();
		Thread.sleep(3000);
		// clicking on the confirm button
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[7]/a[1]")).click();
		Thread.sleep(3000);
		// clicking on the yes button
		// yes
		driver.findElement(By.xpath("(//div[@id='confirmModal'])[1]/div[1]/div[2]/div[1]/a[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		// clicking on the confirmed status
		driver.findElement(By.xpath("(//a[@id='status_link_Confirmed'])[1]")).click();
		Thread.sleep(3000);

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
		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		Thread.sleep(2000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on Clinic manager Role
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[2]/a[3]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
	}

	@AfterClass
	public void afterClass() {
	}

}
