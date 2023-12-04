package demowebshop_testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import demowebshop_basetest.BaseClass;
import demowebshop_pageobjects.Homepage;
import demowebshop_pageobjects.LoginPage;
import demowebshop_pageobjects.LogoutPage;

public class TC_02_LoginTest extends BaseClass{
@Test(groups= {"sanity","master"})
	public void login_test() {
		
		logger.info("login test");
		Homepage hp=new Homepage(driver);
		logger.info("click on login");
		hp.clickLogin();
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(rb.getString("emailid"));
		lp.enterPassword(rb.getString("passwordid"));
		lp.clickLogn();
		LogoutPage lop=new LogoutPage(driver);
		boolean emailstatus=lop.emailExists();
		Assert.assertEquals(emailstatus, true);
		logger.info("login test is finshed");
	}
}
