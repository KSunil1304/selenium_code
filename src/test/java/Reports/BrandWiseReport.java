package Reports;

//D
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BrandWiseReport {
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
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.id("phrmcy_brndwise_report"))).click().build().perform();
		Thread.sleep(2000);
		// brand selection
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/form/div/div/div[1]/span/span[1]/span/span[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='CROCIN 500MG']")).click();
		Thread.sleep(1000);

		// from date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("td.is-today")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(1000);
		// brand selection
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/form/div/div/div[1]/span/span[1]/span/span[1]"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='AZITHRO 500MG']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='1']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("td.is-today")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
		// batch selection
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/form/div/div/div[2]/span/span[1]/span/span[1]"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='Sd']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='1']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("td.is-today")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
		// batch selection
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/form/div/div/div[2]/span/span[1]/span/span[1]"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='1023']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// from date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='1']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("td.is-today")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(2000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);

	}
}
