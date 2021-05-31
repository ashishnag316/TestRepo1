package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPWDPage {

	WebDriver driver;
	//constructor
	public ForgotPWDPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By emailID = By.id("user_email");

	private By resetLink = By.xpath("//input[@name='commit']");
	
	public WebElement emailID()
	{
		return driver.findElement(emailID);
	}
	
	
	
	public WebElement resetLink()
	{
		return driver.findElement(resetLink);
	}
	
	
}
