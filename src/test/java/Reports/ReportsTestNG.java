package Reports;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReportsTestNG {
	WebDriver driver;

	@Test(priority = 0)
	public void Dailyreport() throws Exception {
		// Reports_pharmacy.mouse(driver);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("phrmcy_daywise_report"))).click().build().perform();
		Thread.sleep(1000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// from date
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// to date
		driver.findElement(By.id("to-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]/button")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
//		// download
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/center/form/div[2]/div/div[4]/a[2]/i")).click();
//		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/center/form/div[2]/div/div[4]/a[1]")).click();
		Thread.sleep(2000);
		// clicking on the bookings
		WebElement booking = driver.findElement(By.xpath("//label[text()='Bookings']"));
		booking.click();
		Thread.sleep(2000);
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='1']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
//		driver.findElement(By.id("to-date")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);

		// clicking on the profilt
		WebElement profit = driver.findElement(By.xpath("//label[text()='Profit']"));
		profit.click();
		Thread.sleep(2000);
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='1']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// to date
//		driver.findElement(By.id("to-date")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button")).click();
//		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(5000);

	}

	@Test(priority = 1)
	public void Patientwisereport() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("phrmcy_revenue_report"))).click().build().perform();
		Thread.sleep(2000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);

		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// name
		driver.findElement(By.id("q_patient_master_frst_nm_cont")).sendKeys("test");
		Thread.sleep(1000);
		// from date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='month-prev'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1'][1]")).click();
		Thread.sleep(1000);
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(10000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// clicking on the bookings.
		// Bookings
		WebElement bookings = driver.findElement(By.xpath("//label[text()='Bookings']"));
		bookings.click();
		Thread.sleep(2000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// doctor name
		driver.findElement(By.cssSelector("input#q_prescription_sale_order_headers_doctor_name_cont"))
				.sendKeys("Doctor one");
		Thread.sleep(2000);
		// from date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='month-prev'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1'][1]")).click();
		Thread.sleep(1000);
//		// to date
//		driver.findElement(By.id("to-date")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//td[@class='is-today'])[2]/button")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
	}

	@Test(priority = 2) // priority=2
	public void Monthlyreport() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("phrmcy_monthwise_report"))).click().build().perform();
		Thread.sleep(2000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// selecting the date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		WebElement dropdown = driver
				.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year initialized'])[1]"));
		Select select = new Select(dropdown);
		// Select by visible text
		select.selectByVisibleText("2025");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[text()='Jan'])[1]")).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(1000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// selecting the date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		WebElement dropdown1 = driver
				.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year initialized'])[1]"));
		Select select1 = new Select(dropdown1);
		// Select by visible text
		select1.selectByVisibleText("2025");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[text()='Jan'])[1]")).click();
		Thread.sleep(2000);
		// to date
		driver.findElement(By.id("to-date")).click();
		Thread.sleep(1000);
		WebElement dropdown11 = driver
				.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year initialized'])[2]"));
		Select select11 = new Select(dropdown11);
		// Select by visible text
		select11.selectByVisibleText("2025");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[text()='Mar'])[2]")).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(1000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(2000);
		// selecting the bookings radio btn
		WebElement bookings = driver.findElement(By.xpath("(//label[text()='Bookings'])[1]"));
		bookings.click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(2000);
		// selecting the bookings radio btn
		WebElement profit = driver.findElement(By.xpath("(//label[text()='Profit'])[1]"));
		profit.click();
		Thread.sleep(2000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);

	}

	@Test(enabled = false) // priority=3
	public void Invoicereport() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("phrmcy_invoicewise_report"))).click().build().perform();
		Thread.sleep(1000);
		// clicking on the pharmacy
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='NH Pharmacy']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// from-date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// to-date
		driver.findElement(By.id("to-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[contains(@class,'is-today')])[2]/button")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
		// test
		driver.findElement(By.id("q_patient_master_frst_nm_cont")).sendKeys("test");
		Thread.sleep(1000);
		// from-date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// to-date
		driver.findElement(By.id("to-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[contains(@class,'is-today')])[2]/button")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
		// clicking on the pharmacy
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='Cash']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// from-date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// to-date
		driver.findElement(By.id("to-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[contains(@class,'is-today')])[2]/button")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);
	}

	// SoftAssert sa = new SoftAssert();
	@Test(priority = 3)
	public void GSTReport() throws Exception {
		// Reports_pharmacy.mouse(driver);
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("phrmcy_gst_report"))).click().build().perform();
		Thread.sleep(2000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// selecting the date
		driver.findElement(By.id("month_filter")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/input")).click();
		Thread.sleep(1000);
		// march
		driver.findElement(By.xpath("//li//span[text()='January']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(1000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// status
		driver.findElement(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='IP'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(1000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(1000);
		// status
		driver.findElement(By.xpath("(//label[text()='Status'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='All'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(1000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(1000);
	}

	@Test(priority = 4)
	public void BrandwisereportGST() throws Exception {
		// Reports_pharmacy.mouse(driver);
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='BrandWise GST Report']"))).click().build()
				.perform();
		Thread.sleep(2000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// selecting the date
		driver.findElement(By.id("month_filter")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// selecting the date [last month]
		driver.findElement(By.id("month_filter")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/input")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li/span[text()='January']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void DistributorwiseGSTreport() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='DistributorWise GST Report']"))).click().build()
				.perform();
		Thread.sleep(1000);
		// clicking on the distributor
		driver.findElement(By.xpath("(//label[text()='Distributor'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("month_filter")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(5000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);
		// clicking on the distributor
		driver.findElement(By.xpath("(//label[text()='Distributor'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("month_filter")).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@class='month-prev'])[1]")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(5000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 6)
	public void AnnualGSTReport() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Annual GST Report'])[1]"))).click().build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(3000);
//		// download
//		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
//		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Year'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(3000);
//		// download
//		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
//		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 7)
	public void Dueamountreport() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//a[text()='Annual GST Report'])[1]")).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("due_amount_report"))).click().build().perform();
		Thread.sleep(2000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// test
		driver.findElement(By.id("q_patient_master_frst_nm_cont")).sendKeys("test");
		Thread.sleep(1000);
		// from-date
		driver.findElement(By.id("q_order_date_gteq")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='month-prev'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1'][1]")).click();
		Thread.sleep(2000);
//		//to-date
//		driver.findElement(By.cssSelector("input#q_order_date_lteq")).click();
//		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Search'][1]")).click();
		Thread.sleep(1000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
//		// test
//		driver.findElement(By.id("q_patient_master_frst_nm_cont")).sendKeys("Sunil");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// selecting date
//		driver.findElement(By.id("q_order_date_gteq")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("//button[text()='1']")).click();
//		Thread.sleep(1000);
//		// search
//		driver.findElement(By.xpath("//input[@value='Search'][1]")).click();
//		Thread.sleep(1000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(2000);
//		// reset
//		driver.findElement(By.xpath("//a[text()='Reset']")).click();
//		Thread.sleep(2000);

	}

	@Test(priority = 8)
	public void Brandwisereport() throws Exception {
		// Reports_pharmacy.mouse(driver);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='Annual GST Report'])[1]")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("phrmcy_brndwise_report"))).click().build().perform();
		Thread.sleep(2000);
		// brand selection
		driver.findElement(By.xpath("(//label[text()='Brandname'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='A2B'])[1]")).click();
		Thread.sleep(1000);
		// from date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1'][1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// search
		driver.findElement(By.xpath("//input[@value='Search'][1]")).click();
		Thread.sleep(2000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// brand selection
		driver.findElement(By.xpath("(//label[text()='Brandname'])[1]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='SUNIL BRAND'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='1']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(2000);
//		// download
//		driver.findElement(By.xpath("//i[text()='file_download']")).click();
//		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 9)
	public void Profitreport() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Billing'])[1]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='Annual GST Report'])[1]")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Profit Report'])[1]"))).click().build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='A2B'])[1]")).click();
		Thread.sleep(1000);

		// from-date
		driver.findElement(By.cssSelector("input#from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
//		// download
//		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])/i")).click();
//		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(3000);
		// from-date
		driver.findElement(By.cssSelector("input#from-date")).click();
		Thread.sleep(1000);
		// clicking on the previous month button
		driver.findElement(By.xpath("(//button[@class='month-prev'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		Thread.sleep(1000);
		// to-date
		driver.findElement(By.cssSelector("input#to-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
//		// download
//		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])/i")).click();
//		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(3000);
	}

	@Test(enabled = false)
	public void Reorderplan() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Billing'])[1]"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Reorder Plan'])[1]"))).click().build().perform();
		Thread.sleep(2000);
		// selecting the brand from dropdown
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='DOLOBAK'])[1]")).click();
		Thread.sleep(2000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);

		WebElement cb = driver.findElement(By.cssSelector("table#example>tbody>tr>td>label"));
		cb.click();
		Thread.sleep(2000);
		// recalculate
		driver.findElement(By.xpath("(//input[@value='Recalculate'])[1]")).click();
		Thread.sleep(2000);

		// again clikcing on the recalculate
		driver.findElement(By.xpath("(//input[@value='Recalculate'])[2]")).click();
		Thread.sleep(2000);

		WebElement cb1 = driver.findElement(By.cssSelector("table#example>tbody>tr>td>label"));
		cb1.click();
		Thread.sleep(2000);
		// status update
		driver.findElement(By.xpath("(//input[@value='Status Update'])[1]")).click();
		Thread.sleep(2000);
		// closing
		driver.findElement(By.cssSelector("span.btn-close.nh_close.btn-floating>i")).click();
		Thread.sleep(2000);

		// clicking on the load all brands
		driver.findElement(By.xpath("(//a[text()='Load All Brands'])[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 10)
	public void DashboardReports() throws Exception {
		// clicking on the home button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//i[@class='fa fa-home'])[1]"))))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/preceding-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#to-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(2000);
		// received at counter
		driver.findElement(By.cssSelector("span#total")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='totalPaymentModal'])[1]/div/div[1]/span/i[1]")).click();
		Thread.sleep(2000);
		// Breakup-received at counter
		driver.findElement(By.cssSelector("div#sales_count")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='ordersListModal'])[1]/div/div[1]/span/i[1]")).click();
		Thread.sleep(2000);

		// Breakup-Internal Transfers
		driver.findElement(By.xpath("(//div[@id='home_delivery_count'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='ordersListModal'])[1]/div/div[1]/span/i[1]")).click();
		Thread.sleep(2000);

		// Breakup-Delivered
		driver.findElement(By.xpath("(//div[@id='home_delivery_count'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='ordersListModal'])[1]/div/div[1]/span/i[1]")).click();
		Thread.sleep(2000);

		// Breakup-Redeem
		driver.findElement(By.xpath("(//div[@id='home_delivery_count'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='ordersListModal'])[1]/div/div[1]/span/i[1]")).click();
		Thread.sleep(2000);

		// Status filter search
		driver.findElement(By.xpath("(//label[text()='Status'])/preceding-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='OP'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//label[text()='Status'])/preceding-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='IP'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 11)
	public void Expiryreport() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("admin-expiry-report"))).click().build().perform();
		Thread.sleep(1000);
		// selecting the pharmacy
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// from-date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// jan
		driver.findElement(By.xpath("//tr[@class='mtz-monthpicker']/td[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to-date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// jul
		driver.findElement(By.xpath("(//tr[@class='mtz-monthpicker']/td[text()='Jan'])[2]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
//		// downloading the report
//		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
//		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
		// searching through the Manufacturer
		driver.findElement(By.xpath("(//label[text()='Manufacturer'])[1]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[contains(text(), 'Alcon')])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// from-date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// jan
		driver.findElement(By.xpath("//tr[@class='mtz-monthpicker']/td[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to-date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// jul
		driver.findElement(By.xpath("(//tr[@class='mtz-monthpicker']/td[text()='Feb'])[2]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
//		// downloading the report
//		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
//		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
		// searching through the Brandname
		driver.findElement(By.xpath("(//label[text()='BrandName'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(1000);
		// from-date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// jan
		driver.findElement(By.xpath("//tr[@class='mtz-monthpicker']/td[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to-date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// dec
		driver.findElement(By.xpath("(//tr[@class='mtz-monthpicker']/td[text()='Mar'])[2]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
//		// searching through the years
//		// from-date
//		driver.findElement(By.id("from-date")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// year
//		Select year = new Select(driver
//				.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year initialized'])[1]")));
//		year.selectByValue("2024");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// jan
//		driver.findElement(By.xpath("//tr[@class='mtz-monthpicker']/td[1]")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// to-date
//		driver.findElement(By.id("to-date")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// year
//		Select year1 = new Select(driver
//				.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year initialized'])[2]")));
//		year1.selectByValue("2026");
//		// jul
//		driver.findElement(By.xpath("(//tr[@class='mtz-monthpicker']/td[text()='Jun'])[2]")).click();
//		Thread.sleep(1000);
//		// search
//		driver.findElement(By.xpath("//input[@name='commit']")).click();
//		Thread.sleep(5000);
//		// reset
//		driver.findElement(By.xpath("//a[text()='Reset']")).click();
//		Thread.sleep(3000);
	}

//	@BeforeClass
//	@Parameters("url")
//	public void setup(@Optional("https://customer.nanohealthplan.com/users/sign_in") String url) throws Exception {
//		driver = BrowserUtility.getInstance().launchBrowser(url);
//		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
//		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
//		driver.findElement(By.name("commit")).click();
//		Thread.sleep(5000);
//		// selecting the NanoHealth CDP
//		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
//		Thread.sleep(3000);
//		// selecting Role clicking on pharmacy
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
//		Thread.sleep(3000);
//	}

	@BeforeClass
	public void login() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver139.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		// driver.get("https://nhtestserver.ap-south-1.elasticbeanstalk.com/users/sign_in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on pharmacy
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
		Thread.sleep(3000);
	}

	@AfterClass
	public void quit() {
		// driver.quit();
	}
}
