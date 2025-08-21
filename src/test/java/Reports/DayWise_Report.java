package Reports;

//search btn...wip
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DayWise_Report {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver120.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user_login")).sendKeys("pharmacist@yourclinic.com");
		driver.findElement(By.id("user_password")).sendKeys("123456");
		driver.findElement(By.name("commit")).click();
		// Reports_pharmacy.mouse(driver);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		action.moveToElement(driver.findElement(By.id("phrmcy_daywise_report"))).click().build().perform();
		Thread.sleep(1000);
		// id
		driver.findElement(By.id("q_patient_master_ptnt_rgstrtn_id_cont")).sendKeys("RDAA1648104708208");
		Thread.sleep(1000);
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='15']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// name
		driver.findElement(By.id("q_patient_master_frst_nm_cont")).sendKeys("test");
		Thread.sleep(1000);
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='15']")).click();
		Thread.sleep(1000);
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// phone num
		driver.findElement(By.id("q_patient_master_nmbr_cont")).sendKeys("8790098500");
		Thread.sleep(1000);
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='15']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// doctor name
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[1]/form/div[2]/div[1]/div[5]/input"))
				.sendKeys("Nh doctor");
		Thread.sleep(2000);
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='15']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);
		// clicking on the bookings.
		// Bookings
		WebElement bookings = driver.findElement(By.xpath("//label[text()='Bookings']"));
		bookings.click();
		Thread.sleep(2000);
		// name
		driver.findElement(By.id("q_patient_master_frst_nm_cont")).sendKeys("test");
		Thread.sleep(1000);
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='15']")).click();
		Thread.sleep(1000);
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// phone num
		driver.findElement(By.id("q_patient_master_nmbr_cont")).sendKeys("8790098500");
		Thread.sleep(1000);
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='15']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// doctor name
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[1]/form/div[2]/div[1]/div[5]/input"))
				.sendKeys("Nh doctor");
		Thread.sleep(2000);

		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='15']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);

		Thread.sleep(2000);
		// clicking on the bookings
		WebElement booking = driver.findElement(By.xpath("//label[text()='Bookings']"));
		booking.click();
		Thread.sleep(2000);
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='15']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);

		// clicking on the profilt
		WebElement profit = driver.findElement(By.xpath("//label[text()='Profit']"));
		profit.click();
		Thread.sleep(2000);
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='20']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);

		driver.quit();
	}
}
