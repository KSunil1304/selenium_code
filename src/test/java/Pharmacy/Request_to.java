package Pharmacy;

import java.awt.Robot;
import java.awt.event.KeyEvent;
//donee=
import java.time.Duration;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Request_to {
	WebDriver driver;

	@BeforeClass
	public void Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver139.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.findElement(By.id("user_login")).sendKeys("testuser@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		driver.findElement(By.name("commit")).click();
		Thread.sleep(3000);

		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on Pharmacist role
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 0)
	public void Requestto() throws Exception {
		// clicking on the central pharmacy
		driver.findElement(By.xpath("//*[@id=\"account-selection\"]/div/div[2]/a[1]/div/div/div/div[2]")).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacy-masterData"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("pharmacist_brand_masters_link"))).click().build().perform();
		// driver.findElement(By.linkText("BrandMasters")).click();
		driver.findElement(By.linkText("add")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[1]/div[1]/div/span/span[1]/span"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//li[text()='Vaccine']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//li[text()='Alcon Laboratories (India) Private Limited'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//li[text()='Tablet']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#brand_master_brand_name")).sendKeys("Pharmacybrandmastertwo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("input#brand_master_brand_desc")).sendKeys("NA");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='Oral'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='brand_master_tax_service_mapping_master_attributes_hsncode']"))
				.sendKeys("8790");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='IGST'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='12.0'])[1]")).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@id='brand_master_tax_service_mapping_master_attributes_hsncode']"))
//				.sendKeys(Keys.PAGE_DOWN);//		driver.findElement(By.xpath("(//span[@class='selection'])[10]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='COVID-19'][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='brand_master_mrp']")).sendKeys("300");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='brand_master_mrp']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement checkbox1 = driver.findElement(By.xpath("//label[text()='Active']"));
			checkbox1.click();
		}
		Thread.sleep(1000);
		for (int i = 0; i <= 2; i++) {
			WebElement checkbox2 = driver.findElement(By.xpath("//label[text()='Verified']"));
			checkbox2.click();
		}
		Thread.sleep(1000);
		for (int i = 0; i <= 3; i++) {
			WebElement checkbox3 = driver.findElement(By.xpath("//label[text()='Serial Number Required?']"));
			checkbox3.click();
		}
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("//input[@value='Save'][1]")).click();
		Thread.sleep(5000);

		// received without invoice
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).click().build().perform();
		Thread.sleep(1000);
		action1.moveToElement(driver.findElement(By.xpath("(//a[text()='Stock Entry'])[1]"))).click().build().perform();
		Thread.sleep(1000);
		Actions action2 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("//i[text()='add']"))).build().perform();
		Thread.sleep(1000);
		action1.moveToElement(driver.findElement(By.xpath("//i[text()='add']"))).build().perform();
		Thread.sleep(1000);
		action1.moveToElement(driver.findElement(By.xpath("//a[text()='Received without Invoice']"))).click().build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#pharmacy_purchase_header_purchase_dt")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Distributor Name'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Central Pharmacy'])[1]")).click();
		Thread.sleep(1000);
		// searching for the brand
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_brand_name"))
				.sendKeys("Pharmacybrandmastertwo");
		Thread.sleep(3000);
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_brand_name"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		// batch
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_batch"))
				.sendKeys("87900");
		Thread.sleep(1000);
		// expiry date
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_expiry_dt")).click();
		Thread.sleep(1000);
		Select sc = new Select(
				driver.findElement(By.cssSelector("select.mtz-monthpicker.mtz-monthpicker-year:nth-of-type(1)")));
		sc.selectByValue("2030");
		Thread.sleep(1000);
		// jan
		driver.findElement(By.xpath("//td[text()='Jan']")).click();
		Thread.sleep(1000);
		// pkt/strip qty
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_purchase_pck_qty"))
				.sendKeys("10");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// pktcost
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_purchase_pck_cost"))
				.sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// tablet/pkt
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_qty_per_pck"))
				.sendKeys("10");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// pkt mrp
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_pck_mrp"))
				.sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// discount
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_purchase_discount"))
				.sendKeys("3");
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(3000);

		// transfer details
		Actions action11 = new Actions(driver);
		action11.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).click().build().perform();
		Thread.sleep(1000);
		action11.moveToElement(driver.findElement(By.xpath("/html/body/header/div[1]/nav/div/ul/li[3]/ul/li[3]/a")))
				.click().build().perform();
		Thread.sleep(1000);

		// clicking on the transfer
		driver.findElement(By.xpath("(//a[text()='Transfer'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the add button
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(2000);
		// selecting the transfer to
		driver.findElement(By.xpath("(//label[text()='Transfer to'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Test Pharmacy'])[1]")).click();
		Thread.sleep(1000);

		// entering the brand name
		driver.findElement(By.xpath("(//input[@class='medBrandName_transfer'])")).sendKeys("Pharmacybrandmastertwo");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='btn green medicineAvail'])[1]/img")).click();
		Thread.sleep(2000);
		// category
		driver.findElement(
				By.xpath("(//input[@id='pharmacy_transfer_header_pharmacy_transfer_lines_attributes_0_category'])"))
				.sendKeys("Test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// quantity
		driver.findElement(By.id("pharmacy_transfer_header_pharmacy_transfer_lines_attributes_0_quantity"))
				.sendKeys("10");
		Thread.sleep(1000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(3000);

		// clicking on the brand logo
		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// selecting the cdp
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the central pharmacy
		driver.findElement(By.xpath("//*[@id=\"account-selection\"]/div/div[2]/a[2]/div/div/div/div[2]")).click();
		Thread.sleep(3000);

		Actions action111 = new Actions(driver);
		action111.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).click().build().perform();
		Thread.sleep(1000);
		action111.moveToElement(driver.findElement(By.xpath("/html/body/header/div[1]/nav/div/ul/li[3]/ul/li[3]/a")))
				.click().build().perform();
		Thread.sleep(3000);
		// clicking on the transfer button
		driver.findElement(By.xpath("(//a[text()='Transfer'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the receive button
		driver.findElement(By.xpath("(//a[text()='Receive'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the received button
		driver.findElement(By.xpath("(//input[@value='Received'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the received status button
		driver.findElement(By.xpath("(//a[text()='Received'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the request id
		driver.findElement(By.xpath("(//tr[@class='received odd'])[1]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		// clicking on the close button for popup
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-modal'])[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(3000);

		// searching patinet
		driver.findElement(By.cssSelector("input#frst_nm")).sendKeys("Cucum" + Keys.ENTER);
		Thread.sleep(3000);
		// clicking on the pharmacy order
		driver.findElement(By.xpath("(//a[@data-tooltip='Pharmacy Order'])[1]/img[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#prescription_sale_order_header_doctor_name")).sendKeys("D");
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(
				"textarea#prescription_sale_order_header_prescription_order_lines_attributes_0_brand_name"))
				.sendKeys("Pharmacybrandmastertwo");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@class='btn green tooltipped medicineAvail'])[1]")).click();
		// robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		// sending qty
		driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/form/div[4]/div[2]/div[1]/div/div[6]/div/input"))
				.sendKeys("1");
		Thread.sleep(2000);
		// clicking on the deliver button
		driver.findElement(By.xpath("(//input[@id='saveBtn'])[1]")).click();
		Thread.sleep(2000);
		WebElement radio = driver.findElement(By.xpath("//label[text()='Cash']"));
		radio.click();
		driver.findElement(By.id("advance_field")).sendKeys("10");
		Thread.sleep(1000);
		// clicking on the comment
		driver.findElement(By.id("paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.id("payment_cmnt")).sendKeys("test receipt comment 1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("bookNowBtn")).click();
		Thread.sleep(1000);
		Robot robot21 = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// receipt download
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[7]/div[2]/div[2]/a")).click();
		Thread.sleep(1000);
		// downloading total advance pdf
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(1000);
		// downloading total pdf with details pdf
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[11]/a[2]")).click();
		Thread.sleep(1000);
		// clicking on the print
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div[11]/a[1]")).click();
		Thread.sleep(1000);
		// clicking on the share invoice
		driver.findElement(By.xpath("(//a[@class='btn green right btn-loader2 service_wise_pdf'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='phone'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		WebElement submit = driver.findElement(By.xpath("/html/body/main/div/div[13]/div/div[2]/form/div[2]/input"));
		submit.click();
		Thread.sleep(15000);

	}
}
