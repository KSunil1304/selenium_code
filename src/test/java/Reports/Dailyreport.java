package Reports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Dailyreport {
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
		Thread.sleep(3000);
		// Reports_pharmacy.mouse(driver);
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.id("phrmcy_daywise_report"))).click().build().perform();
		Thread.sleep(1000);
		// from date
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// to date
//			driver.findElement(By.id("to-date")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button")).click();
//			Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/center/form/div[2]/div/div[4]/a[2]/i")).click();
		Thread.sleep(2000);
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
//			driver.findElement(By.id("to-date")).click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//			driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button")).click();
//			Thread.sleep(1000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(1000);
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
//			// to date
//			driver.findElement(By.id("to-date")).click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//			driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button")).click();
//			Thread.sleep(1000);
		// search
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(5000);

	}
}
