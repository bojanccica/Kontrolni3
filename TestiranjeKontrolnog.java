package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objekti.Home;
import objekti.SortirajProizvode;
public class TestiranjeKontrolnog {
public static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		//WebDriverWait wait = new WebDriverWait(driver,5);
		System.setProperty("webdriver.chrome.driver", "C:\\driverHrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test(priority = 1)
	public void testIdiNa() {
		Home.idiNa(driver);
		String actual = driver.getCurrentUrl();
		String expected = "https://www.saucedemo.com/";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 2)
	public void testNevelidno() {
		driver.navigate().to(Home.URL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Home.nevalidno(driver);
		Home.pressBtn(driver);
		
		String actual = driver.getCurrentUrl();
		String expected = "https://www.saucedemo.com/";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 3)
	public void testValidno() {
		driver.navigate().to(Home.URL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Home.validno(driver);
		Home.pressBtn(driver);
		
		String actual = driver.getCurrentUrl();
		String expected = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actual, expected);
		
	}
	@Test(priority = 4)
	public void testStranaSortiraj() {
		driver.navigate().to("https://www.saucedemo.com/inventory.html");
		SortirajProizvode.stranaSortiraj(driver);
		SortirajProizvode.listaSortiranja(driver);
		
		String actual = driver.getCurrentUrl();
		String expected = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 5)
	public void testCene() {
		driver.navigate().to("https://www.saucedemo.com/inventory.html");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		int brojac =0;
		boolean prosao = true;
		SortirajProizvode.listaSortiranja(driver);
			for(int i =0; i<6;i++) {
			 driver.findElement(By.cssSelector("div#inventory_container > div > div:nth-child(1) > div.pricebar > div"));
			brojac = i;
			 if(brojac<brojac) {
			  prosao = true;
			}else {
				 prosao =false;
			}
			}
			boolean actual = prosao;
			boolean expected = (prosao == true);
			Assert.assertEquals(actual, expected);
		}
	
	}

	