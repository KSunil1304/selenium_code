package Reports;

//Done = there is only one pharmacy
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BrandWiseReportGST {
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
		// Reports_pharmacy.mouse(driver);
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.xpath("//a[text()='BrandWise GST Report']"))).click().build()
				.perform();
		Thread.sleep(2000);
		// selecting the date
		driver.findElement(By.id("month_filter")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// selecting the date [last month]
		driver.findElement(By.id("month_filter")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/input")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li/span[text()='March']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);

	}
}
