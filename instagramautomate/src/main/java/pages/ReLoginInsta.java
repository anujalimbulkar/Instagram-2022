package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReLoginInsta {
	
	@FindBy  (xpath = "//input[@name='username']") 
	private WebElement userId;

		
 	@FindBy  (xpath = "//input[@aria-label='Password']") 
	private WebElement password;
	
	@FindBy  (xpath = "//button[@class='sqdOP  L3NKy   y3zKF     ']") 
	private WebElement login;
	
	public ReLoginInsta (WebDriver driver){
		PageFactory.initElements(driver, this);
		}
		
		public void clickonuserId() {
			userId.sendKeys("8983959167");
		}
		
		public void clickonpassword() {
			password.sendKeys("anujaD513@");
		}
		
		public void clickonLogin() {
			login.click();
			
		}
	}


