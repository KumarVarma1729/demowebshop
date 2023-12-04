package demowebshop_testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import demowebshop_basetest.BaseClass;
import demowebshop_pageobjects.Homepage;
import demowebshop_pageobjects.LoginPage;
import demowebshop_pageobjects.LogoutPage;
import demowebshop_utilities.DataProviders;

public class TC_03_LoginDDT  extends BaseClass{

	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void LoginDDT(String email,String password,String exp) {
		logger.info("login ddt");
		Homepage hp=new Homepage(driver);
		hp.clickLogin();
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clickLogn();
		LogoutPage lop=new LogoutPage(driver);
		boolean targetpage=lop.emailExists();
		
		if (exp.equals("Valid")) {
			if(targetpage == true){
				LogoutPage lop1=new LogoutPage(driver);
				lop1.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertFalse(true);
			}
		}
		
		if(exp.equals("Invalid")) {
			if(targetpage  == true) {
				LogoutPage lop2=new LogoutPage(driver);
				lop2.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertFalse(true);
			}
		
		}
		logger.info("login ddt finished");
	}
}
