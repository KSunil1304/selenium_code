package Pharmacy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Purchase_Order {
	WebDriver driver;

	@Test(priority = 0)
	public void po() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("/html/body/header/div[1]/nav/div/ul/li[3]/ul/li[1]/a")))
				.click().build().perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Purchase orders")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(1000);
		// selecting the date
		driver.findElement(By.id("pharmacy_purchase_header_purchase_dt")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//td[@class='is-today']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//span[@class='selection'])[4]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='Central Pharmacy'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Brand name
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_brand_name")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_brand_name"))
				.sendKeys("Sunil");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(2000);
		// entering the PckQty
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_purchase_pck_qty"))
				.sendKeys("100");
		Thread.sleep(1000);
//		// entering the PckCost
//		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_purchase_pck_cost"))
//				.sendKeys("1000" + Keys.ENTER);
//		Thread.sleep(2000);
//		// entering the Qty/Pck
//		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_qty_per_pck"))
//				.sendKeys("10");
//		Thread.sleep(1000);
//		// entering the PckMRP
//		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_pck_mrp"))
//				.sendKeys("100");
//		Thread.sleep(2000);
//		// driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_hsncode")).sendKeys("123456"
//		// + Keys.ENTER);
//		Thread.sleep(3000);

		// clicking on the plus button to add new brand
		driver.findElement(By.xpath("(//i[text()='add'])[3]")).click();
		Thread.sleep(3000);
		// Brand name
		driver.findElement(By.xpath("(//input[@class='medBrandPurchase'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='medBrandPurchase'])[2]")).sendKeys("Sun");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@class='medBrandPurchase'])[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		// entering the PckQty
		driver.findElement(By.xpath(
				"/html/body/main/div/div[5]/div/div[2]/form/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div/input"))
				.sendKeys("10");
		Thread.sleep(1000);
		// removing last added brand
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(5000);
		// clicking on the save as draft
		driver.findElement(By.xpath("(//input[@id='btndraft'])[1]")).click();
		Thread.sleep(5000);
		// edit
		// Locate the element
		WebElement editIcon = driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]"));
		// Use JavaScript to click
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", editIcon);

		Thread.sleep(3000);
		// clicking on the save button
		driver.findElement(By.xpath("//input[@value='Save'][1]")).click();
		Thread.sleep(8000);
		// download pdf
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[2]/img[1]"));
		js1.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// click on the purchase date
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(3000);
		// edit from the poup
		driver.findElement(By.xpath("/html/body/main/div/div[7]/div/form/div/div[4]/a")).click();
		Thread.sleep(3000);
		// clicking on the plus button to add new brand
		driver.findElement(By.xpath("(//i[text()='add'])[3]")).click();
		Thread.sleep(3000);
		// Brand name
		driver.findElement(By.xpath("(//input[@class='medBrandPurchase'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='medBrandPurchase'])[2]")).sendKeys("Dolo");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@class='medBrandPurchase'])[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		// entering the PckQty
		driver.findElement(By.xpath(
				"/html/body/main/div/div[5]/div/div[2]/form/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div/input"))
				.sendKeys("10");
		Thread.sleep(50);
		Thread.sleep(3000);
		// clicking on the save button
		driver.findElement(By.xpath("//input[@value='Save'][1]")).click();
		Thread.sleep(8000);
		// download pdf
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		WebElement element1 = driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[2]/img[1]"));
		js11.executeScript("arguments[0].click();", element1);
		Thread.sleep(3000);
		// click on the purchase date
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(3000);
		// closing the popup
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-header-modal'])[1]/div[1]/div[1]/span[1]/i[1]"))
				.click();
		Thread.sleep(10000);
//		// printing the data in the console
//		String tabledata = driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]")).getText();
//		System.out.println(tabledata);
//		Thread.sleep(2000);

		WebElement table = driver.findElement(By.id("example"));
//
//		List<WebElement> head = table.findElements(By.tagName("th"));
//
//		// Get all rows
//		List<WebElement> rows = table.findElements(By.tagName("tr"));
//
//		// Loop through each row
//		for (WebElement row : rows) {
//			// Get each cell in the row
//			List<WebElement> cells = row.findElements(By.tagName("td"));
//
//			// Print cell text
//			for (WebElement cell : cells) {
//				System.out.print(cell.getText() + " | ");
//			}
//			System.out.println(); // New line for each row
//		}
		// Print headers (if present)
		List<WebElement> headerRows = table.findElements(By.tagName("thead")); // optional: use thead
		if (!headerRows.isEmpty()) {
			List<WebElement> headers = headerRows.get(0).findElements(By.tagName("th"));
			for (WebElement header : headers) {
				System.out.print(header.getText() + " | ");
			}
			System.out.println();
		} else {
			// If <thead> is not used, try to find headers from first <tr>
			List<WebElement> firstRowHeaders = table.findElements(By.xpath(".//tr[1]/th"));
			if (!firstRowHeaders.isEmpty()) {
				for (WebElement header : firstRowHeaders) {
					System.out.print(header.getText() + " | ");
				}
				System.out.println();
			}
		}

		// Get all rows (excluding header if already printed)
		List<WebElement> rows = table.findElements(By.xpath(".//tr[position() > 1]"));

		// Loop through each row
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + " | ");
			}
			System.out.println(); // New line for each row
		}

		// Locate the element using XPath (not ID)
		WebElement textElement = driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[5]"));

		// Create Actions object
		Actions actions = new Actions(driver);

		// Double click to select text
		actions.doubleClick(textElement).perform();
		Thread.sleep(1000);

		// Copy the selected text using CTRL + C
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		Thread.sleep(10000);
	}

	@Test(enabled = false)
	public void Approvingthemail() throws Exception {
		// driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]"));
		Thread.sleep(2000);
		driver.navigate().to("https://mail.google.com/mail/u/0/#inbox");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("Inbox"));
		Thread.sleep(3000);
		WebElement firstEmail = driver.findElement(By.cssSelector("tr.zA")); // selects first email
		firstEmail.click();
		Thread.sleep(3000);
//				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.a3s"))); // email body
//				WebElement button = driver.findElement(By.xpath(""));
//				button.click();
//				Thread.sleep(3000);

		driver.findElement(By.xpath("(//div[@data-tooltip='Show trimmed content'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Approve'])[1]")).click();
		Thread.sleep(2000);

	}

	@BeforeClass
	public void login() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver139.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		// driver.get("https://nhtestserver.ap-south-1.elasticbeanstalk.com/users/sign_in");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		driver.findElement(By.name("commit")).click();
		Thread.sleep(3000);

		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on pharmacy
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
		Thread.sleep(3000);
	}

	@AfterClass
	public void close() {

	}
}