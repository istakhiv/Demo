import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Classes.Browser;
import Classes.EmailVerification;
import Classes.HomePage;
import Classes.LogInPage;
import Classes.MailBox;
import library.Retry;
import library.Utility;

import org.sikuli.script.*;

public class Tests {

	ExtentReports report = new ExtentReports("C:\\Practice\\Report\\TestReport.html");
	ExtentTest logger;

	WebDriver driver = Browser.getInstance(browser);
	public static String browser = "chrome";
	public String name = "huan.pedro";
	public String pass = "qawsed1234";

	@AfterMethod
	public void failureCatch(ITestResult result){
		if (result.getStatus()==ITestResult.FAILURE || result.getStatus()==ITestResult.SKIP){
			String screenhot_path=Utility.captureScreenshot(driver, result.getName());
			String image=logger.addScreenCapture(screenhot_path);
			logger.log(LogStatus.FAIL, result.getName()+" - FAILED ", image);
		}
		report.endTest(logger);
	}
	
	@AfterClass
	public void endReport() {
		report.flush();
//		driver.get("C:\\Practice\\Report\\TestReport.html");
	}

//	@Test(retryAnalyzer = Retry.class)
	public void emptyPass() throws FindFailed {
		String id ="TC-1: ";
		String summary="Negative test with empty Pass field";
		logger = report.startTest(id+summary);
		LogInPage logInPage = new LogInPage();
		logInPage.openLoginPage(driver);
		logger.log(LogStatus.INFO, "LogIn page is opened");

		logInPage.typeName(driver, name);
		logger.log(LogStatus.INFO, "Name is typed");

		logInPage.clickLogin(driver);
		logger.log(LogStatus.INFO, "Click LogIn button");
		if(browser=="firefox"){
			Screen s = new Screen();
			s.find("imgs/logIn/emptyPass.png");
		}
		
		logger.log(LogStatus.PASS, "Notification about empty password field is displayed");
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

//	@Test(retryAnalyzer = Retry.class)
	public void emptyEmail() throws FindFailed {
		String id ="TC-2: ";
		String summary="Negative test with empty Email field";
		logger = report.startTest(id+summary);
		LogInPage logInPage = new LogInPage();
		logInPage.openLoginPage(driver);
		logger.log(LogStatus.INFO, "LogIn page is opened");
		
		logInPage.typePass(driver, pass);
		logger.log(LogStatus.INFO, "Pass is typed");
		
		logInPage.clickLogin(driver);
		logger.log(LogStatus.INFO, "Click LogIn button");

		if(browser=="firefox"){
			Screen s = new Screen();
			s.find("imgs/logIn/emptyEmail.png");
		}
		
		logger.log(LogStatus.PASS, "Notification about empty Email field is displayed");
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

//	@Test(retryAnalyzer = Retry.class)
	public void successLogIn() throws FindFailed {
		String id ="TC-3: ";
		String summary="Successful LogIn";
		logger = report.startTest(id+summary);
		LogInPage logInPage = new LogInPage();
		logInPage.openLoginPage(driver);
		logInPage.typeName(driver, name);
		logger.log(LogStatus.INFO, "Name is typed");
		
		logInPage.typePass(driver, pass);
		logger.log(LogStatus.INFO, "Pass is typed");
		logInPage.clickLogin(driver);

		HomePage hp = new HomePage();
		hp.homePageIsOpened(driver);
		logger.log(LogStatus.PASS, "User is successfully logged in and home page is opened");
	}
	
	@Test //(retryAnalyzer = Retry.class)
	public void findEmail() throws FindFailed  {
		String id ="TC-4: ";
		String summary="Find Email";
		logger = report.startTest(id+summary);
		
		LogInPage logInPage = new LogInPage();
		logInPage.openLoginPage(driver);
		logInPage.typeName(driver, name);
		logger.log(LogStatus.INFO, "Name is typed");
		
		logInPage.typePass(driver, pass);
		logger.log(LogStatus.INFO, "Pass is typed");
		logInPage.clickLogin(driver);

		HomePage hp = new HomePage();
		hp.homePageIsOpened(driver);
		logger.log(LogStatus.INFO, "User is successfully logged in and home page is opened");
		
		hp.openEmailBox(driver);
		
		MailBox mb = new MailBox();
		mb.mailBoxIsOpened(driver);
		logger.log(LogStatus.INFO, "MailBox is opened");
		
		mb.filterByDemo(driver);
		logger.log(LogStatus.INFO, "Specificemail was found by *demo* word");
		
		mb.openEmail(driver);
		EmailVerification em= new EmailVerification();
		em.emailIsOpened(driver);
		logger.log(LogStatus.INFO, "Email is opened");
		
		em.textVerification(driver);
		logger.log(LogStatus.PASS, "Email contains appropriate text");
	}
	


}
