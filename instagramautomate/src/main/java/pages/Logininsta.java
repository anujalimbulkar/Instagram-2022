package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logininsta {

	private WebDriver driver;
	@FindBy  (xpath = "//input[@name='username']") 
	private WebElement userId;

		
 	@FindBy  (xpath = "//input[@aria-label='Password']") 
	private WebElement password;
	
	@FindBy  (xpath = "//button[@class='sqdOP  L3NKy   y3zKF     ']") 
	private WebElement login;
	
	//public constructor (to initialize the WebElement)
	public Logininsta (WebDriver driver){
	PageFactory.initElements(driver, this);
	}
	
	public void clickonuserId(String user) {
		userId.sendKeys(user);
	}
	
	public void clickonpassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickonLogin() {
		login.click();
		
	}

		// TODO Auto-generated method stub
		
	}

