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

public class LogInPage {

	private String link = "https://passport.i.ua/login/";
	

	public void openLoginPage(WebDriver driver) throws FindFailed {
		driver.get(link);
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle().replace("\u00a0", " "), "Паспорт - I.UA ");
	}

	public void typeName(WebDriver driver, String name) {
		driver.findElement(By.xpath("html/body/div[1]/div[2]/form/fieldset/p[2]/input")).clear();
		driver.findElement(By.xpath("html/body/div[1]/div[2]/form/fieldset/p[2]/input")).sendKeys(name);
	}

	public void typePass(WebDriver driver, String pass) {
		driver.findElement(By.xpath("html/body/div[1]/div[2]/form/fieldset/p[4]/input")).clear();
		driver.findElement(By.xpath("html/body/div[1]/div[2]/form/fieldset/p[4]/input")).sendKeys(pass);
	}

	public void clickLogin(WebDriver driver) {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
}
