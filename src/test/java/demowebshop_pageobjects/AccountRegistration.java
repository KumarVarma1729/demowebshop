package demowebshop_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends Basepage {
	
	
 public  AccountRegistration(WebDriver driver){
	  super(driver);
  }
  
 
  
	@FindBy(id = "FirstName")
	WebElement txt_firstname;
	
	@FindBy(id="LastName")
	WebElement txt_lastname;
	
	@FindBy(id="Email")
	WebElement txt_email;
	
	@FindBy(id="Password")
	WebElement txt_password;
	
	@FindBy(id="ConfirmPassword")
	WebElement txt_cnfpassword;
	
	@FindBy(id="gender-male")
	WebElement radio_male;
	
	
	@FindBy(id ="register-button")
	WebElement button_register;
	
	
	
	@FindBy(xpath = "//div[@class='page-body']//div[@class='result']")
	WebElement msgconfirm;
	
	
	public void clickRadio() {
		radio_male.click();
	}
	
	public void setFirstname(String fname) {
		txt_firstname.sendKeys(fname);
	}
	 public void setLastname(String lname) {
		 txt_lastname.sendKeys(lname);
	 }
  public void setEmail(String email) {
	  txt_email.sendKeys(email);
  }
  
  public void setPassword(String pwd) {
	  txt_password.sendKeys(pwd);
  }
  public void setConfirmpassword(String cnfpwd) {
	  txt_cnfpassword.sendKeys(cnfpwd);
  }
  public void clickbutton() {
	  button_register.click();
  }
  
  public String getcnfmsg() {
	  String confirmsg=msgconfirm.getText();
	  return  confirmsg;
  }
  
}
