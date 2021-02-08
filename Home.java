package objekti;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class Home {
		public static final String URL = "https://www.saucedemo.com/";
		public static final String USERNAME = "/html/body/div[2]/div[1]/div/div/form/input[1]";
		public static final String PASSWORD = "//*[@id=\"password\"]";
		public static final String BTN = "/html/body/div[2]/div[1]/div/div/form/input[3]";

		public static void idiNa(WebDriver driver) {
			driver.navigate().to(URL);
		}

		public static void nevalidno(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			WebElement username = driver.findElement(By.xpath(USERNAME));
			username.sendKeys(ispisiKredencijala(0,0));
			WebElement pass = driver.findElement(By.xpath(PASSWORD));
			pass.sendKeys(ispisiKredencijala(0,1));
		}

		public static void validno(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			WebElement username = driver.findElement(By.xpath(USERNAME));
			username.click();
			username.sendKeys(ispisiKredencijala(1,0));
			WebElement pass = driver.findElement(By.xpath(PASSWORD));
			pass.click();
			pass.sendKeys(ispisiKredencijala(1,1));
		}

		public static void pressBtn(WebDriver driver) {
			WebElement we = driver.findElement(By.xpath(BTN));
			we.click();
		}

		public static String ispisiKredencijala(int red, int kolona) {
			File f = new File("data.xlsx");
			InputStream inp=null;
			try {
				inp = new FileInputStream(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			XSSFWorkbook wb=null;
			try {
				wb = new XSSFWorkbook(inp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Sheet sheet1 = wb.getSheetAt(0);
			Row row = sheet1.getRow(red);
			Cell cell = row.getCell(kolona);
			String kredencijal = cell.getStringCellValue();
			
			return kredencijal.toString();
		}

	}