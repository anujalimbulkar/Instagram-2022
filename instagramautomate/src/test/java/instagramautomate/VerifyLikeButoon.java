package instagramautomate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.Homepage;
import pages.LogOut;
import pages.Logininsta;
import utils.Utility;

public class VerifyLikeButoon {
	
	
	private WebDriver driver;
	private Homepage homepage;
	private Logininsta logininsta;
	private LogOut logout;
	private SoftAssert soft;
	int testId ;
	
	@Parameters("browser")
	
	@BeforeTest
	public void launchtheBrowser(String browserName){
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADVIKA\\OneDrive\\Documents\\automations\\selenium\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
		}
		
		if(browserName.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ADVIKA\\OneDrive\\Documents\\automations\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}
          
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);    
	}
	@BeforeClass 
	public void beforeclass() throws InterruptedException {
		logininsta = new Logininsta(driver);
		homepage = new Homepage(driver);
		LogOut logout = new LogOut(driver);
	    
		
		
	}
	@BeforeMethod
	public void beforemrthod() throws InterruptedException, EncryptedDocumentException, IOException {
		  driver.get("https://www.instagram.com");
	       Thread.sleep(4000);
	       String info = Utility.getdatafromsheet("Data",0,2);
	       logininsta.clickonuserId(info);
	       Thread.sleep(3000);
	      
	       String info1 = Utility.getdatafromsheet("Data",1,2);
	       logininsta.clickonpassword(info1);
	       Thread.sleep(3000);
	       
	       logininsta.clickonLogin();
	       Thread.sleep(3000);
	       soft = new SoftAssert();
	       
	      
		
	}
	@Test 
	public void test1() throws InterruptedException {	
		testId = 002;
		homepage.clickonnotnow();
		Thread.sleep(3000);
		homepage.clickonlikebutton();
	       Thread.sleep(3000);
	        logout.clickonmoveon();
	       Thread.sleep(3000);
	       
	       logout.clickonlogout();
		
	}
	@AfterMethod
	public void aftermethod() {
		System.out.println("after method");
		
	}
	@AfterClass
	public void afterclass() {
		logininsta = null;
		homepage = null;
		logout = null;
		
	}
	@AfterTest
	public void aftertest() {
		System.out.println("After Test");
		driver.close();
		driver = null;
		System.gc();
	}

}


