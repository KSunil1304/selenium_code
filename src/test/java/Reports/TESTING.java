package Reports;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TESTING {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Properties prop = new Properties();
		File file = new File("config.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\chromedriver138.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");

		WebDriverManager.firefoxdriver().setup(); // FireFox
		// WebDriver driver = new ChromeDriver(co); // Chrome

		String browsername = prop.getProperty("browser");

		WebDriver driver = null;
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(co);
		}

		else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver(co);
		}

		else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver(co);
		}

		else {
			System.out.println("No browser is initiated");
		}

		driver.manage().window().maximize();

		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		co.setPageLoadStrategy(PageLoadStrategy.NONE);

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
//				// download
//				driver.findElement(By.xpath("/html/body/main/div/div[2]/div/center/form/div[2]/div/div[4]/a[2]/i")).click();
//				Thread.sleep(2000);
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
//				driver.findElement(By.id("to-date")).click();
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//				driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button")).click();
//				Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
//				// download
//				driver.findElement(By.xpath("//i[text()='file_download']")).click();
//				Thread.sleep(1000);
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
//				// to date
//				driver.findElement(By.id("to-date")).click();
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//				driver.findElement(By.xpath("(//td[@class='is-today'])[1]/button")).click();
//				Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
//				// download
//				driver.findElement(By.xpath("//i[text()='file_download']")).click();
//				Thread.sleep(1000);
		// reset
		driver.findElement(By.xpath("//a[text()='Reset']")).click();
		Thread.sleep(5000);

	}

}
