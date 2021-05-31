package TestFramework.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPWDPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	@Test(dataProvider="getData")
	public void openBrowser(String userName, String password, String usrText) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		//click on loginBtn
		LandingPage lp = new LandingPage(driver);
		LoginPage lgn = lp.loginBtn();
		log.info("Login Button is clicked");
		//LoginPage lgn = new  LoginPage(driver);
		lgn.emailID().sendKeys(userName);
		log.info("EmailId is entered");
		lgn.password().sendKeys(password);
		log.info("Pwd is entered");
		System.out.println(usrText);
		log.info("Type of user is printed");
		lgn.login().click();
		log.info("login btn clicked");
		log.info("Login failed due to invalid credentials");
		log.info(usrText);
		ForgotPWDPage fp = lgn.fgtPWD();
		fp.emailID().sendKeys("asdasd");
		fp.resetLink().click();
		
	}
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		//rows = how many different data test should run
		//column = how many data values per test
		Object[][] data = new Object[2][3];
		//user1
		data[0][0] = "ashishnaggy@gmail.com";
		data[0][1] = "123456";
		data[0][2] = "Non restricted user";		
		//user2
		data[1][0] = "nonrestricteduser@qa.com";	
		data[1][1] = "543";		
		data[1][2] = "restricted user";		
		//data[0][0]
		//data[0][0]		
		return data;		
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
}
