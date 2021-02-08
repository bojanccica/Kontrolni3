package objekti;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SortirajProizvode {
 public static final String URL_SORTIRANJE = "https://www.saucedemo.com/inventory.html";
 public static WebDriver driver;
 
 public static void stranaSortiraj(WebDriver driver) {
	 driver.navigate().to(URL_SORTIRANJE);
 }
 public static void listaSortiranja(WebDriver driver) {
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/select")).click();
 }
 public static void odNajnizeKaNajvisoj(WebDriver driver) {
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 List<WebElement> artikli = (List<WebElement>) driver.findElement(By.cssSelector("div#inventory_container > div > div:nth-child(1)"));
		 for(WebElement art:artikli) {
			 art.click();
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
 }
