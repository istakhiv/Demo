
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.melloware.jintellitype.Main;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Temp {
	
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver = new FirefoxDriver();
	
	@Test
	void verifyTitle(){
		
		 
		 
		
		
		driver.get("http://learn-automation.com");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("Selenium"));
		}

	@AfterMethod
	public void tearDown(ITestResult result){
		if (result.getStatus()==ITestResult.FAILURE){
			
		}
		
		
	}
}
