package Classes;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.sikuli.script.*;
import org.testng.Assert;


public class HomePage {
	
	private String titleHP = "І.UA - моя пошта ";
		
	public void homePageIsOpened(WebDriver driver) throws FindFailed{
		Assert.assertEquals(driver.getTitle().replace("\u00a0", " "), titleHP);
	}
		
	public void openEmailBox(WebDriver driver) {
		driver.findElement(By.xpath("html/body/div[3]/div[3]/div[3]/div[2]/div[2]/div[3]/ul/li[1]/a")).click();
	}
	
	
}
