package demowebshop_testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import demowebshop_basetest.BaseClass;
import demowebshop_pageobjects.AccountRegistration;
import demowebshop_pageobjects.Homepage;

public class AccountRegistrationTest extends BaseClass {

	
	@Test(groups= {"master","regression"})
	public void test_accountregistration() {
		logger.debug("Application logs");
		logger.info("*** AccountRegistrationTest***");
		Homepage hpage=new Homepage(driver);
		
		hpage.clickRegister();
		logger.info("registration button clicked");
		AccountRegistration registration=new AccountRegistration(driver);
		
		logger.info("enter testdata ");
		registration.clickRadio();
		registration.setFirstname(randomString().toUpperCase());
		registration.setLastname("ram");
		registration.setEmail(randomString()+"@gmail.com");
		String password=randomAlphanumeric();
		registration.setPassword(password);
		registration.setConfirmpassword(password);
		registration.clickbutton();
		
		
		String msg =registration.getcnfmsg();
		logger.info("success");
		Assert.assertEquals(msg, "Your registration completed");
	}
}
