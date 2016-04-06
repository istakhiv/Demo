package Classes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class MailBox {
	
	private String titleMB = "Вхідні - I.UA ";
	private String filteredWord = "Demo";
	
	
	public void mailBoxIsOpened(WebDriver driver){
		Assert.assertEquals(driver.getTitle().replace("\u00a0", " "), titleMB);	
	}
	

	public void filterByDemo(WebDriver driver){
		driver.findElement(By.xpath(".//*[@id='fieldset1']/fieldset[1]/form/span[1]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='fieldset1']/fieldset[1]/form/span[1]/input")).sendKeys(filteredWord);
		driver.findElement(By.xpath(".//*[@id='fieldset1']/fieldset[1]/form/span[2]/i")).click();
	}
	
	public void openEmail(WebDriver driver){
		driver.findElement(By.xpath(".//*[@id='mesgList']/form/div[1]/a/span[3]/span")).click();
	}
	
	
	
}
