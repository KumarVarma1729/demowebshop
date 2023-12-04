package demowebshop_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage{

	public Homepage(WebDriver driver) {
		super(driver);
	}
	@FindBy(className ="ico-register")
	WebElement register;
	@FindBy (className="ico-login")
	WebElement login;
	
	public void clickRegister() {
		register.click();
	}
	public void clickLogin() {
		login.click();
	}
	
}
