package Reports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MonthlyReport {
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
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Billing']"))).build().perform();
		action.moveToElement(driver.findElement(By.id("phrmcy_monthwise_report"))).click().build().perform();
		Thread.sleep(2000);
		// selecting the date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		// to date
		driver.findElement(By.id("to-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='25'])[2]")).click();
		Thread.sleep(1000);
		/*
		 * driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[2]/input")).click();
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("/html/body/ul[1]/li[10]")).click(); //2022
		 * Thread.sleep(1000); driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/input")).click();
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("/html/body/ul[2]/li[1]/span")).click();
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("//button[text()='1']")).click();
		 * Thread.sleep(1000);
		 */
		// search
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(1000);
		// download
		driver.findElement(By.xpath("//i[text()='file_download']")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);

		// selecting the date
		driver.findElement(By.id("from-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='20']")).click();
		Thread.sleep(1000);
		// to date
		driver.findElement(By.id("to-date")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='25'])[2]")).click();
		Thread.sleep(1000);
		/*
		 * driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[2]/input")).click();
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("/html/body/ul[1]/li[10]")).click(); //2022
		 * Thread.sleep(1000); driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/input")).click();
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("/html/body/ul[2]/li[1]/span")).click();
		 * Thread.sleep(1000); driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[6]/button"))
		 * .click(); Thread.sleep(1000);
		 */
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