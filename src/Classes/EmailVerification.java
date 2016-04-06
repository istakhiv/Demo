package Classes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class EmailVerification {
	
	private String titleEmail = "demo test - Вхідні - I.UA ";
	private WebElement emailContent;
	private String emailText;
	private boolean testResult;
	
	
	public void emailIsOpened(WebDriver driver){
		Assert.assertEquals(driver.getTitle().replace("\u00a0", " "), titleEmail);
	}

	public void textVerification(WebDriver driver){
		emailContent=driver.findElement(By.xpath("html/body/div[1]"));
		emailText=emailContent.getText();
		System.out.println("***************************************************");
		System.out.println(emailText);
		Assert.assertTrue(emailText.contains("// For demo test"));
	}
}
