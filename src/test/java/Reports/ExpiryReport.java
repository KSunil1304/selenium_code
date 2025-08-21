package Reports;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ExpiryReport {
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacist_reports"))).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action.moveToElement(driver.findElement(By.id("admin-expiry-report"))).click().build().perform();
		Thread.sleep(1000);
		// clicking on the pharmacy
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
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
		driver.findElement(By.xpath("(//tr[@class='mtz-monthpicker']/td[text()='Jul'])[2]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(5000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
		// searching through the Manufacturer
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='ALCON']")).click();
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
		driver.findElement(By.xpath("(//tr[@class='mtz-monthpicker']/td[text()='Jul'])[2]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(5000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);
		// searching through the Brandname
		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
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
		driver.findElement(By.xpath("(//tr[@class='mtz-monthpicker']/td[text()='Dec'])[2]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(5000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(2000);
		// searching through the years
		// from-date
		driver.findElement(By.id("from-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// year
		Select year = new Select(driver
				.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year initialized'])[1]")));
		year.selectByValue("2023");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// jan
		driver.findElement(By.xpath("//tr[@class='mtz-monthpicker']/td[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to-date
		driver.findElement(By.id("to-date")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// year
		Select year1 = new Select(driver
				.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year initialized'])[2]")));
		year1.selectByValue("2026");
		// jul
		driver.findElement(By.xpath("(//tr[@class='mtz-monthpicker']/td[text()='Jun'])[2]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(5000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(3000);

	}
}
