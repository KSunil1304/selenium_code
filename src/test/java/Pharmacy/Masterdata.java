package Pharmacy;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Masterdata {
	WebDriver driver;

	@Test(priority = 0)

	public void brandmasters() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacy-masterData"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("pharmacist_brand_masters_link"))).click().build().perform();
		// driver.findElement(By.linkText("BrandMasters")).click();
		driver.findElement(By.linkText("add")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//label[text()='Category'])[2]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//li[text()='Vaccine']")).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.xpath("(//label[text()='Form'])[2]/following-sibling::span[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//li[text()='Tablet'][1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#brand_master_brand_name")).sendKeys("Pharmacybrandmaster");
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
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#brand_master_brand_desc")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("input#brand_master_brand_desc")).sendKeys("Test salt name");
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("//input[@value='Save'][1]")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void medicinetype() throws Exception {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacy-masterData"))).click().build().perform();
		try {
			action.moveToElement(driver.findElement(By.id("medicine_type"))).click().build().perform();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// clicking on the add new vaccine +
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(1000);
		// entering the medicine name
		driver.findElement(By.cssSelector("input#medicine_type_master_medicine_type_name"))
				.sendKeys("Cucum medicinetype");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the start date
		driver.findElement(By.cssSelector("input#medicine_type_master_effctv_dt")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// 18
		driver.findElement(By.xpath("//button[text()='1']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// selecting the end date
		driver.findElement(By.cssSelector("input#medicine_type_master_trmntn_dt")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//div[@class='selects-container'])[2]/div[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// 2026
		driver.findElement(By.xpath("/html/body/ul[3]/li[14]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// apr 1
		driver.findElement(By.xpath("(//button[text()='1'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// sending the medicine image
		driver.findElement(By.cssSelector("input#icon_img_url"))
				.sendKeys("C:\\Users\\Lenovo\\Uploadfiles\\medicineone.jpg");
		Thread.sleep(1000);
		// clicking on the save button
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(3000);
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(2000);

		WebElement act = driver.findElement(By.xpath("(//label[text()='Is active'])[1]"));
		act.click();
		Thread.sleep(1000);

		// clicking on the save button
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(3000);
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(3000);

		for (int i = 0; i <= 1; i++) {
			WebElement act1 = driver.findElement(By.xpath("(//label[text()='Is active'])[1]"));
			act1.click();
			Thread.sleep(1000);
		}
		// clicking on the save button
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucum medicinetype'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void manufactures() throws Exception {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacy-masterData"))).click().build().perform();
		Thread.sleep(1000);
		try {
			action.moveToElement(driver.findElement(By.id("manufacturer_master"))).click().build().perform();
		} catch (Exception e) {
			// TODO: handle exception
		}

		// clicking on the add new manufacturer
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(1000);
		// entering the maunfacturer name
		driver.findElement(By.id("manufacturer_master_manufacturer_name")).sendKeys("Cucum maunfacturer");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// entering the description
		driver.findElement(By.id("manufacturer_master_desc")).sendKeys("demo description");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// clicking on the save button
		driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[2]/input[1]")).click();
		Thread.sleep(5000);
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("manufacturer_master_desc")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("manufacturer_master_desc")).sendKeys("demo desc.");
		Thread.sleep(1000);
		// clicking on the save button
		driver.findElement(By.xpath("/html/body/main/div/div[3]/div/div[2]/form/div[2]/input[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#q_manufacturer_name_cont")).sendKeys("Cucum");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Reset'])[1]")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void distributor() throws Exception {
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("pharmacy-masterData"))).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("distributor_master"))).click().build().perform();
		Thread.sleep(1000);
		// clicking on the add button
		driver.findElement(By.xpath("//i[text()='add']")).click();
		Thread.sleep(2000);
		// entering the distributor name
		driver.findElement(By.id("check_name")).sendKeys("Cucum distributor");
		Thread.sleep(1000);
		// entering the license code
		driver.findElement(By.id("check_code")).sendKeys("PH12345");
		Thread.sleep(1000);
		// sending logo,header,footer.
		driver.findElement(By.id("pharmacy_master_invoice_img_url"))
				.sendKeys("C:\\Users\\Lenovo\\Uploadfiles\\Androcare_header.png");
		Thread.sleep(1000);
		driver.findElement(By.id("pharmacy_master_header_img_url"))
				.sendKeys("C:\\Users\\Lenovo\\Uploadfiles\\Androcare_header.png");
		Thread.sleep(1000);
		driver.findElement(By.id("pharmacy_master_footer_img_url"))
				.sendKeys("C:\\Users\\Lenovo\\Uploadfiles\\Androcare_footer.png");
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		// address line 1
		driver.findElement(By.id("address_details_address_line1")).sendKeys("demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// address line 2
		driver.findElement(By.id("address_details_address_line2")).sendKeys("address");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// area
		driver.findElement(By.id("address_details_area")).sendKeys("demo area");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// landamrk
		driver.findElement(By.id("address_details_landmark")).sendKeys("demolandmark");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// city
		driver.findElement(By.xpath("(//label[text()='City'])[1]/preceding-sibling::span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Hyderabad'][1]")).click();
		Thread.sleep(1000);
		// pincode
		driver.findElement(By.id("address_details_pin_code")).sendKeys("500032");
		Thread.sleep(1000);
		// phonetype
		driver.findElement(By.id("contact_details_phn_nmbr_typ")).sendKeys("phone");
		Thread.sleep(1000);
		// country
		driver.findElement(By.xpath("(//span[@class='selection'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='+91']")).click();
		Thread.sleep(1000);
		// phonenumber
		driver.findElement(By.id("contact_details_nmbr")).sendKeys("7654334128");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// gmail
		driver.findElement(By.id("contact_details_email")).sendKeys("testdistribu1@gmail.com");
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("/html/body/main/div[2]/div/div[2]/form/fieldset[2]/div/input[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='selection'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Cucum distributor'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		Thread.sleep(3000);
		// edit
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(2000);
		// adding GST Number
		driver.findElement(By.cssSelector("input#pharmacy_master_gst_no")).sendKeys("27AAAAA1234A1Z5");
		Thread.sleep(2000);
		// save
		driver.findElement(By.xpath("/html/body/main/div[2]/div/div[2]/form/fieldset[2]/div/input[1]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void currentstock() throws Exception {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("current_stock"))).build().perform();
		Thread.sleep(5000);
		driver.close();
	}

	@BeforeClass
	public void login() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver139.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver.get("https://customer.nanohealthplan.com/users/sign_in");
		// driver.get("https://nhtestserver.ap-south-1.elasticbeanstalk.com/users/sign_in");

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
		driver.findElement(By.xpath("(//div[normalize-space(text())='Pharmacist - Test Pharmacy'])[1]")).click();
	}

	@AfterClass
	public void quit() {
		// driver.close();
	}

}
