package Pharmacy;

//getting error on submitting data upload.
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dataupload {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver138.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		driver.findElement(By.name("commit")).click();
		Thread.sleep(1000);

		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on Pharmacist role
		driver.findElement(By.xpath("//*[@id=\"account-selection\"]/div/div[2]/a[2]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
		// mouse hovering to the inventory
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Inventory Details'])[1]"))).click().build()
				.perform();
		Thread.sleep(1000);
		// mouse hovering to the plus
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("//i[text()='add']"))).build().perform();
		Thread.sleep(1000);
		action1.moveToElement(driver.findElement(By.xpath("//i[text()='file_download']"))).click().build().perform();
		Thread.sleep(1000);
		// mouse hovering to the plus
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.xpath("//i[text()='add']"))).build().perform();
		Thread.sleep(1000);
		action2.moveToElement(driver.findElement(By.xpath("//i[text()='file_upload']"))).click().build().perform();
		Thread.sleep(1000);
		// clicking on the drop down
		driver.findElement(By.xpath("(//label[text()='Pharmacy'])[2]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='NH Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("data_upload"))
				.sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Uploads\\pharmacy_data_upload (2).xlsx");
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(5000);

		// searching the uploaded brand
		driver.findElement(
				By.xpath("/html/body/main/div/div[2]/div/div/form[1]/div/div[1]/div[3]/span/span[1]/span/ul/li/input"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='AUTOMATION BRANDMASTER'])[1]")).click();
		Thread.sleep(3000);
		// search
		WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
	}

}
