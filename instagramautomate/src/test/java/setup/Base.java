package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {

	
	public static WebDriver openChromebrowser() {
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADVIKA\\OneDrive\\Documents\\automations\\selenium\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	return driver;
	}


public static WebDriver openEdgebrowser() {
	 System.setProperty("webdriver.edge.driver","C:\\Users\\ADVIKA\\OneDrive\\Documents\\automations\\selenium\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
}
}