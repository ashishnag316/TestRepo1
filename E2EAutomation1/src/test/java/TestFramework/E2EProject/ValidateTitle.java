package TestFramework.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateTitle extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	public LandingPage lp;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}
	
	@Test
	public void validateTitle() throws IOException
	{
		
		//click on loginBtn
		lp = new LandingPage(driver);
		String actual = lp.title().getText();
		log.info("Title is fetched");
		String expected = "FEATURED COURSES123";
		Assert.assertEquals(actual, expected);
		log.info("Title is compared & matched");
		//Assert.assertTrue(lp.navBar().isDisplayed());
		
	}
	
	@Test
	public void validateNavBar() throws IOException
	{
		//driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		//click on loginBtn
		lp = new LandingPage(driver);
		Assert.assertTrue(lp.navBar().isDisplayed());
		log.info("Navigation bar is found");
	}
	

	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	
}
