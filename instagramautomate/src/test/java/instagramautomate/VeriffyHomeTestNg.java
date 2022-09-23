package instagramautomate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import setup.Base;
import utils.Utility;

public class VeriffyHomeTestNg extends Base {
	private WebDriver driver;
	private ChromeOptions options;
	private Homepage homepage;
	private Logininsta logininsta;
	private LogOut logout;
	private SoftAssert soft;
	private String testId ;
	
	@Parameters("browser")
	
	@BeforeTest
	public void launchbrowser(String browserName) throws InterruptedException {
		if(browserName.equals("Chrome"))
		{
		
		   driver =	openChromebrowser();
			
		}
		
		if(browserName.equals ("Edge"))
		{
	
			driver = openEdgebrowser();
			
		}
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}
	@BeforeClass  
	public void createPOMObjects()
	
	{
	
		 logininsta = new Logininsta(driver);
		 homepage = new Homepage(driver);
		 logout = new LogOut(driver);
	}
	     
	     
	 @BeforeMethod
	public void opentheLoginpage() throws InterruptedException, EncryptedDocumentException, IOException {
		 System.out.println("beforemethod");
		 driver.get("https://www.instagram.com");
		 Thread.sleep(6000);
	       
		   String info = Utility.getdatafromsheet("Data",1,0);
	       logininsta.clickonuserId(info);
	       Thread.sleep(5000);
	      
	       String info1 = Utility.getdatafromsheet("Data",1,1);
	       logininsta.clickonpassword(info1);
	       Thread.sleep(5000);
	       
	       logininsta.clickonLogin();
	       Thread.sleep(6000);
	       soft = new SoftAssert();
	       
	      
		
	}
	@Test 
	public void test1() throws InterruptedException, IOException {
		 testId = "insta001";
		 Thread.sleep(3000);

		
		 homepage.clickonnotnow();
		Thread.sleep(6000);
		
		homepage.clickonnotnow();
		Thread.sleep(6000);
		
		homepage.clickonsearch();
	       Thread.sleep(6000);
	       
	       homepage.clickonmydecor();
	       Thread.sleep(6000);
	       
	      
	       logout.clickonmoveon();
	       Thread.sleep(6000);
	       
	       logout.clickonlogout();
	       Thread.sleep(6000);
	       Assert.fail();
		
	}
	@AfterMethod
	public void aftermethod() throws IOException {
	System.out.println("after method");
	
	utils.Utility.Screenshot(driver, testId);
		
		
	}
	@AfterClass
	public void cleanPOMObjects() {
		logininsta = null;
		homepage = null;
		logout = null;
		
	}
	@AfterTest
	public void closetheBrowesr() {
		System.out.println("aftertest");
		driver.close();
		driver = null;
		System.gc(); //garbage collector
	}
	
		
	

}
