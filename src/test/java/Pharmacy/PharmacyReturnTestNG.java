package Pharmacy;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
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

public class PharmacyReturnTestNG {
	WebDriver driver = null;

	@Test(priority = 0)
	public void Test() throws Exception {
		// checking the availble qty.
		// mouse - hovering to the inventory
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).click().build().perform();
		action.moveToElement(driver.findElement(By.xpath("(//a[text()='Inventory Details'])[1]"))).click().build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='BrandName'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(1000);
		// selecting the batch code
		driver.findElement(By.xpath("(//label[text()='Batchnumber'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='1304'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		String avaqty = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[1]/td[5]")).getText();
		System.out.println("Avaiable quantity before ordered:" + avaqty);
		Thread.sleep(5000);

		// creating a new order
		driver.findElement(By.xpath("(//a[@data-tooltip='Add Patient'])[2]/img[1]")).click();
		Thread.sleep(5000);
		// selecting the title
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='first_name'])[1]")).sendKeys("Demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='lst_name'])[1]")).sendKeys("pharmacyreturn");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the age
		driver.findElement(By.xpath("(//input[@id='age'])[1]")).sendKeys("41");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// country code
		driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='+91']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("nmbr")).sendKeys("9988771132");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("testphamreturn@gmail.com");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='address-line1'])[1]")).sendKeys("Hyderabad");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@name='adrs_line2'])[1]")).sendKeys("Hyderabad");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='landmark'])[1]")).sendKeys("Ameerpet");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// city
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='city'])[1]")).sendKeys("testcity");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// district
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='district'])[1]")).sendKeys("testdist");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Robot pgdwn = new Robot();
		pgdwn.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		// pincode
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys("500034");
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")).click();
		Thread.sleep(2000);
		// submit
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("(//input[@id='prescription_sale_order_header_doctor_name'])[1]")).sendKeys("dr");
		Thread.sleep(2000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot2.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		driver.findElement(
				By.xpath("/html/body/main/div[1]/div[2]/form/div[4]/div[2]/div[1]/div/div[2]/div[2]/div/textarea"))
				.sendKeys("Sunil");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(3000);
		// mouse hover on inventory
		Actions inv = new Actions(driver);
		inv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Inventory'])[1]/img[1]"))).build().perform();
		Thread.sleep(1000);
		inv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Inventory'])[1]/img[1]"))).click().build()
				.perform();
		Thread.sleep(2000);
		// closing inventory
		driver.findElement(By.xpath("(//span[@class='btn-close nh_close btn-floating mr-15'])[1]/i[1]")).click();
		Thread.sleep(2000);
//		// selecting the batch
		driver.findElement(By.xpath("//a[contains(text(),'1304(Dec-30)')]")).click();
		Thread.sleep(3000);

		// entering the qty.
		driver.findElement(By.xpath("(//label[text()='QTY'])[1]/following-sibling::input")).sendKeys("1");
		Thread.sleep(2000);
		// adding & deleting another
		driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/form/div[4]/div[5]/div/a/i")).click();
		Thread.sleep(1000);
		// remove
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(2000);

		// deliver
		driver.findElement(By.xpath("(//input[@value='Deliver'])[1]")).click();
		Thread.sleep(3000);
		WebElement radio = driver.findElement(By.xpath("//label[text()='Cash']"));
		radio.click();
		driver.findElement(By.id("advance_field")).sendKeys("1");
		Thread.sleep(1000);
		// clicking on the comment
		driver.findElement(By.id("paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.id("payment_cmnt")).sendKeys("test receipt comment 1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("bookNowBtn")).click();
		Thread.sleep(5000);
		// Generating the invoice
		WebDriverWait generate = new WebDriverWait(driver, Duration.ofSeconds(30));
		generate.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Generate'])[1]"))))
				.click();
		Thread.sleep(2000);
		// confirm
		WebDriverWait confirm = new WebDriverWait(driver, Duration.ofSeconds(30));
		confirm.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='Confirm!'])[1]"))))
				.click();
		Thread.sleep(3000);
		// print invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")).click();
		Thread.sleep(2000);
		Robot robot21 = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// receipt download
		driver.findElement(By.xpath("//a[contains(text(), 'R-')]")).click();
		Thread.sleep(2000);
		// total advance
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);
		// downloading pdf
		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/i[1]")).click();
		Thread.sleep(1000);
		// clicking on the print without details
		driver.findElement(By.xpath("(//a[@data-tooltip='Print without details'])[1]/i[1]")).click();
		Thread.sleep(1000);
		// clicking on the share invoice
		driver.findElement(By.xpath("(//a[@class='btn green right btn-loader2 service_wise_pdf'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		WebElement submit = driver
				.findElement(By.xpath("(//div[@id='modal1'])[1]/div[1]/div[2]/form[1]/div[2]/input[1]"));
		submit.click();
		Thread.sleep(15000);
		// clicking on the manage orders
		WebElement mo = driver.findElement(By.xpath("(//a[text()='Manage Orders'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", mo);
		Thread.sleep(2000);
//		// clikcing on the delivered status
//		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[1]/ul/li[4]/a")).click();
//		Thread.sleep(3000);

		// checking the availble qty.
		// mouse - hovering to the inventory
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).click().build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/header/div[1]/nav/div/ul/li[3]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='BrandName'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(1000);
		// selecting the batch code
		driver.findElement(By.xpath("(//label[text()='Batchnumber'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='1304'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		String orderedqty = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[1]/td[5]")).getText();
		System.out.println("Avaiable quantity after ordered:" + orderedqty);
		Thread.sleep(8000);

		// clicking on the manage orders
		driver.findElement(By.id("pharmacist_orders_list")).click();
		Thread.sleep(2000);
		// clikcing on the delivered status
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[1]/ul/li[4]/a")).click();
		Thread.sleep(10000);
		// clicking on the patient name
		WebElement id = driver.findElement(By.xpath("//a[text()='Demo Pharmacyreturn']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", id);
		Thread.sleep(2000);
		// clicking on the edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		Thread.sleep(1000);
		// return qty.
		driver.findElement(By.xpath("(//input[@class='returnQty'])[1]")).sendKeys("1");
		Thread.sleep(1000);
		// update inovice
		driver.findElement(By.id("saveBtn")).click();
		Thread.sleep(8000);
		// clicking on the continue
		driver.findElement(By.id("prescriptionContinue")).click();
		Thread.sleep(3000);
		try {
			Robot robot3 = new Robot();
			robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1000);

		} catch (Exception e) {
			// TODO: handle exception
		}
		// clicking on the return
		WebElement ret = driver.findElement(By.xpath("//label[text()='Return']"));
		ret.click();
		Thread.sleep(1000);
		// clicking on the cash
		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash.click();
		// advance paid
		driver.findElement(By.id("advance_field")).sendKeys("1");
		Thread.sleep(3000);
		// receipt comment
		driver.findElement(By.id("paymentComment")).click();
		Thread.sleep(1000);
		// receipt comment
		driver.findElement(By.id("payment_cmnt")).sendKeys("receipt comment");
		Thread.sleep(1000);
		WebElement ok = driver.findElement(By.xpath("(//a[text()='Ok'])[2]"));
		ok.click();
		Thread.sleep(1000);
		// comments
		// driver.findElement(By.id("paymentComment")).click();
		// Thread.sleep(1000);
		// refund reason
		driver.findElement(By.id("refund_rsn")).sendKeys("returning sunil brand qty.");
		Thread.sleep(1000);
		// ok
		driver.findElement(By.xpath("(//a[text()='Ok'])[1]")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.id("bookNowBtn")).click();
		Thread.sleep(2000);
		// clicking on the print invoice
		driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]")).click();
		Thread.sleep(2000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		// receipt id 1
		String parentwind = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[contains(text(),'R-')])[1]")).click();
		Thread.sleep(1000);
		Set<String> childwind = driver.getWindowHandles();
		for (String handle : childwind) {
			if (!childwind.equals(parentwind)) {
				Thread.sleep(1000);
				driver.switchTo().window(parentwind);
			}
		}
		Thread.sleep(3000);
		// receipt id 2
		String parentwind1 = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[contains(text(),'R-')])[2]")).click();
		Thread.sleep(2000);
		Set<String> childwind1 = driver.getWindowHandles();
		for (String handle : childwind1) {
			if (!childwind1.equals(parentwind1)) {
				Thread.sleep(1000);
				driver.switchTo().window(parentwind1);
			}
		}
		Thread.sleep(3000);
		// total advance
		String parentwind2 = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@data-tooltip='Total Receipt'])[1]/img[1]")).click();
		Thread.sleep(2000);
		Set<String> childwind2 = driver.getWindowHandles();
		for (String handle : childwind2) {
			if (!childwind2.equals(parentwind2)) {
				Thread.sleep(1000);
				driver.switchTo().window(parentwind2);
			}
		}
		Thread.sleep(3000);
		// clicking on the print
		String parentwind3 = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@data-tooltip='Print'])[1]/i[1]")).click();
		Thread.sleep(1000);
		Set<String> childwind3 = driver.getWindowHandles();
		for (String handle : childwind3) {
			if (!childwind3.equals(parentwind3)) {
				Thread.sleep(1000);
				driver.switchTo().window(parentwind3);
			}
		}
		// clicking on the share invoice
		driver.findElement(By.xpath("(//a[@class='btn green right btn-loader2 service_wise_pdf'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("emails")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("phone")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("emails")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(1000);
		WebElement submit1 = driver.findElement(By.xpath("/html/body/main/div/div[13]/div/div[2]/form/div[2]/input"));
		submit1.click();
		Thread.sleep(15000);
		// clicking on the manage orders
		// WebElement mo1 = driver.findElement(By.xpath("(//a[text()='Manage
		// Orders'])[2]"));
		// JavascriptExecutor js11 = (JavascriptExecutor) driver;
		// js11.executeScript("arguments[0].click();", mo1);
		// Thread.sleep(2000);
		// clikcing on the delivered status
		// driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div[1]/ul/li[4]/a")).click();
		// Thread.sleep(3000);
		// checking the availble qty.
		// mouse - hovering to the inventory
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).click().build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/header/div[1]/nav/div/ul/li[3]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("(//label[text()='BrandName'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(1000);
		// selecting the batch code
		driver.findElement(By.xpath("(//label[text()='Batchnumber'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='1304'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		String returnedqty = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[1]/td[5]")).getText();
		System.out.println("Avaiable quantity after return:" + returnedqty);
		Thread.sleep(5000);

	}

	@Test(enabled = false)
	public void PatientnameSearch() throws Exception {
//		driver.findElement(By.cssSelector("input#frst_nm" + Keys.ENTER)).click();
//		Thread.sleep(3000);
//		// clicking on the home
//		driver.findElement(By.xpath("(//i[@class='fa fa-home'])[1]")).click();
//		Thread.sleep(2000);

	}

	@Test(enabled = false)
	public void BrandnameSearch() throws Exception {
//		driver.findElement(By.cssSelector("input#brand_nm")).sendKeys("Dolamide" + Keys.ENTER);
//		Thread.sleep(3000);
//		// mouse-hovering on the brand
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//div[@id='inv-brands-list'])[1]/ul/li[1]"))).build()
//				.perform();
//		Thread.sleep(2000);

	}

//	@BeforeClass
//	@Parameters("url")
//	public void setup(@Optional("https://customer.nanohealthplan.com/users/sign_in") String url) throws Exception {
//		driver = BrowserUtility.getInstance().launchBrowser(url);
//		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
//		Thread.sleep(1000);
//		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
//		Thread.sleep(1000);
//		driver.findElement(By.name("commit")).click();
//		Thread.sleep(3000);
//		// selecting the NanoHealth CDP
//		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
//		Thread.sleep(3000);
//		// selecting Role clicking on CDPAdmin Role
//		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("frst_nm")).sendKeys("Demopharmacyreturn");
//		Thread.sleep(5000);
//		// clicking on the patient name
//		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
//		Thread.sleep(3000);
//		// clicking on the view profile
//		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
//		Thread.sleep(3000);
//		// close for pending amount
//		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]")).isDisplayed()) {
//			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.id("admin-billing-tab")).click();
//			// clicking on the delete
//			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")).click();
//			Thread.sleep(1000);
//		} else {
//			// clicking on the delete
//			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")).click();
//			Thread.sleep(1000);
//		}
//		// deleteing
//		driver.findElement(By.xpath("(//a[@class='btn-loader modal-action btn green submitBtn'])[1]")).click();
//		Thread.sleep(15000);
////		// signing out
////		driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img")).click();
////		Thread.sleep(1000);
////		driver.findElement(By.xpath("(//i[@class='fa fa-sign-out'])[1]")).click();
////		Thread.sleep(3000);
////		driver.get("https://customer.nanohealthplan.com/users/sign_in");
////		Thread.sleep(3000);
////		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
////		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
////		driver.findElement(By.name("commit")).click();
////		Thread.sleep(1000);
//		// clicking on the brand logo
//		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]")).click();
//		Thread.sleep(3000);
//		// selecting the NanoHealth CDP
//		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
//		Thread.sleep(3000);
//		// selecting Role clicking on Pharmacist Role
//		// selecting Role clicking on pharmacy
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
//
//	}

	@BeforeClass
	public void Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver139.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.manage().window().maximize();
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		Thread.sleep(1000);
		driver.findElement(By.name("commit")).click();
		Thread.sleep(3000);
//		// selecting the NanoHealth CDP
//		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
//		Thread.sleep(3000);
//		// selecting Role clicking on CDPAdmin Role
//		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("frst_nm")).sendKeys("Demopharmacyreturn");
//		Thread.sleep(5000);
//		// clicking on the patient name
//		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
//		Thread.sleep(3000);
//		// clicking on the view profile
//		driver.findElement(By.xpath("(//a[text()='View Profile'])[1]")).click();
//		Thread.sleep(3000);
//		// close for pending amount
//		if (driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]")).isDisplayed()) {
//			driver.findElement(By.xpath("(//div[@id='invoice_modal'])[1]/div[1]/div[1]/span[1]")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.id("admin-billing-tab")).click();
//			// clicking on the delete
//			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")).click();
//			Thread.sleep(1000);
//		} else {
//			// clicking on the delete
//			driver.findElement(By.xpath("/html/body/header/div[1]/nav[2]/div/ul/li[7]/a")).click();
//			Thread.sleep(1000);
//		}
//		// deleteing
//		driver.findElement(By.xpath("(//a[@class='btn-loader modal-action btn green submitBtn'])[1]")).click();
//		Thread.sleep(15000);
////		// signing out
////		driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img")).click();
////		Thread.sleep(1000);
////		driver.findElement(By.xpath("(//i[@class='fa fa-sign-out'])[1]")).click();
////		Thread.sleep(3000);
////		driver.get("https://customer.nanohealthplan.com/users/sign_in");
////		Thread.sleep(3000);
////		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
////		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
////		driver.findElement(By.name("commit")).click();
////		Thread.sleep(1000);
//		// clicking on the brand logo
//		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]/img[1]")).click();
//		Thread.sleep(3000);
//		// selecting the NanoHealth CDP
//		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
//		Thread.sleep(3000);
		// selecting Role clicking on Pharmacist Role
		// selecting Role clicking on pharmacy
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();

	}

	@AfterClass
	public void afterClass() {
	}

}
