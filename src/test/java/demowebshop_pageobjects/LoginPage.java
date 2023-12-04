package demowebshop_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Basepage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy (id="Email")
	WebElement emaillogin;
	@FindBy (id="Password")
	WebElement passwordlogin;
	@FindBy (xpath = "//div[@class='buttons']//input[@type='submit']")
	WebElement loginbutton;
	
	public void enterEmail(String email) {
		emaillogin.sendKeys(email);
		
	}
	public void enterPassword(String Password) {
		passwordlogin.sendKeys(Password);
	}
	public void clickLogn() {
		loginbutton.click();
	}
	
	
	
}
