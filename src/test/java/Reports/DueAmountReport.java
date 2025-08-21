package Reports;

//d
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DueAmountReport {
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
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.id("due_amount_report"))).click().build().perform();
		Thread.sleep(2000);
		// pat.id
		driver.findElement(By.id("q_patient_master_ptnt_rgstrtn_id_eq")).sendKeys("NH1672923567148");
		Thread.sleep(1000);
		// selecting date
		driver.findElement(By.id("q_order_date_gteq")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(1000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// test
		driver.findElement(By.id("q_patient_master_frst_nm_cont")).sendKeys("test");
		Thread.sleep(1000);
		// selecting date
		driver.findElement(By.id("q_order_date_gteq")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(1000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
		// test
		driver.findElement(By.id("q_patient_master_frst_nm_cont")).sendKeys("Sunil");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting date
		driver.findElement(By.id("q_order_date_gteq")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(1000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
	}
}
