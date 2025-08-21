package Reports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Invoicereport {
	public static void main(String[] args) throws Exception {
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
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
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
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);
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
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);
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
		driver.findElement(By.xpath("(//td[@class='is-today'])[2]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);

	}
}
