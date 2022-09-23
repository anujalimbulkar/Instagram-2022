package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
	
	private WebDriver driver;
	@FindBy  (xpath = "(//div[@class='_acut'])[6]") 
	private WebElement movetolog;
	
	

		
 	@FindBy  (xpath = "//div[text()='Log Out']") 
	private WebElement returntoLogOut;
//	
//	@FindBy  (xpath = "//button[@class='sqdOP  L3NKy   y3zKF     ']") 
//	private WebElement login;
	
	public LogOut(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickonmoveon() {
		movetolog.click();
	}
	public void clickonlogout() {
		Actions act = new Actions(driver);
		returntoLogOut.click();
	}
	
}
