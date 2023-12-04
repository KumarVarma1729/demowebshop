package demowebshop_basetest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
public static WebDriver driver;

public Logger logger;

public ResourceBundle rb;

@BeforeClass(groups= {"master","sanity","regression"})
@Parameters({"browser"})
	public void setUp(String browser) {
	
	rb=ResourceBundle.getBundle("config");
	
	logger=LogManager.getLogger(this.getClass());
	
	//ChromeOptions co=new ChromeOptions();
	//co.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
	if(browser.equals("chrome")) {
		
		driver=new ChromeDriver();
	}
	else if(browser.equals("edge")) {
		driver=new EdgeDriver();
	}
	else {
		driver=new FirefoxDriver();
	}
	driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appurl"));
		//driver.get("https://demowebshop.tricentis.com/");
	}
	@AfterClass(groups={"sanity","regression","master"})
	public void teardown() {
		driver.quit();
	}
	
	public String randomString() {
		String randomstring=RandomStringUtils.randomAlphabetic(5);
		return randomstring;
	}
	public String randomNumeric() {
		String randomnum=RandomStringUtils.randomNumeric(10);
	return randomnum;
	}
	public String randomAlphanumeric() {
	String randomalphanumeric=RandomStringUtils.randomAlphanumeric(6);
	return randomalphanumeric;
	}
	/*
	public String captureScreen(String tname) throws IOException {
		String timestamp=new SimpleDateFormat().format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
		try {
		FileUtils.copyFile(source, new File(destination));
		} 
	catch(Exception e) {
			e.getMessage();
		}
			return destination;
		}
		*/
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	}

