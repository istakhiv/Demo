package Classes;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Browser {
	
	private static final String CHROME = "chrome"; 
    private static final String FIREFOX = "firefox";
    

    private static WebDriver driver;
    
    public static WebDriver getInstance(String browser){
    	
        
        if (driver == null){
            if (browser.equals("firefox")){
                driver = new FirefoxDriver();
            } else if (browser.equals("chrome")){
                System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
                driver = new ChromeDriver();
            } else{
                throw new UnsupportedOperationException("Unknown browser" + browser);
            }
            driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
        }
        
        return driver;
        }
    
  
    @BeforeClass
    public static void before(){
        getInstance(CHROME);
    }
    
    @Test
    public static void testMethod() throws InterruptedException{
        driver.get("https://www.google.com.ua/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    
    @AfterClass
    public static void after(){
        driver.close();
        driver.quit();
    }

    
    
    
    }
