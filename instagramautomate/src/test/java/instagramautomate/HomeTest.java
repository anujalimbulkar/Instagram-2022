package instagramautomate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.Homepage;
import pages.Logininsta;
import utils.Utility;

public class HomeTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments(" --disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADVIKA\\OneDrive\\Documents\\automations\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		
	     WebDriver driver = new ChromeDriver(option);
	     Thread.sleep(3000);
	     driver.manage().window().maximize();
	     
	     
	     driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	       driver.get("https://www.instagram.com");
	       Thread.sleep(3000);
	       
	       Logininsta logininsta = new Logininsta(driver);
	      String info = Utility.getdatafromsheet("Data", 2, 0);
	       logininsta.clickonuserId(info);
	       Thread.sleep(3000);
		      
	       
	       String info1 = Utility.getdatafromsheet("Data", 2, 1);

	       logininsta.clickonpassword(info1);
	       Thread.sleep(3000);
	       
	       logininsta.clickonLogin();
	       Thread.sleep(3000);
	       
	       Homepage homepage = new Homepage(driver);
	       homepage.clickonnotnow();
	       Thread.sleep(3000);
	       
	       homepage.clickonlikebutton();
	       Thread.sleep(3000);
	       
	       homepage.clickonsearch();
	       Thread.sleep(3000);
	       
	       homepage.clickonmydecor();
	       Thread.sleep(3000);
	  
	       
	      

	}

}
