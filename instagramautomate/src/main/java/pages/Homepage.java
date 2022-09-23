package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	
	@FindBy  (xpath = "//button[text()='Not Now']") 
	private WebElement notnow;

		
 	@FindBy  (xpath = "//a[@aria-label='Direct messaging - 0 new notifications link']") 
	private WebElement message;
 	
 	@FindBy  (xpath = "//a[@class='_acuj _aa8k']")
 	private WebElement likebutton;
	
	@FindBy  (xpath = "(//div[@class='_abm0'])[10]") 
	private WebElement createapost;
	
	@FindBy (xpath = "//input[@aria-label='Search input']")
	private WebElement search;
	
	@FindBy  (xpath = "//div[text()='my_homely_decor']") 
    private WebElement mydecor;
	
	
	
	//public constructor (to initialize the WebElement)
	public Homepage (WebDriver driver){
	PageFactory.initElements(driver, this);
	}
	
	public void clickonnotnow() {
		notnow.click();
	}
	public void clickonlikebutton() {
		likebutton.click();
	}
	public void clickonsearch() {
//		search.click();
    	search.sendKeys("homedecor");
	}
	public void clickonmydecor() {
		mydecor.click();
	}
	
	public void clickonmessage() {
		message.click();
	}
	public void clickonCreateaPost() {
		createapost.click();
	}
}
