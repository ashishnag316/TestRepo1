package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	//constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By emailID = By.id("user_email");
	private By password = By.id("user_password");
	private By login = By.xpath("//input[@name='commit']");
	private By fgtPWD = By.xpath("//a[@class='link-below-button']");
	
	public WebElement emailID()
	{
		return driver.findElement(emailID);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement login()
	{
		return driver.findElement(login);
	}
	
	public ForgotPWDPage fgtPWD()
	{
		driver.findElement(fgtPWD).click();
		ForgotPWDPage fp = new ForgotPWDPage(driver);
		return fp;
	}
	
}
