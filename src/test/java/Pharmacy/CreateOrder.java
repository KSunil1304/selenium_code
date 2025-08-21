package Pharmacy;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

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

public class CreateOrder {
	WebDriver driver = null;

	@Test(priority = 0)
	public void AddPatient() throws Exception {
		Thread.sleep(2000);
		WebDriverWait addpatient = new WebDriverWait(driver, Duration.ofSeconds(30));
		addpatient
				.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("(//a[@data-tooltip='Add Patient'])[2]/img[1]"))))
				.click();
		Thread.sleep(3000);

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
		driver.findElement(By.xpath("(//input[@id='lst_name'])[1]")).sendKeys("createorder");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// entering the age
		driver.findElement(By.xpath("(//input[@id='age'])[1]")).sendKeys("40");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// country code
		driver.findElement(By.xpath("(//span[@class='selection'])[5]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='+91']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("nmbr")).sendKeys("9988771121");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("testphamord@gmail.com");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
		Thread.sleep(1000);
		// pincode
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//input[@id='pn_cd'])[1]")).sendKeys("500034");
		Robot pgdwn1 = new Robot();
		pgdwn1.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		// selecting demand program
		// demand program
		driver.findElement(By.xpath("(//span[@class='selection'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//li[text()='MSNL1-Rudraram'])[1]")).click();
		Thread.sleep(1000);
		// submit
		driver.findElement(By.xpath("(//input[@id='update_submit'])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("prescription_sale_order_header_doctor_name")).sendKeys("d");
		Thread.sleep(1000);
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		robot2.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//div[text()='Dt. sunil kumar']")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("/html/body/main/div[1]/div[2]/form/div[4]/div[2]/div[1]/div/div[2]/div[2]/div/textarea"))
				.sendKeys("Sunil");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='SUNIL BRAND'])[1]")).click();
		// mouse hover on inventory
		Actions inv = new Actions(driver);
		inv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Inventory'])[1]/img[1]"))).build().perform();
		Thread.sleep(1000);
		inv.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Inventory'])[1]/img[1]"))).click().build()
				.perform();
		Thread.sleep(2000);
		// closing inventory
		driver.findElement(By.xpath("(//span[@class='btn-close nh_close btn-floating mr-15'])[1]/i[1]")).click();
		Thread.sleep(3000);
		// selecting the batch

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'1304(Dec-30)')][1]")))).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[contains(text(),'1304(Dec-30)')][1]")).click();
//		Thread.sleep(3000);
		// entering the qty.
		driver.findElement(By.xpath("(//label[text()='QTY'])[1]/following-sibling::input")).sendKeys("10");
		Thread.sleep(2000);
		// adding & deleting another
		driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/form/div[4]/div[5]/div/a/i")).click();
		Thread.sleep(1000);
		// remove
		driver.findElement(By.xpath("(//i[@class='fa fa-times-circle'])[2]")).click();
		Thread.sleep(2000);
		// clicking on the estimate bill
		driver.findElement(By.xpath("(//input[@value='Estimate Bill'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@id='pharmacist_orders_list'])[1]")).click();
		Thread.sleep(3000);
		// from-date
		driver.findElement(By.cssSelector("input#q_order_date_gteq")).click();
		Thread.sleep(1000);
		// today date
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// to-date
		driver.findElement(By.cssSelector("input#q_order_date_lteq")).click();
		Thread.sleep(1000);
		// today date
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// search
		WebDriverWait search = new WebDriverWait(driver, Duration.ofSeconds(30));
		search.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
//		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the order id
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(3000);
		// pdf download
		driver.findElement(By.xpath("(//img[@data-tooltip='Download'])[1]")).click();
		Thread.sleep(2000);
		// deliver
		WebElement deliverButton = driver.findElement(By.xpath("(//input[@value='Deliver'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", deliverButton);

//		// selecting datefor the pharmacy fill
//		driver.findElement(By.id("refill-date")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.xpath("//button[text()='28']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.id("refillButton")).click();
//		 driver.findElement(By.xpath("/html/body/main/div[3]/div[1]/div[1]/span/i")).click();
//		Thread.sleep(3000);

		// applying the discount percentage
		driver.findElement(By.cssSelector("input#promo_amnt")).click();
		Thread.sleep(2000);
		// proceed clicking
		driver.findElement(By.xpath("(//input[@value='Proceed'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#promo_amnt")).sendKeys("5");
		Thread.sleep(1000);
		// apply btn click
		driver.findElement(By.cssSelector("span#applyCouponModal")).click();
		Thread.sleep(2000);
		// adding comment
		driver.findElement(By.cssSelector("textarea#comments")).sendKeys("applied 5 amount discount");
		Thread.sleep(2000);
		// submit btn click
		WebDriverWait submit = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#applyCouponBtn"))))
				.click();
		Thread.sleep(5000);
		// close chip
		driver.findElement(By.cssSelector("i.material-icons.close.sale_discount_det_close")).click();
		Thread.sleep(3000);
		// applying the discount percentage
		driver.findElement(By.cssSelector("input#promo_amnt")).sendKeys("5");
		Thread.sleep(1000);
		// apply btn click
		driver.findElement(By.cssSelector("span#applyCouponModal")).click();
		Thread.sleep(2000);
		// adding comment
		driver.findElement(By.cssSelector("textarea#comments")).sendKeys("applied 5 percentage discount");
		Thread.sleep(2000);
		// submit btn click
		WebDriverWait submit1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		submit1.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#applyCouponBtn"))))
				.click();
		Thread.sleep(5000);
		Robot pgdwn13 = new Robot();
		pgdwn13.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// pay later
		WebElement paylater = driver.findElement(By.xpath("(//label[text()='Pay Later'])[1]"));
		paylater.click();
		Thread.sleep(3000);
		// submit
		driver.findElement(By.cssSelector("a#bookLater")).click();
		Thread.sleep(3000);
		// mouse-hover on invoice - print invoice
		Actions invoice = new Actions(driver);
		invoice.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		invoice.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		Robot robot3 = new Robot();
		robot3.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
//		// discount mouse hover
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-info-circle tooltipped'])[1]"))).build()
//				.perform();
//		Thread.sleep(1000);
		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(1000);
		// clicking on the print without details
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(1000);
		// clicking on the pay balance
		driver.findElement(By.xpath("(//a[text()='Pay Balance'])[1]")).click();
		Thread.sleep(5000);
		Robot pgdwn14 = new Robot();
		pgdwn14.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		// clicking on the cash btn
		WebElement cash = driver.findElement(By.xpath("//label[text()='Cash']"));
		cash.click();
		Thread.sleep(2000);
		// entering the amount
		driver.findElement(By.id("advance_field")).sendKeys("5");
		Thread.sleep(2000);
		// clicking on the comment
		driver.findElement(By.id("paymentComment")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// comment
		driver.findElement(By.id("payment_cmnt"))
				.sendKeys("5 rupees discount amount applied & 5 rupees amount paid through cash");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// submit
		driver.findElement(By.xpath("(//a[text()='Ok'])[2]")).click();
		Thread.sleep(1000);

		// submit
		driver.findElement(By.cssSelector("button#bookNowBtn")).click();
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
		// mouse-hover on invoice - print invoice
		Actions invoice1 = new Actions(driver);
		invoice1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		invoice1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
//		// discount mouse hover
//		Actions action1 = new Actions(driver);
//		action1.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-info-circle tooltipped'])[1]"))).build()
//				.perform();
//		Thread.sleep(1000);

		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(1000);
		// clicking on the print without details
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(1000);
		// share invoice
		driver.findElement(By.xpath("(//a[@class='btn green right btn-loader2 service_wise_pdf'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='phone'])[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='emails'])[1]")).sendKeys("sunil.kommayella@nanohealth.in");
		Thread.sleep(3000);
		// submit
		driver.findElement(By.xpath("(//div[@id='modal1'])[1]/div[1]/div[2]/form[1]/div[2]/input[1]")).click();
		Thread.sleep(8000);
		// clicking on the manage orders
		WebElement mo = driver.findElement(By.xpath("(//a[text()='Manage Orders'])[2]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", mo);
		Thread.sleep(5000);
		// clikcing on the delivered status
		WebElement d = driver.findElement(By.xpath("(//a[text()='Delivered'])[1]"));
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("arguments[0].click();", d);
		Thread.sleep(8000);

//		WebDriverWait delivery = new WebDriverWait(driver, Duration.ofSeconds(30));
//		delivery.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Delivered'])[1]"))))
//				.click();
//		Thread.sleep(8000);

		// from-date
		driver.findElement(By.cssSelector("input#q_order_date_gteq")).click();
		Thread.sleep(1000);
		// today date
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// to-date
		driver.findElement(By.cssSelector("input#q_order_date_lteq")).click();
		Thread.sleep(1000);
		// today date
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// search
		WebDriverWait search1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		search1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@value='Search'])[1]"))))
				.click();
//				driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(5000);
		// clicking on the order id
		WebDriverWait orderid = new WebDriverWait(driver, Duration.ofSeconds(30));
		orderid.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]"))))
				.click();
		Thread.sleep(3000);
		// clicking on the complete button
		WebDriverWait complete = new WebDriverWait(driver, Duration.ofSeconds(30));
		complete.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Complete'])[1]"))))
				.click();
		Thread.sleep(3000);
		// clicking on the manage orders
		WebDriverWait mo1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		mo1.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a#pharmacist_orders_list"))))
				.click();
		Thread.sleep(5000);
		// clicking on the completed status
		WebDriverWait completed = new WebDriverWait(driver, Duration.ofSeconds(30));
		completed.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Completed'])[1]"))))
				.click();
		Thread.sleep(5000);

		// clicking on the patient name
		driver.findElement(By.xpath("(//a[text()='Demo Createorder'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the all orders
		driver.findElement(By.xpath("(//a[text()='All Orders'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the download button
		Actions pdf = new Actions(driver);
		pdf.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/img[1]"))).build().perform();
		Thread.sleep(1000);
		pdf.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/img[1]"))).click().build()
				.perform();
		Thread.sleep(3000);
		// clicking on the order id
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(3000);
		// clicking on the all orders
		driver.findElement(By.xpath("(//a[text()='All Orders'])[1]")).click();
		Thread.sleep(3000);
		// clicking on the invoice id
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(3000);
		// mouse-hover on invoice - print invoice
		// Actions invoice1 = new Actions(driver);
		invoice1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).build()
				.perform();
		Thread.sleep(1000);
		invoice1.moveToElement(driver.findElement(By.xpath("(//a[@data-tooltip='Print Invoice'])[1]/img[1]"))).click()
				.build().perform();
		Thread.sleep(2000);
		// Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// discount mouse hover
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-info-circle tooltipped'])[1]"))).build()
				.perform();
		Thread.sleep(1000);

		// clicking on the print
		driver.findElement(By.cssSelector("a.btn.green.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(1000);
		// clicking on the print without details
		driver.findElement(By.cssSelector("a.btn.btn_blue.right.tooltipped.service_wise_pdf")).click();
		Thread.sleep(1000);

	}

	@BeforeClass
	public void Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver139.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
//		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
//		driver.findElement(By.name("commit")).click();
//		Thread.sleep(1000);
//		// selecting the NanoHealth CDP
//		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
//		Thread.sleep(3000);
//		// selecting Role clicking on CDPAdmin Role
//		driver.findElement(By.xpath("(//div[normalize-space(text())='CDPAdmin'])[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("frst_nm")).sendKeys("Democreateorder");
//		Thread.sleep(5000);
//		// clicking on the patient name
//		driver.findElement(By.cssSelector("div.col.s7.btn-loader.opt_search")).click();
//		Thread.sleep(3000);
//		// clicking on the view profile
//
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
//		Thread.sleep(8000);
////		// signing out
////		driver.findElement(By.xpath("(//div[@class='profile-img'])[1]/img")).click();
////		Thread.sleep(1000);
////		driver.findElement(By.xpath("(//i[@class='fa fa-sign-out'])[1]")).click();
////		Thread.sleep(3000);
////
////		driver.get("https://customer.nanohealthplan.com/users/sign_in");
////		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
////		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
////		driver.findElement(By.name("commit")).click();
////		Thread.sleep(3000);
//
//		// brand logo click
//		driver.findElement(By.xpath("(//a[@class='brand-logo'])[1]")).click();
//		Thread.sleep(3000);
		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		// selecting Role clicking on pharmacy
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();

//		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Central Pharmacy'])[1]")).click();
		Thread.sleep(3000);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
