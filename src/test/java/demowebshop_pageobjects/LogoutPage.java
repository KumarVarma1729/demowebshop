package demowebshop_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends Basepage {

	public LogoutPage(WebDriver driver) {
		super(driver);
		
	}
	 @FindBy (xpath = "//a[contains(text(),'ramram321@gmail.com')]")
	 WebElement accountEmail;
	 @FindBy(className="ico-Logout")
	 WebElement logout;
	 
	 public boolean emailExists() {
		boolean status= accountEmail.isDisplayed();
		return status;
	 }
	 public void clickLogout() {
		 logout.click();
	 }

}
