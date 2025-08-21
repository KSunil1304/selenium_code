package Pharmacy;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Inventory_TestNG {
	WebDriver driver;

	@Test(priority = 1)
	public void Request_To() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("/html/body/header/div[1]/nav/div/ul/li[3]/ul/li[3]/a")))
				.click().build().perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(1000);
		// selecting the request to
		driver.findElement(By.xpath("(//label[text()='Request to'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// entering the brand name
		driver.findElement(By.id("pharmacy_transfer_header_pharmacy_transfer_lines_attributes_0_brand_name"))
				.sendKeys("Sunil");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(), 'SUNIL BRAND')])[1]")).click();
		Thread.sleep(1000);
		// clicking on the submit
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(5000);
		// quantity
		driver.findElement(
				By.xpath("(//input[@id='pharmacy_transfer_header_pharmacy_transfer_lines_attributes_0_quantity'])[1]"))
				.sendKeys("100");
		Thread.sleep(1000);
		// clicking on the add
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(1000);
		// removing last added
		driver.findElement(By.xpath("(//a[@class='remove_fields dynamic'])[2]/i")).click();
		Thread.sleep(1000);
		// clicking on the submit
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		// from-date
		driver.findElement(By.cssSelector("input#q_transfer_dt_gteq")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// to-date
		driver.findElement(By.cssSelector("input#q_transfer_dt_lteq")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);

		// clicking on the Requestid
		driver.findElement(By.xpath("(//div[@id='search-results'])[1]/div/table/tbody/tr/td[2]/a")).click();
		Thread.sleep(1000);
		// closing
		driver.findElement(By.cssSelector("div#pharmapurchase-modal>div>div>span>i")).click();
		Thread.sleep(1000);

		// clicking on the Requestdate
		driver.findElement(By.xpath("(//div[@id='search-results'])[1]/div/table/tbody/tr/td[3]/a")).click();
		Thread.sleep(1000);
		// closing
		driver.findElement(By.cssSelector("div#pharmapurchase-modal>div>div>span>i")).click();
		Thread.sleep(1000);

//		// cancel
//		driver.findElement(By.xpath("(//input[@value='Cancel'])[1]")).click();
//		Thread.sleep(2000);
//
//		// clicking on the cancelled status
//		driver.findElement(By.xpath("(//a[text()='Cancelled'])[1]")).click();
//		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void Transfer_to() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("/html/body/header/div[1]/nav/div/ul/li[3]/ul/li[3]/a")))
				.click().build().perform();
		Thread.sleep(1000);

		// clicking on the transfer
		driver.findElement(By.xpath("(//a[text()='Transfer'])[1]")).click();
		Thread.sleep(2000);
		// clicking on the add button
		driver.findElement(By.xpath("(//i[text()='add'])[1]")).click();
		Thread.sleep(2000);
		// selecting the transfer to
		driver.findElement(By.xpath("(//span[@class='selection'])[2]")).click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		// entering the brand name
		driver.findElement(By.xpath("(//input[@class='medBrandName_transfer'])")).sendKeys("Sunil");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='btn green medicineAvail'])[1]/img")).click();
		Thread.sleep(2000);
		// batch selection-1234
		driver.findElement(By.xpath("(//div[@id='batch-list'])/ul/li[2]/div")).click();
		Thread.sleep(1000);
		// category
		driver.findElement(By.id("pharmacy_transfer_header_pharmacy_transfer_lines_attributes_0_category"))
				.sendKeys("Test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// quantity
		driver.findElement(By.id("pharmacy_transfer_header_pharmacy_transfer_lines_attributes_0_quantity"))
				.sendKeys("1");
		Thread.sleep(1000);
		Robot robot4 = new Robot();
		robot4.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		// clicking on the add
		driver.findElement(By.xpath("(//i[text()='add'])[2]")).click();
		Thread.sleep(1000);
		// removing last added
		driver.findElement(By.xpath("(//a[@class='remove_fields dynamic'])[2]/i")).click();
		Thread.sleep(1000);

		// submit
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
		Thread.sleep(3000);

		// click on the transfer
		driver.findElement(By.xpath("(//a[text()='Transfer'])[2]")).click();
		Thread.sleep(2000);
		// closing
		driver.findElement(By.cssSelector("div#pharmapurchase-modal>div>div>span>i")).click();
		Thread.sleep(2000);
		// clicking on the Requestid
		driver.findElement(By.xpath("(//div[@id='search-results'])[1]/div/table/tbody/tr/td[2]/a")).click();
		Thread.sleep(1000);
		// closing
		driver.findElement(By.cssSelector("div#pharmapurchase-modal>div>div>span>i")).click();
		Thread.sleep(1000);

		// clicking on the Transfer date
		driver.findElement(By.xpath("(//div[@id='search-results'])[1]/div/table/tbody/tr/td[3]/a")).click();
		Thread.sleep(1000);
		// closing
		driver.findElement(By.cssSelector("div#pharmapurchase-modal>div>div>span>i")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void Inventory_Details() throws Exception {
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).click().build().perform();
		Thread.sleep(1000);
		action1.moveToElement(driver.findElement(By.xpath("(//a[text()='Inventory Details'])[1]"))).click().build()
				.perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='BrandName'])[1]/following-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='SUNIL BRAND'])[1]")).click();
		Thread.sleep(1000);
		// search
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i")).click();
		Thread.sleep(3000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 0)
	public void Inventoryreceivedwithoutinvoice() throws Exception {
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.id("pharmacy-inventory"))).click().build().perform();
		Thread.sleep(1000);
		action1.moveToElement(driver.findElement(By.xpath("/html/body/header/div[1]/nav/div/ul/li[3]/ul/li[1]/a")))
				.click().build().perform();
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
		Robot esc = new Robot();
		esc.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		// searching for the brand
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_brand_name"))
				.sendKeys("Sunil");
		Thread.sleep(3000);
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_brand_name"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		// batch
		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_batch"))
				.sendKeys("123");
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
//		// hsn code
//		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_hsncode")).clear();
//		Thread.sleep(1000);
//		// hsn code
//		driver.findElement(By.id("pharmacy_purchase_header_pharmacy_purchase_lines_attributes_0_hsncode"))
//				.sendKeys("8790");
//		Thread.sleep(1000);
		// mouse hover
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("(//div[@class='hsncode-list'])/ul/li[1]/div"))).build()
//				.perform();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//div[@class='hsncode-list'])/ul/li[1]/div")).click();
//		Thread.sleep(1000);
		// save as draft
		driver.findElement(By.xpath("(//input[@id='btndraft'])[1]")).click();
		Thread.sleep(3000);
		// searching with the date filters
		driver.findElement(By.cssSelector("input#q_received_dt_gteq")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#q_received_dt_lteq")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(2000);
		// save
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(3000);
		// download
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[1]/i[1]")).click();
		Thread.sleep(2000);
		// download pdf
		// downloading pdf in actions
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[2]/img[1]")).click();
		Thread.sleep(3000);
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(2000);
		// add
		driver.findElement(By.xpath("(//i[text()='add'])[3]")).click();
		Thread.sleep(2000);
		// save
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='medBrandPurchase writeInput'])[2]")).sendKeys("W");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='medBrandPurchase writeInput'])[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		// batch
		driver.findElement(By.xpath("(//label[text()='Batch'])[2]/following-sibling::input[1]")).sendKeys("12345");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// expiry date
		driver.findElement(By.xpath("(//label[text()='ExpDate'])[2]/following-sibling::input[1]")).click();
		Thread.sleep(1000);
		Select sc1 = new Select(
				driver.findElement(By.xpath("(//select[@class='mtz-monthpicker mtz-monthpicker-year'])[2]")));
		sc1.selectByValue("2025");
		Thread.sleep(1000);
		// Apr
		driver.findElement(By.xpath("(//td[text()='Apr'])[2]")).click();
		Thread.sleep(1000);
		// pkt/strip qty
		driver.findElement(By.xpath("(//label[text()='Pck/Strip Qty'])[2]/following-sibling::input[1]")).sendKeys("1");
		Thread.sleep(1000);
		// pktcost
		driver.findElement(By.xpath("(//label[text()='PckCost'])[2]/following-sibling::input[1]")).sendKeys("100");
		Thread.sleep(1000);
		// tablet/pkt
		driver.findElement(By.xpath("(//label[text()='PckCost'])[2]/following-sibling::input[1]")).sendKeys(Keys.TAB);
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);

		driver.findElement(
				By.xpath("/html/body/main/div/div[5]/div/div[2]/form/div[2]/div[2]/div[1]/div[2]/div/div[7]/div/input"))
				.sendKeys(Keys.TAB);
		Thread.sleep(1000);

		// Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		robot.keyPress(KeyEvent.VK_0);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		robot.keyPress(KeyEvent.VK_0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='PckMRP'])[2]/following-sibling::input[1]")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='PckMRP'])[2]/following-sibling::input[1]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='PckMRP'])[2]/following-sibling::input[1]")).sendKeys("100");
		// free qty
		driver.findElement(By.xpath("(//label[text()='FreeQty'])[2]/following-sibling::input[1]")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//label[text()='FreeQty'])[2]/following-sibling::input[1]")).sendKeys("10");
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(5000);

		// searching with the date filters
		driver.findElement(By.cssSelector("input#q_received_dt_gteq")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#q_received_dt_lteq")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='is-today'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// downloading pdf in actions
		driver.findElement(By.xpath("(//a[@data-tooltip='Download'])[2]/img[1]")).click();
		Thread.sleep(3000);
		// clicking GR NO.
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[2]/a[1]")).click();
		Thread.sleep(3000);
		// edit
		driver.findElement(By.xpath("(//a[text()='edit'])")).click();
		Thread.sleep(3000);
		// closing popup
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-modal'])[1]/div/div[1]/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
		Thread.sleep(2000);

		// clicking Received Date
		driver.findElement(By.xpath("(//table[@id='example'])[1]/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='pharmapurchase-header-modal'])[1]/div/div[1]/span[1]")).click();
		Thread.sleep(2000);
		// reset
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);

	}

//	@BeforeClass
//	@Parameters("url")
//	public void setup(@Optional("https://customer.nanohealthplan.com/users/sign_in") String url) throws Exception {
//		driver = BrowserUtility.getInstance().launchBrowser(url);
//		driver.manage().window().maximize();
//		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
//		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
//		driver.findElement(By.name("commit")).click();
//		Thread.sleep(3000);
//
//		// selecting the NanoHealth CDP
//		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
//		Thread.sleep(3000);
//	}
	@BeforeClass
	public void Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver139.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user_login")).sendKeys("Sunilk@nh.com");
		driver.findElement(By.id("user_password")).sendKeys("Chakra@1");
		driver.findElement(By.name("commit")).click();
		Thread.sleep(3000);

		// selecting the NanoHealth CDP
		driver.findElement(By.xpath("(//a[text()='nanohealthplan'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
		Thread.sleep(3000);

	}

	@AfterClass
	public void afterClass() {
	}

};